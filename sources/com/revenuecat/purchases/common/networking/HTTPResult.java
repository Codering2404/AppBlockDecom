package com.revenuecat.purchases.common.networking;

import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.revenuecat.purchases.VerificationResult;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
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
public final class HTTPResult {
    public static final Companion Companion = new Companion(null);
    public static final String ETAG_HEADER_NAME = "X-RevenueCat-ETag";
    public static final String LOAD_SHEDDER_HEADER_NAME = "x-revenuecat-fortress";
    public static final String REQUEST_TIME_HEADER_NAME = "X-RevenueCat-Request-Time";
    public static final String SIGNATURE_HEADER_NAME = "X-Signature";
    private final Integer backendErrorCode;
    private final String backendErrorMessage;
    private final JSONObject body;
    private final boolean isFallbackURL;
    private final boolean isLoadShedderResponse;
    private final Origin origin;
    private final String payload;
    private final Date requestDate;
    private final int responseCode;
    private final VerificationResult verificationResult;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HTTPResult deserialize$purchases_defaultsBc8Release(String serialized) throws JSONException {
            Origin originValueOf;
            VerificationResult verificationResultValueOf;
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            JSONObject jSONObject = new JSONObject(serialized);
            int i3 = jSONObject.getInt("responseCode");
            String payload = jSONObject.getString("payload");
            if (jSONObject.has("origin")) {
                String string = jSONObject.getString("origin");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(SERIALIZATION_NAME_ORIGIN)");
                originValueOf = Origin.valueOf(string);
            } else {
                originValueOf = Origin.CACHE;
            }
            Origin origin = originValueOf;
            Date date = jSONObject.has("requestDate") ? new Date(jSONObject.getLong("requestDate")) : null;
            if (jSONObject.has("verificationResult")) {
                String string2 = jSONObject.getString("verificationResult");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(SER…NAME_VERIFICATION_RESULT)");
                verificationResultValueOf = VerificationResult.valueOf(string2);
            } else {
                verificationResultValueOf = VerificationResult.NOT_REQUESTED;
            }
            VerificationResult verificationResult = verificationResultValueOf;
            boolean z2 = jSONObject.has("isLoadShedderResponse") ? jSONObject.getBoolean("isLoadShedderResponse") : false;
            boolean z3 = jSONObject.has("isFallbackURL") ? jSONObject.getBoolean("isFallbackURL") : false;
            Intrinsics.checkNotNullExpressionValue(payload, "payload");
            return new HTTPResult(i3, payload, origin, date, verificationResult, z2, z3);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Origin {
        BACKEND,
        CACHE
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HTTPResult(int r2, java.lang.String r3, com.revenuecat.purchases.common.networking.HTTPResult.Origin r4, java.util.Date r5, com.revenuecat.purchases.VerificationResult r6, boolean r7, boolean r8) {
        /*
            r1 = this;
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "origin"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "verificationResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r1.<init>()
            r1.responseCode = r2
            r1.payload = r3
            r1.origin = r4
            r1.requestDate = r5
            r1.verificationResult = r6
            r1.isLoadShedderResponse = r7
            r1.isFallbackURL = r8
            boolean r2 = kotlin.text.StringsKt.p0(r3)
            r4 = 0
            if (r2 != 0) goto L28
            goto L29
        L28:
            r3 = r4
        L29:
            if (r3 == 0) goto L50
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L31
            r2.<init>(r3)     // Catch: org.json.JSONException -> L31
            goto L4d
        L31:
            r2 = move-exception
            com.revenuecat.purchases.LogHandler r5 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Failed to parse payload as JSON: "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.lang.String r6 = "[Purchases] - ERROR"
            r5.e(r6, r3, r2)
            r2 = r4
        L4d:
            if (r2 == 0) goto L50
            goto L55
        L50:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
        L55:
            r1.body = r2
            boolean r3 = com.revenuecat.purchases.common.BackendHelperKt.isSuccessful(r1)
            if (r3 != 0) goto L6e
            java.lang.String r3 = "code"
            int r3 = r2.optInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r5 = r3.intValue()
            if (r5 <= 0) goto L6e
            goto L6f
        L6e:
            r3 = r4
        L6f:
            r1.backendErrorCode = r3
            boolean r3 = com.revenuecat.purchases.common.BackendHelperKt.isSuccessful(r1)
            if (r3 != 0) goto L89
            java.lang.String r3 = "message"
            java.lang.String r2 = r2.optString(r3)
            java.lang.String r3 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r3 = kotlin.text.StringsKt.p0(r2)
            if (r3 != 0) goto L89
            r4 = r2
        L89:
            r1.backendErrorMessage = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.networking.HTTPResult.<init>(int, java.lang.String, com.revenuecat.purchases.common.networking.HTTPResult$Origin, java.util.Date, com.revenuecat.purchases.VerificationResult, boolean, boolean):void");
    }

    public static /* synthetic */ HTTPResult copy$default(HTTPResult hTTPResult, int i3, String str, Origin origin, Date date, VerificationResult verificationResult, boolean z2, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = hTTPResult.responseCode;
        }
        if ((i4 & 2) != 0) {
            str = hTTPResult.payload;
        }
        if ((i4 & 4) != 0) {
            origin = hTTPResult.origin;
        }
        if ((i4 & 8) != 0) {
            date = hTTPResult.requestDate;
        }
        if ((i4 & 16) != 0) {
            verificationResult = hTTPResult.verificationResult;
        }
        if ((i4 & 32) != 0) {
            z2 = hTTPResult.isLoadShedderResponse;
        }
        if ((i4 & 64) != 0) {
            z3 = hTTPResult.isFallbackURL;
        }
        boolean z4 = z2;
        boolean z5 = z3;
        VerificationResult verificationResult2 = verificationResult;
        Origin origin2 = origin;
        return hTTPResult.copy(i3, str, origin2, date, verificationResult2, z4, z5);
    }

    public final int component1() {
        return this.responseCode;
    }

    public final String component2() {
        return this.payload;
    }

    public final Origin component3() {
        return this.origin;
    }

    public final Date component4() {
        return this.requestDate;
    }

    public final VerificationResult component5() {
        return this.verificationResult;
    }

    public final boolean component6() {
        return this.isLoadShedderResponse;
    }

    public final boolean component7() {
        return this.isFallbackURL;
    }

    public final HTTPResult copy(int i3, String payload, Origin origin, Date date, VerificationResult verificationResult, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        return new HTTPResult(i3, payload, origin, date, verificationResult, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HTTPResult)) {
            return false;
        }
        HTTPResult hTTPResult = (HTTPResult) obj;
        return this.responseCode == hTTPResult.responseCode && Intrinsics.areEqual(this.payload, hTTPResult.payload) && this.origin == hTTPResult.origin && Intrinsics.areEqual(this.requestDate, hTTPResult.requestDate) && this.verificationResult == hTTPResult.verificationResult && this.isLoadShedderResponse == hTTPResult.isLoadShedderResponse && this.isFallbackURL == hTTPResult.isFallbackURL;
    }

    public final Integer getBackendErrorCode() {
        return this.backendErrorCode;
    }

    public final String getBackendErrorMessage() {
        return this.backendErrorMessage;
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final VerificationResult getVerificationResult() {
        return this.verificationResult;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.responseCode) * 31) + this.payload.hashCode()) * 31) + this.origin.hashCode()) * 31;
        Date date = this.requestDate;
        return ((((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.verificationResult.hashCode()) * 31) + Boolean.hashCode(this.isLoadShedderResponse)) * 31) + Boolean.hashCode(this.isFallbackURL);
    }

    public final boolean isFallbackURL() {
        return this.isFallbackURL;
    }

    public final boolean isLoadShedderResponse() {
        return this.isLoadShedderResponse;
    }

    public String toString() {
        return "HTTPResult(responseCode=" + this.responseCode + ", payload=" + this.payload + ", origin=" + this.origin + ", requestDate=" + this.requestDate + ", verificationResult=" + this.verificationResult + ", isLoadShedderResponse=" + this.isLoadShedderResponse + ", isFallbackURL=" + this.isFallbackURL + ')';
    }

    public final String serialize$purchases_defaultsBc8Release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("responseCode", this.responseCode);
        jSONObject.put("payload", this.payload);
        jSONObject.put("origin", this.origin.name());
        Date date = this.requestDate;
        jSONObject.put("requestDate", date != null ? Long.valueOf(date.getTime()) : null);
        jSONObject.put("verificationResult", this.verificationResult.name());
        jSONObject.put(CbYNFSEGaQj.EcYGCC, this.isLoadShedderResponse);
        jSONObject.put("isFallbackURL", this.isFallbackURL);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
        return string;
    }
}
