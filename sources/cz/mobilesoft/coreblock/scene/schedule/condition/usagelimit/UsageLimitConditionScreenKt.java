package cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ChipKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.timepicker.StatelessTimePickerKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerState;
import cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.threeten.bp.DayOfWeek;

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
public final class UsageLimitConditionScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(CoroutineScope coroutineScope, ScaffoldState scaffoldState, boolean z2, ConditionDTO.UsageLimitDTO usageLimitDTO, UsageLimitConditionViewModel usageLimitConditionViewModel, Function1 function1, Function1 function12, Function0 function0, int i3, Composer composer, int i4) {
        y(coroutineScope, scaffoldState, z2, usageLimitDTO, usageLimitConditionViewModel, function1, function12, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void B(final UsageLimitConditionViewState usageLimitConditionViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-293123829);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(usageLimitConditionViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-293123829, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.Content (UsageLimitConditionScreen.kt:204)");
            }
            TimeConditionConfigurationViewState timeConditionConfigurationViewStateD = usageLimitConditionViewState.d();
            boolean zK = usageLimitConditionViewState.e().k();
            TimePickerState timePickerStateI = usageLimitConditionViewState.e().i();
            UsageLimit.PeriodType periodTypeH = usageLimitConditionViewState.e().h();
            int i5 = i4 & 112;
            boolean z2 = i5 == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UsageLimitConditionScreenKt.C(function1, (UsageLimit.PeriodType) obj);
                    }
                };
                composerK.w(objG);
            }
            Function1 function12 = (Function1) objG;
            boolean z3 = i5 == 32;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UsageLimitConditionScreenKt.D(function1, (TimePickerState) obj);
                    }
                };
                composerK.w(objG2);
            }
            V(timePickerStateI, zK, periodTypeH, function12, (Function1) objG2, composerK, 0);
            Configuration configurationF = timeConditionConfigurationViewStateD.f();
            boolean zI = timeConditionConfigurationViewStateD.i();
            boolean zM = timeConditionConfigurationViewStateD.m();
            boolean z4 = i5 == 32;
            Object objG3 = composerK.G();
            if (z4 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UsageLimitConditionScreenKt.E(function1);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function0 = (Function0) objG3;
            boolean z5 = i5 == 32;
            Object objG4 = composerK.G();
            if (z5 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UsageLimitConditionScreenKt.F(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG4);
            }
            Function1 function13 = (Function1) objG4;
            boolean z6 = i5 == 32;
            Object objG5 = composerK.G();
            if (z6 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UsageLimitConditionScreenKt.G(function1, (IntervalDTO) obj);
                    }
                };
                composerK.w(objG5);
            }
            Function1 function14 = (Function1) objG5;
            boolean z7 = i5 == 32;
            Object objG6 = composerK.G();
            if (z7 || objG6 == Composer.f23746a.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UsageLimitConditionScreenKt.H(function1, (IntervalDTO) obj);
                    }
                };
                composerK.w(objG6);
            }
            BaseConditionScreenKt.R0(configurationF, zI, zM, function0, function13, function14, (Function1) objG6, composerK, 0, 0);
            composerK = composerK;
            Configuration configurationF2 = timeConditionConfigurationViewStateD.f();
            boolean zH = timeConditionConfigurationViewStateD.h();
            boolean z8 = i5 == 32;
            Object objG7 = composerK.G();
            if (z8 || objG7 == Composer.f23746a.a()) {
                objG7 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.u
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return UsageLimitConditionScreenKt.I(function1, ((Boolean) obj).booleanValue(), (DayOfWeek) obj2);
                    }
                };
                composerK.w(objG7);
            }
            BaseConditionScreenKt.i0(configurationF2, zH, (Function2) objG7, composerK, 0, 0);
            BaseConditionScreenKt.n0(StringResources_androidKt.b(R.string.IF, composerK, 0), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UsageLimitConditionScreenKt.J(usageLimitConditionViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function1 function1, UsageLimit.PeriodType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new UsageLimitConditionViewEvent.OnPeriodTypeChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function1 function1, TimePickerState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new UsageLimitConditionViewEvent.OnTimePickerStateChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Function1 function1) {
        function1.invoke(new UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent(TimeConditionViewEvent.OnAddIntervalClicked.f115749a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function1 function1, boolean z2) {
        function1.invoke(new UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent(new TimeConditionViewEvent.OnAllDayLongCheckedChanged(z2)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalClicked(interval)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalRemoveClicked(interval)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Function1 function1, boolean z2, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        function1.invoke(new UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent(new TimeConditionViewEvent.OnDayCheckedChanged(z2, dayOfWeek)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(UsageLimitConditionViewState usageLimitConditionViewState, Function1 function1, int i3, Composer composer, int i4) {
        B(usageLimitConditionViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void K(final androidx.compose.material.ScaffoldState r22, final cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewState r23, boolean r24, boolean r25, boolean r26, java.lang.Float r27, final kotlin.jvm.functions.Function1 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionScreenKt.K(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewState, boolean, boolean, boolean, java.lang.Float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Function1 function1) {
        function1.invoke(UsageLimitConditionViewEvent.OnCloseClicked.f115881a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Function1 function1) {
        function1.invoke(UsageLimitConditionViewEvent.OnSaveClicked.f115883a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(UsageLimitConditionViewState usageLimitConditionViewState, Function1 function1, ColumnScope BaseConditionScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseConditionScreen, "$this$BaseConditionScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1105736159, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.RootCompose.<anonymous> (UsageLimitConditionScreen.kt:193)");
            }
            B(usageLimitConditionViewState, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(ScaffoldState scaffoldState, UsageLimitConditionViewState usageLimitConditionViewState, boolean z2, boolean z3, boolean z4, Float f3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        K(scaffoldState, usageLimitConditionViewState, z2, z3, z4, f3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void P(final cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.UsageLimitDTO r29, final java.lang.Long r30, final boolean r31, final kotlin.jvm.functions.Function1 r32, boolean r33, boolean r34, boolean r35, java.lang.Float r36, final kotlin.jvm.functions.Function0 r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 786
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionScreenKt.P(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$UsageLimitDTO, java.lang.Long, boolean, kotlin.jvm.functions.Function1, boolean, boolean, boolean, java.lang.Float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder Q(ConditionDTO.UsageLimitDTO usageLimitDTO, Long l3, boolean z2) {
        return ParametersHolderKt.b(usageLimitDTO, l3, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(boolean z2, Function1 function1) {
        if (z2) {
            function1.invoke(UsageLimitConditionViewEvent.OnCloseClicked.f115881a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Function1 function1) {
        function1.invoke(new UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent(TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Function1 function1, UsageLimitConditionViewState usageLimitConditionViewState, long j3, long j4) {
        function1.invoke(new UsageLimitConditionViewEvent.UsageLimitTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalSet(usageLimitConditionViewState.d().g(), j3, j4)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(ConditionDTO.UsageLimitDTO usageLimitDTO, Long l3, boolean z2, Function1 function1, boolean z3, boolean z4, boolean z5, Float f3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        P(usageLimitDTO, l3, z2, function1, z3, z4, z5, f3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void V(final TimePickerState timePickerState, final boolean z2, final UsageLimit.PeriodType periodType, final Function1 onTabSelected, final Function1 onTimePickerStateChanged, Composer composer, final int i3) {
        int i4;
        boolean z3;
        Intrinsics.checkNotNullParameter(timePickerState, "timePickerState");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Intrinsics.checkNotNullParameter(onTabSelected, "onTabSelected");
        Intrinsics.checkNotNullParameter(onTimePickerStateChanged, "onTimePickerStateChanged");
        Composer composerK = composer.k(-935254306);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(timePickerState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? 32 : 16;
        } else {
            z3 = z2;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.e(periodType.ordinal()) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onTabSelected) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onTimePickerStateChanged) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-935254306, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitSelectionContent (UsageLimitConditionScreen.kt:255)");
            }
            final boolean z4 = z3;
            CardsKt.k(PaddingKt.k(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(8), 1, null), 0L, 0.0f, null, null, ComposableLambdaKt.e(447977947, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return UsageLimitConditionScreenKt.W(periodType, onTabSelected, timePickerState, onTimePickerStateChanged, z4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 196608, 30);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UsageLimitConditionScreenKt.a0(timePickerState, z2, periodType, onTabSelected, onTimePickerStateChanged, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(UsageLimit.PeriodType periodType, final Function1 function1, TimePickerState timePickerState, Function1 function12, boolean z2, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(447977947, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitSelectionContent.<anonymous> (UsageLimitConditionScreen.kt:262)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.i(companion, Dp.g(f3)), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 48);
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
            EnumEntries<UsageLimit.PeriodType> entries = UsageLimit.PeriodType.getEntries();
            int iOrdinal = periodType.ordinal();
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return UsageLimitConditionScreenKt.X(function1, ((Integer) obj).intValue(), (UsageLimit.PeriodType) obj2);
                    }
                };
                composer.w(objG);
            }
            ChipKt.o(null, false, 0.0f, entries, iOrdinal, 0L, (Function2) objG, null, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return UsageLimitConditionScreenKt.Y((UsageLimit.PeriodType) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 0, 167);
            TimePickerConfiguration timePickerConfigurationB = TimePickerConfiguration.b(TimePickerConfiguration.f133137r.a(composer, 6), 0, ComposeColorsKt.j(composer, 0).l0(), null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131069, null);
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return UsageLimitConditionScreenKt.Z(((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG2);
            }
            StatelessTimePickerKt.N(null, timePickerState, timePickerConfigurationB, function12, (Function1) objG2, composer, 24576, 1);
            TextKt.c(StringHelperExtKt.e(StringResources_androidKt.b(periodType.getPerPeriodRes(), composer, 0)), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            if (z2) {
                composer.a0(-276942371);
            } else {
                composer.a0(-264691822);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
                BaseConditionScreenKt.x0(PremiumFeature.USAGE_LIMIT_UNLIMITED, composer, 6);
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
    public static final Unit X(Function1 function1, int i3, UsageLimit.PeriodType periodType) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        function1.invoke(periodType);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Y(UsageLimit.PeriodType SelectableChipRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(SelectableChipRow, "$this$SelectableChipRow");
        composer.a0(-222831690);
        if (ComposerKt.M()) {
            ComposerKt.U(-222831690, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitSelectionContent.<anonymous>.<anonymous>.<anonymous> (UsageLimitConditionScreen.kt:274)");
        }
        String lowerCase = StringResources_androidKt.b(SelectableChipRow.getTitleRes(), composer, 0).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strC = StringHelperExtKt.c(lowerCase);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(boolean z2) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(TimePickerState timePickerState, boolean z2, UsageLimit.PeriodType periodType, Function1 function1, Function1 function12, int i3, Composer composer, int i4) {
        V(timePickerState, z2, periodType, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void y(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final boolean z2, final ConditionDTO.UsageLimitDTO usageLimitDTO, final UsageLimitConditionViewModel usageLimitConditionViewModel, final Function1 function1, final Function1 function12, final Function0 function0, Composer composer, final int i3) {
        int i4;
        ScaffoldState scaffoldState2;
        Composer composer2;
        Composer composerK = composer.k(645718366);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            scaffoldState2 = scaffoldState;
            i4 |= composerK.Z(scaffoldState2) ? 32 : 16;
        } else {
            scaffoldState2 = scaffoldState;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(usageLimitConditionViewModel) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(function12) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(function0) ? 8388608 : 4194304;
        }
        int i5 = i4;
        if (composerK.r((4726931 & i5) != 4726930, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(645718366, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.CommandProcessor (UsageLimitConditionScreen.kt:136)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            int i6 = 29360128 & i5;
            boolean z3 = ((i5 & 896) == 256) | (i6 == 8388608);
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UsageLimitConditionScreenKt.z(z2, function0);
                    }
                };
                composerK.w(objG2);
            }
            ComposeDialogsKt.H0(mutableState, (Function0) objG2, composerK, 6);
            boolean zI = (i6 == 8388608) | ((i5 & 112) == 32) | composerK.I(coroutineScope) | ((3670016 & i5) == 1048576);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                UsageLimitConditionScreenKt$CommandProcessor$2$1 usageLimitConditionScreenKt$CommandProcessor$2$1 = new UsageLimitConditionScreenKt$CommandProcessor$2$1(function0, mutableState, scaffoldState2, coroutineScope, function12, null);
                composerK.w(usageLimitConditionScreenKt$CommandProcessor$2$1);
                objG3 = usageLimitConditionScreenKt$CommandProcessor$2$1;
            }
            composer2 = composerK;
            FlowExtKt.g(usageLimitConditionViewModel, null, (Function2) objG3, composer2, (i5 >> 12) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UsageLimitConditionScreenKt.A(coroutineScope, scaffoldState, z2, usageLimitDTO, usageLimitConditionViewModel, function1, function12, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(boolean z2, Function0 function0) {
        AnswersHelper.f128199a.R4(ProfileType.USAGE_LIMIT, z2);
        function0.invoke();
        return Unit.f139807a;
    }
}
