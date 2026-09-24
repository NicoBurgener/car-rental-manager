public class Fahrzeug {
   protected String marke;
    protected String modell;
    protected int kmStand;

    public  Fahrzeug(String marke, String modell, int kmStand){
       this.marke = marke;
       this.modell = modell;
       this.kmStand = kmStand;
    }
    public int getKmStand(){
        return kmStand;
    }
    public void setKmStand(int kmStand){
        this.kmStand = kmStand;
    }
}
