package com.superwall.sdk.config.models;

import com.superwall.sdk.config.ConfigContext;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.network.NetworkError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1", f = "ConfigState.kt", l = {135, 136, 147}, m = "invokeSuspend")
final class ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Enrichment, NetworkError>>, Object> {
    final /* synthetic */ ConfigContext $$this$exec;
    final /* synthetic */ long $cacheLimit;
    final /* synthetic */ Ref.BooleanRef $isEnrichmentFromCache;
    final /* synthetic */ Config $oldConfig;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1(ConfigContext configContext, Config config, long j3, Ref.BooleanRef booleanRef, Continuation<? super ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1> continuation) {
        super(2, continuation);
        this.$$this$exec = configContext;
        this.$oldConfig = config;
        this.$cacheLimit = j3;
        this.$isEnrichmentFromCache = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1(this.$$this$exec, this.$oldConfig, this.$cacheLimit, this.$isEnrichmentFromCache, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
    
        if (r10 == r0) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L26
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.b(r10)
            goto Lb0
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1e:
            java.lang.Object r0 = r9.L$0
            com.superwall.sdk.models.enrichment.Enrichment r0 = (com.superwall.sdk.models.enrichment.Enrichment) r0
            kotlin.ResultKt.b(r10)
            goto L7c
        L26:
            java.lang.Object r1 = r9.L$0
            com.superwall.sdk.models.enrichment.Enrichment r1 = (com.superwall.sdk.models.enrichment.Enrichment) r1
            kotlin.ResultKt.b(r10)
            goto L66
        L2e:
            kotlin.ResultKt.b(r10)
            com.superwall.sdk.config.ConfigContext r10 = r9.$$this$exec
            com.superwall.sdk.storage.Storage r10 = r10.getStorage()
            com.superwall.sdk.storage.LatestEnrichment r1 = com.superwall.sdk.storage.LatestEnrichment.INSTANCE
            java.lang.Object r10 = r10.read(r1)
            com.superwall.sdk.models.enrichment.Enrichment r10 = (com.superwall.sdk.models.enrichment.Enrichment) r10
            com.superwall.sdk.models.config.Config r1 = r9.$oldConfig
            r5 = 0
            if (r1 == 0) goto L99
            com.superwall.sdk.models.config.FeatureFlags r1 = r1.getFeatureFlags()
            if (r1 == 0) goto L99
            boolean r1 = r1.getEnableConfigRefresh()
            if (r1 != r4) goto L99
            com.superwall.sdk.config.ConfigContext r1 = r9.$$this$exec
            com.superwall.sdk.network.device.DeviceHelper r1 = r1.getDeviceHelper()
            long r6 = r9.$cacheLimit
            r9.L$0 = r10
            r9.label = r4
            java.lang.Object r1 = r1.m1320getEnrichment8Mi8wO0(r5, r6, r9)
            if (r1 != r0) goto L63
            goto Laf
        L63:
            r8 = r1
            r1 = r10
            r10 = r8
        L66:
            com.superwall.sdk.misc.Either r10 = (com.superwall.sdk.misc.Either) r10
            com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1 r2 = new com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1$res$1
            com.superwall.sdk.config.ConfigContext r5 = r9.$$this$exec
            r6 = 0
            r2.<init>(r5, r6)
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = com.superwall.sdk.misc.EitherKt.then(r10, r2, r9)
            if (r10 != r0) goto L7b
            goto Laf
        L7b:
            r0 = r1
        L7c:
            com.superwall.sdk.misc.Either r10 = (com.superwall.sdk.misc.Either) r10
            java.lang.Object r1 = r10.getSuccess()
            if (r1 != 0) goto L98
            if (r0 == 0) goto L98
            com.superwall.sdk.config.ConfigContext r10 = r9.$$this$exec
            kotlin.jvm.internal.Ref$BooleanRef r1 = r9.$isEnrichmentFromCache
            com.superwall.sdk.network.device.DeviceHelper r10 = r10.getDeviceHelper()
            r10.setEnrichment$superwall_release(r0)
            r1.f140137a = r4
            com.superwall.sdk.misc.Either$Success r10 = new com.superwall.sdk.misc.Either$Success
            r10.<init>(r0)
        L98:
            return r10
        L99:
            com.superwall.sdk.config.ConfigContext r10 = r9.$$this$exec
            com.superwall.sdk.network.device.DeviceHelper r10 = r10.getDeviceHelper()
            kotlin.time.Duration$Companion r1 = kotlin.time.Duration.f140631b
            kotlin.time.DurationUnit r1 = kotlin.time.DurationUnit.f140641f
            long r3 = kotlin.time.DurationKt.s(r4, r1)
            r9.label = r2
            java.lang.Object r10 = r10.m1320getEnrichment8Mi8wO0(r5, r3, r9)
            if (r10 != r0) goto Lb0
        Laf:
            return r0
        Lb0:
            com.superwall.sdk.misc.Either r10 = (com.superwall.sdk.misc.Either) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<Enrichment, NetworkError>> continuation) {
        return ((ConfigState$Actions$FetchConfig$1$enrichmentDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
