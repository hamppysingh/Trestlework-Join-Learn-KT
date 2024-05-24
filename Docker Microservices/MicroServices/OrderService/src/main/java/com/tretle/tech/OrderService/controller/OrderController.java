package com.tretle.tech.OrderService.controller;


import com.tretle.tech.OrderService.dto.OrderRequest;
import com.tretle.tech.OrderService.service.OrderService;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @CircuitBreaker(name="inventory",fallbackMethod = "fallbackMethod")
//    @TimeLimiter(name="invertory")
    public String paceOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully!";
    }
    public String fallbackMethod(OrderRequest orderRequest,RuntimeException runtimeException)
    {
        log.error(runtimeException.toString());
        return "Oops! Something went wrong, please order after some time!";
    }
}
