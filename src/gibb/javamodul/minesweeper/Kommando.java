package gibb.javamodul.minesweeper;

/**
 * Created by Robin Berberat on 19.03.2017.
 */
public class Kommando {
    private String kommandoZeichen;
    private int xKoordinate;
    private int yKoordinate;

    public Kommando(String[] stringArray) {
        this.kommandoZeichen = stringArray[0];
        this.xKoordinate = Integer.parseInt(stringArray[1]);
        this.yKoordinate = Integer.parseInt(stringArray[2]);
    }

    public boolean ausfuehren(Spielfeld spielfeld) {
        switch (kommandoZeichen) {
            case "M":
                return spielfeld.markieren(xKoordinate, yKoordinate);
            case "T":
                return spielfeld.aufdecken(xKoordinate, yKoordinate);
            case "t":
                return spielfeld.aufdecken(xKoordinate,yKoordinate);
            case "m":
                return spielfeld.markieren(xKoordinate,yKoordinate);
            default:
                return false;
        }
    }

}

