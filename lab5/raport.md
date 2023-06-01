# Laboratorium 5.
## APRO2 2023L Bartłomiej Dmitruk

### Task 0 (przygotowanie)

W celu konkatenacji Stringów wersja concatV1 używa operatora +=, a wersja concatV2 korzysta z klasy StringBuilder.

##### Analiza wyjścia deasemblera dla concatV1:
- Pętla L1 i L4 wykonuje iterację od 0 do 25 aby zbudować końcowy łańcuch (połączone litery alfabetu). Instrukcje ILOAD, BIPUSH, IF_ICMPGE, IINC i GOTO są używane do zarządzania iteracją i indeksami.
- W pętli, instrukcja INVOKESTATIC jest używana do wywołania metody StringConcatFactory.makeConcatWithConstants, która dokonuje konkatenacji łańcuchów i zwraca wynik.
- Wartością do konkatenacji jest łańcuch złożony z dwóch znaków "\u0001\u0001". Instrukcja INVOKEDYNAMIC jest używana w celu dynamicznego wywołania konkretnej metody do konkatenacji.
##### Analiza wyjścia deasemblera dla concatV2:
- Na początku metody, tworzony jest obiekt StringBuilder za pomocą instrukcji NEW i DUP.
- Pętla L2 i L5 wykonuje iterację od 0 do 25, aby zbudować końcowy łańcuch (połączone litery alfabetu). Instrukcje ILOAD, BIPUSH, IF_ICMPGE, IINC i GOTO są używane do zarządzania iteracją i indeksami.
- W pętli, instrukcja INVOKEVIRTUAL jest używana do wywołania metody StringBuilder.append, która dodaje znak do StringBuilder.
- Na końcu metody, instrukcja INVOKEVIRTUAL jest używana do wywołania metody StringBuilder.toString, która zwraca wynik konkatenacji jako łańcuch.

##### Wnioski :
Wersja concatV1 używa operatora +=, co prowadzi do tworzenia i porzucania tymczasowych łańcuchów przy każdej konkatenacji. Natomiast wersja concatV2 wykorzystuje bardziej wydajną klasę StringBuilder, która minimalizuje tworzenie tymczasowych obiektów łańcuchów i zapewnia bardziej efektywną konkatenację.

### Task 1

Odszyfrowane hasło ma postać : **5oV9P4_2023_+_optional_Strings**
  - hasło składa się z bazy  5oV9P4_2023 
  - do bazy może być dołączona dowolna liczba opcjonalnych łańcuchy znaków oddzielonych znakiem '_'.

Generowanie hasła:
  - Hasło, które jest porównywane z wprowadzonym przez użytkownika jest przechowywane w dwuelementowej tablicy Stringów
  - Pierwszy element tablicy to String o długości 6 znaków, utworzony poprzez przesunięcie znaków ASCII o 2 korzystając z klasy Coder
  - Drugi element tablicy to String o długości 4 znaków, utworzony poprzez pobranie aktualnego roku.
  - Reszta elementów tablicy (opcjonalne łańcuchy znaków) nie jest porównywana z wzorcowym hasłem.
  - Bardziej szczegółowe działanie opisane jest w komentarzach w kodzie programu.

### Task 2

#### Opis metod i potencjalne przeznaczenie:
#### Odszyfrowane argumenty metod:
- os.name                                                         
- Windows                                                         
- https://www.bamsoftware.com/hacks/zipbomb/zbsm.zip              
- shutdown /s                                                     
- shutdown -h now                                                 
- user.dir                                                        
- zbsm.zip

####  Zagrożenia operacji wykonywanych przez program:
- convertHexStringToBytes()
  -  konwersja ciągu znaków z hex na tablicę bajtów.
  
- decryptMessage(): 
  - Deszyfrowanie wiadomości za pomocą szyfrowania AES/CBC. 
  - Przyjmuje zaszyfrowaną wiadomość jako argument i zwraca zdeszyfrowaną wiadomość. 
  - Przeznaczenie tej metody może obejmować odszyfrowywanie komend w zaszyfrowanych w celu ofuskacji.

- downloadFileFromUrl(): 
  - Metoda ta służy do pobierania pliku ZIP z podanego adresu URL. 
  - Pobrany plik jest zapisywany na dysku. 
  - Przeznaczeniem tej metody jest pobranie Zip Bomy na dysk ofiary

- unZipFile():  
  - Metoda ta służy do rozpakowywania zawartości pliku ZIP do określonego katalogu. 
  - Przyjmuje ścieżkę do pliku ZIP i katalog, do którego ma być rozpakowany. 
  - Przeznaczeniem tej metody jest rozpakowanie Zip Bomy w celu zapchania dysku ofiary.

- main(): 
  - Główna metoda, która wykonuje złośliwy kod. 
  - Pobiera i wykonuje plik ZIP z Internetu
  - Następnie w zależności od systemu operacyjnego wykonuje polecenie systemowe (wyłącza komputer ofiary
  - Metoda główna, która uruchamia cały złośliwy kod.


    
Celem programu jest pobranie Zip Bomby z linku, wypakowanie jej, zapchanie dysku ofiary, wyłączenie komputera.
