# shoot-4-teams

TODO: Edit, reformat, bullet/spacing for lists(processes in breeding). Consistent variable names

This is a personal project inspired by Karl Sims' paper 'Artifical Evolution for Computer Graphics'
http://www.karlsims.com/papers/siggraph91.html

Some definitions:
Player - a player is simply a unique string
Match Up - A match up is two disjoint equal-length lists of players. It is how two teams are divided.
Generation - A generation is a list of x Match Ups.

Project Purpose:
To practice software engineering skills learned in school.
Practically, given n players, there are nC(n/2) possible matchups.

Project overview:
A match up can be thought of as an organism. The program begins with a random generation of match ups
given a list of players. The user then selects two 'parent' organisms. These parents are then breeded together.
A new generation is presented back to the user, who can repeat this process indefinitely.

The breeding process:
Let p1,...,pn be the selected parent organisms.
Let x be the number of match ups in the generation.

For all pi i = 1,...,n, compute C(pi, pj) for all pj = 1,.i^..,n.
C(pi, pj) is defined as the number of times player pi is on the same team as pj in the previous generation of matchups.
After calculating C, repeat the following process x times to produce the new generation:
Place a random player into team 1.
Until one of the teams have n/2 players, do the following:
Take a player pnext that has not yet been put in a team.
Compute T1(pnext) and T2(pnext), where Ty(pnext) is the sum of C(pnext, pj) for all pj in Ty.
Randomly select a number rand in [0, T1(pnext) + T2(pnext)].
If rand < T1(pnext), place pnext into team 1. Otherwise, team 2.
Put the remaining players into the incomplete team, if it exists.