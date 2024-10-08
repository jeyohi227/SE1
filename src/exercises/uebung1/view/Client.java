package exercises.uebung1.view;


import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;
import org.hbrs.se1.ws24.exercises.uebung1.factories.TranslatorFactory;

public class Client {

		/**
		 * Methode zur Ausgabe einer Zahl auf der Console
		 * (auch bezeichnet als CLI, Terminal)
		 *
		 */
		private String terminal;

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

