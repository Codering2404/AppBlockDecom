package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
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
public final class ColorsFactory {
    public static final int $stable = 0;
    public static final ColorsFactory INSTANCE = new ColorsFactory();

    private ColorsFactory() {
    }

    public final TemplateConfiguration.Colors create(PaywallData.Configuration.Colors paywallDataColors) {
        Intrinsics.checkNotNullParameter(paywallDataColors, "paywallDataColors");
        int colorInt = paywallDataColors.getBackground().getColorInt();
        int colorInt2 = paywallDataColors.getText1().getColorInt();
        PaywallColor text2 = paywallDataColors.getText2();
        int colorInt3 = text2 != null ? text2.getColorInt() : colorInt2;
        PaywallColor text3 = paywallDataColors.getText3();
        int colorInt4 = text3 != null ? text3.getColorInt() : colorInt3;
        int colorInt5 = paywallDataColors.getCallToActionBackground().getColorInt();
        int colorInt6 = paywallDataColors.getCallToActionForeground().getColorInt();
        PaywallColor callToActionSecondaryBackground = paywallDataColors.getCallToActionSecondaryBackground();
        Integer numValueOf = callToActionSecondaryBackground != null ? Integer.valueOf(callToActionSecondaryBackground.getColorInt()) : null;
        PaywallColor accent1 = paywallDataColors.getAccent1();
        int colorInt7 = accent1 != null ? accent1.getColorInt() : colorInt6;
        PaywallColor accent2 = paywallDataColors.getAccent2();
        int colorInt8 = accent2 != null ? accent2.getColorInt() : colorInt7;
        PaywallColor accent3 = paywallDataColors.getAccent3();
        int colorInt9 = accent3 != null ? accent3.getColorInt() : colorInt8;
        PaywallColor closeButton = paywallDataColors.getCloseButton();
        Integer numValueOf2 = closeButton != null ? Integer.valueOf(closeButton.getColorInt()) : null;
        PaywallColor tierControlBackground = paywallDataColors.getTierControlBackground();
        Integer numValueOf3 = tierControlBackground != null ? Integer.valueOf(tierControlBackground.getColorInt()) : null;
        PaywallColor tierControlForeground = paywallDataColors.getTierControlForeground();
        Integer numValueOf4 = tierControlForeground != null ? Integer.valueOf(tierControlForeground.getColorInt()) : null;
        PaywallColor tierControlSelectedBackground = paywallDataColors.getTierControlSelectedBackground();
        Integer numValueOf5 = tierControlSelectedBackground != null ? Integer.valueOf(tierControlSelectedBackground.getColorInt()) : null;
        PaywallColor tierControlSelectedForeground = paywallDataColors.getTierControlSelectedForeground();
        Integer numValueOf6 = tierControlSelectedForeground != null ? Integer.valueOf(tierControlSelectedForeground.getColorInt()) : null;
        return new TemplateConfiguration.Colors(ColorKt.b(colorInt), ColorKt.b(colorInt2), ColorKt.b(colorInt3), ColorKt.b(colorInt4), ColorKt.b(colorInt5), ColorKt.b(colorInt6), numValueOf != null ? Color.n(ColorKt.b(numValueOf.intValue())) : null, ColorKt.b(colorInt7), ColorKt.b(colorInt8), ColorKt.b(colorInt9), numValueOf2 != null ? Color.n(ColorKt.b(numValueOf2.intValue())) : null, numValueOf3 != null ? Color.n(ColorKt.b(numValueOf3.intValue())) : null, numValueOf4 != null ? Color.n(ColorKt.b(numValueOf4.intValue())) : null, numValueOf5 != null ? Color.n(ColorKt.b(numValueOf5.intValue())) : null, numValueOf6 != null ? Color.n(ColorKt.b(numValueOf6.intValue())) : null, null);
    }
}
