package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

// Web kontroleris leidzia viduje naudoti @RequestMapping.
// @RestController anotacija nurodo , jog pvz: String tipo rezultatas turi buti ispaudinaas klientui toks koks yra
@RestController
public class CalculatorController {
    // http://localhost:8080/hello?name=Dovydas&surname=Stankus
    // Metodo pavadinimas, klaustukas (?), raktas, lygybe (=), reiksme. Optional jeigu daugiau nori reiksmiu simbolis (&).
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name") String name2, String surname, int age) {
        return "Hello " + name2 + " " + surname + " metai: " + age;
    }
    @GetMapping("/index")
    public String index() {
        return "<h1>Internetinis skaiciuotuvas. Atliks operacijas:</h1><br>" +
                "&nbsp;&nbsp; Atimti<br>" +
                "&nbsp;&nbsp; Dalinti<br>" +
                "&nbsp;&nbsp; Sudeti<br>" +
                "&nbsp;&nbsp; Dauginti<br>"
                ;
    }

}
