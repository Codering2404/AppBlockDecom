package cz.mobilesoft.coreblock.util.profile;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class WebsiteHelperKt {
    public static final boolean a(WebsiteProfileRelation websiteProfileRelation, UrlDto url) {
        Intrinsics.checkNotNullParameter(websiteProfileRelation, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        if (Intrinsics.areEqual(websiteProfileRelation.c(), url.getDomain())) {
            return true;
        }
        if (websiteProfileRelation.a() == WebsiteProfileRelation.BlockingType.DOMAIN) {
            if (StringsKt.a0(url.getDomain(), "." + websiteProfileRelation.c(), false, 2, null)) {
                return true;
            }
        }
        if (websiteProfileRelation.a() == WebsiteProfileRelation.BlockingType.KEYWORD) {
            return websiteProfileRelation.e() ? StringsKt.a0(url.getUrl(), websiteProfileRelation.c(), false, 2, null) : StringsKt.a0(url.getDomain(), websiteProfileRelation.c(), false, 2, null);
        }
        return false;
    }
}
