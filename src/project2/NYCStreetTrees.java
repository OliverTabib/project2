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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Object;
import project2.TreeList.Node;

public class NYCStreetTrees {
	public static void main( String[] args ) throws IOException {
		
		String path = "C:\\Users\\ojtab\\Desktop\\CS_102\\project2\\src\\project2"
				+ "\\test.csv";
		//		String path = "C:\\Users\\ojtab\\Desktop\\CS_102\\project2\\src\\project2"
		//				+ "\\2015_NYC_Tree_Census.csv";

		Tree t = new Tree(1, new TreeSpecies("a","a"));
		t.setBoroname("manhattan");
		TreeList tl =  fileToTreeList(path);

		String inputStr = "Enter the tree species to learn more about it"
				+ " (\"quit\" to stop):";

		// Begin console in/outputs
		Scanner sc = new Scanner( System.in );
		System.out.println(inputStr);
		String input = sc.nextLine();
		sc.close();
		displayMatchingSpecies(input, tl);
		displayPopularity(input, tl);

	}

	public static int totalPopOfSpecies (TreeList tl, String species) {
		Node n = tl.head;
		int i = 0;

		while( n.next != null ) {
			String speciesN = n.data.getSpc_common();
			if( speciesN.contains(species)) {
				i++;
			}
			n = n.next;
		}
		String speciesN = n.data.getSpc_common();
		if( speciesN.contains(species)) {
			i++;
		}
		return i;
	}

	public static int[] popPerBoroPerSpecie( TreeList tl , String specie) {
		Node n = tl.head;

		int[] arr = {0,0,0,0,0}; // Manhattan, BK, Staten Island, Queens, Bronx

		while( n.next != null ) {
			String boro = n.data.getBoroname();
			String specieC = n.data.getSpc_common();
			switch(boro) {
			case "manhattan":
				if(specieC.contains(specie)) {
					arr[0]++;
				}
				break;
			case "brooklyn":
				if(specieC.contains(specie)) {
					arr[1]++;
				}
				break;
			case "staten island":
				if(specieC.contains(specie)) {
					arr[2]++;
				}
				break;
			case "queens":
				if(specieC.contains(specie)) {
					arr[3]++;
				}
				break;
			case "bronx":
				if(specieC.contains(specie)) {
					arr[4]++;
				}
				break;
			}
			n = n.next;
		}
		String boro = n.data.getBoroname();
		String specieC = n.data.getSpc_common();
		switch(boro) {
		case "manhattan":
			if(specieC.contains(specie)) {
				arr[0]++;
			}
			break;
		case "brooklyn":
			if(specieC.contains(specie)) {
				arr[1]++;
			}
			break;
		case "staten island":
			if(specieC.contains(specie)) {
				arr[2]++;
			}
			break;
		case "queens":
			if(specieC.contains(specie)) {
				arr[3]++;
			}
			break;
		case "bronx":
			if(specieC.contains(specie)) {
				arr[4]++;
			}
			break;
		}
		return arr;
	}

	public static int[] popPerBoro( TreeList tl ) {
		Node n = tl.head;

		int[] arr = {0,0,0,0,0}; // Manhattan, BK, Staten Island, Queens, Bronx

		while( n.next != null ) {
			String boro = n.data.getBoroname();

			switch(boro) {
			case "manhattan":
				arr[0]++;
				break;
			case "brooklyn":
				arr[1]++;
				break;
			case "staten island":
				arr[2]++;
				break;
			case "queens":
				arr[3]++;
				break;
			case "bronx":
				arr[4]++;
				break;
			}
			n = n.next;
		}
		String boro = n.data.getBoroname();
		switch(boro) {
		case "manhattan":
			arr[0]++;
			break;
		case "brooklyn":
			arr[1]++;
			break;
		case "staten island":
			arr[2]++;
			break;
		case "queens":
			arr[3]++;
			break;
		case "bronx":
			arr[4]++;
			break;
		}
		return arr;
	}

