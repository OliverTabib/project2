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
	private String commonName;
	private String latinName;

	/*
	Both names are possibly empty strings. They cannot be null. '
	If this constructor is called with a null argument, it should throw 
	an instance of IllegalArgumentException with an appropriate error message.
	 */

	public TreeSpecies(String commonName, String latinName) {
		if( commonName == null || latinName == null ) {
			throw new IllegalArgumentException( "A null arguement was passed" );
		}
		this.commonName = commonName;
		this.latinName = latinName;
	}


	@Override
	public boolean equals(Object obj) {
		TreeSpecies other = ( TreeSpecies ) obj;
		String thisCommonName = this.commonName.toLowerCase();
		String thisLatinName = this.latinName.toLowerCase();
		String otherCommonName = other.commonName.toLowerCase();
		String otherLatinName = other.latinName.toLowerCase();

		if( ( thisCommonName.equals( otherCommonName )) && 
				( thisLatinName.equals( otherLatinName ))) {
			return true;
		}
		return false;
	}


	public String getCommonName() {
		return commonName;
	}


	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}


	public String getLatinName() {
		return latinName;
	}


	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}


}
