package com.evernote.android.job;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Pair;
import com.evernote.android.job.util.JobCat;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class JobStorageDatabaseErrorHandler implements DatabaseErrorHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JobCat f67938a = new JobCat("DatabaseErrorHandler");

    JobStorageDatabaseErrorHandler() {
    }

    void a(File file) {
        SQLiteDatabase.deleteDatabase(file);
    }

    void b(String str) {
        if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
            return;
        }
        f67938a.d("deleting the database file: " + str);
        try {
            a(new File(str));
        } catch (Exception e3) {
            f67938a.l(e3, "delete failed: " + e3.getMessage(), new Object[0]);
        }
    }

    @Override // android.database.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        f67938a.d("Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
        if (!sQLiteDatabase.isOpen()) {
            b(sQLiteDatabase.getPath());
            return;
        }
        List<Pair<String, String>> attachedDbs = null;
        try {
            try {
                attachedDbs = sQLiteDatabase.getAttachedDbs();
            } catch (SQLiteException unused) {
            }
            try {
                sQLiteDatabase.close();
            } catch (SQLiteException unused2) {
            }
        } finally {
            if (attachedDbs != null) {
                Iterator<Pair<String, String>> it = attachedDbs.iterator();
                while (it.hasNext()) {
                    b((String) it.next().second);
                }
            } else {
                b(sQLiteDatabase.getPath());
            }
        }
    }
}
