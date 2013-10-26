package se.kjellstrand.here2there.activitys;

import java.io.UnsupportedEncodingException;

import se.kjellstrand.here2there.R;
import se.kjellstrand.here2there.app.Here2ThereApplication;
import se.kjellstrand.here2there.data.DirectionsData;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class MainActivity extends Activity implements Listener<DirectionsData>, ErrorListener {

    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        Button sendDirButton = (Button) findViewById(R.id.sendDirectionsRequestButton);
        final MainActivity this_ = this;
        sendDirButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String origin = ((TextView) findViewById(R.id.fromDirectionTextView)).getText().toString();
                String destination = ((TextView) findViewById(R.id.toDirectionTextView)).getText().toString();
                try {
                    Here2ThereApplication.get().getApi().getDirections(this_,
                            origin, destination, this_, this_);
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
    public void onResponse(DirectionsData arg0) {
        Log.d(TAG, "Got response.");
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);

    }

}
