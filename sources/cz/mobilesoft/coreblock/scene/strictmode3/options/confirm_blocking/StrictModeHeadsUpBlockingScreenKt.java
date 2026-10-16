package cz.mobilesoft.coreblock.scene.strictmode3.options.confirm_blocking;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.MaterialTheme;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeHeadsUpCardKt;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewState;
import cz.mobilesoft.coreblock.scene.strictmode3.options.confirm_blocking.StrictModeHeadsUpBlockingScreenKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

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
public final class StrictModeHeadsUpBlockingScreenKt {
    private static final void h(final Modifier modifier, ImmutableList immutableList, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final ImmutableList immutableList2 = immutableList;
        Composer composerK = composer.k(-1552070695);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(modifier) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(immutableList2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1552070695, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.confirm_blocking.Content (StrictModeHeadsUpBlockingScreen.kt:80)");
            }
            Modifier modifierG = ScrollKt.g(SizeKt.h(modifier, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
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
            Modifier.Companion companion2 = Modifier.b8;
            float f3 = 48;
            Modifier modifierK = PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null);
            String strB = StringResources_androidKt.b(R.string.tf, composerK, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i5 = MaterialTheme.f13092b;
            TextStyle textStyleF = materialTheme.c(composerK, i5).f();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            composer2 = composerK;
            TextKt.c(strB, modifierK, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleF, composer2, 48, 0, 65020);
            SpacerKt.a(PaddingKt.i(companion2, Dp.g(8)), composer2, 6);
            TextKt.c(StringResources_androidKt.b(R.string.ue, composer2, 0), PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer2, i5).b(), composer2, 48, 0, 65020);
            immutableList2 = immutableList;
            StrictModeHeadsUpCardKt.f(StrictModeOption.Companion.a(immutableList2), false, null, composer2, 48, 4);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: a2.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeHeadsUpBlockingScreenKt.i(modifier, immutableList2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Modifier modifier, ImmutableList immutableList, int i3, Composer composer, int i4) {
        h(modifier, immutableList, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void j(final StrictModeOptionsViewState viewState, final Function1 onEvent, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-153873545);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onCloseClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-153873545, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.confirm_blocking.StrictModeHeadsUpBlockingScreen (StrictModeHeadsUpBlockingScreen.kt:42)");
            }
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), null, ComposableLambdaKt.e(1082166226, true, new Function2() { // from class: a2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeHeadsUpBlockingScreenKt.k(onCloseClicked, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(597220977, true, new Function2() { // from class: a2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeHeadsUpBlockingScreenKt.m(onEvent, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-1924614791, true, new Function3() { // from class: a2.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeHeadsUpBlockingScreenKt.o(viewState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeN.a(new Function2() { // from class: a2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeHeadsUpBlockingScreenKt.p(viewState, onEvent, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1082166226, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.confirm_blocking.StrictModeHeadsUpBlockingScreen.<anonymous> (StrictModeHeadsUpBlockingScreen.kt:45)");
            }
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: a2.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeHeadsUpBlockingScreenKt.l(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeCommonsKt.n(null, (Function0) objG, null, composer, 6, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(597220977, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.confirm_blocking.StrictModeHeadsUpBlockingScreen.<anonymous> (StrictModeHeadsUpBlockingScreen.kt:57)");
            }
            Modifier modifierM = PaddingKt.m(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(10), 7, null);
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
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Nl, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: a2.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeHeadsUpBlockingScreenKt.n(function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
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
    public static final Unit n(Function1 function1) {
        function1.invoke(StrictModeOptionsViewEvent.OnSaveClicked.f122299a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(StrictModeOptionsViewState strictModeOptionsViewState, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1924614791, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.confirm_blocking.StrictModeHeadsUpBlockingScreen.<anonymous> (StrictModeHeadsUpBlockingScreen.kt:51)");
            }
            h(PaddingKt.h(Modifier.b8, it), strictModeOptionsViewState.d(), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(StrictModeOptionsViewState strictModeOptionsViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        j(strictModeOptionsViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
