/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Morse Code
 */

package Game.Modules;

import Game.Tools.AVLTree;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Morse class deals with the Morse Code module.
 */
public class Morse extends Attribute {
    public static final HashMap<String, Double> freqs = new HashMap<>();

    private static final AVLTree<String> code = new AVLTree<>();

    public static void initialize(){
        initDots();
        initWords();
    }

    private static void initDots(){
        try {
            Scanner middleMan = new Scanner(new File("src\\Game\\Resources\\Morsecode.txt"));
            while (middleMan.hasNextLine()){
                String[] buffer = middleMan.nextLine().split(" ");
                code.addNode(buffer[1], buffer[0]);
            }
        } catch (IOException ioException){
            System.err.println("Wrong");
        }
    }

    private static void initWords(){
        freqs.put("shell", 3.505);
        freqs.put("halls", 3.515);
        freqs.put("slick", 3.522);
        freqs.put("trick", 3.532);
        freqs.put("boxes", 3.535);
        freqs.put("leaks", 3.542);
        freqs.put("strobe", 3.545);
        freqs.put("bistro", 3.552);
        freqs.put("flick", 3.555);
        freqs.put("bombs", 3.565);
        freqs.put("break", 3.572);
        freqs.put("brick", 3.575);
        freqs.put("steak", 3.582);
        freqs.put("sting", 3.592);
        freqs.put("vector", 3.595);
        freqs.put("beats", 3.6);
    }

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
            case "bre", "brea", "reak", "br" -> "break";
            case "bri", "bric", "brick", "icks" -> "bricks";
            case "ste", "stea" -> "steak";
            case "st", "sti", "stin" -> "sting";
            case "v", "ve", "vec", "vect", "vecto" -> "vector";
            case "be", "bea", "beat", "eats", "ats"-> "beats";
            case "bi", "bis", "bist", "bistr" -> "bistro";
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
        out[1] = transcode(sample.split(" "));
        out[0] = findWords(out[1]);
        return out;
    }

    private static String transcode(String[] inputs){
        StringBuilder results = new StringBuilder();

        for (String input : inputs) {
            results.append(code.dig(input));
        }

        return results.toString();
    }

    private static String findWords(String letters){
        StringBuilder finalWords = new StringBuilder();

        for (Map.Entry<String, Double> buffer : freqs.entrySet()) {
            if (buffer.getKey().contains(letters)) {
                finalWords.append(buffer.getKey()).append(" - ").append(buffer.getValue())
                        .append("MHz").append("/");
            }
        }
        return finalWords.toString();
    }
}
