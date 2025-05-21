package dev.dheeraj.ProductServiceApr25.client;

import dev.dheeraj.ProductServiceApr25.dto.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
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
        FakeStoreProductDTO response = requestForObject(getProductByIdURL,HttpMethod.GET,null, FakeStoreProductDTO.class);
        return response;
    }

    public FakeStoreProductDTO[] getProductByCategory(String category){
        String getProductByCategoryURL = "https://fakestoreapi.com/products/category/" + category;
        FakeStoreProductDTO[] response = requestForObject(getProductByCategoryURL,HttpMethod.GET,null,FakeStoreProductDTO[].class);
        return response;
    }

    public FakeStoreProductDTO createProduct(FakeStoreProductDTO product){
        String createProductURL = "https://fakestoreapi.com/products";
        FakeStoreProductDTO response = requestForObject(createProductURL,HttpMethod.POST,product, FakeStoreProductDTO.class, product);
        return  response;
    }

    public FakeStoreProductDTO updateProduct(int id, FakeStoreProductDTO updatedProduct){
        String updateProductURL = "https://fakestoreapi.com/products/"+id;
        FakeStoreProductDTO response = requestForObject(updateProductURL,HttpMethod.PUT,updatedProduct,FakeStoreProductDTO.class);
        return  response;
    }

    //Here I'm going to create my custom method from RestTemplate,
    // now I don't need to call multiple methods from restTemplate,
    // Just create a common method and call it in each call.

    private  <T> T requestForObject(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
        return (T)restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

}


