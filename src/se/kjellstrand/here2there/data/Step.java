package se.kjellstrand.here2there.data;

public class Step {
    TextValue distance;
    TextValue duration;
    Coord end_location;
    Coord start_location;
    String html_instructions;
    PolyLine polyline;
    String travel_mode;

    public TextValue getDistance() {
        return distance;
    }

    public TextValue getDuration() {
        return duration;
    }

    public Coord getEnd_location() {
        return end_location;
    }

    public String getHtml_instructions() {
        return html_instructions;
    }

    public PolyLine getPolyline() {
        return polyline;
    }

    public Coord getStart_location() {
        return start_location;
    }

    public String getTravel_mode() {
        return travel_mode;
    }

    public void setDistance(TextValue distance) {
        this.distance = distance;
    }

    public void setDuration(TextValue duration) {
        this.duration = duration;
    }

    public void setEnd_location(Coord end_location) {
        this.end_location = end_location;
    }

    public void setHtml_instructions(String html_instructions) {
        this.html_instructions = html_instructions;
    }

    public void setPolyline(PolyLine polyline) {
        this.polyline = polyline;
    }

    public void setStart_location(Coord start_location) {
        this.start_location = start_location;
    }

    public void setTravel_mode(String travel_mode) {
        this.travel_mode = travel_mode;
    }

}
