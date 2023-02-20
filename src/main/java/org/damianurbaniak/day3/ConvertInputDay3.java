package org.damianurbaniak.day3;

import org.damianurbaniak.common.LoadInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertInputDay3 {
    public static List<char[]> inputForDay3(String filename) throws FileNotFoundException {
        final Scanner sc = LoadInput.inputToFurtherManipulations(filename);

        List<char[]> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            list.add(sc.nextLine().toCharArray());
        }
        return list;
    }
}
