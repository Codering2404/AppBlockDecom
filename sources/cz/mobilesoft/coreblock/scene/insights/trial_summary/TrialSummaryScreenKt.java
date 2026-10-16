package cz.mobilesoft.coreblock.scene.insights.trial_summary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.facebook.AccessTokenManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.TrialSummaryData;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;

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
public final class TrialSummaryScreenKt {
    public static final void l(final TrialSummaryData trialSummaryData, String str, final Function0 onButtonClick, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final String buttonText = str;
        Intrinsics.checkNotNullParameter(trialSummaryData, "trialSummaryData");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(onButtonClick, "onButtonClick");
        Composer composerK = composer.k(1858084267);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(trialSummaryData) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(buttonText) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onButtonClick) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1858084267, i4, -1, "cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryBlockSessionsContent (TrialSummaryScreen.kt:203)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(ScrollKt.g(SizeKt.f(WindowInsetsPaddingKt.d(companion2, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(R.dimen.f95486t, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(32), 0.0f, 0.0f, 13, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
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
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion2);
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
            String strB = StringResources_androidKt.b(R.string.vE, composerK, 0);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            float f3 = 16;
            TextKt.c(strB, SizeKt.h(PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 48, 0, 65020);
            float f4 = 12;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.uE, composerK, 0), SizeKt.h(PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
            composerK.y();
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composerK, 0);
            MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement.h(), companion.g(), composerK, 48);
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
            Updater.e(composerA3, measurePolicyA3, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            Modifier modifierA = ClipKt.a(SizeKt.v(companion2, Dp.g(80)), RoundedCornerShapeKt.a(50));
            Brush.Companion companion5 = Brush.Companion;
            AppDistractionType appDistractionType = AppDistractionType.Productive;
            Color colorN = Color.n(appDistractionType.m1357getColor0d7_KjU());
            AppDistractionType appDistractionType2 = AppDistractionType.Neutral;
            Color colorN2 = Color.n(Color.r(appDistractionType2.m1357getColor0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null));
            AppDistractionType appDistractionType3 = AppDistractionType.Distractive;
            Modifier modifierH = BorderKt.h(BackgroundKt.b(modifierA, Brush.Companion.m(companion5, CollectionsKt.listOf((Object[]) new Color[]{colorN, colorN2, Color.n(Color.r(appDistractionType3.m1357getColor0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), Dp.g(1), Brush.Companion.m(companion5, CollectionsKt.listOf((Object[]) new Color[]{Color.n(appDistractionType.m1357getColor0d7_KjU()), Color.n(appDistractionType2.m1357getColor0d7_KjU()), Color.n(appDistractionType3.m1357getColor0d7_KjU())}), 0.0f, 0.0f, 0, 14, null), RoundedCornerShapeKt.a(50));
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA4 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU4 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierH);
            Function0 function0A4 = companion3.a();
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
            Updater.e(composerA4, measurePolicyG, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            IconKt.a(PainterResources_androidKt.c(R.drawable.Z0, composerK, 0), null, SizeKt.v(BoxScopeInstance.f6642a.f(companion2, companion.e()), Dp.g(40)), ComposeColorsKt.j(composerK, 0).q0(), composerK, 48, 0);
            composerK.y();
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composerK, 6);
            String str2 = trialSummaryData.b() + "×";
            TextStyle textStyleE = ComposeTypographyKt.g(composerK, 0).e();
            long jI = TextUnitKt.i(56);
            long jI2 = TextUnitKt.i(68);
            FontWeight.Companion companion6 = FontWeight.f29233b;
            TextKt.c(str2, null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(textStyleE, 0L, jI, companion6.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, jI2, null, null, null, 0, 0, null, 16646137, null), composerK, 0, 0, 65530);
            TextKt.c(StringResources_androidKt.b(R.string.uc, composerK, 0), null, ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).h(), 0L, 0L, companion6.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composerK, 0, 0, 65530);
            composerK.y();
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composerK, 0);
            TextKt.c(StringResources_androidKt.b(R.string.tE, composerK, 0), PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
            composer2 = composerK;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer2, 6);
            boolean z2 = (i4 & 896) == 256;
            Object objG = composer2.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TrialSummaryScreenKt.m(onButtonClick);
                    }
                };
                composer2.w(objG);
            }
            buttonText = str;
            ComposeButtonsKt.J(null, buttonText, false, false, null, (Function0) objG, composer2, i4 & 112, 29);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialSummaryScreenKt.n(trialSummaryData, buttonText, onButtonClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(TrialSummaryData trialSummaryData, String str, Function0 function0, int i3, Composer composer, int i4) {
        l(trialSummaryData, str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void o(final Function0 onClose, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerK = composer.k(-1522281051);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onClose) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1522281051, i4, -1, "cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryScreen (TrialSummaryScreen.kt:62)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
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
            KClass kClassB = Reflection.b(TrialSummaryViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            TrialSummaryViewModel trialSummaryViewModel = (TrialSummaryViewModel) viewModelA;
            TrialSummaryViewState trialSummaryViewState = (TrialSummaryViewState) FlowExtKt.m(trialSummaryViewModel, composerK, 0);
            boolean zI = composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new TrialSummaryScreenKt$TrialSummaryScreen$1$1(context, null);
                composerK.w(objG);
            }
            FlowExtKt.g(trialSummaryViewModel, null, (Function2) objG, composerK, 0, 2);
            final TrialSummaryData trialSummaryDataB = trialSummaryViewState.b();
            if (trialSummaryDataB == null) {
                composerK.a0(285530320);
            } else {
                composerK.a0(285530321);
                final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
                ComposeBackgroundKt.s(null, null, null, onClose, ComposableLambdaKt.e(433029576, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.l
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TrialSummaryScreenKt.p(navHostControllerB, trialSummaryDataB, context, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerK, 54), composerK, ((i4 << 9) & 7168) | 24960, 3);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialSummaryScreenKt.v(onClose, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final NavHostController navHostController, final TrialSummaryData trialSummaryData, final Context context, BoxScope GradientBoxWithProgress, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBoxWithProgress, "$this$GradientBoxWithProgress");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(433029576, i3, -1, "cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryScreen.<anonymous>.<anonymous> (TrialSummaryScreen.kt:84)");
            }
            String route = TrialSummaryScreenNavigation.Comparison.getRoute();
            boolean Z = composer.Z(trialSummaryData) | composer.I(navHostController) | composer.I(context);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TrialSummaryScreenKt.q(trialSummaryData, navHostController, context, (NavGraphBuilder) obj);
                    }
                };
                composer.w(objG);
            }
            NavHostKt.v(navHostController, route, null, null, null, null, null, null, null, null, (Function1) objG, composer, 48, 0, 1020);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(final TrialSummaryData trialSummaryData, final NavHostController navHostController, final Context context, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, TrialSummaryScreenNavigation.Comparison.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(602381957, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.o
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return TrialSummaryScreenKt.r(trialSummaryData, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, TrialSummaryScreenNavigation.BlockingSessions.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1293973870, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.p
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return TrialSummaryScreenKt.t(trialSummaryData, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(NavHostController navHostController) {
        NavController.P(navHostController, TrialSummaryScreenNavigation.BlockingSessions.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(TrialSummaryData trialSummaryData, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1293973870, i3, -1, "cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TrialSummaryScreen.kt:99)");
        }
        String strB = StringResources_androidKt.b(R.string.Ue, composer, 0);
        boolean zI = composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrialSummaryScreenKt.u(context);
                }
            };
            composer.w(objG);
        }
        l(trialSummaryData, strB, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Context context) {
        Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, context, null, DashboardActivity.NavBarItem.Insights.f99176i, 2, null);
        intentC.setFlags(268468224);
        context.startActivity(intentC);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function0 function0, int i3, Composer composer, int i4) {
        o(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void w(final TrialSummaryData trialSummaryData, final String buttonText, final Function0 onButtonClick, Composer composer, final int i3) {
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        String strB;
        Intrinsics.checkNotNullParameter(trialSummaryData, "trialSummaryData");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(onButtonClick, "onButtonClick");
        Composer composerK = composer.k(-490180087);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(trialSummaryData) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(buttonText) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onButtonClick) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-490180087, i4, -1, "cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryScreenContent (TrialSummaryScreen.kt:123)");
            }
            if (trialSummaryData.d() <= trialSummaryData.a()) {
                i5 = i4;
                z2 = true;
            } else {
                i5 = i4;
                z2 = false;
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(ScrollKt.g(SizeKt.f(WindowInsetsPaddingKt.d(companion2, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(R.dimen.f95486t, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(32), 0.0f, 0.0f, 13, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
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
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion2);
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
            String strB2 = StringResources_androidKt.b(z2 ? R.string.EE : R.string.AE, composerK, 0);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            float f3 = 16;
            TextKt.c(strB2, SizeKt.h(PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 48, 0, 65020);
            float f4 = 12;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composerK, 6);
            int i6 = i5;
            TextKt.c(StringResources_androidKt.b(z2 ? R.string.DE : R.string.zE, composerK, 0), SizeKt.h(PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
            composerK.y();
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composerK, 0);
            long jD = trialSummaryData.d();
            String strB3 = StringResources_androidKt.b(R.string.R8, composerK, 0);
            composerK = composerK;
            InsightsScreenComponentsKt.E2(z2, jD, strB3, composerK, 0);
            boolean z4 = z2;
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composerK, 0);
            IntroReportScreenKt.o(trialSummaryData.a(), trialSummaryData.d(), StringResources_androidKt.b(R.string.d3, composerK, 0), StringResources_androidKt.b(R.string.xl, composerK, 0), composerK, 0, 0);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composerK, 0);
            Modifier modifierK = PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null);
            if (z4) {
                composerK.a0(708845513);
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                z3 = true;
                String str = String.format("%d", Arrays.copyOf(new Object[]{Integer.valueOf(MathKt.d(trialSummaryData.c() / AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS))}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                String lowerCase = StringResources_androidKt.b(R.string.Lf, composerK, 0).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                strB = StringResources_androidKt.c(R.string.CE, new Object[]{StringHelperExtKt.q(str, lowerCase, null, 2, null)}, composerK, 0);
                composerK.U();
            } else {
                z3 = true;
                composerK.a0(709136913);
                strB = StringResources_androidKt.b(R.string.BE, composerK, 0);
                composerK.U();
            }
            TextKt.c(strB, modifierK, ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composerK, 6);
            boolean z5 = (i6 & 896) == 256 ? z3 : false;
            Object objG = composerK.G();
            if (z5 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TrialSummaryScreenKt.x(onButtonClick);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.J(null, buttonText, false, false, null, (Function0) objG, composerK, i6 & 112, 29);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialSummaryScreenKt.y(trialSummaryData, buttonText, onButtonClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(TrialSummaryData trialSummaryData, String str, Function0 function0, int i3, Composer composer, int i4) {
        w(trialSummaryData, str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(TrialSummaryData trialSummaryData, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry navBackStackEntry, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, KrzujOtzIk.HFjCreXcrpM);
        if (ComposerKt.M()) {
            ComposerKt.U(602381957, i3, -1, "cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TrialSummaryScreen.kt:89)");
        }
        String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.q
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrialSummaryScreenKt.s(navHostController);
                }
            };
            composer.w(objG);
        }
        w(trialSummaryData, strB, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }
}
