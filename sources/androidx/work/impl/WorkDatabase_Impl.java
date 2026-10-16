package androidx.work.impl;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.RawWorkInfoDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile WorkSpecDao f54671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile DependencyDao f54672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile WorkTagDao f54673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile SystemIdInfoDao f54674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile WorkNameDao f54675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile WorkProgressDao f54676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile PreferenceDao f54677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile RawWorkInfoDao f54678i;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.f52129c.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f52127a).d(databaseConfiguration.f52128b).c(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(20) { // from class: androidx.work.impl.WorkDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.S("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                supportSQLiteDatabase.S("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.S("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                supportSQLiteDatabase.S("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.S("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.S("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                supportSQLiteDatabase.S("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.S("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d73d21f1bd82c9e5268b6dcf9fde2cb')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) WorkDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.get(i3)).b(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) WorkDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.S("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) WorkDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.get(i3)).f(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.c(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(2);
                map.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                map.put("prerequisite_id", new TableInfo.Column("prerequisite_id", "TEXT", true, 2, null, 1));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                hashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
                TableInfo tableInfo = new TableInfo("Dependency", map, hashSet, hashSet2);
                TableInfo tableInfoA = TableInfo.a(supportSQLiteDatabase, "Dependency");
                if (!tableInfo.equals(tableInfoA)) {
                    return new RoomOpenHelper.ValidationResult(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfoA);
                }
                HashMap map2 = new HashMap(30);
                map2.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                map2.put(ServerProtocol.DIALOG_PARAM_STATE, new TableInfo.Column(ServerProtocol.DIALOG_PARAM_STATE, "INTEGER", true, 0, null, 1));
                map2.put("worker_class_name", new TableInfo.Column("worker_class_name", "TEXT", true, 0, null, 1));
                map2.put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", "TEXT", true, 0, null, 1));
                map2.put("input", new TableInfo.Column("input", "BLOB", true, 0, null, 1));
                map2.put("output", new TableInfo.Column("output", "BLOB", true, 0, null, 1));
                map2.put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0, null, 1));
                map2.put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0, null, 1));
                map2.put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0, null, 1));
                map2.put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0, null, 1));
                map2.put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0, null, 1));
                map2.put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, null, 1));
                map2.put("last_enqueue_time", new TableInfo.Column("last_enqueue_time", "INTEGER", true, 0, "-1", 1));
                map2.put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, null, 1));
                map2.put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, null, 1));
                map2.put("run_in_foreground", new TableInfo.Column("run_in_foreground", "INTEGER", true, 0, null, 1));
                map2.put("out_of_quota_policy", new TableInfo.Column("out_of_quota_policy", "INTEGER", true, 0, null, 1));
                map2.put("period_count", new TableInfo.Column("period_count", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                map2.put("generation", new TableInfo.Column("generation", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                map2.put("next_schedule_time_override", new TableInfo.Column("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
                map2.put("next_schedule_time_override_generation", new TableInfo.Column("next_schedule_time_override_generation", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                map2.put("stop_reason", new TableInfo.Column("stop_reason", "INTEGER", true, 0, "-256", 1));
                map2.put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", true, 0, null, 1));
                map2.put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0, null, 1));
                map2.put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0, null, 1));
                map2.put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, null, 1));
                map2.put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, null, 1));
                map2.put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
                map2.put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
                map2.put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", true, 0, null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(2);
                hashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
                hashSet4.add(new TableInfo.Index("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
                TableInfo tableInfo2 = new TableInfo("WorkSpec", map2, hashSet3, hashSet4);
                TableInfo tableInfoA2 = TableInfo.a(supportSQLiteDatabase, "WorkSpec");
                if (!tableInfo2.equals(tableInfoA2)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tableInfo2 + "\n Found:\n" + tableInfoA2);
                }
                HashMap map3 = new HashMap(2);
                map3.put("tag", new TableInfo.Column("tag", "TEXT", true, 1, null, 1));
                map3.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                TableInfo tableInfo3 = new TableInfo("WorkTag", map3, hashSet5, hashSet6);
                TableInfo tableInfoA3 = TableInfo.a(supportSQLiteDatabase, "WorkTag");
                if (!tableInfo3.equals(tableInfoA3)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfoA3);
                }
                HashMap map4 = new HashMap(3);
                map4.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                map4.put("generation", new TableInfo.Column("generation", "INTEGER", true, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                map4.put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0, null, 1));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                TableInfo tableInfo4 = new TableInfo("SystemIdInfo", map4, hashSet7, new HashSet(0));
                TableInfo tableInfoA4 = TableInfo.a(supportSQLiteDatabase, "SystemIdInfo");
                if (!tableInfo4.equals(tableInfoA4)) {
                    return new RoomOpenHelper.ValidationResult(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tableInfo4 + "\n Found:\n" + tableInfoA4);
                }
                HashMap map5 = new HashMap(2);
                map5.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                map5.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                TableInfo tableInfo5 = new TableInfo("WorkName", map5, hashSet8, hashSet9);
                TableInfo tableInfoA5 = TableInfo.a(supportSQLiteDatabase, "WorkName");
                if (!tableInfo5.equals(tableInfoA5)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfoA5);
                }
                HashMap map6 = new HashMap(2);
                map6.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                map6.put("progress", new TableInfo.Column("progress", "BLOB", true, 0, null, 1));
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                TableInfo tableInfo6 = new TableInfo("WorkProgress", map6, hashSet10, new HashSet(0));
                TableInfo tableInfoA6 = TableInfo.a(supportSQLiteDatabase, "WorkProgress");
                if (!tableInfo6.equals(tableInfoA6)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + tableInfo6 + "\n Found:\n" + tableInfoA6);
                }
                HashMap map7 = new HashMap(2);
                map7.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, 1));
                map7.put("long_value", new TableInfo.Column("long_value", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("Preference", map7, new HashSet(0), new HashSet(0));
                TableInfo tableInfoA7 = TableInfo.a(supportSQLiteDatabase, "Preference");
                if (tableInfo7.equals(tableInfoA7)) {
                    return new RoomOpenHelper.ValidationResult(true, null);
                }
                return new RoomOpenHelper.ValidationResult(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfoA7);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.S("DROP TABLE IF EXISTS `Dependency`");
                supportSQLiteDatabase.S("DROP TABLE IF EXISTS `WorkSpec`");
                supportSQLiteDatabase.S("DROP TABLE IF EXISTS `WorkTag`");
                supportSQLiteDatabase.S("DROP TABLE IF EXISTS `SystemIdInfo`");
                supportSQLiteDatabase.S("DROP TABLE IF EXISTS `WorkName`");
                supportSQLiteDatabase.S("DROP TABLE IF EXISTS `WorkProgress`");
                supportSQLiteDatabase.S(KqqtdetwHMIO.qzQLBeZxOaQeiai);
                if (((RoomDatabase) WorkDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) WorkDatabase_Impl.this).mCallbacks.get(i3)).d(supportSQLiteDatabase);
                    }
                }
            }
        }, "7d73d21f1bd82c9e5268b6dcf9fde2cb", "3071c8717539de5d5353f4c8cd59a032")).b());
    }

    @Override // androidx.room.RoomDatabase
    public List getAutoMigrations(Map map) {
        return Arrays.asList(new WorkDatabase_AutoMigration_13_14_Impl(), new WorkDatabase_AutoMigration_14_15_Impl(), new WorkDatabase_AutoMigration_16_17_Impl(), new WorkDatabase_AutoMigration_17_18_Impl(), new WorkDatabase_AutoMigration_18_19_Impl(), new WorkDatabase_AutoMigration_19_20_Impl());
    }

    @Override // androidx.room.RoomDatabase
    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(WorkSpecDao.class, WorkSpecDao_Impl.O());
        map.put(DependencyDao.class, DependencyDao_Impl.e());
        map.put(WorkTagDao.class, WorkTagDao_Impl.f());
        map.put(SystemIdInfoDao.class, SystemIdInfoDao_Impl.j());
        map.put(WorkNameDao.class, WorkNameDao_Impl.c());
        map.put(WorkProgressDao.class, WorkProgressDao_Impl.a());
        map.put(PreferenceDao.class, PreferenceDao_Impl.d());
        map.put(RawWorkInfoDao.class, RawWorkInfoDao_Impl.g());
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public DependencyDao n() {
        DependencyDao dependencyDao;
        if (this.f54672c != null) {
            return this.f54672c;
        }
        synchronized (this) {
            try {
                if (this.f54672c == null) {
                    this.f54672c = new DependencyDao_Impl(this);
                }
                dependencyDao = this.f54672c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dependencyDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public PreferenceDao o() {
        PreferenceDao preferenceDao;
        if (this.f54677h != null) {
            return this.f54677h;
        }
        synchronized (this) {
            try {
                if (this.f54677h == null) {
                    this.f54677h = new PreferenceDao_Impl(this);
                }
                preferenceDao = this.f54677h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return preferenceDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public RawWorkInfoDao p() {
        RawWorkInfoDao rawWorkInfoDao;
        if (this.f54678i != null) {
            return this.f54678i;
        }
        synchronized (this) {
            try {
                if (this.f54678i == null) {
                    this.f54678i = new RawWorkInfoDao_Impl(this);
                }
                rawWorkInfoDao = this.f54678i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rawWorkInfoDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public SystemIdInfoDao q() {
        SystemIdInfoDao systemIdInfoDao;
        if (this.f54674e != null) {
            return this.f54674e;
        }
        synchronized (this) {
            try {
                if (this.f54674e == null) {
                    this.f54674e = new SystemIdInfoDao_Impl(this);
                }
                systemIdInfoDao = this.f54674e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return systemIdInfoDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkNameDao r() {
        WorkNameDao workNameDao;
        if (this.f54675f != null) {
            return this.f54675f;
        }
        synchronized (this) {
            try {
                if (this.f54675f == null) {
                    this.f54675f = new WorkNameDao_Impl(this);
                }
                workNameDao = this.f54675f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workNameDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkProgressDao s() {
        WorkProgressDao workProgressDao;
        if (this.f54676g != null) {
            return this.f54676g;
        }
        synchronized (this) {
            try {
                if (this.f54676g == null) {
                    this.f54676g = new WorkProgressDao_Impl(this);
                }
                workProgressDao = this.f54676g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workProgressDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkSpecDao t() {
        WorkSpecDao workSpecDao;
        if (this.f54671b != null) {
            return this.f54671b;
        }
        synchronized (this) {
            try {
                if (this.f54671b == null) {
                    this.f54671b = new WorkSpecDao_Impl(this);
                }
                workSpecDao = this.f54671b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workSpecDao;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkTagDao u() {
        WorkTagDao workTagDao;
        if (this.f54673d != null) {
            return this.f54673d;
        }
        synchronized (this) {
            try {
                if (this.f54673d == null) {
                    this.f54673d = new WorkTagDao_Impl(this);
                }
                workTagDao = this.f54673d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workTagDao;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        String str = YgVrd.HDtZxaQGpvFDxnx;
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.S("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.S("DELETE FROM `Dependency`");
            writableDatabase.S("DELETE FROM `WorkSpec`");
            writableDatabase.S("DELETE FROM `WorkTag`");
            writableDatabase.S("DELETE FROM `SystemIdInfo`");
            writableDatabase.S("DELETE FROM `WorkName`");
            writableDatabase.S("DELETE FROM `WorkProgress`");
            writableDatabase.S("DELETE FROM `Preference`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.W1("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.E()) {
                writableDatabase.S(str);
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", KqqtdetwHMIO.ZkHnuOLuUjL, "WorkName", "WorkProgress", "Preference");
    }
}
