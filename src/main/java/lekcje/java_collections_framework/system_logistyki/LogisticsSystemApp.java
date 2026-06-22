package main.java.lekcje.java_collections_framework.system_logistyki;

public class LogisticsSystemApp {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();

        manager.assignPackageToZone("WARSZAWA", "P-1");
        manager.assignPackageToZone("WARSZAWA", "P-2");
        manager.assignPackageToZone("KRAKÓW", "P-3");

        manager.printZones();
        System.out.println("---");

        manager.registerCourier(new Courier("Jan", 80));
        manager.registerCourier(new Courier("Anna", 20));
        manager.registerCourier(new Courier("Marek", 50));

        manager.processDispatch();
    }
}