package Game.Objects;

import Game.Structures.Labeled;

public enum MorseCodeLetter implements Labeled {
    A(".-", "a"), B("-...", "b"), C("-.-.", "c"),
    D("-..", "d"), E(".", "e"), F("..-.", "f"),
    G("--.", "g"), H("....", "h"), I("..", "i"),
    J(".---", "j"), K("-.-", "k"), L(".-..", "l"),
    M("--", "m"), N("-.", "n"), O("---", "o"),
    P(".--.", "p"), Q("--.-", "q"), R(".-.", "r"),
    S("...", "s"), T("-", "t"), U("..-", "u"),
    V("...-", "v"), W(".--", "w"), X("-..-", "x"),
    Y("-.--", "y"), Z("--..", "z");

    private final String label, letter;

    @Override
    public String getLabel() {
        return label;
    }

    public String getLetter(){
        return letter;
    }

    MorseCodeLetter(String dotDash, String letter){
        label = dotDash;
        this.letter = letter;
    }
}
