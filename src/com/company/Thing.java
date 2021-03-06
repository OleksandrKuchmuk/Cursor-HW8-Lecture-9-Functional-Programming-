package com.company;

public class Thing {
    private String name;
    private boolean fragile;
    private boolean doublePackage;

    public Thing(String name, boolean fragile) {
        this.name = name;
        this.fragile = fragile;
        this.doublePackage = doublePackage;
    }

    public Thing(String name, boolean fragile, boolean doublePackage) {
        this.name = name;
        this.fragile = fragile;
        this.doublePackage = doublePackage;
    }

    public String getName() {
        return name;
    }

    public boolean setDoublePackage() {
        doublePackage = true;
        return doublePackage;
    }

    public boolean isFragile() {
        return fragile;
    }

    public boolean isDoublePackage() {
        return doublePackage;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "name='" + name + '\'' +
                ", fragile=" + fragile +
                ", doublePackage=" + doublePackage +
                '}';
    }


}
