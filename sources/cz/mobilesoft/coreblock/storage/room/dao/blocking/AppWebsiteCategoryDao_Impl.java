package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import android.content.Context;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.enums.Category;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation;
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
public final class AppWebsiteCategoryDao_Impl extends AppWebsiteCategoryDao {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f124853h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f124854i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f124855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f124856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Category.Converter f124857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124858d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityUpsertAdapter f124860g;

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

    public AppWebsiteCategoryDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f124857c = new Category.Converter();
        this.f124855a = __db;
        this.f124856b = new EntityInsertAdapter<AppWebsiteCategoryRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `AppWebsiteCategoryRelation` (`packageName`,`hostname`,`category`,`isPreset`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppWebsiteCategoryRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.c());
                String strB = entity.b();
                if (strB == null) {
                    statement.D(2);
                } else {
                    statement.p0(2, strB);
                }
                statement.p0(3, AppWebsiteCategoryDao_Impl.this.f124857c.b(entity.a()));
                statement.A(4, entity.d() ? 1L : 0L);
            }
        };
        this.f124858d = new EntityDeleteOrUpdateAdapter<AppWebsiteCategoryRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `AppWebsiteCategoryRelation` WHERE `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppWebsiteCategoryRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.c());
            }
        };
        this.f124859f = new EntityDeleteOrUpdateAdapter<AppWebsiteCategoryRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `AppWebsiteCategoryRelation` SET `packageName` = ?,`hostname` = ?,`category` = ?,`isPreset` = ? WHERE `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppWebsiteCategoryRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.c());
                String strB = entity.b();
                if (strB == null) {
                    statement.D(2);
                } else {
                    statement.p0(2, strB);
                }
                statement.p0(3, AppWebsiteCategoryDao_Impl.this.f124857c.b(entity.a()));
                statement.A(4, entity.d() ? 1L : 0L);
                statement.p0(5, entity.c());
            }
        };
        this.f124860g = new EntityUpsertAdapter(new EntityInsertAdapter<AppWebsiteCategoryRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `AppWebsiteCategoryRelation` (`packageName`,`hostname`,`category`,`isPreset`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppWebsiteCategoryRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.c());
                String strB = entity.b();
                if (strB == null) {
                    statement.D(2);
                } else {
                    statement.p0(2, strB);
                }
                statement.p0(3, AppWebsiteCategoryDao_Impl.this.f124857c.b(entity.a()));
                statement.A(4, entity.d() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<AppWebsiteCategoryRelation>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `AppWebsiteCategoryRelation` SET `packageName` = ?,`hostname` = ?,`category` = ?,`isPreset` = ? WHERE `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppWebsiteCategoryRelation entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.c());
                String strB = entity.b();
                if (strB == null) {
                    statement.D(2);
                } else {
                    statement.p0(2, strB);
                }
                statement.p0(3, AppWebsiteCategoryDao_Impl.this.f124857c.b(entity.a()));
                statement.A(4, entity.d() ? 1L : 0L);
                statement.p0(5, entity.c());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(AppWebsiteCategoryDao_Impl appWebsiteCategoryDao_Impl, AppWebsiteCategoryRelation appWebsiteCategoryRelation, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        appWebsiteCategoryDao_Impl.f124858d.c(_connection, appWebsiteCategoryRelation);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g0(String str, AppWebsiteCategoryDao_Impl appWebsiteCategoryDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "hostname");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "category");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isPreset");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AppWebsiteCategoryRelation(sQLiteStatementG2.f2(iD), sQLiteStatementG2.isNull(iD2) ? null : sQLiteStatementG2.f2(iD2), appWebsiteCategoryDao_Impl.f124857c.a(sQLiteStatementG2.f2(iD3)), ((int) sQLiteStatementG2.getLong(iD4)) != 0));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppWebsiteCategoryRelation h0(String str, String str2, AppWebsiteCategoryDao_Impl appWebsiteCategoryDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        boolean z2 = true;
        try {
            sQLiteStatementG2.p0(1, str2);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "hostname");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "category");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isPreset");
            AppWebsiteCategoryRelation appWebsiteCategoryRelation = null;
            String strF2 = null;
            if (sQLiteStatementG2.B2()) {
                String strF22 = sQLiteStatementG2.f2(iD);
                if (!sQLiteStatementG2.isNull(iD2)) {
                    strF2 = sQLiteStatementG2.f2(iD2);
                }
                Category categoryA = appWebsiteCategoryDao_Impl.f124857c.a(sQLiteStatementG2.f2(iD3));
                if (((int) sQLiteStatementG2.getLong(iD4)) == 0) {
                    z2 = false;
                }
                appWebsiteCategoryRelation = new AppWebsiteCategoryRelation(strF22, strF2, categoryA, z2);
            }
            return appWebsiteCategoryRelation;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List i0(String str, Collection collection, AppWebsiteCategoryDao_Impl appWebsiteCategoryDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "hostname");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "category");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isPreset");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AppWebsiteCategoryRelation(sQLiteStatementG2.f2(iD), sQLiteStatementG2.isNull(iD2) ? null : sQLiteStatementG2.f2(iD2), appWebsiteCategoryDao_Impl.f124857c.a(sQLiteStatementG2.f2(iD3)), ((int) sQLiteStatementG2.getLong(iD4)) != 0));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k0(AppWebsiteCategoryDao_Impl appWebsiteCategoryDao_Impl, AppWebsiteCategoryRelation appWebsiteCategoryRelation, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return appWebsiteCategoryDao_Impl.f124856b.d(_connection, appWebsiteCategoryRelation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List l0(AppWebsiteCategoryDao_Impl appWebsiteCategoryDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return appWebsiteCategoryDao_Impl.f124856b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(AppWebsiteCategoryDao_Impl appWebsiteCategoryDao_Impl, AppWebsiteCategoryRelation appWebsiteCategoryRelation, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        appWebsiteCategoryDao_Impl.f124859f.c(_connection, appWebsiteCategoryRelation);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao
    public Object J(String str, String str2, Continuation continuation) {
        Object objF = DBUtil.f(this.f124855a, new AppWebsiteCategoryDao_Impl$createOrUpdate$2(this, str, str2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao
    public Object L(final String str, Continuation continuation) {
        final String str2 = "SELECT * FROM AppWebsiteCategoryRelation WHERE packageName = ?";
        return DBUtil.g(this.f124855a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppWebsiteCategoryDao_Impl.h0(str2, str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao
    public Object M(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM AppWebsiteCategoryRelation WHERE packageName IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f124855a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppWebsiteCategoryDao_Impl.i0(string, collection, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao
    public Object N(Context context, Continuation continuation) {
        Object objF = DBUtil.f(this.f124855a, new AppWebsiteCategoryDao_Impl$insertAllDefault$2(this, context, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao
    public Object R(String str, Continuation continuation) {
        Object objF = DBUtil.f(this.f124855a, new AppWebsiteCategoryDao_Impl$updateAll$2(this, str, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public Object q(final AppWebsiteCategoryRelation appWebsiteCategoryRelation, Continuation continuation) {
        Object objG = DBUtil.g(this.f124855a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppWebsiteCategoryDao_Impl.f0(this.f125453a, appWebsiteCategoryRelation, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public Object n(final AppWebsiteCategoryRelation appWebsiteCategoryRelation, Continuation continuation) {
        return DBUtil.g(this.f124855a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(AppWebsiteCategoryDao_Impl.k0(this.f125437a, appWebsiteCategoryRelation, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao
    public Object k(Continuation continuation) {
        final String str = "SELECT * FROM AppWebsiteCategoryRelation";
        return DBUtil.g(this.f124855a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppWebsiteCategoryDao_Impl.g0(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public Object p(final AppWebsiteCategoryRelation appWebsiteCategoryRelation, Continuation continuation) {
        Object objG = DBUtil.g(this.f124855a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppWebsiteCategoryDao_Impl.n0(this.f125470a, appWebsiteCategoryRelation, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f124855a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppWebsiteCategoryDao_Impl.l0(this.f125502a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
