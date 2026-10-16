package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpr;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzav extends zzos {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f73434f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final String[] f73435g = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f73436h = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f73437i = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", jTYhJgqLBN.Vqp, "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", KLAQHFCRAUejH.mqhRNBztasCu};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f73438j = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f73439k = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f73440l = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f73441m = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String[] f73442n = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String[] f73443o = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String[] f73444p = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzau f73445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzog f73446e;

    zzav(zzpg zzpgVar) {
        super(zzpgVar);
        this.f73446e = new zzog(this.f73997a.e());
        this.f73997a.w();
        this.f73445d = new zzau(this, this.f73997a.d(), "google_app_measurement.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String M(java.lang.String r3, java.lang.String[] r4, java.lang.String r5) {
        /*
            r2 = this;
            android.database.sqlite.SQLiteDatabase r5 = r2.u0()
            r0 = 0
            android.database.Cursor r0 = r5.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            boolean r4 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            if (r4 == 0) goto L18
            r4 = 0
            java.lang.String r3 = r0.getString(r4)     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            r0.close()
            return r3
        L18:
            r0.close()
            java.lang.String r3 = ""
            return r3
        L1e:
            r3 = move-exception
            goto L31
        L20:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzic r5 = r2.f73997a     // Catch: java.lang.Throwable -> L1e
            com.google.android.gms.measurement.internal.zzgu r5 = r5.a()     // Catch: java.lang.Throwable -> L1e
            com.google.android.gms.measurement.internal.zzgs r5 = r5.o()     // Catch: java.lang.Throwable -> L1e
            java.lang.String r1 = "Database error"
            r5.c(r1, r3, r4)     // Catch: java.lang.Throwable -> L1e
            throw r4     // Catch: java.lang.Throwable -> L1e
        L31:
            if (r0 == 0) goto L36
            r0.close()
        L36:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.M(java.lang.String, java.lang.String[], java.lang.String):java.lang.String");
    }

    private final void N(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseU0 = u0();
            if (contentValues.getAsString("app_id") == null) {
                this.f73997a.a().q().b("Value of the primary key is not set.", zzgu.x("app_id"));
                return;
            }
            StringBuilder sb = new StringBuilder(10);
            sb.append("app_id");
            sb.append(" = ?");
            if (sQLiteDatabaseU0.update("consent_settings", contentValues, sb.toString(), new String[]{r2}) == 0 && sQLiteDatabaseU0.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                this.f73997a.a().o().c("Failed to insert/update table (got -1). key", zzgu.x("consent_settings"), zzgu.x("app_id"));
            }
        } catch (SQLiteException e3) {
            this.f73997a.a().o().d("Error storing into table. key", zzgu.x("consent_settings"), zzgu.x("app_id"), e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.measurement.internal.zzbc O(java.lang.String r30, java.lang.String r31, java.lang.String r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.O(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbc");
    }

    private final void P(String str, zzbc zzbcVar) {
        Preconditions.m(zzbcVar);
        h();
        j();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbcVar.f73470a;
        contentValues.put("app_id", str2);
        contentValues.put("name", zzbcVar.f73471b);
        contentValues.put("lifetime_count", Long.valueOf(zzbcVar.f73472c));
        contentValues.put("current_bundle_count", Long.valueOf(zzbcVar.f73473d));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbcVar.f73475f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbcVar.f73476g));
        contentValues.put("last_bundled_day", zzbcVar.f73477h);
        contentValues.put("last_sampled_complex_event_id", zzbcVar.f73478i);
        contentValues.put("last_sampling_rate", zzbcVar.f73479j);
        contentValues.put("current_session_count", Long.valueOf(zzbcVar.f73474e));
        Boolean bool = zzbcVar.f73480k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (u0().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.f73997a.a().o().b("Failed to insert/update event aggregates (got -1). appId", zzgu.x(str2));
            }
        } catch (SQLiteException e3) {
            this.f73997a.a().o().c("Error storing event aggregates. appId", zzgu.x(zzbcVar.f73470a), e3);
        }
    }

    private final void Q(String str, String str2) {
        Preconditions.g(str2);
        h();
        j();
        try {
            u0().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e3) {
            this.f73997a.a().o().c("Error deleting snapshot. appId", zzgu.x(str2), e3);
        }
    }

    private final String S() {
        zzic zzicVar = this.f73997a;
        long jCurrentTimeMillis = zzicVar.e().currentTimeMillis();
        Locale locale = Locale.US;
        zzls zzlsVar = zzls.GOOGLE_SIGNAL;
        Integer numValueOf = Integer.valueOf(zzlsVar.zza());
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        zzicVar.w();
        Long l3 = (Long) zzfy.T.b(null);
        l3.longValue();
        String str = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", numValueOf, lValueOf, l3);
        Integer numValueOf2 = Integer.valueOf(zzlsVar.zza());
        zzicVar.w();
        String str2 = String.format(locale, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", numValueOf2, lValueOf, Long.valueOf(zzal.q()));
        StringBuilder sb = new StringBuilder(str.length() + 5 + str2.length() + 1);
        sb.append("(");
        sb.append(str);
        sb.append(" OR ");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }

    private static final String T(List list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    static final void o0(ContentValues contentValues, String str, Object obj) {
        Preconditions.g("value");
        Preconditions.m(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    private final long p0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = u0().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j3 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j3;
            } catch (SQLiteException e3) {
                this.f73997a.a().o().c("Database error", str, e3);
                throw e3;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long q0(String str, String[] strArr, long j3) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = u0().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j3 = cursorRawQuery.getLong(0);
                }
                cursorRawQuery.close();
                return j3;
            } catch (SQLiteException e3) {
                this.f73997a.a().o().c("Database error", str, e3);
                throw e3;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long A() {
        return q0("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean A0(zzpn zzpnVar) {
        Preconditions.m(zzpnVar);
        h();
        j();
        String str = zzpnVar.f74484a;
        String str2 = zzpnVar.f74486c;
        if (B0(str, str2) == null) {
            if (zzpp.r0(str2)) {
                if (p0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.f73997a.w().F(str, zzfy.W, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long jP0 = p0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, zzpnVar.f74485b});
                this.f73997a.w();
                if (jP0 >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzpnVar.f74485b);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzpnVar.f74487d));
        o0(contentValues, "value", zzpnVar.f74488e);
        try {
            if (u0().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            this.f73997a.a().o().b("Failed to insert/update user property (got -1). appId", zzgu.x(str));
            return true;
        } catch (SQLiteException e3) {
            this.f73997a.a().o().c("Error storing user property. appId", zzgu.x(zzpnVar.f74484a), e3);
            return true;
        }
    }

    public final boolean B() {
        return p0("select count(1) > 0 from raw_events", null) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzpn B0(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.g(r11)
            com.google.android.gms.common.internal.Preconditions.g(r12)
            r10.h()
            r10.j()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.u0()     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L79
            java.lang.String r3 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L79
            java.lang.String r5 = "app_id=? and name=?"
            java.lang.String[] r6 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L79
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L79
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            if (r0 != 0) goto L32
            goto L99
        L32:
            r0 = 0
            long r7 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            r0 = 1
            java.lang.Object r9 = r10.x(r2, r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            if (r9 != 0) goto L40
            goto L99
        L40:
            r0 = 2
            java.lang.String r5 = r2.getString(r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            com.google.android.gms.measurement.internal.zzpn r3 = new com.google.android.gms.measurement.internal.zzpn     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            boolean r11 = r2.moveToNext()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            if (r11 == 0) goto L6c
            com.google.android.gms.measurement.internal.zzic r11 = r10.f73997a     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            com.google.android.gms.measurement.internal.zzgu r11 = r11.a()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            com.google.android.gms.measurement.internal.zzgs r11 = r11.o()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            java.lang.String r12 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzgu.x(r4)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            r11.b(r12, r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            goto L6c
        L66:
            r0 = move-exception
            r11 = r0
            goto L74
        L69:
            r0 = move-exception
        L6a:
            r11 = r0
            goto L7e
        L6c:
            r2.close()
            return r3
        L70:
            r0 = move-exception
            r4 = r11
            r6 = r12
            goto L6a
        L74:
            r1 = r2
            goto L9f
        L76:
            r0 = move-exception
            r11 = r0
            goto L9f
        L79:
            r0 = move-exception
            r4 = r11
            r6 = r12
            r11 = r0
            r2 = r1
        L7e:
            com.google.android.gms.measurement.internal.zzic r12 = r10.f73997a     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.measurement.internal.zzgu r0 = r12.a()     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.measurement.internal.zzgs r0 = r0.o()     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgu.x(r4)     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.measurement.internal.zzgn r12 = r12.D()     // Catch: java.lang.Throwable -> L66
            java.lang.String r12 = r12.c(r6)     // Catch: java.lang.Throwable -> L66
            r0.d(r3, r4, r12, r11)     // Catch: java.lang.Throwable -> L66
        L99:
            if (r2 == 0) goto L9e
            r2.close()
        L9e:
            return r1
        L9f:
            if (r1 == 0) goto La4
            r1.close()
        La4:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.B0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzpn");
    }

    public final boolean C(String str, String str2) {
        return p0("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final List C0(String str) {
        String str2;
        Preconditions.g(str);
        h();
        j();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                zzic zzicVar = this.f73997a;
                zzicVar.w();
                cursorQuery = u0().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                try {
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            if (string2 == null) {
                                string2 = "";
                            }
                            String str3 = string2;
                            long j3 = cursorQuery.getLong(2);
                            Object objX = x(cursorQuery, 3);
                            if (objX == null) {
                                zzicVar.a().o().b("Read invalid user property value, ignoring it. appId", zzgu.x(str));
                                str2 = str;
                            } else {
                                str2 = str;
                                try {
                                    arrayList.add(new zzpn(str2, str3, string, j3, objX));
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    this.f73997a.a().o().c("Error querying user properties. appId", zzgu.x(str2), e);
                                    arrayList = Collections.EMPTY_LIST;
                                }
                            }
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            str = str2;
                        }
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    str2 = str;
                }
            } catch (SQLiteException e5) {
                e = e5;
                str2 = str;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } finally {
        }
    }

    public final boolean D() {
        return p0("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        r0 = r8.a().o();
        r8.w();
        r0.b("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List D0(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.D0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final long E(String str) {
        Preconditions.g(str);
        return q0("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean E0(zzah zzahVar) {
        Preconditions.m(zzahVar);
        h();
        j();
        String str = zzahVar.f73386a;
        Preconditions.m(str);
        if (B0(str, zzahVar.f73388c.f74478b) == null) {
            long jP0 = p0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.f73997a.w();
            if (jP0 >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzahVar.f73387b);
        contentValues.put("name", zzahVar.f73388c.f74478b);
        o0(contentValues, "value", Preconditions.m(zzahVar.f73388c.zza()));
        contentValues.put("active", Boolean.valueOf(zzahVar.f73390f));
        contentValues.put("trigger_event_name", zzahVar.f73391g);
        contentValues.put("trigger_timeout", Long.valueOf(zzahVar.f73393i));
        zzic zzicVar = this.f73997a;
        contentValues.put("timed_out_event", zzicVar.C().T(zzahVar.f73392h));
        contentValues.put("creation_timestamp", Long.valueOf(zzahVar.f73389d));
        contentValues.put("triggered_event", zzicVar.C().T(zzahVar.f73394j));
        contentValues.put("triggered_timestamp", Long.valueOf(zzahVar.f73388c.f74479c));
        contentValues.put("time_to_live", Long.valueOf(zzahVar.f73395k));
        contentValues.put("expired_event", zzicVar.C().T(zzahVar.f73396l));
        try {
            if (u0().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzicVar.a().o().b("Failed to insert/update conditional user property (got -1)", zzgu.x(str));
            return true;
        } catch (SQLiteException e3) {
            this.f73997a.a().o().c("Error storing conditional user property", zzgu.x(str), e3);
            return true;
        }
    }

    public final boolean F(String str, Long l3, long j3, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        h();
        j();
        Preconditions.m(zzhsVar);
        Preconditions.g(str);
        Preconditions.m(l3);
        zzic zzicVar = this.f73997a;
        byte[] bArrZzcc = zzhsVar.zzcc();
        zzicVar.a().w().c("Saving complex main event, appId, data size", zzicVar.D().a(str), Integer.valueOf(bArrZzcc.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l3);
        contentValues.put("children_to_process", Long.valueOf(j3));
        contentValues.put("main_event", bArrZzcc);
        try {
            if (u0().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzicVar.a().o().b("Failed to insert complex main event (got -1). appId", zzgu.x(str));
            return false;
        } catch (SQLiteException e3) {
            this.f73997a.a().o().c("Error storing complex main event. appId", zzgu.x(str), e3);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00f6: MOVE (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]) (LINE:247), block:B:29:0x00f6 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzah F0(java.lang.String r26, java.lang.String r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.F0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzah");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:107), block:B:19:0x006a */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle G(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r5.h()
            r5.j()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.u0()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r6}     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            if (r2 != 0) goto L2f
            com.google.android.gms.measurement.internal.zzic r6 = r5.f73997a     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            com.google.android.gms.measurement.internal.zzgu r6 = r6.a()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            com.google.android.gms.measurement.internal.zzgs r6 = r6.w()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            java.lang.String r2 = "Default event parameters not found"
            r6.a(r2)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            goto L7f
        L2b:
            r6 = move-exception
            goto L6a
        L2d:
            r6 = move-exception
            goto L70
        L2f:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            com.google.android.gms.internal.measurement.zzhr r3 = com.google.android.gms.internal.measurement.zzhs.zzk()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            com.google.android.gms.internal.measurement.zznl r2 = com.google.android.gms.measurement.internal.zzpk.W(r3, r2)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            com.google.android.gms.internal.measurement.zzhr r2 = (com.google.android.gms.internal.measurement.zzhr) r2     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            com.google.android.gms.internal.measurement.zzmf r2 = r2.zzbc()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            com.google.android.gms.internal.measurement.zzhs r2 = (com.google.android.gms.internal.measurement.zzhs) r2     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            com.google.android.gms.measurement.internal.zzpg r6 = r5.f74388b     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            r6.K0()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            java.util.List r6 = r2.zza()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zzpk.q(r6)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            r1.close()
            return r6
        L55:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzic r3 = r5.f73997a     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            com.google.android.gms.measurement.internal.zzgu r3 = r3.a()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            com.google.android.gms.measurement.internal.zzgs r3 = r3.o()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgu.x(r6)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            r3.c(r4, r6, r2)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            goto L7f
        L6a:
            r0 = r1
            goto L85
        L6c:
            r6 = move-exception
            goto L85
        L6e:
            r6 = move-exception
            r1 = r0
        L70:
            com.google.android.gms.measurement.internal.zzic r2 = r5.f73997a     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.measurement.internal.zzgu r2 = r2.a()     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.measurement.internal.zzgs r2 = r2.o()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r6)     // Catch: java.lang.Throwable -> L2b
        L7f:
            if (r1 == 0) goto L84
            r1.close()
        L84:
            return r0
        L85:
            if (r0 == 0) goto L8a
            r0.close()
        L8a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.G(java.lang.String):android.os.Bundle");
    }

    public final int G0(String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        h();
        j();
        try {
            return u0().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e3) {
            zzic zzicVar = this.f73997a;
            zzicVar.a().o().d("Error deleting conditional property", zzgu.x(str), zzicVar.D().c(str2), e3);
            return 0;
        }
    }

    final boolean H(String str, long j3) {
        try {
            if (q0("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j3)}, 0L) > 0) {
                return false;
            }
            return q0("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j3)}, 0L) > 0;
        } catch (SQLiteException e3) {
            this.f73997a.a().o().b("Error checking backfill conditions", e3);
            return false;
        }
    }

    public final List H0(String str, String str2, String str3) {
        Preconditions.g(str);
        h();
        j();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return I0(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x011e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void I(java.lang.String r25, java.lang.Long r26, java.lang.String r27, android.os.Bundle r28) {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.I(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0056, code lost:
    
        r2 = r12.a().o();
        r12.w();
        r2.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List I0(java.lang.String r29, java.lang.String[] r30) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.I0(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzjl J(java.lang.String r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.m(r5)
            r4.h()
            r4.j()
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.lang.String r0 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.u0()     // Catch: java.lang.Throwable -> L46 android.database.sqlite.SQLiteException -> L49
            android.database.Cursor r5 = r2.rawQuery(r0, r5)     // Catch: java.lang.Throwable -> L46 android.database.sqlite.SQLiteException -> L49
            boolean r0 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            if (r0 != 0) goto L35
            com.google.android.gms.measurement.internal.zzic r0 = r4.f73997a     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.measurement.internal.zzgu r0 = r0.a()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.measurement.internal.zzgs r0 = r0.w()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            java.lang.String r2 = "No data found"
            r0.a(r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
        L2d:
            r5.close()
            goto L5e
        L31:
            r0 = move-exception
            goto L44
        L33:
            r0 = move-exception
            goto L4c
        L35:
            r0 = 0
            java.lang.String r0 = r5.getString(r0)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            r2 = 1
            int r2 = r5.getInt(r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.measurement.internal.zzjl r1 = com.google.android.gms.measurement.internal.zzjl.f(r0, r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            goto L2d
        L44:
            r1 = r5
            goto L64
        L46:
            r5 = move-exception
            r0 = r5
            goto L64
        L49:
            r5 = move-exception
            r0 = r5
            r5 = r1
        L4c:
            com.google.android.gms.measurement.internal.zzic r2 = r4.f73997a     // Catch: java.lang.Throwable -> L31
            com.google.android.gms.measurement.internal.zzgu r2 = r2.a()     // Catch: java.lang.Throwable -> L31
            com.google.android.gms.measurement.internal.zzgs r2 = r2.o()     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "Error querying database."
            r2.b(r3, r0)     // Catch: java.lang.Throwable -> L31
            if (r5 == 0) goto L5e
            goto L2d
        L5e:
            if (r1 != 0) goto L63
            com.google.android.gms.measurement.internal.zzjl r5 = com.google.android.gms.measurement.internal.zzjl.f74015c
            return r5
        L63:
            return r1
        L64:
            if (r1 == 0) goto L69
            r1.close()
        L69:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.J(java.lang.String):com.google.android.gms.measurement.internal.zzjl");
    }

    public final boolean K(String str, zzoh zzohVar) {
        h();
        j();
        Preconditions.m(zzohVar);
        Preconditions.g(str);
        zzic zzicVar = this.f73997a;
        long jCurrentTimeMillis = zzicVar.e().currentTimeMillis();
        zzfx zzfxVar = zzfy.f73676w0;
        long jLongValue = jCurrentTimeMillis - ((Long) zzfxVar.b(null)).longValue();
        long j3 = zzohVar.f74382b;
        if (j3 < jLongValue || j3 > ((Long) zzfxVar.b(null)).longValue() + jCurrentTimeMillis) {
            zzicVar.a().r().d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgu.x(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j3));
        }
        zzicVar.a().w().a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzohVar.f74381a);
        contentValues.put("source", Integer.valueOf(zzohVar.f74383c));
        contentValues.put("timestamp_millis", Long.valueOf(j3));
        try {
            if (u0().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzicVar.a().o().b("Failed to insert trigger URI (got -1). appId", zzgu.x(str));
            return false;
        } catch (SQLiteException e3) {
            this.f73997a.a().o().c("Error storing trigger URI. appId", zzgu.x(str), e3);
            return false;
        }
    }

    public final void L(String str, zzjl zzjlVar) {
        Preconditions.m(str);
        Preconditions.m(zzjlVar);
        h();
        j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjlVar.l());
        contentValues.put("consent_source", Integer.valueOf(zzjlVar.b()));
        N("consent_settings", "app_id", contentValues);
    }

    public final zzar L0(long j3, String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        return M0(j3, str, 1L, false, false, z4, false, z6, z7, z8);
    }

    public final zzar M0(long j3, String str, long j4, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        Preconditions.g(str);
        h();
        j();
        String[] strArr = {str};
        zzar zzarVar = new zzar();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseU0 = u0();
                cursorQuery = sQLiteDatabaseU0.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getLong(0) == j3) {
                        zzarVar.f73420b = cursorQuery.getLong(1);
                        zzarVar.f73419a = cursorQuery.getLong(2);
                        zzarVar.f73421c = cursorQuery.getLong(3);
                        zzarVar.f73422d = cursorQuery.getLong(4);
                        zzarVar.f73423e = cursorQuery.getLong(5);
                        zzarVar.f73424f = cursorQuery.getLong(6);
                        zzarVar.f73425g = cursorQuery.getLong(7);
                    }
                    if (z2) {
                        zzarVar.f73420b += j4;
                    }
                    if (z3) {
                        zzarVar.f73419a += j4;
                    }
                    if (z4) {
                        zzarVar.f73421c += j4;
                    }
                    if (z5) {
                        zzarVar.f73422d += j4;
                    }
                    if (z6) {
                        zzarVar.f73423e += j4;
                    }
                    if (z7) {
                        zzarVar.f73424f += j4;
                    }
                    if (z8) {
                        zzarVar.f73425g += j4;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j3));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzarVar.f73419a));
                    contentValues.put("daily_events_count", Long.valueOf(zzarVar.f73420b));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzarVar.f73421c));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzarVar.f73422d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzarVar.f73423e));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzarVar.f73424f));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(zzarVar.f73425g));
                    sQLiteDatabaseU0.update("apps", contentValues, "app_id=?", strArr);
                } else {
                    this.f73997a.a().r().b("Not updating daily counts, app is not known. appId", zzgu.x(str));
                }
            } catch (SQLiteException e3) {
                this.f73997a.a().o().c("Error updating daily counts. appId", zzgu.x(str), e3);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return zzarVar;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzaq N0(java.lang.String r11) throws java.lang.Throwable {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.g(r11)
            r10.h()
            r10.j()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.u0()     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.String r3 = "apps"
            java.lang.String r0 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            if (r0 != 0) goto L2e
            goto L82
        L2e:
            r0 = 0
            byte[] r0 = r2.getBlob(r0)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r3 = 1
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r4 = 2
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            boolean r5 = r2.moveToNext()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            if (r5 == 0) goto L5c
            com.google.android.gms.measurement.internal.zzic r5 = r10.f73997a     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            com.google.android.gms.measurement.internal.zzgu r5 = r5.a()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            com.google.android.gms.measurement.internal.zzgs r5 = r5.o()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgu.x(r11)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r5.b(r6, r7)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            goto L5c
        L57:
            r0 = move-exception
            r11 = r0
            goto L68
        L5a:
            r0 = move-exception
            goto L6f
        L5c:
            if (r0 != 0) goto L5f
            goto L82
        L5f:
            com.google.android.gms.measurement.internal.zzaq r5 = new com.google.android.gms.measurement.internal.zzaq     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r5.<init>(r0, r3, r4)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r2.close()
            return r5
        L68:
            r1 = r2
            goto L88
        L6a:
            r0 = move-exception
            r11 = r0
            goto L88
        L6d:
            r0 = move-exception
            r2 = r1
        L6f:
            com.google.android.gms.measurement.internal.zzic r3 = r10.f73997a     // Catch: java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzgu r3 = r3.a()     // Catch: java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzgs r3 = r3.o()     // Catch: java.lang.Throwable -> L57
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgu.x(r11)     // Catch: java.lang.Throwable -> L57
            r3.c(r4, r11, r0)     // Catch: java.lang.Throwable -> L57
        L82:
            if (r2 == 0) goto L87
            r2.close()
        L87:
            return r1
        L88:
            if (r1 == 0) goto L8d
            r1.close()
        L8d:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.N0(java.lang.String):com.google.android.gms.measurement.internal.zzaq");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean O0(com.google.android.gms.internal.measurement.zzid r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.O0(com.google.android.gms.internal.measurement.zzid, boolean):boolean");
    }

    public final zzaz U(String str) {
        Preconditions.m(str);
        h();
        j();
        return zzaz.g(M("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void V(String str, zzaz zzazVar) {
        Preconditions.m(str);
        Preconditions.m(zzazVar);
        h();
        j();
        zzjl zzjlVarJ = J(str);
        zzjl zzjlVar = zzjl.f74015c;
        if (zzjlVarJ == zzjlVar) {
            L(str, zzjlVar);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzazVar.e());
        N("consent_settings", "app_id", contentValues);
    }

    public final void W(String str, zzjl zzjlVar) {
        Preconditions.m(str);
        Preconditions.m(zzjlVar);
        h();
        j();
        L(str, J(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjlVar.l());
        N("consent_settings", "app_id", contentValues);
    }

    public final zzjl X(String str) {
        Preconditions.m(str);
        h();
        j();
        return zzjl.f(M("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x031c, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x031d, code lost:
    
        r12.put("filter_id", r0);
        r21 = r3;
        r12.put("property_name", r7.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x032f, code lost:
    
        if (r7.zzg() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0331, code lost:
    
        r0 = java.lang.Boolean.valueOf(r7.zzh());
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x033a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x033b, code lost:
    
        r12.put("session_scoped", r0);
        r12.put("data", r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x034d, code lost:
    
        if (u0().insertWithOnConflict("property_filters", null, r12, 5) != (-1)) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x034f, code lost:
    
        r22.f73997a.a().o().b("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzgu.x(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0363, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0365, code lost:
    
        r0 = r19;
        r3 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x036b, code lost:
    
        r22.f73997a.a().o().c("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzgu.x(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x037e, code lost:
    
        j();
        h();
        com.google.android.gms.common.internal.Preconditions.g(r23);
        r0 = u0();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r23, java.lang.String.valueOf(r10)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r23, java.lang.String.valueOf(r10)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x03a1, code lost:
    
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0494, code lost:
    
        r20.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0497, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0176, code lost:
    
        r11 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0182, code lost:
    
        if (r11.hasNext() == false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x018e, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzfn) r11.next()).zza() != false) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0190, code lost:
    
        r22.f73997a.a().r().c("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzgu.x(r23), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01a9, code lost:
    
        r11 = r0.zzf().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01b5, code lost:
    
        r19 = r0;
        r0 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01c3, code lost:
    
        if (r11.hasNext() == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01c5, code lost:
    
        r12 = (com.google.android.gms.internal.measurement.zzff) r11.next();
        j();
        h();
        com.google.android.gms.common.internal.Preconditions.g(r23);
        com.google.android.gms.common.internal.Preconditions.m(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01df, code lost:
    
        if (r12.zzc().isEmpty() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01e1, code lost:
    
        r0 = r22.f73997a.a().r();
        r11 = com.google.android.gms.measurement.internal.zzgu.x(r23);
        r13 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01f9, code lost:
    
        if (r12.zza() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01fb, code lost:
    
        r16 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0206, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0208, code lost:
    
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r11, r13, java.lang.String.valueOf(r16));
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0213, code lost:
    
        r3 = r12.zzcc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0217, code lost:
    
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0219, code lost:
    
        r7 = new android.content.ContentValues();
        r7.put("app_id", r23);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x022c, code lost:
    
        if (r12.zza() == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x022e, code lost:
    
        r0 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0237, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x023a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x023b, code lost:
    
        r7.put("filter_id", r0);
        r7.put("event_name", r12.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x024b, code lost:
    
        if (r12.zzk() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x024d, code lost:
    
        r0 = java.lang.Boolean.valueOf(r12.zzm());
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0256, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0257, code lost:
    
        r7.put("session_scoped", r0);
        r7.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0269, code lost:
    
        if (u0().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x026b, code lost:
    
        r22.f73997a.a().o().b("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzgu.x(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x027e, code lost:
    
        r0 = r19;
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0286, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0287, code lost:
    
        r22.f73997a.a().o().c("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzgu.x(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x029c, code lost:
    
        r20 = r7;
        r3 = r19.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02aa, code lost:
    
        if (r3.hasNext() == false) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02ac, code lost:
    
        r7 = (com.google.android.gms.internal.measurement.zzfn) r3.next();
        j();
        h();
        com.google.android.gms.common.internal.Preconditions.g(r23);
        com.google.android.gms.common.internal.Preconditions.m(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02c6, code lost:
    
        if (r7.zzc().isEmpty() == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02c8, code lost:
    
        r0 = r22.f73997a.a().r();
        r9 = com.google.android.gms.measurement.internal.zzgu.x(r23);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02e0, code lost:
    
        if (r7.zza() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02e2, code lost:
    
        r16 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02ed, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02ef, code lost:
    
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02f8, code lost:
    
        r11 = r7.zzcc();
        r12 = new android.content.ContentValues();
        r12.put(r0, r23);
        r19 = r0;
        r12.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0311, code lost:
    
        if (r7.zza() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0313, code lost:
    
        r0 = java.lang.Integer.valueOf(r7.zzb());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void Y(java.lang.String r23, java.util.List r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1176
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.Y(java.lang.String, java.util.List):void");
    }

    final zzbc Z(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar, String str2) throws Throwable {
        zzbc zzbcVarO = O("events", str, zzhsVar.zzd());
        if (zzbcVarO == null) {
            zzic zzicVar = this.f73997a;
            zzicVar.a().r().c("Event aggregate wasn't created during raw event logging. appId, event", zzgu.x(str), zzicVar.D().a(str2));
            return new zzbc(str, zzhsVar.zzd(), 1L, 1L, 1L, zzhsVar.zzf(), 0L, null, null, null, null);
        }
        long j3 = zzbcVarO.f73474e + 1;
        long j4 = zzbcVarO.f73473d + 1;
        return new zzbc(zzbcVarO.f73470a, zzbcVarO.f73471b, zzbcVarO.f73472c + 1, j4, j3, zzbcVarO.f73475f, zzbcVarO.f73476g, zzbcVarO.f73477h, zzbcVarO.f73478i, zzbcVarO.f73479j, zzbcVarO.f73480k);
    }

    protected final boolean a0() {
        zzic zzicVar = this.f73997a;
        Context contextD = zzicVar.d();
        zzicVar.w();
        return contextD.getDatabasePath("google_app_measurement.db").exists();
    }

    final /* synthetic */ long b0(String str, String[] strArr, long j3) {
        return q0("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", strArr, -1L);
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean l() {
        return false;
    }

    public final long m(String str, com.google.android.gms.internal.measurement.zzib zzibVar, String str2, Map map, zzls zzlsVar, Long l3) {
        int iDelete;
        h();
        j();
        Preconditions.m(zzibVar);
        Preconditions.g(str);
        h();
        j();
        if (a0()) {
            zzpg zzpgVar = this.f74388b;
            long jA = zzpgVar.L0().f74332f.a();
            zzic zzicVar = this.f73997a;
            long jA2 = zzicVar.e().a();
            long jAbs = Math.abs(jA2 - jA);
            zzicVar.w();
            if (jAbs > zzal.r()) {
                zzpgVar.L0().f74332f.b(jA2);
                h();
                j();
                if (a0() && (iDelete = u0().delete("upload_queue", S(), new String[0])) > 0) {
                    zzicVar.a().w().b("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(iDelete));
                }
                Preconditions.g(str);
                h();
                j();
                try {
                    int iE = zzicVar.w().E(str, zzfy.A);
                    if (iE > 0) {
                        u0().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iE)});
                    }
                } catch (SQLiteException e3) {
                    this.f73997a.a().o().c("Error deleting over the limit queued batches. appId", zzgu.x(str), e3);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] bArrZzcc = zzibVar.zzcc();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrZzcc);
        contentValues.put("upload_uri", str2);
        contentValues.put("upload_headers", String.join("\r\n", arrayList));
        contentValues.put("upload_type", Integer.valueOf(zzlsVar.zza()));
        zzic zzicVar2 = this.f73997a;
        contentValues.put("creation_timestamp", Long.valueOf(zzicVar2.e().currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l3 != null) {
            contentValues.put("associated_row_id", l3);
        }
        try {
            long jInsert = u0().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            zzicVar2.a().o().b("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return -1L;
        } catch (SQLiteException e4) {
            this.f73997a.a().o().c("Error storing MeasurementBatch to upload_queue. appId", str, e4);
            return -1L;
        }
    }

    final /* synthetic */ zzog m0() {
        return this.f73446e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5 A[Catch: all -> 0x0078, SQLiteException -> 0x007a, TryCatch #1 {SQLiteException -> 0x007a, blocks: (B:19:0x0070, B:45:0x00ce, B:47:0x00f5, B:48:0x010a, B:49:0x010e, B:50:0x011e, B:52:0x0124, B:53:0x0137, B:56:0x0151, B:68:0x0178, B:71:0x0180, B:77:0x01a0, B:61:0x0167, B:75:0x0192, B:76:0x019b, B:98:0x0221), top: B:112:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010a A[Catch: all -> 0x0078, SQLiteException -> 0x007a, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x007a, blocks: (B:19:0x0070, B:45:0x00ce, B:47:0x00f5, B:48:0x010a, B:49:0x010e, B:50:0x011e, B:52:0x0124, B:53:0x0137, B:56:0x0151, B:68:0x0178, B:71:0x0180, B:77:0x01a0, B:61:0x0167, B:75:0x0192, B:76:0x019b, B:98:0x0221), top: B:112:0x0070 }] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n0(java.lang.String r20, long r21, long r23, com.google.android.gms.measurement.internal.zzpc r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.n0(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzpc):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List o(java.lang.String r19, com.google.android.gms.measurement.internal.zzoo r20, int r21) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.o(java.lang.String, com.google.android.gms.measurement.internal.zzoo, int):java.util.List");
    }

    public final boolean p(String str) {
        zzls[] zzlsVarArr = {zzls.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlsVarArr[0].zza()));
        String strT = T(arrayList);
        String strS = S();
        StringBuilder sb = new StringBuilder(String.valueOf(strT).length() + 61 + strS.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(strT);
        sb.append(" AND NOT ");
        sb.append(strS);
        return p0(sb.toString(), new String[]{str}) != 0;
    }

    public final void q(Long l3) {
        h();
        j();
        Preconditions.m(l3);
        try {
            if (u0().delete("upload_queue", "rowid=?", new String[]{l3.toString()}) != 1) {
                this.f73997a.a().r().a("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e3) {
            this.f73997a.a().o().b("Failed to delete a MeasurementBatch in a upload_queue table", e3);
            throw e3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String r() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.u0()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L24
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L36
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L1e
        L1c:
            r2 = move-exception
            goto L27
        L1e:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3c
        L22:
            r0 = move-exception
            goto L3c
        L24:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L27:
            com.google.android.gms.measurement.internal.zzic r3 = r6.f73997a     // Catch: java.lang.Throwable -> L1a
            com.google.android.gms.measurement.internal.zzgu r3 = r3.a()     // Catch: java.lang.Throwable -> L1a
            com.google.android.gms.measurement.internal.zzgs r3 = r3.o()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch: java.lang.Throwable -> L1a
        L36:
            if (r0 == 0) goto L3b
            r0.close()
        L3b:
            return r1
        L3c:
            if (r1 == 0) goto L41
            r1.close()
        L41:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.r():java.lang.String");
    }

    public final void r0() {
        j();
        u0().beginTransaction();
    }

    public final boolean s() {
        return p0("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final void s0() {
        j();
        u0().setTransactionSuccessful();
    }

    public final void t(long j3) {
        h();
        j();
        try {
            if (u0().delete("queue", "rowid=?", new String[]{String.valueOf(j3)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e3) {
            this.f73997a.a().o().b("Failed to delete a bundle in a queue table", e3);
            throw e3;
        }
    }

    public final void t0() {
        j();
        u0().endTransaction();
    }

    final void u() {
        h();
        j();
        if (a0()) {
            zzpg zzpgVar = this.f74388b;
            long jA = zzpgVar.L0().f74331e.a();
            zzic zzicVar = this.f73997a;
            long jA2 = zzicVar.e().a();
            long jAbs = Math.abs(jA2 - jA);
            zzicVar.w();
            if (jAbs > zzal.r()) {
                zzpgVar.L0().f74331e.b(jA2);
                h();
                j();
                if (a0()) {
                    SQLiteDatabase sQLiteDatabaseU0 = u0();
                    String strValueOf = String.valueOf(zzicVar.e().currentTimeMillis());
                    zzicVar.w();
                    int iDelete = sQLiteDatabaseU0.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{strValueOf, String.valueOf(zzal.q())});
                    if (iDelete > 0) {
                        zzicVar.a().w().b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    final SQLiteDatabase u0() {
        h();
        try {
            return this.f73445d.getWritableDatabase();
        } catch (SQLiteException e3) {
            this.f73997a.a().r().b("Error opening database", e3);
            throw e3;
        }
    }

    final void v(List list) {
        h();
        j();
        Preconditions.m(list);
        Preconditions.o(list.size());
        if (a0()) {
            String strJoin = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(string.length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (p0(sb2.toString(), null) > 0) {
                this.f73997a.a().r().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseU0 = u0();
                StringBuilder sb3 = new StringBuilder(string.length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseU0.execSQL(sb3.toString());
            } catch (SQLiteException e3) {
                this.f73997a.a().o().b("Error incrementing retry count. error", e3);
            }
        }
    }

    public final zzbc v0(String str, String str2) {
        return O("events", str, str2);
    }

    final void w(Long l3) {
        h();
        j();
        Preconditions.m(l3);
        if (a0()) {
            StringBuilder sb = new StringBuilder(l3.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l3);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (p0(sb.toString(), null) > 0) {
                this.f73997a.a().r().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseU0 = u0();
                long jCurrentTimeMillis = this.f73997a.e().currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(jCurrentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(jCurrentTimeMillis);
                String string = sb2.toString();
                StringBuilder sb3 = new StringBuilder(string.length() + 34 + l3.toString().length() + 29);
                sb3.append("UPDATE upload_queue");
                sb3.append(string);
                sb3.append(" WHERE rowid = ");
                sb3.append(l3);
                sb3.append(" AND retry_count < 2147483647");
                sQLiteDatabaseU0.execSQL(sb3.toString());
            } catch (SQLiteException e3) {
                this.f73997a.a().o().b("Error incrementing retry count. error", e3);
            }
        }
    }

    public final void w0(zzbc zzbcVar) {
        P("events", zzbcVar);
    }

    final Object x(Cursor cursor, int i3) {
        int type = cursor.getType(i3);
        if (type == 0) {
            this.f73997a.a().o().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i3));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i3));
        }
        if (type == 3) {
            return cursor.getString(i3);
        }
        if (type != 4) {
            this.f73997a.a().o().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.f73997a.a().o().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final void x0(String str) {
        zzbc zzbcVarO;
        Q("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = u0().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (zzbcVarO = O("events", str, string)) != null) {
                            P("events_snapshot", zzbcVarO);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e3) {
                this.f73997a.a().o().c("Error creating snapshot. appId", zzgu.x(str), e3);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } finally {
        }
    }

    public final long y() {
        return q0("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y0(java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.y0(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009a A[Catch: all -> 0x0074, SQLiteException -> 0x00ae, TryCatch #0 {all -> 0x0074, blocks: (B:3:0x001b, B:6:0x0041, B:8:0x0060, B:15:0x0079, B:17:0x009a, B:20:0x00b0, B:23:0x00b8), top: B:29:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b0 A[Catch: all -> 0x0074, SQLiteException -> 0x00ae, TRY_LEAVE, TryCatch #0 {all -> 0x0074, blocks: (B:3:0x001b, B:6:0x0041, B:8:0x0060, B:15:0x0079, B:17:0x009a, B:20:0x00b0, B:23:0x00b8), top: B:29:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final long z(java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.z(java.lang.String, java.lang.String):long");
    }

    public final void z0(String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        h();
        j();
        try {
            u0().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e3) {
            zzic zzicVar = this.f73997a;
            zzicVar.a().o().d("Error deleting user property. appId", zzgu.x(str), zzicVar.D().c(str2), e3);
        }
    }

    private final zzpj R(String str, long j3, byte[] bArr, String str2, String str3, int i3, int i4, long j4, long j5, long j6) {
        if (TextUtils.isEmpty(str2)) {
            this.f73997a.a().v().a(wgbAZXYjrv.PHoKKRrERaOKZ);
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzpk.W(com.google.android.gms.internal.measurement.zzib.zzh(), bArr);
            zzls zzlsVarA = zzls.a(i3);
            if (zzlsVarA != zzls.GOOGLE_SIGNAL && zzlsVarA != zzls.GOOGLE_SIGNAL_PENDING && i4 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zzhzVar.zza().iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) it.next()).zzcl();
                    zzicVar.zzao(i4);
                    arrayList.add((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc());
                }
                zzhzVar.zzg();
                zzhzVar.zzf(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                String[] strArrSplit = str3.split("\r\n");
                int length = strArrSplit.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    String str4 = strArrSplit[i5];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit2 = str4.split("=", 2);
                    if (strArrSplit2.length != 2) {
                        this.f73997a.a().o().b("Invalid upload header: ", str4);
                        break;
                    }
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                    i5++;
                }
            }
            zzpi zzpiVar = new zzpi();
            zzpiVar.b(j3);
            zzpiVar.c((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc());
            zzpiVar.d(str2);
            zzpiVar.e(map);
            zzpiVar.f(zzlsVarA);
            zzpiVar.g(j4);
            zzpiVar.h(j5);
            zzpiVar.i(j6);
            zzpiVar.j(i4);
            return zzpiVar.a();
        } catch (IOException e3) {
            this.f73997a.a().o().c("Failed to queued MeasurementBatch from upload_queue. appId", str, e3);
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x02e6: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:742), block:B:83:0x02e6 */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0307  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzh J0(java.lang.String r52) {
        /*
            Method dump skipped, instruction units count: 779
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.J0(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    public final void K0(zzh zzhVar, boolean z2, boolean z3) {
        Preconditions.m(zzhVar);
        h();
        j();
        String strO0 = zzhVar.o0();
        Preconditions.m(strO0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strO0);
        if (z2) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.f74388b.g(strO0).o(zzjk.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.p0());
        }
        contentValues.put("gmp_app_id", zzhVar.r0());
        zzpg zzpgVar = this.f74388b;
        if (zzpgVar.g(strO0).o(zzjk.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.v0());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.g()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.z0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.B0()));
        contentValues.put("app_version", zzhVar.D0());
        contentValues.put("app_store", zzhVar.H0());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.J0()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.L0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.d()));
        contentValues.put("day", Long.valueOf(zzhVar.n()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.p()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.r()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.t()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.h()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.j()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.F0()));
        contentValues.put("firebase_instance_id", zzhVar.x0());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.x()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.v()));
        contentValues.put("health_monitor_sample", zzhVar.z());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.P()));
        contentValues.put(HcgZcEUYo.vNCYxAtGW, Long.valueOf(zzhVar.b()));
        if (zzpgVar.g(strO0).o(zzjk.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.t0());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.V()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.X()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.Z()));
        zzqp.zza();
        zzic zzicVar = this.f73997a;
        if (zzicVar.w().H(strO0, zzfy.Q0)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.b0()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.j0()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.d0()));
        contentValues.put("npa_metadata_value", zzhVar.R());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.G()));
        contentValues.put("sgtm_preview_key", zzhVar.l0());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.B()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.D()));
        contentValues.put("serialized_npa_metadata", zzhVar.I());
        contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.M()));
        List listT = zzhVar.T();
        if (listT != null) {
            if (listT.isEmpty()) {
                zzicVar.a().r().b("Safelisted events should not be an empty list. appId", strO0);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listT));
            }
        }
        zzpr.zza();
        if (zzicVar.w().H(null, zzfy.L0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.f0());
        contentValues.put("unmatched_uwa", zzhVar.h0());
        contentValues.put("ad_campaign_info", zzhVar.K());
        try {
            SQLiteDatabase sQLiteDatabaseU0 = u0();
            if (sQLiteDatabaseU0.update("apps", contentValues, "app_id = ?", new String[]{strO0}) == 0 && sQLiteDatabaseU0.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzicVar.a().o().b("Failed to insert/update app (got -1). appId", zzgu.x(strO0));
            }
        } catch (SQLiteException e3) {
            this.f73997a.a().o().c("Error storing app. appId", zzgu.x(strO0), e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzpj n(long r19) throws java.lang.Throwable {
        /*
            r18 = this;
            r18.h()
            r18.j()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r18.u0()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            java.lang.String r3 = "upload_queue"
            java.lang.String r4 = "rowId"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "measurement_batch"
            java.lang.String r7 = "upload_uri"
            java.lang.String r8 = "upload_headers"
            java.lang.String r9 = "upload_type"
            java.lang.String r10 = "retry_count"
            java.lang.String r11 = "creation_timestamp"
            r12 = 0
            java.lang.String r12 = kotlin.comparisons.xn.YvFRmou.vIhDZqMda     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            java.lang.String r13 = "last_upload_timestamp"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            java.lang.String r5 = "rowId=?"
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            java.lang.String r10 = "1"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            if (r0 != 0) goto L43
            r3 = r18
            goto Lac
        L43:
            r0 = 1
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.m(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r0 = 2
            byte[] r7 = r2.getBlob(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r0 = 3
            java.lang.String r8 = r2.getString(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r0 = 4
            java.lang.String r9 = r2.getString(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r0 = 5
            int r10 = r2.getInt(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r0 = 6
            int r11 = r2.getInt(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r0 = 7
            long r12 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r0 = 8
            long r14 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r0 = 9
            long r16 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r3 = r18
            r5 = r19
            com.google.android.gms.measurement.internal.zzpj r0 = r3.R(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r2.close()
            return r0
        L85:
            r0 = move-exception
            goto L89
        L87:
            r0 = move-exception
            goto L8d
        L89:
            r3 = r18
        L8b:
            r1 = r2
            goto Lb4
        L8d:
            r3 = r18
            goto L99
        L90:
            r0 = move-exception
            goto L94
        L92:
            r0 = move-exception
            goto L97
        L94:
            r3 = r18
            goto Lb4
        L97:
            r2 = r1
            goto L8d
        L99:
            com.google.android.gms.measurement.internal.zzic r4 = r3.f73997a     // Catch: java.lang.Throwable -> Lb2
            com.google.android.gms.measurement.internal.zzgu r4 = r4.a()     // Catch: java.lang.Throwable -> Lb2
            com.google.android.gms.measurement.internal.zzgs r4 = r4.o()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r5 = "Error to querying MeasurementBatch from upload_queue. rowId"
            java.lang.Long r6 = java.lang.Long.valueOf(r19)     // Catch: java.lang.Throwable -> Lb2
            r4.c(r5, r6, r0)     // Catch: java.lang.Throwable -> Lb2
        Lac:
            if (r2 == 0) goto Lb1
            r2.close()
        Lb1:
            return r1
        Lb2:
            r0 = move-exception
            goto L8b
        Lb4:
            if (r1 == 0) goto Lb9
            r1.close()
        Lb9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.n(long):com.google.android.gms.measurement.internal.zzpj");
    }
}
