import java.util.Scanner;
public class RockPaperScissor 


public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in);
        RockPaperScissor object = new RockPaperScissor();
        int games = input.nextInt();
        System.out.println("Enter your choices : ");
        System.out.println("1. Rock\n2. Paper\n3. Scissors");
        String[] choices = new String[games];

        for (int i = 0; i < games; i++)
			{
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    choices[i] = "Rock";
                    break;
                case 2:
                    choices[i] = "Paper";
                    break;
                case 3:
                    choices[i] = "Scissors";
                    break;
                default:
                    System.out.println("Invalid input");
                    return;
            }
        }

        String[][] result = object.resultOfGame(choices);
        object.display(result);
    }
}

{
    public String getComputeChoice() 
	{
        int choice = (int) (Math.random() * 3);
        String []choices = {"Rock", "Paper", "Scissors"};
        return choices[choice];
    }

    public int whoWon(String usersChoice, String computersChoice)
	{
        if (usersChoice == computersChoice)
			{
            return 0;
			} 
			else if (usersChoice == "Rock") 
			{
            if (computersChoice == "Paper")
				{
                return -1;
            } 
			else
			{
                return 1;
            }
        } 
		else if (usersChoice == "Paper") 
		
		
		{
            if (computersChoice == "Scissors"
			{
                return -1;
            } 
			else 
			{
                return 1;
            }
        } 
		else
			{
            if (usersChoice == "Rock")
				{
                return -1;
            } 
			else 
			{
                return 1;
            }
        }
    }

    public String[][] resultOfGame(String[] usersChoices) 
	{
        String[][] result = new String[usersChoices.length][3];
        for (int i = 0; i < usersChoices.length; i++) 
		{
            result[i][0] = usersChoices[i];
            result[i][1] = getComputeChoice();

            int won = whoWon(result[i][0],result[i][1]);

            if (won == 0) 
			{
                result[i][2] = "Draw";
            }
			else if (won == 1) 
			{
                result[i][2] = "User won";
            } 
			else if (won == -1) 
			{
                result[i][2] = "Computer won";
            }
        }

        return result;
    }

    public void display(String[][] result) {
        int userWinCount = 0;
        System.out.printf("Users choise Computers choice result of game");
        
        for (int i = 0; i < result.length; i++) 
		{
            System.out.printf(result[i][0],result[i][1],result[i][2]);
            if (result[i][2]=="User won") 
			{
                userWinCount++;
            }
        }

        System.out.println("Percentage for user wins is " + (userWinCount * 100 / result.length) + " approx");
    }
    public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in);
        RockPaperScissor object = new RockPaperScissor();
        int games = input.nextInt();
        System.out.println("Enter your choices : ");
        System.out.println("1. Rock\n2. Paper\n3. Scissors");
        String[] choices = new String[games];

        for (int i = 0; i < games; i++)
			{
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    choices[i] = "Rock";
                    break;
                case 2:
                    choices[i] = "Paper";
                    break;
                case 3:
                    choices[i] = "Scissors";
                    break;
                default:
                    System.out.println("Invalid input");
                    return;
            }
        }

        String[][] result = object.resultOfGame(choices);
        object.display(result);
    }
}