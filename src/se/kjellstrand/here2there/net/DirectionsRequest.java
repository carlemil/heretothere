package se.kjellstrand.here2there.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import se.kjellstrand.here2there.R;
import se.kjellstrand.here2there.data.DirectionsData;
import android.app.Activity;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.google.gson.Gson;

/**
 * Created by erbsman on 19/10/13.
 */
public class DirectionsRequest extends Request<DirectionsData> {

    private static final String TAG = DirectionsRequest.class.getCanonicalName();
    private final Response.Listener<DirectionsData> mListener;

    private final Gson mGson = new Gson();

    public DirectionsRequest(Activity activity, String origin, String destination,
            Response.Listener<DirectionsData> listener, Response.ErrorListener errorListener)
            throws UnsupportedEncodingException {
        super(Method.GET, getUrl(activity, origin, destination), errorListener);
        mListener = listener;
    }

    @Override
    protected void deliverResponse(DirectionsData response) {
        mListener.onResponse(response);
    }

    @Override
    protected Response<DirectionsData> parseNetworkResponse(NetworkResponse response) {
        String jsonString = new String(response.data);
        Log.d(TAG, "jsonString: " + jsonString);
        DirectionsData demoResponse = mGson.fromJson(jsonString, DirectionsData.class);
        return Response.success(demoResponse, getCacheEntry());
    }

    private static String getUrl(Activity activity, String origin, String destination)
            throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder();
        url.append(activity.getResources().getString(R.string.api_directions_url));
        url.append("?origin=").append(URLEncoder.encode(origin, "UTF-8"));
        url.append("&destination=").append(URLEncoder.encode(destination, "UTF-8"));
        url.append("&sensor=false");
        url.append("&mode=walking");

        return url.toString();
    }
}
