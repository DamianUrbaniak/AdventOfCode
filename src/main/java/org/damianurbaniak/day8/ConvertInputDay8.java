package org.damianurbaniak.day8;

import org.damianurbaniak.common.LoadInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConvertInputDay8 {
    public static List<Pair> input(String filename) throws FileNotFoundException {
        final Scanner sc = LoadInput.inputToFurtherManipulations(filename);
        List<Pair> data = new ArrayList<>();

        while (sc.hasNextLine()) {
            final String[] line = sc.nextLine().split(" ");
            data.add(new Pair(Arrays.copyOfRange(line, 0, 10), Arrays.copyOfRange(line, 11, 15)));
        }
        return data;
    }
    public record Pair(String[] uniqueSignalPatterns, String[] fourDigitOutput) {
    }
}
