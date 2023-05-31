package task0;

/**
 * This class demonstrates string concatenation using different approaches in order to analyze deasembled code.
 * Author: Bartłomiej Dmitruk
 * Date: 1.06.2023
 */
public class StringConcat {

    /**
     * The main method that executes the program.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        String varA = "";
        String varB = "";

        System.out.println("varA = " + concatV1(varA));
        System.out.println("varB = " + concatV2(varB));
    }

    /**
     * Concatenates strings using the += operator.
     *
     * @param var The initial string.
     * @return The concatenated string.
     */
    public static String concatV1(String var) {
        for (int i = 0; i < 26; i++) {
            var += (char) ('a' + i);
        }

        return var;
    }

    /**
     * Concatenates strings using the StringBuilder class.
     *
     * @param var The initial string.
     * @return The concatenated string.
     */
    public static String concatV2(String var) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            sb.append((char) ('a' + i));
        }

        return sb.toString();
    }

}
