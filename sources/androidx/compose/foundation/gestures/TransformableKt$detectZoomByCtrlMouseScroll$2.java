package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2", f = "Transformable.kt", l = {272, 284}, m = "invokeSuspend")
final class TransformableKt$detectZoomByCtrlMouseScroll$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f6330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineContext f6331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScrollConfig f6332d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Channel f6333f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableKt$detectZoomByCtrlMouseScroll$2(CoroutineContext coroutineContext, ScrollConfig scrollConfig, Channel channel, Continuation continuation) {
        super(2, continuation);
        this.f6331c = coroutineContext;
        this.f6332d = scrollConfig;
        this.f6333f = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TransformableKt$detectZoomByCtrlMouseScroll$2 transformableKt$detectZoomByCtrlMouseScroll$2 = new TransformableKt$detectZoomByCtrlMouseScroll$2(this.f6331c, this.f6332d, this.f6333f, continuation);
        transformableKt$detectZoomByCtrlMouseScroll$2.f6330b = obj;
        return transformableKt$detectZoomByCtrlMouseScroll$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
        return ((TransformableKt$detectZoomByCtrlMouseScroll$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0089, code lost:
    
        if (r13 == r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b A[Catch: all -> 0x0017, TRY_ENTER, TryCatch #0 {all -> 0x0017, blocks: (B:7:0x0012, B:26:0x008c, B:28:0x0090, B:23:0x0055, B:19:0x003b, B:22:0x0048, B:14:0x0027), top: B:35:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0089 -> B:26:0x008c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f6329a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r1 = r12.f6330b
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L17
            goto L8c
        L17:
            r0 = move-exception
            r13 = r0
            goto L9d
        L1b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L23:
            java.lang.Object r1 = r12.f6330b
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L17
            goto L48
        L2b:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = r12.f6330b
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            r1 = r13
        L33:
            kotlin.coroutines.CoroutineContext r13 = r12.f6331c
            boolean r13 = kotlinx.coroutines.JobKt.p(r13)
            if (r13 == 0) goto La5
            androidx.compose.foundation.gestures.ScrollConfig r13 = r12.f6332d     // Catch: java.lang.Throwable -> L17
            r12.f6330b = r1     // Catch: java.lang.Throwable -> L17
            r12.f6329a = r3     // Catch: java.lang.Throwable -> L17
            java.lang.Object r13 = androidx.compose.foundation.gestures.TransformableKt.b(r1, r13, r12)     // Catch: java.lang.Throwable -> L17
            if (r13 != r0) goto L48
            goto L8b
        L48:
            androidx.compose.ui.geometry.Offset r13 = (androidx.compose.ui.geometry.Offset) r13     // Catch: java.lang.Throwable -> L17
            long r4 = r13.u()     // Catch: java.lang.Throwable -> L17
            kotlinx.coroutines.channels.Channel r13 = r12.f6333f     // Catch: java.lang.Throwable -> L17
            androidx.compose.foundation.gestures.TransformEvent$TransformStarted r6 = androidx.compose.foundation.gestures.TransformEvent.TransformStarted.f6291a     // Catch: java.lang.Throwable -> L17
            r13.h(r6)     // Catch: java.lang.Throwable -> L17
        L55:
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            int r13 = (int) r4     // Catch: java.lang.Throwable -> L17
            float r13 = java.lang.Float.intBitsToFloat(r13)     // Catch: java.lang.Throwable -> L17
            r4 = 1141391360(0x44084000, float:545.0)
            float r13 = r13 / r4
            r4 = 1073741824(0x40000000, float:2.0)
            double r4 = (double) r4     // Catch: java.lang.Throwable -> L17
            double r6 = (double) r13     // Catch: java.lang.Throwable -> L17
            double r4 = java.lang.Math.pow(r4, r6)     // Catch: java.lang.Throwable -> L17
            float r7 = (float) r4     // Catch: java.lang.Throwable -> L17
            kotlinx.coroutines.channels.Channel r13 = r12.f6333f     // Catch: java.lang.Throwable -> L17
            androidx.compose.foundation.gestures.TransformEvent$TransformDelta r6 = new androidx.compose.foundation.gestures.TransformEvent$TransformDelta     // Catch: java.lang.Throwable -> L17
            androidx.compose.ui.geometry.Offset$Companion r4 = androidx.compose.ui.geometry.Offset.f25596b     // Catch: java.lang.Throwable -> L17
            long r8 = r4.c()     // Catch: java.lang.Throwable -> L17
            r10 = 0
            r11 = 0
            r6.<init>(r7, r8, r10, r11)     // Catch: java.lang.Throwable -> L17
            r13.h(r6)     // Catch: java.lang.Throwable -> L17
            androidx.compose.foundation.gestures.ScrollConfig r13 = r12.f6332d     // Catch: java.lang.Throwable -> L17
            r12.f6330b = r1     // Catch: java.lang.Throwable -> L17
            r12.f6329a = r2     // Catch: java.lang.Throwable -> L17
            java.lang.Object r13 = androidx.compose.foundation.gestures.TransformableKt.a(r1, r13, r12)     // Catch: java.lang.Throwable -> L17
            if (r13 != r0) goto L8c
        L8b:
            return r0
        L8c:
            androidx.compose.ui.geometry.Offset r13 = (androidx.compose.ui.geometry.Offset) r13     // Catch: java.lang.Throwable -> L17
            if (r13 == 0) goto L95
            long r4 = r13.u()     // Catch: java.lang.Throwable -> L17
            goto L55
        L95:
            kotlinx.coroutines.channels.Channel r13 = r12.f6333f
            androidx.compose.foundation.gestures.TransformEvent$TransformStopped r4 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.f6292a
            r13.h(r4)
            goto L33
        L9d:
            kotlinx.coroutines.channels.Channel r0 = r12.f6333f
            androidx.compose.foundation.gestures.TransformEvent$TransformStopped r1 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.f6292a
            r0.h(r1)
            throw r13
        La5:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
