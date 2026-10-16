package com.superwall.sdk.network;

import com.superwall.sdk.dependencies.ApiFactory;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.Task_RetryingKt;
import com.superwall.sdk.models.assignment.AssignmentPostback;
import com.superwall.sdk.models.assignment.ConfirmedAssignmentResponse;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.paywall.Paywalls;
import com.superwall.sdk.network.session.CustomHttpUrlConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
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
public final class BaseHostService extends NetworkService {
    private final CustomHttpUrlConnection customHttpUrlConnection;
    private final ApiFactory factory;
    private final String host;
    private final Json json;
    private final String version;

    public BaseHostService(String host, String version, ApiFactory factory, Json json, CustomHttpUrlConnection customHttpUrlConnection) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object config$default(BaseHostService baseHostService, String str, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        return baseHostService.config(str, function1, continuation);
    }

    public static /* synthetic */ Object paywall$default(BaseHostService baseHostService, String str, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return baseHostService.paywall(str, continuation);
    }

    public static /* synthetic */ Object paywalls$default(BaseHostService baseHostService, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return baseHostService.paywalls(z2, continuation);
    }

    public final Object assignments(Continuation<? super Either<ConfirmedAssignmentResponse, NetworkError>> continuation) {
        return Task_RetryingKt.retrying(NetworkConsts.INSTANCE.retryCount(), null, new BaseHostService$assignments$$inlined$getrl3MWlM$default$1(getCustomHttpUrlConnection(), null, this, "assignments", null, UUID.randomUUID().toString(), false, null), continuation);
    }

    public final Object config(String str, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Either<Config, NetworkError>> continuation) {
        return Task_RetryingKt.retrying(NetworkConsts.INSTANCE.retryCount(), function1, new BaseHostService$config$$inlined$getrl3MWlM$default$1(getCustomHttpUrlConnection(), null, this, "static_config", CollectionsKt.listOf(new URLQueryItem("pk", this.factory.getStorage().getApiKey())), str, false, null), continuation);
    }

    public final Object confirmAssignments(AssignmentPostback assignmentPostback, Continuation<? super Either<ConfirmedAssignmentResponse, NetworkError>> continuation) {
        Json json = this.json;
        json.a();
        byte[] bytes = json.b(AssignmentPostback.Companion.serializer(), assignmentPostback).getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return Task_RetryingKt.retrying(6, null, new BaseHostService$confirmAssignments$$inlined$post7Yrd8eY$default$1(getCustomHttpUrlConnection(), null, this, "confirm_assignments", bytes, UUID.randomUUID().toString(), false, null), continuation);
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

    public final Object paywall(String str, Continuation<? super Either<Paywall, NetworkError>> continuation) {
        List listMutableListOf = CollectionsKt.mutableListOf(new URLQueryItem("pk", this.factory.getStorage().getApiKey()));
        Config config = this.factory.getConfigManager().getConfig();
        if (config != null) {
            if (config.getLocales().contains(this.factory.getDeviceHelper().getLocale())) {
                listMutableListOf.add(new URLQueryItem("locale", this.factory.getDeviceHelper().getLocale()));
            } else {
                String str2 = (String) StringsKt.V0(this.factory.getDeviceHelper().getLocale(), new String[]{"_"}, false, 0, 6, null).get(0);
                if (config.getLocales().contains(str2)) {
                    listMutableListOf.add(new URLQueryItem("locale", str2));
                }
            }
        }
        return Task_RetryingKt.retrying(NetworkConsts.INSTANCE.retryCount(), null, new BaseHostService$paywall$$inlined$getrl3MWlM$default$1(getCustomHttpUrlConnection(), null, this, "paywall/" + str, listMutableListOf, UUID.randomUUID().toString(), true, null), continuation);
    }

    public final Object paywalls(boolean z2, Continuation<? super Either<Paywalls, NetworkError>> continuation) {
        return Task_RetryingKt.retrying(NetworkConsts.INSTANCE.retryCount(), null, new BaseHostService$paywalls$$inlined$getrl3MWlM$default$1(getCustomHttpUrlConnection(), null, this, "paywalls", null, UUID.randomUUID().toString(), z2, null), continuation);
    }
}
