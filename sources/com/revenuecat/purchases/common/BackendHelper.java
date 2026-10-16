package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class BackendHelper {
    private final String apiKey;
    private final AppConfig appConfig;
    private final Map<String, String> authenticationHeaders;
    private final Dispatcher dispatcher;
    private final HTTPClient httpClient;

    public BackendHelper(String apiKey, Dispatcher dispatcher, AppConfig appConfig, HTTPClient httpClient) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.apiKey = apiKey;
        this.dispatcher = dispatcher;
        this.appConfig = appConfig;
        this.httpClient = httpClient;
        this.authenticationHeaders = MapsKt.mapOf(TuplesKt.a("Authorization", "Bearer " + apiKey));
    }

    public static /* synthetic */ void enqueue$default(BackendHelper backendHelper, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Delay delay, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            delay = Delay.NONE;
        }
        backendHelper.enqueue(asyncCall, dispatcher, delay);
    }

    public final void enqueue(Dispatcher.AsyncCall call, Dispatcher dispatcher, Delay delay) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(delay, "delay");
        if (dispatcher.isClosed()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Enqueuing operation in closed dispatcher.", null);
        } else {
            dispatcher.enqueue(call, delay);
        }
    }

    public final Map<String, String> getAuthenticationHeaders$purchases_defaultsBc8Release() {
        return this.authenticationHeaders;
    }

    public final void performRequest(final Endpoint endpoint, final Map<String, ? extends Object> map, final List<Pair<String, String>> list, Delay delay, final Function1<? super PurchasesError, Unit> onError, final Function3<? super PurchasesError, ? super Integer, ? super JSONObject, Unit> onCompleted) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(delay, "delay");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
        enqueue(new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.BackendHelper.performRequest.1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(BackendHelper.this.httpClient, BackendHelper.this.appConfig.getBaseURL(), endpoint, map, list, BackendHelper.this.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, BackendHelper.this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                PurchasesError purchasesError;
                Intrinsics.checkNotNullParameter(result, "result");
                if (BackendHelperKt.isSuccessful(result)) {
                    purchasesError = null;
                } else {
                    purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                }
                onCompleted.invoke(purchasesError, Integer.valueOf(result.getResponseCode()), result.getBody());
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }
        }, this.dispatcher, delay);
    }
}
