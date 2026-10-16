package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class dq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f59290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f59291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f59292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private iq f59293d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f59294f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f59295g = new HashMap();

    private dq() {
    }

    public static dq a(es esVar, dq dqVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        es esVarC;
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (dqVar == null) {
            try {
                dqVar = new dq();
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastCompanionAd", "Error occurred while initializing", th);
                }
                jVar.D().a("VastCompanionAd", th);
                return null;
            }
        }
        if (dqVar.f59290a == 0 && dqVar.f59291b == 0) {
            int i3 = StringUtils.parseInt((String) esVar.a().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
            int i4 = StringUtils.parseInt((String) esVar.a().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
            if (i3 > 0 && i4 > 0) {
                dqVar.f59290a = i3;
                dqVar.f59291b = i4;
            }
        }
        dqVar.f59293d = iq.a(esVar, dqVar.f59293d, jVar);
        if (dqVar.f59292c == null && (esVarC = esVar.c("CompanionClickThrough")) != null) {
            String strD = esVarC.d();
            if (StringUtils.isValidString(strD)) {
                dqVar.f59292c = Uri.parse(strD);
            }
        }
        mq.a(esVar.a("CompanionClickTracking"), dqVar.f59294f, eqVar, jVar);
        mq.a(esVar, dqVar.f59295g, eqVar, jVar);
        return dqVar;
    }

    public Set b() {
        return this.f59294f;
    }

    public Uri c() {
        return this.f59292c;
    }

    public Map d() {
        return this.f59295g;
    }

    public iq e() {
        return this.f59293d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dq)) {
            return false;
        }
        dq dqVar = (dq) obj;
        if (this.f59290a != dqVar.f59290a || this.f59291b != dqVar.f59291b) {
            return false;
        }
        Uri uri = this.f59292c;
        if (uri == null ? dqVar.f59292c != null : !uri.equals(dqVar.f59292c)) {
            return false;
        }
        iq iqVar = this.f59293d;
        if (iqVar == null ? dqVar.f59293d != null : !iqVar.equals(dqVar.f59293d)) {
            return false;
        }
        Set set = this.f59294f;
        if (set == null ? dqVar.f59294f != null : !set.equals(dqVar.f59294f)) {
            return false;
        }
        Map map = this.f59295g;
        Map map2 = dqVar.f59295g;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        int i3 = ((this.f59290a * 31) + this.f59291b) * 31;
        Uri uri = this.f59292c;
        int iHashCode = (i3 + (uri != null ? uri.hashCode() : 0)) * 31;
        iq iqVar = this.f59293d;
        int iHashCode2 = (iHashCode + (iqVar != null ? iqVar.hashCode() : 0)) * 31;
        Set set = this.f59294f;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.f59295g;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f59290a + ", height=" + this.f59291b + ", destinationUri=" + this.f59292c + ", nonVideoResource=" + this.f59293d + ", clickTrackers=" + this.f59294f + ", eventTrackers=" + this.f59295g + '}';
    }

    public static dq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        int i3 = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0);
        int i4 = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0);
        String string = JsonUtils.getString(jSONObject, "destination_uri", null);
        Uri uri = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        iq iqVarA = iq.a(JsonUtils.getJSONObject(jSONObject, "non_video_resource", (JSONObject) null), jVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            kq kqVarA = kq.a(JsonUtils.getJSONObject(jSONArray, i5, (JSONObject) null), jVar);
            if (kqVarA != null) {
                hashSet.add(kqVarA);
            }
        }
        dq dqVar = new dq();
        dqVar.f59290a = i3;
        dqVar.f59291b = i4;
        dqVar.f59292c = uri;
        dqVar.f59293d = iqVarA;
        dqVar.f59294f.addAll(hashSet);
        return dqVar;
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f59290a);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f59291b);
        Uri uri = this.f59292c;
        JsonUtils.putString(jSONObject, "destination_uri", uri == null ? null : uri.toString());
        iq iqVar = this.f59293d;
        JsonUtils.putJSONObject(jSONObject, "non_video_resource", iqVar != null ? iqVar.a() : null);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f59294f.iterator();
        while (it.hasNext()) {
            jSONArray.put(((kq) it.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray);
        return jSONObject;
    }
}
