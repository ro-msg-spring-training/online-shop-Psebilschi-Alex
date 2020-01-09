package ro.msg.learning.shop.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Domain.ProductCategory;
import ro.msg.learning.shop.Exceptions.ProductCategoryNotFoundException;
import ro.msg.learning.shop.Repository.ProductCategoryRepo;
import ro.msg.learning.shop.Service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryRepo repo;
    private final ProductService prodService;

    @GetMapping("/products/{id}")
    ProductDTO productDTO(@PathVariable Integer id) {
        return prodService.getProductInfo(id);
    }

    @GetMapping("/products")
    List<ProductDTO> all() {
        return prodService.getAll();
    }

    @PostMapping("/products")
    ProductDTO newProduct(@RequestBody ProductDTO newProduct) {
        return prodService.addNewProduct(newProduct);
    }

    @PutMapping("/products/{id}")
    ProductDTO updateProd(@RequestBody ProductDTO updatedProduct, @PathVariable Integer id) {
        return prodService.updateProduct(updatedProduct, id);
    }

    @DeleteMapping("/products/{id}")
    void deleteProductCategory(@PathVariable Integer id) {
        prodService.deleteProduct(id);
    }

}
