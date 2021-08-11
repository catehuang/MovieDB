package sait.mms.problemdomain;

public class Movie {
	private static int id;
	private int duration;
	private String title;
	private int year;
	
	public Movie() {
		super();
	}

	public Movie(int duration, String title, int year) {
		super();
		this.duration = duration;
		this.title = title;
		this.year = year;
	}

	/**
	 * Get movie id
	 * @return the number of movie id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the duration of assigned movie
	 * @return the duration of assigned movie in minutes
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Assign the duration for a specified movie
	 * @param duration the minutes of a movie
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Get the name of the movie
	 * @return the name of the movie
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set a name of the movie
	 * @param title the name of a movie
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the year of the movie
	 * @return the year of the movie
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Set a year for the movie
	 * @param year the year of the year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", duration=" + duration + ", title=" + title + ", year=" + year + "]";
	}	
}
