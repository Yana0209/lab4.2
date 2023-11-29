package org.example;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Decoder {

    // Method to decode vowels using numeric equivalents
    public static String decodeVowels(String encoded) {
        StringBuilder decoded = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            switch (c) {
                case '1':
                    decoded.append('a');
                    break;
                case '2':
                    decoded.append('e');
                    break;
                case '3':
                    decoded.append('i');
                    break;
                case '4':
                    decoded.append('o');
                    break;
                case '5':
                    decoded.append('u');
                    break;
                default:
                    decoded.append(c);
                    break;
            }
        }
        return decoded.toString();
    }

    // Method to decode consonants using specific rules
    public static String decodeConsonants(String encoded) {
        StringBuilder decoded = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            if (Character.isLetter(c)) {
                char newChar = c;
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    if (c == 'a' || c == 'A') {
                        newChar = 'b';
                    } else if (c == 'e' || c == 'E') {
                        newChar = 'f';
                    }
                    else if (c == 'i' || c == 'I') {
                        newChar = 'j';
                    } else if (c == 'o' || c == 'O') {
                        newChar = 'p';
                    } else if (c == 'u' || c == 'U') {
                        newChar = 'v';
                    } else {
                        newChar = (char) (c + 1);
                    }
                    } else {
                    if (c == 'z' || c == 'Z') {
                        newChar = 'b';
                    } else if (c == 'Z') {
                        newChar = 'B';
                    } else if (c == 'd' || c == 'h' || c == 'n' || c == 't' || c == 'D' || c == 'H' || c == 'N' || c == 'T') {
                        newChar = (char) (c + 2);
                    } else {
                        newChar = (char) (c + 1);
                    }
                }
                decoded.append(newChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

    // Method to decode the entire encoded message
    public static String decodeMessage(String encodedMessage) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] words = encodedMessage.split("\\s+");

        for (String word : words) {
            if (word.matches("\\d+")) {
                decodedMessage.append(decodeVowels(word)).append(" ");
            } else {
                decodedMessage.append(decodeConsonants(word)).append(" ");
            }
        }

        return decodedMessage.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the encoded message:");
        String encodedMessage = scanner.nextLine();

        String decodedMessage = decodeMessage(encodedMessage);

        System.out.println("Encoded Message: " + encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);

        scanner.close();
    }
}
