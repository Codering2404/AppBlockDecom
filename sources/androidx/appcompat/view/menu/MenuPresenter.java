package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface MenuPresenter {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback {
        void a(MenuBuilder menuBuilder, boolean z2);

        boolean b(MenuBuilder menuBuilder);
    }

    void a(MenuBuilder menuBuilder, boolean z2);

    boolean c(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    void d(Callback callback);

    void e(Parcelable parcelable);

    boolean f(SubMenuBuilder subMenuBuilder);

    Parcelable g();

    int getId();

    void h(boolean z2);

    boolean i();

    boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    void k(Context context, MenuBuilder menuBuilder);
}
