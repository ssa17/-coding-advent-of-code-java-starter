package aoc.year2022;

import aoc.Day;

import java.util.List;

public class Day16 extends Day {

    public static final String ROCK = "Rock";

    static {
        currentDay = new Day16();
    }

    public static void main(String[] args) {
        Day.main(args);
    }

    public Day16() {
        super(16);
    }

    @Override
    public String part1(List<String> input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= 30; i++) {
            stringBuilder
                    .append("== Minute ")
                    .append(i)
                    .append(" ==\n");

            if (input.getFirst().contains("Valve")) {
                stringBuilder
                        .append("You open valve ")
                        .append(input.getFirst(), 6, 8)
                        .append(".\n");
            } else {
                stringBuilder.append("No valves are open.\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String part2(List<String> input) {
        return null;
    }

}
