public class Auto {
    String marke;
    String modell;
    int kmStand;
    int letzterServiceKm;
    boolean istVermietet = false;

    public Auto(String marke, String modell, int kmStand ){
        this.marke = marke;
        this.modell = modell;
        this.kmStand = kmStand;
        this.letzterServiceKm = kmStand;
    }


@Override 
public String toString() { // Gibt es als String aus
    return marke + " " + modell + " (KM: " + kmStand + " km, Vermietet: " + istVermietet + ")";
}
}
