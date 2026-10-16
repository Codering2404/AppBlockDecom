package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final Interpolator F = new AccelerateInterpolator();
    private static final Interpolator G = new DecelerateInterpolator();
    private boolean A;
    boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f1129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f1131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ActionBarOverlayLayout f1132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ActionBarContainer f1133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    DecorToolbar f1134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ActionBarContextView f1135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    View f1136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ScrollingTabContainerView f1137i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TabImpl f1139k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ActionModeImpl f1142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ActionMode f1143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ActionMode.Callback f1144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1145q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1147s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f1150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f1151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f1152x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    ViewPropertyAnimatorCompatSet f1154z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f1138j = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1140l = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ArrayList f1146r = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1148t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f1149u = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f1153y = true;
    final ViewPropertyAnimatorListener C = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.1
        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void b(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f1149u && (view2 = windowDecorActionBar.f1136h) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.f1133e.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.f1133e.setVisibility(8);
            WindowDecorActionBar.this.f1133e.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.f1154z = null;
            windowDecorActionBar2.F();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.f1132d;
            if (actionBarOverlayLayout != null) {
                ViewCompat.j0(actionBarOverlayLayout);
            }
        }
    };
    final ViewPropertyAnimatorListener D = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.2
        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void b(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.f1154z = null;
            windowDecorActionBar.f1133e.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener E = new ViewPropertyAnimatorUpdateListener() { // from class: androidx.appcompat.app.WindowDecorActionBar.3
        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void a(View view) {
            ((View) WindowDecorActionBar.this.f1133e.getParent()).invalidate();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f1158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final MenuBuilder f1159d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ActionMode.Callback f1160f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private WeakReference f1161g;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f1158c = context;
            this.f1160f = callback;
            MenuBuilder menuBuilderX = new MenuBuilder(context).X(1);
            this.f1159d = menuBuilderX;
            menuBuilderX.W(this);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.f1160f;
            if (callback != null) {
                return callback.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void b(MenuBuilder menuBuilder) {
            if (this.f1160f == null) {
                return;
            }
            k();
            WindowDecorActionBar.this.f1135g.g();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void c() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f1142n != this) {
                return;
            }
            if (WindowDecorActionBar.E(windowDecorActionBar.f1150v, windowDecorActionBar.f1151w, false)) {
                this.f1160f.a(this);
            } else {
                WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                windowDecorActionBar2.f1143o = this;
                windowDecorActionBar2.f1144p = this.f1160f;
            }
            this.f1160f = null;
            WindowDecorActionBar.this.D(false);
            WindowDecorActionBar.this.f1135g.h();
            WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
            windowDecorActionBar3.f1132d.setHideOnContentScrollEnabled(windowDecorActionBar3.B);
            WindowDecorActionBar.this.f1142n = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public View d() {
            WeakReference weakReference = this.f1161g;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public Menu e() {
            return this.f1159d;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater f() {
            return new SupportMenuInflater(this.f1158c);
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence g() {
            return WindowDecorActionBar.this.f1135g.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence i() {
            return WindowDecorActionBar.this.f1135g.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void k() {
            if (WindowDecorActionBar.this.f1142n != this) {
                return;
            }
            this.f1159d.i0();
            try {
                this.f1160f.d(this, this.f1159d);
            } finally {
                this.f1159d.h0();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean l() {
            return WindowDecorActionBar.this.f1135g.k();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void m(View view) {
            WindowDecorActionBar.this.f1135g.setCustomView(view);
            this.f1161g = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void n(int i3) {
            o(WindowDecorActionBar.this.f1129a.getResources().getString(i3));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void o(CharSequence charSequence) {
            WindowDecorActionBar.this.f1135g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void q(int i3) {
            r(WindowDecorActionBar.this.f1129a.getResources().getString(i3));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void r(CharSequence charSequence) {
            WindowDecorActionBar.this.f1135g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void s(boolean z2) {
            super.s(z2);
            WindowDecorActionBar.this.f1135g.setTitleOptional(z2);
        }

        public boolean t() {
            this.f1159d.i0();
            try {
                return this.f1160f.b(this, this.f1159d);
            } finally {
                this.f1159d.h0();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class TabImpl extends ActionBar.Tab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ActionBar.TabListener f1163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Drawable f1164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f1165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f1166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1167e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f1168f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ WindowDecorActionBar f1169g;

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence a() {
            return this.f1166d;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public View b() {
            return this.f1168f;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Drawable c() {
            return this.f1164b;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public int d() {
            return this.f1167e;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence e() {
            return this.f1165c;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public void f() {
            this.f1169g.M(this);
        }

        public ActionBar.TabListener g() {
            return this.f1163a;
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z2) {
        this.f1131c = activity;
        View decorView = activity.getWindow().getDecorView();
        L(decorView);
        if (z2) {
            return;
        }
        this.f1136h = decorView.findViewById(R.id.content);
    }

    static boolean E(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return (z2 || z3) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar I(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void K() {
        if (this.f1152x) {
            this.f1152x = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1132d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            T(false);
        }
    }

    private void L(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id.f749q);
        this.f1132d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1134f = I(view.findViewById(androidx.appcompat.R.id.f733a));
        this.f1135g = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id.f738f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id.f735c);
        this.f1133e = actionBarContainer;
        DecorToolbar decorToolbar = this.f1134f;
        if (decorToolbar == null || this.f1135g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f1129a = decorToolbar.getContext();
        boolean z2 = (this.f1134f.x() & 4) != 0;
        if (z2) {
            this.f1141m = true;
        }
        ActionBarPolicy actionBarPolicyB = ActionBarPolicy.b(this.f1129a);
        Q(actionBarPolicyB.a() || z2);
        O(actionBarPolicyB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f1129a.obtainStyledAttributes(null, androidx.appcompat.R.styleable.f805a, androidx.appcompat.R.attr.f635c, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.f845k, false)) {
            P(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.f837i, 0);
        if (dimensionPixelSize != 0) {
            v(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void O(boolean z2) {
        this.f1147s = z2;
        if (z2) {
            this.f1133e.setTabContainer(null);
            this.f1134f.t(this.f1137i);
        } else {
            this.f1134f.t(null);
            this.f1133e.setTabContainer(this.f1137i);
        }
        boolean z3 = J() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f1137i;
        if (scrollingTabContainerView != null) {
            if (z3) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f1132d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.j0(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f1134f.r(!this.f1147s && z3);
        this.f1132d.setHasNonEmbeddedTabs(!this.f1147s && z3);
    }

    private boolean R() {
        return this.f1133e.isLaidOut();
    }

    private void S() {
        if (this.f1152x) {
            return;
        }
        this.f1152x = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1132d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        T(false);
    }

    private void T(boolean z2) {
        if (E(this.f1150v, this.f1151w, this.f1152x)) {
            if (this.f1153y) {
                return;
            }
            this.f1153y = true;
            H(z2);
            return;
        }
        if (this.f1153y) {
            this.f1153y = false;
            G(z2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void A(CharSequence charSequence) {
        this.f1134f.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void B(CharSequence charSequence) {
        this.f1134f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionMode C(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.f1142n;
        if (actionModeImpl != null) {
            actionModeImpl.c();
        }
        this.f1132d.setHideOnContentScrollEnabled(false);
        this.f1135g.l();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.f1135g.getContext(), callback);
        if (!actionModeImpl2.t()) {
            return null;
        }
        this.f1142n = actionModeImpl2;
        actionModeImpl2.k();
        this.f1135g.i(actionModeImpl2);
        D(true);
        return actionModeImpl2;
    }

    public void D(boolean z2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatM;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatF;
        if (z2) {
            S();
        } else {
            K();
        }
        if (!R()) {
            if (z2) {
                this.f1134f.setVisibility(4);
                this.f1135g.setVisibility(0);
                return;
            } else {
                this.f1134f.setVisibility(0);
                this.f1135g.setVisibility(8);
                return;
            }
        }
        if (z2) {
            viewPropertyAnimatorCompatF = this.f1134f.m(4, 100L);
            viewPropertyAnimatorCompatM = this.f1135g.f(0, 200L);
        } else {
            viewPropertyAnimatorCompatM = this.f1134f.m(0, 200L);
            viewPropertyAnimatorCompatF = this.f1135g.f(8, 100L);
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.d(viewPropertyAnimatorCompatF, viewPropertyAnimatorCompatM);
        viewPropertyAnimatorCompatSet.h();
    }

    void F() {
        ActionMode.Callback callback = this.f1144p;
        if (callback != null) {
            callback.a(this.f1143o);
            this.f1143o = null;
            this.f1144p = null;
        }
    }

    public void G(boolean z2) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f1154z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        if (this.f1148t != 0 || (!this.A && !z2)) {
            this.C.b(null);
            return;
        }
        this.f1133e.setAlpha(1.0f);
        this.f1133e.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f3 = -this.f1133e.getHeight();
        if (z2) {
            this.f1133e.getLocationInWindow(new int[]{0, 0});
            f3 -= r5[1];
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatL = ViewCompat.e(this.f1133e).l(f3);
        viewPropertyAnimatorCompatL.j(this.E);
        viewPropertyAnimatorCompatSet2.c(viewPropertyAnimatorCompatL);
        if (this.f1149u && (view = this.f1136h) != null) {
            viewPropertyAnimatorCompatSet2.c(ViewCompat.e(view).l(f3));
        }
        viewPropertyAnimatorCompatSet2.f(F);
        viewPropertyAnimatorCompatSet2.e(250L);
        viewPropertyAnimatorCompatSet2.g(this.C);
        this.f1154z = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.h();
    }

    public void H(boolean z2) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f1154z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        this.f1133e.setVisibility(0);
        if (this.f1148t == 0 && (this.A || z2)) {
            this.f1133e.setTranslationY(0.0f);
            float f3 = -this.f1133e.getHeight();
            if (z2) {
                this.f1133e.getLocationInWindow(new int[]{0, 0});
                f3 -= r5[1];
            }
            this.f1133e.setTranslationY(f3);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatL = ViewCompat.e(this.f1133e).l(0.0f);
            viewPropertyAnimatorCompatL.j(this.E);
            viewPropertyAnimatorCompatSet2.c(viewPropertyAnimatorCompatL);
            if (this.f1149u && (view2 = this.f1136h) != null) {
                view2.setTranslationY(f3);
                viewPropertyAnimatorCompatSet2.c(ViewCompat.e(this.f1136h).l(0.0f));
            }
            viewPropertyAnimatorCompatSet2.f(G);
            viewPropertyAnimatorCompatSet2.e(250L);
            viewPropertyAnimatorCompatSet2.g(this.D);
            this.f1154z = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.h();
        } else {
            this.f1133e.setAlpha(1.0f);
            this.f1133e.setTranslationY(0.0f);
            if (this.f1149u && (view = this.f1136h) != null) {
                view.setTranslationY(0.0f);
            }
            this.D.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1132d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.j0(actionBarOverlayLayout);
        }
    }

    public int J() {
        return this.f1134f.l();
    }

    public void M(ActionBar.Tab tab) {
        if (J() != 2) {
            this.f1140l = tab != null ? tab.d() : -1;
            return;
        }
        FragmentTransaction fragmentTransactionO = (!(this.f1131c instanceof FragmentActivity) || this.f1134f.n().isInEditMode()) ? null : ((FragmentActivity) this.f1131c).getSupportFragmentManager().q().o();
        TabImpl tabImpl = this.f1139k;
        if (tabImpl != tab) {
            this.f1137i.setTabSelected(tab != null ? tab.d() : -1);
            TabImpl tabImpl2 = this.f1139k;
            if (tabImpl2 != null) {
                tabImpl2.g().b(this.f1139k, fragmentTransactionO);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.f1139k = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.g().a(this.f1139k, fragmentTransactionO);
            }
        } else if (tabImpl != null) {
            tabImpl.g().c(this.f1139k, fragmentTransactionO);
            this.f1137i.a(tab.d());
        }
        if (fragmentTransactionO == null || fragmentTransactionO.q()) {
            return;
        }
        fragmentTransactionO.j();
    }

    public void N(int i3, int i4) {
        int iX = this.f1134f.x();
        if ((i4 & 4) != 0) {
            this.f1141m = true;
        }
        this.f1134f.j((i3 & i4) | ((~i4) & iX));
    }

    public void P(boolean z2) {
        if (z2 && !this.f1132d.x()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.B = z2;
        this.f1132d.setHideOnContentScrollEnabled(z2);
    }

    public void Q(boolean z2) {
        this.f1134f.o(z2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void a() {
        if (this.f1151w) {
            this.f1151w = false;
            T(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void c(boolean z2) {
        this.f1149u = z2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void d() {
        if (this.f1151w) {
            return;
        }
        this.f1151w = true;
        T(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void e() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f1154z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
            this.f1154z = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean g() {
        DecorToolbar decorToolbar = this.f1134f;
        if (decorToolbar == null || !decorToolbar.i()) {
            return false;
        }
        this.f1134f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void h(boolean z2) {
        if (z2 == this.f1145q) {
            return;
        }
        this.f1145q = z2;
        int size = this.f1146r.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ActionBar.OnMenuVisibilityListener) this.f1146r.get(i3)).onMenuVisibilityChanged(z2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public int i() {
        return this.f1134f.x();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context j() {
        if (this.f1130b == null) {
            TypedValue typedValue = new TypedValue();
            this.f1129a.getTheme().resolveAttribute(androidx.appcompat.R.attr.f643g, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                this.f1130b = new ContextThemeWrapper(this.f1129a, i3);
            } else {
                this.f1130b = this.f1129a;
            }
        }
        return this.f1130b;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void k() {
        if (this.f1150v) {
            return;
        }
        this.f1150v = true;
        T(false);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m(Configuration configuration) {
        O(ActionBarPolicy.b(this.f1129a).g());
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean o(int i3, KeyEvent keyEvent) {
        Menu menuE;
        ActionModeImpl actionModeImpl = this.f1142n;
        if (actionModeImpl == null || (menuE = actionModeImpl.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i3, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i3) {
        this.f1148t = i3;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void r(Drawable drawable) {
        this.f1133e.setPrimaryBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s(boolean z2) {
        if (this.f1141m) {
            return;
        }
        t(z2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t(boolean z2) {
        N(z2 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void u(boolean z2) {
        N(z2 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void v(float f3) {
        ViewCompat.u0(this.f1133e, f3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void w(int i3) {
        this.f1134f.p(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void x(int i3) {
        this.f1134f.v(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void y(Drawable drawable) {
        this.f1134f.z(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void z(boolean z2) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.A = z2;
        if (z2 || (viewPropertyAnimatorCompatSet = this.f1154z) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.a();
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void b() {
    }

    public WindowDecorActionBar(Dialog dialog) {
        L(dialog.getWindow().getDecorView());
    }
}
