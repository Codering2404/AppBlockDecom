package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
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
public final class PaywallIconKt {
    /* JADX INFO: renamed from: PaywallIcon-FNF3uiM, reason: not valid java name */
    public static final void m914PaywallIconFNF3uiM(final PaywallIconName icon, Modifier modifier, final long j3, Composer composer, final int i3, final int i4) {
        int i5;
        long j4;
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerK = composer.k(269660957);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(icon) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
            j4 = j3;
        } else {
            j4 = j3;
            if ((i3 & 384) == 0) {
                i5 |= composerK.f(j4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            }
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(269660957, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIcon (PaywallIcon.kt:23)");
            }
            IconKt.c(PainterResources_androidKt.c(icon.drawable$revenuecatui_defaultsBc8Release(), composerK, 0), null, SizeKt.f(AspectRatioKt.b(Modifier.b8, 1.0f, false, 2, null), 0.0f, 1, null).then(modifier), j4, composerK, ((i5 << 3) & 7168) | 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt$PaywallIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    PaywallIconKt.m914PaywallIconFNF3uiM(icon, modifier2, j3, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    public static final void PaywallIconPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1356053803);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1356053803, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconPreview (PaywallIcon.kt:150)");
            }
            final PaywallIconName[] paywallIconNameArrValues = PaywallIconName.values();
            GridCells.Adaptive adaptive = new GridCells.Adaptive(Dp.g(40), null);
            composerK.a0(914039657);
            boolean zI = composerK.I(paywallIconNameArrValues);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1<LazyGridScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt$PaywallIconPreview$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((LazyGridScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(LazyGridScope LazyVerticalGrid) {
                        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
                        final PaywallIconName[] paywallIconNameArr = paywallIconNameArrValues;
                        LazyGridScope.d(LazyVerticalGrid, paywallIconNameArr.length, null, null, null, ComposableLambdaKt.c(-320278688, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt$PaywallIconPreview$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(LazyGridItemScope items, int i4, Composer composer2, int i5) {
                                int i6;
                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                if ((i5 & 48) == 0) {
                                    i6 = i5 | (composer2.e(i4) ? 32 : 16);
                                } else {
                                    i6 = i5;
                                }
                                if ((i6 & 145) == 144 && composer2.l()) {
                                    composer2.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-320278688, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconPreview.<anonymous>.<anonymous>.<anonymous> (PaywallIcon.kt:155)");
                                }
                                Modifier.Companion companion = Modifier.b8;
                                Color.Companion companion2 = Color.f25715b;
                                Modifier modifierG = BorderKt.g(BackgroundKt.d(companion, companion2.l(), null, 2, null), Dp.g(1), companion2.a(), null, 4, null);
                                PaywallIconName[] paywallIconNameArr2 = paywallIconNameArr;
                                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                                int iA = ComposablesKt.a(composer2, 0);
                                CompositionLocalMap compositionLocalMapU = composer2.u();
                                Modifier modifierF = ComposedModifierKt.f(composer2, modifierG);
                                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                                Function0 function0A = companion3.a();
                                if (composer2.m() == null) {
                                    ComposablesKt.c();
                                }
                                composer2.L();
                                if (composer2.i()) {
                                    composer2.P(function0A);
                                } else {
                                    composer2.v();
                                }
                                Composer composerA = Updater.a(composer2);
                                Updater.e(composerA, measurePolicyG, companion3.e());
                                Updater.e(composerA, compositionLocalMapU, companion3.g());
                                Function2 function2B = companion3.b();
                                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                                    composerA.w(Integer.valueOf(iA));
                                    composerA.p(Integer.valueOf(iA), function2B);
                                }
                                Updater.e(composerA, modifierF, companion3.f());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                                PaywallIconKt.m914PaywallIconFNF3uiM(paywallIconNameArr2[i4], null, companion2.a(), composer2, 384, 2);
                                composer2.y();
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }), 14, null);
                    }
                };
                composerK.w(objG);
            }
            composerK.U();
            LazyGridDslKt.d(adaptive, null, null, null, false, null, null, null, false, (Function1) objG, composerK, 0, 510);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt.PaywallIconPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    PaywallIconKt.PaywallIconPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
