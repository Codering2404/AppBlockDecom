package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class NestedScrollingParentHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f34425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34426b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f34425a | this.f34426b;
    }

    public void b(View view, View view2, int i3) {
        c(view, view2, i3, 0);
    }

    public void c(View view, View view2, int i3, int i4) {
        if (i4 == 1) {
            this.f34426b = i3;
        } else {
            this.f34425a = i3;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i3) {
        if (i3 == 1) {
            this.f34426b = 0;
        } else {
            this.f34425a = 0;
        }
    }
}
