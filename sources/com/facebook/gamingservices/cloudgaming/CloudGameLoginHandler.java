package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.gamingservices.GamingPayload;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CloudGameLoginHandler {
    private static final int DEFAULT_TIMEOUT_IN_SEC = 5;
    private static boolean IS_RUNNING_IN_CLOUD = false;
    private static SDKLogger mLogger;

    private static List<String> convertPermissionsStringIntoPermissionsList(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!str.isEmpty()) {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.get(i3).toString());
            }
        }
        return arrayList;
    }

    public static void gameLoadComplete(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.MARK_GAME_LOADED);
    }

    public static synchronized AccessToken init(Context context) throws FacebookException {
        return init(context, 5);
    }

    private static boolean isCloudEnvReady(Context context, int i3) {
        GraphResponse graphResponseExecuteAndWait = DaemonRequest.executeAndWait(context, null, SDKMessageEnum.IS_ENV_READY, i3);
        return (graphResponseExecuteAndWait == null || graphResponseExecuteAndWait.getJSONObject() == null || graphResponseExecuteAndWait.getError() != null) ? false : true;
    }

    public static boolean isRunningInCloud() {
        return IS_RUNNING_IN_CLOUD;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.util.Date] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.util.Date] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v9 */
    private static AccessToken setCurrentAccessToken(JSONObject jSONObject) throws JSONException {
        String str;
        long j3;
        Date date;
        String str2;
        List<String> list;
        String str3;
        Date date2;
        ?? r11;
        ?? r12;
        List<String> list2;
        AccessTokenSource accessTokenSource;
        String strOptString = jSONObject.optString(SDKConstants.PARAM_ACCESS_TOKEN);
        String strOptString2 = jSONObject.optString(SDKConstants.PARAM_ACCESS_TOKEN_SOURCE);
        String strOptString3 = jSONObject.optString(SDKConstants.PARAM_APP_ID);
        String strOptString4 = jSONObject.optString(SDKConstants.PARAM_DECLINED_PERMISSIONS);
        String strOptString5 = jSONObject.optString(SDKConstants.PARAM_EXPIRED_PERMISSIONS);
        String strOptString6 = jSONObject.optString(SDKConstants.PARAM_EXPIRATION_TIME);
        String strOptString7 = jSONObject.optString(SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME);
        String strOptString8 = jSONObject.optString(SDKConstants.PARAM_GRAPH_DOMAIN);
        String strOptString9 = jSONObject.optString(SDKConstants.PARAM_LAST_REFRESH_TIME);
        String strOptString10 = jSONObject.optString("permissions");
        String strOptString11 = jSONObject.optString(SDKConstants.PARAM_USER_ID);
        String strOptString12 = jSONObject.optString(SDKConstants.PARAM_SESSION_ID);
        if (strOptString.isEmpty() || strOptString3.isEmpty() || strOptString11.isEmpty()) {
            return null;
        }
        SDKLogger sDKLogger = mLogger;
        if (sDKLogger != null) {
            sDKLogger.setAppID(strOptString3);
            mLogger.setUserID(strOptString11);
            mLogger.setSessionID(strOptString12);
        }
        List<String> listConvertPermissionsStringIntoPermissionsList = convertPermissionsStringIntoPermissionsList(strOptString10);
        List<String> listConvertPermissionsStringIntoPermissionsList2 = convertPermissionsStringIntoPermissionsList(strOptString4);
        List<String> listConvertPermissionsStringIntoPermissionsList3 = convertPermissionsStringIntoPermissionsList(strOptString5);
        AccessTokenSource accessTokenSourceValueOf = !strOptString2.isEmpty() ? AccessTokenSource.valueOf(strOptString2) : null;
        if (strOptString6.isEmpty()) {
            str = null;
            j3 = 1000;
            date = null;
        } else {
            str = null;
            j3 = 1000;
            date = new Date(((long) Integer.parseInt(strOptString6)) * 1000);
        }
        Object date3 = !strOptString9.isEmpty() ? new Date(((long) Integer.parseInt(strOptString9)) * j3) : str;
        Object date4 = !strOptString7.isEmpty() ? new Date(((long) Integer.parseInt(strOptString7)) * j3) : str;
        if (strOptString8.isEmpty()) {
            str2 = str;
            list = listConvertPermissionsStringIntoPermissionsList3;
            str3 = strOptString11;
            date2 = date;
            r11 = date3;
            r12 = date4;
            list2 = listConvertPermissionsStringIntoPermissionsList;
            accessTokenSource = accessTokenSourceValueOf;
        } else {
            str2 = strOptString8;
            date2 = date;
            list = listConvertPermissionsStringIntoPermissionsList3;
            r12 = date4;
            str3 = strOptString11;
            accessTokenSource = accessTokenSourceValueOf;
            r11 = date3;
            list2 = listConvertPermissionsStringIntoPermissionsList;
        }
        AccessToken accessToken = new AccessToken(strOptString, strOptString3, str3, list2, listConvertPermissionsStringIntoPermissionsList2, list, accessTokenSource, date2, r11, r12, str2);
        AccessToken.setCurrentAccessToken(accessToken);
        return accessToken;
    }

    private static void setPackageName(JSONObject jSONObject, Context context) {
        String strOptString = jSONObject.optString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME);
        if (strOptString.isEmpty()) {
            throw new FacebookException("Could not establish a secure connection.");
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).edit();
        editorEdit.putString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, strOptString);
        editorEdit.commit();
    }

    public static synchronized AccessToken init(Context context, int i3) throws FacebookException {
        AccessToken currentAccessToken;
        if (i3 <= 0) {
            i3 = 5;
        }
        if (!isCloudEnvReady(context, i3)) {
            throw new FacebookException("Not running in Cloud environment.");
        }
        mLogger = SDKLogger.getInstance(context);
        GraphResponse graphResponseExecuteAndWait = DaemonRequest.executeAndWait(context, null, SDKMessageEnum.GET_ACCESS_TOKEN, i3);
        if (graphResponseExecuteAndWait == null || graphResponseExecuteAndWait.getJSONObject() == null) {
            throw new FacebookException("Cannot receive response.");
        }
        if (graphResponseExecuteAndWait.getError() != null) {
            throw new FacebookException(graphResponseExecuteAndWait.getError().getErrorMessage());
        }
        setPackageName(graphResponseExecuteAndWait.getJSONObject(), context);
        try {
            currentAccessToken = setCurrentAccessToken(graphResponseExecuteAndWait.getJSONObject());
            GamingPayload.loadPayloadFromCloudGame(graphResponseExecuteAndWait.getJSONObject().optString("payload"));
            Profile.fetchProfileForCurrentAccessToken();
            IS_RUNNING_IN_CLOUD = true;
            mLogger.logLoginSuccess();
        } catch (JSONException e3) {
            throw new FacebookException("Cannot properly handle response.", e3);
        }
        return currentAccessToken;
    }
}
