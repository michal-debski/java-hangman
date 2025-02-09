package pl.edu.agh.hangman;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to start a game type: START");
        String start = scanner.nextLine();
        if (start.equals("START")) {
            String next = scanner.nextLine();
            RandomWordLoader wordLoader = new RandomWordLoader();
            String randomWordFromList = wordLoader.getRandomWordFromList();

            Generator generator = new Generator();
            generator.underscoreGenerate(randomWordFromList);

            int counter = 0;
            String[] hangmanPics = Hangman.getHangmanPics();
            while (LetterChecker.isWordCompleted() && counter == hangmanPics.length) {
                System.out.println(hangmanPics[0]);

                String providedLetter = scanner.nextLine();
                char letter = providedLetter.toCharArray()[0];
                if (LetterChecker.isLetterInWord(randomWordFromList, letter)) {
                    generator.letterGenerate(randomWordFromList, letter);
                } else {
                    counter++;
                    System.out.println(hangmanPics[counter]);
                }
            }
        }
    }
}
