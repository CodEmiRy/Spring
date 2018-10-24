package pl.sda.springtraining.spring.peoduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsControler {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public String showProduct(Model model) {
        model.addAttribute("productsList", productService.findProducts());
        return "products";

    }
}
