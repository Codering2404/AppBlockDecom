package androidx.credentials.provider.utils;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.security.identity.IdentityCredential;
import androidx.biometric.BiometricPrompt;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CryptoObjectUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CryptoObjectUtils f35401a = new CryptoObjectUtils();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api28Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api28Impl f35402a = new Api28Impl();

        private Api28Impl() {
        }

        public final BiometricPrompt.CryptoObject a(Signature signature) {
            Intrinsics.checkNotNullParameter(signature, "signature");
            return new BiometricPrompt.CryptoObject(signature);
        }

        public final BiometricPrompt.CryptoObject b(Cipher cipher) {
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            return new BiometricPrompt.CryptoObject(cipher);
        }

        public final BiometricPrompt.CryptoObject c(Mac mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            return new BiometricPrompt.CryptoObject(mac);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api30Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api30Impl f35403a = new Api30Impl();

        private Api30Impl() {
        }

        public final BiometricPrompt.CryptoObject a(IdentityCredential identityCredential) {
            Intrinsics.checkNotNullParameter(identityCredential, "identityCredential");
            return new BiometricPrompt.CryptoObject(identityCredential);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api35Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api35Impl f35404a = new Api35Impl();

        private Api35Impl() {
        }

        public final long a(BiometricPrompt.CryptoObject crypto) {
            Intrinsics.checkNotNullParameter(crypto, "crypto");
            return crypto.getOperationHandle();
        }
    }

    private CryptoObjectUtils() {
    }

    public final long a(BiometricPrompt.CryptoObject cryptoObject) {
        BiometricPrompt.CryptoObject cryptoObjectB = b(cryptoObject);
        if (cryptoObjectB != null) {
            return Api35Impl.f35404a.a(cryptoObjectB);
        }
        return 0L;
    }

    public final BiometricPrompt.CryptoObject b(BiometricPrompt.CryptoObject cryptoObject) {
        IdentityCredential identityCredentialB;
        if (cryptoObject == null) {
            return null;
        }
        Cipher cipherA = cryptoObject.a();
        if (cipherA != null) {
            return Api28Impl.f35402a.b(cipherA);
        }
        Signature signatureD = cryptoObject.d();
        if (signatureD != null) {
            return Api28Impl.f35402a.a(signatureD);
        }
        Mac macC = cryptoObject.c();
        if (macC != null) {
            return Api28Impl.f35402a.c(macC);
        }
        if (Build.VERSION.SDK_INT < 30 || (identityCredentialB = cryptoObject.b()) == null) {
            return null;
        }
        return Api30Impl.f35403a.a(identityCredentialB);
    }
}
