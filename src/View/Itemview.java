package View;

import java.util.List;
import java.util.Scanner;

import Controller.Itemcontroller;
import Models.Itemcategory;
import Models.Items;

public class Itemview {
    Scanner scanner =new Scanner(System.in);
    Itemcontroller itemcontroller=new Itemcontroller();
    Categoryview categoryview=new Categoryview();
    public void manageitems() throws Exception{
        boolean run=true;
        while(run){
        int manageProductsChoice;
        System.out.println("+------------------------------+");
        System.out.println("|       Manage Products        |");
        System.out.println("+------------------------------+");
        System.out.println("| 1. View Products.            |");
        System.out.println("| 2. Add Products.             |");
        System.out.println("| 3. Add Category.             |");
        System.out.println("| 4. Delete Category.          |");
        System.out.println("| 5. Delete Products.          |");
        System.out.println("| 6. Go Back.                  |");
        System.out.println("+------------------------------+");
        System.out.print("| Enter your choice :");
        manageProductsChoice = Integer.parseInt(scanner.nextLine());
        System.out.println("+------------------------------+");
        switch (manageProductsChoice) {
            case 1:
                try {
                    int productChoice=0;
                    List<Items> itemList = itemcontroller.viewitems();
                    if(itemList.size()==0){
                        System.out.println();
                        System.out.println("+------------------------------+");
                        System.out.println("Pls Add Products to Show!!!");
                        System.out.println("+------------------------------+");
                        System.out.println();
                        System.out.println();
                        break;
                    }
                    viewitem(itemList);
                    System.out.print("| Enter your choice of id...");
                  while(true){
                    productChoice = Integer.parseInt(scanner.nextLine());
                    Items product = itemcontroller.viewitemsbyid(productChoice);
                    if(product.getId()==null){
                        System.out.println("Enter Correct Id!!!");
                        continue;
                    }
                    else{
                        break;
                    }
                  }
                    System.out.println("+------------------------------+\n");
                    Items product = itemcontroller.viewitemsbyid(productChoice);
                    viewitem(product);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
            int sucess = 0;
            do {
                try {
                    Items product = new Items();
                   System.out.println();
                   System.out.println("+-------------------------------- +");
                   System.out.println("|          Add Product            |");
                   System.out.println("+---------------------------------+");
                   System.out.print("| Enter Product Name :");
                   String productName = scanner.nextLine();
                    if (productName.length() > 3) {
                        product.setName(productName);
                        System.out.print("| Enter Price :");
                        double productPrice = Double.parseDouble(scanner.nextLine());
                        if (productPrice > 0) {
                            product.setPrice(productPrice);
                           System.out.println("| Select Product Category :");
                            int productCategoryChoice;
                            categoryview.allcategory();
                           System.out.print("| Enter your choice:");
                           while(true){
                            productCategoryChoice = Integer.parseInt(scanner.nextLine());
                           System.out.println("");
                           Itemcategory productCategory=itemcontroller.getItemcategoryByItemcategoryId(productCategoryChoice);
                           if(productCategory.getItemcategoryId()==null){
                            System.out.println("Enter Correct Id!");
                            continue;
                           }
                           else{
                            System.out.println("+------------------------------+");
                            break;
                           }
                        }
                                Itemcategory productCategory = itemcontroller.getItemcategoryByItemcategoryId(productCategoryChoice);
                                product.setCategory(productCategory);
                                int productId = itemcontroller.createitem(product);
                                if (productId != 0) {
                                    System.out.println();
                                   System.out.println("+------------------------------+");
                                   System.out.println("Product added successfully");
                                   System.out.println("Your product information appears below.");
                                   System.out.println("+------------------------------+");
                                    Thread.sleep(1000);
                                       System.out.println("");
                                        sucess = 1;
                                       viewitem(product);
                                }
                                else{
                                    System.out.println("product creation failed!! try again.");
                                }
                            } 
                         else {
                            System.out.println("Invalid User Input : Please enter valid price.");
                        }
                    } else {
                        System.out.println("Invalid User Input : Please enter valid product name.");
                    }
            
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (sucess != 1);
                break;
            case 3:
             sucess = 0;
            do {
                try {
                    Itemcategory itemcategory=new Itemcategory();
                    System.out.println();
                    System.out.println("+-------------------------------- +");
                    System.out.println("|          Add Category           |");
                    System.out.println("+---------------------------------+");
                    System.out.print("| Enter Category Name :");
                    String Name = scanner.nextLine();
                    itemcategory.setItemcategoryName(Name);
                   int categoryid= itemcontroller.addCategory(itemcategory);
                   if(categoryid!=0){
                    System.out.println();
                    System.out.println("+------------------------------+");
                    System.out.println("Category added successfully");
                    System.out.println("Your category information appears below.");
                    System.out.println("+------------------------------+");
                     Thread.sleep(1000);
                        System.out.println("");
                         sucess = 1;
                        System.out.println("+------------------------------+");
                        System.out.println("|       Category Details       |");
                        System.out.println("+------------------------------+");
                        System.out.println("| Category ID : " + categoryid);
                        System.out.println("|                              ");
                        System.out.println("| Name : " +itemcategory.getItemcategoryName());
                        System.out.println();
                        Thread.sleep(5000);
                   }
                   else{
                    System.out.println("Category Creation failed!!!!");
                   }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (sucess != 1);
            break;
            case 4:
            System.out.println("| Select Category For Deletion  |");
           categoryview.allcategory();
           System.out.print("| Enter your choice:");
           int choice=scanner.nextInt();
           itemcontroller.deletecategorybyid(choice);
           System.out.println("| Category Deleted Sucessfully |");
            break;
            case 5:
            System.out.println("| Select Product For Deletion |");
            List<Items> itemList = itemcontroller.viewitems();
            viewitem(itemList);
            System.out.print("| Enter your choice:");
            choice=scanner.nextInt();
            itemcontroller.deleteitembyid(choice);
            System.out.println("| Category Deleted Sucessfully |");            
            break;
            case 6:
            run=false;
            break;
            default: System.out.println("Invalid User Input Try again!");
    }
}
    }
    public void viewitem(Items product){
        System.out.println("+------------------------------+");
        System.out.println("|       Product Details        |");
        System.out.println("+------------------------------+");
        System.out.println("|                              ");
        System.out.println("| Name : " + product.getName());
        System.out.println("| Category : " + product.getCategory().getItemcategoryName());
        System.out.println("| Price : ₹" + product.getPrice());
        System.out.println("+------------------------------+");
        System.out.println("");
 }
 public void viewitem(List<Items> itemList){
                    System.out.println("+------------------------------+");
                    System.out.println("|          Products            |");
                    System.out.println("+------------------------------+");
                    System.out.println("| id  Product Name              ");
                    System.out.println("|                               ");
                    for (Items items : itemList) {
                    System.out.println("| " + items.getId() + ". " + items.getName());
                    }
                    System.out.println("+------------------------------+");
 }
    }

