package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.core.SubscriptionOptionEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class SubscriptionOptionDao_Impl implements SubscriptionOptionDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f126126g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f126127h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f126128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f126129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126131d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f126132f;

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

    public SubscriptionOptionDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126128a = __db;
        this.f126129b = new EntityInsertAdapter<SubscriptionOptionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SubscriptionOptionDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `SubscriptionOptionEntity` (`id`,`productId`,`optionId`,`offerId`,`offerTags`,`offerToken`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SubscriptionOptionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.f());
                statement.p0(3, entity.e());
                statement.p0(4, entity.b());
                statement.p0(5, entity.c());
                String strD = entity.d();
                if (strD == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strD);
                }
            }
        };
        this.f126130c = new EntityDeleteOrUpdateAdapter<SubscriptionOptionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SubscriptionOptionDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `SubscriptionOptionEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SubscriptionOptionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f126131d = new EntityDeleteOrUpdateAdapter<SubscriptionOptionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SubscriptionOptionDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `SubscriptionOptionEntity` SET `id` = ?,`productId` = ?,`optionId` = ?,`offerId` = ?,`offerTags` = ?,`offerToken` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SubscriptionOptionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.f());
                statement.p0(3, entity.e());
                statement.p0(4, entity.b());
                statement.p0(5, entity.c());
                String strD = entity.d();
                if (strD == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strD);
                }
                statement.A(7, entity.a());
            }
        };
        this.f126132f = new EntityUpsertAdapter(new EntityInsertAdapter<SubscriptionOptionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SubscriptionOptionDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `SubscriptionOptionEntity` (`id`,`productId`,`optionId`,`offerId`,`offerTags`,`offerToken`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SubscriptionOptionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.f());
                statement.p0(3, entity.e());
                statement.p0(4, entity.b());
                statement.p0(5, entity.c());
                String strD = entity.d();
                if (strD == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strD);
                }
            }
        }, new EntityDeleteOrUpdateAdapter<SubscriptionOptionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SubscriptionOptionDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `SubscriptionOptionEntity` SET `id` = ?,`productId` = ?,`optionId` = ?,`offerId` = ?,`offerTags` = ?,`offerToken` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SubscriptionOptionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.f());
                statement.p0(3, entity.e());
                statement.p0(4, entity.b());
                statement.p0(5, entity.c());
                String strD = entity.d();
                if (strD == null) {
                    statement.D(6);
                } else {
                    statement.p0(6, strD);
                }
                statement.A(7, entity.a());
            }
        });
    }
}
