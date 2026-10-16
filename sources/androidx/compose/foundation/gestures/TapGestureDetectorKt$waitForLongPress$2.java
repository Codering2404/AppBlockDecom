package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2", f = "TapGestureDetector.kt", l = {386, 409}, m = "invokeSuspend")
final class TapGestureDetectorKt$waitForLongPress$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f6277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PointerEventPass f6278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f6279d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TapGestureDetectorKt$waitForLongPress$2(PointerEventPass pointerEventPass, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.f6278c = pointerEventPass;
        this.f6279d = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TapGestureDetectorKt$waitForLongPress$2 tapGestureDetectorKt$waitForLongPress$2 = new TapGestureDetectorKt$waitForLongPress$2(this.f6278c, this.f6279d, continuation);
        tapGestureDetectorKt$waitForLongPress$2.f6277b = obj;
        return tapGestureDetectorKt$waitForLongPress$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((TapGestureDetectorKt$waitForLongPress$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (androidx.compose.foundation.gestures.TapGestureDetector_androidKt.b(r14) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        r13.f6279d.f140144a = androidx.compose.foundation.gestures.LongPressResult.Success.f5957a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        r14 = r14.c();
        r5 = r14.size();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        if (r6 >= r5) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r14.get(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0082, code lost:
    
        if (r7.p() != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.f(r7, r1.a(), r1.v0()) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0096, code lost:
    
        r13.f6279d.f140144a = androidx.compose.foundation.gestures.LongPressResult.Canceled.f5955a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009d, code lost:
    
        r14 = androidx.compose.ui.input.pointer.PointerEventPass.f26832c;
        r13.f6277b = r1;
        r13.f6276a = 2;
        r14 = r1.T0(r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a7, code lost:
    
        if (r14 != r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c6, code lost:
    
        r13.f6279d.f140144a = androidx.compose.foundation.gestures.LongPressResult.Canceled.f5955a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ec, code lost:
    
        return kotlin.Unit.f139807a;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a7 -> B:34:0x00aa). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
