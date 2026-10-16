package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AlertController f991g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AlertController.AlertParams f992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f993b;

        public Builder(Context context) {
            this(context, AlertDialog.l(context, 0));
        }

        public AlertDialog a() {
            AlertDialog alertDialog = new AlertDialog(this.f992a.f950a, this.f993b);
            this.f992a.a(alertDialog.f991g);
            alertDialog.setCancelable(this.f992a.f967r);
            if (this.f992a.f967r) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f992a.f968s);
            alertDialog.setOnDismissListener(this.f992a.f969t);
            DialogInterface.OnKeyListener onKeyListener = this.f992a.f970u;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        public Context b() {
            return this.f992a.f950a;
        }

        public Builder c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f972w = listAdapter;
            alertParams.f973x = onClickListener;
            return this;
        }

        public Builder d(boolean z2) {
            this.f992a.f967r = z2;
            return this;
        }

        public Builder e(View view) {
            this.f992a.f956g = view;
            return this;
        }

        public Builder f(Drawable drawable) {
            this.f992a.f953d = drawable;
            return this;
        }

        public Builder g(int i3) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f957h = alertParams.f950a.getText(i3);
            return this;
        }

        public Builder h(CharSequence charSequence) {
            this.f992a.f957h = charSequence;
            return this;
        }

        public Builder i(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f971v = charSequenceArr;
            alertParams.J = onMultiChoiceClickListener;
            alertParams.F = zArr;
            alertParams.G = true;
            return this;
        }

        public Builder j(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f961l = alertParams.f950a.getText(i3);
            this.f992a.f963n = onClickListener;
            return this;
        }

        public Builder k(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f961l = charSequence;
            alertParams.f963n = onClickListener;
            return this;
        }

        public Builder l(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f964o = alertParams.f950a.getText(i3);
            this.f992a.f966q = onClickListener;
            return this;
        }

        public Builder m(DialogInterface.OnCancelListener onCancelListener) {
            this.f992a.f968s = onCancelListener;
            return this;
        }

        public Builder n(DialogInterface.OnKeyListener onKeyListener) {
            this.f992a.f970u = onKeyListener;
            return this;
        }

        public Builder o(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f958i = alertParams.f950a.getText(i3);
            this.f992a.f960k = onClickListener;
            return this;
        }

        public Builder p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f958i = charSequence;
            alertParams.f960k = onClickListener;
            return this;
        }

        public Builder q(ListAdapter listAdapter, int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f972w = listAdapter;
            alertParams.f973x = onClickListener;
            alertParams.I = i3;
            alertParams.H = true;
            return this;
        }

        public Builder r(CharSequence[] charSequenceArr, int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f971v = charSequenceArr;
            alertParams.f973x = onClickListener;
            alertParams.I = i3;
            alertParams.H = true;
            return this;
        }

        public Builder s(int i3) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f955f = alertParams.f950a.getText(i3);
            return this;
        }

        public Builder t(CharSequence charSequence) {
            this.f992a.f955f = charSequence;
            return this;
        }

        public Builder u(View view) {
            AlertController.AlertParams alertParams = this.f992a;
            alertParams.f975z = view;
            alertParams.f974y = 0;
            alertParams.E = false;
            return this;
        }

        public AlertDialog v() {
            AlertDialog alertDialogA = a();
            alertDialogA.show();
            return alertDialogA;
        }

        public Builder(Context context, int i3) {
            this.f992a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.l(context, i3)));
            this.f993b = i3;
        }
    }

    protected AlertDialog(Context context, int i3) {
        super(context, l(context, i3));
        this.f991g = new AlertController(getContext(), this, getWindow());
    }

    static int l(Context context, int i3) {
        if (((i3 >>> 24) & 255) >= 1) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.f661p, typedValue, true);
        return typedValue.resourceId;
    }

    public Button j(int i3) {
        return this.f991g.c(i3);
    }

    public ListView k() {
        return this.f991g.e();
    }

    public void m(View view) {
        this.f991g.t(view);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f991g.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (this.f991g.h(i3, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (this.f991g.i(i3, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f991g.r(charSequence);
    }
}
