package org.damianurbaniak.day6;

import org.damianurbaniak.common.Message;

import java.io.FileNotFoundException;
import java.util.List;

public class SolutionForDay6 {
    public static void main(String[] args) throws FileNotFoundException {
        final List<Integer> inputDay6 = ConvertInputDay6.populationList("src/main/java/org/damianurbaniak/day6/inputDay6");
        SolvingMethodsDay6 smd6 = new SolvingMethodsDay6();

        System.out.println(Message.FIRST_PART_SOLUTION.getMessage());
        System.out.println(smd6.expectingResult(inputDay6, 80));
        System.out.println(Message.SECOND_PART_SOLUTION.getMessage());
        System.out.println(smd6.expectingResult(inputDay6, 256));
    }
}
