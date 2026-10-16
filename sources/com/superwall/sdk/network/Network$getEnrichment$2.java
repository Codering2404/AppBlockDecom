package com.superwall.sdk.network;

import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.dependencies.ApiFactory;
import com.superwall.sdk.models.enrichment.Enrichment;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.superwall.sdk.network.Network$getEnrichment$2", f = "Network.kt", l = {112}, m = "invokeSuspend")
final class Network$getEnrichment$2 extends SuspendLambda implements Function2<Enrichment, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Network this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Network$getEnrichment$2(Network network, Continuation<? super Network$getEnrichment$2> continuation) {
        super(2, continuation);
        this.this$0 = network;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Network$getEnrichment$2 network$getEnrichment$2 = new Network$getEnrichment$2(this.this$0, continuation);
        network$getEnrichment$2.L$0 = obj;
        return network$getEnrichment$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Enrichment enrichment, Continuation<? super Unit> continuation) {
        return ((Network$getEnrichment$2) create(enrichment, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            Enrichment enrichment = (Enrichment) this.L$0;
            ApiFactory apiFactory = this.this$0.factory;
            InternalSuperwallEvent.EnrichmentLoad enrichmentLoad = new InternalSuperwallEvent.EnrichmentLoad(new InternalSuperwallEvent.EnrichmentLoad.State.Complete(enrichment));
            this.label = 1;
            if (apiFactory.track(enrichmentLoad, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
