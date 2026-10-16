package com.applovin.impl;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f59052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f59053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f59054c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final AtomicBoolean f59056e = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f59055d = com.applovin.impl.sdk.j.m();

    public d1(String str, com.applovin.impl.sdk.j jVar) {
        this.f59053b = str;
        this.f59052a = jVar;
        this.f59054c = jVar.I();
    }

    public Context a() {
        return this.f59055d;
    }

    public void a(boolean z2) {
        this.f59056e.set(z2);
    }
}
