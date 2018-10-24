package pl.sda.springtraining.spring.peoduct;

import org.springframework.stereotype.Component;

@Component
public class ProductToProductDTOBuilder {

    public ProductDTO rewriteProductToProductDTO(Product product) {
        return (ProductDTO) rewriterFields(product, new ProductDTO());
    }
    public Product rewriteProductDTOToProduct(ProductDTO productDTO) {
        return (Product) rewriterFields(productDTO, new Product());
    }

    private ProductInfoHolder rewriterFields(ProductInfoHolder source, ProductInfoHolder target) {
        target.setId(source.getId());
        target.setProductName(source.getProductName());
        target.setStockAmount(source.getStockAmount());
        target.setPrice(source.getPrice());
        return target;
    }
}
