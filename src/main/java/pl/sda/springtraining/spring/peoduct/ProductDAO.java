package pl.sda.springtraining.spring.peoduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductDAO {
    @Autowired
    private ProductRepository productRepository;


    public Product saveProduct(Product product) {
       return productRepository.save(product);
    }

    public List<Product> findProducts() {
      return productRepository.findAll(); // todo DTO
    }
    public Optional<Product> findProductById(Integer id) {
        return productRepository.findById(id);
    }


}
