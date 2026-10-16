package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewEvent;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewState;
import cz.mobilesoft.coreblock.scene.selection.BlockingSelectScreenDialogsKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import de.charlex.compose.HtmlTextKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

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
public final class DistractionsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1) {
        function1.invoke(new WeeklyInsightsViewEvent.OnScheduleSelectionConfirmed(true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(WeeklyInsightsViewState weeklyInsightsViewState, List list, MutableState mutableState, SnackbarHostState snackbarHostState, MutableState mutableState2, Function1 function1, Function1 function12, Function1 function13, int i3, Composer composer, int i4) {
        q(weeklyInsightsViewState, list, mutableState, snackbarHostState, mutableState2, function1, function12, function13, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void C(final WeeklyInsightsViewState.DistractiveApp distractiveApp, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1099733976);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(distractiveApp) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1099733976, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.OtherApp (DistractionsScreen.kt:255)");
            }
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composerK, 48);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i5 = i4;
            Drawable drawableA = distractiveApp.a();
            float fG = Dp.g(56);
            float fG2 = Dp.g(42);
            boolean z2 = (i5 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DistractionsScreenKt.D(function0);
                    }
                };
                composerK.w(objG);
            }
            ComponentsKt.g(drawableA, fG, fG2, (Function0) objG, ComposableSingletons$DistractionsScreenKt.f103872a.b(), composerK, 25008, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(6)), composerK, 6);
            TextKt.c(DateHelperExtKt.f((long) distractiveApp.b(), false, false, false, 14, null), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 48, 0, 65016);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DistractionsScreenKt.E(distractiveApp, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(WeeklyInsightsViewState.DistractiveApp distractiveApp, Function0 function0, int i3, Composer composer, int i4) {
        C(distractiveApp, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void o(final WeeklyInsightsViewState viewState, final SnackbarHostState snackbarHostState, final MutableState showAddToBlockingBottomSheet, final MutableState showAppBlockWarningDialog, final Function1 onEvent, final Function1 onTap, final Function1 onAppsLimitPremiumBadgeClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(showAddToBlockingBottomSheet, "showAddToBlockingBottomSheet");
        Intrinsics.checkNotNullParameter(showAppBlockWarningDialog, "showAppBlockWarningDialog");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Intrinsics.checkNotNullParameter(onAppsLimitPremiumBadgeClicked, "onAppsLimitPremiumBadgeClicked");
        Composer composerK = composer.k(-989962938);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(snackbarHostState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(showAddToBlockingBottomSheet) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(showAppBlockWarningDialog) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onEvent) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(onTap) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(onAppsLimitPremiumBadgeClicked) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i4) != 599186, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-989962938, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.DistractionsScreen (DistractionsScreen.kt:59)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = context.getApplicationContext().getPackageManager();
                composerK.w(objG);
            }
            PackageManager packageManager = (PackageManager) objG;
            boolean Z = composerK.Z(viewState.c());
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                Intrinsics.checkNotNull(packageManager);
                objG2 = viewState.r(packageManager);
                composerK.w(objG2);
            }
            int i5 = (i4 & 14) | ((i4 >> 3) & 896);
            int i6 = i4 << 6;
            int i7 = i4 << 3;
            q(viewState, (List) objG2, showAppBlockWarningDialog, snackbarHostState, showAddToBlockingBottomSheet, onEvent, onTap, onAppsLimitPremiumBadgeClicked, composerK, i5 | (i6 & 7168) | (i6 & 57344) | (458752 & i7) | (3670016 & i7) | (i7 & 29360128));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DistractionsScreenKt.p(viewState, snackbarHostState, showAddToBlockingBottomSheet, showAppBlockWarningDialog, onEvent, onTap, onAppsLimitPremiumBadgeClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(WeeklyInsightsViewState weeklyInsightsViewState, SnackbarHostState snackbarHostState, MutableState mutableState, MutableState mutableState2, Function1 function1, Function1 function12, Function1 function13, int i3, Composer composer, int i4) {
        o(weeklyInsightsViewState, snackbarHostState, mutableState, mutableState2, function1, function12, function13, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void q(final WeeklyInsightsViewState viewState, final List mostDistractiveApps, final MutableState showAppBlockWarningDialog, final SnackbarHostState snackbarHostState, final MutableState showAddToBlockingBottomSheet, final Function1 onEvent, final Function1 onTap, final Function1 onAppsLimitPremiumBadgeClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(mostDistractiveApps, "mostDistractiveApps");
        Intrinsics.checkNotNullParameter(showAppBlockWarningDialog, "showAppBlockWarningDialog");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(showAddToBlockingBottomSheet, "showAddToBlockingBottomSheet");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Intrinsics.checkNotNullParameter(onAppsLimitPremiumBadgeClicked, "onAppsLimitPremiumBadgeClicked");
        Composer composerK = composer.k(1027058231);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(mostDistractiveApps) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(showAppBlockWarningDialog) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(snackbarHostState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(showAddToBlockingBottomSheet) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(onEvent) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(onTap) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(onAppsLimitPremiumBadgeClicked) ? 8388608 : 4194304;
        }
        if (composerK.r((4793491 & i4) != 4793490, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1027058231, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.DistractionsScreenContent (DistractionsScreen.kt:86)");
            }
            final WeeklyInsightsViewState.DistractiveApp distractiveApp = (WeeklyInsightsViewState.DistractiveApp) CollectionsKt.firstOrNull(mostDistractiveApps);
            if (distractiveApp == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.l0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DistractionsScreenKt.r(viewState, mostDistractiveApps, showAppBlockWarningDialog, snackbarHostState, showAddToBlockingBottomSheet, onEvent, onTap, onAppsLimitPremiumBadgeClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            composer2 = composerK;
            ComponentsKt.k(StringResources_androidKt.b(R.string.Kg, composerK, 0), HtmlTextKt.e(StringResources_androidKt.b(R.string.uG, composerK, 0), (3 & 1) != 0 ? new SpanStyle(Color.f25715b.b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, 12286, (DefaultConstructorMarker) null) : null, (3 & 2) != 0 ? MapsKt.emptyMap() : null), false, onTap, ComposableLambdaKt.e(-518934179, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.m0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DistractionsScreenKt.s(distractiveApp, viewState, onEvent, showAddToBlockingBottomSheet, mostDistractiveApps, snackbarHostState, onAppsLimitPremiumBadgeClicked, showAppBlockWarningDialog, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i4 >> 9) & 7168) | 24576, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DistractionsScreenKt.B(viewState, mostDistractiveApps, showAppBlockWarningDialog, snackbarHostState, showAddToBlockingBottomSheet, onEvent, onTap, onAppsLimitPremiumBadgeClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(WeeklyInsightsViewState weeklyInsightsViewState, List list, MutableState mutableState, SnackbarHostState snackbarHostState, MutableState mutableState2, Function1 function1, Function1 function12, Function1 function13, int i3, Composer composer, int i4) {
        q(weeklyInsightsViewState, list, mutableState, snackbarHostState, mutableState2, function1, function12, function13, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(final WeeklyInsightsViewState.DistractiveApp distractiveApp, WeeklyInsightsViewState weeklyInsightsViewState, final Function1 function1, final MutableState mutableState, List list, SnackbarHostState snackbarHostState, Function1 function12, MutableState mutableState2, ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        int i5 = (i3 & 6) == 0 ? i3 | (composer.Z(BaseWeeklyInsightsScreen) ? 4 : 2) : i3;
        if (composer.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-518934179, i5, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.DistractionsScreenContent.<anonymous> (DistractionsScreen.kt:94)");
            }
            Modifier.Companion companion = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(42)), composer, 6);
            ComponentsKt.g(distractiveApp.a(), 0.0f, 0.0f, null, null, composer, 0, 30);
            float f3 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strC = distractiveApp.c();
            TextAlign.Companion companion2 = TextAlign.f29616b;
            TextAlign textAlignH = TextAlign.h(companion2.a());
            TextStyle textStyleE = ComposeTypographyKt.g(composer, 0).e();
            long jI = TextUnitKt.i(48);
            FontWeight.Companion companion3 = FontWeight.f29233b;
            TextKt.c(strC, null, 0L, 0L, null, null, null, 0L, null, textAlignH, 0L, 0, false, 0, 0, null, TextStyle.e(textStyleE, 0L, jI, companion3.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 0, 65022);
            float f4 = 4;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.c(R.string.yG, new Object[]{DateHelperExtKt.f((long) distractiveApp.b(), false, false, false, 14, null)}, composer, 0), null, ComposeColorsKt.j(composer, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion2.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65018);
            Composer composer2 = composer;
            if (weeklyInsightsViewState.E()) {
                composer2.a0(-1985112731);
            } else {
                composer2.a0(-1979954424);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
                Modifier modifierJ = PaddingKt.j(BackgroundKt.c(companion, Color.r(ComposeColorsKt.j(composer2, 0).p0(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.a(50)), Dp.g(6), Dp.g(f4));
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer2, 48);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierJ);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                Function0 function0A = companion4.a();
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
                Updater.e(composerA, measurePolicyB, companion4.e());
                Updater.e(composerA, compositionLocalMapU, companion4.g());
                Function2 function2B = companion4.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion4.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.R6, composer2, 6), null, SizeKt.v(companion, Dp.g(f3)), ComposeColorsKt.j(composer2, 0).c0(), composer2, 432, 0);
                SpacerKt.a(SizeKt.A(companion, Dp.g(f4)), composer2, 6);
                TextKt.c(StringResources_androidKt.b(R.string.f95794g1, composer2, 0), null, ComposeColorsKt.j(composer2, 0).c0(), 0L, null, null, null, 0L, null, TextAlign.h(companion2.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer2, 0).d(), 0L, TextUnitKt.i(12), companion3.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 0, 65018);
                composer2 = composer;
                composer2.y();
            }
            composer2.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            ButtonType.TinyRound tinyRound = new ButtonType.TinyRound(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95554q0, composer2, 6), Color.n(ComposeColorsKt.j(composer2, 0).b()), StringResources_androidKt.b(R.string.Eq, composer2, 0), null);
            ButtonColor.Custom custom = new ButtonColor.Custom(false, null, false, Color.n(ComposeColorsKt.j(composer2, 0).X()), null, Color.n(ComposeColorsKt.j(composer2, 0).b()), 23, null);
            boolean Z = composer2.Z(function1) | composer2.I(distractiveApp) | composer2.Z(mutableState);
            Object objG = composer2.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.o0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DistractionsScreenKt.t(function1, distractiveApp, mutableState);
                    }
                };
                composer2.w(objG);
            }
            ComposeButtonsKt.i0(null, tinyRound, custom, (Function0) objG, composer, 0, 1);
            Composer composer3 = composer;
            composer3.a0(-479443570);
            List<WeeklyInsightsViewState.DistractiveApp> listSubList = list.subList(1, list.size());
            if (!listSubList.isEmpty()) {
                SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion, 1.0f, false, 2, null), composer3, 0);
                TextKt.c(StringResources_androidKt.b(R.string.vG, composer3, 0), null, ComposeColorsKt.j(composer3, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion2.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer3, 0).h(), composer, 0, 0, 65018);
                composer3 = composer;
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer3, 6);
                Modifier modifierB = ScrollKt.b(companion, ScrollKt.c(0, composer3, 0, 1), false, null, false, 14, null);
                MeasurePolicy measurePolicyB2 = RowKt.b(Arrangement.f6574a.o(Dp.g(16)), Alignment.f25072a.i(), composer3, 54);
                int iA2 = ComposablesKt.a(composer3, 0);
                CompositionLocalMap compositionLocalMapU2 = composer3.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierB);
                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                Function0 function0A2 = companion5.a();
                if (composer3.m() == null) {
                    ComposablesKt.c();
                }
                composer3.L();
                if (composer3.i()) {
                    composer3.P(function0A2);
                } else {
                    composer3.v();
                }
                Composer composerA2 = Updater.a(composer3);
                Updater.e(composerA2, measurePolicyB2, companion5.e());
                Updater.e(composerA2, compositionLocalMapU2, companion5.g());
                Function2 function2B2 = companion5.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion5.f());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
                composer3.a0(-795663003);
                for (final WeeklyInsightsViewState.DistractiveApp distractiveApp2 : listSubList) {
                    boolean Z2 = composer3.Z(function1) | composer3.I(distractiveApp2) | composer3.Z(mutableState);
                    Object objG2 = composer3.G();
                    if (Z2 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.p0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DistractionsScreenKt.u(function1, distractiveApp2, mutableState);
                            }
                        };
                        composer3.w(objG2);
                    }
                    C(distractiveApp2, (Function0) objG2, composer3, 0);
                }
                composer3.U();
                composer3.y();
            }
            Unit unit = Unit.f139807a;
            composer3.U();
            Modifier.Companion companion6 = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion6, Dp.g(40)), composer3, 6);
            TextKt.c(StringResources_androidKt.b(R.string.wC, composer3, 0), null, ComposeColorsKt.j(composer3, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer3, 0).a(), composer, 0, 0, 65018);
            Composer composer4 = composer;
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion6, 1.0f, false, 2, null), composer4, 0);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer4.a0(-1976291433);
                boolean zF = weeklyInsightsViewState.F();
                boolean zG = weeklyInsightsViewState.g();
                ImmutableList immutableListW = weeklyInsightsViewState.w();
                boolean Z3 = composer4.Z(function1);
                Object objG3 = composer4.G();
                if (Z3 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.q0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DistractionsScreenKt.v(function1, ((Integer) obj).intValue());
                        }
                    };
                    composer4.w(objG3);
                }
                Function1 function13 = (Function1) objG3;
                boolean Z4 = composer4.Z(function1);
                Object objG4 = composer4.G();
                if (Z4 || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.r0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DistractionsScreenKt.w(function1);
                        }
                    };
                    composer4.w(objG4);
                }
                Function0 function0 = (Function0) objG4;
                boolean Z5 = composer4.Z(function1);
                Object objG5 = composer4.G();
                if (Z5 || objG5 == Composer.f23746a.a()) {
                    objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.s0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DistractionsScreenKt.x(function1);
                        }
                    };
                    composer4.w(objG5);
                }
                Function0 function02 = (Function0) objG5;
                boolean Z6 = composer4.Z(function1);
                Object objG6 = composer4.G();
                if (Z6 || objG6 == Composer.f23746a.a()) {
                    objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.t0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DistractionsScreenKt.y(function1);
                        }
                    };
                    composer4.w(objG6);
                }
                Function0 function03 = (Function0) objG6;
                boolean Z7 = composer4.Z(function1);
                Object objG7 = composer4.G();
                if (Z7 || objG7 == Composer.f23746a.a()) {
                    objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.h0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DistractionsScreenKt.z(function1);
                        }
                    };
                    composer4.w(objG7);
                }
                i4 = 0;
                InsightsScreenComponentsKt.K0(zF, zG, immutableListW, mutableState, snackbarHostState, function13, function0, function02, function03, function12, (Function0) objG7, composer4, 0, 0);
                composer4 = composer4;
            } else {
                i4 = 0;
                composer4.a0(-1985112731);
            }
            composer4.U();
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                composer4.a0(-1975027532);
                boolean Z8 = composer4.Z(function1);
                Object objG8 = composer4.G();
                if (Z8 || objG8 == Composer.f23746a.a()) {
                    objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.i0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DistractionsScreenKt.A(function1);
                        }
                    };
                    composer4.w(objG8);
                }
                BlockingSelectScreenDialogsKt.o(mutableState2, (Function0) objG8, composer4, i4);
            } else {
                composer4.a0(-1985112731);
            }
            composer4.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function1 function1, WeeklyInsightsViewState.DistractiveApp distractiveApp, MutableState mutableState) {
        function1.invoke(new WeeklyInsightsViewEvent.OnAppSelected(distractiveApp.d()));
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function1 function1, WeeklyInsightsViewState.DistractiveApp distractiveApp, MutableState mutableState) {
        function1.invoke(new WeeklyInsightsViewEvent.OnAppSelected(distractiveApp.d()));
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1, int i3) {
        function1.invoke(new WeeklyInsightsViewEvent.OnScheduleClicked(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1) {
        function1.invoke(WeeklyInsightsViewEvent.OnAddScheduleClicked.f103908a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function1 function1) {
        function1.invoke(new WeeklyInsightsViewEvent.OnScheduleSelectionConfirmed(false, 1, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function1 function1) {
        function1.invoke(WeeklyInsightsViewEvent.OnDismissBottomSheet.f103911a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function1 function1) {
        function1.invoke(WeeklyInsightsViewEvent.OnLockedScheduleClicked.f103912a);
        return Unit.f139807a;
    }
}
