package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StringRequest extends Request<String> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f57854r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Response.Listener f57855s;

    @Override // com.android.volley.Request
    protected Response G(NetworkResponse networkResponse) {
        String str;
        try {
            str = new String(networkResponse.f57677b, HttpHeaderParser.f(networkResponse.f57678c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.f57677b);
        }
        return Response.c(str, HttpHeaderParser.e(networkResponse));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public void f(String str) {
        Response.Listener listener;
        synchronized (this.f57854r) {
            listener = this.f57855s;
        }
        if (listener != null) {
            listener.b(str);
        }
    }

    @Override // com.android.volley.Request
    public void c() {
        super.c();
        synchronized (this.f57854r) {
            this.f57855s = null;
        }
    }
}
