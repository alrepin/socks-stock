package repin.stock.socks.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Sock {
    @Column(unique = true)
    @EmbeddedId
    private SockKey sockKey;
    
    @NonNull
    private Integer quantity;
}
