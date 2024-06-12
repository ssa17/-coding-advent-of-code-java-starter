package aoc.year2022.day01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01Test {

    @Test
    public void part1() {

        List<String> input = List.of("1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000");

        assertThat(new Day01(1).part1(input)).isEqualTo("24000");
    }

    @Test
    public void part1ElfCaloriesSummed() {

        List<String> input = List.of("1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000");

        assertThat(new Day01(1).sumElfCalories(input)).containsExactly(6000, 4000, 11000, 24000, 10000);
    }
}
