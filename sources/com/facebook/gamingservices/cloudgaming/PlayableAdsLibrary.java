package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PlayableAdsLibrary {
    public static void markGameLoaded(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.MARK_GAME_LOADED);
    }

    public static void openAppStore(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.OPEN_APP_STORE);
    }
}
