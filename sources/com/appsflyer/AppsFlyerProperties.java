package com.appsflyer;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1fSDK;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    private static final AppsFlyerProperties AFInAppEventType = new AppsFlyerProperties();
    public static final String AF_STORE_FROM_API = "api_store_value";
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_NETWORK_DATA = "disableCollectNetworkData";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    public static final String HTTP_CACHE = "http_cache";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String ONELINK_VERSION = "onelinkVersion";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";
    public String AFKeystoreWrapper;
    public boolean values;
    private final Map<String, Object> AFInAppEventParameterName = new HashMap();
    private boolean valueOf = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum EmailsCryptType {
        NONE(0),
        SHA256(3);

        private final int AFKeystoreWrapper;

        EmailsCryptType(int i3) {
            this.AFKeystoreWrapper = i3;
        }

        public final int getValue() {
            return this.AFKeystoreWrapper;
        }
    }

    private AppsFlyerProperties() {
    }

    public static AppsFlyerProperties getInstance() {
        return AFInAppEventType;
    }

    private boolean valueOf() {
        return this.valueOf;
    }

    public final boolean AFInAppEventParameterName() {
        return this.values;
    }

    public boolean getBoolean(String str, boolean z2) {
        String string = getString(str);
        return string == null ? z2 : Boolean.parseBoolean(string);
    }

    public int getInt(String str, int i3) {
        String string = getString(str);
        return string == null ? i3 : Integer.parseInt(string);
    }

    public long getLong(String str, long j3) {
        String string = getString(str);
        return string == null ? j3 : Long.parseLong(string);
    }

    public synchronized Object getObject(String str) {
        return this.AFInAppEventParameterName.get(str);
    }

    public String getReferrer(AFb1fSDK aFb1fSDK) {
        String str = this.AFKeystoreWrapper;
        return str != null ? str : getString("AF_REFERRER") != null ? getString("AF_REFERRER") : aFb1fSDK.AFKeystoreWrapper("referrer", null);
    }

    public synchronized String getString(String str) {
        return (String) this.AFInAppEventParameterName.get(str);
    }

    public boolean isEnableLog() {
        AFLogger.LogLevel logLevel = AFLogger.LogLevel.NONE;
        return getInt("logLevel", logLevel.getLevel()) > logLevel.getLevel();
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    public synchronized void loadProperties(AFb1fSDK aFb1fSDK) {
        try {
            if (valueOf()) {
                return;
            }
            String strAFKeystoreWrapper = aFb1fSDK.AFKeystoreWrapper("savedProperties", null);
            if (strAFKeystoreWrapper != null) {
                AFLogger.afDebugLog("Loading properties..");
                try {
                    JSONObject jSONObject = new JSONObject(strAFKeystoreWrapper);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (this.AFInAppEventParameterName.get(next) == null) {
                            this.AFInAppEventParameterName.put(next, jSONObject.getString(next));
                        }
                    }
                    String[] strArr = {"AppsFlyerKey", "custom_host", "custom_host_prefix"};
                    for (int i3 = 0; i3 < 3; i3++) {
                        this.AFInAppEventParameterName.remove(strArr[i3]);
                    }
                    saveProperties(aFb1fSDK);
                    this.valueOf = true;
                } catch (JSONException e3) {
                    AFLogger.afErrorLog("Failed loading properties", e3);
                }
                StringBuilder sb = new StringBuilder("Done loading properties: ");
                sb.append(this.valueOf);
                AFLogger.afDebugLog(sb.toString());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void remove(String str) {
        this.AFInAppEventParameterName.remove(str);
    }

    public synchronized void saveProperties(AFb1fSDK aFb1fSDK) {
        this.AFInAppEventParameterName.remove("AppsFlyerKey");
        aFb1fSDK.values("savedProperties", new JSONObject(this.AFInAppEventParameterName).toString());
    }

    public synchronized void set(String str, String str2) {
        this.AFInAppEventParameterName.put(str, str2);
    }

    public synchronized void setCustomData(String str) {
        this.AFInAppEventParameterName.put(ADDITIONAL_CUSTOM_DATA, str);
    }

    public synchronized void setUserEmails(String str) {
        this.AFInAppEventParameterName.put(USER_EMAILS, str);
    }

    public synchronized void set(String str, String[] strArr) {
        this.AFInAppEventParameterName.put(str, strArr);
    }

    public synchronized void set(String str, int i3) {
        this.AFInAppEventParameterName.put(str, Integer.toString(i3));
    }

    public synchronized void set(String str, long j3) {
        this.AFInAppEventParameterName.put(str, Long.toString(j3));
    }

    public synchronized void set(String str, boolean z2) {
        this.AFInAppEventParameterName.put(str, Boolean.toString(z2));
    }
}
