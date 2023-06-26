package repin.stock.socks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import repin.stock.socks.model.Color;
import repin.stock.socks.model.Sock;
import repin.stock.socks.model.SockKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface SockRepository extends JpaRepository<Sock, SockKey> {
    @Override
    Optional<Sock> findById(SockKey sockKey);
    
    Optional<Sock> findFirstBySockKey_Color(Color color);
    
    ArrayList<Sock> getSocksBySockKey_Color_Value(String color);
    
/*
    @Query(value = "SELECT SUM(total_days) FROM MyEntity", nativeQuery = true)
    Integer sum();*/
    //countBySockKey_CottonPart(Integer cottonPart);
}
