public class Fahrzeug {
   protected String marke;
    protected String modell;
    protected double kmStand;

    public  Fahrzeug(){
       this.marke = marke;
       this.modell = modell;
       this.kmStand = kmStand;
    }
    public double getKmStand(){
        return kmStand;
    }
    public void setKmStand(double kmStand){
        this.kmStand = kmStand;
    }
}
