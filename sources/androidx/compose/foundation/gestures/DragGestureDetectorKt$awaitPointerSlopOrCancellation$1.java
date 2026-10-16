package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", l = {802, 825}, m = "awaitPointerSlopOrCancellation-6ksA65w")
final class DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f5705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f5706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f5707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f5708d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f5709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f5710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f5711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f5712i;

    DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f5711h = obj;
        this.f5712i |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.h(null, 0L, 0, null, 0L, null, this);
    }
}
