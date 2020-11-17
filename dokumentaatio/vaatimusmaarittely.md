# Vaatimusmäärittely
## Sovelluksen tarkoitus
Sovelluksen tarkoituksena on mahdollistaa karttakohteisiin sidotun tiedon tallentaminen ja näyttäminen. Kartalle voidaan piirtää objekteja, jotka ovat joko pisteitä, viivoja tai pintoja. Objekteilla voi olla myös korkeus-ulottuvuus, mutta karttanäkymä piirretään ortogonaalisesti 2D-projektiona.

Karttaobjekteista tallennetaan tieto sijainnista sekä esimerkiksi materiaalista, käyttötarkoituksesta jne. Liitetyt kohteet voivat olla tehtäviä, linkkejä tiedostoihin tai erikseen tallennettavia olioita.

## Toiminnallisuus
Sovellukseen voidaan luoda kohteita kartalle, ja ne tallennetaan tietokantaan. Objekteihin voidaan liittää kohteita, esimerkiksi aiemmin mainittuja tehtäviä. Tehtävillä voi olla määräaika, johon mennessä ne pitäisi olla suoritettu, esimerkiksi tiskit 27.11.2020 mennessä.

- käyttäjä voi luoda karttaobjektin
- käyttäjä voi luoda kohdeobjektin
- käyttäjä voi linkittää objekteja
- käyttäjä näkee listauksen tehtävistä
- käyttäjä voi tarkastella karttaobjektiin sidottuja kohteita
- käyttäjä voi merkata tehtävän suoritetuksi
- käyttäjä voi muokata kartta- ja muita objekteja

## Kehitysideoita
- käyttäjä voi tuoda kartan, esimerkiksi XML-tiedostosta
- tietokannan synkronoiminen verkossa
