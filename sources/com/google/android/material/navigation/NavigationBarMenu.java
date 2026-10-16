package com.google.android.material.navigation;

import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class NavigationBarMenu extends MenuBuilder {
    private final Class B;
    private final int C;

    @Override // androidx.appcompat.view.menu.MenuBuilder
    protected MenuItem a(int i3, int i4, int i5, CharSequence charSequence) {
        if (size() + 1 <= this.C) {
            i0();
            MenuItem menuItemA = super.a(i3, i4, i5, charSequence);
            if (menuItemA instanceof MenuItemImpl) {
                ((MenuItemImpl) menuItemA).t(true);
            }
            h0();
            return menuItemA;
        }
        String simpleName = this.B.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.C + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.B.getSimpleName() + " does not support submenus");
    }
}
