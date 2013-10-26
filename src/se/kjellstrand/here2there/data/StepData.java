package se.kjellstrand.here2there.data;

public class StepData {
    TextValueData distance;
    TextValueData duration;
    CoordData end_location;
    CoordData start_location;
    String html_instructions;
    PolylineData polyline;
    String travel_mode;

    public TextValueData getDistance() {
        return distance;
    }

    public TextValueData getDuration() {
        return duration;
    }

    public CoordData getEnd_location() {
        return end_location;
    }

    public String getHtml_instructions() {
        return html_instructions;
    }

    public PolylineData getPolyline() {
        return polyline;
    }

    public CoordData getStart_location() {
        return start_location;
    }

    public String getTravel_mode() {
        return travel_mode;
    }

    public void setDistance(TextValueData distance) {
        this.distance = distance;
    }

    public void setDuration(TextValueData duration) {
        this.duration = duration;
    }

    public void setEnd_location(CoordData end_location) {
        this.end_location = end_location;
    }

    public void setHtml_instructions(String html_instructions) {
        this.html_instructions = html_instructions;
    }

    public void setPolyline(PolylineData polyline) {
        this.polyline = polyline;
    }

    public void setStart_location(CoordData start_location) {
        this.start_location = start_location;
    }

    public void setTravel_mode(String travel_mode) {
        this.travel_mode = travel_mode;
    }

}
