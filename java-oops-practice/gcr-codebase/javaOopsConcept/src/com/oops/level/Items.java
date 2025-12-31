import java.util.*;
public class Items{
    String itemcode;
    String itemname;
    double price;

    Items(String itemcode, String itemname , double price){
         this.itemcode = itemcode;
         this.itemname = itemname;
         this.price = price;
    }

    public void displayBookDetails(int i){
        System.out.println("itemcode : "+ itemcode);
        System.out.println("itemname : "+ itemname);
        System.out.println("price : "+ price);

    }
    public static void main(String[] args) {
        String itemName={"waterbottle","bag","shoes"};
        String itemCode={"A" , "B" ,"C"};
        Double price={"200","300","400"};

        Items item1=new Items(itemName,itemCode,price);

        for(int i=0;i=price.length;i++){
            item1.displayItems(i);
        }

    }
}

