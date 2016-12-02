/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort2;

/**
 *
 * @author rodec8600
 */
public class Mergesort2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("List: ");
        int[] list = new int[7];
        int middle, length;
        middle = (list.length / 2) + 1;
        length = list.length;
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 25 + 1);
            System.out.print(list[i] + ",");
        }
        separate(list);

    }

    public static int[] separate(int list[]) {
        int length = list.length;
        int middle = (int) (list.length / 2);
        int[] tempL = new int[middle];
        int[] tempR = new int[list.length - middle];
        int[] sorted = new int[length];
        System.out.println("\nLeft: ");

        //Assigns left side to temp
        for (int i = 0; i < middle; i++) {
            tempL[i] = list[i];
            System.out.print(tempL[i] + " ");
        }

        if (tempL.length == 2) {
            for (int i = 0; i < tempL.length; i++) {
                System.out.println("\nTemp w/ two left values: ");
                System.out.println("" + tempL[i]);
                tempL=merge(tempL);
            }
        } else {
            if (tempL.length != 1) {
                separate(tempL);
            }
        }

        System.out.println("\nRight: ");
        for (int i = middle; i < list.length; i++) {
            tempR[i - middle] = list[i];
            System.out.print(tempR[i - middle] + " ");
        }

        if (tempR.length == 2) {
            for (int i = 0; i < tempR.length; i++) {
                System.out.println("\nTemp w/ two right values: ");
                System.out.println("" + tempR[i]);
                tempR=merge(tempR);
            }
        } else {
            separate(tempR);
        }
        
        return sorted;
    }

    private static int[] merge(int[] temp) {
        int hold;
        if (temp[0] > temp[1]) {
            hold = temp[1];
            temp[1] = temp[0];
            temp[0] = hold;
        }
        return temp;
    }
}
