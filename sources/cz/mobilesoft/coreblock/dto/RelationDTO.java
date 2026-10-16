package cz.mobilesoft.coreblock.dto;

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
public final class RelationDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f96938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f96939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f96940c;

    public RelationDTO(String packageName, String hostname, boolean z2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        this.f96938a = packageName;
        this.f96939b = hostname;
        this.f96940c = z2;
    }

    public final String a() {
        return this.f96939b;
    }

    public final String b() {
        return this.f96938a;
    }

    public final boolean c() {
        return this.f96940c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelationDTO)) {
            return false;
        }
        RelationDTO relationDTO = (RelationDTO) obj;
        return Intrinsics.areEqual(this.f96938a, relationDTO.f96938a) && Intrinsics.areEqual(this.f96939b, relationDTO.f96939b) && this.f96940c == relationDTO.f96940c;
    }

    public int hashCode() {
        return (((this.f96938a.hashCode() * 31) + this.f96939b.hashCode()) * 31) + Boolean.hashCode(this.f96940c);
    }

    public String toString() {
        return "RelationDTO(packageName=" + this.f96938a + ", hostname=" + this.f96939b + ", isPreset=" + this.f96940c + ")";
    }
}
