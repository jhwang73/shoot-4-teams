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

  public Generation(ArrayList<String > playerList, int generationCount, ArrayList<MatchUp> matchUpsList) {
    players = playerList;
    generationSize = generationCount;
    matchUps = matchUpsList;
  }

  public ArrayList<String> getPlayers() { return players; }

  public int getGenerationSize() { return generationSize; }

  public ArrayList<MatchUp> getMatchUps() { return matchUps; }

  /**
   * Returns a random generation of match ups. Use this for generation 0.
   * @param playerList
   * @param generationCount
   * @return
   */
  public static Generation randomGeneration(ArrayList<String> playerList, int generationCount) {
    ArrayList<MatchUp> matchUpsList = new ArrayList<MatchUp>();
    for (int i = 0; i < generationCount; i++) {
      matchUpsList.add(MatchUp.randomMatchUp(playerList));
    }
    return new Generation(playerList, generationCount, matchUpsList);
  }

  /**
   * Returns the next generation of match ups
   * @param playerList
   * @param prevGeneration
   * @param parents
   * @return
   */
  public static Generation breedNewGeneration(ArrayList<String > playerList, ArrayList<MatchUp> prevGeneration, int[] parents) {
    return null;
  }

  @Override
  public String toString() {
    return matchUps.stream().map(MatchUp::toString).toString();
  }

}
