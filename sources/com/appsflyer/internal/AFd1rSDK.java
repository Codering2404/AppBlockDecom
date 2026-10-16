package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1rSDK extends AFd1pSDK {
    public AFd1rSDK(Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, AFc1ySDK aFc1ySDK) {
        super(AFd1tSDK.ARS_VALIDATE, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, aFc1ySDK, null, map, purchaseValidationCallback);
        this.values.add(AFd1tSDK.CONVERSION);
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AFc1qSDK<String> AFInAppEventType(String str) throws Throwable {
        AFc1qSDK<String> aFc1qSDKAFInAppEventType = ((AFd1lSDK) this).afErrorLog.AFInAppEventType(afErrorLogForExcManagerOnly(), str, AFVersionDeclaration());
        if (aFc1qSDKAFInAppEventType != null) {
            AFInAppEventParameterName(aFc1qSDKAFInAppEventType.AFInAppEventParameterName.AFKeystoreWrapper);
        }
        return aFc1qSDKAFInAppEventType;
    }

    @Override // com.appsflyer.internal.AFd1pSDK, com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final boolean valueOf() {
        ResponseNetwork responseNetwork = ((AFd1lSDK) this).afDebugLog;
        if (responseNetwork == null || responseNetwork.getStatusCode() != 424) {
            return super.valueOf();
        }
        return true;
    }
}
