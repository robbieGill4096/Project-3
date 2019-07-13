import java.util.ArrayList;

/**
 * @author Robbie
 *
 *Manage collection of Books Objects
 *Impliments API from Library Interface.
 */
public class Library implements LibraryInterface {
private ArrayList<Book> bookLibrary;
	public Library() {
		this.bookLibrary = new ArrayList<Book>();
		
	}
	
	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> copyBookLibrary = new ArrayList<Book>();
		for (Book book : bookLibrary ) {
			copyBookLibrary.add(book);
		}
		
		
		return copyBookLibrary;
	}

	@Override
	public void addBook(Book newBook) {
		this.bookLibrary.add(newBook); 
		
	}

	@Override
	public void removeBook(int index) {
		// TODO Auto-generated method stub
		this.bookLibrary.remove(index); 
	}

	@Override
	public Book getBook(int index) {
		int sizeOfArray = this.getBooks().size();
		if (index < sizeOfArray) {
		Book specificBookCopy = this.getBooks().get(index);
		return specificBookCopy;
		}
		// TODO Auto-generated method stub
		return null;
	}
	public String toString() {
		int index = 0;
		String stringAndInfo = "";
		for (Book book : this.bookLibrary) {
			String bookInfo = book.toString();
			String formattedBookInfo = "Index: " + index + " " + bookInfo + "\n";
			stringAndInfo += formattedBookInfo;
			
			index += 1;
		}
			
		return stringAndInfo;
		
	}

}
