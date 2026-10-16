package com.revenuecat.purchases.common.networking;

import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class HTTPRequest {
    public static final Companion Companion = new Companion(null);
    public static final String ETAG_HEADER_NAME = "X-RevenueCat-ETag";
    public static final String ETAG_LAST_REFRESH_NAME = "X-RC-Last-Refresh-Time";
    public static final String POST_PARAMS_HASH = "X-Post-Params-Hash";
    private final JSONObject body;
    private final URL fullURL;
    private final Map<String, String> headers;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public HTTPRequest(URL fullURL, Map<String, String> headers, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(fullURL, "fullURL");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.fullURL = fullURL;
        this.headers = headers;
        this.body = jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HTTPRequest copy$default(HTTPRequest hTTPRequest, URL url, Map map, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            url = hTTPRequest.fullURL;
        }
        if ((i3 & 2) != 0) {
            map = hTTPRequest.headers;
        }
        if ((i3 & 4) != 0) {
            jSONObject = hTTPRequest.body;
        }
        return hTTPRequest.copy(url, map, jSONObject);
    }

    public final URL component1() {
        return this.fullURL;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    public final JSONObject component3() {
        return this.body;
    }

    public final HTTPRequest copy(URL fullURL, Map<String, String> headers, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(fullURL, "fullURL");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new HTTPRequest(fullURL, headers, jSONObject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HTTPRequest)) {
            return false;
        }
        HTTPRequest hTTPRequest = (HTTPRequest) obj;
        return Intrinsics.areEqual(this.fullURL, hTTPRequest.fullURL) && Intrinsics.areEqual(this.headers, hTTPRequest.headers) && Intrinsics.areEqual(this.body, hTTPRequest.body);
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final URL getFullURL() {
        return this.fullURL;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public int hashCode() {
        int iHashCode = ((this.fullURL.hashCode() * 31) + this.headers.hashCode()) * 31;
        JSONObject jSONObject = this.body;
        return iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public String toString() {
        return "HTTPRequest(fullURL=" + this.fullURL + ", headers=" + this.headers + ", body=" + this.body + ')';
    }
}
