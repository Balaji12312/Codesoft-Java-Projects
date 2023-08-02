package atm;

import java.util.Scanner;  

public class atmInterface  
{  
    
 public static void main(String args[] )  
 {  
      
     int balance = 500000, withdrawing, depositing;  
       
       
     Scanner sc = new Scanner(System.in);  
       
     while(true)  
     {  
         System.out.println("SBI ATM");  
         System.out.println("Option 1 for Withdrawing");  
         System.out.println("Option 2 for Depositing");  
         System.out.println("Option 3 for Check my Bank Balance");  
         System.out.println("Option 4 for Exit");  
         System.out.print("Choose the Option you want to perform:");  
           
          
         int choice = sc.nextInt();  
         switch(choice)  
         {  
             case 1:  
     System.out.print("Enter Amount that  you are withdrawing:");  
                   
     
     withdrawing = sc.nextInt();  
                   

     if(balance >= withdrawing)  
     {  
         
         balance = balance - withdrawing;  
         System.out.println("collect your Amount");  
     }  
     else  
     {  
         
         System.out.println("Insufficient Amount");  
     }  
     System.out.println("");  
     break;  

             case 2:  
                   
     System.out.print("Enter Amount you are depositing:");  
                   
       
     depositing = sc.nextInt();  
                   
     
     balance = balance + depositing;  
     System.out.println("Your Amount is depsited");  
     System.out.println("");  
     break;  

             case 3:  
      
     System.out.println("Balance : "+balance);  
     System.out.println("");  
     break;  

             case 4:  
     
     System.exit(0);  
         }  
     }  
 }  
}  





