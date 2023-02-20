package org.damianurbaniak.day3;

import org.damianurbaniak.common.Solutions;

import java.util.ArrayList;
import java.util.List;

public class SolvingMethodsDay3 {
    public static Solutions finalResult(List<char[]> list) {
        return new Solutions(calculatePowerConsumption(list).toString(), calculateRatings(list).toString());
    }

    private static Integer calculatePowerConsumption(List<char[]> list) {
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();

        for (int i = 0; i < list.get(i).length; i++) {
            final boolean oneMoreCommon = isOneMoreCommon(list, i);
            if (oneMoreCommon) {
                gammaRate.append('1');
                epsilonRate.append('0');
            } else {
                gammaRate.append('0');
                epsilonRate.append('1');
            }
        }
        return Integer.parseInt(epsilonRate.toString(), 2) *
                Integer.parseInt(gammaRate.toString(), 2);
    }

    private static Integer calculateRatings(List<char[]> list) {
        //creating separate lists for oxygen generator and CO2 scrubber ratings
        List<char[]> oxygenGenerator;
        List<char[]> CO2Scrubber;


        //decide which number occurs more often at the first position
        //distribute corresponding elements to the defined lists
        if (isOneMoreCommon(list, 0)) {
            oxygenGenerator = addElements(list, '1', 0);
            CO2Scrubber = addElements(list, '0', 0);
        } else {
            oxygenGenerator = addElements(list, '0', 0);
            CO2Scrubber = addElements(list, '1', 0);
        }

        //distribute rest elements regarding on specified column place with the same manner as previous step
        for (int i = 1; i < oxygenGenerator.get(0).length; i++) {
            if (oxygenGenerator.size() == 1) break;

            if (isOneMoreCommon(oxygenGenerator, i)) {
                oxygenGenerator = addElements(oxygenGenerator, '1', i);
            } else {
                oxygenGenerator = addElements(oxygenGenerator, '0', i);
            }
        }

        for (int i = 1; i < CO2Scrubber.get(0).length; i++) {
            if (CO2Scrubber.size() == 1) break;

            if (isOneMoreCommon(CO2Scrubber, i)) {
                CO2Scrubber = addElements(CO2Scrubber, '0', i);
            } else {
                CO2Scrubber = addElements(CO2Scrubber, '1', i);
            }
        }
        return Integer.parseInt(String.valueOf(oxygenGenerator.get(0)), 2) *
                Integer.parseInt(String.valueOf(CO2Scrubber.get(0)), 2);
    }

    //add elements which match with number at specified place
    private static List<char[]> addElements(List<char[]> list, char p, int column) {
        List<char[]> reducedList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[column] == p)
                reducedList.add(list.get(i));
        }
        return reducedList;
    }

    //check the number of occurrences of ones if there is more ones than zeros return true
    private static boolean isOneMoreCommon(List<char[]> list, int i) {
        int ones = 0;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j)[i] == '1') {
                ones++;
            }
        }
        return ones >= (list.size() - ones);
    }
}
