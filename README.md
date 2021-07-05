# ITN_JAZ_GR1

Artur Dembicki
s16323

Zadanie JAZ_zjazd_1.pptx

1. 
Stwórz nowy projekt za pomocą https://start.spring.io/. Ustaw w nim grupę jako pl.pjatk, artefakt jako 3 pierwsze litery swojego imienia oraz 3 pierwsze litery swojego nazwiska. Wersja javy niech będzie najwyższa jaką masz (preferowana 11 lub wyżej).
Stwórz dwie klasy oznaczone adnotacją @Component, a następnie stwórz pomiędzy nimi relację poprzez wykorzystanie odpowiedniego konstruktora.
Wypisz na ekran nazwy obydwu komponentów.

2.
Do poprzednich dwóch klas dodaj po jednej metodzie która wypisze na ekran wiadomość z nazwą komponentu i nazwą metody. 
Dodaj nowy komponent któremu wstrzykniesz ApplicationContext. Następnie poprzez wykorzystanie metody `.getBean(String name, Class componentClass)` z applicationContext utwórz dwa obiekty komponentów które wcześniej utworzyliśmy.
Wywołaj utworzone wcześniej metody.

3.
Przekształć poprzednią implementację tak aby nie używać adnotacji @Component tylko skorzystać z konfiguracji plikami .xml.
