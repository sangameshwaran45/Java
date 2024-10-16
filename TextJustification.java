import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextJustification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the words separated by space:");
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        System.out.println("Enter the maximum width:");
        int maxWidth = scanner.nextInt();
        scanner.close();

        List<String> justifiedText = fullJustify(words, maxWidth);
        System.out.println("Justified Text:");
        for (String line : justifiedText) {
            System.out.println(line);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + totalChars + 1 > maxWidth) break;
                totalChars += words[last].length() + 1;
                last++;
            }
            int gaps = last - index - 1;

            StringBuilder sb = new StringBuilder();
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int extra = (maxWidth - totalChars) % gaps;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + (i - index < extra ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}