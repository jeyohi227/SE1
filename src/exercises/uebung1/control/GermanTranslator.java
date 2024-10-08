package exercises.uebung1.control;

public class GermanTranslator implements Translator {

	public String date = "Okt/2024"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]
		/*
		 * Erstellen ein Array mit den Namen, und können so in O(1) Laufzeit die gewünschte Ausgabe erzielen
		 * wirft eine Exception zurück, wenn die übergebene Nummer >10 oder <1 ist
		 */
		if(number > 10 || number < 1)
			throw new IllegalArgumentException("Uebersetzung der Zahl " + number + " nicht moeglich (" + Translator.version + ")");

		String[] name = {"eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun","zehn"};

		return name[number-1];
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2024"))
	 * Das Datum sollte system-intern durch eine Factory-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
