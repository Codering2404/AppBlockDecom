package com.applovin.impl;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ba {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f58604b = new HashSet(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set f58605c = new HashSet(16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ba f58606d = a("ad_req");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ba f58607e = a("ad_imp");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ba f58608f = a("max_ad_imp");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ba f58609g = a("ad_session_start");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ba f58610h = a("ad_imp_session");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ba f58611i = a("max_ad_imp_session");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ba f58612j = a("cached_files_expired");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ba f58613k = a("cache_drop_count");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ba f58614l = a("sdk_reset_state_count", true);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ba f58615m = a("ad_response_process_failures", true);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ba f58616n = a("response_process_failures", true);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ba f58617o = a("incent_failed_to_display_count", true);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ba f58618p = a("app_paused_and_resumed");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ba f58619q = a("ad_rendered_with_mismatched_sdk_key", true);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ba f58620r = a("ad_shown_outside_app_count");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ba f58621s = a("med_ad_req");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ba f58622t = a("med_ad_response_process_failures", true);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ba f58623u = a("med_waterfall_ad_no_fill", true);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ba f58624v = a("med_waterfall_ad_adapter_load_failed", true);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ba f58625w = a("med_waterfall_ad_invalid_response", true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f58626a;

    static {
        a("fullscreen_ad_nil_vc_count");
        a("applovin_bundle_missing");
    }

    private ba(String str) {
        this.f58626a = str;
    }

    private static ba a(String str) {
        return a(str, false);
    }

    public String b() {
        return this.f58626a;
    }

    private static ba a(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        }
        Set set = f58604b;
        if (set.contains(str)) {
            throw new IllegalArgumentException("Key has already been used: " + str);
        }
        set.add(str);
        ba baVar = new ba(str);
        if (z2) {
            f58605c.add(baVar);
        }
        return baVar;
    }

    public static Set a() {
        return f58605c;
    }
}
