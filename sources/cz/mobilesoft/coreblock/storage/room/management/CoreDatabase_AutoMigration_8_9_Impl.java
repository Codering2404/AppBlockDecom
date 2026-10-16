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
public final class CoreDatabase_AutoMigration_8_9_Impl extends Migration {
    public CoreDatabase_AutoMigration_8_9_Impl() {
        super(8, 9);
    }

    @Override // androidx.room.migration.Migration
    public void a(SQLiteConnection connection) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `IgnoredStatisticsItem` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `type` INTEGER NOT NULL, `itemSourceType` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, `isInstalled` INTEGER NOT NULL)");
        SQLite.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_IgnoredStatisticsItem_name_type` ON `IgnoredStatisticsItem` (`name`, `type`)");
        SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `LaunchTime` (`timestamp` INTEGER NOT NULL, PRIMARY KEY(`timestamp`))");
    }
}
