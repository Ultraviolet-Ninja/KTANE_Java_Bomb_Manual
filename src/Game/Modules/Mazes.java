/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Mazes
 */

package Game.Modules;

import Game.Objects.MazeBottom;
import Game.Objects.MazeLetNum;
import Game.Objects.MazeTop;
import javafx.scene.image.Image;

/**
 * Mazes class refers to the Maze module
 */
public class Mazes extends Attribute {

    /**
     * findMaze() finds the correct maze based on the coordinates of one of the circles
     * and the format of the coordinate system used by the defuser.
     *
     * @param coords - the given coordinates of one circle on the maze
     * @param which - The format of the coordinate system used
     * @return - The correct maze
     */
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
        return inForm.length() == 2 ?
                new int[]{Character.getNumericValue(inForm.charAt(0)), Character.getNumericValue(inForm.charAt(1))} :
                new int[]{Integer.parseInt(inForm.substring(0, 2)), Character.getNumericValue(inForm.charAt(2))};
    }
}
