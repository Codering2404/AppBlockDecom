package cz.mobilesoft.coreblock.storage.room.management;

import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class BlockingDatabase_AutoMigration_24_25_Impl extends Migration {
    public BlockingDatabase_AutoMigration_24_25_Impl() {
        super(24, 25);
    }

    @Override // androidx.room.migration.Migration
    public void a(SQLiteConnection connection) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `StreakDay` (`dayKey` TEXT NOT NULL, `dayStartMillis` INTEGER NOT NULL, `timeZoneId` TEXT NOT NULL, `status` INTEGER NOT NULL DEFAULT 0, `lossReason` INTEGER NOT NULL DEFAULT 0, `evaluatedAtMillis` INTEGER NOT NULL, `earnedAtMillis` INTEGER, `rulesVersion` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`dayKey`))");
        SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `StreakActivitySession` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER, `startMillis` INTEGER NOT NULL, `endMillis` INTEGER NOT NULL, `createdAtMillis` INTEGER NOT NULL)");
        SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakActivitySession_profileId` ON `StreakActivitySession` (`profileId`)");
        SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakActivitySession_startMillis` ON `StreakActivitySession` (`startMillis`)");
        SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakActivitySession_endMillis` ON `StreakActivitySession` (`endMillis`)");
        SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `StreakPauseRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `profileId` INTEGER NOT NULL, `startMillis` INTEGER NOT NULL, `plannedEndMillis` INTEGER NOT NULL, `endedAtMillis` INTEGER, `isIndefinite` INTEGER NOT NULL DEFAULT 0)");
        SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakPauseRecord_profileId` ON `StreakPauseRecord` (`profileId`)");
        SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_StreakPauseRecord_startMillis` ON `StreakPauseRecord` (`startMillis`)");
    }
}
