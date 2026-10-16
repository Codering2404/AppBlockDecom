package com.google.firebase.crashlytics.internal.network;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f89003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89004b;

    public HttpResponse(int i3, String str) {
        this.f89003a = i3;
        this.f89004b = str;
    }

    public String a() {
        return this.f89004b;
    }

    public int b() {
        return this.f89003a;
    }
}
