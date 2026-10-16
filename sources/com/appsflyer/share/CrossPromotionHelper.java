package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFa1bSDK;
import com.appsflyer.internal.AFc1ySDK;
import com.appsflyer.internal.AFd1mSDK;
import com.appsflyer.internal.AFd1xSDK;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;
import com.appsflyer.internal.AFg1ySDK;
import com.appsflyer.internal.AFg1zSDK;
import com.facebook.ads.AdSDKNotificationListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CrossPromotionHelper {
    private static String valueOf = "https://%simpression.%s";

    public static void logAndOpenStore(Context context, String str, String str2) {
        logAndOpenStore(context, str, str2, null);
    }

    public static void logCrossPromoteImpression(Context context, String str, String str2) {
        logCrossPromoteImpression(context, str, str2, null);
    }

    public static void setUrl(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            key.getClass();
            if (key.equals("app")) {
                AFg1zSDK.AFInAppEventType = value;
            } else if (key.equals(AdSDKNotificationListener.IMPRESSION_EVENT)) {
                valueOf = value;
            }
        }
    }

    private static void valueOf(String str, Context context, AFg1ySDK aFg1ySDK) {
        AFa1bSDK aFa1bSDKValues = AFa1bSDK.values();
        aFa1bSDKValues.AFInAppEventType(context);
        AFc1ySDK aFc1ySDKValueOf = aFa1bSDKValues.valueOf();
        AFd1mSDK aFd1mSDK = new AFd1mSDK(aFc1ySDKValueOf, str, aFg1ySDK);
        AFd1xSDK aFd1xSDKAFLogger$LogLevel = aFc1ySDKValueOf.AFLogger$LogLevel();
        aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(aFd1mSDK));
    }

    private static LinkGenerator values(Context context, String str, String str2, Map<String, String> map, String str3) {
        LinkGenerator linkGenerator = new LinkGenerator("af_cross_promotion");
        linkGenerator.AFInAppEventType = str3;
        linkGenerator.AFInAppEventParameterName = str;
        linkGenerator.addParameter("af_siteid", context.getPackageName());
        if (str2 != null) {
            linkGenerator.setCampaign(str2);
        }
        if (map != null) {
            linkGenerator.addParameters(map);
        }
        String string = AppsFlyerProperties.getInstance().getString("advertiserId");
        if (string != null) {
            linkGenerator.addParameter("advertising_id", string);
        }
        return linkGenerator;
    }

    public static void logAndOpenStore(Context context, String str, String str2, Map<String, String> map) {
        LinkGenerator linkGeneratorValues = values(context, str, str2, map, String.format(AFg1zSDK.AFInAppEventType, AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName()));
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, track And Open Store is disabled", true);
            return;
        }
        if (AppsFlyerLib.getInstance().isStopped()) {
            AFLogger.afInfoLog("SDK is stopped, track And Open Store is disabled", true);
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("af_campaign", str2);
        AppsFlyerLib.getInstance().logEvent(context, "af_cross_promotion", map);
        valueOf(linkGeneratorValues.generateLink(), context, new AFg1ySDK(context));
    }

    public static void logCrossPromoteImpression(Context context, String str, String str2, Map<String, String> map) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, Promote Impression is disabled", true);
        } else if (AppsFlyerLib.getInstance().isStopped()) {
            AFLogger.afInfoLog("SDK is stopped, Promote Impression is disabled", true);
        } else {
            valueOf(values(context, str, str2, map, String.format(valueOf, AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName())).generateLink(), context, null);
        }
    }
}
