package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    /* JADX INFO: renamed from: colors-lRJcREg, reason: not valid java name */
    public final SwitchColors m932colorslRJcREg(ColorStyle colorStyle, ColorStyle colorStyle2, ColorStyle colorStyle3, long j3, ColorStyle colorStyle4, ColorStyle colorStyle5, ColorStyle colorStyle6, long j4, ColorStyle colorStyle7, ColorStyle colorStyle8, ColorStyle colorStyle9, long j5, ColorStyle colorStyle10, ColorStyle colorStyle11, ColorStyle colorStyle12, long j6, Composer composer, int i3, int i4, int i5) {
        ColorStyle colorStyle13;
        ColorStyle colorStyle14;
        ColorStyle colorStyleM775boximpl;
        composer.a0(1279282675);
        ColorStyle colorStyleM775boximpl2 = (i5 & 1) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer, 6))) : colorStyle;
        ColorStyle colorStyleM775boximpl3 = (i5 & 2) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer, 6))) : colorStyle2;
        ColorStyle colorStyleM775boximpl4 = (i5 & 4) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.j())) : colorStyle3;
        long value = (i5 & 8) != 0 ? SwitchKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j3;
        ColorStyle colorStyleM775boximpl5 = (i5 & 16) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer, 6))) : colorStyle4;
        ColorStyle colorStyleM775boximpl6 = (i5 & 32) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer, 6))) : colorStyle5;
        ColorStyle colorStyleM775boximpl7 = (i5 & 64) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(SwitchKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer, 6))) : colorStyle6;
        long value2 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? SwitchKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer, 6) : j4;
        ColorStyle colorStyleM775boximpl8 = (i5 & Function.MAX_NARGS) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.h(Color.r(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), composer, 6), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b).o0()))) : colorStyle7;
        if ((i5 & 512) != 0) {
            colorStyle13 = colorStyleM775boximpl8;
            colorStyle14 = colorStyleM775boximpl2;
            colorStyleM775boximpl = ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.h(Color.r(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b).o0())));
        } else {
            colorStyle13 = colorStyleM775boximpl8;
            colorStyle14 = colorStyleM775boximpl2;
            colorStyleM775boximpl = colorStyle8;
        }
        ColorStyle colorStyleM775boximpl9 = (i5 & 1024) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.j())) : colorStyle9;
        long jH = (i5 & 2048) != 0 ? ColorKt.h(Color.r(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b).o0()) : j5;
        ColorStyle colorStyleM775boximpl10 = (i5 & 4096) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.h(Color.r(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b).o0()))) : colorStyle10;
        ColorStyle colorStyleM775boximpl11 = (i5 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.h(Color.r(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b).o0()))) : colorStyle11;
        ColorStyle colorStyleM775boximpl12 = (i5 & 16384) != 0 ? ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.h(Color.r(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b).o0()))) : colorStyle12;
        long jH2 = (i5 & 32768) != 0 ? ColorKt.h(Color.r(SwitchKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b).o0()) : j6;
        if (ComposerKt.M()) {
            ComposerKt.U(1279282675, i3, i4, "com.revenuecat.purchases.ui.revenuecatui.composables.SwitchDefaults.colors (Switch.kt:172)");
        }
        SwitchColors switchColors = new SwitchColors(colorStyle14, colorStyleM775boximpl3, colorStyleM775boximpl4, value, colorStyleM775boximpl5, colorStyleM775boximpl6, colorStyleM775boximpl7, value2, colorStyle13, colorStyleM775boximpl, colorStyleM775boximpl9, jH, colorStyleM775boximpl10, colorStyleM775boximpl11, colorStyleM775boximpl12, jH2, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return switchColors;
    }
}
