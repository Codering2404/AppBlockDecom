package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int G = R.style.f79744q;
    private int A;
    WindowInsetsCompat B;
    private int C;
    private boolean D;
    private int E;
    private boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f79920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f79921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewGroup f79922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f79923d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f79924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f79925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f79926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f79927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f79928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Rect f79929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final CollapsingTextHelper f79930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ElevationOverlayProvider f79931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f79932n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f79933o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Drawable f79934p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Drawable f79935q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f79936r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f79937s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ValueAnimator f79938t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f79939u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final TimeInterpolator f79940v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final TimeInterpolator f79941w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f79942x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private AppBarLayout.OnOffsetChangedListener f79943y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f79944z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void a(AppBarLayout appBarLayout, int i3) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f79944z = i3;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.B;
            int iM = windowInsetsCompat != null ? windowInsetsCompat.m() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelperK = CollapsingToolbarLayout.k(childAt);
                int i5 = layoutParams.f79947a;
                if (i5 == 1) {
                    viewOffsetHelperK.f(MathUtils.b(-i3, 0, CollapsingToolbarLayout.this.i(childAt)));
                } else if (i5 == 2) {
                    viewOffsetHelperK.f(Math.round((-i3) * layoutParams.f79948b));
                }
            }
            CollapsingToolbarLayout.this.v();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f79935q != null && iM > 0) {
                ViewCompat.d0(collapsingToolbarLayout2);
            }
            int height = (CollapsingToolbarLayout.this.getHeight() - ViewCompat.z(CollapsingToolbarLayout.this)) - iM;
            float f3 = height;
            CollapsingToolbarLayout.this.f79930l.A0(Math.min(1.0f, (r0 - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f3));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f79930l.n0(collapsingToolbarLayout3.f79944z + height);
            CollapsingToolbarLayout.this.f79930l.y0(Math.abs(i3) / f3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface StaticLayoutBuilderConfigurer extends com.google.android.material.internal.StaticLayoutBuilderConfigurer {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TitleCollapseMode {
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f79494j);
    }

    private void a(int i3) {
        d();
        ValueAnimator valueAnimator = this.f79938t;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f79938t = valueAnimator2;
            valueAnimator2.setInterpolator(i3 > this.f79936r ? this.f79940v : this.f79941w);
            this.f79938t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator3.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.f79938t.cancel();
        }
        this.f79938t.setDuration(this.f79939u);
        this.f79938t.setIntValues(this.f79936r, i3);
        this.f79938t.start();
    }

    private TextUtils.TruncateAt b(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.MIDDLE : TextUtils.TruncateAt.START;
    }

    private void c(AppBarLayout appBarLayout) {
        if (l()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void d() {
        if (this.f79920a) {
            ViewGroup viewGroup = null;
            this.f79922c = null;
            this.f79923d = null;
            int i3 = this.f79921b;
            if (i3 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i3);
                this.f79922c = viewGroup2;
                if (viewGroup2 != null) {
                    this.f79923d = e(viewGroup2);
                }
            }
            if (this.f79922c == null) {
                int childCount = getChildCount();
                int i4 = 0;
                while (true) {
                    if (i4 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i4);
                    if (m(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i4++;
                }
                this.f79922c = viewGroup;
            }
            u();
            this.f79920a = false;
        }
    }

    private View e(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList colorStateListH = MaterialColors.h(getContext(), R.attr.f79520w);
        if (colorStateListH != null) {
            return colorStateListH.getDefaultColor();
        }
        return this.f79931m.d(getResources().getDimension(R.dimen.f79556b));
    }

    private static int h(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    static ViewOffsetHelper k(View view) {
        int i3 = R.id.f79661u0;
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(i3);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(i3, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private boolean l() {
        return this.A == 1;
    }

    private static boolean m(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    private boolean n(View view) {
        View view2 = this.f79923d;
        return (view2 == null || view2 == this) ? view == this.f79922c : view == view2;
    }

    private void q(boolean z2) {
        int titleMarginStart;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        View view = this.f79923d;
        if (view == null) {
            view = this.f79922c;
        }
        int i3 = i(view);
        DescendantOffsetUtils.a(this, this.f79924f, this.f79929k);
        ViewGroup viewGroup = this.f79922c;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            titleMarginStart = toolbar.getTitleMarginStart();
            titleMarginEnd = toolbar.getTitleMarginEnd();
            titleMarginTop = toolbar.getTitleMarginTop();
            titleMarginBottom = toolbar.getTitleMarginBottom();
        } else if (viewGroup instanceof android.widget.Toolbar) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            titleMarginStart = toolbar2.getTitleMarginStart();
            titleMarginEnd = toolbar2.getTitleMarginEnd();
            titleMarginTop = toolbar2.getTitleMarginTop();
            titleMarginBottom = toolbar2.getTitleMarginBottom();
        } else {
            titleMarginStart = 0;
            titleMarginBottom = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
        }
        CollapsingTextHelper collapsingTextHelper = this.f79930l;
        Rect rect = this.f79929k;
        int i4 = rect.left + (z2 ? titleMarginEnd : titleMarginStart);
        int i5 = rect.top + i3 + titleMarginTop;
        int i6 = rect.right;
        if (!z2) {
            titleMarginStart = titleMarginEnd;
        }
        collapsingTextHelper.e0(i4, i5, i6 - titleMarginStart, (rect.bottom + i3) - titleMarginBottom);
    }

    private void r() {
        setContentDescription(getTitle());
    }

    private void s(Drawable drawable, int i3, int i4) {
        t(drawable, this.f79922c, i3, i4);
    }

    private void t(Drawable drawable, View view, int i3, int i4) {
        if (l() && view != null && this.f79932n) {
            i4 = view.getBottom();
        }
        drawable.setBounds(0, 0, i3, i4);
    }

    private void u() {
        View view;
        if (!this.f79932n && (view = this.f79924f) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f79924f);
            }
        }
        if (!this.f79932n || this.f79922c == null) {
            return;
        }
        if (this.f79924f == null) {
            this.f79924f = new View(getContext());
        }
        if (this.f79924f.getParent() == null) {
            this.f79922c.addView(this.f79924f, -1, -1);
        }
    }

    private void w(int i3, int i4, int i5, int i6, boolean z2) {
        View view;
        if (!this.f79932n || (view = this.f79924f) == null) {
            return;
        }
        boolean z3 = ViewCompat.Q(view) && this.f79924f.getVisibility() == 0;
        this.f79933o = z3;
        if (z3 || z2) {
            boolean z4 = ViewCompat.y(this) == 1;
            q(z4);
            this.f79930l.o0(z4 ? this.f79927i : this.f79925g, this.f79929k.top + this.f79926h, (i5 - i3) - (z4 ? this.f79925g : this.f79927i), (i6 - i4) - this.f79928j);
            this.f79930l.b0(z2);
        }
    }

    private void x() {
        if (this.f79922c != null && this.f79932n && TextUtils.isEmpty(this.f79930l.O())) {
            setTitle(j(this.f79922c));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.f79922c == null && (drawable = this.f79934p) != null && this.f79936r > 0) {
            drawable.mutate().setAlpha(this.f79936r);
            this.f79934p.draw(canvas);
        }
        if (this.f79932n && this.f79933o) {
            if (this.f79922c == null || this.f79934p == null || this.f79936r <= 0 || !l() || this.f79930l.F() >= this.f79930l.G()) {
                this.f79930l.l(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.f79934p.getBounds(), Region.Op.DIFFERENCE);
                this.f79930l.l(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.f79935q == null || this.f79936r <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.B;
        int iM = windowInsetsCompat != null ? windowInsetsCompat.m() : 0;
        if (iM > 0) {
            this.f79935q.setBounds(0, -this.f79944z, getWidth(), iM - this.f79944z);
            this.f79935q.mutate().setAlpha(this.f79936r);
            this.f79935q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        boolean z2;
        if (this.f79934p == null || this.f79936r <= 0 || !n(view)) {
            z2 = false;
        } else {
            t(this.f79934p, view, getWidth(), getHeight());
            this.f79934p.mutate().setAlpha(this.f79936r);
            this.f79934p.draw(canvas);
            z2 = true;
        }
        return super.drawChild(canvas, view, j3) || z2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f79935q;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f79934p;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.f79930l;
        if (collapsingTextHelper != null) {
            state |= collapsingTextHelper.I0(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f79930l.q();
    }

    public float getCollapsedTitleTextSize() {
        return this.f79930l.u();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f79930l.v();
    }

    public Drawable getContentScrim() {
        return this.f79934p;
    }

    public int getExpandedTitleGravity() {
        return this.f79930l.B();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f79928j;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f79927i;
    }

    public int getExpandedTitleMarginStart() {
        return this.f79925g;
    }

    public int getExpandedTitleMarginTop() {
        return this.f79926h;
    }

    public float getExpandedTitleTextSize() {
        return this.f79930l.D();
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f79930l.E();
    }

    public int getHyphenationFrequency() {
        return this.f79930l.H();
    }

    public int getLineCount() {
        return this.f79930l.I();
    }

    public float getLineSpacingAdd() {
        return this.f79930l.J();
    }

    public float getLineSpacingMultiplier() {
        return this.f79930l.K();
    }

    public int getMaxLines() {
        return this.f79930l.L();
    }

    int getScrimAlpha() {
        return this.f79936r;
    }

    public long getScrimAnimationDuration() {
        return this.f79939u;
    }

    public int getScrimVisibleHeightTrigger() {
        int i3 = this.f79942x;
        if (i3 >= 0) {
            return i3 + this.C + this.E;
        }
        WindowInsetsCompat windowInsetsCompat = this.B;
        int iM = windowInsetsCompat != null ? windowInsetsCompat.m() : 0;
        int iZ = ViewCompat.z(this);
        return iZ > 0 ? Math.min((iZ * 2) + iM, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f79935q;
    }

    public CharSequence getTitle() {
        if (this.f79932n) {
            return this.f79930l.O();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.A;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f79930l.N();
    }

    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f79930l.R();
    }

    final int i(View view) {
        return ((getHeight() - k(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    WindowInsetsCompat o(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.v(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.a(this.B, windowInsetsCompat2)) {
            this.B = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            ViewCompat.v0(this, ViewCompat.v(appBarLayout));
            if (this.f79943y == null) {
                this.f79943y = new OffsetUpdateListener();
            }
            appBarLayout.d(this.f79943y);
            ViewCompat.j0(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f79930l.Y(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.f79943y;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).v(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        WindowInsetsCompat windowInsetsCompat = this.B;
        if (windowInsetsCompat != null) {
            int iM = windowInsetsCompat.m();
            int childCount = getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (!ViewCompat.v(childAt) && childAt.getTop() < iM) {
                    ViewCompat.X(childAt, iM);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i8 = 0; i8 < childCount2; i8++) {
            k(getChildAt(i8)).d();
        }
        w(i3, i4, i5, i6, false);
        x();
        v();
        int childCount3 = getChildCount();
        for (int i9 = 0; i9 < childCount3; i9++) {
            k(getChildAt(i9)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        CollapsingToolbarLayout collapsingToolbarLayout;
        d();
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i4);
        WindowInsetsCompat windowInsetsCompat = this.B;
        int iM = windowInsetsCompat != null ? windowInsetsCompat.m() : 0;
        if ((mode == 0 || this.D) && iM > 0) {
            this.C = iM;
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iM, 1073741824));
        }
        if (!this.F || this.f79930l.L() <= 1) {
            collapsingToolbarLayout = this;
        } else {
            x();
            collapsingToolbarLayout = this;
            collapsingToolbarLayout.w(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int iZ = collapsingToolbarLayout.f79930l.z();
            if (iZ > 1) {
                collapsingToolbarLayout.E = Math.round(collapsingToolbarLayout.f79930l.A()) * (iZ - 1);
                super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + collapsingToolbarLayout.E, 1073741824));
            }
        }
        ViewGroup viewGroup = collapsingToolbarLayout.f79922c;
        if (viewGroup != null) {
            View view = collapsingToolbarLayout.f79923d;
            if (view == null || view == collapsingToolbarLayout) {
                setMinimumHeight(h(viewGroup));
            } else {
                setMinimumHeight(h(view));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        Drawable drawable = this.f79934p;
        if (drawable != null) {
            s(drawable, i3, i4);
        }
    }

    public void p(boolean z2, boolean z3) {
        if (this.f79937s != z2) {
            if (z3) {
                a(z2 ? 255 : 0);
            } else {
                setScrimAlpha(z2 ? 255 : 0);
            }
            this.f79937s = z2;
        }
    }

    public void setCollapsedTitleGravity(int i3) {
        this.f79930l.j0(i3);
    }

    public void setCollapsedTitleTextAppearance(int i3) {
        this.f79930l.g0(i3);
    }

    public void setCollapsedTitleTextColor(int i3) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setCollapsedTitleTextSize(float f3) {
        this.f79930l.k0(f3);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f79930l.l0(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f79934p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f79934p = drawableMutate;
            if (drawableMutate != null) {
                s(drawableMutate, getWidth(), getHeight());
                this.f79934p.setCallback(this);
                this.f79934p.setAlpha(this.f79936r);
            }
            ViewCompat.d0(this);
        }
    }

    public void setContentScrimColor(int i3) {
        setContentScrim(new ColorDrawable(i3));
    }

    public void setContentScrimResource(int i3) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i3));
    }

    public void setExpandedTitleColor(int i3) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setExpandedTitleGravity(int i3) {
        this.f79930l.u0(i3);
    }

    public void setExpandedTitleMarginBottom(int i3) {
        this.f79928j = i3;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i3) {
        this.f79927i = i3;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i3) {
        this.f79925g = i3;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i3) {
        this.f79926h = i3;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i3) {
        this.f79930l.r0(i3);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f79930l.t0(colorStateList);
    }

    public void setExpandedTitleTextSize(float f3) {
        this.f79930l.v0(f3);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f79930l.w0(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z2) {
        this.F = z2;
    }

    public void setForceApplySystemWindowInsetTop(boolean z2) {
        this.D = z2;
    }

    public void setHyphenationFrequency(int i3) {
        this.f79930l.B0(i3);
    }

    public void setLineSpacingAdd(float f3) {
        this.f79930l.D0(f3);
    }

    public void setLineSpacingMultiplier(float f3) {
        this.f79930l.E0(f3);
    }

    public void setMaxLines(int i3) {
        this.f79930l.F0(i3);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z2) {
        this.f79930l.H0(z2);
    }

    void setScrimAlpha(int i3) {
        ViewGroup viewGroup;
        if (i3 != this.f79936r) {
            if (this.f79934p != null && (viewGroup = this.f79922c) != null) {
                ViewCompat.d0(viewGroup);
            }
            this.f79936r = i3;
            ViewCompat.d0(this);
        }
    }

    public void setScrimAnimationDuration(long j3) {
        this.f79939u = j3;
    }

    public void setScrimVisibleHeightTrigger(int i3) {
        if (this.f79942x != i3) {
            this.f79942x = i3;
            v();
        }
    }

    public void setScrimsShown(boolean z2) {
        p(z2, ViewCompat.R(this) && !isInEditMode());
    }

    public void setStaticLayoutBuilderConfigurer(StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        this.f79930l.J0(staticLayoutBuilderConfigurer);
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f79935q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f79935q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f79935q.setState(getDrawableState());
                }
                DrawableCompat.m(this.f79935q, ViewCompat.y(this));
                this.f79935q.setVisible(getVisibility() == 0, false);
                this.f79935q.setCallback(this);
                this.f79935q.setAlpha(this.f79936r);
            }
            ViewCompat.d0(this);
        }
    }

    public void setStatusBarScrimColor(int i3) {
        setStatusBarScrim(new ColorDrawable(i3));
    }

    public void setStatusBarScrimResource(int i3) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i3));
    }

    public void setTitle(CharSequence charSequence) {
        this.f79930l.K0(charSequence);
        r();
    }

    public void setTitleCollapseMode(int i3) {
        this.A = i3;
        boolean zL = l();
        this.f79930l.z0(zL);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (zL && this.f79934p == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f79930l.M0(truncateAt);
    }

    public void setTitleEnabled(boolean z2) {
        if (z2 != this.f79932n) {
            this.f79932n = z2;
            r();
            u();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        this.f79930l.G0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z2 = i3 == 0;
        Drawable drawable = this.f79935q;
        if (drawable != null && drawable.isVisible() != z2) {
            this.f79935q.setVisible(z2, false);
        }
        Drawable drawable2 = this.f79934p;
        if (drawable2 == null || drawable2.isVisible() == z2) {
            return;
        }
        this.f79934p.setVisible(z2, false);
    }

    final void v() {
        if (this.f79934p == null && this.f79935q == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f79944z < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f79934p || drawable == this.f79935q;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i3) {
        int i4 = G;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f79920a = true;
        this.f79929k = new Rect();
        this.f79942x = -1;
        this.C = 0;
        this.E = 0;
        Context context2 = getContext();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.f79930l = collapsingTextHelper;
        collapsingTextHelper.L0(AnimationUtils.f79853e);
        collapsingTextHelper.H0(false);
        this.f79931m = new ElevationOverlayProvider(context2);
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, R.styleable.Z1, i3, i4, new int[0]);
        collapsingTextHelper.u0(typedArrayI.getInt(R.styleable.f79773e2, 8388691));
        collapsingTextHelper.j0(typedArrayI.getInt(R.styleable.f79757a2, 8388627));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R.styleable.f79777f2, 0);
        this.f79928j = dimensionPixelSize;
        this.f79927i = dimensionPixelSize;
        this.f79926h = dimensionPixelSize;
        this.f79925g = dimensionPixelSize;
        int i5 = R.styleable.f79789i2;
        if (typedArrayI.hasValue(i5)) {
            this.f79925g = typedArrayI.getDimensionPixelSize(i5, 0);
        }
        int i6 = R.styleable.f79785h2;
        if (typedArrayI.hasValue(i6)) {
            this.f79927i = typedArrayI.getDimensionPixelSize(i6, 0);
        }
        int i7 = R.styleable.f79793j2;
        if (typedArrayI.hasValue(i7)) {
            this.f79926h = typedArrayI.getDimensionPixelSize(i7, 0);
        }
        int i8 = R.styleable.f79781g2;
        if (typedArrayI.hasValue(i8)) {
            this.f79928j = typedArrayI.getDimensionPixelSize(i8, 0);
        }
        this.f79932n = typedArrayI.getBoolean(R.styleable.u2, true);
        setTitle(typedArrayI.getText(R.styleable.s2));
        collapsingTextHelper.r0(R.style.f79735h);
        collapsingTextHelper.g0(androidx.appcompat.R.style.f801c);
        int i9 = R.styleable.f79797k2;
        if (typedArrayI.hasValue(i9)) {
            collapsingTextHelper.r0(typedArrayI.getResourceId(i9, 0));
        }
        int i10 = R.styleable.f79761b2;
        if (typedArrayI.hasValue(i10)) {
            collapsingTextHelper.g0(typedArrayI.getResourceId(i10, 0));
        }
        int i11 = R.styleable.w2;
        if (typedArrayI.hasValue(i11)) {
            setTitleEllipsize(b(typedArrayI.getInt(i11, -1)));
        }
        int i12 = R.styleable.f79801l2;
        if (typedArrayI.hasValue(i12)) {
            collapsingTextHelper.t0(MaterialResources.a(context2, typedArrayI, i12));
        }
        int i13 = R.styleable.f79765c2;
        if (typedArrayI.hasValue(i13)) {
            collapsingTextHelper.i0(MaterialResources.a(context2, typedArrayI, i13));
        }
        this.f79942x = typedArrayI.getDimensionPixelSize(R.styleable.f79821q2, -1);
        int i14 = R.styleable.f79813o2;
        if (typedArrayI.hasValue(i14)) {
            collapsingTextHelper.F0(typedArrayI.getInt(i14, 1));
        }
        int i15 = R.styleable.v2;
        if (typedArrayI.hasValue(i15)) {
            collapsingTextHelper.G0(android.view.animation.AnimationUtils.loadInterpolator(context2, typedArrayI.getResourceId(i15, 0)));
        }
        this.f79939u = typedArrayI.getInt(R.styleable.f79817p2, 600);
        int i16 = R.attr.f79493i0;
        this.f79940v = MotionUtils.g(context2, i16, AnimationUtils.f79851c);
        this.f79941w = MotionUtils.g(context2, i16, AnimationUtils.f79852d);
        setContentScrim(typedArrayI.getDrawable(R.styleable.f79769d2));
        setStatusBarScrim(typedArrayI.getDrawable(R.styleable.r2));
        setTitleCollapseMode(typedArrayI.getInt(R.styleable.t2, 0));
        this.f79921b = typedArrayI.getResourceId(R.styleable.x2, -1);
        this.D = typedArrayI.getBoolean(R.styleable.f79809n2, false);
        this.F = typedArrayI.getBoolean(R.styleable.f79805m2, false);
        typedArrayI.recycle();
        setWillNotDraw(false);
        ViewCompat.C0(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.o(windowInsetsCompat);
            }
        });
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f79930l.i0(colorStateList);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f79947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f79948b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f79947a = 0;
            this.f79948b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.y2);
            this.f79947a = typedArrayObtainStyledAttributes.getInt(R.styleable.z2, 0);
            a(typedArrayObtainStyledAttributes.getFloat(R.styleable.A2, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(float f3) {
            this.f79948b = f3;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f79947a = 0;
            this.f79948b = 0.5f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f79947a = 0;
            this.f79948b = 0.5f;
        }
    }
}
