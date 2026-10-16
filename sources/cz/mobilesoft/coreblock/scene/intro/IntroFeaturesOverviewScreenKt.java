package cz.mobilesoft.coreblock.scene.intro;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.intro.question.ExplanationScreenKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.IconedRowKt;
import cz.mobilesoft.coreblock.view.compose.SplashContentKt;
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
public final class IntroFeaturesOverviewScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 function0, Function0 function02, Composer composer, final int i3) {
        int i4;
        final Function0 function03;
        final Function0 function04;
        Composer composerK = composer.k(-336664768);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function02) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-336664768, i4, -1, "cz.mobilesoft.coreblock.scene.intro.Content (IntroFeaturesOverviewScreen.kt:56)");
            }
            int i5 = i4 << 9;
            function03 = function0;
            function04 = function02;
            ExplanationScreenKt.e(StringResources_androidKt.c(R.string.Nh, new Object[]{3}, composerK, 0), null, StringResources_androidKt.b(R.string.l8, composerK, 0), function03, function04, ComposableSingletons$IntroFeaturesOverviewScreenKt.f104468a.e(), composerK, (i5 & 7168) | 196608 | (i5 & 57344), 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function03 = function0;
            function04 = function02;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroFeaturesOverviewScreenKt.e(function03, function04, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        d(function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void f(final Function0 onContinueClicked, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(1774915435);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onContinueClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1774915435, i4, -1, "cz.mobilesoft.coreblock.scene.intro.IntroFeaturesOverviewScreen (IntroFeaturesOverviewScreen.kt:38)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            Unit unit = Unit.f139807a;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new IntroFeaturesOverviewScreenKt$IntroFeaturesOverviewScreen$1$1(mutableState, null);
                composerK.w(objG2);
            }
            EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            if (g(mutableState)) {
                composerK.a0(1163596797);
                d(onContinueClicked, onCloseClicked, composerK, i4 & 126);
                composerK.U();
            } else {
                composerK.a0(1163663261);
                SplashContentKt.c(StringResources_androidKt.c(R.string.Mf, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composerK, 0)}, composerK, 0), false, composerK, 0, 2);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroFeaturesOverviewScreenKt.i(onContinueClicked, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean g(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        f(function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Composer composer, final int i3) {
        Composer composerK = composer.k(-117571535);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-117571535, i3, -1, "cz.mobilesoft.coreblock.scene.intro.OverviewContent (IntroFeaturesOverviewScreen.kt:68)");
            }
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Modifier modifierM = PaddingKt.m(PaddingKt.k(Modifier.b8, Dp.g(22), 0.0f, 2, null), 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, Alignment.f25072a.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            ImageVector.Companion companion2 = ImageVector.f26323k;
            IconedRowKt.b(VectorResources_androidKt.b(companion2, R.drawable.G4, composerK, 6), ComposeColorsKt.j(composerK, 0).b(), null, null, StringResources_androidKt.b(R.string.zD, composerK, 0), StringResources_androidKt.b(R.string.Qh, composerK, 0), null, 0.0f, composerK, 0, 204);
            IconedRowKt.b(VectorResources_androidKt.b(companion2, R.drawable.X4, composerK, 6), ColorKt.d(4294939904L), null, null, StringResources_androidKt.b(R.string.uv, composerK, 0), StringResources_androidKt.b(R.string.Kh, composerK, 0), null, 0.0f, composerK, 48, 204);
            IconedRowKt.b(VectorResources_androidKt.b(companion2, R.drawable.T5, composerK, 6), ColorKt.d(4294927748L), null, null, StringResources_androidKt.b(R.string.PD, composerK, 0), StringResources_androidKt.b(R.string.Mh, composerK, 0), null, 0.0f, composerK, 48, 204);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroFeaturesOverviewScreenKt.k(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(int i3, Composer composer, int i4) {
        j(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
