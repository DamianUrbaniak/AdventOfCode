package org.damianurbaniak.day3;

import org.damianurbaniak.common.Message;
import org.damianurbaniak.common.Solutions;

import java.io.FileNotFoundException;
import java.util.List;

public class SolutionForDay3 {
    public static void main(String[] args) throws FileNotFoundException {
        final List<char[]> dataToProcess = ConvertInputDay3.inputForDay3("src/main/java/org/damianurbaniak/day3/inputDay3");
        final Solutions solutions = SolvingMethodsDay3.finalResult(dataToProcess);

        System.out.println(Message.FIRST_PART_SOLUTION.getMessage());
        System.out.println(solutions.part1());

        System.out.println(Message.SECOND_PART_SOLUTION.getMessage());
        System.out.println(solutions.part2());
    }
}
