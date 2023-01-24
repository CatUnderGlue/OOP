package collections.part3;

import collections.part3.transports.Transport;

import java.util.Objects;

public class Mechanic<T extends Transport<?>> {
    private final String fullname;
    private String company;

    public Mechanic(String fullname, String company) {
        if (fullname == null || fullname.isEmpty() || fullname.isBlank()) {
            this.fullname = "default";
        } else {
            this.fullname = fullname;
        }
        setCompany(company);
    }

    public void  carryOutMaintenance(T transport){
        System.out.printf("%s проводит техобслуживание т/с марки %s %s\n", fullname, transport.getBrand(), transport.getModel());
    }

    public void fixTransport(T transport){
        System.out.printf("%s чинит т/с %s %s\n", fullname, transport.getBrand(), transport.getModel());
    }

    public String getFullname() {
        return fullname;
    }

    public void setCompany(String company) {
        if (company == null || company.isEmpty() || company.isBlank()) {
            this.company = "default";
        } else {
            this.company = company;
        }
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return fullname + " из компании - " + company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(fullname, mechanic.fullname) && Objects.equals(company, mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, company);
    }
}
