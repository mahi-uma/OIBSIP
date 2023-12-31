import java.util.Scanner;
import java.util.Random;
class Game { 
	public static boolean isPrime(int num){
		int flag=0;
		if(num<2){
			return false;
		}
		else{
			for(int i=2;i<num;i++){
				if(num%i==0){
					flag=0;
					break;
				}
				else{
					flag=1;
				}
			}
			if(flag==0){
				return false;
			}
			else{
				return true;
			}
		}
	}
	public static void hintFun(int n){
		if(n%2==0){
			System.out.println("\nHINT:Actual number is EVEN Number");
		}
		else{
			if(isPrime(n)){
				System.out.println("\nHINT:Actual number is PRIME Number");
			}
			else{
				System.out.println("\nHINT:Actual number is ODD Number");
			}
		}
	}
	public static void startgame(int max){
		int attempts=6;
		int u_attempts=1;
		int hint=1;
		Random random = new Random();
        Scanner s=new Scanner(System.in);
        int generated_no = random.nextInt(max);
		while(attempts!=0){
			System.out.println("Guess the number:");
			String guessed_no=s.next();
			if(guessed_no.equals("h")){
				attempts++;
				u_attempts--;
				if(hint!=0){
					hint--;
					hintFun(generated_no);
				}
				else{
					System.out.println("You have already used your hint option ...");
				}
			}
			else{
				int value=Integer.parseInt(guessed_no);
				if(value==-1){
					System.out.println("The Game is terminated........");
					break;
				}
				else if(value>100){System.out.println("The number is out of range");}
				else{
					if(value==generated_no){
						System.out.println("You WIN the game in "+u_attempts+"attempts\n\n");
						System.out.println("Your Score is "+(100/u_attempts));
						break;
					}
					else if(value>generated_no){
						System.out.println("Your guess is higher than actual number");
					}
					else{
						System.out.println("Your guess is lower than actual number");
					}
				}
			}
			
			attempts--;
			
			u_attempts++;
		}
		if(attempts==0){
			
			System.out.println("\n\nOOPS!!!....Number of attempts exceeded....\nyou loose the game....");
			
			System.out.println("The Score is 0");
			
			System.out.println("The actual number is "+generated_no);
		}
	}
	public static void main(String[] args) {
        
		Scanner s=new Scanner(System.in);
        
		int min,max;
        
		String ch;
        
		System.out.println("Before entering into the GAME you need to enter the range of numbers--->");
        
		System.out.println("\nEnter min range: ");
        
		min=s.nextInt();
        
		System.out.println("\nEnter max range: ");
        
		max=s.nextInt();
        
		System.out.println("\nNumber Guessing Game Ranges from "+min+" and "+max+"\n\n");
        
		System.out.println("Instructions are----->\n\n");
		
        System.out.println("********************************\n");
		
		System.out.println("1.You need to guess the number automatically generated by computer");
		
        
		System.out.println("\n2.You have only 6 attempts to guess the number");
        
		System.out.println("\n3.Score will be awarded at the end of the game ");
		
		System.out.println("\n4.If you want hint type h------>\n**NOTE:ONLY ONE HINT CAN BE GIVEN IN THE ENTIRE GAME**");
		
        System.out.println("\n5.If you want to quit the game in the middle type: -1\n");
		
		System.out.println("\nDo you want to start the game->(y/n):");
        
		ch=s.next();
        
		if(ch.equals("y")){
            
			startgame(max);
        
		}
        
		else{
            
			System.out.println("Game is Over...");
        
		}
    
	}
    
}









