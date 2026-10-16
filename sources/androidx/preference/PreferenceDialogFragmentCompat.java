package androidx.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.preference.DialogPreference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DialogPreference f50854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f50855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CharSequence f50856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f50857d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f50858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f50859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BitmapDrawable f50860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f50861i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api30Impl {
        static void a(Window window) {
            window.getDecorView().getWindowInsetsController().show(WindowInsets.Type.ime());
        }
    }

    private void E(Dialog dialog) {
        Window window = dialog.getWindow();
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(window);
        } else {
            F();
        }
    }

    protected void A(View view) {
        int i3;
        View viewFindViewById = view.findViewById(android.R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f50858f;
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

    protected View B(Context context) {
        int i3 = this.f50859g;
        if (i3 == 0) {
            return null;
        }
        return getLayoutInflater().inflate(i3, (ViewGroup) null);
    }

    public abstract void C(boolean z2);

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        this.f50861i = i3;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityResultCaller targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.TargetFragment)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.TargetFragment targetFragment2 = (DialogPreference.TargetFragment) targetFragment;
        String string = requireArguments().getString("key");
        if (bundle != null) {
            this.f50855b = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f50856c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f50857d = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f50858f = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f50859g = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f50860h = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) targetFragment2.h(string);
        this.f50854a = dialogPreference;
        this.f50855b = dialogPreference.H0();
        this.f50856c = this.f50854a.J0();
        this.f50857d = this.f50854a.I0();
        this.f50858f = this.f50854a.G0();
        this.f50859g = this.f50854a.F0();
        Drawable drawableE0 = this.f50854a.E0();
        if (drawableE0 == null || (drawableE0 instanceof BitmapDrawable)) {
            this.f50860h = (BitmapDrawable) drawableE0;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableE0.getIntrinsicWidth(), drawableE0.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableE0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableE0.draw(canvas);
        this.f50860h = new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.f50861i = -2;
        AlertDialog.Builder builderK = new AlertDialog.Builder(requireContext()).t(this.f50855b).f(this.f50860h).p(this.f50856c, this).k(this.f50857d, this);
        View viewB = B(requireContext());
        if (viewB != null) {
            A(viewB);
            builderK.u(viewB);
        } else {
            builderK.h(this.f50858f);
        }
        D(builderK);
        AlertDialog alertDialogA = builderK.a();
        if (z()) {
            E(alertDialogA);
        }
        return alertDialogA;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        C(this.f50861i == -1);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f50855b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f50856c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f50857d);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f50858f);
        bundle.putInt("PreferenceDialogFragment.layout", this.f50859g);
        BitmapDrawable bitmapDrawable = this.f50860h;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public DialogPreference y() {
        if (this.f50854a == null) {
            this.f50854a = (DialogPreference) ((DialogPreference.TargetFragment) getTargetFragment()).h(requireArguments().getString("key"));
        }
        return this.f50854a;
    }

    protected boolean z() {
        return false;
    }

    protected void F() {
    }

    protected void D(AlertDialog.Builder builder) {
    }
}
