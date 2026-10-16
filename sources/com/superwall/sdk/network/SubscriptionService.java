package com.superwall.sdk.network;

import com.superwall.sdk.dependencies.ApiFactory;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.Task_RetryingKt;
import com.superwall.sdk.models.entitlements.RedeemRequest;
import com.superwall.sdk.models.entitlements.Redeemable;
import com.superwall.sdk.models.entitlements.TransactionReceipt;
import com.superwall.sdk.models.entitlements.WebEntitlements;
import com.superwall.sdk.models.internal.DeviceVendorId;
import com.superwall.sdk.models.internal.WebRedemptionResponse;
import com.superwall.sdk.network.session.CustomHttpUrlConnection;
import com.superwall.sdk.store.testmode.models.SuperwallProductsResponse;
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
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;

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
public final class SubscriptionService extends NetworkService {
    private final CustomHttpUrlConnection customHttpUrlConnection;
    private final ApiFactory factory;
    private final String host;
    private final Json json;
    private final String version;

    public SubscriptionService(String host, String version, ApiFactory factory, Json json, CustomHttpUrlConnection customHttpUrlConnection) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(customHttpUrlConnection, "customHttpUrlConnection");
        this.host = host;
        this.version = version;
        this.factory = factory;
        this.customHttpUrlConnection = customHttpUrlConnection;
        this.json = JsonKt.a(json, new Function1() { // from class: com.superwall.sdk.network.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SubscriptionService.json$lambda$0((JsonBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.j(null);
        Json.g(false);
        Json.h(true);
        Json.e(true);
        return Unit.f139807a;
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

    public final Object getProducts(Continuation<? super Either<SuperwallProductsResponse, NetworkError>> continuation) {
        return Task_RetryingKt.retrying(NetworkConsts.INSTANCE.retryCount(), null, new SubscriptionService$getProducts$$inlined$getrl3MWlM$default$1(getCustomHttpUrlConnection(), null, this, "products", null, UUID.randomUUID().toString(), false, null), continuation);
    }

    @Override // com.superwall.sdk.network.NetworkService
    public String getVersion() {
        return this.version;
    }

    @Override // com.superwall.sdk.network.NetworkService
    public Object makeHeaders(boolean z2, String str, Continuation<? super Map<String, String>> continuation) {
        return this.factory.makeHeaders(z2, str, continuation);
    }

    /* JADX INFO: renamed from: redeemToken-Jf2YlNw, reason: not valid java name */
    public final Object m1318redeemTokenJf2YlNw(List<Redeemable> list, String str, String str2, DeviceVendorId deviceVendorId, List<TransactionReceipt> list2, String str3, Map<String, ? extends JsonElement> map, Continuation<? super Either<WebRedemptionResponse, NetworkError>> continuation) {
        Json json = this.json;
        RedeemRequest redeemRequest = new RedeemRequest(deviceVendorId.getValue(), str == null ? null : str, str2, list, list2, str3, map);
        json.a();
        byte[] bytes = json.b(RedeemRequest.Companion.serializer(), redeemRequest).getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        Duration.Companion companion = Duration.f140631b;
        return Task_RetryingKt.retrying(0, null, new SubscriptionService$redeemTokenJf2YlNw$$inlined$post7Yrd8eY$default$1(getCustomHttpUrlConnection(), null, this, "redeem", bytes, UUID.randomUUID().toString(), false, Duration.f(DurationKt.s(10, DurationUnit.f140641f))), continuation);
    }

    public final Object webEntitlementsByDeviceId(DeviceVendorId deviceVendorId, Continuation<? super Either<WebEntitlements, NetworkError>> continuation) {
        String str = "users/" + deviceVendorId.getValue() + "/entitlements";
        List listListOf = CollectionsKt.listOf(new URLQueryItem("deviceId", deviceVendorId.getValue()));
        Duration.Companion companion = Duration.f140631b;
        return Task_RetryingKt.retrying(NetworkConsts.INSTANCE.retryCount(), null, new SubscriptionService$webEntitlementsByDeviceId$$inlined$getrl3MWlM$default$1(getCustomHttpUrlConnection(), null, this, str, listListOf, UUID.randomUUID().toString(), false, Duration.f(DurationKt.s(5, DurationUnit.f140641f))), continuation);
    }

    /* JADX INFO: renamed from: webEntitlementsByUserId-AKGx8qU, reason: not valid java name */
    public final Object m1319webEntitlementsByUserIdAKGx8qU(String str, DeviceVendorId deviceVendorId, Continuation<? super Either<WebEntitlements, NetworkError>> continuation) {
        if (str == null) {
            str = deviceVendorId.getValue();
        }
        String str2 = "users/" + str + "/entitlements";
        List listListOf = CollectionsKt.listOf(new URLQueryItem("deviceId", deviceVendorId.getValue()));
        Duration.Companion companion = Duration.f140631b;
        return Task_RetryingKt.retrying(NetworkConsts.INSTANCE.retryCount(), null, new SubscriptionService$webEntitlementsByUserIdAKGx8qU$$inlined$getrl3MWlM$default$1(getCustomHttpUrlConnection(), null, this, str2, listListOf, UUID.randomUUID().toString(), false, Duration.f(DurationKt.s(5, DurationUnit.f140641f))), continuation);
    }
}
