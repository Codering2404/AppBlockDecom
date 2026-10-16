package com.superwall.sdk.misc;

import android.graphics.Color;
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
public final class Color_HelpersKt {
    public static final int inverseReadableOverlayColor(int i3) {
        return isDarkColor(i3) ? -16777216 : -1;
    }

    public static final boolean isDarkColor(int i3) {
        return ((((double) 0.2126f) * (((double) Color.red(i3)) / 255.0d)) + (((double) 0.7152f) * (((double) Color.green(i3)) / 255.0d))) + (((double) 0.0722f) * (((double) Color.blue(i3)) / 255.0d)) < 0.5d;
    }

    public static final boolean isLightColor(int i3) {
        return !isDarkColor(i3);
    }

    public static final int readableOverlayColor(int i3) {
        return isDarkColor(i3) ? -1 : -16777216;
    }
}
