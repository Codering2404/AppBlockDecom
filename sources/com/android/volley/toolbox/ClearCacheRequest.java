package com.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ClearCacheRequest extends Request<Object> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Cache f57773r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f57774s;

    @Override // com.android.volley.Request
    public boolean B() {
        this.f57773r.clear();
        if (this.f57774s == null) {
            return true;
        }
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.f57774s);
        return true;
    }

    @Override // com.android.volley.Request
    protected Response G(NetworkResponse networkResponse) {
        return null;
    }

    @Override // com.android.volley.Request
    public Request.Priority v() {
        return Request.Priority.IMMEDIATE;
    }

    @Override // com.android.volley.Request
    protected void f(Object obj) {
    }
}
