package pl.edu.agh.hangman;

public class Generator {
//    public static void main(String[] args) {
//        Generator g = new Generator();
//        System.out.println(g.letterReplace("abc", 'a'));
////        System.out.println(g.letterReplace("abc", 'b'));
//    }

    public void underscoreGenerate(String s) {
        if (!s.isEmpty()) {
            int stringLength = s.length();
            for (int i = 0; i < stringLength; i++) {
                System.out.print("_");
            }
        }
        System.out.println("\n");
    }

    public String letterReplace(String s, Character character) {
        StringBuilder sb = new StringBuilder();

        String s1 = String.valueOf(character);
        if (!s.isEmpty() && s.contains(s1)) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == character) {
                    sb.append(s);
                    sb.setCharAt(i, character);
                }
            }
            return String.valueOf(sb);
        }
        throw new RuntimeException("Word must have at least one letter");
    }

}
