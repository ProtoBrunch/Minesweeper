package gibb.javamodul.minesweeper;

/**
 * Die Hauptklasse von Minesweeper.
 * Diese Klasse initiiert das Spiel und handhabt dessen Ablauf.
 *
 * Created by Robin Berberat on 18.03.2017.
 */
public class Minesweeper {
    static Textausgaben textausgaben = new Textausgaben();
    private Benutzereingaben benutzereingaben = new Benutzereingaben();

    private Minesweeper(){
        while(true){
        Spielfeld spielfeld = new Spielfeld();
        textausgaben.zeigeSpielfeld(spielfeld);
        boolean playing = true;
        while(playing) {
            textausgaben.zeigeEingabeaufforderung();
            String[] eingaben = benutzereingaben.kommandoEingabe(spielfeld);
            Kommando kommando = new Kommando(eingaben);
            playing = kommando.ausfuehren(spielfeld);
            textausgaben.zeigeSpielfeld(spielfeld);
        }
        textausgaben.zeigeSchlussmeldung();
        }

    }

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
    }
}
