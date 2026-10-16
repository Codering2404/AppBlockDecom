package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AuthenticationCallbackProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BiometricPrompt.AuthenticationCallback f2406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FingerprintManagerCompat.AuthenticationCallback f2407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Listener f2408c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api28Impl {
        static BiometricPrompt.AuthenticationCallback a(final Listener listener) {
            return new BiometricPrompt.AuthenticationCallback() { // from class: androidx.biometric.AuthenticationCallbackProvider.Api28Impl.1
                @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
                public void onAuthenticationError(int i3, CharSequence charSequence) {
                    listener.a(i3, charSequence);
                }

                @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
                public void onAuthenticationFailed() {
                    listener.b();
                }

                @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
                public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                    BiometricPrompt.CryptoObject cryptoObjectA = authenticationResult != null ? CryptoObjectUtils.a(authenticationResult.getCryptoObject()) : null;
                    int i3 = Build.VERSION.SDK_INT;
                    int iA = -1;
                    if (i3 >= 30) {
                        if (authenticationResult != null) {
                            iA = Api30Impl.a(authenticationResult);
                        }
                    } else if (i3 != 29) {
                        iA = 2;
                    }
                    listener.d(new BiometricPrompt.AuthenticationResult(cryptoObjectA, iA));
                }

                @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
                public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api30Impl {
        static int a(BiometricPrompt.AuthenticationResult authenticationResult) {
            return authenticationResult.getAuthenticationType();
        }
    }

    AuthenticationCallbackProvider(Listener listener) {
        this.f2408c = listener;
    }

    BiometricPrompt.AuthenticationCallback a() {
        if (this.f2406a == null) {
            this.f2406a = Api28Impl.a(this.f2408c);
        }
        return this.f2406a;
    }

    FingerprintManagerCompat.AuthenticationCallback b() {
        if (this.f2407b == null) {
            this.f2407b = new FingerprintManagerCompat.AuthenticationCallback() { // from class: androidx.biometric.AuthenticationCallbackProvider.1
                @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                public void a(int i3, CharSequence charSequence) {
                    AuthenticationCallbackProvider.this.f2408c.a(i3, charSequence);
                }

                @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                public void b() {
                    AuthenticationCallbackProvider.this.f2408c.b();
                }

                @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                public void c(int i3, CharSequence charSequence) {
                    AuthenticationCallbackProvider.this.f2408c.c(charSequence);
                }

                @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                public void d(FingerprintManagerCompat.AuthenticationResult authenticationResult) {
                    AuthenticationCallbackProvider.this.f2408c.d(new BiometricPrompt.AuthenticationResult(authenticationResult != null ? CryptoObjectUtils.b(authenticationResult.a()) : null, 2));
                }
            };
        }
        return this.f2407b;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Listener {
        Listener() {
        }

        void b() {
        }

        void c(CharSequence charSequence) {
        }

        void d(BiometricPrompt.AuthenticationResult authenticationResult) {
        }

        void a(int i3, CharSequence charSequence) {
        }
    }
}
