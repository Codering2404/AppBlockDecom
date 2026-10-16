package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f1279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ActionMode f1280b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CallbackWrapper implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f1281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f1282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList f1283c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SimpleArrayMap f1284d = new SimpleArrayMap();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f1282b = context;
            this.f1281a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f1284d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.f1282b, (SupportMenu) menu);
            this.f1284d.put(menu, menuWrapperICS);
            return menuWrapperICS;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void a(ActionMode actionMode) {
            this.f1281a.onDestroyActionMode(e(actionMode));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean b(ActionMode actionMode, Menu menu) {
            return this.f1281a.onCreateActionMode(e(actionMode), f(menu));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean c(ActionMode actionMode, MenuItem menuItem) {
            return this.f1281a.onActionItemClicked(e(actionMode), new MenuItemWrapperICS(this.f1282b, (SupportMenuItem) menuItem));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean d(ActionMode actionMode, Menu menu) {
            return this.f1281a.onPrepareActionMode(e(actionMode), f(menu));
        }

        public android.view.ActionMode e(ActionMode actionMode) {
            int size = this.f1283c.size();
            for (int i3 = 0; i3 < size; i3++) {
                SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) this.f1283c.get(i3);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f1280b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f1282b, actionMode);
            this.f1283c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f1279a = context;
        this.f1280b = actionMode;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1280b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1280b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.f1279a, (SupportMenu) this.f1280b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1280b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1280b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1280b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1280b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1280b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1280b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1280b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1280b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1280b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1280b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1280b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z2) {
        this.f1280b.s(z2);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i3) {
        this.f1280b.n(i3);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i3) {
        this.f1280b.q(i3);
    }
}
