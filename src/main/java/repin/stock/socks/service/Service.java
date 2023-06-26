package repin.stock.socks.service;

import lombok.RequiredArgsConstructor;
import repin.stock.socks.dto.GetRequestDTO;
import repin.stock.socks.dto.Operation;
import repin.stock.socks.dto.UpdateLeftoversDTO;
import repin.stock.socks.model.Color;
import repin.stock.socks.model.Sock;
import repin.stock.socks.model.SockKey;
import repin.stock.socks.repository.ColorRepository;
import repin.stock.socks.repository.SockRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static repin.stock.socks.config.Constants.NOTHING_TO_REDUCE;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    
    private final SockRepository sockRepository;
    private final ColorRepository colorRepository;
    
    @Transactional
    public boolean update(UpdateLeftoversDTO dto) {
        
        Color color = colorRepository.findFirstByValue(dto.getColor())
                .orElseGet(() -> colorRepository.save(new Color(dto.getColor())));
        
        SockKey sockKey = new SockKey(color, dto.getCottonPart());
        
        Sock sock = sockRepository
                .findById(sockKey)
                .orElse(new Sock(sockKey, 0));
        
        Integer leftovers = sock.getQuantity();
        
        if (!dto.getIncrease() && (dto.getQuantity() > leftovers)) {
            throw new RuntimeException(NOTHING_TO_REDUCE);
        } else if (!dto.getIncrease() && (dto.getQuantity().equals(leftovers))) {
            sockRepository.delete(sock);
            sockRepository.findFirstBySockKey_Color(color)
                    .orElseGet(() -> {
                        colorRepository.delete(color);
                        return null;
                    });
            return true;
        }
        
        sock.setQuantity(dto.getIncrease() ? leftovers + dto.getQuantity() : leftovers - dto.getQuantity());
        
        sockRepository.save(sock);
        return true;
    }
    
    
    public Integer state(GetRequestDTO dto) {
/*        Color color = colorRepository.findFirstByValue(dto.getColor())
                .orElse(null);*/
        ArrayList<Sock> socksListByColor = sockRepository.getSocksBySockKey_Color_Value(dto.getColor());
        
        switch (Operation.getByName(dto.getOperation())) {
            case EQUAL:
                return socksListByColor.stream()
                        .filter(sock -> sock.getSockKey().getCottonPart().equals(dto.getCottonPart()))
                        .map(Sock::getQuantity)
                        .mapToInt(Integer::intValue)
                        .sum();
            case LESS_THAN:
                    return socksListByColor.stream()
                        .filter(sock -> sock.getSockKey().getCottonPart() < dto.getCottonPart())
                        .map(Sock::getQuantity)
                        .mapToInt(Integer::intValue)
                        .sum();
            case MORE_THAN:
                return socksListByColor.stream()
                        .filter(sock -> sock.getSockKey().getCottonPart() > (dto.getCottonPart()))
                        .map(Sock::getQuantity)
                        .mapToInt(Integer::intValue)
                        .sum();
        }
        return null;
    }
    
    

    
}
