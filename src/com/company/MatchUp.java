package com.company;

import java.util.ArrayList;

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
          t2.addAll(currentNumP, playerList);
          break;
        } else if (t2CurrentNumP == t2NumP) {
          t1.addAll(currentNumP, playerList);
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

  @Override
  public String toString() {
    return "hi";
  }
}
