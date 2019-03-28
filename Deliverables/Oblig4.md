**DEL 1: PROSJEKT OG PROSJEKTSTRUKTUR**

**Tester:**

Selv om vi alle har erfaring med testing og har tatt ansvar for å teste våre egne komponenter, ser vi verdien i å velge en testansvarlig som kan passe på at alle holder fokus på det. Som vi nevner i retrospektiv er dette noe vi kan bli enda bedre på, og mtp at testing kan ofte være 25% av et utviklingsbudsjett, er det naturlig at noen får ansvar for dette. Vi har valgt Magne som testansvarlig, og han er i gang med å utvikle en strategi for testing fremover i prosjektet. Han foreslår at vi setter oss et mål om å være optimistiske men realistiske. Det er enkelte deler av koden som det ikke er nyttig å teste, og som bare vil drive opp måltallet uten å faktisk bidra til kvalitetssikring av kodebasen. 

**Automatiske J-Unit tester**

Vi begynte tidlig med å skrive unit-tester som sjekket hver klasse vi har skrevet og bekreftet at de fungerte som de skulle. Hver gang man er ferdig å skrive en bolk med kode har vi prøvd å skrive gode tester som påpeker eventuelle feil og mangler, før vi pusher koden. Vi har også kjørt alle de andre testene, for å se at den nye koden vi skriver ikke endrer funksjonaliteten til deler av koden som tidligere har vært ok, og som andre deler av programmet er avhengig av. Styrken i omfattende enhetstesting har kommet frem på denne måten.

**Manuell testing**

Enkelte deler av spillet har vært vanskeligere å teste med J-Unit tester, og der har vi måttet bruke manuell testing. Dette gjelder spesielt med gameplay, grafikk, de delene av spillet som må fremprovoseres av spilleren og de delene av programmet som varierer fra maskin til maskin. Vi har forskjellige operativsystem og forskjellige oppløsninger, og forsøket på å få alt til å se likt ut på alle maskiner 

**Gruppedynamikk:**

Vi føler de valgene vi har tatt er gode. Ingen av valgene som er tatt, har fått oss til å føle at vi har trengt å gå tilbake og endre på noe. Gruppedynamikken er veldig bra, vi jobber godt sammen og har det kjekt med hverandre. Den agile arbeids metodikken fungerer fortsatt og vi har fått god flyt i arbeidet. 

**Kommunikasjonen:**

Vi bruker fortsatt Slack, og er veldig fornøyd med hvordan det har fungert. Vi har nå i siste tiden også laget en facebook chat der det går i litt “mindre faglig” diskusjoner, og eventuelle påminnelser om å sjekke Slack.

[**Retrospektivt**](https://github.com/inf112-v19/The_Terminators/blob/master/Deliverables/Retrospektivt%2028.03docx.pdf)

**Hva vi kan forbedre:**

* Commits: 
  * Siden vi er mange som jobber med samme prosjekt så blir det litt variasjon i commits. Noen er flinkere enn andre til å committe ofte. Her har vi et forbedringspotensiale. Vi må og bli flinkere på å variere på hvem sin maskin vi jobber fra, siden vi parprogrammerer, sånn at committsene blir litt jevnere fordelt mellom oss. 

[**Møtereferat**](https://github.com/inf112-v19/The_Terminators/blob/master/Deliverables/Meetings.md)

**Kompetanseoverføring:**
Vi parprogrammerer sammen, ofte med en som kan mer enn den andre slik at alle lærer noe. Når vi møtes går vi gjennom prosjektet slik at alle får oversikt og kan spørre hvis man lurer på noe. 

**KLASSEDIAGRAM!!!!!!!**

**DEL 2: KRAV**

**KRAVLISTE FOR Å NÅ MVP:**

* One must be able to play a complete round 
  * Finished this week, with win and game over conditions
* One must be able to win the game game by visiting the last flag (completing a game)
  * Finished this week, reaching all checkpoints ends the game 
* There must be lasers on the board 
  * Lasers have been on the to-do board for a while, but haven’t been prioritized yet. This is because we have been torn between using a collision system or having it being based on the tiles. This will be the focus of our first sprint after this delivery.
* There must be holes on the board 
  * These are functional, as well as the edges of the board where the player can fall off.
* Injury mechanisms (player gets fewer cards in case of injury) 
  * This feature is not yet implemented, as it will be a natural extension to the point above (laser) and the point below (allowing other players to injure)
* Game mechanisms to shoot other players within reach with laser pointing straight ahead 
  * This will be directly tied to the laser we develop for the board, and as such has not been started yet. Expected start is in a week, the second sprint after this delivery.
* Acting assembly line on the board that moves the robots 
  * Functional
* Functioning gyros on the board that move the robots 
  * Functional
* Game over after 3 lost lives 
  * Functional, finished this week.
* Multiplayer over LAN or Internet 
  * Initial tests have been successful (a branch has been made that has successfully communicated between two machines on a local network). When we have decided on what we wish to send, this can be quickly implemented. We will have one player be the host and the other the client. 
* Power down 
  * Not yet implemented
* Assembly line that runs at double speed 
  * Functional
* Options cards 
  * Not yet implemented
* Place flags even before the game starts 
  * We have flags placed at static positions now, to ease testing and development of win states and checkpoints. Now that we have finished that part, we can work on placing flags at specific spots, changing the amount of flags, etc
* Assemble different boards to larger games
  * Not yet finished, most work has been done on a standard (4+12) x 12 board
* Play against AI (single-player mode), possibly play against random robots 
  * Not yet implemented

We have come a long way and are happy with our progress and codebase, and have had few problems implementing new features without breaking older ones. With the remaining weeks of the project, we expect to reach our goal of having all the features of the MVP finished. When we are finished with the project and can start doing larger tests of entire runthroughs, we will focus on that before starting work on additional features. 


**DEL 3: KODE**

 * Produktet skal fungerer på Linux ( Ubuntu / Debian ), Windows og OSX. -
   * I gruppen har vi bare OSX maskiner og Windows maskiner. I tillegg har samtlige ulike skjermer, noe som har gjort det til dels vanskelig å få programmet til å se bra ut hos alle. Dette tenker vi uansett at er greit for å få testet på flest mulig skjermer og få en best mulig løsning.

* dokumenter hvordan testene skal kjøres
  * Vi benytter oss av JUnit tester, og har gjort det fra starten. I tillegg kjøres diverse funksjonelle tester under utvikling.
  
 
* Kodekvalitet og testdekning vektlegges. Merk at testene dere skriver skal brukes i produktet.
  * Vi har hele tiden vært oppmerksom på dette, men hele teorien bak å skrive tester før vi koder er nytt for alle i gruppen. Vi har sakte men sikkert beveget oss litt mot dette, men det har vært krevende. Vi fokuserer fortsatt hele tiden på å skrive gode tester som dekker programmet i størst mulig grad.



