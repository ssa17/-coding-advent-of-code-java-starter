package aoc.year2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day16Test {

    @Test
    public void givenListOfEmptyStrings_printEachMinute() {
        int inputSize = 10;
        ArrayList<String> input = new ArrayList<>();
        for (int i = 0; i < inputSize; i++) {
            input.add("String " + i);
        }

        assertThat(new Day16().part1(input)).containsPattern("== Minute . ==\nNo valves are open.");
        assertThat(new Day16().part1(input)).containsIgnoringNewLines("Minute 1");
        assertThat(new Day16().part1(input)).containsIgnoringNewLines("Minute 2");
        assertThat(new Day16().part1(input)).containsIgnoringNewLines("Minute 10");
        assertThat(new Day16().part1(input)).containsIgnoringNewLines("Minute 25");
        assertThat(new Day16().part1(input)).containsIgnoringNewLines("Minute 30");
    }

    @Test
    public void givenSingleValve_returnValveOpened() {
        List<String> input = List.of("Valve AA has flow rate=1;");

        assertThat(new Day16().part1(input)).containsPattern("== Minute . ==\n");
        assertThat(new Day16().part1(input)).containsIgnoringNewLines("You open valve AA.");
    }

    @Test
    public void givenSingleValve_returnPressureValueOfValveAndOpenStatus() {
        List<String> input = List.of("Valve AA has flow rate=1;");

        assertThat(new Day16().part1(input)).containsPattern("== Minute . ==\n");
        assertThat(new Day16().part1(input)).containsIgnoringNewLines("You open valve AA.");
//        assertThat(new Day16().part1(input)).containsIgnoringNewLines("Valve AA is open, releasing 1 pressure.");
    }
}