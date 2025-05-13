package dev.dheeraj.ProductServiceApr25.service;

import dev.dheeraj.ProductServiceApr25.client.FakeStoreClient;
import dev.dheeraj.ProductServiceApr25.dto.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductDTO[] getAllProductsFromFakeStore() {
          return fakeStoreClient.getAllProducts();
    }

    public FakeStoreProductDTO getProductById(int id){
        return  fakeStoreClient.getProductById(id);
    }

    public FakeStoreProductDTO[] getProductByCategory(String category){
        return fakeStoreClient.getProductByCategory(category);
    }

    public FakeStoreProductDTO createProduct(FakeStoreProductDTO product){
        return fakeStoreClient.createProduct(product);
    }

}

