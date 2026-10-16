package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakActivitySessionEntity;
import java.util.ArrayList;
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
public final class StreakActivitySessionDao_Impl extends StreakActivitySessionDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f125193g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f125194h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125198d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f125199f;

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

    public StreakActivitySessionDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125195a = __db;
        this.f125196b = new EntityInsertAdapter<StreakActivitySessionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `StreakActivitySession` (`id`,`profileId`,`startMillis`,`endMillis`,`createdAtMillis`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakActivitySessionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                Long lF = entity.f();
                if (lF == null) {
                    statement.D(2);
                } else {
                    statement.A(2, lF.longValue());
                }
                statement.A(3, entity.g());
                statement.A(4, entity.d());
                statement.A(5, entity.c());
            }
        };
        this.f125197c = new EntityDeleteOrUpdateAdapter<StreakActivitySessionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `StreakActivitySession` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakActivitySessionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
            }
        };
        this.f125198d = new EntityDeleteOrUpdateAdapter<StreakActivitySessionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `StreakActivitySession` SET `id` = ?,`profileId` = ?,`startMillis` = ?,`endMillis` = ?,`createdAtMillis` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakActivitySessionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                Long lF = entity.f();
                if (lF == null) {
                    statement.D(2);
                } else {
                    statement.A(2, lF.longValue());
                }
                statement.A(3, entity.g());
                statement.A(4, entity.d());
                statement.A(5, entity.c());
                statement.A(6, entity.e());
            }
        };
        this.f125199f = new EntityUpsertAdapter(new EntityInsertAdapter<StreakActivitySessionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `StreakActivitySession` (`id`,`profileId`,`startMillis`,`endMillis`,`createdAtMillis`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakActivitySessionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                Long lF = entity.f();
                if (lF == null) {
                    statement.D(2);
                } else {
                    statement.A(2, lF.longValue());
                }
                statement.A(3, entity.g());
                statement.A(4, entity.d());
                statement.A(5, entity.c());
            }
        }, new EntityDeleteOrUpdateAdapter<StreakActivitySessionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `StreakActivitySession` SET `id` = ?,`profileId` = ?,`startMillis` = ?,`endMillis` = ?,`createdAtMillis` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakActivitySessionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                Long lF = entity.f();
                if (lF == null) {
                    statement.D(2);
                } else {
                    statement.A(2, lF.longValue());
                }
                statement.A(3, entity.g());
                statement.A(4, entity.d());
                statement.A(5, entity.c());
                statement.A(6, entity.e());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(StreakActivitySessionDao_Impl streakActivitySessionDao_Impl, StreakActivitySessionEntity streakActivitySessionEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        streakActivitySessionDao_Impl.f125197c.c(_connection, streakActivitySessionEntity);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b0(String str, long j3, Long l3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            if (l3 == null) {
                sQLiteStatementG2.D(2);
            } else {
                sQLiteStatementG2.A(2, l3.longValue());
            }
            if (l3 == null) {
                sQLiteStatementG2.D(3);
            } else {
                sQLiteStatementG2.A(3, l3.longValue());
            }
            boolean z2 = false;
            if (sQLiteStatementG2.B2()) {
                z2 = ((int) sQLiteStatementG2.getLong(0)) != 0;
            }
            sQLiteStatementG2.close();
            return z2;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c0(String str, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "startMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "endMillis");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "createdAtMillis");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new StreakActivitySessionEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.isNull(iD2) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD2)), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.getLong(iD5)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakActivitySessionEntity d0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "startMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "endMillis");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "createdAtMillis");
            StreakActivitySessionEntity streakActivitySessionEntity = null;
            if (sQLiteStatementG2.B2()) {
                streakActivitySessionEntity = new StreakActivitySessionEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.isNull(iD2) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD2)), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.getLong(iD5));
            }
            return streakActivitySessionEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e0(String str, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "startMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "endMillis");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "createdAtMillis");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new StreakActivitySessionEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.isNull(iD2) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD2)), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.getLong(iD5)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g0(StreakActivitySessionDao_Impl streakActivitySessionDao_Impl, StreakActivitySessionEntity streakActivitySessionEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return streakActivitySessionDao_Impl.f125196b.d(_connection, streakActivitySessionEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(StreakActivitySessionDao_Impl streakActivitySessionDao_Impl, StreakActivitySessionEntity streakActivitySessionEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        streakActivitySessionDao_Impl.f125198d.c(_connection, streakActivitySessionEntity);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao
    public Object J(final long j3, Continuation continuation) {
        final String str = "DELETE FROM StreakActivitySession WHERE endMillis < ?";
        Object objG = DBUtil.g(this.f125195a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.l4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakActivitySessionDao_Impl.a0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao
    public Object K(final Long l3, final long j3, Continuation continuation) {
        final String str = "\n            SELECT EXISTS(\n                SELECT 1 FROM StreakActivitySession\n                WHERE startMillis = ?\n                AND ((profileId = ?) OR (profileId IS NULL AND ? IS NULL))\n            )\n            ";
        return DBUtil.g(this.f125195a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.s4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StreakActivitySessionDao_Impl.b0(str, j3, l3, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao
    public Object L(final long j3, final long j4, Continuation continuation) {
        final String str = "\n            SELECT * FROM StreakActivitySession\n            WHERE startMillis < ? AND endMillis > ?\n            ORDER BY startMillis ASC\n            ";
        return DBUtil.g(this.f125195a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.q4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakActivitySessionDao_Impl.c0(str, j4, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao
    public Object M(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM StreakActivitySession WHERE endMillis > ? ORDER BY startMillis DESC LIMIT 1";
        return DBUtil.g(this.f125195a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.o4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakActivitySessionDao_Impl.d0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao
    public Object N(final long j3, final long j4, Continuation continuation) {
        final String str = "\n            SELECT * FROM StreakActivitySession\n            WHERE profileId = ? AND endMillis > ?\n            ORDER BY startMillis ASC\n            ";
        return DBUtil.g(this.f125195a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.t4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakActivitySessionDao_Impl.e0(str, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public Object q(final StreakActivitySessionEntity streakActivitySessionEntity, Continuation continuation) {
        Object objG = DBUtil.g(this.f125195a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.n4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakActivitySessionDao_Impl.Y(this.f125565a, streakActivitySessionEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakActivitySessionDao
    public Object deleteAll(Continuation continuation) {
        final String str = "DELETE FROM StreakActivitySession";
        Object objG = DBUtil.g(this.f125195a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.p4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakActivitySessionDao_Impl.Z(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public Object n(final StreakActivitySessionEntity streakActivitySessionEntity, Continuation continuation) {
        return DBUtil.g(this.f125195a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.r4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(StreakActivitySessionDao_Impl.g0(this.f125634a, streakActivitySessionEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public Object p(final StreakActivitySessionEntity streakActivitySessionEntity, Continuation continuation) {
        Object objG = DBUtil.g(this.f125195a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.m4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakActivitySessionDao_Impl.i0(this.f125550a, streakActivitySessionEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }
}
