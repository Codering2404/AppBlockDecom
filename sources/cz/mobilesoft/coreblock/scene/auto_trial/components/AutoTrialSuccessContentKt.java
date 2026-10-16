package cz.mobilesoft.coreblock.scene.auto_trial.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.List;
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
public final class AutoTrialSuccessContentKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f98916a = CollectionsKt.listOf((Object[]) new UnlockedFeature[]{new UnlockedFeature(R.drawable.W0, R.string.f95791f2), new UnlockedFeature(R.drawable.u3, R.string.of), new UnlockedFeature(R.drawable.r6, R.string.vr), new UnlockedFeature(R.drawable.W, R.string.By), new UnlockedFeature(R.drawable.H5, R.string.f95787e2), new UnlockedFeature(R.drawable.b5, R.string.I3)});

    public static final void d(Modifier modifier, final Function0 onContinueClick, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onContinueClick, "onContinueClick");
        Composer composerK = composer.k(-1683401682);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onContinueClick) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1683401682, i5, -1, "cz.mobilesoft.coreblock.scene.auto_trial.components.AutoTrialSuccessContent (AutoTrialSuccessContent.kt:53)");
            }
            float fA = PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0);
            Modifier modifierF = SizeKt.f(modifier3, 0.0f, 1, null);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierK = PaddingKt.k(ScrollKt.g(SizeKt.f(companion3, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), fA, 0.0f, 2, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA2, measurePolicyA, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            BoxKt.a(SizeKt.h(SizeKt.i(WindowInsetsPaddingKt.d(companion3, WindowInsets_androidKt.d(WindowInsets.f7172a, composerK, 6)), Dp.g(56)), 0.0f, 1, null), composerK, 0);
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(companion3, 0.0f, 0.0f, Dp.g(65), Dp.g(f3), 3, null);
            int i7 = 0;
            TextKt.c(StringResources_androidKt.b(R.string.f95812k2, composerK, 0), modifierM, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).e(), 0L, TextUnitKt.i(61), FontWeight.f29233b.g(), null, null, ComposeTypographyKt.f(), null, TextUnitKt.i(0), null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(61), null, null, null, 0, 0, null, 16645977, null), composerK, 48, 0, 65016);
            Modifier modifierK2 = PaddingKt.k(companion3, 0.0f, Dp.g(f3), 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion.i(), composerK, 48);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierK2);
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
            Updater.e(composerA3, measurePolicyB, companion2.e());
            Updater.e(composerA3, compositionLocalMapU3, companion2.g());
            Function2 function2B3 = companion2.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ImageKt.a(PainterResources_androidKt.c(R.drawable.r4, composerK, 0), null, null, null, null, 0.0f, null, composerK, 48, 124);
            TextKt.c(StringResources_androidKt.b(R.string.f95829o2, composerK, 0), PaddingKt.m(companion3, Dp.g(4), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composerK, 0).Y(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 48, 0, 65528);
            composerK.y();
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(f3)), companion.k(), composerK, 6);
            int iA4 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU4 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, companion3);
            Function0 function0A4 = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A4);
            } else {
                composerK.v();
            }
            Composer composerA4 = Updater.a(composerK);
            Updater.e(composerA4, measurePolicyA2, companion2.e());
            Updater.e(composerA4, compositionLocalMapU4, companion2.g());
            Function2 function2B4 = companion2.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF5, companion2.f());
            composerK.a0(2133866669);
            int i8 = 2;
            for (List<UnlockedFeature> list : CollectionsKt.chunked(f98916a, 2)) {
                Modifier modifierA = IntrinsicKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), IntrinsicSize.f6987b);
                MeasurePolicy measurePolicyB2 = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.l(), composerK, 6);
                int iA5 = ComposablesKt.a(composerK, i7);
                CompositionLocalMap compositionLocalMapU5 = composerK.u();
                Modifier modifierF6 = ComposedModifierKt.f(composerK, modifierA);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                Function0 function0A5 = companion4.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A5);
                } else {
                    composerK.v();
                }
                Composer composerA5 = Updater.a(composerK);
                Updater.e(composerA5, measurePolicyB2, companion4.e());
                Updater.e(composerA5, compositionLocalMapU5, companion4.g());
                Function2 function2B5 = companion4.b();
                if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                    composerA5.w(Integer.valueOf(iA5));
                    composerA5.p(Integer.valueOf(iA5), function2B5);
                }
                Updater.e(composerA5, modifierF6, companion4.f());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
                composerK.a0(969908962);
                for (UnlockedFeature unlockedFeature : list) {
                    f(SizeKt.d(RowScope.c(rowScopeInstance2, Modifier.b8, 1.0f, false, 2, null), 0.0f, 1, null), unlockedFeature.a(), unlockedFeature.b(), composerK, 0, 0);
                }
                composerK.U();
                composerK.y();
                i8 = 2;
                i7 = 0;
            }
            int i9 = i8;
            composerK.U();
            composerK.y();
            Modifier.Companion companion5 = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion5, Dp.g(120)), composerK, 6);
            composerK.y();
            Alignment.Companion companion6 = Alignment.f25072a;
            Modifier modifierH = SizeKt.h(boxScopeInstance.f(companion5, companion6.b()), 0.0f, 1, null);
            Alignment.Horizontal horizontalG = companion6.g();
            Arrangement arrangement2 = Arrangement.f6574a;
            MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement2.h(), horizontalG, composerK, 48);
            int iA6 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU6 = composerK.u();
            Modifier modifierF7 = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
            Function0 function0A6 = companion7.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A6);
            } else {
                composerK.v();
            }
            Composer composerA6 = Updater.a(composerK);
            Updater.e(composerA6, measurePolicyA3, companion7.e());
            Updater.e(composerA6, compositionLocalMapU6, companion7.g());
            Function2 function2B6 = companion7.b();
            if (composerA6.i() || !Intrinsics.areEqual(composerA6.G(), Integer.valueOf(iA6))) {
                composerA6.w(Integer.valueOf(iA6));
                composerA6.p(Integer.valueOf(iA6), function2B6);
            }
            Updater.e(composerA6, modifierF7, companion7.f());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
            BoxKt.a(BackgroundKt.b(SizeKt.i(SizeKt.h(companion5, 0.0f, 1, null), Dp.g(40)), Brush.Companion.m(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.r(ComposeColorsKt.j(composerK, 0).e(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(ComposeColorsKt.j(composerK, 0).e())}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), composerK, 0);
            Modifier modifierD = BackgroundKt.d(SizeKt.h(companion5, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).e(), null, 2, null);
            MeasurePolicy measurePolicyA4 = ColumnKt.a(arrangement2.h(), companion6.g(), composerK, 48);
            int iA7 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU7 = composerK.u();
            Modifier modifierF8 = ComposedModifierKt.f(composerK, modifierD);
            Function0 function0A7 = companion7.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A7);
            } else {
                composerK.v();
            }
            Composer composerA7 = Updater.a(composerK);
            Updater.e(composerA7, measurePolicyA4, companion7.e());
            Updater.e(composerA7, compositionLocalMapU7, companion7.g());
            Function2 function2B7 = companion7.b();
            if (composerA7.i() || !Intrinsics.areEqual(composerA7.G(), Integer.valueOf(iA7))) {
                composerA7.w(Integer.valueOf(iA7));
                composerA7.p(Integer.valueOf(iA7), function2B7);
            }
            Updater.e(composerA7, modifierF8, companion7.f());
            Modifier modifier4 = modifier3;
            FlatButtonsKt.p(null, false, StringResources_androidKt.b(R.string.Z1, composerK, 0), false, onContinueClick, composerK, (i5 << 9) & 57344, 11);
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.f95773b2, composerK, 0), PaddingKt.m(PaddingKt.k(companion5, fA, 0.0f, i9, null), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, 0, 0, 65016);
            composer2.y();
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.components.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoTrialSuccessContentKt.e(modifier2, onContinueClick, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Modifier modifier, Function0 function0, int i3, int i4, Composer composer, int i5) {
        d(modifier, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void f(Modifier modifier, final int i3, final int i4, Composer composer, final int i5, final int i6) {
        int i7;
        final Modifier modifier2;
        Composer composerK = composer.k(-102931078);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (composerK.Z(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= composerK.e(i4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i7 & 147) != 146, i7 & 1)) {
            if (i8 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-102931078, i7, -1, "cz.mobilesoft.coreblock.scene.auto_trial.components.UnlockedFeatureCard (AutoTrialSuccessContent.kt:191)");
            }
            int i9 = (i7 & 14) | 196608;
            Modifier modifier3 = modifier;
            CardsKt.k(modifier3, ComposeColorsKt.j(composerK, 0).l0(), 0.0f, null, null, ComposableLambdaKt.e(-910256355, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.components.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AutoTrialSuccessContentKt.g(i3, i4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, i9, 28);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier3;
        } else {
            composerK.Q();
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.components.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoTrialSuccessContentKt.h(modifier2, i3, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(int i3, int i4, ColumnScope BaseCard, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i5 & 17) != 16, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-910256355, i5, -1, "cz.mobilesoft.coreblock.scene.auto_trial.components.UnlockedFeatureCard.<anonymous> (AutoTrialSuccessContent.kt:196)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(SizeKt.f(companion, 0.0f, 1, null), Dp.g(16));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            IconKt.c(PainterResources_androidKt.c(i3, composer, 0), null, SizeKt.v(companion, Dp.g(56)), ComposeColorsKt.j(composer, 0).s(), composer, 432, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            TextKt.c(StringResources_androidKt.b(i4, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 2, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 24576, 48634);
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
    public static final Unit h(Modifier modifier, int i3, int i4, int i5, int i6, Composer composer, int i7) {
        f(modifier, i3, i4, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }
}
