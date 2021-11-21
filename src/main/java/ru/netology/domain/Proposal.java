package ru.netology.domain;

public class Proposal implements Comparable<Proposal> {

    private int id;
    private int price;
    private String depAir;
    private String arrtAir;
    private int travelTime;

    public Proposal(int id, int price, String depAir, String arrtAir, int travelTime) {
        this.id = id;
        this.price = price;
        this.depAir = depAir;
        this.arrtAir = arrtAir;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public String getDepAir() {
        return depAir;
    }

    public String getArrtAir() {
        return arrtAir;
    }

    @Override
    public int compareTo(Proposal p) {
        return this.price - p.price;
    }

}
