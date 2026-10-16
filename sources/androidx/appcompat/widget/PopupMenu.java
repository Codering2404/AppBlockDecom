package androidx.appcompat.widget;

import android.view.MenuItem;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class PopupMenu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MenuPopupHelper f2055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    OnMenuItemClickListener f2056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    OnDismissListener f2057c;

    /* JADX INFO: renamed from: androidx.appcompat.widget.PopupMenu$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PopupMenu f2059a;

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PopupMenu popupMenu = this.f2059a;
            OnDismissListener onDismissListener = popupMenu.f2057c;
            if (onDismissListener != null) {
                onDismissListener.a(popupMenu);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.PopupMenu$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends ForwardingListener {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ PopupMenu f2060k;

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu b() {
            return this.f2060k.f2055a.c();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean c() {
            this.f2060k.b();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean d() {
            this.f2060k.a();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnDismissListener {
        void a(PopupMenu popupMenu);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public void a() {
        this.f2055a.b();
    }

    public void b() {
        this.f2055a.k();
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.PopupMenu$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements MenuBuilder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PopupMenu f2058a;

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = this.f2058a.f2056b;
            if (onMenuItemClickListener != null) {
                return onMenuItemClickListener.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void b(MenuBuilder menuBuilder) {
        }
    }
}
