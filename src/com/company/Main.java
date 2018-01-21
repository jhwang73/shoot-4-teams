package com.company;

import com.company.MatchUp;
import com.company.Generation;
import java.util.ArrayList;
import java.util.Arrays;
import com.company.MatchUp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

//        Scan file should check that all names are unique
      
      // Read player file
      ArrayList<String> players = new ArrayList<>();
      try {
        File f = new File("testPlayers.txt");
        BufferedReader b = new BufferedReader(new FileReader(f));
        String readLine = "";
        while ((readLine = b.readLine()) != null) {
          players.add(readLine);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      // Make a random Generation which is generation 0
      Generation generation0 = Generation.randomGeneration(players, 5);

      // have loop that does this.
      // present user gneeration.
      // ask if user is done. if yes, ask for which. present final thing
      // if no, ask for which ones they like. check that they are valid indices
      // breedGeneration with those parents

    }
}
