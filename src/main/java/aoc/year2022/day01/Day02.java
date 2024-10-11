package aoc.year2022.day01;

import aoc.Day;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 extends Day {

    static {
        currentDay = new Day02();
    }

    public static void main(String[] args) {
        Day.main(args);
    }

    public Day02() {
        super(2);
    }

    @Override
    public String part1(List<String> input) {
        int total = 0;
        int rock = 1;
        int paper = 2;
        int scissor = 3;
        int loss = 0;
        int draw = 3;
        int win = 6;

        Pattern pattern = Pattern.compile("([ABC]) ([XYZ])");
        for (String hand : input) {
            //    B _ X
            //   0 1 2 3
            Matcher matcher = pattern.matcher(hand);
            matcher.matches();
            String ourMove = matcher.group(2);
            String theirMove = matcher.group(1);
            total += switch (ourMove) {
                case "X" -> {
                    if (theirMove.equals("A")) {
                        yield rock + draw;
                    } else if (theirMove.equals("C")) {
                        yield rock + win;
                    }
                    yield rock;
                }
                case "Y" -> {
                    if (theirMove.equals("B")) {
                        yield paper + draw;
                    } else if (theirMove.equals("A")) {
                        yield paper + win;
                    }
                    yield paper;
                }
                case "Z" -> {
                    if (theirMove.equals("C")) {
                        yield scissor + draw;
                    } else if (theirMove.equals("B")) {
                        yield scissor + win;
                    }
                    yield scissor;
                }
                default -> loss;
            };
        }
        return String.valueOf(total);
    }

    @Override
    public String part2(List<String> input) {
        return null;
    }

}
