package com.vendas.gestavendas.controller.dto.product;

import com.vendas.gestavendas.controller.dto.category.CategoryResponseDTO;
import com.vendas.gestavendas.entity.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@ApiModel("Product return DTO")
@Data
@AllArgsConstructor
public class ProductResponseDTO {

    @ApiModelProperty(value = "Code")
    private UUID code;

    @ApiModelProperty(value = "Description")
    private String description;

    @ApiModelProperty(value = "Quantity")
    private Integer quantity;

    @ApiModelProperty(value = "Price Cost")
    private BigDecimal priceCost;

    @ApiModelProperty(value = "Price Sale")
    private BigDecimal priceSale;

    @ApiModelProperty(value = "Observation")
    private String observation;

    @ApiModelProperty(value = "Category")
    private CategoryResponseDTO categoryDto;

    public static ProductResponseDTO convert(Product product) {
        return new ProductResponseDTO(product.getCode(), product.getDescription(), product.getQuantity(),
                product.getPriceCost(), product.getPriceSale(), product.getObservation(), CategoryResponseDTO.convert(product.getCategory()));
    }
}
