package cz.mobilesoft.coreblock.view.compose.slider;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
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
public final class DragGestureDetectorCopyOfCopyKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f132004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f132005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f132006c;

    static {
        float fG = Dp.g((float) 0.125d);
        f132004a = fG;
        float fG2 = Dp.g(18);
        f132005b = fG2;
        f132006c = fG / fG2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x016b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0231 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x021c -> B:56:0x0229). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(androidx.compose.ui.input.pointer.AwaitPointerEventScope r28, long r29, int r31, kotlin.jvm.functions.Function2 r32, kotlin.coroutines.Continuation r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.slider.DragGestureDetectorCopyOfCopyKt.a(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean b(PointerEvent pointerEvent, long j3) {
        Object obj;
        List listC = pointerEvent.c();
        int size = listC.size();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = listC.get(i3);
            if (PointerId.c(((PointerInputChange) obj).f(), j3)) {
                break;
            }
            i3++;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange != null && pointerInputChange.i()) {
            z2 = true;
        }
        return true ^ z2;
    }

    public static final float c(ViewConfiguration pointerSlop, int i3) {
        Intrinsics.checkNotNullParameter(pointerSlop, "$this$pointerSlop");
        return PointerType.h(i3, PointerType.f26922b.b()) ? pointerSlop.g() * f132006c : pointerSlop.g();
    }
}
