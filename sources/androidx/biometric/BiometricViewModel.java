package androidx.biometric;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.biometric.AuthenticationCallbackProvider;
import androidx.biometric.BiometricPrompt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class BiometricViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Executor f2449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BiometricPrompt.AuthenticationCallback f2450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BiometricPrompt.PromptInfo f2451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BiometricPrompt.CryptoObject f2452d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AuthenticationCallbackProvider f2453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CancellationSignalProvider f2454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DialogInterface.OnClickListener f2455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f2456i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private MutableLiveData f2463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MutableLiveData f2464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MutableLiveData f2465r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MutableLiveData f2466s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private MutableLiveData f2467t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MutableLiveData f2469v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MutableLiveData f2471x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private MutableLiveData f2472y;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2457j = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f2468u = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f2470w = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CallbackListener extends AuthenticationCallbackProvider.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f2474a;

        CallbackListener(BiometricViewModel biometricViewModel) {
            this.f2474a = new WeakReference(biometricViewModel);
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        void a(int i3, CharSequence charSequence) {
            if (this.f2474a.get() == null || ((BiometricViewModel) this.f2474a.get()).U0() || !((BiometricViewModel) this.f2474a.get()).S0()) {
                return;
            }
            ((BiometricViewModel) this.f2474a.get()).b1(new BiometricErrorData(i3, charSequence));
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        void b() {
            if (this.f2474a.get() == null || !((BiometricViewModel) this.f2474a.get()).S0()) {
                return;
            }
            ((BiometricViewModel) this.f2474a.get()).c1(true);
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        void c(CharSequence charSequence) {
            if (this.f2474a.get() != null) {
                ((BiometricViewModel) this.f2474a.get()).d1(charSequence);
            }
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        void d(BiometricPrompt.AuthenticationResult authenticationResult) {
            if (this.f2474a.get() == null || !((BiometricViewModel) this.f2474a.get()).S0()) {
                return;
            }
            if (authenticationResult.a() == -1) {
                authenticationResult = new BiometricPrompt.AuthenticationResult(authenticationResult.b(), ((BiometricViewModel) this.f2474a.get()).M0());
            }
            ((BiometricViewModel) this.f2474a.get()).e1(authenticationResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DefaultExecutor implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f2475a = new Handler(Looper.getMainLooper());

        DefaultExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f2475a.post(runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NegativeButtonListener implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f2476a;

        NegativeButtonListener(BiometricViewModel biometricViewModel) {
            this.f2476a = new WeakReference(biometricViewModel);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f2476a.get() != null) {
                ((BiometricViewModel) this.f2476a.get()).p1(true);
            }
        }
    }

    private static void r1(MutableLiveData mutableLiveData, Object obj) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mutableLiveData.p(obj);
        } else {
            mutableLiveData.n(obj);
        }
    }

    MutableLiveData A0() {
        if (this.f2464q == null) {
            this.f2464q = new MutableLiveData();
        }
        return this.f2464q;
    }

    LiveData B0() {
        if (this.f2465r == null) {
            this.f2465r = new MutableLiveData();
        }
        return this.f2465r;
    }

    LiveData C0() {
        if (this.f2463p == null) {
            this.f2463p = new MutableLiveData();
        }
        return this.f2463p;
    }

    int D0() {
        return this.f2457j;
    }

    CancellationSignalProvider E0() {
        if (this.f2454g == null) {
            this.f2454g = new CancellationSignalProvider();
        }
        return this.f2454g;
    }

    BiometricPrompt.AuthenticationCallback F0() {
        if (this.f2450b == null) {
            this.f2450b = new BiometricPrompt.AuthenticationCallback() { // from class: androidx.biometric.BiometricViewModel.1
            };
        }
        return this.f2450b;
    }

    Executor G0() {
        Executor executor = this.f2449a;
        return executor != null ? executor : new DefaultExecutor();
    }

    BiometricPrompt.CryptoObject H0() {
        return this.f2452d;
    }

    CharSequence I0() {
        BiometricPrompt.PromptInfo promptInfo = this.f2451c;
        if (promptInfo != null) {
            return promptInfo.b();
        }
        return null;
    }

    LiveData J0() {
        if (this.f2472y == null) {
            this.f2472y = new MutableLiveData();
        }
        return this.f2472y;
    }

    int K0() {
        return this.f2470w;
    }

    LiveData L0() {
        if (this.f2471x == null) {
            this.f2471x = new MutableLiveData();
        }
        return this.f2471x;
    }

    int M0() {
        int iY0 = y0();
        return (!AuthenticatorUtils.c(iY0) || AuthenticatorUtils.b(iY0)) ? -1 : 2;
    }

    DialogInterface.OnClickListener N0() {
        if (this.f2455h == null) {
            this.f2455h = new NegativeButtonListener(this);
        }
        return this.f2455h;
    }

    CharSequence O0() {
        CharSequence charSequence = this.f2456i;
        if (charSequence != null) {
            return charSequence;
        }
        BiometricPrompt.PromptInfo promptInfo = this.f2451c;
        if (promptInfo != null) {
            return promptInfo.c();
        }
        return null;
    }

    CharSequence P0() {
        BiometricPrompt.PromptInfo promptInfo = this.f2451c;
        if (promptInfo != null) {
            return promptInfo.d();
        }
        return null;
    }

    CharSequence Q0() {
        BiometricPrompt.PromptInfo promptInfo = this.f2451c;
        if (promptInfo != null) {
            return promptInfo.e();
        }
        return null;
    }

    LiveData R0() {
        if (this.f2466s == null) {
            this.f2466s = new MutableLiveData();
        }
        return this.f2466s;
    }

    boolean S0() {
        return this.f2459l;
    }

    boolean T0() {
        BiometricPrompt.PromptInfo promptInfo = this.f2451c;
        return promptInfo == null || promptInfo.f();
    }

    boolean U0() {
        return this.f2460m;
    }

    LiveData V0() {
        if (this.f2469v == null) {
            this.f2469v = new MutableLiveData();
        }
        return this.f2469v;
    }

    boolean W0() {
        return this.f2468u;
    }

    boolean X0() {
        return this.f2462o;
    }

    LiveData Y0() {
        if (this.f2467t == null) {
            this.f2467t = new MutableLiveData();
        }
        return this.f2467t;
    }

    boolean Z0() {
        return this.f2458k;
    }

    void a1() {
        this.f2450b = null;
    }

    void b1(BiometricErrorData biometricErrorData) {
        if (this.f2464q == null) {
            this.f2464q = new MutableLiveData();
        }
        r1(this.f2464q, biometricErrorData);
    }

    void c1(boolean z2) {
        if (this.f2466s == null) {
            this.f2466s = new MutableLiveData();
        }
        r1(this.f2466s, Boolean.valueOf(z2));
    }

    void d1(CharSequence charSequence) {
        if (this.f2465r == null) {
            this.f2465r = new MutableLiveData();
        }
        r1(this.f2465r, charSequence);
    }

    void e1(BiometricPrompt.AuthenticationResult authenticationResult) {
        if (this.f2463p == null) {
            this.f2463p = new MutableLiveData();
        }
        r1(this.f2463p, authenticationResult);
    }

    void f1(boolean z2) {
        this.f2459l = z2;
    }

    void g1(int i3) {
        this.f2457j = i3;
    }

    void h1(boolean z2) {
        this.f2460m = z2;
    }

    void i1(boolean z2) {
        this.f2461n = z2;
    }

    void j1(boolean z2) {
        if (this.f2469v == null) {
            this.f2469v = new MutableLiveData();
        }
        r1(this.f2469v, Boolean.valueOf(z2));
    }

    void k1(boolean z2) {
        this.f2468u = z2;
    }

    void l1(CharSequence charSequence) {
        if (this.f2472y == null) {
            this.f2472y = new MutableLiveData();
        }
        r1(this.f2472y, charSequence);
    }

    void m1(int i3) {
        this.f2470w = i3;
    }

    void n1(int i3) {
        if (this.f2471x == null) {
            this.f2471x = new MutableLiveData();
        }
        r1(this.f2471x, Integer.valueOf(i3));
    }

    void o1(boolean z2) {
        this.f2462o = z2;
    }

    void p1(boolean z2) {
        if (this.f2467t == null) {
            this.f2467t = new MutableLiveData();
        }
        r1(this.f2467t, Boolean.valueOf(z2));
    }

    void q1(boolean z2) {
        this.f2458k = z2;
    }

    int y0() {
        BiometricPrompt.PromptInfo promptInfo = this.f2451c;
        if (promptInfo != null) {
            return AuthenticatorUtils.a(promptInfo, this.f2452d);
        }
        return 0;
    }

    AuthenticationCallbackProvider z0() {
        if (this.f2453f == null) {
            this.f2453f = new AuthenticationCallbackProvider(new CallbackListener(this));
        }
        return this.f2453f;
    }
}
