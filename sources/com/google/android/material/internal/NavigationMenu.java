package com.google.android.material.internal;

import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class NavigationMenu extends MenuBuilder {
    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) a(i3, i4, i5, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(w(), this, menuItemImpl);
        menuItemImpl.x(navigationSubMenu);
        return navigationSubMenu;
    }
}
