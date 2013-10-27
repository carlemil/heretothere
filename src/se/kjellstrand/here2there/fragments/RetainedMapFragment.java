package se.kjellstrand.here2there.fragments;

import java.io.UnsupportedEncodingException;
import java.util.List;

import se.kjellstrand.here2there.app.Here2ThereApplication;
import se.kjellstrand.here2there.data.DirectionsData;
import se.kjellstrand.here2there.data.PolylineData;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class RetainedMapFragment extends MapFragment implements Listener<DirectionsData>, ErrorListener {

    private static final String TAG = RetainedMapFragment.class.getCanonicalName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);

        Activity activity = getActivity();
        String origin = "Malmö C";// ((TextView)
                                  // activity.findViewById(R.id.fromDirectionTextView)).getText().toString();
        String destination = "Malmö Värnhem";// ((TextView)
                                             // activity.findViewById(R.id.toDirectionTextView)).getText().toString();
        try {
            Here2ThereApplication.get().getApi().getDirections(activity,
                    origin, destination, this, this);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        // TODO Auto-generated method stub
        if (volleyError != null && volleyError.networkResponse != null) {
            Log.d(TAG, "Error response: " + volleyError.networkResponse.statusCode);
        } else {
            Log.d(TAG, "Empty error response.");
        }
    }

    @Override
    public void onResponse(DirectionsData directions) {
        Log.d(TAG, "Got response.");

        // drawPolyLine(directions.getRoutes()[0].getOverview_polyline().getPoints());
    }

    private void drawPolyLine(PolylineData polyline, GoogleMap map) {
        List<LatLng> list = polyline.getPointsList();
        LatLng last = null;
        for (int i = 0; i < list.size() - 1; i++) {
            LatLng src = list.get(i);
            LatLng dest = list.get(i + 1);
            last = dest;
            Log.d("latLng:", last.latitude + ", " + last.longitude);
            Polyline line = map.addPolyline(new PolylineOptions().add(
                    new LatLng(src.latitude, src.longitude), new LatLng(dest.latitude, dest.longitude))
                    .width(2)
                    .color(Color.BLUE));
        }
    }

}
