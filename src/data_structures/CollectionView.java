package data_structures;

import java.util.Collection;
import java.util.HashMap;


public class CollectionView {

    /** INSTRUCTIONS
     *
     * A map is given to you below, with some data inserted into it.
     *
     * Retrieve the Collection view of the values present in map
     */

    public static void main(String[] args) {

        // Create a HashMap object
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        // Insert key-value pairs into the map
        map.put(5, "San Jose");
        map.put(6, "Seattle");
        map.put(2, "LA");
        map.put(4, "Boston");
        map.put(1, "NYC");
        map.put(3, "Denver");

        // Retrieve the Collection view of the values in the map
        Collection<String> values = map.values();

        // Print the collection view of values
        System.out.println("Collection View of Values: " + values);
    }
}





