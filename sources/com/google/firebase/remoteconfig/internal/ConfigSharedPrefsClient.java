package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigSharedPrefsClient {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Date f89782f = new Date(-1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Date f89783g = new Date(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f89784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f89785b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f89786c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f89787d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f89788e = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BackoffMetadata {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f89789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Date f89790b;

        BackoffMetadata(int i3, Date date) {
            this.f89789a = i3;
            this.f89790b = date;
        }

        Date a() {
            return this.f89790b;
        }

        int b() {
            return this.f89789a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class RealtimeBackoffMetadata {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f89791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Date f89792b;

        public RealtimeBackoffMetadata(int i3, Date date) {
            this.f89791a = i3;
            this.f89792b = date;
        }

        Date a() {
            return this.f89792b;
        }

        int b() {
            return this.f89791a;
        }
    }

    public ConfigSharedPrefsClient(SharedPreferences sharedPreferences) {
        this.f89784a = sharedPreferences;
    }

    BackoffMetadata a() {
        BackoffMetadata backoffMetadata;
        synchronized (this.f89786c) {
            backoffMetadata = new BackoffMetadata(this.f89784a.getInt("num_failed_fetches", 0), new Date(this.f89784a.getLong("backoff_end_time_in_millis", -1L)));
        }
        return backoffMetadata;
    }

    public Map b() {
        try {
            JSONObject jSONObject = new JSONObject(this.f89784a.getString("customSignals", JsonUtils.EMPTY_JSON));
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public long c() {
        return this.f89784a.getLong("fetch_timeout_in_seconds", 60L);
    }

    String d() {
        return this.f89784a.getString("last_fetch_etag", null);
    }

    Date e() {
        return new Date(this.f89784a.getLong("last_fetch_time_in_millis", -1L));
    }

    long f() {
        return this.f89784a.getLong("last_template_version", 0L);
    }

    public long g() {
        return this.f89784a.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.f89713j);
    }

    public RealtimeBackoffMetadata h() {
        RealtimeBackoffMetadata realtimeBackoffMetadata;
        synchronized (this.f89787d) {
            realtimeBackoffMetadata = new RealtimeBackoffMetadata(this.f89784a.getInt("num_failed_realtime_streams", 0), new Date(this.f89784a.getLong("realtime_backoff_end_time_in_millis", -1L)));
        }
        return realtimeBackoffMetadata;
    }

    void i() {
        k(0, f89783g);
    }

    void j() {
        p(0, f89783g);
    }

    void k(int i3, Date date) {
        synchronized (this.f89786c) {
            this.f89784a.edit().putInt("num_failed_fetches", i3).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public void l(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.f89785b) {
            this.f89784a.edit().putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.a()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.b()).commit();
        }
    }

    void m(String str) {
        synchronized (this.f89785b) {
            this.f89784a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    void n(long j3) {
        synchronized (this.f89785b) {
            this.f89784a.edit().putLong("last_template_version", j3).apply();
        }
    }

    public void o(Date date) {
        synchronized (this.f89787d) {
            this.f89784a.edit().putLong("realtime_backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    void q() {
        synchronized (this.f89785b) {
            this.f89784a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    void r(Date date) {
        synchronized (this.f89785b) {
            this.f89784a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    void s() {
        synchronized (this.f89785b) {
            this.f89784a.edit().putInt("last_fetch_status", 2).apply();
        }
    }

    void p(int i3, Date date) {
        synchronized (this.f89787d) {
            this.f89784a.edit().putInt("num_failed_realtime_streams", i3).putLong(SbbqvQlxi.UdkSyXGCX, date.getTime()).apply();
        }
    }
}
