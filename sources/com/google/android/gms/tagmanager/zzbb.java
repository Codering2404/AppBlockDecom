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
final class zzbb extends SQLiteOpenHelper {
    final /* synthetic */ zzbd zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbb(zzbd zzbdVar, Context context, String str) {
        super(context, "google_tagmanager.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzbdVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = super.getWritableDatabase();
        } catch (SQLiteException unused) {
            this.zza.zzc.getDatabasePath("google_tagmanager.db").delete();
            writableDatabase = null;
        }
        return writableDatabase == null ? super.getWritableDatabase() : writableDatabase;
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
                    cursorQuery = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{"datalayer"}, null, null, null);
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
                Cursor cursorRawQuery = sQLiteDatabase2.rawQuery("SELECT * FROM datalayer WHERE 0", null);
                HashSet hashSet = new HashSet();
                try {
                    for (String str : cursorRawQuery.getColumnNames()) {
                        hashSet.add(str);
                    }
                    cursorRawQuery.close();
                    if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
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
            Log.w("GoogleTagManager", "Error querying for table datalayer");
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
        sQLiteDatabase2.execSQL(zzbd.zza);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
    }
}
