package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import cz.mobilesoft.coreblock.storage.room.entity.core.AggregatedPauseHistory;
import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntity;
import java.util.ArrayList;
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
import kotlinx.coroutines.flow.Flow;

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
public final class SchedulePauseHistoryDao_Impl extends SchedulePauseHistoryDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f126116g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f126117h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f126118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f126119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126121d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f126122f;

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

    public SchedulePauseHistoryDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126118a = __db;
        this.f126119b = new EntityInsertAdapter<SchedulePauseHistoryEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `SchedulePauseHistoryTable` (`id`,`pauseTimeSeconds`,`updatedAt`,`isForToday`,`profileId`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SchedulePauseHistoryEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.b());
                statement.A(3, entity.d());
                statement.A(4, entity.e() ? 1L : 0L);
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lC.longValue());
                }
            }
        };
        this.f126120c = new EntityDeleteOrUpdateAdapter<SchedulePauseHistoryEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `SchedulePauseHistoryTable` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SchedulePauseHistoryEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f126121d = new EntityDeleteOrUpdateAdapter<SchedulePauseHistoryEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `SchedulePauseHistoryTable` SET `id` = ?,`pauseTimeSeconds` = ?,`updatedAt` = ?,`isForToday` = ?,`profileId` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SchedulePauseHistoryEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.b());
                statement.A(3, entity.d());
                statement.A(4, entity.e() ? 1L : 0L);
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lC.longValue());
                }
                statement.A(6, entity.a());
            }
        };
        this.f126122f = new EntityUpsertAdapter(new EntityInsertAdapter<SchedulePauseHistoryEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao_Impl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SchedulePauseHistoryEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.b());
                statement.A(3, entity.d());
                statement.A(4, entity.e() ? 1L : 0L);
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lC.longValue());
                }
            }

            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return cJfnYMIyomoWf.KqpHB;
            }
        }, new EntityDeleteOrUpdateAdapter<SchedulePauseHistoryEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `SchedulePauseHistoryTable` SET `id` = ?,`pauseTimeSeconds` = ?,`updatedAt` = ?,`isForToday` = ?,`profileId` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, SchedulePauseHistoryEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.A(2, entity.b());
                statement.A(3, entity.d());
                statement.A(4, entity.e() ? 1L : 0L);
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lC.longValue());
                }
                statement.A(6, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(SchedulePauseHistoryDao_Impl schedulePauseHistoryDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        schedulePauseHistoryDao_Impl.f126120c.d(_connection, list);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Z(SchedulePauseHistoryDao_Impl schedulePauseHistoryDao_Impl, SchedulePauseHistoryEntity schedulePauseHistoryEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return schedulePauseHistoryDao_Impl.f126119b.d(_connection, schedulePauseHistoryEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List a0(SchedulePauseHistoryDao_Impl schedulePauseHistoryDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return schedulePauseHistoryDao_Impl.f126119b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List b0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "pauseTimeSeconds");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isForToday");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new SchedulePauseHistoryEntity((int) sQLiteStatementG2.getLong(iD), (int) sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5))));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
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
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "pauseTimeSeconds");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isForToday");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new SchedulePauseHistoryEntity((int) sQLiteStatementG2.getLong(iD), (int) sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5))));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AggregatedPauseHistory d0(String str, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            if (sQLiteStatementG2.B2()) {
                return new AggregatedPauseHistory(sQLiteStatementG2.getLong(0), sQLiteStatementG2.isNull(1) ? null : Long.valueOf(sQLiteStatementG2.getLong(1)));
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'cz.mobilesoft.coreblock.storage.room.entity.core.AggregatedPauseHistory'.");
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e0(String str, long j3, long j4, long j5, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            sQLiteStatementG2.A(3, j5);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "pauseTimeSeconds");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isForToday");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new SchedulePauseHistoryEntity((int) sQLiteStatementG2.getLong(iD), (int) sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5))));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao
    public Object J(List list, Continuation continuation) {
        Object objF = DBUtil.f(this.f126118a, new SchedulePauseHistoryDao_Impl$restoreBackup$2(this, list, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao
    public Object L(Continuation continuation) {
        final String str = "SELECT * FROM SchedulePauseHistoryTable ORDER BY updatedAt DESC";
        return DBUtil.g(this.f126118a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.k2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SchedulePauseHistoryDao_Impl.b0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao
    public Object M(final long j3, final long j4, Continuation continuation) {
        final String str = "SELECT * FROM SchedulePauseHistoryTable WHERE updatedAt >= ? AND updatedAt <= ? ORDER BY updatedAt DESC";
        return DBUtil.g(this.f126118a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.l2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SchedulePauseHistoryDao_Impl.c0(str, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao
    public Object N(final long j3, final long j4, Continuation continuation) {
        final String str = "SELECT COUNT(*) as count, SUM(pauseTimeSeconds) as total FROM SchedulePauseHistoryTable WHERE updatedAt >= ? AND updatedAt <= ?";
        return DBUtil.g(this.f126118a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.m2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SchedulePauseHistoryDao_Impl.d0(str, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao
    public Flow O(final long j3, final long j4, final long j5) {
        final String str = "SELECT * FROM SchedulePauseHistoryTable WHERE updatedAt >= ? AND updatedAt <= ? AND profileId = ?";
        return FlowUtil.a(this.f126118a, false, new String[]{"SchedulePauseHistoryTable"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.i2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SchedulePauseHistoryDao_Impl.e0(str, j3, j4, j5, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Object n(final SchedulePauseHistoryEntity schedulePauseHistoryEntity, Continuation continuation) {
        return DBUtil.g(this.f126118a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.g2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(SchedulePauseHistoryDao_Impl.Z(this.f126199a, schedulePauseHistoryEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f126118a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.h2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SchedulePauseHistoryDao_Impl.X(this.f126209a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f126118a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.j2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SchedulePauseHistoryDao_Impl.a0(this.f126235a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
