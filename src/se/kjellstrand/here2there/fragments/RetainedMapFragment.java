package se.kjellstrand.here2there.fragments;

import java.io.UnsupportedEncodingException;
import java.util.List;

import se.kjellstrand.here2there.R;
import se.kjellstrand.here2there.app.Here2ThereApplication;
import se.kjellstrand.here2there.data.DirectionsData;
import android.app.Dialog;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class RetainedMapFragment extends MapFragment implements
        Listener<DirectionsData>, ErrorListener, LocationListener,
        GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener {

    private static final String TAG = RetainedMapFragment.class.getCanonicalName();

    // A request to connect to Location Services
    private LocationRequest mLocationRequest;

    // Stores the current instantiation of the location client in this object
    private LocationClient mLocationClient;

    // Milliseconds per second
    public static final int MILLISECONDS_PER_SECOND = 1000;

    // The update interval
    public static final int UPDATE_INTERVAL_IN_SECONDS = 5;

    // A fast interval ceiling
    public static final int FAST_CEILING_IN_SECONDS = 1;

    // A fast ceiling of update intervals, used when the app is visible
    public static final long FAST_INTERVAL_CEILING_IN_MILLISECONDS =
            MILLISECONDS_PER_SECOND * FAST_CEILING_IN_SECONDS;

    // Update interval in milliseconds
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS =
            MILLISECONDS_PER_SECOND * UPDATE_INTERVAL_IN_SECONDS;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);

        // Create a new global location parameters object
        mLocationRequest = LocationRequest.create();

        /* Set the update interval */
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);

        // Use high accuracy
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        // Set the interval ceiling to one minute
        mLocationRequest.setFastestInterval(FAST_INTERVAL_CEILING_IN_MILLISECONDS);

        /* Create a new location client, using the enclosing class to handle
         * callbacks. */
        mLocationClient = new LocationClient(getActivity(), this, this);
        mLocationClient.connect();
        // getMap().setMyLocationEnabled(true);

        String origin = "Jayway, Hans Michelsensgatan 10, 211 20 Malmö, Sweden";// ((TextView)
        // activity.findViewById(R.id.fromDirectionTextView)).getText().toString();
        String destination = "Östra Förstadsgatan 13, 211 31 Malmö, Sweden";// ((TextView)
        // activity.findViewById(R.id.toDirectionTextView)).getText().toString();
        try {
            Here2ThereApplication.get().getApi().getDirections(getActivity(),
                    origin, destination, this, this);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * In response to a request to start updates, send a request to Location
     * Services
     */
    private void startPeriodicUpdates() {

        mLocationClient.requestLocationUpdates(mLocationRequest, this);
        Log.d(TAG, "location_requested");
    }

    /**
     * In response to a request to stop updates, send a request to Location
     * Services
     */
    private void stopPeriodicUpdates() {
        mLocationClient.removeLocationUpdates(this);
        Log.d(TAG, "location_updates_stopped");
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
        if (directions.getRoutes().length > 0) {
            GoogleMap map = ((RetainedMapFragment)
                    getFragmentManager().findFragmentById(R.id.retained_mapfragment_map)).getMap();

            drawPolyLine(directions.getRoutes()[0].getOverview_polyline().getPointsList(), map);
        }
    }

    // / Move to a subclass of GoogleMap, that can handle the drawing itself. or
    // perhaps a util class...
    private void drawPolyLine(List<LatLng> list, GoogleMap map) {
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

    private boolean servicesConnected() {
        // Check that Google Play services is available
        int resultCode =
                GooglePlayServicesUtil.
                        isGooglePlayServicesAvailable(getActivity());
        // If Google Play services is available
        if (ConnectionResult.SUCCESS == resultCode) {
            // In debug mode, log the status
            Log.d("Location Updates",
                    "Google Play services is available.");
            // Continue
            return true;
            // Google Play services was not available for some reason
        } else {
            // Display an error dialog
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resultCode, getActivity(), 0);
            if (dialog != null) {
                ErrorDialogFragment errorFragment = new ErrorDialogFragment();
                errorFragment.setDialog(dialog);
                errorFragment.show(getFragmentManager(), "Error tag.");
            }
            return false;
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // TODO Auto-generated method stub
        Log.d(TAG, "onConnectionFailed " + result.getErrorCode());
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        // TODO Auto-generated method stub
        Log.d(TAG, "onConnected");
        startPeriodicUpdates();
    }

    @Override
    public void onDisconnected() {
        // TODO Auto-generated method stub
        Log.d(TAG, "onDisconnected");
        stopPeriodicUpdates();
    }

    @Override
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub
        Log.d(TAG, "LAT: " + location.getLatitude() + " LNG: " + location.getLongitude());
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate update = CameraUpdateFactory.newLatLng(latLng);
        getMap().animateCamera(update);
    }

}
