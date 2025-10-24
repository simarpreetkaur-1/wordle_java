//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] word = {"crisp", "ghost", "trend", "flint", "bloom", "crown", "spark", "train", "glass", "fruit",
                "sharp", "flame", "stone", "beach", "grass", "pride", "charm", "dream", "blaze", "cloud",
                "pixel", "quick", "sweet", "brave", "clean", "water", "sound", "flash", "grain", "plant"};

        Random rand = new Random();
        String targetWord = word[rand.nextInt(word.length)];
        int wordLength = targetWord.length();
        int maxAttempts = 6;

        System.out.println("Welcome to WORDLE!!");
        System.out.println("Guess the word consisting of 5 letters.");
        System.out.println("You have 6 chances.");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": ");
            String guess = sc.nextLine().toLowerCase();

            // Check length
            if (guess.length() != wordLength) {
                System.out.println("Please enter a " + wordLength + "-letter word.");
                attempt--;
                continue;
            }

            // Check if word exists
            boolean validWord = false;
            for (String w : word) {
                if (w.equals(guess)) {
                    validWord = true;
                    break;
                }
            }
            if (!validWord) {
                System.out.println("Word not in word list.");
                attempt--;
                continue;
            }

            // Build feedback
            StringBuilder feedback = new StringBuilder();
            for (int i = 0; i < wordLength; i++) {
                if (guess.charAt(i) == targetWord.charAt(i)) {
                    feedback.append("🟩");
                } else if (targetWord.contains(Character.toString(guess.charAt(i)))) {
                    feedback.append("🟨");
                } else {
                    feedback.append("⬛");
                }
            }

            // Print feedback
            System.out.println(feedback.toString());

            // Check win
            if (guess.equals(targetWord)) {
                System.out.println("Congratulations! You guessed the word: " + targetWord);
                break;
            }

            // Check loss
            if (attempt == maxAttempts) {
                System.out.println("Sorry! The word was: " + targetWord);
            }

            System.out.println();
        }

        sc.close();
    }
}









