package aero_flow.controller;

import aero_flow.model.Aircraft;

import java.util.*;

public class FlightControl {
    private final Map<String, List<String>> gateBoardingList = new HashMap<>();
    private final PriorityQueue<Aircraft> takeoffQueue;

    public Map<String, List<String>> getGateBoardingList() {
        return gateBoardingList;
    }

    public FlightControl() {
        this.takeoffQueue = new PriorityQueue<>((a1, a2) ->
                Integer.compare(a2.emergencyLevel(), a1.emergencyLevel())
        );
    }

    public void assignPassengerToGate(String gate, String passengerName) {
        gateBoardingList.computeIfAbsent(gate, passenegerName -> new ArrayList<>()).add(passengerName);
    }

    public void registerDeparture(Aircraft aircraft) {
        takeoffQueue.add(aircraft);
    }

    public void processTakeoffs() {
        while (!takeoffQueue.isEmpty()) {
            Aircraft aircraft = takeoffQueue.poll();
            System.out.println("[WIEŻA] Zezwalam na start: " + aircraft.flightNumber() +
                    " (Priorytet: " + aircraft.emergencyLevel() + ")");
        }
    }

}
