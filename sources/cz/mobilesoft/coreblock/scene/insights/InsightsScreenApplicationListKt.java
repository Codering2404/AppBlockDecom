package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewEvent;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class InsightsScreenApplicationListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(int i3, Function1 function1, int i4, Composer composer, int i5) {
        y(i3, function1, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final void B(Composer composer, final int i3) {
        Composer composerK = composer.k(1236336769);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1236336769, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ForwardChevron (InsightsScreenApplicationList.kt:479)");
            }
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95580y1, composerK, 6), StringResources_androidKt.b(R.string.Yf, composerK, 0), SizeKt.o(Modifier.b8, Dp.g(24)), null, null, 0.0f, ColorFilter.Companion.c(ColorFilter.f25730b, ComposeColorsKt.j(composerK, 0).s(), 0, 2, null), composerK, 384, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenApplicationListKt.C(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(int i3, Composer composer, int i4) {
        B(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void D(final cz.mobilesoft.coreblock.enums.AppDistractionType r49, float r50, long r51, long r53, androidx.compose.runtime.Composer r55, final int r56, final int r57) {
        /*
            Method dump skipped, instruction units count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenApplicationListKt.D(cz.mobilesoft.coreblock.enums.AppDistractionType, float, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(AppDistractionType appDistractionType, float f3, long j3, long j4, int i3, int i4, Composer composer, int i5) {
        D(appDistractionType, f3, j3, j4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1906936517);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function1) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1906936517, i4, -1, "cz.mobilesoft.coreblock.scene.insights.LoadMoreAppsButton (InsightsScreenApplicationList.kt:492)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(52)), Dp.g(f3), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierD = BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.a(50)), ComposeColorsKt.j(composerK, 0).l0(), null, 2, null);
            boolean z2 = (i4 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.o0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenApplicationListKt.G(function1);
                    }
                };
                composerK.w(objG);
            }
            float f4 = 4;
            Modifier modifierF2 = boxScopeInstance.f(PaddingKt.j(ClickableKt.f(modifierD, false, null, null, (Function0) objG, 7, null), Dp.g(8), Dp.g(f4)), companion2.e());
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.b(), companion2.i(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.mk, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composer2, 0, 0, 65530);
            SpacerKt.a(SizeKt.A(companion, Dp.g(f4)), composer2, 6);
            IconKt.a(PainterResources_androidKt.c(R.drawable.f95571v1, composer2, 0), null, SizeKt.v(companion, Dp.g(f3)), ComposeColorsKt.j(composer2, 0).q(), composer2, 432, 0);
            composer2.y();
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenApplicationListKt.H(function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnMoreAppsClicked.f102689a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1, int i3, Composer composer, int i4) {
        F(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void J(LazyListScope lazyListScope, InsightsViewState viewState, final Function1 onEvent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        if (viewState.d0()) {
            LazyListScope.c(lazyListScope, "app-feel-banner", null, ComposableLambdaKt.c(-902895091, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.q0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenApplicationListKt.K(onEvent, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-902895091, i3, -1, "cz.mobilesoft.coreblock.scene.insights.appFeelBanner.<anonymous> (InsightsScreenApplicationList.kt:246)");
            }
            ComposeCardsKt.m(SizeKt.h(PaddingKt.j(Modifier.b8, Dp.g(16), Dp.g(8)), 0.0f, 1, null), new CardType.Custom(ComposeColorsKt.j(composer, 0).l0(), null, Dp.d(Dp.g(0)), null, 10, null), null, ComposableLambdaKt.e(740710216, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenApplicationListKt.L(function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3462, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(740710216, i3, -1, "cz.mobilesoft.coreblock.scene.insights.appFeelBanner.<anonymous>.<anonymous> (InsightsScreenApplicationList.kt:256)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH2);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null), Dp.g(f3), Dp.g(f3), 0.0f, Dp.g(f3), 4, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierM);
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
            Updater.e(composerA3, measurePolicyA, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.Cg, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            float f4 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            float fG = Dp.g(32);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            PaddingValues paddingValuesB = PaddingKt.b(Dp.g(f4), Dp.g(6));
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.s0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenApplicationListKt.M(function1);
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.r(null, fG, paddingValuesB, primary, false, false, (Function0) objG, ComposableSingletons$InsightsScreenApplicationListKt.f102561a.k(), composer, 12783024, 17);
            composer.y();
            Modifier modifierB = AspectRatioKt.b(SizeKt.A(companion, Dp.g(118)), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.e(), false);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierB);
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
            Updater.e(composerA4, measurePolicyG2, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            ImageKt.a(PainterResources_androidKt.c(R.drawable.f95505e, composer, 0), null, SizeKt.f(companion, 0.0f, 1, null), null, ContentScale.f27054a.e(), 0.0f, null, composer, 25008, 104);
            composer.y();
            composer.y();
            Modifier modifierF5 = boxScopeInstance.f(companion, companion2.n());
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            String strB = StringResources_androidKt.b(R.string.N7, composer, 0);
            float fG2 = Dp.g(40);
            float fG3 = Dp.g(20);
            long jP = ComposeColorsKt.j(composer, 0).p();
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.t0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenApplicationListKt.N(function1);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.q0(modifierF5, imageVectorB, null, false, fG2, fG3, jP, strB, (Function0) objG2, composer, 221184, 12);
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
    public static final Unit M(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnAppFeelBannerSortAppsClicked.f102673a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function1 function1) {
        function1.invoke(InsightsViewEvent.OnAppFeelBannerDismissed.f102672a);
        return Unit.f139807a;
    }

    public static final void O(LazyListScope lazyListScope, final PackageManager packageManager, final Context context, final InsightsViewState viewState, final List appData, final Function1 onEvent) {
        LazyListScope lazyListScope2;
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        if (appData.isEmpty()) {
            return;
        }
        Iterator it = appData.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (viewState.q0(((AggregatedItemRecord) it.next()).e())) {
                break;
            } else {
                i3++;
            }
        }
        int i4 = i3;
        int i5 = i4 >= 0 ? i4 : 4;
        LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(-1059129294, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.w0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InsightsScreenApplicationListKt.P(onEvent, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        if (viewState.h0() == null || viewState.a0() != InsightsViewState.InsightsPeriodType.Week) {
            lazyListScope2 = lazyListScope;
        } else {
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(-716135932, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.x0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenApplicationListKt.R(viewState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
            lazyListScope2 = lazyListScope;
        }
        final Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.y0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return InsightsScreenApplicationListKt.S(((Integer) obj).intValue(), (AggregatedItemRecord) obj2);
            }
        };
        final int i6 = i5;
        lazyListScope2.h(appData.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsScreenApplicationListKt$applicationList$$inlined$itemsIndexed$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i7) {
                return function2.invoke(Integer.valueOf(i7), appData.get(i7));
            }
        }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsScreenApplicationListKt$applicationList$$inlined$itemsIndexed$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i7) {
                appData.get(i7);
                return null;
            }
        }, ComposableLambdaKt.c(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsScreenApplicationListKt$applicationList$$inlined$itemsIndexed$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i7, Composer composer, int i8) {
                int i9;
                int i10;
                Composer composer2 = composer;
                int i11 = 2;
                if ((i8 & 6) == 0) {
                    i9 = i8 | (composer2.Z(lazyItemScope) ? 4 : 2);
                } else {
                    i9 = i8;
                }
                if ((i8 & 48) == 0) {
                    i9 |= composer2.e(i7) ? 32 : 16;
                }
                if (!composer2.r((i9 & 147) != 146, i9 & 1)) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-1091073711, i9, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                final AggregatedItemRecord aggregatedItemRecord = (AggregatedItemRecord) appData.get(i7);
                composer2.a0(86941836);
                boolean Z = composer2.Z(aggregatedItemRecord.e());
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = viewState.g(packageManager, aggregatedItemRecord.e());
                    composer2.w(objG);
                }
                Pair pair = (Pair) objG;
                String str = (String) pair.a();
                Drawable drawable = (Drawable) pair.b();
                Float fB = viewState.b(aggregatedItemRecord);
                Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierH);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
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
                Updater.e(composerA, measurePolicyA, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                String strG = viewState.G(aggregatedItemRecord.c(), true);
                boolean zI = composer2.I(aggregatedItemRecord) | composer2.I(context) | composer2.Z(viewState);
                Object objG2 = composer2.G();
                if (zI || objG2 == Composer.f23746a.a()) {
                    final Context context2 = context;
                    final InsightsViewState insightsViewState = viewState;
                    objG2 = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.insights.InsightsScreenApplicationListKt$applicationList$4$2$1$1
                        public final void c() {
                            AnswersHelper answersHelper = AnswersHelper.f128199a;
                            String strE = aggregatedItemRecord.e();
                            String lowerCase = InsightsViewStateKt.a(aggregatedItemRecord).name().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            answersHelper.l2(strE, aggregatedItemRecord.b(), lowerCase);
                            Context context3 = context2;
                            context3.startActivity(InsightsActivity.f102590g.a(context3, aggregatedItemRecord.e(), insightsViewState.a0()));
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            c();
                            return Unit.f139807a;
                        }
                    };
                    composer2.w(objG2);
                }
                int i12 = 1;
                float f3 = 0.0f;
                Object obj = null;
                InsightsScreenApplicationListKt.u(strG, aggregatedItemRecord, fB, str, drawable, false, (Function0) objG2, composer2, 0, 32);
                Map mapL0 = viewState.l0();
                List list = mapL0 != null ? (List) mapL0.get(aggregatedItemRecord.e()) : null;
                if (list == null) {
                    composer2.a0(-2069744267);
                    composer2.U();
                    i10 = 0;
                } else {
                    composer2.a0(-2069744266);
                    composer2.a0(71783451);
                    int iMin = Math.min(list.size(), 5);
                    int i13 = 0;
                    while (i13 < iMin) {
                        AggregatedItemRecord aggregatedItemRecord2 = (AggregatedItemRecord) list.get(i13);
                        Modifier.Companion companion2 = Modifier.b8;
                        Modifier modifierK = PaddingKt.k(PaddingKt.m(SizeKt.h(companion2, f3, i12, obj), Dp.g(64), 0.0f, Dp.g(40), 0.0f, 10, null), f3, Dp.g(i11), i12, obj);
                        MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer2, 48);
                        int iA2 = ComposablesKt.a(composer2, 0);
                        CompositionLocalMap compositionLocalMapU2 = composer2.u();
                        Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierK);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                        Function0 function0A2 = companion3.a();
                        if (composer2.m() == null) {
                            ComposablesKt.c();
                        }
                        composer2.L();
                        if (composer2.i()) {
                            composer2.P(function0A2);
                        } else {
                            composer2.v();
                        }
                        Composer composerA2 = Updater.a(composer2);
                        Updater.e(composerA2, measurePolicyB, companion3.e());
                        Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                        Function2 function2B2 = companion3.b();
                        if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                            composerA2.w(Integer.valueOf(iA2));
                            composerA2.p(Integer.valueOf(iA2), function2B2);
                        }
                        Updater.e(composerA2, modifierF2, companion3.f());
                        RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                        BaseWebsiteSelectionScreenKt.D(aggregatedItemRecord2.e(), ClipKt.a(SizeKt.v(companion2, Dp.g(16)), RoundedCornerShapeKt.d(Dp.g(4))), composer2, 0, 0);
                        SpacerKt.a(SizeKt.A(companion2, Dp.g(6)), composer2, 6);
                        TextKt.c(aggregatedItemRecord2.e(), null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 0, 0, 65530);
                        SpacerKt.a(RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), composer, 0);
                        TextKt.c(InsightsViewState.H(viewState, aggregatedItemRecord2.c(), false, 2, null), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
                        composer2 = composer;
                        composer2.y();
                        i13++;
                        list = list;
                        f3 = f3;
                        iMin = iMin;
                        i11 = 2;
                        obj = obj;
                        i12 = i12;
                    }
                    i10 = 0;
                    composer2.U();
                    Unit unit = Unit.f139807a;
                    composer2.U();
                }
                if (i7 == i6 && viewState.e0()) {
                    composer2.a0(-2068131925);
                    InsightsWebTrackingPermissionCardKt.d(onEvent, composer2, i10);
                } else {
                    composer2.a0(-2076562623);
                }
                composer2.U();
                composer2.y();
                composer2.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        if (i4 < 0 && viewState.e0() && appData.size() < 5) {
            LazyListScope.c(lazyListScope2, null, null, ComposableLambdaKt.c(83438597, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.z0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenApplicationListKt.T(onEvent, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        if (viewState.p()) {
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(883013126, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.a1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenApplicationListKt.U(onEvent, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
            return;
        }
        if (viewState.B() == null || !(!r0.isEmpty())) {
            return;
        }
        LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(-1252589713, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.b1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InsightsScreenApplicationListKt.V(viewState, onEvent, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1059129294, i3, -1, "cz.mobilesoft.coreblock.scene.insights.applicationList.<anonymous> (InsightsScreenApplicationList.kt:85)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Object objG = composer.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = InteractionSourceKt.a();
                composer.w(objG);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
            boolean Z = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z || objG2 == companion2.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.l0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenApplicationListKt.Q(function1);
                    }
                };
                composer.w(objG2);
            }
            Modifier modifierD = ClickableKt.d(modifierH, mutableInteractionSource, null, false, null, null, (Function0) objG2, 28, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
            SpacerKt.a(SizeKt.v(companion, Dp.g(24)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.rA, composer, 0), PaddingKt.m(companion, Dp.g(16), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 48, 0, 65532);
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
    public static final Unit Q(Function1 function1) {
        function1.invoke(new InsightsViewEvent.OnBarSelected(null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(InsightsViewState insightsViewState, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-716135932, i3, -1, "cz.mobilesoft.coreblock.scene.insights.applicationList.<anonymous> (InsightsScreenApplicationList.kt:112)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, Dp.g(40), 0.0f, 10, null), 0.0f, Dp.g(f3), 0.0f, Dp.g(8), 5, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 48);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            TextKt.c(StringResources_androidKt.b(R.string.uA, composer, 0), RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65016);
            TextKt.c(InsightsViewState.H(insightsViewState, insightsViewState.h0().longValue(), false, 2, null), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
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
    public static final Object S(int i3, AggregatedItemRecord item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(83438597, i3, -1, "cz.mobilesoft.coreblock.scene.insights.applicationList.<anonymous> (InsightsScreenApplicationList.kt:215)");
            }
            InsightsWebTrackingPermissionCardKt.d(function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(883013126, i3, -1, "cz.mobilesoft.coreblock.scene.insights.applicationList.<anonymous> (InsightsScreenApplicationList.kt:223)");
            }
            F(function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(InsightsViewState insightsViewState, Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1252589713, i3, -1, "cz.mobilesoft.coreblock.scene.insights.applicationList.<anonymous> (InsightsScreenApplicationList.kt:229)");
            }
            y(insightsViewState.B().size(), function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void u(final java.lang.String r73, final cz.mobilesoft.statistics.model.AggregatedItemRecord r74, java.lang.Float r75, final java.lang.String r76, final android.graphics.drawable.Drawable r77, boolean r78, kotlin.jvm.functions.Function0 r79, androidx.compose.runtime.Composer r80, final int r81, final int r82) {
        /*
            Method dump skipped, instruction units count: 1673
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenApplicationListKt.u(java.lang.String, cz.mobilesoft.statistics.model.AggregatedItemRecord, java.lang.Float, java.lang.String, android.graphics.drawable.Drawable, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(String str, AggregatedItemRecord aggregatedItemRecord, Float f3, String str2, Drawable drawable, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        u(str, aggregatedItemRecord, f3, str2, drawable, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void y(final int i3, final Function1 function1, Composer composer, final int i4) {
        int i5;
        Composer composerK = composer.k(758733581);
        if ((i4 & 6) == 0) {
            i5 = (composerK.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(758733581, i5, -1, "cz.mobilesoft.coreblock.scene.insights.ExcludedAppsButton (InsightsScreenApplicationList.kt:532)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(56));
            boolean z2 = (i5 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.c1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenApplicationListKt.z(function1);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierK = PaddingKt.k(ClickableKt.f(modifierI, false, null, null, (Function0) objG, 7, null), Dp.g(16), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierC = BackgroundKt.c(SizeKt.v(companion, Dp.g(32)), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(Dp.g(8)));
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierC);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.H3, composerK, 6), null, BoxScopeInstance.f6642a.f(SizeKt.v(companion, Dp.g(24)), companion2.e()), 0L, composerK, 48, 8);
            composerK.y();
            TextKt.c(StringHelperExtKt.q(StringResources_androidKt.b(R.string.Lg, composerK, 0), String.valueOf(i3), null, 2, null), PaddingKt.m(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 1, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 3120, 55288);
            composerK = composerK;
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            B(composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenApplicationListKt.A(i3, function1, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function1 function1) {
        function1.invoke(InsightsViewEvent.ShowExcludedAppsBottomSheet.f102696a);
        return Unit.f139807a;
    }
}
