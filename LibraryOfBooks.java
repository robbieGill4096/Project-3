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

	public static void mainMenu() {
		LibraryInterface littleLibrary = new Library();
		String selection = "";
		while (selection.equals("Q") != true) {
			selection = "";

			Scanner reader = new Scanner(System.in);
			String input = reader.nextLine();

			selection += input.toUpperCase();

			switch (selection.toUpperCase()) {
			// view contents of the library.
			case "C":
				System.out.println("View contents of the Library....");
				System.out.println(dividerPrompt);

				String bookList = littleLibrary.toString();

				System.out.println(bookList);
				System.out.print(selectionPrompt);
				break;
			// add a book to the library.
			case "A":
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
				break;
			// delete a book from the library.
			case "D":
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
						break;
					} else {
						System.out.println(number + " is not an index in the current Library. ");
						System.out.print(selectionPrompt);
						break;
					}
				} catch (Exception e) {
					System.out.println(invalidPrompt);
					System.out.print(selectionPrompt);
					break;

				}
			//read a book in the library.
			case "R":
				System.out.println("Read a book from the library...\n");
				System.out.print("Please enter the index of the book: ");
				try {
					String index = reader.nextLine();

					Integer number = Integer.parseInt(index);
					int sizeOfLib = littleLibrary.getBooks().size();
					if (number < sizeOfLib) {

						Book selectedBook = littleLibrary.getBook(number);
						System.out.println(selectedBook.getText());
						System.out.print(selectionPrompt);
						break;
					} else {
						System.out.println(number + " is not an index in the current Library. ");
						System.out.print(selectionPrompt);
						break;
					}
				} catch (Exception e) {
					System.out.println(invalidPrompt);
					System.out.print(selectionPrompt);
					break;

				}
			//display Menu again.
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
	}

	public static void main(String[] args) {
		menuPrompt();
		mainMenu();
	}
}
