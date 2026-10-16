package com.revenuecat.purchases.ui.revenuecatui.composables;

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
final class TierSwitcherUIConstants {
    public static final int roundedCorner = 50;
    public static final TierSwitcherUIConstants INSTANCE = new TierSwitcherUIConstants();
    private static final float minimumHeight = Dp.g(40);
    private static final float selectedTierPadding = Dp.g(2);
    private static final float tierTextPaddingHorizontal = Dp.g(10);
    private static final float tierTextPaddingVertical = Dp.g(4);
    private static final float tierHorizontalPadding = Dp.g(16);
    private static final float tierVerticalPadding = Dp.g(8);

    private TierSwitcherUIConstants() {
    }

    /* JADX INFO: renamed from: getMinimumHeight-D9Ej5fM, reason: not valid java name */
    public final float m945getMinimumHeightD9Ej5fM() {
        return minimumHeight;
    }

    /* JADX INFO: renamed from: getSelectedTierPadding-D9Ej5fM, reason: not valid java name */
    public final float m946getSelectedTierPaddingD9Ej5fM() {
        return selectedTierPadding;
    }

    /* JADX INFO: renamed from: getTierHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m947getTierHorizontalPaddingD9Ej5fM() {
        return tierHorizontalPadding;
    }

    /* JADX INFO: renamed from: getTierTextPaddingHorizontal-D9Ej5fM, reason: not valid java name */
    public final float m948getTierTextPaddingHorizontalD9Ej5fM() {
        return tierTextPaddingHorizontal;
    }

    /* JADX INFO: renamed from: getTierTextPaddingVertical-D9Ej5fM, reason: not valid java name */
    public final float m949getTierTextPaddingVerticalD9Ej5fM() {
        return tierTextPaddingVertical;
    }

    /* JADX INFO: renamed from: getTierVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m950getTierVerticalPaddingD9Ej5fM() {
        return tierVerticalPadding;
    }
}
