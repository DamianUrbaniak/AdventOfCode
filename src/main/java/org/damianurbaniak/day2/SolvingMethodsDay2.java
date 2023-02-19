package org.damianurbaniak.day2;

import org.damianurbaniak.common.Solutions;

import java.util.List;

public class SolvingMethodsDay2 {
    public enum Directions {

        FORWARD,
        UP,
        DOWN;
    }

    public static Solutions finalResult(List<ConvertInputDay2.Pair> pairList) {
        return new Solutions(setPositionPart1(pairList).toString(),
                setPositionPart2(pairList).toString());
    }

    private static Integer setPositionPart1(List<ConvertInputDay2.Pair> pairList) {

        int horizontal = 0;
        int depth = 0;
        for (int i = 0; i < pairList.size(); i++) {

            if (Directions.UP.toString().equals(pairList.get(i).direction().toUpperCase())) {
                depth -= pairList.get(i).fields();
            } else if (Directions.DOWN.toString().equals(pairList.get(i).direction().toUpperCase())) {
                depth += pairList.get(i).fields();
            } else {
                horizontal += pairList.get(i).fields();
            }
        }
        return depth * horizontal;
    }

    private static Integer setPositionPart2(List<ConvertInputDay2.Pair> pairList) {

        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for (int i = 0; i < pairList.size(); i++) {

            if (Directions.UP.toString().equals(pairList.get(i).direction().toUpperCase())) {
                aim -= pairList.get(i).fields();
            } else if (Directions.DOWN.toString().equals(pairList.get(i).direction().toUpperCase())) {
                aim += pairList.get(i).fields();
            } else {
                horizontal += pairList.get(i).fields();
                depth += aim * (pairList.get(i).fields());
            }
        }
        return depth * horizontal;
    }
}
