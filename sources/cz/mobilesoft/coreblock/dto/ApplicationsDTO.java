package cz.mobilesoft.coreblock.dto;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ApplicationsDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f96911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ANIADTO f96912b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationsDTO)) {
            return false;
        }
        ApplicationsDTO applicationsDTO = (ApplicationsDTO) obj;
        return Intrinsics.areEqual(this.f96911a, applicationsDTO.f96911a) && Intrinsics.areEqual(this.f96912b, applicationsDTO.f96912b);
    }

    public int hashCode() {
        int iHashCode = this.f96911a.hashCode() * 31;
        ANIADTO aniadto = this.f96912b;
        return iHashCode + (aniadto == null ? 0 : aniadto.hashCode());
    }

    public String toString() {
        return "ApplicationsDTO(applications=" + this.f96911a + ", ania=" + this.f96912b + ")";
    }
}
