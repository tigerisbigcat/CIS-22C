// 22C
// TTh 9:30-11:15
// Name : Lei Hao
// Suppose we have six players named 1, 2, 3, 4, 5, and 6.
// Further, suppose the rhyme has three words A, B, C.
// There will be five rounds played with one player eliminated in each round.
// In the following table, fill in the players next to the part of
// the rhyme they say in each round. Cross out the players as they are eliminated.

package com.company;

import java.io.*;
import java.util.*;

/**
 * CountingGame is a program that will simulate a children's counting game used to select
 * someone.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
    
public class CountingGame {

    public static void main(String args[]) {
        ListInterface<Integer> players = null;
        ListInterface<String> rhyme = null;

        int max;
        int position = 1;       // always start with the first player

        System.out.println("Please enter the number of players.");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        System.out.println("Constructing list of players");

        //Create a new Alist<Integer> and assign it to players.
        players = new AList<Integer>(max);
        for (int i = 1; i <= max; i++) {
            players.add(i, i);
        }

        System.out.println("The players list is " + players);

        rhyme = getRhyme();

        int startAt = 1;
        while (players.getLength() > 1) {
            startAt = doRhyme(players, rhyme, startAt);
        }

        System.out.println("The winner is " + players.getEntry(1));
    }

    /**
     * Do the rhyme with the players in the list and remove the selected
     * player.
     *
     * @param players A list holding the players.
     * @param rhyme   A list holding the words of the rhyme.
     * @param startAt A position to start the rhyme at.
     * @return The position of the player eliminated.
     */
    public static int doRhyme(ListInterface<Integer> players, ListInterface<String> rhyme, int startAt) {

        int removePlayerIndex = 0;

        // For each word in the rhyme
        for (int rhymeIndex = 1; rhymeIndex <= rhyme.getLength(); rhymeIndex++) {
            String word = rhyme.getEntry(rhymeIndex);

            int playerIndex = (rhymeIndex + startAt - 1) % players.getLength();
            int currentPlayer;
            if (playerIndex == 0) {
                currentPlayer = players.getEntry(players.getLength());
                removePlayerIndex = players.getLength();
            } else {
                currentPlayer = players.getEntry(playerIndex);
                removePlayerIndex = playerIndex;
            }

            // Print the word in the rhyme and the player that says it.
            System.out.println("Players " + currentPlayer + ": " + word);
        }

        // Print the name of the player to be removed.
        System.out.println("Removing player " + players.getEntry(removePlayerIndex));

        // Remove that player from the list.
        players.remove(removePlayerIndex);
        int nextRoundIndex;
        if (removePlayerIndex > players.getLength()) {
            nextRoundIndex = 1;
        } else {
            nextRoundIndex = removePlayerIndex;
        }
        // Return the index of the player that will start the next round.
        return nextRoundIndex;
    }

    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }
    
    /**
     * getRhyme - Get the rhyme.
     *
     * @return    A list of words that is the rhyme.
     */
    private static ListInterface<String> getRhyme()
    {
        Scanner input;
        String inString = "";
        ListInterface<String> rhyme = new AList<String>();
        
        try
        {
            input = new Scanner( System.in );
            
            System.out.println("Please enter a rhyme");
            inString = input.nextLine().trim();
            
            Scanner rhymeWords = new Scanner(inString);
            while(rhymeWords.hasNext())
            {
                rhyme.add(rhymeWords.next());
            }
            
        }
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use a rhyme of size one");
        }

        // Make sure there is at least one word in the rhyme
        if(rhyme.getLength() < 1)
            rhyme.add("Default");
            
        return (ListInterface<String>)rhyme;
                                    
    }
    
}
