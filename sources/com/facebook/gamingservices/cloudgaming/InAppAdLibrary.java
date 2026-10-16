package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class InAppAdLibrary {
    public static void loadInterstitialAd(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PLACEMENT_ID, str), callback, SDKMessageEnum.LOAD_INTERSTITIAL_AD);
        } catch (JSONException e3) {
            SDKLogger.logInternalError(context, SDKMessageEnum.LOAD_INTERSTITIAL_AD, e3);
        }
    }

    public static void loadRewardedVideo(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PLACEMENT_ID, str), callback, SDKMessageEnum.LOAD_REWARDED_VIDEO);
        } catch (JSONException e3) {
            SDKLogger.logInternalError(context, SDKMessageEnum.LOAD_REWARDED_VIDEO, e3);
        }
    }

    public static void showInterstitialAd(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PLACEMENT_ID, str), callback, SDKMessageEnum.SHOW_INTERSTITIAL_AD);
        } catch (JSONException e3) {
            SDKLogger.logInternalError(context, SDKMessageEnum.SHOW_INTERSTITIAL_AD, e3);
        }
    }

    public static void showRewardedVideo(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PLACEMENT_ID, str), callback, SDKMessageEnum.SHOW_REWARDED_VIDEO);
        } catch (JSONException e3) {
            SDKLogger.logInternalError(context, SDKMessageEnum.SHOW_REWARDED_VIDEO, e3);
        }
    }
}
