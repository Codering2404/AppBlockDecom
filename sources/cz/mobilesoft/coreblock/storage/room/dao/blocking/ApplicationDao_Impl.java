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
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
public final class ApplicationDao_Impl extends ApplicationDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f124920g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f124921h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f124922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f124923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f124925d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f124926f;

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

    public ApplicationDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f124922a = __db;
        this.f124923b = new EntityInsertAdapter<Application>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `Application` (`packageName`,`label`,`labelForSearch`,`isUninstalled`,`appCategories`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Application entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.d());
                statement.p0(2, entity.b());
                statement.p0(3, entity.c());
                statement.A(4, entity.e() ? 1L : 0L);
                if (entity.a() == null) {
                    statement.D(5);
                } else {
                    statement.A(5, r6.intValue());
                }
            }
        };
        this.f124924c = new EntityDeleteOrUpdateAdapter<Application>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `Application` WHERE `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Application entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.d());
            }
        };
        this.f124925d = new EntityDeleteOrUpdateAdapter<Application>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `Application` SET `packageName` = ?,`label` = ?,`labelForSearch` = ?,`isUninstalled` = ?,`appCategories` = ? WHERE `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Application entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.d());
                statement.p0(2, entity.b());
                statement.p0(3, entity.c());
                statement.A(4, entity.e() ? 1L : 0L);
                if (entity.a() == null) {
                    statement.D(5);
                } else {
                    statement.A(5, r0.intValue());
                }
                statement.p0(6, entity.d());
            }
        };
        this.f124926f = new EntityUpsertAdapter(new EntityInsertAdapter<Application>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `Application` (`packageName`,`label`,`labelForSearch`,`isUninstalled`,`appCategories`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Application entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.d());
                statement.p0(2, entity.b());
                statement.p0(3, entity.c());
                statement.A(4, entity.e() ? 1L : 0L);
                if (entity.a() == null) {
                    statement.D(5);
                } else {
                    statement.A(5, r6.intValue());
                }
            }
        }, new EntityDeleteOrUpdateAdapter<Application>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `Application` SET `packageName` = ?,`label` = ?,`labelForSearch` = ?,`isUninstalled` = ?,`appCategories` = ? WHERE `packageName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Application entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.d());
                statement.p0(2, entity.b());
                statement.p0(3, entity.c());
                statement.A(4, entity.e() ? 1L : 0L);
                if (entity.a() == null) {
                    statement.D(5);
                } else {
                    statement.A(5, r0.intValue());
                }
                statement.p0(6, entity.d());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A0(String str, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            long j3 = sQLiteStatementG2.B2() ? sQLiteStatementG2.getLong(0) : 0L;
            sQLiteStatementG2.close();
            return j3;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(String str, Collection collection, SQLiteConnection _connection) {
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
    public static final Unit C0(String str, Collection collection, SQLiteConnection _connection) {
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
    public static final List D0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "label");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "labelForSearch");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isUninstalled");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "appCategories");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.f2(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, sQLiteStatementG2.isNull(iD5) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(iD5))));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List E0(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            sQLiteStatementG2.p0(2, str2);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "label");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "labelForSearch");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isUninstalled");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "appCategories");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.f2(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, sQLiteStatementG2.isNull(iD5) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(iD5))));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List F0(String str, String str2, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            sQLiteStatementG2.p0(2, str2);
            Iterator it = collection.iterator();
            int i3 = 3;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "label");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "labelForSearch");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isUninstalled");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "appCategories");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.f2(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, sQLiteStatementG2.isNull(iD5) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(iD5))));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List G0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "packageName");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "label");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "labelForSearch");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isUninstalled");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "appCategories");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.f2(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, sQLiteStatementG2.isNull(iD5) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(iD5))));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H0(String str, Collection collection, int i3, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.p0(i3 + 1, str2);
            sQLiteStatementG2.p0(i3 + 2, str2);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.f2(2), ((int) sQLiteStatementG2.getLong(3)) != 0, sQLiteStatementG2.isNull(4) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(4))));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List I0(String str, Collection collection, int i3, String str2, Collection collection2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.p0(i3 + 1, str2);
            sQLiteStatementG2.p0(i3 + 2, str2);
            int i5 = i3 + 3;
            Iterator it2 = collection2.iterator();
            while (it2.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it2.next());
                i5++;
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.f2(2), ((int) sQLiteStatementG2.getLong(3)) != 0, sQLiteStatementG2.isNull(4) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(4))));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List J0(String str, Collection collection, SQLiteConnection _connection) {
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
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "label");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "labelForSearch");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isUninstalled");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "appCategories");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.f2(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, sQLiteStatementG2.isNull(iD5) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(iD5))));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K0(String str, Collection collection, SQLiteConnection _connection) {
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
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "label");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "labelForSearch");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "isUninstalled");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "appCategories");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.f2(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, sQLiteStatementG2.isNull(iD5) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(iD5))));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List L0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.f2(2), ((int) sQLiteStatementG2.getLong(3)) != 0, sQLiteStatementG2.isNull(4) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(4))));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List M0(String str, Set set, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = set.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i3, ((Number) it.next()).longValue());
                i3++;
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Application(sQLiteStatementG2.f2(0), sQLiteStatementG2.f2(1), sQLiteStatementG2.f2(2), ((int) sQLiteStatementG2.getLong(3)) != 0, sQLiteStatementG2.isNull(4) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(4))));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List N0(ApplicationDao_Impl applicationDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return applicationDao_Impl.f124923b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(String str, Collection collection, SQLiteConnection _connection) {
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
    public static final List P0(ApplicationDao_Impl applicationDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return applicationDao_Impl.f124926f.c(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(String str, Collection collection, SQLiteConnection _connection) {
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

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object L(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Application SET appCategories = NULL WHERE packageName IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f124922a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.z0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object M(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM Application WHERE packageName IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f124922a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ApplicationDao_Impl.A0(string, collection, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object N(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM Application WHERE packageName in (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f124922a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.B0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object O(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM Application WHERE packageName in (");
        StringUtil.a(sb, collection.size());
        sb.append(") AND isUninstalled = 0");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f124922a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.C0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object S(final String str, final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("            SELECT * FROM Application WHERE (labelForSearch LIKE ");
        sb.append("?");
        sb.append(" || '%' OR labelForSearch LIKE '% ' || ");
        sb.append("?");
        sb.append(" || '%')");
        sb.append("\n");
        sb.append("            AND packageName NOT IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        sb.append("\n");
        sb.append("            ORDER BY labelForSearch");
        sb.append("\n");
        sb.append("            ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f124922a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.F0(string, str, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object T(final String str, Continuation continuation) {
        final String str2 = "SELECT * FROM Application WHERE (labelForSearch LIKE ? || '%' OR labelForSearch LIKE '% ' || ? || '%') ORDER BY labelForSearch";
        return DBUtil.g(this.f124922a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.E0(str2, str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object V(Continuation continuation) {
        Object objF = DBUtil.f(this.f124922a, new ApplicationDao_Impl$getAllAndDecategorize$2(this, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object X(Continuation continuation) {
        final String str = "\n                SELECT * FROM Application WHERE appCategories IS NULL\n            ";
        return DBUtil.g(this.f124922a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.G0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object Y(final String str, final Collection collection, final Collection collection2, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("            SELECT packageName, label, labelForSearch, isUninstalled, appCategories, (CASE WHEN packageName IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(") THEN 0 ELSE 1 END) AS isSelected");
        sb.append("\n");
        sb.append("            FROM Application WHERE (labelForSearch LIKE ");
        sb.append("?");
        sb.append(" || '%' OR labelForSearch LIKE '% ' || ");
        sb.append("?");
        sb.append(" || '%')");
        sb.append("\n");
        sb.append("            AND packageName NOT IN (");
        StringUtil.a(sb, collection2.size());
        sb.append(")");
        sb.append("\n");
        sb.append("            ORDER BY isSelected, labelForSearch");
        sb.append("\n");
        sb.append("            ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f124922a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.I0(string, collection, size, str, collection2, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object Z(final String str, final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("            SELECT packageName, label, labelForSearch, isUninstalled, appCategories, (CASE WHEN packageName IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(") THEN 0 ELSE 1 END) AS isSelected");
        sb.append("\n");
        sb.append("            FROM Application WHERE (labelForSearch LIKE ");
        sb.append("?");
        sb.append(" || '%' OR labelForSearch LIKE '% ' || ");
        sb.append("?");
        sb.append(" || '%')");
        sb.append("\n");
        sb.append("            ORDER BY isSelected, labelForSearch");
        sb.append("\n");
        sb.append("            ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f124922a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.H0(string, collection, size, str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Flow d0(final Collection packageNames) {
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM Application WHERE packageName IN (");
        StringUtil.a(sb, packageNames.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return FlowUtil.a(this.f124922a, true, new String[]{"Application"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.K0(string, packageNames, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object e0(final long j3, Continuation continuation) {
        final String str = "\n            SELECT a.packageName, a.label, a.labelForSearch, a.isUninstalled, a.appCategories\n            FROM ApplicationProfileRelation r \n            JOIN Application a \n            ON r.packageName = a.packageName\n            AND r.flags = 0\n            WHERE r.profileId = ? \n            ";
        return DBUtil.g(this.f124922a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.L0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object f0(final Set set, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("            SELECT a.packageName, a.label, a.labelForSearch, a.isUninstalled, a.appCategories");
        sb.append("\n");
        sb.append("            FROM ApplicationProfileRelation r ");
        sb.append("\n");
        sb.append("            JOIN Application a ");
        sb.append("\n");
        sb.append("            ON r.packageName = a.packageName");
        sb.append("\n");
        sb.append("            AND r.flags = 0");
        sb.append("\n");
        sb.append("            WHERE r.profileId IN (");
        StringUtil.a(sb, set.size());
        sb.append(")");
        sb.append("\n");
        sb.append("            ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f124922a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.M0(string, set, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object g0(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Application SET isUninstalled = 1 WHERE packageName IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f124922a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.O0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object j(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f124922a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.P0(this.f125540a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object k(Continuation continuation) {
        final String str = "SELECT * FROM Application ORDER BY labelForSearch";
        return DBUtil.g(this.f124922a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.D0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f124922a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.N0(this.f125661a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao
    public Object c0(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM Application WHERE packageName IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, cJfnYMIyomoWf.ahfkI);
        return DBUtil.g(this.f124922a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationDao_Impl.J0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
