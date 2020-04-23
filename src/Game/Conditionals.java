/*
 * Author: Ultraviolet-Ninja
 * Project: Bomb Defusal Manual for Keep Talking and Nobody Explodes [Vanilla]
 * Section: Conditionals
 */

package Game;

/**
 * Conditionals contains all the Enum types for all the Modules to keep their
 * characteristics separate from each other.
 */

enum RadioGroup implements Index{
    BUTTON_COLOR(0), BUTTON_LABEL(1), MAZE(2);

    private final int index;

    @Override
    public int getIdx() {
        return index;
    }

    RadioGroup(int index){
        this.index = index;
    }
}

enum SimpleWires implements Labeled{
    RED("Red"), BLUE("Blue"), BLACK("Black"),
    WHITE("White"), YELLOW("Yellow");

    private final String label;

    SimpleWires(String label){
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label + "\n";
    }
}

enum ComplexWires implements Labeled{
    RED("Red"), BLUE("Blue"), STAR("Star"), LIT("LED"), BLANK("White");

    private final String label;

    @Override
    public String getLabel() {
        return label;
    }

    ComplexWires(String label){
        this.label = label;
    }
}

enum SequencedWires implements Index, Labeled{
    RED(0), BLUE(0), BLACK(0);

    private int index;

    public void setIndex(int index){
        this.index = index;
    }

    @Override
    public int getIdx() {
        return index;
    }

    @Override
    public String getLabel() {
        return "file:src\\Occurrences\\";
    }

    SequencedWires(int index){
        this.index = index;
    }
}

enum TheButton {
    BLUE, RED, YELLOW, WHITE, ABORT, DETONATE, PRESS, HOLD
}

enum Keypads implements Labeled, Flaggable {
    RACKET1("Empty Racket", false), A_T("A_T", false),
    STROKED_LAMBDA1("Lambda", false), HARRY_POTTER("Harry Potter", false),
    RUSSIAN_CAT1("Russian Cat", false), CURVY_H1("Curvy H", false),
    BACK_C1("BackwardsC", false),

    REVERSE_EURO1("Reverse Euro", false), RACKET2("Empty Racket", false),
    BACK_C2("BackwardsC", false), DISNEY_Q1("Disney Q", false),
    HOLLOW_STAR1("Hollow Star", false), CURVY_H2("Curvy H", false),
    SPANISH_QUESTION1("Spanish Question", false),

    COPYRIGHT("Copyright", false), THE_SAC("Sac", false),
    DISNEY_Q2("Disney Q", false), RUSSIAN_X1("Russian X", false),
    NOT_THREE("Not3", false), STROKED_LAMBDA2("Lambda", false),
    HOLLOW_STAR2("Hollow Star", false),

    RUSSIAN_SIX1("Russian 6", false),PARAGRAPH1("Paragraph", false),
    TB_1("Tb", false), RUSSIAN_CAT2("Russian Cat", false),
    RUSSIAN_X2("Russian X", false), SPANISH_QUESTION2("Spanish Question", false),
    SMILEY1("Smily", false),

    PSI1("Psi", false),SMILEY2("Smily", false), TB_2("Tb", false),
    C_DOT("C", false), PARAGRAPH2("Paragraph", false),
    ALIEN_THREE("Alien 3", false), STAR("Star", false),

    RUSSIAN_SIX2("Russian 6", false), REVERSE_EURO2("Reverse Euro", false),
    PUZZLE("Puzzle", false), AE("ae.PNG", false), PSI2("Psi", false),
    RUSSIAN_NH("Russian NH", false), OMEGA("Omega", false);

    private final String imageLocation;
    private boolean flag;

    Keypads(String label, boolean flag){
        this.flag = flag;
        imageLocation = label;
    }

    @Override
    public String getLabel() {
        return "file:src\\Symbols\\" + imageLocation + ".PNG";
    }

    @Override
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean getFlag() {
        return !flag;
    }
}

enum SimonSays implements Labeled{
    RED("R"), YELLOW("Y"), GREEN("G"), BLUE("B");

