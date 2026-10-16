package com.revenuecat.purchases.ui.revenuecatui.templates;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

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
final class Template7UIConstants {
    public static final float headerAspectRatio = 2.0f;
    public static final Template7UIConstants INSTANCE = new Template7UIConstants();
    private static final float featureIconSize = Dp.g(25);
    private static final float checkmarkSize = Dp.g(18);
    private static final float discountPadding = Dp.g(8);

    private Template7UIConstants() {
    }

    /* JADX INFO: renamed from: getCheckmarkSize-D9Ej5fM, reason: not valid java name */
    public final float m1227getCheckmarkSizeD9Ej5fM() {
        return checkmarkSize;
    }

    /* JADX INFO: renamed from: getDiscountPadding-D9Ej5fM, reason: not valid java name */
    public final float m1228getDiscountPaddingD9Ej5fM() {
        return discountPadding;
    }

    /* JADX INFO: renamed from: getFeatureIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1229getFeatureIconSizeD9Ej5fM() {
        return featureIconSize;
    }
}
