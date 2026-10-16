package cz.mobilesoft.coreblock.scene.strictmode3.access;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState;
import cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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
public final class StrictModeTimerBottomSheetKt {
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j(java.lang.String r12, final androidx.compose.runtime.MutableState r13, androidx.compose.runtime.MutableState r14, final kotlin.jvm.functions.Function1 r15, androidx.compose.runtime.Composer r16, final int r17, final int r18) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeTimerBottomSheetKt.j(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(MutableState mutableState, TimePickerViewModel viewModel, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (ComposerKt.M()) {
            ComposerKt.U(1910924565, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeCooldownTimerBottomSheet.<anonymous> (StrictModeTimerBottomSheet.kt:44)");
        }
        Object value = mutableState.getValue();
        boolean zI = composer.I(viewModel) | composer.Z(mutableState);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new StrictModeTimerBottomSheetKt$StrictModeCooldownTimerBottomSheet$1$1$1(viewModel, mutableState, null);
            composer.w(objG);
        }
        EffectsKt.g(value, (Function2) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String str, MutableState mutableState, MutableState mutableState2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        j(str, mutableState, mutableState2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m(java.lang.String r8, androidx.compose.runtime.MutableState r9, final androidx.compose.runtime.MutableState r10, kotlin.jvm.functions.Function1 r11, androidx.compose.runtime.Composer r12, final int r13, final int r14) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeTimerBottomSheetKt.m(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n(java.lang.String r22, final androidx.compose.runtime.MutableState r23, final kotlin.jvm.functions.Function1 r24, final kotlin.jvm.functions.Function3 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeTimerBottomSheetKt.n(java.lang.String, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(MutableState mutableState, TimePickerViewModel viewModel, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (ComposerKt.M()) {
            ComposerKt.U(-941507446, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeTimerBottomSheet.<anonymous> (StrictModeTimerBottomSheet.kt:66)");
        }
        Object value = mutableState.getValue();
        boolean Z = composer.Z(mutableState) | composer.I(viewModel);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new StrictModeTimerBottomSheetKt$StrictModeTimerBottomSheet$1$1$1(mutableState, viewModel, null);
            composer.w(objG);
        }
        EffectsKt.g(value, (Function2) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(String str, MutableState mutableState, MutableState mutableState2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        m(str, mutableState, mutableState2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder q() {
        return ParametersHolderKt.b(new TimePickerViewModel.Params(new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Hours(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Days(0L, 99L), false, null, false, 56, null), 0L, null, true, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(String str, TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, final Function1 function1, final MutableState mutableState, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1396007417, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeTimerBottomSheet.<anonymous> (StrictModeTimerBottomSheet.kt:121)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            TextKt.c(str, PaddingKt.i(companion, Dp.g(f3)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).h(), composer, 48, 0, 65532);
            ComposeSwipeableTimePickerKt.W(timePickerViewState, TimePickerConfiguration.b(TimePickerConfiguration.f133137r.a(composer, 6), 0, ComposeColorsKt.j(composer, 0).X(), null, Dp.g(f3), 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131061, null), FlowExtKt.n(timePickerViewModel, composer, 0), composer, 0, 0);
            if (StringsKt.p0(timePickerViewState.e()) || !timePickerViewState.r()) {
                composer.a0(-293324837);
            } else {
                composer.a0(-287873983);
                SpacerKt.a(SizeKt.v(companion, Dp.g(8)), composer, 6);
                ComposeSwipeableTimePickerKt.u(timePickerViewState.e(), composer, 0);
            }
            composer.U();
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            boolean zU = timePickerViewState.u();
            boolean Z = composer.Z(function1) | composer.Z(timePickerViewState) | composer.Z(mutableState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.r1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeTimerBottomSheetKt.s(function1, timePickerViewState, mutableState);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, zU, false, null, (Function0) objG, composer, 0, 25);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function1 function1, TimePickerViewState timePickerViewState, MutableState mutableState) {
        function1.invoke(Long.valueOf(timePickerViewState.o()));
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(String str, MutableState mutableState, Function1 function1, Function3 function3, int i3, int i4, Composer composer, int i5) {
        n(str, mutableState, function1, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
