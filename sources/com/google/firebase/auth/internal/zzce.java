package com.google.firebase.auth.internal;

import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.revenuecat.purchases.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f87972a;

    static {
        HashMap map = new HashMap();
        f87972a = map;
        map.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        map.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        map.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        map.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        map.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static Status a(Intent intent) {
        Preconditions.m(intent);
        Preconditions.a(d(intent));
        return (Status) SafeParcelableSerializer.b(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }

    public static Status b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("code");
            String string2 = jSONObject.getString("message");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Map map = f87972a;
                if (map.containsKey(string)) {
                    return zzao.a(((String) map.get(string)) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + string2);
                }
            }
            return zzao.a("WEB_INTERNAL_ERROR:" + str);
        } catch (JSONException e3) {
            return zzao.a("WEB_INTERNAL_ERROR:" + str + "[ " + e3.getLocalizedMessage() + " ]");
        }
    }

    public static void c(Intent intent, Status status) {
        SafeParcelableSerializer.e(status, intent, "com.google.firebase.auth.internal.STATUS");
    }

    public static boolean d(Intent intent) {
        Preconditions.m(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }
}
