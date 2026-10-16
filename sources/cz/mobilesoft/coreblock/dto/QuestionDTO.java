package cz.mobilesoft.coreblock.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
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
public final class QuestionDTO implements Serializable {

    @SerializedName("id")
    private final int id;

    @SerializedName("slug")
    private final String slug;

    @SerializedName("title")
    private final String title;

    public final int a() {
        return this.id;
    }

    public final String b() {
        return this.slug;
    }

    public final String c() {
        return this.title;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuestionDTO)) {
            return false;
        }
        QuestionDTO questionDTO = (QuestionDTO) obj;
        return this.id == questionDTO.id && Intrinsics.areEqual(this.title, questionDTO.title) && Intrinsics.areEqual(this.slug, questionDTO.slug);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.slug.hashCode();
    }

    public String toString() {
        return "QuestionDTO(id=" + this.id + ", title=" + this.title + ", slug=" + this.slug + ")";
    }
}
