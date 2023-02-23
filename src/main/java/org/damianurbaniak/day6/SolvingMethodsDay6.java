package org.damianurbaniak.day6;

import java.util.List;

public class SolvingMethodsDay6 {
    public long expectingResult(List<Integer> input, int days) {
        Population population = new Population();
        Population populationToFurtherSimulations = distributeInput(input, population);
        performNCycles(populationToFurtherSimulations, days);
        return calculatePopulation(populationToFurtherSimulations);
    }

    private static void performNCycles(Population population, int days) {
        for (int i = 0; i < days; i++) {
            population.performCycle(population.firstCycle, population.restCycles);
        }
    }

    private static long calculatePopulation(Population population) {
        long totalPopulation = 0;
        for (int i = 0; i < population.firstCycle.length; i++) {
            totalPopulation += population.firstCycle[i];
        }

        for (int i = 0; i < population.restCycles.length; i++) {
            totalPopulation += population.restCycles[i];
        }
        return totalPopulation;
    }

    private static Population distributeInput(List<Integer> input, Population population) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == 1)
                population.restCycles[1]++;
            if (input.get(i) == 2)
                population.restCycles[2]++;
            if (input.get(i) == 3)
                population.restCycles[3]++;
            if (input.get(i) == 4)
                population.restCycles[4]++;
            if (input.get(i) == 5)
                population.restCycles[5]++;
        }
        return population;
    }

    private class Population {
        long[] firstCycle = new long[9];
        long[] restCycles = new long[7];

        private void performCycle(long[] firstCycle, long[] restCycles) {
            long newborns = firstCycle[0] + restCycles[0];

            for (int i = 0; i < firstCycle.length - 1; i++) {
                firstCycle[i] = firstCycle[i + 1];
            }
            firstCycle[8] = newborns;

            for (int i = 0; i < restCycles.length - 1; i++) {
                restCycles[i] = restCycles[i + 1];
            }
            restCycles[6] = newborns;
        }
    }
}
