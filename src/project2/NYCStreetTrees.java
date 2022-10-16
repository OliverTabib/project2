/*
 It is responsible for opening and reading the data file, obtaining user input,
  performing some data validation and handling all errors that may occur, and 
  printing all output to the standard output stream. It should handle any exceptions 
  thrown by your other classes and terminate gracefully, if need be, with a friendly 
  error message presented to the user: The program should never just reprint the 
  exception message as a way of handling an exception. These messages are rarely 
  readable to the ordinary user and make it seem like the program crashed in 
  response to the exception.

  You may (and probably should) implement other methods in this class to modularize 
  the design.
 */

package project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class NYCStreetTrees {
	public static void main( String[] args ) throws FileNotFoundException {
		FileReader f = new FileReader("C:\\Users\\ojtab\\Desktop\\CS_102\\project2\\src\\project2"
				+ "\\2015_NYC_Tree_Census.csv");
		TreeSpecies s = new TreeSpecies("","");
		Tree t = new Tree(0, s);
		t.setZipcode(0);
		System.out.println(t.getZipcode());
	}

}
