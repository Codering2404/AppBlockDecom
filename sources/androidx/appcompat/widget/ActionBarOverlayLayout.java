package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.common.api.Api;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    static final int[] H = {R.attr.f633b, android.R.attr.windowContentOverlay};
    private static final WindowInsetsCompat I = new WindowInsetsCompat.Builder().d(Insets.b(0, 1, 0, 1)).a();
    private static final Rect J = new Rect();
    private OverScroller A;
    ViewPropertyAnimator B;
    final AnimatorListenerAdapter C;
    private final Runnable D;
    private final Runnable E;
    private final NestedScrollingParentHelper F;
    private final NoSystemUiLayoutFlagView G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ContentFrameLayout f1592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ActionBarContainer f1593d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DecorToolbar f1594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f1595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f1599k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1600l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1601m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Rect f1602n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Rect f1603o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Rect f1604p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Rect f1605q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f1606r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f1607s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Rect f1608t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Rect f1609u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private WindowInsetsCompat f1610v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private WindowInsetsCompat f1611w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private WindowInsetsCompat f1612x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private WindowInsetsCompat f1613y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ActionBarVisibilityCallback f1614z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ActionBarVisibilityCallback {
        void a();

        void b();

        void c(boolean z2);

        void d();

        void e();

        void onWindowVisibilityChanged(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NoSystemUiLayoutFlagView extends View {
        NoSystemUiLayoutFlagView(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1591b = 0;
        this.f1602n = new Rect();
        this.f1603o = new Rect();
        this.f1604p = new Rect();
        this.f1605q = new Rect();
        this.f1606r = new Rect();
        this.f1607s = new Rect();
        this.f1608t = new Rect();
        this.f1609u = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.f34517b;
        this.f1610v = windowInsetsCompat;
        this.f1611w = windowInsetsCompat;
        this.f1612x = windowInsetsCompat;
        this.f1613y = windowInsetsCompat;
        this.C = new AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = null;
                actionBarOverlayLayout.f1599k = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = null;
                actionBarOverlayLayout.f1599k = false;
            }
        };
        this.D = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.v();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = actionBarOverlayLayout.f1593d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
            }
        };
        this.E = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.v();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = actionBarOverlayLayout.f1593d.animate().translationY(-ActionBarOverlayLayout.this.f1593d.getHeight()).setListener(ActionBarOverlayLayout.this.C);
            }
        };
        w(context);
        this.F = new NestedScrollingParentHelper(this);
        NoSystemUiLayoutFlagView noSystemUiLayoutFlagView = new NoSystemUiLayoutFlagView(context);
        this.G = noSystemUiLayoutFlagView;
        addView(noSystemUiLayoutFlagView);
    }

    private void B() {
        v();
        this.D.run();
    }

    private boolean C(float f3) {
        this.A.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this.A.getFinalY() > this.f1593d.getHeight();
    }

    private void a() {
        v();
        this.E.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean q(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = r0
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = r0
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = r0
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            return r0
        L35:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    private boolean r() {
        ViewCompat.f(this.G, I, this.f1605q);
        return !this.f1605q.equals(J);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar u(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void w(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(H);
        this.f1590a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f1595g = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.A = new OverScroller(context);
    }

    private void y() {
        v();
        postDelayed(this.E, 600L);
    }

    private void z() {
        v();
        postDelayed(this.D, 600L);
    }

    void A() {
        if (this.f1592c == null) {
            this.f1592c = (ContentFrameLayout) findViewById(R.id.f734b);
            this.f1593d = (ActionBarContainer) findViewById(R.id.f735c);
            this.f1594f = u(findViewById(R.id.f733a));
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean b() {
        A();
        return this.f1594f.b();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean c() {
        A();
        return this.f1594f.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean d() {
        A();
        return this.f1594f.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1595g != null) {
            int bottom = this.f1593d.getVisibility() == 0 ? (int) (this.f1593d.getBottom() + this.f1593d.getTranslationY() + 0.5f) : 0;
            this.f1595g.setBounds(0, bottom, getWidth(), this.f1595g.getIntrinsicHeight() + bottom);
            this.f1595g.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void e(Menu menu, MenuPresenter.Callback callback) {
        A();
        this.f1594f.e(menu, callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean f() {
        A();
        return this.f1594f.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void g() {
        A();
        this.f1594f.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1593d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        A();
        return this.f1594f.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean h() {
        A();
        return this.f1594f.h();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void i(int i3) {
        A();
        if (i3 == 2) {
            this.f1594f.q();
        } else if (i3 == 5) {
            this.f1594f.y();
        } else {
            if (i3 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void j(View view, View view2, int i3, int i4) {
        if (i4 == 0) {
            onNestedScrollAccepted(view, view2, i3);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void k(View view, int i3) {
        if (i3 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void l(View view, int i3, int i4, int[] iArr, int i5) {
        if (i5 == 0) {
            onNestedPreScroll(view, i3, i4, iArr);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void m() {
        A();
        this.f1594f.s();
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void n(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        o(view, i3, i4, i5, i6, i7);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void o(View view, int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            onNestedScroll(view, i3, i4, i5, i6);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        A();
        WindowInsetsCompat windowInsetsCompatA = WindowInsetsCompat.A(windowInsets, this);
        boolean zQ = q(this.f1593d, new Rect(windowInsetsCompatA.k(), windowInsetsCompatA.m(), windowInsetsCompatA.l(), windowInsetsCompatA.j()), true, true, false, true);
        ViewCompat.f(this, windowInsetsCompatA, this.f1602n);
        Rect rect = this.f1602n;
        WindowInsetsCompat windowInsetsCompatP = windowInsetsCompatA.p(rect.left, rect.top, rect.right, rect.bottom);
        this.f1610v = windowInsetsCompatP;
        boolean z2 = true;
        if (!this.f1611w.equals(windowInsetsCompatP)) {
            this.f1611w = this.f1610v;
            zQ = true;
        }
        if (this.f1603o.equals(this.f1602n)) {
            z2 = zQ;
        } else {
            this.f1603o.set(this.f1602n);
        }
        if (z2) {
            requestLayout();
        }
        return windowInsetsCompatA.a().c().b().y();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w(getContext());
        ViewCompat.j0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int measuredHeight;
        A();
        measureChildWithMargins(this.f1593d, i3, 0, i4, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1593d.getLayoutParams();
        int iMax = Math.max(0, this.f1593d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int iMax2 = Math.max(0, this.f1593d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1593d.getMeasuredState());
        boolean z2 = (ViewCompat.K(this) & Function.MAX_NARGS) != 0;
        if (z2) {
            measuredHeight = this.f1590a;
            if (this.f1597i && this.f1593d.getTabContainer() != null) {
                measuredHeight += this.f1590a;
            }
        } else {
            measuredHeight = this.f1593d.getVisibility() != 8 ? this.f1593d.getMeasuredHeight() : 0;
        }
        this.f1604p.set(this.f1602n);
        this.f1612x = this.f1610v;
        if (this.f1596h || z2 || !r()) {
            this.f1612x = new WindowInsetsCompat.Builder(this.f1612x).d(Insets.b(this.f1612x.k(), this.f1612x.m() + measuredHeight, this.f1612x.l(), this.f1612x.j())).a();
        } else {
            Rect rect = this.f1604p;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f1612x = this.f1612x.p(0, measuredHeight, 0, 0);
        }
        q(this.f1592c, this.f1604p, true, true, true, true);
        if (!this.f1613y.equals(this.f1612x)) {
            WindowInsetsCompat windowInsetsCompat = this.f1612x;
            this.f1613y = windowInsetsCompat;
            ViewCompat.g(this.f1592c, windowInsetsCompat);
        }
        measureChildWithMargins(this.f1592c, i3, 0, i4, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f1592c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1592c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f1592c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1592c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f3, float f4, boolean z2) {
        if (!this.f1598j || !z2) {
            return false;
        }
        if (C(f4)) {
            a();
        } else {
            B();
        }
        this.f1599k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i3, int i4, int i5, int i6) {
        int i7 = this.f1600l + i4;
        this.f1600l = i7;
        setActionBarHideOffset(i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.F.b(view, view2, i3);
        this.f1600l = getActionBarHideOffset();
        v();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1614z;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        if ((i3 & 2) == 0 || this.f1593d.getVisibility() != 0) {
            return false;
        }
        return this.f1598j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f1598j && !this.f1599k) {
            if (this.f1600l <= this.f1593d.getHeight()) {
                z();
            } else {
                y();
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1614z;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.b();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i3) {
        super.onWindowSystemUiVisibilityChanged(i3);
        A();
        int i4 = this.f1601m ^ i3;
        this.f1601m = i3;
        boolean z2 = (i3 & 4) == 0;
        boolean z3 = (i3 & Function.MAX_NARGS) != 0;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1614z;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.c(!z3);
            if (z2 || !z3) {
                this.f1614z.a();
            } else {
                this.f1614z.d();
            }
        }
        if ((i4 & Function.MAX_NARGS) == 0 || this.f1614z == null) {
            return;
        }
        ViewCompat.j0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        this.f1591b = i3;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1614z;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onWindowVisibilityChanged(i3);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean p(View view, View view2, int i3, int i4) {
        return i4 == 0 && onStartNestedScroll(view, view2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public void setActionBarHideOffset(int i3) {
        v();
        this.f1593d.setTranslationY(-Math.max(0, Math.min(i3, this.f1593d.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.f1614z = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.f1614z.onWindowVisibilityChanged(this.f1591b);
            int i3 = this.f1601m;
            if (i3 != 0) {
                onWindowSystemUiVisibilityChanged(i3);
                ViewCompat.j0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f1597i = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f1598j) {
            this.f1598j = z2;
            if (z2) {
                return;
            }
            v();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i3) {
        A();
        this.f1594f.setIcon(i3);
    }

    public void setLogo(int i3) {
        A();
        this.f1594f.u(i3);
    }

    public void setOverlayMode(boolean z2) {
        this.f1596h = z2;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        A();
        this.f1594f.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        A();
        this.f1594f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    void v() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean x() {
        return this.f1596h;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        A();
        this.f1594f.setIcon(drawable);
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i3) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i3, int i4, int[] iArr) {
    }
}
