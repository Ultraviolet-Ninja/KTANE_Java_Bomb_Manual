/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Memory
 */

package Game;

import Game.Mod.Attribute;

/**
 * Memory class refers to the Memory module
 */
public class Memory extends Attribute {
    private static int[] positions = new int[4],
            labels = new int[4];

    private static final String pos = " position", lab = " Label";

    /**
     * setInstructions() communicates to the user what button to press next on the module
     * based on the stage and number values of buttons pressed in previous stages.
     *
     * @param stage - the current stage of the module
     * @param display - what the display reads on the current stage
     * @return - the instructions to tell the user which button to press next
     */
    public static String[] setInstruction(int stage, int display){
        String[] instructions = new String[2];
        switch (stage){
            case 1:
                if (display == 1 || display == 2){//Second Position
                    instructions[0] = ordinalFormat(2) + pos;
                    instructions[1] = "P2";
                    positions[0] = 2;
                } else if (display == 3){//Third Position
                    instructions[0] = ordinalFormat(3) + pos;
                    instructions[1] = "P3";
                    positions[0] = 3;
                } else {//Forth Position
                    instructions[0] = ordinalFormat(4) + pos;
                    instructions[1] = "P4";
                    positions[0] = 4;
                }
                break;
            case 2:
                if (display == 1){ //Label 4
                    instructions[0] = lab.replace(" ", "") + " 4";
                    instructions[1] = "L4";
                    labels[1] = 4;
                } else if (display == 3){ //First position
                    instructions[0] = ordinalFormat(1) + pos;
                    instructions[1] = "P1";
                    positions[1] = 1;
                } else { //Position of Stage 1
                    instructions[0] = ordinalFormat(positions[0]) + pos;
                    instructions[1] = "P" + positions[0];
                    positions[1] = positions[0];
                }
                break;
            case 3:
                if (display == 1){//Label of Stage 2
                    instructions[0] = lab.replace(" ", "") + " " + labels[1];
                    instructions[1] = "L" + labels[1];
                    labels[2] = labels[1];
                } else if (display == 2){//Label of Stage 1
                    instructions[0] = lab.replace(" ", "") + " " + labels[0];
                    instructions[1] = "L" + labels[0];
                    labels[2] = labels[0];
                } else if (display == 3){ //Third Position
                    instructions[0] = ordinalFormat(3) + pos;
                    instructions[1] = "P3";
                    positions[2] = 3;
                } else { //Label 4
                    instructions[0] = lab.replace(" ", "") + " 4";
                    instructions[1] = "L4";
                    labels[2] = 4;
                }
                break;
            case 4:
                if (display == 1){ //Position of Stage 1
                    instructions[0] = ordinalFormat(positions[0]) + pos;
                    instructions[1] = "P" + positions[0];
                    positions[3] = positions[0];
                } else if (display == 2){ //First Position
                    instructions[0] = ordinalFormat(1) + pos;
                    instructions[1] = "P1";
                    positions[3] = 1;
                } else { //Position of Stage 2
                    instructions[0] = ordinalFormat(positions[1]) + pos;
                    instructions[1] = "P" + positions[1];
                    positions[3] = positions[1];
                }
                break;
            default:
                if (display == 1){ //Label of Stage 1
                    instructions[0] = lab.replace(" ", "") + " " + labels[0];
                    instructions[1] = "N";
                } else if (display == 2){ //Label of Stage 2
                    instructions[0] = lab.replace(" ", "") + " " + labels[1];
                    instructions[1] = "N";
                } else if (display == 3){ //Label of Stage 4
                    instructions[0] = lab.replace(" ", "") + " " + labels[3];
                    instructions[1] = "N";
                } else { //Label of Stage 3
                    instructions[0] = lab.replace(" ", "") + " " + labels[2];
                    instructions[1] = "N";
                }
                break;
        }
        return instructions;
    }

    /**
     * setPosition() sets the position of a certain stage for future use.
     *
     * @param stage - the stage to set the position to
     * @param pos - which position the
     */
    public static void setPosition(int stage, int pos){
        positions[stage] = pos;
    }

    /**
     * setLabel() sets the label of a certain stage for future use.
     *
     * @param stage - the stage to set the label of
     * @param label - the label on the button pressed
     */
    public static void setLabel(int stage, int label){
        labels[stage] = label;
    }

    /**
     * clear() resets the arrays.
     */
    public static void clear(){
        labels = new int[4];
        positions = new int[4];
    }

    public static String ordinalFormat(int number){
        return switch (number) {
            case 1 -> "1st";
            case 2 -> "2nd";
            case 3 -> "3rd";
            case 4 -> "4th";
            case 5 -> "5th";
            case 6 -> "6th";
            default -> "";
        };
    }
}
