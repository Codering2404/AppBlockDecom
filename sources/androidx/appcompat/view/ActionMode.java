package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f1264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1265b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback {
        void a(ActionMode actionMode);

        boolean b(ActionMode actionMode, Menu menu);

        boolean c(ActionMode actionMode, MenuItem menuItem);

        boolean d(ActionMode actionMode, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f1264a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f1265b;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    public abstract void m(View view);

    public abstract void n(int i3);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f1264a = obj;
    }

    public abstract void q(int i3);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z2) {
        this.f1265b = z2;
    }
}
