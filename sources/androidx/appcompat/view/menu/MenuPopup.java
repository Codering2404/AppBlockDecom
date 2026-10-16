package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Rect f1514a;

    MenuPopup() {
    }

    protected static int p(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i4 = 0;
        int i5 = 0;
        View view = null;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = listAdapter.getItemViewType(i6);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i6, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i3) {
                return i3;
            }
            if (measuredWidth > i4) {
                i4 = measuredWidth;
            }
        }
        return i4;
    }

    protected static boolean y(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = menuBuilder.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static MenuAdapter z(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (MenuAdapter) listAdapter;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean c(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public abstract void l(MenuBuilder menuBuilder);

    protected boolean m() {
        return true;
    }

    public Rect n() {
        return this.f1514a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        z(listAdapter).f1441a.P((MenuItem) listAdapter.getItem(i3), this, m() ? 0 : 4);
    }

    public abstract void q(View view);

    public void r(Rect rect) {
        this.f1514a = rect;
    }

    public abstract void s(boolean z2);

    public abstract void t(int i3);

    public abstract void u(int i3);

    public abstract void v(PopupWindow.OnDismissListener onDismissListener);

    public abstract void w(boolean z2);

    public abstract void x(int i3);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void k(Context context, MenuBuilder menuBuilder) {
    }
}
