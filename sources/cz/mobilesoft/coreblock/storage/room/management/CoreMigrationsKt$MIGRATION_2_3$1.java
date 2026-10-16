package cz.mobilesoft.coreblock.storage.room.management;

import android.database.sqlite.SQLiteDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.storage.greendao.GreendaoDatabase;
import cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class CoreMigrationsKt$MIGRATION_2_3$1 extends Migration implements KoinComponent {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f126698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f126699d;

    /* JADX WARN: Multi-variable type inference failed */
    CoreMigrationsKt$MIGRATION_2_3$1() {
        super(2, 3);
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f126698c = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProductDao>() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_2_3$1$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProductDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f126699d = LazyKt.a(lazyThreadSafetyModeB2, new Function0<GreendaoDatabase>() { // from class: cz.mobilesoft.coreblock.storage.room.management.CoreMigrationsKt$MIGRATION_2_3$1$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GreendaoDatabase.class), objArr2, objArr3);
            }
        });
    }

    private final GreendaoDatabase d() {
        return (GreendaoDatabase) this.f126699d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProductDao e() {
        return (ProductDao) this.f126698c.getValue();
    }

    @Override // androidx.room.migration.Migration
    public void b(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.S("\n                CREATE TABLE IF NOT EXISTS ProductEntity (\n                    `productId` TEXT NOT NULL,\n                    `revenueCatId` TEXT NOT NULL,\n                    `title` TEXT, \n                    `description` TEXT, \n                    `isSubscription` INTEGER NOT NULL, \n                    `currency` TEXT, \n                    `priceValue` REAL, \n                    `priceText` TEXT, \n                    `introductoryPriceValue` REAL, \n                    `introductoryPriceText` TEXT, \n                    `isActive` INTEGER NOT NULL, \n                    `isLifeTime` INTEGER NOT NULL, \n                    `orderInList` INTEGER NOT NULL, \n                    `purchaseToken` TEXT, \n                    `trialPeriod` TEXT, \n                    PRIMARY KEY(`productId`)\n                )\n            ");
        SQLiteDatabase sQLiteDatabaseA = d().a();
        if (sQLiteDatabaseA != null) {
            CoroutineScope applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
            BuildersKt__Builders_commonKt.d(applicationScope, null, null, new CoreMigrationsKt$MIGRATION_2_3$1$migrate$1(sQLiteDatabaseA, this, null), 3, null);
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
