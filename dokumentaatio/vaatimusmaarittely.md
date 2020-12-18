# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on perinteinen korttipeli Pasianssi (tarkemmin Klondike-pasianssi), jossa käyttäjä pyrkii pinoamaan kortit maittain järjestyksessä 1:stä 13:sta.
Sovellus ottaa aikaa pelin kulusta ja pitää yllä kirjaa nopeimmista pelin läpi menneistä suorituksista. Lisäksi sovellus laskee käyttäjän tekemiä siirtoja, mitkä lisätään aikojen lisäksi suorituslistalle. Käyttäjä voi pelin päävalikossa tulostaa suorituslistan järjestettynä aikojen mukaan (nopeimmasta hitaimpaan), tai siirtojen mukaan (pienimmästä siirtojen määrästä suurimpaan).

## Käyttäjät

Sovelluksella on vain yksi käyttäjärooli ja se on normaali käyttäjä.

## Käyttöliittymäluonnos

Sovellus koostuu tekstikäyttöliittymästä, jossa eri näkymät ovat päävalikko, suorituslistojen tulostus sekä itse pelin kulku.

### Päävalikko
<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Mainmenu.PNG">

### Suorituslistat
<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/toplist.PNG">

### Siirto
<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/siirto.PNG">

### Pelin loppu
<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/loppupeli.PNG">

## Perusversion tarjoama toiminnallisuus

### Pelin alku

- Ohjelman käynnistyessä käyttäjälle tulee valikoksi päävalikko, josta valitaan haluaako uuden pelin, katsoa tuloslistoja vai lopettaa pelin.
- Uusi peli jakaa uuden pelipöydän ja käyttäjä voi alkaa pelaamaan peliä.
- Tuloslistojen tarkastelussa käyttäjä voi valita katsooko listoja aikajärjestyksessä vai tehtyjen siirtojen mukaisessa järjestyksessä.
- Pelin lopetus lopettaa ohjelman suorittamisen.

### Pelin kulku

- Käyttäjälle tulostetaan pelipöytä sekä ohjeet mitä siirtoja voi tehdä ja miten.
Siirrot:
1. Siirto käsipakasta/-pakkaan
2-5. Siirto lopullisiin pinoihin tai pois niistä
6-12. Siirto pöydällä oleviin pakkoihin tai niistä pois
0. Lopettaa pelin

### Pelin loppu

- Pelaaja voi valita numeron 0, jolloin peli palautuu alkunäkymään. Sovellus tulostaa käytetyn ajan sekä tehdtyjen siirtojen määrän.
- Mikäli peli menee läpi (kaikki kortit maittain järjestyksessä "yläruudukoissa"), ajanotto loppuu ja sovellus tulostaa tekstin missä käyttäjä voi syöttää nimimerkin TOP-listaa varten.
- Peli palautuu alkuruutuun.

## Jatkokehitysideoita

Perusversion toteuttamisen jälkeen ajan salliessa sovellusta voidaan täydentää esim. seuraavilla toiminnallisuuksilla:

- Vaihtoehto nostetaanko ns. käsipakasta 1 vai 3 korttia
- Edellä mainitulle toiminnallisuudelle oma top-lista ja alkuruutuun mahdollisuus tarkistella molempia top-listoja
- Graafisen käyttöliittymän samoilla toiminnallisuuksilla kuin tekstikäyttöliittymä. [Käyttöliittymäluonnos](https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttoliittymaluonnos.jpg)
- Visuaalisia parannuksia peliin (esim. kortit lomittain, että näkyy monta korttia missäkin pakassa on pelipöydällä)
- Top-listan tyhjennys
- Mahdollisuus suoraan aloittaa alusta pelin ollessa käynnissä (alkuperäisessä ideassa kierto alkuruudun kautta)
