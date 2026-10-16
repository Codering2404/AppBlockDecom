package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
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
public final /* synthetic */ class ThemeImageUrlsKt {
    public static final ImageUrls getUrlsForCurrentTheme(ThemeImageUrls themeImageUrls, Composer composer, int i3) {
        ImageUrls light;
        Intrinsics.checkNotNullParameter(themeImageUrls, "<this>");
        if (ComposerKt.M()) {
            ComposerKt.U(154958320, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.ktx.<get-urlsForCurrentTheme> (ThemeImageUrls.kt:12)");
        }
        if (!DarkThemeKt.a(composer, 0) || (light = themeImageUrls.getDark()) == null) {
            light = themeImageUrls.getLight();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return light;
    }
}
