package se.kjellstrand.here2there;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;

/**
 * Created by erbsman on 10/19/13.
 */
public class DemoApi {

    private final RequestQueue mQueue;

    public DemoApi(RequestQueue queue) {
        mQueue = queue;
    }

    @SuppressWarnings("unchecked")
    public Request<DemoItem> getDemoItemDetails(String path, Listener<DemoItem> listener,
                             Response.ErrorListener errorListener) {
        return mQueue.add(new DemoItemDetailsRequest(path, listener, errorListener));
    }

}
