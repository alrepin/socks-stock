package repin.stock.socks.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import repin.stock.socks.config.ValueOfEnum;
import repin.stock.socks.dto.GetRequestDTO;
import repin.stock.socks.dto.UpdateLeftoversDTO;
import repin.stock.socks.service.Service;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Validated
@RestController
@CrossOrigin(value = "${application.cors.origin}")
@RequestMapping("${ept.prod}")
@RequiredArgsConstructor
@Tag(name = "${controller.tag}")
public class Controller {
    private final Service service;
    
    @Value("${income.description}")
    private String incomeDescription;
    
    @Operation(summary = "${income.description}")
    @PostMapping(value = "/income", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> income(@Valid @RequestBody UpdateLeftoversDTO dto) {
//        try {
        dto.setIncrease(true);
        Boolean result = service.update(dto);
//                    ? ResponseEntity.ok().build() : ResponseEntity.;
        if (result) {
            return ResponseEntity.ok().build();
        }
        
/*        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }*/
        return null;
    }
    
    @Value("${outcome.description}")
    private String outcomeDescription;
    
    @Operation(summary = "${outcome.description}")
    @PostMapping(value = "/outcome", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> outcome(@Valid @RequestBody UpdateLeftoversDTO dto) {
//        try {
        dto.setIncrease(false);
        Boolean result = service.update(dto);
//                    ? ResponseEntity.ok().build() : ResponseEntity.;
        if (result) {
            return ResponseEntity.ok().build();
        }
        
/*        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }*/
        return null;
    }
    
    @Value("${get.description}")
    private String getDescription;
    
    @Operation(summary = "${get.description}")
    @GetMapping()
    public ResponseEntity<?> state(
            @RequestParam(value = "color", required = true) @NotBlank String color,
            @RequestParam(value = "cottonPart", required = true) @Min(0) @Max(100) Integer cottonPart,
            @RequestParam(value = "operation", required = true) @ValueOfEnum(enumClass = repin.stock.socks.dto.Operation.class) String operation
//            @RequestParam(value = "operation", required = false) @ValueOfEnum(enumClass = repin.stock.socks.dto.Operation.class, message = "{enum.in}") String operation
    
    ) {
        GetRequestDTO dto = new GetRequestDTO()
                .setColor(color)
                .setOperation(operation)
                .setCottonPart(cottonPart);

//        try {
//        Integer result = 50;
        Integer result = service.state(dto);
//                    ? ResponseEntity.ok().build() : ResponseEntity.;
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        
/*        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }*/
        return null;
    }
    
    
}