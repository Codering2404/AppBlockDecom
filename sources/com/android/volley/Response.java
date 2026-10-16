package com.android.volley;

import com.android.volley.Cache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Response<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f57718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cache.Entry f57719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VolleyError f57720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f57721d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ErrorListener {
        void c(VolleyError volleyError);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener<T> {
        void b(Object obj);
    }

    private Response(Object obj, Cache.Entry entry) {
        this.f57721d = false;
        this.f57718a = obj;
        this.f57719b = entry;
        this.f57720c = null;
    }

    public static Response a(VolleyError volleyError) {
        return new Response(volleyError);
    }

    public static Response c(Object obj, Cache.Entry entry) {
        return new Response(obj, entry);
    }

    public boolean b() {
        return this.f57720c == null;
    }

    private Response(VolleyError volleyError) {
        this.f57721d = false;
        this.f57718a = null;
        this.f57719b = null;
        this.f57720c = volleyError;
    }
}
