package com.vendas.gestavendas.controller.dto.product;

import com.vendas.gestavendas.entity.Category;
import com.vendas.gestavendas.entity.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@ApiModel("Product request DTO")
@Data
@AllArgsConstructor
public class ProductRequestDTO {

    @ApiModelProperty(value = "Description")
    @NotBlank(message = "Description")
    @Length(min = 3, max = 255, message = "Description")
    private String description;

    @ApiModelProperty(value = "Quantity")
    @NotNull(message = "Quantity")
    private Integer quantity;

    @ApiModelProperty(value = "Price Cost")
    @NotNull(message = "Price cost")
    private BigDecimal priceCost;

    @ApiModelProperty(value = "Price Sale")
    @NotNull(message = "Price sale")
    private BigDecimal priceSale;

    @ApiModelProperty(value = "Observation")
    @Length(max = 255, message = "Observation")
    private String observation;

    public Product convertForEntity(UUID categoryCode) {
        return new Product(description, quantity, priceCost, priceSale, observation, new Category(categoryCode));
    }

    public Product convertForEntity(UUID categoryCode, UUID productCode) {
        return new Product(productCode, description, quantity, priceCost, priceSale, observation, new Category(categoryCode));
    }
}
