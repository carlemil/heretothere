package se.kjellstrand.here2there;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by erbsman on 19/10/13.
 * 
 * 
 * 
 * 1. Karta med 'min location', liten klocka för att ändra tiden för sökningen?
 * 2. help text? "where do you want to go?" / start/fav button för list på
 * tidigare fav sökningar 3. karta med klickbar rutter, click för 4 4. list av
 * instruktioner på rutten
 * 
 * http://maps.googleapis.com/maps/api/directions/json?origin=Toronto&
 * destination=Montreal&sensor=false&mode=walking
 * http://maps.googleapis.com/maps
 * /api/geocode/json?latlng=53.244921,-2.479539&sensor=true
 * 
 * https://developers.google.com/maps/documentation/directions/?hl=sv&csw=1
 * https://developers.google.com/maps/documentation/android/
 * 
 * http://stackoverflow.com/questions/2964982/android-get-and-parse-google-
 * directions
 * 
 * 
 */
public class Here2ThereApplication extends Application {

    private static final String TAG = Here2ThereApplication.class.getCanonicalName();

    private static Here2ThereApplication sInstance;

    private Here2ThereApi mApi;

    private RequestQueue mRequestQueue;

    public static Here2ThereApplication get() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        mRequestQueue = Volley.newRequestQueue(this);
    }

    public Here2ThereApi getApi() {
        if (mApi == null) {
            mApi = new Here2ThereApi(mRequestQueue);
        }
        return mApi;
    }

}
