package exercises.uebung1.view;


import exercises.uebung1.control.Translator;
import exercises.uebung1.factories.TranslatorFactory;

public class Client {

		/**
		 * Methode zur Ausgabe einer Zahl auf der Console
		 * (auch bezeichnet als CLI, Terminal)
		 *
		 */
		private String terminal;

		private Translator translator;

		public void setTranslator(Translator translator) {
			this.translator = translator;
		}

		 void display( int aNumber ){
			// In dieser Methode soll die Methode translateNumber
			// mit dem übergegebenen Wert der Variable aNumber
			// aufgerufen werden.
			//
			// Strenge Implementierung (nur) gegen das Interface Translator gewuenscht!

			 Translator translator = TranslatorFactory.createGermanTranslator();

			 terminal = translator.translateNumber(aNumber);

			 System.out.println("Das Ergebnis der Berechnung: " +
					terminal );

		 }
}

