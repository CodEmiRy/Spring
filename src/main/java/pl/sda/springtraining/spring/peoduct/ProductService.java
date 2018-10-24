package pl.sda.springtraining.spring.peoduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductService {
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    private ProductToProductDTOBuilder productToProductDTOBuilder;
    private ProductDAO productDAO;
    public Product createNewProduct(String productName, Integer stockAmount, BigDecimal price) {
        Product product = new Product();
        product.setProductName(productName);
        product.setStockAmount(stockAmount);
        product.setPrice(price);
       return productDAO.saveProduct(product);
    }

    public List<ProductDTO> findProducts() {
       return productDAO.findProducts().stream()
               .map(p-> productToProductDTOBuilder.rewriteProductToProductDTO(p))
               .collect(Collectors.toList());
    }

    public Optional<Product> findProductById(Integer id) {
        return productDAO.findProductById(id);
    }

    public void updateProduct(Product product) {
        Product productById = productDAO.findProductById(product.getId()).get();
        productById.setProductName(product.getProductName());
        productById.setStockAmount(product.getStockAmount());
        productById.setPrice(product.getPrice());
        productDAO.saveProduct(productById);

    }
}
