package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFc1tSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFd1pSDK extends AFd1lSDK<String> {
    private final AFb1gSDK AFLogger;
    private final String AFLogger$LogLevel;
    private final PurchaseHandler.PurchaseValidationCallback AFVersionDeclaration;
    private final AFb1fSDK afErrorLogForExcManagerOnly;
    private final Map<String, Object> afWarnLog;
    private final AFe1rSDK getLevel;
    private final String onAppOpenAttributionNative;

    public AFd1pSDK(AFd1tSDK aFd1tSDK, AFd1tSDK[] aFd1tSDKArr, AFc1ySDK aFc1ySDK, String str, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        super(aFd1tSDK, aFd1tSDKArr, aFc1ySDK, str);
        AFb1gSDK aFb1gSDKAFInAppEventParameterName = aFc1ySDK.AFInAppEventParameterName();
        this.AFLogger = aFb1gSDKAFInAppEventParameterName;
        AFb1fSDK aFb1fSDKAFKeystoreWrapper = aFc1ySDK.AFKeystoreWrapper();
        this.afErrorLogForExcManagerOnly = aFb1fSDKAFKeystoreWrapper;
        AFe1rSDK aFe1rSDKAFLogger = aFc1ySDK.AFLogger();
        this.getLevel = aFe1rSDKAFLogger;
        String str2 = map.containsKey("billing_library_version") ? (String) map.remove("billing_library_version") : null;
        this.AFLogger$LogLevel = str2;
        String str3 = map.containsKey("connector_version") ? (String) map.remove("connector_version") : null;
        this.onAppOpenAttributionNative = str3;
        HashMap map2 = new HashMap(new HashMap(map));
        map2.put("app_id", aFb1gSDKAFInAppEventParameterName.values.values.getPackageName());
        map2.put("event_timestamp", Long.valueOf(aFe1rSDKAFLogger.AFKeystoreWrapper()));
        String strValues = AFb1gSDK.values();
        if (strValues != null) {
            map2.put("cuid", strValues);
        }
        Context context = aFb1gSDKAFInAppEventParameterName.values.values;
        map2.put("app_version_name", AFa1fSDK.AFKeystoreWrapper(context, context.getPackageName()));
        HashMap map3 = new HashMap();
        AFc1tSDK.AFa1wSDK aFa1wSDKAFInAppEventType = AFa1eSDK.AFInAppEventType(aFb1gSDKAFInAppEventParameterName.values.values, new HashMap());
        String str4 = aFa1wSDKAFInAppEventType != null ? aFa1wSDKAFInAppEventType.AFInAppEventParameterName : null;
        if (!AFb1tSDK.AFKeystoreWrapper(str4)) {
            map3.put("advertising_id", str4);
        }
        AFc1tSDK.AFa1wSDK aFa1wSDKAFInAppEventParameterName = AFa1eSDK.AFInAppEventParameterName(aFb1gSDKAFInAppEventParameterName.values.values.getContentResolver());
        String str5 = aFa1wSDKAFInAppEventParameterName != null ? aFa1wSDKAFInAppEventParameterName.AFInAppEventParameterName : null;
        if (!AFb1tSDK.AFKeystoreWrapper(str5)) {
            map3.put("oaid", str5);
        }
        AFc1tSDK.AFa1wSDK aFa1wSDKAFInAppEventParameterName2 = AFa1eSDK.AFInAppEventParameterName(aFb1gSDKAFInAppEventParameterName.values.values.getContentResolver());
        String str6 = aFa1wSDKAFInAppEventParameterName2 != null ? aFa1wSDKAFInAppEventParameterName2.AFInAppEventParameterName : null;
        if (!AFb1tSDK.AFKeystoreWrapper(str6)) {
            map3.put("amazon_aid", str6);
        }
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            String strAFInAppEventType = ((AFd1lSDK) this).afRDLog.AFInAppEventType(aFb1fSDKAFKeystoreWrapper);
            if (!AFb1tSDK.AFKeystoreWrapper(strAFInAppEventType)) {
                map3.put("imei", strAFInAppEventType);
            }
        }
        map3.put("appsflyer_id", AFa1aSDK.valueOf(aFb1gSDKAFInAppEventParameterName.values, aFb1gSDKAFInAppEventParameterName.valueOf));
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        map3.put("os_version", sb.toString());
        map3.put("sdk_version", "6.12.3");
        if (!AFb1tSDK.AFKeystoreWrapper(str3)) {
            map3.put("sdk_connector_version", str3);
        }
        map2.put("device_data", map3);
        if (!AFb1tSDK.AFKeystoreWrapper(str2)) {
            map2.put("billing_lib_version", str2);
        }
        this.afWarnLog = map2;
        this.AFVersionDeclaration = purchaseValidationCallback;
    }

    protected final void AFInAppEventParameterName(String str) {
        String string = new JSONObject(this.afWarnLog).toString();
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(": preparing data: ");
        sb.append(string);
        AFc1sSDK.values(sb.toString());
        ((AFd1lSDK) this).afInfoLog.values(str, string);
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    public final String AFVersionDeclaration() {
        return this.AFLogger$LogLevel;
    }

    protected final Map<String, Object> afErrorLogForExcManagerOnly() {
        return this.afWarnLog;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final boolean afRDLog() {
        return true;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public boolean valueOf() {
        ResponseNetwork responseNetwork = ((AFd1lSDK) this).afDebugLog;
        if (responseNetwork == null || responseNetwork.getStatusCode() != 503) {
            return super.valueOf();
        }
        return true;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final void values() {
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback;
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback2;
        super.values();
        Throwable thAfInfoLog = afInfoLog();
        if (thAfInfoLog != null && (purchaseValidationCallback2 = this.AFVersionDeclaration) != null) {
            purchaseValidationCallback2.onFailure(thAfInfoLog);
        }
        ResponseNetwork<String> responseNetwork = ((AFd1lSDK) this).afDebugLog;
        if (responseNetwork == null || (purchaseValidationCallback = this.AFVersionDeclaration) == null) {
            return;
        }
        purchaseValidationCallback.onResponse(responseNetwork);
    }
}
