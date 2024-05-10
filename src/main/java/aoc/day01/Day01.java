package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day01 extends Day {

    static {
        currentDay = new Day01();
    }

    public static void main(String[] args) {
        Day.main(args);
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
        input.forEach(line -> {
            String firstNumber = "";
            String secondNumber = "";

            // TODO: we should probably look at a nicer way to do this without using labelled loops
            outer: for (int offset = 0; offset < line.length(); offset++) {
                if (Character.isDigit(line.charAt(offset))) {
                    firstNumber = line.substring(offset, offset + 1);
                    break;
                } else {
                    for (Map.Entry<String, String> entry : numbers.entrySet()) {
                        String wordNumber = entry.getKey();
                        if (line.startsWith(wordNumber, offset)) {
                            firstNumber = entry.getValue();
                            break outer;
                        }
                    }
                }
            }

            outer: for (int offset = line.length() - 1; offset >= 0; offset--) {
                if (Character.isDigit(line.charAt(offset))) {
                    secondNumber = line.substring(offset, offset + 1);
                    break;
                } else {
                    for (Map.Entry<String, String> entry : numbers.entrySet()) {
                        String wordNumber = entry.getKey();
                        if (line.startsWith(wordNumber, offset)) {
                            secondNumber = entry.getValue();
                            break outer;
                        }
                    }
                }
            }

            if (firstNumber.isEmpty() && secondNumber.isEmpty()) {
                result.add(line);
            } else {
                result.add(firstNumber + secondNumber);
            }

        });
        return result;
    }
}
