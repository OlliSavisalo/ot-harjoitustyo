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

Sovellus tekee itse uuden toplist.db -nimisen tiedoston ja alustaa sinne Toplist-tablen sekä syöttää 5 riviä valmiita syötteitä. Tämä ominaisuus mahdollisesti poistetaan viimeiseen versioon, kun testauksessa on todettu toimivaksi.
