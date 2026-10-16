package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.revenuecat.purchases.common.Constants;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class kq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f61053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f61054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f61055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f61056d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f61057f = -1;

    private kq() {
    }

    public static kq a(es esVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        List<String> listExplode;
        int size;
        long seconds;
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strD = esVar.d();
            if (!StringUtils.isValidString(strD)) {
                jVar.I();
                if (!com.applovin.impl.sdk.n.a()) {
                    return null;
                }
                jVar.I().b("VastTracker", "Unable to create tracker. Could not find URL.");
                return null;
            }
            kq kqVar = new kq();
            kqVar.f61055c = strD;
            kqVar.f61053a = (String) esVar.a().get("id");
            kqVar.f61054b = (String) esVar.a().get("event");
            kqVar.f61057f = a(kqVar.b(), eqVar);
            String str = (String) esVar.a().get("offset");
            if (StringUtils.isValidString(str)) {
                String strTrim = str.trim();
                if (strTrim.contains("%")) {
                    kqVar.f61057f = StringUtils.parseInt(strTrim.substring(0, strTrim.length() - 1));
                    return kqVar;
                }
                if (strTrim.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR) && (size = (listExplode = CollectionUtils.explode(strTrim, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)).size()) > 0) {
                    int i3 = size - 1;
                    long j3 = 0;
                    for (int i4 = i3; i4 >= 0; i4--) {
                        String str2 = listExplode.get(i4);
                        if (StringUtils.isNumeric(str2)) {
                            int i5 = Integer.parseInt(str2);
                            if (i4 == i3) {
                                seconds = i5;
                            } else if (i4 == size - 2) {
                                seconds = TimeUnit.MINUTES.toSeconds(i5);
                            } else if (i4 == size - 3) {
                                seconds = TimeUnit.HOURS.toSeconds(i5);
                            }
                            j3 += seconds;
                        }
                    }
                    kqVar.f61056d = j3;
                    kqVar.f61057f = -1;
                }
            }
            return kqVar;
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastTracker", "Error occurred while initializing", th);
            }
            jVar.D().a("VastTracker", th);
            return null;
        }
    }

    public String b() {
        return this.f61054b;
    }

    public String c() {
        return this.f61055c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kq)) {
            return false;
        }
        kq kqVar = (kq) obj;
        if (this.f61056d != kqVar.f61056d || this.f61057f != kqVar.f61057f) {
            return false;
        }
        String str = this.f61053a;
        if (str == null ? kqVar.f61053a != null : !str.equals(kqVar.f61053a)) {
            return false;
        }
        String str2 = this.f61054b;
        if (str2 == null ? kqVar.f61054b == null : str2.equals(kqVar.f61054b)) {
            return this.f61055c.equals(kqVar.f61055c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f61053a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f61054b;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f61055c.hashCode()) * 31;
        long j3 = this.f61056d;
        return ((iHashCode2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.f61057f;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f61053a + "', event='" + this.f61054b + "', uriString='" + this.f61055c + "', offsetSeconds=" + this.f61056d + ", offsetPercent=" + this.f61057f + '}';
    }

    public static kq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        kq kqVar = new kq();
        String string = JsonUtils.getString(jSONObject, "uri_string", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        kqVar.f61055c = string;
        kqVar.f61053a = JsonUtils.getString(jSONObject, "identifier", "");
        kqVar.f61054b = JsonUtils.getString(jSONObject, "event", "");
        kqVar.f61056d = JsonUtils.getLong(jSONObject, "offset_seconds", -1L);
        kqVar.f61057f = JsonUtils.getInt(jSONObject, "offset_percent", -1);
        return kqVar;
    }

    public boolean a(long j3, int i3) {
        long j4 = this.f61056d;
        boolean z2 = j4 >= 0;
        boolean z3 = j3 >= j4;
        int i4 = this.f61057f;
        return (z2 && z3) || ((i4 >= 0) && (i3 >= i4));
    }

    private static int a(String str, eq eqVar) {
        if ("start".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        if (eqVar != null) {
            return eqVar.g();
        }
        return 95;
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "identifier", this.f61053a);
        JsonUtils.putString(jSONObject, "event", this.f61054b);
        JsonUtils.putString(jSONObject, "uri_string", this.f61055c);
        JsonUtils.putLong(jSONObject, "offset_seconds", this.f61056d);
        JsonUtils.putInt(jSONObject, "offset_percent", this.f61057f);
        return jSONObject;
    }
}
