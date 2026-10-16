package com.superwall.sdk.network;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class RequestResult {
    private final double duration;
    private final Map<String, String> headers;
    private final String requestId;
    private final int responseCode;
    private final String responseMessage;

    public RequestResult(String requestId, int i3, String responseMessage, double d3, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.requestId = requestId;
        this.responseCode = i3;
        this.responseMessage = responseMessage;
        this.duration = d3;
        this.headers = headers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestResult copy$default(RequestResult requestResult, String str, int i3, String str2, double d3, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = requestResult.requestId;
        }
        if ((i4 & 2) != 0) {
            i3 = requestResult.responseCode;
        }
        if ((i4 & 4) != 0) {
            str2 = requestResult.responseMessage;
        }
        if ((i4 & 8) != 0) {
            d3 = requestResult.duration;
        }
        if ((i4 & 16) != 0) {
            map = requestResult.headers;
        }
        Map map2 = map;
        String str3 = str2;
        return requestResult.copy(str, i3, str3, d3, map2);
    }

    public final String component1() {
        return this.requestId;
    }

    public final int component2() {
        return this.responseCode;
    }

    public final String component3() {
        return this.responseMessage;
    }

    public final double component4() {
        return this.duration;
    }

    public final Map<String, String> component5() {
        return this.headers;
    }

    public final RequestResult copy(String requestId, int i3, String responseMessage, double d3, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new RequestResult(requestId, i3, responseMessage, d3, headers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestResult)) {
            return false;
        }
        RequestResult requestResult = (RequestResult) obj;
        return Intrinsics.areEqual(this.requestId, requestResult.requestId) && this.responseCode == requestResult.responseCode && Intrinsics.areEqual(this.responseMessage, requestResult.responseMessage) && Double.compare(this.duration, requestResult.duration) == 0 && Intrinsics.areEqual(this.headers, requestResult.headers);
    }

    public final double getDuration() {
        return this.duration;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public int hashCode() {
        return (((((((this.requestId.hashCode() * 31) + Integer.hashCode(this.responseCode)) * 31) + this.responseMessage.hashCode()) * 31) + Double.hashCode(this.duration)) * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "RequestResult(requestId=" + this.requestId + ", responseCode=" + this.responseCode + ", responseMessage=" + this.responseMessage + ", duration=" + this.duration + ", headers=" + this.headers + ")";
    }
}
