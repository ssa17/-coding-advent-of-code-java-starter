package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day01 extends Day {

    static {
        currentDay = new Day01();
    }

    private Map<String, String> numbers = Map.of(
            "one","1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9",
            "zero", "0"
    );

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

            outer: for (int i = 0; i < s.length(); i++) {
                for (Map.Entry<String, String> entry : numbers.entrySet()) {
                    if (s.startsWith(entry.getKey(), i)) {
                        s = s.replaceFirst(entry.getKey(), entry.getValue());
                        break outer;
                    }
                }
            }

            outer: for (int i = s.length(); i > 0; i--) {
                for (Map.Entry<String, String> entry : numbers.entrySet()) {
                    if (s.startsWith(entry.getKey(), i)) {
                        s = s.substring(0,i) + entry.getValue() + s.substring(i + entry.getKey().length());
                        break outer;
                    }
                }
            }

            result.add(s);
        });
        return result;
    }
}
