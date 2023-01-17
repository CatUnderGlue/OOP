package collections.part1.mechanics;

import collections.part1.transports.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Mechanic<T extends Transport> {
    private List<T> transports = new ArrayList<>();
    private String fullname;
    private String company;
    private T transportType;

    public Mechanic(String fullname, String company) {
        if (fullname == null || fullname.isEmpty() || fullname.isBlank()) {
            this.fullname = "default";
        } else {
            this.fullname = fullname;
        }
        setCompany(company);
    }

    public void carryOutMaintenance(){
        System.out.printf("%s проводит техобслуживание т/с марки %s %s\n", fullname, transportType.getBrand(), transportType.getModel());
    }

    public void fixTransport(){
        System.out.printf("%s чинит т/с %s %s\n", fullname, transportType.getBrand(), transportType.getModel());
    }

    public void addTransport(T transport){
        transports.add(transport);
    }

    public void removeTransport(T transport){
        transports.remove(transport);
    }

    public List<T> getTransports() {
        return transports;
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

    public T getTransportType() {
        return transportType;
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
        return Objects.equals(transports, mechanic.transports) && Objects.equals(fullname, mechanic.fullname) && Objects.equals(company, mechanic.company) && Objects.equals(transportType, mechanic.transportType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transports, fullname, company, transportType);
    }
}
