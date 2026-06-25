package main.java.lekcje.refaktoryzacja_i_bledy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class LoyaltyAppManager {

    static class CustomerCard {
        private final String cardId;
        private final String ownerName;

        public CustomerCard(String cardId, String ownerName) {
            this.cardId = cardId;
            this.ownerName = ownerName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CustomerCard that = (CustomerCard) o;
            return Objects.equals(cardId, that.cardId) &&
                    Objects.equals(ownerName, that.ownerName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cardId, ownerName);
        }
    }

    static class DiscountCoupon {
        private final String couponCode;
        private final int discountPercent;

        public DiscountCoupon(String couponCode, int discountPercent) {
            this.couponCode = couponCode;
            this.discountPercent = discountPercent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DiscountCoupon that = (DiscountCoupon) o;
            return discountPercent == that.discountPercent &&
                    Objects.equals(couponCode, that.couponCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(couponCode, discountPercent);
        }
    }

    static class PartnerBranch {
        private final String branchId;
        private final String city;

        public PartnerBranch(String branchId, String city) {
            this.branchId = branchId;
            this.city = city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PartnerBranch that = (PartnerBranch) o;
            return Objects.equals(branchId, that.branchId) &&
                    Objects.equals(city, that.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(branchId, city);
        }
    }


    public static void main(String[] args) {
        System.out.println("TEST 1: CustomerCard w HashSet");

        Set<CustomerCard> cardSet = new HashSet<>();
        CustomerCard card1 = new CustomerCard("ID-123", "Jan Kowalski");
        CustomerCard card2 = new CustomerCard("ID-123", "Jan Kowalski"); // Duplikat logiczny

        cardSet.add(card1);
        cardSet.add(card2);

        System.out.println("Rozmiar zbioru kart: " + cardSet.size());
        if (cardSet.size() == 1) {
            System.out.println("HashSet prawidłowo zablokował duplikat.\n");
        } else {
            System.out.println("HashSet dopuścił duplikat.\n");
        }

        System.out.println("TEST 2: DiscountCoupon w HashMap");

        Map<DiscountCoupon, String> couponMap = new HashMap<>();
        DiscountCoupon coupon1 = new DiscountCoupon("SUMMER20", 20);

        couponMap.put(coupon1, "Kupon Aktywny");

        DiscountCoupon searchCoupon = new DiscountCoupon("SUMMER20", 20);

        String result = couponMap.get(searchCoupon);
        System.out.println("Wynik z mapy dla nowo utworzonego obiektu: " + result);

        if ("Kupon Aktywny".equals(result)) {
            System.out.println("HashMap prawidłowo pobrał wartość dla logicznie równego klucza.");
        } else {
            System.out.println("HashMap nie znalazł wartości (zwrócono " + result + ").");
        }
    }
}
