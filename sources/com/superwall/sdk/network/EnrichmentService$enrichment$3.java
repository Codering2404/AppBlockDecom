package com.superwall.sdk.network;

import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.Task_RetryingKt;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.models.enrichment.EnrichmentRequest;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.time.Duration;
import kotlinx.serialization.json.Json;

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
@DebugMetadata(c = "com.superwall.sdk.network.EnrichmentService$enrichment$3", f = "EnrichmentService.kt", l = {53}, m = "invokeSuspend")
final class EnrichmentService$enrichment$3 extends SuspendLambda implements Function1<Continuation<? super Either<? extends Enrichment, NetworkError>>, Object> {
    final /* synthetic */ EnrichmentRequest $enrichmentRequest;
    final /* synthetic */ int $maxRetry;
    final /* synthetic */ long $timeout;
    int label;
    final /* synthetic */ EnrichmentService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EnrichmentService$enrichment$3(EnrichmentService enrichmentService, EnrichmentRequest enrichmentRequest, int i3, long j3, Continuation<? super EnrichmentService$enrichment$3> continuation) {
        super(1, continuation);
        this.this$0 = enrichmentService;
        this.$enrichmentRequest = enrichmentRequest;
        this.$maxRetry = i3;
        this.$timeout = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new EnrichmentService$enrichment$3(this.this$0, this.$enrichmentRequest, this.$maxRetry, this.$timeout, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Json json = this.this$0.getFactory().json();
        EnrichmentRequest enrichmentRequest = this.$enrichmentRequest;
        json.a();
        byte[] bytes = json.b(EnrichmentRequest.Companion.serializer(), enrichmentRequest).getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        EnrichmentService enrichmentService = this.this$0;
        int i4 = this.$maxRetry;
        EnrichmentService$enrichment$3$invokeSuspend$$inlined$post7Yrd8eY$default$1 enrichmentService$enrichment$3$invokeSuspend$$inlined$post7Yrd8eY$default$1 = new EnrichmentService$enrichment$3$invokeSuspend$$inlined$post7Yrd8eY$default$1(enrichmentService.getCustomHttpUrlConnection(), null, enrichmentService, "enrich", bytes, UUID.randomUUID().toString(), false, Duration.f(this.$timeout));
        this.label = 1;
        Object objRetrying = Task_RetryingKt.retrying(i4, null, enrichmentService$enrichment$3$invokeSuspend$$inlined$post7Yrd8eY$default$1, this);
        return objRetrying == objF ? objF : objRetrying;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Either<Enrichment, NetworkError>> continuation) {
        return ((EnrichmentService$enrichment$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
