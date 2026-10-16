package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory;
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
public final class PomodoroHistoryDao_Impl extends PomodoroHistoryDao {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f126046h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f126047i = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RoomDatabase f126048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityInsertAdapter f126049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126050d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityUpsertAdapter f126052g;

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

    public PomodoroHistoryDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126048b = __db;
        this.f126049c = new EntityInsertAdapter<PomodoroHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `PomodoroHistory` (`id`,`focusTimeMillis`,`breakTimeMillis`,`sessionCount`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                statement.A(2, entity.d());
                statement.A(3, entity.c());
                statement.A(4, entity.f());
                statement.A(5, entity.g());
            }
        };
        this.f126050d = new EntityDeleteOrUpdateAdapter<PomodoroHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `PomodoroHistory` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
            }
        };
        this.f126051f = new EntityDeleteOrUpdateAdapter<PomodoroHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `PomodoroHistory` SET `id` = ?,`focusTimeMillis` = ?,`breakTimeMillis` = ?,`sessionCount` = ?,`updatedAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                statement.A(2, entity.d());
                statement.A(3, entity.c());
                statement.A(4, entity.f());
                statement.A(5, entity.g());
                statement.A(6, entity.e());
            }
        };
        this.f126052g = new EntityUpsertAdapter(new EntityInsertAdapter<PomodoroHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `PomodoroHistory` (`id`,`focusTimeMillis`,`breakTimeMillis`,`sessionCount`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                statement.A(2, entity.d());
                statement.A(3, entity.c());
                statement.A(4, entity.f());
                statement.A(5, entity.g());
            }
        }, new EntityDeleteOrUpdateAdapter<PomodoroHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `PomodoroHistory` SET `id` = ?,`focusTimeMillis` = ?,`breakTimeMillis` = ?,`sessionCount` = ?,`updatedAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PomodoroHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                statement.A(2, entity.d());
                statement.A(3, entity.c());
                statement.A(4, entity.f());
                statement.A(5, entity.g());
                statement.A(6, entity.e());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(PomodoroHistoryDao_Impl pomodoroHistoryDao_Impl, PomodoroHistory pomodoroHistory, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        pomodoroHistoryDao_Impl.f126050d.c(_connection, pomodoroHistory);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(PomodoroHistoryDao_Impl pomodoroHistoryDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        pomodoroHistoryDao_Impl.f126050d.d(_connection, list);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(String str, SQLiteConnection _connection) {
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
    public static final int j0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            return sQLiteStatementG2.B2() ? (int) sQLiteStatementG2.getLong(0) : 0;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l0(PomodoroHistoryDao_Impl pomodoroHistoryDao_Impl, PomodoroHistory pomodoroHistory, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return pomodoroHistoryDao_Impl.f126049c.d(_connection, pomodoroHistory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m0(PomodoroHistoryDao_Impl pomodoroHistoryDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return pomodoroHistoryDao_Impl.f126049c.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "focusTimeMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "breakTimeMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "sessionCount");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new PomodoroHistory((int) sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), (int) sQLiteStatementG2.getLong(iD4), (int) sQLiteStatementG2.getLong(iD5)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroHistory o0(String str, long j3, long j4, int i3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            sQLiteStatementG2.A(3, i3);
            return sQLiteStatementG2.B2() ? new PomodoroHistory((int) sQLiteStatementG2.getLong(SQLiteStatementUtil.d(sQLiteStatementG2, "id")), sQLiteStatementG2.getLong(SQLiteStatementUtil.d(sQLiteStatementG2, "focusTimeMillis")), sQLiteStatementG2.getLong(SQLiteStatementUtil.d(sQLiteStatementG2, "breakTimeMillis")), (int) sQLiteStatementG2.getLong(SQLiteStatementUtil.d(sQLiteStatementG2, "sessionCount")), (int) sQLiteStatementG2.getLong(SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt"))) : null;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List p0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "focusTimeMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "breakTimeMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "sessionCount");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new PomodoroHistory((int) sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), (int) sQLiteStatementG2.getLong(iD4), (int) sQLiteStatementG2.getLong(iD5)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PomodoroHistory q0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "focusTimeMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "breakTimeMillis");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "sessionCount");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt");
            if (!sQLiteStatementG2.B2()) {
                throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory'.");
            }
            PomodoroHistory pomodoroHistory = new PomodoroHistory((int) sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), (int) sQLiteStatementG2.getLong(iD4), (int) sQLiteStatementG2.getLong(iD5));
            sQLiteStatementG2.close();
            return pomodoroHistory;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(PomodoroHistoryDao_Impl pomodoroHistoryDao_Impl, PomodoroHistory pomodoroHistory, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        pomodoroHistoryDao_Impl.f126051f.c(_connection, pomodoroHistory);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao
    public Object J(PomodoroHistory pomodoroHistory, Continuation continuation) {
        Object objF = DBUtil.f(this.f126048b, new PomodoroHistoryDao_Impl$checkAndInsert$2(this, pomodoroHistory, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao
    public Object L(Continuation continuation) {
        final String str = "SELECT COUNT(id) from PomodoroHistory";
        return DBUtil.g(this.f126048b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.p1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(PomodoroHistoryDao_Impl.j0(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao
    public Object M(List list, Continuation continuation) {
        Object objF = DBUtil.f(this.f126048b, new PomodoroHistoryDao_Impl$restoreBackup$2(this, list, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao
    public Object O(Continuation continuation) {
        final String str = "SELECT * FROM PomodoroHistory";
        return DBUtil.g(this.f126048b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.l1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroHistoryDao_Impl.n0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao
    public Object P(final long j3, final long j4, final int i3, Continuation continuation) {
        final String str = "SELECT * from PomodoroHistory WHERE focusTimeMillis = ? AND breakTimeMillis = ? AND sessionCount = ? LIMIT 1";
        return DBUtil.g(this.f126048b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.i1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroHistoryDao_Impl.o0(str, j3, j4, i3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao
    public Object Q(Continuation continuation) {
        final String str = "SELECT * FROM PomodoroHistory ORDER BY updatedAt DESC LIMIT 5";
        return DBUtil.g(this.f126048b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.r1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroHistoryDao_Impl.p0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao
    public Object R(Continuation continuation) {
        final String str = "SELECT * FROM PomodoroHistory ORDER BY updatedAt ASC LIMIT 1";
        return DBUtil.g(this.f126048b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.q1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroHistoryDao_Impl.q0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao
    public void b() {
        final String str = "DELETE FROM PomodoroHistory";
        DBUtil.e(this.f126048b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.j1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroHistoryDao_Impl.i0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public Object q(final PomodoroHistory pomodoroHistory, Continuation continuation) {
        Object objG = DBUtil.g(this.f126048b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.k1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroHistoryDao_Impl.g0(this.f126242a, pomodoroHistory, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f126048b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.m1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroHistoryDao_Impl.h0(this.f126256a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public Object n(final PomodoroHistory pomodoroHistory, Continuation continuation) {
        return DBUtil.g(this.f126048b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.n1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(PomodoroHistoryDao_Impl.l0(this.f126264a, pomodoroHistory, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public Object p(final PomodoroHistory pomodoroHistory, Continuation continuation) {
        Object objG = DBUtil.g(this.f126048b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.o1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroHistoryDao_Impl.s0(this.f126276a, pomodoroHistory, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f126048b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.s1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PomodoroHistoryDao_Impl.m0(this.f126311a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
