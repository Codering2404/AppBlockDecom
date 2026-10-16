package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ViewOverlayApi14 implements ViewOverlayImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected OverlayViewGroup f81300a;

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void a(Drawable drawable) {
        this.f81300a.a(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void b(Drawable drawable) {
        this.f81300a.e(drawable);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class OverlayViewGroup extends ViewGroup {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static Method f81301f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ViewGroup f81302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        View f81303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ArrayList f81304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f81305d;

        static {
            try {
                Class cls = Integer.TYPE;
                f81301f = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        private void b() {
            if (this.f81305d) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void c() {
            if (getChildCount() == 0) {
                ArrayList arrayList = this.f81304c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f81305d = true;
                    this.f81302a.removeView(this);
                }
            }
        }

        private void d(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f81302a.getLocationOnScreen(iArr2);
            this.f81303b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            b();
            if (this.f81304c == null) {
                this.f81304c = new ArrayList();
            }
            if (this.f81304c.contains(drawable)) {
                return;
            }
            this.f81304c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.f81302a.getLocationOnScreen(new int[2]);
            this.f81303b.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f81303b.getWidth(), this.f81303b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList arrayList = this.f81304c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Drawable) this.f81304c.get(i3)).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void e(Drawable drawable) {
            ArrayList arrayList = this.f81304c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                c();
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f81302a == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f81302a == null) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            d(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            if (super.verifyDrawable(drawable)) {
                return true;
            }
            ArrayList arrayList = this.f81304c;
            return arrayList != null && arrayList.contains(drawable);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        }
    }
}
