package gibb.javamodul.minesweeper;

/**
 * Diese Klasse verarbeitet die validierten Benutzereingaben und gibt diese an die korrekte Methode in der "Spielfeld"-Klasse weiter.
 *
 * Created by Robin Berberat on 19.03.2017.
 */
public class Kommando {
    private String kommandoZeichen;
    private int xKoordinate;
    private int yKoordinate;

    public Kommando(String[] stringArray) {
        this.kommandoZeichen = stringArray[0].toUpperCase();
        this.xKoordinate = Integer.parseInt(stringArray[1]);
        this.yKoordinate = Integer.parseInt(stringArray[2]);
    }

    public boolean ausfuehren(Spielfeld spielfeld) {
        switch (kommandoZeichen) {
            case "M":
                return spielfeld.markieren(xKoordinate, yKoordinate);
            case "T":
                return spielfeld.aufdecken(xKoordinate, yKoordinate);
            default:
                return false;
        }
    }

}

