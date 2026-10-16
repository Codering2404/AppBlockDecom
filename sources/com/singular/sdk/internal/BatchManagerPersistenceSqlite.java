package com.singular.sdk.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import d.qFm.sECyKyO;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class BatchManagerPersistenceSqlite implements BatchManagerPersistence {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SingularLog f92515c = SingularLog.f(BatchManagerPersistenceSqlite.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BatchManagerSQLiteHelper f92516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f92517b;

    public BatchManagerPersistenceSqlite(Context context) {
        this.f92516a = new BatchManagerSQLiteHelper(context);
        this.f92517b = context;
    }

    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized long a() {
        return h(this.f92517b);
    }

    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized boolean b(String str, String str2) {
        f92515c.a("updateEvent: key: " + str + " value: " + str2);
        return this.f92516a.i(str, str2);
    }

    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized boolean c(String str) {
        f92515c.a("deleteEvent: key: " + str);
        return this.f92516a.a(str);
    }

    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized Set d() {
        Set setB;
        SingularLog singularLog = f92515c;
        singularLog.a("getAllEvents");
        setB = this.f92516a.b();
        singularLog.a("getAllEvents: returning " + setB.size() + " events");
        return setB;
    }

    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized long e() {
        return i(this.f92517b);
    }

    @Override // com.singular.sdk.internal.BatchManagerPersistence
    public synchronized boolean f(String str, String str2) {
        f92515c.a("addEvent: key: " + str + " value: " + str2);
        return this.f92516a.c(str, str2);
    }

    long i(Context context) {
        long jH = h(context) + 1;
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("batch_send_id", 0).edit();
            editorEdit.putLong("sendId", jH);
            editorEdit.commit();
            return jH;
        } catch (Throwable th) {
            f92515c.c(Utils.l(th));
            return jH;
        }
    }

    long h(Context context) {
        return context.getSharedPreferences("batch_send_id", 0).getLong(sECyKyO.FxKXbjYpxDL, 0L);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class BatchManagerSQLiteHelper extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SQLiteDatabase f92518a;

        public BatchManagerSQLiteHelper(Context context) {
            super(context, "singular-batch-managerx-1.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        public synchronized boolean a(String str) {
            BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.delete key: " + str);
            try {
                if (!f(str)) {
                    BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.delete key does not exist - returning false ");
                    return false;
                }
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    this.f92518a = writableDatabase;
                    if (writableDatabase.delete("events", "eventKey =?", new String[]{str}) != 1) {
                        BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.delete failed ");
                        return false;
                    }
                    BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.delete - success ");
                    SQLiteDatabase sQLiteDatabase = this.f92518a;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return true;
                } catch (SQLException unused) {
                    throw new IOException();
                }
            } finally {
                SQLiteDatabase sQLiteDatabase2 = this.f92518a;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
            }
        }

        public synchronized Set b() {
            HashSet hashSet;
            SQLiteDatabase sQLiteDatabase;
            try {
                BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.getAll");
                hashSet = new HashSet();
                Cursor cursorRawQuery = null;
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    this.f92518a = readableDatabase;
                    cursorRawQuery = readableDatabase.rawQuery("SELECT * FROM events", null);
                    if (cursorRawQuery != null && cursorRawQuery.getCount() != 0) {
                        cursorRawQuery.moveToFirst();
                        do {
                            hashSet.add(new AbstractMap.SimpleEntry(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("eventKey")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("value"))));
                        } while (cursorRawQuery.moveToNext());
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    sQLiteDatabase = this.f92518a;
                } catch (Throwable th) {
                    try {
                        BatchManagerPersistenceSqlite.f92515c.c("SQLiteHelper.getAll exception: " + th.getMessage());
                        BatchManagerPersistenceSqlite.f92515c.c(Utils.l(th));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        sQLiteDatabase = this.f92518a;
                        if (sQLiteDatabase != null) {
                        }
                    } catch (Throwable th2) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        SQLiteDatabase sQLiteDatabase2 = this.f92518a;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                        }
                        throw th2;
                    }
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.getAll returning: " + hashSet.size() + " entries");
            } catch (Throwable th3) {
                throw th3;
            }
            return hashSet;
        }

        public synchronized boolean c(String str, String str2) {
            SQLiteDatabase writableDatabase;
            BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.insert key: " + str + " value: " + str2);
            if (f(str)) {
                BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.insert key already exists - returning false ");
                return false;
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                } catch (SQLException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("eventKey", str);
                contentValues.put("value", str2);
                if (writableDatabase.insert("events", null, contentValues) != -1) {
                    BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.insert success ");
                    writableDatabase.close();
                    return true;
                }
                BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.insert false ");
                writableDatabase.close();
                return false;
            } catch (SQLException e4) {
                e = e4;
                sQLiteDatabase = writableDatabase;
                throw new IOException(e);
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }

        public synchronized boolean f(String str) {
            BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.keyExists: key: " + str);
            Cursor cursor = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    this.f92518a = writableDatabase;
                    Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM events WHERE eventKey= ?", new String[]{str});
                    if (cursorRawQuery == null || cursorRawQuery.getCount() == 0) {
                        BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.keyExists: returning false ");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        SQLiteDatabase sQLiteDatabase = this.f92518a;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return false;
                    }
                    BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.keyExists: returning true ");
                    cursorRawQuery.close();
                    cursorRawQuery.close();
                    SQLiteDatabase sQLiteDatabase2 = this.f92518a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    return true;
                } catch (SQLException unused) {
                    throw new IOException();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                SQLiteDatabase sQLiteDatabase3 = this.f92518a;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                }
                throw th;
            }
        }

        public synchronized boolean i(String str, String str2) {
            BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.update key: " + str + " value: " + str2);
            try {
                if (!f(str)) {
                    BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.update: key does not exist - returning false ");
                    return false;
                }
                try {
                    this.f92518a = getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("eventKey", str);
                    contentValues.put("value", str2);
                    if (this.f92518a.replace("events", null, contentValues) == -1) {
                        BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.update - failed");
                        return false;
                    }
                    BatchManagerPersistenceSqlite.f92515c.a("SQLiteHelper.update - success");
                    SQLiteDatabase sQLiteDatabase = this.f92518a;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return true;
                } catch (SQLException unused) {
                    throw new IOException();
                }
            } finally {
                SQLiteDatabase sQLiteDatabase2 = this.f92518a;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE events (eventKey  TEXT PRIMARY KEY NOT NULL,value TEXT )");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        }
    }
}
