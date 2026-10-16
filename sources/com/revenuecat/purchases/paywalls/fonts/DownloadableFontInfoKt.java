package com.revenuecat.purchases.paywalls.fonts;

import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import com.revenuecat.purchases.utils.Result;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class DownloadableFontInfoKt {
    public static final /* synthetic */ Result toDownloadableFontInfo(UiConfig.AppConfig.FontsConfig.FontInfo.Name name) {
        String str;
        Intrinsics.checkNotNullParameter(name, "<this>");
        String url = name.getUrl();
        if (url == null || StringsKt.p0(url)) {
            str = "Font URL is empty for " + name.getValue() + ". Cannot download font. Please try to re-upload your font in the RevenueCat dashboard.";
        } else {
            String hash = name.getHash();
            if (hash == null || StringsKt.p0(hash)) {
                str = "Font hash is empty for " + name.getValue() + ". Cannot validate downloaded font. Please try to re-upload your font in the RevenueCat dashboard.";
            } else {
                String family = name.getFamily();
                if (family == null || StringsKt.p0(family)) {
                    str = "Font family is empty for " + name.getValue() + ". Cannot download font. Please try to re-upload your font in the RevenueCat dashboard.";
                } else if (name.getWeight() == null) {
                    str = "Font weight is null for " + name.getValue() + ". Cannot download font. Please try to re-upload your font in the RevenueCat dashboard.";
                } else if (name.getStyle() == null) {
                    str = "Font style is null for " + name.getValue() + ". Cannot download font. Please try to re-upload your font in the RevenueCat dashboard.";
                } else {
                    str = null;
                }
            }
        }
        if (str != null) {
            return new Result.Error(str);
        }
        String url2 = name.getUrl();
        Intrinsics.checkNotNull(url2);
        String hash2 = name.getHash();
        Intrinsics.checkNotNull(hash2);
        String family2 = name.getFamily();
        Intrinsics.checkNotNull(family2);
        Integer weight = name.getWeight();
        Intrinsics.checkNotNull(weight);
        int iIntValue = weight.intValue();
        FontStyle style = name.getStyle();
        Intrinsics.checkNotNull(style);
        return new Result.Success(new DownloadableFontInfo(url2, hash2, family2, iIntValue, style));
    }
}
