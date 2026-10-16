package androidx.slidingpanelayout.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SlidingPaneLayout extends ViewGroup implements Openable {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static boolean f53120z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f53121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f53122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f53123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f53124d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f53125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f53126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f53127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f53128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f53129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f53130k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f53131l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f53132m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f53133n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List f53134o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private PanelSlideListener f53135p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final ViewDragHelper f53136q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f53137r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f53138s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Rect f53139t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final ArrayList f53140u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f53141v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    FoldingFeature f53142w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private FoldingFeatureObserver.OnFoldingFeatureChangeListener f53143x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private FoldingFeatureObserver f53144y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f53146d = new Rect();

        AccessibilityDelegate() {
        }

        private void n(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f53146d;
            accessibilityNodeInfoCompat2.l(rect);
            accessibilityNodeInfoCompat.e0(rect);
            accessibilityNodeInfoCompat.X0(accessibilityNodeInfoCompat2.U());
            accessibilityNodeInfoCompat.C0(accessibilityNodeInfoCompat2.w());
            accessibilityNodeInfoCompat.i0(accessibilityNodeInfoCompat2.o());
            accessibilityNodeInfoCompat.m0(accessibilityNodeInfoCompat2.r());
            accessibilityNodeInfoCompat.q0(accessibilityNodeInfoCompat2.J());
            accessibilityNodeInfoCompat.j0(accessibilityNodeInfoCompat2.H());
            accessibilityNodeInfoCompat.s0(accessibilityNodeInfoCompat2.K());
            accessibilityNodeInfoCompat.t0(accessibilityNodeInfoCompat2.L());
            accessibilityNodeInfoCompat.b0(accessibilityNodeInfoCompat2.E());
            accessibilityNodeInfoCompat.L0(accessibilityNodeInfoCompat2.R());
            accessibilityNodeInfoCompat.z0(accessibilityNodeInfoCompat2.O());
            accessibilityNodeInfoCompat.a(accessibilityNodeInfoCompat2.i());
            accessibilityNodeInfoCompat.B0(accessibilityNodeInfoCompat2.v());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatX = AccessibilityNodeInfoCompat.X(accessibilityNodeInfoCompat);
            super.g(view, accessibilityNodeInfoCompatX);
            n(accessibilityNodeInfoCompat, accessibilityNodeInfoCompatX);
            accessibilityNodeInfoCompatX.Z();
            accessibilityNodeInfoCompat.i0("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            accessibilityNodeInfoCompat.N0(view);
            Object objE = ViewCompat.E(view);
            if (objE instanceof View) {
                accessibilityNodeInfoCompat.E0((View) objE);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i3);
                if (!o(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.w0(childAt, 1);
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (o(view)) {
                return false;
            }
            return super.i(viewGroup, view, accessibilityEvent);
        }

        public boolean o(View view) {
            return SlidingPaneLayout.this.k(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DisableLayerRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f53148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SlidingPaneLayout f53149b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f53148a.getParent() == this.f53149b) {
                this.f53148a.setLayerType(0, null);
                this.f53149b.j(this.f53148a);
            }
            this.f53149b.f53140u.remove(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DragHelperCallback extends ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        private boolean n() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f53130k || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.m() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            return SlidingPaneLayout.this.m() || SlidingPaneLayout.this.getLockMode() != 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int a(View view, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f53126g.getLayoutParams();
            if (SlidingPaneLayout.this.l()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + SlidingPaneLayout.this.f53126g.getWidth());
                return Math.max(Math.min(i3, width), width - SlidingPaneLayout.this.f53129j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            return Math.min(Math.max(i3, paddingLeft), SlidingPaneLayout.this.f53129j + paddingLeft);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int b(View view, int i3, int i4) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int d(View view) {
            return SlidingPaneLayout.this.f53129j;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void f(int i3, int i4) {
            if (n()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f53136q.c(slidingPaneLayout.f53126g, i4);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void h(int i3, int i4) {
            if (n()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f53136q.c(slidingPaneLayout.f53126g, i4);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void i(View view, int i3) {
            SlidingPaneLayout.this.u();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void j(int i3) {
            if (SlidingPaneLayout.this.f53136q.B() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f53127h != 1.0f) {
                    slidingPaneLayout.e(slidingPaneLayout.f53126g);
                    SlidingPaneLayout.this.f53137r = true;
                } else {
                    slidingPaneLayout.x(slidingPaneLayout.f53126g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.d(slidingPaneLayout2.f53126g);
                    SlidingPaneLayout.this.f53137r = false;
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void k(View view, int i3, int i4, int i5, int i6) {
            SlidingPaneLayout.this.p(i3);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void l(View view, float f3, float f4) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.l()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f3 < 0.0f || (f3 == 0.0f && SlidingPaneLayout.this.f53127h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f53129j;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f53126g.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f3 > 0.0f || (f3 == 0.0f && SlidingPaneLayout.this.f53127h > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f53129j;
                }
            }
            SlidingPaneLayout.this.f53136q.P(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean m(View view, int i3) {
            if (n()) {
                return ((LayoutParams) view.getLayoutParams()).f53153b;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PanelSlideListener {
        void a(View view);

        void b(View view);

        void c(View view, float f3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f53156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f53157d;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f53156c ? 1 : 0);
            parcel.writeInt(this.f53157d);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f53156c = parcel.readInt() != 0;
            this.f53157d = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TouchBlocker extends FrameLayout {
        TouchBlocker(View view) {
            super(view.getContext());
            addView(view);
        }

        @Override // android.view.View
        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    static {
        f53120z = Build.VERSION.SDK_INT >= 29;
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    private boolean c(int i3) {
        if (!this.f53125f) {
            this.f53137r = false;
        }
        if (!this.f53138s && !v(1.0f, i3)) {
            return false;
        }
        this.f53137r = false;
        return true;
    }

    private static Activity g(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private Insets getSystemGestureInsets() {
        WindowInsetsCompat windowInsetsCompatF;
        if (!f53120z || (windowInsetsCompatF = ViewCompat.F(this)) == null) {
            return null;
        }
        return windowInsetsCompatF.i();
    }

    private static Rect h(FoldingFeature foldingFeature, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        Rect rect = new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getWidth());
        Rect rect2 = new Rect(foldingFeature.getBounds());
        boolean zIntersect = rect2.intersect(rect);
        if ((rect2.width() == 0 && rect2.height() == 0) || !zIntersect) {
            return null;
        }
        rect2.offset(-iArr[0], -iArr[1]);
        return rect2;
    }

    private static int i(View view) {
        return view instanceof TouchBlocker ? ViewCompat.A(((TouchBlocker) view).getChildAt(0)) : ViewCompat.A(view);
    }

    private static int o(View view, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return (((ViewGroup.MarginLayoutParams) layoutParams).width != 0 || layoutParams.f53152a <= 0.0f) ? View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824) : ViewGroup.getChildMeasureSpec(i3, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height);
    }

    private boolean r(int i3) {
        if (!this.f53125f) {
            this.f53137r = true;
        }
        if (!this.f53138s && !v(0.0f, i3)) {
            return false;
        }
        this.f53137r = true;
        return true;
    }

    private void s(float f3) {
        boolean zL = l();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != this.f53126g) {
                float f4 = 1.0f - this.f53128i;
                int i4 = this.f53131l;
                this.f53128i = f3;
                int i5 = ((int) (f4 * i4)) - ((int) ((1.0f - f3) * i4));
                if (zL) {
                    i5 = -i5;
                }
                childAt.offsetLeftAndRight(i5);
            }
        }
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver foldingFeatureObserver) {
        this.f53144y = foldingFeatureObserver;
        foldingFeatureObserver.f(this.f53143x);
    }

    private ArrayList w() {
        Rect rectH;
        FoldingFeature foldingFeature = this.f53142w;
        if (foldingFeature == null || !foldingFeature.a() || this.f53142w.getBounds().left == 0 || this.f53142w.getBounds().top != 0 || (rectH = h(this.f53142w, this)) == null) {
            return null;
        }
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), rectH.left), getHeight() - getPaddingBottom());
        int width = getWidth() - getPaddingRight();
        return new ArrayList(Arrays.asList(rect, new Rect(Math.min(width, rectH.right), getPaddingTop(), width, getHeight() - getPaddingBottom())));
    }

    private static boolean y(View view) {
        return view.isOpaque();
    }

    public void a(PanelSlideListener panelSlideListener) {
        this.f53134o.add(panelSlideListener);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new TouchBlocker(view), i3, layoutParams);
        } else {
            super.addView(view, i3, layoutParams);
        }
    }

    public boolean b() {
        return c(0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f53136q.n(true)) {
            if (this.f53125f) {
                ViewCompat.d0(this);
            } else {
                this.f53136q.a();
            }
        }
    }

    void d(View view) {
        Iterator it = this.f53134o.iterator();
        while (it.hasNext()) {
            ((PanelSlideListener) it.next()).b(view);
        }
        sendAccessibilityEvent(32);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        int right;
        super.draw(canvas);
        Drawable drawable = l() ? this.f53124d : this.f53123c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (l()) {
            right = childAt.getRight();
            i3 = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i4 = left - intrinsicWidth;
            i3 = left;
            right = i4;
        }
        drawable.setBounds(right, top, i3, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        if (l() ^ m()) {
            this.f53136q.N(1);
            Insets systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                ViewDragHelper viewDragHelper = this.f53136q;
                viewDragHelper.M(Math.max(viewDragHelper.x(), systemGestureInsets.f33964a));
            }
        } else {
            this.f53136q.N(2);
            Insets systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                ViewDragHelper viewDragHelper2 = this.f53136q;
                viewDragHelper2.M(Math.max(viewDragHelper2.x(), systemGestureInsets2.f33966c));
            }
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.f53125f && !layoutParams.f53153b && this.f53126g != null) {
            canvas.getClipBounds(this.f53139t);
            if (l()) {
                Rect rect = this.f53139t;
                rect.left = Math.max(rect.left, this.f53126g.getRight());
            } else {
                Rect rect2 = this.f53139t;
                rect2.right = Math.min(rect2.right, this.f53126g.getLeft());
            }
            canvas.clipRect(this.f53139t);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j3);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    void e(View view) {
        Iterator it = this.f53134o.iterator();
        while (it.hasNext()) {
            ((PanelSlideListener) it.next()).a(view);
        }
        sendAccessibilityEvent(32);
    }

    void f(View view) {
        Iterator it = this.f53134o.iterator();
        while (it.hasNext()) {
            ((PanelSlideListener) it.next()).c(view, this.f53127h);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.f53122b;
    }

    public final int getLockMode() {
        return this.f53141v;
    }

    public int getParallaxDistance() {
        return this.f53131l;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.f53121a;
    }

    void j(View view) {
        ViewCompat.A0(view, ((LayoutParams) view.getLayoutParams()).f53155d);
    }

    boolean k(View view) {
        if (view == null) {
            return false;
        }
        return this.f53125f && ((LayoutParams) view.getLayoutParams()).f53154c && this.f53127h > 0.0f;
    }

    boolean l() {
        return ViewCompat.y(this) == 1;
    }

    public boolean m() {
        return !this.f53125f || this.f53127h == 0.0f;
    }

    public boolean n() {
        return this.f53125f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Activity activityG;
        super.onAttachedToWindow();
        this.f53138s = true;
        if (this.f53144y == null || (activityG = g(getContext())) == null) {
            return;
        }
        this.f53144y.e(activityG);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f53138s = true;
        FoldingFeatureObserver foldingFeatureObserver = this.f53144y;
        if (foldingFeatureObserver != null) {
            foldingFeatureObserver.g();
        }
        int size = this.f53140u.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((DisableLayerRunnable) this.f53140u.get(i3)).run();
        }
        this.f53140u.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f53125f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f53137r = this.f53136q.F(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f53125f || (this.f53130k && actionMasked != 0)) {
            this.f53136q.b();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.f53136q.b();
            return false;
        }
        if (actionMasked == 0) {
            this.f53130k = false;
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.f53132m = x2;
            this.f53133n = y2;
            if (this.f53136q.F(this.f53126g, (int) x2, (int) y2) && k(this.f53126g)) {
                z2 = true;
            }
            return !this.f53136q.Q(motionEvent) || z2;
        }
        if (actionMasked == 2) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float fAbs = Math.abs(x3 - this.f53132m);
            float fAbs2 = Math.abs(y3 - this.f53133n);
            if (fAbs > this.f53136q.A() && fAbs2 > fAbs) {
                this.f53136q.b();
                this.f53130k = true;
                return false;
            }
        }
        z2 = false;
        if (this.f53136q.Q(motionEvent)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d9  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int paddingTop;
        int iMin;
        int i5;
        int iMax;
        int iMakeMeasureSpec;
        int i6;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (mode2 != Integer.MIN_VALUE) {
            iMin = mode2 != 1073741824 ? 0 : (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = iMin;
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            iMin = 0;
        }
        int iMax2 = Math.max((size - getPaddingLeft()) - getPaddingRight(), 0);
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f53126g = null;
        int i7 = 0;
        boolean z2 = false;
        int i8 = iMax2;
        float f3 = 0.0f;
        while (true) {
            i5 = 8;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i9 = iMax2;
            if (childAt.getVisibility() == 8) {
                layoutParams.f53154c = false;
            } else {
                float f4 = layoutParams.f53152a;
                if (f4 > 0.0f) {
                    f3 += f4;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                    i7 = i6 + 1;
                    iMax2 = i9;
                }
                int iMax3 = Math.max(i9 - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin), 0);
                int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                i6 = i7;
                childAt.measure(i10 == -2 ? View.MeasureSpec.makeMeasureSpec(iMax3, mode == 0 ? mode : Integer.MIN_VALUE) : i10 == -1 ? View.MeasureSpec.makeMeasureSpec(iMax3, mode) : View.MeasureSpec.makeMeasureSpec(i10, 1073741824), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > iMin) {
                    if (mode2 == Integer.MIN_VALUE) {
                        iMin = Math.min(measuredHeight, paddingTop);
                    } else if (mode2 == 0) {
                        iMin = measuredHeight;
                    }
                }
                i8 -= measuredWidth;
                if (i6 != 0) {
                    boolean z3 = i8 < 0;
                    layoutParams.f53153b = z3;
                    z2 |= z3;
                    if (z3) {
                        this.f53126g = childAt;
                    }
                }
                i7 = i6 + 1;
                iMax2 = i9;
            }
            i6 = i7;
            i7 = i6 + 1;
            iMax2 = i9;
        }
        int i11 = iMax2;
        if (z2 || f3 > 0.0f) {
            int i12 = 0;
            while (i12 < childCount) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getVisibility() != i5) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    int measuredWidth2 = (((ViewGroup.MarginLayoutParams) layoutParams2).width != 0 || layoutParams2.f53152a <= 0.0f) ? childAt2.getMeasuredWidth() : 0;
                    if (z2) {
                        iMax = i11 - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    } else if (layoutParams2.f53152a > 0.0f) {
                        iMax = ((int) ((layoutParams2.f53152a * Math.max(0, i8)) / f3)) + measuredWidth2;
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    } else {
                        iMax = measuredWidth2;
                        iMakeMeasureSpec = 0;
                    }
                    int iO = o(childAt2, i4, getPaddingTop() + getPaddingBottom());
                    if (measuredWidth2 != iMax) {
                        childAt2.measure(iMakeMeasureSpec, iO);
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        if (measuredHeight2 > iMin) {
                            if (mode2 == Integer.MIN_VALUE) {
                                iMin = Math.min(measuredHeight2, paddingTop);
                            } else if (mode2 == 0) {
                                iMin = measuredHeight2;
                            }
                        }
                    }
                }
                i12++;
                i5 = 8;
            }
        }
        ArrayList arrayListW = w();
        if (arrayListW != null && !z2) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt3 = getChildAt(i13);
                if (childAt3.getVisibility() != 8) {
                    Rect rect = (Rect) arrayListW.get(i13);
                    LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                    int i14 = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
                    int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt3.getMeasuredHeight(), 1073741824);
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), Integer.MIN_VALUE), iMakeMeasureSpec2);
                    if ((childAt3.getMeasuredWidthAndState() & 16777216) == 1 || (i(childAt3) != 0 && rect.width() < i(childAt3))) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(i11 - i14, 1073741824), iMakeMeasureSpec2);
                        if (i13 != 0) {
                            layoutParams3.f53153b = true;
                            this.f53126g = childAt3;
                            z2 = true;
                        }
                    } else {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), iMakeMeasureSpec2);
                    }
                }
            }
        }
        setMeasuredDimension(size, iMin + getPaddingTop() + getPaddingBottom());
        this.f53125f = z2;
        if (this.f53136q.B() == 0 || z2) {
            return;
        }
        this.f53136q.a();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        if (savedState.f53156c) {
            q();
        } else {
            b();
        }
        this.f53137r = savedState.f53156c;
        setLockMode(savedState.f53157d);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f53156c = n() ? m() : this.f53137r;
        savedState.f53157d = this.f53141v;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (i3 != i5) {
            this.f53138s = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f53125f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f53136q.G(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.f53132m = x2;
            this.f53133n = y2;
            return true;
        }
        if (actionMasked == 1 && k(this.f53126g)) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float f3 = x3 - this.f53132m;
            float f4 = y3 - this.f53133n;
            int iA = this.f53136q.A();
            if ((f3 * f3) + (f4 * f4) < iA * iA && this.f53136q.F(this.f53126g, (int) x3, (int) y3)) {
                c(0);
            }
        }
        return true;
    }

    void p(int i3) {
        if (this.f53126g == null) {
            this.f53127h = 0.0f;
            return;
        }
        boolean zL = l();
        LayoutParams layoutParams = (LayoutParams) this.f53126g.getLayoutParams();
        int width = this.f53126g.getWidth();
        if (zL) {
            i3 = (getWidth() - i3) - width;
        }
        float paddingRight = (i3 - ((zL ? getPaddingRight() : getPaddingLeft()) + (zL ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin))) / this.f53129j;
        this.f53127h = paddingRight;
        if (this.f53131l != 0) {
            s(paddingRight);
        }
        f(this.f53126g);
    }

    public boolean q() {
        return r(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view.getParent() instanceof TouchBlocker) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.f53125f) {
            return;
        }
        this.f53137r = view == this.f53126g;
    }

    @Deprecated
    public void setCoveredFadeColor(int i3) {
        this.f53122b = i3;
    }

    public final void setLockMode(int i3) {
        this.f53141v = i3;
    }

    @Deprecated
    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        PanelSlideListener panelSlideListener2 = this.f53135p;
        if (panelSlideListener2 != null) {
            t(panelSlideListener2);
        }
        if (panelSlideListener != null) {
            a(panelSlideListener);
        }
        this.f53135p = panelSlideListener;
    }

    public void setParallaxDistance(int i3) {
        this.f53131l = i3;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f53123c = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f53124d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i3) {
        setShadowDrawableLeft(getResources().getDrawable(i3));
    }

    public void setShadowResourceLeft(int i3) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i3));
    }

    public void setShadowResourceRight(int i3) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i3));
    }

    @Deprecated
    public void setSliderFadeColor(int i3) {
        this.f53121a = i3;
    }

    public void t(PanelSlideListener panelSlideListener) {
        this.f53134o.remove(panelSlideListener);
    }

    void u() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    boolean v(float f3, int i3) {
        int paddingLeft;
        if (!this.f53125f) {
            return false;
        }
        boolean zL = l();
        LayoutParams layoutParams = (LayoutParams) this.f53126g.getLayoutParams();
        if (zL) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (f3 * this.f53129j)) + this.f53126g.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (f3 * this.f53129j));
        }
        ViewDragHelper viewDragHelper = this.f53136q;
        View view = this.f53126g;
        if (!viewDragHelper.R(view, paddingLeft, view.getTop())) {
            return false;
        }
        u();
        ViewCompat.d0(this);
        return true;
    }

    void x(View view) {
        int left;
        int right;
        int top;
        int bottom;
        View childAt;
        boolean z2;
        View view2 = view;
        boolean zL = l();
        int width = zL ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zL ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !y(view2)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view2.getLeft();
            right = view2.getRight();
            top = view2.getTop();
            bottom = view2.getBottom();
        }
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount && (childAt = getChildAt(i3)) != view2) {
            if (childAt.getVisibility() == 8) {
                z2 = zL;
            } else {
                z2 = zL;
                childAt.setVisibility((Math.max(zL ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zL ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i3++;
            view2 = view;
            zL = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int[] f53151e = {R.attr.layout_weight};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f53152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f53153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f53154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Paint f53155d;

        public LayoutParams() {
            super(-1, -1);
            this.f53152a = 0.0f;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f53152a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f53152a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f53152a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f53152a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f53151e);
            this.f53152a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f53121a = 0;
        this.f53127h = 1.0f;
        this.f53134o = new CopyOnWriteArrayList();
        this.f53138s = true;
        this.f53139t = new Rect();
        this.f53140u = new ArrayList();
        this.f53143x = new FoldingFeatureObserver.OnFoldingFeatureChangeListener() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.1
            @Override // androidx.slidingpanelayout.widget.FoldingFeatureObserver.OnFoldingFeatureChangeListener
            public void a(FoldingFeature foldingFeature) {
                SlidingPaneLayout.this.f53142w = foldingFeature;
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.h0(300L);
                changeBounds.j0(PathInterpolatorCompat.a(0.2f, 0.0f, 0.0f, 1.0f));
                TransitionManager.b(SlidingPaneLayout.this, changeBounds);
                SlidingPaneLayout.this.requestLayout();
            }
        };
        float f3 = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        ViewCompat.m0(this, new AccessibilityDelegate());
        ViewCompat.w0(this, 1);
        ViewDragHelper viewDragHelperO = ViewDragHelper.o(this, 0.5f, new DragHelperCallback());
        this.f53136q = viewDragHelperO;
        viewDragHelperO.O(f3 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(WindowInfoTracker.a(context), ContextCompat.getMainExecutor(context)));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void a(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void b(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void c(View view, float f3) {
        }
    }
}
