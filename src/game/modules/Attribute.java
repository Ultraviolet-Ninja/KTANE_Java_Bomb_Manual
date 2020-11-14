/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Attribute
 */

package game.modules;

/**
 * Attribute class carries all the important widgets of the current bomb.
 * This class is extended by the Module classes, and all bomb widgets are accessible by those classes.
 */
public class Attribute {
    protected static boolean hasVowel = false,
            lastDigitEven = false,
            FRK = false, CAR = false,
            hasParallel = false;
    protected static int numBatteries = 0;

    public static void setVowel(boolean vowel){
        hasVowel = vowel;
    }

    public static void setLastDigitEven(boolean isEven){
        lastDigitEven = isEven;
    }

    public static void setFRK(boolean FRK) {
        Attribute.FRK = FRK;
    }

    public static void setCAR(boolean CAR) {
        Attribute.CAR = CAR;
    }

    public static void setParallel(boolean has){
        hasParallel = has;
    }

    public static void setNumBatteries(int number){
        if (number >= 0) {
            numBatteries = number;
        }
    }
}