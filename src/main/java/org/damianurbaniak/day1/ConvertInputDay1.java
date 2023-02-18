package org.damianurbaniak.day1;

import org.damianurbaniak.common.LoadInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertInputDay1 {

    public static List<Integer> inputForDay1(String filename) throws FileNotFoundException {

        Scanner sc = LoadInput.inputToFurtherManipulations(filename);

        List<Integer> measurements = new ArrayList<>();

        while (sc.hasNextLine()) {
            measurements.add(sc.nextInt());
        }
        return measurements;
    }
}
