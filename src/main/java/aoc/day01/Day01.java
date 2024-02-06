package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            Optional<Character> firstDigit = Optional.empty();
            char lastDigit = '0';

            for (char letter : word.toCharArray()) {
                if(Character.isDigit(letter)) {
                    if (firstDigit.isEmpty()) {
                        firstDigit = Optional.of(letter);
                    }
                    lastDigit = letter;
                }
            }
            runningTotal += Integer.parseInt(String.valueOf(firstDigit.orElseThrow()) + lastDigit);
        }

        return String.valueOf(runningTotal);
    }

    @Override
    public String part2(List<String> input) {
        return input.isEmpty() ? "" : input.get(0);
    }

}
