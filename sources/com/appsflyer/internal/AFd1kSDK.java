package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1kSDK extends AFd1pSDK {
    public AFd1kSDK(Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, AFc1ySDK aFc1ySDK) {
        super(AFd1tSDK.PURCHASE_VALIDATE, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, aFc1ySDK, null, map, purchaseValidationCallback);
        this.values.add(AFd1tSDK.CONVERSION);
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AFc1qSDK<String> AFInAppEventType(String str) throws Throwable {
        AFc1qSDK<String> aFc1qSDKAFInAppEventParameterName = ((AFd1lSDK) this).afErrorLog.AFInAppEventParameterName(afErrorLogForExcManagerOnly(), str, AFVersionDeclaration());
        if (aFc1qSDKAFInAppEventParameterName != null) {
            AFInAppEventParameterName(aFc1qSDKAFInAppEventParameterName.AFInAppEventParameterName.AFKeystoreWrapper);
        }
        return aFc1qSDKAFInAppEventParameterName;
    }
}
