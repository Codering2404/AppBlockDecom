package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class JsonRequest<T> extends Request<T> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f57830u = String.format("application/json; charset=%s", "utf-8");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f57831r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Response.Listener f57832s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f57833t;

    public JsonRequest(int i3, String str, String str2, Response.Listener listener, Response.ErrorListener errorListener) {
        super(i3, str, errorListener);
        this.f57831r = new Object();
        this.f57832s = listener;
        this.f57833t = str2;
    }

    @Override // com.android.volley.Request
    public void c() {
        super.c();
        synchronized (this.f57831r) {
            this.f57832s = null;
        }
    }

    @Override // com.android.volley.Request
    protected void f(Object obj) {
        Response.Listener listener;
        synchronized (this.f57831r) {
            listener = this.f57832s;
        }
        if (listener != null) {
            listener.b(obj);
        }
    }

    @Override // com.android.volley.Request
    public byte[] j() {
        try {
            String str = this.f57833t;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            VolleyLog.f("Unsupported Encoding while trying to get the bytes of %s using %s", this.f57833t, "utf-8");
            return null;
        }
    }

    @Override // com.android.volley.Request
    public String k() {
        return f57830u;
    }

    @Override // com.android.volley.Request
    public byte[] r() {
        return j();
    }

    @Override // com.android.volley.Request
    public String s() {
        return k();
    }
}
