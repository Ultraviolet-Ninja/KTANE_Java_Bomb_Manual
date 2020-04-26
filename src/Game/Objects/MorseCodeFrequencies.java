package Game.Objects;

import Game.Structures.Frequency;
import Game.Structures.Labeled;

public enum MorseCodeFrequencies implements Labeled, Frequency {
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