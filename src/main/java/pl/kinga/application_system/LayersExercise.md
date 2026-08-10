a) Wklej wynik http://localhost:8080/applications (JSON)
[{"id":1,"applicantName":"Anna Nowak","type":"MELDUNEK","status":"NOWY"},{"id":2,"applicantName":"Jan Kowalski","type":"DOWOD","status":"W_TRAKCIE"},{"id":3,"applicantName":"Maria Wisniewska","type":"MELDUNEK","status":"ZAKONCZONY"}]
b) Wklej wynik http://localhost:8080/applications/1
{"id":1,"applicantName":"Anna Nowak","type":"MELDUNEK","status":"NOWY"}
c) Wklej wynik http://localhost:8080/applications/type/
[{"id":1,"applicantName":"Anna Nowak","type":"MELDUNEK","status":"NOWY"},{"id":3,"applicantName":"Maria Wisniewska","type":"MELDUNEK","status":"ZAKONCZONY"}]
d) Wklej kod metody findByType z Repository
(bez reszty klasy — tylko metode)
public List<Application> findByType(String type){
return applications.stream()
.filter(a -> a.getType().equals(type))
.toList();
}
e) Odpowiedz (1-2 zdania): dlaczego Controller nie powinien
wywolywac Repository bezposrednio?
    W naszym przypadku mozna bybylo pominac bo Service wykonuje dokladnie te same operacje co Repository ale dla 
ugruntowania wiedzy o wartwach wyszczegolnilismy je.
    Warto jest miec to rozdzielenie bo np. gdybysmy dokonali zmian w repository tzn nie wpisywali wartosci w liscie na sztywno tylko zamienili na pobieranie z bazy i Service wykonywal dodatkowa logike biznesowa 
to zmiany dokonane w Repository nie dotykają Controllera bezposrenio.