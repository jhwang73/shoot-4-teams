package com.company;

import com.company.MatchUp;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * A generation of multiple team match-ups.
 */
public class Generation {
  private final ArrayList<String> players;
  private final int generationSize;
  private ArrayList<MatchUp> matchUps;

  public Generation(ArrayList<String > playerList, int generationCount) {
    players = playerList;
    generationSize = generationCount;
    matchUps = null;
  }

  /**
   * Returns the next generation of match ups
   * @param players
   * @param prevGeneration
   * @param parents
   * @return
   */
  public static Generation breedNewGeneration(ArrayList<String > players, ArrayList<MatchUp> prevGeneration, int[] parents) {
    return null;
  }

  @Override
  public String toString() {
    return matchUps.stream().map(MatchUp::toString).toString();
  }

}
