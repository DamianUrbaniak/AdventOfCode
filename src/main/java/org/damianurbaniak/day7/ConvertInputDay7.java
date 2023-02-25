package org.damianurbaniak.day7;

import org.damianurbaniak.common.LoadInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertInputDay7 {
    public static List<Integer> crabsPosition(String filename) throws FileNotFoundException {
        Scanner sc = LoadInput.inputToFurtherManipulations(filename);
        List<Integer> list = new ArrayList<>();

        final String[] splittedInput = sc.nextLine().split(",");

        for (int i = 0; i < splittedInput.length; i++) {
            list.add(Integer.parseInt(splittedInput[i]));
        }
        return list;
    }
}
