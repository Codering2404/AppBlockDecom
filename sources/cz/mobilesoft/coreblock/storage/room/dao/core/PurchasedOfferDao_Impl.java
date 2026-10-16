package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.core.PurchasedOfferEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
public final class PurchasedOfferDao_Impl implements PurchasedOfferDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f126073g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f126074h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f126075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f126076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126078d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f126079f;

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

    public PurchasedOfferDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126075a = __db;
        this.f126076b = new EntityInsertAdapter<PurchasedOfferEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PurchasedOfferDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `PurchasedOfferEntity` (`purchaseToken`,`productId`,`offerTags`,`purchaseTime`,`isSynchronized`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PurchasedOfferEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.d());
                statement.p0(2, entity.b());
                statement.p0(3, entity.a());
                statement.p0(4, entity.c());
                statement.A(5, entity.e() ? 1L : 0L);
            }
        };
        this.f126077c = new EntityDeleteOrUpdateAdapter<PurchasedOfferEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PurchasedOfferDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `PurchasedOfferEntity` WHERE `purchaseToken` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PurchasedOfferEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.d());
            }
        };
        this.f126078d = new EntityDeleteOrUpdateAdapter<PurchasedOfferEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PurchasedOfferDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `PurchasedOfferEntity` SET `purchaseToken` = ?,`productId` = ?,`offerTags` = ?,`purchaseTime` = ?,`isSynchronized` = ? WHERE `purchaseToken` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PurchasedOfferEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.d());
                statement.p0(2, entity.b());
                statement.p0(3, entity.a());
                statement.p0(4, entity.c());
                statement.A(5, entity.e() ? 1L : 0L);
                statement.p0(6, entity.d());
            }
        };
        this.f126079f = new EntityUpsertAdapter(new EntityInsertAdapter<PurchasedOfferEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PurchasedOfferDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `PurchasedOfferEntity` (`purchaseToken`,`productId`,`offerTags`,`purchaseTime`,`isSynchronized`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PurchasedOfferEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.d());
                statement.p0(2, entity.b());
                statement.p0(3, entity.a());
                statement.p0(4, entity.c());
                statement.A(5, entity.e() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<PurchasedOfferEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PurchasedOfferDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `PurchasedOfferEntity` SET `purchaseToken` = ?,`productId` = ?,`offerTags` = ?,`purchaseTime` = ?,`isSynchronized` = ? WHERE `purchaseToken` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PurchasedOfferEntity purchasedOfferEntity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(purchasedOfferEntity, jTYhJgqLBN.jhiZvOsItYSMcGy);
                statement.p0(1, purchasedOfferEntity.d());
                statement.p0(2, purchasedOfferEntity.b());
                statement.p0(3, purchasedOfferEntity.a());
                statement.p0(4, purchasedOfferEntity.c());
                statement.A(5, purchasedOfferEntity.e() ? 1L : 0L);
                statement.p0(6, purchasedOfferEntity.d());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(PurchasedOfferDao_Impl purchasedOfferDao_Impl, Collection collection, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        purchasedOfferDao_Impl.f126078d.d(_connection, collection);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object r(final Collection collection, Continuation continuation) {
        Object objG = DBUtil.g(this.f126075a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.u1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PurchasedOfferDao_Impl.L(this.f126323a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }
}
