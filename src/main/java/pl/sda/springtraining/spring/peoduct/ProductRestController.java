package pl.sda.springtraining.spring.peoduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController ///
@RequestMapping(value = "/api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/product")
  //  @ResponseBody // można użyć zamiast
    public String addProduct(@RequestBody ProductDTO productDTO) {
        Product newProduct = productService.createNewProduct(productDTO.getProductName(), productDTO.getStockAmount(), productDTO.getPrice());
        return newProduct.getId().toString();

    }
    @GetMapping(value = "/products")
    public List<ProductDTO> showProducts(){

        return productService.findProducts();
    }
}
