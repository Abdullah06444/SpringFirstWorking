package de.abdullahgur.ilservice.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Il {

    @Id
    private Date createDate = new Date();
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
