package aoc.day01;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void testPart2(){
        // Given
        List<String> input = List.of("two1nine", "eightwothree", "abcone2threexyz", "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen");

        // When
        String result = new Day01().part2(input);

        // Then
        assertEquals("281", result);
    }

    @Test
    public void testFirstAndLastNumbersTakePriority(){
        // Given
        List<String> input = List.of("eightwoeighthree");

        // When
        String result = new Day01().part2(input);

        // Then
        assertEquals("83", result);
    }

    @Test
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
        List<String> result = new Day01().convertInput(input);

        // Then
        assertThat(result).containsExactly("29");
    }

    @Test
    void testOverlappingStrings() {
        // Given
        List<String> input = List.of("twoneonetwone");

        // When
        List<String> result = new Day01().convertInput(input);

        // Then
        assertThat(result).containsExactly("21");
    }

    @Test
    void testStringOne() {
        // Given
        List<String> input = List.of("one");

        // When
        List<String> result = new Day01().convertInput(input);


        // Then
        assertThat(result).containsExactly("11");
    }

    @Test
    void testStringOneOnPart2() {
        // Given
        List<String> input = List.of("one");

        // When
        String result = new Day01().part2(input);

        // Then
        assertThat(result).isEqualTo("11");
    }

    @Test
    void testConvertAllNumbers() {
        // Given
        List<String> input = List.of("onetwothreefourfivesixseveneightninezero");

        // When
        List<String> result = new Day01().convertInput(input);

        // Then
        assertThat(result).containsExactly("10");
    }

    @Test
    void testOverlapping() {
        // Given
        List<String> input = List.of("twone");

        // When
        String result = new Day01().part2(input);

        // Then
        assertThat(result).isEqualTo("21");
    }

    @Test
    void testPartTwoWithNoWords() {
        // Given
        List<String> input = List.of("11");

        // When
        String result = new Day01().part2(input);

        // Then
        assertThat(result).isEqualTo("11");
    }

    @Test
    void testDigitFirstThenString() {

        List<String> result = new Day01().convertInput(List.of("1one1"));

        assertThat(result).containsExactly("11");
    }

    @Test
    public void testPart2EachString(){
        assertEquals("29", new Day01().part2(List.of("two1nine")));
        assertEquals("83", new Day01().part2(List.of( "eightwothree")));
        assertEquals("13", new Day01().part2(List.of("abcone2threexyz")));
        assertEquals("24", new Day01().part2(List.of( "xtwone3four")));
        assertEquals("42", new Day01().part2(List.of("4nineeightseven2")));
        assertEquals("14", new Day01().part2(List.of("zoneight234")));
        assertEquals("76", new Day01().part2(List.of("7pqrstsixteen")));
    }
}
