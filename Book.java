import java.util.Scanner;
import java.io.*;

/**
 * @author Robbie
 *
 *         represents book Objects
 */
public class Book implements BookInterface {
	// Constructor object attributes
	private String title;
	private String author;
	private String genre;
	private String filename;
/**
 * 
 * @param Title takes a String representing the title of a book.
 * @param Author takes a String representing the Author of a book.
 */
	public Book(String Title, String Author) {
		this.title = Title;
		this.author = Author;
		this.genre = null;
		this.filename = null;

	}
/**
 * 
 * gets the book objects Title
 */
	@Override
	public String getTitle() {

		return title;
	}
	/**
	 * sets the book objects Title
	 */
	@Override
	public void setTitle(String title) {

		this.title = title;
	}
/**
 * gets the books Author
 * @return the book object attribute Author.
 */
	@Override
	public String getAuthor() {

		return author;
	}
/**
 * 
 * sets the author of a book Object.
 */
	@Override
	public void setAuthor(String author) {

		this.author = author;
	}
/**
 * @return the genre attribute
 */
	@Override
	public String getGenre() {

		return genre;
	}
/**
 * sets the genre attribute 
 */
	@Override
	public void setGenre(String genre) {

		this.genre = genre;
	}
/**
 * returns the filename attribute
 * @return filename
 */
	@Override
	public String getFilename() {

		return filename;
	}
	/**
	 * sets the filename attribute.
	 */
	@Override
	public void setFilename(String filename) {

		this.filename = filename;
	}

	/**
	 * Ensure all the attributes are set (not null) 
	 * and that the referenced Filename exists.
	 * @return true if valid, false if not.
	 */
	@Override
	public boolean isValid() {

		String title = this.getTitle();
		String author = this.getAuthor();
		String genre = this.getGenre();
		String fileName = this.getFilename();

		if (title == null) {
			return false;
		}
		if (author == null) {
			return false;
		}
		if (genre == null) {
			return false;
		}
		if (fileName == null) {
			return false;
		} else {
			// and filename exists.
			File bookFile = new File(fileName);
			Scanner fileReader;

			try {
				fileReader = new Scanner(bookFile);

				return true;
			} catch (FileNotFoundException e) {
				return false;
			}
		}
	}
	/**
	 * Return a String that contains the text contents of the 
	 * file referenced by the Filename attribute. Since this 
	 * method will need to open a file it will need to catch 
	 * the FileNotFoundException. If this Exception is raised, 
	 * simply return a String stating that the file was not able 
	 * to be opened.
	 * @return String containing text contents of book
	 */
	@Override
	public String getText() {
		if (isValid() == true) {
			String selectedFile = this.getFilename();
			Scanner fileScan;
			File book = new File(selectedFile);
			String bookString = "";
			Scanner fileReader;
			try {
				fileReader = new Scanner(book);

				while (fileReader.hasNextLine()) {
					bookString += fileReader.nextLine() + "\n";
				}
				return (bookString);

			} catch (FileNotFoundException e) {

				return "The file was not able to be opened.";

			}
		} else
			return "The file was not able to be opened.";
	}
	
	/**
	 * Return a String containing the Title, Author and Genre of the book, 
	 *    but not the filepath.
	 * @return String with book details
	 */
	public String toString() {
		title = this.getTitle();
		author = this.getAuthor();
		genre = this.getGenre();
		String strBookAttributes = "Title: " + title + " Author: " + "" + author + " Genre: " + genre;

		return strBookAttributes;
	}
}
