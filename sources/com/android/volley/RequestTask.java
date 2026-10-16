package com.android.volley;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RequestTask<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Request f57717a;

    public RequestTask(Request request) {
        this.f57717a = request;
    }

    public int a(RequestTask requestTask) {
        return this.f57717a.compareTo(requestTask.f57717a);
    }
}
