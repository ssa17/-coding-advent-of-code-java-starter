package aoc.year2022.day01;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02Test {

    @Test
    @Disabled
    public void testInput() {
        List<String> input = List.of("A Y", "B X", "C Z");

        assertThat(new Day02().part1(input)).isEqualTo("15");
    }
    // A X Rock
    // B Y Paper
    // C Z Scissors
    @Test
    void loseWithRock() {
        List<String> input = List.of("B X");

        assertThat(new Day02().part1(input)).isEqualTo("1");
    }

    @Test
    void loseWithPaper() {
        List<String> input = List.of("C Y");

        assertThat(new Day02().part1(input)).isEqualTo("2");
    }

    @Test
    void loseWithScissors() {
        List<String> input = List.of("A Z");

        assertThat(new Day02().part1(input)).isEqualTo("3");
    }

    @Test
    void threeLosses() {
        List<String> input = List.of("B X", "C Y", "A Z");

        assertThat(new Day02().part1(input)).isEqualTo("6");
    }

    @Test
    void threeDraws() {
        List<String> input = List.of("A X", "B Y", "C Z");

        assertThat(new Day02().part1(input)).isEqualTo("15");
    }

    @Test
    void threeWins() {
        List<String> input = List.of("C X", "A Y", "B Z");

        assertThat(new Day02().part1(input)).isEqualTo("24");
    }

    @Test
    void regex() {
        String generalPattern = "[ABC] [XYZ]";
        assertThat("A Z").matches(generalPattern);
        assertThat("B X").matches(generalPattern);
        assertThat("C Y").matches(generalPattern);
        assertThat("A Z".matches(generalPattern)).isTrue();

        String extractPattern = "([ABC]) ([XYZ])";
        Pattern pattern = Pattern.compile(extractPattern);
        Matcher matcher = pattern.matcher("A Z");
        assertThat(matcher.matches()).isTrue();
        assertThat(matcher.group(2)).isEqualTo("Z");
    }
}
