package com.superwall.sdk;

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
@DebugMetadata(c = "com.superwall.sdk.Superwall$setInterfaceStyle$1$1", f = "Superwall.kt", l = {877, 877, 878}, m = "invokeSuspend")
final class Superwall$setInterfaceStyle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ Superwall this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Superwall$setInterfaceStyle$1$1(Superwall superwall, Continuation<? super Superwall$setInterfaceStyle$1$1> continuation) {
        super(2, continuation);
        this.this$0 = superwall;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Superwall$setInterfaceStyle$1$1(this.this$0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        if (r7.recheckPreloadIfNeeded(r6) != r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.label
            r2 = 3
            r3 = 1
            r4 = 2
            if (r1 == 0) goto L2e
            if (r1 == r3) goto L26
            if (r1 == r4) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r7)
            goto L68
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1d:
            kotlin.ResultKt.b(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            r7.j()
            goto L55
        L26:
            java.lang.Object r1 = r6.L$0
            com.superwall.sdk.Superwall r1 = (com.superwall.sdk.Superwall) r1
            kotlin.ResultKt.b(r7)
            goto L42
        L2e:
            kotlin.ResultKt.b(r7)
            com.superwall.sdk.Superwall r1 = r6.this$0
            com.superwall.sdk.dependencies.DependencyContainer r7 = r1.getDependencyContainer$superwall_release()
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.makeSessionDeviceAttributes(r6)
            if (r7 != r0) goto L42
            goto L67
        L42:
            java.util.HashMap r7 = (java.util.HashMap) r7
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$DeviceAttributes r3 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$DeviceAttributes
            r5 = 0
            r3.<init>(r7, r5, r4, r5)
            r6.L$0 = r5
            r6.label = r4
            java.lang.Object r7 = com.superwall.sdk.analytics.internal.TrackingKt.track(r1, r3, r6)
            if (r7 != r0) goto L55
            goto L67
        L55:
            com.superwall.sdk.Superwall r7 = r6.this$0
            com.superwall.sdk.dependencies.DependencyContainer r7 = r7.getDependencyContainer$superwall_release()
            com.superwall.sdk.config.ConfigManager r7 = r7.getConfigManager()
            r6.label = r2
            java.lang.Object r7 = r7.recheckPreloadIfNeeded(r6)
            if (r7 != r0) goto L68
        L67:
            return r0
        L68:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall$setInterfaceStyle$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Superwall$setInterfaceStyle$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
