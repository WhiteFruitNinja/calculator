package com.spring.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

// @RestController negrąžina view.
// Kadangi mums reikia grąžinti veiw pagal Spring MVC, naudojame @Controller
@Controller
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

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String home(){
        // grąžiname JSP failą,turi būti talpinami 'webapp -> WEB-INF -> jsp' aplanke
        return "skaiciuotuvas";
    }

    // Kadangi skaičiuotuvo forma naudoja Post metodą, čia irgi nurodome POST
    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    String skaiciuoti(@RequestParam HashMap<String, String> skaiciai, ModelMap modelMap){
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

        // ModelMap objektas naudojamas siųsti reikšmes iš Spring MVC controller į JSP
        modelMap.put("sk1", sk1);
        modelMap.put("sk2", sk2);
        modelMap.put("zenklas", zenklas);
        modelMap.put("rezultatas", rezultatas);

        return "skaiciuoti";
    }

}
