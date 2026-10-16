package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuBuilder B;
    private MenuItemImpl C;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.B = menuBuilder;
        this.C = menuItemImpl;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuBuilder F() {
        return this.B.F();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean I() {
        return this.B.I();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean J() {
        return this.B.J();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean K() {
        return this.B.K();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void W(MenuBuilder.Callback callback) {
        this.B.W(callback);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean f(MenuItemImpl menuItemImpl) {
        return this.B.f(menuItemImpl);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    boolean h(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.h(menuBuilder, menuItem) || this.B.h(menuBuilder, menuItem);
    }

    public Menu j0() {
        return this.B;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean m(MenuItemImpl menuItemImpl) {
        return this.B.m(menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.B.setGroupDividerEnabled(z2);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a0(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.d0(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.e0(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.B.setQwertyMode(z2);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public String v() {
        MenuItemImpl menuItemImpl = this.C;
        int itemId = menuItemImpl != null ? menuItemImpl.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.v() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i3) {
        return (SubMenu) super.Z(i3);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i3) {
        return (SubMenu) super.c0(i3);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i3) {
        this.C.setIcon(i3);
        return this;
    }
}
