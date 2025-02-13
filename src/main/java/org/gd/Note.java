package org.gd;

import java.util.Map;

public class Note {
    private static final Map<String, Integer> pitches = Map.of("C", 1, "D", 3, "E", 5, "F", 6, "G", 8, "A", 10, "B", 12);
    private final String pitch;
    private static final Map<String, Integer> modifiers = Map.of("b", -1, "natural", 0, "#", 1);
    private final String modifier;
    private final int octave;
    private final int keyNumber;
    private final int freq;

    Note(String pitch, String modifier, String octave) {
        this(pitch, modifier, Integer.parseInt(octave));
    }

    Note(String pitch, String modifier, int octave) {

        // pitch
        if (pitches.containsKey(pitch)) {
            this.pitch = pitch;
        } else { throw new IllegalArgumentException("bad pitch in note constructor"); }

        // modifier
        if (modifier == null) {
            this.modifier = "natural";
        }
        else if ((((!modifiers.containsKey(modifier) ||
                (modifier.equals("b") && (pitch.equals("C") || pitch.equals("F")))) ||
                (modifier.equals("#") && (pitch.equals("B") || pitch.equals("E")))) ||
                ((modifier.equals("b") && pitch.equals("A")) && octave == 0)) ||
                ((modifier.equals("#") && (pitch.equals("C")) && octave == 8))) {
            throw new IllegalArgumentException("bad modifier in note constructor");
        } else { this.modifier = modifier; }


        // octave
        if ((octave < 0 || octave > 8) ||
                (octave == 0 && (!pitch.equals("A") && !pitch.equals("B"))) ||
                (octave == 8 && !pitch.equals("C"))) {
            throw new IllegalArgumentException("bad octave in note constructor");
        } else { this.octave = octave; }

        // keyNumber
        this.keyNumber = Note.calculateKeyNumber(this.pitch, this.modifier, this.octave);

        // freq
        this.freq = Note.calculateFreq(this.keyNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Note)) {
            return false;
        }

        return this.keyNumber == ((Note)obj).getKeyNumber();
    }

    @Override
    public String toString() {
        return this.getPitch() + (this.getModifier().equals("natural") ? "" : this.getModifier()) + this.getOctave();
    }

    private static int calculateKeyNumber(String pitch, String modifier, int octave) {
        return (octave * 12) - 9 + pitches.get(pitch) + modifiers.get(modifier);
    }

    private static int calculateFreq(int keyNumber) {
        // Using A4 (keyNumber = 49) tuned to 440Hz
        return (int)Math.round(Math.pow(2, ((double)keyNumber - 49) / 12) * 440);
    }

    String getPitch() {
        return this.pitch;
    }

    String getModifier() {
        return this.modifier;
    }

    int getOctave() {
        return this.octave;
    }

    int getKeyNumber() {
        return this.keyNumber;
    }

    int getFreq() {
        return this.freq;
    }
}
