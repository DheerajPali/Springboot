package dev.dheeraj.ProductServiceApr25.controller;

import dev.dheeraj.ProductServiceApr25.dto.FakeStoreProductDTO;
import dev.dheeraj.ProductServiceApr25.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private  ProductService productService;

    @GetMapping("/products")
    public FakeStoreProductDTO[] getAllProducts() {
        return  productService.getAllProductsFromFakeStore();
    }

    @GetMapping("/product/{id}")
    public FakeStoreProductDTO getProductById(@PathVariable("id") int id) {
        return  productService.getProductById(id);
    }

    @GetMapping("/products/category/{name}")
    public FakeStoreProductDTO[] getProductByCategory(@PathVariable("name") String name){
//        System.out.print("hello");
        return productService.getProductByCategory(name);

    }

    @PostMapping("/product")
    public FakeStoreProductDTO createProduct (@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        return productService.createProduct(fakeStoreProductDTO);
    }

    @PutMapping("/product/{id}")
    public FakeStoreProductDTO updateProduct (@PathVariable("id") int id, @RequestBody FakeStoreProductDTO updatedFakeStoreProductDTO ){
        return productService.updateProduct(id,updatedFakeStoreProductDTO);
    }


}
