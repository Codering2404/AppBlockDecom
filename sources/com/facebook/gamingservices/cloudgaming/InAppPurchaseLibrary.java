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
public class InAppPurchaseLibrary {
    public static void cancelSubscription(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("purchaseToken", str), callback, SDKMessageEnum.CANCEL_SUBSCRIPTION);
        } catch (JSONException e3) {
            SDKLogger.logInternalError(context, SDKMessageEnum.CANCEL_SUBSCRIPTION, e3);
        }
    }

    public static void consumePurchase(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("purchaseToken", str), callback, SDKMessageEnum.CONSUME_PURCHASE);
        } catch (JSONException e3) {
            SDKLogger.logInternalError(context, SDKMessageEnum.CONSUME_PURCHASE, e3);
        }
    }

    public static void getCatalog(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_CATALOG);
    }

    public static void getPurchases(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_PURCHASES);
    }

    public static void getSubscribableCatalog(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_SUBSCRIBABLE_CATALOG);
    }

    public static void getSubscriptions(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_SUBSCRIPTIONS);
    }

    public static void onReady(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.ON_READY);
    }

    public static void purchase(Context context, String str, String str2, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PRODUCT_ID, str).put(SDKConstants.PARAM_DEVELOPER_PAYLOAD, str2), callback, SDKMessageEnum.PURCHASE);
        } catch (JSONException e3) {
            SDKLogger.logInternalError(context, SDKMessageEnum.PURCHASE, e3);
        }
    }

    public static void purchaseSubscription(Context context, String str, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PRODUCT_ID, str), callback, SDKMessageEnum.PURCHASE_SUBSCRIPTION);
        } catch (JSONException e3) {
            SDKLogger.logInternalError(context, SDKMessageEnum.PURCHASE_SUBSCRIPTION, e3);
        }
    }
}
