package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class ToolbarActionBar extends ActionBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final DecorToolbar f1104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Window.Callback f1105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AppCompatDelegateImpl.ActionBarMenuCallback f1106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f1107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f1110g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f1111h = new Runnable() { // from class: androidx.appcompat.app.ToolbarActionBar.1
        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar.this.E();
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Toolbar.OnMenuItemClickListener f1112i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1115a;

        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(MenuBuilder menuBuilder, boolean z2) {
            if (this.f1115a) {
                return;
            }
            this.f1115a = true;
            ToolbarActionBar.this.f1104a.s();
            ToolbarActionBar.this.f1105b.onPanelClosed(108, menuBuilder);
            this.f1115a = false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(MenuBuilder menuBuilder) {
            ToolbarActionBar.this.f1105b.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void b(MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f1104a.f()) {
                ToolbarActionBar.this.f1105b.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.f1105b.onPreparePanel(0, null, menuBuilder)) {
                ToolbarActionBar.this.f1105b.onMenuOpened(108, menuBuilder);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        ToolbarMenuCallback() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public boolean a(int i3) {
            if (i3 != 0) {
                return false;
            }
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.f1107d) {
                return false;
            }
            toolbarActionBar.f1104a.g();
            ToolbarActionBar.this.f1107d = true;
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public View onCreatePanelView(int i3) {
            if (i3 == 0) {
                return new View(ToolbarActionBar.this.f1104a.getContext());
            }
            return null;
        }
    }

    ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() { // from class: androidx.appcompat.app.ToolbarActionBar.2
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                return ToolbarActionBar.this.f1105b.onMenuItemSelected(0, menuItem);
            }
        };
        this.f1112i = onMenuItemClickListener;
        Preconditions.h(toolbar);
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.f1104a = toolbarWidgetWrapper;
        this.f1105b = (Window.Callback) Preconditions.h(callback);
        toolbarWidgetWrapper.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        toolbarWidgetWrapper.setWindowTitle(charSequence);
        this.f1106c = new ToolbarMenuCallback();
    }

    private Menu D() {
        if (!this.f1108e) {
            this.f1104a.w(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.f1108e = true;
        }
        return this.f1104a.k();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void A(CharSequence charSequence) {
        this.f1104a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void B(CharSequence charSequence) {
        this.f1104a.setWindowTitle(charSequence);
    }

    void E() {
        Menu menuD = D();
        MenuBuilder menuBuilder = menuD instanceof MenuBuilder ? (MenuBuilder) menuD : null;
        if (menuBuilder != null) {
            menuBuilder.i0();
        }
        try {
            menuD.clear();
            if (!this.f1105b.onCreatePanelMenu(0, menuD) || !this.f1105b.onPreparePanel(0, null, menuD)) {
                menuD.clear();
            }
            if (menuBuilder != null) {
                menuBuilder.h0();
            }
        } catch (Throwable th) {
            if (menuBuilder != null) {
                menuBuilder.h0();
            }
            throw th;
        }
    }

    public void F(int i3, int i4) {
        this.f1104a.j((i3 & i4) | ((~i4) & this.f1104a.x()));
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean f() {
        return this.f1104a.c();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean g() {
        if (!this.f1104a.i()) {
            return false;
        }
        this.f1104a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void h(boolean z2) {
        if (z2 == this.f1109f) {
            return;
        }
        this.f1109f = z2;
        int size = this.f1110g.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ActionBar.OnMenuVisibilityListener) this.f1110g.get(i3)).onMenuVisibilityChanged(z2);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public int i() {
        return this.f1104a.x();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context j() {
        return this.f1104a.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void k() {
        this.f1104a.setVisibility(8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean l() {
        this.f1104a.n().removeCallbacks(this.f1111h);
        ViewCompat.e0(this.f1104a.n(), this.f1111h);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.ActionBar
    void n() {
        this.f1104a.n().removeCallbacks(this.f1111h);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean o(int i3, KeyEvent keyEvent) {
        Menu menuD = D();
        if (menuD == null) {
            return false;
        }
        menuD.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuD.performShortcut(i3, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean q() {
        return this.f1104a.d();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void r(Drawable drawable) {
        this.f1104a.a(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t(boolean z2) {
        F(z2 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void u(boolean z2) {
        F(z2 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void v(float f3) {
        ViewCompat.u0(this.f1104a.n(), f3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void w(int i3) {
        this.f1104a.p(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void x(int i3) {
        this.f1104a.v(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void y(Drawable drawable) {
        this.f1104a.z(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s(boolean z2) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void z(boolean z2) {
    }
}
