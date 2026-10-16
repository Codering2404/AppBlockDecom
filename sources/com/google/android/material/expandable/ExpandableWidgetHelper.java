package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ExpandableWidgetHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f80967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f80968b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f80969c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.f80967a = (View) expandableWidget;
    }

    private void a() {
        ViewParent parent = this.f80967a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).m(this.f80967a);
        }
    }

    public int b() {
        return this.f80969c;
    }

    public boolean c() {
        return this.f80968b;
    }

    public void d(Bundle bundle) {
        this.f80968b = bundle.getBoolean("expanded", false);
        this.f80969c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f80968b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f80968b);
        bundle.putInt("expandedComponentIdHint", this.f80969c);
        return bundle;
    }

    public void f(int i3) {
        this.f80969c = i3;
    }
}
