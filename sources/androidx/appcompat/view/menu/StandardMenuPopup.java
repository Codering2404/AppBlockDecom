package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f1529w = R.layout.f773o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MenuBuilder f1531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MenuAdapter f1532d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f1533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f1534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f1536i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final MenuPopupWindow f1537j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1540m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f1541n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    View f1542o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private MenuPresenter.Callback f1543p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ViewTreeObserver f1544q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1545r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1546s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1547t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1549v;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1538k = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!StandardMenuPopup.this.b() || StandardMenuPopup.this.f1537j.A()) {
                return;
            }
            View view = StandardMenuPopup.this.f1542o;
            if (view == null || !view.isShown()) {
                StandardMenuPopup.this.dismiss();
            } else {
                StandardMenuPopup.this.f1537j.show();
            }
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1539l = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.f1544q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.f1544q = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.f1544q.removeGlobalOnLayoutListener(standardMenuPopup.f1538k);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1548u = 0;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i3, int i4, boolean z2) {
        this.f1530b = context;
        this.f1531c = menuBuilder;
        this.f1533f = z2;
        this.f1532d = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z2, f1529w);
        this.f1535h = i3;
        this.f1536i = i4;
        Resources resources = context.getResources();
        this.f1534g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.f695d));
        this.f1541n = view;
        this.f1537j = new MenuPopupWindow(context, null, i3, i4);
        menuBuilder.c(this, context);
    }

    private boolean A() {
        View view;
        if (b()) {
            return true;
        }
        if (this.f1545r || (view = this.f1541n) == null) {
            return false;
        }
        this.f1542o = view;
        this.f1537j.J(this);
        this.f1537j.K(this);
        this.f1537j.I(true);
        View view2 = this.f1542o;
        boolean z2 = this.f1544q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1544q = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1538k);
        }
        view2.addOnAttachStateChangeListener(this.f1539l);
        this.f1537j.C(view2);
        this.f1537j.F(this.f1548u);
        if (!this.f1546s) {
            this.f1547t = MenuPopup.p(this.f1532d, null, this.f1530b, this.f1534g);
            this.f1546s = true;
        }
        this.f1537j.E(this.f1547t);
        this.f1537j.H(2);
        this.f1537j.G(n());
        this.f1537j.show();
        ListView listViewO = this.f1537j.o();
        listViewO.setOnKeyListener(this);
        if (this.f1549v && this.f1531c.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1530b).inflate(R.layout.f772n, (ViewGroup) listViewO, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(this.f1531c.z());
            }
            frameLayout.setEnabled(false);
            listViewO.addHeaderView(frameLayout, null, false);
        }
        this.f1537j.m(this.f1532d);
        this.f1537j.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z2) {
        if (menuBuilder != this.f1531c) {
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.f1543p;
        if (callback != null) {
            callback.a(menuBuilder, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean b() {
        return !this.f1545r && this.f1537j.b();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void d(MenuPresenter.Callback callback) {
        this.f1543p = callback;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        if (b()) {
            this.f1537j.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f1530b, subMenuBuilder, this.f1542o, this.f1533f, this.f1535h, this.f1536i);
            menuPopupHelper.j(this.f1543p);
            menuPopupHelper.g(MenuPopup.y(subMenuBuilder));
            menuPopupHelper.i(this.f1540m);
            this.f1540m = null;
            this.f1531c.e(false);
            int iC = this.f1537j.c();
            int iL = this.f1537j.l();
            if ((Gravity.getAbsoluteGravity(this.f1548u, this.f1541n.getLayoutDirection()) & 7) == 5) {
                iC += this.f1541n.getWidth();
            }
            if (menuPopupHelper.n(iC, iL)) {
                MenuPresenter.Callback callback = this.f1543p;
                if (callback == null) {
                    return true;
                }
                callback.b(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable g() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void h(boolean z2) {
        this.f1546s = false;
        MenuAdapter menuAdapter = this.f1532d;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView o() {
        return this.f1537j.o();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1545r = true;
        this.f1531c.close();
        ViewTreeObserver viewTreeObserver = this.f1544q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1544q = this.f1542o.getViewTreeObserver();
            }
            this.f1544q.removeGlobalOnLayoutListener(this.f1538k);
            this.f1544q = null;
        }
        this.f1542o.removeOnAttachStateChangeListener(this.f1539l);
        PopupWindow.OnDismissListener onDismissListener = this.f1540m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i3 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void q(View view) {
        this.f1541n = view;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void s(boolean z2) {
        this.f1532d.d(z2);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (!A()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void t(int i3) {
        this.f1548u = i3;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void u(int i3) {
        this.f1537j.e(i3);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void v(PopupWindow.OnDismissListener onDismissListener) {
        this.f1540m = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void w(boolean z2) {
        this.f1549v = z2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void x(int i3) {
        this.f1537j.i(i3);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void l(MenuBuilder menuBuilder) {
    }
}
