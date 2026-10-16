package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.legacy.content.Werj.QgXempTBEfV;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.core.UsedBackdoorCodeEntity;
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
public final class UsedBackdoorCodeDao_Impl implements UsedBackdoorCodeDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f126140g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f126141h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f126142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f126143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126145d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f126146f;

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

    public UsedBackdoorCodeDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126142a = __db;
        this.f126143b = new EntityInsertAdapter<UsedBackdoorCodeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.UsedBackdoorCodeDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `UsedBackdoorCodeEntity` (`id`,`code`,`timeInMillis`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, UsedBackdoorCodeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.b());
                statement.p0(2, entity.a());
                statement.A(3, entity.c());
            }
        };
        this.f126144c = new EntityDeleteOrUpdateAdapter<UsedBackdoorCodeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.UsedBackdoorCodeDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `UsedBackdoorCodeEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, UsedBackdoorCodeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.b());
            }
        };
        this.f126145d = new EntityDeleteOrUpdateAdapter<UsedBackdoorCodeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.UsedBackdoorCodeDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `UsedBackdoorCodeEntity` SET `id` = ?,`code` = ?,`timeInMillis` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement sQLiteStatement, UsedBackdoorCodeEntity entity) {
                Intrinsics.checkNotNullParameter(sQLiteStatement, QgXempTBEfV.TMBP);
                Intrinsics.checkNotNullParameter(entity, "entity");
                sQLiteStatement.A(1, entity.b());
                sQLiteStatement.p0(2, entity.a());
                sQLiteStatement.A(3, entity.c());
                sQLiteStatement.A(4, entity.b());
            }
        };
        this.f126146f = new EntityUpsertAdapter(new EntityInsertAdapter<UsedBackdoorCodeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.UsedBackdoorCodeDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `UsedBackdoorCodeEntity` (`id`,`code`,`timeInMillis`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, UsedBackdoorCodeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.b());
                statement.p0(2, entity.a());
                statement.A(3, entity.c());
            }
        }, new EntityDeleteOrUpdateAdapter<UsedBackdoorCodeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.UsedBackdoorCodeDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `UsedBackdoorCodeEntity` SET `id` = ?,`code` = ?,`timeInMillis` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, UsedBackdoorCodeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.b());
                statement.p0(2, entity.a());
                statement.A(3, entity.c());
                statement.A(4, entity.b());
            }
        });
    }
}
