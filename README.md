# ITN_JAZ_GR1

Artur Dembicki
s16323

Zadanie JAZ_zjazd_2.pptx

1.
Stwórz nową klasę która będzie zwykłym POJO (Plain Old Java Object) z kilkoma dowolnymi polami.
Stwórz klasę oznaczoną adnotacją @Configuration i następnie stwórz beana z wcześniej utworzonej klasy
Stwórz jeszcze jednego beana który będzie nazywał się `defaultData` i będzie zwracał listę String z 5 dowolnymi stringami.

2.
W pliku application.properties dodaj pole `my.custom.property` które przyjmie wartość `Hello from application properties`.
Wypisz tę wartość w konsoli podczas tworzenia dowolnego beana.

3.
Ustaw domyślną wartość w przypadku braku pola w application.properties
Wypisz w konsoli domyślną wartość

4.
Zmień plik z formatu application.properties na format application.yml

Praca domowa:
W pliku application.properties (lub application.yml) stwórz własną zmienną która domyślnie przyjmie wartość false. Utwórz dodatkowo profil, który zmieni wartość tej zmiennej na true
Utwórz bean’a który będzie inicjował się tylko wtedy gdy uruchomisz aplikację z profilem który w tej zmiennej posiada wartość true. W przypadku profilu który zostawiał zmienną z wartością false bean nie może się utworzyć.
