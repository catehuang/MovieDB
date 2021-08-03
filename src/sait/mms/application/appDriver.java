package sait.mms.application;

import java.sql.SQLException;
import java.util.Scanner;

import sait.mms.managers.MovieManagementSystem;

public class appDriver {

	public static void main(String[] args) throws SQLException {
		MovieManagementSystem mms = new MovieManagementSystem();
		Scanner in = new Scanner(System.in);
		int selectedOption = 0;

		while (selectedOption != 5) {
			mms.displayMenu();
			selectedOption = Integer.parseInt(in.nextLine());
			System.out.println();			
			
			switch (selectedOption) {
				case 1: 
					mms.addMovie();
					break;
				case 2: 
					mms.printMoviesInYear();
					break;
				case 3: 
					mms.printRandomMovies();
					break;
				case 4: 
					mms.deleteMovie();
					break;
				case 5: 
					System.out.println("Goodbye!");
					break;
				default: 
					System.out.println("Invalid option. Please try it again.");
					System.out.println();
					break;
			}
		}
		in.close();
		
	}

}