    private final String label;

    @Override
    public String getLabel() {
        return label;
    }

    SimonSays(String label){
        this.label = label;
    }
}

enum WhosOnFirstPictures implements Labeled{
    YES("Yes"), FIRST("First"), DISPLAY("Display"), OKAY("Okay"),
    SAYS("Says"), NO("No"), NOTHING("Nothing"), EMPTY("Empty"),
    BLANK("Blank"), LED("Led"),LEAD("Lead"), READ("Read"),
    RED("Red"), REED("Reed"), LEED("Leed"), HOLDON("Hold On"),
    YOU("You"), YOUARE("You Are.PNG"), YOUR("Your"), YOURE("You're"),
    UR("ur.PNG"),THERE("There"), THEIR("Their"), THEYRE("They're"),
    THEYARE("They Are"), SEE("See"),C("C"),CEE("Cee");

    private final String label;

    @Override
    public String getLabel() {
        return "file:src\\Step1_Panels\\" + label + ".PNG";
    }

    WhosOnFirstPictures(String location){
        label=location;
    }
}

enum WhosOnFirstWords implements Labeled, Listed{
    READY("READY","YES", "OKAY", "WHAT", "MIDDLE", "LEFT", "PRESS", "RIGHT", "BLANK", "READY"),
    FIRST("FIRST","LEFT", "OKAY", "YES", "MIDDLE", "NO", "RIGHT", "NOTHING", "UHHH", "WAIT", "READY",
            "BLANK", "WHAT", "PRESS", "FIRST"),
    NO("NO","BLANK", "UHHH", "WAIT", "FIRST", "WHAT", "READY", "RIGHT", "YES", "NOTHING", "LEFT",
            "PRESS", "OKAY", "NO"),
    BLANK("BLANK","WAIT", "RIGHT", "OKAY", "MIDDLE", "BLANK"),
    NOTHING("NOTHING","UHHH", "RIGHT", "OKAY", "MIDDLE", "YES", "BLANK", "NO", "PRESS", "LEFT", "WHAT",
            "WAIT", "FIRST", "NOTHING"),
    YES("YES","OKAY", "RIGHT", "UHHH", "MIDDLE", "FIRST", "WHAT", "PRESS", "READY", "NOTHING", "YES"),
    WHAT("WHAT","UHHH", "WHAT"),
    UHHH("UHHH","READY", "NOTHING", "LEFT", "WHAT", "OKAY", "YES", "RIGHT", "NO", "PRESS", "BLANK", "UHHH"),
    LEFT("LEFT","RIGHT", "LEFT"),
    RIGHT("RIGHT","YES", "NOTHING", "READY", "PRESS", "NO", "WAIT", "WHAT", "RIGHT"),
    MIDDLE("MIDDLE","BLANK", "READY", "OKAY", "WHAT", "NOTHING", "PRESS", "NO", "WAIT", "LEFT", "MIDDLE"),
    OKAY("OKAY","MIDDLE", "NO", "FIRST", "YES", "UHHH", "NOTHING", "WAIT", "OKAY"),
    WAIT("WAIT","UHHH", "NO", "BLANK", "OKAY", "YES", "LEFT", "FIRST", "PRESS", "WHAT", "WAIT"),
    PRESS("PRESS","RIGHT", "MIDDLE", "YES", "READY", "PRESS"),
    YOU("YOU","SURE", "YOU ARE", "YOUR", "YOU'RE", "NEXT", "UH HUH", "UR", "HOLD", "WHAT?", "YOU", "UH UH",
            "LIKE", "DONE", "U"),
    YOUARE("YOU ARE","YOUR", "NEXT", "LIKE", "UH HUH", "WHAT?", "DONE", "UH UH", "HOLD", "YOU", "U", "YOU'RE",
                   "SURE", "UR", "YOU ARE"),
    YOUR("YOUR","UH UH", "YOU ARE", "UH HUH", "YOUR"),
    YOURE("YOU'RE","YOU", "YOU'RE"),
    UR("UR","DONE", "U", "UR"),
    U("U","UH HUH", "SURE", "NEXT", "WHAT?", "YOU'RE", "UR", "UH UH", "DONE", "U"),
    UHHUH("UH HUH","UH HUH"),
    UHUH("UH UH","UR", "U", "YOU ARE", "YOU'RE", "NEXT", "UH UH"),
    WHATQ("WHAT?","YOU", "HOLD", "YOU'RE", "YOUR", "U", "DONE", "UH UH", "LIKE", "YOU ARE", "UH HUH", "UR",
            "NEXT", "WHAT?"),
    DONE("DONE","SURE", "UH HUH", "NEXT", "WHAT?", "YOUR", "UR", "YOU'RE", "HOLD", "LIKE", "YOU", "U",
            "YOU ARE"," UH UH", "DONE"),
    NEXT("NEXT","WHAT?", "UH HUH", "UH UH", "YOUR", "HOLD", "SURE", "NEXT"),
    HOLD("HOLD","YOU ARE", "U", "DONE", "UH UH", "YOU", "UR", "SURE", "WHAT?", "YOU'RE", "NEXT", "HOLD"),
    SURE("SURE","YOU ARE", "DONE", "LIKE", "YOU'RE", "YOU", "HOLD", "UH HUH", "UR", "SURE"),
    LIKE("LIKE","YOU'RE", "NEXT", "U", "UR", "HOLD", "DONE", "UH UH", "WHAT?", "UH HUH", "YOU", "LIKE");

