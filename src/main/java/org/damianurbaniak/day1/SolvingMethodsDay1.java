package org.damianurbaniak.day1;

import org.damianurbaniak.common.Solutions;

import java.util.List;

public class SolvingMethodsDay1 {
    public static Solutions finalResult(List<Integer> listToProcess) {
        return new Solutions(countMeasurementsIncrease(listToProcess).toString(),
                countThreeMeasurementsWindowIncrease(listToProcess).toString());
    }

    private static Integer countMeasurementsIncrease(final List<Integer> listToProcess) {
        int count = 0;
        for (int i = 0; i < listToProcess.size() - 1; i++) {
            if (listToProcess.get(i) < listToProcess.get(i + 1)) {
                count++;
            }
        }
        return count;
    }

    private static Integer countThreeMeasurementsWindowIncrease(final List<Integer> listToProcess) {
        int count = 0;
        for (int i = 0; i < listToProcess.size() - 3; i++) {
            int first = listToProcess.get(i) + listToProcess.get(i + 1) + listToProcess.get(i + 2);
            int second = listToProcess.get(i + 1) + listToProcess.get(i + 2) + listToProcess.get(i + 3);

            if (first < second) {
                count++;
            }
        }
        return count;
    }
}
