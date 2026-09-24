import java.util.ArrayList;
import java.util.Scanner;

public class Garage {
    ArrayList<Auto> autoList;

    public Garage(){
        this.autoList = new ArrayList<>();
    }
    public void autoHinzufuegen(Auto auto){
        autoList.add(auto);
    }
    public void alleAutosAnzeigen(){
        if (autoList.isEmpty()){
            System.out.println("Die Garage ist aktuell leer.");
        }else {
            System.out.println("--Autos in der Garage--");
            for (int i = 0; i < autoList.size(); i++){
                System.out.println((i + 1) + ". " + autoList.get(i));
            }
        }
    }
    public Auto getAutoPosition(int index){
        if (index >= 0 && index < autoList.size()){
            return autoList.get(index);
        }else {
            System.out.println("Ungültige Position!");
            return null;
        }
    }
    public ArrayList<Auto> getAutoList(){
        return autoList;
    }
    public void setAutoList(ArrayList<Auto> autoList){
        this.autoList = autoList;
    }
}