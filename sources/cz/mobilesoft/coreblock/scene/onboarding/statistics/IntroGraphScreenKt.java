package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2;
import cz.mobilesoft.coreblock.scene.premium.components.PremiumReviewsCarouselCardKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.TooltipKt;
import cz.mobilesoft.coreblock.view.graph.BarGraphKt;
import cz.mobilesoft.coreblock.view.graph.GraphConfiguration;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

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
public final class IntroGraphScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f111370a;

        static {
            int[] iArr = new int[AppDistractionType.values().length];
            try {
                iArr[AppDistractionType.Distractive.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppDistractionType.Neutral.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppDistractionType.Productive.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f111370a = iArr;
        }
    }

    private static final void A(Composer composer, final int i3) {
        Composer composerK = composer.k(-1983211410);
        int i4 = 0;
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1983211410, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.DistractionTypeLegend (IntroGraphScreen.kt:315)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(6));
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            int i5 = 54;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, verticalI, composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(1592372252);
            for (AppDistractionType appDistractionType : AppDistractionType.getEntries()) {
                Alignment.Vertical verticalI2 = Alignment.f25072a.i();
                Arrangement.HorizontalOrVertical horizontalOrVerticalO2 = Arrangement.f6574a.o(Dp.g(4));
                Modifier.Companion companion3 = Modifier.b8;
                MeasurePolicy measurePolicyB2 = RowKt.b(horizontalOrVerticalO2, verticalI2, composerK, i5);
                int iA2 = ComposablesKt.a(composerK, i4);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, companion3);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                Function0 function0A2 = companion4.a();
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
                Updater.e(composerA2, measurePolicyB2, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
                InsightsScreenComponentsKt.e1(null, Dp.g(12), appDistractionType, composerK, 48, 1);
                Composer composer2 = composerK;
                TextKt.c(StringResources_androidKt.b(appDistractionType.getNameRes(), composerK, i4), null, ComposeColorsKt.j(composerK, i4).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, i4).d(), 0L, TextUnitKt.i(11), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(17), null, null, null, 0, 0, null, 16646141, null), composer2, 0, 0, 65530);
                composerK = composer2;
                composerK.y();
                i4 = i4;
                i5 = i5;
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroGraphScreenKt.B(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(int i3, Composer composer, int i4) {
        A(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void C(final float r18, final long r19, final cz.mobilesoft.coreblock.view.graph.GraphData r21, java.util.Map r22, final long r23, kotlin.jvm.functions.Function0 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroGraphScreenKt.C(float, long, cz.mobilesoft.coreblock.view.graph.GraphData, java.util.Map, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void D(final float r15, final cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2 r16, final kotlin.jvm.functions.Function0 r17, androidx.compose.runtime.Composer r18, final int r19) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroGraphScreenKt.D(float, cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(float f3, OnboardingViewStateV2 onboardingViewStateV2, Function0 function0, int i3, Composer composer, int i4) {
        D(f3, onboardingViewStateV2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(long j3, GraphData graphData, Map map, long j4, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Object obj;
        float f3;
        int i4;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1668439098, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroGraphScreen.<anonymous> (IntroGraphScreen.kt:109)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = Arrangement.f6574a.e();
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion2 = Modifier.b8;
            float f4 = 16;
            Modifier modifierK = PaddingKt.k(PaddingKt.m(ScrollKt.g(companion2, ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalE, horizontalG, composer, 54);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(R.string.DH, composer, 0);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65022);
            float f5 = 12;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f5)), composer, 6);
            TextKt.c(StringHelper.f((Context) composer.q(AndroidCompositionLocals_androidKt.g()), ((long) 1000) * j3), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, TextUnitKt.i(56), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(68), null, null, null, 0, 0, null, 16646141, null), composer, 0, 0, 65534);
            TextKt.c(StringResources_androidKt.b(R.string.qA, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            Composer composer2 = composer;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f5)), composer2, 6);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composer2, 0);
            if (graphData == null) {
                composer2.a0(-1920909766);
                composer2.U();
                obj = null;
                f3 = 0.0f;
                i4 = 1;
            } else {
                composer2.a0(-1920909765);
                obj = null;
                f3 = 0.0f;
                i4 = 1;
                BarGraphKt.m(SizeKt.i(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(240)), graphData, new GraphConfiguration(false, false, false, true, false, false, null, null, null, null, false, false, null, false, null, null, 65524, null), 0L, 0.0f, null, composer2, 6, 56);
                composer2 = composer2;
                composer2.U();
            }
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f5)), composer2, 6);
            if (map.isEmpty()) {
                companion = companion2;
                composer2.a0(-1926945806);
            } else {
                composer2.a0(-1920183621);
                companion = companion2;
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
                r(map, composer2, 0);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer2, 6);
            }
            composer2.U();
            y(j4, composer2, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer2, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Dg, composer2, 0), SizeKt.h(companion, f3, i4, obj), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 48, 0, 65016);
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
    public static final Unit I(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(float f3, long j3, GraphData graphData, Map map, long j4, Function0 function0, int i3, int i4, Composer composer, int i5) {
        C(f3, j3, graphData, map, j4, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final int K(AppDistractionType appDistractionType) {
        Intrinsics.checkNotNullParameter(appDistractionType, "<this>");
        int i3 = WhenMappings.f111370a[appDistractionType.ordinal()];
        if (i3 == 1) {
            return R.string.qk;
        }
        if (i3 == 2) {
            return R.string.rk;
        }
        if (i3 == 3) {
            return R.string.sk;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final void L(final long j3, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1555303051);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1555303051, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.pickupsBadge (IntroGraphScreen.kt:242)");
            }
            int i5 = R.string.Z2;
            long jA = ComposeColorsKt.j(composerK, 0).A();
            if (j3 > 150) {
                composerK.a0(-73843982);
                i5 = R.string.Y2;
                jA = ComposeColorsKt.j(composerK, 0).c0();
                composerK.U();
            } else {
                if (j3 >= 50) {
                    composerK.a0(-73746611);
                    i5 = R.string.a3;
                    jA = ComposeColorsKt.j(composerK, 0).b();
                } else {
                    composerK.a0(-83439753);
                }
                composerK.U();
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierC = BackgroundKt.c(companion, Color.r(jA, 0.15f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.a(50));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierC);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(i5, composerK, 0), PaddingKt.k(PaddingKt.k(companion, Dp.g(12), 0.0f, 2, null), 0.0f, Dp.g(4), 1, null), jA, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, 48, 0, 65528);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroGraphScreenKt.M(j3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(long j3, int i3, Composer composer, int i4) {
        L(j3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void p(final RowScope rowScope, final Context context, final Drawable drawable, final long j3, final int i3, final AppDistractionType appDistractionType, Composer composer, final int i4) {
        int i5;
        Composer composerK = composer.k(1088691568);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(rowScope) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.I(context) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(drawable) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.f(j3) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.e(i3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i5 |= composerK.e(appDistractionType.ordinal()) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1088691568, i5, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.AppBox (IntroGraphScreen.kt:407)");
            }
            float fG = i3 != 0 ? i3 != 1 ? Dp.g(86) : Dp.g(105) : Dp.g(121);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = SizeKt.i(RowScope.c(rowScope, companion, 1.0f, false, 2, null), fG);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            float f3 = 16;
            BoxKt.a(BackgroundKt.b(PaddingKt.m(SizeKt.f(companion, 0.0f, 1, null), 0.0f, Dp.g(20), 0.0f, 0.0f, 13, null), Brush.Companion.c(ComposeColorsKt.j(composerK, 0).n0(), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L)), TileMode.f25948b.a()), RoundedCornerShapeKt.f(Dp.g(f3), Dp.g(f3), 0.0f, 0.0f, 12, null), 0.0f, 4, null), composerK, 0);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ImageKt.a(DrawablePainterKt.e(drawable, composerK, (i5 >> 6) & 14), null, SizeKt.v(companion, Dp.g(40)), null, null, 0.0f, null, composerK, 432, 120);
            float f4 = 8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(2)), companion2.i(), composerK, 54);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, companion);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyB, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            InsightsScreenComponentsKt.e1(null, Dp.g(12), appDistractionType, composerK, ((i5 >> 9) & 896) | 48, 1);
            TextKt.c(StringHelper.f(context, ((long) 1000) * j3), null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65530);
            composerK = composerK;
            composerK.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroGraphScreenKt.q(rowScope, context, drawable, j3, i3, appDistractionType, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(RowScope rowScope, Context context, Drawable drawable, long j3, int i3, AppDistractionType appDistractionType, int i4, Composer composer, int i5) {
        p(rowScope, context, drawable, j3, i3, appDistractionType, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final void r(final Map map, Composer composer, final int i3) {
        Composer composerK = composer.k(919683976);
        int i4 = (i3 & 6) == 0 ? (composerK.I(map) ? 4 : 2) | i3 : i3;
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(919683976, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.AppCarousel (IntroGraphScreen.kt:276)");
            }
            EnumEntries<AppDistractionType> entries = AppDistractionType.getEntries();
            final ArrayList arrayList = new ArrayList();
            for (AppDistractionType appDistractionType : entries) {
                if (((List) map.get(appDistractionType)) != null && (!r4.isEmpty())) {
                    arrayList.add(appDistractionType);
                }
            }
            if (arrayList.isEmpty()) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return IntroGraphScreenKt.s(map, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            boolean zI = composerK.I(arrayList);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(IntroGraphScreenKt.t(arrayList));
                    }
                };
                composerK.w(objG);
            }
            PagerState pagerStateL = PagerStateKt.l(0, 0.0f, (Function0) objG, composerK, 0, 3);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            PagerKt.a(pagerStateL, null, null, null, 0, Dp.g(16), null, null, false, false, null, null, null, null, ComposableLambdaKt.e(89377535, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.q
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return IntroGraphScreenKt.u(arrayList, map, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), composerK, 196608, 24576, 16350);
            composerK = composerK;
            if (arrayList.size() > 1) {
                composerK.a0(-91486489);
                SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composerK, 6);
                PremiumReviewsCarouselCardKt.o(arrayList.size(), pagerStateL, null, composerK, 0, 4);
            } else {
                composerK.a0(-102629532);
            }
            composerK.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composerK, 6);
            A(composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN2 = composerK.n();
        if (scopeUpdateScopeN2 != null) {
            scopeUpdateScopeN2.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroGraphScreenKt.v(map, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Map map, int i3, Composer composer, int i4) {
        r(map, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(List list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(List list, Map map, PagerScope HorizontalPager, int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.M()) {
            ComposerKt.U(89377535, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.AppCarousel.<anonymous>.<anonymous> (IntroGraphScreen.kt:291)");
        }
        AppDistractionType appDistractionType = (AppDistractionType) list.get(i3);
        List listEmptyList = (List) map.get(appDistractionType);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        w(appDistractionType, listEmptyList, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Map map, int i3, Composer composer, int i4) {
        r(map, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void w(final AppDistractionType appDistractionType, final List list, Composer composer, final int i3) {
        int i4;
        RowScopeInstance rowScopeInstance;
        Context context;
        Composer composerK = composer.k(-1777503638);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(appDistractionType.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(list) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1777503638, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.AppCarouselPage (IntroGraphScreen.kt:345)");
            }
            Context context2 = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            int i5 = R.dimen.f95480n;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(BackgroundKt.c(ClipKt.a(modifierH, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i5, composerK, 0))), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i5, composerK, 0))), Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(20), 0.0f, Dp.g(0), 5, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(8)), companion2.i(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
            int i6 = i4;
            Context context3 = context2;
            TextKt.c(StringResources_androidKt.b(K(appDistractionType), composerK, 0), null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65530);
            composerK = composerK;
            TooltipKt.k(StringResources_androidKt.b(R.string.Dg, composerK, 0), null, null, ComposeColorsKt.j(composerK, 0).F(), 0.0f, null, composerK, 0, 54);
            composerK.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.o(Dp.g(6)), companion2.a(), composerK, 54);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierH2);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyB2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            composerK.a0(1702932616);
            int i7 = 0;
            while (i7 < 3) {
                AppInfo appInfo = (AppInfo) CollectionsKt.getOrNull(list, i7);
                if (appInfo != null) {
                    composerK.a0(-138946769);
                    RowScopeInstance rowScopeInstance3 = rowScopeInstance2;
                    context = context3;
                    p(rowScopeInstance3, context, appInfo.b(), appInfo.a(), i7, appDistractionType, composerK, 6 | ((i6 << 15) & 458752));
                    rowScopeInstance = rowScopeInstance3;
                    composerK.U();
                } else {
                    rowScopeInstance = rowScopeInstance2;
                    context = context3;
                    composerK.a0(-138623284);
                    BoxKt.a(RowScope.c(rowScopeInstance, Modifier.b8, 1.0f, false, 2, null), composerK, 0);
                    composerK.U();
                }
                i7++;
                context3 = context;
                rowScopeInstance2 = rowScopeInstance;
            }
            composerK.U();
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroGraphScreenKt.x(appDistractionType, list, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(AppDistractionType appDistractionType, List list, int i3, Composer composer, int i4) {
        w(appDistractionType, list, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void y(final long j3, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1606548663);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.f(j3) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1606548663, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.DailyPickupsCard (IntroGraphScreen.kt:197)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Modifier.Companion companion2 = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(BackgroundKt.c(SizeKt.h(companion2, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0))), Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Modifier modifierM = PaddingKt.m(RowScope.c(RowScopeInstance.f7101a, companion2, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.g(f3), 0.0f, 11, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f4 = 8;
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.o(Dp.g(f4)), companion.i(), composerK, 54);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyB2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.T8, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composer2, 0, 0, 65530);
            TooltipKt.k(StringResources_androidKt.b(R.string.XD, composer2, 0), null, null, ComposeColorsKt.j(composer2, 0).F(), 0.0f, null, composer2, 0, 54);
            composer2.y();
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer2, 6);
            L(j3, composer2, i4 & 14);
            composer2.y();
            TextKt.c(j3 + "×", null, ComposeColorsKt.j(composer2, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).f(), composer2, 0, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroGraphScreenKt.z(j3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(long j3, int i3, Composer composer, int i4) {
        y(j3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(final Function0 function0, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1658668537, i3, -1, vgWWUoTKYyuC.pKEiSfwCuI);
            }
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IntroGraphScreenKt.I(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
