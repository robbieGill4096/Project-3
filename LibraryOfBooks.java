import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Navigation Menu Structure
 * Console UI
 */

public class LibraryOfBooks {
	// main menu
	static String menuPrompt = "|*** LIBRARY OF BOOKS ***|";
	static String spacerPrompt = "|                        |";
	static String borderPrompt = "|========================|";
	// PRINT LIBRARY CONTENT
	static String libraryContentPrompt = "| (C)ontent		 |";
	// add A book to Library
	static String addBookPrompt = "| (A)dd Book		 |";
	// delete a book from library
	static String deleteBookPrompt = "| (D)elete Book		 |";
	// read a book in library
	static String readBookPrompt = "| (R)ead Book		 |";
	// quit
	static String quitPrompt = "| (Q)uit		 |";
	static String selectionPrompt = "Press (M) for Menu, Please\nenter a selection: ";

	// general purpose
	static String invalidPrompt = "Invalid Selection!";
	static String dividerPrompt = "==================================";
	static LibraryInterface littleLibrary = new Library();
	static Scanner reader = new Scanner(System.in);

	public static void menuPrompt() {
		System.out.println(borderPrompt);
		System.out.println(menuPrompt);
		System.out.println(borderPrompt);
		System.out.println(libraryContentPrompt);
		System.out.println(addBookPrompt);
		System.out.println(deleteBookPrompt);
		System.out.println(readBookPrompt);
		System.out.println(quitPrompt);
		System.out.println(borderPrompt);
		System.out.print(selectionPrompt);
	}

	public static void content() {
		System.out.println("View contents of the Library....");
		System.out.println(dividerPrompt);

		String bookList = littleLibrary.toString();

		System.out.println(bookList);
		System.out.print(selectionPrompt);

	}

	public static void addBook() {
		System.out.println("Add a book to the library....\n");
		System.out.print("Please enter the books Title: ");
		String title = reader.nextLine();
		System.out.print("Please enter the books Author: ");
		String author = reader.nextLine();
		Book newBook = new Book(title, author);

		System.out.print("Please enter the books Genre: ");
		String genre = reader.nextLine();
		newBook.setGenre(genre);
		System.out.print("Please enter the books filename: ");
		String filename = reader.nextLine();
		newBook.setFilename(filename);

		littleLibrary.addBook(newBook);

		System.out.print(selectionPrompt);

	}

	public static void deleteBook() {
		System.out.println("Remove a book from the library...\n");
		System.out.print("Please enter the index of the book: ");
		try {
			String index = reader.nextLine();

			Integer number = Integer.parseInt(index);
			int sizeOfLib = littleLibrary.getBooks().size();
			if (number < sizeOfLib) {

				littleLibrary.removeBook(number);

				System.out.println();
				System.out.println("Book at index " + number + " removed from Library.");
				System.out.print(selectionPrompt);
				return;
			} else {
				System.out.println(number + " is not an index in the current Library. ");
				System.out.print(selectionPrompt);
				return;
			}
		} catch (Exception e) {
			System.out.println(invalidPrompt);
			System.out.print(selectionPrompt);
			return;

		}
	}

	public static String getPage(String fulltext, int index) {
		ArrayList<String> bookPages = new ArrayList<String>();
		final int INCREMENT = 1500;
		int firstIndex = 0;
		int lastIndex = INCREMENT;
		int count = 0;
		while (lastIndex > count) {
			count += 1;
			fulltext += " ";
		}
		do {

			bookPages.add(fulltext.substring(firstIndex, lastIndex));

			firstIndex += INCREMENT;
			lastIndex += INCREMENT;
		} while (lastIndex < fulltext.length());

		String selectedPage = bookPages.get(index);
		return selectedPage;

	}

	public static void readBook() {
		try {
			System.out.println("Read a book from the library...\n");
			System.out.print("Please enter the index of the book: ");

			String index = reader.nextLine();
			Integer number = Integer.parseInt(index);
			int sizeOfLib = littleLibrary.getBooks().size();
			if (number < sizeOfLib) {

				Book selectedBook = littleLibrary.getBook(number);
				System.out.println("How would you like to read the text:\n(S)croll\n(P)age");
				String userSelection = reader.nextLine();

				if (userSelection.toLowerCase().equals("s")) {
					System.out.println(selectedBook.getText());
					System.out.print(selectionPrompt);
					return;
				}
				if (userSelection.toLowerCase().equals("p")) {
					System.out.print("Please enter a page number:");
					String pageNum = reader.nextLine();
					Integer pageNumber = Integer.parseInt(pageNum);
					System.out.println(getPage(selectedBook.getText(), pageNumber));
					System.out.println();
					System.out.println("Would you like to keep reading? (Y) or (N)");
					String response = "";

					while (response.toLowerCase().equals("n") != true) {
						response = "";
						String input = reader.nextLine();
						if (input.equals("n") == true) {
							break;
						}
						pageNumber += 1;

						System.out.println(getPage(selectedBook.getText(), pageNumber));
						System.out.println();
						System.out.println("Would you like to keep reading? (Y) or (N)");
						response += input;

					}
					System.out.print(selectionPrompt);
					return;
				}

			} else {
				System.out.println(number + " is not an index in the current Library. ");
				System.out.print(selectionPrompt);
				return;
			}

		}

		catch (Exception e) {
			System.out.println(invalidPrompt);
			System.out.print(selectionPrompt);
			return;

		}
	}


	public static void mainMenu() {
		String selection = "";
		while (selection.equals("Q") != true) {
			selection = "";

			String input = reader.nextLine();

			selection += input.toUpperCase();

			switch (selection.toUpperCase()) {
			// view contents of the library.
			case "C":
				content();
				break;
			case "A":
				addBook();
				break;
			case "D":
				deleteBook();
				break;
			// read a book in the library.
			case "R":
				readBook();
				break;
			// display Menu again.
			case "M":
				menuPrompt();
				break;
			default:
				if (selection.equals("Q") != true) {
					System.out.println(invalidPrompt);
					System.out.print(selectionPrompt);
				}
				break;
			}
		}
		System.out.println("Goodbye!");
		reader.close();
	}

	public static void main(String[] args) {
		menuPrompt();
		mainMenu();
	}
}
