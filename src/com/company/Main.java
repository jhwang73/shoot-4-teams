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
   * Reads a .txt file to a list of players. Checks for any duplicate names.
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

  /**
   * Return a list of generations with a random Generation for generation 0.
   * @param playerList
   * @param generationCount
   * @return
   */
  private static ArrayList<Generation> initializeGenerations(ArrayList<String> playerList, int generationCount) {
    ArrayList<Generation> generations = new ArrayList<>();
    Generation generation0 = Generation.randomGeneration(playerList, generationCount);
    generations.add(generation0);
    return generations;
  }

  public static void main(String[] args) {
    int generationCount = 2;
    String divide = "--------------------------------";

    // Read player file
    ArrayList<String> players = readFileToPlayers("testPlayers.txt");

    // Make a list of generations and make a random Generation which is generation 0
    ArrayList<Generation> generations = initializeGenerations(players, generationCount);
    int generationNumber = 0;

    while (true) {
      Generation currentGeneration = generations.get(generationNumber);
      // Ask if user is done.
      System.out.println(divide);
      System.out.println("Generation " + generationNumber);
      System.out.println(currentGeneration.toString());
      System.out.println("Is there a team match up you want to use? y/n");
      System.out.println(divide);
      String cont = scanner.nextLine();

      // If user is done, ask for which one and end the program.
      if (cont.toLowerCase().equals("y")) {
        System.out.println("Which match up? Input the number of the match up.");
        System.out.println(divide);
        int chosen = Integer.parseInt(scanner.nextLine());
        if (chosen >= 0 && chosen < generationCount) {
          System.out.println("Selected Match Up");
          System.out.println(currentGeneration.getMatchUps().get(chosen));
          System.out.println(divide);
          break;
        } else {
          System.out.println("ERROR: Please input a valid number! \n");
        }
      // If user is not done, ask for which ones to breed, breed, and repeat.
      } else if (cont.toLowerCase().equals("n")) {
        System.out.println("Which ones would you like to breed?" +
            " Input the number(s) of the match up(s), separated by spaces");
        String line = scanner.nextLine();
        String[] numberStrs = line.split(" ");
        int[] parents = new int[numberStrs.length];
        boolean allValid = true;
        for(int i = 0;i < numberStrs.length;i++)
        {
          int parentIdx = Integer.parseInt(numberStrs[i]);
          if (parentIdx >= 0 && parentIdx < generationCount) {
            parents[i] = Integer.parseInt(numberStrs[i]);
          } else {
            allValid = false;
            break;
          }
        }
        if (allValid) {
          generations.add(currentGeneration.breedNextGeneration(parents));
          generationNumber += 1;
        } else {
          System.out.println("ERROR: Please input valid numbers!");
        }
      } else {
        System.out.println("ERROR: Please type y or n.");
      }
    }

    System.out.println("Thank you for using Shoot 4 Teams!");

  }
}
