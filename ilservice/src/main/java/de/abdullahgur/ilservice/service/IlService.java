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

    public Il createIl(Il newIl) {
        // newIl.setCreateDate(new Date());
        return ilRepository.save(newIl);
    }

    public void updateIl(String id, Il newIl) {

        Il oldIl = getIlById(id);
        oldIl.setName(newIl.getName());
        ilRepository.save(oldIl);
    }

    public void deleteIl(String id) {
        ilRepository.deleteById(id);
    }

    public Il getIlById(String id) {

        return ilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("bu il bulunamadi"));
        /*Optional<Il> byId = ilRepository.findById(id);
        if (byId.isEmpty())
            throw new RuntimeException("bu il bulunamadi");
        return byId.get();*/
    }

}
