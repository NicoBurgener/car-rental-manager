public class Auto extends Fahrzeug {
     int lastServiceKm;
    protected boolean istVermietet = false;

    public Auto(String marke, String modell, int kmStand) {
        super.marke = marke;
        super.modell = modell;
        super.kmStand = kmStand;
        this.lastServiceKm = kmStand;
    }
    public boolean mieten(){
        if(!istVermietet){
            istVermietet = true;
            return true;
        }else {
            return false;
        }
    }
    public void zurueckgeben(int gefahrenKm){
        this.istVermietet = false;
        this.kmStand= this.kmStand + gefahrenKm;
    }
    public boolean servicenoetig(){
        if ((this.kmStand - this.lastServiceKm) >= 15000){
            return false;
        }else {
            return true;
        }
    }
    public boolean serviceDurchfueren(){
        if (servicenoetig()){
            this .lastServiceKm = (int) this.kmStand;
            System.out.println("Service wurde durchgeführt");
            return true;
        }else {
            System.out.println("Kein Service erforderlich.");
            return false;
        }
    }

}
