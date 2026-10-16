package com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent;

import androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class IconComponentStateKt {
    public static final /* synthetic */ IconComponentState rememberUpdatedIconComponentState(IconComponentStyle style, final PaywallState.Loaded.Components paywallState, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(paywallState, "paywallState");
        composer.a0(-153323417);
        if (ComposerKt.M()) {
            ComposerKt.U(-153323417, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.rememberUpdatedIconComponentState (IconComponentState.kt:35)");
        }
        composer.a0(1960797606);
        int i4 = (i3 & 112) ^ 48;
        boolean z2 = (i4 > 32 && composer.Z(paywallState)) || (i3 & 48) == 32;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function0<PaywallState.Loaded.Components.SelectedPackageInfo>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentStateKt$rememberUpdatedIconComponentState$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final PaywallState.Loaded.Components.SelectedPackageInfo invoke() {
                    return paywallState.getSelectedPackageInfo();
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        composer.U();
        composer.a0(1960799811);
        boolean z3 = (i4 > 32 && composer.Z(paywallState)) || (i3 & 48) == 32;
        Object objG2 = composer.G();
        if (z3 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentStateKt$rememberUpdatedIconComponentState$2$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(paywallState.getSelectedTabIndex());
                }
            };
            composer.w(objG2);
        }
        Function0 function02 = (Function0) objG2;
        composer.U();
        composer.a0(1960802187);
        boolean z4 = (i4 > 32 && composer.Z(paywallState)) || (i3 & 48) == 32;
        Object objG3 = composer.G();
        if (z4 || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentStateKt$rememberUpdatedIconComponentState$3$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final OfferEligibility invoke() {
                    return paywallState.getSelectedOfferEligibility();
                }
            };
            composer.w(objG3);
        }
        Function0 function03 = (Function0) objG3;
        composer.U();
        composer.a0(1960804520);
        boolean z5 = (i4 > 32 && composer.Z(paywallState)) || (i3 & 48) == 32;
        Object objG4 = composer.G();
        if (z5 || objG4 == Composer.f23746a.a()) {
            objG4 = new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentStateKt$rememberUpdatedIconComponentState$4$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, CustomVariableValue> invoke() {
                    return paywallState.getMergedCustomVariables();
                }
            };
            composer.w(objG4);
        }
        composer.U();
        IconComponentState iconComponentStateRememberUpdatedIconComponentState = rememberUpdatedIconComponentState(style, function0, function02, function03, (Function0) objG4, composer, i3 & 14);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return iconComponentStateRememberUpdatedIconComponentState;
    }

    private static final /* synthetic */ IconComponentState rememberUpdatedIconComponentState(IconComponentStyle iconComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Composer composer, int i3) {
        composer.a0(-1304007611);
        if (ComposerKt.M()) {
            ComposerKt.U(-1304007611, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.rememberUpdatedIconComponentState (IconComponentState.kt:52)");
        }
        WindowWidthSizeClass windowWidthSizeClassB = AndroidWindowAdaptiveInfo_androidKt.b(composer, 0).a().b();
        LayoutDirection layoutDirection = (LayoutDirection) composer.q(CompositionLocalsKt.m());
        composer.a0(1960824020);
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(iconComponentStyle)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            IconComponentState iconComponentState = new IconComponentState(windowWidthSizeClassB, layoutDirection, iconComponentStyle, function0, function02, function03, function04);
            composer.w(iconComponentState);
            objG = iconComponentState;
        }
        IconComponentState iconComponentState2 = (IconComponentState) objG;
        composer.U();
        iconComponentState2.update(windowWidthSizeClassB);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return iconComponentState2;
    }
}
