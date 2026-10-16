package cz.mobilesoft.coreblock.view.timeselector;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
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
public final class TimeSelectBottomSheetKt {
    /* JADX WARN: Removed duplicated region for block: B:105:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:237:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final kotlin.jvm.functions.Function1 r37, kotlin.jvm.functions.Function0 r38, cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig r39, long r40, java.lang.Long r42, boolean r43, java.lang.String r44, java.lang.String r45, androidx.compose.ui.graphics.vector.ImageVector r46, final androidx.compose.runtime.MutableState r47, kotlin.jvm.functions.Function2 r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 985
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.timeselector.TimeSelectBottomSheetKt.g(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig, long, java.lang.Long, boolean, java.lang.String, java.lang.String, androidx.compose.ui.graphics.vector.ImageVector, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder i(TimePickerConfig timePickerConfig, long j3, Long l3, boolean z2) {
        return ParametersHolderKt.b(new TimePickerViewModel.Params(timePickerConfig, j3, l3, z2, null, 16, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function2 function2, String str, TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, String str2, ImageVector imageVector, final Function1 function1, final MutableState mutableState, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(AppBottomSheet) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 131) != 130, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-727442464, i4, -1, "cz.mobilesoft.coreblock.view.timeselector.TimeSelectBottomSheet.<anonymous> (TimeSelectBottomSheet.kt:67)");
            }
            if (function2 != null) {
                composer.a0(1166580132);
                function2.invoke(composer, 0);
                composer.U();
                i5 = 0;
            } else {
                composer.a0(1166681750);
                i5 = 0;
                TextKt.c(str, AppBottomSheet.c(PaddingKt.i(Modifier.b8, Dp.g(16)), Alignment.f25072a.g()), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).h(), composer, 0, 0, 65532);
                composer.U();
            }
            ComposeSwipeableTimePickerKt.W(timePickerViewState, TimePickerConfiguration.b(TimePickerConfiguration.f133137r.a(composer, 6), 0, ComposeColorsKt.j(composer, i5).X(), null, 0.0f, 0.0f, Dp.g(i5), 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131037, null), FlowExtKt.n(timePickerViewModel, composer, i5), composer, 0, 0);
            SpacerKt.a(SizeKt.v(Modifier.b8, Dp.g(16)), composer, 6);
            boolean zU = timePickerViewState.u();
            boolean Z = composer.Z(function1) | composer.Z(timePickerViewState) | composer.Z(mutableState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.timeselector.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeSelectBottomSheetKt.k(function1, timePickerViewState, mutableState);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, str2, zU, false, imageVector, (Function0) objG, composer, 0, 9);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function1 function1, TimePickerViewState timePickerViewState, MutableState mutableState) {
        function1.invoke(Long.valueOf(timePickerViewState.o()));
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1, Function0 function0, TimePickerConfig timePickerConfig, long j3, Long l3, boolean z2, String str, String str2, ImageVector imageVector, MutableState mutableState, Function2 function2, int i3, int i4, int i5, Composer composer, int i6) {
        g(function1, function0, timePickerConfig, j3, l3, z2, str, str2, imageVector, mutableState, function2, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }
}
