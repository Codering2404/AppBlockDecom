package cz.mobilesoft.coreblock.scene.schedule;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class WebsiteDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f115037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f115038b;

    public WebsiteDTO(boolean z2, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f115037a = z2;
        this.f115038b = url;
    }

    public final String a() {
        return this.f115038b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebsiteDTO)) {
            return false;
        }
        WebsiteDTO websiteDTO = (WebsiteDTO) obj;
        return this.f115037a == websiteDTO.f115037a && Intrinsics.areEqual(this.f115038b, websiteDTO.f115038b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f115037a) * 31) + this.f115038b.hashCode();
    }

    public String toString() {
        return "WebsiteDTO(isEnabled=" + this.f115037a + ", url=" + this.f115038b + ")";
    }

    public /* synthetic */ WebsiteDTO(boolean z2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, str);
    }
}
