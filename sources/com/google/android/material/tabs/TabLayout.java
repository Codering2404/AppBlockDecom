package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final int f82128b0 = R.style.f79747t;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final Pools.Pool f82129c0 = new Pools.SynchronizedPool(16);
    private int A;
    int B;
    int C;
    int D;
    int E;
    boolean F;
    boolean G;
    int H;
    int I;
    boolean J;
    private TabIndicatorInterpolator K;
    private final TimeInterpolator L;
    private BaseOnTabSelectedListener M;
    private final ArrayList N;
    private BaseOnTabSelectedListener O;
    private ValueAnimator P;
    ViewPager Q;
    private PagerAdapter R;
    private DataSetObserver S;
    private TabLayoutOnPageChangeListener T;
    private AdapterChangeListener U;
    private boolean V;
    private int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f82130a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final Pools.Pool f82131a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f82132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Tab f82133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final SlidingTabIndicator f82134d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f82135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f82136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f82137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f82138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f82139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f82140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f82141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ColorStateList f82142m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ColorStateList f82143n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ColorStateList f82144o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Drawable f82145p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f82146q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    PorterDuff.Mode f82147r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    float f82148s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f82149t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    float f82150u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final int f82151v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f82152w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f82153x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f82154y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f82155z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f82157a;

        AdapterChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.Q == viewPager) {
                tabLayout.M(pagerAdapter2, this.f82157a);
            }
        }

        void b(boolean z2) {
            this.f82157a = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void a(Tab tab);

        void b(Tab tab);

        void c(Tab tab);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface LabelVisibility {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.F();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.F();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class SlidingTabIndicator extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ValueAnimator f82160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f82161b;

        SlidingTabIndicator(Context context) {
            super(context);
            this.f82161b = -1;
            setWillNotDraw(false);
        }

        private void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f82130a == -1) {
                tabLayout.f82130a = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.f82130a);
        }

        private void f(int i3) {
            if (TabLayout.this.W == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i3);
                TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.K;
                TabLayout tabLayout = TabLayout.this;
                tabIndicatorInterpolator.c(tabLayout, childAt, tabLayout.f82145p);
                TabLayout.this.f82130a = i3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(View view, View view2, float f3) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.f82145p;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f82145p.getBounds().bottom);
            } else {
                TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.K;
                TabLayout tabLayout = TabLayout.this;
                tabIndicatorInterpolator.d(tabLayout, view, view2, f3, tabLayout.f82145p);
            }
            ViewCompat.d0(this);
        }

        private void k(boolean z2, int i3, int i4) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f82130a == i3) {
                return;
            }
            final View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            final View childAt2 = getChildAt(i3);
            if (childAt2 == null) {
                g();
                return;
            }
            TabLayout.this.f82130a = i3;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SlidingTabIndicator.this.j(childAt, childAt2, valueAnimator.getAnimatedFraction());
                }
            };
            if (!z2) {
                this.f82160a.removeAllUpdateListeners();
                this.f82160a.addUpdateListener(animatorUpdateListener);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f82160a = valueAnimator;
            valueAnimator.setInterpolator(TabLayout.this.L);
            valueAnimator.setDuration(i4);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(animatorUpdateListener);
            valueAnimator.start();
        }

        void c(int i3, int i4) {
            ValueAnimator valueAnimator = this.f82160a;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.f82130a != i3) {
                this.f82160a.cancel();
            }
            k(true, i3, i4);
        }

        boolean d() {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (getChildAt(i3).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            int iHeight = TabLayout.this.f82145p.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.f82145p.getIntrinsicHeight();
            }
            int i3 = TabLayout.this.D;
            if (i3 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i3 != 1) {
                height = 0;
                if (i3 != 2) {
                    iHeight = i3 != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (TabLayout.this.f82145p.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f82145p.getBounds();
                TabLayout.this.f82145p.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout.this.f82145p.draw(canvas);
            }
            super.draw(canvas);
        }

        void h(int i3, float f3) {
            TabLayout.this.f82130a = Math.round(i3 + f3);
            ValueAnimator valueAnimator = this.f82160a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f82160a.cancel();
            }
            j(getChildAt(i3), getChildAt(i3 + 1), f3);
        }

        void i(int i3) {
            Rect bounds = TabLayout.this.f82145p.getBounds();
            TabLayout.this.f82145p.setBounds(bounds.left, 0, bounds.right, i3);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
            super.onLayout(z2, i3, i4, i5, i6);
            ValueAnimator valueAnimator = this.f82160a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i3, int i4) {
            super.onMeasure(i3, i4);
            if (View.MeasureSpec.getMode(i3) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z2 = true;
            if (tabLayout.B == 1 || tabLayout.E == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) ViewUtils.g(getContext(), 16)) * 2)) {
                    boolean z3 = false;
                    for (int i6 = 0; i6 < childCount; i6++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z3 = true;
                        }
                    }
                    z2 = z3;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.B = 0;
                    tabLayout2.U(false);
                }
                if (z2) {
                    super.onMeasure(i3, i4);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i3) {
            super.onRtlPropertiesChanged(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Tab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f82166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Drawable f82167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f82168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f82169d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f82171f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public TabLayout f82173h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public TabView f82174i;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f82170e = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f82172g = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f82175j = -1;

        public View e() {
            return this.f82171f;
        }

        public Drawable f() {
            return this.f82167b;
        }

        public int g() {
            return this.f82170e;
        }

        public int h() {
            return this.f82172g;
        }

        public CharSequence i() {
            return this.f82168c;
        }

        public boolean j() {
            TabLayout tabLayout = this.f82173h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.f82170e;
        }

        void k() {
            this.f82173h = null;
            this.f82174i = null;
            this.f82166a = null;
            this.f82167b = null;
            this.f82175j = -1;
            this.f82168c = null;
            this.f82169d = null;
            this.f82170e = -1;
            this.f82171f = null;
        }

        public void l() {
            TabLayout tabLayout = this.f82173h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.K(this);
        }

        public Tab m(CharSequence charSequence) {
            this.f82169d = charSequence;
            s();
            return this;
        }

        public Tab n(int i3) {
            return o(LayoutInflater.from(this.f82174i.getContext()).inflate(i3, (ViewGroup) this.f82174i, false));
        }

        public Tab o(View view) {
            this.f82171f = view;
            s();
            return this;
        }

        public Tab p(Drawable drawable) {
            this.f82167b = drawable;
            TabLayout tabLayout = this.f82173h;
            if (tabLayout.B == 1 || tabLayout.E == 2) {
                tabLayout.U(true);
            }
            s();
            if (BadgeUtils.f80041a && this.f82174i.l() && this.f82174i.f82183f.isVisible()) {
                this.f82174i.invalidate();
            }
            return this;
        }

        void q(int i3) {
            this.f82170e = i3;
        }

        public Tab r(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f82169d) && !TextUtils.isEmpty(charSequence)) {
                this.f82174i.setContentDescription(charSequence);
            }
            this.f82168c = charSequence;
            s();
            return this;
        }

        void s() {
            TabView tabView = this.f82174i;
            if (tabView != null) {
                tabView.t();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorAnimationMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f82176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f82177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f82178c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f82176a = new WeakReference(tabLayout);
        }

        void a() {
            this.f82178c = 0;
            this.f82177b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            this.f82177b = this.f82178c;
            this.f82178c = i3;
            TabLayout tabLayout = (TabLayout) this.f82176a.get();
            if (tabLayout != null) {
                tabLayout.V(this.f82178c);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f3, int i4) {
            boolean z2;
            TabLayout tabLayout = (TabLayout) this.f82176a.get();
            if (tabLayout != null) {
                int i5 = this.f82178c;
                boolean z3 = true;
                if (i5 != 2 || this.f82177b == 1) {
                    z2 = true;
                } else {
                    z2 = true;
                    z3 = false;
                }
                if (i5 == 2 && this.f82177b == 0) {
                    z2 = false;
                }
                tabLayout.P(i3, f3, z3, z2, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            TabLayout tabLayout = (TabLayout) this.f82176a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i3 || i3 >= tabLayout.getTabCount()) {
                return;
            }
            int i4 = this.f82178c;
            tabLayout.L(tabLayout.B(i3), i4 == 0 || (i4 == 2 && this.f82177b == 0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class TabView extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Tab f82179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f82180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImageView f82181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private View f82182d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private BadgeDrawable f82183f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private View f82184g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private TextView f82185h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ImageView f82186i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Drawable f82187j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f82188k;

        public TabView(Context context) {
            super(context);
            this.f82188k = 2;
            u(context);
            ViewCompat.D0(this, TabLayout.this.f82135f, TabLayout.this.f82136g, TabLayout.this.f82137h, TabLayout.this.f82138i);
            setGravity(17);
            setOrientation(!TabLayout.this.F ? 1 : 0);
            setClickable(true);
            ViewCompat.E0(this, PointerIconCompat.b(getContext(), 1002));
        }

        private void f(final View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    if (view.getVisibility() == 0) {
                        TabView.this.s(view);
                    }
                }
            });
        }

        private float g(Layout layout, int i3, float f3) {
            return layout.getLineWidth(i3) * (f3 / layout.getPaint().getTextSize());
        }

        private BadgeDrawable getBadge() {
            return this.f82183f;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.f82183f == null) {
                this.f82183f = BadgeDrawable.d(getContext());
            }
            r();
            BadgeDrawable badgeDrawable = this.f82183f;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h(boolean z2) {
            setClipChildren(z2);
            setClipToPadding(z2);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z2);
                viewGroup.setClipToPadding(z2);
            }
        }

        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Canvas canvas) {
            Drawable drawable = this.f82187j;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f82187j.draw(canvas);
            }
        }

        private FrameLayout k(View view) {
            if ((view == this.f82181c || view == this.f82180b) && BadgeUtils.f80041a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean l() {
            return this.f82183f != null;
        }

        private void m() {
            ViewGroup viewGroup;
            if (BadgeUtils.f80041a) {
                FrameLayout frameLayoutI = i();
                addView(frameLayoutI, 0);
                viewGroup = frameLayoutI;
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.f79674e, viewGroup, false);
            this.f82181c = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void n() {
            ViewGroup viewGroup;
            if (BadgeUtils.f80041a) {
                FrameLayout frameLayoutI = i();
                addView(frameLayoutI);
                viewGroup = frameLayoutI;
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.f79675f, viewGroup, false);
            this.f82180b = textView;
            viewGroup.addView(textView);
        }

        private void p(View view) {
            if (l() && view != null) {
                h(false);
                BadgeUtils.c(this.f82183f, view, k(view));
                this.f82182d = view;
            }
        }

        private void q() {
            if (l()) {
                h(true);
                View view = this.f82182d;
                if (view != null) {
                    BadgeUtils.f(this.f82183f, view);
                    this.f82182d = null;
                }
            }
        }

        private void r() {
            Tab tab;
            Tab tab2;
            if (l()) {
                if (this.f82184g != null) {
                    q();
                    return;
                }
                if (this.f82181c != null && (tab2 = this.f82179a) != null && tab2.f() != null) {
                    View view = this.f82182d;
                    ImageView imageView = this.f82181c;
                    if (view == imageView) {
                        s(imageView);
                        return;
                    } else {
                        q();
                        p(this.f82181c);
                        return;
                    }
                }
                if (this.f82180b == null || (tab = this.f82179a) == null || tab.h() != 1) {
                    q();
                    return;
                }
                View view2 = this.f82182d;
                TextView textView = this.f82180b;
                if (view2 == textView) {
                    s(textView);
                } else {
                    q();
                    p(this.f82180b);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(View view) {
            if (l() && view == this.f82182d) {
                BadgeUtils.g(this.f82183f, view, k(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(Context context) {
            int i3 = TabLayout.this.f82151v;
            if (i3 != 0) {
                Drawable drawableB = AppCompatResources.b(context, i3);
                this.f82187j = drawableB;
                if (drawableB != null && drawableB.isStateful()) {
                    this.f82187j.setState(getDrawableState());
                }
            } else {
                this.f82187j = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            Drawable rippleDrawable = gradientDrawable;
            if (TabLayout.this.f82144o != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = RippleUtils.a(TabLayout.this.f82144o);
                boolean z2 = TabLayout.this.J;
                GradientDrawable gradientDrawable3 = gradientDrawable;
                if (z2) {
                    gradientDrawable3 = null;
                }
                rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, z2 ? null : gradientDrawable2);
            }
            ViewCompat.q0(this, rippleDrawable);
            TabLayout.this.invalidate();
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void x(android.widget.TextView r8, android.widget.ImageView r9, boolean r10) {
            /*
                Method dump skipped, instruction units count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.x(android.widget.TextView, android.widget.ImageView, boolean):void");
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f82187j;
            if ((drawable == null || !drawable.isStateful()) ? false : this.f82187j.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        int getContentHeight() {
            View[] viewArr = {this.f82180b, this.f82181c, this.f82184g};
            int iMax = 0;
            int iMin = 0;
            boolean z2 = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z2 ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z2 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z2 = true;
                }
            }
            return iMax - iMin;
        }

        int getContentWidth() {
            View[] viewArr = {this.f82180b, this.f82181c, this.f82184g};
            int iMax = 0;
            int iMin = 0;
            boolean z2 = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z2 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z2 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z2 = true;
                }
            }
            return iMax - iMin;
        }

        public Tab getTab() {
            return this.f82179a;
        }

        void o() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatZ0 = AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f82183f;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfoCompatZ0.m0(this.f82183f.i());
            }
            accessibilityNodeInfoCompatZ0.l0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, this.f82179a.g(), 1, false, isSelected()));
            if (isSelected()) {
                accessibilityNodeInfoCompatZ0.j0(false);
                accessibilityNodeInfoCompatZ0.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34572i);
            }
            accessibilityNodeInfoCompatZ0.I0(getResources().getString(R.string.f79709h));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i3, int i4) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i3 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f82152w, Integer.MIN_VALUE);
            }
            super.onMeasure(i3, i4);
            if (this.f82180b != null) {
                float f3 = TabLayout.this.f82148s;
                int i5 = this.f82188k;
                ImageView imageView = this.f82181c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f82180b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f3 = TabLayout.this.f82150u;
                    }
                } else {
                    i5 = 1;
                }
                float textSize = this.f82180b.getTextSize();
                int lineCount = this.f82180b.getLineCount();
                int iD = TextViewCompat.d(this.f82180b);
                if (f3 != textSize || (iD >= 0 && i5 != iD)) {
                    if (TabLayout.this.E != 1 || f3 <= textSize || lineCount != 1 || ((layout = this.f82180b.getLayout()) != null && g(layout, 0, f3) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.f82180b.setTextSize(0, f3);
                        this.f82180b.setMaxLines(i5);
                        super.onMeasure(i3, i4);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f82179a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f82179a.l();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z2) {
            isSelected();
            super.setSelected(z2);
            TextView textView = this.f82180b;
            if (textView != null) {
                textView.setSelected(z2);
            }
            ImageView imageView = this.f82181c;
            if (imageView != null) {
                imageView.setSelected(z2);
            }
            View view = this.f82184g;
            if (view != null) {
                view.setSelected(z2);
            }
        }

        void setTab(Tab tab) {
            if (tab != this.f82179a) {
                this.f82179a = tab;
                t();
            }
        }

        final void t() {
            w();
            Tab tab = this.f82179a;
            setSelected(tab != null && tab.j());
        }

        final void v() {
            setOrientation(!TabLayout.this.F ? 1 : 0);
            TextView textView = this.f82185h;
            if (textView == null && this.f82186i == null) {
                x(this.f82180b, this.f82181c, true);
            } else {
                x(textView, this.f82186i, false);
            }
        }

        final void w() {
            ViewParent parent;
            Tab tab = this.f82179a;
            View viewE = tab != null ? tab.e() : null;
            if (viewE != null) {
                ViewParent parent2 = viewE.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(viewE);
                    }
                    View view = this.f82184g;
                    if (view != null && (parent = view.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f82184g);
                    }
                    addView(viewE);
                }
                this.f82184g = viewE;
                TextView textView = this.f82180b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f82181c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f82181c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewE.findViewById(android.R.id.text1);
                this.f82185h = textView2;
                if (textView2 != null) {
                    this.f82188k = TextViewCompat.d(textView2);
                }
                this.f82186i = (ImageView) viewE.findViewById(android.R.id.icon);
            } else {
                View view2 = this.f82184g;
                if (view2 != null) {
                    removeView(view2);
                    this.f82184g = null;
                }
                this.f82185h = null;
                this.f82186i = null;
            }
            if (this.f82184g == null) {
                if (this.f82181c == null) {
                    m();
                }
                if (this.f82180b == null) {
                    n();
                    this.f82188k = TextViewCompat.d(this.f82180b);
                }
                TextViewCompat.o(this.f82180b, TabLayout.this.f82139j);
                if (!isSelected() || TabLayout.this.f82141l == -1) {
                    TextViewCompat.o(this.f82180b, TabLayout.this.f82140k);
                } else {
                    TextViewCompat.o(this.f82180b, TabLayout.this.f82141l);
                }
                ColorStateList colorStateList = TabLayout.this.f82142m;
                if (colorStateList != null) {
                    this.f82180b.setTextColor(colorStateList);
                }
                x(this.f82180b, this.f82181c, true);
                r();
                f(this.f82181c);
                f(this.f82180b);
            } else {
                TextView textView3 = this.f82185h;
                if (textView3 != null || this.f82186i != null) {
                    x(textView3, this.f82186i, false);
                }
            }
            if (tab == null || TextUtils.isEmpty(tab.f82169d)) {
                return;
            }
            setContentDescription(tab.f82169d);
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f79527z0);
    }

    private void A() {
        if (this.P == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.P = valueAnimator;
            valueAnimator.setInterpolator(this.L);
            this.P.setDuration(this.C);
            this.P.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private boolean C() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    private void J(int i3) {
        TabView tabView = (TabView) this.f82134d.getChildAt(i3);
        this.f82134d.removeViewAt(i3);
        if (tabView != null) {
            tabView.o();
            this.f82131a0.b(tabView);
        }
        requestLayout();
    }

    private void R(ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.Q;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.T;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.U;
            if (adapterChangeListener != null) {
                this.Q.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.O;
        if (baseOnTabSelectedListener != null) {
            I(baseOnTabSelectedListener);
            this.O = null;
        }
        if (viewPager != null) {
            this.Q = viewPager;
            if (this.T == null) {
                this.T = new TabLayoutOnPageChangeListener(this);
            }
            this.T.a();
            viewPager.addOnPageChangeListener(this.T);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.O = viewPagerOnTabSelectedListener;
            g(viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                M(adapter, z2);
            }
            if (this.U == null) {
                this.U = new AdapterChangeListener();
            }
            this.U.b(z2);
            viewPager.addOnAdapterChangeListener(this.U);
            N(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.Q = null;
            M(null, false);
        }
        this.V = z3;
    }

    private void S() {
        int size = this.f82132b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Tab) this.f82132b.get(i3)).s();
        }
    }

    private void T(LinearLayout.LayoutParams layoutParams) {
        if (this.E == 1 && this.B == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private int getDefaultHeight() {
        int size = this.f82132b.size();
        for (int i3 = 0; i3 < size; i3++) {
            Tab tab = (Tab) this.f82132b.get(i3);
            if (tab != null && tab.f() != null && !TextUtils.isEmpty(tab.i())) {
                return !this.F ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i3 = this.f82153x;
        if (i3 != -1) {
            return i3;
        }
        int i4 = this.E;
        if (i4 == 0 || i4 == 2) {
            return this.f82155z;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f82134d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void l(TabItem tabItem) {
        Tab tabE = E();
        CharSequence charSequence = tabItem.f82125a;
        if (charSequence != null) {
            tabE.r(charSequence);
        }
        Drawable drawable = tabItem.f82126b;
        if (drawable != null) {
            tabE.p(drawable);
        }
        int i3 = tabItem.f82127c;
        if (i3 != 0) {
            tabE.n(i3);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            tabE.m(tabItem.getContentDescription());
        }
        i(tabE);
    }

    private void m(Tab tab) {
        TabView tabView = tab.f82174i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f82134d.addView(tabView, tab.g(), u());
    }

    private void n(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        l((TabItem) view);
    }

    private void o(int i3) {
        if (i3 == -1) {
            return;
        }
        if (getWindowToken() == null || !ViewCompat.R(this) || this.f82134d.d()) {
            N(i3, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iR = r(i3, 0.0f);
        if (scrollX != iR) {
            A();
            this.P.setIntValues(scrollX, iR);
            this.P.start();
        }
        this.f82134d.c(i3, this.C);
    }

    private void p(int i3) {
        if (i3 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i3 == 1) {
            this.f82134d.setGravity(1);
            return;
        } else if (i3 != 2) {
            return;
        }
        this.f82134d.setGravity(8388611);
    }

    private void q() {
        int i3 = this.E;
        ViewCompat.D0(this.f82134d, (i3 == 0 || i3 == 2) ? Math.max(0, this.A - this.f82135f) : 0, 0, 0, 0);
        int i4 = this.E;
        if (i4 == 0) {
            p(this.B);
        } else if (i4 == 1 || i4 == 2) {
            if (this.B == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f82134d.setGravity(1);
        }
        U(true);
    }

    private int r(int i3, float f3) {
        View childAt;
        int i4 = this.E;
        if ((i4 != 0 && i4 != 2) || (childAt = this.f82134d.getChildAt(i3)) == null) {
            return 0;
        }
        int i5 = i3 + 1;
        View childAt2 = i5 < this.f82134d.getChildCount() ? this.f82134d.getChildAt(i5) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i6 = (int) ((width + width2) * 0.5f * f3);
        return ViewCompat.y(this) == 0 ? left + i6 : left - i6;
    }

    private void s(Tab tab, int i3) {
        tab.q(i3);
        this.f82132b.add(i3, tab);
        int size = this.f82132b.size();
        int i4 = -1;
        for (int i5 = i3 + 1; i5 < size; i5++) {
            if (((Tab) this.f82132b.get(i5)).g() == this.f82130a) {
                i4 = i5;
            }
            ((Tab) this.f82132b.get(i5)).q(i5);
        }
        this.f82130a = i4;
    }

    private void setSelectedTabView(int i3) {
        int childCount = this.f82134d.getChildCount();
        if (i3 < childCount) {
            int i4 = 0;
            while (i4 < childCount) {
                View childAt = this.f82134d.getChildAt(i4);
                if ((i4 != i3 || childAt.isSelected()) && (i4 == i3 || !childAt.isSelected())) {
                    childAt.setSelected(i4 == i3);
                    childAt.setActivated(i4 == i3);
                } else {
                    childAt.setSelected(i4 == i3);
                    childAt.setActivated(i4 == i3);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).w();
                    }
                }
                i4++;
            }
        }
    }

    private static ColorStateList t(int i3, int i4) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i4, i3});
    }

    private LinearLayout.LayoutParams u() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        T(layoutParams);
        return layoutParams;
    }

    private TabView w(Tab tab) {
        Pools.Pool pool = this.f82131a0;
        TabView tabView = pool != null ? (TabView) pool.a() : null;
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.f82169d)) {
            tabView.setContentDescription(tab.f82168c);
            return tabView;
        }
        tabView.setContentDescription(tab.f82169d);
        return tabView;
    }

    private void x(Tab tab) {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            ((BaseOnTabSelectedListener) this.N.get(size)).c(tab);
        }
    }

    private void y(Tab tab) {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            ((BaseOnTabSelectedListener) this.N.get(size)).a(tab);
        }
    }

    private void z(Tab tab) {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            ((BaseOnTabSelectedListener) this.N.get(size)).b(tab);
        }
    }

    public Tab B(int i3) {
        if (i3 < 0 || i3 >= getTabCount()) {
            return null;
        }
        return (Tab) this.f82132b.get(i3);
    }

    public boolean D() {
        return this.G;
    }

    public Tab E() {
        Tab tabV = v();
        tabV.f82173h = this;
        tabV.f82174i = w(tabV);
        if (tabV.f82175j != -1) {
            tabV.f82174i.setId(tabV.f82175j);
        }
        return tabV;
    }

    void F() {
        int currentItem;
        H();
        PagerAdapter pagerAdapter = this.R;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                k(E().r(this.R.getPageTitle(i3)), false);
            }
            ViewPager viewPager = this.Q;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            K(B(currentItem));
        }
    }

    protected boolean G(Tab tab) {
        return f82129c0.b(tab);
    }

    public void H() {
        for (int childCount = this.f82134d.getChildCount() - 1; childCount >= 0; childCount--) {
            J(childCount);
        }
        Iterator it = this.f82132b.iterator();
        while (it.hasNext()) {
            Tab tab = (Tab) it.next();
            it.remove();
            tab.k();
            G(tab);
        }
        this.f82133c = null;
    }

    public void I(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.N.remove(baseOnTabSelectedListener);
    }

    public void K(Tab tab) {
        L(tab, true);
    }

    public void L(Tab tab, boolean z2) {
        Tab tab2 = this.f82133c;
        if (tab2 == tab) {
            if (tab2 != null) {
                x(tab);
                o(tab.g());
                return;
            }
            return;
        }
        int iG = tab != null ? tab.g() : -1;
        if (z2) {
            if ((tab2 == null || tab2.g() == -1) && iG != -1) {
                N(iG, 0.0f, true);
            } else {
                o(iG);
            }
            if (iG != -1) {
                setSelectedTabView(iG);
            }
        }
        this.f82133c = tab;
        if (tab2 != null && tab2.f82173h != null) {
            z(tab2);
        }
        if (tab != null) {
            y(tab);
        }
    }

    void M(PagerAdapter pagerAdapter, boolean z2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.R;
        if (pagerAdapter2 != null && (dataSetObserver = this.S) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.R = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.S == null) {
                this.S = new PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.S);
        }
        F();
    }

    public void N(int i3, float f3, boolean z2) {
        O(i3, f3, z2, true);
    }

    public void O(int i3, float f3, boolean z2, boolean z3) {
        P(i3, f3, z2, z3, true);
    }

    void P(int i3, float f3, boolean z2, boolean z3, boolean z4) {
        int iRound = Math.round(i3 + f3);
        if (iRound < 0 || iRound >= this.f82134d.getChildCount()) {
            return;
        }
        if (z3) {
            this.f82134d.h(i3, f3);
        }
        ValueAnimator valueAnimator = this.P;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.P.cancel();
        }
        int iR = r(i3, f3);
        int scrollX = getScrollX();
        boolean z5 = (i3 < getSelectedTabPosition() && iR >= scrollX) || (i3 > getSelectedTabPosition() && iR <= scrollX) || i3 == getSelectedTabPosition();
        if (ViewCompat.y(this) == 1) {
            z5 = (i3 < getSelectedTabPosition() && iR <= scrollX) || (i3 > getSelectedTabPosition() && iR >= scrollX) || i3 == getSelectedTabPosition();
        }
        if (z5 || this.W == 1 || z4) {
            if (i3 < 0) {
                iR = 0;
            }
            scrollTo(iR, 0);
        }
        if (z2) {
            setSelectedTabView(iRound);
        }
    }

    public void Q(ViewPager viewPager, boolean z2) {
        R(viewPager, z2, false);
    }

    void U(boolean z2) {
        for (int i3 = 0; i3 < this.f82134d.getChildCount(); i3++) {
            View childAt = this.f82134d.getChildAt(i3);
            childAt.setMinimumWidth(getTabMinWidth());
            T((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    void V(int i3) {
        this.W = i3;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        n(view);
    }

    public void g(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (this.N.contains(baseOnTabSelectedListener)) {
            return;
        }
        this.N.add(baseOnTabSelectedListener);
    }

    public int getSelectedTabPosition() {
        Tab tab = this.f82133c;
        if (tab != null) {
            return tab.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f82132b.size();
    }

    public int getTabGravity() {
        return this.B;
    }

    public ColorStateList getTabIconTint() {
        return this.f82143n;
    }

    public int getTabIndicatorAnimationMode() {
        return this.I;
    }

    public int getTabIndicatorGravity() {
        return this.D;
    }

    int getTabMaxWidth() {
        return this.f82152w;
    }

    public int getTabMode() {
        return this.E;
    }

    public ColorStateList getTabRippleColor() {
        return this.f82144o;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f82145p;
    }

    public ColorStateList getTabTextColors() {
        return this.f82142m;
    }

    public void h(OnTabSelectedListener onTabSelectedListener) {
        g(onTabSelectedListener);
    }

    public void i(Tab tab) {
        k(tab, this.f82132b.isEmpty());
    }

    public void j(Tab tab, int i3, boolean z2) {
        if (tab.f82173h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        s(tab, i3);
        m(tab);
        if (z2) {
            tab.l();
        }
    }

    public void k(Tab tab, boolean z2) {
        j(tab, this.f82132b.size(), z2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
        if (this.Q == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                R((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.V) {
            setupWithViewPager(null);
            this.V = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i3 = 0; i3 < this.f82134d.getChildCount(); i3++) {
            View childAt = this.f82134d.getChildAt(i3);
            if (childAt instanceof TabView) {
                ((TabView) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo).k0(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return C() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.ViewUtils.g(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.f82154y
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.ViewUtils.g(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.f82152w = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.E
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto Laa
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L81
            goto L8c
        L81:
            return
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto Laa
        L8c:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            r7.measure(r0, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || C()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        MaterialShapeUtils.d(this, f3);
    }

    public void setInlineLabel(boolean z2) {
        if (this.F != z2) {
            this.F = z2;
            for (int i3 = 0; i3 < this.f82134d.getChildCount(); i3++) {
                View childAt = this.f82134d.getChildAt(i3);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).v();
                }
            }
            q();
        }
    }

    public void setInlineLabelResource(int i3) {
        setInlineLabel(getResources().getBoolean(i3));
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        A();
        this.P.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = DrawableCompat.r(drawable).mutate();
        this.f82145p = drawableMutate;
        DrawableUtils.n(drawableMutate, this.f82146q);
        int intrinsicHeight = this.H;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.f82145p.getIntrinsicHeight();
        }
        this.f82134d.i(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i3) {
        this.f82146q = i3;
        DrawableUtils.n(this.f82145p, i3);
        U(false);
    }

    public void setSelectedTabIndicatorGravity(int i3) {
        if (this.D != i3) {
            this.D = i3;
            ViewCompat.d0(this.f82134d);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i3) {
        this.H = i3;
        this.f82134d.i(i3);
    }

    public void setTabGravity(int i3) {
        if (this.B != i3) {
            this.B = i3;
            q();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f82143n != colorStateList) {
            this.f82143n = colorStateList;
            S();
        }
    }

    public void setTabIconTintResource(int i3) {
        setTabIconTint(AppCompatResources.a(getContext(), i3));
    }

    public void setTabIndicatorAnimationMode(int i3) {
        this.I = i3;
        if (i3 == 0) {
            this.K = new TabIndicatorInterpolator();
            return;
        }
        if (i3 == 1) {
            this.K = new ElasticTabIndicatorInterpolator();
        } else {
            if (i3 == 2) {
                this.K = new FadeTabIndicatorInterpolator();
                return;
            }
            throw new IllegalArgumentException(i3 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.G = z2;
        this.f82134d.g();
        ViewCompat.d0(this.f82134d);
    }

    public void setTabMode(int i3) {
        if (i3 != this.E) {
            this.E = i3;
            q();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f82144o != colorStateList) {
            this.f82144o = colorStateList;
            for (int i3 = 0; i3 < this.f82134d.getChildCount(); i3++) {
                View childAt = this.f82134d.getChildAt(i3);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).u(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i3) {
        setTabRippleColor(AppCompatResources.a(getContext(), i3));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f82142m != colorStateList) {
            this.f82142m = colorStateList;
            S();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        M(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.J != z2) {
            this.J = z2;
            for (int i3 = 0; i3 < this.f82134d.getChildCount(); i3++) {
                View childAt = this.f82134d.getChildAt(i3);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).u(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i3) {
        setUnboundedRipple(getResources().getBoolean(i3));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        Q(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    protected Tab v() {
        Tab tab = (Tab) f82129c0.a();
        return tab == null ? new Tab() : tab;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f82128b0;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f82130a = -1;
        this.f82132b = new ArrayList();
        this.f82141l = -1;
        this.f82146q = 0;
        this.f82152w = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.H = -1;
        this.N = new ArrayList();
        this.f82131a0 = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context2);
        this.f82134d = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R.styleable.p7;
        int i5 = R.styleable.O7;
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, iArr, i3, i4, i5);
        ColorStateList colorStateListG = DrawableUtils.g(getBackground());
        if (colorStateListG != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.a0(colorStateListG);
            materialShapeDrawable.P(context2);
            materialShapeDrawable.Z(ViewCompat.t(this));
            ViewCompat.q0(this, materialShapeDrawable);
        }
        setSelectedTabIndicator(MaterialResources.e(context2, typedArrayI, R.styleable.v7));
        setSelectedTabIndicatorColor(typedArrayI.getColor(R.styleable.y7, 0));
        slidingTabIndicator.i(typedArrayI.getDimensionPixelSize(R.styleable.B7, -1));
        setSelectedTabIndicatorGravity(typedArrayI.getInt(R.styleable.A7, 0));
        setTabIndicatorAnimationMode(typedArrayI.getInt(R.styleable.x7, 0));
        setTabIndicatorFullWidth(typedArrayI.getBoolean(R.styleable.z7, true));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R.styleable.G7, 0);
        this.f82138i = dimensionPixelSize;
        this.f82137h = dimensionPixelSize;
        this.f82136g = dimensionPixelSize;
        this.f82135f = dimensionPixelSize;
        this.f82135f = typedArrayI.getDimensionPixelSize(R.styleable.J7, dimensionPixelSize);
        this.f82136g = typedArrayI.getDimensionPixelSize(R.styleable.K7, this.f82136g);
        this.f82137h = typedArrayI.getDimensionPixelSize(R.styleable.I7, this.f82137h);
        this.f82138i = typedArrayI.getDimensionPixelSize(R.styleable.H7, this.f82138i);
        if (ThemeEnforcement.g(context2)) {
            this.f82139j = R.attr.C0;
        } else {
            this.f82139j = R.attr.A0;
        }
        int resourceId = typedArrayI.getResourceId(i5, R.style.f79736i);
        this.f82140k = resourceId;
        int[] iArr2 = androidx.appcompat.R.styleable.c3;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr2);
        try {
            int i6 = androidx.appcompat.R.styleable.d3;
            this.f82148s = typedArrayObtainStyledAttributes.getDimensionPixelSize(i6, 0);
            int i7 = androidx.appcompat.R.styleable.g3;
            this.f82142m = MaterialResources.a(context2, typedArrayObtainStyledAttributes, i7);
            typedArrayObtainStyledAttributes.recycle();
            int i8 = R.styleable.M7;
            if (typedArrayI.hasValue(i8)) {
                this.f82141l = typedArrayI.getResourceId(i8, resourceId);
            }
            int i9 = this.f82141l;
            if (i9 != -1) {
                typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(i9, iArr2);
                try {
                    this.f82149t = typedArrayObtainStyledAttributes.getDimensionPixelSize(i6, (int) this.f82148s);
                    ColorStateList colorStateListA = MaterialResources.a(context2, typedArrayObtainStyledAttributes, i7);
                    if (colorStateListA != null) {
                        this.f82142m = t(this.f82142m.getDefaultColor(), colorStateListA.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListA.getDefaultColor()));
                    }
                } finally {
                }
            }
            int i10 = R.styleable.P7;
            if (typedArrayI.hasValue(i10)) {
                this.f82142m = MaterialResources.a(context2, typedArrayI, i10);
            }
            int i11 = R.styleable.N7;
            if (typedArrayI.hasValue(i11)) {
                this.f82142m = t(this.f82142m.getDefaultColor(), typedArrayI.getColor(i11, 0));
            }
            this.f82143n = MaterialResources.a(context2, typedArrayI, R.styleable.t7);
            this.f82147r = ViewUtils.p(typedArrayI.getInt(R.styleable.u7, -1), null);
            this.f82144o = MaterialResources.a(context2, typedArrayI, R.styleable.L7);
            this.C = typedArrayI.getInt(R.styleable.w7, 300);
            this.L = MotionUtils.g(context2, R.attr.f79487f0, AnimationUtils.f79850b);
            this.f82153x = typedArrayI.getDimensionPixelSize(R.styleable.E7, -1);
            this.f82154y = typedArrayI.getDimensionPixelSize(R.styleable.D7, -1);
            this.f82151v = typedArrayI.getResourceId(R.styleable.q7, 0);
            this.A = typedArrayI.getDimensionPixelSize(R.styleable.r7, 0);
            this.E = typedArrayI.getInt(R.styleable.F7, 1);
            this.B = typedArrayI.getInt(R.styleable.s7, 0);
            this.F = typedArrayI.getBoolean(R.styleable.C7, false);
            this.J = typedArrayI.getBoolean(R.styleable.Q7, false);
            typedArrayI.recycle();
            Resources resources = getResources();
            this.f82150u = resources.getDimensionPixelSize(R.dimen.f79576l);
            this.f82155z = resources.getDimensionPixelSize(R.dimen.f79574k);
            q();
        } finally {
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3) {
        n(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.M;
        if (baseOnTabSelectedListener2 != null) {
            I(baseOnTabSelectedListener2);
        }
        this.M = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            g(baseOnTabSelectedListener);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    public void setSelectedTabIndicator(int i3) {
        if (i3 != 0) {
            setSelectedTabIndicator(AppCompatResources.b(getContext(), i3));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f82192a;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.f82192a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void a(Tab tab) {
            this.f82192a.setCurrentItem(tab.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void b(Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void c(Tab tab) {
        }
    }
}
