package gibb.javamodul.minesweeper;

import java.util.concurrent.ThreadLocalRandom;
import static gibb.javamodul.minesweeper.Minesweeper.textausgaben;

/**
 * Created by Robin Berberat on 18.03.2017.
 */
public class Spielfeld {


    private Zelle[][] spielfeld;
    private int breite, laenge, anzahlBombenImFeld;

    Spielfeld(int breite, int laenge, int anzahlBomben){
        this.breite = breite;
        this.laenge = laenge;
        this.anzahlBombenImFeld = anzahlBomben;

        this.spielfeldErstellung(breite,laenge,anzahlBomben);
    }

    Spielfeld(){
        breite = 10;
        laenge = 10;
        anzahlBombenImFeld = 8;

        this.spielfeldErstellung(breite,laenge,anzahlBombenImFeld);
    }

    private void spielfeldErstellung(int breite, int laenge, int anzahlBomben){
        this.spielfeldeInitialisierung();
        this.legeBomben(anzahlBomben);
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

    private boolean prüfeObKoordinatenLegal(int xKoordinate, int yKoordinate){
        if(xKoordinate < 0 || xKoordinate >= breite || yKoordinate < 0 || yKoordinate >= laenge){
            return false;
        }
        else{
            return true;
        }
    }

    private void alarmiereNachbarschaft(int xKoordinate, int yKoordinate){
        int[] xKoordinaten = {xKoordinate-1,xKoordinate,xKoordinate+1};
        int[] yKoordinaten = {yKoordinate-1,yKoordinate,yKoordinate+1};

        for (int ordinate: xKoordinaten) {
            for (int abszisse : yKoordinaten) {
                if(this.prüfeObKoordinatenLegal(ordinate,abszisse)){
                    spielfeld[ordinate][abszisse].alarmiereNachbarIstBombe();
                }
            }
        }
    }

    public boolean markieren(int x, int y){
        spielfeld[x][y].invertiereIstMarkiert();
        textausgaben.zeigeSpielfeld(spielfeld);
        return true;
    }

    public boolean aufdecken(int x , int y){
        if(spielfeld[x][y].getIstMarkiert()){
            return true;
        }

        spielfeld[x][y].zelleAufdecken();
        if(spielfeld[x][y].getIstBombe()){
            return false;
        }

        if(spielfeld[x][y].hatNachbarn()){
            return true;
        }else{
            this.nachbarschaftAufdecken(x,y);
        }
        return true;
    }

    private void nachbarschaftAufdecken(int xKoordinate, int yKoordinate){
        int[] xKoordinaten = {xKoordinate-1,xKoordinate,xKoordinate+1};
        int[] yKoordinaten = {yKoordinate-1,yKoordinate,yKoordinate+1};

        for (int ordinate: xKoordinaten) {
            for (int abszisse : yKoordinaten) {
                if(this.prüfeObKoordinatenLegal(ordinate,abszisse)){
                    if(!(spielfeld[ordinate][abszisse].getIstAufgedeckt() || spielfeld[ordinate][abszisse].getIstMarkiert())){
                        this.aufdecken(ordinate,abszisse);
                    }
                }
            }
        }
    }




    public int getBreite(){
        return breite;
    }

    public int getLaenge() {
        return laenge;
    }

    public Zelle[][] getSpielfeld() {
        return spielfeld;
    }
}
