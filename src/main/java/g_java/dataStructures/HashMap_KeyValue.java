package g_java.dataStructures;

import java.util.HashMap;
import java.util.Map;

public class HashMap_KeyValue {

	public static void main(String[] args) {
		System.out.println("DataStructure 1:\n================\n");

		/** Java HashMap
			In the ArrayList chapter, you learned that Arrays store items as an ordered collection, and you have to access them with an index number (int type).
			A HashMap however, store items in "key/value" pairs, and you can access them by an index of another type (e.g. a String).
			One object is used as a key (index) to another object (value). It can store different types: String keys and Integer values, or the same type, like: String keys and String values.
			------
			import java.util.HashMap; // needs this import of HashMap util class
			HashMap<String, String> capitalCities = new HashMap<String, String>();
			capitalCities.put("Israel", "Jerusalem");
			capitalCities.get("Israel");
			------
			hash = map: key (unique) | value => data structures for quick data fetch (like index in SQL).
			map is a type of collection (array list is a collection of single cell list, while map have double).
			map is build like a table with 2 columns: key (the key must be unique) | value [it operates like a quick fetch database]
			hash map key is any object and it points to another object
		 */
		// section 1) Create a HashMap object called capitalCities holding <String, String> as Key\Value
		HashMap<String, String> capitalCities = new HashMap<String, String>(); // can be <String> or any other object
	    // add keys and values (Country, capitalCity) using .put
	    capitalCities.put("England", "London");
	    capitalCities.put("Germany", "Berlin");
	    capitalCities.put("Norway", "Oslo");
	    capitalCities.put("USA", "Washington DC");
	    
		// print cell value using .get by key
	 	System.out.println("for index 'England' value (of capital) is: " + capitalCities.get("England"));
	 	
	 	// print all list
	    System.out.println("entire map (key & value): " + capitalCities);

	    // add more elements using add
	    capitalCities.put("Israel", "Jerusalem"); // add Israel
	    capitalCities.put("Greece", "Athens"); // add Greece
	    // prints
	    System.out.println("entire map (key & value) after add: " + capitalCities); // print all
	    System.out.println("only index 'israel' value (of capital): " + capitalCities.get("Israel")); // get recently added
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// section 2) Create a HashMap object of Objects [more complex example]
		HashMap<String, HmapCountryClass> mapCountry = new HashMap<String, HmapCountryClass>(); // can be <String> or any other object

		// init objects
		HmapCountryClass usa = new HmapCountryClass("United States", "Washington", 1);
		HmapCountryClass uk = new HmapCountryClass("United Kingdom", "London", 44);
		HmapCountryClass il = new HmapCountryClass("Israel", "Jerusalem", 972);
		// add keys and values (CountryNameIndex, MapCountryClassObject)
		mapCountry.put("United States", usa);
		mapCountry.put("United Kingdom", uk);
		mapCountry.put("Israel", il);
		// print all
	    System.out.println("entire map: " + mapCountry.toString());
	    
	    // to be able to easily loop over this ^ above map we need a temp map within a for-each...
	    for (Map.Entry<String, HmapCountryClass> entry : mapCountry.entrySet()) { // Needs an import !!!
			String c = entry.getKey();
			HmapCountryClass o = entry.getValue();
			System.out.println(c + " Details: ");
			System.out.println(o.getsCountry() + ", " + o.getsCapital() + ", " + o.getiAreaCode());
		}
	    
	    // NOTE as seen in this folder - some time we have a text file which we want to insert into collection so we can use -> will be shown later on...
		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */	
	// this method will do...
}
