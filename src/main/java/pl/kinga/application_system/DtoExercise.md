a) Wklej wynik GET /applicants/1 — czy widzisz fullName?
{
"id": 1,
"fullName": "Anna Nowak",
"email": "anna.nowak@email.pl",
"applications": [
{
"id": 1,
"type": "MELDUNEK",
"status": "NOWY",
"applicantName": "Anna Nowak"
},
{
"id": 2,
"type": "DOWOD",
"status": "W_TRAKCIE",
"applicantName": "Anna Nowak"
}
]
}
Response file saved.
> 2026-08-12T221013.200.json

Response code: 200;

jest fullName widoczne
b) Wklej wynik GET /applications — czy teraz widac applicantName?
[
{
"id": 1,
"type": "MELDUNEK",
"status": "NOWY",
"applicantName": "Anna Nowak"
},
{
"id": 2,
"type": "DOWOD",
"status": "W_TRAKCIE",
"applicantName": "Anna Nowak"
},
{
"id": 3,
"type": "MELDUNEK",
"status": "ZAKONCZONY",
"applicantName": "Jan Kowalski"
}
]
jest widoczny aplicantName
c) Wklej wynik POST /applicants z pustymi danymi — czy walidacja dziala?
{
"lastName": "Nazwisko nie moze byc puste",
"firstName": "Imie nie moze byc puste",
"email": "Email nie moze byc pusty"
}
Response file saved.
> 2026-08-12T221437.400.json

Response code: 400;
d) Wklej kod jednego z Twoich DTO (np. ApplicationResponse)
package pl.kinga.application_system.dto;

public record ApplicationResponse(Long id, String type, String status, String applicantName) {
}
e) Odpowiedz (1-2 zdania): jaka jest roznica miedzy Entity a DTO?
Entity to encja czyli klasa ktora zawiera szkielet danych w bazie danych.
DTO to Data Transfer Object czyli klasa (lub record) definiujacy co jest przesylane albo otrzymywane w API.
Oddziela API os encji -> klient nie widzi niektowych pol np hasla,i zmiana encji nie wplywa na API. 
f) Odpowiedz (1 zdanie): czym jest Java Record?
Java Record to niemutowalna klasa danych, ktora automatycznie generuje konstruktor, gettery equals itd. 
Idealnie nadaje sie do dto.

e) Entity vs DTO — odpowiedź trafna! Jedna drobna uwaga do języka rekrutacyjnego: zamiast "szkielet danych w bazie" powiedz "mapowanie
na tabelę w bazie" — to bardziej precyzyjne i tak to mówią na rozmowach. Reszta (oddzielenie, bezpieczeństwo, stabilność API) — celnie.

f) Record — poprawnie! Na rozmowie warto dodać: "pola są final, brak setterów, gettery bez get — record.name() zamiast
record.getName()". To szczegół, który pokazuje, że rzeczywiście tego używałaś.