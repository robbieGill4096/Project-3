import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class testfile
{
	public static String getPage(String fulltext, int index) {
		 ArrayList<String> bookPages = new ArrayList<String>();
		 final int INCREMENT = 70;
		 int firstIndex = 0;
		 int lastIndex = INCREMENT;
		 int count = 0;
		 while(lastIndex > count) {
			 count += 1;
			 fulltext+=" ";
		 }
		do {
			
			bookPages.add(fulltext.substring(firstIndex, lastIndex));
			
			firstIndex += INCREMENT;
			lastIndex += INCREMENT;
		}
		while (lastIndex < fulltext.length());
		
		String selectedPage = bookPages.get(index);
		return selectedPage;
			
	}
	
	
	public static void main(String[] args) {
		System.out.println(getPage("",0));
		
	}
}