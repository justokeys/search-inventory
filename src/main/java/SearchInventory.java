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
            thescanner.nextLine();
            // Switch menu that call different methods
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
        for (Products currentProduct : inventory) {

            // Keeping the same csv format for listing the products
            System.out.printf("ID: %d | %s | $%.2f \n", currentProduct.getId(), currentProduct.getName(), currentProduct.getPrice());

        }


    }
   // method to look up products By id from user input
    public static void lookupById(){


        System.out.println("Enter product ID");

        int pID = thescanner.nextInt();


        for (Products currentProduct : inventory) {

            if (pID == currentProduct.getId()) {

                System.out.printf("ID: %d | %s | $%.2f \n", currentProduct.getId(), currentProduct.getName(), currentProduct.getPrice());
                break;
            }



        }




    }

// find by price range with sub switch menu
    public static void findByPriceRange(){
// ask user input
        System.out.println(
                """ 
                Enter price range:
                1- 0-5.00
                2- 5.00 - 20.00
                3- 20.00 - 50.00
                4- 50.00 - 100.00
                5- 100.00+
                Enter command:\s""" );
        boolean appRunning = true;




            int userInput = thescanner.nextInt();// switch statement with while loop to return to main menu
            switch (userInput) {

                case 1:
                    for (int i = 0; i < inventory.size(); i++) {

                        Products price = inventory.get(i);


                        if (price.getPrice() <= 5.00) {
                            System.out.printf("ID: %d | %s | $%.2f \n", price.getId(), price.getName(), price.getPrice());
                        }

                    }
                    break;
                case 2:
                    for (int i = 0; i < inventory.size(); i++) {

                        Products price = inventory.get(i);


                        if (price.getPrice() >= 5.00 && price.getPrice() <= 20.00) {
                            System.out.printf("ID: %d | %s | $%.2f \n", price.getId(), price.getName(), price.getPrice());
                        }

                    }
                    break;
                case 3:
                    for (int i = 0; i < inventory.size(); i++) {

                        Products price = inventory.get(i);

                        if (price.getPrice() >= 20.00 && price.getPrice() <= 50.00) {

                            System.out.printf("ID: %d | %s | $%.2f \n", price.getId(), price.getName(), price.getPrice());
                        }


                    }
                    break;
                case 4:
                    for (int i = 0; i < inventory.size(); i++) {

                        Products price = inventory.get(i);

                        if (price.getPrice() >= 50.00 && price.getPrice() <= 100.00) {

                            System.out.printf("ID: %d | %s | $%.2f \n", price.getId(), price.getName(), price.getPrice());
                        }


                    }
                    break;
                case 5:
                    for (int i = 0; i < inventory.size(); i++) {

                        Products price = inventory.get(i);

                        if (price.getPrice() > 100.00) {

                            System.out.printf("ID: %d | %s | $%.2f \n", price.getId(), price.getName(), price.getPrice());
                        }


                    }
                    break;


            }





}
// take user input and adds to csv file
    public static void addNewProduct(){
        boolean appRunning = true;
        while (appRunning) {

            System.out.println("---Enter Product Data below To Exit Press ( X )---");
            System.out.println();
            System.out.print("Enter Product ID: ");

            String userInput = thescanner.nextLine();
            if( userInput.equalsIgnoreCase("X")){
                System.out.println("Exiting and saving your file...");
                break;
            }




            int newID = Integer.parseInt(userInput);


            System.out.print("Enter Product Name: ");
            String newProductName = thescanner.nextLine();
            System.out.print("Enter Product Price: ");
            double newPrice = thescanner.nextDouble();
            thescanner.nextLine();

            try {
                FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                Products newProduct = new Products(newID,newProductName,newPrice);
                inventory.add(newProduct);
                String newFile =  String.format("%d|%s|%.2f", newProduct.getId(), newProduct.getName(), newProduct.getPrice());
                bufferedWriter.write(newFile);
                bufferedWriter.newLine();
                bufferedWriter.close();




            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }






}








