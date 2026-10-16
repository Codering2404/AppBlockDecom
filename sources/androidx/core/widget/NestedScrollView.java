package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.os.BuildCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    private static final float E = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final AccessibilityDelegate F = new AccessibilityDelegate();
    private static final int[] G = {R.attr.fillViewport};
    private float A;
    private OnScrollChangeListener B;
    final DifferentialMotionFlingTargetImpl C;
    DifferentialMotionFlingController D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f34662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f34663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f34664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OverScroller f34665d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EdgeEffect f34666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EdgeEffect f34667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f34668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f34669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f34670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f34671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f34672l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private VelocityTracker f34673m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f34674n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f34675o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f34676p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f34677q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f34678r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f34679s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int[] f34680t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int[] f34681u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f34682v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f34683w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private SavedState f34684x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final NestedScrollingParentHelper f34685y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final NestedScrollingChildHelper f34686z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.a(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.g(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.i0(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfoCompat.K0(true);
            if (nestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34581r);
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.C);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34580q);
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.E);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean j(View view, int i3, Bundle bundle) {
            if (super.j(view, i3, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i3 != 4096) {
                if (i3 == 8192 || i3 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.X(0, iMax, true);
                    return true;
                }
                if (i3 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.X(0, iMin, true);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api35Impl {
        public static void a(View view, float f3) {
            try {
                view.setFrameContentVelocity(f3);
            } catch (LinkageError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {
        DifferentialMotionFlingTargetImpl() {
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean a(float f3) {
            if (f3 == 0.0f) {
                return false;
            }
            c();
            NestedScrollView.this.v((int) f3);
            return true;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float b() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void c() {
            NestedScrollView.this.f34665d.abortAnimation();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnScrollChangeListener {
        void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f34688a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f34688a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f34688a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f34688a = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.R.attr.f33491c);
    }

    private void A() {
        VelocityTracker velocityTracker = this.f34673m;
        if (velocityTracker == null) {
            this.f34673m = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void B() {
        this.f34665d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f34676p = viewConfiguration.getScaledTouchSlop();
        this.f34677q = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f34678r = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void C() {
        if (this.f34673m == null) {
            this.f34673m = VelocityTracker.obtain();
        }
    }

    private void D(int i3, int i4) {
        this.f34668h = i3;
        this.f34679s = i4;
        Y(2, 0);
    }

    private boolean E(View view) {
        return !G(view, 0, getHeight());
    }

    private static boolean F(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && F((View) parent, view2);
    }

    private boolean G(View view, int i3, int i4) {
        view.getDrawingRect(this.f34664c);
        offsetDescendantRectToMyCoords(view, this.f34664c);
        return this.f34664c.bottom + i3 >= getScrollY() && this.f34664c.top - i3 <= getScrollY() + i4;
    }

    private void H(int i3, int i4, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i3);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f34686z.e(0, scrollY2, 0, i3 - scrollY2, null, i4, iArr);
    }

    private void I(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f34679s) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.f34668h = (int) motionEvent.getY(i3);
            this.f34679s = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f34673m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void L() {
        VelocityTracker velocityTracker = this.f34673m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f34673m = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int M(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f34666f
            float r0 = androidx.core.widget.EdgeEffectCompat.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.f34666f
            float r4 = -r4
            float r4 = androidx.core.widget.EdgeEffectCompat.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f34666f
            float r5 = androidx.core.widget.EdgeEffectCompat.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f34666f
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.f34667g
            float r0 = androidx.core.widget.EdgeEffectCompat.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.f34667g
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.EdgeEffectCompat.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f34667g
            float r5 = androidx.core.widget.EdgeEffectCompat.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f34667g
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L63
            r3.invalidate()
        L63:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.M(int, float):int");
    }

    private void N(boolean z2) {
        if (z2) {
            Y(2, 1);
        } else {
            a0(1);
        }
        this.f34683w = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean O(int i3, int i4, int i5) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i6 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i3 == 33;
        View viewU = u(z3, i4, i5);
        if (viewU == null) {
            viewU = this;
        }
        if (i4 < scrollY || i5 > i6) {
            P(z3 ? i4 - scrollY : i5 - i6, 0, 1, true);
            z2 = true;
        }
        if (viewU != findFocus()) {
            viewU.requestFocus(i3);
        }
        return z2;
    }

    private int P(int i3, int i4, int i5, boolean z2) {
        int i6;
        int i7;
        VelocityTracker velocityTracker;
        if (i5 == 1) {
            Y(2, i5);
        }
        boolean z3 = false;
        if (i(0, i3, this.f34681u, this.f34680t, i5)) {
            int i8 = i3 - this.f34681u[1];
            i7 = this.f34680t[1];
            i6 = i8;
        } else {
            i6 = i3;
            i7 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z4 = d() && !z2;
        int i9 = i6;
        boolean z5 = J(0, i6, 0, scrollY, 0, scrollRange, 0, 0, true) && !y(i5);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f34681u;
        iArr[1] = 0;
        m(0, scrollY2, 0, i9 - scrollY2, this.f34680t, i5, iArr);
        int i10 = i7 + this.f34680t[1];
        int i11 = i9 - this.f34681u[1];
        int i12 = scrollY + i11;
        if (i12 < 0) {
            if (z4) {
                EdgeEffectCompat.d(this.f34666f, (-i11) / getHeight(), i4 / getWidth());
                if (!this.f34667g.isFinished()) {
                    this.f34667g.onRelease();
                }
            }
        } else if (i12 > scrollRange && z4) {
            EdgeEffectCompat.d(this.f34667g, i11 / getHeight(), 1.0f - (i4 / getWidth()));
            if (!this.f34666f.isFinished()) {
                this.f34666f.onRelease();
            }
        }
        if (this.f34666f.isFinished() && this.f34667g.isFinished()) {
            z3 = z5;
        } else {
            postInvalidateOnAnimation();
        }
        if (z3 && i5 == 0 && (velocityTracker = this.f34673m) != null) {
            velocityTracker.clear();
        }
        if (i5 == 1) {
            a0(i5);
            this.f34666f.onRelease();
            this.f34667g.onRelease();
        }
        return i10;
    }

    private void Q(View view) {
        view.getDrawingRect(this.f34664c);
        offsetDescendantRectToMyCoords(view, this.f34664c);
        int iG = g(this.f34664c);
        if (iG != 0) {
            scrollBy(0, iG);
        }
    }

    private boolean R(Rect rect, boolean z2) {
        int iG = g(rect);
        boolean z3 = iG != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, iG);
                return z3;
            }
            T(0, iG);
        }
        return z3;
    }

    private boolean S(EdgeEffect edgeEffect, int i3) {
        if (i3 > 0) {
            return true;
        }
        return x(-i3) < EdgeEffectCompat.b(edgeEffect) * ((float) getHeight());
    }

    private void U(int i3, int i4, int i5, boolean z2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f34663b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f34665d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i4 + scrollY, Math.max(0, height - height2))) - scrollY, i5);
            N(z2);
        } else {
            if (!this.f34665d.isFinished()) {
                a();
            }
            scrollBy(i3, i4);
        }
        this.f34663b = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean Z(MotionEvent motionEvent) {
        boolean z2;
        if (EdgeEffectCompat.b(this.f34666f) != 0.0f) {
            EdgeEffectCompat.d(this.f34666f, 0.0f, motionEvent.getX() / getWidth());
            z2 = true;
        } else {
            z2 = false;
        }
        if (EdgeEffectCompat.b(this.f34667g) == 0.0f) {
            return z2;
        }
        EdgeEffectCompat.d(this.f34667g, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void a() {
        this.f34665d.abortAnimation();
        a0(1);
    }

    private boolean d() {
        int overScrollMode = getOverScrollMode();
        return overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0);
    }

    private boolean e() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                return true;
            }
        }
        return false;
    }

    private static int f(int i3, int i4, int i5) {
        if (i4 >= i5 || i3 < 0) {
            return 0;
        }
        return i4 + i3 > i5 ? i5 - i4 : i3;
    }

    private void q(int i3) {
        if (i3 != 0) {
            if (this.f34675o) {
                T(0, i3);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    private boolean r(int i3) {
        if (EdgeEffectCompat.b(this.f34666f) != 0.0f) {
            if (S(this.f34666f, i3)) {
                this.f34666f.onAbsorb(i3);
                return true;
            }
            v(-i3);
            return true;
        }
        if (EdgeEffectCompat.b(this.f34667g) == 0.0f) {
            return false;
        }
        int i4 = -i3;
        if (S(this.f34667g, i4)) {
            this.f34667g.onAbsorb(i4);
            return true;
        }
        v(i4);
        return true;
    }

    private void s() {
        this.f34679s = -1;
        this.f34672l = false;
        L();
        a0(0);
        this.f34666f.onRelease();
        this.f34667g.onRelease();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View u(boolean r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 2
            java.util.ArrayList r0 = r12.getFocusables(r0)
            int r1 = r0.size()
            r2 = 0
            r3 = 0
            r4 = r3
            r5 = r4
        Ld:
            if (r4 >= r1) goto L53
            java.lang.Object r6 = r0.get(r4)
            android.view.View r6 = (android.view.View) r6
            int r7 = r6.getTop()
            int r8 = r6.getBottom()
            if (r14 >= r8) goto L50
            if (r7 >= r15) goto L50
            r9 = 1
            if (r14 >= r7) goto L28
            if (r8 >= r15) goto L28
            r10 = r9
            goto L29
        L28:
            r10 = r3
        L29:
            if (r2 != 0) goto L2e
            r2 = r6
            r5 = r10
            goto L50
        L2e:
            if (r13 == 0) goto L36
            int r11 = r2.getTop()
            if (r7 < r11) goto L3e
        L36:
            if (r13 != 0) goto L40
            int r7 = r2.getBottom()
            if (r8 <= r7) goto L40
        L3e:
            r7 = r9
            goto L41
        L40:
            r7 = r3
        L41:
            if (r5 == 0) goto L48
            if (r10 == 0) goto L50
            if (r7 == 0) goto L50
            goto L4f
        L48:
            if (r10 == 0) goto L4d
            r2 = r6
            r5 = r9
            goto L50
        L4d:
            if (r7 == 0) goto L50
        L4f:
            r2 = r6
        L50:
            int r4 = r4 + 1
            goto Ld
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.u(boolean, int, int):android.view.View");
    }

    private float x(int i3) {
        double dLog = Math.log((Math.abs(i3) * 0.35f) / (this.f34662a * 0.015f));
        float f3 = E;
        return (float) (((double) (this.f34662a * 0.015f)) * Math.exp((((double) f3) / (((double) f3) - 1.0d)) * dLog));
    }

    private boolean z(int i3, int i4) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            if (i4 >= childAt.getTop() - scrollY && i4 < childAt.getBottom() - scrollY && i3 >= childAt.getLeft() && i3 < childAt.getRight()) {
                return true;
            }
        }
        return false;
    }

    boolean J(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z2) {
        boolean z3;
        boolean z4;
        int i11;
        int overScrollMode = getOverScrollMode();
        boolean z5 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z6 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        boolean z8 = overScrollMode == 0 || (overScrollMode == 1 && z6);
        int i12 = i5 + i3;
        int i13 = !z7 ? 0 : i9;
        int i14 = i6 + i4;
        int i15 = !z8 ? 0 : i10;
        int i16 = -i13;
        int i17 = i13 + i7;
        int i18 = -i15;
        int i19 = i15 + i8;
        if (i12 > i17) {
            i12 = i17;
            z3 = true;
        } else if (i12 < i16) {
            z3 = true;
            i12 = i16;
        } else {
            z3 = false;
        }
        if (i14 > i19) {
            i14 = i19;
            z4 = true;
        } else if (i14 < i18) {
            z4 = true;
            i14 = i18;
        } else {
            z4 = false;
        }
        if (!z4 || y(1)) {
            i11 = i12;
        } else {
            int i20 = i12;
            this.f34665d.springBack(i20, i14, 0, 0, 0, getScrollRange());
            i11 = i20;
        }
        onOverScrolled(i11, i14, z3, z4);
        return z3 || z4;
    }

    public boolean K(int i3) {
        boolean z2 = i3 == 130;
        int height = getHeight();
        if (z2) {
            this.f34664c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f34664c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f34664c.top = getScrollY() - height;
            Rect rect2 = this.f34664c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f34664c;
        int i4 = rect3.top;
        int i5 = height + i4;
        rect3.bottom = i5;
        return O(i3, i4, i5);
    }

    public final void T(int i3, int i4) {
        U(i3, i4, 250, false);
    }

    public final void V(int i3, int i4) {
        W(i3, i4, 250, false);
    }

    void W(int i3, int i4, int i5, boolean z2) {
        U(i3 - getScrollX(), i4 - getScrollY(), i5, z2);
    }

    void X(int i3, int i4, boolean z2) {
        W(i3, i4, 250, z2);
    }

    public boolean Y(int i3, int i4) {
        return this.f34686z.p(i3, i4);
    }

    public void a0(int i3) {
        this.f34686z.r(i3);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean c(int i3) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i3);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !G(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i3 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i3 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i3 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            P(maxScrollAmount, 0, 1, true);
        } else {
            viewFindNextFocus.getDrawingRect(this.f34664c);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f34664c);
            P(g(this.f34664c), 0, 1, true);
            viewFindNextFocus.requestFocus(i3);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && E(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        int i3;
        if (this.f34665d.isFinished()) {
            return;
        }
        this.f34665d.computeScrollOffset();
        int currY = this.f34665d.getCurrY();
        int iH = h(currY - this.f34683w);
        this.f34683w = currY;
        int[] iArr = this.f34681u;
        iArr[1] = 0;
        i(0, iH, iArr, null, 1);
        int i4 = iH - this.f34681u[1];
        int scrollRange = getScrollRange();
        if (BuildCompat.d()) {
            Api35Impl.a(this, Math.abs(this.f34665d.getCurrVelocity()));
        }
        if (i4 != 0) {
            int scrollY = getScrollY();
            J(0, i4, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            i3 = scrollRange;
            int scrollY2 = getScrollY() - scrollY;
            int i5 = i4 - scrollY2;
            int[] iArr2 = this.f34681u;
            iArr2[1] = 0;
            m(0, scrollY2, 0, i5, this.f34680t, 1, iArr2);
            i4 = i5 - this.f34681u[1];
        } else {
            i3 = scrollRange;
        }
        if (i4 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && i3 > 0)) {
                if (i4 < 0) {
                    if (this.f34666f.isFinished()) {
                        this.f34666f.onAbsorb((int) this.f34665d.getCurrVelocity());
                    }
                } else if (this.f34667g.isFinished()) {
                    this.f34667g.onAbsorb((int) this.f34665d.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f34665d.isFinished()) {
            a0(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || t(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f3, float f4, boolean z2) {
        return this.f34686z.a(f3, f4, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f3, float f4) {
        return this.f34686z.b(f3, f4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return i(i3, i4, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return this.f34686z.f(i3, i4, i5, i6, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.f34666f.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (Api21Impl.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (Api21Impl.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.f34666f.setSize(width, height);
            if (this.f34666f.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f34667g.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (Api21Impl.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = getPaddingLeft();
        }
        if (Api21Impl.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f34667g.setSize(width2, height2);
        if (this.f34667g.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    protected int g(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        int i5 = rect.bottom;
        if (i5 > i4 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i4, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        }
        if (rect.top >= scrollY || i5 >= i4) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i4 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f34685y.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    float getVerticalScrollFactorCompat() {
        if (this.A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.A = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.A;
    }

    int h(int i3) {
        int height = getHeight();
        if (i3 > 0 && EdgeEffectCompat.b(this.f34666f) != 0.0f) {
            int iRound = Math.round(((-height) / 4.0f) * EdgeEffectCompat.d(this.f34666f, ((-i3) * 4.0f) / height, 0.5f));
            if (iRound != i3) {
                this.f34666f.finish();
            }
            return i3 - iRound;
        }
        if (i3 >= 0 || EdgeEffectCompat.b(this.f34667g) == 0.0f) {
            return i3;
        }
        float f3 = height;
        int iRound2 = Math.round((f3 / 4.0f) * EdgeEffectCompat.d(this.f34667g, (i3 * 4.0f) / f3, 0.5f));
        if (iRound2 != i3) {
            this.f34667g.finish();
        }
        return i3 - iRound2;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return y(0);
    }

    public boolean i(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        return this.f34686z.d(i3, i4, iArr, iArr2, i5);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f34686z.l();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void j(View view, View view2, int i3, int i4) {
        this.f34685y.c(view, view2, i3, i4);
        Y(2, i4);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void k(View view, int i3) {
        this.f34685y.e(view, i3);
        a0(i3);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void l(View view, int i3, int i4, int[] iArr, int i5) {
        i(i3, i4, iArr, null, i5);
    }

    public void m(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        this.f34686z.e(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i3, int i4) {
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void n(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        H(i6, i7, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void o(View view, int i3, int i4, int i5, int i6, int i7) {
        H(i6, i7, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f34670j = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i3;
        int width;
        float axisValue;
        if (motionEvent.getAction() == 8 && !this.f34672l) {
            if (MotionEventCompat.a(motionEvent, 2)) {
                i3 = 9;
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if (MotionEventCompat.a(motionEvent, 4194304)) {
                float axisValue2 = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i3 = 26;
                axisValue = axisValue2;
            } else {
                i3 = 0;
                width = 0;
                axisValue = 0.0f;
            }
            if (axisValue != 0.0f) {
                P(-((int) (axisValue * getVerticalScrollFactorCompat())), width, 1, MotionEventCompat.a(motionEvent, 8194));
                if (i3 != 0) {
                    this.D.g(motionEvent, i3);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        int measuredHeight = 0;
        this.f34669i = false;
        View view = this.f34671k;
        if (view != null && F(view, this)) {
            Q(this.f34671k);
        }
        this.f34671k = null;
        if (!this.f34670j) {
            if (this.f34684x != null) {
                scrollTo(getScrollX(), this.f34684x.f34688a);
                this.f34684x = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i6 - i4) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iF = f(scrollY, paddingTop, measuredHeight);
            if (iF != scrollY) {
                scrollTo(getScrollX(), iF);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f34670j = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f34674n && View.MeasureSpec.getMode(i4) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f3, float f4, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f4, true);
        v((int) f4);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return dispatchNestedPreFling(f3, f4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        l(view, i3, i4, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        H(i6, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        j(view, view2, i3, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i3, int i4, boolean z2, boolean z3) {
        super.scrollTo(i3, i4);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        if (i3 == 2) {
            i3 = 130;
        } else if (i3 == 1) {
            i3 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i3) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i3);
        if (viewFindNextFocus == null || E(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i3, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f34684x = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f34688a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i4, int i5, int i6) {
        super.onScrollChanged(i3, i4, i5, i6);
        OnScrollChangeListener onScrollChangeListener = this.B;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.a(this, i3, i4, i5, i6);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !G(viewFindFocus, 0, i6)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f34664c);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f34664c);
        q(g(this.f34664c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return p(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        k(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        C();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f34682v = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f34682v);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f34673m;
                velocityTracker.computeCurrentVelocity(1000, this.f34678r);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f34679s);
                if (Math.abs(yVelocity) >= this.f34677q) {
                    if (!r(yVelocity)) {
                        int i3 = -yVelocity;
                        float f3 = i3;
                        if (!dispatchNestedPreFling(0.0f, f3)) {
                            dispatchNestedFling(0.0f, f3, true);
                            v(i3);
                        }
                    }
                } else if (this.f34665d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                s();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f34679s);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f34679s + " in onTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    int i4 = this.f34668h - y2;
                    int iM = i4 - M(i4, motionEvent.getX(iFindPointerIndex));
                    if (!this.f34672l && Math.abs(iM) > this.f34676p) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f34672l = true;
                        iM = iM > 0 ? iM - this.f34676p : iM + this.f34676p;
                    }
                    if (this.f34672l) {
                        int iP = P(iM, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f34668h = y2 - iP;
                        this.f34682v += iP;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f34672l && getChildCount() > 0 && this.f34665d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                s();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f34668h = (int) motionEvent.getY(actionIndex);
                this.f34679s = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                I(motionEvent);
                this.f34668h = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f34679s));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f34672l && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f34665d.isFinished()) {
                a();
            }
            D((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f34673m;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean p(View view, View view2, int i3, int i4) {
        return (i3 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f34669i) {
            this.f34671k = view2;
        } else {
            Q(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return R(rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            L();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f34669i = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i4) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iF = f(i3, width, width2);
            int iF2 = f(i4, height, height2);
            if (iF == getScrollX() && iF2 == getScrollY()) {
                return;
            }
            super.scrollTo(iF, iF2);
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.f34674n) {
            this.f34674n = z2;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        this.f34686z.m(z2);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.B = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.f34675o = z2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i3) {
        return Y(i3, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        a0(0);
    }

    public boolean t(KeyEvent keyEvent) {
        this.f34664c.setEmpty();
        if (!e()) {
            if (isFocused() && keyEvent.getKeyCode() != 4) {
                View viewFindFocus = findFocus();
                if (viewFindFocus == this) {
                    viewFindFocus = null;
                }
                View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
                if (viewFindNextFocus != null && viewFindNextFocus != this && viewFindNextFocus.requestFocus(130)) {
                    return true;
                }
            }
            return false;
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return keyEvent.isAltPressed() ? w(33) : c(33);
            }
            if (keyCode == 20) {
                return keyEvent.isAltPressed() ? w(130) : c(130);
            }
            if (keyCode == 62) {
                K(keyEvent.isShiftPressed() ? 33 : 130);
                return false;
            }
            if (keyCode == 92) {
                return w(33);
            }
            if (keyCode == 93) {
                return w(130);
            }
            if (keyCode == 122) {
                K(33);
                return false;
            }
            if (keyCode == 123) {
                K(130);
                return false;
            }
        }
        return false;
    }

    public void v(int i3) {
        if (getChildCount() > 0) {
            this.f34665d.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, 0);
            N(true);
            if (BuildCompat.d()) {
                Api35Impl.a(this, Math.abs(this.f34665d.getCurrVelocity()));
            }
        }
    }

    public boolean w(int i3) {
        int childCount;
        boolean z2 = i3 == 130;
        int height = getHeight();
        Rect rect = this.f34664c;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f34664c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f34664c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f34664c;
        return O(i3, rect3.top, rect3.bottom);
    }

    public boolean y(int i3) {
        return this.f34686z.k(i3);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f34664c = new Rect();
        this.f34669i = true;
        this.f34670j = false;
        this.f34671k = null;
        this.f34672l = false;
        this.f34675o = true;
        this.f34679s = -1;
        this.f34680t = new int[2];
        this.f34681u = new int[2];
        DifferentialMotionFlingTargetImpl differentialMotionFlingTargetImpl = new DifferentialMotionFlingTargetImpl();
        this.C = differentialMotionFlingTargetImpl;
        this.D = new DifferentialMotionFlingController(getContext(), differentialMotionFlingTargetImpl);
        this.f34666f = EdgeEffectCompat.a(context, attributeSet);
        this.f34667g = EdgeEffectCompat.a(context, attributeSet);
        this.f34662a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        B();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, G, i3, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f34685y = new NestedScrollingParentHelper(this);
        this.f34686z = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.m0(this, F);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        if (getChildCount() <= 0) {
            super.addView(view, i3);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
