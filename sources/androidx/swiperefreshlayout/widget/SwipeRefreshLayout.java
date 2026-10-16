package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    private static final String P = "SwipeRefreshLayout";
    private static final int[] Q = {R.attr.enabled};
    int A;
    int B;
    CircularProgressDrawable C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    private Animation H;
    boolean I;
    private int J;
    boolean K;
    private OnChildScrollUpCallback L;
    private Animation.AnimationListener M;
    private final Animation N;
    private final Animation O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f53307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    OnRefreshListener f53308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f53309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f53310d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f53311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f53312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final NestedScrollingParentHelper f53313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final NestedScrollingChildHelper f53314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f53315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f53316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f53317l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f53318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f53319n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f53320o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f53321p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f53322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f53323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f53324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f53325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final DecelerateInterpolator f53326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    CircleImageView f53327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f53328w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int f53329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f53330y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected int f53331z;

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass6 extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SwipeRefreshLayout f53339a;

        @Override // android.view.animation.Animation
        public void applyTransformation(float f3, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = this.f53339a;
            int iAbs = !swipeRefreshLayout.K ? swipeRefreshLayout.A - Math.abs(swipeRefreshLayout.f53331z) : swipeRefreshLayout.A;
            SwipeRefreshLayout swipeRefreshLayout2 = this.f53339a;
            this.f53339a.setTargetOffsetTopAndBottom((swipeRefreshLayout2.f53329x + ((int) ((iAbs - r1) * f3))) - swipeRefreshLayout2.f53327v.getTop());
            this.f53339a.C.e(1.0f - f3);
        }
    }

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass7 extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SwipeRefreshLayout f53340a;

        @Override // android.view.animation.Animation
        public void applyTransformation(float f3, Transformation transformation) {
            this.f53340a.h(f3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnChildScrollUpCallback {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnRefreshListener {
        void a();
    }

    private void a(int i3, Animation.AnimationListener animationListener) {
        this.f53329x = i3;
        this.N.reset();
        this.N.setDuration(200L);
        this.N.setInterpolator(this.f53326u);
        if (animationListener != null) {
            this.f53327v.b(animationListener);
        }
        this.f53327v.clearAnimation();
        this.f53327v.startAnimation(this.N);
    }

    private void b(int i3, Animation.AnimationListener animationListener) {
        if (this.f53324s) {
            w(i3, animationListener);
            return;
        }
        this.f53329x = i3;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.f53326u);
        if (animationListener != null) {
            this.f53327v.b(animationListener);
        }
        this.f53327v.clearAnimation();
        this.f53327v.startAnimation(this.O);
    }

    private void d() {
        if (this.f53307a == null) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (!childAt.equals(this.f53327v)) {
                    this.f53307a = childAt;
                    return;
                }
            }
        }
    }

    private void e(float f3) {
        if (f3 > this.f53311f) {
            q(true, true);
            return;
        }
        this.f53309c = false;
        this.C.j(0.0f, 0.0f);
        b(this.f53319n, !this.f53324s ? new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (swipeRefreshLayout.f53324s) {
                    return;
                }
                swipeRefreshLayout.v(null);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        } : null);
        this.C.d(false);
    }

    private boolean f(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void g(float f3) {
        this.C.d(true);
        float fMin = Math.min(1.0f, Math.abs(f3 / this.f53311f));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f3) - this.f53311f;
        int i3 = this.B;
        if (i3 <= 0) {
            i3 = this.K ? this.A - this.f53331z : this.A;
        }
        float f4 = i3;
        double dMax = Math.max(0.0f, Math.min(fAbs, f4 * 2.0f) / f4) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i4 = this.f53331z + ((int) ((f4 * fMin) + (f4 * fPow * 2.0f)));
        if (this.f53327v.getVisibility() != 0) {
            this.f53327v.setVisibility(0);
        }
        if (!this.f53324s) {
            this.f53327v.setScaleX(1.0f);
            this.f53327v.setScaleY(1.0f);
        }
        if (this.f53324s) {
            setAnimationProgress(Math.min(1.0f, f3 / this.f53311f));
        }
        if (f3 < this.f53311f) {
            if (this.C.getAlpha() > 76 && !f(this.F)) {
                u();
            }
        } else if (this.C.getAlpha() < 255 && !f(this.G)) {
            t();
        }
        this.C.j(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.C.e(Math.min(1.0f, fMax));
        this.C.g((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i4 - this.f53319n);
    }

    private void i(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f53323r) {
            this.f53323r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void q(boolean z2, boolean z3) {
        if (this.f53309c != z2) {
            this.I = z3;
            d();
            this.f53309c = z2;
            if (z2) {
                a(this.f53319n, this.M);
            } else {
                v(this.M);
            }
        }
    }

    private Animation r(final int i3, final int i4) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f3, Transformation transformation) {
                SwipeRefreshLayout.this.C.setAlpha((int) (i3 + ((i4 - r0) * f3)));
            }
        };
        animation.setDuration(300L);
        this.f53327v.b(null);
        this.f53327v.clearAnimation();
        this.f53327v.startAnimation(animation);
        return animation;
    }

    private void s(float f3) {
        float f4 = this.f53321p;
        float f5 = f3 - f4;
        int i3 = this.f53310d;
        if (f5 <= i3 || this.f53322q) {
            return;
        }
        this.f53320o = f4 + i3;
        this.f53322q = true;
        this.C.setAlpha(76);
    }

    private void setColorViewAlpha(int i3) {
        this.f53327v.getBackground().setAlpha(i3);
        this.C.setAlpha(i3);
    }

    private void t() {
        this.G = r(this.C.getAlpha(), 255);
    }

    private void u() {
        this.F = r(this.C.getAlpha(), 76);
    }

    private void w(int i3, Animation.AnimationListener animationListener) {
        this.f53329x = i3;
        this.f53330y = this.f53327v.getScaleX();
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f3, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                float f4 = swipeRefreshLayout.f53330y;
                swipeRefreshLayout.setAnimationProgress(f4 + ((-f4) * f3));
                SwipeRefreshLayout.this.h(f3);
            }
        };
        this.H = animation;
        animation.setDuration(150L);
        if (animationListener != null) {
            this.f53327v.b(animationListener);
        }
        this.f53327v.clearAnimation();
        this.f53327v.startAnimation(this.H);
    }

    private void x(Animation.AnimationListener animationListener) {
        this.f53327v.setVisibility(0);
        this.C.setAlpha(255);
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f3, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f3);
            }
        };
        this.D = animation;
        animation.setDuration(this.f53318m);
        if (animationListener != null) {
            this.f53327v.b(animationListener);
        }
        this.f53327v.clearAnimation();
        this.f53327v.startAnimation(this.D);
    }

    public boolean c() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.L;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.a(this, this.f53307a);
        }
        View view = this.f53307a;
        return view instanceof ListView ? ListViewCompat.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f3, float f4, boolean z2) {
        return this.f53314i.a(f3, f4, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f3, float f4) {
        return this.f53314i.b(f3, f4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i3, int i4, int[] iArr, int[] iArr2) {
        return this.f53314i.c(i3, i4, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i3, int i4, int i5, int i6, int[] iArr) {
        return this.f53314i.f(i3, i4, i5, i6, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        int i5 = this.f53328w;
        return i5 < 0 ? i4 : i4 == i3 + (-1) ? i5 : i4 >= i5 ? i4 + 1 : i4;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f53313h.a();
    }

    public int getProgressCircleDiameter() {
        return this.J;
    }

    public int getProgressViewEndOffset() {
        return this.A;
    }

    public int getProgressViewStartOffset() {
        return this.f53331z;
    }

    void h(float f3) {
        setTargetOffsetTopAndBottom((this.f53329x + ((int) ((this.f53331z - r0) * f3))) - this.f53327v.getTop());
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f53314i.j();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f53314i.l();
    }

    void m() {
        this.f53327v.clearAnimation();
        this.C.stop();
        this.f53327v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f53324s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f53331z - this.f53319n);
        }
        this.f53319n = this.f53327v.getTop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r4.d()
            int r0 = r5.getActionMasked()
            boolean r1 = r4.f53325t
            r2 = 0
            if (r1 == 0) goto L10
            if (r0 != 0) goto L10
            r4.f53325t = r2
        L10:
            boolean r1 = r4.isEnabled()
            if (r1 == 0) goto L81
            boolean r1 = r4.f53325t
            if (r1 != 0) goto L81
            boolean r1 = r4.c()
            if (r1 != 0) goto L81
            boolean r1 = r4.f53309c
            if (r1 != 0) goto L81
            boolean r1 = r4.f53317l
            if (r1 == 0) goto L29
            goto L81
        L29:
            if (r0 == 0) goto L5d
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L58
            r1 = 2
            if (r0 == r1) goto L3d
            r1 = 3
            if (r0 == r1) goto L58
            r1 = 6
            if (r0 == r1) goto L39
            goto L7e
        L39:
            r4.i(r5)
            goto L7e
        L3d:
            int r0 = r4.f53323r
            if (r0 != r3) goto L49
            java.lang.String r5 = androidx.swiperefreshlayout.widget.SwipeRefreshLayout.P
            java.lang.String r0 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r5, r0)
            return r2
        L49:
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L50
            return r2
        L50:
            float r5 = r5.getY(r0)
            r4.s(r5)
            goto L7e
        L58:
            r4.f53322q = r2
            r4.f53323r = r3
            goto L7e
        L5d:
            int r0 = r4.f53331z
            androidx.swiperefreshlayout.widget.CircleImageView r1 = r4.f53327v
            int r1 = r1.getTop()
            int r0 = r0 - r1
            r4.setTargetOffsetTopAndBottom(r0)
            int r0 = r5.getPointerId(r2)
            r4.f53323r = r0
            r4.f53322q = r2
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L78
            return r2
        L78:
            float r5 = r5.getY(r0)
            r4.f53321p = r5
        L7e:
            boolean r5 = r4.f53322q
            return r5
        L81:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f53307a == null) {
            d();
        }
        View view = this.f53307a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f53327v.getMeasuredWidth();
        int measuredHeight2 = this.f53327v.getMeasuredHeight();
        int i7 = measuredWidth / 2;
        int i8 = measuredWidth2 / 2;
        int i9 = this.f53319n;
        this.f53327v.layout(i7 - i8, i9, i7 + i8, measuredHeight2 + i9);
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f53307a == null) {
            d();
        }
        View view = this.f53307a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f53327v.measure(View.MeasureSpec.makeMeasureSpec(this.J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.J, 1073741824));
        this.f53328w = -1;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) == this.f53327v) {
                this.f53328w = i5;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f3, float f4, boolean z2) {
        return dispatchNestedFling(f3, f4, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return dispatchNestedPreFling(f3, f4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
        if (i4 > 0) {
            float f3 = this.f53312g;
            if (f3 > 0.0f) {
                float f4 = i4;
                if (f4 > f3) {
                    iArr[1] = i4 - ((int) f3);
                    this.f53312g = 0.0f;
                } else {
                    this.f53312g = f3 - f4;
                    iArr[1] = i4;
                }
                g(this.f53312g);
            }
        }
        if (this.K && i4 > 0 && this.f53312g == 0.0f && Math.abs(i4 - iArr[1]) > 0) {
            this.f53327v.setVisibility(8);
        }
        int[] iArr2 = this.f53315j;
        if (dispatchNestedPreScroll(i3 - iArr[0], i4 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        dispatchNestedScroll(i3, i4, i5, i6, this.f53316k);
        if (i6 + this.f53316k[1] >= 0 || c()) {
            return;
        }
        float fAbs = this.f53312g + Math.abs(r11);
        this.f53312g = fAbs;
        g(fAbs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.f53313h.b(view, view2, i3);
        startNestedScroll(i3 & 2);
        this.f53312g = 0.0f;
        this.f53317l = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return (!isEnabled() || this.f53325t || this.f53309c || (i3 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f53313h.d(view);
        this.f53317l = false;
        float f3 = this.f53312g;
        if (f3 > 0.0f) {
            e(f3);
            this.f53312g = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f53325t && actionMasked == 0) {
            this.f53325t = false;
        }
        if (!isEnabled() || this.f53325t || c() || this.f53309c || this.f53317l) {
            return false;
        }
        if (actionMasked == 0) {
            this.f53323r = motionEvent.getPointerId(0);
            this.f53322q = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f53323r);
                if (iFindPointerIndex < 0) {
                    Log.e(P, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f53322q) {
                    float y2 = (motionEvent.getY(iFindPointerIndex) - this.f53320o) * 0.5f;
                    this.f53322q = false;
                    e(y2);
                }
                this.f53323r = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f53323r);
                if (iFindPointerIndex2 < 0) {
                    Log.e(P, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y3 = motionEvent.getY(iFindPointerIndex2);
                s(y3);
                if (this.f53322q) {
                    float f3 = (y3 - this.f53320o) * 0.5f;
                    if (f3 <= 0.0f) {
                        return false;
                    }
                    g(f3);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(P, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.f53323r = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    i(motionEvent);
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        View view = this.f53307a;
        if (view == null || ViewCompat.S(view)) {
            super.requestDisallowInterceptTouchEvent(z2);
        }
    }

    void setAnimationProgress(float f3) {
        this.f53327v.setScaleX(f3);
        this.f53327v.setScaleY(f3);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        d();
        this.C.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr2[i3] = ContextCompat.getColor(context, iArr[i3]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i3) {
        this.f53311f = i3;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (z2) {
            return;
        }
        m();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        this.f53314i.m(z2);
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback onChildScrollUpCallback) {
        this.L = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f53308b = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i3) {
        setProgressBackgroundColorSchemeResource(i3);
    }

    public void setProgressBackgroundColorSchemeColor(int i3) {
        this.f53327v.setBackgroundColor(i3);
    }

    public void setProgressBackgroundColorSchemeResource(int i3) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i3));
    }

    public void setRefreshing(boolean z2) {
        if (!z2 || this.f53309c == z2) {
            q(z2, false);
            return;
        }
        this.f53309c = z2;
        setTargetOffsetTopAndBottom((!this.K ? this.A + this.f53331z : this.A) - this.f53319n);
        this.I = false;
        x(this.M);
    }

    public void setSize(int i3) {
        if (i3 == 0 || i3 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i3 == 0) {
                this.J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.J = (int) (displayMetrics.density * 40.0f);
            }
            this.f53327v.setImageDrawable(null);
            this.C.k(i3);
            this.f53327v.setImageDrawable(this.C);
        }
    }

    public void setSlingshotDistance(int i3) {
        this.B = i3;
    }

    void setTargetOffsetTopAndBottom(int i3) {
        this.f53327v.bringToFront();
        ViewCompat.X(this.f53327v, i3);
        this.f53319n = this.f53327v.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i3) {
        return this.f53314i.o(i3);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.f53314i.q();
    }

    void v(Animation.AnimationListener animationListener) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f3, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f3);
            }
        };
        this.E = animation;
        animation.setDuration(150L);
        this.f53327v.b(animationListener);
        this.f53327v.clearAnimation();
        this.f53327v.startAnimation(this.E);
    }

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SwipeRefreshLayout f53332a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            OnRefreshListener onRefreshListener;
            SwipeRefreshLayout swipeRefreshLayout = this.f53332a;
            if (!swipeRefreshLayout.f53309c) {
                swipeRefreshLayout.m();
                return;
            }
            swipeRefreshLayout.C.setAlpha(255);
            this.f53332a.C.start();
            SwipeRefreshLayout swipeRefreshLayout2 = this.f53332a;
            if (swipeRefreshLayout2.I && (onRefreshListener = swipeRefreshLayout2.f53308b) != null) {
                onRefreshListener.a();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = this.f53332a;
            swipeRefreshLayout3.f53319n = swipeRefreshLayout3.f53327v.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
