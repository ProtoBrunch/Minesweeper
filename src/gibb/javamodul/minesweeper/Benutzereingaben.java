package gibb.javamodul.minesweeper;

import java.util.Scanner;

/**
 * Diese Klasse ist für alle Verarbeitungen von Konsoleneingaben im Programm verantwortlich.
 * Wenn vorgegeben, gibt diese Klasse die Eingaben weiter an eine verantwortliche Methode innerhalb der "Validieren"-Klasse.
 *
 * Created by Robin Berberat on 18.03.2017.
 */
class Benutzereingaben {
    private Scanner scanner = new Scanner(System.in);
    private String userEingabe;
    private String[] eingabenArray;
    private Validierung validierung = new Validierung();
    private boolean eingabeValid;

    String[] kommandoEingabe(Spielfeld spielfeld){
        userEingabe = scanner.nextLine();
        eingabenArray = userEingabe.split(" ");
        eingabeValid = validierung.kommandoValidierung(eingabenArray, spielfeld);
        while(!eingabeValid){
            userEingabe = scanner.nextLine();
            eingabenArray = userEingabe.split(" ");
            eingabeValid = validierung.kommandoValidierung(eingabenArray,spielfeld);
        }
        return eingabenArray;
    }




}
