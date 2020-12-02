# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on perinteinen korttipeli Pasianssi (tarkemmin Klondike-pasianssi), jossa käyttäjä pyrkii pinoamaan kortit maittain järjestyksessä 1:stä 13:sta.
Sovellus ottaa aikaa pelin kulusta ja pitää yllä kirjaa nopeimmista pelin läpi menneistä suorituksista.

## Käyttäjät

Sovelluksella on vain yksi käyttäjärooli ja se on normaali käyttäjä.

## Käyttöliittymäluonnos

Sovellus koostuu yhdestä näkymästä ja näkymän päälle tulee alussa pienempi ponnahdusikkuna, josta voi aloittaa uuden pelin tai tarkistaa nopeimpien suoritusten tuloksen. Pelin lopussa tulee myös ponnahdusikkuna, johon voi kirjoittaa oman nimimerkin, mikäli haluaa tuloksensa listalle.

<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttoliittymaluonnos.jpg" width="750">

## Perusversion tarjoama toiminnallisuus

### Pelin alku

- Suuri pelinäkymä aukeaa
- Pienempi ponnahdusikkuna tulee esille
	- Uuden pelin aloitus
	- TOP-listan tarkastaminen
	- Pelistä poistuminen (EXIT)

### Pelin kulku

- Alussa avautuneeseen suureen pelinäkymään avautuu itse korttipeli, ajanotto käynnistyy ja pelaaja voi alkaa pelaamaan peliä.

### Pelin loppu

- Pelaaja voi painaa Lopeta-nappia, jolloin peli palautuu alkunäkymään
- Mikäli peli menee läpi (kaikki kortit maittain järjestyksessä "yläruudukoissa"), ajanotto loppuu ja esiin tulee ponnahdusikkuna missä näkyy pelin kesto sekä voi syöttää nimimerkin TOP-listaa varten (josta näkyy top10 pelatut ajat)
- Peli palautuu alkuruutuun

## Jatkokehitysideoita

Perusversion toteuttamisen jälkeen ajan salliessa sovellusta voidaan täydentää esim. seuraavilla toiminnallisuuksilla:

- Vaihtoehto nostetaanko ns. käsipakasta 1 vai 3 korttia
- Edellä mainitulle toiminnallisuudelle oma top-lista ja alkuruutuun mahdollisuus tarkistella molempia top-listoja
- Visuaalisia parannuksia peliin (esim. kortit lomittain, että näkyy monta korttia missäkin pakassa on pelipöydällä)
- Top-listan tyhjennys
- Mahdollisuus suoraan aloittaa alusta pelin ollessa käynnissä (alkuperäisessä ideassa kierto alkuruudun kautta)

