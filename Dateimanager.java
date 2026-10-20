import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Dateimanager implements Speicherbar {
    
    @Override 
    public void speichern(String dateiname, ArrayList<Auto> autos){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dateiname))) {
            for (Auto auto : autos) {
                writer.write(auto.toCsvString());

                writer.newLine();
            }
            System.out.println("Erfolgreich gespeichert");
        }catch (IOException e){
            System.out.println("Fehler beim Speichern: " + e.getMessage());
        }
    }

    @Override 
    public ArrayList<Auto>  laden(String dateiname){
       ArrayList<Auto> geladeneAutos = new ArrayList<>();

try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
    String zeile;

    // readLine() liest eine Zeile. Wenn am Ende der Datei nichts mehr kommt, gibt es null zurück.
    while ((zeile = reader.readLine()) != null) {
        
        // 1. Die Zeile z. B. "VW;Golf;50000;40000;false" am Semikolon trennen
        String[] teile = zeile.split(";");

        // teile[0] ist "VW"
        // teile[1] ist "Golf"
        // teile[2] ist "50000" (Achtung: Ist noch ein Text/String!)
        
        // 2. Texte in passende Datentypen umwandeln:
        String marke = teile[0];
        String modell = teile[1];
        int kmStand = Integer.parseInt(teile[2]);          // Macht aus "50000" die Zahl 50000
        int lastServiceKm = Integer.parseInt(teile[3]);    // Macht aus "40000" die Zahl 40000
        boolean istVermietet = Boolean.parseBoolean(teile[4]); // Macht aus "false" das boolean false

        // 3. Auto-Objekt mit deinem 2. Konstruktor neu erstellen
        Auto geladenesAuto = new Auto(marke, modell, kmStand, lastServiceKm, istVermietet);

        // 4. Zur Liste hinzufügen
        geladeneAutos.add(geladenesAuto);
    }
} catch (IOException e) {
    System.out.println("Fehler beim Laden: " + e.getMessage());
}

return geladeneAutos;

    }
}
