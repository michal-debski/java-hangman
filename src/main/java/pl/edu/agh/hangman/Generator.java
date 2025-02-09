package pl.edu.agh.hangman;

public class Generator {

    public void underscoreGenerate(String s) {
        if (!s.isEmpty()) {
            int stringLength = s.length();
            for (int i = 0; i < stringLength; i++) {
                System.out.print("_");
            }
        }
        System.out.println("\n");
    }

    public String replaceUnserscoreWithLetter(String s, Character character) {
        String replacedString = s.replaceAll("[A-Za-z]", "_");
        s = replacedString.replace("*", character.toString());

        return s;
    }

    public String letterGenerate(String s, Character character) {
        String s1 = String.valueOf(character);
        if (!s.isEmpty() && s.contains(s1)) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == character) {
                    s = s.replace(String.valueOf(character), "*");
                    s = replaceUnserscoreWithLetter(s, character);
                }
            }
            System.out.println(s);
            return s;
        }
        throw new RuntimeException("Word must have at least one letter");
    }

}
