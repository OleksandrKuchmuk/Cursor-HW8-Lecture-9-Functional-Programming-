package com.company;

public class Thing {
    private String name;
    private boolean fragile;
    private boolean doublePackage;

//    public Thing(String ball, boolean b, boolean b1) {
//        this.name = name;
//        this.fragile = fragile;
//    }

    public Thing(String name, boolean fragile) {
        this.name = name;
        this.fragile = fragile;
        this.doublePackage = doublePackage;
    }

    public String getName() {
        return name;
    }

    public void setDoublePackage() {
        this.doublePackage = doublePackage;
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
