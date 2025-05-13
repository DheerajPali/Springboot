package dev.dheeraj.ProductServiceApr25.client;

import dev.dheeraj.ProductServiceApr25.dto.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplate restTemplate;

    public FakeStoreProductDTO[] getAllProducts(){
        String getAllProductURL = "https://fakestoreapi.com/products";
        FakeStoreProductDTO[] response = restTemplate.getForObject(getAllProductURL, FakeStoreProductDTO[].class);
        return response;
    }

    public FakeStoreProductDTO getProductById(int id){
        String getProductByIdURL = "https://fakestoreapi.com/products/"+id;
        FakeStoreProductDTO response = restTemplate.getForObject(getProductByIdURL, FakeStoreProductDTO.class);
        return response;
    }

    public FakeStoreProductDTO[] getProductByCategory(String category){
        String getProductByCategoryURL = "https://fakestoreapi.com/products/category/" + category;
        FakeStoreProductDTO[] response = restTemplate.getForObject(getProductByCategoryURL,FakeStoreProductDTO[].class);
        return response;
    }

    public FakeStoreProductDTO createProduct(FakeStoreProductDTO product){
        String createProductURL = "https://fakestoreapi.com/products";
        FakeStoreProductDTO response = restTemplate.postForObject(createProductURL,product, FakeStoreProductDTO.class, product);
        return  response;
    }

}


