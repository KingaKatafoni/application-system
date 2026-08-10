a) Wklej odpowiedz na Test 1 (puste pola) — powinien byc JSON z bledami + status 400
{
"applicantName": "Imie musi miec od 2 do 100 znakow",
"type": "Typ wniosku nie moze byc pusty",
"status": "Status nie moze byc pusty"
}
Response file saved.
> 2026-08-10T221359.400.json

Response code: 400;
Blad 400 -> Zle dane w zapytaniu
b) Wklej odpowiedz na Test 2 (za krotkie imie) — jaki blad dostales?
{
"applicantName": "Imie musi miec od 2 do 100 znakow"
}
Response file saved.
> 2026-08-10T221425.400.json

Response code: 400;
Blad 400 -> Zle dane w zapytaniu
c) Wklej odpowiedz na Test 3 (poprawne dane) — powinien byc 201
{
"id": 5,
"applicantName": "Tomek Zielinski",
"type": "PASZPORT",
"status": "NOWY"
}
Response file saved.
> 2026-08-10T221547.201.json

Response code: 201;
kod 201 -> Created
d) Odpowiedz (1-2 zdania): co robi @Valid?
@Valid daje znac Springowi ze zanim przekaze obiekt do metody w controller to ma sprawdzic adnotacje walidacyjne.
e) Odpowiedz (1-2 zdania): po co jest @RestControllerAdvice?
@RestControllerAdvive to globalny handler bledow, ktory obsluguje wyjatki ze wszytskich kontrolerow.
Dzieki niemu i @ExceptionHandler'owi zamiast ogolnej odpowiedzi bad request mamy czytelna odpowiedz z walidacji.