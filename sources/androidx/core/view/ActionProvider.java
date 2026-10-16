package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ActionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f34380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SubUiVisibilityListener f34381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VisibilityListener f34382c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SubUiVisibilityListener {
        void b(boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z2);
    }

    public ActionProvider(Context context) {
        this.f34380a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f34382c = null;
        this.f34381b = null;
    }

    public void i(SubUiVisibilityListener subUiVisibilityListener) {
        this.f34381b = subUiVisibilityListener;
    }

    public void j(VisibilityListener visibilityListener) {
        if (this.f34382c != null && visibilityListener != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f34382c = visibilityListener;
    }

    public void k(boolean z2) {
        SubUiVisibilityListener subUiVisibilityListener = this.f34381b;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.b(z2);
        }
    }

    public void f(SubMenu subMenu) {
    }
}
