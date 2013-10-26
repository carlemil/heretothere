package se.kjellstrand.here2there.data;

public class WayPointData {
    CoordData location;
    Integer step_index;
    Double step_interpolation;

    public CoordData getLocation() {
        return location;
    }

    public void setLocation(CoordData location) {
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
