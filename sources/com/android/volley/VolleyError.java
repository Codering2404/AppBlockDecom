package com.android.volley;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class VolleyError extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkResponse f57722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f57723b;

    public VolleyError() {
        this.f57722a = null;
    }

    void a(long j3) {
        this.f57723b = j3;
    }

    public VolleyError(NetworkResponse networkResponse) {
        this.f57722a = networkResponse;
    }

    public VolleyError(String str) {
        super(str);
        this.f57722a = null;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.f57722a = null;
    }
}
