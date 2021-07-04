package pl.pjatk.artdem;

import org.springframework.stereotype.Component;

//@Component
public class MySecondComponent {

/*    public MySecondComponent() {
//        System.out.println("Hello From MySecondComponent");
    }*/

    //Stwórz dwie klasy oznaczone adnotacją @Component, a następnie stwórz pomiędzy nimi relację poprzez wykorzystanie odpowiedniego konstruktora.
    public MySecondComponent(MyFirstComponent myFirstComponent) {   //wstrzykiwanie zależności od MyFirstComponent - Spring wie, że potrzebuje MyFirstComponent żeby stworzyć MySecondComponent

        //Wypisz na ekran nazwy obydwu komponentów
        System.out.println("Hello From MySecondComponent");
        myFirstComponent.printMe();
    }

    //Do poprzednich dwóch klas dodaj po jednej metodzie która wypisze na ekran wiadomość z nazwą komponentu i nazwą metody.
    public void printMe(){
        System.out.println("Hello From MySecondComponent, printMe method");
    }
}
