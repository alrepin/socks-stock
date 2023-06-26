package repin.stock.socks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateLeftoversDTO {
    //@NotBlank(message = "color must not be empty")
    @NotBlank
    private String color;
    
    @NotNull
    @Min(value = 0, message = "{NotNull.min}")
    @Max(value = 100, message = "{NotNull.max}")
    private Integer cottonPart;
    
    @Min(value = 1, message = "{NotNull.min}")
    private Integer quantity;
    
    @JsonIgnore
    private Boolean increase;
}
