package se.kjellstrand.here2there.data;

public class Leg {
    TextValue distance;
    TextValue duration;
    String end_address;
    Coord end_location;
    String start_address;
    Coord start_location;
    Step steps[];
    WayPoint via_waypoint[];

    public TextValue getDistance() {
        return distance;
    }

    public TextValue getDuration() {
        return duration;
    }

    public String getEnd_address() {
        return end_address;
    }

    public Coord getEnd_location() {
        return end_location;
    }

    public String getStart_address() {
        return start_address;
    }

    public Coord getStart_location() {
        return start_location;
    }

    public Step[] getSteps() {
        return steps;
    }

    public void setDistance(TextValue distance) {
        this.distance = distance;
    }

    public void setDuration(TextValue duration) {
        this.duration = duration;
    }

    public void setEnd_address(String end_address) {
        this.end_address = end_address;
    }

    public void setEnd_location(Coord end_location) {
        this.end_location = end_location;
    }

    public void setStart_address(String start_address) {
        this.start_address = start_address;
    }

    public void setStart_location(Coord start_location) {
        this.start_location = start_location;
    }

    public void setSteps(Step[] steps) {
        this.steps = steps;
    }
}
