package androidx.biometric;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class FingerprintDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Handler f2481a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Runnable f2482b = new Runnable() { // from class: androidx.biometric.FingerprintDialogFragment.1
        @Override // java.lang.Runnable
        public void run() {
            FingerprintDialogFragment.this.C();
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    BiometricViewModel f2483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2484d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f2486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    TextView f2487h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api21Impl {
        static void a(Drawable drawable) {
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api26Impl {
        static int a() {
            return R.attr.f2496a;
        }
    }

    private int A(int i3) {
        Context context = getContext();
        FragmentActivity activity = getActivity();
        if (context == null || activity == null) {
            Log.w("FingerprintFragment", "Unable to get themed color. Context or activity is null.");
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i3, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(typedValue.data, new int[]{i3});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }

    static FingerprintDialogFragment B() {
        return new FingerprintDialogFragment();
    }

    private boolean D(int i3, int i4) {
        if (i3 == 0 && i4 == 1) {
            return false;
        }
        if (i3 == 1 && i4 == 2) {
            return true;
        }
        return i3 == 2 && i4 == 1;
    }

    private void y() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        BiometricViewModel biometricViewModel = (BiometricViewModel) new ViewModelProvider(activity).a(BiometricViewModel.class);
        this.f2483c = biometricViewModel;
        biometricViewModel.L0().j(this, new Observer<Integer>() { // from class: androidx.biometric.FingerprintDialogFragment.3
            @Override // androidx.lifecycle.Observer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Integer num) {
                FingerprintDialogFragment fingerprintDialogFragment = FingerprintDialogFragment.this;
                fingerprintDialogFragment.f2481a.removeCallbacks(fingerprintDialogFragment.f2482b);
                FingerprintDialogFragment.this.E(num.intValue());
                FingerprintDialogFragment.this.F(num.intValue());
                FingerprintDialogFragment fingerprintDialogFragment2 = FingerprintDialogFragment.this;
                fingerprintDialogFragment2.f2481a.postDelayed(fingerprintDialogFragment2.f2482b, 2000L);
            }
        });
        this.f2483c.J0().j(this, new Observer<CharSequence>() { // from class: androidx.biometric.FingerprintDialogFragment.4
            @Override // androidx.lifecycle.Observer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(CharSequence charSequence) {
                FingerprintDialogFragment fingerprintDialogFragment = FingerprintDialogFragment.this;
                fingerprintDialogFragment.f2481a.removeCallbacks(fingerprintDialogFragment.f2482b);
                FingerprintDialogFragment.this.G(charSequence);
                FingerprintDialogFragment fingerprintDialogFragment2 = FingerprintDialogFragment.this;
                fingerprintDialogFragment2.f2481a.postDelayed(fingerprintDialogFragment2.f2482b, 2000L);
            }
        });
    }

    private Drawable z(int i3, int i4) {
        int i5;
        Context context = getContext();
        if (context == null) {
            Log.w("FingerprintFragment", "Unable to get asset. Context is null.");
            return null;
        }
        if (i3 == 0 && i4 == 1) {
            i5 = R.drawable.f2498b;
        } else if (i3 == 1 && i4 == 2) {
            i5 = R.drawable.f2497a;
        } else if (i3 == 2 && i4 == 1) {
            i5 = R.drawable.f2498b;
        } else {
            if (i3 != 1 || i4 != 3) {
                return null;
            }
            i5 = R.drawable.f2498b;
        }
        return ContextCompat.getDrawable(context, i5);
    }

    void C() {
        Context context = getContext();
        if (context == null) {
            Log.w("FingerprintFragment", "Not resetting the dialog. Context is null.");
        } else {
            this.f2483c.n1(1);
            this.f2483c.l1(context.getString(R.string.f2506c));
        }
    }

    void E(int i3) {
        int iK0;
        Drawable drawableZ;
        if (this.f2486g == null || (drawableZ = z((iK0 = this.f2483c.K0()), i3)) == null) {
            return;
        }
        this.f2486g.setImageDrawable(drawableZ);
        if (D(iK0, i3)) {
            Api21Impl.a(drawableZ);
        }
        this.f2483c.m1(i3);
    }

    void F(int i3) {
        TextView textView = this.f2487h;
        if (textView != null) {
            textView.setTextColor(i3 == 2 ? this.f2484d : this.f2485f);
        }
    }

    void G(CharSequence charSequence) {
        TextView textView = this.f2487h;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.f2483c.j1(true);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y();
        this.f2484d = A(Api26Impl.a());
        this.f2485f = A(android.R.attr.textColorSecondary);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.t(this.f2483c.Q0());
        View viewInflate = LayoutInflater.from(builder.b()).inflate(R.layout.f2503a, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.f2502d);
        if (textView != null) {
            CharSequence charSequenceP0 = this.f2483c.P0();
            if (TextUtils.isEmpty(charSequenceP0)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(charSequenceP0);
            }
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.f2499a);
        if (textView2 != null) {
            CharSequence charSequenceI0 = this.f2483c.I0();
            if (TextUtils.isEmpty(charSequenceI0)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(charSequenceI0);
            }
        }
        this.f2486g = (ImageView) viewInflate.findViewById(R.id.f2501c);
        this.f2487h = (TextView) viewInflate.findViewById(R.id.f2500b);
        builder.k(AuthenticatorUtils.b(this.f2483c.y0()) ? getString(R.string.f2504a) : this.f2483c.O0(), new DialogInterface.OnClickListener() { // from class: androidx.biometric.FingerprintDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                FingerprintDialogFragment.this.f2483c.p1(true);
            }
        });
        builder.u(viewInflate);
        AlertDialog alertDialogA = builder.a();
        alertDialogA.setCanceledOnTouchOutside(false);
        return alertDialogA;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f2481a.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f2483c.m1(0);
        this.f2483c.n1(1);
        this.f2483c.l1(getString(R.string.f2506c));
    }
}
