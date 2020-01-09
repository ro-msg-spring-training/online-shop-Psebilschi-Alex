package ro.msg.learning.shop.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTOs.ProductDTO;
import ro.msg.learning.shop.Domain.Product;
import ro.msg.learning.shop.Domain.ProductCategory;
import ro.msg.learning.shop.Exceptions.ProductCategoryNotFoundException;
import ro.msg.learning.shop.Exceptions.ProductNotFoundException;
import ro.msg.learning.shop.Repository.ProductCategoryRepo;
import ro.msg.learning.shop.Repository.ProductRepo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductCategoryRepo categoryRepo;
    private final ProductRepo productRepo;

    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }

    public ProductDTO updateProduct(ProductDTO updatedInfo, Integer id) {
        Integer categoryId = updatedInfo.getCategory();
        ProductCategory category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ProductCategoryNotFoundException(categoryId));
        productRepo.findById(id)
                .map(prod -> {
                    prod.setCategory(category);
                    prod.setDescription(updatedInfo.getDescription());
                    prod.setImage_url(updatedInfo.getImage_url());
                    prod.setName(updatedInfo.getName());
                    prod.setPrice(updatedInfo.getPrice());
                    prod.setWeight(updatedInfo.getWeight());
                    return productRepo.save(prod);
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
        return updatedInfo.toBuilder()
                .id(id)
                .categoryDescription(category.getDescription())
                .categoryName(category.getName())
                .build();
    }

    public ProductDTO addNewProduct(ProductDTO newProduct) {
        Integer categoryId = newProduct.getCategory();
        ProductCategory category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ProductCategoryNotFoundException(categoryId));
        Product prod = productRepo.save(Product.builder()
                    .name(newProduct.getName())
                    .description(newProduct.getDescription())
                    .price(newProduct.getPrice())
                    .weight(newProduct.getWeight())
                    .image_url(newProduct.getImage_url())
                    .category(category)
                    .build()
        );

        return newProduct.toBuilder()
                .id(prod.getId())
                .categoryName(category.getName())
                .categoryDescription(category.getDescription())
                .build();
    }

    public ProductDTO getProductInfo(Integer id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductCategoryNotFoundException(id));
        ProductCategory category = categoryRepo.findById(product.getCategory().getId()).get();
        return ProductDTO.builder()
                .id(product.getId())
                .category(product.getCategory().getId())
                .name(product.getName())
                .description(product.getDescription())
                .image_url(product.getImage_url())
                .categoryName(category.getName())
                .categoryDescription(category.getDescription())
                .price(product.getPrice())
                .weight(product.getWeight())
                .build();
    }

    public List<ProductDTO> getAll() {
        List<ProductDTO> returnList = new ArrayList<>();
        List<Product> productList= productRepo.findAll();
        for (Product product : productList) {
            ProductCategory category = categoryRepo.findById(product.getCategory().getId()).get();
            returnList.add(ProductDTO.builder()
                    .id(product.getId())
                    .category(product.getCategory().getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .image_url(product.getImage_url())
                    .categoryName(category.getName())
                    .categoryDescription(category.getDescription())
                    .price(product.getPrice())
                    .weight(product.getWeight())
                    .build());
        }
        return returnList;
    }
}
