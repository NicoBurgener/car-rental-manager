import java.util.ArrayList;

public interface Speicherbar {
     void speichern (String dateiname, ArrayList<Auto>autos);
     ArrayList<Auto> laden (String dateiname);
}
