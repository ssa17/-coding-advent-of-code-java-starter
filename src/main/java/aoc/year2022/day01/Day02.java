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
        Pattern pattern = Pattern.compile("[ABC] ([XYZ])");
        for (String hand : input) {
            //    B _ X
            //   0 1 2 3
            Matcher matcher = pattern.matcher(hand);
            matcher.matches();
            String ourMove = matcher.group(1);
            switch (ourMove) {
                case "X":
                    total++;
                    break;
                case "Y":
                    total += 2;
                    break;
                case "Z":
                    total += 3;
                    break;
            }
        }
        return String.valueOf(total);
    }

    @Override
    public String part2(List<String> input) {
        return null;
    }

}
