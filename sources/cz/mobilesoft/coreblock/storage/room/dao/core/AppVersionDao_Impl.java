package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.core.AppVersionEntity;
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
public final class AppVersionDao_Impl implements AppVersionDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f125836g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f125837h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125841d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f125842f;

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

    public AppVersionDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125838a = __db;
        this.f125839b = new EntityInsertAdapter<AppVersionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `AppVersionEntity` (`versionCode`,`versionName`,`firstInstallTime`,`changelogShownInPast`,`changelogShowingNow`,`whatsNewShownInPast`,`whatsNewShowingNow`) VALUES (?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppVersionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.p0(2, entity.e());
                statement.A(3, entity.c());
                statement.A(4, entity.b() ? 1L : 0L);
                statement.A(5, entity.a() ? 1L : 0L);
                statement.A(6, entity.g() ? 1L : 0L);
                statement.A(7, entity.f() ? 1L : 0L);
            }
        };
        this.f125840c = new EntityDeleteOrUpdateAdapter<AppVersionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `AppVersionEntity` WHERE `versionCode` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppVersionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
            }
        };
        this.f125841d = new EntityDeleteOrUpdateAdapter<AppVersionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `AppVersionEntity` SET `versionCode` = ?,`versionName` = ?,`firstInstallTime` = ?,`changelogShownInPast` = ?,`changelogShowingNow` = ?,`whatsNewShownInPast` = ?,`whatsNewShowingNow` = ? WHERE `versionCode` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppVersionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.p0(2, entity.e());
                statement.A(3, entity.c());
                statement.A(4, entity.b() ? 1L : 0L);
                statement.A(5, entity.a() ? 1L : 0L);
                statement.A(6, entity.g() ? 1L : 0L);
                statement.A(7, entity.f() ? 1L : 0L);
                statement.A(8, entity.d());
            }
        };
        this.f125842f = new EntityUpsertAdapter(new EntityInsertAdapter<AppVersionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `AppVersionEntity` (`versionCode`,`versionName`,`firstInstallTime`,`changelogShownInPast`,`changelogShowingNow`,`whatsNewShownInPast`,`whatsNewShowingNow`) VALUES (?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppVersionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.p0(2, entity.e());
                statement.A(3, entity.c());
                statement.A(4, entity.b() ? 1L : 0L);
                statement.A(5, entity.a() ? 1L : 0L);
                statement.A(6, entity.g() ? 1L : 0L);
                statement.A(7, entity.f() ? 1L : 0L);
            }
        }, new EntityDeleteOrUpdateAdapter<AppVersionEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `AppVersionEntity` SET `versionCode` = ?,`versionName` = ?,`firstInstallTime` = ?,`changelogShownInPast` = ?,`changelogShowingNow` = ?,`whatsNewShownInPast` = ?,`whatsNewShowingNow` = ? WHERE `versionCode` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, AppVersionEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.p0(2, entity.e());
                statement.A(3, entity.c());
                statement.A(4, entity.b() ? 1L : 0L);
                statement.A(5, entity.a() ? 1L : 0L);
                statement.A(6, entity.g() ? 1L : 0L);
                statement.A(7, entity.f() ? 1L : 0L);
                statement.A(8, entity.d());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppVersionEntity S(String str, SQLiteConnection _connection) {
        AppVersionEntity appVersionEntity;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "versionCode");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "versionName");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "firstInstallTime");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "changelogShownInPast");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "changelogShowingNow");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "whatsNewShownInPast");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "whatsNewShowingNow");
            if (sQLiteStatementG2.B2()) {
                appVersionEntity = new AppVersionEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.getLong(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0, ((int) sQLiteStatementG2.getLong(iD7)) != 0);
            } else {
                appVersionEntity = null;
            }
            return appVersionEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppVersionEntity T(String str, SQLiteConnection _connection) {
        AppVersionEntity appVersionEntity;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "versionCode");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "versionName");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "firstInstallTime");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "changelogShownInPast");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "changelogShowingNow");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "whatsNewShownInPast");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "whatsNewShowingNow");
            if (sQLiteStatementG2.B2()) {
                appVersionEntity = new AppVersionEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.getLong(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0, ((int) sQLiteStatementG2.getLong(iD7)) != 0);
            } else {
                appVersionEntity = null;
            }
            return appVersionEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppVersionEntity U(String str, SQLiteConnection _connection) {
        AppVersionEntity appVersionEntity;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "versionCode");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "versionName");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "firstInstallTime");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "changelogShownInPast");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "changelogShowingNow");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "whatsNewShownInPast");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "whatsNewShowingNow");
            if (sQLiteStatementG2.B2()) {
                appVersionEntity = new AppVersionEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.getLong(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0, ((int) sQLiteStatementG2.getLong(iD7)) != 0);
            } else {
                appVersionEntity = null;
            }
            return appVersionEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppVersionEntity V(String str, SQLiteConnection _connection) {
        AppVersionEntity appVersionEntity;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "versionCode");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "versionName");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "firstInstallTime");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "changelogShownInPast");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "changelogShowingNow");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "whatsNewShownInPast");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "whatsNewShowingNow");
            if (sQLiteStatementG2.B2()) {
                appVersionEntity = new AppVersionEntity(sQLiteStatementG2.getLong(iD), sQLiteStatementG2.f2(iD2), sQLiteStatementG2.getLong(iD3), ((int) sQLiteStatementG2.getLong(iD4)) != 0, ((int) sQLiteStatementG2.getLong(iD5)) != 0, ((int) sQLiteStatementG2.getLong(iD6)) != 0, ((int) sQLiteStatementG2.getLong(iD7)) != 0);
            } else {
                appVersionEntity = null;
            }
            return appVersionEntity;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long X(AppVersionDao_Impl appVersionDao_Impl, AppVersionEntity appVersionEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return appVersionDao_Impl.f125839b.d(_connection, appVersionEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            boolean z2 = false;
            if (sQLiteStatementG2.B2()) {
                if (((int) sQLiteStatementG2.getLong(0)) != 0) {
                    z2 = true;
                }
            }
            return z2;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            boolean z2 = false;
            if (sQLiteStatementG2.B2()) {
                if (((int) sQLiteStatementG2.getLong(0)) != 0) {
                    z2 = true;
                }
            }
            return z2;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(String str, SQLiteConnection _connection) {
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
    public static final Unit b0(String str, SQLiteConnection _connection) {
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

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao
    public Object B(Continuation continuation) {
        final String str = "UPDATE AppVersionEntity SET whatsNewShowingNow = 0";
        Object objG = DBUtil.g(this.f125838a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppVersionDao_Impl.b0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao
    public Flow D() {
        final String str = "SELECT EXISTS(SELECT * FROM AppVersionEntity WHERE whatsNewShowingNow = 1)";
        return FlowUtil.a(this.f125838a, false, new String[]{"AppVersionEntity"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AppVersionDao_Impl.Z(str, (SQLiteConnection) obj));
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao
    public Object I(Continuation continuation) {
        final String str = "UPDATE AppVersionEntity SET changelogShowingNow = 0";
        Object objG = DBUtil.g(this.f125838a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppVersionDao_Impl.a0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public Object n(final AppVersionEntity appVersionEntity, Continuation continuation) {
        return DBUtil.g(this.f125838a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(AppVersionDao_Impl.X(this.f126318a, appVersionEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao
    public Object g(Continuation continuation) {
        final String str = "SELECT * FROM AppVersionEntity WHERE changelogShownInPast = 1 ORDER BY versionCode DESC LIMIT 1";
        return DBUtil.g(this.f125838a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppVersionDao_Impl.T(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao
    public Object s(Continuation continuation) {
        final String str = "SELECT * FROM AppVersionEntity ORDER BY versionCode DESC LIMIT 1";
        return DBUtil.g(this.f125838a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppVersionDao_Impl.S(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao
    public Object v(Continuation continuation) {
        final String str = "SELECT * FROM AppVersionEntity WHERE whatsNewShownInPast = 1 ORDER BY versionCode DESC LIMIT 1";
        return DBUtil.g(this.f125838a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppVersionDao_Impl.U(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao
    public Object y(Continuation continuation) {
        final String str = "SELECT * FROM AppVersionEntity ORDER BY versionCode ASC LIMIT 1";
        return DBUtil.g(this.f125838a, true, false, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppVersionDao_Impl.V(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao
    public Flow z() {
        final String str = "SELECT EXISTS(SELECT * FROM AppVersionEntity WHERE changelogShowingNow = 1)";
        return FlowUtil.a(this.f125838a, false, new String[]{"AppVersionEntity"}, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AppVersionDao_Impl.Y(str, (SQLiteConnection) obj));
            }
        });
    }
}
