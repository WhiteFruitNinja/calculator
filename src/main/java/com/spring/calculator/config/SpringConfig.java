package com.spring.calculator.config;

import com.spring.calculator.service.NumberService;
import com.spring.calculator.service.NumberServiceImpl;
import com.spring.calculator.service.UserService;
import com.spring.calculator.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration - žymi konfigūracijos komponentą
// viduje leidžia kurti bean per metodus su @Bean
@Configuration
public class SpringConfig {

    @Bean
    @Qualifier("UserService")
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    // Bean - tai objektai, kurei sudaro Spring aplikacijos pagrindą.
    // Paprastai tai Java klasė, realizuojanti tam tikrą interfeisą ir JavaBean specifikaciją.
    // Bean atitinka Singleton šabloną - programinės įrangos projektavimo schema,
    // kuri riboja klasės įvykdymą vienu "vieninteliu" egzemplioriumi.
    // tai naudinga, kai reikia tiksliai vieno objekto, norint koordinuoti veiksmus visoje sistemoje.
    @Bean
    // @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkrečiai bean susieti priklausomybę.
    // Jeigu @Configuration klasėje yra daugiau negu vienas bean, @Qualifier anotacija yra privaloma,
    // kitu atveju metama klaida:
    // 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberService")
    public NumberService getNumberService(){
        return new NumberServiceImpl();
    }

}
