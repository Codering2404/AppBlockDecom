package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcf extends SQLiteOpenHelper {
    final /* synthetic */ zzcg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcf(zzcg zzcgVar, Context context, String str) {
        super(context, "google_analytics_v4.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzcgVar;
    }

    private final boolean zza(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
                return zMoveToFirst;
            } catch (SQLiteException e3) {
                this.zza.zzS("Error querying for table", str, e3);
                if (cursorQuery == null) {
                    return false;
                }
                cursorQuery.close();
                return false;
            }
        } finally {
        }
    }

    private static final Set zzb(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
        try {
            for (String str2 : cursorRawQuery.getColumnNames()) {
                hashSet.add(str2);
            }
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        if (!this.zza.zze.zzc(3600000L)) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            this.zza.zze.zzb();
            this.zza.zzI("Opening the database failed, dropping the table and recreating it");
            zzcg zzcgVar = this.zza;
            zzcgVar.zzo().getDatabasePath(zzcgVar.zzad()).delete();
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.zza.zze.zza();
                return writableDatabase;
            } catch (SQLiteException e3) {
                this.zza.zzJ("Failed to open freshly created database", e3);
                throw e3;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        try {
            if (Integer.parseInt(Build.VERSION.SDK) < 9) {
                return;
            }
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        } catch (NumberFormatException unused) {
            zzfc.zzb("Invalid version number", Build.VERSION.SDK);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (zza(sQLiteDatabase, "hits2")) {
            Set setZzb = zzb(sQLiteDatabase, "hits2");
            String[] strArr = {"hit_id", "hit_string", "hit_time", "hit_url"};
            for (int i3 = 0; i3 < 4; i3++) {
                String str = strArr[i3];
                if (!setZzb.remove(str)) {
                    throw new SQLiteException("Database hits2 is missing required column: ".concat(String.valueOf(str)));
                }
            }
            boolean zRemove = setZzb.remove("hit_app_id");
            if (!setZzb.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            }
            if (!zRemove) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        } else {
            sQLiteDatabase.execSQL(zzcg.zza);
        }
        if (!zza(sQLiteDatabase, DiagnosticsEntry.PROPERTIES_KEY)) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            return;
        }
        Set setZzb2 = zzb(sQLiteDatabase, DiagnosticsEntry.PROPERTIES_KEY);
        String[] strArr2 = {"app_uid", "cid", "tid", NativeProtocol.WEB_DIALOG_PARAMS, "adid", "hits_count"};
        for (int i4 = 0; i4 < 6; i4++) {
            String str2 = strArr2[i4];
            if (!setZzb2.remove(str2)) {
                throw new SQLiteException("Database properties is missing required column: ".concat(String.valueOf(str2)));
            }
        }
        if (!setZzb2.isEmpty()) {
            throw new SQLiteException("Database properties table has extra columns");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
    }
}
