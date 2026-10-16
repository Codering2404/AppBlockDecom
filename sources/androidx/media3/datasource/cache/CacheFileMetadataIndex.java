package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.common.util.Assertions;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.VersionTable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class CacheFileMetadataIndex {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f42050c = {"name", "length", "last_touch_timestamp"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DatabaseProvider f42051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f42052b;

    private static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    private Cursor c() {
        Assertions.e(this.f42052b);
        return this.f42051a.getReadableDatabase().query(this.f42052b, f42050c, null, null, null, null, null);
    }

    private static String d(String str) {
        return "ExoPlayerCacheFileMetadata" + str;
    }

    public Map b() throws DatabaseIOException {
        try {
            Cursor cursorC = c();
            try {
                HashMap map = new HashMap(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    map.put((String) Assertions.e(cursorC.getString(0)), new CacheFileMetadata(cursorC.getLong(1), cursorC.getLong(2)));
                }
                cursorC.close();
                return map;
            } finally {
            }
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    public void e(long j3) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j3);
            this.f42052b = d(hexString);
            if (VersionTable.b(this.f42051a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f42051a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.f42052b);
                    writableDatabase.execSQL("CREATE TABLE " + this.f42052b + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    public void f(String str) throws DatabaseIOException {
        Assertions.e(this.f42052b);
        try {
            this.f42051a.getWritableDatabase().delete(this.f42052b, "name = ?", new String[]{str});
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    public void g(Set set) throws DatabaseIOException {
        Assertions.e(this.f42052b);
        try {
            SQLiteDatabase writableDatabase = this.f42051a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f42052b, "name = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    public void h(String str, long j3, long j4) throws DatabaseIOException {
        Assertions.e(this.f42052b);
        try {
            SQLiteDatabase writableDatabase = this.f42051a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j3));
            contentValues.put("last_touch_timestamp", Long.valueOf(j4));
            writableDatabase.replaceOrThrow(this.f42052b, null, contentValues);
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }
}
