package org.damianurbaniak.day6;

import org.damianurbaniak.common.LoadInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertInputDay6 {
    public static List<Integer> populationList(String filename) throws FileNotFoundException {
        ArrayList<Integer> population = new ArrayList<>();
        final Scanner sc = LoadInput.inputToFurtherManipulations(filename);

        String line = sc.nextLine();
        String[] list = line.split(",");

        for (int i = 0; i < list.length; i++) {
            population.add((Integer.parseInt(list[i])));
        }
        return population;
    }
}
