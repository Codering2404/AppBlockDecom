package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.core.ProductEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ProductDao_Impl extends ProductDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f126066g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f126067h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f126068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f126069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126071d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f126072f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return CollectionsKt.emptyList();
        }

        private Companion() {
        }
    }

    public ProductDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126068a = __db;
        this.f126069b = new EntityInsertAdapter<ProductEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `ProductEntity` (`productId`,`revenueCatId`,`title`,`description`,`isSubscription`,`currency`,`priceValue`,`priceText`,`introductoryPriceValue`,`introductoryPriceText`,`isActive`,`orderInList`,`purchaseToken`,`trialPeriod`,`isLifeTime`,`deactivationTimeInMillis`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ProductEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
                statement.p0(2, entity.k());
                String strL = entity.l();
                if (strL == null) {
                    statement.D(3);
                } else {
                    statement.p0(3, strL);
                }
                String strC = entity.c();
                if (strC == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strC);
                }
                statement.A(5, entity.p() ? 1L : 0L);
                String strA = entity.a();
                if (strA == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strA);
                }
                Double dH = entity.h();
                if (dH == null) {
                    statement.D(7);
                } else {
                    statement.t(7, dH.doubleValue());
                }
                String strG = entity.g();
                if (strG == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strG);
                }
                Double dE = entity.e();
                if (dE == null) {
                    statement.D(9);
                } else {
                    statement.t(9, dE.doubleValue());
                }
                String strD = entity.d();
                if (strD == null) {
                    statement.D(10);
                } else {
                    statement.p0(10, strD);
                }
                statement.A(11, entity.n() ? 1L : 0L);
                statement.A(12, entity.f());
                String strJ = entity.j();
                if (strJ == null) {
                    statement.D(13);
                } else {
                    statement.p0(13, strJ);
                }
                String strM = entity.m();
                if (strM == null) {
                    statement.D(14);
                } else {
                    statement.p0(14, strM);
                }
                statement.A(15, entity.o() ? 1L : 0L);
                Long lB = entity.b();
                if (lB == null) {
                    statement.D(16);
                } else {
                    statement.A(16, lB.longValue());
                }
            }
        };
        this.f126070c = new EntityDeleteOrUpdateAdapter<ProductEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `ProductEntity` WHERE `productId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ProductEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
            }
        };
        this.f126071d = new EntityDeleteOrUpdateAdapter<ProductEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `ProductEntity` SET `productId` = ?,`revenueCatId` = ?,`title` = ?,`description` = ?,`isSubscription` = ?,`currency` = ?,`priceValue` = ?,`priceText` = ?,`introductoryPriceValue` = ?,`introductoryPriceText` = ?,`isActive` = ?,`orderInList` = ?,`purchaseToken` = ?,`trialPeriod` = ?,`isLifeTime` = ?,`deactivationTimeInMillis` = ? WHERE `productId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ProductEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
                statement.p0(2, entity.k());
                String strL = entity.l();
                if (strL == null) {
                    statement.D(3);
                } else {
                    statement.p0(3, strL);
                }
                String strC = entity.c();
                if (strC == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strC);
                }
                statement.A(5, entity.p() ? 1L : 0L);
                String strA = entity.a();
                if (strA == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strA);
                }
                Double dH = entity.h();
                if (dH == null) {
                    statement.D(7);
                } else {
                    statement.t(7, dH.doubleValue());
                }
                String strG = entity.g();
                if (strG == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strG);
                }
                Double dE = entity.e();
                if (dE == null) {
                    statement.D(9);
                } else {
                    statement.t(9, dE.doubleValue());
                }
                String strD = entity.d();
                if (strD == null) {
                    statement.D(10);
                } else {
                    statement.p0(10, strD);
                }
                statement.A(11, entity.n() ? 1L : 0L);
                statement.A(12, entity.f());
                String strJ = entity.j();
                if (strJ == null) {
                    statement.D(13);
                } else {
                    statement.p0(13, strJ);
                }
                String strM = entity.m();
                if (strM == null) {
                    statement.D(14);
                } else {
                    statement.p0(14, strM);
                }
                statement.A(15, entity.o() ? 1L : 0L);
                Long lB = entity.b();
                if (lB == null) {
                    statement.D(16);
                } else {
                    statement.A(16, lB.longValue());
                }
                statement.p0(17, entity.i());
            }
        };
        this.f126072f = new EntityUpsertAdapter(new EntityInsertAdapter<ProductEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `ProductEntity` (`productId`,`revenueCatId`,`title`,`description`,`isSubscription`,`currency`,`priceValue`,`priceText`,`introductoryPriceValue`,`introductoryPriceText`,`isActive`,`orderInList`,`purchaseToken`,`trialPeriod`,`isLifeTime`,`deactivationTimeInMillis`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ProductEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
                statement.p0(2, entity.k());
                String strL = entity.l();
                if (strL == null) {
                    statement.D(3);
                } else {
                    statement.p0(3, strL);
                }
                String strC = entity.c();
                if (strC == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strC);
                }
                statement.A(5, entity.p() ? 1L : 0L);
                String strA = entity.a();
                if (strA == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strA);
                }
                Double dH = entity.h();
                if (dH == null) {
                    statement.D(7);
                } else {
                    statement.t(7, dH.doubleValue());
                }
                String strG = entity.g();
                if (strG == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strG);
                }
                Double dE = entity.e();
                if (dE == null) {
                    statement.D(9);
                } else {
                    statement.t(9, dE.doubleValue());
                }
                String strD = entity.d();
                if (strD == null) {
                    statement.D(10);
                } else {
                    statement.p0(10, strD);
                }
                statement.A(11, entity.n() ? 1L : 0L);
                statement.A(12, entity.f());
                String strJ = entity.j();
                if (strJ == null) {
                    statement.D(13);
                } else {
                    statement.p0(13, strJ);
                }
                String strM = entity.m();
                if (strM == null) {
                    statement.D(14);
                } else {
                    statement.p0(14, strM);
                }
                statement.A(15, entity.o() ? 1L : 0L);
                Long lB = entity.b();
                if (lB == null) {
                    statement.D(16);
                } else {
                    statement.A(16, lB.longValue());
                }
            }
        }, new EntityDeleteOrUpdateAdapter<ProductEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.ProductDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `ProductEntity` SET `productId` = ?,`revenueCatId` = ?,`title` = ?,`description` = ?,`isSubscription` = ?,`currency` = ?,`priceValue` = ?,`priceText` = ?,`introductoryPriceValue` = ?,`introductoryPriceText` = ?,`isActive` = ?,`orderInList` = ?,`purchaseToken` = ?,`trialPeriod` = ?,`isLifeTime` = ?,`deactivationTimeInMillis` = ? WHERE `productId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ProductEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.i());
                statement.p0(2, entity.k());
                String strL = entity.l();
                if (strL == null) {
                    statement.D(3);
                } else {
                    statement.p0(3, strL);
                }
                String strC = entity.c();
                if (strC == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strC);
                }
                statement.A(5, entity.p() ? 1L : 0L);
                String strA = entity.a();
                if (strA == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strA);
                }
                Double dH = entity.h();
                if (dH == null) {
                    statement.D(7);
                } else {
                    statement.t(7, dH.doubleValue());
                }
                String strG = entity.g();
                if (strG == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strG);
                }
                Double dE = entity.e();
                if (dE == null) {
                    statement.D(9);
                } else {
                    statement.t(9, dE.doubleValue());
                }
                String strD = entity.d();
                if (strD == null) {
                    statement.D(10);
                } else {
                    statement.p0(10, strD);
                }
                statement.A(11, entity.n() ? 1L : 0L);
                statement.A(12, entity.f());
                String strJ = entity.j();
                if (strJ == null) {
                    statement.D(13);
                } else {
                    statement.p0(13, strJ);
                }
                String strM = entity.m();
                if (strM == null) {
                    statement.D(14);
                } else {
                    statement.p0(14, strM);
                }
                statement.A(15, entity.o() ? 1L : 0L);
                Long lB = entity.b();
                if (lB == null) {
                    statement.D(16);
                } else {
                    statement.A(16, lB.longValue());
                }
                statement.p0(17, entity.i());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K(ProductDao_Impl productDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return productDao_Impl.f126069b.e(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f126068a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.t1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProductDao_Impl.K(this.f126316a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
