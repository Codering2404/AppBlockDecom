package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
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
public final class IntervalDao_Impl extends IntervalDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f125062g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f125063h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125067d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f125068f;

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

    public IntervalDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125064a = __db;
        this.f125065b = new EntityInsertAdapter<Interval>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `Interval` (`id`,`profileId`,`fromInMinutes`,`toInMinutes`,`parentId`,`isAllDayAuto`,`isEnabled`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Interval entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                statement.A(2, entity.g());
                statement.A(3, entity.b());
                statement.A(4, entity.a());
                Long lF = entity.f();
                if (lF == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lF.longValue());
                }
                statement.A(6, entity.h() ? 1L : 0L);
                statement.A(7, entity.i() ? 1L : 0L);
            }
        };
        this.f125066c = new EntityDeleteOrUpdateAdapter<Interval>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `Interval` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Interval entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
            }
        };
        this.f125067d = new EntityDeleteOrUpdateAdapter<Interval>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `Interval` SET `id` = ?,`profileId` = ?,`fromInMinutes` = ?,`toInMinutes` = ?,`parentId` = ?,`isAllDayAuto` = ?,`isEnabled` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Interval entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                statement.A(2, entity.g());
                statement.A(3, entity.b());
                statement.A(4, entity.a());
                Long lF = entity.f();
                if (lF == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lF.longValue());
                }
                statement.A(6, entity.h() ? 1L : 0L);
                statement.A(7, entity.i() ? 1L : 0L);
                statement.A(8, entity.e());
            }
        };
        this.f125068f = new EntityUpsertAdapter(new EntityInsertAdapter<Interval>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `Interval` (`id`,`profileId`,`fromInMinutes`,`toInMinutes`,`parentId`,`isAllDayAuto`,`isEnabled`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Interval entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                statement.A(2, entity.g());
                statement.A(3, entity.b());
                statement.A(4, entity.a());
                Long lF = entity.f();
                if (lF == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lF.longValue());
                }
                statement.A(6, entity.h() ? 1L : 0L);
                statement.A(7, entity.i() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<Interval>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `Interval` SET `id` = ?,`profileId` = ?,`fromInMinutes` = ?,`toInMinutes` = ?,`parentId` = ?,`isAllDayAuto` = ?,`isEnabled` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Interval entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.e());
                statement.A(2, entity.g());
                statement.A(3, entity.b());
                statement.A(4, entity.a());
                Long lF = entity.f();
                if (lF == null) {
                    statement.D(5);
                } else {
                    statement.A(5, lF.longValue());
                }
                statement.A(6, entity.h() ? 1L : 0L);
                statement.A(7, entity.i() ? 1L : 0L);
                statement.A(8, entity.e());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(String str, long j3, SQLiteConnection _connection) {
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
    public static final Unit B0(String str, Collection collection, SQLiteConnection _connection) {
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
    public static final List C0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "fromInMinutes");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "toInMinutes");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "parentId");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAllDayAuto");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                long j4 = sQLiteStatementG2.getLong(iD2);
                long j5 = sQLiteStatementG2.getLong(iD3);
                long j6 = sQLiteStatementG2.getLong(iD4);
                Long lValueOf = sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5));
                boolean z2 = true;
                if (((int) sQLiteStatementG2.getLong(iD6)) == 0) {
                    z2 = false;
                }
                arrayList.add(new Interval(j3, j4, j5, j6, lValueOf, z2, ((int) sQLiteStatementG2.getLong(iD7)) != 0));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List D0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "fromInMinutes");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "toInMinutes");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "parentId");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAllDayAuto");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Interval(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5)), ((int) sQLiteStatementG2.getLong(iD6)) != 0, ((int) sQLiteStatementG2.getLong(iD7)) != 0));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List F0(String str, Collection collection, SQLiteConnection _connection) {
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
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "fromInMinutes");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "toInMinutes");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "parentId");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAllDayAuto");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i4 = iD2;
                arrayList.add(new Interval(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5)), ((int) sQLiteStatementG2.getLong(iD6)) != 0, ((int) sQLiteStatementG2.getLong(iD7)) != 0));
                iD2 = i4;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Interval G0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "fromInMinutes");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "toInMinutes");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "parentId");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAllDayAuto");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            Interval interval = null;
            if (sQLiteStatementG2.B2()) {
                interval = new Interval(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5)), ((int) sQLiteStatementG2.getLong(iD6)) != 0, ((int) sQLiteStatementG2.getLong(iD7)) != 0);
            }
            return interval;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Interval H0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "fromInMinutes");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "toInMinutes");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "parentId");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAllDayAuto");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            Interval interval = null;
            if (sQLiteStatementG2.B2()) {
                interval = new Interval(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5)), ((int) sQLiteStatementG2.getLong(iD6)) != 0, ((int) sQLiteStatementG2.getLong(iD7)) != 0);
            }
            return interval;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long J0(IntervalDao_Impl intervalDao_Impl, Interval interval, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return intervalDao_Impl.f125065b.d(_connection, interval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K0(IntervalDao_Impl intervalDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return intervalDao_Impl.f125065b.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(IntervalDao_Impl intervalDao_Impl, Collection collection, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        intervalDao_Impl.f125067d.d(_connection, collection);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v0(String str, long j3, SQLiteConnection _connection) {
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
    public static final Unit x0(IntervalDao_Impl intervalDao_Impl, Interval interval, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        intervalDao_Impl.f125066c.c(_connection, interval);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(IntervalDao_Impl intervalDao_Impl, List list, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        intervalDao_Impl.f125066c.d(_connection, list);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(String str, long j3, SQLiteConnection _connection) {
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

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public Object n(final Interval interval, Continuation continuation) {
        return DBUtil.g(this.f125064a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.w1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(IntervalDao_Impl.J0(this.f125719a, interval, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object J(final long j3, Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM Interval WHERE profileId = ?";
        return DBUtil.g(this.f125064a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.d2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(IntervalDao_Impl.v0(str, j3, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object K(final long j3, Continuation continuation) {
        final String str = "DELETE FROM Interval WHERE profileId = ? AND isAllDayAuto = 1";
        Object objG = DBUtil.g(this.f125064a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.e2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.z0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object L(final long j3, Continuation continuation) {
        final String str = "DELETE FROM Interval WHERE parentId = ?";
        Object objG = DBUtil.g(this.f125064a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.f2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.A0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object M(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM Interval WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f125064a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.c2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.B0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object T(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM Interval WHERE profileId = ?";
        return DBUtil.g(this.f125064a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.a2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.D0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object U(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM Interval WHERE profileId = ? AND isAllDayAuto = 0";
        return DBUtil.g(this.f125064a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.g2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.E0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object V(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM Interval WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(") AND isAllDayAuto = 0");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125064a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.v1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.F0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object W(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM Interval WHERE parentId IS NOT NULL AND parentId = ?";
        return DBUtil.g(this.f125064a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.h2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.H0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object X(long j3, Continuation continuation) {
        Object objF = DBUtil.f(this.f125064a, new IntervalDao_Impl$insertAllDayAuto$2(this, j3, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object Z(Interval interval, Continuation continuation) {
        return DBUtil.f(this.f125064a, new IntervalDao_Impl$insertAndDeleteAuto$2(this, interval, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object e(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM Interval WHERE id = ?";
        return DBUtil.g(this.f125064a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.z1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.G0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object h(final List list, Continuation continuation) {
        Object objG = DBUtil.g(this.f125064a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.t1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.y0(this.f125665a, list, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao
    public Object k(Continuation continuation) {
        final String str = "SELECT * FROM Interval";
        return DBUtil.g(this.f125064a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.b2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.C0(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object r(final Collection collection, Continuation continuation) {
        Object objG = DBUtil.g(this.f125064a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.u1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.L0(this.f125681a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125064a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.y1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.K0(this.f125758a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public Object q(final Interval interval, Continuation continuation) {
        Object objG = DBUtil.g(this.f125064a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.x1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntervalDao_Impl.x0(this.f125735a, interval, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List E0(String str, long j3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "fromInMinutes");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "toInMinutes");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, tDEtWsFLJfe.xbrzBZbt);
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "isAllDayAuto");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isEnabled");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new Interval(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.getLong(iD3), sQLiteStatementG2.getLong(iD4), sQLiteStatementG2.isNull(iD5) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD5)), ((int) sQLiteStatementG2.getLong(iD6)) != 0, ((int) sQLiteStatementG2.getLong(iD7)) != 0));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }
}
