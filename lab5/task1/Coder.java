package task1;

/**
 * The Coder class provides a static method to encode a given string by shifting each character's ASCII value by 2.
 * This class is used by the Main class.
 * This class is for analise of
 */
public class Coder {
    /**
     * Encodes the given string by shifting each character's ASCII value by 2.
     *
     * @param var0 The string to be encoded.
     * @return The encoded string.
     */
    static String code(String var0) {
        StringBuilder var1 = new StringBuilder();

        for(int var2 = 0; var2 < var0.length(); ++var2) {      // Iterate over each character in var0
            var1.append((char)(var0.charAt(var2) + 2));        // Append the character after shifting its ASCII value by 2
        }

        return var1.toString();                                // var1 = "5oV9P4" - output for var0 = "3mT7N2"
    }
}
