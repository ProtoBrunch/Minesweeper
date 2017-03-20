package gibb.javamodul.minesweeper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static gibb.javamodul.minesweeper.Minesweeper.textausgaben;


/**
 * Diese Klasse handhabt die Validierung der Konsoleneingaben, welche sie von der "Benutzeringaben"-Klasse erhält.
 * Jede Methode dieser Klasse sollte ausschliesslich Boolean werte zurückgeben.
 *
 * Created by Robin Berberat on 18.03.2017.
 */
public class Validierung {

    boolean kommandoValidierung(String[] kommando, Spielfeld spielfeld) {

        int spielFeldbreite = spielfeld.getSpielfeld().length;
        int spielfeldLaenge = spielfeld.getSpielfeld()[0].length;
        Pattern pattern = Pattern.compile("([MmTt])");
        Matcher matcher = pattern.matcher(kommando[0]);

        if (kommando.length != 3) {
            textausgaben.zeigeFehlermeldung();
            return false;
        }

        if (kommando[0].length() != 1){
            textausgaben.zeigeFehlermeldung();
            return false;
        }

        if (!matcher.find()){
            textausgaben.zeigeFehlermeldung();
            return false;
        }

        if (!tryParseInt(kommando[1]) ||  !tryParseInt(kommando[2])) {
            textausgaben.zeigeFehlermeldung();
            return false;
        }

        int xKoordinate = Integer.parseInt(kommando[1]);
        int yKoordinate = Integer.parseInt(kommando[2]);

        if (xKoordinate < 0 || yKoordinate < 0 || xKoordinate >= spielFeldbreite || yKoordinate >= spielfeldLaenge) {
            textausgaben.zeigeFehlermeldung();
            return false;
        }
        return true;
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
