package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class InterpolateOnScrollPositionChangeHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f81760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MaterialShapeDrawable f81761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScrollView f81762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f81763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f81764e;

    /* JADX INFO: renamed from: com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterpolateOnScrollPositionChangeHelper f81765a;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            this.f81765a.a();
        }
    }

    public void a() {
        ScrollView scrollView = this.f81762c;
        if (scrollView == null) {
            return;
        }
        if (scrollView.getChildCount() == 0) {
            throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
        }
        this.f81762c.getLocationInWindow(this.f81763d);
        this.f81762c.getChildAt(0).getLocationInWindow(this.f81764e);
        int top = (this.f81760a.getTop() - this.f81763d[1]) + this.f81764e[1];
        int height = this.f81760a.getHeight();
        int height2 = this.f81762c.getHeight();
        if (top < 0) {
            this.f81761b.b0(Math.max(0.0f, Math.min(1.0f, (top / height) + 1.0f)));
            this.f81760a.invalidate();
            return;
        }
        if (top + height > height2) {
            this.f81761b.b0(Math.max(0.0f, Math.min(1.0f, 1.0f - ((r0 - height2) / height))));
            this.f81760a.invalidate();
        } else if (this.f81761b.y() != 1.0f) {
            this.f81761b.b0(1.0f);
            this.f81760a.invalidate();
        }
    }
}
