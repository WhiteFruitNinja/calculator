package com.spring.calculator;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

// @RestController negrąžina view.
// Kadangi mums reikia grąžinti veiw pagal Spring MVC, naudojame @Controller
@Controller
public class CalculatorController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String home(Model model){
        // Jeigu Model 'number' nepraeina validacijos - per jį grąžinamos validacijos klaidos į View
        model.addAttribute("number", new Number());
        // grąžiname JSP failą,turi būti talpinami 'webapp -> WEB-INF -> jsp' aplanke
        return "skaiciuotuvas";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    String skaiciuoti(@Valid @ModelAttribute("number") Number e, BindingResult br,
                      @RequestParam HashMap<String, String> skaiciai, ModelMap modelMap){
        if(br.hasErrors()){
            return "skaiciuotuvas";
        } else {
            int sk1 = Integer.parseInt(skaiciai.get("sk1"));
            int sk2 = Integer.parseInt(skaiciai.get("sk2"));
            String zenklas = skaiciai.get("zenklas");
            int rezultatas = 0;
            if (zenklas.equals("+")){
                rezultatas = sk1 + sk2;
            } else if (zenklas.equals("-")){
                rezultatas = sk1 - sk2;
            } else if (zenklas.equals("*")){
                rezultatas = sk1 * sk2;
            } else if (zenklas.equals("/")) {
                rezultatas = sk1 / sk2;
            }

            modelMap.put("sk1", sk1);
            modelMap.put("sk2", sk2);
            modelMap.put("zenklas", zenklas);
            modelMap.put("rezultatas", rezultatas);

            return "skaiciuoti";
        }
    }

}
