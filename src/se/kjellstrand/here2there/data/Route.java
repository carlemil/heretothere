package se.kjellstrand.here2there.data;

public class Route {
    Bounds bounds;
    String copyrights;
    Leg legs[];
    OverviewPolyline overview_polyline;
    String summary;
    String warnings[];
    Integer waypoint_order[];

    public Bounds getBounds() {
        return bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public Leg[] getLegs() {
        return legs;
    }

    public OverviewPolyline getOverview_polyline() {
        return overview_polyline;
    }

    public String getSummary() {
        return summary;
    }

    public String[] getWarnings() {
        return warnings;
    }

    public Integer[] getWaypoint_order() {
        return waypoint_order;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public void setLegs(Leg[] legs) {
        this.legs = legs;
    }

    public void setOverview_polyline(OverviewPolyline overview_polyline) {
        this.overview_polyline = overview_polyline;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setWarnings(String[] warnings) {
        this.warnings = warnings;
    }

    public void setWaypoint_order(Integer[] waypoint_order) {
        this.waypoint_order = waypoint_order;
    }
}
