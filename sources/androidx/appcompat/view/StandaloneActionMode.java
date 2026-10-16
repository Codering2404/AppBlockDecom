package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f1272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ActionBarContextView f1273d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ActionMode.Callback f1274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WeakReference f1275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1277i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MenuBuilder f1278j;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z2) {
        this.f1272c = context;
        this.f1273d = actionBarContextView;
        this.f1274f = callback;
        MenuBuilder menuBuilderX = new MenuBuilder(actionBarContextView.getContext()).X(1);
        this.f1278j = menuBuilderX;
        menuBuilderX.W(this);
        this.f1277i = z2;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f1274f.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void b(MenuBuilder menuBuilder) {
        k();
        this.f1273d.g();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void c() {
        if (this.f1276h) {
            return;
        }
        this.f1276h = true;
        this.f1274f.a(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    public View d() {
        WeakReference weakReference = this.f1275g;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.ActionMode
    public Menu e() {
        return this.f1278j;
    }

    @Override // androidx.appcompat.view.ActionMode
    public MenuInflater f() {
        return new SupportMenuInflater(this.f1273d.getContext());
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence g() {
        return this.f1273d.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence i() {
        return this.f1273d.getTitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void k() {
        this.f1274f.d(this, this.f1278j);
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean l() {
        return this.f1273d.k();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void m(View view) {
        this.f1273d.setCustomView(view);
        this.f1275g = view != null ? new WeakReference(view) : null;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void n(int i3) {
        o(this.f1272c.getString(i3));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void o(CharSequence charSequence) {
        this.f1273d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void q(int i3) {
        r(this.f1272c.getString(i3));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void r(CharSequence charSequence) {
        this.f1273d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void s(boolean z2) {
        super.s(z2);
        this.f1273d.setTitleOptional(z2);
    }
}
