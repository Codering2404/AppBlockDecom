package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFc1qSDK<ResponseBody> {
    public final AFb1zSDK AFInAppEventParameterName;
    private final AtomicBoolean AFInAppEventType = new AtomicBoolean(false);
    private final ExecutorService AFKeystoreWrapper;
    private final AFc1gSDK<ResponseBody> valueOf;
    private final AFc1lSDK values;

    public AFc1qSDK(AFb1zSDK aFb1zSDK, ExecutorService executorService, AFc1lSDK aFc1lSDK, AFc1gSDK<ResponseBody> aFc1gSDK) {
        this.AFInAppEventParameterName = aFb1zSDK;
        this.AFKeystoreWrapper = executorService;
        this.values = aFc1lSDK;
        this.valueOf = aFc1gSDK;
    }

    public final AFc1dSDK<ResponseBody> AFKeystoreWrapper() throws Throwable {
        if (this.AFInAppEventType.getAndSet(true)) {
            throw new IllegalStateException("Http call is already executed");
        }
        AFc1dSDK<String> aFc1dSDKAFKeystoreWrapper = this.values.AFKeystoreWrapper(this.AFInAppEventParameterName);
        try {
            return new AFc1dSDK<>(this.valueOf.values(aFc1dSDKAFKeystoreWrapper.getBody()), aFc1dSDKAFKeystoreWrapper.valueOf, aFc1dSDKAFKeystoreWrapper.values, aFc1dSDKAFKeystoreWrapper.AFKeystoreWrapper, aFc1dSDKAFKeystoreWrapper.AFInAppEventType);
        } catch (JSONException e3) {
            AFLogger.afErrorLogForExcManagerOnly("could not parse raw response - execute", e3);
            throw new ParsingException(e3.getMessage(), e3, aFc1dSDKAFKeystoreWrapper);
        }
    }
}
