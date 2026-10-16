package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Toolbar f2305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f2309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f2310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f2311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    CharSequence f2313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f2314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f2315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Window.Callback f2316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f2317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ActionMenuPresenter f2318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f2319o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f2320p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f2321q;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z2) {
        this(toolbar, z2, R.string.f781a, R.drawable.f720n);
    }

    private int A() {
        if (this.f2305a.getNavigationIcon() == null) {
            return 11;
        }
        this.f2321q = this.f2305a.getNavigationIcon();
        return 15;
    }

    private void G(CharSequence charSequence) {
        this.f2313i = charSequence;
        if ((this.f2306b & 8) != 0) {
            this.f2305a.setTitle(charSequence);
            if (this.f2312h) {
                ViewCompat.p0(this.f2305a.getRootView(), charSequence);
            }
        }
    }

    private void H() {
        if ((this.f2306b & 4) != 0) {
            if (TextUtils.isEmpty(this.f2315k)) {
                this.f2305a.setNavigationContentDescription(this.f2320p);
            } else {
                this.f2305a.setNavigationContentDescription(this.f2315k);
            }
        }
    }

    private void I() {
        if ((this.f2306b & 4) == 0) {
            this.f2305a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f2305a;
        Drawable drawable = this.f2311g;
        if (drawable == null) {
            drawable = this.f2321q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void J() {
        Drawable drawable;
        int i3 = this.f2306b;
        if ((i3 & 2) == 0) {
            drawable = null;
        } else if ((i3 & 1) == 0 || (drawable = this.f2310f) == null) {
            drawable = this.f2309e;
        }
        this.f2305a.setLogo(drawable);
    }

    public void B(View view) {
        View view2 = this.f2308d;
        if (view2 != null && (this.f2306b & 16) != 0) {
            this.f2305a.removeView(view2);
        }
        this.f2308d = view;
        if (view == null || (this.f2306b & 16) == 0) {
            return;
        }
        this.f2305a.addView(view);
    }

    public void C(int i3) {
        if (i3 == this.f2320p) {
            return;
        }
        this.f2320p = i3;
        if (TextUtils.isEmpty(this.f2305a.getNavigationContentDescription())) {
            p(this.f2320p);
        }
    }

    public void D(Drawable drawable) {
        this.f2310f = drawable;
        J();
    }

    public void E(CharSequence charSequence) {
        this.f2315k = charSequence;
        H();
    }

    public void F(CharSequence charSequence) {
        this.f2314j = charSequence;
        if ((this.f2306b & 8) != 0) {
            this.f2305a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void a(Drawable drawable) {
        this.f2305a.setBackground(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean b() {
        return this.f2305a.d();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean c() {
        return this.f2305a.w();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.f2305a.e();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean d() {
        return this.f2305a.Q();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void e(Menu menu, MenuPresenter.Callback callback) {
        if (this.f2318n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f2305a.getContext());
            this.f2318n = actionMenuPresenter;
            actionMenuPresenter.s(R.id.f739g);
        }
        this.f2318n.d(callback);
        this.f2305a.K((MenuBuilder) menu, this.f2318n);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean f() {
        return this.f2305a.B();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void g() {
        this.f2317m = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.f2305a.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.f2305a.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean h() {
        return this.f2305a.A();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean i() {
        return this.f2305a.v();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void j(int i3) {
        View view;
        int i4 = this.f2306b ^ i3;
        this.f2306b = i3;
        if (i4 != 0) {
            if ((i4 & 4) != 0) {
                if ((i3 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i4 & 3) != 0) {
                J();
            }
            if ((i4 & 8) != 0) {
                if ((i3 & 8) != 0) {
                    this.f2305a.setTitle(this.f2313i);
                    this.f2305a.setSubtitle(this.f2314j);
                } else {
                    this.f2305a.setTitle((CharSequence) null);
                    this.f2305a.setSubtitle((CharSequence) null);
                }
            }
            if ((i4 & 16) == 0 || (view = this.f2308d) == null) {
                return;
            }
            if ((i3 & 16) != 0) {
                this.f2305a.addView(view);
            } else {
                this.f2305a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu k() {
        return this.f2305a.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int l() {
        return this.f2319o;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat m(final int i3, long j3) {
        return ViewCompat.e(this.f2305a).b(i3 == 0 ? 1.0f : 0.0f).e(j3).g(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f2324a = false;

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void a(View view) {
                this.f2324a = true;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void b(View view) {
                if (this.f2324a) {
                    return;
                }
                ToolbarWidgetWrapper.this.f2305a.setVisibility(i3);
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void c(View view) {
                ToolbarWidgetWrapper.this.f2305a.setVisibility(0);
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup n() {
        return this.f2305a;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void p(int i3) {
        E(i3 == 0 ? null : getContext().getString(i3));
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void q() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void r(boolean z2) {
        this.f2305a.setCollapsible(z2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void s() {
        this.f2305a.f();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int i3) {
        setIcon(i3 != 0 ? AppCompatResources.b(getContext(), i3) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        this.f2312h = true;
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int i3) {
        this.f2305a.setVisibility(i3);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.f2316l = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f2312h) {
            return;
        }
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void t(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f2307c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f2305a;
            if (parent == toolbar) {
                toolbar.removeView(this.f2307c);
            }
        }
        this.f2307c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.f2319o != 2) {
            return;
        }
        this.f2305a.addView(scrollingTabContainerView, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f2307c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.f900a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void u(int i3) {
        D(i3 != 0 ? AppCompatResources.b(getContext(), i3) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void v(int i3) {
        z(i3 != 0 ? AppCompatResources.b(getContext(), i3) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void w(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f2305a.L(callback, callback2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int x() {
        return this.f2306b;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void y() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void z(Drawable drawable) {
        this.f2311g = drawable;
        I();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z2, int i3, int i4) {
        Drawable drawable;
        this.f2319o = 0;
        this.f2320p = 0;
        this.f2305a = toolbar;
        this.f2313i = toolbar.getTitle();
        this.f2314j = toolbar.getSubtitle();
        this.f2312h = this.f2313i != null;
        this.f2311g = toolbar.getNavigationIcon();
        TintTypedArray tintTypedArrayV = TintTypedArray.v(toolbar.getContext(), null, R.styleable.f805a, R.attr.f635c, 0);
        this.f2321q = tintTypedArrayV.g(R.styleable.f849l);
        if (z2) {
            CharSequence charSequenceP = tintTypedArrayV.p(R.styleable.f873r);
            if (!TextUtils.isEmpty(charSequenceP)) {
                setTitle(charSequenceP);
            }
            CharSequence charSequenceP2 = tintTypedArrayV.p(R.styleable.f865p);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                F(charSequenceP2);
            }
            Drawable drawableG = tintTypedArrayV.g(R.styleable.f857n);
            if (drawableG != null) {
                D(drawableG);
            }
            Drawable drawableG2 = tintTypedArrayV.g(R.styleable.f853m);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.f2311g == null && (drawable = this.f2321q) != null) {
                z(drawable);
            }
            j(tintTypedArrayV.k(R.styleable.f833h, 0));
            int iN = tintTypedArrayV.n(R.styleable.f829g, 0);
            if (iN != 0) {
                B(LayoutInflater.from(this.f2305a.getContext()).inflate(iN, (ViewGroup) this.f2305a, false));
                j(this.f2306b | 16);
            }
            int iM = tintTypedArrayV.m(R.styleable.f841j, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2305a.getLayoutParams();
                layoutParams.height = iM;
                this.f2305a.setLayoutParams(layoutParams);
            }
            int iE = tintTypedArrayV.e(R.styleable.f825f, -1);
            int iE2 = tintTypedArrayV.e(R.styleable.f821e, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f2305a.J(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = tintTypedArrayV.n(R.styleable.f876s, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.f2305a;
                toolbar2.N(toolbar2.getContext(), iN2);
            }
            int iN3 = tintTypedArrayV.n(R.styleable.f869q, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.f2305a;
                toolbar3.M(toolbar3.getContext(), iN3);
            }
            int iN4 = tintTypedArrayV.n(R.styleable.f861o, 0);
            if (iN4 != 0) {
                this.f2305a.setPopupTheme(iN4);
            }
        } else {
            this.f2306b = A();
        }
        tintTypedArrayV.x();
        C(i3);
        this.f2315k = this.f2305a.getNavigationContentDescription();
        this.f2305a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ActionMenuItem f2322a;

            {
                this.f2322a = new ActionMenuItem(ToolbarWidgetWrapper.this.f2305a.getContext(), 0, android.R.id.home, 0, 0, ToolbarWidgetWrapper.this.f2313i);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.f2316l;
                if (callback == null || !toolbarWidgetWrapper.f2317m) {
                    return;
                }
                callback.onMenuItemSelected(0, this.f2322a);
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.f2309e = drawable;
        J();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void o(boolean z2) {
    }
}
