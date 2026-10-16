package cz.mobilesoft.coreblock.view.compose.slider;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material.SliderColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.ClosedFloatingPointRange;

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
public final class ComposeSliderKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:213:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(final float r45, final kotlin.jvm.functions.Function1 r46, androidx.compose.ui.Modifier r47, boolean r48, kotlin.ranges.ClosedFloatingPointRange r49, int r50, kotlin.jvm.functions.Function1 r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.material.SliderColors r53, androidx.compose.ui.unit.Dp r54, androidx.compose.ui.unit.Dp r55, androidx.compose.runtime.Composer r56, final int r57, final int r58, final int r59) {
        /*
            Method dump skipped, instruction units count: 833
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.slider.ComposeSliderKt.e(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, androidx.compose.ui.unit.Dp, androidx.compose.ui.unit.Dp, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(float f3, Function1 function1, Modifier modifier, boolean z2, ClosedFloatingPointRange closedFloatingPointRange, int i3, Function1 function12, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, Dp dp, Dp dp2, int i4, int i5, int i6, Composer composer, int i7) {
        e(f3, function1, modifier, z2, closedFloatingPointRange, i3, function12, mutableInteractionSource, sliderColors, dp, dp2, composer, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
        return Unit.f139807a;
    }

    private static final float g(MutableState mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final void h(MutableState mutableState, float f3) {
        mutableState.setValue(Float.valueOf(f3));
    }

    private static final boolean i(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private static final boolean j(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float k(boolean z2, float f3, MutableState mutableState) {
        return z2 ? g(mutableState) : f3;
    }

    private static final float l(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1, MutableState mutableState, float f3) {
        h(mutableState, f3);
        function1.invoke(Float.valueOf(f3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function1 function1, MutableState mutableState) {
        if (function1 != null) {
            function1.invoke(Float.valueOf(g(mutableState)));
        }
        return Unit.f139807a;
    }
}
