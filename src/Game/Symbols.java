package Game;

import Game.Mod.Attribute;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Symbols extends Attribute {

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