    private final String label;
    private final String[] stream;

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String[] getWords() {
        return stream;
    }

    WhosOnFirstWords(String label, String ... wordStream){
        this.label = label;
        stream = wordStream;
    }
}

enum MazeTop implements Coordinate, Labeled{
    TOP_LEFT1(1,2, "Top Left"), TOP_MIDDLE1(2,4,"Top Middle"),
    TOP_RIGHT1(4, 4,"Top Right"), MIDDLE_LEFT1(1,1,"Middle Left"),
    CENTER1(5,3, "Center"), MIDDLE_RIGHT1(5,1,"Middle Right"),
    BOTTOM_LEFT1(2,1,"Bottom Left"), BOTTOM_MID1(4, 1, "Bottom Middle"),
    BOTTOM_RIGHT1(3,2,"Bottom Right"),

    TOP_LEFT2(6,3,"Top Left"), TOP_MIDDLE2(5,2,"Top Middle"),
    TOP_RIGHT2(6,4,"Top Right"), MIDDLE_LEFT2(1,4,"Middle Left"),
    CENTER2(4,6,"Center"), MIDDLE_RIGHT2(3,5,"Middle Right"),
    BOTTOM_LEFT2(2,6,"Bottom Left"), BOTTOM_MID2(3,4,"Bottom Middle"),
    BOTTOM_RIGHT2(1,5,"Bottom Right");

    private final int[] coordinates;
    private final String label;

    @Override
    public int[] getCoords() {
        return coordinates;
    }

    @Override
    public String getLabel() {
        return "file:src\\Mazes\\" + label + ".PNG";
    }

    MazeTop(int x, int y, String label){
        coordinates = new int[]{x ,y};
        this.label = label;
    }
}

enum MazeBottom implements Coordinate, Labeled{
    TOP_LEFT1(1,5,"Top Left"), TOP_MIDDLE1(2,3,"Top Middle"),
    TOP_RIGHT1(4,3,"Top Right"), MIDDLE_LEFT1(1,3,"Middle Left"),
    CENTER1(5,4,"Center"), MIDDLE_RIGHT1(5,6,"Middle Right"),
    BOTTOM_LEFT1(2,6,"Bottom Left"), BOTTOM_MID1(4,6,"Bottom Middle"),
    BOTTOM_RIGHT1(3,5,"Bottom Right"),

