package main.java.lekcje.refaktoryzacja_i_bledy;

// Stała wartość zwracana przez hashCode() (tzw. Hash Collision / Constant Hash).
// Technicznie kontrakt jest spełniony (równe obiekty mają ten sam hash),
// ale jest to fatalny antywzorzec wydajnościowy. Każdy nowo dodany obiekt trafi do
// tego samego "koszyka" (bucket) w HashMap/HashSet. Zamiast szybkiego dostępu w czasie O(1),
// kolekcja zamieni się w listę wiązaną (lub drzewo od Javy 8), drastycznie degradując
// wydajność do O(n) lub O(log n).
class DiscountCoupon {
    private final String couponCode;
    private final int discountPercent;

    public DiscountCoupon(String couponCode, int discountPercent) {
        this.couponCode = couponCode;
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountCoupon)) return false;
        DiscountCoupon other = (DiscountCoupon) o;
        return this.couponCode.equals(other.couponCode) && this.discountPercent == other.discountPercent;
    }

    @Override
    public int hashCode() {
        return 7;
    }
}