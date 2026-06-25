package main.java.lekcje.java_collections_framework;

import java.util.HashSet;
import java.util.Set;

public class SupplierContractTest {
    public static void main(String[] args) {
        Set<Supplier> suppliers = new HashSet<>();

        Supplier s1 = new Supplier("SUP-102", "Firma A");
        Supplier s2 = new Supplier("SUP-102", "Firma B (Duplikat ID)");

        suppliers.add(s1);
        suppliers.add(s2);

        System.out.println("Rozmiar kolekcji HashSet: " + suppliers.size());
    }
}