/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deckofcards;

import static java.lang.Math.ceil;
import java.util.Arrays;

/**
 *
 * @author VishnuPriya
 */
public class ShuffleCards
{    
    static int no_of_iterations = 1;
    static int no_of_rounds = 0;
    boolean same = false;  
    int n_copy = 0;
    int[] table_order = null;
    
    public ShuffleCards() 
    {
        
    }    
    public ShuffleCards(int no) 
    {
        this.table_order = new int[no];
    }
        
    public int[] Shuffle(int n,int[] cards,int[] original_order) throws Exception
    {
        int[] table = new int[(n+1)/2];
        int[] hand = new int[n/2]; 
        
        if((n>=1) && (same!=true))
        {
            int j=0,k=0;
            int Shuffle_No = 0;  
             for(int i=0;i<((n+1)/2);i++)            
             {  
                if((j<cards.length)&&(cards[j]!=0))
                {
                    table[i] = cards[j++];
                    k++;   
                }
                else
                 break;
                if((j<cards.length) && (cards[j]!=0))
                {            
                    hand[i] = cards[j++];
                }
                else
                 break;
            }
            if((no_of_iterations==1))
                System.arraycopy(table, 0, table_order, 0, k);                
            else
                System.arraycopy(table, 0, table_order, (n_copy), table.length);
            System.out.println("");             
            System.out.println("TABLE_ORDER_COPY:  ");
            for(int i=0; i<table_order.length; i++)
            {
                System.out.print("  "+table_order[i]+" ");
            }        
            System.out.println("");
            System.out.println("Table Order: ");
            for(int i=0; i<table.length; i++)
            {
                System.out.print("  "+table[i]+" ");
            }  
            System.out.println("");        
            System.out.println("Hand Order: ");
            for(int i=0; i<hand.length; i++)
            {
                System.out.print("  "+hand[i]+" ");
            }          

            no_of_iterations++;
            if(n%2==0)
            {
              n_copy = n_copy + ((n+1)/2);              
              Shuffle_No = ((n+1)/2);
            }
            else
            {
              n_copy = n_copy + (((n+1+1)/2));
              Shuffle_No = (((n+1)/2)-1);
            }
            
            if(Shuffle_No>=1)
            {
                Shuffle(Shuffle_No,hand,original_order);
                
            }
            else
            {
                
                    n_copy = 0;
                    return table_order;
            }    
         }       

        else
        {
              return table_order;            
        }           
        return table_order;
    }  
}
