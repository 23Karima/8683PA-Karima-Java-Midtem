package data_structures;
import java.util.ArrayList;
import java.util.Iterator;
public class UseArrayList {

    /** INSTRUCTIONS
     *
     * Demonstrate how to use an ArrayList that includes using the add, peek, remove & retrieve methods.
     * Use For-Each loop and While-loop with Iterator to retrieve the data.
     *
     * Store and retrieve the data from/to a database table.
     */

    public static void main(String[] args) {
        // Create an ArrayList to store data
        ArrayList<String> list = new ArrayList<>();
        list.add("Jeep, ");//using add() method to add elements to the ArrayList
        list.add("Tesla, ");
        list.add("Mini");

        // printing  the data using a For-Each loop
        System.out.println("\nData retrieved using For-Each loop:");
        for (String item : list) {
            System.out.print(item);
        }
        // retrieved and print the data using a While loop and Iterator
        System.out.println("\nData retrieved using While loop and Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.print(item);
        }

        // Retrieve and print the first element in the ArrayList
        System.out.println("\nThe first type of cars brands is: " + list.get(0));

        // Remove the second element from the ArrayList mean in the index 1.
        list.remove(1);//here remove Tesla.

        // print our array after updating.
        System.out.println("Updated ArrayList: " + list);
    }
}
