package de.abdullahgur.ilservice.module;

import lombok.AllArgsConstructor;
import lombok.Data; // bunu ekledikten sonra intellijIdea idemiz bize lombok library eklemek ister misin
import lombok.NoArgsConstructor; // şeklinde uyarı verir ve ekleriz projeye

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Il {

    private Date createDate;
    private String id;
    private String name;

    /* Bu iki constructor yazmamak için yukarıdaki iki annotations yazıyoruz, compiler time da maven bize bunu sağlıyor.
    public il(){

    }
    public il(String id, String name){
        this.id = id;
        this.name = name;
    }*/
}
