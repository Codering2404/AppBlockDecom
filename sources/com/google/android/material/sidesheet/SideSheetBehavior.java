package com.google.android.material.sidesheet;

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
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements Sheet<SideSheetCallback> {
    private static final int A = R.string.f79706e0;
    private static final int B = R.style.A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SheetDelegate f81930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f81931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MaterialShapeDrawable f81932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorStateList f81933d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ShapeAppearanceModel f81934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StateSettlingTracker f81935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f81936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f81937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f81938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f81939k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ViewDragHelper f81940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f81941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f81942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f81943o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f81944p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f81945q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f81946r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private WeakReference f81947s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private WeakReference f81948t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f81949u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private VelocityTracker f81950v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private MaterialSideContainerBackHelper f81951w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f81952x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Set f81953y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final ViewDragHelper.Callback f81954z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class StateSettlingTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f81958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f81959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f81960c = new Runnable() { // from class: com.google.android.material.sidesheet.e
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.StateSettlingTracker.a(this.f81974a);
            }
        };

        StateSettlingTracker() {
        }

        public static /* synthetic */ void a(StateSettlingTracker stateSettlingTracker) {
            stateSettlingTracker.f81959b = false;
            if (SideSheetBehavior.this.f81940l != null && SideSheetBehavior.this.f81940l.n(true)) {
                stateSettlingTracker.b(stateSettlingTracker.f81958a);
            } else if (SideSheetBehavior.this.f81938j == 2) {
                SideSheetBehavior.this.J0(stateSettlingTracker.f81958a);
            }
        }

        void b(int i3) {
            if (SideSheetBehavior.this.f81947s == null || SideSheetBehavior.this.f81947s.get() == null) {
                return;
            }
            this.f81958a = i3;
            if (this.f81959b) {
                return;
            }
            ViewCompat.e0((View) SideSheetBehavior.this.f81947s.get(), this.f81960c);
            this.f81959b = true;
        }
    }

    public SideSheetBehavior() {
        this.f81935g = new StateSettlingTracker();
        this.f81937i = true;
        this.f81938j = 5;
        this.f81939k = 5;
        this.f81942n = 0.1f;
        this.f81949u = -1;
        this.f81953y = new LinkedHashSet();
        this.f81954z = new ViewDragHelper.Callback() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(View view, int i3, int i4) {
                return MathUtils.b(i3, SideSheetBehavior.this.f81930a.g(), SideSheetBehavior.this.f81930a.f());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(View view, int i3, int i4) {
                return view.getTop();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int d(View view) {
                return SideSheetBehavior.this.f81943o + SideSheetBehavior.this.o0();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i3) {
                if (i3 == 1 && SideSheetBehavior.this.f81937i) {
                    SideSheetBehavior.this.J0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(View view, int i3, int i4, int i5, int i6) {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                View viewJ0 = SideSheetBehavior.this.j0();
                if (viewJ0 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewJ0.getLayoutParams()) != null) {
                    SideSheetBehavior.this.f81930a.p(marginLayoutParams, view.getLeft(), view.getRight());
                    viewJ0.setLayoutParams(marginLayoutParams);
                }
                SideSheetBehavior.this.d0(view, i3);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void l(View view, float f3, float f4) {
                int iZ = SideSheetBehavior.this.Z(view, f3, f4);
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                sideSheetBehavior.O0(view, iZ, sideSheetBehavior.N0());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(View view, int i3) {
                return (SideSheetBehavior.this.f81938j == 1 || SideSheetBehavior.this.f81947s == null || SideSheetBehavior.this.f81947s.get() != view) ? false : true;
            }
        };
    }

    private boolean A0(View view, int i3, boolean z2) {
        int iP0 = p0(i3);
        ViewDragHelper viewDragHelperT0 = t0();
        if (viewDragHelperT0 != null) {
            return z2 ? viewDragHelperT0.P(iP0, view.getTop()) : viewDragHelperT0.R(view, iP0, view.getTop());
        }
        return false;
    }

    private void B0(CoordinatorLayout coordinatorLayout) {
        int i3;
        View viewFindViewById;
        if (this.f81948t != null || (i3 = this.f81949u) == -1 || (viewFindViewById = coordinatorLayout.findViewById(i3)) == null) {
            return;
        }
        this.f81948t = new WeakReference(viewFindViewById);
    }

    private void C0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i3) {
        ViewCompat.i0(view, accessibilityActionCompat, null, b0(i3));
    }

    private void D0() {
        VelocityTracker velocityTracker = this.f81950v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f81950v = null;
        }
    }

    private void E0(View view, Runnable runnable) {
        if (z0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void H0(int i3) {
        SheetDelegate sheetDelegate = this.f81930a;
        if (sheetDelegate == null || sheetDelegate.j() != i3) {
            if (i3 == 0) {
                this.f81930a = new RightSheetDelegate(this);
                if (this.f81934f == null || w0()) {
                    return;
                }
                ShapeAppearanceModel.Builder builderV = this.f81934f.v();
                builderV.H(0.0f).z(0.0f);
                R0(builderV.m());
                return;
            }
            if (i3 == 1) {
                this.f81930a = new LeftSheetDelegate(this);
                if (this.f81934f == null || v0()) {
                    return;
                }
                ShapeAppearanceModel.Builder builderV2 = this.f81934f.v();
                builderV2.D(0.0f).v(0.0f);
                R0(builderV2.m());
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i3 + ". Must be 0 or 1.");
        }
    }

    private void I0(View view, int i3) {
        H0(GravityCompat.b(((CoordinatorLayout.LayoutParams) view.getLayoutParams()).f33465c, i3) == 3 ? 1 : 0);
    }

    public static /* synthetic */ boolean K(SideSheetBehavior sideSheetBehavior, int i3, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        sideSheetBehavior.c(i3);
        return true;
    }

    private boolean K0() {
        if (this.f81940l != null) {
            return this.f81937i || this.f81938j == 1;
        }
        return false;
    }

    public static /* synthetic */ void L(SideSheetBehavior sideSheetBehavior, int i3) {
        View view = (View) sideSheetBehavior.f81947s.get();
        if (view != null) {
            sideSheetBehavior.O0(view, i3, false);
        }
    }

    public static /* synthetic */ void M(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i3, View view, ValueAnimator valueAnimator) {
        sideSheetBehavior.f81930a.o(marginLayoutParams, AnimationUtils.c(i3, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    private boolean M0(View view) {
        return (view.isShown() || ViewCompat.n(view) != null) && this.f81937i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(View view, int i3, boolean z2) {
        if (!A0(view, i3, z2)) {
            J0(i3);
        } else {
            J0(2);
            this.f81935g.b(i3);
        }
    }

    private void P0() {
        View view;
        WeakReference weakReference = this.f81947s;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.g0(view, 262144);
        ViewCompat.g0(view, 1048576);
        if (this.f81938j != 5) {
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34588y, 5);
        }
        if (this.f81938j != 3) {
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34586w, 3);
        }
    }

    private void Q0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference weakReference = this.f81947s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.f81947s.get();
        View viewJ0 = j0();
        if (viewJ0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewJ0.getLayoutParams()) == null) {
            return;
        }
        this.f81930a.o(marginLayoutParams, (int) ((this.f81943o * view.getScaleX()) + this.f81946r));
        viewJ0.requestLayout();
    }

    private void R0(ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = this.f81932c;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    private void S0(View view) {
        int i3 = this.f81938j == 5 ? 4 : 0;
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    private int X(int i3, View view) {
        int i4 = this.f81938j;
        if (i4 == 1 || i4 == 2) {
            return i3 - this.f81930a.h(view);
        }
        if (i4 == 3) {
            return 0;
        }
        if (i4 == 5) {
            return this.f81930a.e();
        }
        throw new IllegalStateException("Unexpected value: " + this.f81938j);
    }

    private float Y(float f3, float f4) {
        return Math.abs(f3 - f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Z(View view, float f3, float f4) {
        if (y0(f3)) {
            return 3;
        }
        if (L0(view, f3)) {
            return (this.f81930a.m(f3, f4) || this.f81930a.l(view)) ? 5 : 3;
        }
        if (f3 != 0.0f && SheetUtils.a(f3, f4)) {
            return 5;
        }
        int left = view.getLeft();
        return Math.abs(left - k0()) < Math.abs(left - this.f81930a.e()) ? 3 : 5;
    }

    private void a0() {
        WeakReference weakReference = this.f81948t;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f81948t = null;
    }

    private AccessibilityViewCommand b0(final int i3) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.c
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                return SideSheetBehavior.K(this.f81968a, i3, view, commandArguments);
            }
        };
    }

    private void c0(Context context) {
        if (this.f81934f == null) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f81934f);
        this.f81932c = materialShapeDrawable;
        materialShapeDrawable.P(context);
        ColorStateList colorStateList = this.f81933d;
        if (colorStateList != null) {
            this.f81932c.a0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
        this.f81932c.setTint(typedValue.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(View view, int i3) {
        if (this.f81953y.isEmpty()) {
            return;
        }
        float fB = this.f81930a.b(i3);
        Iterator it = this.f81953y.iterator();
        while (it.hasNext()) {
            ((SheetCallback) it.next()).b(view, fB);
        }
    }

    private void e0(View view) {
        if (ViewCompat.n(view) == null) {
            ViewCompat.p0(view, view.getResources().getString(A));
        }
    }

    public static SideSheetBehavior f0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.LayoutParams) layoutParams).f();
        if (behaviorF instanceof SideSheetBehavior) {
            return (SideSheetBehavior) behaviorF;
        }
        throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
    }

    private int g0(int i3, int i4, int i5, int i6) {
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

    private ValueAnimator.AnimatorUpdateListener i0() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View viewJ0 = j0();
        if (viewJ0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewJ0.getLayoutParams()) == null) {
            return null;
        }
        final int iC = this.f81930a.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.sidesheet.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SideSheetBehavior.M(this.f81970a, marginLayoutParams, iC, viewJ0, valueAnimator);
            }
        };
    }

    private int l0() {
        SheetDelegate sheetDelegate = this.f81930a;
        return (sheetDelegate == null || sheetDelegate.j() == 0) ? 5 : 3;
    }

    private CoordinatorLayout.LayoutParams u0() {
        View view;
        WeakReference weakReference = this.f81947s;
        if (weakReference == null || (view = (View) weakReference.get()) == null || !(view.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            return null;
        }
        return (CoordinatorLayout.LayoutParams) view.getLayoutParams();
    }

    private boolean v0() {
        CoordinatorLayout.LayoutParams layoutParamsU0 = u0();
        return layoutParamsU0 != null && ((ViewGroup.MarginLayoutParams) layoutParamsU0).leftMargin > 0;
    }

    private boolean w0() {
        CoordinatorLayout.LayoutParams layoutParamsU0 = u0();
        return layoutParamsU0 != null && ((ViewGroup.MarginLayoutParams) layoutParamsU0).rightMargin > 0;
    }

    private boolean x0(MotionEvent motionEvent) {
        return K0() && Y((float) this.f81952x, motionEvent.getX()) > ((float) this.f81940l.A());
    }

    private boolean y0(float f3) {
        return this.f81930a.k(f3);
    }

    private boolean z0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.Q(view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void D(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.c() != null) {
            super.D(coordinatorLayout, view, savedState.c());
        }
        int i3 = savedState.f81957c;
        if (i3 == 1 || i3 == 2) {
            i3 = 5;
        }
        this.f81938j = i3;
        this.f81939k = i3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable E(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.E(coordinatorLayout, view), this);
    }

    public void F0(int i3) {
        this.f81949u = i3;
        a0();
        WeakReference weakReference = this.f81947s;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i3 == -1 || !ViewCompat.R(view)) {
                return;
            }
            view.requestLayout();
        }
    }

    public void G0(boolean z2) {
        this.f81937i = z2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f81938j == 1 && actionMasked == 0) {
            return true;
        }
        if (K0()) {
            this.f81940l.G(motionEvent);
        }
        if (actionMasked == 0) {
            D0();
        }
        if (this.f81950v == null) {
            this.f81950v = VelocityTracker.obtain();
        }
        this.f81950v.addMovement(motionEvent);
        if (K0() && actionMasked == 2 && !this.f81941m && x0(motionEvent)) {
            this.f81940l.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f81941m;
    }

    void J0(int i3) {
        View view;
        if (this.f81938j == i3) {
            return;
        }
        this.f81938j = i3;
        if (i3 == 3 || i3 == 5) {
            this.f81939k = i3;
        }
        WeakReference weakReference = this.f81947s;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        S0(view);
        Iterator it = this.f81953y.iterator();
        while (it.hasNext()) {
            ((SheetCallback) it.next()).a(view, i3);
        }
        P0();
    }

    boolean L0(View view, float f3) {
        return this.f81930a.n(view, f3);
    }

    public boolean N0() {
        return true;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public void b(SideSheetCallback sideSheetCallback) {
        this.f81953y.add(sideSheetCallback);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void a() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.f81951w;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        materialSideContainerBackHelper.f();
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public void c(final int i3) {
        if (i3 == 1 || i3 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i3 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference weakReference = this.f81947s;
        if (weakReference == null || weakReference.get() == null) {
            J0(i3);
        } else {
            E0((View) this.f81947s.get(), new Runnable() { // from class: com.google.android.material.sidesheet.b
                @Override // java.lang.Runnable
                public final void run() {
                    SideSheetBehavior.L(this.f81966a, i3);
                }
            });
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void d(BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.f81951w;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        materialSideContainerBackHelper.j(backEventCompat);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void e(BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.f81951w;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        materialSideContainerBackHelper.l(backEventCompat, l0());
        Q0();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void f() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.f81951w;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        BackEventCompat backEventCompatC = materialSideContainerBackHelper.c();
        if (backEventCompatC == null || Build.VERSION.SDK_INT < 34) {
            c(5);
        } else {
            this.f81951w.h(backEventCompatC, l0(), new AnimatorListenerAdapter() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SideSheetBehavior.this.J0(5);
                    if (SideSheetBehavior.this.f81947s == null || SideSheetBehavior.this.f81947s.get() == null) {
                        return;
                    }
                    ((View) SideSheetBehavior.this.f81947s.get()).requestLayout();
                }
            }, i0());
        }
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public int getState() {
        return this.f81938j;
    }

    int h0() {
        return this.f81943o;
    }

    public View j0() {
        WeakReference weakReference = this.f81948t;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public int k0() {
        return this.f81930a.d();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void m(CoordinatorLayout.LayoutParams layoutParams) {
        super.m(layoutParams);
        this.f81947s = null;
        this.f81940l = null;
        this.f81951w = null;
    }

    public float m0() {
        return this.f81942n;
    }

    float n0() {
        return 0.5f;
    }

    int o0() {
        return this.f81946r;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void p() {
        super.p();
        this.f81947s = null;
        this.f81940l = null;
        this.f81951w = null;
    }

    int p0(int i3) {
        if (i3 == 3) {
            return k0();
        }
        if (i3 == 5) {
            return this.f81930a.e();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!M0(view)) {
            this.f81941m = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            D0();
        }
        if (this.f81950v == null) {
            this.f81950v = VelocityTracker.obtain();
        }
        this.f81950v.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f81952x = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f81941m) {
            this.f81941m = false;
            return false;
        }
        return (this.f81941m || (viewDragHelper = this.f81940l) == null || !viewDragHelper.Q(motionEvent)) ? false : true;
    }

    int q0() {
        return this.f81945q;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i3) {
        if (ViewCompat.v(coordinatorLayout) && !ViewCompat.v(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.f81947s == null) {
            this.f81947s = new WeakReference(view);
            this.f81951w = new MaterialSideContainerBackHelper(view);
            MaterialShapeDrawable materialShapeDrawable = this.f81932c;
            if (materialShapeDrawable != null) {
                ViewCompat.q0(view, materialShapeDrawable);
                MaterialShapeDrawable materialShapeDrawable2 = this.f81932c;
                float fT = this.f81936h;
                if (fT == -1.0f) {
                    fT = ViewCompat.t(view);
                }
                materialShapeDrawable2.Z(fT);
            } else {
                ColorStateList colorStateList = this.f81933d;
                if (colorStateList != null) {
                    ViewCompat.r0(view, colorStateList);
                }
            }
            S0(view);
            P0();
            if (ViewCompat.w(view) == 0) {
                ViewCompat.w0(view, 1);
            }
            e0(view);
        }
        I0(view, i3);
        if (this.f81940l == null) {
            this.f81940l = ViewDragHelper.p(coordinatorLayout, this.f81954z);
        }
        int iH = this.f81930a.h(view);
        coordinatorLayout.M(view, i3);
        this.f81944p = coordinatorLayout.getWidth();
        this.f81945q = this.f81930a.i(coordinatorLayout);
        this.f81943o = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f81946r = marginLayoutParams != null ? this.f81930a.a(marginLayoutParams) : 0;
        ViewCompat.W(view, X(iH, view));
        B0(coordinatorLayout);
        for (SheetCallback sheetCallback : this.f81953y) {
            if (sheetCallback instanceof SideSheetCallback) {
                ((SideSheetCallback) sheetCallback).c(view);
            }
        }
        return true;
    }

    int r0() {
        return this.f81944p;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(g0(i3, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, -1, marginLayoutParams.width), g0(i5, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, -1, marginLayoutParams.height));
        return true;
    }

    int s0() {
        return 500;
    }

    ViewDragHelper t0() {
        return this.f81940l;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.SavedState.1
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
        final int f81957c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f81957c = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f81957c);
        }

        public SavedState(Parcelable parcelable, SideSheetBehavior sideSheetBehavior) {
            super(parcelable);
            this.f81957c = sideSheetBehavior.f81938j;
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f81935g = new StateSettlingTracker();
        this.f81937i = true;
        this.f81938j = 5;
        this.f81939k = 5;
        this.f81942n = 0.1f;
        this.f81949u = -1;
        this.f81953y = new LinkedHashSet();
        this.f81954z = new ViewDragHelper.Callback() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(View view, int i3, int i4) {
                return MathUtils.b(i3, SideSheetBehavior.this.f81930a.g(), SideSheetBehavior.this.f81930a.f());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(View view, int i3, int i4) {
                return view.getTop();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int d(View view) {
                return SideSheetBehavior.this.f81943o + SideSheetBehavior.this.o0();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i3) {
                if (i3 == 1 && SideSheetBehavior.this.f81937i) {
                    SideSheetBehavior.this.J0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(View view, int i3, int i4, int i5, int i6) {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                View viewJ0 = SideSheetBehavior.this.j0();
                if (viewJ0 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewJ0.getLayoutParams()) != null) {
                    SideSheetBehavior.this.f81930a.p(marginLayoutParams, view.getLeft(), view.getRight());
                    viewJ0.setLayoutParams(marginLayoutParams);
                }
                SideSheetBehavior.this.d0(view, i3);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void l(View view, float f3, float f4) {
                int iZ = SideSheetBehavior.this.Z(view, f3, f4);
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                sideSheetBehavior.O0(view, iZ, sideSheetBehavior.N0());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(View view, int i3) {
                return (SideSheetBehavior.this.f81938j == 1 || SideSheetBehavior.this.f81947s == null || SideSheetBehavior.this.f81947s.get() != view) ? false : true;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.N6);
        int i3 = R.styleable.P6;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            this.f81933d = MaterialResources.a(context, typedArrayObtainStyledAttributes, i3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.S6)) {
            this.f81934f = ShapeAppearanceModel.e(context, attributeSet, 0, B).m();
        }
        int i4 = R.styleable.R6;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            F0(typedArrayObtainStyledAttributes.getResourceId(i4, -1));
        }
        c0(context);
        this.f81936h = typedArrayObtainStyledAttributes.getDimension(R.styleable.O6, -1.0f);
        G0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.Q6, true));
        typedArrayObtainStyledAttributes.recycle();
        this.f81931b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
