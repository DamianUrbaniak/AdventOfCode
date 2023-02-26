package org.damianurbaniak.day8;

import org.damianurbaniak.common.Message;

import java.io.FileNotFoundException;
import java.util.List;

public class SolutionForDay8 {
    public static void main(String[] args) throws FileNotFoundException {
        final List<ConvertInputDay8.Pair> input = ConvertInputDay8.input("src/main/java/org/damianurbaniak/day8/inputDay8");

        System.out.println(Message.FIRST_PART_SOLUTION.getMessage());
        System.out.println(SolvingMethodsDay8.finalResult(input).part1());
        System.out.println(Message.SECOND_PART_SOLUTION.getMessage());
        System.out.println(SolvingMethodsDay8.finalResult(input).part2());
    }
}
