package se.kjellstrand.here2there.activitys;

import java.util.List;

import se.kjellstrand.here2there.R;
import se.kjellstrand.here2there.data.PolylineData;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

// import com.google.android.gms.maps.FragmentActivity;

public class MapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

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

        GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();

        map.setMyLocationEnabled(true);

        // drawPolyLine(list);

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
