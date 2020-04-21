package Game;

import Game.Mod.Attribute;
import java.util.ArrayList;

public class Complex extends Attribute {
    private static final String cut = " : Cut",
            dont = " : Don't cut";
    public static String solve(String sample){
        String[] combos = sample.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String wire : combos){
            builder.append(solve(translate(wire))).append("\n");
        }

        return builder.toString();
    }

    private static ArrayList<ComplexWires> translate(String wire){
        ArrayList<ComplexWires> properties = new ArrayList<>();
        if (!wire.toLowerCase().equals("w")) {
            if (wire.toLowerCase().contains("r")) {
                properties.add(ComplexWires.RED);
            }
            if (wire.toLowerCase().contains("b")) {
                properties.add(ComplexWires.BLUE);
            }
            if (wire.toLowerCase().contains("l")) {
                properties.add(ComplexWires.LIT);
            }
            if (wire.toLowerCase().contains("s")) {
                properties.add(ComplexWires.STAR);
            }
        } else {
            properties.add(ComplexWires.BLANK);
        }

        return properties;
    }

    private static String solve(ArrayList<ComplexWires> traits){
        String script = "";
        switch (traits.size()){//All four
            case 4:
                script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                        + ComplexWires.STAR.getLabel() + "/" + ComplexWires.LIT.getLabel() + dont;
                break;
            case 3:
                if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.LIT)
                        && traits.contains(ComplexWires.RED)){//Red Blue LED
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                            + ComplexWires.LIT.getLabel() + (lastDigitEven?cut:dont);
                } else if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.RED)
                        && traits.contains(ComplexWires.STAR)){//Red Blue Star
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                            + ComplexWires.STAR.getLabel() + (hasParallel?cut:dont);
                } else if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.STAR)
                        && traits.contains(ComplexWires.LIT)){//Blue Star LED
                    script = ComplexWires.BLUE.getLabel() + "/" + ComplexWires.LIT.getLabel() + "/"
                            + ComplexWires.STAR.getLabel() + (hasParallel?cut:dont);
                } else if (traits.contains(ComplexWires.RED) && traits.contains(ComplexWires.STAR)
                        && traits.contains(ComplexWires.LIT)){//Red Star LED
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.LIT.getLabel() + "/"
                            + ComplexWires.STAR.getLabel() + (numBatteries >= 2?cut:dont);
                }
                break;
            case 2:
                if (traits.contains(ComplexWires.RED) && traits.contains(ComplexWires.STAR)){//Red Star
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.STAR.getLabel() + cut;
                } else if (traits.contains(ComplexWires.RED) && traits.contains(ComplexWires.BLUE)){//Red Blue
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel()
                            + (lastDigitEven?cut:dont);
                } else if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.LIT)){//Blue LED
                    script = ComplexWires.BLUE.getLabel() + "/" + ComplexWires.LIT.getLabel()
                            + (hasParallel?cut:dont);
                } else if (traits.contains(ComplexWires.LIT) && traits.contains(ComplexWires.STAR)){//LED Star
                    script = ComplexWires.LIT.getLabel() + "/" + ComplexWires.STAR.getLabel()
                            + (numBatteries >= 2?cut:dont);
                } else if (traits.contains(ComplexWires.STAR) && traits.contains(ComplexWires.BLUE)){//Blue Star
                    script = ComplexWires.STAR.getLabel() + "/" + ComplexWires.BLUE.getLabel() + dont;
                } else if (traits.contains(ComplexWires.LIT) && traits.contains(ComplexWires.RED)){//Red LED
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.LIT.getLabel()
                            + (numBatteries >= 2?cut:dont);
                }
                break;
            default:
                if (traits.contains(ComplexWires.BLANK)){//White
                    script = ComplexWires.BLANK.getLabel() + cut;
                } else if (traits.contains(ComplexWires.RED)){//Red
                    script = ComplexWires.RED.getLabel() + (lastDigitEven?cut:dont);
                } else if (traits.contains(ComplexWires.BLUE)){//Blue
                    script = ComplexWires.BLUE.getLabel() + (lastDigitEven?cut:dont);
                } else if (traits.contains(ComplexWires.STAR)){//Star
                    script = ComplexWires.STAR.getLabel() + cut;
                } else {//LED
                    script = ComplexWires.LIT.getLabel() + dont;
                }
        }

        return script;
    }
}
