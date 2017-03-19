package gibb.javamodul.minesweeper;

/**
 * Created by Robin Berberat on 18.03.2017.
 */
public class Textausgaben {
    private String output;

    void zuVieleBomben(){

    }

    void neueAnzahlBomben(int anzahlBomben){

    }

    void zeigeSpielfeld(Zelle[][] spielfeld){
        int breite = spielfeld.length;
        int laenge = spielfeld[0].length;


        System.out.print(" ");
        for (int spalte = 0; spalte < breite; spalte++) {
            System.out.print(" "+spalte);
        }
        System.out.println("");
        for (int zeile = 0; zeile < laenge; zeile++) {
            System.out.print(zeile);
            for (int spalte = 0; spalte < breite; spalte++) {
                if(spielfeld[spalte][zeile].getIstMarkiert()){
                    System.out.print(" M");
                }else if(spielfeld[spalte][zeile].getIstAufgedeckt()){
                    if(spielfeld[spalte][zeile].getIstBombe()){
                        System.out.print(" B");
                    }else{
                        System.out.print(" "+spielfeld[spalte][zeile].getAnzahlBombenAlsNachbarn());
                    }
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println();
    }

    void zeigeEingabeaufforderung(){

    }

    void zeigeFehlermeldung(){

    }

    void zeigeSchlussmeldung(){

    }

    void kommandoEingabeUngueltig(){
        System.out.println("Invalid command!");
    }


}
