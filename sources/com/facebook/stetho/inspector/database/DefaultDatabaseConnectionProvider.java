package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultDatabaseConnectionProvider implements DatabaseConnectionProvider {
    protected int determineOpenOptions(File file) {
        String parent = file.getParent();
        StringBuilder sb = new StringBuilder();
        sb.append(file.getName());
        sb.append("-wal");
        return new File(parent, sb.toString()).exists() ? 1 : 0;
    }

    @Override // com.facebook.stetho.inspector.database.DatabaseConnectionProvider
    public SQLiteDatabase openDatabase(File file) throws SQLiteException {
        return performOpen(file, determineOpenOptions(file));
    }

    protected SQLiteDatabase performOpen(File file, int i3) {
        SQLiteDatabaseCompat sQLiteDatabaseCompat = SQLiteDatabaseCompat.getInstance();
        SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, sQLiteDatabaseCompat.provideOpenFlags(i3));
        sQLiteDatabaseCompat.enableFeatures(i3, sQLiteDatabaseOpenDatabase);
        return sQLiteDatabaseOpenDatabase;
    }
}
