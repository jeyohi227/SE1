package exercises.uebung8;

public class ReiseAnbieterAdapter implements HotelSucheInterface {

    private Reiseanbieter system;

    private QueryObject transformIN( SuchAuftrag sa ) {
        // SuchAuftrag --transformiert--> QueryObject
        return null;
    }
    private SuchErgebnis transformOUT( QueryResult qr ) {
        // QueryResult --transformiert--> SuchErgebnis
        return null;
    }

    public SuchErgebnis suche(SuchAuftrag sa) {
        QueryObject q = this.transformIN(sa);
        QueryResult r = this.system.executeQuery(q);
        SuchErgebnis se = this.transformOUT(r);
        return se;
    }
}
