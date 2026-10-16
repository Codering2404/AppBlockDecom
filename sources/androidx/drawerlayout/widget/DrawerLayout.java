package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DrawerLayout extends ViewGroup implements Openable {
    private static final int[] M = {R.attr.colorPrimaryDark};
    static final int[] N = {R.attr.layout_gravity};
    static final boolean O;
    private static final boolean P;
    private static boolean Q;
    private CharSequence A;
    private CharSequence B;
    private Object C;
    private boolean D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private Drawable H;
    private final ArrayList I;
    private Rect J;
    private Matrix K;
    private final AccessibilityViewCommand L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ChildAccessibilityDelegate f36733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f36734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36736d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f36737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f36738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ViewDragHelper f36739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ViewDragHelper f36740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ViewDragCallback f36741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ViewDragCallback f36742k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f36743l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f36744m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f36745n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f36746o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f36747p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f36748q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f36749r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f36750s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private DrawerListener f36751t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List f36752u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f36753v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f36754w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Drawable f36755x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Drawable f36756y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f36757z;

    /* JADX INFO: renamed from: androidx.drawerlayout.widget.DrawerLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements AccessibilityViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DrawerLayout f36758a;

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            if (!this.f36758a.C(view) || this.f36758a.r(view) == 2) {
                return false;
            }
            this.f36758a.f(view);
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.drawerlayout.widget.DrawerLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements View.OnApplyWindowInsetsListener {
        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).R(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f36759d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ DrawerLayout f36760e;

        private void n(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (DrawerLayout.A(childAt)) {
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        private void o(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f36759d;
            accessibilityNodeInfoCompat2.l(rect);
            accessibilityNodeInfoCompat.e0(rect);
            accessibilityNodeInfoCompat.X0(accessibilityNodeInfoCompat2.U());
            accessibilityNodeInfoCompat.C0(accessibilityNodeInfoCompat2.w());
            accessibilityNodeInfoCompat.i0(accessibilityNodeInfoCompat2.o());
            accessibilityNodeInfoCompat.m0(accessibilityNodeInfoCompat2.r());
            accessibilityNodeInfoCompat.q0(accessibilityNodeInfoCompat2.J());
            accessibilityNodeInfoCompat.t0(accessibilityNodeInfoCompat2.L());
            accessibilityNodeInfoCompat.b0(accessibilityNodeInfoCompat2.E());
            accessibilityNodeInfoCompat.L0(accessibilityNodeInfoCompat2.R());
            accessibilityNodeInfoCompat.a(accessibilityNodeInfoCompat2.i());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewP = this.f36760e.p();
            if (viewP == null) {
                return true;
            }
            CharSequence charSequenceS = this.f36760e.s(this.f36760e.t(viewP));
            if (charSequenceS == null) {
                return true;
            }
            text.add(charSequenceS);
            return true;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.O) {
                super.g(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompatX = AccessibilityNodeInfoCompat.X(accessibilityNodeInfoCompat);
                super.g(view, accessibilityNodeInfoCompatX);
                accessibilityNodeInfoCompat.N0(view);
                Object objE = ViewCompat.E(view);
                if (objE instanceof View) {
                    accessibilityNodeInfoCompat.E0((View) objE);
                }
                o(accessibilityNodeInfoCompat, accessibilityNodeInfoCompatX);
                accessibilityNodeInfoCompatX.Z();
                n(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.i0("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfoCompat.s0(false);
            accessibilityNodeInfoCompat.t0(false);
            accessibilityNodeInfoCompat.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34568e);
            accessibilityNodeInfoCompat.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34569f);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.O || DrawerLayout.A(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            if (DrawerLayout.A(view)) {
                return;
            }
            accessibilityNodeInfoCompat.E0(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DrawerListener {
        void a(View view);

        void b(View view);

        void c(int i3);

        void d(View view, float f3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ViewDragCallback extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ViewDragHelper f36771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f36772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ DrawerLayout f36773d;

        /* JADX INFO: renamed from: androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewDragCallback f36774a;

            @Override // java.lang.Runnable
            public void run() {
                this.f36774a.o();
            }
        }

        private void n() {
            View viewN = this.f36773d.n(this.f36770a == 3 ? 5 : 3);
            if (viewN != null) {
                this.f36773d.f(viewN);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int a(View view, int i3, int i4) {
            if (this.f36773d.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i3, 0));
            }
            int width = this.f36773d.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i3, width));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int b(View view, int i3, int i4) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int d(View view) {
            if (this.f36773d.D(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void f(int i3, int i4) {
            View viewN = (i3 & 1) == 1 ? this.f36773d.n(3) : this.f36773d.n(5);
            if (viewN == null || this.f36773d.r(viewN) != 0) {
                return;
            }
            this.f36771b.c(viewN, i4);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean g(int i3) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void h(int i3, int i4) {
            this.f36773d.postDelayed(this.f36772c, 160L);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void i(View view, int i3) {
            ((LayoutParams) view.getLayoutParams()).f36763c = false;
            n();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void j(int i3) {
            this.f36773d.W(i3, this.f36771b.w());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void k(View view, int i3, int i4, int i5, int i6) {
            float width = (this.f36773d.c(view, 3) ? i3 + r3 : this.f36773d.getWidth() - i3) / view.getWidth();
            this.f36773d.T(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            this.f36773d.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void l(View view, float f3, float f4) {
            int i3;
            float fU = this.f36773d.u(view);
            int width = view.getWidth();
            if (this.f36773d.c(view, 3)) {
                i3 = (f3 > 0.0f || (f3 == 0.0f && fU > 0.5f)) ? 0 : -width;
            } else {
                int width2 = this.f36773d.getWidth();
                if (f3 < 0.0f || (f3 == 0.0f && fU > 0.5f)) {
                    width2 -= width;
                }
                i3 = width2;
            }
            this.f36771b.P(i3, view.getTop());
            this.f36773d.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean m(View view, int i3) {
            return this.f36773d.D(view) && this.f36773d.c(view, this.f36770a) && this.f36773d.r(view) == 0;
        }

        void o() {
            View viewN;
            int width;
            int iY = this.f36771b.y();
            boolean z2 = this.f36770a == 3;
            if (z2) {
                viewN = this.f36773d.n(3);
                width = (viewN != null ? -viewN.getWidth() : 0) + iY;
            } else {
                viewN = this.f36773d.n(5);
                width = this.f36773d.getWidth() - iY;
            }
            if (viewN != null) {
                if (((!z2 || viewN.getLeft() >= width) && (z2 || viewN.getLeft() <= width)) || this.f36773d.r(viewN) != 0) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) viewN.getLayoutParams();
                this.f36771b.R(viewN, width, viewN.getTop());
                layoutParams.f36763c = true;
                this.f36773d.invalidate();
                n();
                this.f36773d.b();
            }
        }

        public void p() {
            this.f36773d.removeCallbacks(this.f36772c);
        }
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        O = true;
        P = true;
        Q = i3 >= 29;
    }

    static boolean A(View view) {
        return (ViewCompat.w(view) == 4 || ViewCompat.w(view) == 2) ? false : true;
    }

    private boolean G(float f3, float f4, View view) {
        if (this.J == null) {
            this.J = new Rect();
        }
        view.getHitRect(this.J);
        return this.J.contains((int) f3, (int) f4);
    }

    private void H(Drawable drawable, int i3) {
        if (drawable == null || !DrawableCompat.h(drawable)) {
            return;
        }
        DrawableCompat.m(drawable, i3);
    }

    private Drawable O() {
        int iY = ViewCompat.y(this);
        if (iY == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                H(drawable, iY);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                H(drawable2, iY);
                return this.F;
            }
        }
        return this.G;
    }

    private Drawable P() {
        int iY = ViewCompat.y(this);
        if (iY == 0) {
            Drawable drawable = this.F;
            if (drawable != null) {
                H(drawable, iY);
                return this.F;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                H(drawable2, iY);
                return this.E;
            }
        }
        return this.H;
    }

    private void Q() {
        if (P) {
            return;
        }
        this.f36756y = O();
        this.f36757z = P();
    }

    private void U(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34588y;
        ViewCompat.g0(view, accessibilityActionCompat.b());
        if (!C(view) || r(view) == 2) {
            return;
        }
        ViewCompat.i0(view, accessibilityActionCompat, null, this.L);
    }

    private void V(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((z2 || D(childAt)) && !(z2 && childAt == view)) {
                ViewCompat.w0(childAt, 4);
            } else {
                ViewCompat.w0(childAt, 1);
            }
        }
    }

    private boolean m(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventV = v(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventV);
            motionEventV.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private MotionEvent v(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.K == null) {
                this.K = new Matrix();
            }
            matrix.invert(this.K);
            motionEventObtain.transform(this.K);
        }
        return motionEventObtain;
    }

    static String w(int i3) {
        return (i3 & 3) == 3 ? "LEFT" : (i3 & 5) == 5 ? "RIGHT" : Integer.toHexString(i3);
    }

    private static boolean x(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean y() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (((LayoutParams) getChildAt(i3).getLayoutParams()).f36763c) {
                return true;
            }
        }
        return false;
    }

    private boolean z() {
        return p() != null;
    }

    boolean B(View view) {
        return ((LayoutParams) view.getLayoutParams()).f36761a == 0;
    }

    public boolean C(View view) {
        if (D(view)) {
            return (((LayoutParams) view.getLayoutParams()).f36764d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean D(View view) {
        int iB = GravityCompat.b(((LayoutParams) view.getLayoutParams()).f36761a, ViewCompat.y(view));
        return ((iB & 3) == 0 && (iB & 5) == 0) ? false : true;
    }

    public boolean E(int i3) {
        View viewN = n(i3);
        if (viewN != null) {
            return F(viewN);
        }
        return false;
    }

    public boolean F(View view) {
        if (D(view)) {
            return ((LayoutParams) view.getLayoutParams()).f36762b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void I(View view, float f3) {
        float fU = u(view);
        float width = view.getWidth();
        int i3 = ((int) (width * f3)) - ((int) (fU * width));
        if (!c(view, 3)) {
            i3 = -i3;
        }
        view.offsetLeftAndRight(i3);
        T(view, f3);
    }

    public void J(int i3) {
        K(i3, true);
    }

    public void K(int i3, boolean z2) {
        View viewN = n(i3);
        if (viewN != null) {
            M(viewN, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i3));
    }

    public void L(View view) {
        M(view, true);
    }

    public void M(View view, boolean z2) {
        if (!D(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f36745n) {
            layoutParams.f36762b = 1.0f;
            layoutParams.f36764d = 1;
            V(view, true);
            U(view);
        } else if (z2) {
            layoutParams.f36764d |= 2;
            if (c(view, 3)) {
                this.f36739h.R(view, 0, view.getTop());
            } else {
                this.f36740i.R(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            I(view, 1.0f);
            W(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void N(DrawerListener drawerListener) {
        List list;
        if (drawerListener == null || (list = this.f36752u) == null) {
            return;
        }
        list.remove(drawerListener);
    }

    public void R(Object obj, boolean z2) {
        this.C = obj;
        this.D = z2;
        setWillNotDraw(!z2 && getBackground() == null);
        requestLayout();
    }

    public void S(int i3, int i4) {
        View viewN;
        int iB = GravityCompat.b(i4, ViewCompat.y(this));
        if (i4 == 3) {
            this.f36746o = i3;
        } else if (i4 == 5) {
            this.f36747p = i3;
        } else if (i4 == 8388611) {
            this.f36748q = i3;
        } else if (i4 == 8388613) {
            this.f36749r = i3;
        }
        if (i3 != 0) {
            (iB == 3 ? this.f36739h : this.f36740i).b();
        }
        if (i3 != 1) {
            if (i3 == 2 && (viewN = n(iB)) != null) {
                L(viewN);
                return;
            }
            return;
        }
        View viewN2 = n(iB);
        if (viewN2 != null) {
            f(viewN2);
        }
    }

    void T(View view, float f3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f3 == layoutParams.f36762b) {
            return;
        }
        layoutParams.f36762b = f3;
        l(view, f3);
    }

    void W(int i3, View view) {
        int i4;
        int iB = this.f36739h.B();
        int iB2 = this.f36740i.B();
        if (iB == 1 || iB2 == 1) {
            i4 = 1;
        } else {
            i4 = 2;
            if (iB != 2 && iB2 != 2) {
                i4 = 0;
            }
        }
        if (view != null && i3 == 0) {
            float f3 = ((LayoutParams) view.getLayoutParams()).f36762b;
            if (f3 == 0.0f) {
                j(view);
            } else if (f3 == 1.0f) {
                k(view);
            }
        }
        if (i4 != this.f36743l) {
            this.f36743l = i4;
            List list = this.f36752u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((DrawerListener) this.f36752u.get(size)).c(i4);
                }
            }
        }
    }

    public void a(DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (this.f36752u == null) {
            this.f36752u = new ArrayList();
        }
        this.f36752u.add(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i3, int i4) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (!D(childAt)) {
                this.I.add(childAt);
            } else if (C(childAt)) {
                childAt.addFocusables(arrayList, i3, i4);
                z2 = true;
            }
        }
        if (!z2) {
            int size = this.I.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = (View) this.I.get(i6);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i3, i4);
                }
            }
        }
        this.I.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (o() != null || D(view)) {
            ViewCompat.w0(view, 4);
        } else {
            ViewCompat.w0(view, 1);
        }
        if (O) {
            return;
        }
        ViewCompat.m0(view, this.f36733a);
    }

    void b() {
        if (this.f36750s) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.f36750s = true;
    }

    boolean c(View view, int i3) {
        return (t(view) & i3) == i3;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i3).getLayoutParams()).f36762b);
        }
        this.f36737f = fMax;
        boolean zN = this.f36739h.n(true);
        boolean zN2 = this.f36740i.n(true);
        if (zN || zN2) {
            ViewCompat.d0(this);
        }
    }

    public void d(int i3) {
        e(i3, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f36737f <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt = getChildAt(i3);
            if (G(x2, y2, childAt) && !B(childAt) && m(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        int height = getHeight();
        boolean zB = B(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i3 = 0;
        if (zB) {
            int childCount = getChildCount();
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != view && childAt.getVisibility() == 0 && x(childAt) && D(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i4) {
                            i4 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i4, 0, width, getHeight());
            i3 = i4;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j3);
        canvas.restoreToCount(iSave);
        float f3 = this.f36737f;
        if (f3 > 0.0f && zB) {
            this.f36738g.setColor((this.f36736d & 16777215) | (((int) ((((-16777216) & r14) >>> 24) * f3)) << 24));
            canvas.drawRect(i3, 0.0f, width, getHeight(), this.f36738g);
            return zDrawChild;
        }
        if (this.f36756y != null && c(view, 3)) {
            int intrinsicWidth = this.f36756y.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f36739h.y(), 1.0f));
            this.f36756y.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f36756y.setAlpha((int) (fMax * 255.0f));
            this.f36756y.draw(canvas);
            return zDrawChild;
        }
        if (this.f36757z != null && c(view, 5)) {
            int intrinsicWidth2 = this.f36757z.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f36740i.y(), 1.0f));
            this.f36757z.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f36757z.setAlpha((int) (fMax2 * 255.0f));
            this.f36757z.draw(canvas);
        }
        return zDrawChild;
    }

    public void e(int i3, boolean z2) {
        View viewN = n(i3);
        if (viewN != null) {
            g(viewN, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i3));
    }

    public void f(View view) {
        g(view, true);
    }

    public void g(View view, boolean z2) {
        if (!D(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f36745n) {
            layoutParams.f36762b = 0.0f;
            layoutParams.f36764d = 0;
        } else if (z2) {
            layoutParams.f36764d |= 4;
            if (c(view, 3)) {
                this.f36739h.R(view, -view.getWidth(), view.getTop());
            } else {
                this.f36740i.R(view, getWidth(), view.getTop());
            }
        } else {
            I(view, 0.0f);
            W(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (P) {
            return this.f36734b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f36755x;
    }

    public void h() {
        i(false);
    }

    void i(boolean z2) {
        int childCount = getChildCount();
        boolean zR = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (D(childAt) && (!z2 || layoutParams.f36763c)) {
                zR |= c(childAt, 3) ? this.f36739h.R(childAt, -childAt.getWidth(), childAt.getTop()) : this.f36740i.R(childAt, getWidth(), childAt.getTop());
                layoutParams.f36763c = false;
            }
        }
        this.f36741j.p();
        this.f36742k.p();
        if (zR) {
            invalidate();
        }
    }

    void j(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f36764d & 1) == 1) {
            layoutParams.f36764d = 0;
            List list = this.f36752u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((DrawerListener) this.f36752u.get(size)).b(view);
                }
            }
            V(view, false);
            U(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void k(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f36764d & 1) == 0) {
            layoutParams.f36764d = 1;
            List list = this.f36752u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((DrawerListener) this.f36752u.get(size)).a(view);
                }
            }
            V(view, true);
            U(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void l(View view, float f3) {
        List list = this.f36752u;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((DrawerListener) this.f36752u.get(size)).d(view, f3);
            }
        }
    }

    View n(int i3) {
        int iB = GravityCompat.b(i3, ViewCompat.y(this)) & 7;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if ((t(childAt) & 7) == iB) {
                return childAt;
            }
        }
        return null;
    }

    View o() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((((LayoutParams) childAt.getLayoutParams()).f36764d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f36745n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f36745n = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.D || this.f36755x == null) {
            return;
        }
        Object obj = this.C;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f36755x.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f36755x.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.f36739h
            boolean r1 = r1.Q(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.f36740i
            boolean r2 = r2.Q(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            androidx.customview.widget.ViewDragHelper r7 = r6.f36739h
            boolean r7 = r7.e(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.f36741j
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.f36742k
            r7.p()
            goto L36
        L31:
            r6.i(r2)
            r6.f36750s = r3
        L36:
            r7 = r3
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f36753v = r0
            r6.f36754w = r7
            float r4 = r6.f36737f
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            androidx.customview.widget.ViewDragHelper r4 = r6.f36739h
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.u(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.B(r7)
            if (r7 == 0) goto L5d
            r7 = r2
            goto L5e
        L5d:
            r7 = r3
        L5e:
            r6.f36750s = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.y()
            if (r7 != 0) goto L70
            boolean r7 = r6.f36750s
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            return r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 4 || !z()) {
            return super.onKeyDown(i3, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return super.onKeyUp(i3, keyEvent);
        }
        View viewP = p();
        if (viewP != null && r(viewP) == 0) {
            h();
        }
        return viewP != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        WindowInsets rootWindowInsets;
        float f3;
        int i7;
        boolean z3 = true;
        this.f36744m = true;
        int i8 = i5 - i3;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (B(childAt)) {
                    int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i10, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i10, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f4 = measuredWidth;
                        i7 = (-measuredWidth) + ((int) (layoutParams.f36762b * f4));
                        f3 = (measuredWidth + i7) / f4;
                    } else {
                        float f5 = measuredWidth;
                        f3 = (i8 - r11) / f5;
                        i7 = i8 - ((int) (layoutParams.f36762b * f5));
                    }
                    boolean z4 = f3 != layoutParams.f36762b ? z3 : false;
                    int i11 = layoutParams.f36761a & 112;
                    if (i11 == 16) {
                        int i12 = i6 - i4;
                        int i13 = (i12 - measuredHeight) / 2;
                        int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i13 < i14) {
                            i13 = i14;
                        } else {
                            int i15 = i13 + measuredHeight;
                            int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i15 > i12 - i16) {
                                i13 = (i12 - i16) - measuredHeight;
                            }
                        }
                        childAt.layout(i7, i13, measuredWidth + i7, measuredHeight + i13);
                    } else if (i11 != 80) {
                        int i17 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i7, i17, measuredWidth + i7, measuredHeight + i17);
                    } else {
                        int i18 = i6 - i4;
                        childAt.layout(i7, (i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z4) {
                        T(childAt, f3);
                    }
                    int i19 = layoutParams.f36762b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i19) {
                        childAt.setVisibility(i19);
                    }
                }
            }
            i9++;
            z3 = true;
        }
        if (Q && (rootWindowInsets = getRootWindowInsets()) != null) {
            Insets insetsI = WindowInsetsCompat.z(rootWindowInsets).i();
            ViewDragHelper viewDragHelper = this.f36739h;
            viewDragHelper.M(Math.max(viewDragHelper.x(), insetsI.f33964a));
            ViewDragHelper viewDragHelper2 = this.f36740i;
            viewDragHelper2.M(Math.max(viewDragHelper2.x(), insetsI.f33966c));
        }
        this.f36744m = false;
        this.f36745n = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z2 = this.C != null && ViewCompat.v(this);
        int iY = ViewCompat.y(this);
        int childCount = getChildCount();
        boolean z3 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z2) {
                    int iB = GravityCompat.b(layoutParams.f36761a, iY);
                    if (ViewCompat.v(childAt)) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.C;
                        if (iB == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (iB == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.C;
                        if (iB == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iB == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (B(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else {
                    if (!D(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (P) {
                        float fT = ViewCompat.t(childAt);
                        float f3 = this.f36734b;
                        if (fT != f3) {
                            ViewCompat.u0(childAt, f3);
                        }
                    }
                    int iT = t(childAt) & 7;
                    boolean z5 = iT == 3;
                    if ((z5 && z3) || (!z5 && z4)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + w(iT) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z5) {
                        z3 = true;
                    } else {
                        z4 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i3, this.f36735c + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i4, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewN;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        int i3 = savedState.f36765c;
        if (i3 != 0 && (viewN = n(i3)) != null) {
            L(viewN);
        }
        int i4 = savedState.f36766d;
        if (i4 != 3) {
            S(i4, 3);
        }
        int i5 = savedState.f36767f;
        if (i5 != 3) {
            S(i5, 5);
        }
        int i6 = savedState.f36768g;
        if (i6 != 3) {
            S(i6, 8388611);
        }
        int i7 = savedState.f36769h;
        if (i7 != 3) {
            S(i7, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        Q();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            int i4 = layoutParams.f36764d;
            boolean z2 = i4 == 1;
            boolean z3 = i4 == 2;
            if (z2 || z3) {
                savedState.f36765c = layoutParams.f36761a;
                break;
            }
        }
        savedState.f36766d = this.f36746o;
        savedState.f36767f = this.f36747p;
        savedState.f36768g = this.f36748q;
        savedState.f36769h = this.f36749r;
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.f36739h
            r0.G(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.f36740i
            r0.G(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5f
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6d
        L1a:
            r6.i(r2)
            r6.f36750s = r1
            goto L6d
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.f36739h
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.u(r4, r5)
            if (r3 == 0) goto L5a
            boolean r3 = r6.B(r3)
            if (r3 == 0) goto L5a
            float r3 = r6.f36753v
            float r0 = r0 - r3
            float r3 = r6.f36754w
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.f36739h
            int r3 = r3.A()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5a
            android.view.View r7 = r6.o()
            if (r7 == 0) goto L5a
            int r7 = r6.r(r7)
            r0 = 2
            if (r7 != r0) goto L5b
        L5a:
            r1 = r2
        L5b:
            r6.i(r1)
            goto L6d
        L5f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f36753v = r0
            r6.f36754w = r7
            r6.f36750s = r1
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    View p() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (D(childAt) && F(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int q(int i3) {
        int iY = ViewCompat.y(this);
        if (i3 == 3) {
            int i4 = this.f36746o;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iY == 0 ? this.f36748q : this.f36749r;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i3 == 5) {
            int i6 = this.f36747p;
            if (i6 != 3) {
                return i6;
            }
            int i7 = iY == 0 ? this.f36749r : this.f36748q;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i3 == 8388611) {
            int i8 = this.f36748q;
            if (i8 != 3) {
                return i8;
            }
            int i9 = iY == 0 ? this.f36746o : this.f36747p;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        }
        if (i3 != 8388613) {
            return 0;
        }
        int i10 = this.f36749r;
        if (i10 != 3) {
            return i10;
        }
        int i11 = iY == 0 ? this.f36747p : this.f36746o;
        if (i11 != 3) {
            return i11;
        }
        return 0;
    }

    public int r(View view) {
        if (D(view)) {
            return q(((LayoutParams) view.getLayoutParams()).f36761a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2) {
            i(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f36744m) {
            return;
        }
        super.requestLayout();
    }

    public CharSequence s(int i3) {
        int iB = GravityCompat.b(i3, ViewCompat.y(this));
        if (iB == 3) {
            return this.A;
        }
        if (iB == 5) {
            return this.B;
        }
        return null;
    }

    public void setDrawerElevation(float f3) {
        this.f36734b = f3;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (D(childAt)) {
                ViewCompat.u0(childAt, this.f36734b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.f36751t;
        if (drawerListener2 != null) {
            N(drawerListener2);
        }
        if (drawerListener != null) {
            a(drawerListener);
        }
        this.f36751t = drawerListener;
    }

    public void setDrawerLockMode(int i3) {
        S(i3, 3);
        S(i3, 5);
    }

    public void setScrimColor(int i3) {
        this.f36736d = i3;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f36755x = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i3) {
        this.f36755x = new ColorDrawable(i3);
        invalidate();
    }

    int t(View view) {
        return GravityCompat.b(((LayoutParams) view.getLayoutParams()).f36761a, ViewCompat.y(this));
    }

    float u(View view) {
        return ((LayoutParams) view.getLayoutParams()).f36762b;
    }

    public void setStatusBarBackground(int i3) {
        this.f36755x = i3 != 0 ? ContextCompat.getDrawable(getContext(), i3) : null;
        invalidate();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f36761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f36762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f36763c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f36764d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f36761a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.N);
            this.f36761a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f36761a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f36761a = 0;
            this.f36761a = layoutParams.f36761a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f36761a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f36761a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
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
        int f36765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f36766d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36768g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f36769h;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f36765c = 0;
            this.f36765c = parcel.readInt();
            this.f36766d = parcel.readInt();
            this.f36767f = parcel.readInt();
            this.f36768g = parcel.readInt();
            this.f36769h = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f36765c);
            parcel.writeInt(this.f36766d);
            parcel.writeInt(this.f36767f);
            parcel.writeInt(this.f36768g);
            parcel.writeInt(this.f36769h);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f36765c = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SimpleDrawerListener implements DrawerListener {
        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void a(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void b(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void c(int i3) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void d(View view, float f3) {
        }
    }
}
