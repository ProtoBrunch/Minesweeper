package gibb.javamodul.minesweeper;

/**
 * Created by Robin Berberat on 18.03.2017.
 */
public class Minesweeper {
    static Textausgaben textausgaben = new Textausgaben();
    private static Benutzereingaben benutzereingaben = new Benutzereingaben();

    private Minesweeper(){
        while(true){
        Spielfeld spielfeld = new Spielfeld();
        textausgaben.zeigeSpielfeld(spielfeld.getSpielfeld());
        boolean playing = true;
        while(playing) {
            textausgaben.zeigeEingabeaufforderung();
            String[] eingaben = benutzereingaben.kommandoEingabe(spielfeld);
            Kommando kommando = new Kommando(eingaben);
            playing = kommando.ausfuehren(spielfeld);
            textausgaben.zeigeSpielfeld(spielfeld.getSpielfeld());
        }
        textausgaben.zeigeSchlussmeldung();
        }

    }

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
    }
}
