package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SupportMenuItem f1504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f1505e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ActionProviderWrapper extends ActionProvider implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ActionProvider.VisibilityListener f1506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final android.view.ActionProvider f1507e;

        ActionProviderWrapper(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f1507e = actionProvider;
        }

        @Override // androidx.core.view.ActionProvider
        public boolean a() {
            return this.f1507e.hasSubMenu();
        }

        @Override // androidx.core.view.ActionProvider
        public boolean b() {
            return this.f1507e.isVisible();
        }

        @Override // androidx.core.view.ActionProvider
        public View c() {
            return this.f1507e.onCreateActionView();
        }

        @Override // androidx.core.view.ActionProvider
        public View d(MenuItem menuItem) {
            return this.f1507e.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.ActionProvider
        public boolean e() {
            return this.f1507e.onPerformDefaultAction();
        }

        @Override // androidx.core.view.ActionProvider
        public void f(SubMenu subMenu) {
            this.f1507e.onPrepareSubMenu(MenuItemWrapperICS.this.d(subMenu));
        }

        @Override // androidx.core.view.ActionProvider
        public boolean g() {
            return this.f1507e.overridesItemVisibility();
        }

        @Override // androidx.core.view.ActionProvider
        public void j(ActionProvider.VisibilityListener visibilityListener) {
            this.f1506d = visibilityListener;
            this.f1507e.setVisibilityListener(visibilityListener != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z2) {
            ActionProvider.VisibilityListener visibilityListener = this.f1506d;
            if (visibilityListener != null) {
                visibilityListener.onActionProviderVisibilityChanged(z2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final android.view.CollapsibleActionView f1509a;

        /* JADX WARN: Multi-variable type inference failed */
        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f1509a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f1509a;
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            this.f1509a.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        public void onActionViewExpanded() {
            this.f1509a.onActionViewExpanded();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f1510a;

        OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f1510a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f1510a.onMenuItemActionCollapse(MenuItemWrapperICS.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f1510a.onMenuItemActionExpand(MenuItemWrapperICS.this.c(menuItem));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f1512a;

        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f1512a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f1512a.onMenuItemClick(MenuItemWrapperICS.this.c(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1504d = supportMenuItem;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f1504d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f1504d.expandActionView();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider actionProviderA = this.f1504d.a();
        if (actionProviderA instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) actionProviderA).f1507e;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f1504d.getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1504d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1504d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1504d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1504d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1504d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1504d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1504d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1504d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1504d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1504d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1504d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1504d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1504d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f1504d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1504d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f1504d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1504d.getTooltipText();
    }

    public void h(boolean z2) {
        try {
            if (this.f1505e == null) {
                this.f1505e = this.f1504d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1505e.invoke(this.f1504d, Boolean.valueOf(z2));
        } catch (Exception e3) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e3);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1504d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1504d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f1504d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f1504d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f1504d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f1504d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ActionProviderWrapper actionProviderWrapper = new ActionProviderWrapper(this.f1372a, actionProvider);
        SupportMenuItem supportMenuItem = this.f1504d;
        if (actionProvider == null) {
            actionProviderWrapper = null;
        }
        supportMenuItem.b(actionProviderWrapper);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.f1504d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        this.f1504d.setAlphabeticShortcut(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f1504d.setCheckable(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f1504d.setChecked(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f1504d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f1504d.setEnabled(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1504d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1504d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1504d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1504d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        this.f1504d.setNumericShortcut(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1504d.setOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1504d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.f1504d.setShortcut(c3, c4);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i3) {
        this.f1504d.setShowAsAction(i3);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i3) {
        this.f1504d.setShowAsActionFlags(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1504d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1504d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f1504d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        return this.f1504d.setVisible(z2);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        this.f1504d.setAlphabeticShortcut(c3, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f1504d.setIcon(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        this.f1504d.setNumericShortcut(c3, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f1504d.setShortcut(c3, c4, i3, i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.f1504d.setTitle(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i3) {
        this.f1504d.setActionView(i3);
        View actionView = this.f1504d.getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            this.f1504d.setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }
}
