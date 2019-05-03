**OBLIG 5**

**DEL 1: PROSJEKT OG PROSJEKTSTRUKTUR**

* Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet
at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet
fungerer på?

* Måten vi har jobbet på har tvunget oss til å jobbe godt sammen, fordi mesteparten av jobbingen har skjedd som en gruppe. Veldig mye av koden er skrevet med parprogrammering, og selv om vi har et project board til deloppgaver snakker vi også sammen om hva vi til enhver tid jobber med, hva vi trenger hjelp med, når vi forventer å bli ferdig, osv. 

* Til enhver tid vet alle hva de andre jobber med, hvor langt vi er kommet i oppgavene våre og prosjektet som helhet, hvilke endringer som har skjedd som kan påvirke deres oppgaver. Vi har jevnlige møter slik at vi får tatt opp evt utfordringer, og får løst de - enten det måtte være teknisk, logistikkmessig, osv. 

* [Møter](https://github.com/inf112-v19/The_Terminators/blob/master/Deliverables/Meetings.md)

* Vi har ikke valgt en løsning der enkelte fokuserer på design, andre på koding, osv. Vi har delt opp oppgavene i såpass små deler og jobbet såpass mye sammen at det aldri har vært slik at et område er helt ukjent for en person, og de derfor ikke kunne jobbet med det. Utenom å fullføre prosjektet har vi også fokusert på å bli bedre på det vi ikke har så mye erfaring med, slik at vi alle kommer styrket ut av faget.

Retrospektiv: 

* Den arbeidsmetodikken vi valgte i starten ble valgt etter diskusjon om hvordan vi liker å jobbe, når det passer å møtes og hvilke utfordringer eller bekymringer vi hadde til å begynne på et såpass stort prosjekt. Det gjorde at vi underveis slapp å gjøre noen store endringer, da systemet passet til oss og semesteret vårt. Vi anser oss selv som heldig som har fått den gruppen vi har fått, og er stolt av arbeidet vi har fått til. 

* I starten var vi ikke god nok til å bytte på hvilken pc vi parprogramert med, noe som førte til ujevn commits blant gruppen. Dette har vi blitt bedre på, da vi føler det er viktig å presisere at dette har vært et lagarbeid der alle har bidratt. 

* Det som har fungert best er jevne møter, god kommunikasjon, lagmedlemmer som stiller opp og viser engasjement, å dele oppgaver opp i små nok oppgaver til at enhver føler at de kan få hodet rundt det, samarbeid og fokus på å hjelpe hverandre. 

* Med litt mer tid ville vi vurdert å ta i bruk automatisert build/test/deploy-verktøy, og blitt enig om en felles kode-stil eller brukt et system for automatisk kode-styling. 

* De viktigste tingene vi har lært er verdien av git, verdien av planlegging og verdien av samarbeid. Ingen av oss har begitt oss ut på et så stort prosjekt før, og derfor aldri måttet bruke git på en avansert måte, aldri har måttet planlegge strukturen til et stort program før, og aldri jobbet i samme gruppe over et helt semester. Det føler vi oss nå trygg på å gjøre igjen. 

**DEL 2: KRAV**

* Man må kunne spille en komplett runde 
* Man må kunne vinne spillet spillet ved å besøke siste flagg (fullføre et spill) 
* Det skal være lasere på brettet 
* Det skal være hull på brettet 
* Skademekanismer (spilleren får færre kort ved skade) 
* Spillmekanismer for å skyte andre spillere innen rekkevidde med laser som peker rett frem 
* Fungerende samlebånd på brettet som flytter robotene 
* Fungerende gyroer på brettet som flytter robotene 
* Game over etter 3 tapte liv 
**
* Multiplayer over LAN eller Internett (trenger ikke gjøre noe fancy her, men må kunne spille på ulike maskiner mot hverandre) 
* Feilhåndtering ved disconnect. (Spillet skal i hvertfall ikke krasje) 
**
* Power down 
* Samlebånd som går i dobbelt tempo 
* Spille mot AI (single-player-mode), evt spill mot random-roboter


**DEL 3: KODE**

* Som en del av denne leveransen skal dere legge ved en liste (og kort beskrivelse?) over kjente feil og
svakheter i produktet.

* Dere må dokumentere hvordan prosjektet bygger, testes og kjøres, slik at det er lett å teste koden. Under
vurdering kommer koden også til å brukertestes.

* Produktet skal fungerer på Linux ( Ubuntu / Debian ), Windows og OSX.

* Dokumentér også hvordan testene skal kjøres.

* Kodekvalitet og testdekning vektlegges. Merk at testene dere skriver skal brukes i produktet.

* [Klassediagram](LINK)
Legg også ved et klassediagram som viser de viktige delene av koden. Tilpass klassediagrammet slik at det gir leseren mest mulig informasjon (feks Intellij kan tilpasse klassediagram som genereres). Hvis deregjør justeringer som feks å ta vekk ubetydelige klasser, skriv noen linjer om hvordan dere har tilpasset
klassediagrammet). Det er viktig at klassediagrammet viser hovedelementene i programmet og hvordan
disse kommuniserer. Tenk at dere skal forklare arkitekturen i programmet deres til en ny utvikler.
