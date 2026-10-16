package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker;

import android.content.res.Configuration;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.SnackbarHostKt;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material3.DatePickerColors;
import androidx.compose.material3.DatePickerDefaults;
import androidx.compose.material3.DatePickerKt;
import androidx.compose.material3.DatePickerState;
import androidx.compose.material3.DisplayMode;
import androidx.compose.material3.SelectableDates;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavHostController;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState;
import java.io.IOException;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;
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
public final class DateTimePickerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(PauseBlockingViewState pauseBlockingViewState, Function1 function1, CoroutineScope coroutineScope, SnackbarHostState snackbarHostState, String str) {
        long jC = pauseBlockingViewState.e().c() + pauseBlockingViewState.e().f();
        if (jC > TimeHelperExt.f128663a.f()) {
            function1.invoke(new PauseBlockingViewEvent.OnPauseClicked(new PauseBlockingViewState.PauseBlockingType.UntilDateAndTime(jC)));
        } else {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new DateTimePickerScreenKt$DateTimePickerScreen$4$1$2$1$1(snackbarHostState, str, null), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function1 function1, long j3) {
        function1.invoke(new PauseBlockingViewEvent.OnTimeSelected(j3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(NavHostController navHostController, Function1 function1, PauseBlockingViewState pauseBlockingViewState, int i3, Composer composer, int i4) {
        t(navHostController, function1, pauseBlockingViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void E(Modifier modifier, final Function1 function1, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Composer composer2;
        int iA;
        float fMin;
        Composer composerK = composer.k(-247192680);
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
            i5 |= composerK.I(function1) ? 32 : 16;
        }
        int i7 = i5;
        if (composerK.r((i7 & 19) != 18, i7 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-247192680, i7, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.PauseDatePicker (DateTimePickerScreen.kt:208)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = DateHelper.h();
                composerK.w(objG);
            }
            final Calendar calendar = (Calendar) objG;
            float f3 = 16;
            float fG = Dp.g(f3);
            float fG2 = Dp.g(360);
            float fG3 = Dp.g(Dp.g(fG * 2) + fG2);
            float fG4 = Dp.g(320);
            float fG5 = Dp.g(((Configuration) composerK.q(AndroidCompositionLocals_androidKt.f())).screenWidthDp);
            Long lValueOf = Long.valueOf(DateHelper.j().getTimeInMillis() + 43200000);
            if (Dp.f(fG5, fG4) >= 0) {
                fMin = Math.min(fG5 / fG3, 1.0f);
                iA = DisplayMode.f17460b.b();
            } else {
                iA = DisplayMode.f17460b.a();
                fMin = 1.0f;
            }
            float f4 = fMin;
            Modifier modifier4 = modifier3;
            DatePickerState datePickerStateK = DatePickerKt.K(lValueOf, null, null, iA, new SelectableDates() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreenKt$PauseDatePicker$datePickerState$1
                @Override // androidx.compose.material3.SelectableDates
                public boolean a(int i8) {
                    int i9 = calendar.get(1);
                    return i9 <= i8 && i8 <= i9 + 1;
                }

                @Override // androidx.compose.material3.SelectableDates
                public boolean b(long j3) {
                    return j3 <= calendar.getTimeInMillis() + 2592000000L && calendar.getTimeInMillis() <= j3;
                }
            }, composerK, 0, 6);
            Long lI = datePickerStateK.i();
            boolean Z = ((i7 & 112) == 32) | composerK.Z(datePickerStateK) | composerK.I(calendar);
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                objG2 = new DateTimePickerScreenKt$PauseDatePicker$1$1(function1, datePickerStateK, calendar, null);
                composerK.w(objG2);
            }
            EffectsKt.g(lI, (Function2) objG2, composerK, 0);
            float fG6 = f4 == 1.0f ? Dp.g(f3) : f4 > 0.98f ? Dp.g(10) : f4 > 0.95f ? Dp.g(5) : Dp.g(0);
            Modifier.Companion companion2 = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion2, fG6), composerK, 0);
            Modifier modifierA = ClipKt.a(SizeKt.h(modifier4, 0.0f, 1, null).then(f4 == 1.0f ? PaddingKt.i(companion2, Dp.g(f3)) : ScaleKt.a(SizeKt.u(companion2, fG2, 0.0f, 2, null), f4)), RoundedCornerShapeKt.d(Dp.g(f3)));
            DatePickerColors datePickerColorsC = DatePickerDefaults.f16873a.c(composerK, 6);
            long jX = ComposeColorsKt.j(composerK, 0).X();
            long jQ = ComposeColorsKt.j(composerK, 0).q();
            long jB = ComposeColorsKt.j(composerK, 0).b();
            long jP = ComposeColorsKt.j(composerK, 0).p();
            long jS = ComposeColorsKt.j(composerK, 0).s();
            long jB2 = ComposeColorsKt.j(composerK, 0).b();
            long jB3 = ComposeColorsKt.j(composerK, 0).b();
            long jR = Color.r(ComposeColorsKt.j(composerK, 0).b(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
            long jP2 = ComposeColorsKt.j(composerK, 0).p();
            long jS2 = ComposeColorsKt.j(composerK, 0).s();
            long jB4 = ComposeColorsKt.j(composerK, 0).b();
            long jR2 = Color.r(ComposeColorsKt.j(composerK, 0).b(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
            long jB5 = ComposeColorsKt.j(composerK, 0).b();
            Color.Companion companion3 = Color.f25715b;
            DatePickerKt.b(datePickerStateK, modifierA, null, null, null, false, datePickerColorsC.a((23401494 & 1) != 0 ? datePickerColorsC.f16847a : jX, (23401494 & 2) != 0 ? datePickerColorsC.f16848b : 0L, (23401494 & 4) != 0 ? datePickerColorsC.f16849c : 0L, (23401494 & 8) != 0 ? datePickerColorsC.f16850d : jQ, (23401494 & 16) != 0 ? datePickerColorsC.f16851e : 0L, (23401494 & 32) != 0 ? datePickerColorsC.f16852f : jB, (23401494 & 64) != 0 ? datePickerColorsC.f16853g : jP, (23401494 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? datePickerColorsC.f16854h : jS, (23401494 & Function.MAX_NARGS) != 0 ? datePickerColorsC.f16855i : jB2, (23401494 & 512) != 0 ? datePickerColorsC.f16856j : jB3, (23401494 & 1024) != 0 ? datePickerColorsC.f16857k : 0L, (23401494 & 2048) != 0 ? datePickerColorsC.f16858l : jR, (23401494 & 4096) != 0 ? datePickerColorsC.f16859m : 0L, (23401494 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? datePickerColorsC.f16860n : jP2, (23401494 & 16384) != 0 ? datePickerColorsC.f16861o : jS2, (23401494 & 32768) != 0 ? datePickerColorsC.f16862p : jB4, (23401494 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? datePickerColorsC.f16863q : 0L, (23401494 & 131072) != 0 ? datePickerColorsC.f16864r : jR2, (23401494 & 262144) != 0 ? datePickerColorsC.f16865s : 0L, (23401494 & 524288) != 0 ? datePickerColorsC.f16866t : jB5, (23401494 & 1048576) != 0 ? datePickerColorsC.f16867u : companion3.j(), (23401494 & 2097152) != 0 ? datePickerColorsC.f16868v : 0L, (23401494 & 4194304) != 0 ? datePickerColorsC.f16869w : 0L, (23401494 & 8388608) != 0 ? datePickerColorsC.f16870x : companion3.j(), (23401494 & 16777216) != 0 ? datePickerColorsC.f16871y : null), composerK, 224256, 4);
            composer2 = composerK;
            SpacerKt.a(SizeKt.i(companion2, fG6), composer2, 0);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateTimePickerScreenKt.F(modifier2, function1, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Modifier modifier, Function1 function1, int i3, int i4, Composer composer, int i5) {
        E(modifier, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void G(final java.lang.String r36, final java.lang.String r37, kotlin.jvm.functions.Function0 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 701
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreenKt.G(java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(String str, String str2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        G(str, str2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void K(java.lang.String r21, final androidx.compose.runtime.MutableState r22, final kotlin.jvm.functions.Function1 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreenKt.K(java.lang.String, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder L() {
        return ParametersHolderKt.b(new TimePickerViewModel.Params(TimePickerConfig.f133036h.c(), TimeHelperExt.f128663a.f() - DateHelper.h().getTimeInMillis(), null, false, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(String str, final TimePickerViewState timePickerViewState, TimePickerViewModel timePickerViewModel, final Function1 function1, final MutableState mutableState, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1725509346, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.TimePickerBottomSheet.<anonymous> (DateTimePickerScreen.kt:370)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            TextKt.c(str, PaddingKt.i(companion, Dp.g(f3)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).h(), composer, 48, 0, 65532);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            ComposeSwipeableTimePickerKt.W(timePickerViewState, null, FlowExtKt.n(timePickerViewModel, composer, 0), composer, 0, 2);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.Sv, composer, 0);
            boolean zU = timePickerViewState.u();
            boolean Z = composer.Z(function1) | composer.Z(timePickerViewState) | composer.Z(mutableState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateTimePickerScreenKt.N(function1, timePickerViewState, mutableState);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, zU, false, null, (Function0) objG, composer, 0, 25);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function1 function1, TimePickerViewState timePickerViewState, MutableState mutableState) {
        function1.invoke(Long.valueOf(timePickerViewState.o()));
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(String str, MutableState mutableState, Function1 function1, int i3, int i4, Composer composer, int i5) {
        K(str, mutableState, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void t(final NavHostController navHostController, final Function1 onEvent, final PauseBlockingViewState viewState, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(navHostController, "navHostController");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Composer composerK = composer.k(99276430);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navHostController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(viewState) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(99276430, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreen (DateTimePickerScreen.kt:93)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new SnackbarHostState();
                composerK.w(objG3);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG4);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG4;
            Long lValueOf = Long.valueOf(viewState.e().f());
            Long lValueOf2 = Long.valueOf(viewState.e().c());
            boolean z2 = (i4 & 896) == 256;
            Object objG5 = composerK.G();
            if (z2 || objG5 == companion.a()) {
                objG5 = new DateTimePickerScreenKt$DateTimePickerScreen$1$1(mutableState2, viewState, null);
                composerK.w(objG5);
            }
            EffectsKt.f(lValueOf, lValueOf2, (Function2) objG5, composerK, 0);
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composerK, 6)), null, ComposableLambdaKt.e(-1701440621, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateTimePickerScreenKt.u(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, ComposableLambdaKt.e(1961776007, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateTimePickerScreenKt.x(snackbarHostState, (SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-874860340, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.o
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateTimePickerScreenKt.y(onEvent, viewState, mutableState2, coroutineScope, mutableState, snackbarHostState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 24960, 12582912, 131050);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateTimePickerScreenKt.D(navHostController, onEvent, viewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(final NavHostController navHostController, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1701440621, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreen.<anonymous> (DateTimePickerScreen.kt:106)");
            }
            AppBarKt.g(ComposableSingletons$DateTimePickerScreenKt.f100220a.d(), BackgroundKt.d(SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(56)), ComposeColorsKt.j(composer, 0).e(), null, 2, null), ComposableLambdaKt.e(-985720691, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateTimePickerScreenKt.v(navHostController, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit v(final NavHostController navHostController, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-985720691, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreen.<anonymous>.<anonymous> (DateTimePickerScreen.kt:121)");
            }
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G0, composer, 6);
            String strB = StringResources_androidKt.b(R.string.Re, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateTimePickerScreenKt.w(navHostController);
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
    public static final Unit w(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(SnackbarHostState snackbarHostState, SnackbarHostState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1961776007, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreen.<anonymous> (DateTimePickerScreen.kt:132)");
            }
            SnackbarHostKt.b(snackbarHostState, null, null, composer, 6, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(PauseBlockingViewState pauseBlockingViewState, final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1729742403, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreen.<anonymous>.<anonymous>.<anonymous> (DateTimePickerScreen.kt:150)");
            }
            String strB = StringResources_androidKt.b(R.string.QC, composer, 0);
            String strE = pauseBlockingViewState.e().e();
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateTimePickerScreenKt.A(mutableState);
                    }
                };
                composer.w(objG);
            }
            G(strB, strE, (Function0) objG, composer, 384, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(final Function1 function1, final PauseBlockingViewState pauseBlockingViewState, MutableState mutableState, final CoroutineScope coroutineScope, final MutableState mutableState2, final SnackbarHostState snackbarHostState, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Object obj;
        int i5;
        final Function1 function12;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-874860340, i4, -1, vgWWUoTKYyuC.JRPBPVPvHVxTbw);
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(SizeKt.f(companion, 0.0f, 1, null), paddingValues);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            E(null, function1, composer, 0, 1);
            float f3 = 16;
            ComposeCardsKt.m(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(-1729742403, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DateTimePickerScreenKt.z(pauseBlockingViewState, mutableState2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3078, 4);
            TextKt.c(StringResources_androidKt.c(R.string.vu, new Object[]{pauseBlockingViewState.e().d()}, composer, 0), PaddingKt.j(companion, Dp.g(f3), Dp.g(12)), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 48, 0, 65528);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            final String strB = StringResources_androidKt.b(R.string.a9, composer, 0);
            String strB2 = StringResources_androidKt.b(R.string.wn, composer, 0);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            boolean Z = composer.Z(pauseBlockingViewState) | composer.Z(function1) | composer.I(coroutineScope) | composer.Z(strB);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                i5 = 0;
                obj = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateTimePickerScreenKt.B(pauseBlockingViewState, function1, coroutineScope, snackbarHostState, strB);
                    }
                };
                function12 = function1;
                composer.w(obj);
            } else {
                i5 = 0;
                obj = objG;
                function12 = function1;
            }
            ComposeButtonsKt.J(null, strB2, zBooleanValue, false, null, (Function0) obj, composer, 0, 25);
            String strB3 = StringResources_androidKt.b(R.string.Yv, composer, i5);
            boolean Z2 = composer.Z(function12);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return DateTimePickerScreenKt.C(function12, ((Long) obj2).longValue());
                    }
                };
                composer.w(objG2);
            }
            K(strB3, mutableState2, (Function1) objG2, composer, 48, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
