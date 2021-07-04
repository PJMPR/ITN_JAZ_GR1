package pl.pjatk.artdem;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//Używając andnotacji @Component:
/*//Dodaj nowy komponent któremu wstrzykniesz ApplicationContext.
@Component
public class MyThirdComponent {

    ApplicationContext context; // context nie potrzebuje adnotacji - sam potrafi się wstrzyknąć

    public MyThirdComponent(ApplicationContext context) {
        System.out.println("Hello from MyThirdComponent");
        this.context = context;
    }

    public void printMe() {

        System.out.println("Hello From MyThirdComponent, printMe method");

        //Następnie poprzez wykorzystanie metody `.getBean(String name, Class componentClass)` z applicationContext
        //utwórz dwa obiekty komponentów które wcześniej utworzyliśmy.
        MyFirstComponent first = this.context.getBean(MyFirstComponent.class);
        MySecondComponent second = this.context.getBean(MySecondComponent.class);

        //Wywołaj utworzone wcześniej metody
        first.printMe();
        second.printMe();

    }
}*/

    //Uzywajac konfiguracji beans.xml:
    public class MyThirdComponent {

        MyFirstComponent first;
        MySecondComponent second;

        public MyThirdComponent(MyFirstComponent first, MySecondComponent second) {
            this.first = first;
            this.second = second;
        }

        public void printMe() {

            //Wywołaj utworzone wcześniej metody
            first.printMe();
            second.printMe();

            System.out.println("Hello From MyThirdComponent, printMe method");
        }

    }
