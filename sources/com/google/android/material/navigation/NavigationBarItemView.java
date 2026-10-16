package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] H = {R.attr.state_checked};
    private static final ActiveIndicatorTransform I;
    private static final ActiveIndicatorTransform J;
    private float A;
    private boolean B;
    private int C;
    private int D;
    private boolean E;
    private int F;
    private BadgeDrawable G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f81367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f81368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Drawable f81369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f81370d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f81371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f81372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f81373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f81374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f81375j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f81376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f81377l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final FrameLayout f81378m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final View f81379n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ImageView f81380o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ViewGroup f81381p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final TextView f81382q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final TextView f81383r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f81384s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f81385t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private MenuItemImpl f81386u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ColorStateList f81387v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Drawable f81388w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Drawable f81389x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ValueAnimator f81390y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ActiveIndicatorTransform f81391z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ActiveIndicatorTransform {
        private ActiveIndicatorTransform() {
        }

        protected float a(float f3, float f4) {
            return AnimationUtils.b(0.0f, 1.0f, f4 == 0.0f ? 0.8f : 0.0f, f4 == 0.0f ? 1.0f : 0.2f, f3);
        }

        protected float b(float f3, float f4) {
            return AnimationUtils.a(0.4f, 1.0f, f3);
        }

        protected float c(float f3, float f4) {
            return 1.0f;
        }

        public void d(float f3, float f4, View view) {
            view.setScaleX(b(f3, f4));
            view.setScaleY(c(f3, f4));
            view.setAlpha(a(f3, f4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.ActiveIndicatorTransform
        protected float c(float f3, float f4) {
            return b(f3, f4);
        }
    }

    static {
        I = new ActiveIndicatorTransform();
        J = new ActiveIndicatorUnlabeledTransform();
    }

    public NavigationBarItemView(Context context) {
        super(context);
        this.f81367a = false;
        this.f81384s = -1;
        this.f81385t = 0;
        this.f81391z = I;
        this.A = 0.0f;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f81378m = (FrameLayout) findViewById(com.google.android.material.R.id.f79623b0);
        this.f81379n = findViewById(com.google.android.material.R.id.f79621a0);
        ImageView imageView = (ImageView) findViewById(com.google.android.material.R.id.f79625c0);
        this.f81380o = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(com.google.android.material.R.id.f79627d0);
        this.f81381p = viewGroup;
        TextView textView = (TextView) findViewById(com.google.android.material.R.id.f79631f0);
        this.f81382q = textView;
        TextView textView2 = (TextView) findViewById(com.google.android.material.R.id.f79629e0);
        this.f81383r = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f81370d = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f81371f = viewGroup.getPaddingBottom();
        this.f81372g = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.B);
        ViewCompat.w0(textView, 2);
        ViewCompat.w0(textView2, 2);
        setFocusable(true);
        g(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    if (NavigationBarItemView.this.f81380o.getVisibility() == 0) {
                        NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                        navigationBarItemView.w(navigationBarItemView.f81380o);
                    }
                }
            });
        }
    }

    private void g(float f3, float f4) {
        this.f81373h = f3 - f4;
        this.f81374i = (f4 * 1.0f) / f3;
        this.f81375j = (f3 * 1.0f) / f4;
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f81378m;
        return frameLayout != null ? frameLayout : this.f81380o;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i3 = 0;
        for (int i4 = 0; i4 < iIndexOfChild; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i3++;
            }
        }
        return i3;
    }

    private int getSuggestedIconHeight() {
        return ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin + getIconOrContainer().getMeasuredHeight();
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.G;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.G.l();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f81380o.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private static Drawable i(ColorStateList colorStateList) {
        return new RippleDrawable(RippleUtils.a(colorStateList), null, null);
    }

    private FrameLayout j(View view) {
        ImageView imageView = this.f81380o;
        if (view == imageView && BadgeUtils.f80041a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    private boolean k() {
        return this.G != null;
    }

    private boolean l() {
        return this.E && this.f81376k == 2;
    }

    private void m(final float f3) {
        if (!this.B || !this.f81367a || !ViewCompat.Q(this)) {
            q(f3, f3);
            return;
        }
        ValueAnimator valueAnimator = this.f81390y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f81390y = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.A, f3);
        this.f81390y = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                NavigationBarItemView.this.q(((Float) valueAnimator2.getAnimatedValue()).floatValue(), f3);
            }
        });
        this.f81390y.setInterpolator(MotionUtils.g(getContext(), com.google.android.material.R.attr.f79487f0, AnimationUtils.f79850b));
        this.f81390y.setDuration(MotionUtils.f(getContext(), com.google.android.material.R.attr.V, getResources().getInteger(com.google.android.material.R.integer.f79668b)));
        this.f81390y.start();
    }

    private void n() {
        MenuItemImpl menuItemImpl = this.f81386u;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    private void o() {
        Drawable drawableI = this.f81369c;
        RippleDrawable rippleDrawable = null;
        boolean z2 = true;
        if (this.f81368b != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.B && getActiveIndicatorDrawable() != null && this.f81378m != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(RippleUtils.d(this.f81368b), null, activeIndicatorDrawable);
                z2 = false;
            } else if (drawableI == null) {
                drawableI = i(this.f81368b);
            }
        }
        FrameLayout frameLayout = this.f81378m;
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            this.f81378m.setForeground(rippleDrawable);
        }
        ViewCompat.q0(this, drawableI);
        setDefaultFocusHighlightEnabled(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(float f3, float f4) {
        View view = this.f81379n;
        if (view != null) {
            this.f81391z.d(f3, f4, view);
        }
        this.A = f3;
    }

    private static void r(TextView textView, int i3) {
        TextViewCompat.o(textView, i3);
        int i4 = MaterialResources.i(textView.getContext(), i3, 0);
        if (i4 != 0) {
            textView.setTextSize(0, i4);
        }
    }

    private static void s(View view, float f3, float f4, int i3) {
        view.setScaleX(f3);
        view.setScaleY(f4);
        view.setVisibility(i3);
    }

    private static void t(View view, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i3;
        layoutParams.bottomMargin = i3;
        layoutParams.gravity = i4;
        view.setLayoutParams(layoutParams);
    }

    private void u(View view) {
        if (k() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.c(this.G, view, j(view));
        }
    }

    private void v(View view) {
        if (k()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.f(this.G, view);
            }
            this.G = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(View view) {
        if (k()) {
            BadgeUtils.g(this.G, view, j(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3) {
        if (this.f81379n == null || i3 <= 0) {
            return;
        }
        int iMin = Math.min(this.C, i3 - (this.F * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f81379n.getLayoutParams();
        layoutParams.height = l() ? iMin : this.D;
        layoutParams.width = iMin;
        this.f81379n.setLayoutParams(layoutParams);
    }

    private void y() {
        if (l()) {
            this.f81391z = J;
        } else {
            this.f81391z = I;
        }
    }

    private static void z(View view, int i3) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i3);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void c(MenuItemImpl menuItemImpl, int i3) {
        this.f81386u = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        TooltipCompat.a(this, !TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        this.f81367a = true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean d() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.f81378m;
        if (frameLayout != null && this.B) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.f81379n;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public BadgeDrawable getBadge() {
        return this.G;
    }

    protected int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.f79618m;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f81386u;
    }

    protected int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.B0;
    }

    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f81384s;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f81381p.getLayoutParams();
        return getSuggestedIconHeight() + (this.f81381p.getVisibility() == 0 ? this.f81372g : 0) + layoutParams.topMargin + this.f81381p.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f81381p.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f81381p.getMeasuredWidth() + layoutParams.rightMargin);
    }

    void h() {
        p();
        this.f81386u = null;
        this.A = 0.0f;
        this.f81367a = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        MenuItemImpl menuItemImpl = this.f81386u;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f81386u.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.G;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f81386u.getTitle();
            if (!TextUtils.isEmpty(this.f81386u.getContentDescription())) {
                title = this.f81386u.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.G.i()));
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatZ0 = AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo);
        accessibilityNodeInfoCompatZ0.l0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            accessibilityNodeInfoCompatZ0.j0(false);
            accessibilityNodeInfoCompatZ0.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34572i);
        }
        accessibilityNodeInfoCompatZ0.I0(getResources().getString(com.google.android.material.R.string.f79709h));
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        post(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarItemView.2
            @Override // java.lang.Runnable
            public void run() {
                NavigationBarItemView.this.x(i3);
            }
        });
    }

    void p() {
        v(this.f81380o);
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.f81379n;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        o();
    }

    public void setActiveIndicatorEnabled(boolean z2) {
        this.B = z2;
        o();
        View view = this.f81379n;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i3) {
        this.D = i3;
        x(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i3) {
        if (this.f81372g != i3) {
            this.f81372g = i3;
            n();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i3) {
        this.F = i3;
        x(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z2) {
        this.E = z2;
    }

    public void setActiveIndicatorWidth(int i3) {
        this.C = i3;
        x(getWidth());
    }

    void setBadge(BadgeDrawable badgeDrawable) {
        if (this.G == badgeDrawable) {
            return;
        }
        if (k() && this.f81380o != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            v(this.f81380o);
        }
        this.G = badgeDrawable;
        ImageView imageView = this.f81380o;
        if (imageView != null) {
            u(imageView);
        }
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
    }

    public void setChecked(boolean z2) {
        this.f81383r.setPivotX(r0.getWidth() / 2);
        this.f81383r.setPivotY(r0.getBaseline());
        this.f81382q.setPivotX(r0.getWidth() / 2);
        this.f81382q.setPivotY(r0.getBaseline());
        m(z2 ? 1.0f : 0.0f);
        int i3 = this.f81376k;
        if (i3 != -1) {
            if (i3 == 0) {
                if (z2) {
                    t(getIconOrContainer(), this.f81370d, 49);
                    z(this.f81381p, this.f81371f);
                    this.f81383r.setVisibility(0);
                } else {
                    t(getIconOrContainer(), this.f81370d, 17);
                    z(this.f81381p, 0);
                    this.f81383r.setVisibility(4);
                }
                this.f81382q.setVisibility(4);
            } else if (i3 == 1) {
                z(this.f81381p, this.f81371f);
                if (z2) {
                    t(getIconOrContainer(), (int) (this.f81370d + this.f81373h), 49);
                    s(this.f81383r, 1.0f, 1.0f, 0);
                    TextView textView = this.f81382q;
                    float f3 = this.f81374i;
                    s(textView, f3, f3, 4);
                } else {
                    t(getIconOrContainer(), this.f81370d, 49);
                    TextView textView2 = this.f81383r;
                    float f4 = this.f81375j;
                    s(textView2, f4, f4, 4);
                    s(this.f81382q, 1.0f, 1.0f, 0);
                }
            } else if (i3 == 2) {
                t(getIconOrContainer(), this.f81370d, 17);
                this.f81383r.setVisibility(8);
                this.f81382q.setVisibility(8);
            }
        } else if (this.f81377l) {
            if (z2) {
                t(getIconOrContainer(), this.f81370d, 49);
                z(this.f81381p, this.f81371f);
                this.f81383r.setVisibility(0);
            } else {
                t(getIconOrContainer(), this.f81370d, 17);
                z(this.f81381p, 0);
                this.f81383r.setVisibility(4);
            }
            this.f81382q.setVisibility(4);
        } else {
            z(this.f81381p, this.f81371f);
            if (z2) {
                t(getIconOrContainer(), (int) (this.f81370d + this.f81373h), 49);
                s(this.f81383r, 1.0f, 1.0f, 0);
                TextView textView3 = this.f81382q;
                float f5 = this.f81374i;
                s(textView3, f5, f5, 4);
            } else {
                t(getIconOrContainer(), this.f81370d, 49);
                TextView textView4 = this.f81383r;
                float f6 = this.f81375j;
                s(textView4, f6, f6, 4);
                s(this.f81382q, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z2);
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.f81382q.setEnabled(z2);
        this.f81383r.setEnabled(z2);
        this.f81380o.setEnabled(z2);
        if (z2) {
            ViewCompat.E0(this, PointerIconCompat.b(getContext(), 1002));
        } else {
            ViewCompat.E0(this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.f81388w) {
            return;
        }
        this.f81388w = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.r(drawable).mutate();
            this.f81389x = drawable;
            ColorStateList colorStateList = this.f81387v;
            if (colorStateList != null) {
                DrawableCompat.o(drawable, colorStateList);
            }
        }
        this.f81380o.setImageDrawable(drawable);
    }

    public void setIconSize(int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f81380o.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.f81380o.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f81387v = colorStateList;
        if (this.f81386u == null || (drawable = this.f81389x) == null) {
            return;
        }
        DrawableCompat.o(drawable, colorStateList);
        this.f81389x.invalidateSelf();
    }

    public void setItemBackground(int i3) {
        setItemBackground(i3 == 0 ? null : ContextCompat.getDrawable(getContext(), i3));
    }

    public void setItemPaddingBottom(int i3) {
        if (this.f81371f != i3) {
            this.f81371f = i3;
            n();
        }
    }

    public void setItemPaddingTop(int i3) {
        if (this.f81370d != i3) {
            this.f81370d = i3;
            n();
        }
    }

    public void setItemPosition(int i3) {
        this.f81384s = i3;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f81368b = colorStateList;
        o();
    }

    public void setLabelVisibilityMode(int i3) {
        if (this.f81376k != i3) {
            this.f81376k = i3;
            y();
            x(getWidth());
            n();
        }
    }

    public void setShifting(boolean z2) {
        if (this.f81377l != z2) {
            this.f81377l = z2;
            n();
        }
    }

    public void setTextAppearanceActive(int i3) {
        this.f81385t = i3;
        r(this.f81383r, i3);
        g(this.f81382q.getTextSize(), this.f81383r.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z2) {
        setTextAppearanceActive(this.f81385t);
        TextView textView = this.f81383r;
        textView.setTypeface(textView.getTypeface(), z2 ? 1 : 0);
    }

    public void setTextAppearanceInactive(int i3) {
        r(this.f81382q, i3);
        g(this.f81382q.getTextSize(), this.f81383r.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f81382q.setTextColor(colorStateList);
            this.f81383r.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f81382q.setText(charSequence);
        this.f81383r.setText(charSequence);
        MenuItemImpl menuItemImpl = this.f81386u;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.f81386u;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.f81386u.getTooltipText();
        }
        TooltipCompat.a(this, charSequence);
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f81369c = drawable;
        o();
    }
}
