package Game.Mod;

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