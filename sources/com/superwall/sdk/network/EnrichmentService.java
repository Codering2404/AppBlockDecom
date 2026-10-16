package com.superwall.sdk.network;

import com.superwall.sdk.dependencies.ApiFactory;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.EitherKt;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.models.enrichment.EnrichmentRequest;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.network.session.CustomHttpUrlConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

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
public final class EnrichmentService extends NetworkService {
    private final CustomHttpUrlConnection customHttpUrlConnection;
    private final ApiFactory factory;
    private final String host;
    private final String version;

    public EnrichmentService(String host, String version, ApiFactory factory, CustomHttpUrlConnection customHttpUrlConnection) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(customHttpUrlConnection, "customHttpUrlConnection");
        this.host = host;
        this.version = version;
        this.factory = factory;
        this.customHttpUrlConnection = customHttpUrlConnection;
    }

    /* JADX INFO: renamed from: enrichment-exY8QGI$default, reason: not valid java name */
    public static /* synthetic */ Object m1305enrichmentexY8QGI$default(EnrichmentService enrichmentService, EnrichmentRequest enrichmentRequest, int i3, long j3, Continuation continuation, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        int i5 = i3;
        if ((i4 & 4) != 0) {
            Duration.Companion companion = Duration.f140631b;
            j3 = DurationKt.s(1, DurationUnit.f140641f);
        }
        return enrichmentService.m1306enrichmentexY8QGI(enrichmentRequest, i5, j3, continuation);
    }

    /* JADX INFO: renamed from: enrichment-exY8QGI, reason: not valid java name */
    public final Object m1306enrichmentexY8QGI(EnrichmentRequest enrichmentRequest, int i3, long j3, Continuation<? super Either<Enrichment, NetworkError>> continuation) {
        return EitherKt.m1275eitherWithTimeoutrnQQ1Ag(j3, new Function0() { // from class: com.superwall.sdk.network.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NetworkError.Timeout.INSTANCE;
            }
        }, new EnrichmentService$enrichment$3(this, enrichmentRequest, i3, j3, null), continuation);
    }

    @Override // com.superwall.sdk.network.NetworkService
    public CustomHttpUrlConnection getCustomHttpUrlConnection() {
        return this.customHttpUrlConnection;
    }

    public final ApiFactory getFactory() {
        return this.factory;
    }

    @Override // com.superwall.sdk.network.NetworkService
    public String getHost() {
        return this.host;
    }

    @Override // com.superwall.sdk.network.NetworkService
    public String getVersion() {
        return this.version;
    }

    @Override // com.superwall.sdk.network.NetworkService
    public Object makeHeaders(boolean z2, String str, Continuation<? super Map<String, String>> continuation) {
        return this.factory.makeHeaders(z2, str, continuation);
    }
}
