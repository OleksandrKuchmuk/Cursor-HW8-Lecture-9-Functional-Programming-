package com.company;

public class Thing {
    private String name;
    private boolean fragile;
    private boolean Package;

    public Thing(String name, boolean fragile) {
        this.name = name;
        this.fragile = fragile;
        this.Package = Package;
    }

    public String getName() {
        return name;
    }

    public void setDoublePackage() {
        this.Package = Package;
    }

    public boolean isFragile() {
        return fragile;
    }

    public boolean isDoublePackage() {
        return Package;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "name='" + name + '\'' +
                ", fragile=" + fragile +
                ", doublePackage=" + Package +
                '}';
    }
}
