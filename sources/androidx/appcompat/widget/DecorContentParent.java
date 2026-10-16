package androidx.appcompat.widget;

import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface DecorContentParent {
    boolean b();

    boolean c();

    boolean d();

    void e(Menu menu, MenuPresenter.Callback callback);

    boolean f();

    void g();

    boolean h();

    void i(int i3);

    void m();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
