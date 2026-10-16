package com.superwall.sdk.storage.core_data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao;
import com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao_Impl;
import com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao;
import com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class SuperwallDatabase_Impl extends SuperwallDatabase {
    private volatile ManagedEventDataDao _managedEventDataDao;
    private volatile ManagedTriggerRuleOccurrenceDao _managedTriggerRuleOccurrenceDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.S("DELETE FROM `ManagedEventData`");
            writableDatabase.S("DELETE FROM `ManagedTriggerRuleOccurrence`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.W1("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.E()) {
                writableDatabase.S("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "ManagedEventData", "ManagedTriggerRuleOccurrence");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.f52129c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f52127a).d(databaseConfiguration.f52128b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.superwall.sdk.storage.core_data.SuperwallDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS `ManagedEventData` (`id` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `name` TEXT NOT NULL, `parameters` TEXT NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS `ManagedTriggerRuleOccurrence` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `createdAt` INTEGER NOT NULL, `occurrenceKey` TEXT NOT NULL)");
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.S("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '11f00dc53be30cfe213781d453297cf1')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.S("DROP TABLE IF EXISTS `ManagedEventData`");
                supportSQLiteDatabase.S("DROP TABLE IF EXISTS `ManagedTriggerRuleOccurrence`");
                List list = ((RoomDatabase) SuperwallDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).d(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                List list = ((RoomDatabase) SuperwallDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).b(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) SuperwallDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                SuperwallDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List list = ((RoomDatabase) SuperwallDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).f(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.c(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(4);
                map.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                map.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                map.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                map.put("parameters", new TableInfo.Column("parameters", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("ManagedEventData", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfoA = TableInfo.a(supportSQLiteDatabase, "ManagedEventData");
                if (!tableInfo.equals(tableInfoA)) {
                    return new RoomOpenHelper.ValidationResult(false, "ManagedEventData(com.superwall.sdk.storage.core_data.entities.ManagedEventData).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfoA);
                }
                HashMap map2 = new HashMap(3);
                map2.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, 1));
                map2.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                map2.put("occurrenceKey", new TableInfo.Column("occurrenceKey", "TEXT", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("ManagedTriggerRuleOccurrence", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfoA2 = TableInfo.a(supportSQLiteDatabase, "ManagedTriggerRuleOccurrence");
                if (tableInfo2.equals(tableInfoA2)) {
                    return new RoomOpenHelper.ValidationResult(true, null);
                }
                return new RoomOpenHelper.ValidationResult(false, "ManagedTriggerRuleOccurrence(com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrence).\n Expected:\n" + tableInfo2 + "\n Found:\n" + tableInfoA2);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }
        }, "11f00dc53be30cfe213781d453297cf1", "ee4655b3ec0d2ace448aa481008538b7")).b());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(ManagedEventDataDao.class, ManagedEventDataDao_Impl.getRequiredConverters());
        map.put(ManagedTriggerRuleOccurrenceDao.class, ManagedTriggerRuleOccurrenceDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // com.superwall.sdk.storage.core_data.SuperwallDatabase
    public ManagedEventDataDao managedEventDataDao() {
        ManagedEventDataDao managedEventDataDao;
        if (this._managedEventDataDao != null) {
            return this._managedEventDataDao;
        }
        synchronized (this) {
            try {
                if (this._managedEventDataDao == null) {
                    this._managedEventDataDao = new ManagedEventDataDao_Impl(this);
                }
                managedEventDataDao = this._managedEventDataDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return managedEventDataDao;
    }

    @Override // com.superwall.sdk.storage.core_data.SuperwallDatabase
    public ManagedTriggerRuleOccurrenceDao managedTriggerRuleOccurrenceDao() {
        ManagedTriggerRuleOccurrenceDao managedTriggerRuleOccurrenceDao;
        if (this._managedTriggerRuleOccurrenceDao != null) {
            return this._managedTriggerRuleOccurrenceDao;
        }
        synchronized (this) {
            try {
                if (this._managedTriggerRuleOccurrenceDao == null) {
                    this._managedTriggerRuleOccurrenceDao = new ManagedTriggerRuleOccurrenceDao_Impl(this);
                }
                managedTriggerRuleOccurrenceDao = this._managedTriggerRuleOccurrenceDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return managedTriggerRuleOccurrenceDao;
    }
}
