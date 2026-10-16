package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteQuery;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public final class ApplicationProfileRelationDao_Impl extends ApplicationProfileRelationDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f124956g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f124957h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f124958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f124959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124961d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f124962f;

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

    public ApplicationProfileRelationDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f124958a = __db;
        this.f124959b = new EntityInsertAdapter<ApplicationProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `ApplicationProfileRelation` (`id`,`packageName`,`profileId`,`isEnabled`,`flags`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationProfileRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.p0(2, entity.d());
                statement.A(3, entity.e());
                statement.A(4, entity.f() ? 1L : 0L);
                statement.A(5, entity.b());
            }
        };
        this.f124960c = new EntityDeleteOrUpdateAdapter<ApplicationProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `ApplicationProfileRelation` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationProfileRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
            }
        };
        this.f124961d = new EntityDeleteOrUpdateAdapter<ApplicationProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `ApplicationProfileRelation` SET `id` = ?,`packageName` = ?,`profileId` = ?,`isEnabled` = ?,`flags` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationProfileRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.p0(2, entity.d());
                statement.A(3, entity.e());
                statement.A(4, entity.f() ? 1L : 0L);
                statement.A(5, entity.b());
                statement.A(6, entity.c());
            }
        };
        this.f124962f = new EntityUpsertAdapter(new EntityInsertAdapter<ApplicationProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `ApplicationProfileRelation` (`id`,`packageName`,`profileId`,`isEnabled`,`flags`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationProfileRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.p0(2, entity.d());
                statement.A(3, entity.e());
                statement.A(4, entity.f() ? 1L : 0L);
                statement.A(5, entity.b());
            }
        }, new EntityDeleteOrUpdateAdapter<ApplicationProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `ApplicationProfileRelation` SET `id` = ?,`packageName` = ?,`profileId` = ?,`isEnabled` = ?,`flags` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, ApplicationProfileRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.c());
                statement.p0(2, entity.d());
                statement.A(3, entity.e());
                statement.A(4, entity.f() ? 1L : 0L);
                statement.A(5, entity.b());
                statement.A(6, entity.c());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A0(String str, RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(ApplicationProfileRelationDao_Impl applicationProfileRelationDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        applicationProfileRelationDao_Impl.f124960c.d(_connection, list);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(String str, int i3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, i3);
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(String str, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(String str, long j3, int i3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, i3);
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(String str, long j3, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            Iterator it = collection.iterator();
            int i3 = 2;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(String str, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i3, ((Number) it.next()).longValue());
                i3++;
            }
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H0(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "flags");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new ApplicationProfileRelation(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.getLong(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, (int) sQLiteStatementG2.getLong(iD5)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List I0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "flags");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new ApplicationProfileRelation(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.getLong(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, (int) sQLiteStatementG2.getLong(iD5)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List J0(String str, RoomRawQuery roomRawQuery, ApplicationProfileRelationDao_Impl applicationProfileRelationDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(applicationProfileRelationDao_Impl.z0(sQLiteStatementG2));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long L0(ApplicationProfileRelationDao_Impl applicationProfileRelationDao_Impl, ApplicationProfileRelation applicationProfileRelation, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return applicationProfileRelationDao_Impl.f124959b.d(_connection, applicationProfileRelation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List M0(ApplicationProfileRelationDao_Impl applicationProfileRelationDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return applicationProfileRelationDao_Impl.f124959b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List N0(ApplicationProfileRelationDao_Impl applicationProfileRelationDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return applicationProfileRelationDao_Impl.f124962f.c(_connection, collection);
    }

    private final ApplicationProfileRelation z0(SQLiteStatement sQLiteStatement) {
        boolean z2;
        int iC = SQLiteStatementUtil.c(sQLiteStatement, "id");
        int iC2 = SQLiteStatementUtil.c(sQLiteStatement, "packageName");
        int iC3 = SQLiteStatementUtil.c(sQLiteStatement, "profileId");
        int iC4 = SQLiteStatementUtil.c(sQLiteStatement, "isEnabled");
        int iC5 = SQLiteStatementUtil.c(sQLiteStatement, "flags");
        long j3 = iC == -1 ? 0L : sQLiteStatement.getLong(iC);
        if (iC2 == -1) {
            throw new IllegalStateException("Missing column 'packageName' for a NON-NULL value, column not found in result.");
        }
        String strF2 = sQLiteStatement.f2(iC2);
        long j4 = iC3 != -1 ? sQLiteStatement.getLong(iC3) : 0L;
        if (iC4 == -1) {
            z2 = false;
        } else {
            z2 = ((int) sQLiteStatement.getLong(iC4)) != 0;
        }
        return new ApplicationProfileRelation(j3, strF2, j4, z2, iC5 != -1 ? (int) sQLiteStatement.getLong(iC5) : 0);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public Object n(final ApplicationProfileRelation applicationProfileRelation, Continuation continuation) {
        return DBUtil.g(this.f124958a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ApplicationProfileRelationDao_Impl.L0(this.f125558a, applicationProfileRelation, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao
    public Object S(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation) {
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(supportSQLiteQuery).n();
        final String strF = roomRawQueryN.f();
        return DBUtil.g(this.f124958a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ApplicationProfileRelationDao_Impl.A0(strF, roomRawQueryN, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao
    public Object T(final int i3, Continuation continuation) {
        final String str = "DELETE FROM ApplicationProfileRelation WHERE flags & ? > 0";
        Object objG = DBUtil.g(this.f124958a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.p0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.C0(str, i3, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao
    public Object U(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ApplicationProfileRelation WHERE packageName IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f124958a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.D0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao
    public Object V(final long j3, final int i3, Continuation continuation) {
        final String str = "DELETE FROM ApplicationProfileRelation WHERE profileId = ? AND flags & ? > 0";
        Object objG = DBUtil.g(this.f124958a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.E0(str, j3, i3, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao
    public Object W(final long j3, final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ApplicationProfileRelation WHERE profileId = ");
        sb.append("?");
        sb.append(" AND packageName IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f124958a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.F0(string, j3, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao
    public Object X(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ApplicationProfileRelation WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f124958a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.G0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao
    public Object c0(final String str, Continuation continuation) {
        final String str2 = "SELECT * FROM ApplicationProfileRelation WHERE packageName = ?";
        return DBUtil.g(this.f124958a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.H0(str2, str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao
    public Object d0(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM ApplicationProfileRelation WHERE profileId = ?";
        return DBUtil.g(this.f124958a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.I0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f124958a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.B0(this.f125627a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object j(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f124958a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.N0(this.f125455a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao
    public Object j0(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation) {
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(supportSQLiteQuery).n();
        final String strF = roomRawQueryN.f();
        return DBUtil.g(this.f124958a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.J0(strF, roomRawQueryN, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f124958a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao_Impl.M0(this.f125610a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
