package androidx.compose.material3.internal;

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
@DebugMetadata(c = "androidx.compose.material3.internal.DragGestureDetectorCopyKt", f = "DragGestureDetectorCopy.kt", l = {145, 183}, m = "awaitHorizontalPointerSlopOrCancellation-gDDlDlE")
final class DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f22006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f22007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f22008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f22009d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f22010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f22011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f22012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f22013i;

    DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22012h = obj;
        this.f22013i |= Integer.MIN_VALUE;
        return DragGestureDetectorCopyKt.a(null, 0L, 0, null, this);
    }
}
