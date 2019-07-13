import java.util.Scanner;
import java.io.*;


/**
 * @author Robbie
 *
 *represents book Objects 
 */
public class Book implements BookInterface {
	//Constructor object attributes
	private String title;
	private String author;
	private String genre;
	private String filename;
	
	public Book (String title,String author) {
		this.title = title;
		this.author = author;
		this.genre = null;
		this.filename = null;
		
	}

	@Override
	public String getTitle() {
		
		return author;
	}

	@Override
	public void setTitle(String title) {
		
		this.title = title;
	}

	@Override
	public String getAuthor() {
		
		return author;
	}

	@Override
	public void setAuthor(String author) {
		
		this.author = author;
	}

	@Override
	public String getGenre() {
		
		
		return genre;
	}

	@Override
	public void setGenre(String genre) {
		
		this.genre = genre;
	}

	@Override
	public String getFilename() {
		
		
		return filename;
	}

	@Override
	public void setFilename(String filename) {
		
		this.filename = filename;
	}

	@Override
	public boolean isValid() {
		
		
		String title = this.getTitle();
		String author = this.getAuthor();
		String genre = this.getGenre();
		String fileName = this.getFilename();
		if ((title== null || author == null || genre == null || fileName == null) == true) {
			return false;
		}
		//and filename exists.
		File bookFile = new File (fileName);
		Scanner fileReader;
		
		try {fileReader = new Scanner(bookFile);
		if ((title== null || author == null || genre == null || fileName == null) == true) {
			return false;
		}
		else {
			return true;}
		}
		catch (FileNotFoundException e) {
			return false;
			}
		
	}

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
		     
		}
		catch (FileNotFoundException e) {
					
			return "The file was not able to be opened.";
					
				}
		}
		else 
			return "The file was not able to be opened.";
		   }

	public String toString() {
		title = this.getTitle();
		author = this.getAuthor();
		genre = this.getGenre();
		filename = this.getFilename();
		String strBookAttributes ="Title: " + title + "Author: " + "" + author+ "Genre: " +genre+ "Filename: " +filename;
		
		return strBookAttributes;
	}
}
