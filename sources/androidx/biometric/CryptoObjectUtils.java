package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.security.identity.IdentityCredential;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class CryptoObjectUtils {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api23Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api28Impl {
        static BiometricPrompt.CryptoObject a(Signature signature) {
            return new BiometricPrompt.CryptoObject(signature);
        }

        static BiometricPrompt.CryptoObject b(Cipher cipher) {
            return new BiometricPrompt.CryptoObject(cipher);
        }

        static BiometricPrompt.CryptoObject c(Mac mac) {
            return new BiometricPrompt.CryptoObject(mac);
        }

        static Cipher d(BiometricPrompt.CryptoObject cryptoObject) {
            return cryptoObject.getCipher();
        }

        static Mac e(BiometricPrompt.CryptoObject cryptoObject) {
            return cryptoObject.getMac();
        }

        static Signature f(BiometricPrompt.CryptoObject cryptoObject) {
            return cryptoObject.getSignature();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api30Impl {
        static BiometricPrompt.CryptoObject a(IdentityCredential identityCredential) {
            return new BiometricPrompt.CryptoObject(identityCredential);
        }

        static IdentityCredential b(BiometricPrompt.CryptoObject cryptoObject) {
            return cryptoObject.getIdentityCredential();
        }
    }

    static BiometricPrompt.CryptoObject a(BiometricPrompt.CryptoObject cryptoObject) {
        IdentityCredential identityCredentialB;
        if (cryptoObject == null) {
            return null;
        }
        Cipher cipherD = Api28Impl.d(cryptoObject);
        if (cipherD != null) {
            return new BiometricPrompt.CryptoObject(cipherD);
        }
        Signature signatureF = Api28Impl.f(cryptoObject);
        if (signatureF != null) {
            return new BiometricPrompt.CryptoObject(signatureF);
        }
        Mac macE = Api28Impl.e(cryptoObject);
        if (macE != null) {
            return new BiometricPrompt.CryptoObject(macE);
        }
        if (Build.VERSION.SDK_INT < 30 || (identityCredentialB = Api30Impl.b(cryptoObject)) == null) {
            return null;
        }
        return new BiometricPrompt.CryptoObject(identityCredentialB);
    }

    static BiometricPrompt.CryptoObject b(FingerprintManagerCompat.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        Cipher cipherA = cryptoObject.a();
        if (cipherA != null) {
            return new BiometricPrompt.CryptoObject(cipherA);
        }
        Signature signatureC = cryptoObject.c();
        if (signatureC != null) {
            return new BiometricPrompt.CryptoObject(signatureC);
        }
        Mac macB = cryptoObject.b();
        if (macB != null) {
            return new BiometricPrompt.CryptoObject(macB);
        }
        return null;
    }

    static BiometricPrompt.CryptoObject c(BiometricPrompt.CryptoObject cryptoObject) {
        IdentityCredential identityCredentialB;
        if (cryptoObject == null) {
            return null;
        }
        Cipher cipherA = cryptoObject.a();
        if (cipherA != null) {
            return Api28Impl.b(cipherA);
        }
        Signature signatureD = cryptoObject.d();
        if (signatureD != null) {
            return Api28Impl.a(signatureD);
        }
        Mac macC = cryptoObject.c();
        if (macC != null) {
            return Api28Impl.c(macC);
        }
        if (Build.VERSION.SDK_INT < 30 || (identityCredentialB = cryptoObject.b()) == null) {
            return null;
        }
        return Api30Impl.a(identityCredentialB);
    }

    static FingerprintManagerCompat.CryptoObject d(BiometricPrompt.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        Cipher cipherA = cryptoObject.a();
        if (cipherA != null) {
            return new FingerprintManagerCompat.CryptoObject(cipherA);
        }
        Signature signatureD = cryptoObject.d();
        if (signatureD != null) {
            return new FingerprintManagerCompat.CryptoObject(signatureD);
        }
        Mac macC = cryptoObject.c();
        if (macC != null) {
            return new FingerprintManagerCompat.CryptoObject(macC);
        }
        if (Build.VERSION.SDK_INT >= 30 && cryptoObject.b() != null) {
            Log.e("CryptoObjectUtils", "Identity credential is not supported by FingerprintManager.");
        }
        return null;
    }
}
