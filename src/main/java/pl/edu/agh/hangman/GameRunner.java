package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pl.edu.agh.hangman.LetterChecker.isWordCompleted;

public class GameRunner {

    private Generator generator;
    private RandomWordLoader randomWordLoader;

    public GameRunner(Generator generator, RandomWordLoader randomWordLoader) {
        this.generator = generator;
        this.randomWordLoader = randomWordLoader;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to start a game type: START");
        String start = scanner.nextLine();

        if (start.equals("START") || start.equals("start")) {

            RandomWordLoader wordLoader = new RandomWordLoader();
            String randomWordFromList = wordLoader.getRandomWordFromList();

            Generator generator = new Generator();
            generator.underscoreGenerate(randomWordFromList);
            int counter = 0;
            List<Character> characterList = new ArrayList<>();
            String[] hangmanPics = Hangman.getHangmanPics();
            System.out.println(hangmanPics[0]);
            do {
                System.out.println("Provide letter:");
                while (scanner.hasNext()) {
                    String providedLetter = scanner.nextLine();
                    char letter = providedLetter.toCharArray()[0];
                    if (LetterChecker.isLetterInWord(randomWordFromList, letter)) {
                        System.out.println(generator.letterReplace(randomWordFromList, letter));
                        characterList.add(letter);
                    } else {
                        counter++;
                        System.out.println(hangmanPics[counter]);
                    }
                }

            } while (isWordCompleted(characterList, randomWordFromList) || counter == characterList.size());

        }
        while (scanner.hasNext()) ;
    }
}
