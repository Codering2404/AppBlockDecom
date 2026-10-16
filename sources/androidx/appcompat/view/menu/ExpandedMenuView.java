package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f1409c = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MenuBuilder f1410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1411b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void a(MenuBuilder menuBuilder) {
        this.f1410a = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean b(MenuItemImpl menuItemImpl) {
        return this.f1410a.O(menuItemImpl, 0);
    }

    public int getWindowAnimations() {
        return this.f1411b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
        b((MenuItemImpl) getAdapter().getItem(i3));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, f1409c, i3, 0);
        if (tintTypedArrayV.s(0)) {
            setBackgroundDrawable(tintTypedArrayV.g(0));
        }
        if (tintTypedArrayV.s(1)) {
            setDivider(tintTypedArrayV.g(1));
        }
        tintTypedArrayV.x();
    }
}
