/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baseballtest;

/**
 * Tests BaseballTeam, SportsTeam
 * @author rodec8600
 */
public class BaseballTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creates a BaseballTeam object, adds a win, a loss, and a tie
        //Then it displays them all!
        BaseballTeam BluBox = new BaseballTeam(0, 0, 0, 5, 1, 2, 2);
        
        System.out.println("BluBox Stats");
        System.out.println(BluBox.displayScore());
       
        System.out.println("But three days later...");
        
        BluBox.addWin();
        BluBox.addLoss();
        
        BluBox.addTie();
        System.out.println(BluBox.displayScore());
        
    }
    
}
