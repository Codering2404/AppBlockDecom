package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
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
public final class CustomerCenterUIConstants {
    public static final int $stable = 0;
    private static final float ContentUnavailableIconSize;
    private static final float ContentUnavailableViewPaddingHorizontal;
    private static final float ContentUnavailableViewPaddingText;
    private static final float ContentUnavailableViewPaddingVertical;
    public static final CustomerCenterUIConstants INSTANCE = new CustomerCenterUIConstants();
    private static final float ManagementViewHorizontalPadding;
    private static final float ManagementViewSpacer;
    private static final float ManagementViewTitleTopPadding;
    private static final float PaddingMedium;
    private static final float PaddingSmall;
    private static final float PaddingTiny;
    private static final float PaddingXL;
    public static final float SettingsRowMainTextAlpha = 1.0f;
    private static final long SettingsRowMainTextSize;
    public static final float SettingsRowSupportingTextAlpha = 0.6f;
    private static final long SettingsRowSupportingTextSize;
    private static final float SubscriptionViewHorizontalSpace;
    private static final float SubscriptionViewIconSize;
    private static final float SubscriptionViewRowHeight;

    static {
        float fG = Dp.g(4);
        PaddingTiny = fG;
        float fG2 = Dp.g(8);
        PaddingSmall = fG2;
        float f3 = 16;
        float fG3 = Dp.g(f3);
        PaddingMedium = fG3;
        float fG4 = Dp.g(32);
        PaddingXL = fG4;
        ManagementViewTitleTopPadding = Dp.g(64);
        SettingsRowMainTextSize = TextUnitKt.i(20);
        SettingsRowSupportingTextSize = TextUnitKt.i(14);
        SubscriptionViewRowHeight = Dp.g(60);
        SubscriptionViewHorizontalSpace = fG2;
        float f4 = 24;
        SubscriptionViewIconSize = Dp.g(f4);
        ContentUnavailableViewPaddingHorizontal = Dp.g(f3);
        ContentUnavailableViewPaddingVertical = Dp.g(20);
        ContentUnavailableViewPaddingText = fG;
        ContentUnavailableIconSize = Dp.g(f4);
        ManagementViewHorizontalPadding = fG3;
        ManagementViewSpacer = fG4;
    }

    private CustomerCenterUIConstants() {
    }

    /* JADX INFO: renamed from: getContentUnavailableIconSize-D9Ej5fM, reason: not valid java name */
    public final float m967getContentUnavailableIconSizeD9Ej5fM() {
        return ContentUnavailableIconSize;
    }

    /* JADX INFO: renamed from: getContentUnavailableViewPaddingHorizontal-D9Ej5fM, reason: not valid java name */
    public final float m968getContentUnavailableViewPaddingHorizontalD9Ej5fM() {
        return ContentUnavailableViewPaddingHorizontal;
    }

    /* JADX INFO: renamed from: getContentUnavailableViewPaddingText-D9Ej5fM, reason: not valid java name */
    public final float m969getContentUnavailableViewPaddingTextD9Ej5fM() {
        return ContentUnavailableViewPaddingText;
    }

    /* JADX INFO: renamed from: getContentUnavailableViewPaddingVertical-D9Ej5fM, reason: not valid java name */
    public final float m970getContentUnavailableViewPaddingVerticalD9Ej5fM() {
        return ContentUnavailableViewPaddingVertical;
    }

    /* JADX INFO: renamed from: getManagementViewHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m971getManagementViewHorizontalPaddingD9Ej5fM() {
        return ManagementViewHorizontalPadding;
    }

    /* JADX INFO: renamed from: getManagementViewSpacer-D9Ej5fM, reason: not valid java name */
    public final float m972getManagementViewSpacerD9Ej5fM() {
        return ManagementViewSpacer;
    }

    /* JADX INFO: renamed from: getManagementViewTitleTopPadding-D9Ej5fM, reason: not valid java name */
    public final float m973getManagementViewTitleTopPaddingD9Ej5fM() {
        return ManagementViewTitleTopPadding;
    }

    /* JADX INFO: renamed from: getSettingsRowMainTextSize-XSAIIZE, reason: not valid java name */
    public final long m974getSettingsRowMainTextSizeXSAIIZE() {
        return SettingsRowMainTextSize;
    }

    /* JADX INFO: renamed from: getSettingsRowSupportingTextSize-XSAIIZE, reason: not valid java name */
    public final long m975getSettingsRowSupportingTextSizeXSAIIZE() {
        return SettingsRowSupportingTextSize;
    }

    /* JADX INFO: renamed from: getSubscriptionViewHorizontalSpace-D9Ej5fM, reason: not valid java name */
    public final float m976getSubscriptionViewHorizontalSpaceD9Ej5fM() {
        return SubscriptionViewHorizontalSpace;
    }

    /* JADX INFO: renamed from: getSubscriptionViewIconSize-D9Ej5fM, reason: not valid java name */
    public final float m977getSubscriptionViewIconSizeD9Ej5fM() {
        return SubscriptionViewIconSize;
    }

    /* JADX INFO: renamed from: getSubscriptionViewRowHeight-D9Ej5fM, reason: not valid java name */
    public final float m978getSubscriptionViewRowHeightD9Ej5fM() {
        return SubscriptionViewRowHeight;
    }
}
