package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.core.LaunchTimeEntity;
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
public final class LaunchTimeDao_Impl extends LaunchTimeDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f126008g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f126009h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f126010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f126011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126013d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f126014f;

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

    public LaunchTimeDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126010a = __db;
        this.f126011b = new EntityInsertAdapter<LaunchTimeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `LaunchTime` (`timestamp`) VALUES (?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, LaunchTimeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f126012c = new EntityDeleteOrUpdateAdapter<LaunchTimeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `LaunchTime` WHERE `timestamp` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, LaunchTimeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f126013d = new EntityDeleteOrUpdateAdapter<LaunchTimeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `LaunchTime` SET `timestamp` = ? WHERE `timestamp` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, LaunchTimeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.a());
            }
        };
        this.f126014f = new EntityUpsertAdapter(new EntityInsertAdapter<LaunchTimeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `LaunchTime` (`timestamp`) VALUES (?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, LaunchTimeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        }, new EntityDeleteOrUpdateAdapter<LaunchTimeEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `LaunchTime` SET `timestamp` = ? WHERE `timestamp` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, LaunchTimeEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long T(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long V(LaunchTimeDao_Impl launchTimeDao_Impl, LaunchTimeEntity launchTimeEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return launchTimeDao_Impl.f126011b.d(_connection, launchTimeEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List W(LaunchTimeDao_Impl launchTimeDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return launchTimeDao_Impl.f126011b.e(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao
    public Object J(final long j3, Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM LaunchTime WHERE timestamp > ?";
        return DBUtil.g(this.f126010a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(LaunchTimeDao_Impl.T(str, j3, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao
    public Object K(long j3, Continuation continuation) {
        return DBUtil.f(this.f126010a, new LaunchTimeDao_Impl$existAnyLaunchesAfter$2(this, j3, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao
    public Object M(Continuation continuation) {
        Object objF = DBUtil.f(this.f126010a, new LaunchTimeDao_Impl$saveTodayLaunchTime$2(this, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public Object n(final LaunchTimeEntity launchTimeEntity, Continuation continuation) {
        return DBUtil.g(this.f126010a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.d1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(LaunchTimeDao_Impl.V(this.f126176a, launchTimeEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f126010a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.e1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LaunchTimeDao_Impl.W(this.f126183a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
