package de.abdullahgur.ilservice.controller;

import de.abdullahgur.ilservice.module.Il;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController // normal classta spring bootta otomatik kontrol olması için bu annotation ekliyoruz.
@RequestMapping("/iller") // kontrol hangi URL oluşabileceğini belirlemedir.
public class IlController {

    private final List<Il> iller;

    public IlController(){

        Il il1 = new Il("34","Istanbul");
        Il il2 = new Il("44","Malatya");
        Il il3 = new Il("51","Nigde");
        iller = Arrays.asList(il1, il2, il3);
    }

    @GetMapping
    //sadece yukarıdaki annotationlar ile birşey elde edilmez. Bunun için bir get metodu lazım.
    public ResponseEntity<List<Il>> getIller(){


        // HttpStatus.OK kodu kısa tutmak adına static tanımlıyoruz
        return new ResponseEntity<>(iller, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Il>getIl(@PathVariable String id){

        Il result = iller.stream()
                .filter(il -> il.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("bu il bulunamadı"));
        return new ResponseEntity<>(result, OK);

    /*  // standart yöntemde çağırma
        Il result = null;

        for (int i=0; i < iller.size(); i++){
            Il il = iller.get(i);
            if (il.getId().equals(Id))
                result = il;
        }

        if (result == null)
            throw new RuntimeException("Il not found");

     */
    }
}
