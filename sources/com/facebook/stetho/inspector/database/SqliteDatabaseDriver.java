package com.facebook.stetho.inspector.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SqliteDatabaseDriver extends DatabaseDriver2<SqliteDatabaseDescriptor> {
    private static final String[] UNINTERESTING_FILENAME_SUFFIXES = {"-journal", "-shm", "-uid", "-wal"};
    private final DatabaseConnectionProvider mDatabaseConnectionProvider;
    private final DatabaseFilesProvider mDatabaseFilesProvider;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SqliteDatabaseDescriptor implements DatabaseDescriptor {
        public final File file;

        public SqliteDatabaseDescriptor(File file) {
            this.file = file;
        }

        @Override // com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor
        public String name() {
            return this.file.getName();
        }
    }

    @Deprecated
    public SqliteDatabaseDriver(Context context) {
        this(context, new DefaultDatabaseFilesProvider(context), new DefaultDatabaseConnectionProvider());
    }

    private <T> T executeInsert(SQLiteDatabase sQLiteDatabase, String str, BaseDatabaseDriver.ExecuteResultHandler<T> executeResultHandler) {
        return executeResultHandler.handleInsert(sQLiteDatabase.compileStatement(str).executeInsert());
    }

    private <T> T executeRawQuery(SQLiteDatabase sQLiteDatabase, String str, BaseDatabaseDriver.ExecuteResultHandler<T> executeResultHandler) {
        sQLiteDatabase.execSQL(str);
        return executeResultHandler.handleRawQuery();
    }

    private <T> T executeSelect(SQLiteDatabase sQLiteDatabase, String str, BaseDatabaseDriver.ExecuteResultHandler<T> executeResultHandler) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, null);
        try {
            return executeResultHandler.handleSelect(cursorRawQuery);
        } finally {
            cursorRawQuery.close();
        }
    }

    private <T> T executeUpdateDelete(SQLiteDatabase sQLiteDatabase, String str, BaseDatabaseDriver.ExecuteResultHandler<T> executeResultHandler) {
        return executeResultHandler.handleUpdateDelete(sQLiteDatabase.compileStatement(str).executeUpdateDelete());
    }

    private static String getFirstWord(String str) {
        String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(32);
        return iIndexOf >= 0 ? strTrim.substring(0, iIndexOf) : strTrim;
    }

    private SQLiteDatabase openDatabase(SqliteDatabaseDescriptor sqliteDatabaseDescriptor) throws SQLiteException {
        Util.throwIfNull(sqliteDatabaseDescriptor);
        return this.mDatabaseConnectionProvider.openDatabase(sqliteDatabaseDescriptor.file);
    }

    private static String removeSuffix(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.endsWith(str2)) {
                return str.substring(0, str.length() - str2.length());
            }
        }
        return str;
    }

    static List<File> tidyDatabaseList(List<File> list) {
        HashSet hashSet = new HashSet(list);
        ArrayList arrayList = new ArrayList();
        for (File file : list) {
            String path = file.getPath();
            String strRemoveSuffix = removeSuffix(path, UNINTERESTING_FILENAME_SUFFIXES);
            if (strRemoveSuffix.equals(path) || !hashSet.contains(new File(strRemoveSuffix))) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver
    public /* bridge */ /* synthetic */ Database.ExecuteSQLResponse executeSQL(Object obj, String str, BaseDatabaseDriver.ExecuteResultHandler executeResultHandler) throws SQLiteException {
        return executeSQL((SqliteDatabaseDescriptor) obj, str, (BaseDatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse>) executeResultHandler);
    }

    @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver
    public List<SqliteDatabaseDescriptor> getDatabaseNames() {
        ArrayList arrayList = new ArrayList();
        List<File> databaseFiles = this.mDatabaseFilesProvider.getDatabaseFiles();
        Collections.sort(databaseFiles);
        Iterator<T> it = tidyDatabaseList(databaseFiles).iterator();
        while (it.hasNext()) {
            arrayList.add(new SqliteDatabaseDescriptor((File) it.next()));
        }
        return arrayList;
    }

    @Deprecated
    public SqliteDatabaseDriver(Context context, DatabaseFilesProvider databaseFilesProvider) {
        this(context, databaseFilesProvider, new DefaultDatabaseConnectionProvider());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r0.equals("UPDATE") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
    
        if (r0.equals("PRAGMA") != false) goto L24;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse executeSQL(com.facebook.stetho.inspector.database.SqliteDatabaseDriver.SqliteDatabaseDescriptor r3, java.lang.String r4, com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver.ExecuteResultHandler<com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse> r5) throws android.database.sqlite.SQLiteException {
        /*
            r2 = this;
            com.facebook.stetho.common.Util.throwIfNull(r4)
            com.facebook.stetho.common.Util.throwIfNull(r5)
            android.database.sqlite.SQLiteDatabase r3 = r2.openDatabase(r3)
            java.lang.String r0 = getFirstWord(r4)     // Catch: java.lang.Throwable -> L23
            java.lang.String r0 = r0.toUpperCase()     // Catch: java.lang.Throwable -> L23
            int r1 = r0.hashCode()     // Catch: java.lang.Throwable -> L23
            switch(r1) {
                case -2130463047: goto L5b;
                case -1926899396: goto L49;
                case -1852692228: goto L40;
                case -1785516855: goto L2e;
                case -591179561: goto L25;
                case 2012838315: goto L1a;
                default: goto L19;
            }     // Catch: java.lang.Throwable -> L23
        L19:
            goto L6d
        L1a:
            java.lang.String r1 = "DELETE"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L6d
            goto L36
        L23:
            r4 = move-exception
            goto L77
        L25:
            java.lang.String r1 = "EXPLAIN"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L6d
            goto L51
        L2e:
            java.lang.String r1 = "UPDATE"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L6d
        L36:
            java.lang.Object r4 = r2.executeUpdateDelete(r3, r4, r5)     // Catch: java.lang.Throwable -> L23
            com.facebook.stetho.inspector.protocol.module.Database$ExecuteSQLResponse r4 = (com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse) r4     // Catch: java.lang.Throwable -> L23
            r3.close()
            return r4
        L40:
            java.lang.String r1 = "SELECT"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L6d
            goto L51
        L49:
            java.lang.String r1 = "PRAGMA"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L6d
        L51:
            java.lang.Object r4 = r2.executeSelect(r3, r4, r5)     // Catch: java.lang.Throwable -> L23
            com.facebook.stetho.inspector.protocol.module.Database$ExecuteSQLResponse r4 = (com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse) r4     // Catch: java.lang.Throwable -> L23
            r3.close()
            return r4
        L5b:
            java.lang.String r1 = "INSERT"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L6d
            java.lang.Object r4 = r2.executeInsert(r3, r4, r5)     // Catch: java.lang.Throwable -> L23
            com.facebook.stetho.inspector.protocol.module.Database$ExecuteSQLResponse r4 = (com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse) r4     // Catch: java.lang.Throwable -> L23
            r3.close()
            return r4
        L6d:
            java.lang.Object r4 = r2.executeRawQuery(r3, r4, r5)     // Catch: java.lang.Throwable -> L23
            com.facebook.stetho.inspector.protocol.module.Database$ExecuteSQLResponse r4 = (com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse) r4     // Catch: java.lang.Throwable -> L23
            r3.close()
            return r4
        L77:
            r3.close()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.database.SqliteDatabaseDriver.executeSQL(com.facebook.stetho.inspector.database.SqliteDatabaseDriver$SqliteDatabaseDescriptor, java.lang.String, com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver$ExecuteResultHandler):com.facebook.stetho.inspector.protocol.module.Database$ExecuteSQLResponse");
    }

    @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver
    public List<String> getTableNames(SqliteDatabaseDescriptor sqliteDatabaseDescriptor) throws SQLiteException {
        SQLiteDatabase sQLiteDatabaseOpenDatabase = openDatabase(sqliteDatabaseDescriptor);
        try {
            Cursor cursorRawQuery = sQLiteDatabaseOpenDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type IN (?, ?)", new String[]{"table", ViewHierarchyConstants.VIEW_KEY});
            try {
                ArrayList arrayList = new ArrayList();
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(cursorRawQuery.getString(0));
                }
                return arrayList;
            } finally {
                cursorRawQuery.close();
            }
        } finally {
            sQLiteDatabaseOpenDatabase.close();
        }
    }

    public SqliteDatabaseDriver(Context context, DatabaseFilesProvider databaseFilesProvider, DatabaseConnectionProvider databaseConnectionProvider) {
        super(context);
        this.mDatabaseFilesProvider = databaseFilesProvider;
        this.mDatabaseConnectionProvider = databaseConnectionProvider;
    }
}
