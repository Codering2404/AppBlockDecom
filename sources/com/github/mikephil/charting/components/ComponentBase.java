package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ComponentBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f68395a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f68396b = 5.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f68397c = 5.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Typeface f68398d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected float f68399e = Utils.e(10.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f68400f = -16777216;

    public int a() {
        return this.f68400f;
    }

    public float b() {
        return this.f68399e;
    }

    public Typeface c() {
        return this.f68398d;
    }

    public float d() {
        return this.f68396b;
    }

    public float e() {
        return this.f68397c;
    }

    public boolean f() {
        return this.f68395a;
    }

    public void g(int i3) {
        this.f68400f = i3;
    }

    public void h(float f3) {
        if (f3 > 24.0f) {
            f3 = 24.0f;
        }
        if (f3 < 6.0f) {
            f3 = 6.0f;
        }
        this.f68399e = Utils.e(f3);
    }

    public void i(Typeface typeface) {
        this.f68398d = typeface;
    }

    public void j(float f3) {
        this.f68396b = Utils.e(f3);
    }

    public void k(float f3) {
        this.f68397c = Utils.e(f3);
    }
}
