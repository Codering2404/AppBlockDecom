package com.applovin.impl.sdk.ad;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.applovin.impl.adview.e;
import com.applovin.impl.hh;
import com.applovin.impl.mg;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tl;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends b implements hh {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f63178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f63179m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f63180n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final mg f63181o;

    public a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jSONObject2, jVar);
        this.f63178l = l1();
        this.f63179m = q1();
        this.f63180n = p1();
        this.f63181o = new mg(this);
    }

    public static a a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        JSONObject jSONObject2;
        if (jSONObject == null || (jSONObject2 = JsonUtils.getJSONObject(jSONObject, "full_response", (JSONObject) null)) == null) {
            return null;
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject2, "ads", new JSONArray()), 0, (JSONObject) null);
        if (jSONObject3 == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject3, "html", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String string2 = JsonUtils.getString(jSONObject3, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "");
        JsonUtils.putString(jSONObject3, "html", JsonUtils.getString(jSONObject, "original_html_source", ""));
        JsonUtils.putString(jSONObject3, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, JsonUtils.getString(jSONObject, "original_video_uri_string", ""));
        a aVar = new a(jSONObject3, jSONObject2, jVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray, i3, null);
            if (objectAtIndex instanceof String) {
                String str = (String) objectAtIndex;
                if (!TextUtils.isEmpty(str)) {
                    aVar.a(Uri.parse(str));
                }
            }
        }
        aVar.b(string);
        if (StringUtils.isValidString(string2)) {
            aVar.d(Uri.parse(string2));
        }
        return aVar;
    }

    private String p1() {
        return getStringFromAdObject("stream_url", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(tl tlVar) {
        tlVar.b("html", this.f63178l);
        tlVar.b("stream_url", this.f63180n);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean G0() {
        return getBooleanFromFullResponse("is_persisted_ad", false);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean K0() {
        return containsKeyForAdObject("stream_url");
    }

    @Override // com.applovin.impl.sdk.ad.b
    public void N0() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.a(new Consumer() { // from class: com.applovin.impl.sdk.ad.d
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    this.f63213a.w((tl) obj);
                }
            });
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", this.f63178l);
            JsonUtils.putString(this.adObject, "stream_url", this.f63180n);
        }
    }

    @Override // com.applovin.impl.sdk.ad.b
    public String Q() {
        return this.f63179m;
    }

    public void b(String str) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b("html", str);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", str);
        }
    }

    public void d(Uri uri) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, uri.toString());
        }
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        JSONObject jSONObjectDeepCopy;
        JSONObject jSONObjectA;
        tl tlVar = this.synchronizedFullResponse;
        if (tlVar != null) {
            jSONObjectA = tlVar.a();
        } else {
            synchronized (this.fullResponseLock) {
                jSONObjectDeepCopy = JsonUtils.deepCopy(this.fullResponse);
            }
            jSONObjectA = jSONObjectDeepCopy;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObjectA, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject, "html", this.f63178l);
            JsonUtils.putString(jSONObject, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, this.f63179m);
            JsonUtils.putString(jSONObject, "stream_url", this.f63180n);
        }
        return jSONObjectA;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        return u0() != null;
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public boolean isOpenMeasurementEnabled() {
        if (this.sdk.V().e()) {
            return true;
        }
        return getBooleanFromAdObject("omsdk_enabled", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri j() {
        String stringFromAdObject = getStringFromAdObject("click_url", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri l0() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return StringUtils.isValidString(stringFromAdObject) ? Uri.parse(stringFromAdObject) : j();
    }

    public String l1() {
        return getStringFromAdObject("html", "");
    }

    public String m1() {
        return getStringFromAdObject("html_url", "");
    }

    public float n1() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    public String o1() {
        return this.f63180n;
    }

    public boolean r1() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", Boolean.FALSE);
        }
        return true;
    }

    public void s1() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.c("stream_url");
            return;
        }
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    public boolean t1() {
        return getBooleanFromAdObject("should_cache_html_url_contents", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri u0() {
        String strP1 = p1();
        if (StringUtils.isValidString(strP1)) {
            return Uri.parse(strP1);
        }
        String strQ1 = q1();
        if (StringUtils.isValidString(strQ1)) {
            return Uri.parse(strQ1);
        }
        return null;
    }

    public boolean u1() {
        return getBooleanFromAdObject("should_respect_whitelist_when_retrieving_html_from_url", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public mg getAdEventTracker() {
        return this.f63181o;
    }

    public e.a k1() {
        return a(getIntFromAdObject("expandable_style", e.a.INVISIBLE.b()));
    }

    public String q1() {
        return getStringFromAdObject(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, vgWWUoTKYyuC.AtDGDNJPs);
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "original_html_source", this.f63178l);
        JsonUtils.putString(jSONObject, "original_video_uri_string", this.f63179m);
        JsonUtils.putString(jSONObject, "original_video_stream_uri_string", this.f63180n);
        ArrayList arrayList = new ArrayList();
        Iterator it = i().iterator();
        while (it.hasNext()) {
            arrayList.add(((Uri) it.next()).toString());
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
