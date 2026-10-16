package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ViewOffsetHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f79972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f79973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f79974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f79975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f79976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f79977f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f79978g = true;

    public ViewOffsetHelper(View view) {
        this.f79972a = view;
    }

    void a() {
        View view = this.f79972a;
        ViewCompat.X(view, this.f79975d - (view.getTop() - this.f79973b));
        View view2 = this.f79972a;
        ViewCompat.W(view2, this.f79976e - (view2.getLeft() - this.f79974c));
    }

    public int b() {
        return this.f79973b;
    }

    public int c() {
        return this.f79975d;
    }

    void d() {
        this.f79973b = this.f79972a.getTop();
        this.f79974c = this.f79972a.getLeft();
    }

    public boolean e(int i3) {
        if (!this.f79978g || this.f79976e == i3) {
            return false;
        }
        this.f79976e = i3;
        a();
        return true;
    }

    public boolean f(int i3) {
        if (!this.f79977f || this.f79975d == i3) {
            return false;
        }
        this.f79975d = i3;
        a();
        return true;
    }
}
