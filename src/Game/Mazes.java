package Game;

import Game.Mod.Attribute;
import javafx.scene.image.Image;

public class Mazes extends Attribute {

    public static Image findMaze(String coords, int which){
        String finalLabel = "";
        int[] numbers = cast(coords);

        switch (which){
            case 0:
                for (MazeTop top : MazeTop.values()){
                    if (coordsMatch(numbers, top.getCoords())){
                        finalLabel = top.getLabel();
                    }
                }
                break;
            case 1:
                for (MazeBottom bottom: MazeBottom.values()){
                    if (coordsMatch(numbers, bottom.getCoords())){
                        finalLabel = bottom.getLabel();
                    }
                }
                break;
            default:
                for (MazeLetNum notation: MazeLetNum.values()){
                    if (coordsMatch(numbers, notation.getCoords())){
                        finalLabel = notation.getLabel();
                    }
                }
                break;

        }
        return new Image(finalLabel);
    }

    private static boolean coordsMatch(int[] input, int[] maze){
        return input[0] == maze[0] && input[1] == maze[1];
    }

    private static int[] cast(String inForm){
        if (inForm.length() == 2) {
            return new int[]{Character.getNumericValue(inForm.charAt(0)), Character.getNumericValue(inForm.charAt(1))};
        } else {
            return new int[]{Integer.parseInt(inForm.substring(0, 2)), Character.getNumericValue(inForm.charAt(2))};
        }
    }
}
