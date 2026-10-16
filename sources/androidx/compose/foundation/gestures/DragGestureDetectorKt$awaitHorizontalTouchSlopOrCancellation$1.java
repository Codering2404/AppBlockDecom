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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", l = {1061, 1104}, m = "awaitHorizontalTouchSlopOrCancellation-jO51t88")
final class DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f5685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f5686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f5687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f5688d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f5689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f5690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f5691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f5692i;

    DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f5691h = obj;
        this.f5692i |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.f(null, 0L, null, this);
    }
}
