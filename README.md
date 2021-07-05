# ITN_JAZ_GR1

Artur Dembicki
s16323

Zadanie JAZ_zjazd_4.pptx

1.
Dodaj nowy endpoint `/excpetion`, który po wywoaniu go będzie rzucał dowolny exception (RuntimeException, NullPointerException, etc…).
Dodaj @ControllerAdvice który obsłuży ten błąd i pozwoli nam zwrócić status 400 oraz body `Exception occurred on request. Exception message: " + tresc_naszego_błędu`
Niech pod `tresc_naszego_błędu` będzie String przekazywany podczas rzucania błędu. 

2.
Zrób refactor kodu tak, aby klasy znajdujące się w projekcie były możliwie jak najczytelniejsze. Utwórz nowe pakiety do których poprzenosisz klasy, dodaj nowe klasy z adnotacją @Service do których przeniesiesz logikę biznesową. Nie zapomnij o wstrzykiwaniu zależności poprzez konstruktor.

3a.
Za pomocą Spring Initializr stwórz nowy projekt nazwany MovieRentalService, który będzie aplikacją webową. 
Zaprojektuj swój model filmu. Niech film posiada obowiązkowo ID, nazwę oraz kategorię. Reszta pól według uznania

3b.
Nie zapominając o nowo poznanych zasadach z ćwiczenia drugiego, stwórz:
endpoint zwracający wszystkie filmy. 
Metoda GET, 
ścieżka /movies, 
Zwracany typ ResponseEntity<List<Movie>>
Status: OK (200)

3c.
Nie zapominając o nowo poznanych zasadach z ćwiczenia drugiego, stwórz:
endpoint zwracający film pod konkretnym id. 
Metoda GET, 
ścieżka /movies/{id}, 
Zwracany typ ResponseEntity<Movie>
Status:
W przypadku znalezienia - 200 (OK)
ii. W przypadku braku zasobu - 404 (NOT FOUND)

3d.
Nie zapominając o nowo poznanych zasadach z ćwiczenia drugiego, stwórz:
endpoint dodający nowy film.
Metoda HTTP: POST
Path: “/movies”
@RequestBody Movie movie - pamiętaj o nie przesyłaniu pola ‘id’.
Status:
Poprawnego dodania - 200 (OK) 
Nieprawidłowe dane wejściowe - 400 (BAD REQUEST) 
Zwracany typ: ResponseEntity<Movie>

3e.
Nie zapominając o nowo poznanych zasadach z ćwiczenia drugiego, stwórz:
endpoint aktualizujący istniejący film. Jeśli dany film nie istnieje, należy zwrócić kod błędu 404. Nie ma konieczności walidacji ustawianych danych.
Metoda HTTP: PUT
Path: “/movies/{id}”
@RequestBody Movie movie
Status:
Poprawna aktualizacja - 200 (OK)
Nieprawidłowe dane wejściowe - 400 (BAD REQUEST)
Zwracany typ: ResponseEntity<Movie>

3f.
Nie zapominając o nowo poznanych zasadach z ćwiczenia drugiego, stwórz:
endpoint usuwający istniejący film.Metoda HTTP: PUT
Metoda HTTP: DELETE
Path: “/movies/{id}”
Status:
Poprawne usunięcie - 204 (NO CONTENT)
Brak zasobu do usunięcia - 404 (NOT FOUND)
Zwracany typ: ResponseEntity<Void>

Praca domowa:
Skonfiguruj lokalnie działającą bazę danych MySQL (MySQL Server i MySQL Workbench). 
Utwórz bazę danych dla wcześniej utworzonej encji Movie. Na razie jedynie po stronie MySQL, po stronie javy nic nie robimy. 
Po utworzeniu bazy danych dodaj kilka rekordów do tabeli Movie
W e-mailu z pracą domową proszę o przesłanie screena z MySQL Workbencha na którym będzie wykonanie zapytanie select i zostanie zwrócone kilka filmów.

