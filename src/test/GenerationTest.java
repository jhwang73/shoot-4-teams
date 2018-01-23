package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import com.company.MatchUp;
import com.company.Generation;
import java.util.*;

import static org.junit.Assert.*;

public class GenerationTest {
  @Test
  public void testGeneration() throws Exception {
    ArrayList<String> testPL = new ArrayList<>(Arrays.asList("Jason", "Matthew", "Sam", "Phillip"));

    ArrayList<String> testT1 = new ArrayList<>(Arrays.asList("Jason", "Matthew"));
    ArrayList<String> testT2 = new ArrayList<>(Arrays.asList("Sam", "Phillip"));
    MatchUp testMU1 = new MatchUp(testT1, testT2);

    ArrayList<String> testT3 = new ArrayList<>(Arrays.asList("Jason", "Sam"));
    ArrayList<String> testT4 = new ArrayList<>(Arrays.asList("Matthew", "Phillip"));
    MatchUp testMU2 = new MatchUp(testT3, testT4);

    ArrayList<MatchUp> testMUL = new ArrayList<>(Arrays.asList(testMU1, testMU2));

    Generation testG = new Generation(testPL, 2, testMUL);

    assertEquals("[Jason, Matthew, Sam, Phillip]", testG.getPlayers().toString());
    assertEquals(2, testG.getGenerationSize());
    assertEquals("[Team 1: [Jason, Matthew]\n" +
        "Team 2: [Sam, Phillip], Team 1: [Jason, Sam]\n" +
        "Team 2: [Matthew, Phillip]]", testG.getMatchUps().toString());
  }

  @Test
  public void testToString() throws Exception {
    ArrayList<String> testPL = new ArrayList<>(Arrays.asList("Jason", "Matthew", "Sam", "Phillip"));

    ArrayList<String> testT1 = new ArrayList<>(Arrays.asList("Jason", "Matthew"));
    ArrayList<String> testT2 = new ArrayList<>(Arrays.asList("Sam", "Phillip"));
    MatchUp testMU1 = new MatchUp(testT1, testT2);

    ArrayList<String> testT3 = new ArrayList<>(Arrays.asList("Jason", "Sam"));
    ArrayList<String> testT4 = new ArrayList<>(Arrays.asList("Matthew", "Phillip"));
    MatchUp testMU2 = new MatchUp(testT3, testT4);

    ArrayList<MatchUp> testMUL = new ArrayList<>(Arrays.asList(testMU1, testMU2));

    Generation testG = new Generation(testPL, 2, testMUL);

    assertEquals("MatchUp #0\n" +
        "Team 1: [Jason, Matthew]\n" +
        "Team 2: [Sam, Phillip]\n" +
        "\n" +
        "MatchUp #1\n" +
        "Team 1: [Jason, Sam]\n" +
        "Team 2: [Matthew, Phillip]" +
        "\n" +
        "\n", testG.toString());
  }

  @Test
  public void testRandomGeneration() throws Exception {
    ArrayList<String> testPL = new ArrayList<>(Arrays.asList("Jason", "Matthew", "Sam", "Phillip"));
    Generation testRandomG = Generation.randomGeneration(testPL, 3);
    System.out.println(testRandomG.toString());
  }

  @Test
  public void testBreedGeneration() throws Exception {
    ArrayList<String> testPL = new ArrayList<>(Arrays.asList("Jason", "Matthew", "Sam", "Phillip"));

    ArrayList<String> testT1 = new ArrayList<>(Arrays.asList("Jason", "Matthew"));
    ArrayList<String> testT2 = new ArrayList<>(Arrays.asList("Sam", "Phillip"));
    MatchUp testMU1 = new MatchUp(testT1, testT2);

    ArrayList<String> testT3 = new ArrayList<>(Arrays.asList("Jason", "Sam"));
    ArrayList<String> testT4 = new ArrayList<>(Arrays.asList("Matthew", "Phillip"));
    MatchUp testMU2 = new MatchUp(testT3, testT4);

    ArrayList<MatchUp> testMUL = new ArrayList<>(Arrays.asList(testMU1, testMU2));

    Generation testG = new Generation(testPL, 2, testMUL);
    int[] parents = {0,1};
    Generation testBreedG = testG.breedNextGeneration(parents);

    System.out.println(testBreedG.toString());
  }
}
