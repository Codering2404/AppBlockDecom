package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int A = R.style.f79742o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f79872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f79873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f79874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f79875d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f79876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f79877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WindowInsetsCompat f79878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f79879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f79880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f79881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f79882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f79883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f79884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private WeakReference f79885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f79886p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator f79887q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f79888r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final List f79889s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final long f79890t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final TimeInterpolator f79891u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int[] f79892v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Drawable f79893w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Integer f79894x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f79895y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Behavior f79896z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f79898l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f79899m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private ValueAnimator f79900n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private SavedState f79901o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private WeakReference f79902p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private BaseDragCallback f79903q;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean a(AppBarLayout appBarLayout);
        }

        public BaseBehavior() {
        }

        private boolean B0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List listW = coordinatorLayout.w(appBarLayout);
            int size = listW.size();
            for (int i3 = 0; i3 < size; i3++) {
                CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.LayoutParams) ((View) listW.get(i3)).getLayoutParams()).f();
                if (behaviorF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behaviorF).Q() != 0;
                }
            }
            return false;
        }

        private void C0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topInset = appBarLayout.getTopInset() + appBarLayout.getPaddingTop();
            int iS = S() - topInset;
            int iK0 = k0(appBarLayout, iS);
            if (iK0 >= 0) {
                View childAt = appBarLayout.getChildAt(iK0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int iC = layoutParams.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int iZ = -childAt.getBottom();
                    if (iK0 == 0 && ViewCompat.v(appBarLayout) && ViewCompat.v(childAt)) {
                        topInset2 -= appBarLayout.getTopInset();
                    }
                    if (g0(iC, 2)) {
                        iZ += ViewCompat.z(childAt);
                    } else if (g0(iC, 5)) {
                        int iZ2 = ViewCompat.z(childAt) + iZ;
                        if (iS < iZ2) {
                            topInset2 = iZ2;
                        } else {
                            iZ = iZ2;
                        }
                    }
                    if (g0(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        iZ -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    b0(coordinatorLayout, appBarLayout, MathUtils.b(d0(iS, iZ, topInset2) + topInset, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void D0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, boolean z2) {
            View viewJ0 = j0(appBarLayout, i3);
            boolean zD = false;
            if (viewJ0 != null) {
                int iC = ((LayoutParams) viewJ0.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int iZ = ViewCompat.z(viewJ0);
                    if (i4 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i3) < (viewJ0.getBottom() - iZ) - appBarLayout.getTopInset()) : (-i3) >= (viewJ0.getBottom() - iZ) - appBarLayout.getTopInset()) {
                        zD = true;
                    }
                }
            }
            if (appBarLayout.q()) {
                zD = appBarLayout.D(i0(coordinatorLayout));
            }
            boolean zA = appBarLayout.A(zD);
            if (z2 || (zA && B0(coordinatorLayout, appBarLayout))) {
                if (appBarLayout.getBackground() != null) {
                    appBarLayout.getBackground().jumpToCurrentState();
                }
                if (appBarLayout.getForeground() != null) {
                    appBarLayout.getForeground().jumpToCurrentState();
                }
                if (appBarLayout.getStateListAnimator() != null) {
                    appBarLayout.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        private void a0(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
            if (ViewCompat.M(coordinatorLayout)) {
                return;
            }
            ViewCompat.m0(coordinatorLayout, new AccessibilityDelegateCompat() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    View viewL0;
                    super.g(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.i0(ScrollView.class.getName());
                    if (appBarLayout.getTotalScrollRange() == 0 || (viewL0 = BaseBehavior.this.l0(coordinatorLayout)) == null || !BaseBehavior.this.h0(appBarLayout)) {
                        return;
                    }
                    if (BaseBehavior.this.S() != (-appBarLayout.getTotalScrollRange())) {
                        accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34580q);
                        accessibilityNodeInfoCompat.K0(true);
                    }
                    if (BaseBehavior.this.S() != 0) {
                        if (!viewL0.canScrollVertically(-1)) {
                            accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34581r);
                            accessibilityNodeInfoCompat.K0(true);
                        } else if ((-appBarLayout.getDownNestedPreScrollRange()) != 0) {
                            accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34581r);
                            accessibilityNodeInfoCompat.K0(true);
                        }
                    }
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public boolean j(View view, int i3, Bundle bundle) {
                    if (i3 == 4096) {
                        appBarLayout.setExpanded(false);
                        return true;
                    }
                    if (i3 != 8192) {
                        return super.j(view, i3, bundle);
                    }
                    if (BaseBehavior.this.S() != 0) {
                        View viewL0 = BaseBehavior.this.l0(coordinatorLayout);
                        if (!viewL0.canScrollVertically(-1)) {
                            appBarLayout.setExpanded(true);
                            return true;
                        }
                        int i4 = -appBarLayout.getDownNestedPreScrollRange();
                        if (i4 != 0) {
                            BaseBehavior.this.w(coordinatorLayout, appBarLayout, viewL0, 0, i4, new int[]{0, 0}, 1);
                            return true;
                        }
                    }
                    return false;
                }
            });
        }

        private void b0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, float f3) {
            int iAbs = Math.abs(S() - i3);
            float fAbs = Math.abs(f3);
            c0(coordinatorLayout, appBarLayout, i3, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f));
        }

        private void c0(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i3, int i4) {
            int iS = S();
            if (iS == i3) {
                ValueAnimator valueAnimator = this.f79900n;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f79900n.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f79900n;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f79900n = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.f79853e);
                this.f79900n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        BaseBehavior.this.V(coordinatorLayout, appBarLayout, ((Integer) valueAnimator4.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.f79900n.setDuration(Math.min(i4, 600));
            this.f79900n.setIntValues(iS, i3);
            this.f79900n.start();
        }

        private int d0(int i3, int i4, int i5) {
            return i3 < (i4 + i5) / 2 ? i4 : i5;
        }

        private boolean f0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            return appBarLayout.m() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        }

        private static boolean g0(int i3, int i4) {
            return (i3 & i4) == i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (((LayoutParams) appBarLayout.getChildAt(i3).getLayoutParams()).f79917a != 0) {
                    return true;
                }
            }
            return false;
        }

        private View i0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View j0(AppBarLayout appBarLayout, int i3) {
            int iAbs = Math.abs(i3);
            int childCount = appBarLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = appBarLayout.getChildAt(i4);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int k0(AppBarLayout appBarLayout, int i3) {
            int childCount = appBarLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = appBarLayout.getChildAt(i4);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (g0(layoutParams.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i5 = -i3;
                if (top <= i5 && bottom >= i5) {
                    return i4;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public View l0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int o0(AppBarLayout appBarLayout, int i3) {
            int iAbs = Math.abs(i3);
            int childCount = appBarLayout.getChildCount();
            int topInset = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = appBarLayout.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolatorD = layoutParams.d();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i4++;
                } else if (interpolatorD != null) {
                    int iC = layoutParams.c();
                    if ((iC & 1) != 0) {
                        topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= ViewCompat.z(childAt);
                        }
                    }
                    if (ViewCompat.v(childAt)) {
                        topInset -= appBarLayout.getTopInset();
                    }
                    if (topInset > 0) {
                        float f3 = topInset;
                        return Integer.signum(i3) * (childAt.getTop() + Math.round(f3 * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f3)));
                    }
                }
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
        public int W(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, int i5) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout2;
            int iS = S();
            int i6 = 0;
            if (i4 == 0 || iS < i4 || iS > i5) {
                coordinatorLayout2 = coordinatorLayout;
                appBarLayout2 = appBarLayout;
                this.f79898l = 0;
            } else {
                int iB = MathUtils.b(i3, i4, i5);
                if (iS != iB) {
                    int iO0 = appBarLayout.k() ? o0(appBarLayout, iB) : iB;
                    boolean zM = M(iO0);
                    int i7 = iS - iB;
                    this.f79898l = iB - iO0;
                    if (zM) {
                        while (i6 < appBarLayout.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) appBarLayout.getChildAt(i6).getLayoutParams();
                            ChildScrollEffect childScrollEffectB = layoutParams.b();
                            if (childScrollEffectB != null && (layoutParams.c() & 1) != 0) {
                                childScrollEffectB.a(appBarLayout, appBarLayout.getChildAt(i6), K());
                            }
                            i6++;
                        }
                    }
                    if (!zM && appBarLayout.k()) {
                        coordinatorLayout.m(appBarLayout);
                    }
                    appBarLayout.s(K());
                    coordinatorLayout2 = coordinatorLayout;
                    appBarLayout2 = appBarLayout;
                    D0(coordinatorLayout2, appBarLayout2, iB, iB < iS ? -1 : 1, false);
                    i6 = i7;
                } else {
                    coordinatorLayout2 = coordinatorLayout;
                    appBarLayout2 = appBarLayout;
                }
            }
            a0(coordinatorLayout2, appBarLayout2);
            return i6;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int S() {
            return K() + this.f79898l;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public boolean N(AppBarLayout appBarLayout) {
            BaseDragCallback baseDragCallback = this.f79903q;
            if (baseDragCallback != null) {
                return baseDragCallback.a(appBarLayout);
            }
            WeakReference weakReference = this.f79902p;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
        public int Q(AppBarLayout appBarLayout) {
            return (-appBarLayout.getDownNestedScrollRange()) + appBarLayout.getTopInset();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
        public int R(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
        public void T(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            C0(coordinatorLayout, appBarLayout);
            if (appBarLayout.q()) {
                appBarLayout.A(appBarLayout.D(i0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
        public boolean r(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3) {
            boolean zR = super.r(coordinatorLayout, appBarLayout, i3);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.f79901o;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z2 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i4 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z2) {
                            b0(coordinatorLayout, appBarLayout, i4, 0.0f);
                        } else {
                            V(coordinatorLayout, appBarLayout, i4);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z2) {
                            b0(coordinatorLayout, appBarLayout, 0, 0.0f);
                        } else {
                            V(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (savedState.f79910c) {
                V(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (savedState.f79911d) {
                V(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(savedState.f79912f);
                V(coordinatorLayout, appBarLayout, (-childAt.getBottom()) + (this.f79901o.f79914h ? ViewCompat.z(childAt) + appBarLayout.getTopInset() : Math.round(childAt.getHeight() * this.f79901o.f79913g)));
            }
            appBarLayout.w();
            this.f79901o = null;
            M(MathUtils.b(K(), -appBarLayout.getTotalScrollRange(), 0));
            D0(coordinatorLayout, appBarLayout, K(), 0, true);
            appBarLayout.s(K());
            a0(coordinatorLayout, appBarLayout);
            return zR;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
        public boolean s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, int i5, int i6) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams())).height != -2) {
                return super.s(coordinatorLayout, appBarLayout, i3, i4, i5, i6);
            }
            coordinatorLayout.N(appBarLayout, i3, i4, View.MeasureSpec.makeMeasureSpec(0, 0), i6);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void w(androidx.coordinatorlayout.widget.CoordinatorLayout r7, com.google.android.material.appbar.AppBarLayout r8, android.view.View r9, int r10, int r11, int[] r12, int r13) {
            /*
                r6 = this;
                if (r11 == 0) goto L26
                if (r11 >= 0) goto L11
                int r10 = r8.getTotalScrollRange()
                int r10 = -r10
                int r13 = r8.getDownNestedPreScrollRange()
                int r13 = r13 + r10
            Le:
                r4 = r10
                r5 = r13
                goto L18
            L11:
                int r10 = r8.getUpNestedPreScrollRange()
                int r10 = -r10
                r13 = 0
                goto Le
            L18:
                if (r4 == r5) goto L26
                r10 = 1
                r0 = r6
                r1 = r7
                r2 = r8
                r3 = r11
                int r7 = r0.U(r1, r2, r3, r4, r5)
                r12[r10] = r7
                goto L27
            L26:
                r2 = r8
            L27:
                boolean r7 = r2.q()
                if (r7 == 0) goto L34
                boolean r7 = r2.D(r9)
                r2.A(r7)
            L34:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.w(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int, int[], int):void");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
        public void z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout2;
            int i8;
            if (i6 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                appBarLayout2 = appBarLayout;
                i8 = i6;
                iArr[1] = U(coordinatorLayout2, appBarLayout2, i8, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
                appBarLayout2 = appBarLayout;
                i8 = i6;
            }
            if (i8 == 0) {
                a0(coordinatorLayout2, appBarLayout2);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
        public void D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                y0((SavedState) parcelable, true);
                super.D(coordinatorLayout, appBarLayout, this.f79901o.c());
            } else {
                super.D(coordinatorLayout, appBarLayout, parcelable);
                this.f79901o = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
        public Parcelable E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable parcelableE = super.E(coordinatorLayout, appBarLayout);
            SavedState savedStateZ0 = z0(parcelableE, appBarLayout);
            return savedStateZ0 == null ? parcelableE : savedStateZ0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
        public boolean G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
            ValueAnimator valueAnimator;
            boolean z2 = (i3 & 2) != 0 && (appBarLayout.q() || f0(coordinatorLayout, appBarLayout, view));
            if (z2 && (valueAnimator = this.f79900n) != null) {
                valueAnimator.cancel();
            }
            this.f79902p = null;
            this.f79899m = i4;
            return z2;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public void I(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
            if (this.f79899m == 0 || i3 == 1) {
                C0(coordinatorLayout, appBarLayout);
                if (appBarLayout.q()) {
                    appBarLayout.A(appBarLayout.D(view));
                }
            }
            this.f79902p = new WeakReference(view);
        }

        void y0(SavedState savedState, boolean z2) {
            if (this.f79901o == null || z2) {
                this.f79901o = savedState;
            }
        }

        SavedState z0(Parcelable parcelable, AppBarLayout appBarLayout) {
            int iK = K();
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                int bottom = childAt.getBottom() + iK;
                if (childAt.getTop() + iK <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.f35460b;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z2 = iK == 0;
                    savedState.f79911d = z2;
                    savedState.f79910c = !z2 && (-iK) >= appBarLayout.getTotalScrollRange();
                    savedState.f79912f = i3;
                    savedState.f79914h = bottom == ViewCompat.z(childAt) + appBarLayout.getTopInset();
                    savedState.f79913g = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
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
            boolean f79910c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f79911d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f79912f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            float f79913g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            boolean f79914h;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f79910c = parcel.readByte() != 0;
                this.f79911d = parcel.readByte() != 0;
                this.f79912f = parcel.readInt();
                this.f79913g = parcel.readFloat();
                this.f79914h = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                super.writeToParcel(parcel, i3);
                parcel.writeByte(this.f79910c ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f79911d ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f79912f);
                parcel.writeFloat(this.f79913g);
                parcel.writeByte(this.f79914h ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void a(AppBarLayout appBarLayout, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Behavior extends BaseBehavior<AppBarLayout> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.J(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int K() {
            return super.K();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean M(int i3) {
            return super.M(i3);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.q(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: q0 */
        public /* bridge */ /* synthetic */ boolean r(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3) {
            return super.r(coordinatorLayout, appBarLayout, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: r0 */
        public /* bridge */ /* synthetic */ boolean s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3, int i4, int i5, int i6) {
            return super.s(coordinatorLayout, appBarLayout, i3, i4, i5, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: s0 */
        public /* bridge */ /* synthetic */ void w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int[] iArr, int i5) {
            super.w(coordinatorLayout, appBarLayout, view, i3, i4, iArr, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: t0 */
        public /* bridge */ /* synthetic */ void z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            super.z(coordinatorLayout, appBarLayout, view, i3, i4, i5, i6, i7, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: u0 */
        public /* bridge */ /* synthetic */ void D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.D(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: v0 */
        public /* bridge */ /* synthetic */ Parcelable E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.E(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: w0 */
        public /* bridge */ /* synthetic */ boolean G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
            return super.G(coordinatorLayout, appBarLayout, view, view2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: x0 */
        public /* bridge */ /* synthetic */ void I(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
            super.I(coordinatorLayout, appBarLayout, view, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ChildScrollEffect {
        public abstract void a(AppBarLayout appBarLayout, View view, float f3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CompressChildScrollEffect extends ChildScrollEffect {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f79915a = new Rect();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f79916b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ChildScrollEffect
        public void a(AppBarLayout appBarLayout, View view, float f3) {
            b(this.f79915a, appBarLayout, view);
            float fAbs = this.f79915a.top - Math.abs(f3);
            if (fAbs > 0.0f) {
                ViewCompat.t0(view, null);
                view.setTranslationY(0.0f);
                view.setVisibility(0);
                return;
            }
            float fA = 1.0f - MathUtils.a(Math.abs(fAbs / this.f79915a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.f79915a.height() * 0.3f) * (1.0f - (fA * fA)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.f79916b);
            this.f79916b.offset(0, (int) (-fHeight));
            if (fHeight >= this.f79916b.height()) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            ViewCompat.t0(view, this.f79916b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface LiftOnScrollListener {
        void a(float f3, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int X(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).f();
            if (behaviorF instanceof BaseBehavior) {
                return ((BaseBehavior) behaviorF).S();
            }
            return 0;
        }

        private void Y(View view, View view2) {
            CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).f();
            if (behaviorF instanceof BaseBehavior) {
                ViewCompat.X(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behaviorF).f79898l) + S()) - O(view2));
            }
        }

        private void Z(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.q()) {
                    appBarLayout.A(appBarLayout.D(view));
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean C(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z2) {
            AppBarLayout appBarLayoutN = N(coordinatorLayout.v(view));
            if (appBarLayoutN != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.f79960d;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutN.x(false, !z2);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float P(View view) {
            int i3;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iX = X(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iX > downNestedPreScrollRange) && (i3 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iX / i3) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int R(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.R(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public AppBarLayout N(List list) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) list.get(i3);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean k(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Y(view, view2);
            Z(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void o(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.m0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean r(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return super.r(coordinatorLayout, view, i3);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean s(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
            return super.s(coordinatorLayout, view, i3, i4, i5, i6);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.o6);
            U(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.p6, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f79478b);
    }

    private boolean C() {
        return this.f79893w != null && getTopInset() > 0;
    }

    private boolean E() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !ViewCompat.v(childAt)) {
                return true;
            }
        }
        return false;
    }

    private void F(float f3, float f4) {
        ValueAnimator valueAnimator = this.f79887q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f3, f4);
        this.f79887q = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f79890t);
        this.f79887q.setInterpolator(this.f79891u);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f79888r;
        if (animatorUpdateListener != null) {
            this.f79887q.addUpdateListener(animatorUpdateListener);
        }
        this.f79887q.start();
    }

    private void G() {
        setWillNotDraw(!C());
    }

    public static /* synthetic */ void a(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable, ValueAnimator valueAnimator) {
        appBarLayout.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialShapeDrawable.Z(fFloatValue);
        Drawable drawable = appBarLayout.f79893w;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).Z(fFloatValue);
        }
        Iterator it = appBarLayout.f79889s.iterator();
        while (it.hasNext()) {
            ((LiftOnScrollListener) it.next()).a(fFloatValue, materialShapeDrawable.A());
        }
    }

    public static /* synthetic */ void b(AppBarLayout appBarLayout, ColorStateList colorStateList, ColorStateList colorStateList2, MaterialShapeDrawable materialShapeDrawable, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        appBarLayout.getClass();
        int iL = MaterialColors.l(colorStateList.getDefaultColor(), colorStateList2.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        materialShapeDrawable.a0(ColorStateList.valueOf(iL));
        if (appBarLayout.f79893w != null && (num2 = appBarLayout.f79894x) != null && num2.equals(num)) {
            DrawableCompat.n(appBarLayout.f79893w, iL);
        }
        if (appBarLayout.f79889s.isEmpty()) {
            return;
        }
        for (LiftOnScrollListener liftOnScrollListener : appBarLayout.f79889s) {
            if (materialShapeDrawable.x() != null) {
                liftOnScrollListener.a(0.0f, iL);
            }
        }
    }

    private void e() {
        WeakReference weakReference = this.f79885o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f79885o = null;
    }

    private Integer f() {
        Drawable drawable = this.f79893w;
        if (drawable instanceof MaterialShapeDrawable) {
            return Integer.valueOf(((MaterialShapeDrawable) drawable).A());
        }
        ColorStateList colorStateListG = DrawableUtils.g(drawable);
        if (colorStateListG != null) {
            return Integer.valueOf(colorStateListG.getDefaultColor());
        }
        return null;
    }

    private View g(View view) {
        int i3;
        if (this.f79885o == null && (i3 = this.f79884n) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i3) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f79884n);
            }
            if (viewFindViewById != null) {
                this.f79885o = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.f79885o;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private boolean l() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (((LayoutParams) getChildAt(i3).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void n(final MaterialShapeDrawable materialShapeDrawable, final ColorStateList colorStateList, final ColorStateList colorStateList2) {
        final Integer numF = MaterialColors.f(getContext(), R.attr.f79518v);
        this.f79888r = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.b(this.f79980a, colorStateList, colorStateList2, materialShapeDrawable, numF, valueAnimator);
            }
        };
        ViewCompat.q0(this, materialShapeDrawable);
    }

    private void o(Context context, final MaterialShapeDrawable materialShapeDrawable) {
        materialShapeDrawable.P(context);
        this.f79888r = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.a(this.f79985a, materialShapeDrawable, valueAnimator);
            }
        };
        ViewCompat.q0(this, materialShapeDrawable);
    }

    private void p() {
        Behavior behavior = this.f79896z;
        BaseBehavior.SavedState savedStateZ0 = (behavior == null || this.f79873b == -1 || this.f79877g != 0) ? null : behavior.z0(AbsSavedState.f35460b, this);
        this.f79873b = -1;
        this.f79874c = -1;
        this.f79875d = -1;
        if (savedStateZ0 != null) {
            this.f79896z.y0(savedStateZ0, false);
        }
    }

    private boolean r() {
        return getBackground() instanceof MaterialShapeDrawable;
    }

    private void y(boolean z2, boolean z3, boolean z4) {
        this.f79877g = (z2 ? 1 : 2) | (z3 ? 4 : 0) | (z4 ? 8 : 0);
        requestLayout();
    }

    private boolean z(boolean z2) {
        if (this.f79881k == z2) {
            return false;
        }
        this.f79881k = z2;
        refreshDrawableState();
        return true;
    }

    boolean A(boolean z2) {
        return B(z2, !this.f79880j);
    }

    boolean B(boolean z2, boolean z3) {
        if (!z3 || this.f79882l == z2) {
            return false;
        }
        this.f79882l = z2;
        refreshDrawableState();
        if (!r()) {
            return true;
        }
        if (this.f79886p) {
            F(z2 ? 0.0f : 1.0f, z2 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f79883m) {
            return true;
        }
        F(z2 ? 0.0f : this.f79895y, z2 ? this.f79895y : 0.0f);
        return true;
    }

    boolean D(View view) {
        View viewG = g(view);
        if (viewG != null) {
            view = viewG;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public void c(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.f79879i == null) {
            this.f79879i = new ArrayList();
        }
        if (baseOnOffsetChangedListener == null || this.f79879i.contains(baseOnOffsetChangedListener)) {
            return;
        }
        this.f79879i.add(baseOnOffsetChangedListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void d(OnOffsetChangedListener onOffsetChangedListener) {
        c(onOffsetChangedListener);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (C()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f79872a);
            this.f79893w.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f79893w;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f79896z = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int iZ;
        int i3 = this.f79874c;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = layoutParams.f79917a;
                if ((i5 & 5) != 5) {
                    if (i4 > 0) {
                        break;
                    }
                } else {
                    int i6 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    if ((i5 & 8) != 0) {
                        iZ = ViewCompat.z(childAt);
                    } else if ((i5 & 2) != 0) {
                        iZ = measuredHeight - ViewCompat.z(childAt);
                    } else {
                        iMin = i6 + measuredHeight;
                        if (childCount == 0 && ViewCompat.v(childAt)) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i4 += iMin;
                    }
                    iMin = i6 + iZ;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i4 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i4);
        this.f79874c = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i3 = this.f79875d;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i4 = 0;
        int iZ = 0;
        while (true) {
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                int i5 = layoutParams.f79917a;
                if ((i5 & 1) == 0) {
                    break;
                }
                iZ += measuredHeight;
                if ((i5 & 2) != 0) {
                    iZ -= ViewCompat.z(childAt);
                    break;
                }
            }
            i4++;
        }
        int iMax = Math.max(0, iZ);
        this.f79875d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f79884n;
    }

    public MaterialShapeDrawable getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            return (MaterialShapeDrawable) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iZ = ViewCompat.z(this);
        if (iZ == 0) {
            int childCount = getChildCount();
            iZ = childCount >= 1 ? ViewCompat.z(getChildAt(childCount - 1)) : 0;
            if (iZ == 0) {
                return getHeight() / 3;
            }
        }
        return (iZ * 2) + topInset;
    }

    int getPendingAction() {
        return this.f79877g;
    }

    public Drawable getStatusBarForeground() {
        return this.f79893w;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f79878h;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.m();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i3 = this.f79873b;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i4 = 0;
        int iZ = 0;
        while (true) {
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = layoutParams.f79917a;
                if ((i5 & 1) == 0) {
                    break;
                }
                iZ += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if (i4 == 0 && ViewCompat.v(childAt)) {
                    iZ -= getTopInset();
                }
                if ((i5 & 2) != 0) {
                    iZ -= ViewCompat.z(childAt);
                    break;
                }
            }
            i4++;
        }
        int iMax = Math.max(0, iZ);
        this.f79873b = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new LayoutParams((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    boolean k() {
        return this.f79876f;
    }

    boolean m() {
        return getTotalScrollRange() != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        if (this.f79892v == null) {
            this.f79892v = new int[4];
        }
        int[] iArr = this.f79892v;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + iArr.length);
        boolean z2 = this.f79881k;
        int i4 = R.attr.f79519v0;
        if (!z2) {
            i4 = -i4;
        }
        iArr[0] = i4;
        iArr[1] = (z2 && this.f79882l) ? R.attr.f79521w0 : -R.attr.f79521w0;
        int i5 = R.attr.f79511r0;
        if (!z2) {
            i5 = -i5;
        }
        iArr[2] = i5;
        iArr[3] = (z2 && this.f79882l) ? R.attr.f79509q0 : -R.attr.f79509q0;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        boolean z3 = true;
        if (ViewCompat.v(this) && E()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.X(getChildAt(childCount), topInset);
            }
        }
        p();
        this.f79876f = false;
        int childCount2 = getChildCount();
        int i7 = 0;
        while (true) {
            if (i7 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i7).getLayoutParams()).d() != null) {
                this.f79876f = true;
                break;
            }
            i7++;
        }
        Drawable drawable = this.f79893w;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f79880j) {
            return;
        }
        if (!this.f79883m && !l()) {
            z3 = false;
        }
        z(z3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i4);
        if (mode != 1073741824 && ViewCompat.v(this) && E()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i4));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        p();
    }

    public boolean q() {
        return this.f79883m;
    }

    void s(int i3) {
        this.f79872a = i3;
        if (!willNotDraw()) {
            ViewCompat.d0(this);
        }
        List list = this.f79879i;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = (BaseOnOffsetChangedListener) this.f79879i.get(i4);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.a(this, i3);
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        MaterialShapeUtils.d(this, f3);
    }

    public void setExpanded(boolean z2) {
        x(z2, ViewCompat.R(this));
    }

    public void setLiftOnScroll(boolean z2) {
        this.f79883m = z2;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f79884n = -1;
        if (view == null) {
            e();
        } else {
            this.f79885o = new WeakReference(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i3) {
        this.f79884n = i3;
        e();
    }

    public void setLiftableOverrideEnabled(boolean z2) {
        this.f79880j = z2;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        if (i3 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i3);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f79893w;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f79893w = drawable != null ? drawable.mutate() : null;
            this.f79894x = f();
            Drawable drawable3 = this.f79893w;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f79893w.setState(getDrawableState());
                }
                DrawableCompat.m(this.f79893w, ViewCompat.y(this));
                this.f79893w.setVisible(getVisibility() == 0, false);
                this.f79893w.setCallback(this);
            }
            G();
            ViewCompat.d0(this);
        }
    }

    public void setStatusBarForegroundColor(int i3) {
        setStatusBarForeground(new ColorDrawable(i3));
    }

    public void setStatusBarForegroundResource(int i3) {
        setStatusBarForeground(AppCompatResources.b(getContext(), i3));
    }

    @Deprecated
    public void setTargetElevation(float f3) {
        ViewUtilsLollipop.b(this, f3);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z2 = i3 == 0;
        Drawable drawable = this.f79893w;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
    }

    WindowInsetsCompat t(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.v(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.a(this.f79878h, windowInsetsCompat2)) {
            this.f79878h = windowInsetsCompat2;
            G();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public void u(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List list = this.f79879i;
        if (list == null || baseOnOffsetChangedListener == null) {
            return;
        }
        list.remove(baseOnOffsetChangedListener);
    }

    public void v(OnOffsetChangedListener onOffsetChangedListener) {
        u(onOffsetChangedListener);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f79893w;
    }

    void w() {
        this.f79877g = 0;
    }

    public void x(boolean z2, boolean z3) {
        y(z2, z3, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i3) {
        int i4 = A;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f79873b = -1;
        this.f79874c = -1;
        this.f79875d = -1;
        this.f79877g = 0;
        this.f79889s = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            ViewUtilsLollipop.a(this);
        }
        ViewUtilsLollipop.c(this, attributeSet, i3, i4);
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, R.styleable.f79794k, i3, i4, new int[0]);
        ViewCompat.q0(this, typedArrayI.getDrawable(R.styleable.f79798l));
        ColorStateList colorStateListA = MaterialResources.a(context2, typedArrayI, R.styleable.f79822r);
        this.f79886p = colorStateListA != null;
        ColorStateList colorStateListG = DrawableUtils.g(getBackground());
        if (colorStateListG != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.a0(colorStateListG);
            if (colorStateListA != null) {
                n(materialShapeDrawable, colorStateListG, colorStateListA);
            } else {
                o(context2, materialShapeDrawable);
            }
        }
        this.f79890t = MotionUtils.f(context2, R.attr.X, getResources().getInteger(R.integer.f79667a));
        this.f79891u = MotionUtils.g(context2, R.attr.f79493i0, AnimationUtils.f79849a);
        int i5 = R.styleable.f79814p;
        if (typedArrayI.hasValue(i5)) {
            y(typedArrayI.getBoolean(i5, false), false, false);
        }
        if (typedArrayI.hasValue(R.styleable.f79810o)) {
            ViewUtilsLollipop.b(this, typedArrayI.getDimensionPixelSize(r11, 0));
        }
        int i6 = R.styleable.f79806n;
        if (typedArrayI.hasValue(i6)) {
            setKeyboardNavigationCluster(typedArrayI.getBoolean(i6, false));
        }
        int i7 = R.styleable.f79802m;
        if (typedArrayI.hasValue(i7)) {
            setTouchscreenBlocksFocus(typedArrayI.getBoolean(i7, false));
        }
        this.f79895y = getResources().getDimension(R.dimen.f79556b);
        this.f79883m = typedArrayI.getBoolean(R.styleable.f79818q, false);
        this.f79884n = typedArrayI.getResourceId(R.styleable.f79825s, -1);
        setStatusBarForeground(typedArrayI.getDrawable(R.styleable.f79828t));
        typedArrayI.recycle();
        ViewCompat.C0(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.appbar.AppBarLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return AppBarLayout.this.t(windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f79917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ChildScrollEffect f79918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Interpolator f79919c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollEffect {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f79917a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f79834v);
            this.f79917a = typedArrayObtainStyledAttributes.getInt(R.styleable.f79840x, 0);
            f(typedArrayObtainStyledAttributes.getInt(R.styleable.f79837w, 0));
            int i3 = R.styleable.f79843y;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                this.f79919c = android.view.animation.AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i3, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        private ChildScrollEffect a(int i3) {
            if (i3 != 1) {
                return null;
            }
            return new CompressChildScrollEffect();
        }

        public ChildScrollEffect b() {
            return this.f79918b;
        }

        public int c() {
            return this.f79917a;
        }

        public Interpolator d() {
            return this.f79919c;
        }

        boolean e() {
            int i3 = this.f79917a;
            return (i3 & 1) == 1 && (i3 & 10) != 0;
        }

        public void f(int i3) {
            this.f79918b = a(i3);
        }

        public void g(int i3) {
            this.f79917a = i3;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f79917a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f79917a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f79917a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f79917a = 1;
        }
    }
}
