# Käyttöohje Solitaire

Lataa .jar-tiedosto [Solitaire](https://github.com/OlliSavisalo/ot-harjoitustyo/releases/download/viikko7/Solitaire.jar)

tai vaihtoehtoisesti

Lataa ja pura tiedosto [Solitaire.zip](https://github.com/OlliSavisalo/ot-harjoitustyo/archive/viikko7.zip)

## Ohjelman käynnistys

Jar-tiedoston avaaminen komentorivillä
```
java -jar Solitaire.jar

```

Toistaiseksi ohjelma on pelkästään tekstimuodossa oleva peli ja sen voi käynnistää Netbeansissa tai komentorivillä komennolla:
```
java Paaohjelma.java
```

### Käynnistyksen mahdolliset virheet

Viimeisessä versiossa ohjelmaan lisätty tietokanta, johon tallennetaan läpipäässeiden pelien pelaajan nimi, pelin kesto sekä tehtyjen siirtojen määrä. Ohjelman alussa tämä tietokanta alustetaan, sekä lisätään muutama rivi, jotta voimme testata tietokannan toimivuuden.
Mikäli siis käynnistettäessä tulee SQL-virhe, pitää kansiosta poistaa toplist.db-tiedosto.

## Ohjelman kulku

Aluksi ohjelmassa tulee näkyviin "päävalikko", josta käyttäjä voi valita uuden pelin, top-listojen katsomisen tai pelistä poistumisen.

#### Päävalikko
<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Mainmenu.PNG">

### Uusi peli
Ensimmäinen kortti joka näkyy, on "käsipakka".
Tämän kortin oikealla puolella näkyy aluksi tyhjät paikat ja niihin kohdille pinottavat maat.
Alla 7 eri pinoa kortteja, joita voidaan siirrellä.
Ohjelma kysyy haluttavat toimenpiteet pelin kulkiessa eteenpäin. Mikäli pöydän pakoissa on mahdollista siirtää useampaa korttia, on tämäkin otettu huomioon ja pöytä tarkistaa monta haluaa siirtää jos mahdollista.
Valinta 0 keskeyttää pelin ja palauttaa käyttäjän päävalikkoon.

#### Siirto
<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/siirto.PNG">

#### Pelin loppu
Alla olevassa kuvassa käyttäjä on itse lopettanut pelin ja saa tiedon tehdyistä siirroista ja pelin kestosta. Mikäli peli olisi mennyt läpi, olisi ohjelma kysynyt käyttäjän nimimerkkiä ja lisännyt suorituksen suorituslistaan.

<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/loppupeli.PNG">

### Top-listat

Käyttäjä voi valita kumpaa listaa haluaa tulostettavan, joko aikajärjestyksessä tai tehtyjen siirtojen mukaan. Listat ovat aina pienimmästä suurimpaan.


#### Suorituslistat
<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/toplist.PNG">
