package androidx.media3.exoplayer.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.VersionTable;
import androidx.media3.exoplayer.offline.DownloadRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.common.cache.LSNn.vfptEEmYY;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class DefaultDownloadIndex implements WritableDownloadIndex {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f44359f = p(3, 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f44360g = {"id", "mime_type", ShareConstants.MEDIA_URI, "stream_keys", "custom_cache_key", "data", ServerProtocol.DIALOG_PARAM_STATE, "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f44361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f44362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DatabaseProvider f44363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f44364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f44365e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class DownloadCursorImpl implements DownloadCursor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Cursor f44366a;

        @Override // androidx.media3.exoplayer.offline.DownloadCursor
        public Download V0() {
            return DefaultDownloadIndex.n(this.f44366a);
        }

        @Override // androidx.media3.exoplayer.offline.DownloadCursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f44366a.close();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadCursor
        public int getPosition() {
            return this.f44366a.getPosition();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadCursor
        public boolean moveToPosition(int i3) {
            return this.f44366a.moveToPosition(i3);
        }

        private DownloadCursorImpl(Cursor cursor) {
            this.f44366a = cursor;
        }
    }

    private static List j(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : Util.h1(str, ",")) {
                String[] strArrH1 = Util.h1(str2, "\\.");
                Assertions.g(strArrH1.length == 3);
                arrayList.add(new StreamKey(Integer.parseInt(strArrH1[0]), Integer.parseInt(strArrH1[1]), Integer.parseInt(strArrH1[2])));
            }
        }
        return arrayList;
    }

    static String k(List list) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            StreamKey streamKey = (StreamKey) list.get(i3);
            sb.append(streamKey.f41093a);
            sb.append('.');
            sb.append(streamKey.f41094b);
            sb.append('.');
            sb.append(streamKey.f41095c);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private void l() {
        synchronized (this.f44364d) {
            if (this.f44365e) {
                return;
            }
            try {
                int iB = VersionTable.b(this.f44363c.getReadableDatabase(), 0, this.f44361a);
                if (iB != 3) {
                    SQLiteDatabase writableDatabase = this.f44363c.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        VersionTable.d(writableDatabase, 0, this.f44361a, 3);
                        List listR = iB == 2 ? r(writableDatabase) : new ArrayList();
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f44362b);
                        writableDatabase.execSQL("CREATE TABLE " + this.f44362b + " (id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                        Iterator it = listR.iterator();
                        while (it.hasNext()) {
                            s((Download) it.next(), writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                this.f44365e = true;
            } catch (SQLException e3) {
                throw new DatabaseIOException(e3);
            }
        }
    }

    private Cursor m(String str, String[] strArr) throws DatabaseIOException {
        try {
            return this.f44363c.getReadableDatabase().query(this.f44362b, f44360g, str, strArr, null, null, "start_time_ms ASC");
        } catch (SQLiteException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Download n(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        DownloadRequest.Builder builderF = new DownloadRequest.Builder((String) Assertions.e(cursor.getString(0)), Uri.parse((String) Assertions.e(cursor.getString(2)))).e(cursor.getString(1)).f(j(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest downloadRequestA = builderF.d(blob).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.f44427a = cursor.getLong(13);
        downloadProgress.f44428b = cursor.getFloat(12);
        int i3 = cursor.getInt(6);
        return new Download(downloadRequestA, i3, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i3 == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    private static Download o(Cursor cursor) {
        DownloadRequest downloadRequestA = new DownloadRequest.Builder((String) Assertions.e(cursor.getString(0)), Uri.parse((String) Assertions.e(cursor.getString(2)))).e(q(cursor.getString(1))).f(j(cursor.getString(3))).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.f44427a = cursor.getLong(13);
        downloadProgress.f44428b = cursor.getFloat(12);
        int i3 = cursor.getInt(6);
        return new Download(downloadRequestA, i3, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i3 == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    private static String p(int... iArr) {
        if (iArr.length == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ServerProtocol.DIALOG_PARAM_STATE);
        sb.append(" IN (");
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i3 > 0) {
                sb.append(',');
            }
            sb.append(iArr[i3]);
        }
        sb.append(')');
        return sb.toString();
    }

    private static String q(String str) {
        return "dash".equals(str) ? "application/dash+xml" : "hls".equals(str) ? "application/x-mpegURL" : "ss".equals(str) ? "application/vnd.ms-sstr+xml" : "video/x-unknown";
    }

    private List r(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (!Util.m1(sQLiteDatabase, this.f44362b)) {
            return arrayList;
        }
        Cursor cursorQuery = sQLiteDatabase.query(this.f44362b, new String[]{"id", "title", ShareConstants.MEDIA_URI, "stream_keys", "custom_cache_key", "data", ServerProtocol.DIALOG_PARAM_STATE, "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded"}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(o(cursorQuery));
            } finally {
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    private void s(Download download, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = download.f44370a.f44433f;
        if (bArr == null) {
            bArr = Util.f41614f;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", download.f44370a.f44429a);
        contentValues.put("mime_type", download.f44370a.f44431c);
        contentValues.put(ShareConstants.MEDIA_URI, download.f44370a.f44430b.toString());
        contentValues.put("stream_keys", k(download.f44370a.f44432d));
        contentValues.put("custom_cache_key", download.f44370a.f44434g);
        contentValues.put("data", download.f44370a.f44435h);
        contentValues.put(ServerProtocol.DIALOG_PARAM_STATE, Integer.valueOf(download.f44371b));
        contentValues.put("start_time_ms", Long.valueOf(download.f44372c));
        contentValues.put("update_time_ms", Long.valueOf(download.f44373d));
        contentValues.put("content_length", Long.valueOf(download.f44374e));
        contentValues.put("stop_reason", Integer.valueOf(download.f44375f));
        contentValues.put("failure_reason", Integer.valueOf(download.f44376g));
        contentValues.put("percent_downloaded", Float.valueOf(download.b()));
        contentValues.put("bytes_downloaded", Long.valueOf(download.a()));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.f44362b, null, contentValues);
    }

    @Override // androidx.media3.exoplayer.offline.WritableDownloadIndex
    public void a(String str, int i3) throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i3));
            this.f44363c.getWritableDatabase().update(this.f44362b, contentValues, f44359f + " AND id = ?", new String[]{str});
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    @Override // androidx.media3.exoplayer.offline.WritableDownloadIndex
    public void b(Download download) throws DatabaseIOException {
        l();
        try {
            s(download, this.f44363c.getWritableDatabase());
        } catch (SQLiteException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    @Override // androidx.media3.exoplayer.offline.WritableDownloadIndex
    public void c(String str) throws DatabaseIOException {
        l();
        try {
            this.f44363c.getWritableDatabase().delete(this.f44362b, "id = ?", new String[]{str});
        } catch (SQLiteException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    @Override // androidx.media3.exoplayer.offline.WritableDownloadIndex
    public void d(int i3) throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i3));
            this.f44363c.getWritableDatabase().update(this.f44362b, contentValues, f44359f, null);
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    @Override // androidx.media3.exoplayer.offline.DownloadIndex
    public DownloadCursor e(int... iArr) throws DatabaseIOException {
        l();
        return new DownloadCursorImpl(m(p(iArr), null));
    }

    @Override // androidx.media3.exoplayer.offline.WritableDownloadIndex
    public void f() throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ServerProtocol.DIALOG_PARAM_STATE, (Integer) 5);
            contentValues.put("failure_reason", (Integer) 0);
            this.f44363c.getWritableDatabase().update(this.f44362b, contentValues, null, null);
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }

    @Override // androidx.media3.exoplayer.offline.DownloadIndex
    public Download h(String str) throws DatabaseIOException {
        l();
        try {
            Cursor cursorM = m("id = ?", new String[]{str});
            try {
                if (cursorM.getCount() == 0) {
                    cursorM.close();
                    return null;
                }
                cursorM.moveToNext();
                Download downloadN = n(cursorM);
                cursorM.close();
                return downloadN;
            } finally {
            }
        } catch (SQLiteException e3) {
            throw new DatabaseIOException(e3);
        }
        throw new DatabaseIOException(e3);
    }

    @Override // androidx.media3.exoplayer.offline.WritableDownloadIndex
    public void g() throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(vfptEEmYY.quMSKki, (Integer) 0);
            this.f44363c.getWritableDatabase().update(this.f44362b, contentValues, "state = 2", null);
        } catch (SQLException e3) {
            throw new DatabaseIOException(e3);
        }
    }
}
