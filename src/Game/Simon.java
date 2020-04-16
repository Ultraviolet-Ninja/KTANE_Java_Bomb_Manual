package Game;

import Game.Mod.Attribute;

public class Simon extends Attribute {

    public static String next(SimonSays color, double strikes){
        if (hasVowel) {
            if (strikes == 0){
                switch (color) {
                    case RED:
                        return SimonSays.BLUE.getLabel();
                    case YELLOW:
                        return SimonSays.GREEN.getLabel();
                    case GREEN:
                        return SimonSays.YELLOW.getLabel();
                    case BLUE:
                        return SimonSays.RED.getLabel();
                }
            } else if (strikes == 1){
                return repeatedPattern(color);
            } else {
                switch (color) {
                    case RED:
                        return SimonSays.GREEN.getLabel();
                    case YELLOW:
                        return SimonSays.BLUE.getLabel();
                    case GREEN:
                        return SimonSays.YELLOW.getLabel();
                    case BLUE:
                        return SimonSays.RED.getLabel();
                }
            }
        } else {
            if (strikes == 0){
                switch (color) {
                    case RED:
                        return SimonSays.BLUE.getLabel();
                    case YELLOW:
                        return SimonSays.RED.getLabel();
                    case GREEN:
                        return SimonSays.GREEN.getLabel();
                    case BLUE:
                        return SimonSays.YELLOW.getLabel();
                }
            } else if (strikes == 1){
                switch (color) {
                    case RED:
                        return SimonSays.RED.getLabel();
                    case YELLOW:
                        return SimonSays.GREEN.getLabel();
                    case GREEN:
                        return SimonSays.YELLOW.getLabel();
                    case BLUE:
                        return SimonSays.BLUE.getLabel();
                }
            } else {
                return repeatedPattern(color);
            }
        }

        return "Will never reach this point";
    }

    public static String newOrder(String oldOrder, double strikes){
        StringBuilder next = new StringBuilder();

        for (char letter : oldOrder.toCharArray()){
            next.append(next(getColor(letter), strikes));
        }


        return next.toString();
    }

    private static SimonSays getColor(char label){
        switch (label){
            case 'R':
                return SimonSays.RED;
            case 'B':
                return SimonSays.BLUE;
            case 'G':
                return SimonSays.GREEN;
            default:
                return SimonSays.YELLOW;
        }
    }

    private static String repeatedPattern(SimonSays color){
        String temp = "";

        switch (color) {
            case RED:
                temp = SimonSays.YELLOW.getLabel();
                break;
            case YELLOW:
                temp = SimonSays.RED.getLabel();
                break;
            case GREEN:
                temp = SimonSays.BLUE.getLabel();
                break;
            case BLUE:
                temp = SimonSays.GREEN.getLabel();
                break;
        }
        return temp;
    }
}
