package se.kjellstrand.here2there.net;

import java.io.UnsupportedEncodingException;

import se.kjellstrand.here2there.data.DirectionsData;
import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;

/**
 * Created by erbsman on 19/10/13.
 */
public class Here2ThereApi {

    private static final String LOG_TAG = Here2ThereApi.class.getCanonicalName();
    private final RequestQueue mQueue;

    public Here2ThereApi(RequestQueue queue) {
        mQueue = queue;
    }

    @SuppressWarnings("unchecked")
    public Request<DirectionsData> getDirections(Activity activity, String origin, String destination,
            Listener<DirectionsData> listener, Response.ErrorListener errorListener)
            throws UnsupportedEncodingException {
        Log.d(LOG_TAG, "Sending out request for directions from '" + origin + "' to '" + destination + "'.");
        return mQueue.add(new DirectionsRequest(activity, origin, destination, listener, errorListener));
    }

}
