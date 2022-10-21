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

public class Tree implements Comparable<Tree> {

	/*
	 * public Tree (int treeID, TreeSpecies species )
	 * 
	 * The treeID should be a non-negative integer and the species should not be
	 * null. If the constructor is called with invalid arguments, then an instance
	 * of IllegalArgumentException should be thrown carrying an appropriate error
	 * message.
	 * 
	 * There should be no default constructor.
	 */

	private int tree_id;
	private String status;
	private String health;
	private String spc_latin;
	private String spc_common;
	private int zipcode;
	private String boroname;
	private double x_sp;
	private double y_sp;
	private TreeSpecies species;

	public Tree(int treeID, TreeSpecies species) {
		// Input validation:
		if (treeID < 0)
			throw new IllegalArgumentException("Tree ID must be " + "nonnegative");
		if (species == null)
			throw new IllegalArgumentException("Species " + "must not be null");

		this.tree_id = treeID;
		this.species = species;

		// Get species names form TreeSpecies.java
		this.spc_common = species.getCommonName().toLowerCase();
		this.spc_latin = species.getLatinName().toLowerCase();
	}

	public int getTree_id() {
		return tree_id;
	}

	public void setTree_id(int tree_id) {
		// Input validation
		if (tree_id < 0)
			throw new IllegalArgumentException("Tree ID must be" + " nonnegative");
		this.tree_id = tree_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		// Input Validation:
		if (!(status == null)) {
			status = status.toLowerCase();
		}

		if (!(status == null || status.equalsIgnoreCase("dead") || status.equalsIgnoreCase("stump")
				|| status.equalsIgnoreCase("") || status.equalsIgnoreCase("alive"))) {
			throw new IllegalArgumentException("Invalid Status Argument");
		}
		this.status = status;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		// Input Validation:
		if (!(health == null)) {
			health = health.toLowerCase();
		}

		if (!(health == null || health.equalsIgnoreCase("good") || health.equalsIgnoreCase("fair")
				|| health.equalsIgnoreCase("") || health.equalsIgnoreCase("poor"))) {
			throw new IllegalArgumentException("Invalid Health Argument");
		}
		this.health = health;
	}

	public String getSpc_latin() {
		return spc_latin;
	}

	public void setSpc_latin(String spc_latin) {
		// Input Validation:
		if (spc_latin == null)
			throw new IllegalArgumentException("Latin Name " + "is null");
		this.spc_latin = spc_latin.toLowerCase();
	}

	public String getSpc_common() {
		return spc_common;
	}

	public void setSpc_common(String spc_common) {
		// Input Validation:
		if (spc_common == null)
			throw new IllegalArgumentException("Common Name " + "is null");
		this.spc_common = spc_common.toLowerCase();
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		// Input Validation:
		if (!(0 <= zipcode && 99999 >= zipcode)) {
			throw new IllegalArgumentException("Zipcode must be between 0 " + "and 99999");
		}
		this.zipcode = zipcode;

	}

	public String getBoroname() {
		return boroname;
	}

	public void setBoroname(String boroname) {
		// Input Validation:
		if (!(boroname == null)) {
			boroname = boroname.toLowerCase();
		}

		if (!(boroname == null || boroname.equalsIgnoreCase("manhattan") || boroname.equalsIgnoreCase("bronx")
				|| boroname.equalsIgnoreCase("brooklyn") || boroname.equalsIgnoreCase("queens")
				|| boroname.equalsIgnoreCase("staten island"))) {
			throw new IllegalArgumentException("Invalid Borough Argument");
		}
		this.boroname = boroname;
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
	 * equals(Object obj) The two Tree objects should be considered equal if their
	 * id's and both, Latin and common, species names are the same. The other values
	 * should not be considered in the equality. The name comparison should be case
	 * insensitive.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Tree)) {
			throw new IllegalArgumentException("Must compare two Tree objects");
		}
		Tree t = (Tree) obj;
		int thisTreeID = this.getTree_id();
		int otherTreeID = t.getTree_id();

		String thisLatinName = this.getSpc_latin();
		String otherLatinName = t.getSpc_latin();

		String thisCommonName = this.getSpc_common();
		String otherCommonName = t.getSpc_common();

		if (thisTreeID == otherTreeID && (thisLatinName.equals(otherLatinName))
				&& (thisCommonName.equalsIgnoreCase(otherCommonName))) {
			return true;
		}
		return false;

	}

	@Override
	public int compareTo(Tree o) {
		int val = 0;

		String thisCommonName = this.getSpc_common();
		String otherCommonName = o.getSpc_common();

		// If the two Tree objects have the same common name
		// use the ID number to compare
		if (this.getSpc_common().equals(o.getSpc_common())) {
			if (this.tree_id > o.getTree_id()) {
				val = 1;
			} else if (this.getTree_id() < o.getTree_id()) {
				val = -1;
			} else {
				val = 0;
			} // Same common name and ID
		} else {
			val = thisCommonName.compareTo(otherCommonName);
		}
		return val;
	}

	public String capFirstLetter(String str) {
		if (str == null)
			return str;
		if (str.length() <= 1)
			return str;
		String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
		return cap;
	}

	@Override
	public String toString() {
		// TODO Implement a toString method that is a meaningful representation
		// of the object on which it is called.

		String title = "Information for " + capFirstLetter(this.getSpc_common()) + " (ID: " + this.getTree_id() + ")"
				+ " Tree:";

		String latin = "\n  Latin:\t" + capFirstLetter(this.getSpc_latin());
		String status = "\n  Status:\t" + capFirstLetter(this.getStatus());
		String health = "\n  Health:\t" + capFirstLetter(this.getHealth());
		String zip = Integer.toString(this.getZipcode());

		// Handling trailing zeros of zipcode:
		if (zip.length() < 5) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < (5 - zip.length()); i++) {
				sb.append("0");
			}
			sb.append(zip);
			zip = sb.toString();
		}

		String zipcode = "\n  Zipcode:\t" + zip;
		String boro = "\n  Borough:\t" + capFirstLetter(this.getBoroname());

		String s = title + latin + status + health + zipcode + boro;
		return s;

	}

}
