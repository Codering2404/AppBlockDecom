package cz.mobilesoft.coreblock.util.updates;

import androidx.glance.session.ecY.lisODU;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class InAppUpdateDialogDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f129851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f129852b;

    public InAppUpdateDialogDTO(int i3, int i4) {
        this.f129851a = i3;
        this.f129852b = i4;
    }

    public final int a() {
        return this.f129851a;
    }

    public final int b() {
        return this.f129852b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InAppUpdateDialogDTO)) {
            return false;
        }
        InAppUpdateDialogDTO inAppUpdateDialogDTO = (InAppUpdateDialogDTO) obj;
        return this.f129851a == inAppUpdateDialogDTO.f129851a && this.f129852b == inAppUpdateDialogDTO.f129852b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f129851a) * 31) + Integer.hashCode(this.f129852b);
    }

    public String toString() {
        return "InAppUpdateDialogDTO(dialogMessage=" + this.f129851a + lisODU.nrIiuIGPr + this.f129852b + ")";
    }
}
