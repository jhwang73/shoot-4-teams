package test;

import com.company.MatchUp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class MatchUpTest {
  @Test
  public void testMatchUp() throws Exception {
    ArrayList<String> testT1 = new ArrayList<>(Arrays.asList("Jason", "Matthew"));
    ArrayList<String> testT2 = new ArrayList<>(Arrays.asList("Sam", "Phillip"));
    MatchUp testMU = new MatchUp(testT1, testT2);
    assertEquals("[Jason, Matthew]", testMU.getTeam1().toString());
    assertEquals("[Sam, Phillip]", testMU.getTeam2().toString());
  }

  @Test
  public void testToString() throws Exception {
    ArrayList<String> testT1 = new ArrayList<>(Arrays.asList("Jason"));
    ArrayList<String> testT2 = new ArrayList<>(Arrays.asList("Sam"));
    MatchUp testMU = new MatchUp(testT1, testT2);
    assertEquals("Team 1: [Jason]\n" + "Team 2: [Sam]", testMU.toString());
  }

  @Test
  public void testRandomMatchUp() throws Exception {
    ArrayList<String> testPL = new ArrayList<>(Arrays.asList("Jason", "Sam", "Matthew", "Phillip"));
    MatchUp testMU = MatchUp.randomMatchUp(testPL);
    System.out.println(testMU.toString());
  }

  @Test
  public void testChildMatchUP() throws Exception {

  }

  @Test
  public void testPlayerToTeam1() throws Exception {

  }

  @Test
  public void testMutate() throws Exception {

  }


}
