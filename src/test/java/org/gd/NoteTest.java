package org.gd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class NoteTest {

    @Test
    void stringConstructorPitchTest() {
        Note note1 = new Note("G", "b", "4");
        Note note2 = new Note("A", "b", "1");
        Note note3 = new Note("C", "natural", "8");

        assertEquals("G", note1.getPitch());
        assertEquals("A", note2.getPitch());
        assertEquals("C", note3.getPitch());

        assertThrows(IllegalArgumentException.class, () -> new Note("b", "b", "1"), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("z", "b", "1"), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("Z", "b", "1"), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("AA", "b", "1"), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("!", "b", "1"), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("3", "b", "1"), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A A", "b", "1"), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("\n", "b", "1"), "bad pitch in note constructor");
        assertThrows(NullPointerException.class, () -> new Note(null, "b", "1"), "bad pitch in note constructor");
    }

    @Test
    void stringConstructorModifierTest() {
        Note note1 = new Note("G", "b", "4");
        Note note2 = new Note("A", "#", "1");
        Note note3 = new Note("C", "natural", "8");
        Note note4 = new Note("C", null, "8");

        assertEquals("b", note1.getModifier());
        assertEquals("#", note2.getModifier());
        assertEquals("natural", note3.getModifier());
        assertEquals("natural", note4.getModifier());

        assertThrows(IllegalArgumentException.class, () -> new Note("A", "flat", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "nat", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "sharp", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "\n", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "3", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "flatflat", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "flat flat", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("C", "flat", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("F", "flat", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "flat", "0"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("B", "#", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("E", "#", "4"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("C", "#", "8"), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("G", "natural", "8"), "bad modifier in note constructor");
    }

    @Test
    void stringConstructorOctaveTest() {
        Note note1 = new Note("G", "b", "4");
        Note note2 = new Note("A", "b", "1");
        Note note3 = new Note("C", "natural", "8");

        assertEquals(4, note1.getOctave());
        assertEquals(1, note2.getOctave());
        assertEquals(8, note3.getOctave());

        assertThrows(IllegalArgumentException.class, () -> new Note("A", "b", "50"), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "b", "-10"), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "b", "qqqq"), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("C", "natural", "0"), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("G", "natural", "0"), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "natural", "8"), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("D", "natural", "8"), "bad octave in note constructor");
    }

    @Test
    void stringConstructorKeyNumberTest() {
        Note note1 = new Note("A", "natural", "0");
        Note note2 = new Note("A", "#", "0");
        Note note3 = new Note("C", "natural", "8");
        Note note4 = new Note("A", "natural", "4");
        Note note5 = new Note("A", "b", "4");

        assertEquals(1, note1.getKeyNumber());
        assertEquals(2, note2.getKeyNumber());
        assertEquals(88, note3.getKeyNumber());
        assertEquals(49, note4.getKeyNumber());
        assertEquals(48, note5.getKeyNumber());
    }

    @Test
    void stringConstructorFrequencyTest() {
        Note note1 = new Note("A", "natural", "0");
        Note note2 = new Note("A", "#", "0");
        Note note3 = new Note("C", "natural", "8");
        Note note4 = new Note("A", "natural", "4");
        Note note5 = new Note("A", "b", "4");

        assertEquals(28, note1.getFreq());
        assertEquals(29, note2.getFreq());
        assertEquals(4186, note3.getFreq());
        assertEquals(440, note4.getFreq());
        assertEquals(415, note5.getFreq());
    }

    @Test
    void integerConstructorPitchTest() {
        Note note1 = new Note("G", "b", 4);
        Note note2 = new Note("A", "b", 1);
        Note note3 = new Note("C", "natural", 8);

        assertEquals("G", note1.getPitch());
        assertEquals("A", note2.getPitch());
        assertEquals("C", note3.getPitch());

        assertThrows(IllegalArgumentException.class, () -> new Note("b", "b", 1), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("z", "b", 1), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("Z", "b", 1), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("AA", "b", 1), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("!", "b", 1), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("3", "b", 1), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A A", "b", 1), "bad pitch in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("\n", "b", 1), "bad pitch in note constructor");
        assertThrows(NullPointerException.class, () -> new Note(null, "b", 1), "bad pitch in note constructor");
    }

    @Test
    void integerConstructorModifierTest() {
        Note note1 = new Note("G", "b", "4");
        Note note2 = new Note("A", "#", "1");
        Note note3 = new Note("C", "natural", "8");
        Note note4 = new Note("C", null, "8");

        assertEquals("b", note1.getModifier());
        assertEquals("#", note2.getModifier());
        assertEquals("natural", note3.getModifier());
        assertEquals("natural", note4.getModifier());

        assertThrows(IllegalArgumentException.class, () -> new Note("A", "flat", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "nat", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "sharp", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "\n", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "3", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "flatflat", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "flat flat", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("C", "flat", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("F", "flat", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "flat", 0), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("B", "#", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("E", "#", 4), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("C", "#", 8), "bad modifier in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("G", "natural", 8), "bad modifier in note constructor");
    }

    @Test
    void integerConstructorOctaveTest() {
        Note note1 = new Note("G", "b", "4");
        Note note2 = new Note("A", "b", "1");
        Note note3 = new Note("C", "natural", "8");

        assertEquals(4, note1.getOctave());
        assertEquals(1, note2.getOctave());
        assertEquals(8, note3.getOctave());

        assertThrows(IllegalArgumentException.class, () -> new Note("A", "b", 50), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "b", -10), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("C", "natural", 0), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("G", "natural", 0), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("A", "natural", 8), "bad octave in note constructor");
        assertThrows(IllegalArgumentException.class, () -> new Note("D", "natural", 8), "bad octave in note constructor");
    }

    @Test
    void integerConstructorKeyNumberTest() {
        Note note1 = new Note("A", "natural", 0);
        Note note2 = new Note("A", "#", 0);
        Note note3 = new Note("C", "natural", 8);
        Note note4 = new Note("A", "natural", 4);
        Note note5 = new Note("A", "b", 4);

        assertEquals(1, note1.getKeyNumber());
        assertEquals(2, note2.getKeyNumber());
        assertEquals(88, note3.getKeyNumber());
        assertEquals(49, note4.getKeyNumber());
        assertEquals(48, note5.getKeyNumber());
    }

    @Test
    void integerConstructorFrequencyTest() {
        Note note1 = new Note("A", "natural", 0);
        Note note2 = new Note("A", "#", 0);
        Note note3 = new Note("C", "natural", 8);
        Note note4 = new Note("A", "natural", 4);
        Note note5 = new Note("A", "b", 4);

        assertEquals(28, note1.getFreq());
        assertEquals(29, note2.getFreq());
        assertEquals(4186, note3.getFreq());
        assertEquals(440, note4.getFreq());
        assertEquals(415, note5.getFreq());
    }
}