package com.example.product.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class CategoryRequest {

    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    @JsonProperty("nameCategory")
    private String nameCategory;

    public CategoryRequest(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public CategoryRequest() {
    }
}
