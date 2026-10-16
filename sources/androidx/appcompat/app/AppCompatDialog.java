package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppCompatDelegate f1088d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final KeyEventDispatcher.Component f1089f;

    public AppCompatDialog(Context context, int i3) {
        super(context, f(context, i3));
        this.f1089f = new KeyEventDispatcher.Component() { // from class: androidx.appcompat.app.j
            @Override // androidx.core.view.KeyEventDispatcher.Component
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f1175a.h(keyEvent);
            }
        };
        AppCompatDelegate appCompatDelegateE = e();
        appCompatDelegateE.W(f(context, i3));
        appCompatDelegateE.E(null);
    }

    private static int f(Context context, int i3) {
        if (i3 != 0) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.S, typedValue, true);
        return typedValue.resourceId;
    }

    private void g() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.b(getWindow().getDecorView(), this);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e().f(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        e().F();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.b(this.f1089f, getWindow().getDecorView(), this, keyEvent);
    }

    public AppCompatDelegate e() {
        if (this.f1088d == null) {
            this.f1088d = AppCompatDelegate.o(this, this);
        }
        return this.f1088d;
    }

    @Override // android.app.Dialog
    public View findViewById(int i3) {
        return e().p(i3);
    }

    boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean i(int i3) {
        return e().N(i3);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        e().B();
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        e().A();
        super.onCreate(bundle);
        e().E(bundle);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        e().K();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i3) {
        g();
        e().Q(i3);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().X(charSequence);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        g();
        e().R(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        super.setTitle(i3);
        e().X(getContext().getString(i3));
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        e().S(view, layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }
}
