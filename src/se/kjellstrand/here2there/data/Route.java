package se.kjellstrand.here2there.data;

public class Route {
    Bounds bounds;
    String copyrights;
    Leg legs[];

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public Leg[] getLegs() {
        return legs;
    }

    public void setLegs(Leg[] legs) {
        this.legs = legs;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }
}
