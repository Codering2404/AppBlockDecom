package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f79950d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    OverScroller f79951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f79952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f79953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f79954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f79955j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private VelocityTracker f79956k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class FlingRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CoordinatorLayout f79957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f79958b;

        FlingRunnable(CoordinatorLayout coordinatorLayout, View view) {
            this.f79957a = coordinatorLayout;
            this.f79958b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f79958b == null || (overScroller = HeaderBehavior.this.f79951f) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.T(this.f79957a, this.f79958b);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.V(this.f79957a, this.f79958b, headerBehavior.f79951f.getCurrY());
            ViewCompat.e0(this.f79958b, this);
        }
    }

    public HeaderBehavior() {
        this.f79953h = -1;
        this.f79955j = -1;
    }

    private void O() {
        if (this.f79956k == null) {
            this.f79956k = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[ADDED_TO_REGION] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean J(androidx.coordinatorlayout.widget.CoordinatorLayout r10, android.view.View r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            int r1 = r12.getActionMasked()
            r6 = -1
            r7 = 0
            r8 = 1
            if (r1 == r8) goto L4d
            r3 = 2
            if (r1 == r3) goto L2d
            r2 = 3
            if (r1 == r2) goto L71
            r2 = 6
            if (r1 == r2) goto L13
            goto L4b
        L13:
            int r1 = r12.getActionIndex()
            if (r1 != 0) goto L1b
            r1 = r8
            goto L1c
        L1b:
            r1 = r7
        L1c:
            int r2 = r12.getPointerId(r1)
            r9.f79953h = r2
            float r1 = r12.getY(r1)
            r2 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r2
            int r1 = (int) r1
            r9.f79954i = r1
            goto L4b
        L2d:
            int r1 = r9.f79953h
            int r1 = r12.findPointerIndex(r1)
            if (r1 != r6) goto L36
            return r7
        L36:
            float r1 = r12.getY(r1)
            int r1 = (int) r1
            int r3 = r9.f79954i
            int r3 = r3 - r1
            r9.f79954i = r1
            int r4 = r9.Q(r11)
            r5 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.U(r1, r2, r3, r4, r5)
        L4b:
            r1 = r7
            goto L80
        L4d:
            android.view.VelocityTracker r1 = r9.f79956k
            if (r1 == 0) goto L71
            r1.addMovement(r12)
            android.view.VelocityTracker r1 = r9.f79956k
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3)
            android.view.VelocityTracker r1 = r9.f79956k
            int r3 = r9.f79953h
            float r5 = r1.getYVelocity(r3)
            int r1 = r9.R(r11)
            int r3 = -r1
            r4 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.P(r1, r2, r3, r4, r5)
            r1 = r8
            goto L72
        L71:
            r1 = r7
        L72:
            r9.f79952g = r7
            r9.f79953h = r6
            android.view.VelocityTracker r2 = r9.f79956k
            if (r2 == 0) goto L80
            r2.recycle()
            r2 = 0
            r9.f79956k = r2
        L80:
            android.view.VelocityTracker r2 = r9.f79956k
            if (r2 == 0) goto L87
            r2.addMovement(r12)
        L87:
            boolean r2 = r9.f79952g
            if (r2 != 0) goto L8f
            if (r1 == 0) goto L8e
            goto L8f
        L8e:
            return r7
        L8f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.J(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    boolean N(View view) {
        return false;
    }

    final boolean P(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, float f3) {
        Runnable runnable = this.f79950d;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.f79950d = null;
        }
        if (this.f79951f == null) {
            this.f79951f = new OverScroller(view.getContext());
        }
        this.f79951f.fling(0, K(), 0, Math.round(f3), 0, 0, i3, i4);
        if (!this.f79951f.computeScrollOffset()) {
            T(coordinatorLayout, view);
            return false;
        }
        FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, view);
        this.f79950d = flingRunnable;
        ViewCompat.e0(view, flingRunnable);
        return true;
    }

    int Q(View view) {
        return -view.getHeight();
    }

    int R(View view) {
        return view.getHeight();
    }

    int S() {
        return K();
    }

    final int U(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5) {
        return W(coordinatorLayout, view, S() - i3, i4, i5);
    }

    int V(CoordinatorLayout coordinatorLayout, View view, int i3) {
        return W(coordinatorLayout, view, i3, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    int W(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5) {
        int iB;
        int iK = K();
        if (i4 == 0 || iK < i4 || iK > i5 || iK == (iB = MathUtils.b(i3, i4, i5))) {
            return 0;
        }
        M(iB);
        return iK - iB;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f79955j < 0) {
            this.f79955j = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f79952g) {
            int i3 = this.f79953h;
            if (i3 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i3)) == -1) {
                return false;
            }
            int y2 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y2 - this.f79954i) > this.f79955j) {
                this.f79954i = y2;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f79953h = -1;
            int x2 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            boolean z2 = N(view) && coordinatorLayout.F(view, x2, y3);
            this.f79952g = z2;
            if (z2) {
                this.f79954i = y3;
                this.f79953h = motionEvent.getPointerId(0);
                O();
                OverScroller overScroller = this.f79951f;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f79951f.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f79956k;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f79953h = -1;
        this.f79955j = -1;
    }

    void T(CoordinatorLayout coordinatorLayout, View view) {
    }
}
