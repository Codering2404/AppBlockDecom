package com.applovin.impl;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f64251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f64252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final uj f64227c = new uj("com.applovin.sdk.impl.isFirstRun", String.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final uj f64228d = new uj("com.applovin.sdk.launched_before", Boolean.class);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final uj f64229e = new uj("com.applovin.sdk.latest_installed_version", String.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final uj f64230f = new uj("com.applovin.sdk.install_date", Long.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final uj f64231g = new uj("com.applovin.sdk.user_id", String.class);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final uj f64232h = new uj("com.applovin.sdk.compass_id", String.class);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final uj f64233i = new uj("com.applovin.sdk.compass_random_token", String.class);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final uj f64234j = new uj("com.applovin.sdk.applovin_random_token", String.class);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final uj f64235k = new uj("com.applovin.sdk.device_test_group", String.class);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final uj f64236l = new uj("com.applovin.sdk.compliance.has_user_consent", Boolean.class);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final uj f64237m = new uj("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final uj f64238n = new uj("com.applovin.sdk.compliance.is_do_not_sell", Boolean.class);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final uj f64239o = new uj("com.applovin.sdk.has_seen_but_not_accepted_privacy_policy", Boolean.class);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final uj f64240p = new uj("IABTCF_CmpSdkID", Object.class);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final uj f64241q = new uj("IABTCF_CmpSdkVersion", Object.class);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final uj f64242r = new uj("IABTCF_gdprApplies", Object.class);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final uj f64243s = new uj("IABTCF_TCString", String.class);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final uj f64244t = new uj("IABTCF_AddtlConsent", String.class);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final uj f64245u = new uj("IABTCF_VendorConsents", String.class);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final uj f64246v = new uj("IABTCF_VendorLegitimateInterests", String.class);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final uj f64247w = new uj("IABTCF_PurposeConsents", String.class);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final uj f64248x = new uj("IABTCF_PurposeLegitimateInterests", String.class);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final uj f64249y = new uj("IABTCF_SpecialFeaturesOptIns", String.class);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final uj f64250z = new uj("com.applovin.sdk.stats", String.class);
    public static final uj A = new uj("com.applovin.sdk.task.stats", HashSet.class);
    public static final uj B = new uj("com.applovin.sdk.network_response_code_mapping", String.class);
    public static final uj C = new uj("com.applovin.sdk.impl.ad.persistence.queue", String.class);
    public static final uj D = new uj("com.applovin.sdk.last_video_position", Integer.class);
    public static final uj E = new uj("com.applovin.sdk.should_resume_video", Boolean.class);
    public static final uj F = new uj("com.applovin.sdk.mediation.signal_providers", String.class);
    public static final uj G = new uj("com.applovin.sdk.mediation.auto_init_adapters", String.class);
    public static final uj H = new uj("com.applovin.sdk.persisted_data", String.class);
    public static final uj I = new uj("com.applovin.sdk.mediation_provider", String.class);
    public static final uj J = new uj("com.applovin.sdk.mediation.test_mode_enabled", Boolean.class);
    public static final uj K = new uj("com.applovin.sdk.user_agent", String.class);
    public static final uj L = new uj("com.applovin.sdk.last_os_version_user_agent_collected_for", String.class);
    public static final uj M = new uj("com.applovin.sdk.last_fullscreen_ad_timestamp_ms", Long.class);
    public static final uj N = new uj("com.applovin.sdk.last_fullscreen_ad_duration_ms", Long.class);
    public static final uj O = new uj("com.applovin.sdk.app_killed_urls_from_last_ad", String.class);
    public static final uj P = new uj("com.applovin.sdk.app_killed_last_ad_data", String.class);

    public uj(String str, Class cls) {
        this.f64251a = str;
        this.f64252b = cls;
    }

    public String a() {
        return this.f64251a;
    }

    public Class b() {
        return this.f64252b;
    }

    public String toString() {
        return "Key{name='" + this.f64251a + "', type=" + this.f64252b + '}';
    }
}
