package cz.mobilesoft.coreblock.storage.room.dao.blocking;

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
import cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakPauseRecordEntity;
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
public final class StreakPauseRecordDao_Impl extends StreakPauseRecordDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f125213g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f125214h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125218d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f125219f;

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

    public StreakPauseRecordDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125215a = __db;
        this.f125216b = new EntityInsertAdapter<StreakPauseRecordEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `StreakPauseRecord` (`id`,`profileId`,`startMillis`,`plannedEndMillis`,`endedAtMillis`,`isIndefinite`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakPauseRecordEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.f());
                statement.A(3, entity.g());
                statement.A(4, entity.e());
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lC.longValue());
                }
                statement.A(6, entity.h() ? 1L : 0L);
            }
        };
        this.f125217c = new EntityDeleteOrUpdateAdapter<StreakPauseRecordEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `StreakPauseRecord` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakPauseRecordEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
            }
        };
        this.f125218d = new EntityDeleteOrUpdateAdapter<StreakPauseRecordEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `StreakPauseRecord` SET `id` = ?,`profileId` = ?,`startMillis` = ?,`plannedEndMillis` = ?,`endedAtMillis` = ?,`isIndefinite` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakPauseRecordEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.f());
                statement.A(3, entity.g());
                statement.A(4, entity.e());
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lC.longValue());
                }
                statement.A(6, entity.h() ? 1L : 0L);
                statement.A(7, entity.d());
            }
        };
        this.f125219f = new EntityUpsertAdapter(new EntityInsertAdapter<StreakPauseRecordEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `StreakPauseRecord` (`id`,`profileId`,`startMillis`,`plannedEndMillis`,`endedAtMillis`,`isIndefinite`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakPauseRecordEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.f());
                statement.A(3, entity.g());
                statement.A(4, entity.e());
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lC.longValue());
                }
                statement.A(6, entity.h() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<StreakPauseRecordEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `StreakPauseRecord` SET `id` = ?,`profileId` = ?,`startMillis` = ?,`plannedEndMillis` = ?,`endedAtMillis` = ?,`isIndefinite` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakPauseRecordEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.f());
                statement.A(3, entity.g());
                statement.A(4, entity.e());
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lC.longValue());
                }
                statement.A(6, entity.h() ? 1L : 0L);
                statement.A(7, entity.d());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(String str, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(String str, SQLiteConnection _connection) {
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
    public static final Unit Z(String str, long j3, SQLiteConnection _connection) {
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
    public static final StreakPauseRecordEntity a0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "startMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "plannedEndMillis");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "endedAtMillis");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isIndefinite");
            StreakPauseRecordEntity streakPauseRecordEntity = null;
            if (sQLiteStatementG2.B2()) {
                streakPauseRecordEntity = new StreakPauseRecordEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5)), ((int) sQLiteStatementG2.getLong(iD6)) != 0);
            }
            return streakPauseRecordEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List b0(String str, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "startMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "plannedEndMillis");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "endedAtMillis");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isIndefinite");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new StreakPauseRecordEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5)), ((int) sQLiteStatementG2.getLong(iD6)) != 0));
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
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "startMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "plannedEndMillis");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "endedAtMillis");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isIndefinite");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new StreakPauseRecordEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5)), ((int) sQLiteStatementG2.getLong(iD6)) != 0));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long e0(StreakPauseRecordDao_Impl streakPauseRecordDao_Impl, StreakPauseRecordEntity streakPauseRecordEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return streakPauseRecordDao_Impl.f125216b.d(_connection, streakPauseRecordEntity);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao
    public Object J(final long j3, final long j4, Continuation continuation) {
        final String str = "UPDATE StreakPauseRecord SET endedAtMillis = ? WHERE id = ?";
        Object objG = DBUtil.g(this.f125215a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.f5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakPauseRecordDao_Impl.X(str, j4, j3, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao
    public Object K(final long j3, Continuation continuation) {
        final String str = "DELETE FROM StreakPauseRecord WHERE startMillis < ?";
        Object objG = DBUtil.g(this.f125215a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.i5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakPauseRecordDao_Impl.Z(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao
    public Object L(final long j3, Continuation continuation) {
        final String str = "\n            SELECT * FROM StreakPauseRecord\n            WHERE profileId = ? AND endedAtMillis IS NULL\n            ORDER BY startMillis DESC LIMIT 1\n            ";
        return DBUtil.g(this.f125215a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.g5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakPauseRecordDao_Impl.a0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao
    public Object M(final long j3, final long j4, Continuation continuation) {
        final String str = "\n            SELECT * FROM StreakPauseRecord\n            WHERE startMillis < ?\n            AND COALESCE(endedAtMillis, plannedEndMillis) > ?\n            ORDER BY startMillis ASC\n            ";
        return DBUtil.g(this.f125215a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.h5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakPauseRecordDao_Impl.b0(str, j4, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao
    public Object N(final long j3, final long j4, Continuation continuation) {
        final String str = "\n            SELECT * FROM StreakPauseRecord\n            WHERE startMillis >= ? AND startMillis < ?\n            ORDER BY startMillis ASC\n            ";
        return DBUtil.g(this.f125215a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.d5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakPauseRecordDao_Impl.c0(str, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao
    public Flow O() {
        final String str = "SELECT * FROM StreakPauseRecord";
        return FlowUtil.a(this.f125215a, false, new String[]{"StreakPauseRecord"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.j5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakPauseRecordDao_Impl.f0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public Object n(final StreakPauseRecordEntity streakPauseRecordEntity, Continuation continuation) {
        return DBUtil.g(this.f125215a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.e5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(StreakPauseRecordDao_Impl.e0(this.f125413a, streakPauseRecordEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakPauseRecordDao
    public Object deleteAll(Continuation continuation) {
        final String str = "DELETE FROM StreakPauseRecord";
        Object objG = DBUtil.g(this.f125215a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.c5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakPauseRecordDao_Impl.Y(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "startMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "plannedEndMillis");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, cJfnYMIyomoWf.VMsyMZxXWLknP);
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isIndefinite");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new StreakPauseRecordEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5)), ((int) sQLiteStatementG2.getLong(iD6)) != 0));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }
}
