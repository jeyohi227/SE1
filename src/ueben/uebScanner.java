package ueben;

import java.util.Random;
import java.util.Scanner;

public class uebScanner {
    static Scanner sc = new Scanner(System.in);

    public static void ausgabeText() {
        String input = "";
        String text = "";
        String antwort = "j";
        System.out.println("Wollen Sie noch mehr eingeben? (j/n)");
        while(antwort.equals("j")) {
            antwort = sc.nextLine();
            input = sc.nextLine();
            text += " " + input;
            System.out.println("eingegebener Text:\n" + text);
        }
        sc.close();
    }

    public static void ausgabeSumme() {
        int summe = 0;
        while(sc.hasNextInt()) {
            int number = sc.nextInt();
            summe += number;
            System.out.println("Summe: " + summe);
        }
        sc.close();
    }

    public static void spiel(String name){
        Random random = new Random();
        int spielerscore = 0;
        int cpu = 0;

        System.out.println("Möchtest du weiter machen? (j/n)");
        String zug = sc.nextLine();
        while (zug.equals("j")){
                int gewuerfelt = random.nextInt(7);
                if(gewuerfelt == 6){
                    System.out.println("Du hast eine 6 gewuerfelt, die CPU gewinnt!\n");
                    sc.close();
                    return;
                }
                spielerscore += gewuerfelt;
                System.out.println("Gewuerfelt: " + gewuerfelt + "\nScore von " + name + ": " + spielerscore + "\n");

                System.out.println("Möchtest du weiter machen? (j/n)");
                zug = sc.nextLine();
            }
        /**
         * CPU am Zug
         */
        int gewuerfeltcpu = 0;
        while(gewuerfeltcpu != 6){
            gewuerfeltcpu = random.nextInt(7);
            if(gewuerfeltcpu != 6) {
                cpu += gewuerfeltcpu;
                System.out.println("CPU wuerfelt: " + gewuerfeltcpu + "\nScore von CPU: " + cpu + "\n");
                if (cpu > spielerscore) {
                    System.out.println("CPU gewinnt!");
                }
            }
        }
        String endstand = "Endstand:\n" + name + ": " + spielerscore + "\t CPU: " + cpu;
        if(spielerscore > cpu){
            System.out.println(endstand + "\n\nDu hast gewonnen!");
        }else if(spielerscore == cpu){
            System.out.println(endstand + "\n\nUnentschieden");
        }else if(cpu > spielerscore){
            System.out.println(endstand + "\n\nDu hast verloren!\n");
        }
    }

    public static void Ratespiel() {
        System.out.println("Such dir eine Zahl zwischen 1-10 aus");
        while(sc.nextLine().equals("j")) {
            System.out.println("Multipliziere deine Zahl mit 9 ");
            while(sc.nextLine().equals("j")){

                System.out.println("Ziehe die Quersumme deiner Zahl");
                System.out.println("gib help ein, falls du nicht weiß was die Quersumme ist");
                if(sc.nextLine().equals("help")) {
                            System.out.println("Quersumme:");
                            System.out.println("Quersumme ist, wenn du deine einzelnen Zahlen zusammenaddierst.\n" +
                                "z.B Deine Zahl=85\t Quersumme=8+5=13\n" +
                                "oder deine Zahl=213\t Quersumme=2+1+3=6\n" +
                                "\tBei einstelligen Zahlen ist die Quersumme identisch");
                            System.out.println("\n Hast du es verstanden?\n");
                        }
                while(sc.nextLine().equals("j")) {
                    System.out.println("Subtrahiere deine Zahl mit 3");
                    while(sc.nextLine().equals("j")){
                        System.out.println("Addiere deine Zahl mit 4");
                        while(sc.nextLine().equals("j")){
                            System.out.println("Subtrahiere deine Zahl mit 10");
                            while(sc.nextLine().equals("j")) {
                                System.out.println("Ist deine Zahl jetzt 0? :-)");
                                while(sc.nextLine().equals("j")){
                                    System.out.println("Sehr gut! ;)");
                                    sc.close();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Ratespiel();
    }
}
