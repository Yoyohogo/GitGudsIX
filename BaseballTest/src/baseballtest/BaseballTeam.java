/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballtest;

/**
 *
 * @author rodec8600
 */
public class BaseballTeam extends SportsTeam {

    int batters, pitchers, basemen;

    /**
     * Constructor 
     * PRE: wins, losses, ties, players, batters, pitchers, basemen
     * POST: a BaseballTeam object is created
     */
    public BaseballTeam(int win, int lose, int tie, int players, int batter, int pitcher, int baseman) {
        super(win, lose, tie, players);
        batters = batter;
        pitchers = pitcher;
        basemen = baseman;
    }

    /**
     * Calls a method to decide what player to add
     * PRE: a type of player
     * POST: a player is added
     */
    public void addPlayer(int type) {
        if (type == 0) {
            addBatter();
        } else if (type == 1) {
            addPitcher();
        } else if (type == 2) {
            addBaseman();
        } else {
            System.out.println("Please provide valid input.");
        }
        numPlayers ++;
    }

    /**
     * Calls a method to decide what player to remove
     * PRE: a type of player
     * POST: a player is removed 
     */
    public void removePlayer(int type) {
        if (type == 0) {
            removeBatter();
        } else if (type == 1) {
            removePitcher();
        } else if (type == 2) {
            removeBaseman();
        } else {
            System.out.println("Please provide valid input.");
        }
        numPlayers --;
    }
    
    /**
     * Adds a batter
     * PRE: none
     * POST: a batter is added
     */
    private void addBatter() {
        batters++;
    }

    /**
     * Adds a pitcher
     * PRE: none
     * POST: a pitcher is added
     */
    private void addPitcher() {
        pitchers++;
    }

    /**
     * Adds a basemen
     * PRE: none
     * POST: a basemen is added
     */
    private void addBaseman() {
        basemen++;
    }

    /**
     * Removes a batter
     * PRE: none
     * POST: a batter is removed
     */
    private void removeBatter() {
        batters --;
    }

    /**
     * Removes a pitcher
     * PRE: none
     * POST: a pitcher is removed
     */
    private void removePitcher() {
        pitchers --;
    }

    /**
     * Removes a baseman
     * PRE: none
     * POST: a baseman is removed
     */
    private void removeBaseman() {
        basemen --;
    }
}
