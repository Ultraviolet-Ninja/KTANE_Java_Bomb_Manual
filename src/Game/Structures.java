package Game;

interface Labeled {
    String getLabel();
}

interface Coordinate {
    int[] getCoords();
}

interface Index{
    int getIdx();
}

interface Frequency{
    double frequency();
}

interface Flaggable{
    void setFlag(boolean flag);

    boolean getFlag();
}

interface Listed{
    String[] getWords();
}