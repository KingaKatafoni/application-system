a) Wklej wynik GET /applicants/1 (Anna z wnioskami)
{
"firstName": "Anna",
"lastName": "Nowak",
"email": "anna.nowak@email.pl",
"applications": [
{
"type": "MELDUNEK",
"status": "NOWY",
"id": 1
},
{
"type": "DOWOD",
"status": "W_TRAKCIE",
"id": 2
}
],
"id": 1
}
Response file saved.
> 2026-08-11T232234.200.json

Response code: 200
b) Wklej wynik POST /applicants (nowy wnioskodawca)
{
"firstName": "Maria",
"lastName": "Wisniewska",
"email": "maria@email.pl",
"applications": [],
"id": 3
}
Response file saved.
> 2026-08-11T233040.201.json

Response code: 201;

c) Wklej wynik POST /applicants/3/applications (nowy wniosek do Marii)
{
"firstName": "Maria",
"lastName": "Wisniewska",
"email": "maria@email.pl",
"applications": [
{
"type": "PASZPORT",
"status": "NOWY",
"id": 4
}
],
"id": 3
}
Response file saved.
> 2026-08-11T233328.201.json

Response code: 201;

d) Wklej wynik GET /applications (lista wnioskow —
czy widac dane wnioskodawcy?)
[
{
"type": "MELDUNEK",
"status": "NOWY",
"id": 1
},
{
"type": "DOWOD",
"status": "W_TRAKCIE",
"id": 2
},
{
"type": "MELDUNEK",
"status": "ZAKONCZONY",
"id": 3
},
{
"type": "PASZPORT",
"status": "NOWY",
"id": 4
}
]
Response file saved.
> 2026-08-11T233426.200.json

Response code: 200;

nie widac wnioskodawcow

e) Odpowiedz (1-2 zdania): dlaczego potrzebujemy
@JsonManagedReference i @JsonBackReference?
Potrzebujemy ich aby serializacja nie stworzyla niekonczacej sie petli -> Stack Overflow