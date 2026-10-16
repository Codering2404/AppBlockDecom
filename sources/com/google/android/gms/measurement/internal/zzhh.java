package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhh extends zzjf {
    static final Pair A = new Pair("", 0L);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f73809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SharedPreferences f73810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zzhf f73811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zzhe f73812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final zzhe f73813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zzhg f73814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f73815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f73816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f73817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final zzhe f73818l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final zzhc f73819m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final zzhg f73820n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final zzhd f73821o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final zzhc f73822p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final zzhe f73823q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final zzhe f73824r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f73825s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final zzhc f73826t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final zzhc f73827u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final zzhe f73828v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final zzhg f73829w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final zzhg f73830x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final zzhe f73831y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final zzhd f73832z;

    zzhh(zzic zzicVar) {
        super(zzicVar);
        this.f73818l = new zzhe(this, "session_timeout", 1800000L);
        this.f73819m = new zzhc(this, "start_new_session", true);
        this.f73823q = new zzhe(this, "last_pause_time", 0L);
        this.f73824r = new zzhe(this, SDKAnalyticsEvents.PARAMETER_SESSION_ID, 0L);
        this.f73820n = new zzhg(this, "non_personalized_ads", null);
        this.f73821o = new zzhd(this, "last_received_uri_timestamps_by_source", null);
        this.f73822p = new zzhc(this, "allow_remote_dynamite", false);
        this.f73812f = new zzhe(this, "first_open_time", 0L);
        this.f73813g = new zzhe(this, "app_install_time", 0L);
        this.f73814h = new zzhg(this, "app_instance_id", null);
        this.f73826t = new zzhc(this, "app_backgrounded", false);
        this.f73827u = new zzhc(this, "deep_link_retrieval_complete", false);
        this.f73828v = new zzhe(this, "deep_link_retrieval_attempts", 0L);
        this.f73829w = new zzhg(this, "firebase_feature_rollouts", null);
        this.f73830x = new zzhg(this, "deferred_attribution_cache", null);
        this.f73831y = new zzhe(this, "deferred_attribution_cache_timestamp", 0L);
        this.f73832z = new zzhd(this, "default_event_parameters", null);
    }

    final boolean A(long j3) {
        return j3 - this.f73818l.a() > this.f73823q.a();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    protected final boolean i() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    protected final void j() {
        zzic zzicVar = this.f73997a;
        SharedPreferences sharedPreferences = zzicVar.d().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f73809c = sharedPreferences;
        boolean z2 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f73825s = z2;
        if (!z2) {
            SharedPreferences.Editor editorEdit = this.f73809c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        zzicVar.w();
        this.f73811e = new zzhf(this, "health_monitor", Math.max(0L, ((Long) zzfy.f73628d.b(null)).longValue()), null);
    }

    final Pair o(String str) {
        h();
        if (!w().o(zzjk.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        zzic zzicVar = this.f73997a;
        long jA = zzicVar.e().a();
        String str2 = this.f73815i;
        if (str2 != null && jA < this.f73817k) {
            return new Pair(str2, Boolean.valueOf(this.f73816j));
        }
        this.f73817k = jA + zzicVar.w().D(str, zzfy.f73622b);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzicVar.d());
            this.f73815i = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.f73815i = id;
            }
            this.f73816j = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e3) {
            this.f73997a.a().v().b("Unable to get advertising id", e3);
            this.f73815i = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f73815i, Boolean.valueOf(this.f73816j));
    }

    protected final SharedPreferences p() {
        h();
        l();
        Preconditions.m(this.f73809c);
        return this.f73809c;
    }

    protected final SharedPreferences q() {
        h();
        l();
        if (this.f73810d == null) {
            zzic zzicVar = this.f73997a;
            String strValueOf = String.valueOf(zzicVar.d().getPackageName());
            zzgs zzgsVarW = zzicVar.a().w();
            String strConcat = strValueOf.concat("_preferences");
            zzgsVarW.b("Default prefs file", strConcat);
            this.f73810d = zzicVar.d().getSharedPreferences(strConcat, 0);
        }
        return this.f73810d;
    }

    final SparseArray r() {
        Bundle bundleA = this.f73821o.a();
        int[] intArray = bundleA.getIntArray("uriSources");
        long[] longArray = bundleA.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            this.f73997a.a().o().a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = 0; i3 < intArray.length; i3++) {
            sparseArray.put(intArray[i3], Long.valueOf(longArray[i3]));
        }
        return sparseArray;
    }

    final void s(Boolean bool) {
        h();
        SharedPreferences.Editor editorEdit = p().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    final Boolean t() {
        h();
        if (p().contains("measurement_enabled")) {
            return Boolean.valueOf(p().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    final zzaz u() {
        h();
        return zzaz.g(p().getString("dma_consent_settings", null));
    }

    final boolean v(int i3) {
        return zzjl.u(i3, p().getInt("consent_source", 100));
    }

    final zzjl w() {
        h();
        return zzjl.f(p().getString("consent_settings", "G1"), p().getInt("consent_source", 100));
    }

    protected final boolean x(zzod zzodVar) {
        h();
        String string = p().getString("stored_tcf_param", "");
        String strA = zzodVar.a();
        if (strA.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = p().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        return true;
    }

    final void y(boolean z2) {
        h();
        this.f73997a.a().w().b("App measurement setting deferred collection", Boolean.valueOf(z2));
        SharedPreferences.Editor editorEdit = p().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z2);
        editorEdit.apply();
    }

    final boolean z() {
        SharedPreferences sharedPreferences = this.f73809c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }
}
