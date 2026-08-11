a) Wklej wynik GET /applications (powinny byc dane z data.sql)
[
{
"applicantName": "Anna Nowak",
"type": "MELDUNEK",
"status": "NOWY",
"id": 1
},
{
"applicantName": "Jan Kowalski",
"type": "DOWOD",
"status": "W_TRAKCIE",
"id": 2
},
{
"applicantName": "Maria Wisniewska",
"type": "MELDUNEK",
"status": "ZAKONCZONY",
"id": 3
}
]
Response file saved.
> 2026-08-11T213741.200.json

Response code: 200
b) Wklej wynik POST nowego wniosku — jakie id dostal?
{
"applicantName": "Tomek Zielinski",
"type": "PASZPORT",
"status": "NOWY",
"id": 4
}
Response file saved.
> 2026-08-11T213822.201.json

Response code: 201
otrzymal id 4
c) Wklej 2-3 linie SQL z konsoli IntelliJ (te "Hibernate: ...")
Hibernate: select a1_0.id,a1_0.applicant_name,a1_0.status,a1_0.type from application a1_0 where a1_0.status=?
Hibernate: select a1_0.id,a1_0.applicant_name,a1_0.status,a1_0.type from application a1_0
Hibernate: insert into application (applicant_name,status,type,id) values (?,?,?,default)
d) Wklej wynik GET /applications/status/NOWY
[
{
"applicantName": "Anna Nowak",
"type": "MELDUNEK",
"status": "NOWY",
"id": 1
}
]
Response file saved.
> 2026-08-11T213617.200.json

Response code: 200
e) Wklej kod interfejsu ApplicationRepository (caly interfejs)
package pl.kinga.application_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kinga.application_system.model.Application;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByType(String type);

    List<Application> findByStatus(String status);

}
f) Odpowiedz (1-2 zdania): jaka jest roznica miedzy JDBC
(modul 9) a Spring Data JPA?

Roznica jest znaczaca dla dewelopera, poniewaz korzystajac z JDBC musze 
ustawic polaczenie pamietac o zabezpieczeniu try with resources, musze napisac sql i przekazac go do metody
a na koncu po otrzymaniu wyniku musze go przypisac do zmiennej i w dowolny sposob wykorzystac.
Natomiast Spring Data JPA wykonuje to wszytsko za mnie, ustawia polaczenie, za pomoca wbudowanych metod w interfejsie 
JpaRepository konwertuje pod spodem metode np findById na query SELECT ... 
