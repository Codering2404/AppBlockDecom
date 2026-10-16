package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

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
public final class AnchoredDraggableState$draggableState$1 implements DraggableState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnchoredDraggableState$draggableState$1$dragScope$1 f21882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableState f21883b;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.material3.internal.AnchoredDraggableState$draggableState$1$dragScope$1] */
    AnchoredDraggableState$draggableState$1(final AnchoredDraggableState anchoredDraggableState) {
        this.f21883b = anchoredDraggableState;
        this.f21882a = new DragScope() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$draggableState$1$dragScope$1
            @Override // androidx.compose.foundation.gestures.DragScope
            public void a(float f3) {
                AnchoredDragScope.b(anchoredDraggableState.f21847o, anchoredDraggableState.z(f3), 0.0f, 2, null);
            }
        };
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public Object a(MutatePriority mutatePriority, Function2 function2, Continuation continuation) throws Throwable {
        Object objI = this.f21883b.i(mutatePriority, new AnchoredDraggableState$draggableState$1$drag$2(this, function2, null), continuation);
        return objI == IntrinsicsKt.f() ? objI : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public void b(float f3) {
        this.f21883b.n(f3);
    }
}
