package se.kjellstrand.here2there.data;

public class Bounds {
    Coord northeast;
    Coord southwest;

    public Coord getNortheast() {
        return northeast;
    }

    public Coord getSouthwest() {
        return southwest;
    }

    public void setNortheast(Coord northeast) {
        this.northeast = northeast;
    }

    public void setSouthwest(Coord southwest) {
        this.southwest = southwest;
    }

}
