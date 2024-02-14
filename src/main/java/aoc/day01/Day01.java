package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;

public class Day01 extends Day {

    static {
        currentDay = new Day01();
    }

    public Day01() {
        super(1);
    }

    @Override
    public String part1(List<String> input) {
        int runningTotal = 0;

        for (String word : input) {
            word = word.replaceAll("\\D", "");

            runningTotal += Integer.parseInt(String.valueOf(word.charAt(0)) + word.charAt(word.length()-1));
        }
        return String.valueOf(runningTotal);
    }

    @Override
    public String part2(List<String> input) {
        return part1(convertInput(input));
    }

    public List<String> convertInput(final List<String> input) {
        List<String> result = new ArrayList<>();
        input.forEach(s -> {
            result.add(s
                    .replaceAll("one", "1")
                    .replaceAll("two", "2")
                    .replaceAll("three", "3")
                    .replaceAll("four", "4")
                    .replaceAll("five", "5")
                    .replaceAll("six", "6")
                    .replaceAll("seven", "7")
                    .replaceAll("eight", "8")
                    .replaceAll("nine", "9")
                    .replaceAll("zero", "0")
            );
        });
        return result;
    }
}
