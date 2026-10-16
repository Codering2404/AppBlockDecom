package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f87915a = new Logger("JSONParser", new String[0]);

    public static List a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Object objC = jSONArray.get(i3);
            if (objC instanceof JSONArray) {
                objC = a((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            arrayList.add(objC);
        }
        return arrayList;
    }

    public static Map b(String str) {
        Preconditions.g(str);
        List<String> listZza = com.google.android.gms.internal.p002firebaseauthapi.zzt.zza('.').zza((CharSequence) str);
        if (listZza.size() < 2) {
            f87915a.c("Invalid idToken " + str, new Object[0]);
            return new HashMap();
        }
        try {
            Map mapD = d(new String(Base64Utils.b(listZza.get(1)), Utf8Charset.NAME));
            return mapD == null ? new HashMap() : mapD;
        } catch (UnsupportedEncodingException e3) {
            f87915a.b("Unable to decode token", e3, new Object[0]);
            return new HashMap();
        }
    }

    public static Map c(JSONObject jSONObject) throws JSONException {
        ArrayMap arrayMap = new ArrayMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objC = jSONObject.get(next);
            if (objC instanceof JSONArray) {
                objC = a((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            arrayMap.put(next, objC);
        }
        return arrayMap;
    }

    public static Map d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return c(jSONObject);
            }
            return null;
        } catch (Exception e3) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzaao(e3);
        }
    }
}
