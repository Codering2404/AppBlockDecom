package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
abstract class BaseMenuWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f1372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SimpleArrayMap f1373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SimpleArrayMap f1374c;

    BaseMenuWrapper(Context context) {
        this.f1372a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f1373b == null) {
            this.f1373b = new SimpleArrayMap();
        }
        MenuItem menuItem2 = (MenuItem) this.f1373b.get(supportMenuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f1372a, supportMenuItem);
        this.f1373b.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f1374c == null) {
            this.f1374c = new SimpleArrayMap();
        }
        SubMenu subMenu2 = (SubMenu) this.f1374c.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.f1372a, supportSubMenu);
        this.f1374c.put(supportSubMenu, subMenuWrapperICS);
        return subMenuWrapperICS;
    }

    final void e() {
        SimpleArrayMap simpleArrayMap = this.f1373b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap simpleArrayMap2 = this.f1374c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    final void f(int i3) {
        if (this.f1373b == null) {
            return;
        }
        int i4 = 0;
        while (i4 < this.f1373b.size()) {
            if (((SupportMenuItem) this.f1373b.f(i4)).getGroupId() == i3) {
                this.f1373b.h(i4);
                i4--;
            }
            i4++;
        }
    }

    final void g(int i3) {
        if (this.f1373b == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f1373b.size(); i4++) {
            if (((SupportMenuItem) this.f1373b.f(i4)).getItemId() == i3) {
                this.f1373b.h(i4);
                return;
            }
        }
    }
}
