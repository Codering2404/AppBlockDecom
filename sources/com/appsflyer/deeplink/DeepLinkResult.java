package com.appsflyer.deeplink;

import com.appsflyer.AFLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DeepLinkResult {
    private final DeepLink deepLink;
    private final Error error;
    private final Status status;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Error {
        TIMEOUT,
        NETWORK,
        HTTP_STATUS_CODE,
        UNEXPECTED,
        DEVELOPER_ERROR
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Status {
        FOUND,
        NOT_FOUND,
        ERROR
    }

    public DeepLinkResult(DeepLink deepLink, Error error) {
        this.deepLink = deepLink;
        this.error = error;
        if (error != null) {
            this.status = Status.ERROR;
        } else if (deepLink != null) {
            this.status = Status.FOUND;
        } else {
            this.status = Status.NOT_FOUND;
        }
    }

    public DeepLink getDeepLink() {
        return this.deepLink;
    }

    public Error getError() {
        return this.error;
    }

    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.PARAM_DEEP_LINK, this.deepLink);
            jSONObject.put("error", this.error);
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.status);
        } catch (JSONException e3) {
            AFLogger.afErrorLogForExcManagerOnly("error while creating deep link json", e3);
        }
        return jSONObject.toString();
    }
}
