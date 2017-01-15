package planyourtrip.com.planyourtrip.Network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

/**
 * Created by "nithesh" on 1/14/2017.
 */

public class GsonRequest<T> extends Request<T> {
    private Gson gson = new GsonBuilder().create();
    private Class<T> mClass;
    private Response.Listener listener;
    JsonSyntaxException exc;
    public GsonRequest(int method, Class<T> mClass, String url, Response.ErrorListener errorListener, Response.Listener listener) {
        super(method, url, errorListener);
        this.mClass = mClass;
        this.listener = listener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(json, mClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            exc = e;
            return Response.error(new ParseError(exc));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse((T)response);
    }
}
