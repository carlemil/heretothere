package se.kjellstrand.here2there.data;

import java.util.List;

import se.kjellstrand.here2there.utils.PolyLineParser;

import com.google.android.gms.maps.model.LatLng;

public class PolylineData {
    String points;

    private List<LatLng> pointsList;

    public List<LatLng> getPointsList() {
        return pointsList;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
        pointsList = PolyLineParser.parse(points);
    }
}
