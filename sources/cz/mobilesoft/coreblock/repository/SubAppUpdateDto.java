package cz.mobilesoft.coreblock.repository;

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
public final class SubAppUpdateDto {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f98383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f98384b;

    public final String a() {
        return this.f98383a;
    }

    public final List b() {
        return this.f98384b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubAppUpdateDto)) {
            return false;
        }
        SubAppUpdateDto subAppUpdateDto = (SubAppUpdateDto) obj;
        return Intrinsics.areEqual(this.f98383a, subAppUpdateDto.f98383a) && Intrinsics.areEqual(this.f98384b, subAppUpdateDto.f98384b);
    }

    public int hashCode() {
        return (this.f98383a.hashCode() * 31) + this.f98384b.hashCode();
    }

    public String toString() {
        return "SubAppUpdateDto(id=" + this.f98383a + ", viewIds=" + this.f98384b + ")";
    }
}
