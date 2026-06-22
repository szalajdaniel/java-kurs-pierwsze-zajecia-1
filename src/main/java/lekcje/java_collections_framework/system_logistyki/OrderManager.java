package main.java.lekcje.java_collections_framework.system_logistyki;

import java.util.*;

class OrderManager {
    private final Map<String, List<String>> zonePackages = new HashMap<>();
    private final PriorityQueue<Courier> dispatchQueue;

    public OrderManager() {
        this.dispatchQueue = new PriorityQueue<>(Comparator.comparingInt(Courier::loadPercentage));
    }

    public void assignPackageToZone(String zone, String packageCode) {
        zonePackages.computeIfAbsent(zone, k -> new ArrayList<>()).add(packageCode);
    }

    public void registerCourier(Courier courier) {
        dispatchQueue.offer(courier);
    }

    public void processDispatch() {
        while (!dispatchQueue.isEmpty()) {
            Courier courier = dispatchQueue.poll();
            System.out.printf("[WYSYŁKA] Ładuję auto kuriera: %s (Zapełnienie: %d%%)%n",
                    courier.name(), courier.loadPercentage());
        }
    }

    public void printZones() {
        System.out.println("Stan stref wysyłkowych: " + zonePackages);
    }
}