package cz.mobilesoft.coreblock.scene.sharing;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.images.components.FixedCanvasKt;
import cz.mobilesoft.coreblock.scene.sharing.images.components.TransparentPreviewCheckerboardKt;
import cz.mobilesoft.coreblock.scene.sharing.images.screentime.ScreenTimeImageKt;
import cz.mobilesoft.coreblock.scene.sharing.images.screentime.TransparentScreenTimeImageKt;
import cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.TransparentUpsDownsImageKt;
import cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.UpsDownsImageKt;
import cz.mobilesoft.coreblock.scene.sharing.images.weekly_report.WeeklyReportImageKt;
import cz.mobilesoft.coreblock.scene.sharing.intents.ShareAppItemKt;
import cz.mobilesoft.coreblock.scene.sharing.intents.ShareableAppInfo;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SocialSharingScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119355a;

        static {
            int[] iArr = new int[SocialShareTemplate.values().length];
            try {
                iArr[SocialShareTemplate.ScreenTimeSquare.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SocialShareTemplate.ScreenTimePortrait.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SocialShareTemplate.UpsDownsSquare.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SocialShareTemplate.UpsDownsPortrait.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SocialShareTemplate.ScreenTimeTransparent.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SocialShareTemplate.UpsDownsTransparent.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SocialShareTemplate.WeeklyReportPortrait.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f119355a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(ShareableAppInfo shareableAppInfo, CoroutineScope coroutineScope, Context context, View view, SocialShareTemplate socialShareTemplate, SocialsSharingViewState socialsSharingViewState) {
        AnswersHelper.f128199a.C6(shareableAppInfo.d());
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new SocialSharingScreenKt$SocialSharingScreen$6$1$3$1$1$1$1$1(context, view, socialShareTemplate, socialsSharingViewState, shareableAppInfo, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(List list, PagerState pagerState, CoroutineScope coroutineScope, Context context, View view, SocialsSharingViewState socialsSharingViewState) {
        AnswersHelper.f128199a.C6("download");
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new SocialSharingScreenKt$SocialSharingScreen$6$1$3$1$2$1$1(context, view, (SocialShareTemplate) list.get(pagerState.v()), socialsSharingViewState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(CoroutineScope coroutineScope, Context context, View view, SocialShareTemplate socialShareTemplate, SocialsSharingViewState socialsSharingViewState) {
        AnswersHelper.f128199a.C6("copy");
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new SocialSharingScreenKt$SocialSharingScreen$6$1$3$1$3$1$1(context, view, socialShareTemplate, socialsSharingViewState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(List list, PagerState pagerState, CoroutineScope coroutineScope, Context context, View view, SocialsSharingViewState socialsSharingViewState) {
        AnswersHelper.f128199a.C6("more");
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new SocialSharingScreenKt$SocialSharingScreen$6$1$3$1$4$1$1(context, view, (SocialShareTemplate) list.get(pagerState.v()), socialsSharingViewState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(PaddingValues paddingValues, SocialsSharingViewState socialsSharingViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        p(paddingValues, socialsSharingViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void p(final PaddingValues paddingValues, final SocialsSharingViewState viewState, final Function1 onEvent, final Function0 onCloseClick, Composer composer, final int i3) {
        int i4;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Composer composerK = composer.k(1530972943);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onCloseClick) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1530972943, i5, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreen (SocialSharingScreen.kt:69)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final View view = (View) composerK.q(AndroidCompositionLocals_androidKt.j());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            long jA = ((WindowInfo) composerK.q(CompositionLocalsKt.u())).a();
            int i6 = (int) (jA & 4294967295L);
            boolean z2 = ((int) (jA >> 32)) > i6;
            final float fG = Dp.g(((Density) composerK.q(CompositionLocalsKt.f())).F(i6) * 0.4f);
            final List listC = viewState.c();
            if (listC.isEmpty()) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SocialSharingScreenKt.q(paddingValues, viewState, onEvent, onCloseClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            boolean zI = composerK.I(listC);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.sharing.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(SocialSharingScreenKt.r(listC));
                    }
                };
                composerK.w(objG2);
            }
            final boolean z3 = z2;
            final PagerState pagerStateL = PagerStateKt.l(0, 0.0f, (Function0) objG2, composerK, 0, 3);
            Integer numValueOf = Integer.valueOf(viewState.e());
            boolean Z = composerK.Z(pagerStateL) | ((i5 & 112) == 32);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion.a()) {
                objG3 = new SocialSharingScreenKt$SocialSharingScreen$2$1(pagerStateL, viewState, null);
                composerK.w(objG3);
            }
            EffectsKt.g(numValueOf, (Function2) objG3, composerK, 0);
            Integer numValueOf2 = Integer.valueOf(listC.size());
            boolean Z2 = composerK.Z(pagerStateL) | composerK.I(listC);
            Object objG4 = composerK.G();
            if (Z2 || objG4 == companion.a()) {
                objG4 = new SocialSharingScreenKt$SocialSharingScreen$3$1(pagerStateL, listC, null);
                composerK.w(objG4);
            }
            EffectsKt.g(numValueOf2, (Function2) objG4, composerK, 0);
            Integer numValueOf3 = Integer.valueOf(pagerStateL.v());
            boolean Z3 = ((i5 & 896) == 256) | composerK.Z(pagerStateL);
            Object objG5 = composerK.G();
            if (Z3 || objG5 == companion.a()) {
                objG5 = new SocialSharingScreenKt$SocialSharingScreen$4$1(onEvent, pagerStateL, null);
                composerK.w(objG5);
            }
            EffectsKt.g(numValueOf3, (Function2) objG5, composerK, 0);
            long jE = ComposeColorsKt.j(composerK, 0).e();
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(676043723, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialSharingScreenKt.s(onCloseClick, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54);
            composerK = composerK;
            ScaffoldKt.a(null, composableLambdaE, null, null, null, 0, jE, 0L, null, ComposableLambdaKt.e(-676932064, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.sharing.l
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialSharingScreenKt.t(paddingValues, z3, fG, listC, pagerStateL, viewState, coroutineScope, context, view, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 805306416, 445);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialSharingScreenKt.E(paddingValues, viewState, onEvent, onCloseClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(PaddingValues paddingValues, SocialsSharingViewState socialsSharingViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        p(paddingValues, socialsSharingViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int r(List list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(676043723, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreen.<anonymous> (SocialSharingScreen.kt:101)");
            }
            ToolbarKt.e(null, function0, StringResources_androidKt.b(R.string.Hw, composer, 0), false, null, false, false, null, null, composer, 0, 505);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(PaddingValues paddingValues, final boolean z2, float f3, final List list, final PagerState pagerState, final SocialsSharingViewState socialsSharingViewState, final CoroutineScope coroutineScope, final Context context, final View view, PaddingValues scaffoldPadding, Composer composer, int i3) {
        int i4;
        Modifier.Companion companion;
        Modifier modifierH;
        long jQ;
        Intrinsics.checkNotNullParameter(scaffoldPadding, "scaffoldPadding");
        int i5 = (i3 & 6) == 0 ? i3 | (composer.Z(scaffoldPadding) ? 4 : 2) : i3;
        if (composer.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-676932064, i5, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreen.<anonymous> (SocialSharingScreen.kt:107)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            float f4 = 16;
            Modifier modifierF = SizeKt.f(PaddingKt.k(PaddingKt.h(PaddingKt.h(companion2, paddingValues), scaffoldPadding), 0.0f, Dp.g(f4), 1, null), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f4));
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion3.g(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (z2) {
                modifierH = ColumnScope.b(columnScopeInstance, SizeKt.k(SizeKt.h(companion2, 0.0f, 1, null), 0.0f, f3, 1, null), 1.0f, false, 2, null);
                companion = companion2;
                i4 = 54;
            } else {
                i4 = 54;
                companion = companion2;
                modifierH = SizeKt.h(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), 0.0f, 1, null);
            }
            BoxWithConstraintsKt.a(modifierH, companion3.e(), false, ComposableLambdaKt.e(-1699325716, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.sharing.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialSharingScreenKt.u(z2, pagerState, list, socialsSharingViewState, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, i4), composer, 3120, 4);
            final SocialShareTemplate socialShareTemplate = (SocialShareTemplate) list.get(pagerState.v());
            TextKt.c(F(socialShareTemplate, composer, 0), PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 48, 0, 65016);
            Modifier modifierH2 = SizeKt.h(SizeKt.E(companion, null, false, 3, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.b(), companion3.l(), composer, 6);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierH2);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer.a0(-1250617579);
            int iH = pagerState.H();
            for (int i6 = 0; i6 < iH; i6++) {
                if (pagerState.v() == i6) {
                    composer.a0(746034158);
                    jQ = ComposeColorsKt.j(composer, 0).L();
                } else {
                    composer.a0(746034711);
                    jQ = ComposeColorsKt.j(composer, 0).q();
                }
                composer.U();
                BoxKt.a(SizeKt.v(BackgroundKt.d(ClipKt.a(PaddingKt.i(Modifier.b8, Dp.g(3)), RoundedCornerShapeKt.g()), jQ, null, 2, null), Dp.g(8)), composer, 0);
            }
            composer.U();
            composer.y();
            final List listG = socialsSharingViewState.g();
            BoxWithConstraintsKt.a(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(f4), 0.0f, 2, null), null, false, ComposableLambdaKt.e(663942115, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.sharing.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialSharingScreenKt.y(listG, list, pagerState, coroutineScope, context, view, socialsSharingViewState, socialShareTemplate, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3078, 6);
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
    public static final Unit u(boolean z2, PagerState pagerState, final List list, final SocialsSharingViewState socialsSharingViewState, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1699325716, i4, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreen.<anonymous>.<anonymous>.<anonymous> (SocialSharingScreen.kt:128)");
            }
            PagerKt.a(pagerState, SizeKt.f(Modifier.b8, 0.0f, 1, null), PaddingKt.c(z2 ? ((Dp) ComparisonsKt.k(Dp.d(Dp.g(Dp.g(BoxWithConstraints.d() - Dp.g(Dp.g(BoxWithConstraints.g() * 0.5625f) / 0.75f)) / 2)), Dp.d(Dp.g(0)))).l() : Dp.g(BoxWithConstraints.d() * 0.15f), 0.0f, 2, null), null, 1, Dp.g(12), null, null, false, false, null, null, null, null, ComposableLambdaKt.e(-315832275, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.sharing.q
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return SocialSharingScreenKt.v(list, socialsSharingViewState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer, 54), composer, 221232, 24576, 16328);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(final List list, final SocialsSharingViewState socialsSharingViewState, PagerScope HorizontalPager, final int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.M()) {
            ComposerKt.U(-315832275, i4, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SocialSharingScreen.kt:146)");
        }
        BoxWithConstraintsKt.a(SizeKt.f(Modifier.b8, 0.0f, 1, null), Alignment.f25072a.e(), false, ComposableLambdaKt.e(1839357955, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.sharing.r
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SocialSharingScreenKt.w(list, i3, socialsSharingViewState, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3126, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(List list, int i3, final SocialsSharingViewState socialsSharingViewState, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i4) {
        int i5;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i4 & 6) == 0) {
            i5 = i4 | (composer2.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i5 = i4;
        }
        if (composer2.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1839357955, i5, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SocialSharingScreen.kt:150)");
            }
            final SocialShareTemplate socialShareTemplate = (SocialShareTemplate) list.get(i3);
            float previewAspectRatio = socialShareTemplate.getFormat().getPreviewAspectRatio();
            float fL = ((Dp) ComparisonsKt.m(Dp.d(BoxWithConstraints.d()), Dp.d(Dp.g(BoxWithConstraints.g() * previewAspectRatio)))).l();
            float fG = Dp.g(fL / previewAspectRatio);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierA = ClipKt.a(SizeKt.x(companion, fL, fG), RoundedCornerShapeKt.d(Dp.g(24)));
            SocialShareTemplate.Format format = socialShareTemplate.getFormat();
            SocialShareTemplate.Format format2 = SocialShareTemplate.Format.Transparent;
            Modifier modifierB = TransparentPreviewCheckerboardKt.b(modifierA, format == format2);
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierF);
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
            Updater.e(composerA, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierB);
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
            Updater.e(composerA2, measurePolicyG2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            FixedCanvasKt.e(SizeKt.f(companion, 0.0f, 1, null), socialShareTemplate, ComposableLambdaKt.e(-1301121266, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialSharingScreenKt.x(socialShareTemplate, socialsSharingViewState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, 390, 0);
            if (socialShareTemplate.getFormat() == format2) {
                composer2.a0(-1484809226);
                String strB = StringResources_androidKt.b(R.string.cE, composer2, 0);
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String upperCase = strB.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                float f3 = 4;
                TextKt.c(upperCase, PaddingKt.k(BorderKt.f(PaddingKt.i(boxScopeInstance.f(companion, companion2.o()), Dp.g(16)), Dp.g(1), Color.f25715b.l(), RoundedCornerShapeKt.d(Dp.g(f3))), Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer2, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).k(), composer, 0, 0, 65528);
                composer2 = composer;
            } else {
                composer2.a0(-1496866893);
            }
            composer2.U();
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(SocialShareTemplate socialShareTemplate, SocialsSharingViewState socialsSharingViewState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1301121266, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SocialSharingScreen.kt:167)");
            }
            switch (WhenMappings.f119355a[socialShareTemplate.ordinal()]) {
                case 1:
                    composer.a0(-542048102);
                    ScreenTimeImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialShareTemplate, socialsSharingViewState.f(), socialsSharingViewState.h(), socialsSharingViewState.d(), composer, (SocialsSharePayload.f119374r << 6) | 6, 0);
                    composer.U();
                    break;
                case 2:
                    composer.a0(-542028422);
                    ScreenTimeImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialShareTemplate, socialsSharingViewState.f(), socialsSharingViewState.h(), socialsSharingViewState.d(), composer, (SocialsSharePayload.f119374r << 6) | 6, 0);
                    composer.U();
                    break;
                case 3:
                    composer.a0(-542008971);
                    UpsDownsImageKt.e(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialShareTemplate, socialsSharingViewState.f(), socialsSharingViewState.h(), composer, (SocialsSharePayload.f119374r << 6) | 6, 0);
                    composer.U();
                    break;
                case 4:
                    composer.a0(-541992587);
                    UpsDownsImageKt.e(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialShareTemplate, socialsSharingViewState.f(), socialsSharingViewState.h(), composer, (SocialsSharePayload.f119374r << 6) | 6, 0);
                    composer.U();
                    break;
                case 5:
                    composer.a0(-541976107);
                    TransparentScreenTimeImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialsSharingViewState.f(), socialsSharingViewState.h(), composer, (SocialsSharePayload.f119374r << 3) | 6, 0);
                    composer.U();
                    break;
                case 6:
                    composer.a0(-541961677);
                    TransparentUpsDownsImageKt.b(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialsSharingViewState.f(), socialsSharingViewState.h(), composer, (SocialsSharePayload.f119374r << 3) | 6, 0);
                    composer.U();
                    break;
                case 7:
                    composer.a0(-541947185);
                    WeeklyReportImageKt.c(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialsSharingViewState.f(), socialsSharingViewState.h(), socialsSharingViewState.d(), composer, (SocialsSharePayload.f119374r << 3) | 6, 0);
                    composer.U();
                    break;
                default:
                    composer.a0(-542048261);
                    composer.U();
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(final List list, final List list2, final PagerState pagerState, final CoroutineScope coroutineScope, final Context context, final View view, final SocialsSharingViewState socialsSharingViewState, final SocialShareTemplate socialShareTemplate, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(663942115, i4, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreen.<anonymous>.<anonymous>.<anonymous> (SocialSharingScreen.kt:269)");
            }
            float f3 = 8;
            float fG = Dp.g(f3);
            final float fL = ((Dp) ComparisonsKt.m(Dp.d(Dp.g(Dp.g(BoxWithConstraints.d() - Dp.g(3 * fG)) / 4)), Dp.d(Dp.g(120)))).l();
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            FlowLayoutKt.d(modifierH, arrangement.p(fG, Alignment.f25072a.g()), arrangement.o(Dp.g(f3)), null, 4, 0, ComposableLambdaKt.e(1424117832, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.sharing.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SocialSharingScreenKt.z(list, fL, list2, pagerState, coroutineScope, context, view, socialsSharingViewState, socialShareTemplate, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1597878, 40);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(List list, float f3, final List list2, final PagerState pagerState, final CoroutineScope coroutineScope, Context context, final View view, final SocialsSharingViewState socialsSharingViewState, final SocialShareTemplate socialShareTemplate, FlowRowScope FlowRow, Composer composer, int i3) {
        List list3;
        PagerState pagerState2;
        CoroutineScope coroutineScope2;
        Context context2;
        CoroutineScope coroutineScope3 = coroutineScope;
        Context context3 = context;
        View view2 = view;
        SocialsSharingViewState socialsSharingViewState2 = socialsSharingViewState;
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1424117832, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.SocialSharingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SocialSharingScreen.kt:283)");
            }
            composer.a0(-1517328540);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final ShareableAppInfo shareableAppInfo = (ShareableAppInfo) it.next();
                String strB = shareableAppInfo.b();
                Painter painterE = DrawablePainterKt.e(shareableAppInfo.c(), composer, 0);
                boolean zI = composer.I(shareableAppInfo) | composer.I(coroutineScope3) | composer.I(context3) | composer.I(view2) | composer.e(socialShareTemplate.ordinal()) | composer.Z(socialsSharingViewState2);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    final SocialsSharingViewState socialsSharingViewState3 = socialsSharingViewState2;
                    final Context context4 = context3;
                    final View view3 = view2;
                    Object obj = new Function0() { // from class: cz.mobilesoft.coreblock.scene.sharing.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SocialSharingScreenKt.A(shareableAppInfo, coroutineScope, context4, view3, socialShareTemplate, socialsSharingViewState3);
                        }
                    };
                    coroutineScope2 = coroutineScope;
                    context2 = context4;
                    composer.w(obj);
                    objG = obj;
                } else {
                    coroutineScope2 = coroutineScope3;
                    context2 = context3;
                }
                ShareAppItemKt.c(null, strB, painterE, f3, null, false, (Function0) objG, composer, 0, 49);
                view2 = view;
                socialsSharingViewState2 = socialsSharingViewState;
                coroutineScope3 = coroutineScope2;
                context3 = context2;
            }
            final CoroutineScope coroutineScope4 = coroutineScope3;
            final Context context5 = context3;
            composer.U();
            String strB2 = StringResources_androidKt.b(R.string.Cc, composer, 0);
            Painter painterC = PainterResources_androidKt.c(R.drawable.I0, composer, 0);
            Color colorN = Color.n(ComposeColorsKt.j(composer, 0).L());
            boolean zI2 = composer.I(list2) | composer.Z(pagerState) | composer.I(coroutineScope4) | composer.I(context5) | composer.I(view) | composer.Z(socialsSharingViewState);
            Object objG2 = composer.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                Object obj2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.sharing.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SocialSharingScreenKt.B(list2, pagerState, coroutineScope4, context5, view, socialsSharingViewState);
                    }
                };
                list3 = list2;
                pagerState2 = pagerState;
                composer.w(obj2);
                objG2 = obj2;
            } else {
                list3 = list2;
                pagerState2 = pagerState;
            }
            ShareAppItemKt.c(null, strB2, painterC, f3, colorN, true, (Function0) objG2, composer, 196608, 1);
            String strB3 = StringResources_androidKt.b(R.string.t8, composer, 0);
            Painter painterC2 = PainterResources_androidKt.c(R.drawable.F1, composer, 0);
            Color colorN2 = Color.n(ComposeColorsKt.j(composer, 0).L());
            boolean zI3 = composer.I(coroutineScope4) | composer.I(context5) | composer.I(view) | composer.e(socialShareTemplate.ordinal()) | composer.Z(socialsSharingViewState);
            Object objG3 = composer.G();
            if (zI3 || objG3 == Composer.f23746a.a()) {
                Object obj3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.sharing.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SocialSharingScreenKt.C(coroutineScope4, context5, view, socialShareTemplate, socialsSharingViewState);
                    }
                };
                composer.w(obj3);
                objG3 = obj3;
            }
            ShareAppItemKt.c(null, strB3, painterC2, f3, colorN2, true, (Function0) objG3, composer, 196608, 1);
            String strB4 = StringResources_androidKt.b(R.string.mk, composer, 0);
            Painter painterC3 = PainterResources_androidKt.c(R.drawable.K3, composer, 0);
            Color colorN3 = Color.n(ComposeColorsKt.j(composer, 0).L());
            boolean zI4 = composer.I(list3) | composer.Z(pagerState2) | composer.I(coroutineScope4) | composer.I(context5) | composer.I(view) | composer.Z(socialsSharingViewState);
            Object objG4 = composer.G();
            if (zI4 || objG4 == Composer.f23746a.a()) {
                final List list4 = list3;
                final PagerState pagerState3 = pagerState2;
                Object obj4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.sharing.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SocialSharingScreenKt.D(list4, pagerState3, coroutineScope4, context5, view, socialsSharingViewState);
                    }
                };
                composer.w(obj4);
                objG4 = obj4;
            }
            ShareAppItemKt.c(null, strB4, painterC3, f3, colorN3, true, (Function0) objG4, composer, 196608, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final String F(SocialShareTemplate socialShareTemplate, Composer composer, int i3) {
        int i4;
        if (ComposerKt.M()) {
            ComposerKt.U(1500097538, i3, -1, YznnJpHcAmeoW.YWUuiCnNzA);
        }
        if (socialShareTemplate == SocialShareTemplate.WeeklyReportPortrait) {
            i4 = R.string.MG;
        } else if (socialShareTemplate.getFormat() == SocialShareTemplate.Format.Transparent) {
            i4 = R.string.Yn;
        } else if (socialShareTemplate.getFormat() == SocialShareTemplate.Format.Square) {
            i4 = R.string.Yz;
        } else {
            i4 = R.string.FA;
        }
        String strB = StringResources_androidKt.b(i4, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return strB;
    }
}
