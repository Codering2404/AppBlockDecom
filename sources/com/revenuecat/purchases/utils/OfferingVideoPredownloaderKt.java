package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.VideoUrls;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

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
public final class OfferingVideoPredownloaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Pair<URL, Checksum>> checkedUrls(ThemeVideoUrls themeVideoUrls) {
        URL urlLowRes;
        URL url;
        Pair pairA = TuplesKt.a(themeVideoUrls.getLight().getUrl(), themeVideoUrls.getLight().getChecksum());
        VideoUrls dark = themeVideoUrls.getDark();
        Pair pairA2 = null;
        Pair pairA3 = (dark == null || (url = dark.getUrl()) == null) ? null : TuplesKt.a(url, themeVideoUrls.getDark().getChecksum());
        URL urlLowRes2 = themeVideoUrls.getLight().getUrlLowRes();
        Pair pairA4 = urlLowRes2 != null ? TuplesKt.a(urlLowRes2, themeVideoUrls.getLight().getChecksumLowRes()) : null;
        VideoUrls dark2 = themeVideoUrls.getDark();
        if (dark2 != null && (urlLowRes = dark2.getUrlLowRes()) != null) {
            pairA2 = TuplesKt.a(urlLowRes, themeVideoUrls.getDark().getChecksumLowRes());
        }
        return CollectionsKt.listOfNotNull((Object[]) new Pair[]{pairA, pairA3, pairA4, pairA2});
    }
}
