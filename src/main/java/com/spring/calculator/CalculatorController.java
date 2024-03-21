package com.spring.calculator;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    // url pavyzdys http://localhost:8080/skaiciuoti?sk1=3&sk2=1&zenklas=%2B
    // specialiems symboliams siųsti per url:
    // https://meyerweb.com/eric/tools/dencoder/
    @RequestMapping(method = RequestMethod.GET, value = "/skaiciuoti")
    String skaiciuoti(@RequestParam HashMap<String, String> skaiciai){
        int sk1 = Integer.parseInt(skaiciai.get("sk1"));
        int sk2 = Integer.parseInt(skaiciai.get("sk2"));
        String zenklas = skaiciai.get("zenklas");

        int rezultatas = 0;
        if(zenklas.equals("+")){
            rezultatas = sk1 + sk2;
        } else if (zenklas.equals("-")){
            rezultatas = sk1 - sk2;
        } else if (zenklas.equals("*")){
            rezultatas = sk1 * sk2;
        } else if (zenklas.equals("/")) {
            rezultatas = sk1 / sk2;
        }

        return sk1 + zenklas + sk2 + " = " + rezultatas;
    }

}
