package org.damianurbaniak.day2;

import org.damianurbaniak.common.Message;
import org.damianurbaniak.common.Solutions;

import java.io.FileNotFoundException;
import java.util.List;

public class SolutionForDay2 {
    public static void main(String[] args) throws FileNotFoundException {
        final List<ConvertInputDay2.Pair> inputDay2 = ConvertInputDay2.inputForDay2("src/main/java/org/damianurbaniak/day2/inputDay2");
        final Solutions solutions = SolvingMethodsDay2.finalResult(inputDay2);

        System.out.println(Message.FIRST_PART_SOLUTION.getMessage());
        System.out.println(solutions.part1());
        System.out.println(Message.SECOND_PART_SOLUTION.getMessage());
        System.out.println(solutions.part2());

    }
}
