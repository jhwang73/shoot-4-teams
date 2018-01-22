package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GenerationTest {
  @Test
  public void testGeneration() throws Exception {
    ArrayList<String> testT1 = new ArrayList<>(Arrays.asList("Jason", "Matthew"));
    ArrayList<String> testT2 = new ArrayList<>(Arrays.asList("Sam", "Phillip"));
    MatchUp testMU = new MatchUp(testT1, testT2);
    assertEquals("[Jason, Matthew]", testMU.getTeam1().toString());
    assertEquals("[Sam, Phillip]", testMU.getTeam2().toString());
  }
}
