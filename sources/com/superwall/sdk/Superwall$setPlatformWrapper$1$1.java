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
@DebugMetadata(c = "com.superwall.sdk.Superwall$setPlatformWrapper$1$1", f = "Superwall.kt", l = {864, 864}, m = "invokeSuspend")
final class Superwall$setPlatformWrapper$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ Superwall this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Superwall$setPlatformWrapper$1$1(Superwall superwall, Continuation<? super Superwall$setPlatformWrapper$1$1> continuation) {
        super(2, continuation);
        this.this$0 = superwall;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Superwall$setPlatformWrapper$1$1(this.this$0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (com.superwall.sdk.analytics.internal.TrackingKt.track(r1, r2, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L27
            if (r1 == r2) goto L1f
            if (r1 != r3) goto L17
            kotlin.ResultKt.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            r6.j()
            goto L4e
        L17:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1f:
            java.lang.Object r1 = r5.L$0
            com.superwall.sdk.Superwall r1 = (com.superwall.sdk.Superwall) r1
            kotlin.ResultKt.b(r6)
            goto L3b
        L27:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.Superwall r1 = r5.this$0
            com.superwall.sdk.dependencies.DependencyContainer r6 = r1.getDependencyContainer$superwall_release()
            r5.L$0 = r1
            r5.label = r2
            java.lang.Object r6 = r6.makeSessionDeviceAttributes(r5)
            if (r6 != r0) goto L3b
            goto L4d
        L3b:
            java.util.HashMap r6 = (java.util.HashMap) r6
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$DeviceAttributes r2 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$DeviceAttributes
            r4 = 0
            r2.<init>(r6, r4, r3, r4)
            r5.L$0 = r4
            r5.label = r3
            java.lang.Object r6 = com.superwall.sdk.analytics.internal.TrackingKt.track(r1, r2, r5)
            if (r6 != r0) goto L4e
        L4d:
            return r0
        L4e:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.Superwall$setPlatformWrapper$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Superwall$setPlatformWrapper$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
