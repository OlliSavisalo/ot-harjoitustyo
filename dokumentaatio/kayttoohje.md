# Käyttöohje Solitaire

Lataa .jar-tiedosto [Solitaire, viikko 5](https://github.com/OlliSavisalo/ot-harjoitustyo/releases/tag/viikko5)

tai vaihtoehtoisesti

Lataa ja pura tiedosto [Solitaire.zip](https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/Solitaire.zip)

## Ohjelman käynnistys

Jar-tiedoston avaaminen komentorivillä
```
java -jar Solitaire.jar

```

Toistaiseksi ohjelma on pelkästään tekstimuodossa oleva peli, joten ohjelman voi käynnistää Netbeansissa tai terminaalissa komennolla:
```
java Paaohjelma.java
```

## Ohjelman kulku
Ensimmäinen kortti joka näkyy, on "käsipakka".
Tämän kortin oikealla puolella näkyy aluksi tyhjät paikat ja niihin kohdille pinottavat maat.
Alla 7 eri pinoa kortteja, joita voidaan siirrellä.
Ohjelma kysyy haluttavat toimenpiteet pelin kulkiessa eteenpäin. Mikäli pöydän pakoissa on mahdollista siirtää useampaa korttia, on tämäkin otettu huomioon ja pöytä tarkistaa monta haluaa siirtää jos mahdollista.
