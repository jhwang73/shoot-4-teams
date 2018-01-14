package com.company;

import com.company.MatchUp;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * A generation of multiple team match-ups.
 */
public class Generation {
  private final String[] players;
  private MatchUp[] matchUps;

  public Generation(String[] playersList) {
    players = playersList;
    matchUps = null;
  }

  public static Generation breedNewGeneration(String[] players, MatchUp[] prevGeneration, int[] parents) {
    return null;
  }

  @Override
  public String toString() {
    return Arrays.stream(matchUps)
        .map(MatchUp::toString).toString();
  }

}
