package pl.pjatk.artdem;

import org.springframework.stereotype.Component;

//@Component
public class MyFirstComponent {

    public MyFirstComponent() {
        System.out.println("Hello From MyFirstComponent");
    }

/*    public void printHelloMessage(){
        System.out.println("Hello From MyFirstComponent from printHelloMessage method");
    }*/

    //Do poprzednich dwóch klas dodaj po jednej metodzie która wypisze na ekran wiadomość z nazwą komponentu i nazwą metody.
    public void printMe(){
        System.out.println("Hello From MyFirstComponent, printMe method");
    }
}
