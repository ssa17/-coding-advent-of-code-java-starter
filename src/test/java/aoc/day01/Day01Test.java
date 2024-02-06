package aoc.day01;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {

    @Test
    public void testPart1(){
        // Given
        List<String> input = new  ArrayList<>();
        input.add("1abc2");
        input.add("pqr3stu8vwx");
        input.add("a1b2c3d4e5f");
        input.add("treb7uchet");

        // When
        String result = new Day01().part1(input);

        // Then
        assertEquals("142", result);
    }


    @Test
    public void testPart1Line1(){
        // Given
        List<String> input = new  ArrayList<>();
        input.add("1abc2");

        // When
        String result = new Day01().part1(input);

        // Then
        assertEquals("12", result);
    }

    @Test
    void testPart1MultiLine2Digits() {
        // Given
        List<String> input = List.of("1abc2", "2abc3a");

        // When
        String result = new Day01().part1(input);

        // Then
        assertEquals("35", result);
    }

    @Test
    void testPart1MultiLineMoreThan2Digits() {
        // Given
        List<String> input = List.of("1ab23c2", "2a11bc3a");

        // When
        String result = new Day01().part1(input);

        // Then
        assertEquals("35", result);
    }

    @Test
    @Disabled
    public void testPart2(){
        // Given
        List<String> input = List.of("two1nine", "eightwothree", "abcone2threexyz", "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen");

        // When
        String result = new Day01().part2(input);

        // Then
        assertEquals("281", result);
    }

    @Test
    @Disabled
    public void testPart2SingleLine() {
        // Given
        List<String> input = List.of("two1nine");

        // When
        String result = new Day01().part2(input);

        // Then
        assertEquals("29", result);
    }

    @Test
    void convertsPartTwoInputToPartOneInput() {
        // Given
        List<String> input = List.of("two1nine");

        // When
        String result = new Day01().convertInput(input).getFirst();

        // Then
        assertEquals("219", result);
    }
}
