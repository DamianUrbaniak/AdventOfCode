package org.damianurbaniak.day8;

import org.damianurbaniak.common.Solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolvingMethodsDay8 {
    public static Solutions finalResult(List<ConvertInputDay8.Pair> list) {
        return new Solutions(occurrencesPart1(list).toString(), occurrencesPart2(list).toString());
    }

    private static Integer occurrencesPart2(List<ConvertInputDay8.Pair> list) {
        Integer sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += Integer.parseInt(findValue(decipherizedDigits(list.get(i)),
                    list.get(i).fourDigitOutput()));
        }
        return sum;
    }

    private static Integer occurrencesPart1(List<ConvertInputDay8.Pair> list) {
        Integer occurrences = 0;
        for (int i = 0; i < list.size(); i++) {
            String[] fdo = list.get(i).fourDigitOutput();
            for (int j = 0; j < fdo.length; j++) {
                if (checkIfItsSimplyDigit(fdo[j])) {
                    occurrences++;
                }
            }
        }
        return occurrences;
    }

    private static boolean checkIfItsSimplyDigit(String ssd) {
        if (ssd.length() == SimplyDigits.ONE.getMessage() ||
                ssd.length() == SimplyDigits.FOUR.getMessage() ||
                ssd.length() == SimplyDigits.SEVEN.getMessage() ||
                ssd.length() == SimplyDigits.EIGHT.getMessage())
            return true;
        return false;
    }

    private static Map<Integer, String> decipherizedDigits(ConvertInputDay8.Pair pair) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < pair.uniqueSignalPatterns().length; i++) {
            if (pair.uniqueSignalPatterns()[i].length() == 2)
                map.put(1, pair.uniqueSignalPatterns()[i]);
            if (pair.uniqueSignalPatterns()[i].length() == 3)
                map.put(7, pair.uniqueSignalPatterns()[i]);
            if (pair.uniqueSignalPatterns()[i].length() == 4)
                map.put(4, pair.uniqueSignalPatterns()[i]);
            if (pair.uniqueSignalPatterns()[i].length() == 7)
                map.put(8, pair.uniqueSignalPatterns()[i]);
        }

        for (int i = 0; i < pair.uniqueSignalPatterns().length; i++) {
            //zero
            if (compareStrings(map.get(7), pair.uniqueSignalPatterns()[i]).size() == 3 &&
                    compareStrings(map.get(1), pair.uniqueSignalPatterns()[i]).size() == 4 &&
                    compareStrings(map.get(4), pair.uniqueSignalPatterns()[i]).size() == 4 &&
                    pair.uniqueSignalPatterns()[i].length() == 6)
                map.put(0, pair.uniqueSignalPatterns()[i]);
            //nine
            if (compareStrings(map.get(1), pair.uniqueSignalPatterns()[i]).size() == 4 &&
                    compareStrings(map.get(4), pair.uniqueSignalPatterns()[i]).size() == 2 &&
                    compareStrings(map.get(7), pair.uniqueSignalPatterns()[i]).size() == 3 &&
                    pair.uniqueSignalPatterns()[i].length() == 6)
                map.put(9, pair.uniqueSignalPatterns()[i]);
            //six
            if (compareStrings(map.get(1), pair.uniqueSignalPatterns()[i]).size() == 6 &&
                    compareStrings(map.get(4), pair.uniqueSignalPatterns()[i]).size() == 4 &&
                    compareStrings(map.get(7), pair.uniqueSignalPatterns()[i]).size() == 5 &&
                    pair.uniqueSignalPatterns()[i].length() == 6)
                map.put(6, pair.uniqueSignalPatterns()[i]);
            //two
            if (compareStrings(map.get(1), pair.uniqueSignalPatterns()[i]).size() == 5 &&
                    compareStrings(map.get(4), pair.uniqueSignalPatterns()[i]).size() == 5 &&
                    compareStrings(map.get(7), pair.uniqueSignalPatterns()[i]).size() == 4 &&
                    pair.uniqueSignalPatterns()[i].length() == 5)
                map.put(2, pair.uniqueSignalPatterns()[i]);
            //three
            if (compareStrings(map.get(1), pair.uniqueSignalPatterns()[i]).size() == 3 &&
                    compareStrings(map.get(4), pair.uniqueSignalPatterns()[i]).size() == 3 &&
                    compareStrings(map.get(7), pair.uniqueSignalPatterns()[i]).size() == 2 &&
                    pair.uniqueSignalPatterns()[i].length() == 5)
                map.put(3, pair.uniqueSignalPatterns()[i]);
            //five
            if (compareStrings(map.get(1), pair.uniqueSignalPatterns()[i]).size() == 5 &&
                    compareStrings(map.get(4), pair.uniqueSignalPatterns()[i]).size() == 3 &&
                    compareStrings(map.get(7), pair.uniqueSignalPatterns()[i]).size() == 4 &&
                    pair.uniqueSignalPatterns()[i].length() == 5)
                map.put(5, pair.uniqueSignalPatterns()[i]);
        }
        return map;
    }

    private static String findValue(Map<Integer, String> map, String[] array) {
        StringBuilder number = new StringBuilder("");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < map.size(); j++) {
                if (compareStrings(map.get(j), (array[i])).isEmpty())
                    number.append(j);
            }
        }
        return number.toString();
    }

    private static Set<Character> compareStrings(String str1, String str2) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (str2.indexOf(c) == -1) {
                uniqueChars.add(c);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (str1.indexOf(c) == -1) {
                uniqueChars.add(c);
            }
        }
        return uniqueChars;
    }
}
