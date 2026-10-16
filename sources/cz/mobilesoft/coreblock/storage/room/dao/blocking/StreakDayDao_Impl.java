package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.facebook.internal.AnalyticsEvents;
import cz.mobilesoft.coreblock.scene.streaks.StreakDayStatus;
import cz.mobilesoft.coreblock.scene.streaks.StreakLossReason;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.StreakDayEntity;
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
public final class StreakDayDao_Impl extends StreakDayDao {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f125200i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f125201j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StreakDayStatus.Converter f125204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreakLossReason.Converter f125205d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final EntityUpsertAdapter f125208h;

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

    public StreakDayDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125204c = new StreakDayStatus.Converter();
        this.f125205d = new StreakLossReason.Converter();
        this.f125202a = __db;
        this.f125203b = new EntityInsertAdapter<StreakDayEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `StreakDay` (`dayKey`,`dayStartMillis`,`timeZoneId`,`status`,`lossReason`,`evaluatedAtMillis`,`earnedAtMillis`,`rulesVersion`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakDayEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.A(2, entity.b());
                statement.p0(3, entity.h());
                statement.A(4, StreakDayDao_Impl.this.f125204c.b(entity.g()));
                statement.A(5, StreakDayDao_Impl.this.f125205d.b(entity.e()));
                statement.A(6, entity.d());
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(7);
                } else {
                    statement.A(7, lC.longValue());
                }
                statement.A(8, entity.f());
            }
        };
        this.f125206f = new EntityDeleteOrUpdateAdapter<StreakDayEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `StreakDay` WHERE `dayKey` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakDayEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
            }
        };
        this.f125207g = new EntityDeleteOrUpdateAdapter<StreakDayEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `StreakDay` SET `dayKey` = ?,`dayStartMillis` = ?,`timeZoneId` = ?,`status` = ?,`lossReason` = ?,`evaluatedAtMillis` = ?,`earnedAtMillis` = ?,`rulesVersion` = ? WHERE `dayKey` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakDayEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.A(2, entity.b());
                statement.p0(3, entity.h());
                statement.A(4, StreakDayDao_Impl.this.f125204c.b(entity.g()));
                statement.A(5, StreakDayDao_Impl.this.f125205d.b(entity.e()));
                statement.A(6, entity.d());
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(7);
                } else {
                    statement.A(7, lC.longValue());
                }
                statement.A(8, entity.f());
                statement.p0(9, entity.a());
            }
        };
        this.f125208h = new EntityUpsertAdapter(new EntityInsertAdapter<StreakDayEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `StreakDay` (`dayKey`,`dayStartMillis`,`timeZoneId`,`status`,`lossReason`,`evaluatedAtMillis`,`earnedAtMillis`,`rulesVersion`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakDayEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.A(2, entity.b());
                statement.p0(3, entity.h());
                statement.A(4, StreakDayDao_Impl.this.f125204c.b(entity.g()));
                statement.A(5, StreakDayDao_Impl.this.f125205d.b(entity.e()));
                statement.A(6, entity.d());
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(7);
                } else {
                    statement.A(7, lC.longValue());
                }
                statement.A(8, entity.f());
            }
        }, new EntityDeleteOrUpdateAdapter<StreakDayEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `StreakDay` SET `dayKey` = ?,`dayStartMillis` = ?,`timeZoneId` = ?,`status` = ?,`lossReason` = ?,`evaluatedAtMillis` = ?,`earnedAtMillis` = ?,`rulesVersion` = ? WHERE `dayKey` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, StreakDayEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.p0(1, entity.a());
                statement.A(2, entity.b());
                statement.p0(3, entity.h());
                statement.A(4, StreakDayDao_Impl.this.f125204c.b(entity.g()));
                statement.A(5, StreakDayDao_Impl.this.f125205d.b(entity.e()));
                statement.A(6, entity.d());
                Long lC = entity.c();
                if (lC == null) {
                    statement.D(7);
                } else {
                    statement.A(7, lC.longValue());
                }
                statement.A(8, entity.f());
                statement.p0(9, entity.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Y(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            return sQLiteStatementG2.B2() ? (int) sQLiteStatementG2.getLong(0) : 0;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(String str, SQLiteConnection _connection) {
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
    public static final StreakDayEntity a0(String str, String str2, StreakDayDao_Impl streakDayDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "dayKey");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayStartMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeZoneId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lossReason");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "evaluatedAtMillis");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "earnedAtMillis");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "rulesVersion");
            StreakDayEntity streakDayEntity = null;
            if (sQLiteStatementG2.B2()) {
                streakDayEntity = new StreakDayEntity(sQLiteStatementG2.f2(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), streakDayDao_Impl.f125204c.a((int) sQLiteStatementG2.getLong(iD4)), streakDayDao_Impl.f125205d.a((int) sQLiteStatementG2.getLong(iD5)), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.isNull(iD7) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD7)), (int) sQLiteStatementG2.getLong(iD8));
            }
            return streakDayEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List b0(String str, String str2, String str3, StreakDayDao_Impl streakDayDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            sQLiteStatementG2.p0(2, str3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "dayKey");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayStartMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeZoneId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lossReason");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "evaluatedAtMillis");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "earnedAtMillis");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "rulesVersion");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new StreakDayEntity(sQLiteStatementG2.f2(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), streakDayDao_Impl.f125204c.a((int) sQLiteStatementG2.getLong(iD4)), streakDayDao_Impl.f125205d.a((int) sQLiteStatementG2.getLong(iD5)), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.isNull(iD7) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD7)), (int) sQLiteStatementG2.getLong(iD8)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDayEntity c0(String str, String str2, StreakDayDao_Impl streakDayDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.p0(1, str2);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "dayKey");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayStartMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeZoneId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lossReason");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "evaluatedAtMillis");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "earnedAtMillis");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "rulesVersion");
            StreakDayEntity streakDayEntity = null;
            if (sQLiteStatementG2.B2()) {
                streakDayEntity = new StreakDayEntity(sQLiteStatementG2.f2(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), streakDayDao_Impl.f125204c.a((int) sQLiteStatementG2.getLong(iD4)), streakDayDao_Impl.f125205d.a((int) sQLiteStatementG2.getLong(iD5)), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.isNull(iD7) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD7)), (int) sQLiteStatementG2.getLong(iD8));
            }
            return streakDayEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List d0(String str, StreakDayDao_Impl streakDayDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "dayKey");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "dayStartMillis");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "timeZoneId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "lossReason");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "evaluatedAtMillis");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "earnedAtMillis");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "rulesVersion");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                arrayList.add(new StreakDayEntity(sQLiteStatementG2.f2(iD), sQLiteStatementG2.getLong(iD2), sQLiteStatementG2.f2(iD3), streakDayDao_Impl.f125204c.a((int) sQLiteStatementG2.getLong(iD4)), streakDayDao_Impl.f125205d.a((int) sQLiteStatementG2.getLong(iD5)), sQLiteStatementG2.getLong(iD6), sQLiteStatementG2.isNull(iD7) ? null : Long.valueOf(sQLiteStatementG2.getLong(iD7)), (int) sQLiteStatementG2.getLong(iD8)));
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long f0(StreakDayDao_Impl streakDayDao_Impl, StreakDayEntity streakDayEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return streakDayDao_Impl.f125208h.b(_connection, streakDayEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g0(StreakDayDao_Impl streakDayDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return streakDayDao_Impl.f125208h.c(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao
    public Object J(Continuation continuation) {
        final String str = "SELECT COUNT(*) FROM StreakDay WHERE status != 0";
        return DBUtil.g(this.f125202a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.w4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(StreakDayDao_Impl.Y(str, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao
    public Object K(final String str, Continuation continuation) {
        final String str2 = "SELECT * FROM StreakDay WHERE dayKey = ?";
        return DBUtil.g(this.f125202a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.u4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakDayDao_Impl.a0(str2, str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao
    public Object L(final String str, final String str2, Continuation continuation) {
        final String str3 = "SELECT * FROM StreakDay WHERE dayKey >= ? AND dayKey <= ? ORDER BY dayKey ASC";
        return DBUtil.g(this.f125202a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.z4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakDayDao_Impl.b0(str3, str, str2, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao
    public Object M(final String str, Continuation continuation) {
        final String str2 = "SELECT * FROM StreakDay WHERE dayKey <= ? ORDER BY dayKey DESC LIMIT 1";
        return DBUtil.g(this.f125202a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.x4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakDayDao_Impl.c0(str2, str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao
    public Flow N() {
        final String str = "SELECT * FROM StreakDay ORDER BY dayKey ASC";
        return FlowUtil.a(this.f125202a, false, new String[]{"StreakDay"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.b5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakDayDao_Impl.d0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.StreakDayDao
    public Object deleteAll(Continuation continuation) {
        final String str = "DELETE FROM StreakDay";
        Object objG = DBUtil.g(this.f125202a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.a5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakDayDao_Impl.Z(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public Object f(final StreakDayEntity streakDayEntity, Continuation continuation) {
        return DBUtil.g(this.f125202a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.y4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(StreakDayDao_Impl.f0(this.f125764a, streakDayEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object j(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125202a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.v4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StreakDayDao_Impl.g0(this.f125708a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
