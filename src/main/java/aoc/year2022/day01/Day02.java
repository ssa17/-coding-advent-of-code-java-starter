package aoc.year2022.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 extends Day {

    public static final String ROCK = "Rock";

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
//            Map<String, Set<String>> draws = Map.of("A", Set.of("X","L"), "B", "Y", "C", "Z");
//            Map<String, String> wins = Map.of("A", "Z", "B", "X", "C", "Y");
//
//            if (theirMove.equals(ROCK))

            ArrayList arrayList = new ArrayList();


            total += switch (ourMove) {
                case "X" -> {
                    int score = rock;
                    if (theirMove.equals("A")) {
                        score += draw;
                    } else if (theirMove.equals("C")) {
                        score += win;
                    }
                    else {
                        score += loss;
                    }
                    yield score;
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
//            total += ourMove.score() + ourMove.outcomeAgainst(theirMove).score();
        }
        return String.valueOf(total);
    }

    @Override
    public String part2(List<String> input) {
        return null;
    }

}
