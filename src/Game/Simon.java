package Game;

import Game.Mod.Attribute;

public class Simon extends Attribute {

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
