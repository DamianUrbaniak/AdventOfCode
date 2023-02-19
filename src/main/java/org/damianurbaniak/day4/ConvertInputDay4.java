package org.damianurbaniak.day4;

import org.damianurbaniak.common.LoadInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertInputDay4 {
    public static List<int[][]> tablesForDay4(String filename) throws FileNotFoundException {
        final Scanner sc = LoadInput.inputToFurtherManipulations(filename);

        List<int[][]> tablesList = new ArrayList<>();
        int count = 0;
        int[][] bingoTable = new int[5][5];

        while (sc.hasNextLine()) {
            if (count == 0)
                bingoTable = new int[5][5];

            if (count < 5) {
                final String liner = sc.nextLine().strip().replace("  ", " ");
                final String[] line = liner.split(" ");

                for (int i = 0; i < line.length; i++) {
                    bingoTable[count][i] = Integer.parseInt(line[i]);
                }
                count++;
            }

            if (count == 6) {
                sc.nextLine();
                count = 0;
            }
            if (count == 5) {
                tablesList.add(bingoTable);
                count++;
            }
        }
        return tablesList;
    }

    public static List<Integer> numbersForDay4(String filename) throws FileNotFoundException {
        final Scanner sc = LoadInput.inputToFurtherManipulations(filename);

        List<Integer> listOfIntegers = new ArrayList<>();
        final String[] arrayOfNumbers = sc.nextLine().split(",");
        for (final String arrayOfNumber : arrayOfNumbers) {
            listOfIntegers.add(Integer.valueOf(arrayOfNumber));
        }
        return listOfIntegers;
    }
}
