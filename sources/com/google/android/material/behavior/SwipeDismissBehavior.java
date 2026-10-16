package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewDragHelper f80061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    OnDismissListener f80062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f80063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f80064d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f80066g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f80065f = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f80067h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f80068i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f80069j = 0.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f80070k = 0.5f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ViewDragHelper.Callback f80071l = new ViewDragHelper.Callback() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f80072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f80073b = -1;

        private boolean n(View view, float f3) {
            if (f3 == 0.0f) {
                return Math.abs(view.getLeft() - this.f80072a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f80068i);
            }
            boolean z2 = ViewCompat.y(view) == 1;
            int i3 = SwipeDismissBehavior.this.f80067h;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0) {
                return z2 ? f3 < 0.0f : f3 > 0.0f;
            }
            if (i3 == 1) {
                if (z2) {
                    return f3 > 0.0f;
                }
                if (f3 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int a(View view, int i3, int i4) {
            int width;
            int width2;
            int width3;
            boolean z2 = ViewCompat.y(view) == 1;
            int i5 = SwipeDismissBehavior.this.f80067h;
            if (i5 == 0) {
                if (z2) {
                    width = this.f80072a - view.getWidth();
                    width2 = this.f80072a;
                } else {
                    width = this.f80072a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i5 != 1) {
                width = this.f80072a - view.getWidth();
                width2 = view.getWidth() + this.f80072a;
            } else if (z2) {
                width = this.f80072a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f80072a - view.getWidth();
                width2 = this.f80072a;
            }
            return SwipeDismissBehavior.N(width, i3, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int b(View view, int i3, int i4) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int d(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void i(View view, int i3) {
            this.f80073b = i3;
            this.f80072a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f80064d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f80064d = false;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void j(int i3) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.f80062b;
            if (onDismissListener != null) {
                onDismissListener.b(i3);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void k(View view, int i3, int i4, int i5, int i6) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f80069j;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f80070k;
            float fAbs = Math.abs(i3 - this.f80072a);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.M(0.0f, 1.0f - SwipeDismissBehavior.P(width, width2, fAbs), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void l(android.view.View r3, float r4, float r5) {
            /*
                r2 = this;
                r5 = -1
                r2.f80073b = r5
                int r5 = r3.getWidth()
                boolean r0 = r2.n(r3, r4)
                if (r0 == 0) goto L23
                r0 = 0
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 < 0) goto L1d
                int r4 = r3.getLeft()
                int r0 = r2.f80072a
                if (r4 >= r0) goto L1b
                goto L1d
            L1b:
                int r0 = r0 + r5
                goto L21
            L1d:
                int r4 = r2.f80072a
                int r0 = r4 - r5
            L21:
                r4 = 1
                goto L26
            L23:
                int r0 = r2.f80072a
                r4 = 0
            L26:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                androidx.customview.widget.ViewDragHelper r5 = r5.f80061a
                int r1 = r3.getTop()
                boolean r5 = r5.P(r0, r1)
                if (r5 == 0) goto L3f
                com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable r5 = new com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable
                com.google.android.material.behavior.SwipeDismissBehavior r0 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r5.<init>(r3, r4)
                androidx.core.view.ViewCompat.e0(r3, r5)
                return
            L3f:
                if (r4 == 0) goto L4a
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener r4 = r4.f80062b
                if (r4 == 0) goto L4a
                r4.a(r3)
            L4a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.l(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean m(View view, int i3) {
            int i4 = this.f80073b;
            return (i4 == -1 || i4 == i3) && SwipeDismissBehavior.this.L(view);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnDismissListener {
        void a(View view);

        void b(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class SettleRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f80076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f80077b;

        SettleRunnable(View view, boolean z2) {
            this.f80076a = view;
            this.f80077b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f80061a;
            if (viewDragHelper != null && viewDragHelper.n(true)) {
                ViewCompat.e0(this.f80076a, this);
            } else {
                if (!this.f80077b || (onDismissListener = SwipeDismissBehavior.this.f80062b) == null) {
                    return;
                }
                onDismissListener.a(this.f80076a);
            }
        }
    }

    static float M(float f3, float f4, float f5) {
        return Math.min(Math.max(f3, f4), f5);
    }

    static int N(int i3, int i4, int i5) {
        return Math.min(Math.max(i3, i4), i5);
    }

    private void O(ViewGroup viewGroup) {
        if (this.f80061a == null) {
            this.f80061a = this.f80066g ? ViewDragHelper.o(viewGroup, this.f80065f, this.f80071l) : ViewDragHelper.p(viewGroup, this.f80071l);
        }
    }

    static float P(float f3, float f4, float f5) {
        return (f5 - f3) / (f4 - f3);
    }

    private void U(View view) {
        ViewCompat.g0(view, 1048576);
        if (L(view)) {
            ViewCompat.i0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34588y, null, new AccessibilityViewCommand() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean a(View view2, AccessibilityViewCommand.CommandArguments commandArguments) {
                    if (!SwipeDismissBehavior.this.L(view2)) {
                        return false;
                    }
                    boolean z2 = ViewCompat.y(view2) == 1;
                    int i3 = SwipeDismissBehavior.this.f80067h;
                    ViewCompat.W(view2, (!(i3 == 0 && z2) && (i3 != 1 || z2)) ? view2.getWidth() : -view2.getWidth());
                    view2.setAlpha(0.0f);
                    OnDismissListener onDismissListener = SwipeDismissBehavior.this.f80062b;
                    if (onDismissListener != null) {
                        onDismissListener.a(view2);
                    }
                    return true;
                }
            });
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f80061a == null) {
            return false;
        }
        if (this.f80064d && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f80061a.G(motionEvent);
        return true;
    }

    public boolean L(View view) {
        return true;
    }

    public void Q(float f3) {
        this.f80070k = M(0.0f, f3, 1.0f);
    }

    public void R(OnDismissListener onDismissListener) {
        this.f80062b = onDismissListener;
    }

    public void S(float f3) {
        this.f80069j = M(0.0f, f3, 1.0f);
    }

    public void T(int i3) {
        this.f80067h = i3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zF = this.f80063c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zF = coordinatorLayout.F(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f80063c = zF;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f80063c = false;
        }
        if (zF) {
            O(coordinatorLayout);
            if (!this.f80064d && this.f80061a.Q(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i3) {
        boolean zR = super.r(coordinatorLayout, view, i3);
        if (ViewCompat.w(view) == 0) {
            ViewCompat.w0(view, 1);
            U(view);
        }
        return zR;
    }
}
