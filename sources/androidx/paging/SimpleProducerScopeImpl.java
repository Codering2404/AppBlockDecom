package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SimpleProducerScopeImpl<T> implements SimpleProducerScope<T>, CoroutineScope, SendChannel<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SendChannel f50650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f50651b;

    public SimpleProducerScopeImpl(CoroutineScope scope, SendChannel channel) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.f50650a = channel;
        this.f50651b = scope;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.paging.SimpleProducerScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object M(kotlin.jvm.functions.Function0 r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.paging.SimpleProducerScopeImpl$awaitClose$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.paging.SimpleProducerScopeImpl$awaitClose$1 r0 = (androidx.paging.SimpleProducerScopeImpl$awaitClose$1) r0
            int r1 = r0.f50656f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50656f = r1
            goto L18
        L13:
            androidx.paging.SimpleProducerScopeImpl$awaitClose$1 r0 = new androidx.paging.SimpleProducerScopeImpl$awaitClose$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f50654c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f50656f
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f50653b
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            java.lang.Object r6 = r0.f50652a
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L76
        L31:
            r7 = move-exception
            goto L84
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.b(r7)
            kotlin.coroutines.CoroutineContext r7 = r5.getCoroutineContext()     // Catch: java.lang.Throwable -> L31
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.v8     // Catch: java.lang.Throwable -> L31
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r2)     // Catch: java.lang.Throwable -> L31
            if (r7 == 0) goto L7c
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7     // Catch: java.lang.Throwable -> L31
            r0.f50652a = r6     // Catch: java.lang.Throwable -> L31
            r0.f50653b = r7     // Catch: java.lang.Throwable -> L31
            r0.f50656f = r3     // Catch: java.lang.Throwable -> L31
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L31
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)     // Catch: java.lang.Throwable -> L31
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L31
            r2.C()     // Catch: java.lang.Throwable -> L31
            androidx.paging.SimpleProducerScopeImpl$awaitClose$2$1 r3 = new androidx.paging.SimpleProducerScopeImpl$awaitClose$2$1     // Catch: java.lang.Throwable -> L31
            r3.<init>()     // Catch: java.lang.Throwable -> L31
            r7.invokeOnCompletion(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.Object r7 = r2.v()     // Catch: java.lang.Throwable -> L31
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()     // Catch: java.lang.Throwable -> L31
            if (r7 != r2) goto L73
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)     // Catch: java.lang.Throwable -> L31
        L73:
            if (r7 != r1) goto L76
            return r1
        L76:
            r6.invoke()
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L7c:
            java.lang.String r7 = "Internal error, context should have a job."
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L31
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L31
            throw r0     // Catch: java.lang.Throwable -> L31
        L84:
            r6.invoke()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SimpleProducerScopeImpl.M(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void g(Function1 handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f50650a.g(handler);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f50651b.getCoroutineContext();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object h(Object obj) {
        return this.f50650a.h(obj);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean w(Throwable th) {
        return this.f50650a.w(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object y(Object obj, Continuation continuation) {
        return this.f50650a.y(obj, continuation);
    }
}
