package com.tretle.tech.OrderService.service;

import com.tretle.tech.OrderService.dto.InventoryResponse;
import com.tretle.tech.OrderService.dto.OrderLineItemsDto;
import com.tretle.tech.OrderService.dto.OrderRequest;
import com.tretle.tech.OrderService.event.OrderPlacedEvent;
import com.tretle.tech.OrderService.pojo.Order;
import com.tretle.tech.OrderService.pojo.OrderLineItems;
import com.tretle.tech.OrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;

    public void  placeOrder(OrderRequest orderRequest)
    {
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems=orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes=order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode).toList();

        InventoryResponse[] result=webClientBuilder.build().get()
        .uri("http://inventory-service/api/inventory",
                uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
        .retrieve()
        .bodyToMono(InventoryResponse[].class)
        .block();
        Arrays.stream(result).forEach(p->System.out.println(p.getSkuCode()+" "+p.isInStock()));
        boolean result1 =Arrays.stream(result)
                .allMatch(InventoryResponse::isInStock);
        if(result1)
        {
            orderRepository.save(order);
            kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
        }
        else {
            throw new IllegalArgumentException("Product is not in Stock, Please try again later...");
        }


    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
