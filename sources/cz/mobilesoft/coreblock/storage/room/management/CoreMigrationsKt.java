package cz.mobilesoft.coreblock.storage.room.management;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.facebook.appevents.AppEventsConstants;
import cz.mobilesoft.coreblock.enums.SubscriptionOfferId;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
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
public final class CoreMigrationsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Migration f126689a = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_1_2$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.S("CREATE TABLE IF NOT EXISTS TokenFCMEntity (isSyncedWithServer INTEGER NOT NULL, token TEXT NOT NULL, PRIMARY KEY(token))");
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Migration f126690b = new CoreMigrationsKt$MIGRATION_2_3$1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Migration f126691c = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_3_4$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            try {
                database.S("ALTER TABLE `ProductEntity` ADD COLUMN `deactivationTimeInMillis` INTEGER DEFAULT NULL");
            } catch (SQLiteException e3) {
                String message = e3.getMessage();
                if (message == null || !StringsKt.a0(message, "duplicate", false, 2, null)) {
                    throw e3;
                }
                e3.printStackTrace();
            }
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Migration f126692d = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_7_8$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.S("UPDATE `SubscriptionOfferEntity` SET `offerId` = '" + SubscriptionOfferId.ID_PREFIX + "' || `offerId` WHERE `offerId` NOT LIKE '" + SubscriptionOfferId.ID_PREFIX + "%'");
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Migration f126693e = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_9_10$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            if (!CoreMigrationsKt.a(database, "ProductEntity", "revenueCatId")) {
                database.S("ALTER TABLE `ProductEntity` ADD COLUMN `revenueCatId` TEXT NOT NULL DEFAULT ''");
            }
            database.S("CREATE INDEX IF NOT EXISTS `index_ProductEntity_revenueCatId` ON `ProductEntity` (`revenueCatId`)");
            database.S("UPDATE `ProductEntity` SET `revenueCatId` = `productId`");
            database.S("DROP TABLE IF EXISTS `SubscriptionOfferEntity`");
            database.S("DROP TABLE IF EXISTS `PricingPhaseEntity`");
            database.S("CREATE TABLE IF NOT EXISTS `SubscriptionOptionEntity` (\n  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n  `productId` TEXT NOT NULL, \n  `optionId` TEXT NOT NULL, \n  `offerId` TEXT NOT NULL, \n  `offerTags` TEXT NOT NULL,\n  `offerToken` TEXT,\n  FOREIGN KEY(`productId`) REFERENCES `ProductEntity`(`productId`) ON UPDATE NO ACTION ON DELETE CASCADE\n)");
            database.S("CREATE INDEX IF NOT EXISTS `index_SubscriptionOptionEntity_productId` ON `SubscriptionOptionEntity` (`productId`)");
            database.S("CREATE INDEX IF NOT EXISTS `index_SubscriptionOptionEntity_optionId` ON `SubscriptionOptionEntity` (`optionId`)");
            database.S("CREATE INDEX IF NOT EXISTS `index_SubscriptionOptionEntity_offerId` ON `SubscriptionOptionEntity` (`offerId`)");
            database.S("CREATE TABLE IF NOT EXISTS `PricingPhaseEntity` (\n  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n  `optionId` INTEGER NOT NULL, \n  `phaseIndex` INTEGER NOT NULL, \n  `phaseType` INTEGER NOT NULL, \n  `formattedPrice` TEXT NOT NULL, \n  `priceAmount` REAL NOT NULL, \n  `priceCurrencyCode` TEXT NOT NULL, \n  `billingPeriod` TEXT NOT NULL, \n  `billingCycleCount` INTEGER NOT NULL, \n  `recurrenceMode` INTEGER NOT NULL, \n  FOREIGN KEY(`optionId`) REFERENCES `SubscriptionOptionEntity`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE\n)");
            database.S("CREATE INDEX IF NOT EXISTS `index_PricingPhaseEntity_optionId` ON `PricingPhaseEntity` (`optionId`)");
            database.S("CREATE INDEX IF NOT EXISTS `index_PricingPhaseEntity_phaseIndex` ON `PricingPhaseEntity` (`phaseIndex`)");
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Migration f126694f = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_11_12$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.S("DROP TABLE IF EXISTS `BlockingConfig`");
            database.S("CREATE TABLE `BlockingConfig` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `config_type` INTEGER NOT NULL, \n    `blocking_message` TEXT NOT NULL,\n    `show_reason` INTEGER NOT NULL,\n    `timeout_seconds` INTEGER NOT NULL,\n    `show_counter` INTEGER NOT NULL,\n    `icon_res` INTEGER NOT NULL,\n    `custom_title` TEXT NOT NULL,\n    `custom_subtitle` TEXT NOT NULL,\n    `custom_exit_button_text` TEXT NOT NULL,\n    `custom_color_hex` TEXT NOT NULL\n)");
            for (CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity : CollectionsKt.listOf((Object[]) new CustomBlockingScreenConfigEntity[]{new CustomBlockingScreenConfigEntity(null, ConfigType.DEFAULT, null, false, 0, false, 0, null, null, null, null, 2045, null), new CustomBlockingScreenConfigEntity(null, ConfigType.ROTATING, null, false, 0, false, 0, null, null, null, null, 2045, null)})) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("config_type", Integer.valueOf(customBlockingScreenConfigEntity.m().ordinal()));
                contentValues.put("blocking_message", customBlockingScreenConfigEntity.c());
                contentValues.put("show_reason", Integer.valueOf(customBlockingScreenConfigEntity.j() ? 1 : 0));
                contentValues.put("timeout_seconds", Integer.valueOf(customBlockingScreenConfigEntity.l()));
                contentValues.put("show_counter", Integer.valueOf(customBlockingScreenConfigEntity.k() ? 1 : 0));
                contentValues.put("icon_res", Integer.valueOf(customBlockingScreenConfigEntity.h()));
                contentValues.put("custom_title", customBlockingScreenConfigEntity.g());
                contentValues.put("custom_subtitle", customBlockingScreenConfigEntity.f());
                contentValues.put("custom_exit_button_text", customBlockingScreenConfigEntity.e());
                contentValues.put("custom_color_hex", customBlockingScreenConfigEntity.d());
                database.a2("BlockingConfig", 1, contentValues);
            }
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Migration f126695g = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_12_13$1
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Cursor cursor;
            Throwable th;
            String str;
            Cursor cursor2;
            String str2;
            Intrinsics.checkNotNullParameter(database, "database");
            database.S("CREATE TABLE `BlockingConfig_new` (\n    `id` TEXT PRIMARY KEY NOT NULL,\n    `config_type` INTEGER NOT NULL, \n    `blocking_message` TEXT NOT NULL,\n    `show_reason` INTEGER NOT NULL,\n    `timeout_seconds` INTEGER NOT NULL,\n    `show_counter` INTEGER NOT NULL,\n    `icon_res` INTEGER NOT NULL,\n    `custom_title` TEXT NOT NULL,\n    `custom_subtitle` TEXT NOT NULL,\n    `custom_exit_button_text` TEXT NOT NULL,\n    `custom_color_hex` TEXT NOT NULL\n)");
            database.S("INSERT INTO `BlockingConfig_new` \nSELECT \n    CAST(`id` AS TEXT),\n    `config_type`, `blocking_message`, `show_reason`, \n    `timeout_seconds`, `show_counter`, `icon_res`, `custom_title`, \n    `custom_subtitle`, `custom_exit_button_text`, `custom_color_hex`\nFROM `BlockingConfig`");
            ArrayList arrayList = new ArrayList();
            ConfigType configType = ConfigType.DEFAULT;
            Cursor cursorW1 = database.W1("SELECT 1 FROM BlockingConfig_new WHERE config_type = " + configType.ordinal() + " LIMIT 1");
            try {
                if (cursorW1.getCount() == 0) {
                    try {
                        str2 = "SELECT 1 FROM BlockingConfig_new WHERE config_type = ";
                        str = " LIMIT 1";
                        cursor2 = cursorW1;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursorW1;
                    }
                    try {
                        arrayList.add(new CustomBlockingScreenConfigEntity(AppEventsConstants.EVENT_PARAM_VALUE_YES, configType, null, false, 0, false, 0, null, null, null, null, 2044, null));
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        cursor = cursor2;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            CloseableKt.a(cursor, th);
                            throw th4;
                        }
                    }
                } else {
                    str = " LIMIT 1";
                    cursor2 = cursorW1;
                    str2 = "SELECT 1 FROM BlockingConfig_new WHERE config_type = ";
                }
                try {
                    Unit unit = Unit.f139807a;
                    CloseableKt.a(cursor2, null);
                    ConfigType configType2 = ConfigType.ROTATING;
                    Cursor cursorW12 = database.W1(str2 + configType2.ordinal() + str);
                    try {
                        if (cursorW12.getCount() == 0) {
                            arrayList.add(new CustomBlockingScreenConfigEntity("2", configType2, null, false, 0, false, 0, null, null, null, null, 2044, null));
                        }
                        CloseableKt.a(cursorW12, null);
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i3 = 0;
                            while (i3 < size) {
                                Object obj = arrayList.get(i3);
                                i3++;
                                CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity = (CustomBlockingScreenConfigEntity) obj;
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("id", customBlockingScreenConfigEntity.i());
                                contentValues.put("config_type", Integer.valueOf(customBlockingScreenConfigEntity.m().ordinal()));
                                contentValues.put("blocking_message", customBlockingScreenConfigEntity.c());
                                contentValues.put("show_reason", Integer.valueOf(customBlockingScreenConfigEntity.j() ? 1 : 0));
                                contentValues.put("timeout_seconds", Integer.valueOf(customBlockingScreenConfigEntity.l()));
                                contentValues.put("show_counter", Integer.valueOf(customBlockingScreenConfigEntity.k() ? 1 : 0));
                                contentValues.put("icon_res", Integer.valueOf(customBlockingScreenConfigEntity.h()));
                                contentValues.put("custom_title", customBlockingScreenConfigEntity.g());
                                contentValues.put("custom_subtitle", customBlockingScreenConfigEntity.f());
                                contentValues.put("custom_exit_button_text", customBlockingScreenConfigEntity.e());
                                contentValues.put("custom_color_hex", customBlockingScreenConfigEntity.d());
                                database.a2("BlockingConfig_new", 1, contentValues);
                            }
                        }
                        database.S("DROP TABLE `BlockingConfig`");
                        database.S("ALTER TABLE `BlockingConfig_new` RENAME TO `BlockingConfig`");
                    } finally {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = cursor2;
                    th = th;
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                cursor = cursorW1;
            }
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Migration f126696h = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_13_14$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.S("CREATE TABLE IF NOT EXISTS `MoodCheckInEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mood` INTEGER NOT NULL, `mood_raw_value` INTEGER NOT NULL, `day` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `note` TEXT)");
            database.S("CREATE UNIQUE INDEX IF NOT EXISTS `index_MoodCheckInEntity_day` ON `MoodCheckInEntity` (`day`)");
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Migration f126697i = new Migration() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_14_15$1
        @Override // androidx.room.migration.Migration
        public void b(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            if (!CoreMigrationsKt.a(database, "AppVersionEntity", "whatsNewShownInPast")) {
                database.S("ALTER TABLE `AppVersionEntity` ADD COLUMN `whatsNewShownInPast` INTEGER NOT NULL DEFAULT 0");
            }
            if (CoreMigrationsKt.a(database, "AppVersionEntity", "whatsNewShowingNow")) {
                return;
            }
            database.S("ALTER TABLE `AppVersionEntity` ADD COLUMN `whatsNewShowingNow` INTEGER NOT NULL DEFAULT 0");
        }
    };

    public static final boolean a(SupportSQLiteDatabase database, String tableName, String columnName) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(columnName, "columnName");
        Cursor cursorW1 = database.W1("PRAGMA table_info(" + tableName + ")");
        while (cursorW1.moveToNext()) {
            try {
                if (Intrinsics.areEqual(cursorW1.getString(cursorW1.getColumnIndexOrThrow("name")), columnName)) {
                    CloseableKt.a(cursorW1, null);
                    return true;
                }
            } finally {
            }
        }
        Unit unit = Unit.f139807a;
        CloseableKt.a(cursorW1, null);
        return false;
    }

    public static final Migration b() {
        return f126694f;
    }

    public static final Migration c() {
        return f126695g;
    }

    public static final Migration d() {
        return f126696h;
    }

    public static final Migration e() {
        return f126697i;
    }

    public static final Migration f() {
        return f126689a;
    }

    public static final Migration g() {
        return f126690b;
    }

    public static final Migration h() {
        return f126691c;
    }

    public static final Migration i() {
        return f126692d;
    }

    public static final Migration j() {
        return f126693e;
    }
}
