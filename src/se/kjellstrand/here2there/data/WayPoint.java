package se.kjellstrand.here2there.data;

public class WayPoint {
    Coord location;
    Integer step_index;
    Double step_interpolation;

    public Coord getLocation() {
        return location;
    }

    public void setLocation(Coord location) {
        this.location = location;
    }

    public Integer getStep_index() {
        return step_index;
    }

    public void setStep_index(Integer step_index) {
        this.step_index = step_index;
    }

    public Double getStep_interpolation() {
        return step_interpolation;
    }

    public void setStep_interpolation(Double step_interpolation) {
        this.step_interpolation = step_interpolation;
    }
}
