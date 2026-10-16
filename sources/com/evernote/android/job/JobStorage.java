package com.evernote.android.job;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.LruCache;
import com.evernote.android.job.util.JobCat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class JobStorage {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final JobCat f67928h = new JobCat("JobStorage");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f67929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JobCacheId f67930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicInteger f67931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f67932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final JobOpenHelper f67933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SQLiteDatabase f67934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ReadWriteLock f67935g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class JobCacheId extends LruCache<Integer, JobRequest> {
        public JobCacheId() {
            super(30);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JobRequest create(Integer num) {
            return JobStorage.this.m(num.intValue(), true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JobOpenHelper extends SQLiteOpenHelper {
        private void a(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table jobs (_id integer primary key, tag text not null, startMs integer, endMs integer, backoffMs integer, backoffPolicy text not null, intervalMs integer, requirementsEnforced integer, requiresCharging integer, requiresDeviceIdle integer, exact integer, networkType text not null, extras text, numFailures integer, scheduledAt integer, started integer, flexMs integer, flexSupport integer, lastRun integer, transient integer, requiresBatteryNotLow integer, requiresStorageNotLow integer);");
        }

        private void b(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("alter table jobs add column isTransient integer;");
        }

        private void c(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("alter table jobs add column flexMs integer;");
            sQLiteDatabase.execSQL("alter table jobs add column flexSupport integer;");
            ContentValues contentValues = new ContentValues();
            long j3 = JobRequest.f67885j;
            contentValues.put("intervalMs", Long.valueOf(j3));
            sQLiteDatabase.update("jobs", contentValues, "intervalMs>0 AND intervalMs<" + j3, new String[0]);
            sQLiteDatabase.execSQL("update jobs set flexMs = intervalMs;");
        }

        private void f(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("alter table jobs add column lastRun integer;");
        }

        private void i(SQLiteDatabase sQLiteDatabase) throws Throwable {
            SQLiteDatabase sQLiteDatabase2;
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase2 = sQLiteDatabase;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase2 = sQLiteDatabase;
            }
            try {
                sQLiteDatabase2.execSQL("create table jobs_new (_id integer primary key, tag text not null, startMs integer, endMs integer, backoffMs integer, backoffPolicy text not null, intervalMs integer, requirementsEnforced integer, requiresCharging integer, requiresDeviceIdle integer, exact integer, networkType text not null, extras text, numFailures integer, scheduledAt integer, started integer, flexMs integer, flexSupport integer, lastRun integer);");
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO ");
                sb.append("jobs_new");
                sb.append(" SELECT ");
                sb.append("_id");
                sb.append(",");
                sb.append("tag");
                sb.append(",");
                sb.append("startMs");
                sb.append(",");
                sb.append("endMs");
                sb.append(",");
                sb.append("backoffMs");
                sb.append(",");
                sb.append("backoffPolicy");
                sb.append(",");
                sb.append("intervalMs");
                sb.append(",");
                sb.append("requirementsEnforced");
                sb.append(",");
                sb.append("requiresCharging");
                sb.append(",");
                sb.append("requiresDeviceIdle");
                sb.append(",");
                sb.append("exact");
                sb.append(",");
                sb.append("networkType");
                sb.append(",");
                sb.append("extras");
                sb.append(",");
                sb.append("numFailures");
                sb.append(",");
                sb.append("scheduledAt");
                sb.append(",");
                sb.append("isTransient");
                sb.append(",");
                sb.append("flexMs");
                sb.append(",");
                sb.append("flexSupport");
                sb.append(",");
                sb.append("lastRun");
                sb.append(" FROM ");
                sb.append("jobs");
                sQLiteDatabase2 = sQLiteDatabase;
                sQLiteDatabase2.execSQL(sb.toString());
                sQLiteDatabase2.execSQL("DROP TABLE jobs");
                sQLiteDatabase2.execSQL("ALTER TABLE jobs_new RENAME TO jobs");
                sQLiteDatabase2.execSQL("alter table jobs add column transient integer;");
                sQLiteDatabase2.setTransactionSuccessful();
                sQLiteDatabase2.endTransaction();
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase2.endTransaction();
                throw th;
            }
        }

        private void j(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("alter table jobs add column requiresBatteryNotLow integer;");
            sQLiteDatabase.execSQL("alter table jobs add column requiresStorageNotLow integer;");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) throws Throwable {
            while (i3 < i4) {
                if (i3 == 1) {
                    b(sQLiteDatabase);
                } else if (i3 == 2) {
                    c(sQLiteDatabase);
                } else if (i3 == 3) {
                    f(sQLiteDatabase);
                } else if (i3 == 4) {
                    i(sQLiteDatabase);
                } else {
                    if (i3 != 5) {
                        throw new IllegalStateException("not implemented");
                    }
                    j(sQLiteDatabase);
                }
                i3++;
            }
        }

        private JobOpenHelper(Context context, String str) {
            super(context, str, null, 6, new JobStorageDatabaseErrorHandler());
        }
    }

    public JobStorage(Context context) {
        this(context, "evernote_jobs.db");
    }

    private void e(int i3) {
        synchronized (this.f67932d) {
            this.f67932d.add(String.valueOf(i3));
            this.f67929a.edit().putStringSet("FAILED_DELETE_IDS", this.f67932d).apply();
        }
    }

    private static void f(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void g(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !JobConfig.g()) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Exception unused) {
        }
    }

    private boolean h(int i3) {
        boolean z2;
        synchronized (this.f67932d) {
            try {
                z2 = !this.f67932d.isEmpty() && this.f67932d.contains(String.valueOf(i3));
            } finally {
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JobRequest m(int i3, boolean z2) throws Throwable {
        Throwable th;
        SQLiteDatabase sQLiteDatabaseK;
        Exception exc;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor2 = null;
        if (h(i3)) {
            return null;
        }
        String str = "_id=?";
        if (!z2) {
            try {
                str = "_id=? AND started<=0";
            } catch (Exception e3) {
                exc = e3;
                cursor = null;
                sQLiteDatabase = null;
                try {
                    f67928h.g(exc, "could not load id %d", Integer.valueOf(i3));
                    f(cursor);
                    g(sQLiteDatabase);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    sQLiteDatabaseK = sQLiteDatabase;
                    f(cursor2);
                    g(sQLiteDatabaseK);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabaseK = null;
                f(cursor2);
                g(sQLiteDatabaseK);
                throw th;
            }
        }
        String str2 = str;
        sQLiteDatabaseK = k();
        try {
            Cursor cursorQuery = sQLiteDatabaseK.query("jobs", null, str2, new String[]{String.valueOf(i3)}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        JobRequest jobRequestE = JobRequest.e(cursorQuery);
                        f(cursorQuery);
                        g(sQLiteDatabaseK);
                        return jobRequestE;
                    }
                } catch (Exception e4) {
                    sQLiteDatabase = sQLiteDatabaseK;
                    cursor = cursorQuery;
                    exc = e4;
                    f67928h.g(exc, "could not load id %d", Integer.valueOf(i3));
                    f(cursor);
                    g(sQLiteDatabase);
                } catch (Throwable th4) {
                    th = th4;
                    cursor2 = cursorQuery;
                    f(cursor2);
                    g(sQLiteDatabaseK);
                    throw th;
                }
            }
            f(cursorQuery);
            g(sQLiteDatabaseK);
        } catch (Exception e5) {
            exc = e5;
            sQLiteDatabase = sQLiteDatabaseK;
            cursor = null;
        } catch (Throwable th5) {
            th = th5;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(JobRequest jobRequest, int i3) {
        this.f67935g.writeLock().lock();
        SQLiteDatabase sQLiteDatabaseK = null;
        try {
            try {
                this.f67930b.remove(Integer.valueOf(i3));
                sQLiteDatabaseK = k();
                sQLiteDatabaseK.delete("jobs", "_id=?", new String[]{String.valueOf(i3)});
                g(sQLiteDatabaseK);
                this.f67935g.writeLock().unlock();
                return true;
            } catch (Exception e3) {
                f67928h.g(e3, "could not delete %d %s", Integer.valueOf(i3), jobRequest);
                e(i3);
                g(sQLiteDatabaseK);
                this.f67935g.writeLock().unlock();
                return false;
            }
        } catch (Throwable th) {
            g(sQLiteDatabaseK);
            this.f67935g.writeLock().unlock();
            throw th;
        }
    }

    private void r(JobRequest jobRequest) throws Throwable {
        ContentValues contentValuesN = jobRequest.N();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase sQLiteDatabaseK = k();
            try {
                if (sQLiteDatabaseK.insertWithOnConflict("jobs", null, contentValuesN, 5) < 0) {
                    throw new SQLException("Couldn't insert job request into database");
                }
                g(sQLiteDatabaseK);
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = sQLiteDatabaseK;
                g(sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void s() {
        new Thread("CleanupFinishedJobsThread") { // from class: com.evernote.android.job.JobStorage.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HashSet<String> hashSet;
                synchronized (JobStorage.this.f67932d) {
                    hashSet = new HashSet(JobStorage.this.f67932d);
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    try {
                        int i3 = Integer.parseInt((String) it.next());
                        if (JobStorage.this.q(null, i3)) {
                            it.remove();
                            JobStorage.f67928h.i("Deleted job %d which failed to delete earlier", Integer.valueOf(i3));
                        } else {
                            JobStorage.f67928h.e("Couldn't delete job %d which failed to delete earlier", Integer.valueOf(i3));
                        }
                    } catch (NumberFormatException unused) {
                        it.remove();
                    }
                }
                synchronized (JobStorage.this.f67932d) {
                    try {
                        JobStorage.this.f67932d.clear();
                        if (hashSet.size() > 50) {
                            int i4 = 0;
                            for (String str : hashSet) {
                                int i5 = i4 + 1;
                                if (i4 <= 50) {
                                    JobStorage.this.f67932d.add(str);
                                    i4 = i5;
                                }
                            }
                        } else {
                            JobStorage.this.f67932d.addAll(hashSet);
                        }
                    } finally {
                    }
                }
            }
        }.start();
    }

    private void u(JobRequest jobRequest) {
        this.f67930b.put(Integer.valueOf(jobRequest.o()), jobRequest);
    }

    public JobRequest i(int i3) {
        this.f67935g.readLock().lock();
        try {
            return this.f67930b.get(Integer.valueOf(i3));
        } finally {
            this.f67935g.readLock().unlock();
        }
    }

    public Set j(String str, boolean z2) {
        Throwable th;
        SQLiteDatabase sQLiteDatabaseK;
        Exception exc;
        String[] strArr;
        String str2;
        HashSet hashSet = new HashSet();
        this.f67935g.readLock().lock();
        Cursor cursorQuery = null;
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = z2 ? null : "ifnull(started, 0)<=0";
                strArr = null;
            } else {
                strArr = new String[]{str};
                str2 = (z2 ? "" : "ifnull(started, 0)<=0 AND ") + "tag=?";
            }
            sQLiteDatabaseK = k();
            try {
                try {
                    cursorQuery = sQLiteDatabaseK.query("jobs", null, str2, strArr, null, null, null);
                    HashMap map = new HashMap(this.f67930b.snapshot());
                    while (cursorQuery != null) {
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                        Integer numValueOf = Integer.valueOf(i3);
                        if (!h(i3)) {
                            if (map.containsKey(numValueOf)) {
                                hashSet.add((JobRequest) map.get(numValueOf));
                            } else {
                                hashSet.add(JobRequest.e(cursorQuery));
                            }
                        }
                    }
                } catch (Exception e3) {
                    exc = e3;
                    f67928h.g(exc, "could not load all jobs", new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                f(cursorQuery);
                g(sQLiteDatabaseK);
                this.f67935g.readLock().unlock();
                throw th;
            }
        } catch (Exception e4) {
            exc = e4;
            sQLiteDatabaseK = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabaseK = null;
            f(cursorQuery);
            g(sQLiteDatabaseK);
            this.f67935g.readLock().unlock();
            throw th;
        }
        f(cursorQuery);
        g(sQLiteDatabaseK);
        this.f67935g.readLock().unlock();
        return hashSet;
    }

    SQLiteDatabase k() {
        SQLiteDatabase sQLiteDatabase = this.f67934f;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase;
        }
        try {
            return this.f67933e.getWritableDatabase();
        } catch (SQLiteCantOpenDatabaseException e3) {
            f67928h.f(e3);
            new JobStorageDatabaseErrorHandler().b("evernote_jobs.db");
            return this.f67933e.getWritableDatabase();
        }
    }

    int l() throws Throwable {
        SQLiteDatabase sQLiteDatabaseK;
        int i3;
        Cursor cursorRawQuery = null;
        try {
            sQLiteDatabaseK = k();
            try {
                try {
                    cursorRawQuery = sQLiteDatabaseK.rawQuery("SELECT MAX(_id) FROM jobs", null);
                    i3 = (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) ? 0 : cursorRawQuery.getInt(0);
                    f(cursorRawQuery);
                    g(sQLiteDatabaseK);
                } catch (Exception e3) {
                    e = e3;
                    f67928h.f(e);
                    f(cursorRawQuery);
                    g(sQLiteDatabaseK);
                    i3 = 0;
                }
            } catch (Throwable th) {
                th = th;
                f(cursorRawQuery);
                g(sQLiteDatabaseK);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabaseK = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabaseK = null;
            f(cursorRawQuery);
            g(sQLiteDatabaseK);
            throw th;
        }
        return Math.max(JobConfig.c(), Math.max(i3, this.f67929a.getInt("JOB_ID_COUNTER_v2", 0)));
    }

    public synchronized int n() {
        int iIncrementAndGet;
        try {
            if (this.f67931c == null) {
                this.f67931c = new AtomicInteger(l());
            }
            iIncrementAndGet = this.f67931c.incrementAndGet();
            int iC = JobConfig.c();
            if (iIncrementAndGet < iC || iIncrementAndGet >= 2147480000) {
                this.f67931c.set(iC);
                iIncrementAndGet = this.f67931c.incrementAndGet();
            }
            this.f67929a.edit().putInt("JOB_ID_COUNTER_v2", iIncrementAndGet).apply();
        } catch (Throwable th) {
            throw th;
        }
        return iIncrementAndGet;
    }

    public void o(JobRequest jobRequest) {
        this.f67935g.writeLock().lock();
        try {
            r(jobRequest);
            u(jobRequest);
        } finally {
            this.f67935g.writeLock().unlock();
        }
    }

    public void p(JobRequest jobRequest) {
        q(jobRequest, jobRequest.o());
    }

    public void t(JobRequest jobRequest, ContentValues contentValues) {
        this.f67935g.writeLock().lock();
        SQLiteDatabase sQLiteDatabaseK = null;
        try {
            try {
                u(jobRequest);
                sQLiteDatabaseK = k();
                sQLiteDatabaseK.update("jobs", contentValues, "_id=?", new String[]{String.valueOf(jobRequest.o())});
            } catch (Exception e3) {
                f67928h.g(e3, "could not update %s", jobRequest);
            }
        } finally {
            g(sQLiteDatabaseK);
            this.f67935g.writeLock().unlock();
        }
    }

    public JobStorage(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("evernote_jobs", 0);
        this.f67929a = sharedPreferences;
        this.f67935g = new ReentrantReadWriteLock();
        this.f67930b = new JobCacheId();
        this.f67933e = new JobOpenHelper(context, str);
        Set<String> stringSet = sharedPreferences.getStringSet("FAILED_DELETE_IDS", new HashSet());
        this.f67932d = stringSet;
        if (stringSet.isEmpty()) {
            return;
        }
        s();
    }
}
