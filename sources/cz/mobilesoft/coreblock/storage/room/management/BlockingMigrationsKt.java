package cz.mobilesoft.coreblock.storage.room.management;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class BlockingMigrationsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Migration f126645a = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_1_2$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.S("ALTER TABLE `Profile` ADD COLUMN `pausedUntil` INTEGER NOT NULL DEFAULT 0");
            database.S("UPDATE `Profile` SET `pausedUntil` = -1 WHERE `isEnabled` = 0");
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Migration f126646b = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_3_4$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.S("UPDATE `Profile` SET `pausedUntil` = -1\nWHERE (\n    (\n        SELECT COUNT(*) FROM `Interval` \n        WHERE `Interval`.`profileId` = `Profile`.`id` \n        AND `Interval`.`isEnabled` = 0\n    ) > 0 OR (\n        SELECT COUNT(*) FROM `UsageLimit`\n        WHERE `UsageLimit`.`profileId` = `Profile`.`id`\n        AND `UsageLimit`.`originalAllowedCount` > 0\n    ) > 0 OR (\n        SELECT COUNT(*) FROM `WebsiteProfileRelation`\n        WHERE `WebsiteProfileRelation`.`profileId` = `Profile`.`id`\n        AND `WebsiteProfileRelation`.`isEnabled` = 0\n    ) > 0 OR (\n        SELECT COUNT(*) FROM `ApplicationProfileRelation`\n        WHERE `ApplicationProfileRelation`.`profileId` = `Profile`.`id`\n        AND `ApplicationProfileRelation`.`isEnabled` = 0\n    ) > 0\n)");
            database.S("UPDATE `Interval` SET `isEnabled` = 1");
            database.S("UPDATE `UsageLimit` SET `allowedCount` = `originalAllowedCount` WHERE `originalAllowedCount` > 0");
            database.S("UPDATE `UsageLimit` SET `originalAllowedCount` = 0");
            database.S("UPDATE `WebsiteProfileRelation` SET `isEnabled` = 1");
            database.S("UPDATE `ApplicationProfileRelation` SET `isEnabled` = 1");
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Migration f126647c = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_4_5$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.S("ALTER TABLE Profile ADD COLUMN emoji INTEGER NOT NULL DEFAULT " + ScheduleEmoji.NoIcon.getId());
            database.S("ALTER TABLE Profile ADD COLUMN blockUnsupportedBrowsers INTEGER NOT NULL DEFAULT 0");
            int iMask = ProfileType.TIME.mask();
            ScheduleEmoji scheduleEmoji = ScheduleEmoji.Clock;
            database.S("\n                    UPDATE Profile SET emoji = CASE\n                    WHEN typeCombinations & " + iMask + " != 0 THEN " + scheduleEmoji.getId() + "\n                    WHEN typeCombinations & " + ProfileType.LOCATION.mask() + " != 0 THEN " + ScheduleEmoji.Location.getId() + "\n                    WHEN typeCombinations & " + ProfileType.WIFI.mask() + " != 0 THEN " + ScheduleEmoji.Wifi.getId() + "\n                    WHEN typeCombinations & " + ProfileType.USAGE_LIMIT.mask() + " != 0 THEN " + ScheduleEmoji.Hourglass.getId() + "\n                    WHEN typeCombinations & " + ProfileType.LAUNCH_COUNT.mask() + " != 0 THEN " + ScheduleEmoji.Rocket.getId() + "\n                    ELSE " + scheduleEmoji.getId() + " END\n                    ");
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Migration f126648d = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_5_6$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.S("ALTER TABLE BrowserViewId ADD COLUMN showLocalHtml INTEGER NOT NULL DEFAULT 1");
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Migration f126649e = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_7_8$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            Cursor cursorW1 = null;
            try {
                try {
                    cursorW1 = database.W1("SELECT * FROM WebsiteProfileRelation");
                    int columnIndex = cursorW1.getColumnIndex("id");
                    int columnIndex2 = cursorW1.getColumnIndex("name");
                    int columnIndex3 = cursorW1.getColumnIndex("blockingType");
                    while (cursorW1.moveToNext()) {
                        long j3 = cursorW1.getLong(columnIndex);
                        String string = cursorW1.getString(columnIndex2);
                        if (cursorW1.getInt(columnIndex3) == WebsiteProfileRelation.BlockingType.DOMAIN.getId()) {
                            StringHelper stringHelper = StringHelper.f128649a;
                            Intrinsics.checkNotNull(string);
                            string = stringHelper.y(string, "((.*:)//)?(www\\.)?([A-Za-z0-9\\-]+(\\.[A-Za-z0-9\\-]+)+)(:[0-9]+)?(.*)");
                        }
                        database.S(StringsKt.n("\n                            UPDATE `WebsiteProfileRelation` SET `name` = '" + string + "'\n                            WHERE `id` = " + j3 + "\n                        "));
                    }
                    cursorW1.close();
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                    if (cursorW1 != null) {
                        cursorW1.close();
                    }
                }
            } catch (Throwable th) {
                if (cursorW1 != null) {
                    cursorW1.close();
                }
                throw th;
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Migration f126650f = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_8_9$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("CREATE TABLE IF NOT EXISTS `SchedulePauseHistoryTable` (`id` INTEGER NOT NULL, `pauseTimeSeconds` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Migration f126651g = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_9_10$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("ALTER TABLE Application ADD COLUMN isUninstalled INTEGER NOT NULL DEFAULT 0");
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Migration f126652h = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_10_11$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("UPDATE `WebsiteProfileRelation` SET name = LOWER(name)");
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Migration f126653i = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_12_13$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("DROP TABLE IF EXISTS `SubAppRelation`");
            db.S("CREATE TABLE IF NOT EXISTS `SubAppRelation` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n    `profileId` INTEGER NOT NULL, \n    `subAppId` TEXT NOT NULL, \n    FOREIGN KEY(`profileId`) REFERENCES `Profile`(`id`) ON DELETE CASCADE ON UPDATE NO ACTION\n)");
            db.S("CREATE INDEX IF NOT EXISTS `index_SubAppRelation_profileId` \nON `SubAppRelation` (`profileId`)");
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Migration f126654j = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_14_15$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (CoreMigrationsKt.a(db, "Application", "appCategories")) {
                return;
            }
            db.S("ALTER TABLE Application ADD COLUMN appCategories INTEGER NULL");
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Migration f126655k = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_15_16$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("ALTER TABLE SchedulePauseHistoryTable ADD COLUMN isForToday INTEGER NOT NULL DEFAULT 0");
            db.S("UPDATE SchedulePauseHistoryTable SET isForToday = 1 WHERE pauseTimeSeconds = -1");
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Migration f126656l = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_16_17$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("ALTER TABLE BrowserViewId ADD COLUMN detectionMethod TEXT");
            db.S("ALTER TABLE BrowserViewId ADD COLUMN extractionMethod TEXT");
            db.S("ALTER TABLE BrowserViewId ADD COLUMN clickToOpenUrlBarViewId TEXT");
        }
    };

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Migration f126657m = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_17_18$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("ALTER TABLE SchedulePauseHistoryTable ADD COLUMN profileId INTEGER");
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Migration f126658n = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_18_19$1
        /* JADX WARN: Finally extract failed */
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            int iMask = ProfileType.TIME.mask();
            String strN = StringsKt.n("\n            typeCombinations & " + iMask + " = 0\n            AND (typeCombinations & (typeCombinations - 1)) = 0\n            AND typeCombinations != " + ProfileType.QUICK_BLOCK.mask() + "\n            AND title != 'STRICT_MODE_TAG_V2'\n        ");
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT id FROM Profile WHERE ");
            sb.append(strN);
            Cursor cursorW1 = db.W1(sb.toString());
            try {
                int columnIndex = cursorW1.getColumnIndex("id");
                while (cursorW1.moveToNext()) {
                    arrayList.add(Long.valueOf(cursorW1.getLong(columnIndex)));
                }
                cursorW1.close();
                db.S(StringsKt.n("\n            UPDATE Profile  \n            SET typeCombinations = typeCombinations | " + iMask + ",\n                onConditions = onConditions | " + iMask + "\n            WHERE " + strN + "\n        "));
                if (arrayList.isEmpty()) {
                    return;
                }
                db.S(StringsKt.n("\n                INSERT INTO `Interval` (profileId, fromInMinutes, toInMinutes, isEnabled, isAllDayAuto)\n                SELECT id, 0, 1440, 1, 1\n                FROM Profile \n                WHERE id IN (" + CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null) + ")\n            "));
            } catch (Throwable th) {
                cursorW1.close();
                throw th;
            }
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Migration f126659o = new BlockingMigrationsKt$BLOCKING_MIGRATION_19_20$1();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Migration f126660p = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_20_21$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("DELETE FROM ApplicationProfileRelation\nWHERE packageName IN (\n    'com.samsung.accessibility',\n    'com.google.android.permissioncontroller',\n    'com.google.android.settings.intelligence'\n)");
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Migration f126661q = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_21_22$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S(StringsKt.n("\n                UPDATE `Profile`\n                SET `emoji` = CASE `emoji`\n                    WHEN 6 THEN " + ScheduleEmoji.Sleep.getId() + "\n                    WHEN 58 THEN " + ScheduleEmoji.Clock.getId() + "\n                    WHEN 69 THEN " + ScheduleEmoji.Lock.getId() + "\n                    WHEN 73 THEN " + ScheduleEmoji.MinusMark.getId() + "\n                    ELSE `emoji`\n                END\n                "));
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Migration f126662r = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_22_23$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("ALTER TABLE `Profile` ADD COLUMN `blockInAppPurchases` INTEGER NOT NULL DEFAULT 0");
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Migration f126663s = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.BlockingMigrationsKt$BLOCKING_MIGRATION_23_24$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.S("ALTER TABLE `Profile` ADD COLUMN `webBrowsingMode` INTEGER NOT NULL DEFAULT 0");
        }
    };

    public static final Migration a() {
        return f126652h;
    }

    public static final Migration b() {
        return f126653i;
    }

    public static final Migration c() {
        return f126654j;
    }

    public static final Migration d() {
        return f126655k;
    }

    public static final Migration e() {
        return f126656l;
    }

    public static final Migration f() {
        return f126657m;
    }

    public static final Migration g() {
        return f126658n;
    }

    public static final Migration h() {
        return f126659o;
    }

    public static final Migration i() {
        return f126645a;
    }

    public static final Migration j() {
        return f126660p;
    }

    public static final Migration k() {
        return f126661q;
    }

    public static final Migration l() {
        return f126662r;
    }

    public static final Migration m() {
        return f126663s;
    }

    public static final Migration n() {
        return f126646b;
    }

    public static final Migration o() {
        return f126647c;
    }

    public static final Migration p() {
        return f126648d;
    }

    public static final Migration q() {
        return f126649e;
    }

    public static final Migration r() {
        return f126650f;
    }

    public static final Migration s() {
        return f126651g;
    }
}
