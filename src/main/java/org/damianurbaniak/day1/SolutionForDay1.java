package org.damianurbaniak.day1;

import org.damianurbaniak.common.Message;
import org.damianurbaniak.common.Solutions;

import java.io.FileNotFoundException;
import java.util.List;


public class SolutionForDay1 {
    public static void main(String[] args) throws FileNotFoundException {
        final List<Integer> listToProcess = ConvertInputDay1.inputForDay1("src/main/java/org/damianurbaniak/day1/inputDay1");
        final Solutions solutions = SolvingMethodsDay1.finalResult(listToProcess);

        System.out.println(Message.FIRST_PART_SOLUTION.getMessage());
        System.out.println(solutions.part1());

        System.out.println(Message.SECOND_PART_SOLUTION.getMessage());
        System.out.println(solutions.part2());
    }
}
