package com.vendas.gestavendas.controller.dto.category;

import com.vendas.gestavendas.entity.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@ApiModel("Category request DTO")
@Data
public class CategoryRequestDTO {

    @ApiModelProperty(value = "Name")
    @NotBlank(message = "Name")
    @Length(min = 3, max = 50, message = "Name")
    private String name;

    public Category convertForEntity() {
        return new Category(name);
    }

    public Category convertForEntity(UUID code) {
        return new Category(code, name);
    }
}
