package examples.f.dev.thefirstclient.io;

/**
 * Created by Salvador on 13/07/2015.
 */

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton extends Application {

    public static final String TAG = VolleySingleton.class
            .getSimpleName();

    private static VolleySingleton mInstance;

    //Cola de petisiones
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        //porque volley es volleySingleton
    }

    private VolleySingleton(Context context) {
        mCtx = context;
        //obtener la cola de peticiones
        mRequestQueue = getRequestQueue();

    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // es el contexto de toda nuestraaplicacion
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
