package androidx.biometric;

import android.util.Log;
import androidx.core.os.CancellationSignal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class CancellationSignalProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Injector f2477a = new Injector() { // from class: androidx.biometric.CancellationSignalProvider.1
        @Override // androidx.biometric.CancellationSignalProvider.Injector
        public CancellationSignal a() {
            return new CancellationSignal();
        }

        @Override // androidx.biometric.CancellationSignalProvider.Injector
        public android.os.CancellationSignal b() {
            return Api16Impl.b();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.os.CancellationSignal f2478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CancellationSignal f2479c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api16Impl {
        static void a(android.os.CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        static android.os.CancellationSignal b() {
            return new android.os.CancellationSignal();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Injector {
        CancellationSignal a();

        android.os.CancellationSignal b();
    }

    CancellationSignalProvider() {
    }

    void a() {
        android.os.CancellationSignal cancellationSignal = this.f2478b;
        if (cancellationSignal != null) {
            try {
                Api16Impl.a(cancellationSignal);
            } catch (NullPointerException e3) {
                Log.e("CancelSignalProvider", "Got NPE while canceling biometric authentication.", e3);
            }
            this.f2478b = null;
        }
        CancellationSignal cancellationSignal2 = this.f2479c;
        if (cancellationSignal2 != null) {
            try {
                cancellationSignal2.a();
            } catch (NullPointerException e4) {
                Log.e("CancelSignalProvider", "Got NPE while canceling fingerprint authentication.", e4);
            }
            this.f2479c = null;
        }
    }

    android.os.CancellationSignal b() {
        if (this.f2478b == null) {
            this.f2478b = this.f2477a.b();
        }
        return this.f2478b;
    }

    CancellationSignal c() {
        if (this.f2479c == null) {
            this.f2479c = this.f2477a.a();
        }
        return this.f2479c;
    }
}
