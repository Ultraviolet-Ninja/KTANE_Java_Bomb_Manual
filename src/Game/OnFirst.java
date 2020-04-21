package Game;

import Game.Mod.Attribute;
import javafx.scene.image.Image;

public class OnFirst extends Attribute {

    public static Image findPanel(String text){
        text = format(text);
        for (WhosOnFirstPictures pic : WhosOnFirstPictures.values()){
            if (pic.getLabel().toLowerCase().contains(text)){
                return new Image(pic.getLabel());
            }
        }
        return null;
    }

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
        switch (initial.toLowerCase()) {
            case "n":
                initial = "no";
                break;
            case "redy":
            case "rdy":
            case "ry":
                initial = "ready";
                break;
            case "b":
            case "blk":
            case "blnk":
            case "bnk":
            case "bl":
            case "bla":
            case "baln":
            case "balnk":
            case "blan":
                initial = "blank";
                break;
            case "p":
            case "pr":
            case "pre":
            case "ss":
            case "pres":
                initial = "press";
                break;
            case "rig":
            case "righ":
            case "ryt":
            case "rye":
                initial = "right";
                break;
            case "mid":
            case "mi":
            case "midd":
            case "middl":
                initial = "middle";
                break;
            case "nex":
            case "ne":
            case "xt":
                initial = "next";
                break;
            case "s":
            case "su":
            case "ure":
                initial = "sure";
                break;
            case "e":
            case "ty":
            case "em":
            case "emp":
                initial = "empty";
                break;
            case "le":
            case "lee":
                initial = "leed";
                break;
            case "la":
            case "lea":
                initial = "lead";
                break;
            case "ree":
                initial = "reed";
                break;
            case "rad":
            case "rea":
                initial = "read";
                break;
            case "ho":
            case "hol":
                initial = "hold";
                break;
            case "holdn":
            case "holdon":
            case "hod":
            case "hoon":
            case "holon":
            case "holn":
                initial = "hold on";
                break;
            case "d":
            case "di":
            case "dis":
            case "disp":
            case "displ":
            case "displa":
                initial = "display";
                break;
            case "do":
            case "don":
            case "dne":
            case "one":
                initial = "done";
                break;
            case "uh":
            case "uh u":
            case "uhu":
            case "uhuh":
                initial = "uh uh";
                break;
            case "yre":
            case "y're":
            case "y'r":
            case "yr'":
            case "yu're":
            case "youre":
                initial = "you're";
                break;
            case "uh h":
            case "uh ":
            case "uhh":
            case "uhhuh":
                initial = "uh huh";
                break;
            case "yur":
            case "yure":
            case "youare":
            case "you ":
            case "you a":
            case "you ar":
                initial = "you are";
                break;
            case "q":
            case "?":
            case "wq":
            case "whatq":
                initial = "what?";
                break;
            case "tyre":
            case "th're":
            case "ty're":
            case "t're":
            case "thyr":
            case "thyre":
            case "theyr":
            case "theyre":
                initial = "they're";
                break;
            case "tyare":
            case "eyre":
            case "eyare":
            case "they ar":
            case "they re":
            case "they r":
            case "theya":
            case "theyar":
            case "theyare":
                initial = "they are";
                break;
            case "wht":
            case "wh":
            case "wnq":
                initial = "what";
                break;
            case "ye":
            case "es":
                initial = "yes";
                break;
            case "yor":
            case "our":
            case "yr":
                initial = "your";
                break;
            case "y":
            case "yo":
                initial = "you";
                break;
            case "ce":
                initial = "cee";
                break;
            case "ok":
            case "oka":
            case "oak":
            case "oaky":
                initial = "okay";
                break;
            case "sa":
            case "say":
            case "sys":
                initial = "says";
                break;
            case "f":
            case "fir":
            case "firs":
            case "fi":
            case "1st":
                initial = "first";
                break;
            case "not":
            case "noth":
                initial = "nothing";
                break;
            case "ere":
                initial = "there";
                break;
            case "eir":
            case "ir":
                initial = "their";
                break;
            default:
                return initial;
        }
        return initial;
    }
}
