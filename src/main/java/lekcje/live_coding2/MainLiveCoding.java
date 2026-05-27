package main.java.lekcje.live_coding2;

public class MainLiveCoding {


    public static void main(String[] args) {
        Warehouse<Electronic> warehouse = new Warehouse<Electronic>();
        Electronic electronic = new Electronic("TV",1400);
        Electronic electronic2 = new Electronic(electronic);
        warehouse.addProduct(electronic);
        warehouse.addProduct(electronic2);
        warehouse.showInventory();

        for (Electronic item : warehouse.getProducts()) {
            if(item instanceof Shippable){
                item.ship("Warszawa, ul. Sezamkowa 10");
            }
        }
    }

}
