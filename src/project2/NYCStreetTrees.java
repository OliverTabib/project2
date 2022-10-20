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
import java.io.IOException;
import java.util.Scanner;

public class NYCStreetTrees {
	public static void main( String[] args ) throws IOException {

		String path = "C:\\Users\\ojtab\\Desktop\\CS_102\\project2\\src\\project2"
				+ "\\test.csv";
		
		String fileString = fileToString(path);
		TreeList tl =  stringToTreeList(fileString);
		
		String inputStr = "Enter the tree species to learn more about it"
				+ " (\"quit\" to stop):";
		
		Scanner sc = new Scanner( System.in );
		System.out.println(inputStr);
		String input = sc.nextLine();
		sc.close();
		
		
		

	}
	
	public static void displayMatchingSpecies(String species) {
		
	}

	public static String fileToString(String filePath) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(filePath));
			String s;

			while ((s = buffer.readLine()) != null) {

				sb.append(s).append("\n");
			}
			buffer.close();
		}
		catch (IOException e){
			throw new IOException("File could not be read");
		}
	
		return sb.toString();
	}
	
	public static TreeList stringToTreeList( String fileString ) {
		int treeCount = treeCount( fileString );
		String[] line = fileString.split( "\n" );
		TreeList tl = new TreeList();
		
		for( int i = 0; i < treeCount; i++ ) {
			String[] row = line[i].split(",");
			
			if( row[0].equals("tree_id") ) { // if first line, skip
				continue;
			}
			int treeID = Integer.parseInt(row[0]); // Parse treeid to int
			String commonName = row[9];
			String latinName = row[8];
			String status = row[6];
			String health = row[7];
			String zipcode = row[25];
			String boro = row[29];
			double x_sp = Double.parseDouble( row[39] );
			double y_sp = Double.parseDouble( row[40] );
			
			
			TreeSpecies ts = new TreeSpecies ( commonName, latinName );
			
			Tree t = new Tree( treeID, ts );
			t.setStatus( status );
			t.setHealth( health );
			t.setZipcode( Integer.parseInt(zipcode) );
			t.setBoroName(boro);
			t.setX_sp(x_sp);
			t.setY_sp(y_sp);
			
			tl.add(t);
		}
		return tl;
	}
	
	public static int treeCount(String fileString) {
		String[] arr = fileString.split("\n");
		return arr.length;
	}

}
