package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.internal.AFa1bSDK;
import com.appsflyer.internal.AFb1zSDK;
import com.appsflyer.internal.AFc1ySDK;
import com.appsflyer.internal.AFd1qSDK;
import com.appsflyer.internal.AFd1xSDK;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;
import com.appsflyer.internal.AFg1zSDK;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LinkGenerator {
    String AFInAppEventParameterName;
    String AFInAppEventType;
    private String AFKeystoreWrapper;
    private String AFLogger;
    private String AFLogger$LogLevel;
    private final Map<String, String> AFVersionDeclaration = new HashMap();
    private String afDebugLog;
    private String afErrorLog;
    private String afErrorLogForExcManagerOnly;
    private String afInfoLog;
    private String afRDLog;
    private String valueOf;
    private final String values;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public LinkGenerator(String str) {
        this.values = str;
    }

    private Map<String, String> AFInAppEventType() {
        HashMap map = new HashMap();
        map.put("pid", this.values);
        String str = this.afDebugLog;
        if (str != null) {
            map.put("af_referrer_uid", str);
        }
        String str2 = this.valueOf;
        if (str2 != null) {
            map.put(AFInAppEventParameterName.AF_CHANNEL, str2);
        }
        String str3 = this.afInfoLog;
        if (str3 != null) {
            map.put("af_referrer_customer_id", str3);
        }
        String str4 = this.AFKeystoreWrapper;
        if (str4 != null) {
            map.put("c", str4);
        }
        String str5 = this.afRDLog;
        if (str5 != null) {
            map.put("af_referrer_name", str5);
        }
        String str6 = this.AFLogger;
        if (str6 != null) {
            map.put("af_referrer_image_url", str6);
        }
        if (this.AFLogger$LogLevel != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.AFLogger$LogLevel);
            String str7 = this.afErrorLog;
            if (str7 != null) {
                this.afErrorLog = str7.replaceFirst("^[/]", "");
                sb.append(this.AFLogger$LogLevel.endsWith("/") ? "" : "/");
                sb.append(this.afErrorLog);
            }
            map.put("af_dp", sb.toString());
        }
        for (Map.Entry<String, String> entry : this.AFVersionDeclaration.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return AFb1zSDK.AFInAppEventType(map);
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.AFVersionDeclaration.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.AFVersionDeclaration.putAll(map);
        }
        return this;
    }

    public String generateLink() {
        StringBuilder sb = new StringBuilder();
        String str = this.AFInAppEventType;
        if (str == null || !str.startsWith("http")) {
            sb.append(String.format(AFg1zSDK.AFInAppEventType, AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName()));
        } else {
            sb.append(this.AFInAppEventType);
        }
        if (this.AFInAppEventParameterName != null) {
            sb.append('/');
            sb.append(this.AFInAppEventParameterName);
        }
        Map<String, String> mapAFInAppEventType = AFInAppEventType();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : mapAFInAppEventType.entrySet()) {
            if (sb2.length() == 0) {
                sb2.append('?');
            } else {
                sb2.append('&');
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    public String getBrandDomain() {
        return this.afErrorLogForExcManagerOnly;
    }

    public String getCampaign() {
        return this.AFKeystoreWrapper;
    }

    public String getChannel() {
        return this.valueOf;
    }

    public String getMediaSource() {
        return this.values;
    }

    public Map<String, String> getUserParams() {
        return new HashMap(this.AFVersionDeclaration);
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.AFLogger$LogLevel = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.AFInAppEventType = String.format("https://%s/%s", String.format("%sapp.%s", AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName()), str3);
            return this;
        }
        if (str2 == null || str2.length() < 5) {
            str2 = "go.onelink.me";
        }
        this.AFInAppEventType = String.format("https://%s/%s", str2, str);
        return this;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.afErrorLogForExcManagerOnly = str;
        return this;
    }

    public LinkGenerator setCampaign(String str) {
        this.AFKeystoreWrapper = str;
        return this;
    }

    public LinkGenerator setChannel(String str) {
        this.valueOf = str;
        return this;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.afErrorLog = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.afInfoLog = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.AFLogger = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.afRDLog = str;
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.afDebugLog = str;
        return this;
    }

    public void generateLink(Context context, ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        String str = this.afErrorLogForExcManagerOnly;
        Map<String, String> mapAFInAppEventType = AFInAppEventType();
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        AFa1bSDK.values().AFInAppEventType(context);
        AFc1ySDK aFc1ySDKValueOf = AFa1bSDK.values().valueOf();
        AFd1qSDK aFd1qSDK = new AFd1qSDK(aFc1ySDKValueOf, UUID.randomUUID(), string, mapAFInAppEventType, str, responseListener);
        AFd1xSDK aFd1xSDKAFLogger$LogLevel = aFc1ySDKValueOf.AFLogger$LogLevel();
        aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(aFd1qSDK));
    }

    @Deprecated
    public void generateLink(Context context, final CreateOneLinkHttpTask.ResponseListener responseListener) {
        generateLink(context, new ResponseListener() { // from class: com.appsflyer.share.LinkGenerator.2
            @Override // com.appsflyer.share.LinkGenerator.ResponseListener
            public final void onResponse(String str) {
                responseListener.onResponse(str);
            }

            @Override // com.appsflyer.share.LinkGenerator.ResponseListener
            public final void onResponseError(String str) {
                responseListener.onResponseError(str);
            }
        });
    }
}
