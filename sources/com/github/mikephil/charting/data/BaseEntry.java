package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f68511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f68512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f68513c;

    public BaseEntry() {
        this.f68511a = 0.0f;
        this.f68512b = null;
        this.f68513c = null;
    }

    public Object c() {
        return this.f68512b;
    }

    public Drawable d() {
        return this.f68513c;
    }

    public float e() {
        return this.f68511a;
    }

    public void f(Object obj) {
        this.f68512b = obj;
    }

    public void g(float f3) {
        this.f68511a = f3;
    }

    public BaseEntry(float f3) {
        this.f68512b = null;
        this.f68513c = null;
        this.f68511a = f3;
    }
}
