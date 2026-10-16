package com.applovin.impl;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class nd extends id {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f62020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f62021d;

    public nd(Throwable th, jd jdVar, Surface surface) {
        super(th, jdVar);
        this.f62020c = System.identityHashCode(surface);
        this.f62021d = surface == null || surface.isValid();
    }
}
