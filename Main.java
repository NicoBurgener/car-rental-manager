import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Garage garage = new Garage();
        Dateimanager dateimanager = new Dateimanager();
        String dateiname = "autos.txt";

        // Beim Start bisher gespeicherte Daten laden
        garage.setAutoList(dateimanager.laden(dateiname));

        boolean laeuft = true;

        while (laeuft) {
            System.out.println("\n--- GARAGEN-MANAGER ---");
            System.out.println("1. Alle Autos anzeigen");
            System.out.println("2. Neues Auto hinzufügen");
            System.out.println("3. Auto mieten");
            System.out.println("4. Auto zurückgeben");
            System.out.println("5. Service durchführen");
            System.out.println("6. Speichern & Beenden");
            System.out.print("Wähle eine Option: ");

            int wahl = scanner.nextInt();
            scanner.nextLine(); // Puffer-Zeilenumbruch leeren

            switch (wahl) {
                case 1:
                    garage.alleAutosAnzeigen();
                    break;

                case 2:
                    System.out.print("Marke: ");
                    String marke = scanner.nextLine();
                    System.out.print("Modell: ");
                    String modell = scanner.nextLine();
                    System.out.print("KM-Stand: ");
                    int km = scanner.nextInt();

                    garage.autoHinzufuegen(new Auto(marke, modell, km));
                    System.out.println("Auto erfolgreich hinzugefügt!");
                    break;

                case 3:
                    garage.alleAutosAnzeigen();
                    if (!garage.getAutoList().isEmpty()) {
                        System.out.print("Nummer des zu mietenden Autos eingeben: ");
                        int mietIndex = scanner.nextInt() - 1; // -1 wegen 0-basierter Liste
                        Auto mietAuto = garage.getAutoPosition(mietIndex);

                        if (mietAuto != null) {
                            if (mietAuto.mieten()) {
                                System.out.println("Auto wurde erfolgreich gemietet!");
                            } else {
                                System.out.println("Auto ist bereits vermietet!");
                            }
                        }
                    }
                    break;

                case 4:
                    garage.alleAutosAnzeigen();
                    if (!garage.getAutoList().isEmpty()) {
                        System.out.print("Nummer des zurückzugebenden Autos eingeben: ");
                        int rueckIndex = scanner.nextInt() - 1;
                        Auto rueckAuto = garage.getAutoPosition(rueckIndex);

                        if (rueckAuto != null) {
                            System.out.print("Wie viele Kilometer bist du gefahren? ");
                            int gefahrenKm = scanner.nextInt();
                            rueckAuto.zurueckgeben(gefahrenKm);
                            System.out.println("Auto erfolgreich zurückgegeben!");
                        }
                    }
                    break;

                case 5:
                    garage.alleAutosAnzeigen();
                    if (!garage.getAutoList().isEmpty()) {
                        System.out.print("Nummer des Autos für den Service eingeben: ");
                        int serviceIndex = scanner.nextInt() - 1;
                        Auto serviceAuto = garage.getAutoPosition(serviceIndex);

                        if (serviceAuto != null) {
                            serviceAuto.serviceDurchfueren();
                        }
                    }
                    break;

                case 6:
                    // Autos beim Beenden in Datei schreiben
                    dateimanager.speichern(dateiname, garage.getAutoList());
                    System.out.println("Programm wird beendet. Auf Wiedersehen!");
                    laeuft = false;
                    break;

                default:
                    System.out.println("Ungültige Option! Bitte wähle eine Zahl von 1 bis 6.");
            }
        }

        scanner.close();
    }
}