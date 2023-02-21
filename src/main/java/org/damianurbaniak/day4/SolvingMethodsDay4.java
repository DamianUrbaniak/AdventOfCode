package org.damianurbaniak.day4;

import org.damianurbaniak.common.Solutions;

import java.util.List;

public class SolvingMethodsDay4 {
    public static Solutions finalResult(List<int[][]> tables, List<Integer> numbers) {
        return new Solutions(calculateResultPart1(tables, numbers).toString(),
                calculateResultPart2(tables, numbers).toString());
    }

    private static Integer calculateResultPart1(List<int[][]> tables, List<Integer> numbers) {
        final Results winningTable = findWinningTable(tables, numbers);
        int sumOfUnmarkedFields = sumOfAllNumbers(tables.get(winningTable.winningTable))
                - sumOfMarkedNumbers(tables.get(winningTable.winningTable), numbers, winningTable.attempts);
        return sumOfUnmarkedFields * numbers.get(winningTable.attempts);
    }

    private static Integer calculateResultPart2(List<int[][]> tables, List<Integer> numbers) {
        final Results loosingTable = findWinningLastWinTable(tables, numbers);
        int sumOfUnmarkedFields = sumOfAllNumbers(tables.get(loosingTable.winningTable))
                - sumOfMarkedNumbers(tables.get(loosingTable.winningTable), numbers, loosingTable.attempts);
        return sumOfUnmarkedFields * numbers.get(loosingTable.attempts);
    }

    private static Results findWinningTable(List<int[][]> tables, List<Integer> numbers) {
        int attempts = 100;
        int numberOfWinningTable = 0;
        for (int i = 0; i < tables.size(); i++) {
            if (decideResult(tables.get(i), numbers) < attempts) {
                attempts = decideResult(tables.get(i), numbers);
                numberOfWinningTable = i;
            }
        }
        return new Results(numberOfWinningTable, attempts);
    }

    private static Results findWinningLastWinTable(List<int[][]> tables, List<Integer> numbers) {
        int attempts = 0;
        int numberOfLastWinningTable = 0;
        for (int i = 0; i < tables.size(); i++) {
            if (decideResult(tables.get(i), numbers) > attempts) {
                attempts = decideResult(tables.get(i), numbers);
                numberOfLastWinningTable = i;
            }
        }
        return new Results(numberOfLastWinningTable, attempts);
    }

    private static int sumOfAllNumbers(int[][] table) {
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                sum += table[i][j];
            }
        }
        return sum;
    }

    private static int sumOfMarkedNumbers(int[][] table, List<Integer> numbers, int attempts) {
        int sum = 0;
        for (int k = 0; k <= attempts; k++) {
            for (int i = 0; i < table.length; i++) {
                if (isGivenNumberMatch(table[i], numbers.get(k))) {
                    sum += numbers.get(k);
                }
            }
        }
        return sum;
    }

    private static int[][] transpositionTable(int[][] table) {
        int[][] afterTransposition = new int[5][5];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                afterTransposition[j][i] = table[i][j];
            }
        }
        return afterTransposition;
    }

    private static int decideResult(int[][] table, List<Integer> numbers) {
        int[][] copyTable = table.clone();

        int attempts = 100;
        int checksCount = 0;

        for (int i = 0; i < copyTable.length; i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (isGivenNumberMatch(copyTable[i], numbers.get(j))) {
                    checksCount++;
                }
                if (checksCount == 5) {
                    checksCount = 0;
                    if (attempts > j)
                        attempts = j;
                    break;
                }
            }
        }
        int[][] tableAfterTransposition = transpositionTable(copyTable);

        for (int i = 0; i < tableAfterTransposition.length; i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (isGivenNumberMatch(tableAfterTransposition[i], numbers.get(j))) {
                    checksCount++;
                }
                if (checksCount == 5) {
                    checksCount = 0;
                    if (attempts > j)
                        attempts = j;
                    break;
                }
            }
        }
        return attempts;
    }

    private static boolean isGivenNumberMatch(int[] line, Integer number) {
        for (int i = 0; i < line.length; i++) {
            if (line[i] == number) {
                return true;
            }
        }
        return false;
    }

    record Results(int winningTable, int attempts) {
    }
}
