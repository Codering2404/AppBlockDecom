package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MenuBuilder f1473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AlertDialog f1474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ListMenuPresenter f1475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MenuPresenter.Callback f1476d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f1473a = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void a(MenuBuilder menuBuilder, boolean z2) {
        if (z2 || menuBuilder == this.f1473a) {
            c();
        }
        MenuPresenter.Callback callback = this.f1476d;
        if (callback != null) {
            callback.a(menuBuilder, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean b(MenuBuilder menuBuilder) {
        MenuPresenter.Callback callback = this.f1476d;
        if (callback != null) {
            return callback.b(menuBuilder);
        }
        return false;
    }

    public void c() {
        AlertDialog alertDialog = this.f1474b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f1473a;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.w());
        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.b(), R.layout.f770l);
        this.f1475c = listMenuPresenter;
        listMenuPresenter.d(this);
        this.f1473a.b(this.f1475c);
        builder.c(this.f1475c.b(), this);
        View viewA = menuBuilder.A();
        if (viewA != null) {
            builder.e(viewA);
        } else {
            builder.f(menuBuilder.y()).t(menuBuilder.z());
        }
        builder.n(this);
        AlertDialog alertDialogA = builder.a();
        this.f1474b = alertDialogA;
        alertDialogA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1474b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1474b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.f1473a.O((MenuItemImpl) this.f1475c.b().getItem(i3), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1475c.a(this.f1473a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i3 == 82 || i3 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1474b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1474b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1473a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1473a.performShortcut(i3, keyEvent, 0);
    }
}
