# Olli Savisalo, Ohjelmistotekniikka syksy 2020

## Harjoitustyö, Solitaire

Sovellus on perinteinen korttipeli Pasianssi (tarkemmin Klondike-pasianssi), jossa käyttäjä pyrkii pinoamaan kortit maittain järjestyksessä 1:stä 13:sta.
Pelin viimeisimmässä versiossa on käytössä tekstiliittymä, joka kysyy korttien siirrot tekstimuodossa ja ottaa komennot vastaan luvuilla 0-12.

### Releaset

[Solitaire, viikko 7. Loppupalautus](https://github.com/OlliSavisalo/ot-harjoitustyo/releases/tag/viikko7)

[Solitaire, viikko 6](https://github.com/OlliSavisalo/ot-harjoitustyo/releases/tag/viikko6)

[Solitaire, viikko 5](https://github.com/OlliSavisalo/ot-harjoitustyo/releases/tag/viikko5)

### Dokumentaatio

[Arkkitehtuurikuvaus](https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Testausdokumentti](https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

### Komentorivitoiminnot

#### Testaus
Testit suoritetaan komennolla
```
mvn test
```
Testikattavuusraportti luodaan komennolla
```
mvn jacoco:report
```
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html
[Viimeisin testiraportti](https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Solitaire_Jacoco.png)

#### Suoritettavan Jar:n generointi
Komento
```
mvn package
```

#### JavaDoc
JavaDoc generoidaan komennolla
```
mvn javadoc:javadoc
```

#### Checkstyle
Tiedostoon [checkstyle.xml](https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Solitaire_Checkstyle.png) määrittelemät tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
