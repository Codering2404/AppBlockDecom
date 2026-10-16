package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.RoomSQLiteQuery;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
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
public final class WebsiteProfileRelationDao_Impl extends WebsiteProfileRelationDao {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f125313i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f125314j = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RoomDatabase f125315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityInsertAdapter f125316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WebsiteProfileRelation.BlockingType.Converter f125317d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final EntityUpsertAdapter f125320h;

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

    public WebsiteProfileRelationDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125317d = new WebsiteProfileRelation.BlockingType.Converter();
        this.f125315b = __db;
        this.f125316c = new EntityInsertAdapter<WebsiteProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `WebsiteProfileRelation` (`id`,`profileId`,`name`,`blockingType`,`isAnywhereInUrl`,`isEnabled`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WebsiteProfileRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.b());
                statement.A(2, entity.d());
                statement.p0(3, entity.c());
                statement.A(4, WebsiteProfileRelationDao_Impl.this.f125317d.b(entity.a()));
                statement.A(5, entity.e() ? 1L : 0L);
                statement.A(6, entity.f() ? 1L : 0L);
            }
        };
        this.f125318f = new EntityDeleteOrUpdateAdapter<WebsiteProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `WebsiteProfileRelation` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WebsiteProfileRelation websiteProfileRelation) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(websiteProfileRelation, tDEtWsFLJfe.WxJnv);
                statement.A(1, websiteProfileRelation.b());
            }
        };
        this.f125319g = new EntityDeleteOrUpdateAdapter<WebsiteProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `WebsiteProfileRelation` SET `id` = ?,`profileId` = ?,`name` = ?,`blockingType` = ?,`isAnywhereInUrl` = ?,`isEnabled` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WebsiteProfileRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.b());
                statement.A(2, entity.d());
                statement.p0(3, entity.c());
                statement.A(4, WebsiteProfileRelationDao_Impl.this.f125317d.b(entity.a()));
                statement.A(5, entity.e() ? 1L : 0L);
                statement.A(6, entity.f() ? 1L : 0L);
                statement.A(7, entity.b());
            }
        };
        this.f125320h = new EntityUpsertAdapter(new EntityInsertAdapter<WebsiteProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `WebsiteProfileRelation` (`id`,`profileId`,`name`,`blockingType`,`isAnywhereInUrl`,`isEnabled`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WebsiteProfileRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.b());
                statement.A(2, entity.d());
                statement.p0(3, entity.c());
                statement.A(4, WebsiteProfileRelationDao_Impl.this.f125317d.b(entity.a()));
                statement.A(5, entity.e() ? 1L : 0L);
                statement.A(6, entity.f() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<WebsiteProfileRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `WebsiteProfileRelation` SET `id` = ?,`profileId` = ?,`name` = ?,`blockingType` = ?,`isAnywhereInUrl` = ?,`isEnabled` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, WebsiteProfileRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.b());
                statement.A(2, entity.d());
                statement.p0(3, entity.c());
                statement.A(4, WebsiteProfileRelationDao_Impl.this.f125317d.b(entity.a()));
                statement.A(5, entity.e() ? 1L : 0L);
                statement.A(6, entity.f() ? 1L : 0L);
                statement.A(7, entity.b());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long f0(String str, RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
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
    public static final long g0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            return sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h0(String str, long j3, SQLiteConnection _connection) {
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
    public static final Unit i0(WebsiteProfileRelationDao_Impl websiteProfileRelationDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        websiteProfileRelationDao_Impl.f125318f.d(_connection, list);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(String str, Collection collection, SQLiteConnection _connection) {
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
    public static final List k0(String str, Collection collection, WebsiteProfileRelationDao_Impl websiteProfileRelationDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAnywhereInUrl");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i4 = iD2;
                int i5 = iD3;
                arrayList.add(new WebsiteProfileRelation(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), websiteProfileRelationDao_Impl.f125317d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
                iD2 = i4;
                iD3 = i5;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List l0(String str, long j3, WebsiteProfileRelationDao_Impl websiteProfileRelationDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAnywhereInUrl");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i3 = iD;
                int i4 = iD2;
                arrayList.add(new WebsiteProfileRelation(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), websiteProfileRelationDao_Impl.f125317d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
                iD = i3;
                iD2 = i4;
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m0(String str, Collection collection, WebsiteProfileRelationDao_Impl websiteProfileRelationDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i3, ((Number) it.next()).longValue());
                i3++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAnywhereInUrl");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i4 = iD2;
                int i5 = iD3;
                arrayList.add(new WebsiteProfileRelation(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), websiteProfileRelationDao_Impl.f125317d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
                iD2 = i4;
                iD3 = i5;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n0(String str, Collection collection, int i3, Collection collection2, WebsiteProfileRelationDao_Impl websiteProfileRelationDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i4, ((Number) it.next()).longValue());
                i4++;
            }
            int i5 = i3 + 1;
            Iterator it2 = collection2.iterator();
            while (it2.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it2.next());
                i5++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "name");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "blockingType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAnywhereInUrl");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i6 = iD2;
                int i7 = iD3;
                arrayList.add(new WebsiteProfileRelation(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), websiteProfileRelationDao_Impl.f125317d.a((int) sQLiteStatementG2.getLong(iD4)), ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0));
                iD2 = i6;
                iD3 = i7;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List o0(WebsiteProfileRelationDao_Impl websiteProfileRelationDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return websiteProfileRelationDao_Impl.f125316c.e(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao
    public Object K(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation) {
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(supportSQLiteQuery).n();
        final String strF = roomRawQueryN.f();
        return DBUtil.g(this.f125315b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.m6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(WebsiteProfileRelationDao_Impl.f0(strF, roomRawQueryN, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao
    public Flow L() {
        final String str = "SELECT COUNT(*) FROM WebsiteProfileRelation WHERE isAnywhereInUrl = 1";
        return FlowUtil.a(this.f125315b, true, new String[]{"WebsiteProfileRelation"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.l6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(WebsiteProfileRelationDao_Impl.g0(str, (SQLiteConnection) obj));
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao
    public Object M(final long j3, Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM WebsiteProfileRelation WHERE profileId = ?";
        return DBUtil.g(this.f125315b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.g6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(WebsiteProfileRelationDao_Impl.h0(str, j3, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao
    public Object N(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM WebsiteProfileRelation WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f125315b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.i6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebsiteProfileRelationDao_Impl.j0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao
    public Object Q(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM WebsiteProfileRelation WHERE name IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125315b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.d6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebsiteProfileRelationDao_Impl.k0(string, collection, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao
    public Object R(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM WebsiteProfileRelation WHERE profileId = ?";
        return DBUtil.g(this.f125315b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.k6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebsiteProfileRelationDao_Impl.l0(str, j3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao
    public Object S(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM WebsiteProfileRelation WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125315b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.j6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebsiteProfileRelationDao_Impl.m0(string, collection, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao
    public Object T(final Collection collection, final Collection collection2, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM WebsiteProfileRelation WHERE profileId IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(") AND name IN (");
        StringUtil.a(sb, collection2.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125315b, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.e6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebsiteProfileRelationDao_Impl.n0(string, collection, size, collection2, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f125315b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.f6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebsiteProfileRelationDao_Impl.i0(this.f125435a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125315b, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.h6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebsiteProfileRelationDao_Impl.o0(this.f125468a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
