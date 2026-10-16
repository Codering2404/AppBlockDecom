package com.appsflyer;

import com.appsflyer.internal.AFb1gSDK;
import com.appsflyer.internal.AFc1rSDK;
import com.appsflyer.internal.AFc1ySDK;
import com.appsflyer.internal.AFd1xSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PurchaseHandler {
    public final AFc1ySDK AFInAppEventParameterName;
    public final AFd1xSDK valueOf;
    private final AFb1gSDK values;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PurchaseValidationCallback {
        void onFailure(Throwable th);

        void onResponse(ResponseNetwork<String> responseNetwork);
    }

    public PurchaseHandler(AFc1ySDK aFc1ySDK) {
        this.AFInAppEventParameterName = aFc1ySDK;
        this.values = aFc1ySDK.AFInAppEventParameterName();
        this.valueOf = aFc1ySDK.AFLogger$LogLevel();
    }

    public final boolean AFInAppEventType(Map<String, Object> map, PurchaseValidationCallback purchaseValidationCallback, String... strArr) {
        boolean zAFInAppEventType = AFc1rSDK.AFInAppEventType(map, strArr, this.values);
        if (!zAFInAppEventType && purchaseValidationCallback != null) {
            purchaseValidationCallback.onFailure(new IllegalArgumentException("Invalid Request Data"));
        }
        return zAFInAppEventType;
    }
}
