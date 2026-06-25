package main.java.lekcje.java_collections_framework;

import java.util.Objects;

class Supplier {
    private final String supplierId;
    private final String companyName;

    public Supplier(String supplierId, String companyName) {
        this.supplierId = supplierId;
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(supplierId, supplier.supplierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId);
    }

    @Override
    public String toString() {
        return "Supplier{id='" + supplierId + "', name='" + companyName + "'}";
    }
}