/*
 The Tree class stores information about a particular tree that grows in 
 New York City. The class should store only a subset of the entries from the 
 input file, namely:
	* tree_id as a non-negative integer
	* status as a string, valid values: "Alive", "Dead", "Stump", or empty string 
	  or null
	* health as a string, valid values: "Good", "Fair", "Poor", or empty string or 
	  null
	* spc_latin (Latin name) as a, possibly empty, string, cannot be null
	* spc_common (common name) as a, possibly empty, string, cannot be null
	* zipcode as a positive five digit integer (This means that any number from
	  0 to 99999 is acceptable. The values that are shorter should be treated as 
	  if they had leading zeroes, i.e., 8608 represents zipcode 08608, 
	  98 represents zip code 00098, etc.)
	* boroname as a string, valid values: "Manhattan", "Queens", "Staten Island"
	* x_sp as a double
	* y_sp as a double

 All of the string data fields should be case insensitive 

 Note that some of these data fields may not be needed in this project, 
 but the code has to provide them and the data for them has to be stored.
 
 The class should provide getters and setters for all other required data fields. 
 The parameters for all setters should be validated according to the rules specified
 above. If a setter is called with invalid arguments, then an instance of 
 IllegalArgumentException should be thrown carrying an appropriate error message.
 
 

 */




package project2;

public class Tree implements Comparable<Tree>{
	
	/*
	 public Tree (int treeID, TreeSpecies species )

	 The treeID should be a non-negative integer and the species should not be null.
	 If the constructor is called with invalid arguments, then an 
	 instance of IllegalArgumentException should be thrown carrying an 
	 appropriate error message.

	 There should be no default constructor.
	 */
	public Tree (int treeID, TreeSpecies species) {
		// TODO Implement constructor
	}
	
	/*
	  equals(Object obj)
	  The two Tree objects should be considered equal if their id's and both, 
	  Latin and common, species names are the same. The other values should not 
	  be considered in the equality. The name comparison should be case insensitive.
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Implement equals method
		
		return false;
		
	}
	
	@Override
	public int compareTo(Tree o) {
		// TODO Implement compareTo (see Comparison in JavaDocs)
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Implement a toString method that is a meaningful representation
		// of the object on which it is called. 
		
		return null;
		
	}
	

}


















