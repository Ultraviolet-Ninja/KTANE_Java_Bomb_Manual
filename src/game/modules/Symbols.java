/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Keypads
 */

package game.modules;

import game.objects.Keypads;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * Symbols refers to the Keypads module
 */
public class Symbols extends Attribute {

    /**
     * change() highlights or de-highlights the Keypad that was clicked by the user.
     *
     * @param toEdit - the Keypad to highlight or return to normal
     * @param og - the Image of the original keypad appearance
     * @return - the highlighted or normal image of the keypad
     */
    public static Image change(Keypads toEdit, Image og) {
        if (toEdit.getFlag()) {
            WritableImage nextImage = new WritableImage((int) og.getWidth(), (int) og.getHeight());
            for (int x = 0; x < (int) og.getWidth(); x++) {
                for (int y = 0; y < (int) og.getHeight(); y++) {
                    nextImage.getPixelWriter().setColor(x, y,
                            highLight(og.getPixelReader().getColor(x, y)));
                }
            }
            toEdit.setFlag(true);
            return nextImage;
        } else {
            toEdit.setFlag(false);
            return new Image(toEdit.getLabel(), og.getWidth(), og.getHeight(), true, true);
        }
    }

    private static Color highLight(Color toHigh) {
        return new Color(0, toHigh.getGreen(), toHigh.getBlue(), 1);
    }
}
