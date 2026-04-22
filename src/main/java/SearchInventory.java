import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventory {
//Global scanner and Array list they scan be seen and used across the entire class
    static Scanner thescanner = new Scanner(System.in);
    static ArrayList<Products> inventory = new ArrayList<>();


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

            int menuChoice = thescanner.nextInt();

            switch (menuChoice){
                case 1:
                    listAllProducts();
                    break;
                case 2:
                    lookupById();
                    break;
                case 3:
                    findByPriceRange();
                    break;
                case 4:
                    addNewProduct();
                    break;
                case 5:
                    appRunning = false;

            }
        }










    }

// fishised getInventory that reads the
    public static void getInventory() {

        try {

            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null){
                String[] productData = line.split("\\|");


                int productId = Integer.parseInt(productData[0]);
                String productName = productData[1];
                double productPrice = Double.parseDouble(productData[2]);

                Products allProducts = new Products(productId,productName,productPrice);
                inventory.add(allProducts);

                String newFile =  String.format("%d|%s|%.2f\n", allProducts.getId(),allProducts.getName(), allProducts.getPrice());


            }
            bufferedReader.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

        // adding method to for option 1 in the menu List all Products
    public static void listAllProducts(){
        for(int i = 0; i < inventory.size(); i++){

            Products currentProduct = inventory.get(i);

            // Keeping the same csv format for listing the productc
            System.out.printf("ID: %d | %s | $%.2f \n", currentProduct.getId(), currentProduct.getName(), currentProduct.getPrice());

        }


    }
}
