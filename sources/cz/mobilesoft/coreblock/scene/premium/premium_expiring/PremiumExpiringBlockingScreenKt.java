package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import android.util.Log;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.GradientTextKt;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt;
import cz.mobilesoft.coreblock.view.screen.SimpleScreenKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumExpiringBlockingScreenKt {
    public static final void d(final PremiumExpiringViewState viewState, Function0 onNavigateToNext, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onNavigateToNext, "onNavigateToNext");
        Composer composerK = composer.k(845362327);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onNavigateToNext) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(845362327, i4, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringBlockingScreen (PremiumExpiringBlockingScreen.kt:40)");
            }
            function0 = onNavigateToNext;
            SimpleScreenKt.b(StringResources_androidKt.b(R.string.dq, composerK, 0), StringResources_androidKt.b(R.string.l8, composerK, 0), function0, null, null, ComposableLambdaKt.e(535917649, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.p0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumExpiringBlockingScreenKt.e(viewState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 3) & 896) | 196608, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onNavigateToNext;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumExpiringBlockingScreenKt.g(viewState, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(final PremiumExpiringViewState premiumExpiringViewState, BoxScope BaseScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BaseScreen, "$this$BaseScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BaseScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(535917649, i4, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringBlockingScreen.<anonymous> (PremiumExpiringBlockingScreen.kt:46)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.cq, composer, 0), PaddingKt.k(companion, Dp.g(16), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65020);
            SpacerKt.a(SizeKt.i(companion, Dp.g(40)), composer, 6);
            Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(56), 7, null);
            Alignment.Horizontal horizontalG = companion2.g();
            boolean Z = composer.Z(premiumExpiringViewState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.r0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PremiumExpiringBlockingScreenKt.f(premiumExpiringViewState, (LazyListScope) obj);
                    }
                };
                composer.w(objG);
            }
            LazyDslKt.b(modifierM, null, null, false, null, horizontalG, null, false, null, (Function1) objG, composer, 196614, 478);
            composer.y();
            SpacerKt.a(BackgroundKt.b(PaddingKt.m(SizeKt.i(SizeKt.h(BaseScreen.f(companion, companion2.b()), 0.0f, 1, null), Dp.g(112)), 0.0f, 0.0f, 0.0f, Dp.g(44), 7, null), Brush.Companion.m(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.f25715b.j()), Color.n(ComposeColorsKt.j(composer, 0).e())}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(PremiumExpiringViewState premiumExpiringViewState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List listE = premiumExpiringViewState.e();
        final PremiumExpiringBlockingScreenKt$PremiumExpiringBlockingScreen$lambda$0$0$0$0$$inlined$items$default$1 premiumExpiringBlockingScreenKt$PremiumExpiringBlockingScreen$lambda$0$0$0$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringBlockingScreenKt$PremiumExpiringBlockingScreen$lambda$0$0$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyColumn.h(listE.size(), null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringBlockingScreenKt$PremiumExpiringBlockingScreen$lambda$0$0$0$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return premiumExpiringBlockingScreenKt$PremiumExpiringBlockingScreen$lambda$0$0$0$0$$inlined$items$default$1.invoke(listE.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringBlockingScreenKt$PremiumExpiringBlockingScreen$lambda$0$0$0$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                int i5;
                if ((i4 & 6) == 0) {
                    i5 = i4 | (composer.Z(lazyItemScope) ? 4 : 2);
                } else {
                    i5 = i4;
                }
                if ((i4 & 48) == 0) {
                    i5 |= composer.e(i3) ? 32 : 16;
                }
                if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                Object obj = listE.get(i3);
                composer.a0(-1737891274);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                Function0 function0A = companion3.a();
                if (composer.m() == null) {
                    ComposablesKt.c();
                }
                composer.L();
                if (composer.i()) {
                    composer.P(function0A);
                } else {
                    composer.v();
                }
                Composer composerA = Updater.a(composer);
                Updater.e(composerA, measurePolicyG, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                if (obj instanceof QuickBlockProfileDTO) {
                    composer.a0(484083282);
                    QuickBlockCardKt.b1(PaddingKt.m(companion, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), (QuickBlockProfileDTO) obj, composer, 6, 0);
                    composer.U();
                } else if (obj instanceof ProfileViewDTO) {
                    composer.a0(484394832);
                    ProfileItemKt.g1(PaddingKt.m(companion, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), (ProfileViewDTO) obj, composer, 6, 0);
                    composer.U();
                } else {
                    composer.a0(484691378);
                    composer.U();
                    Log.d("PremiumExpiringBlockingScreen", "Unknown profile type: " + obj);
                }
                GradientTextKt.c(boxScopeInstance.f(companion, companion2.n()), StringResources_androidKt.b(R.string.ae, composer, 0), PaddingKt.a(Dp.g(8)), ComposeTypographyKt.g(composer, 0).g(), ComposableSingletons$PremiumExpiringBlockingScreenKt.f113526a.b(), composer, 24960, 0);
                composer.y();
                SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(PremiumExpiringViewState premiumExpiringViewState, Function0 function0, int i3, Composer composer, int i4) {
        d(premiumExpiringViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
