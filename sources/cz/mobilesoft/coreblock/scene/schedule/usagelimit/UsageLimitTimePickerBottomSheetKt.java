package cz.mobilesoft.coreblock.scene.schedule.usagelimit;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SnackbarKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewEvent;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;

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
public final class UsageLimitTimePickerBottomSheetKt {
    /* JADX WARN: Removed duplicated region for block: B:120:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final androidx.compose.runtime.MutableState r24, final androidx.compose.runtime.MutableState r25, java.lang.Long r26, boolean r27, final kotlin.jvm.functions.Function2 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.usagelimit.UsageLimitTimePickerBottomSheetKt.k(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, java.lang.Long, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder l(MutableState mutableState, Long l3) {
        return ParametersHolderKt.b(new TimePickerViewModel.Params(((ScheduleActivity.BlockingConditionConfig) mutableState.getValue()).c(), ((ScheduleActivity.BlockingConditionConfig) mutableState.getValue()).a(), null, false, l3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(MutableState mutableState, MutableState mutableState2, Long l3, boolean z2, Function2 function2, int i3, int i4, Composer composer, int i5) {
        k(mutableState, mutableState2, l3, z2, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final UsageLimit.PeriodType n(MutableState mutableState) {
        return (UsageLimit.PeriodType) mutableState.getValue();
    }

    private static final void o(MutableState mutableState, UsageLimit.PeriodType periodType) {
        mutableState.setValue(periodType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String p(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(final TimePickerViewState timePickerViewState, final Function2 function2, final MutableState mutableState, final MutableState mutableState2, TimePickerViewModel timePickerViewModel, final Function1 function1, final boolean z2, final MutableState mutableState3, MutableState mutableState4, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        float f3;
        Object obj;
        Continuation continuation;
        final MutableState mutableState5;
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1515044684, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.usagelimit.ConditionSelectorBottomSheet.<anonymous> (UsageLimitTimePickerBottomSheet.kt:79)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f4 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f4));
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
            TextKt.c(StringResources_androidKt.b(R.string.JF, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).h(), composer, 0, 0, 65534);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(52), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierK);
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
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 0.5f, false, 2, null);
            String strB = StringResources_androidKt.b(R.string.AD, composer, 0);
            boolean z3 = n(mutableState3) == UsageLimit.PeriodType.DAILY;
            boolean Z = composer.Z(timePickerViewState) | composer.b(z2) | composer.Z(mutableState) | composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                f3 = f4;
                Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.usagelimit.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UsageLimitTimePickerBottomSheetKt.s(timePickerViewState, z2, mutableState, function1, mutableState3);
                    }
                };
                composer.w(function0);
                objG = function0;
            } else {
                f3 = f4;
            }
            ComposeButtonsKt.G0(modifierC, strB, null, 0L, 0L, z3, (Function0) objG, composer, 0, 28);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            Modifier modifierC2 = RowScope.c(rowScopeInstance, companion, 0.5f, false, 2, null);
            String strB2 = StringResources_androidKt.b(R.string.DD, composer, 0);
            boolean z4 = n(mutableState3) == UsageLimit.PeriodType.HOURLY;
            boolean Z2 = composer.Z(timePickerViewState) | composer.b(z2) | composer.Z(mutableState) | composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                continuation = null;
                obj = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.usagelimit.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UsageLimitTimePickerBottomSheetKt.t(timePickerViewState, z2, mutableState, function1, mutableState3);
                    }
                };
                composer.w(obj);
            } else {
                obj = objG2;
                continuation = null;
            }
            Continuation continuation2 = continuation;
            ComposeButtonsKt.G0(modifierC2, strB2, null, 0L, 0L, z4, (Function0) obj, composer, 0, 28);
            composer.y();
            ComposeSwipeableTimePickerKt.W(timePickerViewState, null, function1, composer, 0, 2);
            composer.y();
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            String strB3 = StringResources_androidKt.b(R.string.Lt, composer, 0);
            boolean zU = timePickerViewState.u();
            boolean Z3 = composer.Z(function2) | composer.Z(timePickerViewState) | composer.Z(mutableState) | composer.Z(mutableState2);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.usagelimit.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UsageLimitTimePickerBottomSheetKt.u(function2, timePickerViewState, mutableState, mutableState2);
                    }
                };
                composer.w(objG3);
            }
            ComposeButtonsKt.J(null, strB3, zU, false, null, (Function0) objG3, composer, 0, 25);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            if (p(mutableState4).length() > 0) {
                composer.a0(1118552914);
                String strP = p(mutableState4);
                Object objG4 = composer.G();
                Composer.Companion companion4 = Composer.f23746a;
                if (objG4 == companion4.a()) {
                    mutableState5 = mutableState4;
                    objG4 = new UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$3$1(mutableState5, continuation2);
                    composer.w(objG4);
                } else {
                    mutableState5 = mutableState4;
                }
                EffectsKt.g(strP, (Function2) objG4, composer, 0);
                Alignment alignmentB = companion2.b();
                Object objG5 = composer.G();
                if (objG5 == companion4.a()) {
                    objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.usagelimit.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return UsageLimitTimePickerBottomSheetKt.v(mutableState5);
                        }
                    };
                    composer.w(objG5);
                }
                AndroidPopup_androidKt.c(alignmentB, 0L, (Function0) objG5, null, ComposableLambdaKt.e(-1432151204, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.usagelimit.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return UsageLimitTimePickerBottomSheetKt.w(mutableState5, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 24966, 10);
            } else {
                mutableState5 = mutableState4;
                composer.a0(1111651694);
            }
            composer.U();
            Object objG6 = composer.G();
            if (objG6 == Composer.f23746a.a()) {
                objG6 = new UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1(mutableState5, continuation2);
                composer.w(objG6);
            }
            FlowExtKt.g(timePickerViewModel, null, (Function2) objG6, composer, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(TimePickerViewState timePickerViewState, boolean z2, MutableState mutableState, Function1 function1, MutableState mutableState2) {
        if (!timePickerViewState.t() || z2) {
            UsageLimit.PeriodType periodType = UsageLimit.PeriodType.DAILY;
            o(mutableState2, periodType);
            ((ScheduleActivity.BlockingConditionConfig) mutableState.getValue()).d(periodType);
            function1.invoke(new TimePickerViewEvent.OnUpdateTimePickerConfig(((ScheduleActivity.BlockingConditionConfig) mutableState.getValue()).c()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(TimePickerViewState timePickerViewState, boolean z2, MutableState mutableState, Function1 function1, MutableState mutableState2) {
        if (!timePickerViewState.t() || z2) {
            UsageLimit.PeriodType periodType = UsageLimit.PeriodType.HOURLY;
            o(mutableState2, periodType);
            ((ScheduleActivity.BlockingConditionConfig) mutableState.getValue()).d(periodType);
            function1.invoke(new TimePickerViewEvent.OnUpdateTimePickerConfig(((ScheduleActivity.BlockingConditionConfig) mutableState.getValue()).c()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function2 function2, TimePickerViewState timePickerViewState, MutableState mutableState, MutableState mutableState2) {
        function2.invoke(Long.valueOf(timePickerViewState.p()), ((ScheduleActivity.BlockingConditionConfig) mutableState.getValue()).b());
        mutableState2.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(MutableState mutableState) {
        q(mutableState, "");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1432151204, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.usagelimit.ConditionSelectorBottomSheet.<anonymous>.<anonymous> (UsageLimitTimePickerBottomSheet.kt:158)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(16));
            ComposableSingletons$UsageLimitTimePickerBottomSheetKt composableSingletons$UsageLimitTimePickerBottomSheetKt = ComposableSingletons$UsageLimitTimePickerBottomSheetKt.f117970a;
            SnackbarKt.c(modifierI, composableSingletons$UsageLimitTimePickerBottomSheetKt.c(), composableSingletons$UsageLimitTimePickerBottomSheetKt.d(), false, null, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(1261486007, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.usagelimit.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UsageLimitTimePickerBottomSheetKt.x(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 805306806, 504);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1261486007, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.usagelimit.ConditionSelectorBottomSheet.<anonymous>.<anonymous>.<anonymous> (UsageLimitTimePickerBottomSheet.kt:163)");
            }
            TextKt.c(p(mutableState), null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).a(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }
}
