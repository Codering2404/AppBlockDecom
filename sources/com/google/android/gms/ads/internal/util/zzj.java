package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.legacy.content.Werj.QgXempTBEfV;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbkh;
import com.google.android.gms.internal.ads.zzbki;
import com.google.android.gms.internal.ads.zzcey;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzhcg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj implements zzg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f70334b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ListenableFuture f70336d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedPreferences f70338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SharedPreferences.Editor f70339g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f70341i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f70342j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f70333a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f70335c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzbfq f70337e = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f70340h = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f70343k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f70344l = "-1";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f70345m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private zzcey f70346n = new zzcey("", 0);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f70347o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f70348p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f70349q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f70350r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Set f70351s = Collections.EMPTY_SET;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private JSONObject f70352t = new JSONObject();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f70353u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f70354v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f70355w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f70356x = "";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f70357y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f70358z = "";
    private String A = JsonUtils.EMPTY_JSON;
    private int B = -1;
    private int C = -1;
    private long D = 0;
    private boolean E = false;
    private int F = 0;
    private int G = 0;

    private final void p() {
        ListenableFuture listenableFuture = this.f70336d;
        if (listenableFuture == null || listenableFuture.isDone()) {
            return;
        }
        try {
            this.f70336d.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Interrupted while waiting for preferences loaded.", e3);
        } catch (CancellationException e4) {
            e = e4;
            int i4 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e5) {
            e = e5;
            int i42 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e6) {
            e = e6;
            int i422 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final void q() {
        zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f70329a.n();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void a(int i3) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.F == i3) {
                    return;
                }
                this.F = i3;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putInt("total_inflight_ad_limit", i3);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void c(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzko)).booleanValue()) {
            p();
            synchronized (this.f70333a) {
                try {
                    if (this.f70356x.equals(str)) {
                        return;
                    }
                    this.f70356x = str;
                    SharedPreferences.Editor editor = this.f70339g;
                    if (editor != null) {
                        editor.putString("inspector_info", str);
                        this.f70339g.apply();
                    }
                    q();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void d(int i3) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.G == i3) {
                    return;
                }
                this.G = i3;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putInt("default_queue_capacity", i3);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void e(boolean z2) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.E) {
                    return;
                }
                this.E = true;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putBoolean("is_install_referrer_reported", true);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void f(long j3) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.D == j3) {
                    return;
                }
                this.D = j3;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j3);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void g(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue()) {
            p();
            synchronized (this.f70333a) {
                try {
                    if (this.f70358z.equals(str)) {
                        return;
                    }
                    this.f70358z = str;
                    SharedPreferences.Editor editor = this.f70339g;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.f70339g.apply();
                    }
                    q();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void h(int i3) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.C == i3) {
                    return;
                }
                this.C = i3;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i3);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void i(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkR)).booleanValue()) {
            p();
            synchronized (this.f70333a) {
                try {
                    if (this.A.equals(str)) {
                        return;
                    }
                    this.A = str;
                    SharedPreferences.Editor editor = this.f70339g;
                    if (editor != null) {
                        editor.putString("inspector_ui_storage", str);
                        this.f70339g.apply();
                    }
                    q();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void j(int i3) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.f70349q == i3) {
                    return;
                }
                this.f70349q = i3;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i3);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        r3 = new org.json.JSONObject();
        r3.put("template_id", r9);
        r3.put("uses_media_view", r10);
        r3.put("timestamp_ms", com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        r1.put(r2, r3);
        r7.f70352t.put(r8, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        r10 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.g("Could not update native advanced settings", r8);
     */
    @Override // com.google.android.gms.ads.internal.util.zzg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r7 = this;
            r7.p()
            java.lang.Object r0 = r7.f70333a
            monitor-enter(r0)
            org.json.JSONObject r1 = r7.f70352t     // Catch: java.lang.Throwable -> L14
            org.json.JSONArray r1 = r1.optJSONArray(r8)     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L17
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L17
        L14:
            r8 = move-exception
            goto L8e
        L17:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L14
            r3 = 0
            r4 = r3
        L1d:
            int r5 = r1.length()     // Catch: java.lang.Throwable -> L14
            if (r4 >= r5) goto L48
            org.json.JSONObject r5 = r1.optJSONObject(r4)     // Catch: java.lang.Throwable -> L14
            if (r5 != 0) goto L2b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L2b:
            java.lang.String r6 = "template_id"
            java.lang.String r6 = r5.optString(r6)     // Catch: java.lang.Throwable -> L14
            boolean r6 = r9.equals(r6)     // Catch: java.lang.Throwable -> L14
            if (r6 == 0) goto L45
            if (r10 == 0) goto L43
            java.lang.String r2 = "uses_media_view"
            boolean r2 = r5.optBoolean(r2, r3)     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L43
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L43:
            r2 = r4
            goto L48
        L45:
            int r4 = r4 + 1
            goto L1d
        L48:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            r3.<init>()     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            java.lang.String r4 = "template_id"
            r3.put(r4, r9)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            java.lang.String r9 = "uses_media_view"
            r3.put(r9, r10)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            java.lang.String r9 = "timestamp_ms"
            com.google.android.gms.common.util.Clock r10 = com.google.android.gms.ads.internal.zzt.o()     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            long r4 = r10.currentTimeMillis()     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            r3.put(r9, r4)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            org.json.JSONObject r9 = r7.f70352t     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            r9.put(r8, r1)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            goto L75
        L6d:
            r8 = move-exception
            java.lang.String r9 = "Could not update native advanced settings"
            int r10 = com.google.android.gms.ads.internal.util.zze.f70328b     // Catch: java.lang.Throwable -> L14
            com.google.android.gms.ads.internal.util.client.zzo.g(r9, r8)     // Catch: java.lang.Throwable -> L14
        L75:
            android.content.SharedPreferences$Editor r8 = r7.f70339g     // Catch: java.lang.Throwable -> L14
            if (r8 == 0) goto L89
            java.lang.String r9 = "native_advanced_settings"
            org.json.JSONObject r10 = r7.f70352t     // Catch: java.lang.Throwable -> L14
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L14
            r8.putString(r9, r10)     // Catch: java.lang.Throwable -> L14
            android.content.SharedPreferences$Editor r8 = r7.f70339g     // Catch: java.lang.Throwable -> L14
            r8.apply()     // Catch: java.lang.Throwable -> L14
        L89:
            r7.q()     // Catch: java.lang.Throwable -> L14
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L8e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzj.k(java.lang.String, java.lang.String, boolean):void");
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void l(Runnable runnable) {
        this.f70335c.add(runnable);
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void m(long j3) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.f70348p == j3) {
                    return;
                }
                this.f70348p = j3;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j3);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzbfq n() {
        if (!this.f70334b) {
            return null;
        }
        if ((zzc() && zze()) || !((Boolean) zzbkh.zzb.zze()).booleanValue()) {
            return null;
        }
        synchronized (this.f70333a) {
            try {
                if (Looper.getMainLooper() == null) {
                    return null;
                }
                if (this.f70337e == null) {
                    this.f70337e = new zzbfq();
                }
                this.f70337e.zza();
                int i3 = zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.e("start fetching content...");
                return this.f70337e;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ void o(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppLovinMediationProvider.ADMOB, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        try {
            synchronized (this.f70333a) {
                try {
                    this.f70338f = sharedPreferences;
                    this.f70339g = editorEdit;
                    NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
                    this.f70340h = this.f70338f.getBoolean("use_https", this.f70340h);
                    this.f70353u = this.f70338f.getBoolean("content_url_opted_out", this.f70353u);
                    this.f70341i = this.f70338f.getString("content_url_hashes", this.f70341i);
                    this.f70343k = this.f70338f.getBoolean("gad_idless", this.f70343k);
                    this.f70354v = this.f70338f.getBoolean("content_vertical_opted_out", this.f70354v);
                    this.f70342j = this.f70338f.getString("content_vertical_hashes", this.f70342j);
                    this.f70350r = this.f70338f.getInt("version_code", this.f70350r);
                    if (((Boolean) zzbki.zzg.zze()).booleanValue() && com.google.android.gms.ads.internal.client.zzba.c().zzc()) {
                        this.f70346n = new zzcey("", 0L);
                    } else {
                        this.f70346n = new zzcey(this.f70338f.getString("app_settings_json", this.f70346n.zzd()), this.f70338f.getLong("app_settings_last_update_ms", this.f70346n.zzb()));
                    }
                    this.f70347o = this.f70338f.getLong("app_last_background_time_ms", this.f70347o);
                    this.f70349q = this.f70338f.getInt("request_in_session_count", this.f70349q);
                    this.f70348p = this.f70338f.getLong("first_ad_req_time_ms", this.f70348p);
                    this.f70351s = this.f70338f.getStringSet("never_pool_slots", this.f70351s);
                    this.f70355w = this.f70338f.getString("display_cutout", this.f70355w);
                    this.B = this.f70338f.getInt("app_measurement_npa", this.B);
                    this.C = this.f70338f.getInt("sd_app_measure_npa", this.C);
                    this.D = this.f70338f.getLong("sd_app_measure_npa_ts", this.D);
                    this.f70356x = this.f70338f.getString("inspector_info", this.f70356x);
                    this.f70357y = this.f70338f.getBoolean("linked_device", this.f70357y);
                    this.f70358z = this.f70338f.getString("linked_ad_unit", this.f70358z);
                    this.A = this.f70338f.getString("inspector_ui_storage", this.A);
                    this.f70344l = this.f70338f.getString("IABTCF_TCString", this.f70344l);
                    this.f70345m = this.f70338f.getInt("gad_has_consent_for_cookies", this.f70345m);
                    this.E = this.f70338f.getBoolean("is_install_referrer_reported", this.E);
                    this.F = this.f70338f.getInt("total_inflight_ad_limit", this.F);
                    this.G = this.f70338f.getInt("default_queue_capacity", this.G);
                    try {
                        this.f70352t = new JSONObject(this.f70338f.getString("native_advanced_settings", JsonUtils.EMPTY_JSON));
                    } catch (JSONException e3) {
                        int i3 = zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.g("Could not convert native advanced settings to json object", e3);
                    }
                    q();
                } finally {
                }
            }
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "AdSharedPreferenceManagerImpl.initializeOnBackgroundThread");
            zze.l("AdSharedPreferenceManagerImpl.initializeOnBackgroundThread, errorMessage = ", th);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzA(String str) {
        p();
        synchronized (this.f70333a) {
            try {
                this.f70344l = str;
                if (this.f70339g != null) {
                    if (str.equals("-1")) {
                        this.f70339g.remove("IABTCF_TCString");
                    } else {
                        this.f70339g.putString("IABTCF_TCString", str);
                    }
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzB() {
        p();
        return this.f70344l;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzD() {
        p();
        return this.f70345m;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zzF() {
        long j3;
        p();
        synchronized (this.f70333a) {
            j3 = this.D;
        }
        return j3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzH() {
        String str;
        p();
        synchronized (this.f70333a) {
            str = this.f70356x;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzJ() {
        boolean z2;
        p();
        synchronized (this.f70333a) {
            z2 = this.f70357y;
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzK(boolean z2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkD)).booleanValue()) {
            p();
            synchronized (this.f70333a) {
                try {
                    if (this.f70357y == z2) {
                        return;
                    }
                    this.f70357y = z2;
                    SharedPreferences.Editor editor = this.f70339g;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z2);
                        this.f70339g.apply();
                    }
                    q();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzL() {
        String str;
        p();
        synchronized (this.f70333a) {
            str = this.f70358z;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzN() {
        String str;
        p();
        synchronized (this.f70333a) {
            str = this.A;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzP() {
        boolean z2;
        p();
        synchronized (this.f70333a) {
            z2 = this.E;
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzR() {
        int i3;
        p();
        synchronized (this.f70333a) {
            i3 = this.F;
        }
        return i3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzT() {
        int i3;
        p();
        synchronized (this.f70333a) {
            i3 = this.G;
        }
        return i3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zza(final Context context) {
        synchronized (this.f70333a) {
            try {
                if (this.f70338f != null) {
                    return;
                }
                zzhcg zzhcgVar = zzcfr.zza;
                final String str = AppLovinMediationProvider.ADMOB;
                this.f70336d = zzhcgVar.submit(new Runnable(context, str) { // from class: com.google.android.gms.ads.internal.util.zzi

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    private final /* synthetic */ Context f70331b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    private final /* synthetic */ String f70332c = AppLovinMediationProvider.ADMOB;

                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f70330a.o(this.f70331b, this.f70332c);
                    }
                });
                this.f70334b = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzb(boolean z2) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.f70353u == z2) {
                    return;
                }
                this.f70353u = z2;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z2);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzc() {
        boolean z2;
        p();
        synchronized (this.f70333a) {
            z2 = this.f70353u;
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzd(boolean z2) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.f70354v == z2) {
                    return;
                }
                this.f70354v = z2;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z2);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zze() {
        boolean z2;
        p();
        synchronized (this.f70333a) {
            z2 = this.f70354v;
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzf(int i3) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.f70350r == i3) {
                    return;
                }
                this.f70350r = i3;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putInt("version_code", i3);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzg() {
        int i3;
        p();
        synchronized (this.f70333a) {
            i3 = this.f70350r;
        }
        return i3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzh(String str) {
        p();
        synchronized (this.f70333a) {
            try {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
                if (str != null && !str.equals(this.f70346n.zzd())) {
                    this.f70346n = new zzcey(str, jCurrentTimeMillis);
                    SharedPreferences.Editor editor = this.f70339g;
                    if (editor != null) {
                        editor.putString("app_settings_json", str);
                        this.f70339g.putLong("app_settings_last_update_ms", jCurrentTimeMillis);
                        this.f70339g.apply();
                    }
                    q();
                    Iterator it = this.f70335c.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    return;
                }
                this.f70346n.zza(jCurrentTimeMillis);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final zzcey zzi() {
        zzcey zzceyVar;
        p();
        synchronized (this.f70333a) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznf)).booleanValue() && this.f70346n.zzj()) {
                    Iterator it = this.f70335c.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                }
                zzceyVar = this.f70346n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzceyVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final zzcey zzj() {
        zzcey zzceyVar;
        synchronized (this.f70333a) {
            zzceyVar = this.f70346n;
        }
        return zzceyVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzl(long j3) {
        p();
        synchronized (this.f70333a) {
            try {
                if (this.f70347o == j3) {
                    return;
                }
                this.f70347o = j3;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", j3);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zzm() {
        long j3;
        p();
        synchronized (this.f70333a) {
            j3 = this.f70347o;
        }
        return j3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzo() {
        int i3;
        p();
        synchronized (this.f70333a) {
            i3 = this.f70349q;
        }
        return i3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zzq() {
        long j3;
        p();
        synchronized (this.f70333a) {
            j3 = this.f70348p;
        }
        return j3;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final JSONObject zzs() {
        JSONObject jSONObject;
        p();
        synchronized (this.f70333a) {
            jSONObject = this.f70352t;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzt() {
        p();
        synchronized (this.f70333a) {
            try {
                this.f70352t = new JSONObject();
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.remove("native_advanced_settings");
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzu() {
        String str;
        p();
        synchronized (this.f70333a) {
            str = this.f70355w;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzv(String str) {
        p();
        synchronized (this.f70333a) {
            try {
                if (TextUtils.equals(this.f70355w, str)) {
                    return;
                }
                this.f70355w = str;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzw(boolean z2) {
        p();
        synchronized (this.f70333a) {
            try {
                if (z2 == this.f70343k) {
                    return;
                }
                this.f70343k = z2;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z2);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzx() {
        boolean z2;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbh)).booleanValue()) {
            return false;
        }
        p();
        synchronized (this.f70333a) {
            z2 = this.f70343k;
        }
        return z2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzy(boolean z2) {
        p();
        synchronized (this.f70333a) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() + ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlS)).longValue();
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    editor.putBoolean("is_topics_ad_personalization_allowed", z2);
                    this.f70339g.putLong("topics_consent_expiry_time_ms", jCurrentTimeMillis);
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzz() {
        p();
        synchronized (this.f70333a) {
            try {
                SharedPreferences sharedPreferences = this.f70338f;
                boolean z2 = false;
                if (sharedPreferences == null) {
                    return false;
                }
                if (sharedPreferences.getLong("topics_consent_expiry_time_ms", 0L) < System.currentTimeMillis()) {
                    return false;
                }
                if (this.f70338f.getBoolean("is_topics_ad_personalization_allowed", false) && !this.f70343k) {
                    z2 = true;
                }
                return z2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void b(int i3) {
        p();
        synchronized (this.f70333a) {
            try {
                this.f70345m = i3;
                SharedPreferences.Editor editor = this.f70339g;
                if (editor != null) {
                    if (i3 == -1) {
                        editor.remove(QgXempTBEfV.wfIHbY);
                    } else {
                        editor.putInt(QgXempTBEfV.wfIHbY, i3);
                    }
                    this.f70339g.apply();
                }
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
