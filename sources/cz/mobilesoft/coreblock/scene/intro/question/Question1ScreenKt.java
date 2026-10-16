package cz.mobilesoft.coreblock.scene.intro.question;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.ScaffoldKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.intro.HelpItemWithExplanation;
import cz.mobilesoft.coreblock.scene.intro.OnboardingComposeCommonsKt;
import cz.mobilesoft.coreblock.scene.intro.OnboardingHelpItem;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableSet;

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
public final class Question1ScreenKt {
    private static final void j(final PaddingValues paddingValues, final ImmutableSet immutableSet, final Function1 function1, Composer composer, final int i3) {
        Composer composerK = composer.k(2004786845);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(paddingValues) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(immutableSet) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2004786845, i4, -1, "cz.mobilesoft.coreblock.scene.intro.question.Content (Question1Screen.kt:93)");
            }
            Modifier modifierJ = PaddingKt.j(PaddingKt.h(ScrollKt.g(SizeKt.f(Modifier.b8, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95486t, composerK, 0), Dp.g(32));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(16)), Alignment.f25072a.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(-1200041162);
            for (final OnboardingHelpItem onboardingHelpItem : CollectionsKt.plus((Collection<? extends OnboardingHelpItem.Other>) HelpItemWithExplanation.f104475h.a(), OnboardingHelpItem.Other.f104503g)) {
                boolean zContains = immutableSet.contains(onboardingHelpItem);
                boolean Z = ((i4 & 896) == 256) | composerK.Z(onboardingHelpItem);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.question.g0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Question1ScreenKt.k(function1, onboardingHelpItem);
                        }
                    };
                    composerK.w(objG);
                }
                r(onboardingHelpItem, zContains, (Function0) objG, composerK, 0);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Question1ScreenKt.l(paddingValues, immutableSet, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function1 function1, OnboardingHelpItem onboardingHelpItem) {
        function1.invoke(onboardingHelpItem);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(PaddingValues paddingValues, ImmutableSet immutableSet, Function1 function1, int i3, Composer composer, int i4) {
        j(paddingValues, immutableSet, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void m(final OnboardingViewState viewState, final Function1 onItemClicked, final Function0 onCloseClicked, final Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-159399439);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onItemClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onCloseClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onContinueClicked) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-159399439, i4, -1, "cz.mobilesoft.coreblock.scene.intro.question.Question1Screen (Question1Screen.kt:57)");
            }
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), null, ComposableLambdaKt.e(-1400136330, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Question1ScreenKt.n(onCloseClicked, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-1150857929, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Question1ScreenKt.o(viewState, onContinueClicked, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-821632209, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.question.e0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Question1ScreenKt.p(viewState, onItemClicked, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 3456, 12582912, 131058);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Question1ScreenKt.q(viewState, onItemClicked, onCloseClicked, onContinueClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1400136330, i3, -1, "cz.mobilesoft.coreblock.scene.intro.question.Question1Screen.<anonymous> (Question1Screen.kt:62)");
            }
            OnboardingComposeCommonsKt.e(StringResources_androidKt.b(R.string.Zq, composer, 0), function0, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(OnboardingViewState onboardingViewState, Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1150857929, i3, -1, "cz.mobilesoft.coreblock.scene.intro.question.Question1Screen.<anonymous> (Question1Screen.kt:75)");
            }
            if (onboardingViewState.g()) {
                composer.a0(1515435655);
                Modifier modifierM = PaddingKt.m(PaddingKt.k(Modifier.b8, Dp.g(PrimitiveResources_androidKt.a(R.dimen.f95486t, composer, 0) + Dp.g(16)), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(12), 7, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
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
                Updater.e(composerA, measurePolicyG, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ComposeButtonsKt.i0(null, new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null), new ButtonColor.Accent(!onboardingViewState.e().isEmpty(), null, false, null, 14, null), function0, composer, 0, 1);
                composer.y();
            } else {
                composer.a0(1512260139);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(OnboardingViewState onboardingViewState, Function1 function1, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-821632209, i3, -1, "cz.mobilesoft.coreblock.scene.intro.question.Question1Screen.<anonymous> (Question1Screen.kt:68)");
            }
            j(it, onboardingViewState.e(), function1, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(OnboardingViewState onboardingViewState, Function1 function1, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        m(onboardingViewState, function1, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void r(final OnboardingHelpItem item, final boolean z2, final Function0 onClick, Composer composer, final int i3) {
        int i4;
        Color colorN;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(830586098);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(item) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onClick) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(830586098, i4, -1, "cz.mobilesoft.coreblock.scene.intro.question.SelectableItemCard (Question1Screen.kt:115)");
            }
            if (z2) {
                composerK.a0(684053555);
                long jB = ComposeColorsKt.j(composerK, 0).b();
                composerK.U();
                colorN = Color.n(jB);
            } else {
                composerK.a0(684119740);
                composerK.U();
                colorN = null;
            }
            CardType.Surface surface = new CardType.Surface(colorN, null, null, 6, null);
            Modifier modifierH = SizeKt.h(PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null), 0.0f, 1, null);
            boolean z3 = (i4 & 896) == 256;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.question.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Question1ScreenKt.s(onClick);
                    }
                };
                composerK.w(objG);
            }
            ComposeCardsKt.m(modifierH, surface, (Function0) objG, ComposableLambdaKt.e(760573101, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Question1ScreenKt.t(item, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3078, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Question1ScreenKt.u(item, z2, onClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(OnboardingHelpItem onboardingHelpItem, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(760573101, i3, -1, "cz.mobilesoft.coreblock.scene.intro.question.SelectableItemCard.<anonymous> (Question1Screen.kt:131)");
            }
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(SizeKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(56), 0.0f, 2, null), Dp.g(f3), Dp.g(4));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.i(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, onboardingHelpItem.a(), composer, 6), null, null, null, null, 0.0f, null, composer, 48, 124);
            TextKt.c(StringResources_androidKt.b(onboardingHelpItem.e(), composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65534);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(OnboardingHelpItem onboardingHelpItem, boolean z2, Function0 function0, int i3, Composer composer, int i4) {
        r(onboardingHelpItem, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
