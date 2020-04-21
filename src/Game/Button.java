package Game;

import Game.Mod.Attribute;

public class Button extends Attribute {
    private static final String hold = "Hold",
            tap = "Tap";

    public static String evaluate(TheButton[] properties){
        boolean which;
        if (properties[0] == TheButton.BLUE && properties[1] == TheButton.ABORT){
            which = false;
        } else if (numBatteries > 1 && properties[1] == TheButton.DETONATE){
            which = true;
        } else if (CAR){
            which = false;
        } else if (numBatteries > 2 && FRK){
            which = true;
        } else if (properties[0] == TheButton.YELLOW){
            which = false;
        } else which = properties[0] == TheButton.RED && properties[1] == TheButton.HOLD;

        return which ? tap : hold;
    }
}
