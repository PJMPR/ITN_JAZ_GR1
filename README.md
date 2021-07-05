# ITN_JAZ_GR1

Artur Dembicki
s16323

Zadanie JAZ_zjazd_3.pptx

1.
Dodaj nową dependencję do projektu, dzięki której będziesz mógł korzystać z funkcjonalności webowych.
Stwórz RestController, który po wykonaniu zapytania GET na adres „localhost:8080/test/hello” zwróci ResponseEntity z Stringiem „Hello world” 

2.
Stwórz nową klasę, która będzie reprezentować dowolny model (np. Car)
Stwórz nowy endpoint w tym samym RestControllerze, który po wykonaniu zapytania GET na adres „localhost:8080/test/model” zwróci nowy obiekt klasy którą wcześniej utworzyłeś. 

3.
Stwórz nowy endpoint w tym samym RestControllerze który po wykonaniu zapytania POST na adres „localhost:8080/test/model” skorzysta z danych dostarczonych w `body` i zwróci nowy obiekt korzystający z tych danych.

4.
Stwórz RestController, po wykonaniu zapytania GET na adres „localhost:8080/test/hello/{someValue}” zwróci ResponseEntity z Stringiem {someValue} 

5.
Stwórz RestController, który po wykonaniu zapytania GET na adres „localhost:8080/test/hello?reqParam={someValue}” zwróci ResponseEntity z Stringiem {someValue} 

Praca domowa:
Stwórz nowy RestController, który przyjmie bazowy adres jako `/homework` a następnie zaimplementuj w nim metodę GET która w jednym z przypadków przyjmie dowolny PathVariable, w innym RequestParam i zwrócą podane informacje jako encje.
Stwórz dodatkowo logikę dla pozostałych metod PUT / POST / DELTE. Dla metody PUT skorzystaj z PathVariable oraz RequestBody. Dla metody POST skorzystaj z RequestBody. Dla metody DELETE skorzystaj z PathVariable. Niech metody PUT oraz POST zwrócą dostarczone dane, natomiast metoda DELETE niech zwraca jedynie HTTP status 200 bez żadnego body.
