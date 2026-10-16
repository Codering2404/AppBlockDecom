package com.applovin.impl;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class nq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f62128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f62129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f62130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f62131d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f62132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private gq f62133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f62134h;

    private nq() {
        List list = Collections.EMPTY_LIST;
        this.f62128a = list;
        this.f62129b = list;
        this.f62132f = new HashSet();
        this.f62134h = new HashMap();
    }

    public static nq a(es esVar, nq nqVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        es esVarC;
        gq gqVarA;
        List listA;
        es esVarC2;
        List listA2;
        es esVarC3;
        int iA;
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (eqVar == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (nqVar == null) {
            try {
                nqVar = new nq(eqVar);
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("VastVideoCreative", "Error occurred while initializing", th);
                }
                jVar.D().a("VastVideoCreative", th);
                return null;
            }
        }
        if (nqVar.f62130c == 0 && (esVarC3 = esVar.c("Duration")) != null && (iA = a(esVarC3.d(), jVar)) > 0) {
            nqVar.f62130c = iA;
        }
        es esVarC4 = esVar.c("MediaFiles");
        if (esVarC4 != null && (listA2 = a(esVarC4, jVar)) != null && listA2.size() > 0) {
            List list = nqVar.f62128a;
            if (list != null) {
                listA2.addAll(list);
            }
            nqVar.f62128a = listA2;
        }
        es esVarC5 = esVar.c("VideoClicks");
        if (esVarC5 != null) {
            if (nqVar.f62131d == null && (esVarC2 = esVarC5.c("ClickThrough")) != null) {
                String strD = esVarC2.d();
                if (StringUtils.isValidString(strD)) {
                    nqVar.f62131d = Uri.parse(strD);
                }
            }
            mq.a(esVarC5.a("ClickTracking"), nqVar.f62132f, eqVar, jVar);
        }
        es esVarC6 = esVar.c("Icons");
        if (esVarC6 != null && (gqVarA = gq.a((esVarC = esVarC6.c("Icon")), jVar)) != null) {
            es esVarC7 = esVarC.c("IconClicks");
            if (esVarC7 != null && (listA = esVarC7.a("IconClickTracking")) != null) {
                mq.a(listA, gqVarA.f60042a, eqVar, jVar);
            }
            List listA3 = esVarC.a("IconViewTracking");
            if (listA3 != null) {
                mq.a(listA3, gqVarA.f60043b, eqVar, jVar);
            }
            nqVar.f62133g = gqVarA;
        }
        mq.a(esVar, nqVar.f62134h, eqVar, jVar);
        return nqVar;
    }

    public Uri c() {
        return this.f62131d;
    }

    public int d() {
        return this.f62130c;
    }

    public Map e() {
        return this.f62134h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nq)) {
            return false;
        }
        nq nqVar = (nq) obj;
        if (this.f62130c != nqVar.f62130c) {
            return false;
        }
        List list = this.f62128a;
        if (list == null ? nqVar.f62128a != null : !list.equals(nqVar.f62128a)) {
            return false;
        }
        Uri uri = this.f62131d;
        if (uri == null ? nqVar.f62131d != null : !uri.equals(nqVar.f62131d)) {
            return false;
        }
        Set set = this.f62132f;
        if (set == null ? nqVar.f62132f != null : !set.equals(nqVar.f62132f)) {
            return false;
        }
        Map map = this.f62134h;
        Map map2 = nqVar.f62134h;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public gq f() {
        return this.f62133g;
    }

    public List g() {
        return this.f62128a;
    }

    public int hashCode() {
        List list = this.f62128a;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f62130c) * 31;
        Uri uri = this.f62131d;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set set = this.f62132f;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.f62134h;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f62128a + ", durationSeconds=" + this.f62130c + ", destinationUri=" + this.f62131d + ", clickTrackers=" + this.f62132f + ", eventTrackers=" + this.f62134h + ", industryIcon=" + this.f62133g + '}';
    }

    public Set b() {
        return this.f62132f;
    }

    private nq(eq eqVar) {
        List list = Collections.EMPTY_LIST;
        this.f62128a = list;
        this.f62129b = list;
        this.f62132f = new HashSet();
        this.f62134h = new HashMap();
        this.f62129b = eqVar.f();
    }

    public static nq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        nq nqVar = new nq();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "video_files", new JSONArray());
        nqVar.f62128a = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            oq oqVarA = oq.a(JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null), jVar);
            if (oqVarA != null) {
                nqVar.f62128a.add(oqVarA);
            }
        }
        nqVar.f62129b = JsonUtils.getStringList(jSONObject, "preferred_video_file_types", Collections.EMPTY_LIST);
        nqVar.f62130c = JsonUtils.getInt(jSONObject, "duration_seconds", 0);
        String string = JsonUtils.getString(jSONObject, "destination_uri", null);
        nqVar.f62131d = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
            kq kqVarA = kq.a(JsonUtils.getJSONObject(jSONArray2, i4, (JSONObject) null), jVar);
            if (kqVarA != null) {
                nqVar.f62132f.add(kqVarA);
            }
        }
        nqVar.f62133g = gq.a(JsonUtils.getJSONObject(jSONObject, "industry_icon", (JSONObject) null), jVar);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "event_trackers", new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            HashSet hashSet = new HashSet();
            String next = itKeys.next();
            JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject2, next, new JSONArray());
            for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
                kq kqVarA2 = kq.a(JsonUtils.getJSONObject(jSONArray3, i5, (JSONObject) null), jVar);
                if (kqVarA2 != null) {
                    hashSet.add(kqVarA2);
                }
            }
            nqVar.f62134h.put(next, hashSet);
        }
        return nqVar;
    }

    public oq a(long j3) {
        List list = this.f62128a;
        oq oqVar = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        List<oq> arrayList = new ArrayList(3);
        for (String str : this.f62129b) {
            for (oq oqVar2 : this.f62128a) {
                String strC = oqVar2.c();
                if (StringUtils.isValidString(strC) && str.equalsIgnoreCase(strC)) {
                    arrayList.add(oqVar2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f62128a;
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.applovin.impl.xz
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return nq.a((oq) obj, (oq) obj2);
            }
        });
        for (oq oqVar3 : arrayList) {
            if (oqVar3.b() > j3) {
                break;
            }
            oqVar = oqVar3;
        }
        return oqVar != null ? oqVar : (oq) arrayList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(oq oqVar, oq oqVar2) {
        return Long.compare(oqVar.b(), oqVar2.b());
    }

    private static int a(String str, com.applovin.impl.sdk.j jVar) {
        try {
            List<String> listExplode = CollectionUtils.explode(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            if (listExplode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds(StringUtils.parseInt(listExplode.get(0))) + TimeUnit.MINUTES.toSeconds(StringUtils.parseInt(listExplode.get(1))) + ((long) StringUtils.parseInt(listExplode.get(2))));
            }
        } catch (Throwable unused) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    private static List a(es esVar, com.applovin.impl.sdk.j jVar) {
        List listA = esVar.a("MediaFile");
        ArrayList arrayList = new ArrayList(listA.size());
        List<String> listExplode = CollectionUtils.explode((String) jVar.a(sj.I4));
        List<String> listExplode2 = CollectionUtils.explode((String) jVar.a(sj.H4));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            oq oqVarA = oq.a((es) it.next(), jVar);
            if (oqVarA != null) {
                try {
                    String strC = oqVarA.c();
                    if (StringUtils.isValidString(strC) && !listExplode.contains(strC)) {
                        arrayList.add(oqVarA);
                    } else {
                        if (((Boolean) jVar.a(sj.J4)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(oqVarA.e().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !listExplode2.contains(fileExtensionFromUrl)) {
                                arrayList.add(oqVarA);
                            }
                        }
                        jVar.I();
                        if (com.applovin.impl.sdk.n.a()) {
                            jVar.I().k("VastVideoCreative", "Video file not supported: " + oqVarA);
                        }
                    }
                } catch (Throwable th) {
                    jVar.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.I().a("VastVideoCreative", "Failed to validate video file: " + oqVarA, th);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List list = this.f62128a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((oq) it.next()).a());
            }
        }
        JsonUtils.putJsonArray(jSONObject, jlWo.FuJJClUptcocxb, jSONArray);
        JsonUtils.putJsonArray(jSONObject, "preferred_video_file_types", new JSONArray((Collection) this.f62129b));
        JsonUtils.putInt(jSONObject, "duration_seconds", this.f62130c);
        Uri uri = this.f62131d;
        JsonUtils.putString(jSONObject, "destination_uri", uri == null ? null : uri.toString());
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.f62132f.iterator();
        while (it2.hasNext()) {
            jSONArray2.put(((kq) it2.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray2);
        gq gqVar = this.f62133g;
        if (gqVar != null) {
            JsonUtils.putJSONObject(jSONObject, "industry_icon", gqVar.a());
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.f62134h.keySet()) {
            Set set = (Set) this.f62134h.get(str);
            if (set != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((kq) it3.next()).a());
                }
                JsonUtils.putJsonArray(jSONObject2, str, jSONArray3);
            }
        }
        JsonUtils.putJSONObject(jSONObject, "event_trackers", jSONObject2);
        return jSONObject;
    }
}
