**DEL 1: PROSJEKT OG PROSJEKTSTRUKTUR**
* testrolle:

* hvordan funker teamet og prosjektmetodikk? Gode valg, hva kan forbedres etc.

* gruppedynamikk

* kommunikasjon

* retrospektivt (prosjektstruktur)

* forbedringspunkter fra reterospektivet:

* møtereferat

* kompetanseoverføring, fordeling av kode

**DEL 2: KRAV**

KRAV FRA OBLIG 2:

presentation:
* getting something onto the screen
* finding/creating sprites
* constructing a board
* understanding how the camera works with the board 
* constructing different tiles that the board will consist of
* constructing a robot figure to move around the static board, to understand position (x,y)

cards:
* construct cards that influence the game
* create stacks for new, old and player cards
* create logic for all cards, ensuring functionality for all cards was doable

movement:
* creating a class for the robots with movement methods
* creating a system to run through the different parts of the turns
* creating a system that takes cards as input and moves robots
* creating a player with cards and a robot

tiles:
* creating logic for all tiles
* deciding on a system for tiles to manipulate players
  * is the logic in the player, reacting to the tile type?
  * is the tile affecting change on the player?
* if former, system for player to assess tile underneath and store needed information
* if latter, implement system that allows tile/board to affect player

win state:
* create ordered flag tiles
* create memory in player of which flags have been reached
* end game if all flags have been reached in order

**KRAVLISTE FOR Å NÅ MVP:**
* Man må kunne vinne spillet spillet ved å besøke siste flagg (fullføre et spill)
* Det skal være lasere på brettet
* Det skal være hull på brettet
* Skademekanismer (spilleren får færre kort ved skade)
* Spillmekanismer for å skyte andre spillere innen rekkevidde med laser som peker rett frem
* fungerende samlebånd på brettet som flytter robotene
* fungerende gyroer på brettet som flytter robotene
* game over etter 3 tapte liv
* multiplayer over LAN eller Internet (trenger ikke gjøre noe fancy her, men må kunne spille på ulike maskiner
mot hverandre)
* power down
* samlebånd som går i dobbelt tempo
* options-kort
* plassere flagg selv før spillet starter
* sette sammen ulike brett til større spillflate
* spille mot AI (single-player-mode), evt spill mot random-roboter

**DEL 3: KODE**
* dokumentere hvordan prosjektet bygges, testes og kjøres
* dokumenter hvordan testene skal kjøres


