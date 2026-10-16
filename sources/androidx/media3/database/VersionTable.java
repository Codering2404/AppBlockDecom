package androidx.media3.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VersionTable {
    static {
        MediaLibraryInfo.a("media3.database");
    }

    private static String[] a(int i3, String str) {
        return new String[]{Integer.toString(i3), str};
    }

    public static int b(SQLiteDatabase sQLiteDatabase, int i3, String str) throws DatabaseIOException {
        try {
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
        if (!Util.m1(sQLiteDatabase, "ExoPlayerVersions")) {
            return -1;
        }
        Cursor cursorQuery = sQLiteDatabase.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", a(i3, str), null, null, null);
        try {
            if (cursorQuery.getCount() == 0) {
                cursorQuery.close();
                return -1;
            }
            cursorQuery.moveToNext();
            int i4 = cursorQuery.getInt(0);
            cursorQuery.close();
            return i4;
        } finally {
        }
        throw new DatabaseIOException(e3);
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i3, String str) throws DatabaseIOException {
        try {
            if (Util.m1(sQLiteDatabase, "ExoPlayerVersions")) {
                sQLiteDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", a(i3, str));
            }
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i3, String str, int i4) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i3));
            contentValues.put("instance_uid", str);
            contentValues.put("version", Integer.valueOf(i4));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", null, contentValues);
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }
}
