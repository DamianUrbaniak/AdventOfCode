package org.damianurbaniak.day4;

import org.damianurbaniak.common.Message;

import java.io.FileNotFoundException;
import java.util.List;

public class SolutionForDay4 {
    public static void main(String[] args) throws FileNotFoundException {
        final List<int[][]> inputDay4_tables =
                ConvertInputDay4.tablesForDay4("src/main/java/org/damianurbaniak/day4/inputDay4_numbers");
        final List<Integer> inputDay4_numbers =
                ConvertInputDay4.numbersForDay4("src/main/java/org/damianurbaniak/day4/inputDay4_tables");

        System.out.println(Message.FIRST_PART_SOLUTION.getMessage());
        System.out.println(SolvingMethodsDay4.finalResult(inputDay4_tables, inputDay4_numbers).part1());
        System.out.println(Message.SECOND_PART_SOLUTION.getMessage());
        System.out.println(SolvingMethodsDay4.finalResult(inputDay4_tables, inputDay4_numbers).part2());
    }
}
