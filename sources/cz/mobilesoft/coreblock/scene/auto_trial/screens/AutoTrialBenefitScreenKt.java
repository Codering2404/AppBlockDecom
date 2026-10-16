package cz.mobilesoft.coreblock.scene.auto_trial.screens;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class AutoTrialBenefitScreenKt {
    public static final void f(final String title, final String subtitle, final int i3, final Function0 onNext, final Function0 onClose, Composer composer, final int i4) {
        int i5;
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(onNext, "onNext");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerK = composer.k(527379041);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(title) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.Z(subtitle) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 = i3;
            i5 |= composerK.e(i6) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            i6 = i3;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(onNext) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.I(onClose) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(527379041, i5, -1, "cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialBenefitScreen (AutoTrialBenefitScreen.kt:47)");
            }
            final int i7 = i6;
            composer2 = composerK;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-1511229037, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.screens.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AutoTrialBenefitScreenKt.g(onClose, onNext, title, subtitle, i7, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.screens.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoTrialBenefitScreenKt.k(title, subtitle, i3, onNext, onClose, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(final Function0 function0, final Function0 function02, final String str, final String str2, final int i3, BoxScope GradientBox, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1511229037, i4, -1, "cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialBenefitScreen.<anonymous> (AutoTrialBenefitScreen.kt:49)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), null, ComposableLambdaKt.e(-1058916456, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.screens.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoTrialBenefitScreenKt.h(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(413362137, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.screens.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoTrialBenefitScreenKt.i(function02, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(1948318161, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.screens.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AutoTrialBenefitScreenKt.j(str, str2, i3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3456, 12779520, 98290);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1058916456, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialBenefitScreen.<anonymous>.<anonymous> (AutoTrialBenefitScreen.kt:53)");
            }
            ToolbarKt.e(null, function0, null, false, ToolbarButtonType.Close, false, false, ComposableSingletons$AutoTrialBenefitScreenKt.f98983a.e(), null, composer, 14180352, 301);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(413362137, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialBenefitScreen.<anonymous>.<anonymous> (AutoTrialBenefitScreen.kt:70)");
            }
            FlatButtonsKt.p(null, false, StringResources_androidKt.b(R.string.Gk, composer, 0), false, function0, composer, 0, 11);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(String str, String str2, int i3, PaddingValues paddingValues, Composer composer, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i4 & 6) == 0) {
            i5 = i4 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i5 = i4;
        }
        if (composer.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1948318161, i5, -1, "cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialBenefitScreen.<anonymous>.<anonymous> (AutoTrialBenefitScreen.kt:76)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(PaddingKt.h(SizeKt.f(companion, 0.0f, 1, null), paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            TextKt.c(str, null, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            TextKt.c(str2, null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer, 6);
            ImageKt.a(PainterResources_androidKt.c(i3, composer, 0), null, ColumnScope.b(columnScopeInstance, SizeKt.h(companion, 0.0f, 1, null), 1.0f, false, 2, null), null, ContentScale.f27054a.e(), 0.0f, null, composer, 24624, 104);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
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
    public static final Unit k(String str, String str2, int i3, Function0 function0, Function0 function02, int i4, Composer composer, int i5) {
        f(str, str2, i3, function0, function02, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }
}
