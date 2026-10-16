package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class PointerInteropUtils_androidKt {
    public static final void a(long j3, Function1 function1) {
        MotionEvent motionEventObtain = MotionEvent.obtain(j3, j3, 3, 0.0f, 0.0f, 0);
        motionEventObtain.setSource(0);
        function1.invoke(motionEventObtain);
        motionEventObtain.recycle();
    }

    public static final void b(PointerEvent pointerEvent, long j3, Function1 function1) {
        d(pointerEvent, j3, function1, true);
    }

    public static final void c(PointerEvent pointerEvent, long j3, Function1 function1) {
        d(pointerEvent, j3, function1, false);
    }

    private static final void d(PointerEvent pointerEvent, long j3, Function1 function1, boolean z2) {
        MotionEvent motionEventG = pointerEvent.g();
        if (motionEventG == null) {
            throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.");
        }
        int action = motionEventG.getAction();
        if (z2) {
            motionEventG.setAction(3);
        }
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        motionEventG.offsetLocation(-Float.intBitsToFloat(i3), -Float.intBitsToFloat(i4));
        function1.invoke(motionEventG);
        motionEventG.offsetLocation(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4));
        motionEventG.setAction(action);
    }
}
