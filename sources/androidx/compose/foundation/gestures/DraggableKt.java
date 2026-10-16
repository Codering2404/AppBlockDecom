package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DraggableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function3 f5915a = new DraggableKt$NoOpOnDragStarted$1(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function3 f5916b = new DraggableKt$NoOpOnDragStopped$1(null);

    public static final DraggableState a(Function1 function1) {
        return new DefaultDraggableState(function1);
    }

    public static final Modifier g(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, boolean z3, Function3 function3, Function3 function32, boolean z4) {
        return modifier.then(new DraggableElement(draggableState, orientation, z2, mutableInteractionSource, z3, function3, function32, z4));
    }

    public static /* synthetic */ Modifier h(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, boolean z3, Function3 function3, Function3 function32, boolean z4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        boolean z5 = z2;
        if ((i3 & 8) != 0) {
            mutableInteractionSource = null;
        }
        return g(modifier, draggableState, orientation, z5, mutableInteractionSource, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? f5915a : function3, (i3 & 64) != 0 ? f5916b : function32, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z4);
    }

    public static final DraggableState i(Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-183245213, i3, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:127)");
        }
        final State stateP = SnapshotStateKt.p(function1, composer, i3 & 14);
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = a(new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$rememberDraggableState$1$1
                {
                    super(1);
                }

                public final void c(float f3) {
                    ((Function1) stateP.getValue()).invoke(Float.valueOf(f3));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c(((Number) obj).floatValue());
                    return Unit.f139807a;
                }
            });
            composer.w(objG);
        }
        DraggableState draggableState = (DraggableState) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return draggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float j(long j3, Orientation orientation) {
        return Float.intBitsToFloat((int) (orientation == Orientation.f6031a ? j3 & 4294967295L : j3 >> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float k(long j3, Orientation orientation) {
        return orientation == Orientation.f6031a ? Velocity.i(j3) : Velocity.h(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j3) {
        return VelocityKt.a(Float.isNaN(Velocity.h(j3)) ? 0.0f : Velocity.h(j3), Float.isNaN(Velocity.i(j3)) ? 0.0f : Velocity.i(j3));
    }
}
