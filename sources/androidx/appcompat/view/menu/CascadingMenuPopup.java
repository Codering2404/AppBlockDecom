package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int C = R.layout.f765g;
    private PopupWindow.OnDismissListener A;
    boolean B;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1377d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f1379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Handler f1380h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View f1388p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    View f1389q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1391s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1392t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1393u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f1394v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f1396x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private MenuPresenter.Callback f1397y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    ViewTreeObserver f1398z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f1381i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final List f1382j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1383k = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.b() || CascadingMenuPopup.this.f1382j.size() <= 0 || ((CascadingMenuInfo) CascadingMenuPopup.this.f1382j.get(0)).f1406a.A()) {
                return;
            }
            View view = CascadingMenuPopup.this.f1389q;
            if (view == null || !view.isShown()) {
                CascadingMenuPopup.this.dismiss();
                return;
            }
            Iterator it = CascadingMenuPopup.this.f1382j.iterator();
            while (it.hasNext()) {
                ((CascadingMenuInfo) it.next()).f1406a.show();
            }
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1384l = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.f1398z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.f1398z = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.f1398z.removeGlobalOnLayoutListener(cascadingMenuPopup.f1383k);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    };

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MenuItemHoverListener f1385m = new MenuItemHoverListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3
        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void d(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            CascadingMenuPopup.this.f1380h.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.f1382j.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (menuBuilder == ((CascadingMenuInfo) CascadingMenuPopup.this.f1382j.get(i3)).f1407b) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return;
            }
            int i4 = i3 + 1;
            final CascadingMenuInfo cascadingMenuInfo = i4 < CascadingMenuPopup.this.f1382j.size() ? (CascadingMenuInfo) CascadingMenuPopup.this.f1382j.get(i4) : null;
            CascadingMenuPopup.this.f1380h.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1
                @Override // java.lang.Runnable
                public void run() {
                    CascadingMenuInfo cascadingMenuInfo2 = cascadingMenuInfo;
                    if (cascadingMenuInfo2 != null) {
                        CascadingMenuPopup.this.B = true;
                        cascadingMenuInfo2.f1407b.e(false);
                        CascadingMenuPopup.this.B = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        menuBuilder.O(menuItem, 4);
                    }
                }
            }, menuBuilder, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void n(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.f1380h.removeCallbacksAndMessages(menuBuilder);
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f1386n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1387o = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1395w = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1390r = E();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CascadingMenuInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f1406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MenuBuilder f1407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1408c;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i3) {
            this.f1406a = menuPopupWindow;
            this.f1407b = menuBuilder;
            this.f1408c = i3;
        }

        public ListView a() {
            return this.f1406a.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(Context context, View view, int i3, int i4, boolean z2) {
        this.f1375b = context;
        this.f1388p = view;
        this.f1377d = i3;
        this.f1378f = i4;
        this.f1379g = z2;
        Resources resources = context.getResources();
        this.f1376c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.f695d));
        this.f1380h = new Handler();
    }

    private MenuPopupWindow A() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f1375b, null, this.f1377d, this.f1378f);
        menuPopupWindow.T(this.f1385m);
        menuPopupWindow.K(this);
        menuPopupWindow.J(this);
        menuPopupWindow.C(this.f1388p);
        menuPopupWindow.F(this.f1387o);
        menuPopupWindow.I(true);
        menuPopupWindow.H(2);
        return menuPopupWindow;
    }

    private int B(MenuBuilder menuBuilder) {
        int size = this.f1382j.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (menuBuilder == ((CascadingMenuInfo) this.f1382j.get(i3)).f1407b) {
                return i3;
            }
        }
        return -1;
    }

    private MenuItem C(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = menuBuilder.getItem(i3);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View D(CascadingMenuInfo cascadingMenuInfo, MenuBuilder menuBuilder) {
        MenuAdapter menuAdapter;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemC = C(cascadingMenuInfo.f1407b, menuBuilder);
        if (menuItemC == null) {
            return null;
        }
        ListView listViewA = cascadingMenuInfo.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            headersCount = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            }
            if (menuItemC == menuAdapter.getItem(i3)) {
                break;
            }
            i3++;
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int E() {
        return this.f1388p.getLayoutDirection() == 1 ? 0 : 1;
    }

    private int F(int i3) {
        List list = this.f1382j;
        ListView listViewA = ((CascadingMenuInfo) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1389q.getWindowVisibleDisplayFrame(rect);
        return this.f1390r == 1 ? (iArr[0] + listViewA.getWidth()) + i3 > rect.right ? 0 : 1 : iArr[0] - i3 < 0 ? 1 : 0;
    }

    private void G(MenuBuilder menuBuilder) {
        CascadingMenuInfo cascadingMenuInfo;
        View viewD;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1375b);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, layoutInflaterFrom, this.f1379g, C);
        if (!b() && this.f1395w) {
            menuAdapter.d(true);
        } else if (b()) {
            menuAdapter.d(MenuPopup.y(menuBuilder));
        }
        int iP = MenuPopup.p(menuAdapter, null, this.f1375b, this.f1376c);
        MenuPopupWindow menuPopupWindowA = A();
        menuPopupWindowA.m(menuAdapter);
        menuPopupWindowA.E(iP);
        menuPopupWindowA.F(this.f1387o);
        if (this.f1382j.size() > 0) {
            List list = this.f1382j;
            cascadingMenuInfo = (CascadingMenuInfo) list.get(list.size() - 1);
            viewD = D(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            viewD = null;
        }
        if (viewD != null) {
            menuPopupWindowA.U(false);
            menuPopupWindowA.R(null);
            int iF = F(iP);
            boolean z2 = iF == 1;
            this.f1390r = iF;
            menuPopupWindowA.C(viewD);
            if ((this.f1387o & 5) != 5) {
                iP = z2 ? viewD.getWidth() : 0 - iP;
            } else if (!z2) {
                iP = 0 - viewD.getWidth();
            }
            menuPopupWindowA.e(iP);
            menuPopupWindowA.M(true);
            menuPopupWindowA.i(0);
        } else {
            if (this.f1391s) {
                menuPopupWindowA.e(this.f1393u);
            }
            if (this.f1392t) {
                menuPopupWindowA.i(this.f1394v);
            }
            menuPopupWindowA.G(n());
        }
        this.f1382j.add(new CascadingMenuInfo(menuPopupWindowA, menuBuilder, this.f1390r));
        menuPopupWindowA.show();
        ListView listViewO = menuPopupWindowA.o();
        listViewO.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.f1396x && menuBuilder.z() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.f772n, (ViewGroup) listViewO, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.z());
            listViewO.addHeaderView(frameLayout, null, false);
            menuPopupWindowA.show();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z2) {
        int iB = B(menuBuilder);
        if (iB < 0) {
            return;
        }
        int i3 = iB + 1;
        if (i3 < this.f1382j.size()) {
            ((CascadingMenuInfo) this.f1382j.get(i3)).f1407b.e(false);
        }
        CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) this.f1382j.remove(iB);
        cascadingMenuInfo.f1407b.R(this);
        if (this.B) {
            cascadingMenuInfo.f1406a.S(null);
            cascadingMenuInfo.f1406a.D(0);
        }
        cascadingMenuInfo.f1406a.dismiss();
        int size = this.f1382j.size();
        if (size > 0) {
            this.f1390r = ((CascadingMenuInfo) this.f1382j.get(size - 1)).f1408c;
        } else {
            this.f1390r = E();
        }
        if (size != 0) {
            if (z2) {
                ((CascadingMenuInfo) this.f1382j.get(0)).f1407b.e(false);
                return;
            }
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.f1397y;
        if (callback != null) {
            callback.a(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1398z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1398z.removeGlobalOnLayoutListener(this.f1383k);
            }
            this.f1398z = null;
        }
        this.f1389q.removeOnAttachStateChangeListener(this.f1384l);
        this.A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean b() {
        return this.f1382j.size() > 0 && ((CascadingMenuInfo) this.f1382j.get(0)).f1406a.b();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void d(MenuPresenter.Callback callback) {
        this.f1397y = callback;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int size = this.f1382j.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.f1382j.toArray(new CascadingMenuInfo[size]);
            for (int i3 = size - 1; i3 >= 0; i3--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i3];
                if (cascadingMenuInfo.f1406a.b()) {
                    cascadingMenuInfo.f1406a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.f1382j) {
            if (subMenuBuilder == cascadingMenuInfo.f1407b) {
                cascadingMenuInfo.a().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        l(subMenuBuilder);
        MenuPresenter.Callback callback = this.f1397y;
        if (callback != null) {
            callback.b(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable g() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void h(boolean z2) {
        Iterator it = this.f1382j.iterator();
        while (it.hasNext()) {
            MenuPopup.z(((CascadingMenuInfo) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void l(MenuBuilder menuBuilder) {
        menuBuilder.c(this, this.f1375b);
        if (b()) {
            G(menuBuilder);
        } else {
            this.f1381i.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    protected boolean m() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView o() {
        if (this.f1382j.isEmpty()) {
            return null;
        }
        return ((CascadingMenuInfo) this.f1382j.get(r0.size() - 1)).a();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.f1382j.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = (CascadingMenuInfo) this.f1382j.get(i3);
            if (!cascadingMenuInfo.f1406a.b()) {
                break;
            } else {
                i3++;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.f1407b.e(false);
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
        if (this.f1388p != view) {
            this.f1388p = view;
            this.f1387o = GravityCompat.b(this.f1386n, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void s(boolean z2) {
        this.f1395w = z2;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (b()) {
            return;
        }
        Iterator it = this.f1381i.iterator();
        while (it.hasNext()) {
            G((MenuBuilder) it.next());
        }
        this.f1381i.clear();
        View view = this.f1388p;
        this.f1389q = view;
        if (view != null) {
            boolean z2 = this.f1398z == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1398z = viewTreeObserver;
            if (z2) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1383k);
            }
            this.f1389q.addOnAttachStateChangeListener(this.f1384l);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void t(int i3) {
        if (this.f1386n != i3) {
            this.f1386n = i3;
            this.f1387o = GravityCompat.b(i3, this.f1388p.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void u(int i3) {
        this.f1391s = true;
        this.f1393u = i3;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void v(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void w(boolean z2) {
        this.f1396x = z2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void x(int i3) {
        this.f1392t = true;
        this.f1394v = i3;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(Parcelable parcelable) {
    }
}
