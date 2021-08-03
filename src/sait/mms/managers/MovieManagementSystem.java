package sait.mms.managers;

import java.sql.*;
import java.util.*;

import sait.mms.drivers.MariaDBDriver;

public class MovieManagementSystem {
	MariaDBDriver md = new MariaDBDriver();
	String sqlQuery;
	Scanner in = new Scanner(System.in);

	public void displayMenu() throws SQLException {
		System.out.println("Jim's Movie Manager");
		System.out.println("1\tAdd New Movie");
		System.out.println("2\tPrint movies released in year");
		System.out.println("3\tPrint random list of movies");
		System.out.println("4\tDelete a movie");
		System.out.println("5\tExit");
		System.out.println("");
		System.out.printf("Enter an option: ");
	}

	public void addMovie() throws SQLException {
		md.connect();

		try {
			System.out.printf("Enter movie title: ");
			String title = in.nextLine();
			System.out.printf("Enter duration: ");
			int duration = Integer.parseInt(in.nextLine());
			System.out.printf("Enter year: ");
			int year = Integer.parseInt(in.nextLine());

			sqlQuery = "INSERT INTO Movies " + "(duration, title, year) " + "VALUES (" + duration + ", '" + title
					+ "', " + year + ")";

			int row = md.update(sqlQuery);
			if (row == 1) {
				System.out.println("Added movie to database.");
			} else {
				System.out.println("*Failed to add movie to database*");
			}

			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		md.disconnect();
	}

	public void printMoviesInYear() throws SQLException {
		int totalDuration = 0;
		md.connect();
		System.out.printf("Enter in year: ");

		try {
			int year = Integer.parseInt(in.nextLine());
			System.out.println();

			sqlQuery = "select * from movies where year = " + year + ";";
			ResultSet result = md.get(sqlQuery);
			if (result.next()) {

				System.out.println("Movie List");
				System.out.printf("%-10s %-10s %-50s\n", "Duration", "Year", "Title");

				while (result.next()) {
					totalDuration += result.getInt("duration");
					System.out.printf("%-10d %-10d %-50s\n", result.getInt("duration"), result.getInt("year"),
							result.getString("title"));
				}

				System.out.println();
				System.out.println("Total duration: " + totalDuration + " minutes");
				System.out.println();
				System.out.println();
			} else {
				System.out.println("No movie in Year " + year);
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		md.disconnect();
		return;
	}

	public void printRandomMovies() throws SQLException {
		int totalDuration = 0;
		md.connect();
		System.out.printf("Enter number of movies: ");

		try {
			int numberOfMovies = Integer.parseInt(in.nextLine());
			System.out.println();

			if (numberOfMovies > 0) {
				sqlQuery = "select * from movies order by rand() limit " + numberOfMovies + ";";
				ResultSet result = md.get(sqlQuery);
				
				System.out.println("Movie List");
				System.out.printf("%-10s %-10s %-50s\n", "Duration", "Year", "Title");

				while (result.next()) {
					totalDuration += result.getInt("duration");
					System.out.printf("%-10d %-10d %-50s\n", result.getInt("duration"), result.getInt("year"),
							result.getString("title"));
				}

				System.out.println();
				System.out.println("Total duration: " + totalDuration + " minutes");
				System.out.println();
				System.out.println();
			} else {
				System.out.println("Invalid request.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		md.disconnect();
	}

	public void deleteMovie() throws SQLException {
		md.connect();
		
		System.out.printf("Enter the movie ID thata you want to delete: ");
		try {
			int id = Integer.parseInt(in.nextLine());
			System.out.println();
			sqlQuery = "delete from movies where id = " + id + ";";
			int row = md.update(sqlQuery);
			if(row == 1) {
				System.out.println("Movie " + id + " is deleted." );
			} else {
				System.out.println("Failed to delete Movie " + id);
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		md.disconnect();
	}
}
