package main.java.lekcje.refaktoryzacja_i_bledy;

// Brak nadpisania metody hashCode() przy jednoczesnym nadpisaniu equals().
// Łamie to podstawowy kontrakt Javy (obiekty równe według equals
// muszą mieć ten sam hashCode). W kolekcjach opartych na hashowaniu (HashSet, HashMap)
// dwa identyczne logicznie obiekty otrzymają różne hashe (domyślnie oparte na adresie
// w pamięci). HashSet pozwoli na dodanie duplikatów, a HashMap.get() przy użyciu
// identycznego, ale nowo utworzonego obiektu zwróci null.
class CustomerCard {
    private final String cardId;
    private final String ownerName;

    public CustomerCard(String cardId, String ownerName) {
        this.cardId = cardId;
        this.ownerName = ownerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerCard)) return false;
        CustomerCard other = (CustomerCard) o;
        return this.cardId.equals(other.cardId) && this.ownerName.equals(other.ownerName);
    }
}
