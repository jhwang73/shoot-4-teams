package com.company;

import java.util.ArrayList;
import java.util.Map;
/**
 * A match up of two teams.
 */
public class MatchUp {
  private ArrayList<String> team1;
  private ArrayList<String> team2;
  private final double MUTATIONRATIO = 0.2;

  public MatchUp(ArrayList<String> t1, ArrayList<String> t2) {
    team1 = t1;
    team2 = t2;
  }

  public ArrayList<String> getTeam1() { return team1; }

  public ArrayList<String> getTeam2() { return team2; }

  /**
   * Returns a random matchup.
   * @param playerList
   * @return
   */
  public static MatchUp randomMatchUp(ArrayList<String> playerList) {
    int numP = playerList.size();

    if (numP % 2 == 1) {
      throw new RuntimeException("There must be an even number of players!");
    } else {
      final int t1NumP = numP / 2;
      final int t2NumP = numP / 2;
      int t1CurrentNumP = 0;
      int t2CurrentNumP = 0;
      int currentNumP = 0;
      ArrayList<String> t1 = new ArrayList<>();
      ArrayList<String> t2 = new ArrayList<>();

      // Add the players randomly to one of the two teams
      while (currentNumP < numP) {
        if (t1CurrentNumP == t1NumP) {
          t2.addAll(playerList.subList(currentNumP, numP));
          break;
        } else if (t2CurrentNumP == t2NumP) {
          t1.addAll(playerList.subList(currentNumP, numP));
          break;
        } else {
          if (Math.random() < 0.5) {
            t1.add(playerList.get(currentNumP));
            t1CurrentNumP += 1;
            currentNumP += 1;
          } else {
            t2.add(playerList.get(currentNumP));
            t2CurrentNumP += 1;
            currentNumP += 1;
          }
        }
      }

      return new MatchUp(t1, t2);
    }
  }

  /**
   * Returns a match up that is formed using a nested mapping of players to players to int.
   * @param playerList
   * @param counts counts[player1][player2] contains the number of times player 1 was on the same team as player2
   *               in the matchups chosen when making the mapping.
   * @return
   */
  public static MatchUp childMatchUp(ArrayList<String> playerList, Map<String, Map<String, Integer>> counts) {
    int numP = playerList.size();

    if (numP % 2 == 1) {
      throw new RuntimeException("There must be an even number of players!");
    } else {
      final int t1NumP = numP / 2;
      final int t2NumP = numP / 2;
      int t1CurrentNumP = 0;
      int t2CurrentNumP = 0;
      int currentNumP = 0;
      ArrayList<String> t1 = new ArrayList<>();
      ArrayList<String> t2 = new ArrayList<>();

      // Add the players randomly to one of the two teams
      while (currentNumP < numP) {
        if (t1CurrentNumP == t1NumP) {
          t2.addAll(playerList.subList(currentNumP, numP));
          break;
        } else if (t2CurrentNumP == t2NumP) {
          t1.addAll(playerList.subList(currentNumP, numP));
          break;
        } else {
          String nextPlayer = playerList.get(currentNumP);
          if (playerToTeam1(nextPlayer, t1, t2, counts)) {
            t1.add(playerList.get(currentNumP));
            t1CurrentNumP += 1;
            currentNumP += 1;
          } else {
            t2.add(playerList.get(currentNumP));
            t2CurrentNumP += 1;
            currentNumP += 1;
          }
        }
      }

      return new MatchUp(t1, t2);
    }
  }

  /**
   * Returns true if the weighted random selection placed player in team1. False otherwise.
   * @param player
   * @param t1
   * @param t2
   * @param counts
   * @return
   */
  private static boolean playerToTeam1(String player, ArrayList<String> t1, ArrayList<String> t2, Map<String, Map<String, Integer>> counts) {
    int team1Total = t1.stream().mapToInt(teamMate -> counts.get(player).get(teamMate)).sum();
    int team2Total = t2.stream().mapToInt(teamMate -> counts.get(player).get(teamMate)).sum();
    int totalCount = team1Total + team2Total;

    // Simply add the counts, and perform a proportionally weighted coin toss
    return (int)(Math.random() * totalCount) < team1Total;
  }

  public MatchUp mutate() {
    ArrayList<String> newt1 = new ArrayList<>();
    ArrayList<String> newt2 = new ArrayList<>();
    for (int i = 0; i < team1.size(); i++) {
      if (Math.random() < MUTATIONRATIO) {
        newt1.add(team2.get(i));
        newt2.add(team1.get(i));
      } else {
        newt1.add(team1.get(i));
        newt2.add(team2.get(i));
      }
    }
    return new MatchUp(newt1, newt2);
  }

  @Override
  public String toString() {
    return team1.toString() + "\n" + team2.toString();
  }
}
