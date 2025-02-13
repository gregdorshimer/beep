package org.gd;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.ArrayList;
import java.util.Scanner;

// see also: https://en.wikipedia.org/wiki/Piano_key_frequencies

// TODO features:
// TODO add support for posix OSs
// TODO convert to java sound api (parsing won't need to change)
// TODO make duration changeable
// TODO create a class that represents a piece of music--a list of notes with a tempo

public class Main {

    final static int DURATION = 500; // in milliseconds

    // get access to Kernel32 system calls
    public interface Kernel32 extends Library {
        // FREQUENCY is expressed in hertz and ranges from 37 to 32767
        // DURATION is expressed in milliseconds
        public boolean Beep(int FREQUENCY, int DURATION);
        public void Sleep(int DURATION);
    }

    private static void printInfoText() {
        final String INFO_TEXT =
                "Input notes to play sounds.\n" +
                        "Notes are a letter [A, G], a modifier [#, b, <none>], and an octave [0, 8], with no spaces.\n" +
                        "Multiple notes are separated by spaces.\n" +
                        "Notation represents keys on a standard 88-key piano.\n" +
                        "The lowest note is A0, and the highest, C8, with C being the lowest now in an octave (i.e. A0, B0, C1, D1...).\n" +
                        "Press 'q' to quit.";

        System.out.println(INFO_TEXT);
    }

    private static ArrayList<Note> parseInput(String input) {
        ArrayList<Note> notes = new ArrayList<>();
        for (String s : input.split(" ")) {
            if (s.length() != 2 && s.length() != 3) {
                throw new IllegalArgumentException("bad note input");
            }
            String pitch = s.substring(0, 1);
            String modifier;
            String octave;
            if (s.length() == 2) {
                modifier = null;
                octave = s.substring(1, 2);
            } else {
                modifier = s.substring(1, 2);
                octave = s.substring(2, 3);
            }
            try {
                notes.add(new Note(pitch, modifier, octave));
            } catch (RuntimeException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return notes;
    }

    public static void main(String[] args) {
//        System.getProperties().list(System.out);
//        String os = System.getProperty("os.name");

        Kernel32 lib = (Kernel32) Native.load("kernel32", Kernel32.class);
//        lib.Beep(523, 100);
//        lib.Sleep(900);
//        lib.Beep(587, 100);

        Scanner scanner = new Scanner(System.in);
        printInfoText();
        while (true) {
            System.out.print(">");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                return;
            }

            try {
                ArrayList<Note> notes = parseInput(input);

                for (Note note : notes) {
                    System.out.println(note.toString());
                    lib.Beep(note.getFreq(), DURATION);
                }
            } catch (RuntimeException e) {
                System.out.println(e.toString());
            }
        }
    }
}