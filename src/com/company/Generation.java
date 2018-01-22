package com.company;

import com.company.MatchUp;

import java.util.*;

/**
 * A generation of multiple team match-ups.
 */
public class Generation {
  private final ArrayList<String> players;
  private final int generationSize;
  private ArrayList<MatchUp> matchUps;

  public Generation(ArrayList<String> playerList, int generationCount, ArrayList<MatchUp> matchUpsList) {
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
   * @return Generation instance
   */
  public static Generation randomGeneration(ArrayList<String> playerList, int generationCount) {
    ArrayList<MatchUp> matchUpsList = new ArrayList<MatchUp>();
    for (int i = 0; i < generationCount; i++) {
      matchUpsList.add(MatchUp.randomMatchUp(playerList));
    }
    return new Generation(playerList, generationCount, matchUpsList);
  }

  /**
   * Returns the next generation of match ups.
   * @param parents
   * @return Generation instance
   */
  public Generation breedNextGeneration(int[] parents) {
    Map<String, Map<String, Integer>> counts = makeCounts(parents);
    ArrayList<MatchUp> nextMatchUps = new ArrayList<MatchUp>();
    for (int i = 0; i < generationSize; i++) {
      nextMatchUps.add(MatchUp.childMatchUp(players, counts)
          // Mutate the matchUp
          .mutate());
    }
    return new Generation(players, generationSize, nextMatchUps);
  }

  /**
   * Returns the count of how many times every player was on the same team as every other player
   * @param parents
   * @return Nested mapping Player1:Player2:int
   */
  private Map<String, Map<String, Integer>> makeCounts(int[] parents) {
    Map<String, Map<String, Integer>> counts = new IdentityHashMap<>();

    // For every player
    for (String player:players) {
      Map<String, Integer> map1 = new IdentityHashMap<>();
      for (String teammate:players) {
        map1.put(teammate, 0);
      }
      counts.put(player, map1);
    }
    for (int parent:parents) {
      for (String teammate:matchUps.get(parent).getTeam1()) {
        for (String teammate2:matchUps.get(parent).getTeam1()) {
          counts.get(teammate).put(teammate2, counts.get(teammate).get(teammate2) + 1);
          counts.get(teammate2).put(teammate, counts.get(teammate2).get(teammate) + 1);
        }
      }
      for (String teammate:matchUps.get(parent).getTeam2()) {
        for (String teammate2:matchUps.get(parent).getTeam2()) {
          counts.get(teammate).put(teammate2, counts.get(teammate).get(teammate2) + 1);
          counts.get(teammate2).put(teammate, counts.get(teammate2).get(teammate) + 1);
        }
      }
    }

    return counts;
  }

  @Override
  public String toString() {
    String returnString = "";
    for (int i = 0; i < generationSize; i++) {
      returnString += "MatchUp #" + i + "\n" + matchUps.get(i).toString() + "\n" + "\n";
    }
    return returnString;
  }

}
