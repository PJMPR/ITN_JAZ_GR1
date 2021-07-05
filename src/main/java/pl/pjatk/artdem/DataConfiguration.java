package pl.pjatk.artdem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


//Stwórz klasę oznaczoną adnotacją @Configuration i następnie stwórz beana z wcześniej utworzonej klasy

@Configuration
public class DataConfiguration {

    //stworzyć metodę zwracającą obiekt, który chcemy zmienic w bena
    @Bean
    public DbContext dbContext(@Value("${my.custom.property}") String myText){
        System.out.println(myText);
        return new DbContext("someUrl", "someUserName", "somePassword");
    }

    //Stwórz jeszcze jednego beana który będzie nazywał się `defaultData` i będzie zwracał listę String z 5 dowolnymi stringami.
    //W pliku application.properties dodaj pole `my.custom.property` które przyjmie wartość `Hello from application properties`.
    @Bean
    public List<String> defaultData(@Value("${my.custom.property}") String myText,
                                    //Ustaw domyślną wartość w przypadku braku pola w application.properties
                                    @Value("${my.custom.missingProperty:Some Default Text}") String myText2,
                                    @Value("${my.custom.boolean}") String myBoolean){
        //Wypisz tę wartość w konsoli podczas tworzenia dowolnego beana
        System.out.println(myText);
        System.out.println(myText2);
        System.out.println("my.custom.boolean=" + myBoolean);

        List<String> someStringsList = new ArrayList<>();
        someStringsList.add("test0");
        someStringsList.add("test1");
        someStringsList.add("test2");
        someStringsList.add("test3");
        someStringsList.add("test4");

        System.out.println("defaultData is OK");
        return someStringsList;
    }

    //Utwórz bean’a który będzie inicjował się tylko wtedy gdy uruchomisz aplikację z profilem który w tej zmiennej (my.custom.boolean) posiada wartość true.
    //W przypadku profilu który zostawiał zmienną z wartością false bean nie może się utworzyć.
    @Bean
    @ConditionalOnProperty(
            value = "my.custom.boolean",
            havingValue = "true")
    public String existsOnlyWhenTrue(){
        System.out.println("I exist because this is 'ArtdemApplication newProfile' where my.custom.boolean=true");
        return "I exist";
    }

}
