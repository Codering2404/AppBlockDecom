package cz.mobilesoft.coreblock.scene.schedule.preview_disabled;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
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
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState;
import cz.mobilesoft.coreblock.scene.schedule.preview_disabled.SchedulePreviewInactiveScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryScreenKt;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntity;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SchedulePreviewInactiveScreenKt {
    private static final void l(final boolean z2, final boolean z3, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        int i5;
        int i6;
        int i7;
        long jE;
        long jP;
        Composer composerK = composer.k(-903213332);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-903213332, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview_disabled.EditScheduleSection (SchedulePreviewInactiveScreen.kt:340)");
            }
            if (z2) {
                composerK.a0(341932742);
                composerK.a0(-404610715);
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                composerK.a0(-404609513);
                int iS = builder.s(new SpanStyle(0L, ComposeTypographyKt.g(composerK, 0).i().n(), ComposeTypographyKt.g(composerK, 0).i().q(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65529, (DefaultConstructorMarker) null));
                try {
                    builder.l(StringResources_androidKt.b(R.string.sp, composerK, 0));
                    Unit unit = Unit.f139807a;
                    builder.q(iS);
                    composerK.U();
                    builder.l(" ");
                    builder.l(StringResources_androidKt.b(R.string.rp, composerK, 0));
                    AnnotatedString annotatedStringT = builder.t();
                    composerK.U();
                    i6 = 1;
                    i5 = i4;
                    TextKt.d(annotatedStringT, null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 0, 0, 130554);
                    Modifier.Companion companion = Modifier.b8;
                    float f3 = 16;
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
                    String strB = StringResources_androidKt.b(R.string.ts, composerK, 0);
                    TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composerK, 0).h(), 0L, 0L, FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
                    FlatButtonColors flatButtonColorsA = FlatButtonColors.Premium.f131164a.a(Color.n(ComposeColorsKt.j(composerK, 0).q0()), Color.n(ComposeColorsKt.j(composerK, 0).Y()));
                    Integer numValueOf = Integer.valueOf(R.drawable.s4);
                    boolean z4 = (i5 & 896) == 256;
                    Object objG = composerK.G();
                    if (z4 || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: n1.j
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SchedulePreviewInactiveScreenKt.m(function1);
                            }
                        };
                        composerK.w(objG);
                    }
                    FlatButtonsKt.u(null, 0.0f, 0.0f, null, flatButtonColorsA, null, strB, textStyleE, 0L, numValueOf, null, false, false, (Function0) objG, composerK, 0, 0, 7471);
                    composerK = composerK;
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
                } catch (Throwable th) {
                    builder.q(iS);
                    throw th;
                }
            } else {
                i5 = i4;
                i6 = 1;
                composerK.a0(325456118);
            }
            composerK.U();
            String strB2 = StringResources_androidKt.b(R.string.Kc, composerK, 0);
            TextStyle textStyleE2 = TextStyle.e(ComposeTypographyKt.g(composerK, 0).h(), 0L, 0L, FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            if (z3) {
                composerK.a0(343430042);
                i7 = 0;
                jE = ComposeColorsKt.j(composerK, 0).q0();
                composerK.U();
            } else {
                i7 = 0;
                if (z2) {
                    composerK.a0(343520531);
                    jE = ComposeColorsKt.j(composerK, 0).p();
                    composerK.U();
                } else {
                    composerK.a0(343592885);
                    jE = ComposeColorsKt.j(composerK, 0).e();
                    composerK.U();
                }
            }
            Color colorN = Color.n(jE);
            if (z3) {
                composerK.a0(343720729);
                jP = ComposeColorsKt.j(composerK, i7).a0();
                composerK.U();
            } else if (z2) {
                composerK.a0(343812272);
                jP = ComposeColorsKt.j(composerK, i7).e0();
                composerK.U();
            } else {
                composerK.a0(343887571);
                jP = ComposeColorsKt.j(composerK, i7).p();
                composerK.U();
            }
            FlatButtonColors flatButtonColorsA2 = primary.a(colorN, Color.n(jP));
            Integer numValueOf2 = z3 ? Integer.valueOf(R.drawable.U5) : null;
            if ((i5 & 896) != 256) {
                i6 = i7;
            }
            Object objG2 = composerK.G();
            if (i6 != 0 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: n1.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SchedulePreviewInactiveScreenKt.n(function1);
                    }
                };
                composerK.w(objG2);
            }
            composer2 = composerK;
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, flatButtonColorsA2, null, strB2, textStyleE2, 0L, numValueOf2, null, false, false, (Function0) objG2, composer2, 0, 0, 7471);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: n1.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewInactiveScreenKt.o(z2, z3, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1) {
        function1.invoke(SchedulePreviewViewEvent.OnDisabledByPremiumClicked.f117397a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function1 function1) {
        function1.invoke(SchedulePreviewViewEvent.OnEditScheduleClicked.f117398a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z2, boolean z3, Function1 function1, int i3, Composer composer, int i4) {
        l(z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void p(final SchedulePreviewViewState viewState, final Function1 function1, final Function0 onCloseClicked, final Function0 onBlockingClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        long jR;
        String strM;
        boolean z2;
        final Function1 onEvent = function1;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onBlockingClicked, "onBlockingClicked");
        Composer composerK = composer.k(622686845);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onCloseClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onBlockingClicked) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(622686845, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview_disabled.SchedulePreviewInactiveScreen (SchedulePreviewInactiveScreen.kt:135)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final ProfileWithConfiguration profileWithConfigurationI = viewState.I();
            if (profileWithConfigurationI == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: n1.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SchedulePreviewInactiveScreenKt.q(viewState, onEvent, onCloseClicked, onBlockingClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                final ProfileViewDTO profileViewDTOH = viewState.H();
                if (profileViewDTOH == null) {
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    scopeUpdateScopeN = composerK.n();
                    if (scopeUpdateScopeN == null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: n1.c
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SchedulePreviewInactiveScreenKt.r(viewState, function1, onCloseClicked, onBlockingClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                } else {
                    boolean z3 = profileViewDTOH.z() || profileViewDTOH.B();
                    boolean zF = composerK.f(viewState.J());
                    Object objG = composerK.G();
                    if (zF || objG == Composer.f23746a.a()) {
                        objG = SnapshotStateKt.e(new Function0() { // from class: n1.d
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SchedulePreviewInactiveScreenKt.s(viewState, context);
                            }
                        });
                        composerK.w(objG);
                    }
                    State state = (State) objG;
                    boolean zF2 = composerK.f(viewState.J()) | composerK.Z(viewState.D());
                    Object objG2 = composerK.G();
                    if (zF2 || objG2 == Composer.f23746a.a()) {
                        objG2 = SnapshotStateKt.e(new Function0() { // from class: n1.e
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(SchedulePreviewInactiveScreenKt.t(viewState));
                            }
                        });
                        composerK.w(objG2);
                    }
                    final State state2 = (State) objG2;
                    ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
                    Modifier.Companion companion = Modifier.b8;
                    Modifier modifierD = WindowInsetsPaddingKt.d(SizeKt.h(companion, 0.0f, 1, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6));
                    Brush.Companion companion2 = Brush.Companion;
                    if (z3) {
                        composerK.a0(501862372);
                        jR = Color.r(ComposeColorsKt.j(composerK, 0).B(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerK.U();
                    } else {
                        composerK.a0(501996757);
                        composerK.U();
                        jR = Color.r(viewState.x(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    float f3 = 16;
                    Modifier modifierK = PaddingKt.k(BackgroundKt.b(modifierD, Brush.Companion.m(companion2, CollectionsKt.listOf((Object[]) new Color[]{Color.n(jR), Color.n(ColorKt.b(0)), Color.n(ColorKt.b(0))}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), Dp.g(f3), 0.0f, 2, null);
                    Alignment.Companion companion3 = Alignment.f25072a;
                    Alignment.Horizontal horizontalG = companion3.g();
                    Arrangement arrangement = Arrangement.f6574a;
                    MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
                    int iA = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU = composerK.u();
                    Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                    Function0 function0A = companion4.a();
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
                    Updater.e(composerA, measurePolicyA, companion4.e());
                    Updater.e(composerA, compositionLocalMapU, companion4.g());
                    Function2 function2B = companion4.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion4.f());
                    Modifier modifierG = ScrollKt.g(ColumnScope.b(ColumnScopeInstance.f6666a, SizeKt.h(companion, 0.0f, 1, null), 1.0f, false, 2, null), scrollStateC, false, null, false, 14, null);
                    MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion3.g(), composerK, 48);
                    int iA2 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU2 = composerK.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierG);
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
                    Updater.e(composerA2, measurePolicyA2, companion4.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                    Function2 function2B2 = companion4.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion4.f());
                    int i5 = i4 << 3;
                    int i6 = i5 & 896;
                    ComposableLambda composableLambda = null;
                    SchedulePreviewScreenKt.S0(profileViewDTOH, viewState.M(), function1, onCloseClicked, composerK, i5 & 8064);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
                    SchedulePreviewScreenKt.c1(profileWithConfigurationI, z3, composerK, 0, 0);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composerK, 6);
                    final boolean z4 = z3;
                    SchedulePreviewScreenKt.f1(viewState, profileWithConfigurationI, z4, onBlockingClicked, composerK, i4 & 7182, 0);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
                    final ProfileWithConfiguration profileWithConfigurationI2 = viewState.I();
                    final ScheduleViewState.MainCardSummaryData mainCardSummaryDataK = viewState.K();
                    if (mainCardSummaryDataK == null) {
                        composerK.a0(1654231816);
                        boolean zB = composerK.b(profileViewDTOH.B()) | composerK.Z(profileWithConfigurationI2) | composerK.Z(viewState.u());
                        Object objG3 = composerK.G();
                        if (zB || objG3 == Composer.f23746a.a()) {
                            objG3 = ProfileHelper.l(ProfileHelper.f129250a, profileWithConfigurationI2, viewState.z(), viewState.u(), profileViewDTOH.B(), false, context, false, 80, null);
                            composerK.w(objG3);
                        }
                        mainCardSummaryDataK = (ScheduleViewState.MainCardSummaryData) objG3;
                    } else {
                        composerK.a0(1577381947);
                    }
                    composerK.U();
                    boolean zB2 = composerK.b(profileViewDTOH.z()) | composerK.Z(viewState.D()) | composerK.Z(mainCardSummaryDataK.h());
                    Object objG4 = composerK.G();
                    if (zB2 || objG4 == Composer.f23746a.a()) {
                        objG4 = SnapshotStateKt.e(new Function0() { // from class: n1.f
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SchedulePreviewInactiveScreenKt.u(profileViewDTOH, viewState, mainCardSummaryDataK);
                            }
                        });
                        composerK.w(objG4);
                    }
                    State state3 = (State) objG4;
                    long jL0 = ComposeColorsKt.j(composerK, 0).l0();
                    ProfileType profileTypeZ = viewState.z();
                    if (!profileViewDTOH.z() || profileViewDTOH.B()) {
                        composerK.a0(1577437326);
                        composerK.U();
                        strM = mainCardSummaryDataK.m();
                    } else {
                        composerK.a0(1577436008);
                        strM = StringResources_androidKt.b(R.string.Bn, composerK, 0);
                        composerK.U();
                    }
                    String str = strM;
                    String strK = (!profileViewDTOH.z() || profileViewDTOH.B()) ? mainCardSummaryDataK.k() : (String) state.getValue();
                    Intrinsics.checkNotNull(strK);
                    String strL = mainCardSummaryDataK.l();
                    int i7 = i4;
                    int iJ = mainCardSummaryDataK.j();
                    List list = (List) state3.getValue();
                    if (CollectionsKt.contains(CollectionsKt.listOf((Object[]) new ProfileType[]{ProfileType.LOCATION, ProfileType.WIFI}), viewState.z()) || (profileViewDTOH.z() && (!profileViewDTOH.B() || profileViewDTOH.C()))) {
                        z2 = true;
                        composerK.a0(1657164756);
                        composerK.U();
                    } else {
                        composerK.a0(1656639741);
                        ComposableLambda composableLambdaE = ComposableLambdaKt.e(1883650492, true, new Function2() { // from class: n1.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SchedulePreviewInactiveScreenKt.v(mainCardSummaryDataK, profileViewDTOH, viewState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerK, 54);
                        composerK.U();
                        z2 = true;
                        composableLambda = composableLambdaE;
                    }
                    SchedulePreviewScreenKt.q0(jL0, profileTypeZ, viewState, str, strK, strL, iJ, false, list, function1, ComposableLambdaKt.e(-2023414227, z2, new Function2() { // from class: n1.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SchedulePreviewInactiveScreenKt.w(viewState, state2, mainCardSummaryDataK, profileWithConfigurationI2, z4, profileWithConfigurationI, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerK, 54), composableLambda, false, true, z4, composerK, ((i7 << 6) & 896) | 12582912 | (1879048192 & (i7 << 24)), 3078, 4096);
                    onEvent = function1;
                    composer2 = composerK;
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
                    composer2.y();
                    l(viewState.H().C(), viewState.N(), onEvent, composer2, i6);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }
            scopeUpdateScopeN.a(function2);
        }
        composer2 = composerK;
        composer2.Q();
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: n1.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewInactiveScreenKt.x(viewState, onEvent, onCloseClicked, onBlockingClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        p(schedulePreviewViewState, function1, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        p(schedulePreviewViewState, function1, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String s(SchedulePreviewViewState schedulePreviewViewState, Context context) {
        return schedulePreviewViewState.J() >= TimeUnit.HOURS.toMillis(1L) ? DateHelper.k(context, schedulePreviewViewState.J()) : DateHelper.e(TimeUnit.MILLISECONDS.toSeconds(schedulePreviewViewState.J()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float t(SchedulePreviewViewState schedulePreviewViewState) {
        if (schedulePreviewViewState.D().isEmpty()) {
            return 0.0f;
        }
        return RangesKt.o(schedulePreviewViewState.J() / (((long) ((SchedulePauseHistoryEntity) CollectionsKt.last(schedulePreviewViewState.D())).b()) * 1000), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List u(ProfileViewDTO profileViewDTO, SchedulePreviewViewState schedulePreviewViewState, ScheduleViewState.MainCardSummaryData mainCardSummaryData) {
        if (!profileViewDTO.z() || profileViewDTO.B()) {
            return mainCardSummaryData.h();
        }
        if (((SchedulePauseHistoryEntity) CollectionsKt.lastOrNull(schedulePreviewViewState.D())) == null) {
            return mainCardSummaryData.h();
        }
        return CollectionsKt.listOf((Object[]) new String[]{LockieApplication.g().getString(R.string.Oj, 0), DateHelperExtKt.f(r7.b(), false, false, false, 14, null)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(ScheduleViewState.MainCardSummaryData mainCardSummaryData, ProfileViewDTO profileViewDTO, SchedulePreviewViewState schedulePreviewViewState, Composer composer, int i3) {
        long jX;
        long jQ0;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1883650492, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview_disabled.SchedulePreviewInactiveScreen.<anonymous>.<anonymous>.<anonymous> (SchedulePreviewInactiveScreen.kt:265)");
            }
            String strD = mainCardSummaryData.d();
            Integer numE = mainCardSummaryData.e();
            if (profileViewDTO.B()) {
                composer.a0(2006899784);
                jX = ComposeColorsKt.j(composer, 0).p();
                composer.U();
            } else {
                composer.a0(2006900687);
                composer.U();
                jX = schedulePreviewViewState.x();
            }
            if (profileViewDTO.B()) {
                composer.a0(2006904199);
                jQ0 = ComposeColorsKt.j(composer, 0).n();
            } else {
                composer.a0(2006904961);
                jQ0 = ComposeColorsKt.j(composer, 0).q0();
            }
            composer.U();
            ScheduleSummaryScreenKt.O(strD, numE, jX, jQ0, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(SchedulePreviewViewState schedulePreviewViewState, State state, ScheduleViewState.MainCardSummaryData mainCardSummaryData, ProfileWithConfiguration profileWithConfiguration, boolean z2, ProfileWithConfiguration profileWithConfiguration2, Composer composer, int i3) {
        long jP;
        long jP2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2023414227, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview_disabled.SchedulePreviewInactiveScreen.<anonymous>.<anonymous>.<anonymous> (SchedulePreviewInactiveScreen.kt:274)");
            }
            if (!schedulePreviewViewState.H().z() || schedulePreviewViewState.H().B()) {
                composer.a0(333456213);
                if (mainCardSummaryData.n()) {
                    composer.a0(333466753);
                    SchedulePreviewScreenKt.l0(schedulePreviewViewState, profileWithConfiguration, ProfileType.Companion.b(profileWithConfiguration.p().E()), schedulePreviewViewState.u(), false, true, z2, schedulePreviewViewState.H().B(), composer, 196608, 16);
                    composer.U();
                } else {
                    composer.a0(334303970);
                    ImmutableList immutableListG = mainCardSummaryData.g();
                    if (immutableListG == null || immutableListG.isEmpty()) {
                        composer.a0(335087216);
                        Integer numC = mainCardSummaryData.c();
                        SchedulePreviewScreenKt.j0(1.0f, numC != null ? numC.intValue() : mainCardSummaryData.j(), RangesKt.f(mainCardSummaryData.j(), 1), ComposeColorsKt.j(composer, 0).p(), ComposeColorsKt.j(composer, 0).s(), composer, 6, 0);
                        composer.U();
                    } else {
                        composer.a0(334389530);
                        ImmutableList immutableListG2 = mainCardSummaryData.g();
                        if (schedulePreviewViewState.H().B()) {
                            composer.a0(1119171258);
                            jP = ComposeColorsKt.j(composer, 0).q();
                        } else {
                            composer.a0(1119172089);
                            jP = ComposeColorsKt.j(composer, 0).p();
                        }
                        composer.U();
                        long jS = ComposeColorsKt.j(composer, 0).s();
                        if (schedulePreviewViewState.H().B()) {
                            composer.a0(1119178554);
                            jP2 = ComposeColorsKt.j(composer, 0).q();
                        } else {
                            composer.a0(1119179385);
                            jP2 = ComposeColorsKt.j(composer, 0).p();
                        }
                        composer.U();
                        ScheduleSummaryScreenKt.y(immutableListG2, null, jS, jP, jP2, (schedulePreviewViewState.H().B() || ProfileWithConfiguration.n(profileWithConfiguration2, 0L, 1, null) == null) ? false : true, composer, 0, 2);
                        composer.U();
                    }
                    composer.U();
                }
                composer.U();
            } else {
                composer.a0(332891610);
                QuickBlockCardKt.z1(false, SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(12)), ComposeColorsKt.j(composer, 0).p(), ComposeColorsKt.j(composer, 0).s(), 0L, ((Number) state.getValue()).floatValue(), composer, 48, 17);
                composer.U();
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
    public static final Unit x(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        p(schedulePreviewViewState, function1, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
