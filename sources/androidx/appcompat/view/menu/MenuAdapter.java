package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MenuBuilder f1441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1442b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f1444d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LayoutInflater f1445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f1446g;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z2, int i3) {
        this.f1444d = z2;
        this.f1445f = layoutInflater;
        this.f1441a = menuBuilder;
        this.f1446g = i3;
        a();
    }

    void a() {
        MenuItemImpl menuItemImplX = this.f1441a.x();
        if (menuItemImplX != null) {
            ArrayList arrayListB = this.f1441a.B();
            int size = arrayListB.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((MenuItemImpl) arrayListB.get(i3)) == menuItemImplX) {
                    this.f1442b = i3;
                    return;
                }
            }
        }
        this.f1442b = -1;
    }

    public MenuBuilder b() {
        return this.f1441a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public MenuItemImpl getItem(int i3) {
        ArrayList arrayListB = this.f1444d ? this.f1441a.B() : this.f1441a.G();
        int i4 = this.f1442b;
        if (i4 >= 0 && i3 >= i4) {
            i3++;
        }
        return (MenuItemImpl) arrayListB.get(i3);
    }

    public void d(boolean z2) {
        this.f1443c = z2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1442b < 0 ? (this.f1444d ? this.f1441a.B() : this.f1441a.G()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1445f.inflate(this.f1446g, viewGroup, false);
        }
        int groupId = getItem(i3).getGroupId();
        int i4 = i3 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1441a.I() && groupId != (i4 >= 0 ? getItem(i4).getGroupId() : groupId));
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.f1443c) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.c(getItem(i3), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
