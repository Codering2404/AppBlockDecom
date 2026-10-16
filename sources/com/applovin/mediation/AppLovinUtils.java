package com.applovin.mediation;

import android.content.Context;
import android.os.Bundle;
import com.applovin.mediation.AppLovinExtras;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinErrorCodes;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MediationUtils;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinUtils {
    private static final String DEFAULT_ZONE = "";
    public static final String ERROR_MSG_CHILD_USER = "MobileAds.getRequestConfiguration() indicates the user is a child. AppLovin SDK 13.0.0 or higher does not support child users.";
    public static final String ERROR_MSG_REASON_PREFIX = "AppLovin SDK returned a load failure callback with reason: ";
    private static final String TRUE = "true";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ServerParameterKeys {
        public static final String MULTIPLE_ADS_PER_AD_UNIT = "enable_multiple_ads_per_unit";
        public static final String SDK_KEY = "sdkKey";
        public static final String ZONE_ID = "zone_id";

        private ServerParameterKeys() {
        }
    }

    public static AppLovinAdSize appLovinAdSizeFromAdMobAdSize(Context context, AdSize adSize) {
        ArrayList arrayList = new ArrayList();
        AdSize adSize2 = AdSize.f69645j;
        arrayList.add(adSize2);
        AdSize adSize3 = AdSize.f69648m;
        arrayList.add(adSize3);
        AdSize adSize4 = AdSize.f69649n;
        arrayList.add(adSize4);
        AdSize adSizeA = MediationUtils.a(context, adSize, arrayList);
        if (adSize2.equals(adSizeA)) {
            return AppLovinAdSize.BANNER;
        }
        if (adSize4.equals(adSizeA)) {
            return AppLovinAdSize.MREC;
        }
        if (adSize3.equals(adSizeA)) {
            return AppLovinAdSize.LEADER;
        }
        return null;
    }

    public static AdError getAdError(int i3) {
        String str = "AppLovin error code " + i3;
        if (i3 == -8) {
            str = "INVALID_AD_TOKEN";
        } else if (i3 == -7) {
            str = "INVALID_ZONE";
        } else if (i3 != -6) {
            switch (i3) {
                case -1009:
                    str = "NO_NETWORK";
                    break;
                case -1001:
                    str = "FETCH_AD_TIMEOUT";
                    break;
                case AppLovinErrorCodes.INVALID_URL /* -900 */:
                    str = "INVALID_URL";
                    break;
                case AppLovinErrorCodes.INVALID_RESPONSE /* -800 */:
                    str = "INVALID_RESPONSE";
                    break;
                case AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO /* -600 */:
                    str = "INCENTIVIZED_USER_CLOSED_VIDEO";
                    break;
                case AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT /* -500 */:
                    str = "INCENTIVIZED_SERVER_TIMEOUT";
                    break;
                case AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR /* -400 */:
                    str = "INCENTIVIZED_UNKNOWN_SERVER_ERROR";
                    break;
                case AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED /* -300 */:
                    str = "INCENTIVIZED_NO_AD_PRELOADED";
                    break;
                case AppLovinErrorCodes.SDK_DISABLED /* -22 */:
                    str = "SDK_DISABLED";
                    break;
                case -1:
                    str = "UNSPECIFIED_ERROR";
                    break;
                case 204:
                    str = "NO_FILL";
                    break;
                default:
                    switch (i3) {
                        case AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES /* -202 */:
                            str = "UNABLE_TO_PRECACHE_VIDEO_RESOURCES";
                            break;
                        case AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES /* -201 */:
                            str = "UNABLE_TO_PRECACHE_IMAGE_RESOURCES";
                            break;
                        case AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES /* -200 */:
                            str = "UNABLE_TO_PRECACHE_RESOURCES";
                            break;
                    }
                    break;
            }
        } else {
            str = "UNABLE_TO_RENDER_AD";
        }
        return new AdError(i3, ERROR_MSG_REASON_PREFIX + str, AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN);
    }

    public static AdError getChildUserError() {
        return new AdError(112, ERROR_MSG_CHILD_USER, AppLovinMediationAdapter.ERROR_DOMAIN);
    }

    public static boolean isChildUser() {
        RequestConfiguration requestConfigurationA = MobileAds.a();
        return requestConfigurationA.c() == 1 || requestConfigurationA.d() == 1;
    }

    public static boolean isMultiAdsEnabled(Bundle bundle) {
        if (bundle.containsKey(ServerParameterKeys.MULTIPLE_ADS_PER_AD_UNIT)) {
            return bundle.getString(ServerParameterKeys.MULTIPLE_ADS_PER_AD_UNIT).equals("true");
        }
        return false;
    }

    public static String retrieveZoneId(Bundle bundle) {
        return bundle.containsKey(ServerParameterKeys.ZONE_ID) ? bundle.getString(ServerParameterKeys.ZONE_ID) : "";
    }

    public static boolean shouldMuteAudio(Bundle bundle) {
        return bundle != null && bundle.getBoolean(AppLovinExtras.Keys.MUTE_AUDIO);
    }
}
