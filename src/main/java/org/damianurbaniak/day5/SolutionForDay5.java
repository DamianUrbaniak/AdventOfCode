package org.damianurbaniak.day5;

import org.damianurbaniak.common.Message;
import org.damianurbaniak.common.Solutions;

import java.io.FileNotFoundException;
import java.util.List;
public class SolutionForDay5 {
    public static void main(String[] args) throws FileNotFoundException {
        List<SolvingMethodsDay5.Segment> segmentsList =
                ConvertInputDay5.loadSegmentsList("src/main/java/org/damianurbaniak/day5/inputDay5");

        final Solutions solutions = SolvingMethodsDay5.finalResult(segmentsList);
        System.out.println(Message.SECOND_PART_SOLUTION.getMessage());
        System.out.println(solutions.part2());
    }
}
