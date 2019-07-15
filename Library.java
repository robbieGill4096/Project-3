import java.util.ArrayList;

/**
 * @author Robbie
 *
 * Manage collection of Books Objects Implements API from Library
 * Interface.
 */

public class Library implements LibraryInterface {
	private ArrayList<Book> bookLibrary;
/**
 * creates a new library instance
 * 
 */
	public Library() {
		this.bookLibrary = new ArrayList<Book>();

	}
	/**
	 * takes the book library and iterates through it returning a copy.
	 * @return a copy of the bookLibrary to the user.
	 */
	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> copyBookLibrary = new ArrayList<Book>();
		for (Book book : this.bookLibrary) {
			copyBookLibrary.add(book);
		}

		return copyBookLibrary;
	}
/**
 * adds a book to the library.
 * 
 */
	@Override
	public void addBook(Book newBook) {
		this.bookLibrary.add(newBook);

	}
/**
 * 
 * removes a book object from the library
 */
	@Override
	public void removeBook(int index) {
		if (index <= this.bookLibrary.size() - 1) {
			this.bookLibrary.remove(index);
		}

	}
/**gets a book from the library and creates a copy
 * @return a copy of a book
 */
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
/**
 * iterates through a library of books and adds the index to a string value.
 * @return String value representing all the book objects in a library.
 */
	public String toString() {
		int index = 0;
		String stringAndInfo = "";
		for (Book book : this.bookLibrary) {
			String bookInfo = book.toString();
			String formattedBookInfo = "Index: " + index + " " + bookInfo + " \n";
			stringAndInfo += formattedBookInfo;

			index += 1;
		}

		return stringAndInfo;

	}

}
