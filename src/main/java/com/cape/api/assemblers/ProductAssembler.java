package com.cape.api.assemblers;

import com.cape.api.dto.ProductTO;
import com.cape.dao.documents.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductAssembler {

    public ProductTO toResource( Product product ) {
        return new ProductTO(
              product.getId(),
              product.getName(),
              product.getDescription(),
              product.getImageUrl(),
              product.getLikes()
        );
    }
}
