package Game;

import Game.Mod.Attribute;

import java.util.ArrayList;

public class Simple extends Attribute {
    private static final String
            first = " first ",
            second = " 2nd ",
            third = " 3rd ",
            forth = " 4th ",
            sixth = " last ",
            wire = "wire ";


    public static String conditions(ArrayList<SimpleWires> theList){
        String response;

        switch (theList.size()){
            case 3:
                if (!theList.contains(SimpleWires.RED)){
                    response = second + wire;
                } else if (theList.get(2) == SimpleWires.WHITE){
                    response = sixth + wire;
                } else if (moreThanOne(theList, SimpleWires.BLUE)){
                    response = sixth + "blue " + wire;
                } else {
                    response = sixth + wire;
                }
                break;
            case 4:
                if (moreThanOne(theList, SimpleWires.RED) && !lastDigitEven){
                    response = sixth + "red " + wire + "if odd";
                } else if (theList.get(3) == SimpleWires.YELLOW && !theList.contains(SimpleWires.RED)){
                    response = first + wire;
                } else if (onlyOne(theList, SimpleWires.BLUE)){
                    response = first + wire;
                } else if (moreThanOne(theList, SimpleWires.YELLOW)){
                    response = sixth + wire;
                } else {
                    response = second + wire;
                }
                break;
            case 5:
                if (theList.get(4) == SimpleWires.BLACK && !lastDigitEven){
                    response = forth + wire + "if odd";
                } else if (onlyOne(theList, SimpleWires.RED) && moreThanOne(theList, SimpleWires.YELLOW)){
                    response = first + wire;
                } else if (!theList.contains(SimpleWires.BLACK)){
                    response = second + wire;
                } else {
                    response = first + wire;
                }
                break;
            default:
                if (!theList.contains(SimpleWires.YELLOW) && !lastDigitEven){
                    response = third + wire + "if odd";
                } else if (onlyOne(theList, SimpleWires.YELLOW) && moreThanOne(theList, SimpleWires.WHITE)){
                    response = forth + wire;
                } else if (!theList.contains(SimpleWires.RED)){
                    response = sixth + wire;
                } else {
                    response = forth + wire;
                }
                break;
        }

        return "Cut the" + response;
    }

    private static boolean moreThanOne(ArrayList<SimpleWires> theList, SimpleWires color){
        int i = 0;
        for (SimpleWires wire : theList){
            if (wire == color){
                i++;
            }
        }
        return i > 1;
    }

    private static boolean onlyOne(ArrayList<SimpleWires> theList, SimpleWires color){
        int i = 0;
        for (SimpleWires wire : theList){
            if (wire == color){
                i++;
            }
        }
        return i == 1;
    }
}
