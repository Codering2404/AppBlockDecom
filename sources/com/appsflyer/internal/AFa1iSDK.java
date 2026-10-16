package com.appsflyer.internal;

import android.content.Context;
import com.applovin.sdk.AppLovinEventParameters;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.facebook.AuthenticationToken;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFa1iSDK implements Runnable {
    final String AFInAppEventParameterName;
    private final WeakReference<Context> AFInAppEventType;
    private final String AFKeystoreWrapper;
    private final String afDebugLog;
    private final AFb1gSDK afErrorLog;
    private final Map<String, String> afInfoLog;
    private final String afRDLog;
    final String valueOf;
    final String values;

    AFa1iSDK(Context context, String str, AFb1gSDK aFb1gSDK, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.AFInAppEventType = new WeakReference<>(context);
        this.AFKeystoreWrapper = str;
        this.afDebugLog = str2;
        this.values = str4;
        this.valueOf = str5;
        this.AFInAppEventParameterName = str6;
        this.afInfoLog = map;
        this.afRDLog = str3;
        this.afErrorLog = aFb1gSDK;
    }

    private static AFd1fSDK AFInAppEventParameterName(Context context, AFf1xSDK aFf1xSDK) {
        AFa1bSDK.values().AFInAppEventType(context);
        AFc1ySDK aFc1ySDKValueOf = AFa1bSDK.values().valueOf();
        aFf1xSDK.values(aFc1ySDKValueOf.AFInAppEventParameterName().valueOf.values("appsFlyerCount", 0));
        AFd1fSDK aFd1fSDK = new AFd1fSDK(aFf1xSDK, aFc1ySDKValueOf);
        AFd1xSDK aFd1xSDKAFLogger$LogLevel = aFc1ySDKValueOf.AFLogger$LogLevel();
        aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(aFd1fSDK));
        return aFd1fSDK;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.AFKeystoreWrapper;
        if (str == null || str.length() == 0 || AppsFlyerLib.getInstance().isStopped()) {
            return;
        }
        try {
            Context context = this.AFInAppEventType.get();
            if (context == null) {
                return;
            }
            HashMap map = new HashMap();
            map.put("public-key", this.afDebugLog);
            map.put("sig-data", this.values);
            map.put(AuthenticationToken.SIGNATURE_KEY, this.afRDLog);
            Object map2 = new HashMap(map);
            Object obj = this.afInfoLog;
            String strAFKeystoreWrapper = AFa1bSDK.values().valueOf().AFKeystoreWrapper().AFKeystoreWrapper("referrer", "");
            AFf1zSDK aFf1zSDK = new AFf1zSDK();
            aFf1zSDK.afRDLog = strAFKeystoreWrapper;
            AFa1bSDK aFa1bSDKValues = AFa1bSDK.values();
            Map<String, Object> mapValues = aFa1bSDKValues.values(aFf1zSDK);
            mapValues.put("price", this.valueOf);
            mapValues.put(AppLovinEventParameters.REVENUE_CURRENCY, this.AFInAppEventParameterName);
            mapValues.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, map2);
            if (obj != null) {
                mapValues.put("extra_prms", obj);
            }
            mapValues.putAll(aFa1bSDKValues.valueOf().getLevel().AFInAppEventType());
            aFf1zSDK.valueOf(mapValues);
            aFf1zSDK.values(new AFg1wSDK(this.afErrorLog).valueOf(aFf1zSDK));
            AFInAppEventParameterName(context, aFf1zSDK);
            map.put("dev_key", this.AFKeystoreWrapper);
            map.put("app_id", context.getPackageName());
            map.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
            String string = AppsFlyerProperties.getInstance().getString("advertiserId");
            if (string != null) {
                map.put("advertiserId", string);
            }
            AFf1wSDK aFf1wSDK = (AFf1wSDK) new AFf1wSDK().valueOf(map);
            aFf1wSDK.values(new AFg1wSDK(this.afErrorLog).valueOf(aFf1wSDK));
            final AFd1fSDK aFd1fSDKAFInAppEventParameterName = AFInAppEventParameterName(context, aFf1wSDK);
            aFf1wSDK.AFKeystoreWrapper = new AppsFlyerRequestListener() { // from class: com.appsflyer.internal.AFa1iSDK.2
                @Override // com.appsflyer.attribution.AppsFlyerRequestListener
                public final void onError(int i3, String str2) {
                    ResponseNetwork responseNetwork;
                    if (i3 == 50 && (responseNetwork = ((AFd1lSDK) aFd1fSDKAFInAppEventParameterName).afDebugLog) != null) {
                        str2 = responseNetwork.toString();
                    }
                    AFa1iSDK aFa1iSDK = AFa1iSDK.this;
                    AFa1iSDK.AFInAppEventParameterName(false, aFa1iSDK.values, aFa1iSDK.valueOf, aFa1iSDK.AFInAppEventParameterName, str2);
                }

                @Override // com.appsflyer.attribution.AppsFlyerRequestListener
                public final void onSuccess() {
                    try {
                        JSONObject jSONObject = new JSONObject((String) ((AFd1lSDK) aFd1fSDKAFInAppEventParameterName).afDebugLog.getBody());
                        AFLogger.afInfoLog("Validate response ok: ".concat(String.valueOf(jSONObject)));
                        boolean zOptBoolean = jSONObject.optBoolean("result");
                        AFa1iSDK aFa1iSDK = AFa1iSDK.this;
                        AFa1iSDK.AFInAppEventParameterName(zOptBoolean, aFa1iSDK.values, aFa1iSDK.valueOf, aFa1iSDK.AFInAppEventParameterName, jSONObject.toString());
                    } catch (Exception e3) {
                        AFLogger.afErrorLog("Failed Validate request: ".concat(String.valueOf(e3)), e3);
                        AFa1iSDK aFa1iSDK2 = AFa1iSDK.this;
                        AFa1iSDK.AFInAppEventParameterName(false, aFa1iSDK2.values, aFa1iSDK2.valueOf, aFa1iSDK2.AFInAppEventParameterName, e3.getMessage());
                    }
                }
            };
        } catch (Throwable th) {
            if (AFa1bSDK.AFInAppEventParameterName != null) {
                AFLogger.afErrorLog("Failed Validate request + ex", th);
                AFInAppEventParameterName(false, this.values, this.valueOf, this.AFInAppEventParameterName, th.getMessage());
            }
            AFLogger.afErrorLog(th.getMessage(), th);
        }
    }

    static void AFInAppEventParameterName(boolean z2, String str, String str2, String str3, String str4) {
        if (AFa1bSDK.AFInAppEventParameterName != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(" ");
            sb.append(str3);
            AFLogger.afDebugLog(sb.toString());
            if (z2) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AFa1bSDK.AFInAppEventParameterName.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFa1bSDK.AFInAppEventParameterName;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }
}
