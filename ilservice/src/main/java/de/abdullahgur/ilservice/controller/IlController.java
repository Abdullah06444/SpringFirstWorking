package de.abdullahgur.ilservice.controller;

import de.abdullahgur.ilservice.module.Il;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController // normal classta spring bootta otomatik kontrol olması için bu annotation ekliyoruz.
@RequestMapping("/iller") // kontrol hangi URL oluşabileceğini belirlemedir.
public class IlController {

    private static final List<Il> iller = new ArrayList<>();

    public IlController(){

        if (iller.isEmpty()){

            Il il1 = new Il(new Date(),"34","Istanbul");
            Il il2 = new Il(new Date(),"44","Malatya");
            Il il3 = new Il(new Date(),"51","Nigde");
            //iller = Arrays.asList(il1, il2, il3);
            iller.add(il1);
            iller.add(il2);
            iller.add(il3);
        }
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
                .orElseThrow(() -> new RuntimeException("bu il bulunamadi"));
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

    @PostMapping    // postmapping halihazırdaki List'imize 4. bir il eklemeye yarar.
    public ResponseEntity<Il> createIl(@RequestBody Il newIl) { // iki şey verilir, ya void ya da String ile oluşturduğumuz object id'sini verebiliriz
        // ya da oluşturmak istediğimiz Object kendisini Il vermek isteyebiliriz
        newIl.setCreateDate(new Date());
        iller.add(newIl);

        //Postman arayüzünde yeni ili newadd yapmak için post komutu dışında öncelikle Header sayfasında
        // "Key=Content-Type" ve "Value=application/json" yapınca 415 unsupported media type hatası almayız
        return new ResponseEntity<>(newIl, CREATED);
    }
}
