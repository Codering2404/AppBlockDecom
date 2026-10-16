package androidx.credentials.provider;

import java.util.Objects;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BiometricPromptResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AuthenticationResult f35286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AuthenticationError f35287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f35288c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BiometricPromptResult) {
            BiometricPromptResult biometricPromptResult = (BiometricPromptResult) obj;
            if (this.f35288c == biometricPromptResult.f35288c && Intrinsics.areEqual(this.f35286a, biometricPromptResult.f35286a) && Intrinsics.areEqual(this.f35287b, biometricPromptResult.f35287b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f35288c), this.f35286a, this.f35287b);
    }
}
