package se.kjellstrand.here2there.data;

public class BoundsData {
    CoordData northeast;
    CoordData southwest;

    public CoordData getNortheast() {
        return northeast;
    }

    public CoordData getSouthwest() {
        return southwest;
    }

    public void setNortheast(CoordData northeast) {
        this.northeast = northeast;
    }

    public void setSouthwest(CoordData southwest) {
        this.southwest = southwest;
    }

}
