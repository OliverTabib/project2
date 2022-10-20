/*
  The TreeSpeciesList class should be used to store all the unique TreeSpecies 
  objects. This class should inherit from the ArrayList<TreeSpecies> class. 
 (Some of you may realize that a HashTable would probably be a better choice here. 
  For the purpose of this project, you should NOT use the HashTable or any other 
  hashing data structure).

 The class needs to provide a default constructor that creates an empty 
 TreeSpeciesList object.
 */


package project2;

import java.util.ArrayList;

public class TreeSpeciesList extends ArrayList<TreeSpecies>{

	public TreeSpeciesList() {

	}

	/*
	 * @returns a list of species whose common name contains keyword as a substring
	 * case insensitive
	 * @throws IllegalArgumentException if called with null arg
	 * @returns null if there are no TreeSpecies objects matching the keyword
	 */
	public TreeSpeciesList getByCommonName (String keyword) {
		if( keyword == null) {
			throw new IllegalArgumentException("Keyword is null");
		}
		return null; // TODO: implement this method
	}
	
	/*
	 * @returns list of species whose Latin name contains keyword as substring
	 * case insensitive
	 * @throws IllegalArguementException if called with null arg
	 * @returns null if there are no TreeSpecies objects matching the keyword
	 */
	public TreeSpeciesList getByLatinName(String keyword) {
		if( keyword == null) {
			throw new IllegalArgumentException("Keyword is null");
		}
		return null; // TODO: implement this method
	}
}
