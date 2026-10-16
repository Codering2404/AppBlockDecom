package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final String f33436v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final Class[] f33437w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final ThreadLocal f33438x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final Comparator f33439y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Pools.Pool f33440z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f33441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DirectedAcyclicGraph f33442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f33443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f33444d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f33445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f33446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f33447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f33448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f33449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f33450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f33451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f33452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private OnPreDrawListener f33453n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f33454o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private WindowInsetsCompat f33455p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f33456q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f33457r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f33458s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private OnApplyWindowInsetsListener f33459t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final NestedScrollingParentHelper f33460u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AttachedBehavior {
        Behavior getBehavior();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
            if (i4 == 0) {
                A(coordinatorLayout, view, view2, view3, i3);
            }
        }

        public boolean C(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z2) {
            return false;
        }

        public Parcelable E(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean F(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3) {
            return false;
        }

        public boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
            if (i4 == 0) {
                return F(coordinatorLayout, view, view2, view3, i3);
            }
            return false;
        }

        public void I(CoordinatorLayout coordinatorLayout, View view, View view2, int i3) {
            if (i3 == 0) {
                H(coordinatorLayout, view, view2);
            }
        }

        public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean g(CoordinatorLayout coordinatorLayout, View view) {
            return j(coordinatorLayout, view) > 0.0f;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int i(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float j(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean r(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return false;
        }

        public boolean s(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int i6) {
            return false;
        }

        public boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, float f3, float f4, boolean z2) {
            return false;
        }

        public boolean u(CoordinatorLayout coordinatorLayout, View view, View view2, float f3, float f4) {
            return false;
        }

        public void w(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr, int i5) {
            if (i5 == 0) {
                v(coordinatorLayout, view, view2, i3, i4, iArr);
            }
        }

        public void y(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7) {
            if (i7 == 0) {
                x(coordinatorLayout, view, view2, i3, i4, i5, i6);
            }
        }

        public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            iArr[0] = iArr[0] + i5;
            iArr[1] = iArr[1] + i6;
            y(coordinatorLayout, view, view2, i3, i4, i5, i6, i7);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void p() {
        }

        public void m(LayoutParams layoutParams) {
        }

        public void D(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public void H(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public WindowInsetsCompat l(CoordinatorLayout coordinatorLayout, View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void o(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3) {
        }

        public void v(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr) {
        }

        public void x(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface DefaultBehavior {
        Class value();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DispatchChangeEvent {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f33458s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.L(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f33458s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.L(0);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fL = ViewCompat.L(view);
            float fL2 = ViewCompat.L(view2);
            if (fL > fL2) {
                return -1;
            }
            return fL < fL2 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f33436v = r02 != null ? r02.getName() : null;
        f33439y = new ViewElevationComparator();
        f33437w = new Class[]{Context.class, AttributeSet.class};
        f33438x = new ThreadLocal();
        f33440z = new Pools.SynchronizedPool(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f33418a);
    }

    private int A(int i3) {
        int[] iArr = this.f33450k;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i3);
            return 0;
        }
        if (i3 >= 0 && i3 < iArr.length) {
            return iArr[i3];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i3 + " out of range for " + this);
        return 0;
    }

    private void D(List list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        Comparator comparator = f33439y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean E(View view) {
        return this.f33442b.j(view);
    }

    private void G(View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rectE = e();
        rectE.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        if (this.f33455p != null && ViewCompat.v(this) && !ViewCompat.v(view)) {
            rectE.left += this.f33455p.k();
            rectE.top += this.f33455p.m();
            rectE.right -= this.f33455p.l();
            rectE.bottom -= this.f33455p.j();
        }
        Rect rectE2 = e();
        GravityCompat.a(W(layoutParams.f33465c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectE, rectE2, i3);
        view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
        S(rectE);
        S(rectE2);
    }

    private void H(View view, View view2, int i3) {
        Rect rectE = e();
        Rect rectE2 = e();
        try {
            x(view2, rectE);
            y(view, i3, rectE, rectE2);
            view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
        } finally {
            S(rectE);
            S(rectE2);
        }
    }

    private void I(View view, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iB = GravityCompat.b(X(layoutParams.f33465c), i4);
        int i5 = iB & 7;
        int i6 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i4 == 1) {
            i3 = width - i3;
        }
        int iA = A(i3) - measuredWidth;
        if (i5 == 1) {
            iA += measuredWidth / 2;
        } else if (i5 == 5) {
            iA += measuredWidth;
        }
        int i7 = i6 != 16 ? i6 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(iA, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(i7, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private void J(View view, Rect rect, int i3) {
        boolean z2;
        boolean z3;
        int width;
        int i4;
        int i5;
        int i6;
        int height;
        int i7;
        int i8;
        int i9;
        if (ViewCompat.R(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behaviorF = layoutParams.f();
            Rect rectE = e();
            Rect rectE2 = e();
            rectE2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behaviorF == null || !behaviorF.h(this, view, rectE)) {
                rectE.set(rectE2);
            } else if (!rectE2.contains(rectE)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectE.toShortString() + " | Bounds:" + rectE2.toShortString());
            }
            S(rectE2);
            if (rectE.isEmpty()) {
                S(rectE);
                return;
            }
            int iB = GravityCompat.b(layoutParams.f33470h, i3);
            boolean z4 = true;
            if ((iB & 48) != 48 || (i8 = (rectE.top - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - layoutParams.f33472j) >= (i9 = rect.top)) {
                z2 = false;
            } else {
                Z(view, i9 - i8);
                z2 = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectE.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + layoutParams.f33472j) < (i7 = rect.bottom)) {
                Z(view, height - i7);
                z2 = true;
            }
            if (!z2) {
                Z(view, 0);
            }
            if ((iB & 3) != 3 || (i5 = (rectE.left - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - layoutParams.f33471i) >= (i6 = rect.left)) {
                z3 = false;
            } else {
                Y(view, i6 - i5);
                z3 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectE.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + layoutParams.f33471i) >= (i4 = rect.right)) {
                z4 = z3;
            } else {
                Y(view, width - i4);
            }
            if (!z4) {
                Y(view, 0);
            }
            S(rectE);
        }
    }

    static Behavior O(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f33436v;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = f33438x;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f33437w);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(context, attributeSet);
        } catch (Exception e3) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e3);
        }
    }

    private boolean P(MotionEvent motionEvent, int i3) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f33443c;
        D(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zQ = false;
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) list.get(i4);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behaviorF = layoutParams.f();
            if (!(zQ || z2) || actionMasked == 0) {
                if (!zQ && behaviorF != null) {
                    if (i3 == 0) {
                        zQ = behaviorF.q(this, view, motionEvent);
                    } else if (i3 == 1) {
                        zQ = behaviorF.J(this, view, motionEvent);
                    }
                    if (zQ) {
                        this.f33451l = view;
                    }
                }
                boolean zC = layoutParams.c();
                boolean zI = layoutParams.i(this, view);
                z2 = zI && !zC;
                if (zI && !z2) {
                    break;
                }
            } else if (behaviorF != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i3 == 0) {
                    behaviorF.q(this, view, motionEventObtain);
                } else if (i3 == 1) {
                    behaviorF.J(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zQ;
    }

    private void Q() {
        this.f33441a.clear();
        this.f33442b.c();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParamsC = C(childAt);
            layoutParamsC.d(this, childAt);
            this.f33442b.b(childAt);
            for (int i4 = 0; i4 < childCount; i4++) {
                if (i4 != i3) {
                    View childAt2 = getChildAt(i4);
                    if (layoutParamsC.b(this, childAt, childAt2)) {
                        if (!this.f33442b.d(childAt2)) {
                            this.f33442b.b(childAt2);
                        }
                        this.f33442b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f33441a.addAll(this.f33442b.i());
        Collections.reverse(this.f33441a);
    }

    private static void S(Rect rect) {
        rect.setEmpty();
        f33440z.b(rect);
    }

    private void U(boolean z2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Behavior behaviorF = ((LayoutParams) childAt.getLayoutParams()).f();
            if (behaviorF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    behaviorF.q(this, childAt, motionEventObtain);
                } else {
                    behaviorF.J(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            ((LayoutParams) getChildAt(i4).getLayoutParams()).m();
        }
        this.f33451l = null;
        this.f33448i = false;
    }

    private static int V(int i3) {
        if (i3 == 0) {
            return 17;
        }
        return i3;
    }

    private static int W(int i3) {
        if ((i3 & 7) == 0) {
            i3 |= 8388611;
        }
        return (i3 & 112) == 0 ? i3 | 48 : i3;
    }

    private static int X(int i3) {
        if (i3 == 0) {
            return 8388661;
        }
        return i3;
    }

    private void Y(View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.f33471i;
        if (i4 != i3) {
            ViewCompat.W(view, i3 - i4);
            layoutParams.f33471i = i3;
        }
    }

    private void Z(View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.f33472j;
        if (i4 != i3) {
            ViewCompat.X(view, i3 - i4);
            layoutParams.f33472j = i3;
        }
    }

    private void b0() {
        if (!ViewCompat.v(this)) {
            ViewCompat.C0(this, null);
            return;
        }
        if (this.f33459t == null) {
            this.f33459t = new OnApplyWindowInsetsListener() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                    return CoordinatorLayout.this.a0(windowInsetsCompat);
                }
            };
        }
        ViewCompat.C0(this, this.f33459t);
        setSystemUiVisibility(1280);
    }

    private static Rect e() {
        Rect rect = (Rect) f33440z.a();
        return rect == null ? new Rect() : rect;
    }

    private static int g(int i3, int i4, int i5) {
        return i3 < i4 ? i4 : i3 > i5 ? i5 : i3;
    }

    private void h(LayoutParams layoutParams, Rect rect, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i3) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i4) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        rect.set(iMax, iMax2, i3 + iMax, i4 + iMax2);
    }

    private WindowInsetsCompat i(WindowInsetsCompat windowInsetsCompat) {
        Behavior behaviorF;
        if (windowInsetsCompat.r()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (ViewCompat.v(childAt) && (behaviorF = ((LayoutParams) childAt.getLayoutParams()).f()) != null) {
                windowInsetsCompat = behaviorF.l(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.r()) {
                    return windowInsetsCompat;
                }
            }
        }
        return windowInsetsCompat;
    }

    private void z(View view, int i3, Rect rect, Rect rect2, LayoutParams layoutParams, int i4, int i5) {
        int iB = GravityCompat.b(V(layoutParams.f33465c), i3);
        int iB2 = GravityCompat.b(W(layoutParams.f33466d), i3);
        int i6 = iB & 7;
        int i7 = iB & 112;
        int i8 = iB2 & 7;
        int i9 = iB2 & 112;
        int iWidth = i8 != 1 ? i8 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i9 != 16 ? i9 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i6 == 1) {
            iWidth -= i4 / 2;
        } else if (i6 != 5) {
            iWidth -= i4;
        }
        if (i7 == 16) {
            iHeight -= i5 / 2;
        } else if (i7 != 80) {
            iHeight -= i5;
        }
        rect2.set(iWidth, iHeight, i4 + iWidth, i5 + iHeight);
    }

    void B(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    LayoutParams C(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f33464b) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                layoutParams.o(behavior);
                layoutParams.f33464b = true;
                return layoutParams;
            }
            DefaultBehavior defaultBehavior = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                defaultBehavior = (DefaultBehavior) superclass.getAnnotation(DefaultBehavior.class);
                if (defaultBehavior != null) {
                    break;
                }
            }
            if (defaultBehavior != null) {
                try {
                    layoutParams.o((Behavior) defaultBehavior.value().getDeclaredConstructor(null).newInstance(null));
                } catch (Exception e3) {
                    Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e3);
                }
            }
            layoutParams.f33464b = true;
        }
        return layoutParams;
    }

    public boolean F(View view, int i3, int i4) {
        Rect rectE = e();
        x(view, rectE);
        try {
            return rectE.contains(i3, i4);
        } finally {
            S(rectE);
        }
    }

    void K(View view, int i3) {
        Behavior behaviorF;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f33473k != null) {
            Rect rectE = e();
            Rect rectE2 = e();
            Rect rectE3 = e();
            x(layoutParams.f33473k, rectE);
            u(view, false, rectE2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            z(view, i3, rectE, rectE3, layoutParams, measuredWidth, measuredHeight);
            boolean z2 = (rectE3.left == rectE2.left && rectE3.top == rectE2.top) ? false : true;
            h(layoutParams, rectE3, measuredWidth, measuredHeight);
            int i4 = rectE3.left - rectE2.left;
            int i5 = rectE3.top - rectE2.top;
            if (i4 != 0) {
                ViewCompat.W(view, i4);
            }
            if (i5 != 0) {
                ViewCompat.X(view, i5);
            }
            if (z2 && (behaviorF = layoutParams.f()) != null) {
                behaviorF.n(this, view, layoutParams.f33473k);
            }
            S(rectE);
            S(rectE2);
            S(rectE3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void L(int r18) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.L(int):void");
    }

    public void M(View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = layoutParams.f33473k;
        if (view2 != null) {
            H(view, view2, i3);
            return;
        }
        int i4 = layoutParams.f33467e;
        if (i4 >= 0) {
            I(view, i4, i3);
        } else {
            G(view, i3);
        }
    }

    public void N(View view, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    void R(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).q(rect);
    }

    void T() {
        if (this.f33449j && this.f33453n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f33453n);
        }
        this.f33454o = false;
    }

    final WindowInsetsCompat a0(WindowInsetsCompat windowInsetsCompat) {
        if (ObjectsCompat.a(this.f33455p, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.f33455p = windowInsetsCompat;
        boolean z2 = false;
        boolean z3 = windowInsetsCompat != null && windowInsetsCompat.m() > 0;
        this.f33456q = z3;
        if (!z3 && getBackground() == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        WindowInsetsCompat windowInsetsCompatI = i(windowInsetsCompat);
        requestLayout();
        return windowInsetsCompatI;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean drawChild(android.graphics.Canvas r17, android.view.View r18, long r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r2 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r2
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r3 = r2.f33463a
            if (r3 == 0) goto L8f
            float r3 = r3.j(r0, r1)
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L8f
            android.graphics.Paint r4 = r0.f33445f
            if (r4 != 0) goto L22
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r0.f33445f = r4
        L22:
            android.graphics.Paint r4 = r0.f33445f
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r2 = r2.f33463a
            int r2 = r2.i(r0, r1)
            r4.setColor(r2)
            android.graphics.Paint r2 = r0.f33445f
            r4 = 1132396544(0x437f0000, float:255.0)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            r4 = 0
            r5 = 255(0xff, float:3.57E-43)
            int r3 = g(r3, r4, r5)
            r2.setAlpha(r3)
            int r2 = r17.save()
            boolean r3 = r1.isOpaque()
            if (r3 == 0) goto L65
            int r3 = r1.getLeft()
            float r5 = (float) r3
            int r3 = r1.getTop()
            float r6 = (float) r3
            int r3 = r1.getRight()
            float r7 = (float) r3
            int r3 = r1.getBottom()
            float r8 = (float) r3
            android.graphics.Region$Op r9 = android.graphics.Region.Op.DIFFERENCE
            r4 = r17
            r4.clipRect(r5, r6, r7, r8, r9)
        L65:
            int r3 = r0.getPaddingLeft()
            float r11 = (float) r3
            int r3 = r0.getPaddingTop()
            float r12 = (float) r3
            int r3 = r0.getWidth()
            int r4 = r0.getPaddingRight()
            int r3 = r3 - r4
            float r13 = (float) r3
            int r3 = r0.getHeight()
            int r4 = r0.getPaddingBottom()
            int r3 = r3 - r4
            float r14 = (float) r3
            android.graphics.Paint r15 = r0.f33445f
            r10 = r17
            r10.drawRect(r11, r12, r13, r14, r15)
            r4 = r10
            r4.restoreToCount(r2)
            goto L91
        L8f:
            r4 = r17
        L91:
            boolean r1 = super.drawChild(r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f33457r;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    void f() {
        if (this.f33449j) {
            if (this.f33453n == null) {
                this.f33453n = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f33453n);
        }
        this.f33454o = true;
    }

    final List<View> getDependencySortedChildren() {
        Q();
        return Collections.unmodifiableList(this.f33441a);
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f33455p;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f33460u.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f33457r;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void j(View view, View view2, int i3, int i4) {
        Behavior behaviorF;
        View view3;
        View view4;
        int i5;
        int i6;
        this.f33460u.c(view, view2, i3, i4);
        this.f33452m = view2;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.j(i4) && (behaviorF = layoutParams.f()) != null) {
                view3 = view;
                view4 = view2;
                i5 = i3;
                i6 = i4;
                behaviorF.B(this, childAt, view3, view4, i5, i6);
            } else {
                view3 = view;
                view4 = view2;
                i5 = i3;
                i6 = i4;
            }
            i7++;
            view = view3;
            view2 = view4;
            i3 = i5;
            i4 = i6;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void k(View view, int i3) {
        this.f33460u.e(view, i3);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.j(i3)) {
                Behavior behaviorF = layoutParams.f();
                if (behaviorF != null) {
                    behaviorF.I(this, childAt, view, i3);
                }
                layoutParams.l(i3);
                layoutParams.k();
            }
        }
        this.f33452m = null;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void l(View view, int i3, int i4, int[] iArr, int i5) {
        Behavior behaviorF;
        int childCount = getChildCount();
        boolean z2 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(i5) && (behaviorF = layoutParams.f()) != null) {
                    int[] iArr2 = this.f33446g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorF.w(this, childAt, view, i3, i4, iArr2, i5);
                    int[] iArr3 = this.f33446g;
                    iMax = i3 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f33446g;
                    iMax2 = i4 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z2) {
            L(1);
        }
    }

    public void m(View view) {
        List listG = this.f33442b.g(view);
        if (listG == null || listG.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < listG.size(); i3++) {
            View view2 = (View) listG.get(i3);
            Behavior behaviorF = ((LayoutParams) view2.getLayoutParams()).f();
            if (behaviorF != null) {
                behaviorF.n(this, view2, view);
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void n(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        Behavior behaviorF;
        int childCount = getChildCount();
        boolean z2 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(i7) && (behaviorF = layoutParams.f()) != null) {
                    int[] iArr2 = this.f33446g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorF.z(this, childAt, view, i3, i4, i5, i6, i7, iArr2);
                    int[] iArr3 = this.f33446g;
                    iMax = i5 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f33446g;
                    iMax2 = i6 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z2) {
            L(1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void o(View view, int i3, int i4, int i5, int i6, int i7) {
        n(view, i3, i4, i5, i6, 0, this.f33447h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        U(false);
        if (this.f33454o) {
            if (this.f33453n == null) {
                this.f33453n = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f33453n);
        }
        if (this.f33455p == null && ViewCompat.v(this)) {
            ViewCompat.j0(this);
        }
        this.f33449j = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        U(false);
        if (this.f33454o && this.f33453n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f33453n);
        }
        View view = this.f33452m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f33449j = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f33456q || this.f33457r == null) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.f33455p;
        int iM = windowInsetsCompat != null ? windowInsetsCompat.m() : 0;
        if (iM > 0) {
            this.f33457r.setBounds(0, 0, getWidth(), iM);
            this.f33457r.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            U(true);
        }
        boolean zP = P(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zP;
        }
        U(true);
        return zP;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        Behavior behaviorF;
        int iY = ViewCompat.y(this);
        int size = this.f33441a.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) this.f33441a.get(i7);
            if (view.getVisibility() != 8 && ((behaviorF = ((LayoutParams) view.getLayoutParams()).f()) == null || !behaviorF.r(this, view, iY))) {
                M(view, iY);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onNestedFling(android.view.View r12, float r13, float r14, boolean r15) {
        /*
            r11 = this;
            int r0 = r11.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L3f
            android.view.View r6 = r11.getChildAt(r2)
            int r4 = r6.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1b
        L15:
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r10 = r15
            goto L38
        L1b:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r4
            boolean r5 = r4.j(r1)
            if (r5 != 0) goto L28
            goto L15
        L28:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r4 = r4.f()
            if (r4 == 0) goto L15
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r10 = r15
            boolean r12 = r4.t(r5, r6, r7, r8, r9, r10)
            r3 = r3 | r12
        L38:
            int r2 = r2 + 1
            r12 = r7
            r13 = r8
            r14 = r9
            r15 = r10
            goto L7
        L3f:
            r5 = r11
            if (r3 == 0) goto L46
            r12 = 1
            r11.L(r12)
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onNestedFling(android.view.View, float, float, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onNestedPreFling(android.view.View r11, float r12, float r13) {
        /*
            r10 = this;
            int r0 = r10.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L3b
            android.view.View r6 = r10.getChildAt(r2)
            int r4 = r6.getVisibility()
            r5 = 8
            if (r4 != r5) goto L19
        L15:
            r7 = r11
            r8 = r12
            r9 = r13
            goto L35
        L19:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r4
            boolean r5 = r4.j(r1)
            if (r5 != 0) goto L26
            goto L15
        L26:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r4 = r4.f()
            if (r4 == 0) goto L15
            r5 = r10
            r7 = r11
            r8 = r12
            r9 = r13
            boolean r11 = r4.u(r5, r6, r7, r8, r9)
            r3 = r3 | r11
        L35:
            int r2 = r2 + 1
            r11 = r7
            r12 = r8
            r13 = r9
            goto L7
        L3b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onNestedPreFling(android.view.View, float, float):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        l(view, i3, i4, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        o(view, i3, i4, i5, i6, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        j(view, view2, i3, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        SparseArray sparseArray = savedState.f33482c;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            Behavior behaviorF = C(childAt).f();
            if (id != -1 && behaviorF != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                behaviorF.D(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableE;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            Behavior behaviorF = ((LayoutParams) childAt.getLayoutParams()).f();
            if (id != -1 && behaviorF != null && (parcelableE = behaviorF.E(this, childAt)) != null) {
                sparseArray.append(id, parcelableE);
            }
        }
        savedState.f33482c = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return p(view, view2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        k(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0024, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.f33451l
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.P(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2c
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f33451l
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f33451l
            boolean r6 = r6.J(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f33451l
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L56
            r1 = 3
            if (r2 != r1) goto L55
            goto L56
        L55:
            return r6
        L56:
            r0.U(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean p(View view, View view2, int i3, int i4) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behaviorF = layoutParams.f();
                if (behaviorF != null) {
                    boolean zG = behaviorF.G(this, childAt, view, view2, i3, i4);
                    z2 |= zG;
                    layoutParams.r(i4, zG);
                } else {
                    layoutParams.r(i4, false);
                }
            }
        }
        return z2;
    }

    void q() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            if (E(getChildAt(i3))) {
                z2 = true;
                break;
            }
            i3++;
        }
        if (z2 != this.f33454o) {
            if (z2) {
                f();
            } else {
                T();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        Behavior behaviorF = ((LayoutParams) view.getLayoutParams()).f();
        if (behaviorF == null || !behaviorF.C(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (!z2 || this.f33448i) {
            return;
        }
        U(false);
        this.f33448i = true;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        b0();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f33458s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f33457r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f33457r = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f33457r.setState(getDrawableState());
                }
                DrawableCompat.m(this.f33457r, ViewCompat.y(this));
                this.f33457r.setVisible(getVisibility() == 0, false);
                this.f33457r.setCallback(this);
            }
            ViewCompat.d0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i3) {
        setStatusBarBackground(new ColorDrawable(i3));
    }

    public void setStatusBarBackgroundResource(int i3) {
        setStatusBarBackground(i3 != 0 ? ContextCompat.getDrawable(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z2 = i3 == 0;
        Drawable drawable = this.f33457r;
        if (drawable == null || drawable.isVisible() == z2) {
            return;
        }
        this.f33457r.setVisible(z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    void u(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            x(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List v(View view) {
        List listH = this.f33442b.h(view);
        this.f33444d.clear();
        if (listH != null) {
            this.f33444d.addAll(listH);
        }
        return this.f33444d;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f33457r;
    }

    public List w(View view) {
        List listG = this.f33442b.g(view);
        this.f33444d.clear();
        if (listG != null) {
            this.f33444d.addAll(listG);
        }
        return this.f33444d;
    }

    void x(View view, Rect rect) {
        ViewGroupUtils.a(this, view, rect);
    }

    void y(View view, int i3, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        z(view, i3, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        h(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i3) {
        CoordinatorLayout coordinatorLayout;
        Context context2;
        super(context, attributeSet, i3);
        this.f33441a = new ArrayList();
        this.f33442b = new DirectedAcyclicGraph();
        this.f33443c = new ArrayList();
        this.f33444d = new ArrayList();
        this.f33446g = new int[2];
        this.f33447h = new int[2];
        this.f33460u = new NestedScrollingParentHelper(this);
        TypedArray typedArrayObtainStyledAttributes = i3 == 0 ? context.obtainStyledAttributes(attributeSet, R.styleable.f33421b, 0, R.style.f33419a) : context.obtainStyledAttributes(attributeSet, R.styleable.f33421b, i3, 0);
        if (Build.VERSION.SDK_INT < 29) {
            coordinatorLayout = this;
            context2 = context;
        } else if (i3 == 0) {
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, R.styleable.f33421b, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.f33419a);
        } else {
            context2 = context;
            coordinatorLayout = this;
            coordinatorLayout.saveAttributeDataForStyleable(context2, R.styleable.f33421b, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.f33422c, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            coordinatorLayout.f33450k = resources.getIntArray(resourceId);
            float f3 = resources.getDisplayMetrics().density;
            int length = coordinatorLayout.f33450k.length;
            for (int i4 = 0; i4 < length; i4++) {
                coordinatorLayout.f33450k[i4] = (int) (r12[i4] * f3);
            }
        }
        coordinatorLayout.f33457r = typedArrayObtainStyledAttributes.getDrawable(R.styleable.f33423d);
        typedArrayObtainStyledAttributes.recycle();
        b0();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        if (ViewCompat.w(this) == 0) {
            ViewCompat.w0(this, 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState.1
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
        SparseArray f33482c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i3 = parcel.readInt();
            int[] iArr = new int[i3];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f33482c = new SparseArray(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                this.f33482c.append(iArr[i4], parcelableArray[i4]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            SparseArray sparseArray = this.f33482c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i4 = 0; i4 < size; i4++) {
                iArr[i4] = this.f33482c.keyAt(i4);
                parcelableArr[i4] = (Parcelable) this.f33482c.valueAt(i4);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i3);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Behavior f33463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f33464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f33465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f33466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f33467e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f33468f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f33469g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f33470h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f33471i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33472j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        View f33473k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        View f33474l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f33475m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f33476n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f33477o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f33478p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final Rect f33479q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Object f33480r;

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f33464b = false;
            this.f33465c = 0;
            this.f33466d = 0;
            this.f33467e = -1;
            this.f33468f = -1;
            this.f33469g = 0;
            this.f33470h = 0;
            this.f33479q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f33468f);
            this.f33473k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f33474l = null;
                    this.f33473k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f33468f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f33474l = null;
                this.f33473k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f33474l = null;
                    this.f33473k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f33474l = viewFindViewById;
        }

        private boolean s(View view, int i3) {
            int iB = GravityCompat.b(((LayoutParams) view.getLayoutParams()).f33469g, i3);
            return iB != 0 && (GravityCompat.b(this.f33470h, i3) & iB) == iB;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f33473k.getId() != this.f33468f) {
                return false;
            }
            View view2 = this.f33473k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f33474l = null;
                    this.f33473k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f33474l = view2;
            return true;
        }

        boolean a() {
            return this.f33473k == null && this.f33468f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 == this.f33474l || s(view2, ViewCompat.y(coordinatorLayout))) {
                return true;
            }
            Behavior behavior = this.f33463a;
            return behavior != null && behavior.k(coordinatorLayout, view, view2);
        }

        boolean c() {
            if (this.f33463a == null) {
                this.f33475m = false;
            }
            return this.f33475m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f33468f == -1) {
                this.f33474l = null;
                this.f33473k = null;
                return null;
            }
            if (this.f33473k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f33473k;
        }

        public int e() {
            return this.f33468f;
        }

        public Behavior f() {
            return this.f33463a;
        }

        boolean g() {
            return this.f33478p;
        }

        Rect h() {
            return this.f33479q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z2 = this.f33475m;
            if (z2) {
                return true;
            }
            Behavior behavior = this.f33463a;
            boolean zG = (behavior != null ? behavior.g(coordinatorLayout, view) : false) | z2;
            this.f33475m = zG;
            return zG;
        }

        boolean j(int i3) {
            if (i3 == 0) {
                return this.f33476n;
            }
            if (i3 != 1) {
                return false;
            }
            return this.f33477o;
        }

        void k() {
            this.f33478p = false;
        }

        void l(int i3) {
            r(i3, false);
        }

        void m() {
            this.f33475m = false;
        }

        public void o(Behavior behavior) {
            Behavior behavior2 = this.f33463a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.p();
                }
                this.f33463a = behavior;
                this.f33480r = null;
                this.f33464b = true;
                if (behavior != null) {
                    behavior.m(this);
                }
            }
        }

        void p(boolean z2) {
            this.f33478p = z2;
        }

        void q(Rect rect) {
            this.f33479q.set(rect);
        }

        void r(int i3, boolean z2) {
            if (i3 == 0) {
                this.f33476n = z2;
            } else {
                if (i3 != 1) {
                    return;
                }
                this.f33477o = z2;
            }
        }

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f33464b = false;
            this.f33465c = 0;
            this.f33466d = 0;
            this.f33467e = -1;
            this.f33468f = -1;
            this.f33469g = 0;
            this.f33470h = 0;
            this.f33479q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f33424e);
            this.f33465c = typedArrayObtainStyledAttributes.getInteger(R.styleable.f33425f, 0);
            this.f33468f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.f33426g, -1);
            this.f33466d = typedArrayObtainStyledAttributes.getInteger(R.styleable.f33427h, 0);
            this.f33467e = typedArrayObtainStyledAttributes.getInteger(R.styleable.f33431l, -1);
            this.f33469g = typedArrayObtainStyledAttributes.getInt(R.styleable.f33430k, 0);
            this.f33470h = typedArrayObtainStyledAttributes.getInt(R.styleable.f33429j, 0);
            int i3 = R.styleable.f33428i;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i3);
            this.f33464b = zHasValue;
            if (zHasValue) {
                this.f33463a = CoordinatorLayout.O(context, attributeSet, typedArrayObtainStyledAttributes.getString(i3));
            }
            typedArrayObtainStyledAttributes.recycle();
            Behavior behavior = this.f33463a;
            if (behavior != null) {
                behavior.m(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f33464b = false;
            this.f33465c = 0;
            this.f33466d = 0;
            this.f33467e = -1;
            this.f33468f = -1;
            this.f33469g = 0;
            this.f33470h = 0;
            this.f33479q = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f33464b = false;
            this.f33465c = 0;
            this.f33466d = 0;
            this.f33467e = -1;
            this.f33468f = -1;
            this.f33469g = 0;
            this.f33470h = 0;
            this.f33479q = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f33464b = false;
            this.f33465c = 0;
            this.f33466d = 0;
            this.f33467e = -1;
            this.f33468f = -1;
            this.f33469g = 0;
            this.f33470h = 0;
            this.f33479q = new Rect();
        }
    }
}
