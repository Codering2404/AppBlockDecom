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
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
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
public final class UsageLimitDao_Impl extends UsageLimitDao {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f125269k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f125270l = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RoomDatabase f125271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityInsertAdapter f125272d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final UsageLimit.PeriodType.Converter f125273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final UsageLimit.LimitType.Converter f125274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final EntityUpsertAdapter f125277j;

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

    public UsageLimitDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125273f = new UsageLimit.PeriodType.Converter();
        this.f125274g = new UsageLimit.LimitType.Converter();
        this.f125271c = __db;
        this.f125272d = new EntityInsertAdapter<UsageLimit>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `UsageLimit` (`id`,`profileId`,`periodType`,`limitType`,`lastResetTime`,`allowedCount`,`usedCount`,`originalAllowedCount`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, UsageLimit entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.g());
                statement.A(2, entity.l());
                statement.A(3, UsageLimitDao_Impl.this.f125273f.b(entity.k()));
                statement.A(4, UsageLimitDao_Impl.this.f125274g.b(entity.i()));
                statement.A(5, entity.h());
                statement.A(6, entity.f());
                statement.A(7, entity.m());
                statement.A(8, entity.j());
            }
        };
        this.f125275h = new EntityDeleteOrUpdateAdapter<UsageLimit>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `UsageLimit` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, UsageLimit entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.g());
            }
        };
        this.f125276i = new EntityDeleteOrUpdateAdapter<UsageLimit>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `UsageLimit` SET `id` = ?,`profileId` = ?,`periodType` = ?,`limitType` = ?,`lastResetTime` = ?,`allowedCount` = ?,`usedCount` = ?,`originalAllowedCount` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, UsageLimit entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.g());
                statement.A(2, entity.l());
                statement.A(3, UsageLimitDao_Impl.this.f125273f.b(entity.k()));
                statement.A(4, UsageLimitDao_Impl.this.f125274g.b(entity.i()));
                statement.A(5, entity.h());
                statement.A(6, entity.f());
                statement.A(7, entity.m());
                statement.A(8, entity.j());
                statement.A(9, entity.g());
            }
        };
        this.f125277j = new EntityUpsertAdapter(new EntityInsertAdapter<UsageLimit>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `UsageLimit` (`id`,`profileId`,`periodType`,`limitType`,`lastResetTime`,`allowedCount`,`usedCount`,`originalAllowedCount`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, UsageLimit entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.g());
                statement.A(2, entity.l());
                statement.A(3, UsageLimitDao_Impl.this.f125273f.b(entity.k()));
                statement.A(4, UsageLimitDao_Impl.this.f125274g.b(entity.i()));
                statement.A(5, entity.h());
                statement.A(6, entity.f());
                statement.A(7, entity.m());
                statement.A(8, entity.j());
            }
        }, new EntityDeleteOrUpdateAdapter<UsageLimit>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `UsageLimit` SET `id` = ?,`profileId` = ?,`periodType` = ?,`limitType` = ?,`lastResetTime` = ?,`allowedCount` = ?,`usedCount` = ?,`originalAllowedCount` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, UsageLimit entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.g());
                statement.A(2, entity.l());
                statement.A(3, UsageLimitDao_Impl.this.f125273f.b(entity.k()));
                statement.A(4, UsageLimitDao_Impl.this.f125274g.b(entity.i()));
                statement.A(5, entity.h());
                statement.A(6, entity.f());
                statement.A(7, entity.m());
                statement.A(8, entity.j());
                statement.A(9, entity.g());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(String str, Collection collection, int i3, UsageLimitDao_Impl usageLimitDao_Impl, UsageLimit.LimitType limitType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i4, ((Number) it.next()).longValue());
                i4++;
            }
            sQLiteStatementG2.A(i3 + 1, usageLimitDao_Impl.f125274g.b(limitType));
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List B0(String str, long j3, UsageLimitDao_Impl usageLimitDao_Impl, UsageLimit.LimitType limitType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, usageLimitDao_Impl.f125274g.b(limitType));
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "periodType");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "limitType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastResetTime");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "allowedCount");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "usedCount");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "originalAllowedCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new UsageLimit(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), usageLimitDao_Impl.f125273f.a((int) sQLiteStatementG2.getLong(iD3)), usageLimitDao_Impl.f125274g.a((int) sQLiteStatementG2.getLong(iD4)), sQLiteStatementG2.getLong(iD5), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(iD8)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List C0(String str, Collection collection, UsageLimitDao_Impl usageLimitDao_Impl, SQLiteConnection _connection) {
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
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "periodType");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "limitType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastResetTime");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "allowedCount");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "usedCount");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "originalAllowedCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new UsageLimit(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), usageLimitDao_Impl.f125273f.a((int) sQLiteStatementG2.getLong(iD3)), usageLimitDao_Impl.f125274g.a((int) sQLiteStatementG2.getLong(iD4)), sQLiteStatementG2.getLong(iD5), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(iD8)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List E0(String str, String str2, String str3, Collection collection, int i3, Collection collection2, int i4, String str4, UsageLimitDao_Impl usageLimitDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            sQLiteStatementG2.p0(2, str2);
            sQLiteStatementG2.p0(3, str2);
            sQLiteStatementG2.p0(4, str3);
            Iterator it = collection.iterator();
            int i5 = 5;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i5, ((Number) it.next()).longValue());
                i5++;
            }
            int i6 = i3 + 5;
            Iterator it2 = collection2.iterator();
            int i7 = i6;
            while (it2.hasNext()) {
                sQLiteStatementG2.p0(i7, (String) it2.next());
                i7++;
            }
            int i8 = i6 + i4;
            Iterator it3 = collection.iterator();
            int i9 = i8;
            while (it3.hasNext()) {
                sQLiteStatementG2.A(i9, ((Number) it3.next()).longValue());
                i9++;
            }
            sQLiteStatementG2.p0(i8 + i3, str2);
            sQLiteStatementG2.p0(i3 + 6 + i4 + i3, str4);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "periodType");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "limitType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastResetTime");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "allowedCount");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "usedCount");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "originalAllowedCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new UsageLimit(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), usageLimitDao_Impl.f125273f.a((int) sQLiteStatementG2.getLong(iD3)), usageLimitDao_Impl.f125274g.a((int) sQLiteStatementG2.getLong(iD4)), sQLiteStatementG2.getLong(iD5), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(iD8)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List F0(String str, long j3, UsageLimitDao_Impl usageLimitDao_Impl, UsageLimit.PeriodType periodType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, usageLimitDao_Impl.f125273f.b(periodType));
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "periodType");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "limitType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastResetTime");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "allowedCount");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "usedCount");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "originalAllowedCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new UsageLimit(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), usageLimitDao_Impl.f125273f.a((int) sQLiteStatementG2.getLong(iD3)), usageLimitDao_Impl.f125274g.a((int) sQLiteStatementG2.getLong(iD4)), sQLiteStatementG2.getLong(iD5), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(iD8)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UsageLimit G0(String str, long j3, UsageLimitDao_Impl usageLimitDao_Impl, UsageLimit.LimitType limitType, SQLiteConnection _connection) {
        UsageLimit usageLimit;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, usageLimitDao_Impl.f125274g.b(limitType));
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "periodType");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "limitType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastResetTime");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "allowedCount");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "usedCount");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "originalAllowedCount");
            if (sQLiteStatementG2.B2()) {
                usageLimit = new UsageLimit(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), usageLimitDao_Impl.f125273f.a((int) sQLiteStatementG2.getLong(iD3)), usageLimitDao_Impl.f125274g.a((int) sQLiteStatementG2.getLong(iD4)), sQLiteStatementG2.getLong(iD5), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(iD8));
            } else {
                usageLimit = null;
            }
            return usageLimit;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long I0(UsageLimitDao_Impl usageLimitDao_Impl, UsageLimit usageLimit, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return usageLimitDao_Impl.f125272d.d(_connection, usageLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List J0(UsageLimitDao_Impl usageLimitDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return usageLimitDao_Impl.f125272d.e(_connection, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(UsageLimitDao_Impl usageLimitDao_Impl, Collection collection, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        usageLimitDao_Impl.f125276i.d(_connection, collection);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(UsageLimitDao_Impl usageLimitDao_Impl, UsageLimit usageLimit, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        usageLimitDao_Impl.f125275h.c(_connection, usageLimit);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(String str, long j3, UsageLimitDao_Impl usageLimitDao_Impl, UsageLimit.PeriodType periodType, UsageLimit.LimitType limitType, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            sQLiteStatementG2.A(2, usageLimitDao_Impl.f125273f.b(periodType));
            sQLiteStatementG2.A(3, usageLimitDao_Impl.f125274g.b(limitType));
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(String str, Collection collection, SQLiteConnection _connection) {
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

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public Object n(final UsageLimit usageLimit, Continuation continuation) {
        return DBUtil.g(this.f125271c, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.s5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(UsageLimitDao_Impl.I0(this.f125656a, usageLimit, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object J(final long j3, final UsageLimit.PeriodType periodType, final UsageLimit.LimitType limitType, Continuation continuation) {
        final String str = "DELETE FROM UsageLimit WHERE profileId = ? AND periodType != ? AND limitType = ?";
        Object objG = DBUtil.g(this.f125271c, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.w5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.y0(str, j3, this, periodType, limitType, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object K(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM UsageLimit WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f125271c, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.q5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.z0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object L(final Collection collection, final UsageLimit.LimitType limitType, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM UsageLimit WHERE profileId IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(") AND limitType = ");
        sb.append("?");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f125271c, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.z5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.A0(string, collection, size, this, limitType, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object M(final long j3, final UsageLimit.LimitType limitType, Continuation continuation) {
        final String str = "SELECT * FROM UsageLimit WHERE profileId = ? AND limitType = ?";
        return DBUtil.g(this.f125271c, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.r5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.B0(str, j3, this, limitType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object N(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM UsageLimit WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(") ORDER BY (allowedCount - usedCount) ASC, allowedCount ASC");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125271c, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.a6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.C0(string, collection, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object O(final Collection collection, final Collection collection2, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("            SELECT * FROM UsageLimit ul");
        sb.append("\n");
        sb.append("            WHERE EXISTS (");
        sb.append("\n");
        sb.append("                SELECT * FROM ApplicationProfileRelation ar");
        sb.append("\n");
        sb.append("                WHERE ar.profileId = ul.profileId");
        sb.append("\n");
        sb.append("                AND ar.packageName IN (");
        final int size = collection2.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("                AND ar.profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        sb.append("\n");
        sb.append("            )");
        sb.append("\n");
        sb.append("            ORDER BY (ul.allowedCount - ul.usedCount) ASC, ul.allowedCount ASC");
        sb.append("\n");
        sb.append("            ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125271c, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.y5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.D0(string, collection2, size, collection, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object P(Collection collection, Collection collection2, UrlDto urlDto, Continuation continuation) {
        return DBUtil.f(this.f125271c, new UsageLimitDao_Impl$getAllByProfileIdsPackageNamesAndUrl$2(this, collection, collection2, urlDto, null), continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object R(final Collection collection, final Collection collection2, final String str, final String str2, final String str3, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("            SELECT * FROM UsageLimit ");
        sb.append("\n");
        sb.append("            WHERE profileId IN (");
        sb.append("\n");
        sb.append("                SELECT wr.profileId FROM WebsiteProfileRelation wr");
        sb.append("\n");
        sb.append("                WHERE (");
        sb.append("\n");
        sb.append("                    ");
        sb.append("\n");
        sb.append("            wr.name = ");
        sb.append("?");
        sb.append("\n");
        sb.append("            OR (");
        sb.append("\n");
        sb.append("                wr.blockingType = 0");
        sb.append("\n");
        sb.append("                AND ");
        sb.append("?");
        sb.append(" LIKE '%.' || wr.name");
        sb.append("\n");
        sb.append("            ) OR (");
        sb.append("\n");
        sb.append("                wr.blockingType = 1");
        sb.append("\n");
        sb.append("                AND (");
        sb.append("\n");
        sb.append("                    (");
        sb.append("\n");
        sb.append("                        wr.isAnywhereInUrl = 0");
        sb.append("\n");
        sb.append("                        AND ");
        sb.append("?");
        sb.append(" LIKE '%' || wr.name || '%'");
        sb.append("\n");
        sb.append("                    ) OR (");
        sb.append("\n");
        sb.append("                        wr.isAnywhereInUrl = 1");
        sb.append("\n");
        sb.append("                        AND ");
        sb.append("?");
        sb.append(" LIKE '%' || wr.name || '%'");
        sb.append("\n");
        sb.append("                    )");
        sb.append("\n");
        sb.append("                )");
        sb.append("\n");
        sb.append("            )");
        sb.append("\n");
        sb.append("        ");
        sb.append("\n");
        sb.append("                ) AND wr.profileId IN (");
        final int size = collection.size();
        StringUtil.a(sb, size);
        sb.append(")");
        sb.append("\n");
        sb.append("                UNION ");
        sb.append("\n");
        sb.append("                SELECT ar.profileId FROM ApplicationProfileRelation ar");
        sb.append("\n");
        sb.append("                WHERE ar.packageName IN (");
        final int size2 = collection2.size();
        StringUtil.a(sb, size2);
        sb.append(")");
        sb.append("\n");
        sb.append("                AND ar.profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        sb.append("\n");
        sb.append("            )");
        sb.append("\n");
        sb.append("            OR profileId IN (");
        sb.append("\n");
        sb.append("                SELECT T.id FROM Profile T ");
        sb.append("\n");
        sb.append("                WHERE T.blockAdultContent = 1");
        sb.append("\n");
        sb.append("                AND EXISTS (");
        sb.append("\n");
        sb.append("                    SELECT acw.url FROM AdultContentWebsite acw");
        sb.append("\n");
        sb.append("                    WHERE acw.url = ");
        sb.append("?");
        sb.append("\n");
        sb.append("                    OR acw.url = ");
        sb.append("?");
        sb.append("\n");
        sb.append("                )");
        sb.append("\n");
        sb.append("            )");
        sb.append("\n");
        sb.append("            ORDER BY (allowedCount - usedCount) ASC, allowedCount ASC");
        sb.append("\n");
        sb.append("            ");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125271c, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.x5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.E0(string, str2, str, collection, size, collection2, size2, str3, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object S(final long j3, final UsageLimit.PeriodType periodType, Continuation continuation) {
        final String str = "SELECT * FROM UsageLimit WHERE lastResetTime = ? AND periodType = ?";
        return DBUtil.g(this.f125271c, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.c6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.F0(str, j3, this, periodType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object X(final long j3, final UsageLimit.LimitType limitType, Continuation continuation) {
        final String str = "SELECT * FROM UsageLimit WHERE profileId = ? AND limitType = ? AND allowedCount > 0 ORDER BY lastResetTime DESC, allowedCount ASC LIMIT 1";
        return DBUtil.g(this.f125271c, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.b6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.G0(str, j3, this, limitType, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object Y(int i3, int i4, Continuation continuation) {
        Object objF = DBUtil.f(this.f125271c, new UsageLimitDao_Impl$recreateUsageLimits$2(this, i3, i4, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao
    public Object a0(long j3, long j4, UsageLimit.PeriodType periodType, UsageLimit.LimitType limitType, Continuation continuation) {
        Object objF = DBUtil.f(this.f125271c, new UsageLimitDao_Impl$setUsageLimit$2(this, j3, j4, periodType, limitType, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object r(final Collection collection, Continuation continuation) {
        Object objG = DBUtil.g(this.f125271c, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.v5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.K0(this.f125710a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125271c, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.t5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.J0(this.f125674a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public Object q(final UsageLimit usageLimit, Continuation continuation) {
        Object objG = DBUtil.g(this.f125271c, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.u5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UsageLimitDao_Impl.x0(this.f125690a, usageLimit, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List D0(String str, Collection collection, int i3, Collection collection2, UsageLimitDao_Impl usageLimitDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i4, (String) it.next());
                i4++;
            }
            int i5 = i3 + 1;
            Iterator it2 = collection2.iterator();
            while (it2.hasNext()) {
                sQLiteStatementG2.A(i5, ((Number) it2.next()).longValue());
                i5++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, YznnJpHcAmeoW.VpqNiLUdmGvDukx);
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "limitType");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lastResetTime");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "allowedCount");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "usedCount");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "originalAllowedCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new UsageLimit(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.getLong(iD2), usageLimitDao_Impl.f125273f.a((int) sQLiteStatementG2.getLong(iD3)), usageLimitDao_Impl.f125274g.a((int) sQLiteStatementG2.getLong(iD4)), sQLiteStatementG2.getLong(iD5), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.getLong(iD7), sQLiteStatementG2.getLong(iD8)));
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }
}
