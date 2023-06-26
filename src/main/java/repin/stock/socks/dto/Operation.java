package repin.stock.socks.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Operation {
    MORE_THAN("moreThan"),
    LESS_THAN("lessThan"),
    EQUAL("equal");
    private final String name;
    
    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }
    
    public String toString() {
        return this.name;
    }
    
    public static Operation getByName(String otherName) {
        return Arrays.stream(Operation.values()).filter(v -> v.name.equals(otherName)).findAny().orElse(null);
    }
    
}
