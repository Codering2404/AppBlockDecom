package com.singular.sdk.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SQLitePersistentQueue implements Queue {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SingularLog f92658b = SingularLog.f(SQLitePersistentQueue.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SQLiteManager f92659a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SQLiteManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SQLiteHelper f92660a;

        SQLiteManager(SQLiteHelper sQLiteHelper) {
            this.f92660a = sQLiteHelper;
        }

        private long a(SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery = null;
            try {
                try {
                    cursorRawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(_id) FROM events", null);
                    cursorRawQuery.moveToFirst();
                    long j3 = cursorRawQuery.getLong(0);
                    SQLitePersistentQueue.f92658b.b("getCount() = %d", Long.valueOf(j3));
                    cursorRawQuery.close();
                    return j3;
                } catch (SQLException e3) {
                    throw new IOException(e3);
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        }

        private long c(SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery = null;
            try {
                try {
                    cursorRawQuery = sQLiteDatabase.rawQuery("SELECT MIN(_id) FROM events", null);
                    cursorRawQuery.moveToFirst();
                    long j3 = cursorRawQuery.getLong(0);
                    SQLitePersistentQueue.f92658b.b("getMinId() id = %d", Long.valueOf(j3));
                    cursorRawQuery.close();
                    return j3;
                } catch (SQLException e3) {
                    throw new IOException(e3);
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        }

        private String f(SQLiteDatabase sQLiteDatabase) throws Throwable {
            long jC;
            String[] strArr;
            Cursor cursorQuery;
            Cursor cursor = null;
            try {
                try {
                    jC = c(sQLiteDatabase);
                    strArr = new String[]{String.valueOf(jC)};
                    cursorQuery = sQLiteDatabase.query("events", new String[]{"value"}, "_id = ?", strArr, null, null, null);
                } catch (SQLException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                cursorQuery.moveToFirst();
                if (cursorQuery.getCount() == 0) {
                    cursorQuery.close();
                    return null;
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                sQLiteDatabase.delete("events", "_id = ?", strArr);
                SQLitePersistentQueue.f92658b.b("removeHead() _id = %d", Long.valueOf(jC));
                cursorQuery.close();
                return string;
            } catch (SQLException e4) {
                e = e4;
                cursor = cursorQuery;
                throw new IOException(e);
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        String b() throws Throwable {
            SQLiteDatabase readableDatabase;
            long jC;
            Cursor cursorQuery;
            Cursor cursor = null;
            String string = null;
            cursor = null;
            cursor = null;
            cursor = null;
            try {
                readableDatabase = this.f92660a.getReadableDatabase();
                try {
                    try {
                        jC = c(readableDatabase);
                        cursorQuery = readableDatabase.query("events", new String[]{"value"}, "_id = ?", new String[]{String.valueOf(jC)}, null, null, null);
                    } catch (SQLException e3) {
                        e = e3;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (SQLException e4) {
                e = e4;
                readableDatabase = null;
            } catch (Throwable th2) {
                th = th2;
                readableDatabase = null;
            }
            try {
                cursorQuery.moveToFirst();
                if (cursorQuery.getCount() != 0) {
                    string = cursorQuery.getString(0);
                }
                SQLitePersistentQueue.f92658b.b("getHead() _id = %d, value = %s", Long.valueOf(jC), string);
                cursorQuery.close();
                readableDatabase.close();
                return string;
            } catch (SQLException e5) {
                e = e5;
                cursor = cursorQuery;
                throw new IOException(e);
            } catch (Throwable th3) {
                th = th3;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        long d(java.lang.String r9) throws java.lang.Throwable {
            /*
                r8 = this;
                android.content.ContentValues r0 = new android.content.ContentValues
                r0.<init>()
                java.lang.String r1 = "value"
                r0.put(r1, r9)
                r9 = 0
                com.singular.sdk.internal.SQLitePersistentQueue$SQLiteHelper r1 = r8.f92660a     // Catch: java.lang.Throwable -> L5c android.database.SQLException -> L60
                android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L5c android.database.SQLException -> L60
                java.lang.String r2 = "events"
                long r2 = r1.insert(r2, r9, r0)     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                com.singular.sdk.internal.SingularLog r9 = com.singular.sdk.internal.SQLitePersistentQueue.b()     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                r0.<init>()     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                java.lang.String r4 = "insert() row = "
                r0.append(r4)     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                r0.append(r2)     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                r9.a(r0)     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                long r4 = r8.a(r1)     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                r6 = 10000(0x2710, double:4.9407E-320)
                int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r9 <= 0) goto L58
                com.singular.sdk.internal.SingularLog r9 = com.singular.sdk.internal.SQLitePersistentQueue.b()     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                java.lang.String r0 = "Pruning Queue; current size = %d; max size = %d"
                java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                r5 = 10000(0x2710, float:1.4013E-41)
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                java.lang.Object[] r4 = new java.lang.Object[]{r4, r5}     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                r9.b(r0, r4)     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                r8.f(r1)     // Catch: java.lang.Throwable -> L54 android.database.SQLException -> L56
                goto L58
            L54:
                r9 = move-exception
                goto L69
            L56:
                r9 = move-exception
                goto L63
            L58:
                r1.close()
                return r2
            L5c:
                r0 = move-exception
                r1 = r9
                r9 = r0
                goto L69
            L60:
                r0 = move-exception
                r1 = r9
                r9 = r0
            L63:
                java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L54
                r0.<init>(r9)     // Catch: java.lang.Throwable -> L54
                throw r0     // Catch: java.lang.Throwable -> L54
            L69:
                if (r1 == 0) goto L6e
                r1.close()
            L6e:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.SQLitePersistentQueue.SQLiteManager.d(java.lang.String):long");
        }

        String e() {
            SQLiteDatabase writableDatabase = null;
            try {
                writableDatabase = this.f92660a.getWritableDatabase();
                return f(writableDatabase);
            } finally {
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    public SQLitePersistentQueue(Context context) {
        this.f92659a = new SQLiteManager(new SQLiteHelper(context.getApplicationContext()));
    }

    @Override // com.singular.sdk.internal.Queue
    public synchronized void a(String str) {
        if (this.f92659a.d(str) == -1) {
            throw new IOException("Failed to add element = " + str);
        }
    }

    @Override // com.singular.sdk.internal.Queue
    public synchronized String peek() {
        return this.f92659a.b();
    }

    @Override // com.singular.sdk.internal.Queue
    public synchronized void remove() {
        this.f92659a.e();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SQLiteHelper extends SQLiteOpenHelper implements BaseColumns {
        public SQLiteHelper(Context context) {
            super(context, "singular-1.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,value TEXT )");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        }
    }
}
