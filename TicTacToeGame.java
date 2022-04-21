package main;
import java.util.*;

public class TicTacToeGame {

	//classe principale
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char [][] board = {{' ', ' ', ' ' },
				{' ', ' ', ' '},
				{' ', ' ', ' '}};
		printBoard(board);
		while (true)
		{
			playerTurn(board, scanner);
			if(isGameFInished(board))
			{
				break;
			}
			printBoard(board);
			computerTurn(board);
			if(isGameFInished(board))
			{
				break;
			}
			printBoard(board);
		}
		scanner.close();

	}

	//table de jeu
	private static void printBoard(char[][] board) {
		
		System.out.println(board[0][0]);
		System.out.println("|");
		System.out.println(board[0][1]);
		System.out.println("|");
		System.out.println(board[0][2]);
		System.out.println("-----");
		System.out.println(board[1][0]);
		System.out.println("|");
		System.out.println(board[1][2]);
		System.out.println("-----");
		System.out.println(board[2][0]);
		System.out.println("|");
		System.out.println(board[2][1]);
		System.out.println("|");
		System.out.println(board[2][2]);
	}
	
	//mouvements du joueur
	private static void placeMove(char[][] board, String position, char symbol)
	{
		switch (position)
		{
			case "1":
				board[0][0] = symbol;
			break;
			case "2":
				board[0][1] = symbol;
			break;
			case "3":
				board[0][2] = symbol;
			break;
			case "4":
				board[1][0] = symbol;
			break;
			case "5":
				board[1][1] = symbol;
			break;
			case "6":
				board[1][2] = symbol;
			break;
			case "7":
				board[2][0] = symbol;
			break;
			case "8":
				board[2][1] = symbol;
			break;
			case "9":
				board[2][2] = symbol;
			break;
			default :
				System.out.println(":(");
		}
	}


	//on verifie si le mouvement est valide
	private static boolean isValidMove(char[][] board, String position)
	{
		switch(position)
		{
			case "1" :
				return (board[0][0] == ' ');
			case "2" :
				return (board[0][1] == ' ');
			case "3" :
				return (board[0][2] == ' ');
			case "4" :
				return (board[1][0] == ' ');
			case "5" :
				return (board[1][1] == ' ');
			case "6" :
				return (board[1][2] == ' ');
			case "7" :
				return (board[2][0] == ' ');
			case "8" :
				return (board[2][1] == ' ');
			case "9" :
				return (board[2][2] == ' ');
			default :
				return false;
		}
	}

	//Tour du joueur
	private static void playerTurn(char [][] board, Scanner scanner)
	{
		String userInput;
		while (true)
		{
			System.out.println("Bougez !");
			userInput = scanner.nextLine();
			
			if(isValidMove(board, userInput))
			{
				break;
			} else {
				System.out.println (userInput + "Ce mouvement est invalide.");
			}
		}
		placeMove(board, userInput, 'X');
	}


	//tour de l'ordinateur
	private static void computerTurn(char [][] board)
	{
		Random rand = new Random();
		
		int computerMove;
		
		while (true)
		{
			computerMove = rand.nextInt(9) + 1;
			
			if (isValidMove(board, Integer.toString(computerMove)))
			{
				break;
			}
		}
		System.out.println("L'ordinateur a choisi" + computerMove);
		placeMove(board, Integer.toString(computerMove), '0');
		
	}

	//fin du jeu
	private static boolean isGameFInished(char[][] board)
	{
		if (hasContestantWon(board, 'X'))
		{
			printBoard(board);
			System.out.println("Vous avez gagné. BRAVO!");
			return true;
		}
		
		if(hasContestantWon(board, '0'))
		{
			printBoard(board);
			System.out.println("Vous etes nul a chier, meme pas capable de battre un robot. Vous etes la honte de l'humanité TFOUUU!!!");
			return true;
		}
		
		for(int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if(board[i][j] == ' ')
				{
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("Match nul. Mais t'es sérieux la ? sale nullard.");
		return true;
	}

	private static boolean hasContestantWon(char[][] board, char symbol) {
		
		if((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) || 
			(board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) || 
			(board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) || 
			(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) || 
			(board[0][1] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
			(board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) || 
			(board[0][0] == symbol && board[1][1] == symbol && board[2][0] == symbol))
		{
			return true;
		}
		return false;
	}

}
