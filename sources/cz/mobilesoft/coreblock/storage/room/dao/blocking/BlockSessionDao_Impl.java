package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.dto.AppSessions;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
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
public final class BlockSessionDao_Impl extends BlockSessionDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f124963g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f124964h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f124965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f124966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124968d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f124969f;

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

    public BlockSessionDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f124965a = __db;
        this.f124966b = new EntityInsertAdapter<BlockSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `BlockSession` (`id`,`name`,`timestamp`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.b());
                statement.A(3, entity.c());
            }
        };
        this.f124967c = new EntityDeleteOrUpdateAdapter<BlockSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `BlockSession` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
            }
        };
        this.f124968d = new EntityDeleteOrUpdateAdapter<BlockSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `BlockSession` SET `id` = ?,`name` = ?,`timestamp` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.b());
                statement.A(3, entity.c());
                statement.A(4, entity.a());
            }
        };
        this.f124969f = new EntityUpsertAdapter(new EntityInsertAdapter<BlockSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `BlockSession` (`id`,`name`,`timestamp`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.b());
                statement.A(3, entity.c());
            }
        }, new EntityDeleteOrUpdateAdapter<BlockSession>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `BlockSession` SET `id` = ?,`name` = ?,`timestamp` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, BlockSession entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.a());
                statement.p0(2, entity.b());
                statement.A(3, entity.c());
                statement.A(4, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List U(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "timestamp");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new BlockSession(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.getLong(iD3)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long V(String str, Collection collection, int i3, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, j3);
            sQLiteStatementG2.A(i3 + 2, j4);
            long j5 = sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
            sQLiteStatementG2.close();
            return j5;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List W(String str, Collection collection, int i3, long j3, long j4, int i4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            sQLiteStatementG2.A(i3 + 1, j3);
            sQLiteStatementG2.A(i3 + 2, j4);
            sQLiteStatementG2.A(i3 + 3, i4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AppSessions(sQLiteStatementG2.f2(0), (int) sQLiteStatementG2.getLong(1)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long X(String str, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Z(BlockSessionDao_Impl blockSessionDao_Impl, BlockSession blockSession, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return blockSessionDao_Impl.f124966b.d(_connection, blockSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List a0(BlockSessionDao_Impl blockSessionDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return blockSessionDao_Impl.f124966b.e(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao
    public Flow J(final String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        final String str = "SELECT * FROM BlockSession WHERE name = ?";
        return FlowUtil.a(this.f124965a, false, new String[]{"BlockSession"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockSessionDao_Impl.U(str, name, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao
    public Object K(final Collection collection, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM BlockSession WHERE name NOT IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(") AND timestamp >= ");
        sb.append("?");
        sb.append(" AND timestamp < ");
        sb.append("?");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f124965a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(BlockSessionDao_Impl.V(string, collection, size, j3, j4, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao
    public Object L(final Collection collection, final long j3, final long j4, final int i3, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT name, COUNT(*) as sessions FROM BlockSession WHERE name NOT IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(") AND timestamp >= ");
        sb.append("?");
        sb.append(" AND timestamp < ");
        sb.append("?");
        sb.append(" GROUP BY name ORDER BY sessions DESC LIMIT ");
        sb.append("?");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f124965a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.v0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockSessionDao_Impl.W(string, collection, size, j3, j4, i3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao
    public Object M(final long j3, final long j4, Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM BlockSession WHERE timestamp >= ? AND timestamp < ?";
        return DBUtil.g(this.f124965a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(BlockSessionDao_Impl.X(str, j3, j4, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Object n(final BlockSession blockSession, Continuation continuation) {
        return DBUtil.g(this.f124965a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(BlockSessionDao_Impl.Z(this.f125733a, blockSession, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f124965a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockSessionDao_Impl.a0(this.f125663a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
