a) Wklej logi z konsoli po uruchomieniu aplikacji — czy widzisz komunikat @PostConstruct?
2026-08-14T14:09:59.651+02:00  INFO 8002 --- [application-system] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2026-08-14T14:09:59.677+02:00  INFO 8002 --- [application-system] [           main] o.s.d.j.r.query.QueryEnhancerFactories   : Hibernate is in classpath; If applicable, HQL parser will be used.
Service is already started! -> tu jest komuniakt z @PostConstruct
Hibernate: select count(*) from applicant a1_0
Amount of Applicants: 0  -> tu jest komuniakt z @PostConstruct
b) Wklej logi po zatrzymaniu aplikacji — czy widzisz komunikat @PreDestroy?
2026-08-14T14:15:24.629+02:00  INFO 8002 --- [application-system] [tomcat-shutdown] o.s.boot.tomcat.GracefulShutdown         : Graceful shutdown complete
Service is shutting down! -> komunikat z @PreDestroy
2026-08-14T14:15:24.632+02:00  INFO 8002 --- [application-system] [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
Hibernate: drop table if exists applicant cascade
Hibernate: drop table if exists application cascade
c) Eksperyment prototype: czy oba kontrolery dostaly ten sam requestId czy rozny? Dlaczego?
 Kontrolery otrzymaly rozne id, poniewaz prototype powoduje ze kazde wstrzykniecie dostaje nowa instancje obiektu
Twoja odpowiedź o prototype jest poprawna, ale jest tu pułapka, o której warto wiedzieć na rozmowę:

Dostałaś różne ID w obu kontrolerach — ale każdy kontroler dostaje swoje ID raz, przy starcie i trzyma je na stałe. Gdybyś wywołała GET
/applicants pięć razy, za każdym razem zobaczysz to samo ID, bo kontroler jest singletonem i jego idGenerator nie zmienia się między
requestami.

Prawdziwy "nowy ID na każdy request" wymagałby innego podejścia (np. scope request, albo ObjectProvider<RequestIdGenerator>). Ale to
temat na kiedy indziej — na teraz ważne, że widzisz różnicę między singleton a prototype.
d) Odpowiedz (1-2 zdania): co to jest ApplicationContext?
ApplicationContext to kontener Springa z beanami, po uruchomieniu skanuje pakiety i tworzy klasy
oznaczone @Component -> @Service, @Controller itd., wstrzykuje zaleznosci ktore sa w konstruktorze 
przekazane i zarzadza cyklem zycia beanow.
e) Odpowiedz (1 zdanie): jaki jest domyslny scope beana w Springu?
Domyslny scope w Springu to Singleton -> jedena instancja obiektu na aplikacje
f) Odpowiedz (1-2 zdania): czemu wstrzykiwanie przez konstruktor jest lepsze od @Autowired na polu?
@Autowired jest podejsciem starszym, rekomendowane jest wtrzykiwanie przez konstruktor, poniewaz
-pole moze byc finalne
- czytelniejszy jest kod, bo widac po konstruktorze co jest potrzebne
- ulatwia testowanie