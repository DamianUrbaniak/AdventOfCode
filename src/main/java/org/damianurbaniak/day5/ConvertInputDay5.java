package org.damianurbaniak.day5;

import org.damianurbaniak.common.LoadInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertInputDay5 {
    public static List<SolvingMethodsDay5.Segment> loadSegmentsList(String filename) throws FileNotFoundException {
        List<SolvingMethodsDay5.Segment> segmentsList = new ArrayList<>();
        final Scanner sc = LoadInput.inputToFurtherManipulations(filename);


        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String lineAfterReplacing = line.replace(" -> ", ",");
            String[] coordinatesAsArray = lineAfterReplacing.split(",");

            int xa = Integer.parseInt(coordinatesAsArray[0]);
            int ya = Integer.parseInt(coordinatesAsArray[1]);
            int xb = Integer.parseInt(coordinatesAsArray[2]);
            int yb = Integer.parseInt(coordinatesAsArray[3]);

            segmentsList.add(new SolvingMethodsDay5.Segment(
                    new SolvingMethodsDay5.Point(xa, ya),
                    new SolvingMethodsDay5.Point(xb, yb)
            ));

        }
        return segmentsList;
    }
}
