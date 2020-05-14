/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Who's On First
 */

package Game.Modules;

import Game.Objects.WhosOnFirstPictures;
import Game.Objects.WhosOnFirstWords;
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
            if (pic.getLabel().replace("file:src\\Step1_Panels\\", "")
                    .replace(".PNG", "").equalsIgnoreCase(text)){
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
        //TODO - Change to a Tree

        return null;
    }

    private static String format(String initial){
        return switch (initial.toLowerCase()) {
            case "n" -> "no";
            case "w", "wa", "wai", "wt", "wat", "wit" -> "wait";
            case "redy", "rdy", "ry" -> "ready";
            case "b", "blk", "blnk", "bnk", "bl", "bla", "baln", "balnk", "blan" -> "blank";
            case "p", "pr", "pre", "ss", "pres", "prss", "ress" -> "press";
            case "rig", "righ", "ryt", "rye" -> "right";
            case "mid", "mi", "midd", "middl" -> "middle";
            case "nex", "ne", "xt" -> "next";
            case "s", "su", "ure" -> "sure";
            case "e", "ty", "em", "emp", "ep", "ept"-> "empty";
            case "l" -> "led";
            case "le", "lee" -> "leed";
            case "la", "lea" -> "lead";
            case "li", "ike", "lik", "lke" -> "like";
            case "r", "rd" -> "red";
            case "ree", "re" -> "reed";
            case "rad", "rea", "ra"-> "read";
            case "ho", "hol" -> "hold";
            case "holdn", "holdon", "hod", "hoon", "holon", "holn" -> "hold on";
            case "d", "di", "dis", "disp", "displ", "displa" -> "display";
            case "do", "don", "dne", "one" -> "done";
            case "uh", "uh u", "uhu", "uhuh" -> "uh uh";
            case "yre", "y're", "y'r", "yr'", "yu're", "youre", "yur'", "yor'", "yor'e", "yur'e"-> "you're";
            case "uh h", "uh ", "uhh", "uhhuh" -> "uh huh";
            case "yur", "yure", "youare", "you ", "you a", "you ar", "youa", "youar", "yare", "ya", "yar", "yoare",
                    "yuare", "yoa", "yoar", "yuar", "yua"-> "you are";
            case "q", "?", "wq", "whatq" -> "what?";
            case "tyre", "th're", "ty're", "t're", "thyr", "thyre", "theyr", "theyre", "eyre" -> "they're";
            case "tyare", "eyare", "they ar", "they re", "they r", "theya", "theyar", "theyare",
                    "thya", "thy" -> "they are";
            case "wht", "wh", "wnq" -> "what";
            case "ye", "es" -> "yes";
            case "yor", "our", "yr" -> "your";
            case "y", "yo", "yu" -> "you";
            case "ce" -> "cee";
            case "ok", "oka", "oak", "oaky" -> "okay";
            case "sa", "say", "sys" -> "says";
            case "f", "fir", "firs", "fi", "1st" -> "first";
            case "not", "noth" -> "nothing";
            case "ere" -> "there";
            case "eir", "ir" -> "their";
            case "lef", "lft" -> "left";
            default -> initial;
        };
    }
}
