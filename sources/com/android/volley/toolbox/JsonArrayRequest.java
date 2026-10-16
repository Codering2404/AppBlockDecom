package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JsonArrayRequest extends JsonRequest<JSONArray> {
    @Override // com.android.volley.Request
    protected Response G(NetworkResponse networkResponse) {
        try {
            return Response.c(new JSONArray(new String(networkResponse.f57677b, HttpHeaderParser.g(networkResponse.f57678c, "utf-8"))), HttpHeaderParser.e(networkResponse));
        } catch (UnsupportedEncodingException e3) {
            return Response.a(new ParseError(e3));
        } catch (JSONException e4) {
            return Response.a(new ParseError(e4));
        }
    }
}
