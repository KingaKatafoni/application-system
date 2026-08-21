a) Co sie stalo po samym dodaniu spring-boot-starter-security (przed SecurityConfig)?
    Body bylo puste Spring wymuszal zalogowanie sie (haslo w logach wygenerowane)
b) Wklej wynik POST /applicants BEZ logowania — jaki kod HTTP?
HTTP/1.1 401
Set-Cookie: JSESSIONID=6A2886634E60977D350C41D416A5AD6C; Path=/; HttpOnly
WWW-Authenticate: Basic realm="Realm", charset="UTF-8"
X-Content-Type-Options: nosniff
X-XSS-Protection: 0
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 0
Date: Fri, 14 Aug 2026 19:28:47 GMT

<Response body is empty>

Response code: 401; -> kod 401
c) Wklej wynik POST /applicants Z loginem pracownika — jaki kod HTTP?
{
"id": 3,
"fullName": "Test User",
"email": "test@email.pl",
"applications": []
}
Response file saved.
> 2026-08-14T213125.201.json

Response code: 201; -> kod 201
d) Wklej wynik GET /actuator/beans jako pracownik — jaki kod HTTP i dlaczego?
Content-Length: 0
Date: Fri, 14 Aug 2026 19:32:19 GMT

<Response body is empty>

Response code: 401; -> kod 401 Unauthorized (niezalogowany)
e) Wklej wynik GET /actuator/beans jako admin — jaki kod HTTP?
{
"timestamp": "2026-08-14T19:34:10.013Z",
"status": 403,
"error": "Forbidden",
"path": "/actuator/beans"
}
Response file saved.
> 2026-08-14T213410.403.json

Response code: 403; -> kod 403 forbidden (zalogowany ale bez tych uprawnien)
f) Odpowiedz (1-2 zdania): jaka jest roznica miedzy authentication a authorization?
Authentication -> weryfikacja danych logowania uzytkownika (login + haslo)
Authorization -> weryfikacja uprawnien czy dany uzytkownik (o danej roli) ma dostep do zasobu 
g) Odpowiedz (1 zdanie): dlaczego wylaczamy CSRF w REST API?
CSRF jest zabezpieczeniem formularzy html, REST API z ktorego korzystamy jest bezstanowe - klient wysyla token lub Basic Auth, wiec CSRF jest nie potrzebne.