package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import com.applovin.impl.d4;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f59355a = {7, 4, 2, 1, 11};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f59356b = {5, 6, 12, 10, 3, 9, 8, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f59357c = {15, 13};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f59358d = {20};

    public static String a(String str, com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.f63795u0), str, jVar);
    }

    public static String b(String str, com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.f63792t0), str, jVar);
    }

    public static Map c(com.applovin.impl.sdk.j jVar) {
        HashMap map = new HashMap();
        String str = (String) jVar.a(sj.f63757k);
        if (StringUtils.isValidString(str)) {
            map.put("device_token", str);
        } else if (!((Boolean) jVar.a(sj.a5)).booleanValue()) {
            map.put("api_key", jVar.a0());
        }
        map.putAll(yp.a(jVar.x().e()));
        return map;
    }

    public static String d(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.f63789s0), "4.0/ad", jVar);
    }

    public static String e(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.f63786r0), "4.0/ad", jVar);
    }

    public static Long f(com.applovin.impl.sdk.j jVar) {
        d4.d dVarA = jVar.t().a();
        if (dVarA == null) {
            return null;
        }
        double dC = yp.c(dVarA.b());
        double d3 = yp.d(dVarA.a());
        if (d3 == 0.0d) {
            return null;
        }
        return Long.valueOf((long) (dC / d3));
    }

    public static String g(com.applovin.impl.sdk.j jVar) {
        NetworkInfo networkInfoB = b(com.applovin.impl.sdk.j.m());
        if (networkInfoB != null) {
            int type = networkInfoB.getType();
            int subtype = networkInfoB.getSubtype();
            if (type == 1) {
                return "wifi";
            }
            if (type == 0) {
                return a(subtype, f59355a) ? "2g" : a(subtype, f59356b) ? "3g" : a(subtype, f59357c) ? "4g" : a(subtype, f59358d) ? "5g" : "mobile";
            }
        }
        return "unknown";
    }

    public static String a(String str, String str2, com.applovin.impl.sdk.j jVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (jVar != null) {
            return str + str2;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static String b(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.f63786r0), ((Boolean) jVar.a(sj.j3)).booleanValue() ? "5.0/ad" : "4.0/ad", jVar);
    }

    private static NetworkInfo b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static void b(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        String string = JsonUtils.getString(jSONObject, "persisted_data", null);
        if (StringUtils.isValidString(string)) {
            jVar.b(uj.H, string);
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().d("ConnectionUtils", "Updated persisted data");
            }
        }
    }

    public static String a(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.f63789s0), ((Boolean) jVar.a(sj.j3)).booleanValue() ? "5.0/ad" : "4.0/ad", jVar);
    }

    public static void c(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (jVar != null) {
            try {
                if (jSONObject.has("settings")) {
                    tj tjVarG0 = jVar.g0();
                    if (jSONObject.isNull("settings")) {
                        return;
                    }
                    tjVarG0.a(jSONObject.getJSONObject("settings"));
                    tjVarG0.e();
                    return;
                }
                return;
            } catch (JSONException e3) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("ConnectionUtils", "Unable to parse settings out of API response", e3);
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static void a(int i3, com.applovin.impl.sdk.j jVar) {
        if (i3 == 401) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "SDK key \"" + jVar.a0() + "\" is rejected by AppLovin. Please make sure the SDK key is correct.");
            return;
        }
        if (i3 == 418) {
            jVar.g0().a(sj.f63737f, Boolean.TRUE);
            jVar.g0().e();
        } else if (i3 >= 400 && i3 < 500) {
            if (((Boolean) jVar.a(sj.f63745h)).booleanValue()) {
                jVar.Q0();
            }
        } else if (i3 == -1 && ((Boolean) jVar.a(sj.f63745h)).booleanValue()) {
            jVar.Q0();
        }
    }

    private static boolean a(int i3, int[] iArr) {
        for (int i4 : iArr) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo networkInfoB = b(context);
        if (networkInfoB != null) {
            return networkInfoB.isConnected();
        }
        return false;
    }

    public static byte[] a(InputStream inputStream, com.applovin.impl.sdk.j jVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) jVar.a(sj.c3)).intValue()];
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 > 0) {
                byteArrayOutputStream.write(bArr, 0, i3);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static void a(JSONObject jSONObject, boolean z2, com.applovin.impl.sdk.j jVar) {
        jVar.q().a(jSONObject, z2);
    }

    public static void a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "filesystem_values", (JSONObject) null);
        if (jSONObject2 != null) {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.j.m()).edit();
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object object = JsonUtils.getObject(jSONObject2, next, null);
                if (object != null) {
                    vj.a(next, object, (SharedPreferences) null, editorEdit);
                }
            }
            editorEdit.apply();
        }
    }
}
