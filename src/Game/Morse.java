/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Morse Code
 */

package Game;

import Game.Mod.Attribute;
import java.util.Arrays;
import java.util.List;

/**
 * Morse class deals with the Morse Code module.
 */
public class Morse extends Attribute {

    /**
     * predict() predicts a word put into the manual input section of the Morse Code tab.
     *
     * @param in - the partial word
     * @return - the full word if detected
     */
    public static String predict(String in){
        return switch (in) {
            case "sh", "she", "shel" -> "shell";
            case "h" ,"ha", "hal", "hall" -> "halls";
            case "sl", "sli", "slic" -> "slick";
            case "t", "tr", "tri", "tric" -> "trick";
            case "box", "boxe" -> "boxes";
            case "l", "le", "lea", "leak" -> "leaks";
            case "str", "stro", "strob", "strb" -> "strobe";
            case "f", "fl", "fli", "flic" -> "flick";
            case "bom", "bomb" -> "bombs";
            case "bre", "brea", "break", "reak" -> "breaks";
            case "bri", "bric", "brick", "icks" -> "bricks";
            case "ste", "stea" -> "steak";
            case "st", "sti", "stin" -> "sting";
            case "v", "ve", "vec", "vect", "vecto" -> "vector";
            case "be", "bea", "beat", "eats", "ats"-> "beats";
            default -> in;
        };
    }

    /**
     * translate() turns the morse code letters into letters and possible words
     * with that combination of characters.
     *
     * @param sample - the morse code letters
     * @return - [0] - the resulting words found from those letters.
     *           [1] - the letters that match their morse code counter parts.
     */
    public static String[] translate(String sample){
        String[] out = new String[2];
        out[1] = transcode(sample.split(" "), Arrays.asList(MorseCodeLetter.values()));
        out[0] = findWords(out[1], Arrays.asList(MorseCodeFrequencies.values()));
        return out;
    }

    private static String transcode(String[] inputs, List<MorseCodeLetter> list){
        StringBuilder results = new StringBuilder();

        for (String input : inputs) {
            for (MorseCodeLetter morseCodeLetter : list) {
                if (input.equals(morseCodeLetter.getLabel())) {
                    results.append(morseCodeLetter.getLetter());
                }
            }
        }

        return results.toString();
    }

    private static String findWords(String letters, List<MorseCodeFrequencies> frequencies){
        StringBuilder finalWords = new StringBuilder();

        for (MorseCodeFrequencies frequency : frequencies){
            if (frequency.getLabel().contains(letters)){
                finalWords.append(frequency.getLabel()).append(" - ").append(frequency.frequency())
                        .append("MHz").append("/");
            }
        }
        return finalWords.toString();
    }
}
