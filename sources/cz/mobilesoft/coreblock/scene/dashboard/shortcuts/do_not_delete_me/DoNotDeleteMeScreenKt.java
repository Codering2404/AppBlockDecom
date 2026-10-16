package cz.mobilesoft.coreblock.scene.dashboard.shortcuts.do_not_delete_me;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.do_not_delete_me.DoNotDeleteMeScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class DoNotDeleteMeScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Brush f101478a = Brush.Companion.e(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(ColorKt.d(4281648985L)), Color.n(ColorKt.d(4278811776L))}), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L)), 0, 8, null);

    public static final void c(final Function0 onKeepClicked, final Function0 onUnlockAllClicked, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onKeepClicked, "onKeepClicked");
        Intrinsics.checkNotNullParameter(onUnlockAllClicked, "onUnlockAllClicked");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-1678266870);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onKeepClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onUnlockAllClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onCloseClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1678266870, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.shortcuts.do_not_delete_me.DoNotDeleteMeScreen (DoNotDeleteMeScreen.kt:43)");
            }
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-134867908, true, new Function3() { // from class: u0.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DoNotDeleteMeScreenKt.d(onCloseClicked, onKeepClicked, onUnlockAllClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: u0.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DoNotDeleteMeScreenKt.e(onKeepClicked, onUnlockAllClicked, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function0 function0, Function0 function02, Function0 function03, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-134867908, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.shortcuts.do_not_delete_me.DoNotDeleteMeScreen.<anonymous> (DoNotDeleteMeScreen.kt:45)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.f(companion, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            ToolbarKt.e(null, function0, null, false, ToolbarButtonType.Close, false, false, null, null, composer, 221184, 461);
            float f3 = 24;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.xc, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            long jP = ComposeColorsKt.j(composer, 0).p();
            FontWeight.Companion companion3 = FontWeight.f29233b;
            FontWeight fontWeightB = companion3.b();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, SizeKt.h(companion, 0.0f, 1, null), jP, 0L, null, fontWeightB, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 196656, 0, 64984);
            float f4 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.wc, composer, 0), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65016);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            TextKt.c("2.5", null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, new TextStyle(f101478a, 0.0f, TextUnitKt.i(140), companion3.a(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(140), null, null, null, 0, 0, null, 33292274, null), composer, 6, 0, 65022);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            String strB2 = StringResources_androidKt.b(R.string.tH, composer, 0);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = strB2.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.c(upperCase, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, companion3.b(), null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 196608, 0, 64986);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.z2, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65018);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Primary.f131166a, null, StringResources_androidKt.b(R.string.fi, composer, 0), null, 0L, null, null, false, false, function02, composer, 24576, 0, 8111);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(R.string.kF, composer, 0), null, 0L, null, null, false, false, function03, composer, 24576, 0, 8111);
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
    public static final Unit e(Function0 function0, Function0 function02, Function0 function03, int i3, Composer composer, int i4) {
        c(function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
