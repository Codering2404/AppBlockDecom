package com.google.android.gms.internal.gtm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.HttpUtils;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcg extends zzbu implements Closeable {
    private static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String zzb = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final zzcf zzc;
    private final zzfq zzd;
    private final zzfq zze;

    zzcg(zzbx zzbxVar) {
        super(zzbxVar);
        this.zzd = new zzfq(zzC());
        this.zze = new zzfq(zzC());
        this.zzc = new zzcf(this, zzbxVar.zza(), zzad());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzac(java.lang.String r1, java.lang.String[] r2, long r3) {
        /*
            r0 = this;
            android.database.sqlite.SQLiteDatabase r3 = r0.zzf()
            r4 = 0
            android.database.Cursor r4 = r3.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            boolean r2 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            if (r2 == 0) goto L18
            r2 = 0
            long r1 = r4.getLong(r2)     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            r4.close()
            return r1
        L18:
            r4.close()
            r1 = 0
            return r1
        L1e:
            r1 = move-exception
            goto L27
        L20:
            r2 = move-exception
            java.lang.String r3 = "Database error"
            r0.zzK(r3, r1, r2)     // Catch: java.lang.Throwable -> L1e
            throw r2     // Catch: java.lang.Throwable -> L1e
        L27:
            if (r4 == 0) goto L2c
            r4.close()
        L2c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcg.zzac(java.lang.String, java.lang.String[], long):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzad() {
        zzw();
        zzw();
        return "google_analytics_v4.db";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.zzc.close();
        } catch (SQLiteException e3) {
            zzJ("Sql error closing database", e3);
        } catch (IllegalStateException e4) {
            zzJ("Error closing database", e4);
        }
    }

    public final void zzY(List list) {
        Preconditions.m(list);
        com.google.android.gms.analytics.zzr.h();
        zzV();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        for (int i3 = 0; i3 < list.size(); i3++) {
            Long l3 = (Long) list.get(i3);
            if (l3 == null || l3.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i3 > 0) {
                sb.append(",");
            }
            sb.append(l3);
        }
        sb.append(")");
        String string = sb.toString();
        try {
            SQLiteDatabase sQLiteDatabaseZzf = zzf();
            zzO("Deleting dispatched hits. count", Integer.valueOf(list.size()));
            int iDelete = sQLiteDatabaseZzf.delete("hits2", string, null);
            if (iDelete != list.size()) {
                zzT("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(iDelete), string);
            }
        } catch (SQLiteException e3) {
            zzJ("Error deleting hits", e3);
            throw e3;
        }
    }

    public final void zzZ() {
        zzV();
        zzf().endTransaction();
    }

    public final int zza() {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        if (!this.zzd.zzc(86400000L)) {
            return 0;
        }
        this.zzd.zzb();
        zzN("Deleting stale hits (if any)");
        int iDelete = zzf().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzC().currentTimeMillis() - 2592000000L)});
        zzO("Deleted stale hits, count", Integer.valueOf(iDelete));
        return iDelete;
    }

    public final void zzaa() {
        zzV();
        zzf().setTransactionSuccessful();
    }

    final boolean zzab() {
        return zzb() == 0;
    }

    public final long zzb() {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = zzf().rawQuery("SELECT COUNT(*) FROM hits2", null);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j3 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j3;
            } catch (SQLiteException e3) {
                zzK("Database error", "SELECT COUNT(*) FROM hits2", e3);
                throw e3;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zzc() {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        return zzac(zzb, null, 0L);
    }

    public final long zze(long j3, String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        zzV();
        com.google.android.gms.analytics.zzr.h();
        return zzac("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, str, str2}, 0L);
    }

    final SQLiteDatabase zzf() {
        try {
            return this.zzc.getWritableDatabase();
        } catch (SQLiteException e3) {
            zzR("Error opening database", e3);
            throw e3;
        }
    }

    public final List zzj(long j3) throws Throwable {
        Cursor cursorQuery;
        Map map;
        boolean z2;
        Preconditions.a(j3 >= 0);
        com.google.android.gms.analytics.zzr.h();
        zzV();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = zzf().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j3));
            } catch (Throwable th) {
                th = th;
            }
        } catch (SQLiteException e3) {
            e = e3;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (cursorQuery.moveToFirst()) {
                do {
                    long j4 = cursorQuery.getLong(0);
                    long j5 = cursorQuery.getLong(1);
                    String string = cursorQuery.getString(2);
                    String string2 = cursorQuery.getString(3);
                    int i3 = cursorQuery.getInt(4);
                    Map mapZzk = zzk(string);
                    if (!TextUtils.isEmpty(string2) && string2.startsWith("http:")) {
                        map = mapZzk;
                        z2 = false;
                    } else {
                        map = mapZzk;
                        z2 = true;
                    }
                    arrayList.add(new zzez(this, map, j5, z2, j4, i3, null));
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
            return arrayList;
        } catch (SQLiteException e4) {
            e = e4;
            zzJ("Error loading hits from the database", e);
            throw e;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map zzk(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            return HttpUtils.a(new URI(str), Utf8Charset.NAME);
        } catch (URISyntaxException e3) {
            zzJ("Error parsing hit parameters", e3);
            return new HashMap(0);
        }
    }

    final Map zzl(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            return HttpUtils.a(new URI("?" + str), Utf8Charset.NAME);
        } catch (URISyntaxException e3) {
            zzJ("Error parsing property parameters", e3);
            return new HashMap(0);
        }
    }

    public final void zzm() {
        zzV();
        zzf().beginTransaction();
    }

    public final void zzn(long j3) {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        ArrayList arrayList = new ArrayList(1);
        Long lValueOf = Long.valueOf(j3);
        arrayList.add(lValueOf);
        zzO("Deleting hit, id", lValueOf);
        zzY(arrayList);
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
    }
}
