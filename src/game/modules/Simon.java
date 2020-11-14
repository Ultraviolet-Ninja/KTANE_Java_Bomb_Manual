/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Simon Says
 */

package game.modules;

import game.objects.SimonSays;

/**
 * Simon class deals with the Simon Says module
 */
public class Simon extends Attribute {

    /**
     * next() interprets the next color flash and instructs what to press next.
     *
     * @param color - the current color flashing
     * @param strikes - the number of strikes currently
     * @return - the color to press next
     */
    public static String next(SimonSays color, double strikes){
        if (hasVowel) {
            if (strikes == 0){
                return switch (color) {
                    case RED -> SimonSays.BLUE.getLabel();
                    case YELLOW -> SimonSays.GREEN.getLabel();
                    case GREEN -> SimonSays.YELLOW.getLabel();
                    case BLUE -> SimonSays.RED.getLabel();
                };
            } else if (strikes == 1){
                return repeatedPattern(color);
            } else {
                return switch (color) {
                    case RED -> SimonSays.GREEN.getLabel();
                    case YELLOW -> SimonSays.BLUE.getLabel();
                    case GREEN -> SimonSays.YELLOW.getLabel();
                    case BLUE -> SimonSays.RED.getLabel();
                };
            }
        } else {
            if (strikes == 0){
                return switch (color) {
                    case RED -> SimonSays.BLUE.getLabel();
                    case YELLOW -> SimonSays.RED.getLabel();
                    case GREEN -> SimonSays.GREEN.getLabel();
                    case BLUE -> SimonSays.YELLOW.getLabel();
                };
            } else if (strikes == 1){
                return switch (color) {
                    case RED -> SimonSays.RED.getLabel();
                    case YELLOW -> SimonSays.GREEN.getLabel();
                    case GREEN -> SimonSays.YELLOW.getLabel();
                    case BLUE -> SimonSays.BLUE.getLabel();
                };
            } else {
                return repeatedPattern(color);
            }
        }
    }

    /**
     * newOrder() changes the order of the buttons to press on the module when a strike is added or subtracted
     *
     * @param oldOrder - the order of the colors that have flashed
     * @param strikes - current number of strikes on the bomb
     * @return - the new combination to press on the module
     */
    public static String newOrder(String oldOrder, double strikes){
        StringBuilder next = new StringBuilder();
        for (char letter : oldOrder.toCharArray()){
            next.append(next(getColor(letter), strikes));
        }
        return next.toString();
    }

    private static SimonSays getColor(char label){
        return switch (label) {
            case 'R' -> SimonSays.RED;
            case 'B' -> SimonSays.BLUE;
            case 'G' -> SimonSays.GREEN;
            default -> SimonSays.YELLOW;
        };
    }

    private static String repeatedPattern(SimonSays color){
        return switch (color) {
            case RED -> SimonSays.YELLOW.getLabel();
            case YELLOW -> SimonSays.RED.getLabel();
            case GREEN -> SimonSays.BLUE.getLabel();
            case BLUE -> SimonSays.GREEN.getLabel();
        };
    }
}
