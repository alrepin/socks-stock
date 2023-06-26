package repin.stock.socks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import repin.stock.socks.model.Color;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
    Optional<Color> findFirstByValue(String value);
    
}
