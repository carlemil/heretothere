package se.kjellstrand.here2there.activitys;

import se.kjellstrand.here2there.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.common.GooglePlayServicesUtil;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        /* Button sendDirButton = (Button)
         * findViewById(R.id.sendDirectionsRequestButton); final MainActivity
         * this_ = this; sendDirButton.setOnClickListener(new OnClickListener()
         * {
         * 
         * @Override public void onClick(View v) { String origin = ((TextView)
         * findViewById(R.id.fromDirectionTextView)).getText().toString();
         * String destination = ((TextView)
         * findViewById(R.id.toDirectionTextView)).getText().toString(); try {
         * Here2ThereApplication.get().getApi().getDirections(this_, origin,
         * destination, this_, this_); } catch (UnsupportedEncodingException e)
         * { // TODO Auto-generated catch block e.printStackTrace(); } } }); */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
