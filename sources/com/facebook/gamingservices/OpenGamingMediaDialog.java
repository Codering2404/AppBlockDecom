package com.facebook.gamingservices;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import d.qFm.sECyKyO;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class OpenGamingMediaDialog implements GraphRequest.OnProgressCallback {
    private Context context;
    private GraphRequest.Callback nestedCallback;

    public OpenGamingMediaDialog(Context context) {
        this(context, null);
    }

    @Override // com.facebook.GraphRequest.OnProgressCallback
    public void onProgress(long j3, long j4) {
        GraphRequest.Callback callback = this.nestedCallback;
        if (callback == null || !(callback instanceof GraphRequest.OnProgressCallback)) {
            return;
        }
        ((GraphRequest.OnProgressCallback) callback).onProgress(j3, j4);
    }

    public OpenGamingMediaDialog(Context context, GraphRequest.Callback callback) {
        this.context = context;
        this.nestedCallback = callback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Callback callback = this.nestedCallback;
        if (callback != null) {
            callback.onCompleted(graphResponse);
        }
        if (graphResponse == null || graphResponse.getError() != null) {
            return;
        }
        String strOptString = graphResponse.getJSONObject().optString("id", null);
        String strOptString2 = graphResponse.getJSONObject().optString("video_id", null);
        if (strOptString == null && strOptString2 == null) {
            return;
        }
        if (strOptString == null) {
            strOptString = strOptString2;
        }
        if (CloudGameLoginHandler.isRunningInCloud()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", strOptString);
                jSONObject.put(SDKConstants.PARAM_DEEP_LINK, "MEDIA_ASSET");
                DaemonRequest.executeAsync(this.context, jSONObject, (DaemonRequest.Callback) null, SDKMessageEnum.OPEN_GAMING_SERVICES_DEEP_LINK);
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        this.context.startActivity(new Intent(sECyKyO.oxb, Uri.parse("https://fb.gg/me/media_asset/" + strOptString)));
    }
}
