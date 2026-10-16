package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import java.util.List;
import kotlin.Metadata;

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
public final class InternalPointerEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LongSparseArray f26804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointerInputEvent f26805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26806c;

    public InternalPointerEvent(LongSparseArray longSparseArray, PointerInputEvent pointerInputEvent) {
        this.f26804a = longSparseArray;
        this.f26805b = pointerInputEvent;
    }

    public final boolean a(long j3) {
        Object obj;
        List listB = this.f26805b.b();
        int size = listB.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = listB.get(i3);
            if (PointerId.c(((PointerInputEventData) obj).d(), j3)) {
                break;
            }
            i3++;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        if (pointerInputEventData != null) {
            return pointerInputEventData.a();
        }
        return false;
    }

    public final LongSparseArray b() {
        return this.f26804a;
    }

    public final MotionEvent c() {
        return this.f26805b.a();
    }

    public final boolean d() {
        return this.f26806c;
    }

    public final void e(boolean z2) {
        this.f26806c = z2;
    }
}
