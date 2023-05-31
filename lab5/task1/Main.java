package task1;
/**
 * This class represents the main entry point of the program.
 * It expects a password input as a command-line argument and checks its validity.
 */


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Main {
    public Main() {
    }

    /**
     * The main method of the program.
     *
     * @param var0 The command-line arguments passed to the program.
     */
    public static void main(String[] var0) {

        if (var0.length != 1) {
            System.out.println("Wrong password!");                                                    // Program wymaga podania pojedynczego argumentu. Argument ten jest następnie sprawdzany, czy jest hasłem.
        } else {
            String var1 = var0[0];                                                                    // Argument jest przypisywany do zmiennej var1.
            String[] var2 = var1.split("_");                                                    // Var1 jest dzielony na stringi, które są przypisywane do tablicy Stringów var2.
            Date var3 = Date.from(Instant.now());                                                     // Pobierana jest aktualna data przypisywana do zmiennej var3.
            SimpleDateFormat var4 = new SimpleDateFormat("yyyy");                              // Do zmiennej var4 przypisywany jest obiekt SimpleDateFormat. Format daty jest ustawiany na rok.
            String var5 = var4.format(var3);                                                          // Do zmiennej var5 przypisywany jest rok z var3.
            int var6 = Integer.parseInt(var5);                                                        // Zmiennej var6 przypisywana jest wartość var5 (2023) jako int.
            if (var2[0].length() == 6 && var2[1].length() == 4) {                                     // Jeśli długość pierwszego stringa z tablicy var2 jest równa 6 i długość drugiego stringa z tablicy var2 jest równa 4, to:
                if (var2[0].equals(Coder.code("3mT7N2")) && Integer.parseInt(var2[1]) == var6) { // Jeśli pierwszy string z tablicy var2 jest równy wynikowi metody code z klasy Coder, a drugi string z tablicy var2 jest równy var6 (obecny rok), to hasło jest poprawne.
                    System.out.println("Good guess");                                                 // Wypisuje "Good guess" jeśli hasło jest poprawne.
                } else {
                    System.out.println("Wrong password!");                                            // Wypisuje "Wrong password!" jeśli hasło jest niepoprawne.
                }
            } else {
                System.out.println("Wrong password!");
            }

        }
    }
}