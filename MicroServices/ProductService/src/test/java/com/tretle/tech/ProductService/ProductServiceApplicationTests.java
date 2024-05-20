//package com.tretle.tech.ProductService;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tretle.tech.ProductService.dto.ProductRequest;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.testcontainers.containers.MongoDBContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import java.math.BigDecimal;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
//class ProductServiceApplicationTests {
//
//	@Container
//	static MongoDBContainer mongoDBContainer=new MongoDBContainer("mongo:4.4.2");
//
//    @DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistery){
//		dymDynamicPropertyRegistery.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
//	}
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@Test
//	void shouldCreateProduct() throws Exception {
//		ProductRequest productRequest = getProductRequest();
//		String productRequestString = objectMapper.writeValueAsString(productRequest);
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(productRequestString))
//				.andExpect(status().isCreated());
//
//	}
//	private ProductRequest getProductRequest(){
//			return ProductRequest.builder()
//					.name("Badam Pista")
//					.desc("Icecream")
//					.price(BigDecimal.valueOf(1343.34))
//					.build();
//	}
//}
