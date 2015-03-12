/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deckofcards;
import java.io.*;
import java.sql.Array;
import java.util.Arrays;
/**
 *
 * @author VishnuPriya
 */
public class DeckOfCards 
{
    public static int No_Of_Cards;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        System.out.println("Enter the no of Cards to be shuffled: ");
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String n = br.readLine();        
        No_Of_Cards = Integer.parseInt(n);
        ShuffleCards sc = new ShuffleCards(No_Of_Cards);
        int[] cards = new int[No_Of_Cards];
        int[] original_order = new int[cards.length];
        int j=1;
        for(int i=0; i<No_Of_Cards; i++)
            cards[i] = j++;
        System.arraycopy(cards, 0, original_order, 0, No_Of_Cards);
        try
        {
            int[] temp = new int[No_Of_Cards];
            int no_of_iterations = 0;
            temp = sc.Shuffle(No_Of_Cards,cards,original_order);
            no_of_iterations = 1;
            System.out.println("Temp Array");
            for(int i=0; i<temp.length; i++)
            {
                System.out.print("  "+temp[i]+" ");
            }              
            while(Arrays.equals(temp,cards)==false)
            {                
                temp = sc.Shuffle(No_Of_Cards,temp,original_order);
                no_of_iterations++;
            }
            System.out.println("No of Rounds:   "+no_of_iterations);      
        }
        catch(Exception E)
        {
            E.printStackTrace();
            System.out.println("Exception Caught...!");
        }


    }
    
}
