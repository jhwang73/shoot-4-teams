package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import com.company.MatchUp;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> test1 = new ArrayList<>(Arrays.asList("Jason", "Sam"));
        System.out.println(MatchUp.randomMatchUp(test1));

//        Scan file should check that all names are unique


    }
}
