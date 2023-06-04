package data_structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

    /** INSTRUCTIONS
     *
     * Demonstrate how to use Queue that includes add, peek, remove & poll methods.
     * Use For-Each loop and While-Loop with Iterator to retrieve data.
     *
     * Store and retrieve data from/to a database table.
     */
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        //I am using add()method to add elements to the queue(Can only add items to the  back of queue)
        queue.add("Montana");
        queue.add("Arizona");
        queue.add("Texas");
        queue.add("Louisiana");
        queue.add("Ohio");

        // I am using peek() method to peek the element at the front
        String state =queue.peek();
        System.out.println("The state at the front of the queue is: " + state);

        // I am using remove() method to remove the state at the front of the queue(can only remove items from front of queue)
        String removedState=queue.remove();
        System.out.println("This state has been removed: " + removedState);

        //I am using remove() method to remove the state at the front of the queue
        String polledState= queue.poll();
        System.out.println("This state has been polled" + polledState);
        /*
        Note: The remove() method throws an exception if the Queue is empty, while the poll() method can be used
        instead if you want to avoid exceptions and get a null return value instead.

         */

        //Retrieving all the states using a for each loop
        System.out.println("Following all the states of the queue:");
        for(String states: queue){
            System.out.println(states);
        }

        //Retrieving all the states using a while loop
        System.out.println("Following all the states of the queue:");
        Iterator<String> iterator = queue.iterator();
        while(iterator.hasNext()){
            String states = iterator.next();
            System.out.println(states);
        }

    }

}
