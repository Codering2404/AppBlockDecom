package com.facebook.gamingservices.cloudgaming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DaemonReceiver {
    private static SDKLogger mLogger;
    private static ConcurrentHashMap<String, CompletableFuture<GraphResponse>> requestStore;
    private static DaemonReceiver single_instance;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DaemonBroadcastReceiver extends BroadcastReceiver {
        private DaemonBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CompletableFuture completableFuture;
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra(SDKConstants.RECEIVER_PAYLOAD));
                String string = jSONObject.getString(SDKConstants.REQUEST_ID);
                if (!DaemonReceiver.requestStore.containsKey(string) || (completableFuture = (CompletableFuture) DaemonReceiver.requestStore.remove(string)) == null) {
                    return;
                }
                completableFuture.complete(DaemonReceiver.processResponse(jSONObject, string));
            } catch (JSONException unused) {
            }
        }
    }

    private DaemonReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter(SDKConstants.RECEIVER_INTENT);
        HandlerThread handlerThread = new HandlerThread(SDKConstants.RECEIVER_HANDLER);
        handlerThread.start();
        context.registerReceiver(new DaemonBroadcastReceiver(), intentFilter, null, new Handler(handlerThread.getLooper()));
        requestStore = new ConcurrentHashMap<>();
        mLogger = SDKLogger.getInstance(context);
    }

    private static GraphResponse createDefaultErrorResponse(String str) {
        return createErrorResponse(new FacebookRequestError(20, "UNSUPPORTED_FORMAT", "The response format is invalid."), str);
    }

    static GraphResponse createErrorResponse(FacebookRequestError facebookRequestError, String str) {
        mLogger.logSendingErrorResponse(facebookRequestError, str);
        return new GraphResponse(new GraphRequest(), null, facebookRequestError);
    }

    private static GraphResponse createSuccessResponse(JSONObject jSONObject, String str) {
        if (jSONObject.optJSONObject(GraphResponse.SUCCESS_KEY) != null) {
            mLogger.logSendingSuccessResponse(str);
            return new GraphResponse(new GraphRequest(), (HttpURLConnection) null, "", jSONObject.optJSONObject(GraphResponse.SUCCESS_KEY));
        }
        if (jSONObject.optJSONArray(GraphResponse.SUCCESS_KEY) == null) {
            return createDefaultErrorResponse(str);
        }
        mLogger.logSendingSuccessResponse(str);
        return new GraphResponse(new GraphRequest(), (HttpURLConnection) null, "", jSONObject.optJSONArray(GraphResponse.SUCCESS_KEY));
    }

    static synchronized DaemonReceiver getInstance(Context context) {
        try {
            if (single_instance == null) {
                single_instance = new DaemonReceiver(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return single_instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GraphResponse processResponse(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(GraphResponse.SUCCESS_KEY) ? createSuccessResponse(jSONObject, str) : !jSONObject.isNull("error") ? createErrorResponse(jSONObject, str) : createDefaultErrorResponse(str);
    }

    synchronized ConcurrentHashMap<String, CompletableFuture<GraphResponse>> getRequestStore() {
        return requestStore;
    }

    private static GraphResponse createErrorResponse(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("error");
        if (jSONObjectOptJSONObject != null) {
            return createErrorResponse(new FacebookRequestError(jSONObjectOptJSONObject.optInt("code"), jSONObjectOptJSONObject.optString("type"), jSONObjectOptJSONObject.optString("message")), str);
        }
        return createDefaultErrorResponse(str);
    }
}
