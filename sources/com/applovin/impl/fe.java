package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.arch.core.util.Function;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class fe extends oe implements MaxAd {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f59680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f59681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f59682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected com.applovin.impl.mediation.g f59683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f59684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MaxAdWaterfallInfo f59685q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f59686r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f59687s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f59688t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private bd f59689u;

    protected fe(int i3, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.g gVar, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, jVar);
        this.f59681m = new AtomicBoolean();
        this.f59682n = new AtomicBoolean();
        this.f59680l = i3;
        this.f59683o = gVar;
        this.f59684p = gVar != null ? gVar.b() : null;
    }

    private long L() {
        return a("load_started_time_ms", 0L);
    }

    public static fe a(int i3, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        String string = JsonUtils.getString(jSONObject2, "ad_format", null);
        MaxAdFormat fromString = MaxAdFormat.formatFromString(string);
        Objects.requireNonNull(fromString, "Invalid ad format for string: " + string);
        if (fromString.isAdViewAd()) {
            return new ge(i3, map, jSONObject, jSONObject2, jVar);
        }
        if (fromString == MaxAdFormat.NATIVE) {
            return new ie(i3, map, jSONObject, jSONObject2, jVar);
        }
        if (fromString.isFullscreenAd()) {
            return new he(i3, map, jSONObject, jSONObject2, jVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject b(tl tlVar) {
        return JsonUtils.deepCopy(tlVar.a("ad_values", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle c(tl tlVar) {
        JSONObject jSONObjectA;
        if (tlVar.a("credentials")) {
            jSONObjectA = tlVar.a("credentials", new JSONObject());
        } else {
            jSONObjectA = tlVar.a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, T());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ bd d(tl tlVar) {
        return new bd(tlVar.a("hybrid_ad_config", (JSONObject) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject e(tl tlVar) {
        return JsonUtils.deepCopy(tlVar.a("publisher_extra_info", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double f(tl tlVar) {
        return Double.valueOf(JsonUtils.getDouble(tlVar.a("revenue_parameters", (JSONObject) null), "revenue", -1.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject g(tl tlVar) {
        return JsonUtils.deepCopy(tlVar.a("revenue_parameters", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(tl tlVar) {
        return JsonUtils.getString(tlVar.a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    public com.applovin.impl.mediation.g A() {
        return this.f59683o;
    }

    public String B() {
        return a("bcode", "");
    }

    public long C() {
        return a("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1L, l()));
    }

    public String D() {
        return a("bid_response", (String) null);
    }

    public long E() {
        return a("bwt_ms", ((Long) this.f62260a.a(ue.B7)).longValue());
    }

    public Bundle F() {
        JSONObject jSONObjectA;
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            return (Bundle) tlVar.a(new Function() { // from class: com.applovin.impl.qw
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f62685a.c((tl) obj);
                }
            });
        }
        if (c("credentials")) {
            jSONObjectA = a("credentials", new JSONObject());
        } else {
            jSONObjectA = a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, T());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    public long G() {
        if (L() > 0) {
            return K() - L();
        }
        return -1L;
    }

    public bd H() {
        bd bdVar = this.f59689u;
        if (bdVar != null) {
            return bdVar;
        }
        tl tlVar = this.f62267i;
        if (tlVar != null) {
            this.f59689u = (bd) tlVar.a(new Function() { // from class: com.applovin.impl.ow
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return fe.d((tl) obj);
                }
            });
        } else {
            this.f59689u = new bd(a("hybrid_ad_config", (JSONObject) null));
        }
        return this.f59689u;
    }

    public MaxAdFormat I() {
        String strA = a("haf", (String) null);
        if (StringUtils.isValidString(strA)) {
            return MaxAdFormat.formatFromString(strA);
        }
        return null;
    }

    public int J() {
        return this.f59680l;
    }

    public long K() {
        return a("load_completed_time_ms", 0L);
    }

    public String M() {
        return this.f59687s;
    }

    public double N() {
        return a("price", -1.0f);
    }

    public JSONObject O() {
        tl tlVar = this.f62267i;
        return tlVar != null ? (JSONObject) tlVar.a(new Function() { // from class: com.applovin.impl.nw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return fe.e((tl) obj);
            }
        }) : a("publisher_extra_info", new JSONObject());
    }

    public String P() {
        return JsonUtils.getString(Q(), "revenue_event", "");
    }

    public JSONObject Q() {
        tl tlVar = this.f62267i;
        return tlVar != null ? (JSONObject) tlVar.a(new Function() { // from class: com.applovin.impl.rw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return fe.g((tl) obj);
            }
        }) : a("revenue_parameters", new JSONObject());
    }

    public long S() {
        return a("twt_ms", ((Long) this.f62260a.a(ue.C7)).longValue());
    }

    public String T() {
        return a("third_party_ad_placement_id", (String) null);
    }

    public List U() {
        return b("mwf_info_urls");
    }

    public String V() {
        return b("waterfall_name", "");
    }

    public String W() {
        return b("waterfall_test_name", "");
    }

    public boolean X() {
        return StringUtils.isValidString(D());
    }

    public boolean Y() {
        return I() != null;
    }

    public boolean Z() {
        return a("is_js_tag_ad", Boolean.FALSE).booleanValue();
    }

    public abstract fe a(com.applovin.impl.mediation.g gVar);

    public boolean a0() {
        com.applovin.impl.mediation.g gVar = this.f59683o;
        return gVar != null && gVar.k() && this.f59683o.j();
    }

    public boolean b0() {
        return a("only_load_when_initialized", Boolean.FALSE).booleanValue();
    }

    public boolean c0() {
        return a("prefer_load_when_initialized", Boolean.TRUE).booleanValue();
    }

    public void d0() {
        c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    public void e0() {
        c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdReviewCreativeId() {
        return this.f59688t;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getCreativeId() {
        return a("creative_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspId() {
        return a("dsp_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspName() {
        return a("dsp_name", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(a("ad_format", b("ad_format", (String) null)));
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxNativeAd getNativeAd() {
        com.applovin.impl.mediation.g gVar = this.f59683o;
        if (gVar != null) {
            return gVar.e();
        }
        return null;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkName() {
        return a("network_name", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(T());
    }

    @Override // com.applovin.mediation.MaxAd
    public long getRequestLatencyMillis() {
        return this.f59686r;
    }

    @Override // com.applovin.mediation.MaxAd
    public double getRevenue() {
        if (!((Boolean) this.f62260a.a(ue.y7)).booleanValue() || !getFormat().isFullscreenAd() || u().get()) {
            tl tlVar = this.f62267i;
            return tlVar != null ? ((Double) tlVar.a(new Function() { // from class: com.applovin.impl.sw
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return fe.f((tl) obj);
                }
            })).doubleValue() : JsonUtils.getDouble(a("revenue_parameters", (JSONObject) null), "revenue", -1.0d);
        }
        this.f62260a.I();
        if (!com.applovin.impl.sdk.n.a()) {
            return 0.0d;
        }
        this.f62260a.I().b("MediatedAd", "Attempting to retrieve revenue when not available yet");
        return 0.0d;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getRevenuePrecision() {
        tl tlVar = this.f62267i;
        return tlVar != null ? (String) tlVar.a(new Function() { // from class: com.applovin.impl.tw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return fe.h((tl) obj);
            }
        }) : JsonUtils.getString(a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public AppLovinSdkUtils.Size getSize() {
        int iA = a("ad_width", -3);
        int iA2 = a("ad_height", -3);
        return (iA == -3 || iA2 == -3) ? getFormat().getSize() : new AppLovinSdkUtils.Size(iA, iA2);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdWaterfallInfo getWaterfall() {
        return this.f59685q;
    }

    public void i(String str) {
        this.f59687s = str;
    }

    @Override // com.applovin.impl.oe
    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + T() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }

    public String R() {
        return b("event_id", KLAQHFCRAUejH.BmWDnGn);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str, String str2) {
        JSONObject jSONObjectX = x();
        if (jSONObjectX.has(str)) {
            return JsonUtils.getString(jSONObjectX, str, str2);
        }
        Bundle bundleL = l();
        if (bundleL.containsKey(str)) {
            return bundleL.getString(str);
        }
        JSONObject jSONObjectO = O();
        return jSONObjectO.has(str) ? JsonUtils.getString(jSONObjectO, str, str2) : a(str, str2);
    }

    public void t() {
        this.f59683o = null;
        this.f59685q = null;
    }

    public AtomicBoolean u() {
        return this.f59681m;
    }

    public String v() {
        return a("adomain", (String) null);
    }

    public AtomicBoolean w() {
        return this.f59682n;
    }

    public JSONObject x() {
        tl tlVar = this.f62267i;
        return tlVar != null ? (JSONObject) tlVar.a(new Function() { // from class: com.applovin.impl.pw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return fe.b((tl) obj);
            }
        }) : a("ad_values", new JSONObject());
    }

    public View y() {
        com.applovin.impl.mediation.g gVar;
        if (!a0() || (gVar = this.f59683o) == null) {
            return null;
        }
        return gVar.d();
    }

    public String z() {
        return this.f59684p;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectO = O();
        JsonUtils.putAll(jSONObjectO, jSONObject);
        a("publisher_extra_info", (Object) jSONObjectO);
    }

    public void h(String str) {
        this.f59688t = str;
    }

    public void a(long j3) {
        this.f59686r = j3;
    }

    public void a(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.f59685q = maxAdWaterfallInfo;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectX = x();
        JsonUtils.putAll(jSONObjectX, jSONObject);
        a("ad_values", (Object) jSONObjectX);
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("ad_values")) {
            a(BundleUtils.toJSONObject(bundle.getBundle("ad_values")));
        }
        if (bundle.containsKey("creative_id") && !c("creative_id")) {
            c("creative_id", BundleUtils.getString("creative_id", bundle));
        }
        if (bundle.containsKey("ad_width") && !c("ad_width") && bundle.containsKey("ad_height") && !c("ad_height")) {
            int i3 = BundleUtils.getInt("ad_width", bundle);
            int i4 = BundleUtils.getInt("ad_height", bundle);
            c("ad_width", i3);
            c("ad_height", i4);
        }
        if (bundle.containsKey("publisher_extra_info")) {
            b(BundleUtils.toJSONObject(bundle.getBundle("publisher_extra_info")));
        }
    }
}
