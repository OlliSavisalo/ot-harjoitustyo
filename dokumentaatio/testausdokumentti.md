# Testausdokumentti

Ohjelmaa on testattu yksikkötestein JUnitilla.

## Yksikkötestaus

Suurin osa testeistä on suoritettu solitaire.domain-pakkauksessa olevalle Table-luokalle, joka sisältää lähestulkoon koko sovelluksen logiikan.
Solitaire.dao-paketissa oleville luokille on tehty kohtuullisen vähän testejä, koska ne ovat ainoastaan tiedon tallentamista varten. Sen vuoksi ne ovat aika pieniä luokkia eivätkä sisällä testattavia metodeja juurikaan.
Käyttöliittymän sisältävät luokat ollaan jätetty yksikkötesteistä kokonaan pois.

## Testauskattavuus

Sovelluksen testauskattavuus pois lukien käyttöliittymän luokat:
Rivikattavuus 91%
Haarautumakattavuus 78%

<img src="https://github.com/OlliSavisalo/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Solitaire_Jacoco.png">

## Sovellukseen jääneet laatuongelmat
Sovellus antaa tällä hetkellä virheen seuraavissa tapauksissa:
-Käyttäjä syöttää tekstin numeron sijaan
-Mikäli tietokannan sisältävä tiedosto toplist.db on olemassa jo kansiossa, tulee SQLError
