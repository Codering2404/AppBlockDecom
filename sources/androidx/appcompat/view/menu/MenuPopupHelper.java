package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class MenuPopupHelper implements MenuHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MenuBuilder f1516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f1517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f1520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MenuPresenter.Callback f1523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MenuPopup f1524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f1526l;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z2, int i3) {
        this(context, menuBuilder, view, z2, i3, 0);
    }

    private MenuPopup a() {
        Display defaultDisplay = ((WindowManager) this.f1515a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        MenuPopup cascadingMenuPopup = Math.min(point.x, point.y) >= this.f1515a.getResources().getDimensionPixelSize(R.dimen.f694c) ? new CascadingMenuPopup(this.f1515a, this.f1520f, this.f1518d, this.f1519e, this.f1517c) : new StandardMenuPopup(this.f1515a, this.f1516b, this.f1520f, this.f1518d, this.f1519e, this.f1517c);
        cascadingMenuPopup.l(this.f1516b);
        cascadingMenuPopup.v(this.f1526l);
        cascadingMenuPopup.q(this.f1520f);
        cascadingMenuPopup.d(this.f1523i);
        cascadingMenuPopup.s(this.f1522h);
        cascadingMenuPopup.t(this.f1521g);
        return cascadingMenuPopup;
    }

    private void l(int i3, int i4, boolean z2, boolean z3) {
        MenuPopup menuPopupC = c();
        menuPopupC.w(z3);
        if (z2) {
            if ((GravityCompat.b(this.f1521g, this.f1520f.getLayoutDirection()) & 7) == 5) {
                i3 -= this.f1520f.getWidth();
            }
            menuPopupC.u(i3);
            menuPopupC.x(i4);
            int i5 = (int) ((this.f1515a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            menuPopupC.r(new Rect(i3 - i5, i4 - i5, i3 + i5, i4 + i5));
        }
        menuPopupC.show();
    }

    public void b() {
        if (d()) {
            this.f1524j.dismiss();
        }
    }

    public MenuPopup c() {
        if (this.f1524j == null) {
            this.f1524j = a();
        }
        return this.f1524j;
    }

    public boolean d() {
        MenuPopup menuPopup = this.f1524j;
        return menuPopup != null && menuPopup.b();
    }

    protected void e() {
        this.f1524j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1525k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f1520f = view;
    }

    public void g(boolean z2) {
        this.f1522h = z2;
        MenuPopup menuPopup = this.f1524j;
        if (menuPopup != null) {
            menuPopup.s(z2);
        }
    }

    public void h(int i3) {
        this.f1521g = i3;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1525k = onDismissListener;
    }

    public void j(MenuPresenter.Callback callback) {
        this.f1523i = callback;
        MenuPopup menuPopup = this.f1524j;
        if (menuPopup != null) {
            menuPopup.d(callback);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f1520f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i3, int i4) {
        if (d()) {
            return true;
        }
        if (this.f1520f == null) {
            return false;
        }
        l(i3, i4, true, true);
        return true;
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z2, int i3, int i4) {
        this.f1521g = 8388611;
        this.f1526l = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.e();
            }
        };
        this.f1515a = context;
        this.f1516b = menuBuilder;
        this.f1520f = view;
        this.f1517c = z2;
        this.f1518d = i3;
        this.f1519e = i4;
    }
}
