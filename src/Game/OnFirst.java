/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Who's On First
 */

package Game;

import Game.Mod.Attribute;
import javafx.scene.image.Image;

/**
 * OnFirst class refers to the Who's on First module.
 */
public class OnFirst extends Attribute {

    /**
     * findPanel() finds the correct panel for Step 1 of the module
     *
     * @param text - the partial word
     * @return - the correct Step 1 Panel
     */
    public static Image findPanel(String text){
        text = format(text);
        for (WhosOnFirstPictures pic : WhosOnFirstPictures.values()){
            if (pic.getLabel().toLowerCase().contains(text)){
                return new Image(pic.getLabel());
            }
        }
        return null;
    }

    /**
     * retList() returns the list words associated with given keyword found by the Step 1 Panel
     *
     * @param keyword - the button based on the Step 1 panel
     * @return - the word list associated with the keyword
     */
    public static String[] retList(String keyword){
        keyword = format(keyword);

        for (WhosOnFirstWords word : WhosOnFirstWords.values()){
            if (word.getLabel().equalsIgnoreCase(keyword)){
                return word.getWords();
            }
        }

        return null;
    }

    private static String format(String initial){
        return switch (initial.toLowerCase()) {
            case "n" -> "no";
            case "redy", "rdy", "ry" -> "ready";
            case "b", "blk", "blnk", "bnk", "bl", "bla", "baln", "balnk", "blan" -> "blank";
            case "p", "pr", "pre", "ss", "pres" -> "press";
            case "rig", "righ", "ryt", "rye" -> "right";
            case "mid", "mi", "midd", "middl" -> "middle";
            case "nex", "ne", "xt" -> "next";
            case "s", "su", "ure" -> "sure";
            case "e", "ty", "em", "emp" -> "empty";
            case "le", "lee" -> "leed";
            case "la", "lea" -> "lead";
            case "ree" -> "reed";
            case "rad", "rea" -> "read";
            case "ho", "hol" -> "hold";
            case "holdn", "holdon", "hod", "hoon", "holon", "holn" -> "hold on";
            case "d", "di", "dis", "disp", "displ", "displa" -> "display";
            case "do", "don", "dne", "one" -> "done";
            case "uh", "uh u", "uhu", "uhuh" -> "uh uh";
            case "yre", "y're", "y'r", "yr'", "yu're", "youre" -> "you're";
            case "uh h", "uh ", "uhh", "uhhuh" -> "uh huh";
            case "yur", "yure", "youare", "you ", "you a", "you ar" -> "you are";
            case "q", "?", "wq", "whatq" -> "what?";
            case "tyre", "th're", "ty're", "t're", "thyr", "thyre", "theyr", "theyre" -> "they're";
            case "tyare", "eyre", "eyare", "they ar", "they re", "they r", "theya", "theyar", "theyare", "thya", "thy" -> "they are";
            case "wht", "wh", "wnq" -> "what";
            case "ye", "es" -> "yes";
            case "yor", "our", "yr" -> "your";
            case "y", "yo" -> "you";
            case "ce" -> "cee";
            case "ok", "oka", "oak", "oaky" -> "okay";
            case "sa", "say", "sys" -> "says";
            case "f", "fir", "firs", "fi", "1st" -> "first";
            case "not", "noth" -> "nothing";
            case "ere" -> "there";
            case "eir", "ir" -> "their";
            default -> initial;
        };
    }
}
