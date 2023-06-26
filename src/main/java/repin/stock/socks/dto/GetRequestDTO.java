package repin.stock.socks.dto;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;
import repin.stock.socks.config.ValueOfEnum;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Getter
@Accessors(chain = true)
public class GetRequestDTO {
    
    private String color;
    
//    @ValueOfEnum(enumClass = Operation.class)
    private String operation;
    
//    @Min(0)
//    @Max(100)
    private Integer cottonPart;
}
