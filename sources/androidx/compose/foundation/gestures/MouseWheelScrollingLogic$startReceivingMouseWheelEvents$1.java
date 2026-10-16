package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1", f = "MouseWheelScrollable.kt", l = {107, 110}, m = "invokeSuspend")
final class MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f6015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MouseWheelScrollingLogic f6016c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1(MouseWheelScrollingLogic mouseWheelScrollingLogic, Continuation continuation) {
        super(2, continuation);
        this.f6016c = mouseWheelScrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 = new MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1(this.f6016c, continuation);
        mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.f6015b = obj;
        return mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f6014a
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L26
            if (r1 != r3) goto L1e
            java.lang.Object r1 = r12.f6015b
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L19
            r10 = r12
        L17:
            r13 = r1
            goto L35
        L19:
            r0 = move-exception
            r13 = r0
            r10 = r12
            goto L94
        L1e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L26:
            java.lang.Object r1 = r12.f6015b
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L19
            goto L54
        L2e:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = r12.f6015b
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
        L35:
            kotlin.coroutines.CoroutineContext r1 = r13.getCoroutineContext()     // Catch: java.lang.Throwable -> L88
            boolean r1 = kotlinx.coroutines.JobKt.p(r1)     // Catch: java.lang.Throwable -> L88
            if (r1 == 0) goto L8b
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r1 = r12.f6016c     // Catch: java.lang.Throwable -> L88
            kotlinx.coroutines.channels.Channel r1 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.f(r1)     // Catch: java.lang.Throwable -> L88
            r12.f6015b = r13     // Catch: java.lang.Throwable -> L88
            r12.f6014a = r4     // Catch: java.lang.Throwable -> L88
            java.lang.Object r1 = r1.v(r12)     // Catch: java.lang.Throwable -> L88
            if (r1 != r0) goto L51
            r10 = r12
            goto L84
        L51:
            r11 = r1
            r1 = r13
            r13 = r11
        L54:
            r7 = r13
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta r7 = (androidx.compose.foundation.gestures.MouseWheelScrollingLogic.MouseWheelScrollDelta) r7     // Catch: java.lang.Throwable -> L88
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r13 = r12.f6016c     // Catch: java.lang.Throwable -> L88
            androidx.compose.ui.unit.Density r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.g(r13)     // Catch: java.lang.Throwable -> L88
            float r5 = androidx.compose.foundation.gestures.MouseWheelScrollableKt.b()     // Catch: java.lang.Throwable -> L88
            float r8 = r13.M1(r5)     // Catch: java.lang.Throwable -> L88
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r13 = r12.f6016c     // Catch: java.lang.Throwable -> L88
            androidx.compose.ui.unit.Density r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.g(r13)     // Catch: java.lang.Throwable -> L88
            float r5 = androidx.compose.foundation.gestures.MouseWheelScrollableKt.a()     // Catch: java.lang.Throwable -> L88
            float r9 = r13.M1(r5)     // Catch: java.lang.Throwable -> L88
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r5 = r12.f6016c     // Catch: java.lang.Throwable -> L88
            androidx.compose.foundation.gestures.ScrollingLogic r6 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.h(r5)     // Catch: java.lang.Throwable -> L88
            r12.f6015b = r1     // Catch: java.lang.Throwable -> L88
            r12.f6014a = r3     // Catch: java.lang.Throwable -> L88
            r10 = r12
            java.lang.Object r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.d(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L85
            if (r13 != r0) goto L17
        L84:
            return r0
        L85:
            r0 = move-exception
        L86:
            r13 = r0
            goto L94
        L88:
            r0 = move-exception
            r10 = r12
            goto L86
        L8b:
            r10 = r12
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r13 = r10.f6016c
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic.i(r13, r2)
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        L94:
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r0 = r10.f6016c
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic.i(r0, r2)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
