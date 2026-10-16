package cz.mobilesoft.coreblock.scene.more.backup.dto;

import com.google.gson.annotations.SerializedName;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class IgnoreItemDTO {

    @SerializedName("name")
    private final String name;

    @SerializedName("type")
    private final int type;

    public IgnoreItemDTO(String name, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.type = i3;
    }

    public final String a() {
        return this.name;
    }

    public final int b() {
        return this.type;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IgnoreItemDTO)) {
            return false;
        }
        IgnoreItemDTO ignoreItemDTO = (IgnoreItemDTO) obj;
        return Intrinsics.areEqual(this.name, ignoreItemDTO.name) && this.type == ignoreItemDTO.type;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + Integer.hashCode(this.type);
    }

    public String toString() {
        return "IgnoreItemDTO(name=" + this.name + ", type=" + this.type + ")";
    }
}
