a) Wklej 5 ostatnich linii z konsoli po uruchomieniu
(powinien byc "Started..." i port)
2026-08-09T21:44:49.586+02:00  INFO 65102 --- [application-system] [           main] o.s.boot.tomcat.TomcatWebServer          : Tomcat started on port 8080 (http) with context path '/'
2026-08-09T21:44:49.591+02:00  INFO 65102 --- [application-system] [           main] p.k.a.ApplicationSystemApplication       : Started ApplicationSystemApplication in 1.735 seconds (process running for 2.407)
2026-08-09T21:44:56.237+02:00  INFO 65102 --- [application-system] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2026-08-09T21:44:56.237+02:00  INFO 65102 --- [application-system] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2026-08-09T21:44:56.238+02:00  INFO 65102 --- [application-system] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
b) Wklej co widzisz w przegladarce na /hello
System rejestracji wnioskow dziala!
c) Wklej co widzisz w przegladarce na /status
System wnioskow: AKTYWNY
d) Odpowiedz (1-2 zdania): co robi @SpringBootApplication?
@SpringBootApplication to glowna adnotacja, a tak naprawde pod spodem 3 adnotacje ktore sie wykonuja
    -@SpringBootConfiguration -> konfiguracja Springa
    -@EnableAutoConfiguration -> wlacz autokonfiguracje
    -@ComponentScan -> skanuje paki
et w poszukiwaniu beanow