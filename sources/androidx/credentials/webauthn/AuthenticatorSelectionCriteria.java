package androidx.credentials.webauthn;

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
public final class AuthenticatorSelectionCriteria {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f35410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f35411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f35412d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticatorSelectionCriteria)) {
            return false;
        }
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) obj;
        return Intrinsics.areEqual(this.f35409a, authenticatorSelectionCriteria.f35409a) && Intrinsics.areEqual(this.f35410b, authenticatorSelectionCriteria.f35410b) && this.f35411c == authenticatorSelectionCriteria.f35411c && Intrinsics.areEqual(this.f35412d, authenticatorSelectionCriteria.f35412d);
    }

    public int hashCode() {
        return (((((this.f35409a.hashCode() * 31) + this.f35410b.hashCode()) * 31) + Boolean.hashCode(this.f35411c)) * 31) + this.f35412d.hashCode();
    }

    public String toString() {
        return "AuthenticatorSelectionCriteria(authenticatorAttachment=" + this.f35409a + ", residentKey=" + this.f35410b + ", requireResidentKey=" + this.f35411c + ", userVerification=" + this.f35412d + ')';
    }
}
