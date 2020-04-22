package Game;

import Game.Mod.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Morse extends Attribute {


    public static ArrayList<String> translate(String sample){
        String[] inputs = sample.split(" ");
        return findWords(transcode(inputs, Arrays.asList(MorseCodeLetter.values())),
                Arrays.asList(MorseCodeFrequencies.values()));
    }

    private static ArrayList<String> transcode(String[] inputs, List<MorseCodeLetter> list){
        ArrayList<String> results = new ArrayList<>();

        for (MorseCodeLetter morseCodeLetter : list) {
            for (String input : inputs) {
                if (input.equals(morseCodeLetter.getLabel())) {
                    results.add(morseCodeLetter.getLetter());
                }
            }
        }

        return results;
    }

    private static ArrayList<String> findWords(ArrayList<String> letters, List<MorseCodeFrequencies> frequencies){
        ArrayList<String> testWords = new ArrayList<>(),
                finalWords = new ArrayList<>();

        for (MorseCodeFrequencies frequency : frequencies) {
           if (frequency.getLabel().contains(letters.get(0))) {
                testWords.add(frequency.getLabel() + " - " + frequency.frequency() + "MHz");
           }
        }

        if (letters.size() > 1){
            for (int i = 1; i < letters.size(); i++){
                for (String word : testWords){
                    if (word.contains(letters.get(i))){
                        finalWords.add(word);
                    }
                }
                if (i != letters.size() -1) {
                    testWords = finalWords;
                    finalWords.clear();
                }
            }
        } else {
            finalWords = testWords;
        }
        return finalWords;
    }
}
