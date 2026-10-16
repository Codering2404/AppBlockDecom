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
final class Template3UIConstants {
    public static final Template3UIConstants INSTANCE = new Template3UIConstants();
    private static final float iconCornerRadius = Dp.g(8);
    private static final float iconSize = Dp.g(70);
    private static final float featureIconSize = Dp.g(35);
    private static final float iconPadding = Dp.g(5);
    private static final float featureSpacingPortrait = Dp.g(40);
    private static final float featureSpacingLandscape = Dp.g(20);

    private Template3UIConstants() {
    }

    /* JADX INFO: renamed from: getFeatureIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1195getFeatureIconSizeD9Ej5fM() {
        return featureIconSize;
    }

    /* JADX INFO: renamed from: getFeatureSpacingLandscape-D9Ej5fM, reason: not valid java name */
    public final float m1196getFeatureSpacingLandscapeD9Ej5fM() {
        return featureSpacingLandscape;
    }

    /* JADX INFO: renamed from: getFeatureSpacingPortrait-D9Ej5fM, reason: not valid java name */
    public final float m1197getFeatureSpacingPortraitD9Ej5fM() {
        return featureSpacingPortrait;
    }

    /* JADX INFO: renamed from: getIconCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m1198getIconCornerRadiusD9Ej5fM() {
        return iconCornerRadius;
    }

    /* JADX INFO: renamed from: getIconPadding-D9Ej5fM, reason: not valid java name */
    public final float m1199getIconPaddingD9Ej5fM() {
        return iconPadding;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1200getIconSizeD9Ej5fM() {
        return iconSize;
    }
}
