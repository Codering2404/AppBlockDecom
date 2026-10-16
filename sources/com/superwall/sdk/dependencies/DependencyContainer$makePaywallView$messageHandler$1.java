package com.superwall.sdk.dependencies;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$makePaywallView$messageHandler$1", f = "DependencyContainer.kt", l = {830}, m = "invokeSuspend")
final class DependencyContainer$makePaywallView$messageHandler$1 extends SuspendLambda implements Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    DependencyContainer$makePaywallView$messageHandler$1(Continuation<? super DependencyContainer$makePaywallView$messageHandler$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DependencyContainer$makePaywallView$messageHandler$1 dependencyContainer$makePaywallView$messageHandler$1 = new DependencyContainer$makePaywallView$messageHandler$1(continuation);
        dependencyContainer$makePaywallView$messageHandler$1.L$0 = obj;
        return dependencyContainer$makePaywallView$messageHandler$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super Unit> continuation) {
        return ((DependencyContainer$makePaywallView$messageHandler$1) create(trackableSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            TrackableSuperwallEvent trackableSuperwallEvent = (TrackableSuperwallEvent) this.L$0;
            Superwall companion = Superwall.Companion.getInstance();
            this.label = 1;
            if (TrackingKt.track(companion, trackableSuperwallEvent, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            ((Result) obj).j();
        }
        return Unit.f139807a;
    }
}
