package aoc.year2022.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;

public class Day01 extends Day {

    static {
        currentDay = new Day01();
    }

    protected Day01() {
        super(1);
    }

    @Override
    public String part1(List<String> input) {
        return String.valueOf(sumElfCalories(input).stream().max(Integer::compareTo).orElseThrow());
    }

    @Override
    public String part2(List<String> input) {
        return "";
    }

    public List<Integer> sumElfCalories(List<String> input) {
        ArrayList<Integer> calories = new ArrayList<>();
        calories.add(0);
        return input.stream().collect(() -> calories, (list, item) -> {
            if (!item.isEmpty()) {
                list.set(list.size()-1, list.getLast() + Integer.parseInt(item));
            } else {
                list.add(0);
            };
        }, List::addAll);
    }
}
