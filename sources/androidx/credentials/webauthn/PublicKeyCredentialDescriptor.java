package androidx.credentials.webauthn;

import java.util.Arrays;
import java.util.List;
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
public final class PublicKeyCredentialDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f35418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f35419c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicKeyCredentialDescriptor)) {
            return false;
        }
        PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) obj;
        return Intrinsics.areEqual(this.f35417a, publicKeyCredentialDescriptor.f35417a) && Intrinsics.areEqual(this.f35418b, publicKeyCredentialDescriptor.f35418b) && Intrinsics.areEqual(this.f35419c, publicKeyCredentialDescriptor.f35419c);
    }

    public int hashCode() {
        return (((this.f35417a.hashCode() * 31) + Arrays.hashCode(this.f35418b)) * 31) + this.f35419c.hashCode();
    }

    public String toString() {
        return "PublicKeyCredentialDescriptor(type=" + this.f35417a + ", id=" + Arrays.toString(this.f35418b) + ", transports=" + this.f35419c + ')';
    }
}
