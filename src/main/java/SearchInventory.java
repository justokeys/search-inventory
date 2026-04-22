import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventory {
//Global scanner and Array list they scan be seen and used across the entire class
    static Scanner thescanner = new Scanner(System.in);
    static ArrayList<Product> inventory = new ArrayList<>();

    @Override
    public String toString() {
        return "SearchInventory{}";
    }

    public static void main(String[] args) {
        //placing my function ahead of time
        getInventory();
        //building my menu using while loop and later a switch
        boolean appRunning = true;
        while (appRunning){
            // Menu options
            System.out.println(
            """ 
            What do you want to do?
            1- List all products
            2- Lookup a product by its id
            3- Find all products within a price range
            4- Add a new product
            5- Quit the application
            Enter command:\s""" );

        }



    }
}
