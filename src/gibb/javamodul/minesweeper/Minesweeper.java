package gibb.javamodul.minesweeper;

/**
 * Created by Robin Berberat on 18.03.2017.
 */
public class Minesweeper {
    static Textausgaben textausgaben = new Textausgaben();
    static Benutzereingaben benutzereingaben = new Benutzereingaben();

    Minesweeper(){
        Spielfeld spielfeld = new Spielfeld();
        textausgaben.zeigeSpielfeld(spielfeld.getSpielfeld());
        boolean playing = true;
        while(playing) {
            String[] eingaben = benutzereingaben.kommandoEingabe(spielfeld);
            Kommando kommando = new Kommando(eingaben);
            playing = kommando.ausfuehren(spielfeld);
            textausgaben.zeigeSpielfeld(spielfeld.getSpielfeld());
        }

    }

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
    }
}
