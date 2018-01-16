package com.company;

import com.company.MatchUp;
import com.company.Generation;
import java.util.ArrayList;
import java.util.Arrays;
import com.company.MatchUp;

public class Main {

    public static void main(String[] args) {

//        Scan file should check that all names are unique
        // read file, get an ArrayList of the players
        // Make randomGeneration
        // have loop that does this.
        // present user gneeration.
        // ask if user is done. if yes, ask for which. present final thing
        // if no, ask for which ones they like. check that they are valid indices
        // breedGeneration with those parents


      ArrayList<String> test1 = new ArrayList<>(Arrays.asList("Jason", "Sam", "A", "B"));

      Generation test2 = Generation.randomGeneration(test1, 5);

      System.out.println(test2.toString());

    }
}
