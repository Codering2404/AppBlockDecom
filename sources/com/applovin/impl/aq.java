package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class aq extends com.applovin.impl.sdk.ad.b implements hh {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f58472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f58473m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final jq f58474n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f58475o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final nq f58476p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final dq f58477q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f58478r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final cq f58479s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final rg f58480t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Set f58481u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Set f58482v;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f58483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f58484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.applovin.impl.sdk.j f58485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f58486d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f58487e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f58488f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private jq f58489g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private nq f58490h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private dq f58491i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private cq f58492j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Set f58493k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Set f58494l;

        public b b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f58484b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }

        public b b(Set set) {
            this.f58493k = set;
            return this;
        }

        public b b(String str) {
            this.f58487e = str;
            return this;
        }

        public b a(String str) {
            this.f58488f = str;
            return this;
        }

        public b a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f58483a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        public b a(cq cqVar) {
            this.f58492j = cqVar;
            return this;
        }

        public b a(dq dqVar) {
            this.f58491i = dqVar;
            return this;
        }

        public b a(long j3) {
            this.f58486d = j3;
            return this;
        }

        public b a(Set set) {
            this.f58494l = set;
            return this;
        }

        public b a(com.applovin.impl.sdk.j jVar) {
            if (jVar != null) {
                this.f58485c = jVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        public b a(jq jqVar) {
            this.f58489g = jqVar;
            return this;
        }

        public b a(nq nqVar) {
            this.f58490h = nqVar;
            return this;
        }

        public aq a() {
            return new aq(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum c {
        COMPANION_AD,
        VIDEO
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum d {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        INDUSTRY_ICON_IMPRESSION,
        INDUSTRY_ICON_CLICK,
        ERROR
    }

    private aq(b bVar) {
        super(bVar.f58483a, bVar.f58484b, bVar.f58485c);
        this.f58472l = bVar.f58487e;
        this.f58474n = bVar.f58489g;
        this.f58473m = bVar.f58488f;
        this.f58476p = bVar.f58490h;
        this.f58477q = bVar.f58491i;
        this.f58479s = bVar.f58492j;
        this.f58481u = bVar.f58493k;
        this.f58482v = bVar.f58494l;
        this.f58480t = new rg(this);
        Uri uriU0 = u0();
        if (uriU0 != null) {
            this.f58478r = uriU0.toString();
        } else {
            this.f58478r = "";
        }
        this.f58475o = bVar.f58486d;
    }

    public static aq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "full_response", (JSONObject) null);
        if (jSONObject2 == null) {
            return null;
        }
        bVar.f58484b = jSONObject2;
        JSONObject jSONObject3 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject2, jTYhJgqLBN.NXsRVxpQA, new JSONArray()), 0, (JSONObject) null);
        if (jSONObject3 == null) {
            return null;
        }
        bVar.f58483a = jSONObject3;
        bVar.f58485c = jVar;
        bVar.f58486d = JsonUtils.getLong(jSONObject, "created_at_millis", 0L);
        bVar.f58487e = JsonUtils.getString(jSONObject, "title", "");
        bVar.f58488f = JsonUtils.getString(jSONObject, "ad_description", "");
        bVar.f58489g = jq.a(JsonUtils.getJSONObject(jSONObject, "system_info", (JSONObject) null), jVar);
        bVar.f58490h = nq.a(JsonUtils.getJSONObject(jSONObject, "video_creative", (JSONObject) null), jVar);
        bVar.f58491i = dq.a(JsonUtils.getJSONObject(jSONObject, "companion_ad", (JSONObject) null), jVar);
        bVar.f58492j = cq.a(JsonUtils.getJSONObject(jSONObject, "ad_verifications", (JSONObject) null), jVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "impression_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            kq kqVarA = kq.a(JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null), jVar);
            if (kqVarA != null) {
                hashSet.add(kqVarA);
            }
        }
        bVar.f58493k = hashSet;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "error_trackers", new JSONArray());
        HashSet hashSet2 = new HashSet();
        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
            kq kqVarA2 = kq.a(JsonUtils.getJSONObject(jSONArray2, i4, (JSONObject) null), jVar);
            if (kqVarA2 != null) {
                hashSet2.add(kqVarA2);
            }
        }
        bVar.f58494l = hashSet2;
        aq aqVar = new aq(bVar);
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray());
        for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
            Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray3, i5, null);
            if (objectAtIndex instanceof String) {
                String str = (String) objectAtIndex;
                if (!TextUtils.isEmpty(str)) {
                    aqVar.a(Uri.parse(str));
                }
            }
        }
        return aqVar;
    }

    private Set m1() {
        dq dqVar = this.f58477q;
        return dqVar != null ? dqVar.b() : Collections.EMPTY_SET;
    }

    private String q1() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    private Set u1() {
        nq nqVar = this.f58476p;
        return nqVar != null ? nqVar.b() : Collections.EMPTY_SET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List w(tl tlVar) {
        return yp.a(tlVar.a("vimp_urls", new JSONObject()), getClCode(), null, q1(), R(), V0(), this.sdk);
    }

    public boolean A1() {
        return getBooleanFromAdObject("cache_companion_ad", Boolean.TRUE);
    }

    public boolean B1() {
        return getBooleanFromAdObject("cache_video", Boolean.TRUE);
    }

    public boolean C1() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", Boolean.FALSE);
    }

    public boolean D1() {
        return getBooleanFromAdObject("iopms", Boolean.FALSE);
    }

    public boolean E1() {
        return getBooleanFromAdObject("iopmsfsr", Boolean.TRUE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public List F() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.ps
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f62513a.w((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("vimp_urls", new JSONObject()), getClCode(), null, q1(), R(), V0(), this.sdk);
        }
        return listA;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean G0() {
        return getBooleanFromFullResponse("is_persisted_ad", false);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean J0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE) && j() != null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean K0() {
        return getBooleanFromAdObject("vast_is_streaming", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public void N0() {
    }

    @Override // com.applovin.impl.sdk.ad.b
    public String Q() {
        return this.f58478r;
    }

    public void b(String str) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b("html_template", str);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aq) || !super.equals(obj)) {
            return false;
        }
        aq aqVar = (aq) obj;
        String str = this.f58472l;
        if (str == null ? aqVar.f58472l != null : !str.equals(aqVar.f58472l)) {
            return false;
        }
        String str2 = this.f58473m;
        if (str2 == null ? aqVar.f58473m != null : !str2.equals(aqVar.f58473m)) {
            return false;
        }
        jq jqVar = this.f58474n;
        if (jqVar == null ? aqVar.f58474n != null : !jqVar.equals(aqVar.f58474n)) {
            return false;
        }
        nq nqVar = this.f58476p;
        if (nqVar == null ? aqVar.f58476p != null : !nqVar.equals(aqVar.f58476p)) {
            return false;
        }
        dq dqVar = this.f58477q;
        if (dqVar == null ? aqVar.f58477q != null : !dqVar.equals(aqVar.f58477q)) {
            return false;
        }
        cq cqVar = this.f58479s;
        if (cqVar == null ? aqVar.f58479s != null : !cqVar.equals(aqVar.f58479s)) {
            return false;
        }
        Set set = this.f58481u;
        if (set == null ? aqVar.f58481u != null : !set.equals(aqVar.f58481u)) {
            return false;
        }
        Set set2 = this.f58482v;
        Set set3 = aqVar.f58482v;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        return this.f58475o;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        List listG;
        nq nqVar = this.f58476p;
        return (nqVar == null || (listG = nqVar.g()) == null || listG.size() <= 0) ? false : true;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f58472l;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f58473m;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        jq jqVar = this.f58474n;
        int iHashCode4 = (iHashCode3 + (jqVar != null ? jqVar.hashCode() : 0)) * 31;
        nq nqVar = this.f58476p;
        int iHashCode5 = (iHashCode4 + (nqVar != null ? nqVar.hashCode() : 0)) * 31;
        dq dqVar = this.f58477q;
        int iHashCode6 = (iHashCode5 + (dqVar != null ? dqVar.hashCode() : 0)) * 31;
        cq cqVar = this.f58479s;
        int iHashCode7 = (iHashCode6 + (cqVar != null ? cqVar.hashCode() : 0)) * 31;
        Set set = this.f58481u;
        int iHashCode8 = (iHashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set set2 = this.f58482v;
        return iHashCode8 + (set2 != null ? set2.hashCode() : 0);
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", Boolean.TRUE) && this.f58479s != null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri j() {
        nq nqVar = this.f58476p;
        if (nqVar != null) {
            return nqVar.c();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri l0() {
        return j();
    }

    public dq l1() {
        return this.f58477q;
    }

    public String n1() {
        return getStringFromAdObject("html_template", "");
    }

    public Uri o1() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public c p1() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? c.COMPANION_AD : c.VIDEO;
    }

    public gq r1() {
        nq nqVar = this.f58476p;
        if (nqVar != null) {
            return nqVar.f();
        }
        return null;
    }

    public long s1() {
        return getLongFromAdObject("real_close_delay", 0L);
    }

    public jq t1() {
        return this.f58474n;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "VastAd{title='" + this.f58472l + "', adDescription='" + this.f58473m + "', systemInfo=" + this.f58474n + ", videoCreative=" + this.f58476p + ", companionAd=" + this.f58477q + ", adVerifications=" + this.f58479s + ", impressionTrackers=" + this.f58481u + ", errorTrackers=" + this.f58482v + '}';
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri u0() {
        oq oqVarW1 = w1();
        if (oqVarW1 != null) {
            return oqVarW1.e();
        }
        return null;
    }

    public nq v1() {
        return this.f58476p;
    }

    public oq w1() {
        Long lF = e4.f(this.sdk);
        return this.f58476p.a(lF != null ? lF.longValue() : 0L);
    }

    public boolean x1() {
        return r1() != null;
    }

    public boolean y1() {
        return getBooleanFromAdObject("vast_immediate_ad_load", Boolean.TRUE);
    }

    public void z1() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.c("vast_is_streaming");
            return;
        }
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public rg getAdEventTracker() {
        return this.f58480t;
    }

    public cq k1() {
        return this.f58479s;
    }

    private Set a(c cVar, String[] strArr) {
        Map mapD;
        dq dqVar;
        nq nqVar;
        if (strArr != null && strArr.length > 0) {
            if (cVar == c.VIDEO && (nqVar = this.f58476p) != null) {
                mapD = nqVar.e();
            } else {
                mapD = (cVar != c.COMPANION_AD || (dqVar = this.f58477q) == null) ? null : dqVar.d();
            }
            HashSet hashSet = new HashSet();
            if (mapD != null && !mapD.isEmpty()) {
                for (String str : strArr) {
                    if (mapD.containsKey(str)) {
                        hashSet.addAll((Collection) mapD.get(str));
                    }
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.EMPTY_SET;
    }

    public Set a(d dVar, String str) {
        return a(dVar, new String[]{str});
    }

    public Set a(d dVar, String[] strArr) {
        this.sdk.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.sdk.I().a("VastAd", "Retrieving trackers of type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'...");
        }
        if (dVar == d.IMPRESSION) {
            return this.f58481u;
        }
        if (dVar == d.VIDEO_CLICK) {
            return u1();
        }
        if (dVar == d.COMPANION_CLICK) {
            return m1();
        }
        if (dVar == d.VIDEO) {
            return a(c.VIDEO, strArr);
        }
        if (dVar == d.COMPANION) {
            return a(c.COMPANION_AD, strArr);
        }
        if (dVar == d.INDUSTRY_ICON_CLICK) {
            return r1().b();
        }
        if (dVar == d.INDUSTRY_ICON_IMPRESSION) {
            return r1().f();
        }
        if (dVar == d.ERROR) {
            return this.f58482v;
        }
        this.sdk.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.sdk.I().b("VastAd", "Failed to retrieve trackers of invalid type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'");
        }
        return Collections.EMPTY_SET;
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "created_at_millis", this.f58475o);
        JsonUtils.putString(jSONObject, "title", this.f58472l);
        JsonUtils.putString(jSONObject, "ad_description", this.f58473m);
        jq jqVar = this.f58474n;
        if (jqVar != null) {
            JsonUtils.putJSONObject(jSONObject, "system_info", jqVar.a());
        }
        nq nqVar = this.f58476p;
        if (nqVar != null) {
            JsonUtils.putJSONObject(jSONObject, "video_creative", nqVar.a());
        }
        dq dqVar = this.f58477q;
        if (dqVar != null) {
            JsonUtils.putJSONObject(jSONObject, "companion_ad", dqVar.a());
        }
        cq cqVar = this.f58479s;
        if (cqVar != null) {
            JsonUtils.putJSONObject(jSONObject, "ad_verifications", cqVar.a());
        }
        if (this.f58481u != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f58481u.iterator();
            while (it.hasNext()) {
                jSONArray.put(((kq) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "impression_trackers", jSONArray);
        }
        if (this.f58482v != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.f58482v.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((kq) it2.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "error_trackers", jSONArray2);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it3 = i().iterator();
        while (it3.hasNext()) {
            arrayList.add(((Uri) it3.next()).toString());
        }
        JsonUtils.putJsonArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray((Collection) arrayList));
        tl tlVar = this.synchronizedFullResponse;
        if (tlVar != null) {
            JsonUtils.putJSONObject(jSONObject, "full_response", tlVar.a());
            return jSONObject;
        }
        synchronized (this.fullResponseLock) {
            JsonUtils.putJSONObject(jSONObject, "full_response", this.fullResponse);
        }
        return jSONObject;
    }
}
