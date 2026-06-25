package aero_flow.model;

import java.util.Objects;

public class Passport {
    private final String passportNumber;
    private final String holderName;

    public Passport(String passportNumber, String holderName) {
        this.passportNumber = passportNumber;
        this.holderName = holderName;
    }

    public String getHolderName() {
        return holderName;
    }
    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(passportNumber, passport.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(passportNumber);
    }

    @Override
    public String toString() {
        return "Passport: " +
                "passportNumber='" + passportNumber + '\'' +
                ", holderName='" + holderName + '\'';
    }
}
