package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdu extends SQLiteOpenHelper {
    final /* synthetic */ zzdv zza;
    private boolean zzb;
    private long zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdu(zzdv zzdvVar, Context context, String str) {
        super(context, "gtm_urls.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzdvVar;
        this.zzc = 0L;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        if (this.zzb && this.zzc + 3600000 > this.zza.zzg.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
        }
        this.zzb = true;
        this.zzc = this.zza.zzg.currentTimeMillis();
        try {
            writableDatabase = super.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdv zzdvVar = this.zza;
            zzdvVar.zzd.getDatabasePath(zzdvVar.zze).delete();
            writableDatabase = null;
        }
        if (writableDatabase == null) {
            writableDatabase = super.getWritableDatabase();
        }
        this.zzb = false;
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzbu.zza(sQLiteDatabase.getPath());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase2 = sQLiteDatabase;
                try {
                    cursorQuery = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{"gtm_hits"}, null, null, null);
                } catch (SQLiteException unused) {
                }
            } catch (SQLiteException unused2) {
                sQLiteDatabase2 = sQLiteDatabase;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zMoveToFirst = cursorQuery.moveToFirst();
            cursorQuery.close();
            if (zMoveToFirst) {
                Cursor cursorRawQuery = sQLiteDatabase2.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
                HashSet hashSet = new HashSet();
                try {
                    for (String str : cursorRawQuery.getColumnNames()) {
                        hashSet.add(str);
                    }
                    cursorRawQuery.close();
                    if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                        throw new SQLiteException("Database column missing");
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    }
                    return;
                } catch (Throwable th2) {
                    cursorRawQuery.close();
                    throw th2;
                }
            }
        } catch (SQLiteException unused3) {
            cursor = cursorQuery;
            Log.w("GoogleTagManager", "Error querying for table gtm_hits");
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        sQLiteDatabase2.execSQL(zzdv.zza);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
    }
}
