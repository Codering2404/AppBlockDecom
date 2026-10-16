package com.google.android.material.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements MaterialBackHandler {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final int f80137j0 = R.style.f79743p;
    private ShapeAppearanceModel A;
    private boolean B;
    private final StateSettlingTracker C;
    private ValueAnimator D;
    int E;
    int F;
    int G;
    float H;
    int I;
    float J;
    boolean K;
    private boolean L;
    private boolean M;
    int N;
    int O;
    ViewDragHelper P;
    private boolean Q;
    private int R;
    private boolean S;
    private float T;
    private int U;
    int V;
    int W;
    WeakReference X;
    WeakReference Y;
    WeakReference Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f80138a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final ArrayList f80139a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f80140b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private VelocityTracker f80141b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f80142c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    MaterialBottomContainerBackHelper f80143c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f80144d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    int f80145d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f80146e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f80147f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    boolean f80148f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f80149g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private Map f80150g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f80151h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    final SparseIntArray f80152h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f80153i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final ViewDragHelper.Callback f80154i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f80155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaterialShapeDrawable f80156k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f80157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f80158m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f80159n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f80160o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f80161p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f80162q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f80163r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f80164s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f80165t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f80166u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f80167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f80168w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f80169x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f80170y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f80171z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StableState {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class StateSettlingTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f80188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f80189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f80190c;

        private StateSettlingTracker() {
            this.f80190c = new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.StateSettlingTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    StateSettlingTracker.this.f80189b = false;
                    ViewDragHelper viewDragHelper = BottomSheetBehavior.this.P;
                    if (viewDragHelper != null && viewDragHelper.n(true)) {
                        StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                        stateSettlingTracker.c(stateSettlingTracker.f80188a);
                        return;
                    }
                    StateSettlingTracker stateSettlingTracker2 = StateSettlingTracker.this;
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.N == 2) {
                        bottomSheetBehavior.Z0(stateSettlingTracker2.f80188a);
                    }
                }
            };
        }

        void c(int i3) {
            WeakReference weakReference = BottomSheetBehavior.this.X;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f80188a = i3;
            if (this.f80189b) {
                return;
            }
            ViewCompat.e0((View) BottomSheetBehavior.this.X.get(), this.f80190c);
            this.f80189b = true;
        }
    }

    public BottomSheetBehavior() {
        this.f80138a = 0;
        this.f80140b = true;
        this.f80142c = false;
        this.f80158m = -1;
        this.f80159n = -1;
        this.C = new StateSettlingTracker();
        this.H = 0.5f;
        this.J = -1.0f;
        this.M = true;
        this.N = 4;
        this.O = 4;
        this.T = 0.1f;
        this.f80139a0 = new ArrayList();
        this.f80146e0 = -1;
        this.f80152h0 = new SparseIntArray();
        this.f80154i0 = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f80179a;

            private boolean n(View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return top > (bottomSheetBehavior.W + bottomSheetBehavior.u0()) / 2;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(View view, int i3, int i4) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(View view, int i3, int i4) {
                return MathUtils.b(i3, BottomSheetBehavior.this.u0(), e(view));
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int e(View view) {
                return BottomSheetBehavior.this.l0() ? BottomSheetBehavior.this.W : BottomSheetBehavior.this.I;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i3) {
                if (i3 == 1 && BottomSheetBehavior.this.M) {
                    BottomSheetBehavior.this.Z0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(View view, int i3, int i4, int i5, int i6) {
                BottomSheetBehavior.this.q0(i4);
            }

            /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
            /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void l(android.view.View r8, float r9, float r10) {
                /*
                    Method dump skipped, instruction units count: 308
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5.l(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(View view, int i3) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i4 = bottomSheetBehavior.N;
                if (i4 == 1 || bottomSheetBehavior.f80148f0) {
                    return false;
                }
                if (i4 == 3 && bottomSheetBehavior.f80145d0 == i3) {
                    WeakReference weakReference = bottomSheetBehavior.Z;
                    View view2 = weakReference != null ? (View) weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                this.f80179a = System.currentTimeMillis();
                WeakReference weakReference2 = BottomSheetBehavior.this.X;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
    }

    private boolean E0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.Q(view);
    }

    private void H0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i3) {
        ViewCompat.i0(view, accessibilityActionCompat, null, n0(i3));
    }

    private void I0() {
        this.f80145d0 = -1;
        this.f80146e0 = -1;
        VelocityTracker velocityTracker = this.f80141b0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f80141b0 = null;
        }
    }

    private void J0(SavedState savedState) {
        int i3 = this.f80138a;
        if (i3 == 0) {
            return;
        }
        if (i3 == -1 || (i3 & 1) == 1) {
            this.f80149g = savedState.f80184d;
        }
        if (i3 == -1 || (i3 & 2) == 2) {
            this.f80140b = savedState.f80185f;
        }
        if (i3 == -1 || (i3 & 4) == 4) {
            this.K = savedState.f80186g;
        }
        if (i3 == -1 || (i3 & 8) == 8) {
            this.L = savedState.f80187h;
        }
    }

    private void K0(View view, Runnable runnable) {
        if (E0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void a1(View view) {
        final boolean z2 = (Build.VERSION.SDK_INT < 29 || B0() || this.f80151h) ? false : true;
        if (this.f80162q || this.f80163r || this.f80164s || this.f80166u || this.f80167v || this.f80168w || z2) {
            ViewUtils.f(view, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
                /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
                @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public androidx.core.view.WindowInsetsCompat a(android.view.View r11, androidx.core.view.WindowInsetsCompat r12, com.google.android.material.internal.ViewUtils.RelativePadding r13) {
                    /*
                        Method dump skipped, instruction units count: 207
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4.a(android.view.View, androidx.core.view.WindowInsetsCompat, com.google.android.material.internal.ViewUtils$RelativePadding):androidx.core.view.WindowInsetsCompat");
                }
            });
        }
    }

    private boolean c1() {
        if (this.P != null) {
            return this.M || this.N == 1;
        }
        return false;
    }

    private int d0(View view, int i3, int i4) {
        return ViewCompat.c(view, view.getResources().getString(i3), n0(i4));
    }

    private void f0() {
        int iJ0 = j0();
        if (this.f80140b) {
            this.I = Math.max(this.W - iJ0, this.F);
        } else {
            this.I = this.W - iJ0;
        }
    }

    private float g0(float f3, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f3 > 0.0f) {
                return radius / f3;
            }
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(View view, int i3, boolean z2) {
        int iW0 = w0(i3);
        ViewDragHelper viewDragHelper = this.P;
        if (viewDragHelper == null || (!z2 ? viewDragHelper.R(view, view.getLeft(), iW0) : viewDragHelper.P(view.getLeft(), iW0))) {
            Z0(i3);
            return;
        }
        Z0(2);
        j1(i3, true);
        this.C.c(i3);
    }

    private void h0() {
        this.G = (int) (this.W * (1.0f - this.H));
    }

    private void h1() {
        WeakReference weakReference = this.X;
        if (weakReference != null) {
            i1((View) weakReference.get(), 0);
        }
        WeakReference weakReference2 = this.Y;
        if (weakReference2 != null) {
            i1((View) weakReference2.get(), 1);
        }
    }

    private float i0() {
        WeakReference weakReference;
        WindowInsets rootWindowInsets;
        if (this.f80156k == null || (weakReference = this.X) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        View view = (View) this.X.get();
        if (!y0() || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(g0(this.f80156k.I(), rootWindowInsets.getRoundedCorner(0)), g0(this.f80156k.J(), rootWindowInsets.getRoundedCorner(1)));
    }

    private void i1(View view, int i3) {
        if (view == null) {
            return;
        }
        m0(view, i3);
        if (!this.f80140b && this.N != 6) {
            this.f80152h0.put(i3, d0(view, R.string.f79697a, 6));
        }
        if (this.K && D0() && this.N != 5) {
            H0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34588y, 5);
        }
        int i4 = this.N;
        if (i4 == 3) {
            H0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34587x, this.f80140b ? 4 : 6);
            return;
        }
        if (i4 == 4) {
            H0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34586w, this.f80140b ? 3 : 6);
        } else {
            if (i4 != 6) {
                return;
            }
            H0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34587x, 4);
            H0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34586w, 3);
        }
    }

    private int j0() {
        int i3;
        return this.f80151h ? Math.min(Math.max(this.f80153i, this.W - ((this.V * 9) / 16)), this.U) + this.f80169x : (this.f80161p || this.f80162q || (i3 = this.f80160o) <= 0) ? this.f80149g + this.f80169x : Math.max(this.f80149g, i3 + this.f80155j);
    }

    private void j1(int i3, boolean z2) {
        boolean zZ0;
        ValueAnimator valueAnimator;
        if (i3 == 2 || this.B == (zZ0 = z0()) || this.f80156k == null) {
            return;
        }
        this.B = zZ0;
        if (!z2 || (valueAnimator = this.D) == null) {
            ValueAnimator valueAnimator2 = this.D;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.D.cancel();
            }
            this.f80156k.b0(this.B ? i0() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.D.reverse();
        } else {
            this.D.setFloatValues(this.f80156k.y(), zZ0 ? i0() : 1.0f);
            this.D.start();
        }
    }

    private float k0(int i3) {
        float f3;
        float fU0;
        int i4 = this.I;
        if (i3 > i4 || i4 == u0()) {
            int i5 = this.I;
            f3 = i5 - i3;
            fU0 = this.W - i5;
        } else {
            int i6 = this.I;
            f3 = i6 - i3;
            fU0 = i6 - u0();
        }
        return f3 / fU0;
    }

    private void k1(boolean z2) {
        Map map;
        WeakReference weakReference = this.X;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z2) {
                if (this.f80150g0 != null) {
                    return;
                } else {
                    this.f80150g0 = new HashMap(childCount);
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (childAt != this.X.get()) {
                    if (z2) {
                        this.f80150g0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f80142c) {
                            ViewCompat.w0(childAt, 4);
                        }
                    } else if (this.f80142c && (map = this.f80150g0) != null && map.containsKey(childAt)) {
                        ViewCompat.w0(childAt, ((Integer) this.f80150g0.get(childAt)).intValue());
                    }
                }
            }
            if (!z2) {
                this.f80150g0 = null;
            } else if (this.f80142c) {
                ((View) this.X.get()).sendAccessibilityEvent(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l0() {
        return C0() && D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(boolean z2) {
        View view;
        if (this.X != null) {
            f0();
            if (this.N != 4 || (view = (View) this.X.get()) == null) {
                return;
            }
            if (z2) {
                c(4);
            } else {
                view.requestLayout();
            }
        }
    }

    private void m0(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewCompat.g0(view, 524288);
        ViewCompat.g0(view, 262144);
        ViewCompat.g0(view, 1048576);
        int i4 = this.f80152h0.get(i3, -1);
        if (i4 != -1) {
            ViewCompat.g0(view, i4);
            this.f80152h0.delete(i3);
        }
    }

    private AccessibilityViewCommand n0(final int i3) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.6
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.c(i3);
                return true;
            }
        };
    }

    private void o0(Context context) {
        if (this.A == null) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.A);
        this.f80156k = materialShapeDrawable;
        materialShapeDrawable.P(context);
        ColorStateList colorStateList = this.f80157l;
        if (colorStateList != null) {
            this.f80156k.a0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
        this.f80156k.setTint(typedValue.data);
    }

    private void p0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i0(), 1.0f);
        this.D = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.f80156k != null) {
                    BottomSheetBehavior.this.f80156k.b0(fFloatValue);
                }
            }
        });
    }

    public static BottomSheetBehavior s0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.LayoutParams) layoutParams).f();
        if (behaviorF instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behaviorF;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private int t0(int i3, int i4, int i5, int i6) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, i4, i6);
        if (i5 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i5), 1073741824);
        }
        if (size != 0) {
            i5 = Math.min(size, i5);
        }
        return View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
    }

    private int w0(int i3) {
        if (i3 == 3) {
            return u0();
        }
        if (i3 == 4) {
            return this.I;
        }
        if (i3 == 5) {
            return this.W;
        }
        if (i3 == 6) {
            return this.G;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i3);
    }

    private float x0() {
        VelocityTracker velocityTracker = this.f80141b0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f80144d);
        return this.f80141b0.getYVelocity(this.f80145d0);
    }

    private boolean y0() {
        WeakReference weakReference = this.X;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.X.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean z0() {
        if (this.N == 3) {
            return this.f80171z || y0();
        }
        return false;
    }

    public boolean A0() {
        return this.f80140b;
    }

    public boolean B0() {
        return this.f80161p;
    }

    public boolean C0() {
        return this.K;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void D(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.D(coordinatorLayout, view, savedState.c());
        J0(savedState);
        int i3 = savedState.f80183c;
        if (i3 == 1 || i3 == 2) {
            this.N = 4;
            this.O = 4;
        } else {
            this.N = i3;
            this.O = i3;
        }
    }

    public boolean D0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable E(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.E(coordinatorLayout, view), this);
    }

    public boolean F0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
        this.R = 0;
        this.S = false;
        return (i3 & 2) != 0;
    }

    public void G0(BottomSheetCallback bottomSheetCallback) {
        this.f80139a0.remove(bottomSheetCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void I(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.u0()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.Z0(r0)
            return
        Lf:
            boolean r3 = r2.F0()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference r3 = r2.Z
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.S
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.R
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.f80140b
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.G
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.K
            if (r3 == 0) goto L49
            float r3 = r2.x0()
            boolean r3 = r2.d1(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.R
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.f80140b
            if (r1 == 0) goto L68
            int r5 = r2.F
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.I
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.G
            if (r3 >= r1) goto L7e
            int r1 = r2.I
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.e1()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.I
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.f80140b
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.G
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.I
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.g1(r4, r0, r3)
            r2.S = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.I(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.N == 1 && actionMasked == 0) {
            return true;
        }
        if (c1()) {
            this.P.G(motionEvent);
        }
        if (actionMasked == 0) {
            I0();
        }
        if (this.f80141b0 == null) {
            this.f80141b0 = VelocityTracker.obtain();
        }
        this.f80141b0.addMovement(motionEvent);
        if (c1() && actionMasked == 2 && !this.Q && Math.abs(this.f80146e0 - motionEvent.getY()) > this.P.A()) {
            this.P.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.Q;
    }

    void L0(View view) {
        WeakReference weakReference;
        if (view != null || (weakReference = this.Y) == null) {
            this.Y = new WeakReference(view);
            i1(view, 1);
        } else {
            m0((View) weakReference.get(), 1);
            this.Y = null;
        }
    }

    public void M0(boolean z2) {
        this.M = z2;
    }

    public void N0(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.E = i3;
        j1(this.N, true);
    }

    public void O0(boolean z2) {
        if (this.f80140b == z2) {
            return;
        }
        this.f80140b = z2;
        if (this.X != null) {
            f0();
        }
        Z0((this.f80140b && this.N == 6) ? 3 : this.N);
        j1(this.N, true);
        h1();
    }

    public void P0(boolean z2) {
        this.f80161p = z2;
    }

    public void Q0(float f3) {
        if (f3 <= 0.0f || f3 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.H = f3;
        if (this.X != null) {
            h0();
        }
    }

    public void R0(boolean z2) {
        if (this.K != z2) {
            this.K = z2;
            if (!z2 && this.N == 5) {
                c(4);
            }
            h1();
        }
    }

    public void S0(int i3) {
        this.f80159n = i3;
    }

    public void T0(int i3) {
        this.f80158m = i3;
    }

    public void U0(int i3) {
        V0(i3, false);
    }

    public final void V0(int i3, boolean z2) {
        if (i3 == -1) {
            if (this.f80151h) {
                return;
            } else {
                this.f80151h = true;
            }
        } else {
            if (!this.f80151h && this.f80149g == i3) {
                return;
            }
            this.f80151h = false;
            this.f80149g = Math.max(0, i3);
        }
        l1(z2);
    }

    public void W0(int i3) {
        this.f80138a = i3;
    }

    public void X0(int i3) {
        this.f80147f = i3;
    }

    public void Y0(boolean z2) {
        this.L = z2;
    }

    void Z0(int i3) {
        View view;
        if (this.N == i3) {
            return;
        }
        this.N = i3;
        if (i3 == 4 || i3 == 3 || i3 == 6 || (this.K && i3 == 5)) {
            this.O = i3;
        }
        WeakReference weakReference = this.X;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i3 == 3) {
            k1(true);
        } else if (i3 == 6 || i3 == 5 || i3 == 4) {
            k1(false);
        }
        j1(i3, true);
        for (int i4 = 0; i4 < this.f80139a0.size(); i4++) {
            ((BottomSheetCallback) this.f80139a0.get(i4)).onStateChanged(view, i3);
        }
        h1();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void a() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.f80143c0;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        materialBottomContainerBackHelper.f();
    }

    public boolean b1(long j3, float f3) {
        return false;
    }

    public void c(int i3) {
        if (i3 == 1 || i3 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i3 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.K && i3 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i3);
            return;
        }
        final int i4 = (i3 == 6 && this.f80140b && w0(i3) <= this.F) ? 3 : i3;
        WeakReference weakReference = this.X;
        if (weakReference == null || weakReference.get() == null) {
            Z0(i3);
        } else {
            final View view = (View) this.X.get();
            K0(view, new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.g1(view, i4, false);
                }
            });
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void d(BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.f80143c0;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        materialBottomContainerBackHelper.j(backEventCompat);
    }

    boolean d1(View view, float f3) {
        if (this.L) {
            return true;
        }
        if (D0() && view.getTop() >= this.I) {
            return Math.abs((((float) view.getTop()) + (f3 * this.T)) - ((float) this.I)) / ((float) j0()) > 0.5f;
        }
        return false;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void e(BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.f80143c0;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        materialBottomContainerBackHelper.l(backEventCompat);
    }

    public void e0(BottomSheetCallback bottomSheetCallback) {
        if (this.f80139a0.contains(bottomSheetCallback)) {
            return;
        }
        this.f80139a0.add(bottomSheetCallback);
    }

    public boolean e1() {
        return false;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void f() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.f80143c0;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        BackEventCompat backEventCompatC = materialBottomContainerBackHelper.c();
        if (backEventCompatC == null || Build.VERSION.SDK_INT < 34) {
            c(this.K ? 5 : 4);
        } else if (this.K) {
            this.f80143c0.h(backEventCompatC, new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BottomSheetBehavior.this.Z0(5);
                    WeakReference weakReference = BottomSheetBehavior.this.X;
                    if (weakReference == null || weakReference.get() == null) {
                        return;
                    }
                    ((View) BottomSheetBehavior.this.X.get()).requestLayout();
                }
            });
        } else {
            this.f80143c0.i(backEventCompatC, null);
            c(4);
        }
    }

    public boolean f1() {
        return true;
    }

    public int getState() {
        return this.N;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void m(CoordinatorLayout.LayoutParams layoutParams) {
        super.m(layoutParams);
        this.X = null;
        this.P = null;
        this.f80143c0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void p() {
        super.p();
        this.X = null;
        this.P = null;
        this.f80143c0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i3;
        ViewDragHelper viewDragHelper;
        if (!view.isShown() || !this.M) {
            this.Q = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            I0();
        }
        if (this.f80141b0 == null) {
            this.f80141b0 = VelocityTracker.obtain();
        }
        this.f80141b0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.f80146e0 = (int) motionEvent.getY();
            if (this.N != 2) {
                WeakReference weakReference = this.Z;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.F(view2, x2, this.f80146e0)) {
                    this.f80145d0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f80148f0 = true;
                }
            }
            this.Q = this.f80145d0 == -1 && !coordinatorLayout.F(view, x2, this.f80146e0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f80148f0 = false;
            this.f80145d0 = -1;
            if (this.Q) {
                this.Q = false;
                return false;
            }
        }
        if (!this.Q && (viewDragHelper = this.P) != null && viewDragHelper.Q(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.Z;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.Q || this.N == 1 || coordinatorLayout.F(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.P == null || (i3 = this.f80146e0) == -1 || Math.abs(((float) i3) - motionEvent.getY()) <= ((float) this.P.A())) ? false : true;
    }

    void q0(int i3) {
        View view = (View) this.X.get();
        if (view == null || this.f80139a0.isEmpty()) {
            return;
        }
        float fK0 = k0(i3);
        for (int i4 = 0; i4 < this.f80139a0.size(); i4++) {
            ((BottomSheetCallback) this.f80139a0.get(i4)).onSlide(view, fK0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i3) {
        if (ViewCompat.v(coordinatorLayout) && !ViewCompat.v(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.X == null) {
            this.f80153i = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.f79560d);
            a1(view);
            ViewCompat.K0(view, new InsetsAnimationCallback(view));
            this.X = new WeakReference(view);
            this.f80143c0 = new MaterialBottomContainerBackHelper(view);
            MaterialShapeDrawable materialShapeDrawable = this.f80156k;
            if (materialShapeDrawable != null) {
                ViewCompat.q0(view, materialShapeDrawable);
                MaterialShapeDrawable materialShapeDrawable2 = this.f80156k;
                float fT = this.J;
                if (fT == -1.0f) {
                    fT = ViewCompat.t(view);
                }
                materialShapeDrawable2.Z(fT);
            } else {
                ColorStateList colorStateList = this.f80157l;
                if (colorStateList != null) {
                    ViewCompat.r0(view, colorStateList);
                }
            }
            h1();
            if (ViewCompat.w(view) == 0) {
                ViewCompat.w0(view, 1);
            }
        }
        if (this.P == null) {
            this.P = ViewDragHelper.p(coordinatorLayout, this.f80154i0);
        }
        int top = view.getTop();
        coordinatorLayout.M(view, i3);
        this.V = coordinatorLayout.getWidth();
        this.W = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.U = height;
        int iMin = this.W;
        int i4 = iMin - height;
        int i5 = this.f80170y;
        if (i4 < i5) {
            if (this.f80165t) {
                int i6 = this.f80159n;
                if (i6 != -1) {
                    iMin = Math.min(iMin, i6);
                }
                this.U = iMin;
            } else {
                int iMin2 = iMin - i5;
                int i7 = this.f80159n;
                if (i7 != -1) {
                    iMin2 = Math.min(iMin2, i7);
                }
                this.U = iMin2;
            }
        }
        this.F = Math.max(0, this.W - this.U);
        h0();
        f0();
        int i8 = this.N;
        if (i8 == 3) {
            ViewCompat.X(view, u0());
        } else if (i8 == 6) {
            ViewCompat.X(view, this.G);
        } else if (this.K && i8 == 5) {
            ViewCompat.X(view, this.W);
        } else if (i8 == 4) {
            ViewCompat.X(view, this.I);
        } else if (i8 == 1 || i8 == 2) {
            ViewCompat.X(view, top - view.getTop());
        }
        j1(this.N, false);
        this.Z = new WeakReference(r0(view));
        for (int i9 = 0; i9 < this.f80139a0.size(); i9++) {
            ((BottomSheetCallback) this.f80139a0.get(i9)).onLayout(view);
        }
        return true;
    }

    View r0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.S(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View viewR0 = r0(viewGroup.getChildAt(i3));
                if (viewR0 != null) {
                    return viewR0;
                }
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(t0(i3, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, this.f80158m, marginLayoutParams.width), t0(i5, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, this.f80159n, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean u(CoordinatorLayout coordinatorLayout, View view, View view2, float f3, float f4) {
        WeakReference weakReference;
        return F0() && (weakReference = this.Z) != null && view2 == weakReference.get() && (this.N != 3 || super.u(coordinatorLayout, view, view2, f3, f4));
    }

    public int u0() {
        if (this.f80140b) {
            return this.F;
        }
        return Math.max(this.E, this.f80165t ? 0 : this.f80170y);
    }

    MaterialShapeDrawable v0() {
        return this.f80156k;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void w(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 1) {
            return;
        }
        WeakReference weakReference = this.Z;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (!F0() || view2 == view3) {
            int top = view.getTop();
            int i6 = top - i4;
            if (i4 > 0) {
                if (i6 < u0()) {
                    int iU0 = top - u0();
                    iArr[1] = iU0;
                    ViewCompat.X(view, -iU0);
                    Z0(3);
                } else {
                    if (!this.M) {
                        return;
                    }
                    iArr[1] = i4;
                    ViewCompat.X(view, -i4);
                    Z0(1);
                }
            } else if (i4 < 0 && !view2.canScrollVertically(-1)) {
                if (i6 > this.I && !l0()) {
                    int i7 = top - this.I;
                    iArr[1] = i7;
                    ViewCompat.X(view, -i7);
                    Z0(4);
                } else {
                    if (!this.M) {
                        return;
                    }
                    iArr[1] = i4;
                    ViewCompat.X(view, -i4);
                    Z0(1);
                }
            }
            q0(view.getTop());
            this.R = i4;
            this.S = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f80183c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f80184d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f80185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f80186g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f80187h;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f80183c = parcel.readInt();
            this.f80184d = parcel.readInt();
            this.f80185f = parcel.readInt() == 1;
            this.f80186g = parcel.readInt() == 1;
            this.f80187h = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f80183c);
            parcel.writeInt(this.f80184d);
            parcel.writeInt(this.f80185f ? 1 : 0);
            parcel.writeInt(this.f80186g ? 1 : 0);
            parcel.writeInt(this.f80187h ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f80183c = bottomSheetBehavior.N;
            this.f80184d = bottomSheetBehavior.f80149g;
            this.f80185f = bottomSheetBehavior.f80140b;
            this.f80186g = bottomSheetBehavior.K;
            this.f80187h = bottomSheetBehavior.L;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i3;
        super(context, attributeSet);
        this.f80138a = 0;
        this.f80140b = true;
        this.f80142c = false;
        this.f80158m = -1;
        this.f80159n = -1;
        this.C = new StateSettlingTracker();
        this.H = 0.5f;
        this.J = -1.0f;
        this.M = true;
        this.N = 4;
        this.O = 4;
        this.T = 0.1f;
        this.f80139a0 = new ArrayList();
        this.f80146e0 = -1;
        this.f80152h0 = new SparseIntArray();
        this.f80154i0 = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f80179a;

            private boolean n(View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return top > (bottomSheetBehavior.W + bottomSheetBehavior.u0()) / 2;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(View view, int i32, int i4) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(View view, int i32, int i4) {
                return MathUtils.b(i32, BottomSheetBehavior.this.u0(), e(view));
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int e(View view) {
                return BottomSheetBehavior.this.l0() ? BottomSheetBehavior.this.W : BottomSheetBehavior.this.I;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i32) {
                if (i32 == 1 && BottomSheetBehavior.this.M) {
                    BottomSheetBehavior.this.Z0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(View view, int i32, int i4, int i5, int i6) {
                BottomSheetBehavior.this.q0(i4);
            }

            /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
            /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void l(android.view.View r8, float r9, float r10) {
                /*
                    Method dump skipped, instruction units count: 308
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5.l(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(View view, int i32) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i4 = bottomSheetBehavior.N;
                if (i4 == 1 || bottomSheetBehavior.f80148f0) {
                    return false;
                }
                if (i4 == 3 && bottomSheetBehavior.f80145d0 == i32) {
                    WeakReference weakReference = bottomSheetBehavior.Z;
                    View view2 = weakReference != null ? (View) weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                this.f80179a = System.currentTimeMillis();
                WeakReference weakReference2 = BottomSheetBehavior.this.X;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
        this.f80155j = context.getResources().getDimensionPixelSize(R.dimen.A0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f79829t0);
        int i4 = R.styleable.f79841x0;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.f80157l = MaterialResources.a(context, typedArrayObtainStyledAttributes, i4);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.P0)) {
            this.A = ShapeAppearanceModel.e(context, attributeSet, R.attr.f79486f, f80137j0).m();
        }
        o0(context);
        p0();
        this.J = typedArrayObtainStyledAttributes.getDimension(R.styleable.f79838w0, -1.0f);
        int i5 = R.styleable.f79832u0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            T0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i5, -1));
        }
        int i6 = R.styleable.f79835v0;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            S0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        int i7 = R.styleable.D0;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i7);
        if (typedValuePeekValue != null && (i3 = typedValuePeekValue.data) == -1) {
            U0(i3);
        } else {
            U0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i7, -1));
        }
        R0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.C0, false));
        P0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.H0, false));
        O0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.A0, true));
        Y0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.G0, false));
        M0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.f79844y0, true));
        W0(typedArrayObtainStyledAttributes.getInt(R.styleable.E0, 0));
        Q0(typedArrayObtainStyledAttributes.getFloat(R.styleable.B0, 0.5f));
        int i8 = R.styleable.f79847z0;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i8);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            N0(typedValuePeekValue2.data);
        } else {
            N0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i8, 0));
        }
        X0(typedArrayObtainStyledAttributes.getInt(R.styleable.F0, 500));
        this.f80162q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.L0, false);
        this.f80163r = typedArrayObtainStyledAttributes.getBoolean(R.styleable.M0, false);
        this.f80164s = typedArrayObtainStyledAttributes.getBoolean(R.styleable.N0, false);
        this.f80165t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.O0, true);
        this.f80166u = typedArrayObtainStyledAttributes.getBoolean(R.styleable.I0, false);
        this.f80167v = typedArrayObtainStyledAttributes.getBoolean(R.styleable.J0, false);
        this.f80168w = typedArrayObtainStyledAttributes.getBoolean(R.styleable.K0, false);
        this.f80171z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Q0, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f80144d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f3);

        public abstract void onStateChanged(View view, int i3);

        void onLayout(View view) {
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
    }
}
