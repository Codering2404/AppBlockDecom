package androidx.preference;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.preference.DialogPreference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class PreferenceDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DialogPreference f50846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f50847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CharSequence f50848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f50849d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f50850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f50851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BitmapDrawable f50852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f50853i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api30Impl {
        static void a(Window window) {
            window.getDecorView().getWindowInsetsController().show(WindowInsets.Type.ime());
        }
    }

    private void g(Dialog dialog) {
        Window window = dialog.getWindow();
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(window);
        } else {
            window.setSoftInputMode(5);
        }
    }

    public DialogPreference a() {
        if (this.f50846a == null) {
            this.f50846a = (DialogPreference) ((DialogPreference.TargetFragment) getTargetFragment()).h(getArguments().getString("key"));
        }
        return this.f50846a;
    }

    protected boolean b() {
        return false;
    }

    protected void c(View view) {
        int i3;
        View viewFindViewById = view.findViewById(android.R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f50850f;
            if (TextUtils.isEmpty(charSequence)) {
                i3 = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i3 = 0;
            }
            if (viewFindViewById.getVisibility() != i3) {
                viewFindViewById.setVisibility(i3);
            }
        }
    }

    protected View d(Context context) {
        int i3 = this.f50851g;
        if (i3 == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
    }

    public abstract void e(boolean z2);

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.f50853i = i3;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentCallbacks2 targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.TargetFragment)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.TargetFragment targetFragment2 = (DialogPreference.TargetFragment) targetFragment;
        String string = getArguments().getString("key");
        if (bundle != null) {
            this.f50847b = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f50848c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f50849d = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f50850f = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f50851g = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f50852h = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) targetFragment2.h(string);
        this.f50846a = dialogPreference;
        this.f50847b = dialogPreference.H0();
        this.f50848c = this.f50846a.J0();
        this.f50849d = this.f50846a.I0();
        this.f50850f = this.f50846a.G0();
        this.f50851g = this.f50846a.F0();
        Drawable drawableE0 = this.f50846a.E0();
        if (drawableE0 == null || (drawableE0 instanceof BitmapDrawable)) {
            this.f50852h = (BitmapDrawable) drawableE0;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableE0.getIntrinsicWidth(), drawableE0.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableE0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableE0.draw(canvas);
        this.f50852h = new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Activity activity = getActivity();
        this.f50853i = -2;
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity).setTitle(this.f50847b).setIcon(this.f50852h).setPositiveButton(this.f50848c, this).setNegativeButton(this.f50849d, this);
        View viewD = d(activity);
        if (viewD != null) {
            c(viewD);
            negativeButton.setView(viewD);
        } else {
            negativeButton.setMessage(this.f50850f);
        }
        f(negativeButton);
        AlertDialog alertDialogCreate = negativeButton.create();
        if (b()) {
            g(alertDialogCreate);
        }
        return alertDialogCreate;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        e(this.f50853i == -1);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f50847b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f50848c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f50849d);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f50850f);
        bundle.putInt("PreferenceDialogFragment.layout", this.f50851g);
        BitmapDrawable bitmapDrawable = this.f50852h;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    protected void f(AlertDialog.Builder builder) {
    }
}
