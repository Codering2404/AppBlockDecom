package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.BlurredEdgeTreatment;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt;
import defpackage.BlurTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallBackgroundKt {
    public static final void PaywallBackground(final BoxScope boxScope, final TemplateConfiguration templateConfiguration, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
        Composer composerK = composer.k(-1106841354);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(templateConfiguration) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1106841354, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PaywallBackground (PaywallBackground.kt:23)");
            }
            boolean z2 = false;
            boolean z3 = Build.VERSION.SDK_INT >= 31;
            boolean blurredBackgroundImage = templateConfiguration.getConfiguration().getBlurredBackgroundImage();
            float f3 = blurredBackgroundImage ? 0.7f : 1.0f;
            composerK.a0(1963318254);
            BlurTransformation blurTransformation = (!blurredBackgroundImage || z3) ? null : new BlurTransformation((Context) composerK.q(AndroidCompositionLocals_androidKt.g()), m913toFloatPx8Feqmps(BackgroundUIConstants.INSTANCE.m871getBlurSizeD9Ej5fM(), composerK, 6));
            composerK.U();
            Modifier modifierH = boxScope.h(Modifier.b8);
            if (blurredBackgroundImage && z3) {
                z2 = true;
            }
            Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierH, z2, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallBackgroundKt$PaywallBackground$modifier$1
                @Override // kotlin.jvm.functions.Function1
                public final Modifier invoke(Modifier conditional) {
                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                    return BlurKt.b(conditional, BackgroundUIConstants.INSTANCE.m871getBlurSizeD9Ej5fM(), BlurredEdgeTreatment.f25380b.b());
                }
            });
            if (Intrinsics.areEqual(templateConfiguration.getConfiguration().getImages().getBackground(), PaywallDataExtensionsKt.getDefaultBackgroundPlaceholder(PaywallData.Companion))) {
                composerK.a0(733877144);
                RemoteImageKt.LocalImage(R.drawable.default_background, modifierConditional, BackgroundUIConstants.INSTANCE.getContentScale(), null, blurTransformation, f3, null, composerK, 384, 72);
                composerK.U();
            } else if (templateConfiguration.getImages().getBackgroundUri() != null) {
                composerK.a0(734225770);
                if (blurredBackgroundImage || PaywallModeKt.isFullScreen(templateConfiguration.getMode())) {
                    String string = templateConfiguration.getImages().getBackgroundUri().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "templateConfiguration.im….backgroundUri.toString()");
                    RemoteImageKt.RemoteImage(string, modifierConditional, null, BackgroundUIConstants.INSTANCE.getContentScale(), null, blurTransformation, f3, null, composerK, 3072, 148);
                    composerK = composerK;
                }
                composerK.U();
            } else {
                composerK.a0(734695699);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallBackgroundKt.PaywallBackground.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    PaywallBackgroundKt.PaywallBackground(boxScope, templateConfiguration, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: toFloatPx-8Feqmps, reason: not valid java name */
    private static final float m913toFloatPx8Feqmps(float f3, Composer composer, int i3) {
        composer.a0(452796480);
        if (ComposerKt.M()) {
            ComposerKt.U(452796480, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.toFloatPx (PaywallBackground.kt:73)");
        }
        float density = f3 * ((Density) composer.q(CompositionLocalsKt.f())).getDensity();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return density;
    }
}
