package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$FlatButtonsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$FlatButtonsKt f131139a = new ComposableSingletons$FlatButtonsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f131140b = ComposableLambdaKt.c(-2142226617, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.m
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FlatButtonsKt.u((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f131141c = ComposableLambdaKt.c(2101015706, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.r
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FlatButtonsKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f131142d = ComposableLambdaKt.c(-790419745, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.s
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FlatButtonsKt.v((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f131143e = ComposableLambdaKt.c(230125338, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.t
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FlatButtonsKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2101015706, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$FlatButtonsKt.lambda$2101015706.<anonymous> (FlatButtons.kt:420)");
            }
            Modifier.Companion companion = Modifier.b8;
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierI);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            int i4 = R.drawable.k4;
            Integer numValueOf = Integer.valueOf(i4);
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.p();
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.u(modifierH, 0.0f, 0.0f, null, primary, null, "Action Button", null, 0L, numValueOf, null, false, false, (Function0) objG, composer, 1597446, 3078, 6574);
            composer.y();
            Modifier modifierI2 = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierI2);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
            Integer numValueOf2 = Integer.valueOf(i4);
            Object objG2 = composer.G();
            if (objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.q();
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(modifierH2, 0.0f, 0.0f, null, secondary, null, "Action Button", null, 0L, numValueOf2, null, false, false, (Function0) objG2, composer, 1597446, 3078, 6574);
            composer.y();
            Modifier modifierI3 = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion2.o(), false);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierI3);
            Function0 function0A4 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A4);
            } else {
                composer.v();
            }
            Composer composerA4 = Updater.a(composer);
            Updater.e(composerA4, measurePolicyG3, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            Modifier modifierH3 = SizeKt.h(companion, 0.0f, 1, null);
            FlatButtonColors.Disabled disabled = FlatButtonColors.Disabled.f131162a;
            Integer numValueOf3 = Integer.valueOf(i4);
            Object objG3 = composer.G();
            if (objG3 == companion4.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.r();
                    }
                };
                composer.w(objG3);
            }
            FlatButtonsKt.u(modifierH3, 0.0f, 0.0f, null, disabled, null, "Action Button", null, 0L, numValueOf3, null, false, false, (Function0) objG3, composer, 1597446, 3078, 6574);
            composer.y();
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
    public static final Unit p() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(230125338, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$FlatButtonsKt.lambda$230125338.<anonymous> (FlatButtons.kt:624)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(16));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            int i4 = R.drawable.X;
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.t();
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.H(null, 0.0f, "Pause", i4, null, null, (Function0) objG, composer, 1573248, 51);
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
    public static final Unit t() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2142226617, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$FlatButtonsKt.lambda$-2142226617.<anonymous> (FlatButtons.kt:135)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion2.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierD = BackgroundKt.d(companion, ComposeColorsKt.j(composer, 0).e(), null, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierD);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            int i4 = R.drawable.k4;
            FlatButtonsKt.K(companion, 0.0f, i4, FlatButtonColors.Primary.f131166a, "Add", null, composer, 27654, 34);
            composer.y();
            Modifier modifierD2 = BackgroundKt.d(companion, ComposeColorsKt.j(composer, 0).e(), null, 2, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierD2);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            FlatButtonsKt.K(companion, 0.0f, i4, FlatButtonColors.Secondary.f131167a, "Add", null, composer, 27654, 34);
            composer.y();
            Modifier modifierD3 = BackgroundKt.d(companion, ComposeColorsKt.j(composer, 0).e(), null, 2, null);
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion2.o(), false);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierD3);
            Function0 function0A4 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A4);
            } else {
                composer.v();
            }
            Composer composerA4 = Updater.a(composer);
            Updater.e(composerA4, measurePolicyG3, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            FlatButtonsKt.K(companion, 0.0f, i4, FlatButtonColors.Disabled.f131162a, "Add", null, composer, 27654, 34);
            composer.y();
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
    public static final Unit v(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-790419745, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$FlatButtonsKt.lambda$-790419745.<anonymous> (FlatButtons.kt:461)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion2);
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
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion2, Dp.g(f3));
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierI);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            float f4 = 40;
            float fG = Dp.g(f4);
            TextStyle textStyleI = ComposeTypographyKt.g(composer, 0).i();
            int i4 = R.drawable.f95558r0;
            Integer numValueOf = Integer.valueOf(i4);
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.w();
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.u(modifierH, fG, 0.0f, null, null, null, "Primary", textStyleI, 0L, numValueOf, null, false, false, (Function0) objG, composer, 1572918, 3078, 6460);
            composer.y();
            Modifier modifierI2 = PaddingKt.i(companion2, Dp.g(f3));
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierI2);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
            Modifier modifierH2 = SizeKt.h(companion2, 0.0f, 1, null);
            float fG2 = Dp.g(f4);
            TextStyle textStyleI2 = ComposeTypographyKt.g(composer, 0).i();
            Integer numValueOf2 = Integer.valueOf(i4);
            Object objG2 = composer.G();
            if (objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.x();
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(modifierH2, fG2, 0.0f, null, secondary, null, "Secondary", textStyleI2, 0L, numValueOf2, null, false, false, (Function0) objG2, composer, 1597494, 3078, 6444);
            composer.y();
            Modifier modifierI3 = PaddingKt.i(companion2, Dp.g(f3));
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion.o(), false);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierI3);
            Function0 function0A4 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A4);
            } else {
                composer.v();
            }
            Composer composerA4 = Updater.a(composer);
            Updater.e(composerA4, measurePolicyG3, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            FlatButtonColors.Disabled disabled = FlatButtonColors.Disabled.f131162a;
            Modifier modifierH3 = SizeKt.h(companion2, 0.0f, 1, null);
            float fG3 = Dp.g(f4);
            TextStyle textStyleI3 = ComposeTypographyKt.g(composer, 0).i();
            Integer numValueOf3 = Integer.valueOf(i4);
            Object objG3 = composer.G();
            if (objG3 == companion4.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.y();
                    }
                };
                composer.w(objG3);
            }
            FlatButtonsKt.u(modifierH3, fG3, 0.0f, null, disabled, null, "Disabled", textStyleI3, 0L, numValueOf3, null, false, false, (Function0) objG3, composer, 1597494, 3078, 6444);
            composer.y();
            Modifier modifierI4 = PaddingKt.i(companion2, Dp.g(f3));
            MeasurePolicy measurePolicyG4 = BoxKt.g(companion.o(), false);
            int iA5 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU5 = composer.u();
            Modifier modifierF5 = ComposedModifierKt.f(composer, modifierI4);
            Function0 function0A5 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A5);
            } else {
                composer.v();
            }
            Composer composerA5 = Updater.a(composer);
            Updater.e(composerA5, measurePolicyG4, companion3.e());
            Updater.e(composerA5, compositionLocalMapU5, companion3.g());
            Function2 function2B5 = companion3.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                composerA5.w(Integer.valueOf(iA5));
                composerA5.p(Integer.valueOf(iA5), function2B5);
            }
            Updater.e(composerA5, modifierF5, companion3.f());
            float fG4 = Dp.g(f4);
            TextStyle textStyleI4 = ComposeTypographyKt.g(composer, 0).i();
            Integer numValueOf4 = Integer.valueOf(i4);
            Object objG4 = composer.G();
            if (objG4 == companion4.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.z();
                    }
                };
                composer.w(objG4);
            }
            FlatButtonsKt.u(null, fG4, 0.0f, null, null, null, "Primary", textStyleI4, 0L, numValueOf4, null, false, false, (Function0) objG4, composer, 1572912, 3462, 2365);
            composer.y();
            Modifier modifierI5 = PaddingKt.i(companion2, Dp.g(f3));
            MeasurePolicy measurePolicyG5 = BoxKt.g(companion.o(), false);
            int iA6 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU6 = composer.u();
            Modifier modifierF6 = ComposedModifierKt.f(composer, modifierI5);
            Function0 function0A6 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A6);
            } else {
                composer.v();
            }
            Composer composerA6 = Updater.a(composer);
            Updater.e(composerA6, measurePolicyG5, companion3.e());
            Updater.e(composerA6, compositionLocalMapU6, companion3.g());
            Function2 function2B6 = companion3.b();
            if (composerA6.i() || !Intrinsics.areEqual(composerA6.G(), Integer.valueOf(iA6))) {
                composerA6.w(Integer.valueOf(iA6));
                composerA6.p(Integer.valueOf(iA6), function2B6);
            }
            Updater.e(composerA6, modifierF6, companion3.f());
            float fG5 = Dp.g(f4);
            TextStyle textStyleI5 = ComposeTypographyKt.g(composer, 0).i();
            Integer numValueOf5 = Integer.valueOf(i4);
            Object objG5 = composer.G();
            if (objG5 == companion4.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.A();
                    }
                };
                composer.w(objG5);
            }
            FlatButtonsKt.u(null, fG5, 0.0f, null, secondary, null, "Secondary", textStyleI5, 0L, numValueOf5, null, false, false, (Function0) objG5, composer, 1597488, 3462, 2349);
            composer.y();
            Modifier modifierI6 = PaddingKt.i(companion2, Dp.g(f3));
            MeasurePolicy measurePolicyG6 = BoxKt.g(companion.o(), false);
            int iA7 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU7 = composer.u();
            Modifier modifierF7 = ComposedModifierKt.f(composer, modifierI6);
            Function0 function0A7 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A7);
            } else {
                composer.v();
            }
            Composer composerA7 = Updater.a(composer);
            Updater.e(composerA7, measurePolicyG6, companion3.e());
            Updater.e(composerA7, compositionLocalMapU7, companion3.g());
            Function2 function2B7 = companion3.b();
            if (composerA7.i() || !Intrinsics.areEqual(composerA7.G(), Integer.valueOf(iA7))) {
                composerA7.w(Integer.valueOf(iA7));
                composerA7.p(Integer.valueOf(iA7), function2B7);
            }
            Updater.e(composerA7, modifierF7, companion3.f());
            float fG6 = Dp.g(f4);
            TextStyle textStyleI6 = ComposeTypographyKt.g(composer, 0).i();
            Integer numValueOf6 = Integer.valueOf(i4);
            Object objG6 = composer.G();
            if (objG6 == companion4.a()) {
                objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.material3.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$FlatButtonsKt.B();
                    }
                };
                composer.w(objG6);
            }
            FlatButtonsKt.u(null, fG6, 0.0f, null, disabled, null, "Disabled", textStyleI6, 0L, numValueOf6, null, false, false, (Function0) objG6, composer, 1597488, 3462, 2349);
            composer.y();
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
    public static final Unit w() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z() {
        return Unit.f139807a;
    }
}
