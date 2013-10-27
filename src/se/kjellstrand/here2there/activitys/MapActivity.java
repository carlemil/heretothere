package se.kjellstrand.here2there.activitys;

import se.kjellstrand.here2there.R;
import se.kjellstrand.here2there.fragments.RetainedMapFragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.GoogleMap;

public class MapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity_layout);

        GoogleMap map = ((RetainedMapFragment)
                getFragmentManager().findFragmentById(R.id.retained_mapfragment_map))
                        .getMap();
        map.setMyLocationEnabled(true);

        /* final LatLng HAMBURG = new LatLng(53.558, 9.927); final LatLng KIEL =
         * new LatLng(53.551, 9.993); */
        /* Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
         * .title("Hamburg")); Marker kiel = map.addMarker(new MarkerOptions()
         * .position(KIEL) .title("Kiel") .snippet("Kiel is cool")
         * .icon(BitmapDescriptorFactory
         * .fromResource(R.drawable.ic_launcher))); */
        // Move the camera instantly to hamburg with a zoom of 15.
        // map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));

        // Zoom in, animating the camera.
        // map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        // map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // map.addMarker(new MarkerOptions().position(new LatLng(0,
        // 0)).title("Marker"));

        // GoogleMap map = ((RetainedMapFragment)
        // getFragmentManager().findFragmentById(R.id.map))
        // .getMap();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
