package repin.stock.socks.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class SockKey implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "color")
    @NonNull
    private Color color;
    
    @NonNull
    @Range(min = 0, max = 100)
    private Integer cottonPart;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SockKey)) return false;
        
        SockKey sockKey = (SockKey) o;
        
        if (!getColor().equals(sockKey.getColor())) return false;
        return getCottonPart().equals(sockKey.getCottonPart());
    }
    
    @Override
    public int hashCode() {
        int result = getColor().hashCode();
        result = 31 * result + getCottonPart().hashCode();
        return result;
    }
}
