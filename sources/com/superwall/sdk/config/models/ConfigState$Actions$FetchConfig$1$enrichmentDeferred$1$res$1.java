package com.superwall.sdk.config.models;

import com.superwall.sdk.config.ConfigContext;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.storage.LatestEnrichment;
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
@DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
final class ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1 extends SuspendLambda implements Function2<Enrichment, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConfigContext $$this$exec;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1(ConfigContext configContext, Continuation<? super ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1> continuation) {
        super(2, continuation);
        this.$$this$exec = configContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1 configState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1 = new ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1(this.$$this$exec, continuation);
        configState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1.L$0 = obj;
        return configState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Enrichment enrichment, Continuation<? super Unit> continuation) {
        return ((ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1) create(enrichment, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.$$this$exec.getStorage().write(LatestEnrichment.INSTANCE, (Enrichment) this.L$0);
        return Unit.f139807a;
    }
}
