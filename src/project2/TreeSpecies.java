/*

	READ ME:
	This class should represent a single tree species that has both the 
	common name and the Latin name of the species.
	The class should provide a two parameter constructor
	
	The class should override the equals method. 
	Two TreeSpecies objects are equal if both the names are the same. 
	The comparison should be case insensitive.

*/

package project2;

public class TreeSpecies {
	
	/*
	Both names are, possibly empty, strings. They cannot be null. '
	If this constructor is called with a null argument, it should throw 
	an instance of IllegalArgumentException with an appropriate error message.
	 */
	
	public TreeSpecies(String commonName, String latinName) {
		
	}

	
	@Override
	public boolean equals(Object obj) {
		// TODO Implement this equals method
		return false;
		
	}
	
}
