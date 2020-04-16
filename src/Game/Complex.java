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
        switch (traits.size()){
            case 4:
                script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                        + ComplexWires.STAR.getLabel() + "/" + ComplexWires.LIT.getLabel() + dont;
                break;
            case 3:
                if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.LIT)
                        && traits.contains(ComplexWires.RED)){
                    if (lastDigitEven){
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                                + ComplexWires.LIT.getLabel() + cut;
                    } else {
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                                + ComplexWires.LIT.getLabel() + dont;
                    }
                } else if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.RED)
                        && traits.contains(ComplexWires.STAR)){
                    if (hasParallel){
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                                + ComplexWires.STAR.getLabel() + cut;
                    } else {
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                                + ComplexWires.STAR.getLabel() + dont;
                    }
                } else if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.STAR)
                        && traits.contains(ComplexWires.LIT)){
                    if (hasParallel){
                        script = ComplexWires.BLUE.getLabel() + "/" + ComplexWires.LIT.getLabel() + "/"
                                + ComplexWires.STAR.getLabel() + cut;
                    } else {
                        script = ComplexWires.BLUE.getLabel() + "/" + ComplexWires.LIT.getLabel() + "/"
                                + ComplexWires.STAR.getLabel() + dont;
                    }
                } else if (traits.contains(ComplexWires.RED) && traits.contains(ComplexWires.STAR)
                        && traits.contains(ComplexWires.LIT)){
                    if (numBatteries > 1){
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.LIT.getLabel() + "/"
                                + ComplexWires.STAR.getLabel() + cut;
                    } else {
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.LIT.getLabel() + "/"
                                + ComplexWires.STAR.getLabel() + dont;
                    }
                }
                break;
            case 2:
                if (traits.contains(ComplexWires.RED) && traits.contains(ComplexWires.STAR)){
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.STAR.getLabel() + cut;
                } else if (traits.contains(ComplexWires.RED) && traits.contains(ComplexWires.BLUE)){
                    if (lastDigitEven){
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + cut;
                    } else {
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + dont;
                    }
                } else if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.LIT)){
                    if (hasParallel){
                        script = ComplexWires.BLUE.getLabel() + "/" + ComplexWires.LIT.getLabel() + cut;
                    } else {
                        script = ComplexWires.BLUE.getLabel() + "/" + ComplexWires.LIT.getLabel() + dont;
                    }
                } else if (traits.contains(ComplexWires.LIT) && traits.contains(ComplexWires.STAR)){
                    if (numBatteries > 1){
                        script = ComplexWires.LIT.getLabel() + "/" + ComplexWires.STAR.getLabel() + cut;
                    } else {
                        script = ComplexWires.LIT.getLabel() + "/" + ComplexWires.STAR.getLabel() + dont;
                    }
                } else if (traits.contains(ComplexWires.STAR) && traits.contains(ComplexWires.BLUE)){
                    script = ComplexWires.STAR.getLabel() + "/" + ComplexWires.BLUE.getLabel() + dont;
                } else if (traits.contains(ComplexWires.LIT) && traits.contains(ComplexWires.RED)){
                    if (numBatteries > 1){
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.LIT.getLabel() + cut;
                    } else {
                        script = ComplexWires.RED.getLabel() + "/" + ComplexWires.LIT.getLabel() + dont;
                    }
                }
                break;
            default:
                if (traits.contains(ComplexWires.BLANK)){
                    script = ComplexWires.BLANK.getLabel() + cut;
                } else if (traits.contains(ComplexWires.RED)){
                    if (lastDigitEven){
                        script = ComplexWires.RED.getLabel() + cut;
                    } else {
                        script = ComplexWires.RED.getLabel() + dont;
                    }
                } else if (traits.contains(ComplexWires.BLUE)){
                    if (lastDigitEven){
                        script = ComplexWires.BLUE.getLabel() + cut;
                    } else {
                        script = ComplexWires.BLUE.getLabel() + dont;
                    }
                } else if (traits.contains(ComplexWires.STAR)){
                    script = ComplexWires.STAR.getLabel() + cut;
                } else {
                    script = ComplexWires.LIT.getLabel() + dont;
                }
        }

        return script;
    }
}
