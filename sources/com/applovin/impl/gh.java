package com.applovin.impl;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class gh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f59977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f59978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f59979c;

    gh(String str, String str2, Context context) {
        this.f59977a = str.replace("android.permission.", "");
        this.f59978b = str2;
        this.f59979c = z3.a(str, context);
    }

    public String a() {
        return this.f59978b;
    }

    public String b() {
        return this.f59977a;
    }

    public boolean c() {
        return this.f59979c;
    }
}
