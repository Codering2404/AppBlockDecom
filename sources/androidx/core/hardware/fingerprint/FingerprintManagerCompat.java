package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class FingerprintManagerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f34051a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
        static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i3, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i3, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        public static FingerprintManager c(Context context) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return (FingerprintManager) context.getSystemService(FingerprintManager.class);
            }
            return null;
        }

        static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        public static CryptoObject f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        public static FingerprintManager.CryptoObject g(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.a() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.a());
            }
            if (cryptoObject.c() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.c());
            }
            if (cryptoObject.b() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.b());
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AuthenticationResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CryptoObject f34053a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.f34053a = cryptoObject;
        }

        public CryptoObject a() {
            return this.f34053a;
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.f34051a = context;
    }

    public static FingerprintManagerCompat c(Context context) {
        return new FingerprintManagerCompat(context);
    }

    private static FingerprintManager d(Context context) {
        return Api23Impl.c(context);
    }

    static CryptoObject g(FingerprintManager.CryptoObject cryptoObject) {
        return Api23Impl.f(cryptoObject);
    }

    private static FingerprintManager.AuthenticationCallback h(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() { // from class: androidx.core.hardware.fingerprint.FingerprintManagerCompat.1
            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int i3, CharSequence charSequence) {
                authenticationCallback.a(i3, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                authenticationCallback.b();
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                authenticationCallback.c(i3, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                authenticationCallback.d(new AuthenticationResult(FingerprintManagerCompat.g(Api23Impl.b(authenticationResult))));
            }
        };
    }

    private static FingerprintManager.CryptoObject i(CryptoObject cryptoObject) {
        return Api23Impl.g(cryptoObject);
    }

    public void a(CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        FingerprintManager fingerprintManagerD = d(this.f34051a);
        if (fingerprintManagerD != null) {
            Api23Impl.a(fingerprintManagerD, i(cryptoObject), cancellationSignal, i3, h(authenticationCallback), handler);
        }
    }

    public void b(CryptoObject cryptoObject, int i3, androidx.core.os.CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        a(cryptoObject, i3, cancellationSignal != null ? (CancellationSignal) cancellationSignal.b() : null, authenticationCallback, handler);
    }

    public boolean e() {
        FingerprintManager fingerprintManagerD = d(this.f34051a);
        return fingerprintManagerD != null && Api23Impl.d(fingerprintManagerD);
    }

    public boolean f() {
        FingerprintManager fingerprintManagerD = d(this.f34051a);
        return fingerprintManagerD != null && Api23Impl.e(fingerprintManagerD);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CryptoObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Signature f34054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Cipher f34055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Mac f34056c;

        public CryptoObject(Signature signature) {
            this.f34054a = signature;
            this.f34055b = null;
            this.f34056c = null;
        }

        public Cipher a() {
            return this.f34055b;
        }

        public Mac b() {
            return this.f34056c;
        }

        public Signature c() {
            return this.f34054a;
        }

        public CryptoObject(Cipher cipher) {
            this.f34055b = cipher;
            this.f34054a = null;
            this.f34056c = null;
        }

        public CryptoObject(Mac mac) {
            this.f34056c = mac;
            this.f34055b = null;
            this.f34054a = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class AuthenticationCallback {
        public void b() {
        }

        public void d(AuthenticationResult authenticationResult) {
        }

        public void a(int i3, CharSequence charSequence) {
        }

        public void c(int i3, CharSequence charSequence) {
        }
    }
}
