package park_flow;

import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public class Parking {
    Map<String, UnaryOperator<Double>> pricingStrategies = new HashMap<>();

    public Parking(){
        pricingStrategies.put("MOTO", x -> x * 0.5);
        pricingStrategies.put("CAR", x -> x);
        pricingStrategies.put("BUS", x ->x + 20);
    }
    public double calculateFee(double basePrice, String vehicleType){
        UnaryOperator<Double> price = pricingStrategies.get(vehicleType.toUpperCase());

        if (price == null){
            throw new IllegalArgumentException("Invalid vehicle type: " + vehicleType);
        }
        return price.apply(basePrice);
    }
}
