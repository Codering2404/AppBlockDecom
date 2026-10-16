package com.superwall.sdk.network;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.network.NetworkRequestData;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RequestExecutor {
    private final Function3<Boolean, String, Continuation<? super Map<String, String>>, Object> buildHeaders;

    /* JADX INFO: renamed from: com.superwall.sdk.network.RequestExecutor$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.RequestExecutor", f = "RequestExecutor.kt", l = {18, 63}, m = "execute")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RequestExecutor.this.execute(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestExecutor(Function3<? super Boolean, ? super String, ? super Continuation<? super Map<String, String>>, ? extends Object> buildHeaders) {
        Intrinsics.checkNotNullParameter(buildHeaders, "buildHeaders");
        this.buildHeaders = buildHeaders;
    }

    private final <T> HttpURLConnection buildRequest(NetworkRequestData<T> networkRequestData, Map<String, String> map) throws IOException {
        URL url;
        if (networkRequestData.getComponents() != null) {
            List<URLQueryItem> queryItems = networkRequestData.getComponents().getQueryItems();
            String strJoinToString$default = queryItems != null ? CollectionsKt.joinToString$default(queryItems, "&", null, null, 0, null, new Function1() { // from class: com.superwall.sdk.network.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RequestExecutor.buildRequest$lambda$1((URLQueryItem) obj);
                }
            }, 30, null) : null;
            String scheme = networkRequestData.getComponents().getScheme();
            String host = networkRequestData.getComponents().getHost();
            String path = networkRequestData.getComponents().getPath();
            if (strJoinToString$default == null) {
                strJoinToString$default = "";
            }
            url = new URL(scheme + "://" + host + path + "?" + strJoinToString$default);
        } else {
            if (networkRequestData.getUrl() == null) {
                return null;
            }
            url = networkRequestData.getUrl().toURL();
        }
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.setDoOutput(Intrinsics.areEqual(networkRequestData.getMethod().getMethod(), NetworkRequestData.HttpMethod.POST.getMethod()));
        NetworkRequestData.Components components = networkRequestData.getComponents();
        if ((components != null ? components.getBodyData() : null) != null) {
            httpURLConnection.setDoInput(true);
        }
        Duration durationM1313getTimeoutFghU774 = networkRequestData.m1313getTimeoutFghU774();
        httpURLConnection.setConnectTimeout(durationM1313getTimeoutFghU774 != null ? (int) Duration.p(durationM1313getTimeoutFghU774.S()) : 0);
        Duration durationM1313getTimeoutFghU7742 = networkRequestData.m1313getTimeoutFghU774();
        httpURLConnection.setReadTimeout(durationM1313getTimeoutFghU7742 != null ? (int) Duration.p(durationM1313getTimeoutFghU7742.S()) : 0);
        NetworkRequestData.Components components2 = networkRequestData.getComponents();
        if ((components2 != null ? components2.getBodyData() : null) != null) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(networkRequestData.getComponents().getBodyData());
            outputStream.close();
        }
        httpURLConnection.setRequestMethod(networkRequestData.getMethod().getMethod());
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildRequest$lambda$1(URLQueryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName() + "=" + it.getValue();
    }

    private final String getRequestId(HttpURLConnection httpURLConnection, String str, double d3) throws IOException, NetworkError {
        String headerField = httpURLConnection.getHeaderField("x-request-id");
        if (headerField == null) {
            headerField = "unknown";
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 401) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.network, "Unable to Authenticate", MapsKt.mapOf(TuplesKt.a("request", httpURLConnection.toString()), TuplesKt.a("api_key", str), TuplesKt.a("url", httpURLConnection.getURL().toString()), TuplesKt.a("request_id", headerField), TuplesKt.a("request_duration", Double.valueOf(d3))), (Throwable) null, 16, (Object) null);
            throw new NetworkError.NotAuthenticated();
        }
        if (responseCode != 404) {
            return headerField;
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.network, "Not Found", MapsKt.mapOf(TuplesKt.a("request", httpURLConnection.toString()), TuplesKt.a("api_key", str), TuplesKt.a("url", httpURLConnection.getURL().toString()), TuplesKt.a("request_id", headerField), TuplesKt.a("request_duration", Double.valueOf(d3))), (Throwable) null, 16, (Object) null);
        throw new NetworkError.NotFound();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object execute(com.superwall.sdk.network.NetworkRequestData<?> r24, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.network.RequestResult, com.superwall.sdk.network.NetworkError>> r25) {
        /*
            Method dump skipped, instruction units count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.RequestExecutor.execute(com.superwall.sdk.network.NetworkRequestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Function3<Boolean, String, Continuation<? super Map<String, String>>, Object> getBuildHeaders() {
        return this.buildHeaders;
    }
}
