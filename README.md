# herkansing-restservice

Deze RESTfull service biedt een service aan om de verwachte elektriciteitskosten te simuleren aan de hand van een gegeven bedrijf en
een hoeveelheid verbruikte energie. De service kan via Tomcat lokaal gedraait worden en via de volgende URL worden benaderd:

localhost:8080/plan?company=&consumedElectricity=

De variabele company in de URL is de elektriciteitsmaatschappij
De variabele consumedElektricity is de hoeveelheid verbruikte elektriciteit in kWh.

De volgende elektriciteitsmaatschappijen zijn momenteel ondersteund:
- Nuon
- EnergieDirect
- Eneco
- Oxxio
- Engie
- Essent

Na submit is de de JSON variabele "simulatedElectricityPrice" de gesimuleerde kosten.

Er is gekozen om Maven een .JAR bestand te laten maken die met java -jar target/rest-1.0.jar opgestart kan worden.
Hierbij wordt een lokale Tomcat server opgestart die de service host. In de POM.xml is rekening gehouden om ook een war bestand aan te maken,
hierbij hoeft alleen in de pom <packaging> veranderd te worden naar war i.p.v. jar. 
