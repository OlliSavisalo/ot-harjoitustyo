# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kolmitasoista kerrosarkkitehtuuria seuraavalla tavalla:

<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Solitaire_pakkausrakenne.PNG" width="300">

Pakkaus solitaire.ui sisältää tekstikäyttöliittymällä toteutetun käyttöliittymän, solitaire.domain sisältää sovelluslogiikan ja solitaire.dao ohjelman tietojen tallennukseen tarvittavat luokat.

## Käyttöliittymä

Ohjelma on toteutettu tekstikäyttöliittymällä.
Ensimmäinen näkymä on niin kutsuttu Main menu, josta käyttäjät voivat siirtyä uuteen peliin, katsoa ennätyslistoja ja poistua ohjelmasta.

Käyttöliittymä on pyritty eristämään täysin sovelluksen toteuttavasta logiikasta, joka löytyy pakkauksesta solitaire.domain. Käyttöliittymässä on pelkästään metodeja, jotka kutsuvat eri tulosteita eri tapauksiin.

## Luokkakaavio

<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/SolitaireUml.jpg" width="500">

## Luokka-/pakkauskaavio

<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Solitaire_pakkausjaluokka.PNG" width="500">

## Sekvenssikaavio

Alla oleva sekvenssikaavio kuvaa sovelluksen käynnistystä ja alussa tapahtuvaa luokkien luomista sekä muutamaa ensimmäistä "siirtoa".

<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Kaavio-solitaire.png" width="750">

## Tietojen pysyväistallennus

Tietojen pysyväistallennuksesta vastaa ToplistDao -luokka, johon tallennetaan läpipäässeitten pelien pelaajan nimi, pelin kesto sekä tehtyjen siirtojen määrä.

### Tiedostot

Sovellus tekee itse uuden toplist.db -nimisen tiedoston ja alustaa sinne Toplist-tablen sekä syöttää 5 riviä valmiita syötteitä.
Käyttäjän läpäistessä pelin, kysyy ohjelma hänen nimeään, jonka jälkeen pelin tiedot syötetään tietokantaan.
Sovelluksen päävalikossa voi tarkastella suorituslistoja joko nopeusjärjestyksessä tai siirtojen mukaisessa järjestyksessä.
Sovellus tallentaa tiedot tietokantaan komennolla:
```
INSERT INTO Toplist (nimi, aika, siirrot) VALUES ('Olli', '00:01:13', 50)
```
Tiedon tallennukseen käytettävät muuttujat luokka ToplistDao saa luokasta Solitaire, kun peli on mennyt läpi.

Sovellus hakee tietokannasta suorituslistat komennoilla:
```
SELECT nimi, aika, siirrot FROM Toplist ORDER BY aika
```
ja
```
SELECT nimi, aika, siirrot FROM Toplist ORDER BY siirrot
```

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä
Tekstikäyttöliittymä on vaikeasti luettava, koska tulostetta tulee paljon joka valinnan jälkeen. Tämän takia käyttäjälle voi olla vaikea hahmottaa missä kohdassa peliä mennään. Tähän ongelmaan parannusta saataisiin kenties graafisella käyttöliittymällä, jossa siirrot näkyisivät samantien, eikä tarvitsisi tulostaa samaa asiaa useampaan kertaan.

### Tietokantaluokka
ToplistDao -luokkaa voisi kehittää siten, että se ei joka kerta peliä käynnistettäessä loisi uutta tiedostoa, vaan osaisi tarkistaa olemassaolon ja tehdä sen mukaan uuden tiedoston tai lukea vanhasta.
