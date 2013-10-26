package se.kjellstrand.here2there.data;

public class LegData {
    TextValueData distance;
    TextValueData duration;
    String end_address;
    CoordData end_location;
    String start_address;
    CoordData start_location;
    StepData steps[];
    WayPointData via_waypoint[];

    public TextValueData getDistance() {
        return distance;
    }

    public TextValueData getDuration() {
        return duration;
    }

    public String getEnd_address() {
        return end_address;
    }

    public CoordData getEnd_location() {
        return end_location;
    }

    public String getStart_address() {
        return start_address;
    }

    public CoordData getStart_location() {
        return start_location;
    }

    public StepData[] getSteps() {
        return steps;
    }

    public void setDistance(TextValueData distance) {
        this.distance = distance;
    }

    public void setDuration(TextValueData duration) {
        this.duration = duration;
    }

    public void setEnd_address(String end_address) {
        this.end_address = end_address;
    }

    public void setEnd_location(CoordData end_location) {
        this.end_location = end_location;
    }

    public void setStart_address(String start_address) {
        this.start_address = start_address;
    }

    public void setStart_location(CoordData start_location) {
        this.start_location = start_location;
    }

    public void setSteps(StepData[] steps) {
        this.steps = steps;
    }
}
