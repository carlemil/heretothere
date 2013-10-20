package se.kjellstrand.here2there;

import java.io.UnsupportedEncodingException;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;

/**
 * Created by erbsman on 19/10/13.
 */
public class Here2ThereApi {

    private final RequestQueue mQueue;

    public Here2ThereApi(RequestQueue queue) {
        mQueue = queue;
    }

    @SuppressWarnings("unchecked")
    public Request<Directions> getDirections(Activity activity, String origin, String destination,
            Listener<Directions> listener, Response.ErrorListener errorListener) throws UnsupportedEncodingException {
        return mQueue.add(new DirectionsRequest(activity, origin, destination, listener, errorListener));
    }

}
