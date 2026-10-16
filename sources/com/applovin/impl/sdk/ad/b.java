package com.applovin.impl.sdk.ad;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.arch.core.util.Function;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.core.util.Consumer;
import com.applovin.impl.adview.e;
import com.applovin.impl.d5;
import com.applovin.impl.eh;
import com.applovin.impl.hh;
import com.applovin.impl.lg;
import com.applovin.impl.qq;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.sr;
import com.applovin.impl.tl;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.HKJ.pnxuebdT;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends AppLovinAdImpl implements hh {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f63182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f63183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f63184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicReference f63185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Bundle f63186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d f63187k;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.ad.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum EnumC0122b {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum c {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f63196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f63197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f63198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f63199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f63200e;

        private d() {
            this.f63196a = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.m(), b.this.m());
            this.f63197b = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.m(), b.this.o());
            this.f63198c = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.m(), b.this.k());
            this.f63199d = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.m(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(sj.f63783q1)).intValue());
            this.f63200e = AppLovinSdkUtils.dpToPx(com.applovin.impl.sdk.j.m(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(sj.f63779p1)).intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum e {
        RESIZE_ASPECT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public b(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jSONObject2, jVar);
        this.f63182f = CollectionUtils.synchronizedList();
        this.f63183g = new AtomicBoolean();
        this.f63184h = new AtomicBoolean();
        this.f63185i = new AtomicReference();
        this.f63186j = new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(tl tlVar) {
        return yp.a(tlVar.a("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List b(tl tlVar) {
        return yp.a(tlVar.a("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map c(tl tlVar) {
        try {
            return JsonUtils.toStringMap(tlVar.a("custom_tabs_http_headers", new JSONObject()));
        } catch (JSONException e3) {
            this.sdk.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.sdk.I().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e3);
            }
            return new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List d(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List e(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List g(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ d5 h(tl tlVar) {
        JSONObject jSONObjectA = tlVar.a("custom_tabs_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new d5(jSONObjectA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List i(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List j(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle k(tl tlVar) {
        return JsonUtils.toBundle(tlVar.a("ah_parameters", (JSONObject) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List l(tl tlVar) {
        return yp.a(tlVar.a("imp_urls", new JSONObject()), getClCode(), null, null, R(), V0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map m(tl tlVar) {
        try {
            return JsonUtils.toStringMap(tlVar.a("http_headers_for_postbacks", new JSONObject()));
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String n(tl tlVar) {
        return JsonUtils.getString(tlVar.a("video_button_properties", (JSONObject) null), "video_button_base_url", "/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String o(tl tlVar) {
        return JsonUtils.getString(tlVar.a("video_button_properties", (JSONObject) null), "video_button_html", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String p(tl tlVar) {
        return JsonUtils.getString(tlVar.a("video_button_properties", (JSONObject) null), "video_button_html_url", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qq q(tl tlVar) {
        return new qq(tlVar.a("video_button_properties", (JSONObject) null), this.sdk);
    }

    private String q0() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List r(tl tlVar) {
        return yp.a(tlVar.a("video_end_urls", new JSONObject()), getClCode(), q0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.applovin.impl.adview.m s(tl tlVar) {
        JSONObject jSONObjectA = tlVar.a("web_view_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new com.applovin.impl.adview.m(jSONObjectA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean t(tl tlVar) {
        return JsonUtils.getBoolean(tlVar.a("video_button_properties", (JSONObject) null), "should_cache_video_button_html_assets", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean u(tl tlVar) {
        return JsonUtils.getBoolean(tlVar.a("video_button_properties", (JSONObject) null), "should_cache_video_button_html_url_contents", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean v(tl tlVar) {
        return JsonUtils.getBoolean(tlVar.a("video_button_properties", (JSONObject) null), "should_respect_whitelist_when_retrieving_video_button_html_from_url", Boolean.FALSE);
    }

    public boolean A0() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.a(sj.S1));
    }

    public boolean B0() {
        return getBooleanFromAdObject("custom_tabs_client_warmup_enabled", Boolean.FALSE);
    }

    public boolean C0() {
        return getBooleanFromAdObject("custom_tabs_enabled", Boolean.FALSE);
    }

    public boolean D0() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", Boolean.FALSE);
    }

    public boolean E0() {
        return getBooleanFromAdObject("gase", Boolean.FALSE);
    }

    public boolean F0() {
        return getBooleanFromAdObject("lock_current_orientation", Boolean.FALSE);
    }

    public abstract boolean G0();

    public AtomicBoolean H0() {
        return this.f63183g;
    }

    public boolean I0() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.a(sj.f63740f2));
    }

    public boolean J0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE);
    }

    public abstract boolean K0();

    public boolean L0() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", Boolean.valueOf(yp.h(com.applovin.impl.sdk.j.m()) || yp.f(com.applovin.impl.sdk.j.m()) || ((Boolean) this.sdk.a(sj.f6)).booleanValue()));
    }

    public boolean M0() {
        return getBooleanFromAdObject("web_video", Boolean.FALSE);
    }

    public abstract void N0();

    public boolean O0() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", Boolean.FALSE);
    }

    public boolean P0() {
        return getBooleanFromAdObject("should_apply_web_view_settings_to_web_view_button", (Boolean) this.sdk.a(sj.j6));
    }

    public abstract String Q();

    public boolean Q0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? ((Boolean) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.e
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.t((tl) obj);
            }
        })).booleanValue() : JsonUtils.getBoolean(getJsonObjectFromAdObject("video_button_properties", null), "should_cache_video_button_html_assets", Boolean.FALSE).booleanValue();
    }

    public boolean R0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? ((Boolean) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.g
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.u((tl) obj);
            }
        })).booleanValue() : JsonUtils.getBoolean(getJsonObjectFromAdObject("video_button_properties", null), "should_cache_video_button_html_url_contents", Boolean.FALSE).booleanValue();
    }

    public boolean S0() {
        return this.f63184h.get();
    }

    public boolean T0() {
        return getBooleanFromAdObject("custom_tabs_should_track_events", Boolean.FALSE);
    }

    public boolean U0() {
        return getBooleanFromAdObject("serfaad", (Boolean) this.sdk.a(sj.T0));
    }

    public boolean V0() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", Boolean.FALSE);
    }

    public boolean W0() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", Boolean.FALSE);
    }

    public List Y() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : this.sdk.c(sj.F0);
    }

    public boolean Y0() {
        return getBooleanFromAdObject("avoms", Boolean.FALSE);
    }

    public List Z() {
        return getStringListFromAdObject("rea", X());
    }

    public boolean Z0() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", Boolean.TRUE);
    }

    public String a0() {
        return getStringFromAdObject("text_rewarded_inter_alert_body", "");
    }

    public boolean a1() {
        return getBooleanFromAdObject("require_interaction_for_click", Boolean.FALSE);
    }

    public String b0() {
        return getStringFromAdObject("text_rewarded_inter_alert_ok_action", "OK!");
    }

    public boolean b1() {
        return getBooleanFromAdObject("sruifwvc", Boolean.FALSE);
    }

    public String c0() {
        return getStringFromAdObject("text_rewarded_inter_alert_title", "Watch a video to earn a reward!");
    }

    public boolean c1() {
        return getBooleanFromAdObject("respect_adview_fully_watched", Boolean.FALSE);
    }

    public e.a d0() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? n() : a(intFromAdObject);
    }

    public boolean d1() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? ((Boolean) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.r
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.v((tl) obj);
            }
        })).booleanValue() : JsonUtils.getBoolean(getJsonObjectFromAdObject("video_button_properties", null), "should_respect_whitelist_when_retrieving_video_button_html_from_url", Boolean.FALSE).booleanValue();
    }

    public List e0() {
        return getStringListFromAdObject("substrings_for_disabled_click_logic", Collections.EMPTY_LIST);
    }

    public boolean e1() {
        return getBooleanFromAdObject("show_nia", Boolean.FALSE);
    }

    public eh f() {
        return (eh) this.f63185i.getAndSet(null);
    }

    public c f0() {
        c cVar = c.DEFAULT;
        String upperCase = getStringFromAdObject("ad_target", cVar.toString()).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? c.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? c.ACTIVITY_LANDSCAPE : cVar;
    }

    public boolean f1() {
        return getBooleanFromAdObject("show_rewarded_interstitial_overlay_alert", Boolean.valueOf(AppLovinAdType.AUTO_INCENTIVIZED == getType()));
    }

    public Uri g0() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "https://assets.applovin.com/sound_on.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean g1() {
        return getBooleanFromAdObject("sscomt", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public abstract lg getAdEventTracker();

    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", null);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (Bundle) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.y
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.k((tl) obj);
            }
        }) : JsonUtils.toBundle(getJsonObjectFromAdObject("ah_parameters", null));
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return getStringFromAdObject("ah_dd_token", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public List getOpenMeasurementVerificationScriptResources() {
        List list;
        final Function function = new Function() { // from class: com.applovin.impl.sdk.ad.p
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f63223a.a((JSONArray) obj);
            }
        };
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.x
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.a(function, (tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            list = (List) function.apply(getJsonArrayFromAdObject("omid_verification_script_resources", null));
        }
        return list;
    }

    public List getPrivacySandboxImpressionAttributionUrls() {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_impression_attribution_urls", Collections.EMPTY_LIST);
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        String clCode = getClCode();
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().replace("{CLCODE}", clCode));
        }
        return arrayList;
    }

    public String h0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (String) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.w
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.n((tl) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_base_url", "/");
    }

    public boolean h1() {
        return getBooleanFromAdObject("track_auto_redirects", Boolean.FALSE);
    }

    public String i0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (String) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.n
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.o((tl) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", "");
    }

    public boolean i1() {
        String str = this.sdk.f0().getExtraParameters().get("should_use_exoplayer_if_available");
        return StringUtils.isValidString(str) ? Boolean.parseBoolean(str) : getBooleanFromAdObject("suep", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return StringUtils.isValidString(getDirectDownloadToken());
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public abstract boolean isOpenMeasurementEnabled();

    public abstract Uri j();

    public String j0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (String) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.a0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.p((tl) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html_url", "");
    }

    public boolean j1() {
        return getBooleanFromAdObject("upiosp", Boolean.FALSE);
    }

    public qq k0() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (qq) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.t
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f63226a.q((tl) obj);
            }
        }) : new qq(getJsonObjectFromAdObject("video_button_properties", null), this.sdk);
    }

    public abstract Uri l0();

    public long m0() {
        return getLongFromAdObject("close_delay", 0L);
    }

    public long n0() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5L));
    }

    public int o0() {
        return yp.a(getIntFromAdObject("video_completion_percent", -1));
    }

    public List p0() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.j
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63219a.r((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("video_end_urls", new JSONObject()), getClCode(), q0(), this.sdk);
        }
        return listA;
    }

    public e r0() {
        String stringFromAdObject = getStringFromAdObject("video_gravity", null);
        return ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(stringFromAdObject) ? e.TOP : "bottom".equals(stringFromAdObject) ? e.BOTTOM : ViewHierarchyConstants.DIMENSION_LEFT_KEY.equals(stringFromAdObject) ? e.LEFT : "right".equals(stringFromAdObject) ? e.RIGHT : e.RESIZE_ASPECT;
    }

    public int s0() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    public boolean t0() {
        return getBooleanFromAdObject("progress_bar_enabled", Boolean.FALSE);
    }

    public abstract Uri u0();

    public int v0() {
        return getIntFromAdObject("whalt", yp.a(getSize()) ? 1 : ((Boolean) this.sdk.a(sj.L5)).booleanValue() ? 0 : -1);
    }

    public List w() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.m
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63222a.g((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public com.applovin.impl.adview.m w0() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (com.applovin.impl.adview.m) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.c0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.s((tl) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new com.applovin.impl.adview.m(jsonObjectFromAdObject);
        }
        return null;
    }

    public List x0() {
        return CollectionUtils.explode(getStringFromAdObject("wlh", null));
    }

    public List y0() {
        return CollectionUtils.explode(getStringFromAdObject("wls", ""));
    }

    public boolean z0() {
        return getBooleanFromAdObject("bvde", (Boolean) this.sdk.a(sj.R5));
    }

    private List K() {
        return getIntegerListFromAdObject("multi_close_style", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List f(tl tlVar) {
        return yp.a(tlVar.a("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    public List A() {
        return getStringListFromAdObject("custom_tabs_warmup_urls", Collections.EMPTY_LIST);
    }

    public boolean B() {
        return getBooleanFromAdObject("dismiss_on_skip", Boolean.FALSE);
    }

    public int C() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    public int D() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    public int E() {
        return yp.a(getIntFromAdObject("graphic_completion_percent", -1), 90);
    }

    public List F() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.k
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63220a.l((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("imp_urls", new JSONObject()), getClCode(), null, null, R(), V0(), this.sdk);
        }
        return listA;
    }

    public int G() {
        return getIntFromAdObject("mdafra", ((Integer) this.sdk.a(sj.U0)).intValue());
    }

    public boolean H() {
        return getBooleanFromAdObject("playback_requires_user_action", Boolean.TRUE);
    }

    public String I() {
        return getStringFromFullResponse("event_id", null);
    }

    public List J() {
        List listK = K();
        if (listK == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listK.size());
        Iterator it = listK.iterator();
        while (it.hasNext()) {
            arrayList.add(a(((Integer) it.next()).intValue()));
        }
        return arrayList;
    }

    public List L() {
        return getIntegerListFromAdObject(KrzujOtzIk.WhsWk, null);
    }

    public Uri M() {
        String stringFromAdObject = getStringFromAdObject("mute_image", "https://assets.applovin.com/sound_off.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public String N() {
        return getStringFromAdObject("nia_button_title", "");
    }

    public String O() {
        return getStringFromAdObject("nia_message", "");
    }

    public String P() {
        return getStringFromAdObject("nia_title", "");
    }

    public Map R() {
        HashMap map = new HashMap();
        try {
            tl tlVar = this.synchronizedAdObject;
            map.putAll(tlVar != null ? (Map) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.o
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.m((tl) obj);
                }
            }) : JsonUtils.toStringMap(getJsonObjectFromAdObject(pnxuebdT.UegSnUNFNSau, new JSONObject())));
        } catch (JSONException e3) {
            this.sdk.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.sdk.I().a("DirectAd", "Failed to retrieve http headers for postbacks", e3);
            }
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", Boolean.FALSE)) {
            map.put(GraphRequest.USER_AGENT_HEADER, sr.a());
        }
        return map;
    }

    public EnumC0122b S() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0122b.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0122b.DO_NOT_DISMISS;
            }
        }
        return EnumC0122b.UNSPECIFIED;
    }

    public int T() {
        return getColorFromAdObject("postitial_progress_bar_color", -922746881);
    }

    public long U() {
        return getLongFromAdObject("postitial_progress_bar_total_ms", -1L);
    }

    public long V() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1L);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1L;
    }

    public int W() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    public List X() {
        String stringFromAdObject = getStringFromAdObject("required_html_resources", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.EMPTY_LIST;
    }

    public boolean X0() {
        return getBooleanFromAdObject(muQRKXGtpOhe.JjsiqRROBKRzB, Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject(MHoiDDglUlPJC.QViZz, "");
    }

    public d5 x() {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (d5) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.u
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.h((tl) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("custom_tabs_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new d5(jsonObjectFromAdObject);
        }
        return null;
    }

    public List y() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.s
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63225a.i((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List z() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.d0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63214a.j((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, boolean z2, boolean z3, tl tlVar) {
        return yp.a(tlVar.a("click_tracking_urls", new JSONObject()), a(motionEvent, z2, z3), c(motionEvent, z2, z3), R(), V0(), this.sdk);
    }

    public List d() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.z
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63232a.a((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public Bundle e() {
        return this.f63186j;
    }

    public List g() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.q
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63224a.b((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public String h() {
        String stringFromAdObject = getStringFromAdObject("base_url", "/");
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    public List i() {
        return this.f63182f;
    }

    public int k() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.a(sj.T1)).intValue());
    }

    public d l() {
        if (this.f63187k == null) {
            this.f63187k = new d();
        }
        return this.f63187k;
    }

    public int m() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.a(sj.U1)).intValue());
    }

    public e.a n() {
        List listK = K();
        int intFromAdObject = getIntFromAdObject("close_style", (listK == null || listK.size() <= 0) ? -1 : ((Integer) listK.get(0)).intValue());
        return intFromAdObject == -1 ? a(hasVideoUrl()) : a(intFromAdObject);
    }

    public int o() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.a(sj.V1)).intValue());
    }

    public long p() {
        List listL = L();
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", (listL == null || listL.size() <= 0) ? 0L : ((Integer) listL.get(0)).intValue());
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0L;
        }
        return longFromAdObject;
    }

    public int q() {
        return getColorFromAdObject("countdown_color", -922746881);
    }

    public int r() {
        return getIntFromAdObject("countdown_length", 0);
    }

    public Bundle s() {
        Map map;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            map = (Map) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.l
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63221a.c((tl) obj);
                }
            });
        } else {
            try {
                map = JsonUtils.toStringMap(getJsonObjectFromAdObject("custom_tabs_http_headers", new JSONObject()));
            } catch (JSONException e3) {
                this.sdk.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.sdk.I().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e3);
                }
                map = new HashMap();
            }
        }
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        if (getBooleanFromAdObject("custom_tabs_should_use_webview_ua", Boolean.FALSE)) {
            bundle.putString(GraphRequest.USER_AGENT_HEADER, sr.a());
        }
        return bundle;
    }

    public List t() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.f
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63216a.d((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List u() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.i
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63218a.e((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List v() {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.e0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63215a.f((tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    private String c(MotionEvent motionEvent, boolean z2, boolean z3) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", null);
        Map mapA = a(motionEvent, z2, z3);
        if (stringFromAdObject != null) {
            return StringUtils.replace(stringFromAdObject, mapA);
        }
        return null;
    }

    public void b(boolean z2) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.a("html_resources_cached", z2);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putBoolean(this.adObject, "html_resources_cached", z2);
        }
    }

    public void c(Uri uri) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b("unmute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "unmute_image", uri.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List a(Function function, tl tlVar) {
        return (List) function.apply(tlVar.a("omid_verification_script_resources", (JSONArray) null));
    }

    public List d(MotionEvent motionEvent, boolean z2, boolean z3) {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_click_attribution_urls", Collections.EMPTY_LIST);
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        Map mapA = a(motionEvent, z2, z3);
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(StringUtils.replace(it.next(), mapA));
        }
        return arrayList;
    }

    public List b(final MotionEvent motionEvent, final boolean z2, final boolean z3) {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.v
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63227a.a(motionEvent, z2, z3, (tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("click_tracking_urls", new JSONObject()), a(motionEvent, z2, z3), c(motionEvent, z2, z3), R(), V0(), this.sdk);
        }
        return listA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, boolean z2, tl tlVar) {
        return yp.a(tlVar.a("video_click_tracking_urls", new JSONObject()), a(motionEvent, true, z2), null, R(), V0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, tl tlVar) {
        JsonUtils.putString(tlVar.a("video_button_properties", (JSONObject) null), "video_button_html", str);
    }

    public void c() {
        this.f63184h.set(true);
    }

    public void a(eh ehVar) {
        this.f63185i.set(ehVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            try {
                URL url = new URL(JsonUtils.getString(jSONObject, "url", null));
                String string = JsonUtils.getString(jSONObject, "vendor_key", null);
                String string2 = JsonUtils.getString(jSONObject, "parameters", null);
                if (StringUtils.isValidString(string) && StringUtils.isValidString(string2)) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                }
            } catch (Throwable th) {
                this.sdk.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.sdk.I().a("DirectAd", "Failed to parse OMID verification script resource", th);
                }
            }
        }
        return arrayList;
    }

    public void b(Uri uri) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.b("mute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "mute_image", uri.toString());
        }
    }

    public void a(Uri uri) {
        this.f63182f.add(uri);
    }

    public void a(final String str) {
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            tlVar.a(new Consumer() { // from class: com.applovin.impl.sdk.ad.h
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    b.a(str, (tl) obj);
                }
            });
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", str);
        }
    }

    public List a(final MotionEvent motionEvent, final boolean z2) {
        List listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            listA = (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.ad.b0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f63208a.a(motionEvent, z2, (tl) obj);
                }
            });
        } else {
            synchronized (this.adObjectLock) {
                listA = yp.a(getJsonObjectFromAdObject("video_click_tracking_urls", new JSONObject()), a(motionEvent, true, z2), null, R(), V0(), this.sdk);
            }
        }
        return listA.isEmpty() ? b(motionEvent, true, z2) : listA;
    }

    private Map a(MotionEvent motionEvent, boolean z2, boolean z3) {
        Point pointB = z3.b(com.applovin.impl.sdk.j.m());
        HashMap map = new HashMap(7);
        map.put("{CLCODE}", getClCode());
        map.put("{CLICK_X}", String.valueOf(motionEvent != null ? motionEvent.getRawX() : -1.0f));
        map.put("{CLICK_Y}", String.valueOf(motionEvent != null ? motionEvent.getRawY() : -1.0f));
        map.put("{SCREEN_WIDTH}", String.valueOf(pointB.x));
        map.put("{SCREEN_HEIGHT}", String.valueOf(pointB.y));
        map.put("{IS_VIDEO_CLICK}", String.valueOf(z2));
        map.put("{IS_INSTALL}", String.valueOf(z3));
        return map;
    }

    private e.a a(boolean z2) {
        return z2 ? e.a.WHITE_ON_TRANSPARENT : e.a.WHITE_ON_BLACK;
    }

    protected e.a a(int i3) {
        if (i3 == 1) {
            return e.a.WHITE_ON_TRANSPARENT;
        }
        if (i3 == 2) {
            return e.a.INVISIBLE;
        }
        if (i3 == 3) {
            return e.a.TRANSPARENT_SKIP;
        }
        return e.a.WHITE_ON_BLACK;
    }
}
