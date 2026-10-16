package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import android.app.Activity;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.components.PauseBlockingItemKt;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import cz.mobilesoft.coreblock.scene.streaks.pause.StreakPauseWarningSheetKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
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
public final class PauseBlockingScreenKt {
    public static final void A(final PauseBlockingViewState viewState, final Function1 onEvent, final NavHostController navController, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerK = composer.k(-702361096);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(navController) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-702361096, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.RootCompose (PauseBlockingScreen.kt:119)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final boolean zBooleanValue = ((Boolean) composerK.q(InspectionModeKt.a())).booleanValue();
            final boolean zG = viewState.f().g();
            final long j3 = 86340;
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composerK, 6)), null, ComposableLambdaKt.e(1929052499, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PauseBlockingScreenKt.B(context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-158130694, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PauseBlockingScreenKt.E(zG, viewState, zBooleanValue, onEvent, j3, context, navController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 384, 12582912, 131066);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PauseBlockingScreenKt.Q(viewState, onEvent, navController, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(final Context context, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1929052499, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.RootCompose.<anonymous> (PauseBlockingScreen.kt:127)");
            }
            AppBarKt.g(ComposableSingletons$PauseBlockingScreenKt.f100091a.f(), BackgroundKt.d(SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(56)), ComposeColorsKt.j(composer, 0).e(), null, 2, null), ComposableLambdaKt.e(1858332441, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PauseBlockingScreenKt.C(context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposeColorsKt.j(composer, 0).e(), 0L, Dp.g(0), composer, 1573254, 40);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(final Context context, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1858332441, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.RootCompose.<anonymous>.<anonymous> (PauseBlockingScreen.kt:136)");
            }
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            String strB = StringResources_androidKt.b(R.string.Re, composer, 0);
            boolean zI = composer.I(context);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PauseBlockingScreenKt.D(context);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, 0L, strB, (Function0) objG, composer, 0, 125);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Context context) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            activityB.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final boolean z2, final PauseBlockingViewState pauseBlockingViewState, final boolean z3, final Function1 function1, final long j3, final Context context, final NavHostController navHostController, PaddingValues padding, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-158130694, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.RootCompose.<anonymous> (PauseBlockingScreen.kt:148)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.k(PaddingKt.h(companion, padding), Dp.g(f3), 0.0f, 2, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            TextKt.c(StringResources_androidKt.b(R.string.wn, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).f(), composer, 0, 0, 65018);
            ComposeCardsKt.m(FocusableKt.b(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), false, null, 2, null), new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(-1567272983, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PauseBlockingScreenKt.F(z3, pauseBlockingViewState, z2, function1, j3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3462, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(32)), composer, 6);
            y(StringResources_androidKt.b(R.string.Ak, composer, 0), composer, 0);
            ComposeCardsKt.m(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(1350408914, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PauseBlockingScreenKt.J(z2, function1, context, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3078, 4);
            ComposeCardsKt.m(SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), 0.0f, 1, null), new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(-1606066127, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PauseBlockingScreenKt.M(function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3078, 4);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            if (!z2 || pauseBlockingViewState.c().isEmpty()) {
                composer.a0(-919755426);
            } else {
                composer.a0(-905242776);
                SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
                y(StringResources_androidKt.b(R.string.Hf, composer, 0), composer, 0);
                ComposeCardsKt.m(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(-378065874, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.h0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PauseBlockingScreenKt.O(pauseBlockingViewState, context, function1, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 3078, 4);
                SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            }
            composer.U();
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
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit F(boolean r53, cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState r54, boolean r55, final kotlin.jvm.functions.Function1 r56, long r57, androidx.compose.runtime.Composer r59, int r60) {
        /*
            Method dump skipped, instruction units count: 1071
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingScreenKt.F(boolean, cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState, boolean, kotlin.jvm.functions.Function1, long, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder G(TimePickerViewModel.Params params) {
        return ParametersHolderKt.b(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(TimePickerViewModel timePickerViewModel, long j3) {
        TimePickerViewModel.p1(timePickerViewModel, TimePickerConfig.f133036h.b(), Long.valueOf(j3), null, false, 12, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Function1 function1, TimePickerViewState timePickerViewState) {
        function1.invoke(new PauseBlockingViewEvent.OnPauseClicked(new PauseBlockingViewState.PauseBlockingType.Custom(timePickerViewState.o())));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(final boolean z2, final Function1 function1, final Context context, final NavHostController navHostController, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1350408914, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.RootCompose.<anonymous>.<anonymous>.<anonymous> (PauseBlockingScreen.kt:274)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            String strB = StringResources_androidKt.b(R.string.wF, composer, 0);
            boolean z3 = !z2;
            ImageVector.Companion companion3 = ImageVector.f26323k;
            ImageVector imageVectorB = VectorResources_androidKt.b(companion3, R.drawable.f95535l1, composer, 6);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PauseBlockingScreenKt.K(function1);
                    }
                };
                composer.w(objG);
            }
            PauseBlockingItemKt.c(strB, imageVectorB, z3, false, false, false, (Function0) objG, composer, 3072, 48);
            String strB2 = StringResources_androidKt.b(R.string.uF, composer, 0);
            boolean z4 = !z2;
            ImageVector imageVectorB2 = VectorResources_androidKt.b(companion3, R.drawable.f95531k1, composer, 6);
            boolean zB = composer.b(z2) | composer.I(context) | composer.I(navHostController);
            Object objG2 = composer.G();
            if (zB || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PauseBlockingScreenKt.L(z2, context, navHostController);
                    }
                };
                composer.w(objG2);
            }
            PauseBlockingItemKt.c(strB2, imageVectorB2, z4, false, false, false, (Function0) objG2, composer, 0, 56);
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
    public static final Unit K(Function1 function1) {
        function1.invoke(new PauseBlockingViewEvent.OnPauseClicked(PauseBlockingViewState.PauseBlockingType.ForToday.f100193b));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(boolean z2, Context context, NavHostController navHostController) {
        if (z2) {
            NavController.O(navHostController, NavDateTimePicker.INSTANCE, null, null, 6, null);
        } else {
            context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.PAUSE_SCHEDULES), "pause_blocking_screen", "schedule_pause", false, false, false, null, 240, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1606066127, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.RootCompose.<anonymous>.<anonymous>.<anonymous> (PauseBlockingScreen.kt:313)");
            }
            String strB = StringResources_androidKt.b(R.string.hc, composer, 0);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.J5, composer, 6);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PauseBlockingScreenKt.N(function1);
                    }
                };
                composer.w(objG);
            }
            PauseBlockingItemKt.c(strB, imageVectorB, false, false, false, false, (Function0) objG, composer, 3072, 52);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function1 function1) {
        function1.invoke(new PauseBlockingViewEvent.OnPauseClicked(PauseBlockingViewState.PauseBlockingType.Indefinitely.f100194b));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(PauseBlockingViewState pauseBlockingViewState, Context context, final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        String strB;
        ImageVector imageVector;
        boolean z2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-378065874, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.RootCompose.<anonymous>.<anonymous>.<anonymous> (PauseBlockingScreen.kt:337)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composer.a0(1868959622);
            int i4 = 0;
            for (Object obj : pauseBlockingViewState.c()) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final PauseBlockingViewState.PauseBlockingType pauseBlockingType = (PauseBlockingViewState.PauseBlockingType) obj;
                if (i4 < 5) {
                    composer.a0(249237123);
                    if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.Custom) {
                        composer.a0(249385551);
                        composer.U();
                        strB = DateHelper.l(context, ((PauseBlockingViewState.PauseBlockingType.Custom) pauseBlockingType).a(), false);
                    } else if (pauseBlockingType instanceof PauseBlockingViewState.PauseBlockingType.ForToday) {
                        composer.a0(-130494508);
                        strB = StringResources_androidKt.b(R.string.SD, composer, 0);
                        composer.U();
                    } else {
                        composer.a0(249719016);
                        composer.U();
                        strB = "";
                    }
                    Intrinsics.checkNotNull(strB);
                    ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.e4, composer, 6);
                    if (1 > i4 || i4 > pauseBlockingViewState.c().size()) {
                        imageVector = imageVectorB;
                        z2 = false;
                    } else {
                        imageVector = imageVectorB;
                        z2 = true;
                    }
                    boolean Z = composer.Z(function1) | composer.Z(pauseBlockingType);
                    Object objG = composer.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.i0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PauseBlockingScreenKt.P(function1, pauseBlockingType);
                            }
                        };
                        composer.w(objG);
                    }
                    PauseBlockingItemKt.c(strB, imageVector, false, z2, false, true, (Function0) objG, composer, 196608, 20);
                } else {
                    composer.a0(234078092);
                }
                composer.U();
                i4 = i5;
            }
            composer.U();
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
    public static final Unit P(Function1 function1, PauseBlockingViewState.PauseBlockingType pauseBlockingType) {
        function1.invoke(new PauseBlockingViewEvent.OnPauseClicked(pauseBlockingType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(PauseBlockingViewState pauseBlockingViewState, Function1 function1, NavHostController navHostController, int i3, Composer composer, int i4) {
        A(pauseBlockingViewState, function1, navHostController, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void u(final PauseBlockingViewState viewState, final Function1 onEvent, final NavHostController navController, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerK = composer.k(-2012611887);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(navController) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2012611887, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingScreen (PauseBlockingScreen.kt:96)");
            }
            int i5 = i4 & 112;
            A(viewState, onEvent, navController, composerK, i4 & 1022);
            PauseBlockingViewState.StreakPauseWarning streakPauseWarningH = viewState.h();
            if (streakPauseWarningH == null) {
                composerK.a0(23167209);
            } else {
                composerK.a0(23167210);
                StreakEvaluator.PauseRisk pauseRiskA = streakPauseWarningH.a();
                boolean z2 = i5 == 32;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.y
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PauseBlockingScreenKt.v(onEvent);
                        }
                    };
                    composerK.w(objG);
                }
                Function0 function0 = (Function0) objG;
                boolean z3 = i5 == 32;
                Object objG2 = composerK.G();
                if (z3 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PauseBlockingScreenKt.w(onEvent);
                        }
                    };
                    composerK.w(objG2);
                }
                StreakPauseWarningSheetKt.f(pauseRiskA, function0, (Function0) objG2, composerK, 0);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PauseBlockingScreenKt.x(viewState, onEvent, navController, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1) {
        function1.invoke(PauseBlockingViewEvent.OnStreakPauseTakeBackClicked.f100119a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1) {
        function1.invoke(PauseBlockingViewEvent.OnStreakPauseContinueClicked.f100118a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(PauseBlockingViewState pauseBlockingViewState, Function1 function1, NavHostController navHostController, int i3, Composer composer, int i4) {
        u(pauseBlockingViewState, function1, navHostController, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void y(final String str, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(876160871);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(876160871, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseSectionTitle (PauseBlockingScreen.kt:371)");
            }
            composer2 = composerK;
            TextKt.c(str, null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composer2, (i4 & 14) | 196608, 0, 65498);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PauseBlockingScreenKt.z(str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(String str, int i3, Composer composer, int i4) {
        y(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
