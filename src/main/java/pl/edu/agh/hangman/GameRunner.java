package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pl.edu.agh.hangman.LetterChecker.isWordCompleted;

public class GameRunner {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to start a game type: START");
        String start = scanner.nextLine();

        if (start.equals("START") || start.equals("start")) {

            String next = scanner.nextLine();
            RandomWordLoader wordLoader = new RandomWordLoader();
            String randomWordFromList = wordLoader.getRandomWordFromList();

            Generator generator = new Generator();
            generator.underscoreGenerate(randomWordFromList);
            int counter = 0;
            List<Character> characterList = new ArrayList<>();
            String[] hangmanPics = Hangman.getHangmanPics();
            do {
                    System.out.println(hangmanPics[0]);
                    System.out.println("Provide letter:");
                    String providedLetter = scanner.nextLine();
                    char letter = providedLetter.toCharArray()[0];
                    if (LetterChecker.isLetterInWord(randomWordFromList, letter)) {
                        generator.letterGenerate(randomWordFromList, letter);
                        characterList.add(letter);
                    } else {
                        counter++;
                        System.out.println(hangmanPics[counter]);
                    }
                } while (!isWordCompleted(characterList, randomWordFromList) && counter == hangmanPics.length);

        } while (scanner.hasNext()) ;
    }
}
