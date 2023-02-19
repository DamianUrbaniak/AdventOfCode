package org.damianurbaniak.day2;

import org.damianurbaniak.common.LoadInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertInputDay2 {

    public static List<Pair> inputForDay2(String filename) throws FileNotFoundException {

        Scanner sc = LoadInput.inputToFurtherManipulations(filename);

        List<Pair> list = new ArrayList<>();

        while (sc.hasNextLine()) {

            String[] line = sc.nextLine().split(" ");
            Pair pair = new Pair(line[0], Integer.parseInt(line[1]));
            list.add(pair);
        }
        return list;
    }

    public record Pair(String direction, Integer fields) {
    }
}
