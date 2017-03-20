package gibb.javamodul.minesweeper;

/**
 * Diese Klasse bildet die einzelnen Zellen im Spielfeld.
 * Sie ist dafür verwantwortlich, die verschiedenen möglichen Zustände einer Zelle im Spielfeld zu kennen und diese mit den gegebenen Methoden verändern zu lassen.
 *
 *
 *
 * Created by Robin Berberat on 18.03.2017.
 */
public class Zelle {
    private boolean istBombe = false;
    private boolean istMarkiert = false;
    private boolean istAufgedeckt = false;
    private int anzahlBombenAlsNachbarn = 0;

    boolean legeBombe(){
        if(istBombe){
            return false;
        }
        istBombe = true;
        return true;
    }

    void alarmiereNachbarIstBombe(){anzahlBombenAlsNachbarn++;}

    void invertiereIstMarkiert(){
        istMarkiert = !istMarkiert;
    }

    void zelleAufdecken(){
        istAufgedeckt = true;
    }

    boolean hatNachbarn(){
        if(anzahlBombenAlsNachbarn > 0){
            return true;
        }else{
            return false;
        }
    }

    int getAnzahlBombenAlsNachbarn(){
        return anzahlBombenAlsNachbarn;
    }

    boolean getIstBombe(){
        return istBombe;
    }

    boolean getIstAufgedeckt(){return istAufgedeckt;}

    public boolean getIstMarkiert() {
        return istMarkiert;
    }
}
