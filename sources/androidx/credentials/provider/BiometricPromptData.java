package androidx.credentials.provider;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.credentials.provider.utils.CryptoObjectUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class BiometricPromptData {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f35279d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set f35280e = SetsKt.setOf((Object[]) new Integer[]{15, 255, 32768, 32783, 33023});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BiometricPrompt.CryptoObject f35281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f35283c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api35Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api35Impl f35284a = new Api35Impl();

        private Api35Impl() {
        }

        public static final BiometricPromptData a(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return new BiometricPromptData(null, bundle.getInt("androidx.credentials.provider.BUNDLE_HINT_ALLOWED_AUTHENTICATORS"), true);
        }

        public static final Bundle b(BiometricPromptData biometricPromptData) {
            Intrinsics.checkNotNullParameter(biometricPromptData, "biometricPromptData");
            Bundle bundle = new Bundle();
            bundle.putInt("androidx.credentials.provider.BUNDLE_HINT_ALLOWED_AUTHENTICATORS", biometricPromptData.a());
            if (biometricPromptData.b() != null) {
                bundle.putLong("androidx.credentials.provider.BUNDLE_HINT_CRYPTO_OP_ID", CryptoObjectUtils.f35401a.a(biometricPromptData.b()));
            }
            return bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ApiMinImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ApiMinImpl f35285a = new ApiMinImpl();

        private ApiMinImpl() {
        }

        public static final BiometricPromptData a(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return new BiometricPromptData(null, bundle.getInt("androidx.credentials.provider.BUNDLE_HINT_ALLOWED_AUTHENTICATORS"), true, 1, null);
        }

        public static final Bundle b(BiometricPromptData biometricPromptData) {
            Intrinsics.checkNotNullParameter(biometricPromptData, "biometricPromptData");
            Bundle bundle = new Bundle();
            bundle.putInt("androidx.credentials.provider.BUNDLE_HINT_ALLOWED_AUTHENTICATORS", biometricPromptData.a());
            return bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(Integer num) {
            return num != null && (num.intValue() & 240) == 0;
        }

        public final BiometricPromptData b(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            try {
                if (bundle.containsKey("androidx.credentials.provider.BUNDLE_HINT_ALLOWED_AUTHENTICATORS")) {
                    return Build.VERSION.SDK_INT >= 35 ? Api35Impl.a(bundle) : ApiMinImpl.a(bundle);
                }
                throw new IllegalArgumentException("Bundle lacks allowed authenticator key.");
            } catch (Exception e3) {
                Log.i("BiometricPromptData", "fromSlice failed with: " + e3.getMessage());
                return null;
            }
        }

        public final Bundle d(BiometricPromptData biometricPromptData) {
            Intrinsics.checkNotNullParameter(biometricPromptData, "biometricPromptData");
            return Build.VERSION.SDK_INT >= 35 ? Api35Impl.b(biometricPromptData) : ApiMinImpl.b(biometricPromptData);
        }

        private Companion() {
        }
    }

    public BiometricPromptData(BiometricPrompt.CryptoObject cryptoObject, int i3, boolean z2) {
        this.f35281a = cryptoObject;
        this.f35282b = i3;
        this.f35283c = z2;
        if (!z2 && !f35280e.contains(Integer.valueOf(i3))) {
            throw new IllegalArgumentException("The allowed authenticator must be specified according to the BiometricPrompt spec.");
        }
        if (cryptoObject != null && !f35279d.c(Integer.valueOf(i3))) {
            throw new IllegalArgumentException("If the cryptoObject is non-null, the allowedAuthenticator value must be Authenticators.BIOMETRIC_STRONG.");
        }
    }

    public final int a() {
        return this.f35282b;
    }

    public final BiometricPrompt.CryptoObject b() {
        return this.f35281a;
    }

    public /* synthetic */ BiometricPromptData(BiometricPrompt.CryptoObject cryptoObject, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : cryptoObject, (i4 & 2) != 0 ? 255 : i3, (i4 & 4) != 0 ? false : z2);
    }
}
