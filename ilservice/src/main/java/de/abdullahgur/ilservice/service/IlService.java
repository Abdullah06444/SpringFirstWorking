package de.abdullahgur.ilservice.service;

import de.abdullahgur.ilservice.module.Il;
import de.abdullahgur.ilservice.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component // class injectiable olması icin
@Service // ya da kullanırız
@AllArgsConstructor
public class IlService {

    private final IlRepository ilRepository; // allargsconstructor

    public List<Il> getIller() {
        return ilRepository.findAll(); // bu metot ile repository verdik findAll metotu
        // sayesinde daha az satırla GetMapping yaptık
    }
}
