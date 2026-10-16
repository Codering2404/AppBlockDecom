package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface DecorToolbar {
    void a(Drawable drawable);

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    void e(Menu menu, MenuPresenter.Callback callback);

    boolean f();

    void g();

    Context getContext();

    CharSequence getTitle();

    boolean h();

    boolean i();

    void j(int i3);

    Menu k();

    int l();

    ViewPropertyAnimatorCompat m(int i3, long j3);

    ViewGroup n();

    void o(boolean z2);

    void p(int i3);

    void q();

    void r(boolean z2);

    void s();

    void setIcon(int i3);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i3);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(ScrollingTabContainerView scrollingTabContainerView);

    void u(int i3);

    void v(int i3);

    void w(MenuPresenter.Callback callback, MenuBuilder.Callback callback2);

    int x();

    void y();

    void z(Drawable drawable);
}
