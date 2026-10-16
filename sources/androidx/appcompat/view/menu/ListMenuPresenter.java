package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f1429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LayoutInflater f1430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    MenuBuilder f1431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ExpandedMenuView f1432d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f1435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MenuPresenter.Callback f1436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    MenuAdapter f1437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1438k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MenuAdapter extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1439a = -1;

        public MenuAdapter() {
            a();
        }

        void a() {
            MenuItemImpl menuItemImplX = ListMenuPresenter.this.f1431c.x();
            if (menuItemImplX != null) {
                ArrayList arrayListB = ListMenuPresenter.this.f1431c.B();
                int size = arrayListB.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (((MenuItemImpl) arrayListB.get(i3)) == menuItemImplX) {
                        this.f1439a = i3;
                        return;
                    }
                }
            }
            this.f1439a = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MenuItemImpl getItem(int i3) {
            ArrayList arrayListB = ListMenuPresenter.this.f1431c.B();
            int i4 = i3 + ListMenuPresenter.this.f1433f;
            int i5 = this.f1439a;
            if (i5 >= 0 && i4 >= i5) {
                i4++;
            }
            return (MenuItemImpl) arrayListB.get(i4);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.f1431c.B().size() - ListMenuPresenter.this.f1433f;
            return this.f1439a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f1430b.inflate(listMenuPresenter.f1435h, viewGroup, false);
            }
            ((MenuView.ItemView) view).c(getItem(i3), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(Context context, int i3) {
        this(i3, 0);
        this.f1429a = context;
        this.f1430b = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z2) {
        MenuPresenter.Callback callback = this.f1436i;
        if (callback != null) {
            callback.a(menuBuilder, z2);
        }
    }

    public ListAdapter b() {
        if (this.f1437j == null) {
            this.f1437j = new MenuAdapter();
        }
        return this.f1437j;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean c(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void d(MenuPresenter.Callback callback) {
        this.f1436i = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(Parcelable parcelable) {
        m((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).d(null);
        MenuPresenter.Callback callback = this.f1436i;
        if (callback == null) {
            return true;
        }
        callback.b(subMenuBuilder);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable g() {
        if (this.f1432d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f1438k;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void h(boolean z2) {
        MenuAdapter menuAdapter = this.f1437j;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void k(Context context, MenuBuilder menuBuilder) {
        if (this.f1434g != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1434g);
            this.f1429a = contextThemeWrapper;
            this.f1430b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f1429a != null) {
            this.f1429a = context;
            if (this.f1430b == null) {
                this.f1430b = LayoutInflater.from(context);
            }
        }
        this.f1431c = menuBuilder;
        MenuAdapter menuAdapter = this.f1437j;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public MenuView l(ViewGroup viewGroup) {
        if (this.f1432d == null) {
            this.f1432d = (ExpandedMenuView) this.f1430b.inflate(R.layout.f767i, viewGroup, false);
            if (this.f1437j == null) {
                this.f1437j = new MenuAdapter();
            }
            this.f1432d.setAdapter((ListAdapter) this.f1437j);
            this.f1432d.setOnItemClickListener(this);
        }
        return this.f1432d;
    }

    public void m(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1432d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void n(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f1432d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
        this.f1431c.P(this.f1437j.getItem(i3), this, 0);
    }

    public ListMenuPresenter(int i3, int i4) {
        this.f1435h = i3;
        this.f1434g = i4;
    }
}
