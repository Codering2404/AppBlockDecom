package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", l = {354, 355, 360}, m = "invokeSuspend")
final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f5769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f5770d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f5771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function2 f5772g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f5769c = function1;
        this.f5770d = function0;
        this.f5771f = function02;
        this.f5772g = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.f5769c, this.f5770d, this.f5771f, this.f5772g, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.f5768b = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: CancellationException -> 0x00b6, PHI: r1 r8 r12
      0x0064: PHI (r1v8 androidx.compose.ui.input.pointer.AwaitPointerEventScope) = 
      (r1v4 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
      (r1v9 androidx.compose.ui.input.pointer.AwaitPointerEventScope)
     binds: [B:16:0x002f, B:28:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0064: PHI (r8v6 androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) = 
      (r8v2 androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5)
      (r8v7 androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5)
     binds: [B:16:0x002f, B:28:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0064: PHI (r12v12 java.lang.Object) = (r12v0 java.lang.Object), (r12v18 java.lang.Object) binds: [B:16:0x002f, B:28:0x0061] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {CancellationException -> 0x00b6, blocks: (B:36:0x008c, B:38:0x0094, B:40:0x00a6, B:42:0x00b2, B:45:0x00b9, B:46:0x00bc, B:47:0x00c2, B:30:0x0064, B:32:0x0068, B:27:0x0053, B:23:0x004b), top: B:57:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[Catch: CancellationException -> 0x00b6, TryCatch #2 {CancellationException -> 0x00b6, blocks: (B:36:0x008c, B:38:0x0094, B:40:0x00a6, B:42:0x00b2, B:45:0x00b9, B:46:0x00bc, B:47:0x00c2, B:30:0x0064, B:32:0x0068, B:27:0x0053, B:23:0x004b), top: B:57:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094 A[Catch: CancellationException -> 0x00b6, TryCatch #2 {CancellationException -> 0x00b6, blocks: (B:36:0x008c, B:38:0x0094, B:40:0x00a6, B:42:0x00b2, B:45:0x00b9, B:46:0x00bc, B:47:0x00c2, B:30:0x0064, B:32:0x0068, B:27:0x0053, B:23:0x004b), top: B:57:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2 A[Catch: CancellationException -> 0x00b6, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x00b6, blocks: (B:36:0x008c, B:38:0x0094, B:40:0x00a6, B:42:0x00b2, B:45:0x00b9, B:46:0x00bc, B:47:0x00c2, B:30:0x0064, B:32:0x0068, B:27:0x0053, B:23:0x004b), top: B:57:0x004b }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
