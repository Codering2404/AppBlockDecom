package cz.mobilesoft.statistics.model.datasource;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.facebook.appevents.AppEventsConstants;
import cz.mobilesoft.statistics.model.dao.ApplicationAppTypeDao;
import cz.mobilesoft.statistics.model.dao.ApplicationAppTypeDao_Impl;
import cz.mobilesoft.statistics.model.dao.NotificationRecordDao;
import cz.mobilesoft.statistics.model.dao.NotificationRecordDao_Impl;
import cz.mobilesoft.statistics.model.dao.RecordDao;
import cz.mobilesoft.statistics.model.dao.RecordDao_Impl;
import cz.mobilesoft.statistics.model.datasource.StatisticsDatabase_Impl;
import d.qFm.sECyKyO;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StatisticsDatabase_Impl extends StatisticsDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f133765a = LazyKt.b(new Function0() { // from class: o2.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return StatisticsDatabase_Impl.v(this.f143860a);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f133766b = LazyKt.b(new Function0() { // from class: o2.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return StatisticsDatabase_Impl.t(this.f143861a);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f133767c = LazyKt.b(new Function0() { // from class: o2.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return StatisticsDatabase_Impl.u(this.f143862a);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplicationAppTypeDao_Impl t(StatisticsDatabase_Impl statisticsDatabase_Impl) {
        return new ApplicationAppTypeDao_Impl(statisticsDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationRecordDao_Impl u(StatisticsDatabase_Impl statisticsDatabase_Impl) {
        return new NotificationRecordDao_Impl(statisticsDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecordDao_Impl v(StatisticsDatabase_Impl statisticsDatabase_Impl) {
        return new RecordDao_Impl(statisticsDatabase_Impl);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "record", "applicationAppType", "notificationRecord");
    }

    @Override // androidx.room.RoomDatabase
    public List createAutoMigrations(Map autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StatisticsDatabase_AutoMigration_4_5_Impl());
        arrayList.add(new StatisticsDatabase_AutoMigration_5_6_Impl());
        return arrayList;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "record", "applicationAppType", "notificationRecord");
    }

    @Override // androidx.room.RoomDatabase
    public Set getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.b(RecordDao.class), RecordDao_Impl.f133756f.a());
        linkedHashMap.put(Reflection.b(ApplicationAppTypeDao.class), ApplicationAppTypeDao_Impl.f133744f.a());
        linkedHashMap.put(Reflection.b(NotificationRecordDao.class), NotificationRecordDao_Impl.f133750f.a());
        return linkedHashMap;
    }

    @Override // cz.mobilesoft.statistics.model.datasource.StatisticsDatabase
    public ApplicationAppTypeDao n() {
        return (ApplicationAppTypeDao) this.f133766b.getValue();
    }

    @Override // cz.mobilesoft.statistics.model.datasource.StatisticsDatabase
    public NotificationRecordDao o() {
        return (NotificationRecordDao) this.f133767c.getValue();
    }

    @Override // cz.mobilesoft.statistics.model.datasource.StatisticsDatabase
    public RecordDao p() {
        return (RecordDao) this.f133765a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: cz.mobilesoft.statistics.model.datasource.StatisticsDatabase_Impl$createOpenDelegate$_openDelegate$1
            {
                super(6, "be4248b8febf41714cb80e42d3be820b", "ae907f350b1ee9b9bb7ee89ccf87e895");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void a(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `record` (`timestamp` INTEGER NOT NULL, `originalBeginTime` INTEGER NOT NULL, `name` TEXT NOT NULL, `parentName` TEXT, `typeId` INTEGER NOT NULL, `duration` INTEGER NOT NULL DEFAULT 60, `isInitial` INTEGER NOT NULL DEFAULT 0, `appType` TEXT, `category` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_record_timestamp_name` ON `record` (`timestamp`, `name`)");
                SQLite.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_record_timestamp_originalBeginTime_typeId` ON `record` (`timestamp`, `originalBeginTime`, `typeId`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `applicationAppType` (`packageName` TEXT NOT NULL, `appDistractionType` TEXT NOT NULL, PRIMARY KEY(`packageName`))");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `notificationRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `name` TEXT NOT NULL)");
                SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_notificationRecord_timestamp_name` ON `notificationRecord` (`timestamp`, `name`)");
                SQLite.a(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.a(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'be4248b8febf41714cb80e42d3be820b')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void b(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.a(connection, "DROP TABLE IF EXISTS `record`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `applicationAppType`");
                SQLite.a(connection, "DROP TABLE IF EXISTS `notificationRecord`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void f(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void g(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                this.f133768d.internalInitInvalidationTracker(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void h(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void i(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.b(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public RoomOpenDelegate.ValidationResult j(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("originalBeginTime", new TableInfo.Column("originalBeginTime", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                linkedHashMap.put("parentName", new TableInfo.Column("parentName", "TEXT", false, 0, null, 1));
                TableInfo.Column column = new TableInfo.Column(sECyKyO.aweOWcJnaciss, "INTEGER", true, 0, null, 1);
                String str = sECyKyO.aweOWcJnaciss;
                linkedHashMap.put(str, column);
                linkedHashMap.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, "60", 1));
                linkedHashMap.put("isInitial", new TableInfo.Column("isInitial", "INTEGER", true, 0, AppEventsConstants.EVENT_PARAM_VALUE_NO, 1));
                linkedHashMap.put("appType", new TableInfo.Column("appType", "TEXT", false, 0, null, 1));
                linkedHashMap.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, 1));
                linkedHashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new TableInfo.Index("index_record_timestamp_name", false, CollectionsKt.listOf((Object[]) new String[]{"timestamp", "name"}), CollectionsKt.listOf((Object[]) new String[]{"ASC", "ASC"})));
                linkedHashSet2.add(new TableInfo.Index("index_record_timestamp_originalBeginTime_typeId", true, CollectionsKt.listOf((Object[]) new String[]{"timestamp", "originalBeginTime", str}), CollectionsKt.listOf((Object[]) new String[]{"ASC", "ASC", "ASC"})));
                TableInfo tableInfo = new TableInfo("record", linkedHashMap, linkedHashSet, linkedHashSet2);
                TableInfo.Companion companion = TableInfo.f52966e;
                TableInfo tableInfoA = companion.a(connection, "record");
                if (!tableInfo.equals(tableInfoA)) {
                    return new RoomOpenDelegate.ValidationResult(false, "record(cz.mobilesoft.statistics.model.Record).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfoA);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 1, null, 1));
                linkedHashMap2.put("appDistractionType", new TableInfo.Column("appDistractionType", "TEXT", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("applicationAppType", linkedHashMap2, new LinkedHashSet(), new LinkedHashSet());
                TableInfo tableInfoA2 = companion.a(connection, "applicationAppType");
                if (!tableInfo2.equals(tableInfoA2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "applicationAppType(cz.mobilesoft.statistics.model.ApplicationAppType).\n Expected:\n" + tableInfo2 + "\n Found:\n" + tableInfoA2);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap3.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                linkedHashMap3.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                linkedHashSet4.add(new TableInfo.Index("index_notificationRecord_timestamp_name", false, CollectionsKt.listOf((Object[]) new String[]{"timestamp", "name"}), CollectionsKt.listOf((Object[]) new String[]{"ASC", "ASC"})));
                TableInfo tableInfo3 = new TableInfo("notificationRecord", linkedHashMap3, linkedHashSet3, linkedHashSet4);
                TableInfo tableInfoA3 = companion.a(connection, "notificationRecord");
                if (tableInfo3.equals(tableInfoA3)) {
                    return new RoomOpenDelegate.ValidationResult(true, null);
                }
                return new RoomOpenDelegate.ValidationResult(false, "notificationRecord(cz.mobilesoft.statistics.model.NotificationRecord).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfoA3);
            }
        };
    }
}
