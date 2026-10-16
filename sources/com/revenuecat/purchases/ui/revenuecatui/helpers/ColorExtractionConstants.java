package com.revenuecat.purchases.ui.revenuecatui.helpers;

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
public final class ColorExtractionConstants {
    public static final int $stable = 0;
    public static final int ALPHA_CHANNEL_SHIFT = 24;
    public static final int COLOR_COMPONENT_MASK = 255;
    public static final int COLOR_QUANTIZATION_DIVISOR = 16;
    public static final int GREEN_CHANNEL_SHIFT = 8;
    public static final ColorExtractionConstants INSTANCE = new ColorExtractionConstants();
    public static final int MAXIMUM_BRIGHTNESS_THRESHOLD = 700;
    public static final int MAX_PIXEL_SAMPLES = 10000;
    public static final int MINIMUM_ALPHA_THRESHOLD = 128;
    public static final int MINIMUM_BRIGHTNESS_THRESHOLD = 50;
    public static final double MINIMUM_COLOR_DISTANCE = 0.25d;
    public static final double MINIMUM_DISTANCE_FROM_BLACK_WHITE = 0.3d;
    public static final int RED_CHANNEL_SHIFT = 16;
    public static final double RGB_NORMALIZATION_DIVISOR = 255.0d;
    public static final double WCAG_BLUE_LUMINANCE_WEIGHT = 0.0722d;
    public static final float WCAG_COMPONENT_THRESHOLD = 0.03928f;
    public static final double WCAG_CONTRAST_OFFSET = 0.05d;
    public static final double WCAG_GAMMA_EXPONENT = 2.4d;
    public static final double WCAG_GAMMA_OFFSET = 0.055d;
    public static final double WCAG_GAMMA_SCALE = 1.055d;
    public static final double WCAG_GREEN_LUMINANCE_WEIGHT = 0.7152d;
    public static final double WCAG_LINEAR_COMPONENT_DIVISOR = 12.92d;
    public static final double WCAG_RED_LUMINANCE_WEIGHT = 0.2126d;

    private ColorExtractionConstants() {
    }
}
