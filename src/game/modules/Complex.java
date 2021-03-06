/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Complex
 */

package game.modules;

import game.objects.ComplexWires;
import java.util.ArrayList;

/**
 * Complex class refers to the Complicated Wires module
 */
public class Complex extends Attribute {
    private static final String cut = " - Cut",
            dont = " - Don't cut",
            allScript = "rbls rsl rbl bls rbs rs rl rb bl bs sl s l r b w";

    /**
     * solve() uses the given combinations of wire traits and solves them,
     * returning whether to cut or not for each one.
     *
     * @param sample - Takes in the wire combinations
     * @return - [Confirmation of the given wire] - [To cut or not to cut]
     */
    public static String solve(String sample){
        StringBuilder builder = new StringBuilder();
        if (sample.contains("all")){
            for (String wire : allScript.split(" ")) {
                builder.append(solve(translate(wire))).append("\n");
            }
            return builder.toString();
        } else if (!sample.isEmpty()) {
            String[] combos = sample.split(" ");

            for (String wire : combos) {
                builder.append(solve(translate(wire))).append("\n");
            }

            return builder.toString();
        }
        return "";
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
                        + ComplexWires.STAR.getLabel() + "/" + ComplexWires.LIT.getLabel() + dont + " (like ever)";
                break;
            case 3:
                if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.LIT)
                        && traits.contains(ComplexWires.RED)){//Red Blue LED
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                            + ComplexWires.LIT.getLabel() + (lastDigitEven?cut:dont) + "        (Last Digit)";
                } else if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.RED)
                        && traits.contains(ComplexWires.STAR)){//Red Blue Star
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel() + "/"
                            + ComplexWires.STAR.getLabel() + (hasParallel?cut:dont) + "         (Parallel)";
                } else if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.STAR)
                        && traits.contains(ComplexWires.LIT)){//Blue Star LED
                    script = ComplexWires.BLUE.getLabel() + "/" + ComplexWires.LIT.getLabel() + "/"
                            + ComplexWires.STAR.getLabel() + (hasParallel?cut:dont) + "        (Parallel)";
                } else if (traits.contains(ComplexWires.RED) && traits.contains(ComplexWires.STAR)
                        && traits.contains(ComplexWires.LIT)){//Red Star LED
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.LIT.getLabel() + "/"
                            + ComplexWires.STAR.getLabel() + (numBatteries >= 2?cut:dont) + "        (Batteries)";
                }
                break;
            case 2:
                if (traits.contains(ComplexWires.RED) && traits.contains(ComplexWires.STAR)){//Red Star
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.STAR.getLabel() + cut
                            + "                            (100%)";
                } else if (traits.contains(ComplexWires.RED) && traits.contains(ComplexWires.BLUE)){//Red Blue
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.BLUE.getLabel()
                            + (lastDigitEven?cut:dont) + "             (Last Digit)";
                } else if (traits.contains(ComplexWires.BLUE) && traits.contains(ComplexWires.LIT)){//Blue LED
                    script = ComplexWires.BLUE.getLabel() + "/" + ComplexWires.LIT.getLabel()
                            + (hasParallel?cut:dont) + "              (Parallel)";
                } else if (traits.contains(ComplexWires.LIT) && traits.contains(ComplexWires.STAR)){//LED Star
                    script = ComplexWires.LIT.getLabel() + "/" + ComplexWires.STAR.getLabel()
                            + (numBatteries >= 2?cut:dont) + "              (Batteries)";
                } else if (traits.contains(ComplexWires.STAR) && traits.contains(ComplexWires.BLUE)){//Blue Star
                    script = ComplexWires.STAR.getLabel() + "/" + ComplexWires.BLUE.getLabel() + dont
                            + "             (like ever)";
                } else if (traits.contains(ComplexWires.LIT) && traits.contains(ComplexWires.RED)){//Red LED
                    script = ComplexWires.RED.getLabel() + "/" + ComplexWires.LIT.getLabel()
                            + (numBatteries >= 2?cut:dont) + "              (Batteries)";
                }
                break;
            default:
                if (traits.contains(ComplexWires.BLANK)){//White
                    script = ComplexWires.BLANK.getLabel() + cut
                            + "                     (100%)";
                } else if (traits.contains(ComplexWires.RED)){//Red
                    script = ComplexWires.RED.getLabel() + (lastDigitEven?cut:dont)
                            + "                  (Last Digit)";
                } else if (traits.contains(ComplexWires.BLUE)){//Blue
                    script = ComplexWires.BLUE.getLabel() + (lastDigitEven?cut:dont)
                            + "                 (Last Digit)";
                } else if (traits.contains(ComplexWires.STAR)){//Star
                    script = ComplexWires.STAR.getLabel() + cut
                            + "                   (100%)";
                } else if (traits.contains(ComplexWires.LIT)) {//LED
                    script = ComplexWires.LIT.getLabel() + dont
                            + "                  (like ever)";
                }
        }

        return script;
    }
}
