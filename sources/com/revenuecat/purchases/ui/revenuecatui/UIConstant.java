package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.graphics.Color;
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
public final class UIConstant {
    public static final int defaultAnimationDurationMillis = 200;
    private static final float defaultHorizontalPadding;
    private static final float defaultVerticalSpacing;
    public static final float halfWeight = 0.5f;
    public static final float purchaseInProgressButtonOpacity = 0.4f;
    public static final UIConstant INSTANCE = new UIConstant();
    private static final float defaultCornerRadius = Dp.g(20);
    private static final float defaultPackageCornerRadius = Dp.g(16);
    private static final float defaultPackageBorderWidth = Dp.g((float) 1.5d);
    private static final AnimationSpec<Color> defaultColorAnimation = AnimationSpecKt.n(300, 0, EasingKt.e(), 2, null);
    private static final float iconButtonSize = Dp.g(48);
    public static final int $stable = 8;

    static {
        float f3 = 12;
        defaultHorizontalPadding = Dp.g(f3);
        defaultVerticalSpacing = Dp.g(f3);
    }

    private UIConstant() {
    }

    public final <T> TweenSpec<T> defaultAnimation() {
        return AnimationSpecKt.n(200, 0, EasingKt.f(), 2, null);
    }

    public final AnimationSpec<Color> getDefaultColorAnimation() {
        return defaultColorAnimation;
    }

    /* JADX INFO: renamed from: getDefaultCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m689getDefaultCornerRadiusD9Ej5fM() {
        return defaultCornerRadius;
    }

    /* JADX INFO: renamed from: getDefaultHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m690getDefaultHorizontalPaddingD9Ej5fM() {
        return defaultHorizontalPadding;
    }

    /* JADX INFO: renamed from: getDefaultPackageBorderWidth-D9Ej5fM, reason: not valid java name */
    public final float m691getDefaultPackageBorderWidthD9Ej5fM() {
        return defaultPackageBorderWidth;
    }

    /* JADX INFO: renamed from: getDefaultPackageCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m692getDefaultPackageCornerRadiusD9Ej5fM() {
        return defaultPackageCornerRadius;
    }

    /* JADX INFO: renamed from: getDefaultVerticalSpacing-D9Ej5fM, reason: not valid java name */
    public final float m693getDefaultVerticalSpacingD9Ej5fM() {
        return defaultVerticalSpacing;
    }

    /* JADX INFO: renamed from: getIconButtonSize-D9Ej5fM, reason: not valid java name */
    public final float m694getIconButtonSizeD9Ej5fM() {
        return iconButtonSize;
    }
}
