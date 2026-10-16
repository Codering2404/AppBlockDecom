package com.superwall.sdk.paywall.view.webview.messaging;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$awaitInFlightTemplates$completed$1", f = "PaywallMessageHandler.kt", l = {150}, m = "invokeSuspend")
final class PaywallMessageHandler$awaitInFlightTemplates$completed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ PaywallMessageHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallMessageHandler$awaitInFlightTemplates$completed$1(PaywallMessageHandler paywallMessageHandler, Continuation<? super PaywallMessageHandler$awaitInFlightTemplates$completed$1> continuation) {
        super(2, continuation);
        this.this$0 = paywallMessageHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallMessageHandler$awaitInFlightTemplates$completed$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003b -> B:18:0x0042). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L1b
            if (r1 != r2) goto L13
            java.lang.Object r1 = r3.L$0
            java.util.Iterator r1 = (java.util.Iterator) r1
            kotlin.ResultKt.b(r4)
            goto L42
        L13:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L1b:
            kotlin.ResultKt.b(r4)
        L1e:
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r4 = r3.this$0
            java.lang.Object r4 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.access$getLifecycleLock$p(r4)
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r1 = r3.this$0
            monitor-enter(r4)
            java.util.Set r1 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.access$getInFlightTemplateSends$p(r1)     // Catch: java.lang.Throwable -> L59
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L59
            java.util.List r1 = kotlin.collections.CollectionsKt.toList(r1)     // Catch: java.lang.Throwable -> L59
            monitor-exit(r4)
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L3b
            kotlin.Unit r4 = kotlin.Unit.f139807a
            return r4
        L3b:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r4 = r1.iterator()
            r1 = r4
        L42:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L1e
            java.lang.Object r4 = r1.next()
            kotlinx.coroutines.Job r4 = (kotlinx.coroutines.Job) r4
            r3.L$0 = r1
            r3.label = r2
            java.lang.Object r4 = r4.join(r3)
            if (r4 != r0) goto L42
            return r0
        L59:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$awaitInFlightTemplates$completed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallMessageHandler$awaitInFlightTemplates$completed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
