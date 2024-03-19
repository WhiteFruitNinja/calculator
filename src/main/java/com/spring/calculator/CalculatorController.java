package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Web kontroleris leidzia viduje naudoti @RequestMapping.
// @RestController anotacija nurodo, jog pvz: String tipo rezultatas turetu buti ispausdinamas klientui toks koks yra
@RestController

// Zymi konfiguracijos komponento viduje leidzia kurti bean per metodus su @Bean anotacija
// Si klases lygio anotacija nurodo Spring karkasui "Atspeti" konfiguracija.
// Remiantis priklausomybemis (Jar bibliotekomis) kurias programuotojas itraukia i projekta (pom.xml)
// Siuo atveju ji veikia kartu su main metodu.
@EnableAutoConfiguration

public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String hello () {
        return "Internetinis Skaiciuotuvas <p>" +
                "Galimos operacijos: </br>" +
                "&nbsp;&nbsp; sudeti </br>" +
                "&nbsp;&nbsp; dauginti </br>" +
                "&nbsp;&nbsp; dalinti </br>" +
                "&nbsp;&nbsp; atimti </br></p>";
    }
}
