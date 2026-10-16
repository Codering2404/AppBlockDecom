package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory;
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
public final class QuickBlockTimerHistoryDao_Impl extends QuickBlockTimerHistoryDao {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f126097h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f126098i = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RoomDatabase f126099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityInsertAdapter f126100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126101d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityUpsertAdapter f126103g;

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

    public QuickBlockTimerHistoryDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126099b = __db;
        this.f126100c = new EntityInsertAdapter<QuickBlockTimerHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `QuickBlockTimerHistory` (`id`,`timeMillis`,`updatedAt`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, QuickBlockTimerHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, entity.d());
                statement.A(3, entity.e());
            }
        };
        this.f126101d = new EntityDeleteOrUpdateAdapter<QuickBlockTimerHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `QuickBlockTimerHistory` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, QuickBlockTimerHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
            }
        };
        this.f126102f = new EntityDeleteOrUpdateAdapter<QuickBlockTimerHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `QuickBlockTimerHistory` SET `id` = ?,`timeMillis` = ?,`updatedAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, QuickBlockTimerHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, entity.d());
                statement.A(3, entity.e());
                statement.A(4, entity.c());
            }
        };
        this.f126103g = new EntityUpsertAdapter(new EntityInsertAdapter<QuickBlockTimerHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `QuickBlockTimerHistory` (`id`,`timeMillis`,`updatedAt`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, QuickBlockTimerHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, entity.d());
                statement.A(3, entity.e());
            }
        }, new EntityDeleteOrUpdateAdapter<QuickBlockTimerHistory>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `QuickBlockTimerHistory` SET `id` = ?,`timeMillis` = ?,`updatedAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, QuickBlockTimerHistory entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.A(2, entity.d());
                statement.A(3, entity.e());
                statement.A(4, entity.c());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(QuickBlockTimerHistoryDao_Impl quickBlockTimerHistoryDao_Impl, QuickBlockTimerHistory quickBlockTimerHistory, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        quickBlockTimerHistoryDao_Impl.f126101d.c(_connection, quickBlockTimerHistory);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(QuickBlockTimerHistoryDao_Impl quickBlockTimerHistoryDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        quickBlockTimerHistoryDao_Impl.f126101d.d(_connection, list);
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
    public static final long l0(QuickBlockTimerHistoryDao_Impl quickBlockTimerHistoryDao_Impl, QuickBlockTimerHistory quickBlockTimerHistory, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return quickBlockTimerHistoryDao_Impl.f126100c.d(_connection, quickBlockTimerHistory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m0(QuickBlockTimerHistoryDao_Impl quickBlockTimerHistoryDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return quickBlockTimerHistoryDao_Impl.f126100c.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new QuickBlockTimerHistory((int) sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3)));
            }
            return arrayList;
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
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new QuickBlockTimerHistory((int) sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockTimerHistory q0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "updatedAt");
            if (sQLiteStatementG2.B2()) {
                return new QuickBlockTimerHistory((int) sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), (int) sQLiteStatementG2.getLong(iD3));
            }
            throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory'.");
        } finally {
            sQLiteStatementG2.close();
        }
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao
    public Object J(QuickBlockTimerHistory quickBlockTimerHistory, Continuation continuation) {
        Object objF = DBUtil.f(this.f126099b, new QuickBlockTimerHistoryDao_Impl$checkAndInsert$2(this, quickBlockTimerHistory, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao
    public Object L(Continuation continuation) {
        final String str = "SELECT COUNT(id) from QuickBlockTimerHistory";
        return DBUtil.g(this.f126099b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.b2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(QuickBlockTimerHistoryDao_Impl.j0(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao
    public Object M(List list, Continuation continuation) {
        Object objF = DBUtil.f(this.f126099b, new QuickBlockTimerHistoryDao_Impl$restoreBackup$2(this, list, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao
    public Object O(Continuation continuation) {
        final String str = "SELECT * FROM QuickBlockTimerHistory ORDER BY updatedAt DESC";
        return DBUtil.g(this.f126099b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.d2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockTimerHistoryDao_Impl.n0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao
    public Object P(final long j3, Continuation continuation) {
        final String str = "SELECT * from QuickBlockTimerHistory WHERE timeMillis = ? LIMIT 1";
        return DBUtil.g(this.f126099b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.v1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockTimerHistoryDao_Impl.o0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao
    public Object Q(Continuation continuation) {
        final String str = "SELECT * FROM QuickBlockTimerHistory ORDER BY updatedAt DESC LIMIT 5";
        return DBUtil.g(this.f126099b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.c2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockTimerHistoryDao_Impl.p0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao
    public Object R(Continuation continuation) {
        final String str = "SELECT * FROM QuickBlockTimerHistory ORDER BY updatedAt ASC LIMIT 1";
        return DBUtil.g(this.f126099b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.y1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockTimerHistoryDao_Impl.q0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao
    public void b() {
        final String str = "DELETE FROM QuickBlockTimerHistory";
        DBUtil.e(this.f126099b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.w1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockTimerHistoryDao_Impl.i0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public Object q(final QuickBlockTimerHistory quickBlockTimerHistory, Continuation continuation) {
        Object objG = DBUtil.g(this.f126099b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.e2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockTimerHistoryDao_Impl.g0(this.f126185a, quickBlockTimerHistory, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f126099b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.x1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockTimerHistoryDao_Impl.h0(this.f126341a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public Object n(final QuickBlockTimerHistory quickBlockTimerHistory, Continuation continuation) {
        return DBUtil.g(this.f126099b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.a2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(QuickBlockTimerHistoryDao_Impl.l0(this.f126153a, quickBlockTimerHistory, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public Object p(final QuickBlockTimerHistory quickBlockTimerHistory, Continuation continuation) {
        Object objG = DBUtil.g(this.f126099b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.z1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockTimerHistoryDao_Impl.s0(this.f126355a, quickBlockTimerHistory, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f126099b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.f2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickBlockTimerHistoryDao_Impl.m0(this.f126191a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockTimerHistory o0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            return sQLiteStatementG2.B2() ? new QuickBlockTimerHistory((int) sQLiteStatementG2.getLong(SQLiteStatementUtil.d(sQLiteStatementG2, "id")), sQLiteStatementG2.getLong(SQLiteStatementUtil.d(sQLiteStatementG2, "timeMillis")), (int) sQLiteStatementG2.getLong(SQLiteStatementUtil.d(sQLiteStatementG2, qRMDmh.KjyCATRUeegioh))) : null;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(QuickBlockTimerHistoryDao_Impl quickBlockTimerHistoryDao_Impl, QuickBlockTimerHistory quickBlockTimerHistory, SQLiteConnection sQLiteConnection) throws Exception {
        Intrinsics.checkNotNullParameter(sQLiteConnection, vxrlPPpdv.mxVnfvwruCBZa);
        quickBlockTimerHistoryDao_Impl.f126102f.c(sQLiteConnection, quickBlockTimerHistory);
        return Unit.f139807a;
    }
}
