package gibb.javamodul.minesweeper;

import java.util.concurrent.ThreadLocalRandom;
import static gibb.javamodul.minesweeper.Minesweeper.textausgaben;

/**
 * Diese Klasse ist für die Handhabung des Spielfelds verantwortlich.
 * Sie erstellt, wenn aufgerufen, das Spielfeld und handhabt die Befehle zur Markierung und Aufdeckung der einzelnen Zellen.
 *
 * Spielfeld hat ein zwei-dimensionales Zelle-Array "spielfeld" und drei Int werte "breite, laenge anzahlBombenImFeld"
 * Spielfeld kennt die Zustände der einzelnen Zellen des Zelle[][]-arrays und kann diese weitergeben.
 *
 *
 * Created by Robin Berberat on 18.03.2017.
 */
public class Spielfeld {
    private Zelle[][] spielfeld;
    private int breite, laenge, anzahlBombenImFeld;


    Spielfeld(int breite, int laenge, int anzahlBomben){
        this.breite = breite;
        this.laenge = laenge;
        this.anzahlBombenImFeld = anzahlBomben;

        this.spielfeldErstellung();
    }

    Spielfeld(){
        breite = 10;
        laenge = 10;
        anzahlBombenImFeld = 10;

        this.spielfeldErstellung();
    }

    private void spielfeldErstellung(){
        spielfeldeInitialisierung();
        legeBomben(anzahlBombenImFeld);
    }

    private void spielfeldeInitialisierung(){
        spielfeld = new Zelle[breite][laenge];
        for (int xKoordinate = 0; xKoordinate < breite; xKoordinate++) {
            for (int yKoordinate = 0; yKoordinate < laenge; yKoordinate++) {
                spielfeld[xKoordinate][yKoordinate] = new Zelle();
            }
        }
    }

    private void legeBomben(int anzahlBombenZuLegen){
        int xKoordinate, yKoordinate;
        for (int anzahlBombenGelegt = 0; anzahlBombenGelegt < anzahlBombenZuLegen;) {
            xKoordinate = ThreadLocalRandom.current().nextInt(0, breite);
            yKoordinate = ThreadLocalRandom.current().nextInt(0, laenge);
            if(spielfeld[xKoordinate][yKoordinate].legeBombe()){
                alarmiereNachbarschaft(xKoordinate,yKoordinate);
                anzahlBombenGelegt++;
            }
        }
    }

    private void alarmiereNachbarschaft(int xKoordinate, int yKoordinate){
        int[] xKoordinaten = {xKoordinate-1,xKoordinate,xKoordinate+1};
        int[] yKoordinaten = {yKoordinate-1,yKoordinate,yKoordinate+1};

        for (int ordinate: xKoordinaten) {
            for (int abszisse : yKoordinaten) {
                if(prüfeObKoordinatenLegal(ordinate,abszisse)){
                    spielfeld[ordinate][abszisse].alarmiereNachbarIstBombe();
                }
            }
        }
    }

    public boolean markiereZelle(int xKoordinate, int yKoordinate){
        spielfeld[xKoordinate][yKoordinate].invertiereIstMarkiert();
        textausgaben.zeigeSpielfeld(this);
        return true;
    }

    public boolean deckeZelleAuf(int xKoordinate , int yKoordinate){
        if(spielfeld[xKoordinate][yKoordinate].getIstMarkiert()){
            return true;
        }

        spielfeld[xKoordinate][yKoordinate].zelleAufdecken();
        if(spielfeld[xKoordinate][yKoordinate].getIstBombe()){
            return false;
        }

        if(spielfeld[xKoordinate][yKoordinate].hatNachbarn()){
            return true;
        }else{
            nachbarschaftAufdecken(xKoordinate,yKoordinate);
        }
        return true;
    }

    private void nachbarschaftAufdecken(int xKoordinate, int yKoordinate){
        int[] xKoordinaten = {xKoordinate-1,xKoordinate,xKoordinate+1};
        int[] yKoordinaten = {yKoordinate-1,yKoordinate,yKoordinate+1};

        for (int ordinate: xKoordinaten) {
            for (int abszisse : yKoordinaten) {
                if(prüfeObKoordinatenLegal(ordinate,abszisse)){
                    if(!(spielfeld[ordinate][abszisse].getIstAufgedeckt() || spielfeld[ordinate][abszisse].getIstMarkiert())){
                        deckeZelleAuf(ordinate,abszisse);
                    }
                }
            }
        }
    }

    private boolean prüfeObKoordinatenLegal(int xKoordinate, int yKoordinate){
        if(xKoordinate < 0 || xKoordinate >= breite || yKoordinate < 0 || yKoordinate >= laenge){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean istZelleAufgedeckt(int xKoordinate, int yKoordinate){
        return spielfeld[xKoordinate][yKoordinate].getIstAufgedeckt();
    }

    public boolean istZelleMarkiert(int xKoordinate, int yKoordinate){
        return spielfeld[xKoordinate][yKoordinate].getIstMarkiert();
    }

    public boolean istZelleBombe(int xKoordinate, int yKoordinate){
        return spielfeld[xKoordinate][yKoordinate].getIstBombe();
    }

    public int anzahlBombigeNachbarnEinerZelle(int xKoordinate, int yKoordinate){
        return spielfeld[xKoordinate][yKoordinate].getAnzahlBombenAlsNachbarn();
    }

    public Zelle[][] getSpielfeld() {
        return spielfeld;
    }
}
