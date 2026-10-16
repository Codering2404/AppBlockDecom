package androidx.credentials.webauthn;

import java.util.Arrays;
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
public final class PublicKeyCredentialUserEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f35425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f35426c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicKeyCredentialUserEntity)) {
            return false;
        }
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) obj;
        return Intrinsics.areEqual(this.f35424a, publicKeyCredentialUserEntity.f35424a) && Intrinsics.areEqual(this.f35425b, publicKeyCredentialUserEntity.f35425b) && Intrinsics.areEqual(this.f35426c, publicKeyCredentialUserEntity.f35426c);
    }

    public int hashCode() {
        return (((this.f35424a.hashCode() * 31) + Arrays.hashCode(this.f35425b)) * 31) + this.f35426c.hashCode();
    }

    public String toString() {
        return "PublicKeyCredentialUserEntity(name=" + this.f35424a + ", id=" + Arrays.toString(this.f35425b) + ", displayName=" + this.f35426c + ')';
    }
}