    TOP_LEFT2(6,4,"Top Left"), TOP_MIDDLE2(5,5,"Top Middle"),
    TOP_RIGHT2(6,3,"Top Right"), MIDDLE_LEFT2(1,6,"Middle Left"),
    CENTER2(4,1,"Center"), MIDDLE_RIGHT2(3,2,"Middle Right"),
    BOTTOM_LEFT2(2,1,"Bottom Left"), BOTTOM_MID2(3,3,"Bottom Middle"),
    BOTTOM_RIGHT2(1,2,"Bottom Right");

    private final int[] coordinates;
    private final String label;

    @Override
    public int[] getCoords() {
        return coordinates;
    }

    @Override
    public String getLabel() {
        return "file:src\\Mazes\\" + label + ".PNG";
    }

    MazeBottom(int x, int y, String label){
        coordinates = new int[]{x ,y};
        this.label = label;
    }
}

enum MazeLetNum implements Coordinate, Labeled{
    TOP_LEFT1(11,1,"Top Left"), TOP_MIDDLE1(11,5,"Top Middle"),
    TOP_RIGHT1(13,4,"Top Right"), MIDDLE_LEFT1(10,1,"Middle Left"),
    CENTER1(15,4,"Center"), MIDDLE_RIGHT1(10,5,"Middle Right"),
    BOTTOM_LEFT1(15,2,"Bottom Left"), BOTTOM_MID1(10,4,"Bottom Middle"),
    BOTTOM_RIGHT1(14,1,"Bottom Right"),

    TOP_LEFT2(12,6,"Top Left"), TOP_MIDDLE2(13,2,"Top Middle"),
    TOP_RIGHT2(13,6,"Top Right"), MIDDLE_LEFT2(13,1,"Middle Left"),
    CENTER2(12,5,"Center"), MIDDLE_RIGHT2(14,3,"Middle Right"),
    BOTTOM_LEFT2(10,2,"Bottom Left"), BOTTOM_MID2(13,3,"Bottom Middle"),
    BOTTOM_RIGHT2(11,3,"Bottom Right");

    private final int[] coordinates;
    private final String label;

    @Override
    public int[] getCoords() {
        return coordinates;
    }

    @Override
    public String getLabel() {
        return "file:src\\Mazes\\" + label + ".PNG";
    }

    MazeLetNum(int x, int y, String label){
        coordinates = new int[]{x ,y};
        this.label = label;
    }
}

enum MorseCodeLetter implements Labeled{
    A(".-", "a"), B("-...", "b"), C("-.-.", "c"),
    D("-..", "d"), E(".", "e"), F("..-.", "f"),
    G("--.", "g"), H("....", "h"), I("..", "i"),
    J(".---", "j"), K("-.-", "k"), L(".-..", "l"),
    M("--", "m"), N("-.", "n"), O("---", "o"),
    P(".--.", "p"), Q("--.-", "q"), R(".-.", "r"),
    S("...", "s"), T("-", "t"), U("..-", "u"),
    V("...-", "v"), W(".--", "w"), X("-..-", "x"),
    Y("-.--", "y"), Z("--..", "z");

    private final String label, letter;

    @Override
    public String getLabel() {
        return label;
    }

    public String getLetter(){
        return letter;
    }

    MorseCodeLetter(String dotDash, String letter){
        label = dotDash;
        this.letter = letter;
    }
}

enum MorseCodeFrequencies implements Labeled, Frequency {
    SHELL("shell", 3.505), HALLS("halls", 3.515), SLICK("slick", 3.522),
    TRICK("trick", 3.532), BOXES("boxes", 3.535), LEAKS("leaks", 3.542),
    STROBE("strobe", 3.545), BISTRO("bistro", 3.552), FLICK("flick", 3.555),
    BOMBS("bombs", 3.565), BREAK("break", 3.572), BRICK("brick", 3.575),
    STEAK("steak", 3.582), STING("sting", 3.592), VECTOR("vector", 3.595),
    BEATS("beats", 3.6);

    private final String label;
    private final double frequency;

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public double frequency() {
        return frequency;
    }

    MorseCodeFrequencies(String label, double hertz) {
        this.label = label;
        frequency = hertz;
    }
}