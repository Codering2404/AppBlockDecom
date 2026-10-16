package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.SliderColors;
import androidx.compose.material.SliderDefaults;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.glance.session.ecY.lisODU;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.components.PremiumReviewsCarouselCardKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.view.compose.ChipKt;
import cz.mobilesoft.coreblock.view.compose.slider.ComposeSliderKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

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
public final class ComponentsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1250325739, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumFeatureCard.<anonymous> (Components.kt:324)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(SizeKt.k(SizeKt.h(BackgroundKt.d(companion, ComposeColorsKt.j(composer, 0).l0(), null, 2, null), 0.0f, 1, null), Dp.g(278), 0.0f, 2, null), Dp.g(16));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composer, 48);
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
            SpacerKt.a(SizeKt.i(companion, Dp.g(32)), composer, 6);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
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
            ImageKt.a(PainterResources_androidKt.c(R.drawable.H7, composer, 0), "", SizeKt.v(companion, Dp.g(102)), null, null, 0.0f, null, composer, 432, 120);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.f95543n1, composer, 0), "", PaddingKt.m(boxScopeInstance.f(companion, companion2.c()), 0.0f, 0.0f, 0.0f, Dp.g(4), 7, null), null, null, 0.0f, null, composer, 48, 120);
            composer.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(21)), composer, 6);
            TextKt.c(str, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65022);
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
    public static final Unit B(String str, int i3, Composer composer, int i4) {
        z(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void C(Composer composer, final int i3) {
        Composer composerK = composer.k(986251577);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(986251577, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumFeatureCarousel (Components.kt:274)");
            }
            final int size = PremiumFeature.getEntries().size();
            int i4 = (5000 / size) * size;
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                final int i5 = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(ComponentsKt.D(i5));
                    }
                };
                composerK.w(objG);
            }
            PagerState pagerStateL = PagerStateKt.l(i4, 0.0f, (Function0) objG, composerK, 384, 2);
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
            float f3 = 16;
            PagerKt.a(pagerStateL, SizeKt.E(companion, null, false, 3, null), PaddingKt.c(Dp.g(32), 0.0f, 2, null), null, 2, Dp.g(f3), null, null, false, false, null, null, null, null, ComposableLambdaKt.e(1456704546, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.f
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return ComponentsKt.E(size, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), composerK, 221616, 24576, 16328);
            composerK = composerK;
            PremiumReviewsCarouselCardKt.o(size, pagerStateL, PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, Dp.g(f3), 5, null), composerK, 384, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.F(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int D(int i3) {
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(int i3, PagerScope HorizontalPager, int i4, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.M()) {
            ComposerKt.U(1456704546, i5, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumFeatureCarousel.<anonymous>.<anonymous> (Components.kt:299)");
        }
        z(StringResources_androidKt.b(PremiumFeature.getEntries().get(i4 % i3).getTextRes(), composer, 0), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(int i3, Composer composer, int i4) {
        C(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void o(Modifier modifier, String str, final ClosedFloatingPointRange closedFloatingPointRange, final float f3, final int i3, final Function1 function1, final Function1 function12, float f4, float f5, Composer composer, final int i4, final int i5) {
        Modifier modifier2;
        int i6;
        float f6;
        float f7;
        String str2;
        Composer composer2;
        final Modifier modifier3;
        Composer composerK = composer.k(389426949);
        int i7 = i5 & 1;
        if (i7 != 0) {
            i6 = i4 | 6;
            modifier2 = modifier;
        } else if ((i4 & 6) == 0) {
            modifier2 = modifier;
            i6 = (composerK.Z(modifier2) ? 4 : 2) | i4;
        } else {
            modifier2 = modifier;
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerK.Z(closedFloatingPointRange) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.c(f3) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= composerK.e(i3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i6 |= composerK.I(function1) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i4 & 1572864) == 0) {
            i6 |= composerK.I(function12) ? 1048576 : 524288;
        }
        if ((i4 & 12582912) == 0) {
            i6 |= composerK.c(f4) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i6 |= composerK.c(f5) ? 67108864 : 33554432;
        }
        if (composerK.r((i6 & 38347923) != 38347922, i6 & 1)) {
            Modifier modifier4 = i7 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(389426949, i6, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumCalculator (Components.kt:174)");
            }
            Modifier modifierH = SizeKt.h(modifier4, 0.0f, 1, null);
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
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
            String strB = StringResources_androidKt.b(R.string.f95844s1, composerK, 0);
            TextStyle textStyleH = ComposeTypographyKt.g(composerK, 0).h();
            long jL = ComposeColorsKt.j(composerK, 0).L();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            int i8 = i6;
            Modifier modifier5 = modifier4;
            TextKt.c(strB, null, jL, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleH, composerK, 0, 0, 65018);
            Modifier.Companion companion4 = Modifier.b8;
            float f8 = 12;
            SpacerKt.a(SizeKt.i(companion4, Dp.g(f8)), composerK, 6);
            TextKt.c(StringHelper.b(str, (int) f3), null, ComposeColorsKt.j(composerK, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion4, Dp.g(f8)), composerK, 6);
            SliderColors sliderColorsA = SliderDefaults.f13759a.a(ComposeColorsKt.j(composerK, 0).L(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerK, 0, SliderDefaults.f13760b, 1022);
            float fG = Dp.g(32);
            float fG2 = Dp.g(16);
            boolean z2 = (i8 & 458752) == 131072;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComponentsKt.p(function1, ((Float) obj).floatValue());
                    }
                };
                composerK.w(objG);
            }
            ComposeSliderKt.e(f3, (Function1) objG, null, false, closedFloatingPointRange, 0, null, null, sliderColorsA, Dp.d(fG), Dp.d(fG2), composerK, ((i8 >> 9) & 14) | 805306368 | ((i8 << 6) & 57344), 6, 236);
            SpacerKt.a(SizeKt.i(companion4, Dp.g(6)), composerK, 6);
            Modifier modifierH2 = SizeKt.h(companion4, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.e(), companion.l(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH2);
            Function0 function0A2 = companion2.a();
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
            Updater.e(composerA2, measurePolicyB, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            f6 = f4;
            str2 = str;
            TextKt.c(StringHelper.b(str2, (int) f6), null, ComposeColorsKt.j(composerK, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65530);
            f7 = f5;
            TextKt.c(StringHelper.b(str2, (int) f7), null, ComposeColorsKt.j(composerK, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65530);
            composerK.y();
            float f9 = 24;
            SpacerKt.a(SizeKt.i(companion4, Dp.g(f9)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.f95859x1, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion4, Dp.g(f9)), composerK, 6);
            Modifier modifierH3 = SizeKt.h(PaddingKt.i(BackgroundKt.c(companion4, ComposeColorsKt.j(composerK, 0).N(), RoundedCornerShapeKt.a(50)), Dp.g(4)), 0.0f, 1, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.o(Dp.g(8)), companion.l(), composerK, 6);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierH3);
            Function0 function0A3 = companion2.a();
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
            Updater.e(composerA3, measurePolicyB2, companion2.e());
            Updater.e(composerA3, compositionLocalMapU3, companion2.g());
            Function2 function2B3 = companion2.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion2.f());
            composerK.a0(-1349919579);
            Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4}).iterator();
            while (it.hasNext()) {
                final int iIntValue = ((Number) it.next()).intValue();
                String strC = StringResources_androidKt.c(R.string.wk, new Object[]{Integer.valueOf(iIntValue)}, composerK, 0);
                boolean z3 = i3 == iIntValue;
                boolean zE = ((i8 & 3670016) == 1048576) | composerK.e(iIntValue);
                Object objG2 = composerK.G();
                if (zE || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ComponentsKt.q(function12, iIntValue);
                        }
                    };
                    composerK.w(objG2);
                }
                ChipKt.j(rowScopeInstance, strC, z3, (Function0) objG2, composerK, 6, 0);
            }
            composerK.U();
            composerK.y();
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f9)), composerK, 6);
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.c(R.string.f95856w1, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composerK, 0)}, composerK, 0), null, ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, 0, 0, 65018);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            f6 = f4;
            f7 = f5;
            str2 = str;
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final float f10 = f6;
            final float f11 = f7;
            final String str3 = str2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.r(modifier3, str3, closedFloatingPointRange, f3, i3, function1, function12, f10, f11, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function1 function1, float f3) {
        function1.invoke(Float.valueOf(f3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function1 function1, int i3) {
        function1.invoke(Integer.valueOf(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Modifier modifier, String str, ClosedFloatingPointRange closedFloatingPointRange, float f3, int i3, Function1 function1, Function1 function12, float f4, float f5, int i4, int i5, Composer composer, int i6) {
        o(modifier, str, closedFloatingPointRange, f3, i3, function1, function12, f4, f5, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x04b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void s(androidx.compose.ui.Modifier r61, final java.lang.String r62, boolean r63, androidx.compose.runtime.Composer r64, final int r65, final int r66) {
        /*
            Method dump skipped, instruction units count: 1229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.premium_expiring.ComponentsKt.s(androidx.compose.ui.Modifier, java.lang.String, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(final MutableFloatState mutableFloatState, final MutableIntState mutableIntState, String str, ClosedFloatingPointRange closedFloatingPointRange, float f3, float f4, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1719425184, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumCalculatorContent.<anonymous>.<anonymous> (Components.kt:90)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(16));
            float fC = mutableFloatState.c();
            int iG = mutableIntState.g();
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComponentsKt.u(mutableFloatState, ((Float) obj).floatValue());
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComponentsKt.v(mutableIntState, ((Integer) obj).intValue());
                    }
                };
                composer.w(objG2);
            }
            o(modifierI, str, closedFloatingPointRange, fC, iG, function1, (Function1) objG2, f3, f4, composer, 1769478, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Modifier modifier, String str, boolean z2, int i3, int i4, Composer composer, int i5) {
        s(modifier, str, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void z(final String text, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerK = composer.k(-1954844200);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(text) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1954844200, i4, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumFeatureCard (Components.kt:316)");
            }
            CardKt.a(IntrinsicKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), IntrinsicSize.f6987b), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0)), 0L, 0L, null, Dp.g(0), ComposableLambdaKt.e(-1250325739, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.A(text, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 1769478, 28);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.B(text, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ClosedFloatingPointRange G(String str) {
        switch (str.hashCode()) {
            case 65168:
                if (str.equals("AUD")) {
                    return RangesKt.b(1.0f, 200.0f);
                }
                break;
            case 66044:
                if (str.equals("BRL")) {
                    return RangesKt.b(5.0f, 750.0f);
                }
                break;
            case 66470:
                if (str.equals("CAD")) {
                    return RangesKt.b(1.0f, 200.0f);
                }
                break;
            case 66689:
                if (str.equals(lisODU.jGSjXglbSQNdeF)) {
                    return RangesKt.b(1.0f, 150.0f);
                }
                break;
            case 66894:
                if (str.equals("CNY")) {
                    return RangesKt.b(7.0f, 700.0f);
                }
                break;
            case 67252:
                if (str.equals("CZK")) {
                    return RangesKt.b(20.0f, 1500.0f);
                }
                break;
            case 72653:
                if (str.equals("INR")) {
                    return RangesKt.b(10.0f, 12000.0f);
                }
                break;
            case 73683:
                if (str.equals("JPY")) {
                    return RangesKt.b(100.0f, 15000.0f);
                }
                break;
            case 74704:
                if (str.equals("KRW")) {
                    return RangesKt.b(1500.0f, 200000.0f);
                }
                break;
            case 76803:
                if (str.equals("MXN")) {
                    return RangesKt.b(20.0f, 3000.0f);
                }
                break;
            case 79314:
                if (str.equals("PLN")) {
                    return RangesKt.b(30.0f, 500.0f);
                }
                break;
        }
        return RangesKt.b(1.0f, 150.0f);
    }
}
