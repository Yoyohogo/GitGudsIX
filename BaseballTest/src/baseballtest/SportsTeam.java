/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baseballtest;

/**
 * SportsTeam abstract class
 * @author rodec8600
 */
abstract class SportsTeam {
    
    int wins, losses, ties, numPlayers;
    
    /**
     * Constructor
     * PRE: number of wins, number of losses, number of ties, number of players
     * POST: a SportsTeam object is created
     */
    public SportsTeam(int win, int lose, int tie, int players) {
        wins = win;
        losses = lose;
        ties = tie;
        numPlayers = players;
    }
    
    /**
     * Adds a win
     * PRE: none
     * POST: a win is added
     */
    public void addWin() {
        wins ++;
    }
    
    /**
     * Adds a loss
     * PRE: none
     * POST: a loss is added
     */
    public void addLoss() {
        losses ++;
    }
    
    /**
     * Adds a tie
     * PRE: none
     * POST: a tie is added
     */
    public void addTie() {
        ties ++;
    }
    
    /**
     * Displays wins, losses and ties of the team
     * PRE: none
     * POST: stats are displayed
     */
    public String displayScore() {
        String output = "Wins\t" + wins;
        output += "\nLosses\t" + losses;
        output += "\nTies\t" + ties;
        
        return output;
    }
 
    //abstract void addPlayer();
    
    //abstract void removePlayer();
}
