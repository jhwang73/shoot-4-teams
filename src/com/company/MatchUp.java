package com.company;

import java.util.ArrayList;
import java.util.Map;
/**
 * A match up of two teams.
 */
public class MatchUp {
  private final int numPlayers;
  private ArrayList<String> team1;
  private ArrayList<String> team2;

  public MatchUp(int numP, ArrayList<String> playerList, ArrayList<String> t1, ArrayList<String> t2) {
    numPlayers = numP;
    team1 = t1;
    team2 = t2;
}

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

      return new MatchUp(numP, playerList, t1, t2);
    }
  }

  public static MatchUp childMatchUp(ArrayList<String> playerList, Map<String, Map<String, Integer>> probabilities) {
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
          if (playerToTeam1(nextPlayer, t1, t2, probabilities)) {
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

      return new MatchUp(numP, playerList, t1, t2);
    }
  }

  private static boolean playerToTeam1(String player, ArrayList<String> t1, ArrayList<String> t2, Map<String, Map<String, Integer>> probabilities) {
    int team1Total = t1.stream().mapToInt(teamMate -> probabilities.get(player).get(teamMate)).sum();
    int team2Total = t2.stream().mapToInt(teamMate -> probabilities.get(player).get(teamMate)).sum();
    int totalCount = team1Total + team2Total;

    return (int)(Math.random() * totalCount) < team1Total;
  }

  @Override
  public String toString() {
    return team1.toString() + "\n" + team2.toString();
  }
}
