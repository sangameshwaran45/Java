import java.util.Scanner;
public class WordEncryption {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.printf("Enter the word : ");
        String input1 = s.nextLine();
        System.out.printf("Enter the number : ");
        int input2 = s.nextInt();
        System.out.println("Encrypted words: " + encryptWords(input1, input2));
    }

    public static String encryptWords(String input1, int input2) {
        String[] words = input1.split(" ");
        StringBuilder encryptedWords = new StringBuilder();

        for (String word : words) {
            StringBuilder encryptedWord = new StringBuilder();

            for (char c : word.toCharArray()) {
                char encryptedChar = encryptCharacter(c, input2);
                encryptedWord.append(encryptedChar);
            }

            encryptedWords.append(encryptedWord).append(" ");
        }

        return encryptedWords.toString().trim();
    }

    public static char encryptCharacter(char c, int keyValue) {
        int charValue = Character.isUpperCase(c) ? c - 'A' : c - 'a';
        int encryptedValue = (charValue + keyValue) % 26;

        if (Character.isUpperCase(c)) {
            return Character.toLowerCase((char) (encryptedValue + 'A'));
        } else {
            return Character.toUpperCase((char) (encryptedValue + 'a'));
        }
    }
}