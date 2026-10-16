package cz.mobilesoft.coreblock.scene.intro.strictmode;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
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
public final class RecommendedUnlocksScreenKt {
    public static final void d(final Function0 onContinueClicked, Function0 onOtherMethodsClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Intrinsics.checkNotNullParameter(onOtherMethodsClicked, "onOtherMethodsClicked");
        Composer composerK = composer.k(1553546445);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.I(onContinueClicked) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onOtherMethodsClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1553546445, i4, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.RecommendedUnlocksScreen (RecommendedUnlocksScreen.kt:31)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierG = ScrollKt.g(SizeKt.f(companion, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
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
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(R.string.pz, composerK, 0);
            TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composerK, 0).e(), 0L, TextUnitKt.i(28), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null);
            long jL = ComposeColorsKt.j(composerK, 0).L();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            float f3 = 16;
            int i5 = i4;
            TextKt.c(strB, PaddingKt.m(companion, Dp.g(f3), Dp.g(32), Dp.g(f3), 0.0f, 8, null), jL, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleE, composerK, 0, 0, 65016);
            float f4 = 8;
            TextKt.c(StringResources_androidKt.b(R.string.oz, composerK, 0), PaddingKt.m(companion, Dp.g(f3), Dp.g(f4), Dp.g(f3), 0.0f, 8, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65016);
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = arrangement.b();
            Alignment.Horizontal horizontalG2 = companion2.g();
            Modifier modifierB = ColumnScope.b(columnScopeInstance, SizeKt.f(companion, 0.0f, 1, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(horizontalOrVerticalB, horizontalG2, composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierB);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ImageKt.a(PainterResources_androidKt.c(R.drawable.f95518h0, composerK, 0), null, SizeKt.v(companion, Dp.g(72)), null, null, 0.0f, null, composerK, 432, 120);
            float f5 = 4;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f5)), composerK, 6);
            int i6 = R.string.s8;
            TextKt.c(StringResources_androidKt.b(i6, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 0, 0, 65018);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f5)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Qy, composerK, 0), PaddingKt.m(companion, Dp.g(f3), Dp.g(f4), Dp.g(f3), 0.0f, 8, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65016);
            composerK.y();
            String strQ = StringHelperExtKt.q(StringResources_androidKt.b(R.string.m8, composerK, 0), StringResources_androidKt.b(i6, composerK, 0), null, 2, null);
            boolean z2 = (i5 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecommendedUnlocksScreenKt.e(onContinueClicked);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.J(null, strQ, false, false, null, (Function0) objG, composerK, 0, 29);
            composerK = composerK;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composerK, 6);
            String strB2 = StringResources_androidKt.b(R.string.nz, composerK, 0);
            boolean z3 = (i5 & 112) == 32;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                function0 = onOtherMethodsClicked;
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecommendedUnlocksScreenKt.f(function0);
                    }
                };
                composerK.w(objG2);
            } else {
                function0 = onOtherMethodsClicked;
            }
            ComposeButtonsV2Kt.d(null, strB2, (Function0) objG2, composerK, 0, 1);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composerK, 6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onOtherMethodsClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecommendedUnlocksScreenKt.g(onContinueClicked, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        d(function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
