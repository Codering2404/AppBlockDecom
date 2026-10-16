package cz.mobilesoft.coreblock.scene.premium.exitpaywall;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.ChipColors;
import androidx.compose.material.ChipDefaults;
import androidx.compose.material.ChipKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.dto.PurchaseSuccessDTO;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ExitPaywallScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(PremiumScreenViewState premiumScreenViewState, Function0 function0, Function0 function02, Function1 function1, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        x(premiumScreenViewState, function0, function02, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void B(final PremiumOptionDTO premiumOptionDTO, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-150200348);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(premiumOptionDTO) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-150200348, i4, -1, "cz.mobilesoft.coreblock.scene.premium.exitpaywall.PremiumCard (ExitPaywallScreen.kt:247)");
            }
            CardKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), RoundedCornerShapeKt.d(Dp.g(16)), ComposeColorsKt.j(composerK, 0).l0(), 0L, BorderStrokeKt.a(Dp.g(2), ComposeColorsKt.j(composerK, 0).V()), Dp.g(0), ComposableLambdaKt.e(1829586119, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExitPaywallScreenKt.C(premiumOptionDTO, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 1769478, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExitPaywallScreenKt.F(premiumOptionDTO, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(PremiumOptionDTO premiumOptionDTO, Composer composer, int i3) {
        Modifier.Companion companion;
        Modifier.Companion companion2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1829586119, i3, -1, "cz.mobilesoft.coreblock.scene.premium.exitpaywall.PremiumCard.<anonymous> (ExitPaywallScreen.kt:259)");
            }
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierJ = PaddingKt.j(companion3, Dp.g(12), Dp.g(16));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion4 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion4.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
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
            Updater.e(composerA, measurePolicyA, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion5.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH = SizeKt.h(companion3, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion4.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A2 = companion5.a();
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
            Updater.e(composerA2, measurePolicyB, companion5.e());
            Updater.e(composerA2, compositionLocalMapU2, companion5.g());
            Function2 function2B2 = companion5.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion5.f());
            TextKt.c(StringResources_androidKt.b(R.string.iq, composer, 0), RowScope.c(RowScopeInstance.f7101a, companion3, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).V(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65528);
            Composer composer2 = composer;
            Integer numB = premiumOptionDTO.b();
            if (numB == null) {
                composer2.a0(1268606893);
                composer2.U();
                companion = companion3;
            } else {
                composer2.a0(1268606894);
                final int iIntValue = numB.intValue();
                Modifier modifierI = SizeKt.i(companion3, Dp.g(26));
                companion = companion3;
                ChipColors chipColorsA = ChipDefaults.f12397a.a(ComposeColorsKt.j(composer2, 0).V(), ComposeColorsKt.j(composer2, 0).q0(), 0L, 0L, 0L, 0L, composer2, ChipDefaults.f12402f << 18, 60);
                Object objG = composer2.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExitPaywallScreenKt.D();
                        }
                    };
                    composer2.w(objG);
                }
                ChipKt.a((Function0) objG, modifierI, false, null, null, null, chipColorsA, null, ComposableLambdaKt.e(-1926649740, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.q
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ExitPaywallScreenKt.E(iIntValue, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 100663350, 188);
                Unit unit = Unit.f139807a;
                composer2.U();
            }
            composer2.y();
            Modifier.Companion companion6 = companion;
            SpacerKt.a(SizeKt.i(companion6, Dp.g(4)), composer2, 6);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion4.a(), composer2, 48);
            int iA3 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, companion6);
            Function0 function0A3 = companion5.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A3);
            } else {
                composer2.v();
            }
            Composer composerA3 = Updater.a(composer2);
            Updater.e(composerA3, measurePolicyB2, companion5.e());
            Updater.e(composerA3, compositionLocalMapU3, companion5.g());
            Function2 function2B3 = companion5.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion5.f());
            String strD = premiumOptionDTO.d();
            if (strD == null) {
                composer2.a0(-230892848);
                composer2.U();
                companion2 = companion6;
            } else {
                composer2.a0(-230892847);
                companion2 = companion6;
                TextKt.c(strD, null, ComposeColorsKt.j(composer2, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).h(), composer, 0, 0, 65530);
                composer2 = composer;
                Unit unit2 = Unit.f139807a;
                composer2.U();
            }
            SpacerKt.a(SizeKt.A(companion2, Dp.g(8)), composer2, 6);
            TextKt.c(premiumOptionDTO.a(), null, ComposeColorsKt.j(composer2, 0).O(), 0L, null, null, null, 0L, TextDecoration.f29625b.b(), null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 100663296, 0, 65274);
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
    public static final Unit D() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(int i3, RowScope Chip, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(Chip, "$this$Chip");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1926649740, i4, -1, "cz.mobilesoft.coreblock.scene.premium.exitpaywall.PremiumCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExitPaywallScreen.kt:286)");
            }
            TextKt.c(StringResources_androidKt.c(R.string.oc, new Object[]{Integer.valueOf(i3)}, composer, 0), null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).j(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(PremiumOptionDTO premiumOptionDTO, int i3, Composer composer, int i4) {
        B(premiumOptionDTO, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void o(final PremiumScreenViewState premiumScreenViewState, Function0 function0, Composer composer, final int i3) {
        int i4;
        final Function0 function02 = function0;
        Composer composerK = composer.k(-1151878823);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(premiumScreenViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function02) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1151878823, i5, -1, "cz.mobilesoft.coreblock.scene.premium.exitpaywall.ContentView (ExitPaywallScreen.kt:166)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            float f3 = 16;
            float f4 = 24;
            Modifier modifierL = PaddingKt.l(companion2, Dp.g(f3), Dp.g(f3), Dp.g(f3), Dp.g(f4));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierL);
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
            ImageKt.a(PainterResources_androidKt.c(R.drawable.y2, composerK, 0), null, PaddingKt.m(companion2, 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null), null, null, 0.0f, null, composerK, 432, 120);
            String strB = StringResources_androidKt.b(R.string.L4, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            long jL = ComposeColorsKt.j(composerK, 0).L();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, SizeKt.g(companion2, 0.9f), jL, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.K4, composerK, 0), SizeKt.g(companion2, 0.9f), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(60)), composerK, 6);
            if (premiumScreenViewState.c() instanceof Loading) {
                composerK.a0(789800367);
                Modifier modifierA = IntrinsicKt.a(SizeKt.h(companion2, 0.0f, 1, null), IntrinsicSize.f6987b);
                MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierA);
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
                ProgressIndicatorKt.b(SizeKt.v(BoxScopeInstance.f6642a.f(companion2, companion.e()), Dp.g(48)), 0L, 0.0f, 0L, 0, composerK, 0, 30);
                composerK.y();
                composerK.U();
                function02 = function0;
            } else {
                composerK.a0(790289485);
                PremiumOptionDTO premiumOptionDTOH = premiumScreenViewState.h();
                if (premiumOptionDTOH == null) {
                    composerK.a0(790298939);
                } else {
                    composerK.a0(790298940);
                    B(premiumOptionDTOH, composerK, 0);
                    Unit unit = Unit.f139807a;
                }
                composerK.U();
                SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composerK, 6);
                ButtonDefaults buttonDefaults = ButtonDefaults.f12323a;
                float f5 = 0;
                float fG = Dp.g(f5);
                float fG2 = Dp.g(f5);
                int i6 = ButtonDefaults.f12334l;
                function02 = function0;
                ButtonKt.a(function02, SizeKt.h(SizeKt.k(companion2, Dp.g(56), 0.0f, 2, null), 0.0f, 1, null), false, null, buttonDefaults.b(fG, fG2, 0.0f, 0.0f, 0.0f, composerK, (i6 << 15) | 54, 28), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95478l, composerK, 0)), null, buttonDefaults.a(ComposeColorsKt.j(composerK, 0).A(), 0L, 0L, 0L, composerK, i6 << 12, 14), null, ComposableSingletons$ExitPaywallScreenKt.f113074a.e(), composerK, ((i5 >> 3) & 14) | 805306416, 332);
                composerK = composerK;
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExitPaywallScreenKt.p(premiumScreenViewState, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(PremiumScreenViewState premiumScreenViewState, Function0 function0, int i3, Composer composer, int i4) {
        o(premiumScreenViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void q(final MutableState mutableState, final Function0 onDismissRequest, final Function0 onPurchaseSuccess, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Composer composer2;
        Bundle bundleB;
        final MutableState showExitPaywallDialog = mutableState;
        Intrinsics.checkNotNullParameter(showExitPaywallDialog, "showExitPaywallDialog");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(onPurchaseSuccess, "onPurchaseSuccess");
        Composer composerK = composer.k(1860411753);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(showExitPaywallDialog) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onDismissRequest) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onPurchaseSuccess) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1860411753, i4, -1, "cz.mobilesoft.coreblock.scene.premium.exitpaywall.ExitPaywallDialog (ExitPaywallScreen.kt:65)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExitPaywallScreenKt.r();
                    }
                };
                composerK.w(objG);
            }
            Function0 function02 = (Function0) objG;
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(ExitPaywallPremiumViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function02);
            composerK.Y();
            composerK.Y();
            ExitPaywallPremiumViewModel exitPaywallPremiumViewModel = (ExitPaywallPremiumViewModel) viewModelA;
            final PremiumScreenViewState premiumScreenViewState = (PremiumScreenViewState) FlowExtKt.m(exitPaywallPremiumViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(exitPaywallPremiumViewModel, composerK, 0);
            PurchaseSuccessDTO purchaseSuccessDTOY = premiumScreenViewState.y();
            boolean Z = composerK.Z(premiumScreenViewState) | ((i4 & 896) == 256);
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                objG2 = new ExitPaywallScreenKt$ExitPaywallDialog$1$1(premiumScreenViewState, onPurchaseSuccess, null);
                composerK.w(objG2);
            }
            EffectsKt.g(purchaseSuccessDTOY, (Function2) objG2, composerK, 0);
            Object value = showExitPaywallDialog.getValue();
            int i5 = i4 & 14;
            boolean zI = (i5 == 4) | composerK.I(exitPaywallPremiumViewModel);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new ExitPaywallScreenKt$ExitPaywallDialog$2$1(showExitPaywallDialog, exitPaywallPremiumViewModel, null);
                composerK.w(objG3);
            }
            EffectsKt.g(value, (Function2) objG3, composerK, 0);
            DialogProperties dialogProperties = new DialogProperties(false, false, false, 4, (DefaultConstructorMarker) null);
            boolean z2 = (i5 == 4) | ((i4 & 112) == 32);
            Object objG4 = composerK.G();
            if (z2 || objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExitPaywallScreenKt.s(showExitPaywallDialog, onDismissRequest);
                    }
                };
                composerK.w(objG4);
            }
            function0 = onDismissRequest;
            composer2 = composerK;
            showExitPaywallDialog = mutableState;
            ComposeDialogsKt.z0(showExitPaywallDialog, null, dialogProperties, (Function0) objG4, ComposableLambdaKt.e(1509214762, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ExitPaywallScreenKt.t(premiumScreenViewState, mutableState, onDismissRequest, context, function1N, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, i5 | 24960, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismissRequest;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExitPaywallScreenKt.w(showExitPaywallDialog, function0, onPurchaseSuccess, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder r() {
        return ParametersHolderKt.b("leaving_premium_screen", "premium_screen");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(final PremiumScreenViewState premiumScreenViewState, final MutableState mutableState, final Function0 function0, final Context context, final Function1 function1, BoxScope CustomDialog, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1509214762, i3, -1, "cz.mobilesoft.coreblock.scene.premium.exitpaywall.ExitPaywallDialog.<anonymous> (ExitPaywallScreen.kt:103)");
            }
            boolean Z = composer.Z(mutableState) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExitPaywallScreenKt.u(mutableState, function0);
                    }
                };
                composer.w(objG);
            }
            Function0 function02 = (Function0) objG;
            boolean zI = composer.I(context) | composer.Z(function1) | composer.Z(premiumScreenViewState);
            Object objG2 = composer.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExitPaywallScreenKt.v(context, function1, premiumScreenViewState);
                    }
                };
                composer.w(objG2);
            }
            x(premiumScreenViewState, function02, (Function0) objG2, null, composer, 0, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Context context, Function1 function1, PremiumScreenViewState premiumScreenViewState) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            function1.invoke(new PremiumScreenViewEvent.OnPurchase(activityB, premiumScreenViewState.D()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(MutableState mutableState, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        q(mutableState, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void x(final cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState r26, final kotlin.jvm.functions.Function0 r27, final kotlin.jvm.functions.Function0 r28, kotlin.jvm.functions.Function1 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.exitpaywall.ExitPaywallScreenKt.x(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(PremiumScreenViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }
}
