package exercises.uebung8;

public class HotelSuche {
    void main() {
        SuchAuftrag sa = new SuchAuftrag();
        HotelSucheInterface system = new ReiseAnbieterAdapter();
        SuchErgebnis se = system.suche(sa);
    }
}
