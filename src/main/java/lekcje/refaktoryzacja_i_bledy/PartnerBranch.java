package main.java.lekcje.refaktoryzacja_i_bledy;

// Niespójność pól pomiędzy equals() a hashCode() (Partial Hash).
// Użycie mniejszej liczby pól w hashCode() niż w equals() nie łamie
// twardo kontraktu (równe obiekty nadal będą miały ten sam hash), ale jest to antywzorzec.
// Generuje to niepotrzebne kolizje dla obiektów, które mają ten sam 'branchId',
// ale inne 'city' (np. przy błędnych danych). Złotą zasadą jest używanie do obliczania
// hasha dokładnie tych samych atrybutów, co przy porównywaniu w equals().
class PartnerBranch {
    private final String branchId;
    private final String city;

    public PartnerBranch(String branchId, String city) {
        this.branchId = branchId;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartnerBranch)) return false;
        PartnerBranch other = (PartnerBranch) o;
        return this.branchId.equals(other.branchId) && this.city.equals(other.city);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(branchId);
    }
}