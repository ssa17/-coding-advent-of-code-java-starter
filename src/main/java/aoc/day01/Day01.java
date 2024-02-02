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
            char firstDigit = '0';
            char lastDigit = '0';

            for (char letter : word.toCharArray()) {
                if(Character.isDigit(letter)) {
                    firstDigit =letter;
                    break;
                }
            }
            for (int i = word.length(); i > 0 ; i--) {
                if(Character.isDigit(word.charAt(i-1))) {
                    lastDigit = word.charAt(i-1);
                    break;
                }
            }

            runningTotal += Integer.parseInt(String.valueOf(firstDigit) + lastDigit);
        }

        return String.valueOf(runningTotal);
    }

    @Override
    public String part2(List<String> input) {
        return input.isEmpty() ? "" : input.get(0);
    }

}
