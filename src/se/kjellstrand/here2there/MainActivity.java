package se.kjellstrand.here2there;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

public class MainActivity extends Activity implements Listener<Directions>, ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    public void onErrorResponse(VolleyError arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onResponse(Directions arg0) {
        // TODO Auto-generated method stub

    }

}
