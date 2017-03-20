package gibb.javamodul.minesweeper;

/**
 * Diese Klasse ist für alle Textausgaben auf der Konsole verantwortlich.
 *
 * Created by Robin Berberat on 18.03.2017.
 */
public class Textausgaben {
    private String output;

    void zeigeSpielfeld(Spielfeld spielfeld){
        int breite = spielfeld.getSpielfeld().length;
        int laenge = spielfeld.getSpielfeld().length;

        System.out.print("    ");
        for (int spalte = 0; spalte < breite; spalte++) {
            System.out.print(" "+spalte);
        }
        System.out.println("");
        for (int zeile = 0; zeile < laenge; zeile++) {

            if(zeile > 9){
            System.out.print(zeile+" |");
            } else if(zeile > 99){
                System.out.print(zeile+"|");
            }else{
            System.out.print(zeile+"  |");
            }


            for (int spalte = 0; spalte < breite; spalte++) {
                if(spielfeld.istZelleMarkiert(spalte,zeile)){
                    System.out.print(" M");
                }else if(spielfeld.istZelleAufgedeckt(spalte,zeile)){
                    if(spielfeld.istZelleBombe(spalte,zeile)){
                        System.out.print(" B");
                    }else{
                        System.out.print(" "+spielfeld.anzahlBombigeNachbarnEinerZelle(spalte,zeile));
                    }
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        System.out.println();
    }

    void zeigeEingabeaufforderung(){
        output = "Geben sie nun ihren Eingabefehl ein: ";
        System.out.print(output);
    }

    void zeigeFehlermeldung(){
        output = "Der von ihnen eingegebene Befehl ist ungültig.";
        System.out.println(output);
    }

    void zeigeSchlussmeldung(){
        output = "Vielen Dank dass sie Minesweeper gespielt haben.";
        System.out.println(output);
    }

}
