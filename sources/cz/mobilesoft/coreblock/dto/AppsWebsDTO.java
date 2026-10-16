package cz.mobilesoft.coreblock.dto;

import java.io.Serializable;
import java.util.ArrayList;
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
public final class AppsWebsDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f96913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList f96914b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppsWebsDTO)) {
            return false;
        }
        AppsWebsDTO appsWebsDTO = (AppsWebsDTO) obj;
        return Intrinsics.areEqual(this.f96913a, appsWebsDTO.f96913a) && Intrinsics.areEqual(this.f96914b, appsWebsDTO.f96914b);
    }

    public int hashCode() {
        ArrayList arrayList = this.f96913a;
        int iHashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        ArrayList arrayList2 = this.f96914b;
        return iHashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public String toString() {
        return "AppsWebsDTO(applications=" + this.f96913a + ", websites=" + this.f96914b + ")";
    }
}
