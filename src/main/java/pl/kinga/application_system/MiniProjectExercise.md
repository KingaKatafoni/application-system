a) Jaka adnotacja waliduje ze data musi byc w przyszlosci? Jak ja znalazlas?
    
    Za walidacje Daty w przyszlosci odpowiada adnotacja @Future, znalazlam ja poprzez sprawdzenie dokumentacji odnosnie
    jakarta.validation.constraints 

b) Wklej wynik POST /applicants/1/visits z prawidlowymi danymi — jaki kod?

    {
    "id": 1,
    "visitDate": "2026-09-01",
    "purpose": "Dostarczenie dokumentow do wniosku o meldunek",
    "status": "SCHEDULED",
    "applicantName": "Anna Nowak"
    }
    
    kod 201 -> Created
    
c) Wklej wynik POST z data w przeszlosci — jaki kod i komunikat?

    {
    "visitDate": "musi być datą w przyszłości"
    }
    kod 400 -> Bad request
d) Wklej wynik GET /visits — czy widzisz applicantName?

        [
        {
        "id": 1,
        "visitDate": "2026-09-01",
        "purpose": "Dostarczenie dokumentow do wniosku o meldunek",
        "status": "SCHEDULED",
        "applicantName": "Anna Nowak" -> tutaj widac applicantName
        }
        ]

e) Wklej wynik POST bez logowania — jaki kod?
    
    <Response body is empty>

    Response code: 401 -> Unauthorized (niezalogowany)
f) Ile klas/plikow musialas stworzyc lub zmodyfikowac? Wymien je.
    
    Stworzylam 6 nowych klas -> 
        Visit
        VisitRepository
        VisitService
        VisitController
        VisitResponse
        VisitRequest

    Zmodyfikowalam 4 istniejace klasy
        Applicant
        ApplicantResponse
        DtoMapper
        SecurityConfig

        dodatkowo oczywiscie musialam napisac testy w test.http