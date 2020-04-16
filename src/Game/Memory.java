package Game;

import Game.Mod.Attribute;

public class Memory extends Attribute {
    private static int[] positions = new int[4],
            labels = new int[4];

    private static final String pos = " position", lab = " label";

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

    public static void setPosition(int stage, int pos){
        positions[stage] = pos;
    }

    public static void setLabel(int stage, int label){
        labels[stage] = label;
    }

    public static void clear(){
        labels = new int[4];
        positions = new int[4];
    }

    public static String ordinalFormat(int number){
        String ordinal = "";
        switch (number){
            case 1:
                ordinal = "1st";
                break;
            case 2:
                ordinal = "2nd";
                break;
            case 3:
                ordinal = "3rd";
                break;
            case 4:
                ordinal = "4th";
                break;
            case 5:
                ordinal = "5th";
                break;
            case 6:
                ordinal = "6th";
                break;
        }
        return ordinal;
    }
}
