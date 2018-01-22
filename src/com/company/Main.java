package com.company;

import com.company.MatchUp;
import com.company.Generation;
import java.util.ArrayList;
import java.util.Arrays;
import com.company.MatchUp;
import com.sun.tools.javah.Gen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  private static Scanner scanner = new Scanner( System.in );

  /**
   * Reads a textfile to a list of players. Checks for any duplicate names.
   * @param pathName
   * @return
   */
  private static ArrayList<String> readFileToPlayers(String pathName) {
    ArrayList<String> players = new ArrayList<>();
    try {
      File f = new File(pathName);
      BufferedReader b = new BufferedReader(new FileReader(f));
      String readLine = "";
      while ((readLine = b.readLine()) != null) {
        if (players.contains(readLine)) {
          throw new RuntimeException("All player names must be unique!");
        }
        players.add(readLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return players;
  }

  public static void main(String[] args) {

    // Read player file
    ArrayList<String> players = readFileToPlayers("testPlayers.txt");

    // Make a list of generations and make a random Generation which is generation 0
    ArrayList<Generation> generations = new ArrayList<>();
    Generation generation0 = Generation.randomGeneration(players, 5);
    generations.add(generation0);

    while (true) {
      System.out.println(generations.get(generations.size() - 1));
      System.out.println("Is there a team match up you want to use? y/n");
      String cont = scanner.nextLine();
      if (cont.toLowerCase().equals("y")) {
        System.out.println("Which match up? Input the number of the match up.");
        int chosen = scanner.nextInt();
        if (chosen >= 0 && chosen < players.size()) {
          System.out.println(generations.get(chosen));
          break;
        } else {
          System.out.println("Input a valid number");
          // Go back to line 59
        }
      } else if (cont.toLowerCase().equals("n")) {
        System.out.println("Which ones would you like to breed? Input the number(s) of the match up(s)");
        // Take numbers, check that they are valid
        // Breed, add new gen to generations, continue
      } else {
        System.out.println("Please type y or n");
        // back to line 55
      }
    }

  }
}
