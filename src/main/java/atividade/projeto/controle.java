package atividade.projeto;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controle {

 
    

    @GetMapping("/GET")
    public List<String> frases(){

        return service.getMessage();
    };

    
}
