package cz.mobilesoft.coreblock.view.compose.profileitem;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timeselector.TimeSelectBottomSheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class ActivateNowTimePickerKt {
    public static final void c(final MutableState showTimePickerBottomSheet, final long j3, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(showTimePickerBottomSheet, "showTimePickerBottomSheet");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(1303535122);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(showTimePickerBottomSheet) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1303535122, i4, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.ActivateNowTimePicker (ActivateNowTimePicker.kt:15)");
            }
            String strB = StringResources_androidKt.b(R.string.C, composerK, 0);
            String strB2 = StringResources_androidKt.b(R.string.s3, composerK, 0);
            TimePickerConfig timePickerConfig = new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Hours(0L, 0L, 3, null), null, false, null, false, 60, null);
            boolean z2 = ((i4 & 896) == 256) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ActivateNowTimePickerKt.d(onEvent, j3, ((Long) obj).longValue());
                    }
                };
                composerK.w(objG);
            }
            TimeSelectBottomSheetKt.g((Function1) objG, null, timePickerConfig, 0L, null, false, strB, strB2, null, showTimePickerBottomSheet, null, composerK, (i4 << 27) & 1879048192, 0, 1338);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActivateNowTimePickerKt.e(showTimePickerBottomSheet, j3, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function1 function1, long j3, long j4) {
        function1.invoke(new ProfileItemEvent.OnProfileStartedManually(j3, j4 + TimeHelperExt.f128663a.f(), false));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(MutableState mutableState, long j3, Function1 function1, int i3, Composer composer, int i4) {
        c(mutableState, j3, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
