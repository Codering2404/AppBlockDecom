package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CloseButtonKt {
    /* JADX INFO: renamed from: CloseButton-drOMvmE, reason: not valid java name */
    public static final void m872CloseButtondrOMvmE(final BoxScope CloseButton, final boolean z2, final Color color, final boolean z3, final Function0<Unit> onClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(CloseButton, "$this$CloseButton");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(-396768639);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(CloseButton) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(color) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onClick) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-396768639, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.CloseButton (CloseButton.kt:20)");
            }
            if (z2) {
                Modifier.Companion companion = Modifier.b8;
                Alignment.Companion companion2 = Alignment.f25072a;
                Modifier modifierF = CloseButton.f(companion, companion2.o());
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composerK, 0);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                Function0 function0A = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A);
                } else {
                    composerK.v();
                }
                Composer composerA = Updater.a(composerK);
                Updater.e(composerA, measurePolicyA, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion3.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                InsetSpacersKt.StatusBarSpacer(composerK, 0);
                IconButtonKt.e(onClick, null, !z3, null, null, ComposableLambdaKt.e(170484435, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.CloseButtonKt$CloseButton$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        if ((i5 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(170484435, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.CloseButton.<anonymous>.<anonymous> (CloseButton.kt:30)");
                        }
                        Painter painterC = PainterResources_androidKt.c(R.drawable.close, composer2, 0);
                        Color color2 = color;
                        composer2.a0(752306841);
                        long jB = color2 == null ? ((Color) composer2.q(ContentColorKt.a())).B() : color2.B();
                        composer2.U();
                        IconKt.c(painterC, null, null, jB, composer2, 48, 4);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), composerK, ((i4 >> 12) & 14) | 196608, 26);
                composerK.y();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.CloseButtonKt$CloseButton$2
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
                    CloseButtonKt.m872CloseButtondrOMvmE(CloseButton, z2, color, z3, onClick, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
