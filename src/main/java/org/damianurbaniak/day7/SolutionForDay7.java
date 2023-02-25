package org.damianurbaniak.day7;

import org.damianurbaniak.common.Message;
import org.damianurbaniak.common.Solutions;

import java.io.FileNotFoundException;

public class SolutionForDay7 {
    public static void main(String[] args) throws FileNotFoundException {
        final Solutions solutions = SolvingMethodsDay7.finalResult(ConvertInputDay7.crabsPosition("src/main/java/org/damianurbaniak/day7/inputDay7"));

        System.out.println(Message.FIRST_PART_SOLUTION.getMessage());
        System.out.println(solutions.part1());
        System.out.println(Message.SECOND_PART_SOLUTION.getMessage());
        System.out.println(solutions.part2());
    }
}
