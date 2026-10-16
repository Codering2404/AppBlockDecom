package cz.mobilesoft.coreblock.scene.schedule.condition;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SwitchKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.common.Constants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenHabitsListKt;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration;
import cz.mobilesoft.coreblock.scene.schedule.detail.StateInfoRowKt;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.profile.IntervalsHelper;
import cz.mobilesoft.coreblock.view.ScreenProgressBarKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import cz.mobilesoft.coreblock.view.timepicker.StatelessTimePickerKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerState;
import cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.temporal.WeekFields;

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
public final class BaseConditionScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f115183a = EnumEntriesKt.a(DayOfWeek.values());
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void A0(final cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO r21, boolean r22, final kotlin.jvm.functions.Function0 r23, final kotlin.jvm.functions.Function2 r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt.A0(cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final TimePickerState B0(MutableState mutableState) {
        return (TimePickerState) mutableState.getValue();
    }

    private static final boolean C0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(final MutableState mutableState, final MutableState mutableState2, final Function2 function2, final Function0 function0, final MutableState mutableState3, MutableState mutableState4, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        long jP0;
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(696686210, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.TimeRangePickerBottomSheet.<anonymous> (BaseConditionScreen.kt:625)");
            }
            Density density = (Density) composer.q(CompositionLocalsKt.f());
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(2)), companion2.i(), composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            final RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ProvidedValue providedValueD = CompositionLocalsKt.f().d(DensityKt.a(density.getDensity(), 1.0f));
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(480515880, true, new Function2() { // from class: m1.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseConditionScreenKt.E0(rowScopeInstance, mutableState, mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            int i4 = ProvidedValue.f24012i;
            CompositionLocalKt.b(providedValueD, composableLambdaE, composer, i4 | 48);
            TextKt.c(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 6, 0, 65530);
            CompositionLocalKt.b(CompositionLocalsKt.f().d(DensityKt.a(density.getDensity(), 1.0f)), ComposableLambdaKt.e(-1192644079, true, new Function2() { // from class: m1.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseConditionScreenKt.H0(rowScopeInstance, mutableState2, mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, i4 | 48);
            composer.y();
            float f4 = 24;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            String strG = DateHelperExtKt.g((Context) composer.q(AndroidCompositionLocals_androidKt.g()), N0(mutableState2).i(B0(mutableState)) / ((long) 1000));
            TextStyle textStyleB = ComposeTypographyKt.g(composer, 0).b();
            if (C0(mutableState4)) {
                composer.a0(-432341927);
                jP0 = ComposeColorsKt.j(composer, 0).q();
            } else {
                composer.a0(-432341101);
                jP0 = ComposeColorsKt.j(composer, 0).p0();
            }
            composer.U();
            TextKt.c(strG, null, jP0, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleB, composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            boolean zC0 = C0(mutableState4);
            String strB = StringResources_androidKt.b(R.string.d8, composer, 0);
            boolean Z = composer.Z(mutableState) | composer.Z(mutableState2) | composer.Z(function2) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: m1.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseConditionScreenKt.K0(function2, function0, mutableState, mutableState2);
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.u(modifierH2, 0.0f, 0.0f, null, null, null, strB, null, 0L, null, null, zC0, false, (Function0) objG, composer, 6, 0, 6078);
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
    public static final Unit E0(RowScope rowScope, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(480515880, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.TimeRangePickerBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BaseConditionScreen.kt:645)");
            }
            Modifier modifierC = RowScope.c(rowScope, Modifier.b8, 1.0f, false, 2, null);
            TimePickerState timePickerStateB0 = B0(mutableState);
            TimePickerConfiguration timePickerConfigurationB = TimePickerConfiguration.b(TimePickerConfiguration.f133137r.a(composer, 6), 0, 0L, null, Dp.g(0), 0.0f, Dp.g(4), 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131031, null);
            boolean Z = composer.Z(mutableState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: m1.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseConditionScreenKt.F0(mutableState, (TimePickerState) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: m1.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseConditionScreenKt.G0(mutableState2, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG2);
            }
            StatelessTimePickerKt.N(modifierC, timePickerStateB0, timePickerConfigurationB, function1, (Function1) objG2, composer, 24576, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(MutableState mutableState, TimePickerState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        M0(mutableState, newState);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(MutableState mutableState, boolean z2) {
        Q0(mutableState, !z2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(RowScope rowScope, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1192644079, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.TimeRangePickerBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BaseConditionScreen.kt:672)");
            }
            Modifier modifierC = RowScope.c(rowScope, Modifier.b8, 1.0f, false, 2, null);
            TimePickerState timePickerStateN0 = N0(mutableState);
            TimePickerConfiguration timePickerConfigurationB = TimePickerConfiguration.b(TimePickerConfiguration.f133137r.a(composer, 6), 0, 0L, null, Dp.g(0), 0.0f, Dp.g(4), 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131031, null);
            boolean Z = composer.Z(mutableState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: m1.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseConditionScreenKt.I0(mutableState, (TimePickerState) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: m1.l0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseConditionScreenKt.J0(mutableState2, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG2);
            }
            StatelessTimePickerKt.N(modifierC, timePickerStateN0, timePickerConfigurationB, function1, (Function1) objG2, composer, 24576, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(MutableState mutableState, TimePickerState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        O0(mutableState, newState);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(MutableState mutableState, boolean z2) {
        Q0(mutableState, !z2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(Function2 function2, Function0 function0, MutableState mutableState, MutableState mutableState2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(B0(mutableState).s());
        long minutes2 = timeUnit.toMinutes(N0(mutableState2).s());
        if (minutes - minutes2 != 0) {
            function2.invoke(Long.valueOf(minutes), Long.valueOf(minutes2));
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(IntervalDTO intervalDTO, boolean z2, Function0 function0, Function2 function2, int i3, int i4, Composer composer, int i5) {
        A0(intervalDTO, z2, function0, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void M0(MutableState mutableState, TimePickerState timePickerState) {
        mutableState.setValue(timePickerState);
    }

    private static final TimePickerState N0(MutableState mutableState) {
        return (TimePickerState) mutableState.getValue();
    }

    private static final void O0(MutableState mutableState, TimePickerState timePickerState) {
        mutableState.setValue(timePickerState);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void P(final androidx.compose.material.ScaffoldState r23, boolean r24, boolean r25, java.lang.String r26, final java.lang.String r27, boolean r28, final kotlin.jvm.functions.Function0 r29, final kotlin.jvm.functions.Function2 r30, final kotlin.jvm.functions.Function2 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt.P(androidx.compose.material.ScaffoldState, boolean, boolean, java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean P0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(ScaffoldState scaffoldState, final Function2 function2, final boolean z2, final String str, final boolean z3, final Function0 function0, final boolean z4, final String str2, final Function2 function22, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1088482644, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScaffold.<anonymous> (BaseConditionScreen.kt:112)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composer, 6)), scaffoldState, ComposableLambdaKt.e(1711272753, true, new Function2() { // from class: m1.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseConditionScreenKt.R(function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(-1539906574, true, new Function2() { // from class: m1.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseConditionScreenKt.S(z2, str, z3, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableSingletons$BaseConditionScreenKt.f115184a.d(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(537948650, true, new Function3() { // from class: m1.d0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseConditionScreenKt.T(z4, str2, function22, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 28032, 12779520, 98272);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final void Q0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Function2 function2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1711272753, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScaffold.<anonymous>.<anonymous> (BaseConditionScreen.kt:120)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void R0(final cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration r19, boolean r20, boolean r21, final kotlin.jvm.functions.Function0 r22, final kotlin.jvm.functions.Function1 r23, final kotlin.jvm.functions.Function1 r24, final kotlin.jvm.functions.Function1 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt.R0(cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration, boolean, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(boolean z2, String str, boolean z3, Function0 function0, Composer composer, int i3) {
        String str2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1539906574, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScaffold.<anonymous>.<anonymous> (BaseConditionScreen.kt:141)");
            }
            FlatButtonColors flatButtonColors = z2 ? FlatButtonColors.Disabled.f131162a : FlatButtonColors.Primary.f131166a;
            if (str == null) {
                composer.a0(1913506080);
                String strB = StringResources_androidKt.b(z3 ? R.string.l8 : R.string.Lt, composer, 0);
                composer.U();
                str2 = strB;
            } else {
                composer.a0(1913505646);
                composer.U();
                str2 = str;
            }
            FlatButtonsKt.p(flatButtonColors, false, str2, false, function0, composer, 0, 10);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(Configuration configuration, final Function1 function1, Function1 function12, boolean z2, boolean z3, Function0 function0, Function1 function13, ColumnScope BaseCard, Composer composer, int i3) {
        Function1 function14;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1418118229, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.TimeSelectionContent.<anonymous> (BaseConditionScreen.kt:322)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.o(Dp.g(f3)), horizontalG, composer, 54);
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
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(10)), companion2.i(), composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.c(StringResources_androidKt.b(R.string.tD, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            TextKt.c(StringResources_androidKt.b(R.string.f95827o0, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            Composer composer2 = composer;
            float f4 = 32;
            SwitchKt.a(configuration.l(), function13, SizeKt.i(SizeKt.A(companion, Dp.g(52)), Dp.g(f4)), null, false, cz.mobilesoft.coreblock.view.compose.material3.SwitchKt.a(composer2, 0), null, composer2, 384, 88);
            composer2.y();
            if (configuration.l()) {
                composer2.a0(-346005213);
            } else {
                composer2.a0(-331447520);
                composer2.a0(1651875582);
                for (IntervalDTO intervalDTO : CollectionsKt.sortedWith(configuration.e(), new Comparator() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt$TimeSelectionContent$lambda$0$0$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ComparisonsKt.d(Long.valueOf(((IntervalDTO) obj).b()), Long.valueOf(((IntervalDTO) obj2).b()));
                    }
                })) {
                    if (configuration.e().size() > 1) {
                        composer2.a0(-331170070);
                        boolean Z = composer2.Z(function1);
                        Object objG = composer2.G();
                        if (Z || objG == Composer.f23746a.a()) {
                            objG = new Function1() { // from class: m1.v
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BaseConditionScreenKt.T0(function1, (IntervalDTO) obj);
                                }
                            };
                            composer2.w(objG);
                        }
                        composer2.U();
                        function14 = (Function1) objG;
                    } else {
                        composer2.a0(-331078466);
                        composer2.U();
                        function14 = null;
                    }
                    q0(intervalDTO, function14, function12, composer2, 0, 0);
                }
                composer2.U();
                if (z2 || configuration.e().size() < Limit.TIMES_LIMIT.getLimitValue()) {
                    composer2.a0(-330876190);
                    float f5 = 12;
                    FlatButtonsKt.u(ComposableExtKt.u(SizeKt.I(Modifier.b8, null, false, 3, null), z3), Dp.g(f4), Dp.g(f5), PaddingKt.c(Dp.g(f5), 0.0f, 2, null), FlatButtonColors.b(FlatButtonColors.Secondary.f131167a, Color.n(ComposeColorsKt.j(composer2, 0).b()), null, 2, null), null, StringResources_androidKt.b(R.string.M, composer2, 0), null, 0L, Integer.valueOf(R.drawable.f95554q0), null, false, false, function0, composer, 3504, 384, 3488);
                    composer2 = composer;
                } else {
                    composer2.a0(-346005213);
                }
                composer2.U();
                if (z2) {
                    composer2.a0(-346005213);
                } else {
                    composer2.a0(-330035284);
                    x0(PremiumFeature.INTERVALS_UNLIMITED, composer2, 6);
                }
                composer2.U();
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(boolean z2, String str, Function2 function2, PaddingValues it, Composer composer, int i3) {
        int i4;
        Modifier modifierG;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(537948650, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScaffold.<anonymous>.<anonymous> (BaseConditionScreen.kt:122)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = SizeKt.d(PaddingKt.h(companion, it), 0.0f, 1, null);
            if (z2) {
                composer.a0(1572585071);
                modifierG = ScrollKt.g(companion, ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
                composer.U();
            } else {
                composer.a0(1572586418);
                composer.U();
                modifierG = companion;
            }
            Modifier modifierThen = modifierD.then(modifierG);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierThen);
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
            TextKt.c(str, PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), Dp.g(8)), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65020);
            function2.invoke(composer, 0);
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
    public static final Unit T0(Function1 function1, IntervalDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(ScaffoldState scaffoldState, boolean z2, boolean z3, String str, String str2, boolean z4, Function0 function0, Function2 function2, Function2 function22, int i3, int i4, Composer composer, int i5) {
        P(scaffoldState, z2, z3, str, str2, z4, function0, function2, function22, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(Configuration configuration, boolean z2, boolean z3, Function0 function0, Function1 function1, Function1 function12, Function1 function13, int i3, int i4, Composer composer, int i5) {
        R0(configuration, z2, z3, function0, function1, function12, function13, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void V(final androidx.compose.material.ScaffoldState r20, boolean r21, boolean r22, java.lang.String r23, final java.lang.String r24, java.lang.Float r25, boolean r26, final kotlin.jvm.functions.Function0 r27, final kotlin.jvm.functions.Function2 r28, final kotlin.jvm.functions.Function2 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt.V(androidx.compose.material.ScaffoldState, boolean, boolean, java.lang.String, java.lang.String, java.lang.Float, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void W(final androidx.compose.material.ScaffoldState r20, boolean r21, boolean r22, boolean r23, final java.lang.String r24, java.lang.Float r25, boolean r26, final kotlin.jvm.functions.Function0 r27, final kotlin.jvm.functions.Function0 r28, final kotlin.jvm.functions.Function3 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt.W(androidx.compose.material.ScaffoldState, boolean, boolean, boolean, java.lang.String, java.lang.Float, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Function2 function2, Float f3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-267895251, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreen.<anonymous> (BaseConditionScreen.kt:174)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            function2.invoke(composer, 0);
            if (f3 == null) {
                composer.a0(-1246149213);
            } else {
                composer.a0(-1246149212);
                ScreenProgressBarKt.b(boxScopeInstance.f(companion, companion2.e()), f3.floatValue(), composer, 0, 0);
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
    public static final Unit Y(ScaffoldState scaffoldState, boolean z2, boolean z3, String str, String str2, Float f3, boolean z4, Function0 function0, Function2 function2, Function2 function22, int i3, int i4, Composer composer, int i5) {
        V(scaffoldState, z2, z3, str, str2, f3, z4, function0, function2, function22, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(boolean z2, Function3 function3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1245028059, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreen.<anonymous> (BaseConditionScreen.kt:208)");
            }
            if (z2) {
                composer.a0(-706614783);
                StateInfoRowKt.A(StringResources_androidKt.b(R.string.Ut, composer, 0), composer, 0);
            } else {
                composer.a0(-715625305);
            }
            composer.U();
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
            function3.invoke(ColumnScopeInstance.f6666a, composer, 6);
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
    public static final Unit a0(boolean z2, Function0 function0, boolean z3, Float f3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1893255516, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreen.<anonymous> (BaseConditionScreen.kt:217)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ToolbarKt.e(null, function0, null, z3, z2 ? ToolbarButtonType.Close : ToolbarButtonType.Back, false, false, null, null, composer, 0, 485);
            if (f3 == null) {
                composer.a0(712570184);
            } else {
                composer.a0(712570185);
                ScreenProgressBarKt.b(boxScopeInstance.f(companion, companion2.e()), f3.floatValue(), composer, 0, 0);
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
    public static final Unit b0(ScaffoldState scaffoldState, boolean z2, boolean z3, boolean z4, String str, Float f3, boolean z5, Function0 function0, Function0 function02, Function3 function3, int i3, int i4, Composer composer, int i5) {
        W(scaffoldState, z2, z3, z4, str, f3, z5, function0, function02, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c0(final androidx.compose.runtime.State r29, final org.threeten.bp.DayOfWeek r30, kotlin.jvm.functions.Function1 r31, long r32, long r34, long r36, long r38, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt.c0(androidx.compose.runtime.State, org.threeten.bp.DayOfWeek, kotlin.jvm.functions.Function1, long, long, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(State state, boolean z2) {
        if (state instanceof MutableState) {
            ((MutableState) state).setValue(Boolean.valueOf(z2));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier e0(final Function1 function1, final State state, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ClickableKt.f(applyIf, false, null, null, new Function0() { // from class: m1.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseConditionScreenKt.f0(function1, state);
            }
        }, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(Function1 function1, State state) {
        function1.invoke(Boolean.valueOf(!((Boolean) state.getValue()).booleanValue()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(DayOfWeek dayOfWeek, State state, long j3, long j4, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(824637585, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.DayCheckBox.<anonymous> (BaseConditionScreen.kt:516)");
            }
            Alignment alignmentE = Alignment.f25072a.e();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            String strF = dayOfWeek.f(org.threeten.bp.format.TextStyle.SHORT_STANDALONE, Locale.getDefault());
            Intrinsics.checkNotNullExpressionValue(strF, "getDisplayName(...)");
            TextKt.c(StringHelperExtKt.c(StringsKt.B1(strF, 1)), null, ((Boolean) state.getValue()).booleanValue() ? j3 : j4, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 0, 0, 65530);
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
    public static final Unit h0(State state, DayOfWeek dayOfWeek, Function1 function1, long j3, long j4, long j5, long j6, int i3, int i4, Composer composer, int i5) {
        c0(state, dayOfWeek, function1, j3, j4, j5, j6, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i0(final cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration r16, boolean r17, final kotlin.jvm.functions.Function2 r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt.i0(cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(boolean z2, String str, Configuration configuration, final Function2 function2, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-957799827, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.DaySelectionContent.<anonymous> (BaseConditionScreen.kt:249)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
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
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = arrangement.e();
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, companion2.l(), composer, 6);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.c(StringResources_androidKt.b(R.string.g9, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            Composer composer2 = composer;
            composer2.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(4));
            Modifier modifierU = ComposableExtKt.u(SizeKt.h(companion, 0.0f, 1, null), z2);
            MeasurePolicy measurePolicyB2 = RowKt.b(horizontalOrVerticalO, companion2.l(), composer2, 6);
            int iA3 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierU);
            Function0 function0A3 = companion3.a();
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
            Updater.e(composerA3, measurePolicyB2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            DayOfWeek dayOfWeekC = WeekFields.e(Locale.getDefault()).c();
            List<DayOfWeek> mutableList = CollectionsKt.toMutableList((Collection) EntriesMappings.f115183a);
            if (CollectionsKt.first(mutableList) != dayOfWeekC) {
                Collections.rotate(mutableList, mutableList.size() - mutableList.indexOf(dayOfWeekC));
            }
            composer2.a0(518758124);
            for (final DayOfWeek dayOfWeek : mutableList) {
                final boolean zContains = configuration.k().contains(dayOfWeek);
                boolean zB = composer2.b(zContains);
                Object objG = composer2.G();
                if (zB || objG == Composer.f23746a.a()) {
                    objG = SnapshotStateKt.e(new Function0() { // from class: m1.r
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(BaseConditionScreenKt.k0(zContains));
                        }
                    });
                    composer2.w(objG);
                }
                State state = (State) objG;
                RowScopeInstance rowScopeInstance2 = rowScopeInstance;
                Modifier modifierC = RowScope.c(rowScopeInstance2, Modifier.b8, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
                int iA4 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU4 = composer2.u();
                Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierC);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                Function0 function0A4 = companion4.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A4);
                } else {
                    composer2.v();
                }
                Composer composerA4 = Updater.a(composer2);
                Updater.e(composerA4, measurePolicyG, companion4.e());
                Updater.e(composerA4, compositionLocalMapU4, companion4.g());
                Function2 function2B4 = companion4.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF4, companion4.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                boolean Z = composer2.Z(function2) | composer2.e(dayOfWeek.ordinal());
                Object objG2 = composer2.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: m1.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BaseConditionScreenKt.l0(function2, dayOfWeek, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.w(objG2);
                }
                c0(state, dayOfWeek, (Function1) objG2, 0L, 0L, 0L, 0L, composer2, 0, 120);
                composer.y();
                composer2 = composer;
                rowScopeInstance = rowScopeInstance2;
            }
            composer.U();
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
    public static final Unit l0(Function2 function2, DayOfWeek dayOfWeek, boolean z2) {
        function2.invoke(Boolean.valueOf(z2), dayOfWeek);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Configuration configuration, boolean z2, Function2 function2, int i3, int i4, Composer composer, int i5) {
        i0(configuration, z2, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void n0(final String text, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerK = composer.k(-497750399);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(text) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-497750399, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.InfoBox (BaseConditionScreen.kt:531)");
            }
            InsightsScreenHabitsListKt.o(SizeKt.k(Modifier.b8, Dp.g(48), 0.0f, 2, null), null, PaddingKt.b(Dp.g(16), Dp.g(12)), ComposableLambdaKt.e(1421741094, true, new Function3() { // from class: m1.m0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseConditionScreenKt.o0(text, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3462, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: m1.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseConditionScreenKt.p0(text, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(String str, BoxScope BorderedBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BorderedBox, "$this$BorderedBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1421741094, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.InfoBox.<anonymous> (BaseConditionScreen.kt:540)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 48);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.N2, composer, 6), null, null, ComposeColorsKt.j(composer, 0).D(), composer, 48, 4);
            TextKt.c(str, PaddingKt.m(companion, Dp.g(12), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer, 0).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 48, 0, 65528);
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
    public static final Unit p0(String str, int i3, Composer composer, int i4) {
        n0(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void q0(final cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO r21, kotlin.jvm.functions.Function1 r22, final kotlin.jvm.functions.Function1 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt.q0(cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(Function1 function1, IntervalDTO intervalDTO) {
        function1.invoke(intervalDTO);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(final Context context, final IntervalDTO intervalDTO, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(30857246, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.IntervalCard.<anonymous>.<anonymous> (BaseConditionScreen.kt:418)");
            }
            BoxWithConstraintsKt.a(SizeKt.h(PaddingKt.k(SizeKt.k(Modifier.b8, Dp.g(48), 0.0f, 2, null), Dp.g(16), 0.0f, 2, null), 0.0f, 1, null), Alignment.f25072a.e(), false, ComposableLambdaKt.e(-819609720, true, new Function3() { // from class: m1.e0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseConditionScreenKt.t0(context, intervalDTO, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3126, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(Context context, IntervalDTO intervalDTO, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i3) {
        int i4;
        TextStyle textStyleH;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-819609720, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.IntervalCard.<anonymous>.<anonymous>.<anonymous> (BaseConditionScreen.kt:425)");
            }
            if (Dp.f(BoxWithConstraints.d(), Dp.g(200)) < 0) {
                composer.a0(-104025627);
                textStyleH = ComposeTypographyKt.g(composer, 0).i();
                composer.U();
            } else {
                composer.a0(-103967099);
                textStyleH = ComposeTypographyKt.g(composer, 0).h();
                composer.U();
            }
            TextStyle textStyle = textStyleH;
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer, 48);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Pair pairC = IntervalsHelper.f129240a.c(context, intervalDTO.b(), intervalDTO.a());
            String str = (String) pairC.a();
            String str2 = (String) pairC.b();
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            TextKt.c(str, modifierC, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 1, 0, null, textStyle, composer, 0, 3072, 56824);
            TextKt.c(" — ", null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 6, 0, 65530);
            TextKt.c(str2, RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 1, 0, null, textStyle, composer, 0, 3072, 56824);
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
    public static final Unit u0(final Function1 function1, final IntervalDTO intervalDTO, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-886528022, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.IntervalCard.<anonymous>.<anonymous> (BaseConditionScreen.kt:465)");
        }
        if (function1 == null) {
            composer.a0(-802355316);
            composer.U();
        } else {
            composer.a0(-802355315);
            int i4 = R.drawable.h6;
            float fG = Dp.g(40);
            String strB = StringResources_androidKt.b(R.string.qs, composer, 0);
            FlatButtonColors flatButtonColorsB = FlatButtonColors.b(FlatButtonColors.Primary.f131166a, null, Color.n(ComposeColorsKt.j(composer, 0).x()), 1, null);
            boolean Z = composer.Z(function1) | composer.Z(intervalDTO);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: m1.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseConditionScreenKt.v0(function1, intervalDTO);
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.K(null, fG, i4, flatButtonColorsB, strB, (Function0) objG, composer, 48, 1);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(Function1 function1, IntervalDTO intervalDTO) {
        function1.invoke(intervalDTO);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(IntervalDTO intervalDTO, Function1 function1, Function1 function12, int i3, int i4, Composer composer, int i5) {
        q0(intervalDTO, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void x0(final PremiumFeature premiumFeature, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
        Composer composerK = composer.k(51985157);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(premiumFeature.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(51985157, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.PremiumCard (BaseConditionScreen.kt:565)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            String shortTitle = premiumFeature.getShortTitle(context);
            if (shortTitle == null) {
                shortTitle = "";
            }
            boolean zI = composerK.I(context) | ((i4 & 14) == 4);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: m1.o0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseConditionScreenKt.y0(context, premiumFeature);
                    }
                };
                composerK.w(objG);
            }
            CardsKt.s(companion, null, shortTitle, (Function0) objG, composerK, 6, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: m1.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseConditionScreenKt.z0(premiumFeature, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(Context context, PremiumFeature premiumFeature) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(premiumFeature), "schedule_create", "more_days", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(PremiumFeature premiumFeature, int i3, Composer composer, int i4) {
        x0(premiumFeature, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k0(boolean z2) {
        return z2;
    }
}
