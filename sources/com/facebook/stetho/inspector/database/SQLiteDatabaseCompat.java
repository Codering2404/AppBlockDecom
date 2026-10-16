package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SQLiteDatabaseCompat {
    public static final int ENABLE_FOREIGN_KEY_CONSTRAINTS = 2;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 1;
    private static final SQLiteDatabaseCompat sInstance = new JellyBeanAndBeyondImpl();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class IceCreamSandwichImpl extends SQLiteDatabaseCompat {
        private IceCreamSandwichImpl() {
        }

        @Override // com.facebook.stetho.inspector.database.SQLiteDatabaseCompat
        public void enableFeatures(int i3, SQLiteDatabase sQLiteDatabase) {
            if ((i3 & 1) != 0) {
                sQLiteDatabase.enableWriteAheadLogging();
            }
            if ((i3 & 2) != 0) {
                sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            }
        }

        @Override // com.facebook.stetho.inspector.database.SQLiteDatabaseCompat
        public int provideOpenFlags(int i3) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class JellyBeanAndBeyondImpl extends SQLiteDatabaseCompat {
        private JellyBeanAndBeyondImpl() {
        }

        @Override // com.facebook.stetho.inspector.database.SQLiteDatabaseCompat
        public void enableFeatures(int i3, SQLiteDatabase sQLiteDatabase) {
            if ((i3 & 2) != 0) {
                sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
            }
        }

        @Override // com.facebook.stetho.inspector.database.SQLiteDatabaseCompat
        public int provideOpenFlags(int i3) {
            return (i3 & 1) != 0 ? 536870912 : 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface SQLiteOpenOptions {
    }

    public static SQLiteDatabaseCompat getInstance() {
        return sInstance;
    }

    public abstract void enableFeatures(int i3, SQLiteDatabase sQLiteDatabase);

    public abstract int provideOpenFlags(int i3);
}
