package com.iab.omid.library.applovin.internal;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f92152b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f92153a;

    private g() {
    }

    public static g b() {
        return f92152b;
    }

    public Context a() {
        return this.f92153a;
    }

    public void a(Context context) {
        this.f92153a = context != null ? context.getApplicationContext() : null;
    }
}
