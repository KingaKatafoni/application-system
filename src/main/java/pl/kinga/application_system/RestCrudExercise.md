a) Wklej wynik POST /applications (nowy wniosek) — powinien byc JSON + status 201
{
"id": 4,
"applicantName": "Tomek Zielinski",
"type": "PASZPORT",
"status": "NOWY"
}
Response file saved.
> 2026-08-10T191435.201.json

Response code: 201;
b) Wklej wynik GET /applications po dodaniu i usunieciu
[
{
"id": 1,
"applicantName": "Anna Nowak",
"type": "MELDUNEK",
"status": "ZAKONCZONY"
},
{
"id": 2,
"applicantName": "Jan Kowalski",
"type": "DOWOD",
"status": "W_TRAKCIE"
},
{
"id": 4,
"applicantName": "Tomek Zielinski",
"type": "PASZPORT",
"status": "NOWY"
}
]
Response file saved.
> 2026-08-10T191522.200.json

Response code: 200;
(powinny byc 3 wnioski: Anna zmieniona, Jan, Tomek nowy)
c) Jaki kod HTTP dostales na DELETE /applications/3? A na DELETE /applications/99?
 DELETE applications 3 -> 204
 DELETE applications 99 -> 404
d) Odpowiedz (1-2 zdania): po co jest @RequestBody?
 @RequestBody sluzy do zamiany ciala zapytania na obiekt Java za pomoca Jacksona. Spring robi to automatycznie.
e) Odpowiedz (1-2 zdania): po co jest ResponseEntity
skoro mozna zwracac obiekt bezposrednio?
ResponseEntity jest wrapperem na odpowiedz HTTP czyli oprocz zwracania bezposrednio obiektu
daje nam kontrole nad kodami statusu, naglowkami i cialem.