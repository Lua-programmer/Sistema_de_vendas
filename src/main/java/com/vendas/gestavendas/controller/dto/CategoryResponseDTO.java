package com.vendas.gestavendas.controller.dto;

import com.vendas.gestavendas.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel("Category return DTO")
@AllArgsConstructor
public class CategoryResponseDTO {

    @ApiModelProperty(value = "Code")
    private UUID code;

    @ApiModelProperty(value = "Name")
    private String name;

    public static CategoryResponseDTO convert(Category category) {
        return new CategoryResponseDTO(category.getCode(), category.getName());
    }
}
