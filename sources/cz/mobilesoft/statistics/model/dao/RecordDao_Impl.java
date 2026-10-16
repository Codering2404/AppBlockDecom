package cz.mobilesoft.statistics.model.dao;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import androidx.lifecycle.LiveData;
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
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.facebook.share.HKJ.pnxuebdT;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import cz.mobilesoft.statistics.model.AggregatedAverage;
import cz.mobilesoft.statistics.model.AggregatedCategoryRecord;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import cz.mobilesoft.statistics.model.AggregatedRecord;
import cz.mobilesoft.statistics.model.AggregatedRecordsWithAverage;
import cz.mobilesoft.statistics.model.AppDifference;
import cz.mobilesoft.statistics.model.AppWithType;
import cz.mobilesoft.statistics.model.Record;
import cz.mobilesoft.statistics.model.RecordDuration;
import cz.mobilesoft.statistics.model.dao.RecordDao_Impl;
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
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

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
public final class RecordDao_Impl implements RecordDao {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f133756f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f133757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f133758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f133759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f133760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EntityUpsertAdapter f133761e;

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

    public RecordDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f133757a = __db;
        this.f133758b = new EntityInsertAdapter<Record>() { // from class: cz.mobilesoft.statistics.model.dao.RecordDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `record` (`timestamp`,`originalBeginTime`,`name`,`parentName`,`typeId`,`duration`,`isInitial`,`appType`,`category`,`id`) VALUES (?,?,?,?,?,?,?,?,?,nullif(?, 0))";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Record entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.h());
                statement.A(2, entity.f());
                statement.p0(3, entity.e());
                String strG = entity.g();
                if (strG == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strG);
                }
                statement.A(5, entity.i());
                statement.A(6, entity.c());
                statement.A(7, entity.j() ? 1L : 0L);
                String strA = entity.a();
                if (strA == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strA);
                }
                String strB = entity.b();
                if (strB == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, strB);
                }
                statement.A(10, entity.d());
            }
        };
        this.f133759c = new EntityDeleteOrUpdateAdapter<Record>() { // from class: cz.mobilesoft.statistics.model.dao.RecordDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `record` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Record entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
            }
        };
        this.f133760d = new EntityDeleteOrUpdateAdapter<Record>() { // from class: cz.mobilesoft.statistics.model.dao.RecordDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `record` SET `timestamp` = ?,`originalBeginTime` = ?,`name` = ?,`parentName` = ?,`typeId` = ?,`duration` = ?,`isInitial` = ?,`appType` = ?,`category` = ?,`id` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Record entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.h());
                statement.A(2, entity.f());
                statement.p0(3, entity.e());
                String strG = entity.g();
                if (strG == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strG);
                }
                statement.A(5, entity.i());
                statement.A(6, entity.c());
                statement.A(7, entity.j() ? 1L : 0L);
                String strA = entity.a();
                if (strA == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strA);
                }
                String strB = entity.b();
                if (strB == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, strB);
                }
                statement.A(10, entity.d());
                statement.A(11, entity.d());
            }
        };
        this.f133761e = new EntityUpsertAdapter(new EntityInsertAdapter<Record>() { // from class: cz.mobilesoft.statistics.model.dao.RecordDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `record` (`timestamp`,`originalBeginTime`,`name`,`parentName`,`typeId`,`duration`,`isInitial`,`appType`,`category`,`id`) VALUES (?,?,?,?,?,?,?,?,?,nullif(?, 0))";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Record entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.h());
                statement.A(2, entity.f());
                statement.p0(3, entity.e());
                String strG = entity.g();
                if (strG == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strG);
                }
                statement.A(5, entity.i());
                statement.A(6, entity.c());
                statement.A(7, entity.j() ? 1L : 0L);
                String strA = entity.a();
                if (strA == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strA);
                }
                String strB = entity.b();
                if (strB == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, strB);
                }
                statement.A(10, entity.d());
            }
        }, new EntityDeleteOrUpdateAdapter<Record>() { // from class: cz.mobilesoft.statistics.model.dao.RecordDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `record` SET `timestamp` = ?,`originalBeginTime` = ?,`name` = ?,`parentName` = ?,`typeId` = ?,`duration` = ?,`isInitial` = ?,`appType` = ?,`category` = ?,`id` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, Record entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.h());
                statement.A(2, entity.f());
                statement.p0(3, entity.e());
                String strG = entity.g();
                if (strG == null) {
                    statement.D(4);
                } else {
                    statement.p0(4, strG);
                }
                statement.A(5, entity.i());
                statement.A(6, entity.c());
                statement.A(7, entity.j() ? 1L : 0L);
                String strA = entity.a();
                if (strA == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strA);
                }
                String strB = entity.b();
                if (strB == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, strB);
                }
                statement.A(10, entity.d());
                statement.A(11, entity.d());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(String str, SQLiteConnection _connection) {
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
    public static final Unit F0(String str, int i3, SQLiteConnection _connection) {
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
    public static final List G0(String str, List list, int i3, Collection collection, int i4, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.A(i6 + i4, j3);
            sQLiteStatementG2.A(i3 + 2 + i4, j4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AggregatedItemRecord((int) sQLiteStatementG2.getLong(4), sQLiteStatementG2.f2(0), sQLiteStatementG2.isNull(1) ? null : sQLiteStatementG2.f2(1), sQLiteStatementG2.isNull(5) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(5)), (int) sQLiteStatementG2.getLong(2), null, sQLiteStatementG2.isNull(3) ? null : sQLiteStatementG2.f2(3)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List I0(String str, List list, int i3, Collection collection, int i4, String str2, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.p0(i6 + i4, str2);
            sQLiteStatementG2.A(i3 + 2 + i4, j3);
            sQLiteStatementG2.A(i3 + 3 + i4, j4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                Integer numValueOf = null;
                String strF2 = sQLiteStatementG2.isNull(0) ? null : sQLiteStatementG2.f2(0);
                int i8 = (int) sQLiteStatementG2.getLong(1);
                if (!sQLiteStatementG2.isNull(2)) {
                    numValueOf = Integer.valueOf((int) sQLiteStatementG2.getLong(2));
                }
                arrayList.add(new AggregatedCategoryRecord(i8, numValueOf, strF2));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List J0(String str, List list, int i3, Collection collection, int i4, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.A(i6 + i4, j3);
            sQLiteStatementG2.A(i3 + 2 + i4, j4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                Integer numValueOf = null;
                String strF2 = sQLiteStatementG2.isNull(0) ? null : sQLiteStatementG2.f2(0);
                int i8 = (int) sQLiteStatementG2.getLong(1);
                if (!sQLiteStatementG2.isNull(2)) {
                    numValueOf = Integer.valueOf((int) sQLiteStatementG2.getLong(2));
                }
                arrayList.add(new AggregatedCategoryRecord(i8, numValueOf, strF2));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K0(String str, List list, int i3, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, j3);
            sQLiteStatementG2.A(i3 + 2, j4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AggregatedItemRecord((int) sQLiteStatementG2.getLong(3), sQLiteStatementG2.f2(0), sQLiteStatementG2.isNull(1) ? null : sQLiteStatementG2.f2(1), sQLiteStatementG2.isNull(4) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(4)), (int) sQLiteStatementG2.getLong(2), null, null));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List L0(String str, List list, int i3, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, j3);
            sQLiteStatementG2.A(i3 + 2, j4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AggregatedItemRecord((int) sQLiteStatementG2.getLong(3), sQLiteStatementG2.f2(0), sQLiteStatementG2.isNull(1) ? null : sQLiteStatementG2.f2(1), sQLiteStatementG2.isNull(4) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(4)), (int) sQLiteStatementG2.getLong(2), null, null));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List M0(String str, List list, int i3, Collection collection, int i4, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.A(i6 + i4, j3);
            sQLiteStatementG2.A(i3 + 2 + i4, j4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AggregatedItemRecord((int) sQLiteStatementG2.getLong(4), sQLiteStatementG2.f2(0), sQLiteStatementG2.isNull(1) ? null : sQLiteStatementG2.f2(1), sQLiteStatementG2.isNull(5) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(5)), (int) sQLiteStatementG2.getLong(2), null, sQLiteStatementG2.isNull(3) ? null : sQLiteStatementG2.f2(3)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List N0(String str, Collection collection, int i3, List list, int i4, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i5, ((Number) it.next()).intValue());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = list.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.p0(i7, (String) it2.next());
                i7++;
            }
            sQLiteStatementG2.A(i6 + i4, j3);
            sQLiteStatementG2.A(i3 + 2 + i4, j4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AggregatedRecord(sQLiteStatementG2.f2(0), (int) sQLiteStatementG2.getLong(1), null, (int) sQLiteStatementG2.getLong(2), sQLiteStatementG2.isNull(3) ? null : sQLiteStatementG2.f2(3), null));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List O0(String str, RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "date");
            int iC2 = SQLiteStatementUtil.c(sQLiteStatementG2, "duration");
            int iC3 = SQLiteStatementUtil.c(sQLiteStatementG2, "launchCount");
            int iC4 = SQLiteStatementUtil.c(sQLiteStatementG2, "typeId");
            int iC5 = SQLiteStatementUtil.c(sQLiteStatementG2, "appDistractionType");
            int iC6 = SQLiteStatementUtil.c(sQLiteStatementG2, "category");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                if (iC == -1) {
                    throw new IllegalStateException("Missing column 'date' for a NON-NULL value, column not found in result.");
                }
                String strF2 = sQLiteStatementG2.f2(iC);
                int i3 = 0;
                int i4 = iC2 == -1 ? 0 : (int) sQLiteStatementG2.getLong(iC2);
                String strF22 = null;
                Integer numValueOf = (iC3 == -1 || sQLiteStatementG2.isNull(iC3)) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(iC3));
                if (iC4 != -1) {
                    i3 = (int) sQLiteStatementG2.getLong(iC4);
                }
                String strF23 = (iC5 == -1 || sQLiteStatementG2.isNull(iC5)) ? null : sQLiteStatementG2.f2(iC5);
                if (iC6 != -1 && !sQLiteStatementG2.isNull(iC6)) {
                    strF22 = sQLiteStatementG2.f2(iC6);
                }
                arrayList.add(new AggregatedRecord(strF2, i4, numValueOf, i3, strF23, strF22));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AggregatedRecordsWithAverage P0(RecordDao_Impl recordDao_Impl, String str, Integer[] numArr, String[] strArr, String[] strArr2, String str2, String str3, long j3, long j4, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "<unused var>");
        return super.S(str, numArr, strArr, strArr2, str2, str3, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Q0(String str, long j3, long j4, List list, int i3, Collection collection, int i4, long j5, long j6, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            Iterator it = list.iterator();
            int i5 = 3;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 3;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.A(i6 + i4, j5);
            sQLiteStatementG2.A(i3 + 4 + i4, j6);
            int i8 = i3 + 5 + i4;
            Iterator it3 = list.iterator();
            int i9 = i8;
            while (it3.hasNext()) {
                sQLiteStatementG2.p0(i9, (String) it3.next());
                i9++;
            }
            int i10 = i8 + i3;
            Iterator it4 = collection.iterator();
            while (it4.hasNext()) {
                sQLiteStatementG2.A(i10, ((Number) it4.next()).intValue());
                i10++;
            }
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AppDifference(sQLiteStatementG2.f2(0), sQLiteStatementG2.getLong(1), sQLiteStatementG2.getLong(2), sQLiteStatementG2.getLong(3)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List R0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new AppWithType(sQLiteStatementG2.f2(0), null));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List S0(String str, int i3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, i3);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(sQLiteStatementG2.f2(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AggregatedAverage T0(String str, RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "avgDuration");
            int iC2 = SQLiteStatementUtil.c(sQLiteStatementG2, "avgLaunchCount");
            if (!sQLiteStatementG2.B2()) {
                throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type 'cz.mobilesoft.statistics.model.AggregatedAverage'.");
            }
            float f3 = 0.0f;
            float f4 = iC == -1 ? 0.0f : (float) sQLiteStatementG2.getDouble(iC);
            if (iC2 != -1) {
                f3 = (float) sQLiteStatementG2.getDouble(iC2);
            }
            return new AggregatedAverage(f4, f3);
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List U0(String str, List list, int i3, Collection collection, int i4, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.A(i6 + i4, j3);
            sQLiteStatementG2.A(i3 + 2 + i4, j4);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new RecordDuration(sQLiteStatementG2.getLong(2), sQLiteStatementG2.f2(1), sQLiteStatementG2.getLong(0)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AggregatedRecordsWithAverage V0(RecordDao_Impl recordDao_Impl, Integer[] numArr, String[] strArr, String[] strArr2, long j3, long j4, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "<unused var>");
        return super.P(numArr, strArr, strArr2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double W0(String str, List list, int i3, long j3, long j4, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, j3);
            sQLiteStatementG2.A(i3 + 2, j4);
            int i5 = i3 + 3;
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i5, ((Number) it2.next()).intValue());
                i5++;
            }
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double X0(String str, List list, int i3, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, j3);
            sQLiteStatementG2.A(i3 + 2, j4);
            sQLiteStatementG2.A(i3 + 3, j3);
            sQLiteStatementG2.A(i3 + 4, j4);
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double Y0(String str, long j3, long j4, List list, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            Iterator it = list.iterator();
            int i3 = 3;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double Z0(String str, List list, int i3, long j3, long j4, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, j3);
            sQLiteStatementG2.A(i3 + 2, j4);
            int i5 = i3 + 3;
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i5, ((Number) it2.next()).intValue());
                i5++;
            }
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double a1(String str, long j3, long j4, List list, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, j4);
            Iterator it = list.iterator();
            int i3 = 3;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double b1(String str, List list, int i3, Collection collection, int i4, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.A(i6 + i4, j3);
            sQLiteStatementG2.A(i3 + 2 + i4, j4);
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double c1(String str, List list, int i3, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, j3);
            sQLiteStatementG2.A(i3 + 2, j4);
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecordDuration d1(String str, List list, int i3, Collection collection, int i4, long j3, long j4, SQLiteConnection _connection) {
        RecordDuration recordDuration;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.A(i6 + i4, j3);
            sQLiteStatementG2.A(i3 + 2 + i4, j4);
            if (sQLiteStatementG2.B2()) {
                recordDuration = new RecordDuration(sQLiteStatementG2.getLong(2), sQLiteStatementG2.f2(1), sQLiteStatementG2.getLong(0));
            } else {
                recordDuration = null;
            }
            sQLiteStatementG2.close();
            return recordDuration;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long e1(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Long lValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                lValueOf = Long.valueOf(sQLiteStatementG2.getLong(0));
            }
            return lValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double f1(String str, List list, int i3, Collection collection, int i4, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.A(i6 + i4, j3);
            sQLiteStatementG2.A(i3 + 2 + i4, j4);
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double g1(String str, String str2, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            sQLiteStatementG2.A(2, j3);
            sQLiteStatementG2.A(3, j4);
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double h1(String str, List list, int i3, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, j3);
            sQLiteStatementG2.A(i3 + 2, j4);
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double i1(String str, List list, int i3, Collection collection, int i4, String str2, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.p0(i6 + i4, str2);
            sQLiteStatementG2.A(i3 + 2 + i4, j3);
            sQLiteStatementG2.A(i3 + 3 + i4, j4);
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double j1(String str, List list, int i3, Collection collection, int i4, String str2, long j3, long j4, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = list.iterator();
            int i5 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i5, (String) it.next());
                i5++;
            }
            int i6 = i3 + 1;
            Iterator it2 = collection.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i7, ((Number) it2.next()).intValue());
                i7++;
            }
            sQLiteStatementG2.p0(i6 + i4, str2);
            sQLiteStatementG2.A(i3 + 2 + i4, j3);
            sQLiteStatementG2.A(i3 + 3 + i4, j4);
            Double dValueOf = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                dValueOf = Double.valueOf(sQLiteStatementG2.getDouble(0));
            }
            return dValueOf;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AggregatedRecordsWithAverage k1(RecordDao_Impl recordDao_Impl, Integer[] numArr, String[] strArr, String[] strArr2, long j3, long j4, SQLiteConnection sQLiteConnection) {
        Intrinsics.checkNotNullParameter(sQLiteConnection, "<unused var>");
        return super.b(numArr, strArr, strArr2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List l1(RecordDao_Impl recordDao_Impl, List list, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return recordDao_Impl.f133758b.e(_connection, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String m1(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            String strF2 = null;
            if (sQLiteStatementG2.B2() && !sQLiteStatementG2.isNull(0)) {
                strF2 = sQLiteStatementG2.f2(0);
            }
            return strF2;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(String str, String str2, String str3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            if (str2 == null) {
                sQLiteStatementG2.D(1);
            } else {
                sQLiteStatementG2.p0(1, str2);
            }
            sQLiteStatementG2.p0(2, str3);
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public List A(SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(query).n();
        final String strF = roomRawQueryN.f();
        return (List) DBUtil.e(this.f133757a, true, false, new Function1() { // from class: n2.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.O0(strF, roomRawQueryN, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object C(final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("        SELECT name, parentName, typeId, ");
        sb.append("\n");
        sb.append("            SUM(duration) AS duration, ");
        sb.append("\n");
        sb.append("            SUM(isInitial) AS launchCount ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("            GROUP BY name ");
        sb.append("\n");
        sb.append("            ORDER BY duration DESC");
        sb.append("\n");
        sb.append("    ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.L0(string, list, size, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object D(final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(duration) ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.h1(string, list, size, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object E(final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(isInitial) ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.c1(string, list, size, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.BaseDao
    public List F(final List entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return (List) DBUtil.e(this.f133757a, false, true, new Function1() { // from class: n2.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.l1(this.f143566a, entity, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object G(final String str, final long j3, final long j4, Continuation continuation) {
        final String str2 = "SELECT SUM(duration) \n            FROM record \n            WHERE name = ?\n            AND timestamp BETWEEN ?/1000 AND ?/1000";
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.g1(str2, str, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object H(final Collection collection, final List list, final String str, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(duration) ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            LEFT JOIN applicationAppType ON record.name = applicationAppType.packageName ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND typeId IN (");
        final int size2 = collection.size();
        StringUtil.a(sb, size2);
        sb.append(") ");
        sb.append("\n");
        sb.append("            AND applicationAppType.appDistractionType = ");
        sb.append("?");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.i1(string, list, size, collection, size2, str, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public List J(SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(query).n();
        final String strF = roomRawQueryN.f();
        return (List) DBUtil.e(this.f133757a, true, false, new Function1() { // from class: n2.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.H0(strF, roomRawQueryN, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Flow K(final Collection typeIds, final List ignoredNames, final long j3, final long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DATE(timestamp, 'unixepoch', 'localtime') AS date, ");
        sb.append("\n");
        sb.append("            SUM(duration) AS duration, typeId, appDistractionType ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            LEFT JOIN applicationAppType ON record.name = applicationAppType.packageName ");
        sb.append("\n");
        sb.append("            WHERE typeId IN (");
        final int size = typeIds.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND name NOT IN (");
        final int size2 = ignoredNames.size();
        StringUtil.a(sb, size2);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("            GROUP BY appDistractionType, date ");
        sb.append("\n");
        sb.append("            ORDER BY date");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return FlowUtil.a(this.f133757a, false, new String[]{"record", "applicationAppType"}, new Function1() { // from class: n2.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.N0(string, typeIds, size, ignoredNames, size2, j3, j4, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object L(final Collection collection, final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT AVG(launchCount) ");
        sb.append("\n");
        sb.append("            FROM (");
        sb.append("\n");
        sb.append("                SELECT SUM(isInitial) AS launchCount  ");
        sb.append("\n");
        sb.append("                FROM record ");
        sb.append("\n");
        sb.append("                WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("                AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("                AND typeId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(") ");
        sb.append("\n");
        sb.append("                GROUP BY DATE(timestamp, 'unixepoch', 'localtime') ");
        sb.append("\n");
        sb.append("            )");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.Z0(string, list, size, j3, j4, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object M(final Collection collection, final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(duration) ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND typeId IN (");
        final int size2 = collection.size();
        StringUtil.a(sb, size2);
        sb.append(") ");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.f1(string, list, size, collection, size2, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object O(final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT AVG(launchCount) ");
        sb.append("\n");
        sb.append("            FROM (");
        sb.append("\n");
        sb.append("                SELECT SUM(isInitial) AS launchCount  ");
        sb.append("\n");
        sb.append("                FROM record ");
        sb.append("\n");
        sb.append("                WHERE timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("                AND name IN (");
        StringUtil.a(sb, list.size());
        sb.append(") ");
        sb.append("\n");
        sb.append("                GROUP BY DATE(timestamp, 'unixepoch', 'localtime') ");
        sb.append("\n");
        sb.append("            )");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.a1(string, j3, j4, list, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public AggregatedRecordsWithAverage P(final Integer[] numArr, final String[] strArr, final String[] strArr2, final long j3, final long j4) {
        return (AggregatedRecordsWithAverage) DBUtil.e(this.f133757a, false, true, new Function1() { // from class: n2.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.V0(this.f143624a, numArr, strArr, strArr2, j3, j4, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object Q(final Collection collection, final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT AVG(duration) ");
        sb.append("\n");
        sb.append("            FROM (");
        sb.append("\n");
        sb.append("                SELECT SUM(duration) AS duration  ");
        sb.append("\n");
        sb.append("                FROM record ");
        sb.append("\n");
        sb.append("                WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("                AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("                AND typeId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(") ");
        sb.append("\n");
        sb.append("                GROUP BY DATE(timestamp, 'unixepoch', 'localtime') ");
        sb.append("\n");
        sb.append("            )");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.W0(string, list, size, j3, j4, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public /* bridge */ List R(String str, Integer[] numArr, String[] strArr, String[] strArr2, String str2, String str3, long j3, long j4) {
        return super.R(str, numArr, strArr, strArr2, str2, str3, j3, j4);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public AggregatedRecordsWithAverage S(final String dateFormat, final Integer[] numArr, final String[] strArr, final String[] strArr2, final String str, final String str2, final long j3, final long j4) {
        Intrinsics.checkNotNullParameter(dateFormat, "dateFormat");
        return (AggregatedRecordsWithAverage) DBUtil.e(this.f133757a, false, true, new Function1() { // from class: n2.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.P0(this.f143578a, dateFormat, numArr, strArr, strArr2, str, str2, j3, j4, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public AggregatedAverage T(SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        final RoomRawQuery roomRawQueryN = RoomSQLiteQuery.f52354j.b(query).n();
        final String strF = roomRawQueryN.f();
        return (AggregatedAverage) DBUtil.e(this.f133757a, true, false, new Function1() { // from class: n2.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.T0(strF, roomRawQueryN, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public /* bridge */ List a(Collection collection, String[] strArr, String str, String str2, List list, long j3, long j4) {
        return super.a(collection, strArr, str, str2, list, j3, j4);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public AggregatedRecordsWithAverage b(final Integer[] numArr, final String[] strArr, final String[] strArr2, final long j3, final long j4) {
        return (AggregatedRecordsWithAverage) DBUtil.e(this.f133757a, false, true, new Function1() { // from class: n2.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.k1(this.f143570a, numArr, strArr, strArr2, j3, j4, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object c(final Collection collection, final String str, final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("        SELECT category, ");
        sb.append("\n");
        sb.append("            SUM(duration) AS duration, ");
        sb.append("\n");
        sb.append("            SUM(isInitial) AS launchCount ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            LEFT JOIN applicationAppType ON record.name = applicationAppType.packageName ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND typeId IN (");
        final int size2 = collection.size();
        StringUtil.a(sb, size2);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND applicationAppType.appDistractionType = ");
        sb.append("?");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("            GROUP BY category");
        sb.append("\n");
        sb.append("            ORDER BY duration DESC");
        sb.append("\n");
        sb.append("    ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.I0(string, list, size, collection, size2, str, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object e(final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT AVG(duration) ");
        sb.append("\n");
        sb.append("            FROM (");
        sb.append("\n");
        sb.append("                SELECT SUM(duration) AS duration  ");
        sb.append("\n");
        sb.append("                FROM record ");
        sb.append("\n");
        sb.append("                WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("                AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        sb.append("\n");
        sb.append("                AND name || \"_\" || timestamp NOT IN (");
        sb.append("\n");
        sb.append("                    SELECT parentName || \"_\" || timestamp ");
        sb.append("\n");
        sb.append("                    FROM record");
        sb.append("\n");
        sb.append("                    WHERE parentName IS NOT NULL");
        sb.append("\n");
        sb.append("                    AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("                )");
        sb.append("\n");
        sb.append("                GROUP BY DATE(timestamp, 'unixepoch', 'localtime') ");
        sb.append("\n");
        sb.append("            )");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.X0(string, list, size, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Flow f() {
        final String str = "SELECT name, appDistractionType FROM record LEFT JOIN applicationAppType ON record.name = applicationAppType.packageName GROUP BY name";
        return FlowUtil.a(this.f133757a, false, new String[]{"record", "applicationAppType"}, new Function1() { // from class: n2.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.R0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public void g(final int i3) {
        final String str = "DELETE FROM record WHERE typeId = ?";
        DBUtil.e(this.f133757a, false, true, new Function1() { // from class: n2.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.F0(str, i3, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public LiveData h(final List names, final long j3, final long j4) {
        Intrinsics.checkNotNullParameter(names, "names");
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("        SELECT name, parentName, typeId, ");
        sb.append("\n");
        sb.append("            SUM(duration) AS duration, ");
        sb.append("\n");
        sb.append("            SUM(isInitial) AS launchCount ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name IN (");
        final int size = names.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("            GROUP BY name ");
        sb.append("\n");
        sb.append("            ORDER BY duration DESC");
        sb.append("\n");
        sb.append("    ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return this.f133757a.getInvalidationTracker().p(new String[]{"record"}, false, new Function1() { // from class: n2.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.K0(string, names, size, j3, j4, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object j(final Collection collection, final List list, final String str, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(duration) ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND typeId IN (");
        final int size2 = collection.size();
        StringUtil.a(sb, size2);
        sb.append(") ");
        sb.append("\n");
        sb.append("            AND category = ");
        sb.append("?");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.j1(string, list, size, collection, size2, str, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public void k() {
        final String str = "DELETE FROM record";
        DBUtil.e(this.f133757a, false, true, new Function1() { // from class: n2.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.E0(str, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object l(final int i3, Continuation continuation) {
        final String str = "SELECT name FROM record LEFT JOIN applicationAppType ON record.name = applicationAppType.packageName WHERE appDistractionType IS NULL AND record.typeId = ? GROUP BY name";
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.S0(str, i3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Flow m(final String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        final String str = "SELECT appDistractionType FROM applicationAppType WHERE packageName = ?";
        return FlowUtil.a(this.f133757a, false, new String[]{"applicationAppType"}, new Function1() { // from class: n2.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.m1(str, packageName, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object n(final Collection collection, final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("        SELECT category, ");
        sb.append("\n");
        sb.append("            SUM(duration) AS duration, ");
        sb.append("\n");
        sb.append("            SUM(isInitial) AS launchCount ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND typeId IN (");
        final int size2 = collection.size();
        StringUtil.a(sb, size2);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("            GROUP BY category");
        sb.append("\n");
        sb.append("            ORDER BY duration DESC");
        sb.append("\n");
        sb.append("    ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.J0(string, list, size, collection, size2, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object q(final Collection collection, final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(duration) as total, name, originalBeginTime as timestamp ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND typeId IN (");
        final int size2 = collection.size();
        StringUtil.a(sb, size2);
        sb.append(") ");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        sb.append("\n");
        sb.append("            GROUP BY originalBeginTime ORDER BY total DESC LIMIT 1");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.d1(string, list, size, collection, size2, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public /* bridge */ SimpleSQLiteQuery r(String str, String str2, long j3, long j4, Integer[] numArr, String[] strArr, String[] strArr2) {
        return super.r(str, str2, j3, j4, numArr, strArr, strArr2);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object s(final String str, final String str2, Continuation continuation) {
        final String str3 = "UPDATE record SET category = ? WHERE name = ?";
        Object objG = DBUtil.g(this.f133757a, false, true, new Function1() { // from class: n2.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.n1(str3, str2, str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public List t(final Collection typeIds, final long j3, final long j4, final long j5, final long j6, final List ignoredNames) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("                WITH Week1Usage AS (");
        sb.append("\n");
        sb.append("                    -- Step 1: Aggregate usage for each app in the first weekly interval");
        sb.append("\n");
        sb.append("                    SELECT");
        sb.append("\n");
        sb.append("                        name,");
        sb.append("\n");
        sb.append("                        SUM(duration) AS total_duration_week1");
        sb.append("\n");
        sb.append("                    FROM record");
        sb.append("\n");
        sb.append("                    WHERE timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        sb.append("\n");
        sb.append("                    AND name NOT IN (");
        final int size = ignoredNames.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("                    AND typeId IN (");
        final int size2 = typeIds.size();
        StringUtil.a(sb, size2);
        sb.append(") ");
        sb.append("\n");
        sb.append("                    GROUP BY name");
        sb.append("\n");
        sb.append("                ),");
        sb.append("\n");
        sb.append("                Week2Usage AS (");
        sb.append("\n");
        sb.append("                    -- Step 2: Aggregate usage for each app in the second weekly interval");
        sb.append("\n");
        sb.append("                    SELECT");
        sb.append("\n");
        sb.append("                        name,");
        sb.append("\n");
        sb.append("                        SUM(duration) AS total_duration_week2");
        sb.append("\n");
        sb.append("                    FROM record");
        sb.append("\n");
        sb.append("                    WHERE timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        sb.append("\n");
        sb.append("                    AND name NOT IN (");
        StringUtil.a(sb, ignoredNames.size());
        sb.append(")");
        sb.append("\n");
        sb.append("                    AND typeId IN (");
        StringUtil.a(sb, typeIds.size());
        sb.append(") ");
        sb.append("\n");
        sb.append("                    GROUP BY name");
        sb.append("\n");
        sb.append("                )");
        sb.append("\n");
        sb.append("                -- Step 3: Join the weekly usages and calculate the difference");
        sb.append("\n");
        sb.append("                SELECT");
        sb.append("\n");
        sb.append("                    COALESCE(w1.name, w2.name) AS packageName,");
        sb.append("\n");
        sb.append("                    IFNULL(w1.total_duration_week1, 0) AS usageFirstInterval,");
        sb.append("\n");
        sb.append("                    IFNULL(w2.total_duration_week2, 0) AS usageSecondInterval,");
        sb.append("\n");
        sb.append("                    (IFNULL(w2.total_duration_week2, 0) - IFNULL(w1.total_duration_week1, 0)) AS difference");
        sb.append("\n");
        sb.append("                FROM");
        sb.append("\n");
        sb.append("                    Week1Usage w1");
        sb.append("\n");
        sb.append("                INNER JOIN");
        sb.append("\n");
        sb.append("                    Week2Usage w2 ON w1.name = w2.name");
        sb.append("\n");
        sb.append("                ORDER BY");
        sb.append("\n");
        sb.append("                    difference;");
        sb.append("\n");
        sb.append("            ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return (List) DBUtil.e(this.f133757a, true, false, new Function1() { // from class: n2.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.Q0(string, j3, j4, ignoredNames, size, typeIds, size2, j5, j6, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object u(Continuation continuation) {
        final String str = "SELECT MIN(timestamp)*1000 FROM record";
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.e1(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object v(final Collection collection, final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(isInitial) ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND typeId IN (");
        final int size2 = collection.size();
        StringUtil.a(sb, size2);
        sb.append(") ");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.b1(string, list, size, collection, size2, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H0(String str, RoomRawQuery roomRawQuery, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            roomRawQuery.e().invoke(sQLiteStatementG2);
            int iC = SQLiteStatementUtil.c(sQLiteStatementG2, "duration");
            int iC2 = SQLiteStatementUtil.c(sQLiteStatementG2, "name");
            int iC3 = SQLiteStatementUtil.c(sQLiteStatementG2, "parentName");
            int iC4 = SQLiteStatementUtil.c(sQLiteStatementG2, tDEtWsFLJfe.MClgi);
            int iC5 = SQLiteStatementUtil.c(sQLiteStatementG2, "typeId");
            int iC6 = SQLiteStatementUtil.c(sQLiteStatementG2, "appDistractionType");
            int iC7 = SQLiteStatementUtil.c(sQLiteStatementG2, "category");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                int i3 = iC == -1 ? 0 : (int) sQLiteStatementG2.getLong(iC);
                if (iC2 == -1) {
                    throw new IllegalStateException("Missing column 'name' for a NON-NULL value, column not found in result.");
                }
                arrayList.add(new AggregatedItemRecord(i3, sQLiteStatementG2.f2(iC2), (iC3 == -1 || sQLiteStatementG2.isNull(iC3)) ? null : sQLiteStatementG2.f2(iC3), (iC4 == -1 || sQLiteStatementG2.isNull(iC4)) ? null : Integer.valueOf((int) sQLiteStatementG2.getLong(iC4)), iC5 != -1 ? (int) sQLiteStatementG2.getLong(iC5) : 0, (iC6 == -1 || sQLiteStatementG2.isNull(iC6)) ? null : sQLiteStatementG2.f2(iC6), (iC7 == -1 || sQLiteStatementG2.isNull(iC7)) ? null : sQLiteStatementG2.f2(iC7)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object B(final Collection collection, final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(duration) as total, name, originalBeginTime as timestamp ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = list.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append(vfptEEmYY.JiVWBV);
        final int size2 = collection.size();
        StringUtil.a(sb, size2);
        sb.append(") ");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000");
        sb.append("\n");
        sb.append("            GROUP BY originalBeginTime ORDER BY timestamp");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.U0(string, list, size, collection, size2, j3, j4, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Object N(final List list, final long j3, final long j4, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT AVG(duration) ");
        sb.append("\n");
        sb.append("            FROM (");
        sb.append("\n");
        sb.append("                SELECT SUM(duration) AS duration  ");
        sb.append("\n");
        sb.append(vgWWUoTKYyuC.viHhOIvKcVrVZ);
        sb.append("\n");
        sb.append("                WHERE timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("                AND name IN (");
        StringUtil.a(sb, list.size());
        sb.append(") ");
        sb.append("\n");
        sb.append("                GROUP BY DATE(timestamp, 'unixepoch', 'localtime') ");
        sb.append("\n");
        sb.append("            )");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f133757a, true, false, new Function1() { // from class: n2.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.Y0(string, j3, j4, list, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public Flow d(final Collection typeIds, final List ignoredNames, final long j3, final long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("        SELECT name, parentName, typeId, category, ");
        sb.append("\n");
        sb.append("            SUM(duration) AS duration, ");
        sb.append("\n");
        sb.append("            SUM(isInitial) AS launchCount ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = ignoredNames.size();
        StringUtil.a(sb, size);
        String str = pnxuebdT.OKxv;
        sb.append(str);
        sb.append("\n");
        sb.append("            AND typeId IN (");
        final int size2 = typeIds.size();
        StringUtil.a(sb, size2);
        sb.append(str);
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("            GROUP BY name");
        sb.append("\n");
        sb.append("            ORDER BY duration DESC");
        sb.append("\n");
        sb.append("    ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return FlowUtil.a(this.f133757a, false, new String[]{"record"}, new Function1() { // from class: n2.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.M0(string, ignoredNames, size, typeIds, size2, j3, j4, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.statistics.model.dao.RecordDao
    public LiveData z(final Collection typeIds, final List ignoredNames, final long j3, final long j4) {
        Intrinsics.checkNotNullParameter(typeIds, "typeIds");
        Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("        SELECT name, parentName, typeId, category, ");
        sb.append("\n");
        sb.append(KqqtdetwHMIO.EiGIxpXywi);
        sb.append("\n");
        sb.append("            SUM(isInitial) AS launchCount ");
        sb.append("\n");
        sb.append("            FROM record ");
        sb.append("\n");
        sb.append("            WHERE name NOT IN (");
        final int size = ignoredNames.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND typeId IN (");
        final int size2 = typeIds.size();
        StringUtil.a(sb, size2);
        sb.append(")");
        sb.append("\n");
        sb.append("            AND timestamp BETWEEN ");
        sb.append("?");
        sb.append("/1000 AND ");
        sb.append("?");
        sb.append("/1000 ");
        sb.append("\n");
        sb.append("            GROUP BY name");
        sb.append("\n");
        sb.append("            ORDER BY duration DESC");
        sb.append("\n");
        sb.append("    ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return this.f133757a.getInvalidationTracker().p(new String[]{"record"}, false, new Function1() { // from class: n2.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecordDao_Impl.G0(string, ignoredNames, size, typeIds, size2, j3, j4, (SQLiteConnection) obj);
            }
        });
    }
}
