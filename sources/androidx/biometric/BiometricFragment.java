package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.ads.AdError;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class BiometricFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f2413a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    BiometricViewModel f2414b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private static class Api21Impl {
        static Intent a(KeyguardManager keyguardManager, CharSequence charSequence, CharSequence charSequence2) {
            return keyguardManager.createConfirmDeviceCredentialIntent(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private static class Api28Impl {
        static void a(android.hardware.biometrics.BiometricPrompt biometricPrompt, BiometricPrompt.CryptoObject cryptoObject, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt.AuthenticationCallback authenticationCallback) {
            biometricPrompt.authenticate(cryptoObject, cancellationSignal, executor, authenticationCallback);
        }

        static void b(android.hardware.biometrics.BiometricPrompt biometricPrompt, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt.AuthenticationCallback authenticationCallback) {
            biometricPrompt.authenticate(cancellationSignal, executor, authenticationCallback);
        }

        static android.hardware.biometrics.BiometricPrompt c(BiometricPrompt.Builder builder) {
            return builder.build();
        }

        static BiometricPrompt.Builder d(Context context) {
            return new BiometricPrompt.Builder(context);
        }

        static void e(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        static void f(BiometricPrompt.Builder builder, CharSequence charSequence, Executor executor, DialogInterface.OnClickListener onClickListener) {
            builder.setNegativeButton(charSequence, executor, onClickListener);
        }

        static void g(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        static void h(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private static class Api29Impl {
        static void a(BiometricPrompt.Builder builder, boolean z2) {
            builder.setConfirmationRequired(z2);
        }

        static void b(BiometricPrompt.Builder builder, boolean z2) {
            builder.setDeviceCredentialAllowed(z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private static class Api30Impl {
        static void a(BiometricPrompt.Builder builder, int i3) {
            builder.setAllowedAuthenticators(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private static class PromptExecutor implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f2431a = new Handler(Looper.getMainLooper());

        PromptExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f2431a.post(runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private static class ShowPromptForAuthenticationRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f2432a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2432a.get() != null) {
                ((BiometricFragment) this.f2432a.get()).Z();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private static class StopDelayingPromptRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f2433a;

        StopDelayingPromptRunnable(BiometricViewModel biometricViewModel) {
            this.f2433a = new WeakReference(biometricViewModel);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2433a.get() != null) {
                ((BiometricViewModel) this.f2433a.get()).i1(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private static class StopIgnoringCancelRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f2434a;

        StopIgnoringCancelRunnable(BiometricViewModel biometricViewModel) {
            this.f2434a = new WeakReference(biometricViewModel);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2434a.get() != null) {
                ((BiometricViewModel) this.f2434a.get()).o1(false);
            }
        }
    }

    private void A() {
        if (getActivity() == null) {
            return;
        }
        BiometricViewModel biometricViewModel = (BiometricViewModel) new ViewModelProvider(getActivity()).a(BiometricViewModel.class);
        this.f2414b = biometricViewModel;
        biometricViewModel.C0().j(this, new Observer<BiometricPrompt.AuthenticationResult>() { // from class: androidx.biometric.BiometricFragment.1
            @Override // androidx.lifecycle.Observer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BiometricPrompt.AuthenticationResult authenticationResult) {
                if (authenticationResult != null) {
                    BiometricFragment.this.O(authenticationResult);
                    BiometricFragment.this.f2414b.e1(null);
                }
            }
        });
        this.f2414b.A0().j(this, new Observer<BiometricErrorData>() { // from class: androidx.biometric.BiometricFragment.2
            @Override // androidx.lifecycle.Observer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BiometricErrorData biometricErrorData) {
                if (biometricErrorData != null) {
                    BiometricFragment.this.L(biometricErrorData.b(), biometricErrorData.c());
                    BiometricFragment.this.f2414b.b1(null);
                }
            }
        });
        this.f2414b.B0().j(this, new Observer<CharSequence>() { // from class: androidx.biometric.BiometricFragment.3
            @Override // androidx.lifecycle.Observer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(CharSequence charSequence) {
                if (charSequence != null) {
                    BiometricFragment.this.N(charSequence);
                    BiometricFragment.this.f2414b.b1(null);
                }
            }
        });
        this.f2414b.R0().j(this, new Observer<Boolean>() { // from class: androidx.biometric.BiometricFragment.4
            @Override // androidx.lifecycle.Observer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    BiometricFragment.this.M();
                    BiometricFragment.this.f2414b.c1(false);
                }
            }
        });
        this.f2414b.Y0().j(this, new Observer<Boolean>() { // from class: androidx.biometric.BiometricFragment.5
            @Override // androidx.lifecycle.Observer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    if (BiometricFragment.this.H()) {
                        BiometricFragment.this.Q();
                    } else {
                        BiometricFragment.this.P();
                    }
                    BiometricFragment.this.f2414b.p1(false);
                }
            }
        });
        this.f2414b.V0().j(this, new Observer<Boolean>() { // from class: androidx.biometric.BiometricFragment.6
            @Override // androidx.lifecycle.Observer
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    BiometricFragment.this.y(1);
                    BiometricFragment.this.dismiss();
                    BiometricFragment.this.f2414b.j1(false);
                }
            }
        });
    }

    private void B() {
        this.f2414b.q1(false);
        if (isAdded()) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            FingerprintDialogFragment fingerprintDialogFragment = (FingerprintDialogFragment) parentFragmentManager.n0("androidx.biometric.FingerprintDialogFragment");
            if (fingerprintDialogFragment != null) {
                if (fingerprintDialogFragment.isAdded()) {
                    fingerprintDialogFragment.dismissAllowingStateLoss();
                } else {
                    parentFragmentManager.q().r(fingerprintDialogFragment).k();
                }
            }
        }
    }

    private int C() {
        Context context = getContext();
        if (context == null || !DeviceUtils.e(context, Build.MODEL)) {
            return AdError.SERVER_ERROR_CODE;
        }
        return 0;
    }

    private void D(int i3) {
        if (i3 == -1) {
            U(new BiometricPrompt.AuthenticationResult(null, 1));
        } else {
            R(10, getString(R.string.f2515l));
        }
    }

    private boolean E() {
        FragmentActivity activity = getActivity();
        return activity != null && activity.isChangingConfigurations();
    }

    private boolean F() {
        FragmentActivity activity = getActivity();
        return (activity == null || this.f2414b.H0() == null || !DeviceUtils.f(activity, Build.MANUFACTURER, Build.MODEL)) ? false : true;
    }

    private boolean G() {
        return Build.VERSION.SDK_INT == 28 && !PackageUtils.a(getContext());
    }

    private boolean I() {
        return F() || G();
    }

    private void J() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Log.e("BiometricFragment", "Failed to check device credential. Client FragmentActivity not found.");
            return;
        }
        KeyguardManager keyguardManagerA = KeyguardUtils.a(activity);
        if (keyguardManagerA == null) {
            R(12, getString(R.string.f2514k));
            return;
        }
        CharSequence charSequenceQ0 = this.f2414b.Q0();
        CharSequence charSequenceP0 = this.f2414b.P0();
        CharSequence charSequenceI0 = this.f2414b.I0();
        if (charSequenceP0 == null) {
            charSequenceP0 = charSequenceI0;
        }
        Intent intentA = Api21Impl.a(keyguardManagerA, charSequenceQ0, charSequenceP0);
        if (intentA == null) {
            R(14, getString(R.string.f2513j));
            return;
        }
        this.f2414b.h1(true);
        if (I()) {
            B();
        }
        intentA.setFlags(134742016);
        startActivityForResult(intentA, 1);
    }

    private void S(final int i3, final CharSequence charSequence) {
        if (this.f2414b.U0()) {
            Log.v("BiometricFragment", "Error not sent to client. User is confirming their device credential.");
        } else if (!this.f2414b.S0()) {
            Log.w("BiometricFragment", "Error not sent to client. Client is not awaiting a result.");
        } else {
            this.f2414b.f1(false);
            this.f2414b.G0().execute(new Runnable() { // from class: androidx.biometric.BiometricFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    BiometricFragment.this.f2414b.F0().a(i3, charSequence);
                }
            });
        }
    }

    private void T() {
        if (this.f2414b.S0()) {
            this.f2414b.G0().execute(new Runnable() { // from class: androidx.biometric.BiometricFragment.11
                @Override // java.lang.Runnable
                public void run() {
                    BiometricFragment.this.f2414b.F0().b();
                }
            });
        } else {
            Log.w("BiometricFragment", "Failure not sent to client. Client is not awaiting a result.");
        }
    }

    private void U(BiometricPrompt.AuthenticationResult authenticationResult) {
        V(authenticationResult);
        dismiss();
    }

    private void V(final BiometricPrompt.AuthenticationResult authenticationResult) {
        if (!this.f2414b.S0()) {
            Log.w("BiometricFragment", "Success not sent to client. Client is not awaiting a result.");
        } else {
            this.f2414b.f1(false);
            this.f2414b.G0().execute(new Runnable() { // from class: androidx.biometric.BiometricFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    BiometricFragment.this.f2414b.F0().c(authenticationResult);
                }
            });
        }
    }

    private void W() {
        BiometricPrompt.Builder builderD = Api28Impl.d(requireContext().getApplicationContext());
        CharSequence charSequenceQ0 = this.f2414b.Q0();
        CharSequence charSequenceP0 = this.f2414b.P0();
        CharSequence charSequenceI0 = this.f2414b.I0();
        if (charSequenceQ0 != null) {
            Api28Impl.h(builderD, charSequenceQ0);
        }
        if (charSequenceP0 != null) {
            Api28Impl.g(builderD, charSequenceP0);
        }
        if (charSequenceI0 != null) {
            Api28Impl.e(builderD, charSequenceI0);
        }
        CharSequence charSequenceO0 = this.f2414b.O0();
        if (!TextUtils.isEmpty(charSequenceO0)) {
            Api28Impl.f(builderD, charSequenceO0, this.f2414b.G0(), this.f2414b.N0());
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Api29Impl.a(builderD, this.f2414b.T0());
        }
        int iY0 = this.f2414b.y0();
        if (i3 >= 30) {
            Api30Impl.a(builderD, iY0);
        } else if (i3 >= 29) {
            Api29Impl.b(builderD, AuthenticatorUtils.b(iY0));
        }
        w(Api28Impl.c(builderD), getContext());
    }

    private void X() {
        Context applicationContext = requireContext().getApplicationContext();
        FingerprintManagerCompat fingerprintManagerCompatC = FingerprintManagerCompat.c(applicationContext);
        int iZ = z(fingerprintManagerCompatC);
        if (iZ != 0) {
            R(iZ, ErrorUtils.a(applicationContext, iZ));
            return;
        }
        if (isAdded()) {
            this.f2414b.k1(true);
            if (!DeviceUtils.e(applicationContext, Build.MODEL)) {
                this.f2413a.postDelayed(new Runnable() { // from class: androidx.biometric.BiometricFragment.7
                    @Override // java.lang.Runnable
                    public void run() {
                        BiometricFragment.this.f2414b.k1(false);
                    }
                }, 500L);
                FingerprintDialogFragment.B().show(getParentFragmentManager(), "androidx.biometric.FingerprintDialogFragment");
            }
            this.f2414b.g1(0);
            x(fingerprintManagerCompatC, applicationContext);
        }
    }

    private void Y(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = getString(R.string.f2505b);
        }
        this.f2414b.n1(2);
        this.f2414b.l1(charSequence);
    }

    private static int z(FingerprintManagerCompat fingerprintManagerCompat) {
        if (fingerprintManagerCompat.f()) {
            return !fingerprintManagerCompat.e() ? 11 : 0;
        }
        return 12;
    }

    boolean H() {
        return Build.VERSION.SDK_INT <= 28 && AuthenticatorUtils.b(this.f2414b.y0());
    }

    void M() {
        if (I()) {
            Y(getString(R.string.f2512i));
        }
        T();
    }

    void N(CharSequence charSequence) {
        if (I()) {
            Y(charSequence);
        }
    }

    void O(BiometricPrompt.AuthenticationResult authenticationResult) {
        U(authenticationResult);
    }

    void P() {
        CharSequence charSequenceO0 = this.f2414b.O0();
        if (charSequenceO0 == null) {
            charSequenceO0 = getString(R.string.f2505b);
        }
        R(13, charSequenceO0);
        y(2);
    }

    void Q() {
        J();
    }

    void R(int i3, CharSequence charSequence) {
        S(i3, charSequence);
        dismiss();
    }

    void Z() {
        if (this.f2414b.Z0()) {
            return;
        }
        if (getContext() == null) {
            Log.w("BiometricFragment", "Not showing biometric prompt. Context is null.");
            return;
        }
        this.f2414b.q1(true);
        this.f2414b.f1(true);
        if (I()) {
            X();
        } else {
            W();
        }
    }

    void dismiss() {
        this.f2414b.q1(false);
        B();
        if (!this.f2414b.U0() && isAdded()) {
            getParentFragmentManager().q().r(this).k();
        }
        Context context = getContext();
        if (context == null || !DeviceUtils.d(context, Build.MODEL)) {
            return;
        }
        this.f2414b.i1(true);
        this.f2413a.postDelayed(new StopDelayingPromptRunnable(this.f2414b), 600L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        if (i3 == 1) {
            this.f2414b.h1(false);
            D(i4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT == 29 && AuthenticatorUtils.b(this.f2414b.y0())) {
            this.f2414b.o1(true);
            this.f2413a.postDelayed(new StopIgnoringCancelRunnable(this.f2414b), 250L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT >= 29 || this.f2414b.U0() || E()) {
            return;
        }
        y(0);
    }

    void w(android.hardware.biometrics.BiometricPrompt biometricPrompt, Context context) {
        BiometricPrompt.CryptoObject cryptoObjectC = CryptoObjectUtils.c(this.f2414b.H0());
        CancellationSignal cancellationSignalB = this.f2414b.E0().b();
        PromptExecutor promptExecutor = new PromptExecutor();
        BiometricPrompt.AuthenticationCallback authenticationCallbackA = this.f2414b.z0().a();
        try {
            if (cryptoObjectC == null) {
                Api28Impl.b(biometricPrompt, cancellationSignalB, promptExecutor, authenticationCallbackA);
            } else {
                Api28Impl.a(biometricPrompt, cryptoObjectC, cancellationSignalB, promptExecutor, authenticationCallbackA);
            }
        } catch (NullPointerException e3) {
            Log.e("BiometricFragment", "Got NPE while authenticating with biometric prompt.", e3);
            R(1, context != null ? context.getString(R.string.f2505b) : "");
        }
    }

    void x(FingerprintManagerCompat fingerprintManagerCompat, Context context) {
        try {
            fingerprintManagerCompat.b(CryptoObjectUtils.d(this.f2414b.H0()), 0, this.f2414b.E0().c(), this.f2414b.z0().b(), null);
        } catch (NullPointerException e3) {
            Log.e("BiometricFragment", "Got NPE while authenticating with fingerprint.", e3);
            R(1, ErrorUtils.a(context, 1));
        }
    }

    void y(int i3) {
        if (i3 == 3 || !this.f2414b.X0()) {
            if (I()) {
                this.f2414b.g1(i3);
                if (i3 == 1) {
                    S(10, ErrorUtils.a(getContext(), 10));
                }
            }
            this.f2414b.E0().a();
        }
    }

    void L(final int i3, final CharSequence charSequence) {
        if (!ErrorUtils.b(i3)) {
            i3 = 8;
        }
        Context context = getContext();
        if (Build.VERSION.SDK_INT < 29 && ErrorUtils.c(i3) && context != null && KeyguardUtils.b(context) && AuthenticatorUtils.b(this.f2414b.y0())) {
            J();
            return;
        }
        if (I()) {
            if (charSequence == null) {
                charSequence = ErrorUtils.a(getContext(), i3);
            }
            if (i3 == 5) {
                int iD0 = this.f2414b.D0();
                if (iD0 == 0 || iD0 == 3) {
                    S(i3, charSequence);
                }
                dismiss();
                return;
            }
            if (this.f2414b.W0()) {
                R(i3, charSequence);
            } else {
                Y(charSequence);
                this.f2413a.postDelayed(new Runnable() { // from class: androidx.biometric.BiometricFragment.8
                    @Override // java.lang.Runnable
                    public void run() {
                        BiometricFragment.this.R(i3, charSequence);
                    }
                }, C());
            }
            this.f2414b.k1(true);
            return;
        }
        if (charSequence == null) {
            charSequence = getString(R.string.f2505b) + KqqtdetwHMIO.neBVHBJRTqTxb + i3;
        }
        R(i3, charSequence);
    }
}
