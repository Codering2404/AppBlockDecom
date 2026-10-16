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
public final class QuestionnaireConfig implements Serializable {

    @SerializedName("description")
    private final String description;

    @SerializedName("id")
    private final int id;

    @SerializedName("imageUrl")
    private final String imageUrl;

    @SerializedName("title")
    private final String title;

    @SerializedName("url")
    private final String url;

    public final String a() {
        return this.description;
    }

    public final int b() {
        return this.id;
    }

    public final String c() {
        return this.imageUrl;
    }

    public final String d() {
        return this.title;
    }

    public final String e() {
        return this.url;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuestionnaireConfig)) {
            return false;
        }
        QuestionnaireConfig questionnaireConfig = (QuestionnaireConfig) obj;
        return this.id == questionnaireConfig.id && Intrinsics.areEqual(this.title, questionnaireConfig.title) && Intrinsics.areEqual(this.description, questionnaireConfig.description) && Intrinsics.areEqual(this.url, questionnaireConfig.url) && Intrinsics.areEqual(this.imageUrl, questionnaireConfig.imageUrl);
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.url.hashCode()) * 31;
        String str = this.imageUrl;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "QuestionnaireConfig(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", url=" + this.url + ", imageUrl=" + this.imageUrl + ")";
    }
}
