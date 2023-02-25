package org.damianurbaniak.day7;

import org.damianurbaniak.common.Solutions;

import java.util.List;

public class SolvingMethodsDay7 {
    public static Solutions finalResult(List<Integer> list) {
        Parameters parametersPart1 = smallestAmountOfFuelUsedPart1(list);
        String firstPartMessage = "Point in part 1: " + parametersPart1.point + ". " + "Fuel usage in part 1: " + parametersPart1.fuelUsage + " ";
        Parameters parametersPart2 = smallestAmountOfFuelUsedPart2(list);
        String secondPartMessage = "Point in part 2: " + parametersPart2.point + ". " + "Fuel usage in part 2: " + parametersPart2.fuelUsage;

        return new Solutions(firstPartMessage, secondPartMessage);
    }

    private static int sumOfAllElements(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int average(List<Integer> list) {
        return sumOfAllElements(list) / list.size();
    }

    private static Integer calculateTotalFuelPart1(List<Integer> list, int position) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .map(x -> Math.abs(x - position))
                .sum();
    }

    private static Integer calculateTotalFuelPart2(List<Integer> list, int position) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .map(x -> Math.abs(x - position))
                .map(x -> ((1 + x) * x) / 2)
                .sum();
    }

    private static Parameters smallestAmountOfFuelUsedPart1(List<Integer> list) {
        int fuelUsage = 1000000000;
        int point = 0;
        for (int i = 0; i < list.size(); i++) {
            if (calculateTotalFuelPart1(list, i) < fuelUsage) {
                fuelUsage = calculateTotalFuelPart1(list, i);
                point = i;
            }
        }
        return new Parameters(point, fuelUsage);
    }

    private static Parameters smallestAmountOfFuelUsedPart2(List<Integer> list) {
        int fuelUsage = 1000000000;
        int point = 0;
        for (int i = 0; i < list.size(); i++) {
            int totalFuel = calculateTotalFuelPart2(list, i);
            if (totalFuel < fuelUsage) {
                fuelUsage = totalFuel;
                point = i;
            }
        }
        return new Parameters(point, fuelUsage);
    }
    public record Parameters(int point, int fuelUsage) {
    }
}
