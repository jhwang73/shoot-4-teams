# shoot-4-teams

This is a personal project inspired by Karl Sims' paper 'Artifical Evolution for Computer Graphics'
http://www.karlsims.com/papers/siggraph91.html

# User Interface
Clone the repo, and run the main.java file to start the program! Simple user input process with directions.

## Definitions:
Player - a player is simply a unique string
Match Up - A match up is two disjoint equal-length lists of players. It is how two teams are divided.
Generation - A generation is a list of **x** Match Ups.

## Project Purpose:
To practice software engineering and algorithmic thinking skills learned in school.
Practically, given **n** players, there are **nC(n/2)** possible matchups.

## Project overview:
A match up can be thought of as an organism. The program begins with a random generation of match ups
given a list of players. The user then selects 1+ 'parent' organisms. These parents are then breeded together.
A new generation is presented back to the user, who can repeat this process indefinitely.

### The breeding process:
Let **p1,...,pn** be the selected parent organisms.
Let **x** be the number of match ups in the generation.
- For all **pi, pj**, where **i = 1,...,n. j = 1,...,i^,...,n**, compute **C(pi, pj)**.
  - **C(pi, pj)** is defined as the number of times player **pi** is on the same team as **pj** in all of the parent matchups.
  - Repeat the following process **x** times to produce the new generation:
    - Until one of the teams have **n/2** players, do the following:
      - Take a player **pnext** that has not yet been put in a team.
      - Compute **T1(pnext)** and **T2(pnext)**, where **Ty(pnext)** is the sum of **C(pnext, pj)** for all **pj** in **Ty**.
      - Randomly select a number **rand = [0, T1(pnext) + T2(pnext)]**.
      - If **rand < T1(pnext)**, place **pnext** in team 1. Otherwise, place it in team 2.
    - Put the remaining players into the incomplete team, if it exists.
    - Mutate the match up by swapping corresponding indices between the two teams at a given rate.