	public static void displayPopularity( String species, TreeList tl ) {
		int[] totals = popPerBoro(tl);
		int[] totalPerBoro = popPerBoroPerSpecie(tl, species);

		int totalTreeSpecie = totalPopOfSpecies(tl, species);
		String totalTreeSpecies = Integer.toString(totalTreeSpecie);
		String totalTrees = Integer.toString(tl.size);
		float totalPercentCity =((float)totalTreeSpecie)/tl.size * 100;

		// Total amount of Trees per boro:
		int totalMan = totals[0]; int totalBK = totals[1]; int totalSI = totals[2];
		int totalQ = totals[3]; int totalBX = totals[4];

		// Total amount of specific species per boro
		int totalS_Man = totalPerBoro[0]; int totalS_BK =totalPerBoro[1]; int totalS_SI = totalPerBoro[2]; int totalS_Q = totalPerBoro[3];
		int totalS_BX = totalPerBoro[4];
		Node n = tl.head;

		// Percentages (floats) of specific species per boro
		float perMan = ((float)totalS_Man / totalMan) * 100; float perBK = ((float)totalS_BK / totalBK) * 100;
		float perSI = ((float)totalS_SI / totalSI) * 100; float perQ = ((float)totalS_Q / totalQ) * 100;
		float perBX = ((float)totalS_BX / totalBX) * 100;




		// Display percentages to user:
		System.out.println("Popularity in the city: ");
		System.out.printf("%-15s %-5s %-4s %6.2f%%\n", "\tNYC", ":" ,"(" + totalTreeSpecies +
				")" + totalTrees, totalPercentCity );

		System.out.printf("%-15s %-5s %-4s %6.2f%%\n", "\tManhattan", ":" ,"(" + totalS_Man +
				")" + totalMan, perMan );
		System.out.printf("%-15s %-5s %-7s %6.2f%%\n", "\tBronx", ":" ,"(" + totalS_BX +
				")" + totalBX, perBX );
		System.out.printf("%-15s %-5s %-4s %6.2f%%\n", "\tBrooklyn", ":" ,"(" + totalS_BK +
				")" + totalBK, perBK );
		System.out.printf("%-15s %-5s %-4s %6.2f%%\n", "\tQueens", ":" ,"(" + totalS_Q +
				")" + totalQ, perQ );
		System.out.printf("%-15s %-5s %-7s %6.2f%%\n", "\tStaten Island", ":" ,"(" + totalS_SI +
				")" + totalSI, perSI );


	}

	public static void displayMatchingSpecies( String species, TreeList tl ) {
		Node n = tl.head;

		System.out.println("All matching species:");
		while( n.next != null ) {
			String speciesN = n.data.getSpc_common();
			if( speciesN.contains(species) ) {
				System.out.println( "\t" + speciesN );
			}
			n = n.next;
		}
		String speciesN = n.data.getSpc_common();
		if( speciesN.contains( species) ) {
			System.out.println( "\t" + speciesN );
		}
	}


	public static TreeList fileToTreeList( String path ) throws FileNotFoundException {
		File f = new File( path );
		TreeList tl = new TreeList();
		Node n = tl.head; 

		CSV csv = new CSV( new Scanner(f) );

		for (int i = 0; i < csv.getNumOfRows() - 1; i++ ) {
			if( i == 0 ) csv.getNextRow();
			ArrayList<String> line = csv.getNextRow();
			TreeSpecies ts = new TreeSpecies( line.get(9), line.get(8) );
			int id = 0;
			int zipcode = 0;
			double x_sp = 0; double y_sp = 0;

			try {
				id = Integer.parseInt(line.get(0));
			} catch( NumberFormatException nfe) {}

			Tree t = new Tree( id, ts );
			t.setStatus(line.get(6));
			t.setHealth(line.get(7));

			try {
				zipcode = Integer.parseInt(line.get(25));
			} catch( NumberFormatException nfe) {}
			t.setZipcode(zipcode);
			t.setBoroname(line.get(29));

			try {
				x_sp = Double.parseDouble(line.get(39));
			} catch( NumberFormatException nfe) {}

			try {
				y_sp = Double.parseDouble(line.get(40));
			} catch( NumberFormatException nfe) {}
			t.setX_sp(x_sp); t.setY_sp(y_sp);
			tl.add(t);
		}
		return tl;
	}


	public static int treeCount(String fileString) {
		String[] arr = fileString.split("\n");
		return arr.length;
	}

}
