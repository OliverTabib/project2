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

	private int tree_id;
	private String status;
	private String health;
	private String spc_latin;
	private String spc_common;
	private int zipcode;
	private String boroName;
	private double x_sp;
	private double y_sp;
	private TreeSpecies species;

	public Tree ( int treeID, TreeSpecies species ) {
		// Input validation:
		if( treeID < 0 ) throw new IllegalArgumentException( "Tree ID must be "
				+ "nonnegative" );
		if( species == null ) throw new IllegalArgumentException( "Species "
				+ "must not be null" );


		this.tree_id = treeID;
		this.species = species;

	}

	public int getTree_id() {
		return tree_id;
	}

	public void setTree_id( int tree_id ) {
		// Input validation
		if( tree_id < 0 ) throw new IllegalArgumentException( "Tree ID must be"
				+ " nonnegative" );
		this.tree_id = tree_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		// Input Validation:
		if( !(status == null) ) {
			status = status.toLowerCase();
		}

		if( !( status == null  || status.equals( "dead" ) || 
				status.equals( "stump" ) || status.equals( "" )
				|| status.equals( "alive" ))) {
			throw new IllegalArgumentException( "Invalid Status Argument" );
		}
		this.status = status;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		// Input Validation:
		if( !(health == null) ) {
			health = health.toLowerCase();
		}

		if( !( health == null  || health.equals( "good" ) || 
				health.equals( "fair" ) || health.equals( "" )
				|| health.equals( "poor" ))) {
			throw new IllegalArgumentException( "Invalid Health Argument" );
		}
		this.health = health;
	}

	public String getSpc_latin() {
		return spc_latin;
	}

	public void setSpc_latin(String spc_latin) {
		// Input Validation:
		if( spc_latin == null ) throw new IllegalArgumentException( "Latin Name "
				+ "is null" );
		this.spc_latin = spc_latin;
	}

	public String getSpc_common() {
		return spc_common;
	}

	public void setSpc_common(String spc_common) {
		// Input Validation:
		if( spc_common == null ) throw new IllegalArgumentException( "Common Name "
				+ "is null");
		this.spc_common = spc_common;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		// Input Validation:
		if( !( 0 <= zipcode && 99999 >= zipcode ) ) {
			throw new IllegalArgumentException( "Zipcode must be between 0 "
					+ "and 99999" );
		}
		int zip;
		// Handling trailing zeros:
		String stringZip = Integer.toString( zipcode );
		if( stringZip.length() < 5 ) {
			StringBuilder sb = new StringBuilder();
			for( int i = 0; i < (5 - stringZip.length() ); i++ ) {
				sb.append( "0" );
			}
			sb.append( stringZip );
			stringZip = sb.toString();
			zipcode = Integer.parseInt(stringZip);
		}
		System.out.println(zipcode);
		//this.zipcode = zipcode;
	}

	public String getBoroName() {
		return boroName;
	}

	public void setBoroName(String boroName) {
		this.boroName = boroName;
	}

	public double getX_sp() {
		return x_sp;
	}

	public void setX_sp(double x_sp) {
		this.x_sp = x_sp;
	}

	public double getY_sp() {
		return y_sp;
	}

	public void setY_sp(double y_sp) {
		this.y_sp = y_sp;
	}

	public TreeSpecies getSpecies() {
		return species;
	}

	public void setSpecies(TreeSpecies species) {
		this.species = species;
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


















