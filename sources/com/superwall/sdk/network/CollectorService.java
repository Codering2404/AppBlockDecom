package com.superwall.sdk.network;

import com.superwall.sdk.dependencies.ApiFactory;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.Task_RetryingKt;
import com.superwall.sdk.models.events.EventsRequest;
import com.superwall.sdk.models.events.EventsResponse;
import com.superwall.sdk.network.session.CustomHttpUrlConnection;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
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
public final class CollectorService extends NetworkService {
    private final CustomHttpUrlConnection customHttpUrlConnection;
    private final ApiFactory factory;
    private final String host;
    private final Json json;
    private final String version;

    public CollectorService(String host, String version, ApiFactory factory, Json json, CustomHttpUrlConnection customHttpUrlConnection) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(customHttpUrlConnection, "customHttpUrlConnection");
        this.host = host;
        this.version = version;
        this.factory = factory;
        this.json = json;
        this.customHttpUrlConnection = customHttpUrlConnection;
    }

    public final Object events(EventsRequest eventsRequest, Continuation<? super Either<EventsResponse, NetworkError>> continuation) {
        Json json = this.json;
        json.a();
        byte[] bytes = json.b(EventsRequest.Companion.serializer(), eventsRequest).getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return Task_RetryingKt.retrying(6, null, new CollectorService$events$$inlined$post7Yrd8eY$default$1(getCustomHttpUrlConnection(), null, this, "events", bytes, UUID.randomUUID().toString(), false, null), continuation);
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
