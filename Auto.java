public class Auto extends Fahrzeug {
     int lastServiceKm;
    protected boolean istVermietet = false;

    public Auto(String marke, String modell, int kmStand) {
        super(marke, modell, kmStand);
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
    public boolean servicenoetig() {
    return(this.kmStand - this.lastServiceKm) >=15000;
        }

    public boolean serviceDurchfueren(){
        if (servicenoetig()){
            this .lastServiceKm = this.kmStand;
            System.out.println("Service wurde durchgeführt");
            return true;
        }else {
            System.out.println("Kein Service erforderlich.");
            return false;
        }
    }
    @Override
    public String toString(){
        String status = istVermietet ? "Vermietet" : "Verfügbar";
        String serviceHinweis = servicenoetig() ?" SERVICE NÖTIG!" : "";

        return marke +" " + modell + " | KM: " + kmStand + " | Status: " + status + serviceHinweis;
    }
    public String toCsvString() {
        return marke + ";" + modell + ";" + kmStand + ";" + lastServiceKm + ";" + istVermietet;
    }
}
