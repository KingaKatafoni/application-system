a) Wklej wynik GET /actuator/health — jaki status? Czy widzisz baze H2?
{
"components": {
"db": {
"details": {
"database": "H2",
"validationQuery": "isValid()"
},
"status": "UP" -> status Bazy H2
},
"diskSpace": {
"details": {
"total": 494384795648,
"free": 187998187520,
"threshold": 10485760,
"path": "/Users/kinga/Documents/Projekty/Java_tutor/application-system/.",
"exists": true
},
"status": "UP"
},
"livenessState": {

b) Wklej wynik GET /actuator/info — czy widzisz swoje info.app.*?
{
"app": {
"name": "Application System",
"description": "System obslugi wnioskow â sektor publiczny",
"version": "1.0.0"
}
}
c) Wklej wynik GET /actuator/metrics/jvm.memory.used — ile pamieci zuzywa JVM?
{
"availableTags": [
{
"tag": "area",
"values": [
"heap",
"nonheap"
]
},
{
"tag": "id",
"values": [
"G1 Survivor Space",
"Compressed Class Space",
"Metaspace",
"CodeCache",
"G1 Old Gen",
"G1 Eden Space"
]
}
],
"baseUnit": "bytes",
"description": "The amount of used memory",
"measurements": [
{
"statistic": "VALUE",
"value": 1.79901512E8 -> ilosc zuzywanej pamieci 171 MB
}
],
"name": "jvm.memory.used"
}
d) Czy znalazlas swoje beany w /actuator/beans? Wymien 3 swoje beany ktore znalazlas.
"dtoMapper": { -> dtoMapper
"aliases": [],
"dependencies": [],
"resource": "file [/Users/kinga/Documents/Projekty/Java_tutor/application-system/target/classes/pl/kinga/application_system/dto/DtoMapper.class]",
"scope": "singleton",
"type": "pl.kinga.application_system.dto.DtoMapper"
},
"applicationController": {
"aliases": [],
"dependencies": [
"applicationService",
"dtoMapper",
"requestIdGenerator"
],
"resource": "file [/Users/kinga/Documents/Projekty/Java_tutor/application-system/target/classes/pl/kinga/application_system/controller/ApplicationController.class]",
"scope": "singleton",
"type": "pl.kinga.application_system.controller.ApplicationController"
},
"applicantRepository": {
"aliases": [],
"dependencies": [
"jpa.named-queries#0",
"jpa.ApplicantRepository.fragments#0",
"jpaSharedEM_entityManagerFactory",
"jpaMappingContext"
],
"resource": "pl.kinga.application_system.repository.ApplicantRepository defined in @EnableJpaRepositories declared on DataJpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration",
"scope": "singleton",
"type": "pl.kinga.application_system.repository.ApplicantRepository"
},
e) Wklej wynik /actuator/health PO dodaniu ApplicantHealthIndicator — czy widzisz sekcje "applicant"?

"components": {
"applicant": {
"details": {
"applicants": 2,
"message": "System has applicants"
},
"status": "UP"
},
"db": {
"details": { ...
f) Odpowiedz (1-2 zdania): dlaczego w produkcji nie wystawiasz wszystkich endpointow actuatora?
Ze wzgledow bezpieczenstwa, wystawienie wszytskich endpointow moze zdradzic na zewnatrz strukture projektu,
credentials (dane uzytkownikow, hasla), tylko info i health publiczne reszta zabezpieczona.