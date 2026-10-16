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
public final class CoreDatabase_AutoMigration_6_7_Impl extends Migration {
    public CoreDatabase_AutoMigration_6_7_Impl() {
        super(6, 7);
    }

    @Override // androidx.room.migration.Migration
    public void a(SQLiteConnection connection) throws Exception {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `SubscriptionOfferEntity` (`offerToken` TEXT NOT NULL, `productId` TEXT NOT NULL, `offerId` TEXT NOT NULL, `offerTags` TEXT NOT NULL, PRIMARY KEY(`offerToken`), FOREIGN KEY(`productId`) REFERENCES `ProductEntity`(`productId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_SubscriptionOfferEntity_productId` ON `SubscriptionOfferEntity` (`productId`)");
        SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_SubscriptionOfferEntity_offerId` ON `SubscriptionOfferEntity` (`offerId`)");
        SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `PricingPhaseEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `offerToken` TEXT NOT NULL, `phaseIndex` INTEGER NOT NULL, `phaseType` INTEGER NOT NULL, `formattedPrice` TEXT NOT NULL, `priceAmount` REAL NOT NULL, `priceCurrencyCode` TEXT NOT NULL, `billingPeriod` TEXT NOT NULL, `billingCycleCount` INTEGER NOT NULL, `recurrenceMode` INTEGER NOT NULL, FOREIGN KEY(`offerToken`) REFERENCES `SubscriptionOfferEntity`(`offerToken`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_PricingPhaseEntity_offerToken` ON `PricingPhaseEntity` (`offerToken`)");
        SQLite.a(connection, "CREATE INDEX IF NOT EXISTS `index_PricingPhaseEntity_phaseIndex` ON `PricingPhaseEntity` (`phaseIndex`)");
        SQLite.a(connection, "CREATE TABLE IF NOT EXISTS `PurchasedOfferEntity` (`purchaseToken` TEXT NOT NULL, `productId` TEXT NOT NULL, `offerTags` TEXT NOT NULL, `purchaseTime` TEXT NOT NULL, `isSynchronized` INTEGER NOT NULL, PRIMARY KEY(`purchaseToken`))");
    }
}
